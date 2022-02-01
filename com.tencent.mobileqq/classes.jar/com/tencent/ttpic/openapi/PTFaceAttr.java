package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.light.bean.TTFaceOriginDataModel;

public class PTFaceAttr
{
  public static final PTFaceAttr EmptyFaceAttr = new PTFaceAttr(new PTFaceAttr.Builder().facePoints(new ArrayList(90)).irisPoints(new ArrayList(90)).faceAngles(new ArrayList(3)).pointsVis(new ArrayList(90)).triggeredExpression(new HashSet()).faceDetectScale(1.0D).rotation(0).faceDetector(null).faceActionCounter(new HashMap()).timeStamp(System.currentTimeMillis()));
  private int[] autoBrightnessCurve;
  private int[] autoContrastCurve;
  private List<List<PointF>> bodyPoints;
  private int[] curve;
  private Map<String, Long> detectTimes;
  private List<Set<Integer>> expressions;
  private List<float[]> face3DRotationArray;
  private List<float[]> face3DVerticesArray;
  private double faceAverageL;
  private int faceDetHeight = 0;
  private int faceDetRotation = 0;
  private int faceDetWidth = 0;
  private VideoPreviewFaceOutlineDetector faceDetector;
  private List<float[]> faceKitVerticesArray;
  private PointF facePiont2DCenter;
  private List<int[]> featureIndicesArray;
  private Pair<Integer, int[]> histogram;
  private boolean isPhoneFlatHorizontal;
  private int lastFaceDetectedPhoneRotation;
  private byte[] mData;
  private Map<Integer, FaceActionCounter> mFaceActionCounter;
  private List<float[]> mFaceAngles;
  private double mFaceDetectScale;
  private Map<PTFaceAttr.PTExpression, Boolean> mFaceExpression;
  private List<FaceInfo> mFaceInfoList;
  private List<List<PointF>> mFacePoint94;
  private List<List<PointF>> mFacePoints;
  private List<FaceStatus> mFaceStatusList;
  private List<List<PointF>> mIrisPoints;
  private Frame mOrigFrame;
  private List<Float[]> mPointsVis;
  private Map<String, String[]> mRecordFaceInfo = new HashMap();
  private int mRotation;
  private int mSrcRotation;
  private long mTimeStamp;
  private List<List<PointF>> mTransformFacePoints;
  private Set<Integer> mTriggeredExpression;
  private PTFaceAttr reusedFaceAttr;
  private float[] rgbGain;
  private List<LinkedList<FaceInfo>> shookFaceInfos;
  private Frame starMaskFrame;
  private List<PointF> starPoints;
  private List<TTFaceOriginDataModel> ttFaceOriginDataModelList;
  
  public PTFaceAttr(PTFaceAttr.Builder paramBuilder)
  {
    initValues(paramBuilder);
    this.mFacePoint94 = PTFaceAttr.Builder.access$000(paramBuilder);
    this.mFacePoints = PTFaceAttr.Builder.access$100(paramBuilder);
    this.mIrisPoints = PTFaceAttr.Builder.access$200(paramBuilder);
    this.mPointsVis = PTFaceAttr.Builder.access$300(paramBuilder);
    this.mRecordFaceInfo = PTFaceAttr.Builder.access$400(paramBuilder);
    this.mFaceAngles = PTFaceAttr.Builder.access$500(paramBuilder);
    this.mData = PTFaceAttr.Builder.access$600(paramBuilder);
    this.mFaceExpression = PTFaceAttr.Builder.access$700(paramBuilder);
    this.mFaceStatusList = PTFaceAttr.Builder.access$800(paramBuilder);
    this.mFaceInfoList = PTFaceAttr.Builder.access$900(paramBuilder);
    this.mOrigFrame = PTFaceAttr.Builder.access$1000(paramBuilder);
    this.mTimeStamp = PTFaceAttr.Builder.access$1100(paramBuilder);
    this.mRotation = PTFaceAttr.Builder.access$1200(paramBuilder);
    this.mSrcRotation = PTFaceAttr.Builder.access$1300(paramBuilder);
    this.mTriggeredExpression = PTFaceAttr.Builder.access$1400(paramBuilder);
    this.mFaceDetectScale = PTFaceAttr.Builder.access$1500(paramBuilder);
    this.mFaceActionCounter = PTFaceAttr.Builder.access$1600(paramBuilder);
    this.histogram = PTFaceAttr.Builder.access$1700(paramBuilder);
    this.bodyPoints = PTFaceAttr.Builder.access$1800(paramBuilder);
    this.starPoints = PTFaceAttr.Builder.access$1900(paramBuilder);
    this.starMaskFrame = PTFaceAttr.Builder.access$2000(paramBuilder);
    this.faceDetector = PTFaceAttr.Builder.access$2100(paramBuilder);
    this.rgbGain = PTFaceAttr.Builder.access$2200(paramBuilder);
    this.curve = PTFaceAttr.Builder.access$2300(paramBuilder);
    this.autoContrastCurve = PTFaceAttr.Builder.access$2400(paramBuilder);
    this.autoBrightnessCurve = PTFaceAttr.Builder.access$2500(paramBuilder);
    this.faceAverageL = PTFaceAttr.Builder.access$2600(paramBuilder);
    this.faceKitVerticesArray = PTFaceAttr.Builder.access$2700(paramBuilder);
    this.face3DVerticesArray = PTFaceAttr.Builder.access$2800(paramBuilder);
    this.face3DRotationArray = PTFaceAttr.Builder.access$2900(paramBuilder);
    this.featureIndicesArray = PTFaceAttr.Builder.access$3000(paramBuilder);
    this.facePiont2DCenter = PTFaceAttr.Builder.access$3100(paramBuilder);
    this.lastFaceDetectedPhoneRotation = PTFaceAttr.Builder.access$3200(paramBuilder);
    this.isPhoneFlatHorizontal = PTFaceAttr.Builder.access$3300(paramBuilder);
    this.shookFaceInfos = PTFaceAttr.Builder.access$3400(paramBuilder);
    this.detectTimes = PTFaceAttr.Builder.access$3500(paramBuilder);
    this.faceDetWidth = PTFaceAttr.Builder.access$3600(paramBuilder);
    this.faceDetHeight = PTFaceAttr.Builder.access$3700(paramBuilder);
    this.faceDetRotation = PTFaceAttr.Builder.access$3800(paramBuilder);
    this.expressions = PTFaceAttr.Builder.access$3900(paramBuilder);
  }
  
  private static boolean checkFaceFeatureOutScreen(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      double d = paramInt1;
      Double.isNaN(d);
      float f = (float)(d * paramDouble);
      d = paramInt2;
      Double.isNaN(d);
      RectF localRectF = new RectF(0.0F, 0.0F, f, (float)(d * paramDouble));
      if (!localRectF.contains(((PointF)paramList.get(65)).x, ((PointF)paramList.get(65)).y)) {
        return false;
      }
      if (!localRectF.contains(((PointF)paramList.get(66)).x, ((PointF)paramList.get(66)).y)) {
        return false;
      }
      paramList = new PointF((((PointF)paramList.get(69)).x + ((PointF)paramList.get(9)).x) / 2.0F, (((PointF)paramList.get(69)).y + ((PointF)paramList.get(9)).y) / 2.0F);
      return localRectF.contains(paramList.x, paramList.y);
    }
    return false;
  }
  
  public static boolean checkFaceFeatureOutScreenUKYO(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      double d = paramInt1;
      Double.isNaN(d);
      float f = (float)(d * paramDouble);
      d = paramInt2;
      Double.isNaN(d);
      RectF localRectF = new RectF(0.0F, 0.0F, f, (float)(d * paramDouble));
      if (!localRectF.contains(((PointF)paramList.get(61)).x, ((PointF)paramList.get(61)).y)) {
        return false;
      }
      if (!localRectF.contains(((PointF)paramList.get(57)).x, ((PointF)paramList.get(57)).y)) {
        return false;
      }
      paramList = new PointF((((PointF)paramList.get(69)).x + ((PointF)paramList.get(9)).x) / 2.0F, (((PointF)paramList.get(69)).y + ((PointF)paramList.get(9)).y) / 2.0F);
      return localRectF.contains(paramList.x, paramList.y);
    }
    return false;
  }
  
  public static PTFaceAttr genFaceAttr(byte[] paramArrayOfByte, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    PTFaceAttr.Builder localBuilder = new PTFaceAttr.Builder();
    localBuilder.facePoints(paramVideoPreviewFaceOutlineDetector.getAllFaces()).irisPoints(paramVideoPreviewFaceOutlineDetector.getAllIris()).faceAngles(paramVideoPreviewFaceOutlineDetector.getAllFaceAngles()).triggeredExpression(paramVideoPreviewFaceOutlineDetector.getTriggeredExpression()).faceStatusList(paramVideoPreviewFaceOutlineDetector.getFaceStatus3Ds()).faceDetectScale(1.0D).data(paramArrayOfByte).faceActionCounter(paramVideoPreviewFaceOutlineDetector.getFaceActionCounter()).faceDetector(paramVideoPreviewFaceOutlineDetector);
    return new PTFaceAttr(localBuilder);
  }
  
  private void initValues(PTFaceAttr.Builder paramBuilder)
  {
    PTFaceAttr.Builder.access$702(paramBuilder, new HashMap());
    if (PTFaceAttr.Builder.access$1400(paramBuilder) == null)
    {
      PTFaceAttr.Builder.access$1402(paramBuilder, new HashSet());
      PTFaceAttr.Builder.access$1400(paramBuilder).add(Integer.valueOf(1));
    }
    PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
    int j = arrayOfPTExpression.length;
    int i = 0;
    while (i < j)
    {
      PTFaceAttr.PTExpression localPTExpression = arrayOfPTExpression[i];
      if (PTFaceAttr.Builder.access$1400(paramBuilder).contains(Integer.valueOf(localPTExpression.value))) {
        PTFaceAttr.Builder.access$700(paramBuilder).put(localPTExpression, Boolean.valueOf(true));
      } else {
        PTFaceAttr.Builder.access$700(paramBuilder).put(localPTExpression, Boolean.valueOf(false));
      }
      i += 1;
    }
    PTFaceAttr.Builder.access$1802(paramBuilder, new ArrayList());
  }
  
  public static boolean isPositiveFace(float[] paramArrayOfFloat, List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool2 = false;
    double d = Math.min(Math.abs(Math.cos(paramArrayOfFloat[0])), Math.abs(Math.cos(paramArrayOfFloat[1])));
    boolean bool1 = bool2;
    if (checkFaceFeatureOutScreen(paramList, paramInt1, paramInt2, paramDouble))
    {
      bool1 = bool2;
      if (d >= 0.94D) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String genOrigFaceData()
  {
    Object localObject = this.mFaceInfoList;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    if (i <= 0) {
      return null;
    }
    localObject = new ArrayList();
    int j = 0;
    while (j < i)
    {
      TTFaceOriginDataModel localTTFaceOriginDataModel = new TTFaceOriginDataModel();
      localTTFaceOriginDataModel.cls = 1;
      localTTFaceOriginDataModel.pitch = ((FaceInfo)this.mFaceInfoList.get(j)).pitch;
      localTTFaceOriginDataModel.yaw = ((FaceInfo)this.mFaceInfoList.get(j)).yaw;
      localTTFaceOriginDataModel.roll = ((FaceInfo)this.mFaceInfoList.get(j)).roll;
      localTTFaceOriginDataModel.facePoint = ((FaceInfo)this.mFaceInfoList.get(j)).origFacePoints;
      int k = 0;
      while (k < 94) {
        k += 1;
      }
      System.arraycopy(((FaceInfo)this.mFaceInfoList.get(j)).origPointsVis, 0, localTTFaceOriginDataModel.facePointVisible, 0, ((FaceInfo)this.mFaceInfoList.get(j)).origPointsVis.length);
      ((List)localObject).add(localTTFaceOriginDataModel);
      j += 1;
    }
    return GsonUtils.objList2Json((List)localObject);
  }
  
  public List<float[]> getAllFaceAngles()
  {
    return this.mFaceAngles;
  }
  
  public List<List<PointF>> getAllFacePoints()
  {
    return this.mFacePoints;
  }
  
  public List<List<PointF>> getAllFacePoints94()
  {
    return this.mFacePoint94;
  }
  
  public List<List<PointF>> getAllIrisPoints()
  {
    return this.mIrisPoints;
  }
  
  public int[] getAutoBrightnessCurve()
  {
    return this.autoBrightnessCurve;
  }
  
  public int[] getAutoContrastCurve()
  {
    return this.autoContrastCurve;
  }
  
  public List<List<PointF>> getBodyPoints()
  {
    return this.bodyPoints;
  }
  
  public int[] getCurve()
  {
    return this.curve;
  }
  
  public byte[] getData()
  {
    return this.mData;
  }
  
  public List<Set<Integer>> getExpressions()
  {
    return this.expressions;
  }
  
  public List<float[]> getFace3DRotationArray()
  {
    return this.face3DRotationArray;
  }
  
  public List<float[]> getFace3DVerticesArray()
  {
    return this.face3DVerticesArray;
  }
  
  public Map<Integer, FaceActionCounter> getFaceActionCounter()
  {
    return this.mFaceActionCounter;
  }
  
  public double getFaceAverageL()
  {
    return this.faceAverageL;
  }
  
  public int getFaceCount()
  {
    return this.mFacePoints.size();
  }
  
  public int getFaceDetHeight()
  {
    return this.faceDetHeight;
  }
  
  public int getFaceDetRotation()
  {
    return this.faceDetRotation;
  }
  
  public int getFaceDetWidth()
  {
    return this.faceDetWidth;
  }
  
  public double getFaceDetectScale()
  {
    return this.mFaceDetectScale;
  }
  
  public long getFaceDetectTime()
  {
    Map localMap = this.detectTimes;
    if ((localMap != null) && (localMap.get("sdk_face_detect_time") != null)) {
      return ((Long)this.detectTimes.get("sdk_face_detect_time")).longValue();
    }
    return 0L;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    return this.faceDetector;
  }
  
  public Map<PTFaceAttr.PTExpression, Boolean> getFaceExpression()
  {
    return this.mFaceExpression;
  }
  
  public List<FaceInfo> getFaceInfoList()
  {
    return this.mFaceInfoList;
  }
  
  public List<float[]> getFaceKitVerticesArray()
  {
    return this.faceKitVerticesArray;
  }
  
  public PointF getFacePiont2DCenter()
  {
    return this.facePiont2DCenter;
  }
  
  public List<Rect> getFaceRectList()
  {
    ArrayList localArrayList = new ArrayList();
    double d1 = getFaceDetectScale();
    if (d1 != 0.0D)
    {
      Object localObject = getFaceInfoList();
      if (!CollectionUtils.isEmpty((Collection)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FaceInfo localFaceInfo = (FaceInfo)((Iterator)localObject).next();
          Rect localRect = new Rect();
          double d2 = localFaceInfo.rect[0];
          Double.isNaN(d2);
          localRect.left = ((int)(d2 / d1));
          d2 = localFaceInfo.rect[1];
          Double.isNaN(d2);
          localRect.top = ((int)(d2 / d1));
          d2 = localFaceInfo.rect[2];
          Double.isNaN(d2);
          localRect.right = ((int)(d2 / d1) + localRect.left);
          d2 = localFaceInfo.rect[3];
          Double.isNaN(d2);
          localRect.bottom = ((int)(d2 / d1) + localRect.top);
          localArrayList.add(localRect);
        }
      }
    }
    return localArrayList;
  }
  
  public List<FaceStatus> getFaceStatusList()
  {
    return this.mFaceStatusList;
  }
  
  public List<int[]> getFeatureIndicesArray()
  {
    return this.featureIndicesArray;
  }
  
  public Pair<Integer, int[]> getHistogram()
  {
    return this.histogram;
  }
  
  public int getLastFaceDetectedPhoneRotation()
  {
    return this.lastFaceDetectedPhoneRotation;
  }
  
  public Frame getOrigFrame()
  {
    return this.mOrigFrame;
  }
  
  public List<Float[]> getPointsVis()
  {
    return this.mPointsVis;
  }
  
  public float[] getRGBGain()
  {
    return this.rgbGain;
  }
  
  public int getRealPhoneRotation()
  {
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector = this.faceDetector;
    double d;
    if (localVideoPreviewFaceOutlineDetector != null) {
      d = localVideoPreviewFaceOutlineDetector.getPhotoAngle();
    } else {
      d = 0.0D;
    }
    return VideoFilterUtil.get4DirectionAngle(d);
  }
  
  public Map<String, String[]> getRecordFaceInfo()
  {
    return this.mRecordFaceInfo;
  }
  
  public PTFaceAttr getReusedFaceAttr()
  {
    return this.reusedFaceAttr;
  }
  
  public int getRotation()
  {
    return this.mRotation;
  }
  
  public List<LinkedList<FaceInfo>> getShookFaceInfos()
  {
    return this.shookFaceInfos;
  }
  
  public int getSrcRotation()
  {
    return this.mSrcRotation;
  }
  
  public Frame getStarMaskFrame()
  {
    return this.starMaskFrame;
  }
  
  public List<PointF> getStarPoints()
  {
    return this.starPoints;
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  public List<List<PointF>> getTransformFacePoints()
  {
    return this.mTransformFacePoints;
  }
  
  public Set<Integer> getTriggeredExpression()
  {
    return this.mTriggeredExpression;
  }
  
  public List<TTFaceOriginDataModel> getTtFaceOriginDataModelList()
  {
    return this.ttFaceOriginDataModelList;
  }
  
  public void initTransformFacePoints()
  {
    if (this.mTransformFacePoints == null) {
      this.mTransformFacePoints = new ArrayList();
    }
    this.mTransformFacePoints.clear();
    Object localObject = this.mFacePoints;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Iterator)localObject).next();
        this.mTransformFacePoints.add(VideoMaterial.copyList(localList));
      }
    }
  }
  
  public boolean isLandscape()
  {
    int i = this.mRotation;
    return (i == 90) || (i == 270);
  }
  
  public boolean isPhoneFlatHorizontal()
  {
    return this.isPhoneFlatHorizontal;
  }
  
  public void mergeOrigFaceData(List<TTFaceOriginDataModel> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int k;
    for (;;)
    {
      boolean bool = paramList.hasNext();
      k = 0;
      if (!bool) {
        break;
      }
      localObject1 = (TTFaceOriginDataModel)paramList.next();
      localObject2 = new FaceInfo();
      localObject3 = new float['¼'];
      localObject3 = ((TTFaceOriginDataModel)localObject1).facePoint;
      ((FaceInfo)localObject2).points = YoutuPointsUtil.transformYTPointsToPtuPoints((float[])localObject3);
      ((FaceInfo)localObject2).irisPoints = YoutuPointsUtil.getIrisPoints((float[])localObject3);
      ((FaceInfo)localObject2).pointsVis = YoutuPointsUtil.transformYTPointsVisToPtuPoints(((TTFaceOriginDataModel)localObject1).facePointVisible);
      ((FaceInfo)localObject2).pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(((FaceInfo)localObject2).pointsVis);
      localObject3 = ((FaceInfo)localObject2).angles;
      double d = ((TTFaceOriginDataModel)localObject1).pitch;
      Double.isNaN(d);
      localObject3[0] = ((float)(d * 3.141592653589793D / 180.0D) * -1.0F);
      localObject3 = ((FaceInfo)localObject2).angles;
      d = ((TTFaceOriginDataModel)localObject1).yaw;
      Double.isNaN(d);
      localObject3[1] = ((float)(d * 3.141592653589793D / 180.0D) * -1.0F);
      localObject3 = ((FaceInfo)localObject2).angles;
      d = ((TTFaceOriginDataModel)localObject1).roll;
      Double.isNaN(d);
      localObject3[2] = ((float)(d * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject2).pitch = ((TTFaceOriginDataModel)localObject1).pitch;
      ((FaceInfo)localObject2).yaw = ((TTFaceOriginDataModel)localObject1).yaw;
      ((FaceInfo)localObject2).roll = ((TTFaceOriginDataModel)localObject1).roll;
      ((FaceInfo)localObject2).scale = 0.0F;
      ((FaceInfo)localObject2).tx = 0.0F;
      ((FaceInfo)localObject2).ty = 0.0F;
      ((FaceInfo)localObject2).denseFaceModel = null;
      ((FaceInfo)localObject2).transform = null;
      ((FaceInfo)localObject2).expressionWeights = null;
      ((FaceInfo)localObject2).gender = GenderType.FEMALE.value;
      localArrayList.add(localObject2);
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramList = new ArrayList();
    Object localObject1 = new ArrayList();
    new HashSet().add(Integer.valueOf(1));
    int i = 0;
    while (i < localArrayList.size())
    {
      ((List)localObject2).add(((FaceInfo)localArrayList.get(i)).points);
      i += 1;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      ((List)localObject3).add(((FaceInfo)localArrayList.get(i)).irisPoints);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= localArrayList.size()) {
        break;
      }
      paramList.add(((FaceInfo)localArrayList.get(i)).pointsVis);
      i += 1;
    }
    while (j < localArrayList.size())
    {
      ((List)localObject1).add(((FaceInfo)localArrayList.get(j)).angles);
      j += 1;
    }
    localObject2 = AlgoUtils.rotatePointsForList((List)localObject2, this.faceDetWidth, this.faceDetHeight, this.faceDetRotation);
    localObject3 = AlgoUtils.rotatePointsForList((List)localObject3, this.faceDetWidth, this.faceDetHeight, this.faceDetRotation);
    localObject1 = AlgoUtils.rotateAngles((List)localObject1, -this.faceDetRotation);
    this.mFacePoints.addAll((Collection)localObject2);
    this.mIrisPoints.addAll((Collection)localObject3);
    this.mPointsVis.addAll(paramList);
    this.mFaceAngles.addAll((Collection)localObject1);
    this.mFaceInfoList.addAll(localArrayList);
  }
  
  public void setAutoBrightnessCurve(int[] paramArrayOfInt)
  {
    this.autoBrightnessCurve = paramArrayOfInt;
  }
  
  public void setAutoContrastCurve(int[] paramArrayOfInt)
  {
    this.autoContrastCurve = paramArrayOfInt;
  }
  
  public void setBodyPoints(List<List<PointF>> paramList)
  {
    this.bodyPoints = paramList;
  }
  
  public void setCurve(int[] paramArrayOfInt)
  {
    this.curve = paramArrayOfInt;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  public void setFaceActionCounter(Map<Integer, FaceActionCounter> paramMap)
  {
    this.mFaceActionCounter = paramMap;
  }
  
  public void setFaceAngles(List<float[]> paramList)
  {
    this.mFaceAngles = paramList;
  }
  
  public void setFaceAverageL(double paramDouble)
  {
    this.faceAverageL = paramDouble;
  }
  
  public void setFaceDetectScale(double paramDouble)
  {
    this.mFaceDetectScale = paramDouble;
  }
  
  public void setFaceDetector(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.faceDetector = paramVideoPreviewFaceOutlineDetector;
  }
  
  public void setFaceExpression(Map<PTFaceAttr.PTExpression, Boolean> paramMap)
  {
    this.mFaceExpression = paramMap;
  }
  
  public void setFacePoints(List<List<PointF>> paramList)
  {
    this.mFacePoints = paramList;
  }
  
  public void setFaceStatusList(List<FaceStatus> paramList)
  {
    this.mFaceStatusList = paramList;
  }
  
  public void setHistogram(Pair<Integer, int[]> paramPair)
  {
    this.histogram = paramPair;
  }
  
  public void setIrisPoints(List<List<PointF>> paramList)
  {
    this.mIrisPoints = paramList;
  }
  
  public void setIsPhoneFlatHorizontal(boolean paramBoolean)
  {
    this.isPhoneFlatHorizontal = paramBoolean;
  }
  
  public void setLastFaceDetectedPhoneRotation(int paramInt)
  {
    this.lastFaceDetectedPhoneRotation = paramInt;
  }
  
  public void setOrigFrame(Frame paramFrame)
  {
    this.mOrigFrame = paramFrame;
  }
  
  public void setPointsVis(List<Float[]> paramList)
  {
    this.mPointsVis = paramList;
  }
  
  public void setRGBGain(float[] paramArrayOfFloat)
  {
    this.rgbGain = paramArrayOfFloat;
  }
  
  public void setReusedFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.reusedFaceAttr = paramPTFaceAttr;
  }
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
  }
  
  public void setShookFaceInfos(List<LinkedList<FaceInfo>> paramList)
  {
    this.shookFaceInfos = paramList;
  }
  
  public void setSrcRotation(int paramInt)
  {
    this.mSrcRotation = paramInt;
  }
  
  public void setStarMaskFrame(Frame paramFrame)
  {
    this.starMaskFrame = paramFrame;
  }
  
  public void setStarPoints(List<PointF> paramList)
  {
    this.starPoints = paramList;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
  }
  
  public void setTransformFacePoints(int paramInt, List<PointF> paramList)
  {
    this.mTransformFacePoints.set(paramInt, paramList);
  }
  
  public void setTriggeredExpression(Set<Integer> paramSet)
  {
    this.mTriggeredExpression = paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceAttr
 * JD-Core Version:    0.7.0.1
 */