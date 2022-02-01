package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;
import org.light.bean.TTFaceOriginDataModel;

public class TransformUtils
{
  private static final String TAG = "TransformUtils";
  
  public static float[] ConvertPointListToFloatArray(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    int j = paramList.size();
    float[] arrayOfFloat = new float[j * 2];
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[(i * 2)] = ((PointF)paramList.get(i)).x;
      arrayOfFloat[(i * 2 + 1)] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    return arrayOfFloat;
  }
  
  private static List<PointF> arrPointToList(float[] paramArrayOfFloat, float paramFloat)
  {
    int j = 0;
    Object localObject;
    if (paramArrayOfFloat == null)
    {
      localObject = new ArrayList();
      return localObject;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      paramArrayOfFloat[i] *= paramFloat;
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    i = j;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= paramArrayOfFloat.length / 2) {
        break;
      }
      localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
      i += 1;
    }
  }
  
  public static PTFaceAttr lightFaceToPTFaceAttr(LightFaceData paramLightFaceData)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if ((paramLightFaceData == null) || (paramLightFaceData.mLightFaceFeatureList == null)) {
      return new PTFaceAttr(new PTFaceAttr.Builder());
    }
    Object localObject2 = paramLightFaceData.mLightFaceFeatureList.iterator();
    float f2;
    for (float f1 = 1.0F; ((Iterator)localObject2).hasNext(); f1 = f2)
    {
      localObject3 = (LightFaceFeature)((Iterator)localObject2).next();
      localObject4 = ((LightFaceFeature)localObject3).mTTFaceOriginDataModel;
      localArrayList.add(localObject4);
      localObject5 = new FaceInfo();
      f2 = f1;
      if (paramLightFaceData.imageSize != null)
      {
        f2 = f1;
        if (paramLightFaceData.renderSize != null) {
          f2 = paramLightFaceData.renderSize[0] * 1.0F / paramLightFaceData.imageSize[0];
        }
      }
      ((FaceInfo)localObject5).points = arrPointToList(((LightFaceFeature)localObject3).facePoint90, f2);
      ((FaceInfo)localObject5).point94 = arrPointToList(((LightFaceFeature)localObject3).facePoints, f2);
      ((FaceInfo)localObject5).irisPoints = YoutuPointsUtil.getIrisPoints(((LightFaceFeature)localObject3).facePoint90);
      ((FaceInfo)localObject5).pointsVis = YoutuPointsUtil.transformYTPointsVisToPtuPoints(((LightFaceFeature)localObject3).facePoint90Visibility);
      ((FaceInfo)localObject5).pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(((FaceInfo)localObject5).pointsVis);
      ((FaceInfo)localObject5).angles[0] = ((TTFaceOriginDataModel)localObject4).pitch;
      ((FaceInfo)localObject5).angles[1] = ((TTFaceOriginDataModel)localObject4).yaw;
      ((FaceInfo)localObject5).angles[2] = ((TTFaceOriginDataModel)localObject4).roll;
      ((FaceInfo)localObject5).pitch = ((TTFaceOriginDataModel)localObject4).pitch;
      ((FaceInfo)localObject5).yaw = ((TTFaceOriginDataModel)localObject4).yaw;
      ((FaceInfo)localObject5).roll = ((TTFaceOriginDataModel)localObject4).roll;
      ((FaceInfo)localObject5).scale = 0.0F;
      ((FaceInfo)localObject5).tx = 0.0F;
      ((FaceInfo)localObject5).ty = 0.0F;
      ((FaceInfo)localObject5).denseFaceModel = null;
      ((FaceInfo)localObject5).transform = null;
      ((FaceInfo)localObject5).expressionWeights = null;
      ((FaceInfo)localObject5).gender = GenderType.FEMALE.value;
      ((List)localObject1).add(localObject5);
    }
    localArrayList = new ArrayList();
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    Object localObject5 = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(1));
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localArrayList.add(((FaceInfo)((List)localObject1).get(i)).points);
      i += 1;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      ((List)localObject2).add(((FaceInfo)((List)localObject1).get(i)).point94);
      i += 1;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      ((List)localObject3).add(((FaceInfo)((List)localObject1).get(i)).irisPoints);
      i += 1;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      ((List)localObject4).add(((FaceInfo)((List)localObject1).get(i)).pointsVis);
      i += 1;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      ((List)localObject5).add(((FaceInfo)((List)localObject1).get(i)).angles);
      i += 1;
    }
    localObject1 = new PTFaceAttr.Builder();
    ((PTFaceAttr.Builder)localObject1).facePoints(localArrayList).facePoint94((List)localObject2).irisPoints((List)localObject3).pointsVis((List)localObject4).faceAngles((List)localObject5).faceDetectScale(f1).triggeredExpression(localHashSet).faceDetWidth(paramLightFaceData.imageSize[0]).faceDetHeight(paramLightFaceData.imageSize[1]).data(paramLightFaceData.imageData).build();
    return new PTFaceAttr((PTFaceAttr.Builder)localObject1);
  }
  
  public static LightFaceData ptFaceAttrToLightFaceData(PTFaceAttr paramPTFaceAttr)
  {
    if (paramPTFaceAttr == null) {}
    while (paramPTFaceAttr.getAllFacePoints94() == null) {
      return null;
    }
    LightFaceData localLightFaceData = new LightFaceData();
    int j = paramPTFaceAttr.getAllFacePoints94().size();
    int i = 0;
    for (;;)
    {
      List localList;
      if (i < j)
      {
        localList = (List)paramPTFaceAttr.getAllFacePoints94().get(i);
        if (localList != null) {}
      }
      else
      {
        return localLightFaceData;
      }
      Object localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PointF)((Iterator)localObject1).next();
        ((PointF)localObject2).x /= (float)paramPTFaceAttr.getFaceDetectScale();
        ((PointF)localObject2).y /= (float)paramPTFaceAttr.getFaceDetectScale();
      }
      localObject1 = (float[])paramPTFaceAttr.getAllFaceAngles().get(i);
      Object localObject2 = new LightFaceFeature();
      ((LightFaceFeature)localObject2).facePoints = ConvertPointListToFloatArray(localList);
      ((LightFaceFeature)localObject2).facePoint83 = ConvertPointListToFloatArray(YoutuPointsUtil.transform90PointsTo83(ConvertPointListToFloatArray(localList)));
      Arrays.fill(((LightFaceFeature)localObject2).facePointsVisible, 1.0F);
      Arrays.fill(((LightFaceFeature)localObject2).facePoint83Visibility, 1.0F);
      if (localObject1 != null)
      {
        ((LightFaceFeature)localObject2).pitch = localObject1[0];
        ((LightFaceFeature)localObject2).yaw = localObject1[1];
        ((LightFaceFeature)localObject2).roll = localObject1[2];
      }
      localLightFaceData.mLightFaceFeatureList.add(localObject2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.TransformUtils
 * JD-Core Version:    0.7.0.1
 */