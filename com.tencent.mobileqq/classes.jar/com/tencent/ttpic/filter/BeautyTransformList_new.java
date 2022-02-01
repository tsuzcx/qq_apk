package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.BeautyParam;
import com.tencent.ttpic.openapi.filter.BeautyParam.MeshType;
import com.tencent.ttpic.openapi.model.DistortParam;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BeautyTransformList_new
{
  private static int FACE_CACHE_LEN = 10;
  private static final int MAX_TRANSFORMED_FACES = 5;
  private final int MAX_COUNT = 6;
  private TransformFilter_new mBasic3_new;
  private TransformFilter_new mBasic3_new_2;
  private BeautyParam mBeautyParam;
  private TransformFilter_new mChinThinShorten_new;
  private BaseFilter mCopyFilter;
  private List<TransformFilter_new> mFilters_new;
  private TransformFilter_new mVFaceEyeNose_new;
  private boolean need_60 = false;
  private List<BeautyTransformList_new.FaceInfoOfPeople> peopleList = new LinkedList();
  
  public BeautyTransformList_new()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
    this.mBeautyParam = new BeautyParam(BeautyParam.MeshType.PUDDING_270, false);
    BenchUtil.benchEnd("[onSurfaceCreated] create BeautyParam");
    this.mVFaceEyeNose_new = new TransformFilter_new(new ArrayList(), null);
    this.mChinThinShorten_new = new TransformFilter_new(new ArrayList(), null);
    this.mBasic3_new = new TransformFilter_new(new ArrayList(), null);
    this.mBasic3_new_2 = new TransformFilter_new(new ArrayList(), null);
    this.mFilters_new = new ArrayList();
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
  
  private BeautyTransformList_new.FaceInfoOfFrame getFaceInfo()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.peopleList.iterator();
    while (localIterator.hasNext())
    {
      BeautyTransformList_new.FaceInfoOfPeople localFaceInfoOfPeople = (BeautyTransformList_new.FaceInfoOfPeople)localIterator.next();
      localArrayList1.add(localFaceInfoOfPeople.faces.getLast());
      localArrayList2.add(localFaceInfoOfPeople.facesAngles.getLast());
      localArrayList3.add(Integer.valueOf(localFaceInfoOfPeople.count));
    }
    return new BeautyTransformList_new.FaceInfoOfFrame(this, localArrayList1, localArrayList2, localArrayList3);
  }
  
  private float my_smoothstep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    paramFloat1 = (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
    if (paramFloat1 < 0.0F) {
      paramFloat1 = f2;
    }
    for (;;)
    {
      if (paramFloat1 > 1.0F) {
        paramFloat1 = f1;
      }
      for (;;)
      {
        return (3.0F - paramFloat1 * 2.0F) * (paramFloat1 * paramFloat1);
      }
    }
  }
  
  private void rebuildFilterList()
  {
    this.mFilters_new.clear();
    if ((this.mBeautyParam.vlian.getLevel() != 0) || (this.mBeautyParam.eye.getLevel() != 0) || (this.mBeautyParam.nose.getLevel() != 0)) {
      this.mFilters_new.add(this.mVFaceEyeNose_new);
    }
    if ((this.mBeautyParam.zhailian.getLevel() != 0) || (this.mBeautyParam.xiaba.getLevel() != 0) || (this.mBeautyParam.faceShorten.getLevel() != 0)) {
      this.mFilters_new.add(this.mChinThinShorten_new);
    }
    if (this.mBeautyParam.basic.getLevel() != 0)
    {
      this.mFilters_new.add(this.mBasic3_new);
      if (this.need_60) {
        this.mFilters_new.add(this.mBasic3_new_2);
      }
    }
  }
  
  private boolean samePeople(List<PointF> paramList1, List<PointF> paramList2)
  {
    float f1 = ((PointF)paramList1.get(0)).x;
    f1 = (((PointF)paramList1.get(18)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList1.get(0)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList1.get(18)).y + f2) / 2.0F);
    f1 = ((PointF)paramList2.get(0)).x;
    f1 = (((PointF)paramList2.get(18)).x + f1) / 2.0F;
    f2 = ((PointF)paramList2.get(0)).y;
    PointF localPointF2 = new PointF(f1, (((PointF)paramList2.get(18)).y + f2) / 2.0F);
    f1 = Math.min(AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18)), AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18)));
    return AlgoUtils.getDistance(localPointF1, localPointF2) < f1 * 0.5F;
  }
  
  private boolean sameShape(List<PointF> paramList1, List<PointF> paramList2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f2 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat1[1] * 1.2D));
    float f3 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat1[0] * 1.1D));
    float f1 = (float)(AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18)) / Math.cos(f2));
    f2 = (float)(AlgoUtils.getDistance((PointF)paramList1.get(44), (PointF)paramList1.get(54)) / Math.cos(f2));
    float f4 = ((PointF)paramList1.get(44)).x;
    f4 = (((PointF)paramList1.get(54)).x + f4) / 2.0F;
    float f5 = ((PointF)paramList1.get(44)).y;
    f3 = (float)(AlgoUtils.getDistance(new PointF(f4, (((PointF)paramList1.get(54)).y + f5) / 2.0F), (PointF)paramList1.get(9)) / Math.cos(f3));
    float f6 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat2[1] * 1.2D));
    f5 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat2[0] * 1.1D));
    f4 = (float)(AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18)) / Math.cos(f6));
    f6 = (float)(AlgoUtils.getDistance((PointF)paramList2.get(44), (PointF)paramList2.get(54)) / Math.cos(f6));
    float f7 = ((PointF)paramList2.get(44)).x;
    f7 = (((PointF)paramList2.get(54)).x + f7) / 2.0F;
    float f8 = ((PointF)paramList2.get(44)).y;
    f5 = (float)(AlgoUtils.getDistance(new PointF(f7, (((PointF)paramList2.get(54)).y + f8) / 2.0F), (PointF)paramList2.get(9)) / Math.cos(f5));
    f2 = Math.abs(f2 / f1 - f6 / f4);
    return Math.abs(f3 / f1 - f5 / f4) + f2 < 0.1D;
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
    if (i < ((List)localObject1).size())
    {
      paramList = (List)((List)localObject1).get(i);
      localObject2 = this.peopleList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BeautyTransformList_new.FaceInfoOfPeople localFaceInfoOfPeople = (BeautyTransformList_new.FaceInfoOfPeople)((Iterator)localObject2).next();
        if (samePeople(paramList, (List)localFaceInfoOfPeople.faces.getLast()))
        {
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
        }
      }
    }
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        localObject2 = new BeautyTransformList_new.FaceInfoOfPeople(this);
        ((BeautyTransformList_new.FaceInfoOfPeople)localObject2).faces.add(paramList);
        ((BeautyTransformList_new.FaceInfoOfPeople)localObject2).facesAngles.add(paramList1.get(i));
        this.peopleList.add(localObject2);
      }
      i += 1;
      break;
      paramList = this.peopleList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (BeautyTransformList_new.FaceInfoOfPeople)paramList.next();
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
      return;
    }
  }
  
  public void clear()
  {
    this.mVFaceEyeNose_new.clearGLSLSelf();
    this.mChinThinShorten_new.clearGLSLSelf();
    this.mBasic3_new.clearGLSLSelf();
    this.mBasic3_new_2.clearGLSLSelf();
    this.mCopyFilter.ClearGLSL();
  }
  
  public BeautyParam getBeautyParam()
  {
    return this.mBeautyParam;
  }
  
  public void initial()
  {
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
    this.mVFaceEyeNose_new.ApplyGLSLFilter();
    this.mChinThinShorten_new.ApplyGLSLFilter();
    this.mBasic3_new.ApplyGLSLFilter();
    this.mBasic3_new_2.ApplyGLSLFilter();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
    BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
    this.mCopyFilter.apply();
    BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
  }
  
  public boolean needFaceInfo()
  {
    return this.mFilters_new.size() != 0;
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    if (paramDistortParam == null) {
      return;
    }
    if ((paramInt == BeautyRealConfig.TYPE.FACE_V.value) || (paramInt == BeautyRealConfig.TYPE.EYE.value) || (paramInt == BeautyRealConfig.TYPE.NOSE.value)) {
      if (paramInt == BeautyRealConfig.TYPE.FACE_V.value)
      {
        this.mBeautyParam.vlian = paramDistortParam;
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.vlian.getItems());
        paramDistortParam.addAll(this.mBeautyParam.eye.getItems());
        paramDistortParam.addAll(this.mBeautyParam.nose.getItems());
        this.mVFaceEyeNose_new.setDistortionItems(paramDistortParam);
      }
    }
    for (;;)
    {
      rebuildFilterList();
      return;
      if (paramInt == BeautyRealConfig.TYPE.EYE.value)
      {
        this.mBeautyParam.eye = paramDistortParam;
        break;
      }
      if (paramInt != BeautyRealConfig.TYPE.NOSE.value) {
        break;
      }
      this.mBeautyParam.nose = paramDistortParam;
      break;
      if ((paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) || (paramInt == BeautyRealConfig.TYPE.CHIN.value) || (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value))
      {
        if (paramInt == BeautyRealConfig.TYPE.FACE_THIN.value) {
          this.mBeautyParam.zhailian = paramDistortParam;
        }
        for (;;)
        {
          paramDistortParam = new ArrayList();
          paramDistortParam.addAll(this.mBeautyParam.zhailian.getItems());
          paramDistortParam.addAll(this.mBeautyParam.xiaba.getItems());
          paramDistortParam.addAll(this.mBeautyParam.faceShorten.getItems());
          this.mChinThinShorten_new.setDistortionItems(paramDistortParam);
          break;
          if (paramInt == BeautyRealConfig.TYPE.CHIN.value) {
            this.mBeautyParam.xiaba = paramDistortParam;
          } else if (paramInt == BeautyRealConfig.TYPE.FACE_SHORTEN.value) {
            this.mBeautyParam.faceShorten = paramDistortParam;
          }
        }
      }
      if (BeautyRealConfig.isFaceType(paramInt))
      {
        this.mBeautyParam.basic = paramDistortParam;
        paramDistortParam = new ArrayList();
        paramDistortParam.addAll(this.mBeautyParam.basic.getItems());
        if (paramDistortParam.size() > 30)
        {
          this.mBasic3_new.setDistortionItems(paramDistortParam.subList(0, 30));
          this.mBasic3_new_2.setDistortionItems(paramDistortParam.subList(30, paramDistortParam.size()));
          this.need_60 = true;
        }
        else
        {
          this.need_60 = false;
          this.mBasic3_new.setDistortionItems(paramDistortParam);
        }
      }
    }
  }
  
  public void setBeautyParam(BeautyParam paramBeautyParam)
  {
    if (paramBeautyParam == null) {
      return;
    }
    setBeautyParam(BeautyRealConfig.TYPE.FACE_V.value, paramBeautyParam.vlian);
    setBeautyParam(BeautyRealConfig.TYPE.EYE.value, paramBeautyParam.eye);
    setBeautyParam(BeautyRealConfig.TYPE.NOSE.value, paramBeautyParam.nose);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_THIN.value, paramBeautyParam.zhailian);
    setBeautyParam(BeautyRealConfig.TYPE.CHIN.value, paramBeautyParam.xiaba);
    setBeautyParam(BeautyRealConfig.TYPE.FACE_SHORTEN.value, paramBeautyParam.faceShorten);
    setBeautyParam(BeautyRealConfig.TYPE.BASIC3.value, paramBeautyParam.basic);
    rebuildFilterList();
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mVFaceEyeNose_new.setRenderMode(paramInt);
    this.mChinThinShorten_new.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public Frame updateAndRender(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, float paramFloat)
  {
    updatePeopleList(paramList, paramList1);
    paramList = getFaceInfo();
    paramList1 = paramList.faces;
    List localList1 = paramList.facesAngles;
    List localList2 = paramList.countList;
    FrameUtil.clearFrame(paramFrame, 0.0F, 0.0F, 0.0F, 0.0F, 65, 65);
    paramList = paramFrame;
    if (!CollectionUtils.isEmpty(paramList1))
    {
      int i = 0;
      for (;;)
      {
        paramList = paramFrame;
        if (i >= Math.min(paramList1.size(), 5)) {
          break;
        }
        List localList3 = (List)paramList1.get(i);
        float[] arrayOfFloat = (float[])localList1.get(i);
        Iterator localIterator = this.mFilters_new.iterator();
        while (localIterator.hasNext())
        {
          paramList = (TransformFilter_new)localIterator.next();
          BenchUtil.benchStart("[BeautyTransformList] updatePreview");
          paramList.updateStrength(1.0F - my_smoothstep(0.4F, 1.0F, ((Integer)localList2.get(i)).intValue() / 6.0F));
          paramList.updatePreview(new PTDetectInfo.Builder().facePoints(localList3).faceAngles(arrayOfFloat).phoneAngle(paramFloat).build());
          BenchUtil.benchEnd("[BeautyTransformList] updatePreview");
          BenchUtil.benchStart("[BeautyTransformList] renderProcessBySwitchFbo");
          paramList = paramList.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          paramFrame.unlock();
          BenchUtil.benchEnd("[BeautyTransformList] renderProcessBySwitchFbo");
          paramFrame = paramList;
        }
        i += 1;
      }
    }
    return paramList;
  }
  
  public void updateFaceFeature(List<List<PointF>> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = (List)paramList.next();
        BenchUtil.benchStart("[BeautyTransformList] getFullCoords");
        FaceOffUtil.getFullCoords(localList, 2.0F);
        BenchUtil.benchEnd("[BeautyTransformList] getFullCoords");
        BenchUtil.benchStart("[BeautyTransformList] updateFaceFeature");
        Iterator localIterator = this.mFilters_new.iterator();
        while (localIterator.hasNext()) {
          ((TransformFilter_new)localIterator.next()).updateFaceFeatures(localList);
        }
        BenchUtil.benchEnd("[BeautyTransformList] updateFaceFeature");
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mVFaceEyeNose_new.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mChinThinShorten_new.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mBasic3_new.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mBasic3_new_2.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyTransformList_new
 * JD-Core Version:    0.7.0.1
 */