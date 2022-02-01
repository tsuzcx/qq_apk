package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FaceBeautyItem;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.model.DistortParam;
import com.tencent.ttpic.openapi.util.BeautyRealUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BeautyTransformList
  implements AEFilterI
{
  private static int FACE_CACHE_LEN = 10;
  private static final int MAX_TRANSFORMED_FACES = 5;
  private static final String TAG = "BeautyTransformList";
  private int Basic3level;
  private final int MAX_COUNT = 6;
  private int age = 0;
  private PTFaceAttr faceAttr;
  private int faceShortenLevel;
  private float femalePercent = 1.0F;
  private boolean isFemale = true;
  private FaceBeautyItem item;
  private TransformFilter mBasic3 = null;
  private BeautyAIParam mBeautyAIParam = new BeautyAIParam();
  private BeautyParam mBeautyParam;
  private BeautyParam mBeautyParamValue;
  private TransformFilter mChinThinShorten;
  private BaseFilter mCopyFilter;
  private List<TransformFilter> mFilters;
  private TransformFilter mVFaceEyeNose;
  private float malePercent = 1.0F;
  private int noseLevel;
  private List<BeautyTransformList.FaceInfoOfPeople> peopleList = new LinkedList();
  private Frame transFrame = new Frame();
  
  public BeautyTransformList()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
    this.mBeautyParam = new BeautyParam(BeautyParam.MeshType.PITU, false);
    this.mBeautyParamValue = new BeautyParam(BeautyParam.MeshType.PUDDING_260, true);
    BenchUtil.benchEnd("[onSurfaceCreated] create BeautyParam");
    this.mVFaceEyeNose = new TransformFilter(new ArrayList(), null);
    this.mChinThinShorten = new TransformFilter(new ArrayList(), null);
    this.mBasic3 = new TransformFilter(new ArrayList(), null);
    this.mFilters = new ArrayList();
    this.mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private int chooseBestDataIndex(List<List<PointF>> paramList, List<float[]> paramList1)
  {
    LogUtils.d("getReliableFaceInfo", String.valueOf(paramList.size()));
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (sameShape((List)paramList.get(0), (List)paramList.get(i), (float[])paramList1.get(0), (float[])paramList1.get(i)))
      {
        LogUtils.d("getReliableFaceInfo", String.valueOf(i));
        return i;
      }
      i -= 1;
    }
    return 0;
  }
  
  private BeautyTransformList.FaceInfoOfFrame getFaceInfo()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.peopleList.iterator();
    while (localIterator.hasNext())
    {
      BeautyTransformList.FaceInfoOfPeople localFaceInfoOfPeople = (BeautyTransformList.FaceInfoOfPeople)localIterator.next();
      localArrayList1.add(localFaceInfoOfPeople.faces.getLast());
      localArrayList2.add(localFaceInfoOfPeople.facesAngles.getLast());
      localArrayList3.add(Integer.valueOf(localFaceInfoOfPeople.count));
    }
    return new BeautyTransformList.FaceInfoOfFrame(this, localArrayList1, localArrayList2, localArrayList3);
  }
  
  private float my_smoothstep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
    paramFloat2 = 0.0F;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = paramFloat2;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 > 1.0F) {
      paramFloat2 = 1.0F;
    }
    return paramFloat2 * paramFloat2 * (3.0F - paramFloat2 * 2.0F);
  }
  
  private void rebuildFilterList()
  {
    this.mFilters.clear();
    if ((this.mBeautyParam.vlian.getLevel() != 0) || (this.mBeautyParam.eye.getLevel() != 0) || (this.mBeautyParam.nose.getLevel() != 0)) {
      this.mFilters.add(this.mVFaceEyeNose);
    }
    if ((this.mBeautyParam.zhailian.getLevel() != 0) || (this.mBeautyParam.xiaba.getLevel() != 0) || (this.mBeautyParam.faceShorten.getLevel() != 0)) {
      this.mFilters.add(this.mChinThinShorten);
    }
    if (this.mBeautyParam.basic.getLevel() != 0) {
      this.mFilters.add(this.mBasic3);
    }
  }
  
  private boolean samePeople(List<PointF> paramList1, List<PointF> paramList2)
  {
    boolean bool = false;
    PointF localPointF1 = new PointF((((PointF)paramList1.get(0)).x + ((PointF)paramList1.get(18)).x) / 2.0F, (((PointF)paramList1.get(0)).y + ((PointF)paramList1.get(18)).y) / 2.0F);
    PointF localPointF2 = new PointF((((PointF)paramList2.get(0)).x + ((PointF)paramList2.get(18)).x) / 2.0F, (((PointF)paramList2.get(0)).y + ((PointF)paramList2.get(18)).y) / 2.0F);
    float f = Math.min(AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18)), AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18)));
    if (AlgoUtils.getDistance(localPointF1, localPointF2) < f * 0.5F) {
      bool = true;
    }
    return bool;
  }
  
  private boolean sameShape(List<PointF> paramList1, List<PointF> paramList2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    double d1 = paramArrayOfFloat1[1];
    Double.isNaN(d1);
    float f1 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.2D));
    d1 = paramArrayOfFloat1[0];
    Double.isNaN(d1);
    float f3 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.1D));
    double d2 = AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18));
    d1 = f1;
    double d3 = Math.cos(d1);
    Double.isNaN(d2);
    f1 = (float)(d2 / d3);
    d2 = AlgoUtils.getDistance((PointF)paramList1.get(44), (PointF)paramList1.get(54));
    d1 = Math.cos(d1);
    Double.isNaN(d2);
    float f2 = (float)(d2 / d1);
    d1 = AlgoUtils.getDistance(new PointF((((PointF)paramList1.get(44)).x + ((PointF)paramList1.get(54)).x) / 2.0F, (((PointF)paramList1.get(44)).y + ((PointF)paramList1.get(54)).y) / 2.0F), (PointF)paramList1.get(9));
    d2 = Math.cos(f3);
    Double.isNaN(d1);
    f3 = (float)(d1 / d2);
    d1 = paramArrayOfFloat2[1];
    Double.isNaN(d1);
    float f5 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.2D));
    d1 = paramArrayOfFloat2[0];
    Double.isNaN(d1);
    float f4 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.1D));
    d2 = AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18));
    d1 = f5;
    d3 = Math.cos(d1);
    Double.isNaN(d2);
    f5 = (float)(d2 / d3);
    d2 = AlgoUtils.getDistance((PointF)paramList2.get(44), (PointF)paramList2.get(54));
    d1 = Math.cos(d1);
    Double.isNaN(d2);
    float f6 = (float)(d2 / d1);
    d1 = AlgoUtils.getDistance(new PointF((((PointF)paramList2.get(44)).x + ((PointF)paramList2.get(54)).x) / 2.0F, (((PointF)paramList2.get(44)).y + ((PointF)paramList2.get(54)).y) / 2.0F), (PointF)paramList2.get(9));
    d2 = Math.cos(f4);
    Double.isNaN(d1);
    f4 = (float)(d1 / d2);
    return Math.abs(f2 / f1 - f6 / f5) + Math.abs(f3 / f1 - f4 / f5) < 0.1D;
  }
  
  private void updatePeopleList(List<List<PointF>> paramList, List<float[]> paramList1)
  {
    Object localObject1 = paramList;
    if (paramList == null)
    {
      localObject1 = new ArrayList();
      paramList1 = new ArrayList();
    }
    int i = 0;
    Object localObject2;
    for (;;)
    {
      int j = ((List)localObject1).size();
      int k = 1;
      if ((i >= j) || (i >= paramList1.size())) {
        break;
      }
      paramList = (List)((List)localObject1).get(i);
      localObject2 = this.peopleList.iterator();
      BeautyTransformList.FaceInfoOfPeople localFaceInfoOfPeople;
      do
      {
        j = k;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFaceInfoOfPeople = (BeautyTransformList.FaceInfoOfPeople)((Iterator)localObject2).next();
      } while (!samePeople(paramList, (List)localFaceInfoOfPeople.faces.getLast()));
      if (localFaceInfoOfPeople.count > 0)
      {
        localFaceInfoOfPeople.faces.clear();
        localFaceInfoOfPeople.facesAngles.clear();
      }
      localFaceInfoOfPeople.faces.add(paramList);
      if (localFaceInfoOfPeople.faces.size() > FACE_CACHE_LEN) {
        localFaceInfoOfPeople.faces.removeFirst();
      }
      localFaceInfoOfPeople.facesAngles.add(paramList1.get(i));
      if (localFaceInfoOfPeople.facesAngles.size() > FACE_CACHE_LEN) {
        localFaceInfoOfPeople.facesAngles.removeFirst();
      }
      localFaceInfoOfPeople.count = -1;
      j = 0;
      if (j != 0)
      {
        localObject2 = new BeautyTransformList.FaceInfoOfPeople(this);
        ((BeautyTransformList.FaceInfoOfPeople)localObject2).faces.add(paramList);
        ((BeautyTransformList.FaceInfoOfPeople)localObject2).facesAngles.add(paramList1.get(i));
        this.peopleList.add(localObject2);
      }
      i += 1;
    }
    paramList = this.peopleList.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (BeautyTransformList.FaceInfoOfPeople)paramList.next();
      paramList1.count += 1;
      if (paramList1.count > 0) {
        if (paramList1.count >= 6)
        {
          paramList.remove();
        }
        else
        {
          i = chooseBestDataIndex(paramList1.faces, paramList1.facesAngles);
          localObject1 = (List)paramList1.faces.get(i);
          localObject2 = (float[])paramList1.facesAngles.get(i);
          paramList1.faces.clear();
          paramList1.facesAngles.clear();
          paramList1.faces.add(localObject1);
          paramList1.facesAngles.add(localObject2);
        }
      }
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    PTFaceAttr localPTFaceAttr = this.faceAttr;
    if (localPTFaceAttr == null) {
      return paramFrame;
    }
    return process(paramFrame, localPTFaceAttr.getAllFacePoints(), this.faceAttr.getFaceStatusList(), this.faceAttr.getFaceDetectScale(), this.faceAttr.getAllFaceAngles(), 0.0F, false);
  }
  
  public void clear()
  {
    this.transFrame.clear();
    this.mVFaceEyeNose.clearGLSLSelf();
    this.mChinThinShorten.clearGLSLSelf();
    this.mBasic3.clearGLSLSelf();
    this.mCopyFilter.clearGLSL();
  }
  
  public BeautyParam getBeautyParam()
  {
    return this.mBeautyParam;
  }
  
  public FaceBeautyItem getFaceBeautyItem()
  {
    return this.item;
  }
  
  public float getFemalePercent()
  {
    return this.femalePercent;
  }
  
  public float getMalePercent()
  {
    return this.malePercent;
  }
  
  public void initial()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
    this.mVFaceEyeNose.ApplyGLSLFilter();
    this.mChinThinShorten.ApplyGLSLFilter();
    this.mBasic3.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
    this.mCopyFilter.apply();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
  }
  
  public boolean needFaceInfo()
  {
    return this.mFilters.size() != 0;
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, double paramDouble, List<float[]> paramList2, float paramFloat, boolean paramBoolean)
  {
    updateVideoSize(paramFrame.width, paramFrame.height, paramDouble);
    return updateAndRender(paramFrame, paramList, paramList1, paramList2, paramFloat, paramBoolean);
  }
  
  public void setAge(int paramInt)
  {
    this.age = paramInt;
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    if (paramDistortParam == null) {
      return;
    }
    if ((paramInt != BeautyRealConfig.TYPE.FACE_V.value) && (paramInt != BeautyRealConfig.TYPE.EYE.value) && (paramInt != BeautyRealConfig.TYPE.NOSE.value))
    {
      if ((paramInt != BeautyRealConfig.TYPE.FACE_THIN.value) && (paramInt != BeautyRealConfig.TYPE.CHIN.value) && (paramInt != BeautyRealConfig.TYPE.FACE_SHORTEN.value))
      {
        if (BeautyRealConfig.isFaceType(paramInt))
        {
          this.mBeautyParam.basic = paramDistortParam;
          paramDistortParam = new ArrayList();
          paramDistortParam.addAll(this.mBeautyParam.basic.getItems());
          this.mBasic3.setDistortionItems(paramDistortParam);
        }
      }
      else
      {
        if (paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) {
          this.mBeautyParam.zhailian = paramDistortParam;
        } else if (paramInt == BeautyRealConfig.TYPE.CHIN.value) {
          this.mBeautyParam.xiaba = paramDistortParam;
        } else if (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value) {
          this.mBeautyParam.faceShorten = paramDistortParam;
        }
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.zhailian.getItems());
        paramDistortParam.addAll(this.mBeautyParam.xiaba.getItems());
        paramDistortParam.addAll(this.mBeautyParam.faceShorten.getItems());
        this.mChinThinShorten.setDistortionItems(paramDistortParam);
      }
    }
    else
    {
      if (paramInt == BeautyRealConfig.TYPE.FACE_V.value) {
        this.mBeautyParam.vlian = paramDistortParam;
      } else if (paramInt == BeautyRealConfig.TYPE.EYE.value) {
        this.mBeautyParam.eye = paramDistortParam;
      } else if (paramInt == BeautyRealConfig.TYPE.NOSE.value) {
        this.mBeautyParam.nose = paramDistortParam;
      }
      paramDistortParam = new ArrayList();
      paramDistortParam.addAll(this.mBeautyParam.vlian.getItems());
      paramDistortParam.addAll(this.mBeautyParam.eye.getItems());
      paramDistortParam.addAll(this.mBeautyParam.nose.getItems());
      this.mVFaceEyeNose.setDistortionItems(paramDistortParam);
    }
    rebuildFilterList();
  }
  
  public void setBeautyParamValue(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 11)
    {
      this.Basic3level = paramInt2;
      return;
    }
    if (paramInt1 == BeautyRealConfig.TYPE.NOSE.value)
    {
      this.noseLevel = paramInt2;
      return;
    }
    if (paramInt1 == BeautyRealConfig.TYPE.FACE_SHORTEN.value) {
      this.faceShortenLevel = paramInt2;
    }
  }
  
  public void setFaceBeautyItem(FaceBeautyItem paramFaceBeautyItem)
  {
    this.item = paramFaceBeautyItem;
  }
  
  public void setFemale(boolean paramBoolean)
  {
    this.isFemale = paramBoolean;
  }
  
  public void setNeedReCaculateFace(boolean paramBoolean)
  {
    this.mVFaceEyeNose.setNeedReCaculateFace(paramBoolean);
    this.mChinThinShorten.setNeedReCaculateFace(paramBoolean);
    this.mBasic3.setNeedReCaculateFace(paramBoolean);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mVFaceEyeNose.setRenderMode(paramInt);
    this.mChinThinShorten.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public Frame updateAndRender(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, float paramFloat, boolean paramBoolean)
  {
    Object localObject1 = this;
    ((BeautyTransformList)localObject1).updatePeopleList(paramList, paramList2);
    paramList = getFaceInfo();
    List localList1 = paramList.faces;
    List localList2 = paramList.facesAngles;
    List localList3 = paramList.countList;
    paramList = ((BeautyTransformList)localObject1).faceAttr;
    if (paramList != null) {
      paramList = paramList.getTransformFacePoints();
    } else {
      paramList = null;
    }
    if (!CollectionUtils.isEmpty(localList1))
    {
      int i = 0;
      for (;;)
      {
        Object localObject2 = paramList1;
        localObject1 = this;
        paramList2 = paramFrame;
        if (i >= Math.min(localList1.size(), 5)) {
          break;
        }
        List localList4 = (List)localList1.get(i);
        if ((localObject2 != null) && (paramList1.size() > i))
        {
          int j = ((FaceStatus)((List)localObject2).get(i)).gender;
          boolean bool = true;
          if (j != 1) {
            bool = false;
          }
          ((BeautyTransformList)localObject1).isFemale = bool;
          if (BeautyAIParam.needAIBeautyValid()) {
            j = ((FaceStatus)((List)localObject2).get(i)).age;
          } else {
            j = 0;
          }
          ((BeautyTransformList)localObject1).age = j;
        }
        ((BeautyTransformList)localObject1).mBeautyAIParam.setBeautyParam(((BeautyTransformList)localObject1).isFemale, ((BeautyTransformList)localObject1).age, paramBoolean);
        if (AEModule.isEnableDefaultBasic3())
        {
          ((BeautyTransformList)localObject1).setBeautyParam(BeautyRealConfig.TYPE.BASIC3.value, BeautyRealUtil.getDistortParam(((BeautyTransformList)localObject1).mBeautyParamValue.getDistortList(BeautyRealConfig.TYPE.BASIC3), Math.round(((BeautyTransformList)localObject1).mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.BASIC3, ((BeautyTransformList)localObject1).Basic3level / 100.0F) * 100.0F), BeautyRealConfig.TYPE.BASIC3.value));
          ((BeautyTransformList)localObject1).setBeautyParam(BeautyRealConfig.TYPE.NOSE.value, BeautyRealUtil.getDistortParam(((BeautyTransformList)localObject1).mBeautyParamValue.getDistortList(BeautyRealConfig.TYPE.NOSE), Math.round(((BeautyTransformList)localObject1).mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.NOSE, ((BeautyTransformList)localObject1).noseLevel / 100.0F) * 100.0F), BeautyRealConfig.TYPE.NOSE.value));
          ((BeautyTransformList)localObject1).setBeautyParam(BeautyRealConfig.TYPE.FACE_SHORTEN.value, BeautyRealUtil.getDistortParam(((BeautyTransformList)localObject1).mBeautyParamValue.getDistortList(BeautyRealConfig.TYPE.FACE_SHORTEN), Math.round(((BeautyTransformList)localObject1).mBeautyAIParam.getRealValue(BeautyAIParam.AI_TYPE.FACE_SHORTEN, ((BeautyTransformList)localObject1).faceShortenLevel / 100.0F) * 100.0F), BeautyRealConfig.TYPE.FACE_SHORTEN.value));
        }
        localObject2 = (float[])localList2.get(i);
        localObject1 = ((BeautyTransformList)localObject1).mFilters.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          TransformFilter localTransformFilter = (TransformFilter)((Iterator)localObject1).next();
          BenchUtil.benchStart("[BeautyTransformList] updatePreview");
          localTransformFilter.updateStrength(1.0F - my_smoothstep(0.4F, 1.0F, ((Integer)localList3.get(i)).intValue() / 6.0F));
          PTDetectInfo.Builder localBuilder = new PTDetectInfo.Builder().facePoints(localList4).faceAngles((float[])localObject2).phoneAngle(paramFloat);
          if ((paramList != null) && (paramList.size() > i)) {
            paramList2 = (List)paramList.get(i);
          } else {
            paramList2 = null;
          }
          localTransformFilter.updatePreview(localBuilder.transformPoints(paramList2).build());
          BenchUtil.benchEnd("[BeautyTransformList] updatePreview");
          BenchUtil.benchStart("[BeautyTransformList] renderProcessBySwitchFbo");
          paramList2 = localTransformFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          paramFrame.unlock();
          BenchUtil.benchEnd("[BeautyTransformList] renderProcessBySwitchFbo");
          paramFrame = paramList2;
        }
        i += 1;
      }
    }
    paramList2 = paramFrame;
    return paramList2;
  }
  
  public void updateFaceFeature(List<List<PointF>> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = (List)paramList.next();
      BenchUtil.benchStart("[BeautyTransformList] getFullCoords");
      FaceOffUtil.getFullCoords(localList, 2.0F);
      BenchUtil.benchEnd("[BeautyTransformList] getFullCoords");
      BenchUtil.benchStart("[BeautyTransformList] updateFaceFeature");
      Iterator localIterator = this.mFilters.iterator();
      while (localIterator.hasNext()) {
        ((TransformFilter)localIterator.next()).updateFaceFeatures_new(localList);
      }
      BenchUtil.benchEnd("[BeautyTransformList] updateFaceFeature");
    }
  }
  
  public void updateFemalePercent(float paramFloat)
  {
    this.femalePercent = paramFloat;
  }
  
  public void updateMalePercent(float paramFloat)
  {
    this.malePercent = paramFloat;
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (paramObject.aiAttr != null) {
        this.faceAttr = ((PTFaceAttr)paramObject.aiAttr.getFaceAttr());
      }
    }
    else if ((paramObject instanceof PTFaceAttr))
    {
      this.faceAttr = ((PTFaceAttr)paramObject);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    TransformFilter localTransformFilter = this.mVFaceEyeNose;
    if (localTransformFilter != null) {
      localTransformFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localTransformFilter = this.mChinThinShorten;
    if (localTransformFilter != null) {
      localTransformFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localTransformFilter = this.mBasic3;
    if (localTransformFilter != null) {
      localTransformFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BeautyTransformList
 * JD-Core Version:    0.7.0.1
 */