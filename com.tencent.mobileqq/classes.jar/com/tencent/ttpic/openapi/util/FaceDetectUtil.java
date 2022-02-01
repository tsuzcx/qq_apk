package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.facebeauty.AndroidFaceDetect;
import com.tencent.facebeauty.FaceDetect;
import com.tencent.facebeauty.FaceParam;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.facedetect.FaceParams;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.youtu.TTpicBitmapFaceDetect;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceDetectUtil
{
  public static final int CF_FACE_POINTS = 131;
  public static final int ILLEGAL_BIG_FACE = 2;
  public static final int ILLEGAL_SMALL_FACE = 1;
  public static final int LEGAL_NORMAL_FACE = 0;
  public static final int MIN_EYE_WIDTH = 20;
  public static final String TAG = FaceDetectUtil.class.getSimpleName();
  
  public static List<PointF> array2List(PointF[] paramArrayOfPointF)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfPointF == null) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfPointF.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfPointF[i]);
        i += 1;
      }
    }
  }
  
  private static boolean canUseTTPicDetect()
  {
    return FeatureManager.Features.FACE_DETECT.isPicFaceDetReady();
  }
  
  public static int checkLegalFace(FaceParam paramFaceParam, int paramInt)
  {
    if (paramFaceParam == null) {}
    int i;
    do
    {
      return 1;
      i = distance(paramFaceParam.mLeftEyeCenter, paramFaceParam.mRightEyeCenter);
    } while (i < 20);
    if (i > paramInt) {
      return 2;
    }
    return 0;
  }
  
  public static List<FaceParam> detectFacesByBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBitmap == null) {
      return localArrayList;
    }
    TTpicBitmapFaceDetect localTTpicBitmapFaceDetect = new TTpicBitmapFaceDetect();
    localTTpicBitmapFaceDetect.needDetectFaceFeatures(paramBoolean);
    localTTpicBitmapFaceDetect.detectFace(paramBitmap);
    if (localTTpicBitmapFaceDetect.detectedFace())
    {
      int i = 0;
      while (i < localTTpicBitmapFaceDetect.getFaceCount())
      {
        localArrayList.add(localTTpicBitmapFaceDetect.getFaceParams(i));
        i += 1;
      }
    }
    if ((localTTpicBitmapFaceDetect instanceof TTpicBitmapFaceDetect)) {
      localTTpicBitmapFaceDetect.destroy();
    }
    return localArrayList;
  }
  
  private static int distance(Point paramPoint1, Point paramPoint2)
  {
    return (int)Math.sqrt(Math.abs(paramPoint1.x - paramPoint2.x) * Math.abs(paramPoint1.x - paramPoint2.x) + Math.abs(paramPoint1.y - paramPoint2.y) * Math.abs(paramPoint1.y - paramPoint2.y));
  }
  
  private static List<List<PointF>> doFaceDetect(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = detectFacesByBitmap(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), true);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(facePointf83to90(outline2Points(((FaceParam)((Iterator)localObject).next()).mFaceOutline)));
    }
    return localArrayList;
  }
  
  public static List<List<PointF>> doFaceDetect(Bitmap paramBitmap)
  {
    Object localObject = detectFacesByBitmap(paramBitmap, true);
    paramBitmap = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBitmap.add(facePointf83to90(outline2Points(((FaceParam)((Iterator)localObject).next()).mFaceOutline)));
    }
    return paramBitmap;
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, int paramInt)
  {
    return doPicFaceDetect(paramBitmap, true, true, paramInt);
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, boolean paramBoolean)
  {
    return doPicFaceDetect(paramBitmap, paramBoolean, true, -1);
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    Object localObject;
    if (canUseTTPicDetect())
    {
      localObject = new TTpicBitmapFaceDetect();
      ((FaceDetect)localObject).needDetectFaceFeatures(paramBoolean1);
      ((FaceDetect)localObject).needDetectFaceGender(paramBoolean2);
      ((FaceDetect)localObject).detectFace(paramBitmap);
      if (((FaceDetect)localObject).detectedFace()) {
        localArrayList.addAll(pickAvailableFaces((FaceDetect)localObject, paramInt));
      }
      if (!(localObject instanceof TTpicBitmapFaceDetect)) {
        break label108;
      }
      ((TTpicBitmapFaceDetect)localObject).destroy();
    }
    for (;;)
    {
      return localArrayList;
      localObject = new AndroidFaceDetect();
      break;
      label108:
      ((FaceDetect)localObject).release();
    }
  }
  
  public static List<FaceParam> doPicFaceDetectbyManual(Bitmap paramBitmap, Point paramPoint1, Point paramPoint2)
  {
    return doPicFaceDetectbyManual(paramBitmap, null, paramPoint1, paramPoint2);
  }
  
  public static List<FaceParam> doPicFaceDetectbyManual(Bitmap paramBitmap, Rect paramRect, Point paramPoint1, Point paramPoint2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    TTpicBitmapFaceDetect localTTpicBitmapFaceDetect = new TTpicBitmapFaceDetect();
    localTTpicBitmapFaceDetect.needDetectFaceFeatures(true);
    localTTpicBitmapFaceDetect.needDetectFaceGender(true);
    localTTpicBitmapFaceDetect.detectFaceByManual(paramBitmap, paramRect, paramPoint1, paramPoint2);
    int i = 0;
    while (i < localTTpicBitmapFaceDetect.getFaceCount())
    {
      localArrayList.add(localTTpicBitmapFaceDetect.getFaceParams(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<PointF> facePointf83to90(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 83)) {
      return paramList;
    }
    while (paramList.size() < 90) {
      paramList.add(new PointF());
    }
    while (paramList.size() > 90) {
      paramList.remove(paramList.size() - 1);
    }
    PointF localPointF = (PointF)paramList.get(83);
    float f = ((PointF)paramList.get(55)).x;
    localPointF.x = ((((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(83);
    f = ((PointF)paramList.get(55)).y;
    localPointF.y = ((((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(84);
    f = ((PointF)paramList.get(23)).x;
    localPointF.x = ((((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(84);
    f = ((PointF)paramList.get(23)).y;
    localPointF.y = ((((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(85);
    f = ((PointF)paramList.get(59)).x;
    localPointF.x = ((((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(85);
    f = ((PointF)paramList.get(59)).y;
    localPointF.y = ((((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(86);
    f = ((PointF)paramList.get(35)).x;
    localPointF.x = (((PointF)paramList.get(35)).x - ((PointF)paramList.get(6)).x + f);
    localPointF = (PointF)paramList.get(86);
    f = ((PointF)paramList.get(35)).y;
    localPointF.y = (((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f);
    localPointF = (PointF)paramList.get(87);
    f = ((PointF)paramList.get(64)).x;
    localPointF.x = ((((PointF)paramList.get(64)).x - ((PointF)paramList.get(9)).x) * 1.4F + f);
    localPointF = (PointF)paramList.get(87);
    f = ((PointF)paramList.get(64)).y;
    localPointF.y = ((((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f);
    localPointF = (PointF)paramList.get(88);
    f = ((PointF)paramList.get(45)).x;
    localPointF.x = (((PointF)paramList.get(45)).x - ((PointF)paramList.get(12)).x + f);
    localPointF = (PointF)paramList.get(88);
    f = ((PointF)paramList.get(45)).y;
    localPointF.y = (((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f);
    localPointF = (PointF)paramList.get(89);
    f = ((PointF)paramList.get(83)).x;
    localPointF.x = (((PointF)paramList.get(83)).x - ((PointF)paramList.get(59)).x + f);
    localPointF = (PointF)paramList.get(89);
    f = ((PointF)paramList.get(83)).y;
    localPointF.y = (((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f);
    return paramList;
  }
  
  public static PointF[] flatArray2Points(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    PointF[] arrayOfPointF = new PointF[paramArrayOfFloat.length / 2];
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      arrayOfPointF[i] = new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]);
      i += 1;
    }
    return arrayOfPointF;
  }
  
  public static PTFaceAttr genFaceAttr(List<TTFaceOriginDataModel> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TTFaceOriginDataModel)((Iterator)localObject1).next();
      localObject3 = new float['¼'];
      int i = 0;
      while (i < 67)
      {
        localObject3[(i * 2)] = localObject2.facePoint[(i + 21)][0];
        localObject3[(i * 2 + 1)] = localObject2.facePoint[(i + 21)][1];
        i += 1;
      }
      i = 67;
      while (i < 88)
      {
        localObject3[(i * 2)] = localObject2.facePoint[(i - 67)][0];
        localObject3[(i * 2 + 1)] = localObject2.facePoint[(i - 67)][1];
        i += 1;
      }
      i = 88;
      while (i < 94)
      {
        localObject3[(i * 2)] = localObject2.facePoint[i][0];
        localObject3[(i * 2 + 1)] = localObject2.facePoint[i][1];
        i += 1;
      }
      localObject4 = new FaceInfo();
      ((FaceInfo)localObject4).points = YoutuPointsUtil.transformYTPointsToPtuPoints((float[])localObject3);
      ((FaceInfo)localObject4).irisPoints = YoutuPointsUtil.getIrisPoints((float[])localObject3);
      ((FaceInfo)localObject4).pointsVis = YoutuPointsUtil.transformYTPointsVisToPtuPoints(((TTFaceOriginDataModel)localObject2).facePointVisible);
      ((FaceInfo)localObject4).pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(((FaceInfo)localObject4).pointsVis);
      ((FaceInfo)localObject4).angles[0] = ((float)(((TTFaceOriginDataModel)localObject2).pitch * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject4).angles[1] = ((float)(((TTFaceOriginDataModel)localObject2).yaw * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject4).angles[2] = ((float)(((TTFaceOriginDataModel)localObject2).roll * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject4).pitch = ((TTFaceOriginDataModel)localObject2).pitch;
      ((FaceInfo)localObject4).yaw = ((TTFaceOriginDataModel)localObject2).yaw;
      ((FaceInfo)localObject4).roll = ((TTFaceOriginDataModel)localObject2).roll;
      ((FaceInfo)localObject4).scale = 0.0F;
      ((FaceInfo)localObject4).tx = 0.0F;
      ((FaceInfo)localObject4).ty = 0.0F;
      ((FaceInfo)localObject4).denseFaceModel = null;
      ((FaceInfo)localObject4).transform = null;
      ((FaceInfo)localObject4).expressionWeights = null;
      ((FaceInfo)localObject4).gender = GenderType.FEMALE.value;
      localArrayList.add(localObject4);
    }
    Object localObject7 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashSet();
    Object localObject4 = new HashMap();
    ((Set)localObject3).add(Integer.valueOf(1));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
      ((List)localObject7).add(localFaceInfo.points);
      ((List)localObject6).add(localFaceInfo.irisPoints);
      ((List)localObject1).add(localFaceInfo.pointsVis);
      ((List)localObject5).add(localFaceInfo.angles);
      FaceStatus localFaceStatus = new FaceStatus();
      localFaceStatus.pitch = localFaceInfo.pitch;
      localFaceStatus.yaw = localFaceInfo.yaw;
      localFaceStatus.roll = localFaceInfo.roll;
      localFaceStatus.tx = localFaceInfo.tx;
      localFaceStatus.ty = localFaceInfo.ty;
      localFaceStatus.scale = localFaceInfo.scale;
      localFaceStatus.denseFaceModel = localFaceInfo.denseFaceModel;
      localFaceStatus.transform = localFaceInfo.transform;
      localFaceStatus.expressionWeights = localFaceInfo.expressionWeights;
      localFaceStatus.eyeRollWeights = localFaceInfo.eyeRollWeights;
      localFaceStatus.gender = localFaceInfo.gender;
      localFaceStatus.age = localFaceInfo.age;
      localFaceStatus.faceID = localFaceInfo.faceId;
      localFaceStatus.eyeEulerAngle = localFaceInfo.eyeEulerAngle;
      ((List)localObject2).add(localFaceStatus);
    }
    localObject7 = AlgoUtils.rotatePointsForList((List)localObject7, paramInt1, paramInt2, paramInt3);
    localObject6 = AlgoUtils.rotatePointsForList((List)localObject6, paramInt1, paramInt2, paramInt3);
    localObject5 = AlgoUtils.rotateAngles((List)localObject5, -paramInt3);
    if (paramList.size() > 0)
    {
      ((Set)localObject3).add(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value));
      ((Map)localObject4).put(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value), new FaceActionCounter(1, System.currentTimeMillis()));
    }
    paramList = Pair.create(Integer.valueOf(255), null);
    return new PTFaceAttr(new PTFaceAttr.Builder().facePoints((List)localObject7).irisPoints((List)localObject6).faceAngles((List)localObject5).pointsVis((List)localObject1).faceInfoList(localArrayList).histogram(paramList).faceStatusList((List)localObject2).faceActionCounter((Map)localObject4).triggeredExpression((Set)localObject3).faceDetectScale(1.0D).timeStamp(System.currentTimeMillis()).rotation(0).faceDetector(null));
  }
  
  public static void getAngleFromFaceParams(List<FaceParams> paramList, HashMap<FaceParam, float[]> paramHashMap)
  {
    if (paramHashMap == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramHashMap.put(((FaceParams)paramList.get(i)).getFaceParam(), ((FaceParams)paramList.get(i)).getFaceAngles());
        i += 1;
      }
    }
  }
  
  public static List<FaceParam> getFaceParamFromFaceParams(List<FaceParams> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((FaceParams)paramList.get(i)).getFaceParam());
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<List<PointF>> getPointsByFaceParamsList(List<FaceParam> paramList)
  {
    paramList = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramList.hasNext()) {
      localArrayList.add(facePointf83to90(outline2Points(((FaceParam)paramList.next()).mFaceOutline)));
    }
    return localArrayList;
  }
  
  public static List<PointF> outline2Points(int[][] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int[] arrayOfInt = paramArrayOfInt[i];
      localArrayList.add(new PointF(arrayOfInt[0], arrayOfInt[1]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<TTFaceOriginDataModel> parseOrigFaceDataModelJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return GsonUtils.json2ObjList(paramString, TTFaceOriginDataModel.class);
  }
  
  private static List<FaceParams> pickAvailableFaces(FaceDetect paramFaceDetect, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    FaceParams localFaceParams;
    if (i < paramFaceDetect.getFaceCount())
    {
      localFaceParams = new FaceParams();
      localFaceParams.setFaceParam(paramFaceDetect.getFaceParams(i));
      if ((paramInt != -1) || (checkLegalFace(localFaceParams.getFaceParam(), paramInt) != 1))
      {
        if (!(paramFaceDetect instanceof TTpicBitmapFaceDetect)) {
          break label91;
        }
        localFaceParams.setFaceAngles(((TTpicBitmapFaceDetect)paramFaceDetect).getFaceAngles(i));
      }
      for (;;)
      {
        localArrayList.add(localFaceParams);
        i += 1;
        break;
        label91:
        localFaceParams.setFaceAngles(new float[] { 0.0F, 0.0F, 0.0F });
      }
    }
    if ((localArrayList.isEmpty()) && (paramFaceDetect.getFaceCount() != 0))
    {
      localFaceParams = new FaceParams();
      localFaceParams.setFaceParam((FaceParam)paramFaceDetect.mFaceParams.get(0));
      if (!(paramFaceDetect instanceof TTpicBitmapFaceDetect)) {
        break label188;
      }
      localFaceParams.setFaceAngles(((TTpicBitmapFaceDetect)paramFaceDetect).getFaceAngles(0));
    }
    for (;;)
    {
      localArrayList.add(localFaceParams);
      return localArrayList;
      label188:
      localFaceParams.setFaceAngles(new float[] { 0.0F, 0.0F, 0.0F });
    }
  }
  
  public static PointF[] ulsee2Orig(PointF[] paramArrayOfPointF)
  {
    if (paramArrayOfPointF == null) {
      return null;
    }
    return new PointF[] { paramArrayOfPointF[0], AlgoUtils.middlePoint(paramArrayOfPointF[1], paramArrayOfPointF[2]), paramArrayOfPointF[3], AlgoUtils.middlePoint(paramArrayOfPointF[4], paramArrayOfPointF[5]), paramArrayOfPointF[6], paramArrayOfPointF[8], paramArrayOfPointF[10], paramArrayOfPointF[12], paramArrayOfPointF[14], paramArrayOfPointF[16], paramArrayOfPointF[18], paramArrayOfPointF[20], paramArrayOfPointF[22], paramArrayOfPointF[24], paramArrayOfPointF[26], AlgoUtils.middlePoint(paramArrayOfPointF[27], paramArrayOfPointF[28]), paramArrayOfPointF[29], AlgoUtils.middlePoint(paramArrayOfPointF[30], paramArrayOfPointF[31]), paramArrayOfPointF[32], paramArrayOfPointF[33], paramArrayOfPointF[64], paramArrayOfPointF[65], paramArrayOfPointF[66], paramArrayOfPointF[67], paramArrayOfPointF[36], paramArrayOfPointF[35], paramArrayOfPointF[34], paramArrayOfPointF[42], paramArrayOfPointF[71], paramArrayOfPointF[70], paramArrayOfPointF[69], paramArrayOfPointF[68], paramArrayOfPointF[39], paramArrayOfPointF[40], paramArrayOfPointF[41], paramArrayOfPointF[52], paramArrayOfPointF[57], paramArrayOfPointF[73], paramArrayOfPointF[56], paramArrayOfPointF[55], paramArrayOfPointF[54], paramArrayOfPointF[72], paramArrayOfPointF[53], paramArrayOfPointF[74], paramArrayOfPointF[104], paramArrayOfPointF[61], paramArrayOfPointF[62], paramArrayOfPointF[76], paramArrayOfPointF[63], paramArrayOfPointF[58], paramArrayOfPointF[59], paramArrayOfPointF[75], paramArrayOfPointF[60], paramArrayOfPointF[77], paramArrayOfPointF[105], paramArrayOfPointF[78], paramArrayOfPointF[80], paramArrayOfPointF[82], AlgoUtils.middlePoint(paramArrayOfPointF[47], paramArrayOfPointF[48]), paramArrayOfPointF[49], AlgoUtils.middlePoint(paramArrayOfPointF[50], paramArrayOfPointF[51]), paramArrayOfPointF[83], paramArrayOfPointF[81], paramArrayOfPointF[79], paramArrayOfPointF[46], paramArrayOfPointF[84], paramArrayOfPointF[90], paramArrayOfPointF[95], paramArrayOfPointF[94], paramArrayOfPointF[93], paramArrayOfPointF[92], paramArrayOfPointF[91], paramArrayOfPointF[101], paramArrayOfPointF[102], paramArrayOfPointF[103], paramArrayOfPointF[85], paramArrayOfPointF[86], paramArrayOfPointF[87], paramArrayOfPointF[88], paramArrayOfPointF[89], paramArrayOfPointF[99], paramArrayOfPointF[98], paramArrayOfPointF[97] };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FaceDetectUtil
 * JD-Core Version:    0.7.0.1
 */