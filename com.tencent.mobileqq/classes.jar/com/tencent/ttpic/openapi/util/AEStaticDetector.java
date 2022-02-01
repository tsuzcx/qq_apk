package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.TransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;

public class AEStaticDetector
{
  private static final String TAG = "AEStaticDetector";
  private static String modelPath = "";
  
  public static PTFaceAttr detectFace(Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(modelPath))
    {
      LogUtils.e("AEStaticDetector", "face detect not init model path empty.");
      return null;
    }
    GYAIFace localGYAIFace = new GYAIFace();
    int i = initFaceDetect(localGYAIFace);
    if (i != 0)
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("init face error code: ");
      paramBitmap.append(i);
      LogUtils.e("AEStaticDetector", paramBitmap.toString());
      return null;
    }
    Object localObject2 = new FaceDetector();
    i = localGYAIFace.forwardDetect(paramBitmap, (FaceDetector)localObject2, 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("detect face code: ");
    ((StringBuilder)localObject1).append(i);
    LogUtils.d("AEStaticDetector", ((StringBuilder)localObject1).toString());
    if (((FaceDetector)localObject2).faces != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("face cnt ");
      ((StringBuilder)localObject1).append(((FaceDetector)localObject2).faces.length);
      LogUtils.d("AEStaticDetector", ((StringBuilder)localObject1).toString());
      localObject1 = new int[2];
      localObject1[0] = paramBitmap.getWidth();
      localObject1[1] = paramBitmap.getHeight();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      localByteArrayOutputStream.toByteArray();
      paramBitmap = new LightFaceData((int[])localObject1, (int[])localObject1, (int[])localObject1);
      localObject1 = new ArrayList();
      localObject2 = ((FaceDetector)localObject2).faces;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localByteArrayOutputStream = localObject2[i];
        float[] arrayOfFloat1 = new float['¼'];
        float[] arrayOfFloat2 = new float[94];
        System.arraycopy(localByteArrayOutputStream.pointsVisibility, 0, arrayOfFloat2, 0, localByteArrayOutputStream.pointsVisibility.length);
        float[] arrayOfFloat3 = new float['´'];
        float[] arrayOfFloat4 = new float[90];
        System.arraycopy(YoutuPointsUtil.transform83PointsTo90(localByteArrayOutputStream.fFeatures), 0, arrayOfFloat3, 0, 180);
        System.arraycopy(arrayOfFloat2, 0, arrayOfFloat4, 0, 90);
        float f1 = localByteArrayOutputStream.imageWidth;
        float f2 = localByteArrayOutputStream.imageHeight;
        float f3 = localByteArrayOutputStream.boundsX;
        float f4 = localByteArrayOutputStream.boundsY;
        float f5 = localByteArrayOutputStream.boundsW;
        float f6 = localByteArrayOutputStream.boundsH;
        float f7 = localByteArrayOutputStream.leBoundsX;
        float f8 = localByteArrayOutputStream.leBoundsY;
        float f9 = localByteArrayOutputStream.leBoundsW;
        float f10 = localByteArrayOutputStream.leBoundsH;
        float f11 = localByteArrayOutputStream.reBoundsX;
        float f12 = localByteArrayOutputStream.reBoundsY;
        float f13 = localByteArrayOutputStream.reBoundsW;
        float f14 = localByteArrayOutputStream.reBoundsH;
        float f15 = localByteArrayOutputStream.mouthBoundsX;
        float f16 = localByteArrayOutputStream.mouthBoundsY;
        float f17 = localByteArrayOutputStream.mouthBoundsW;
        float f18 = localByteArrayOutputStream.mouthBoundsH;
        float f19 = localByteArrayOutputStream.pitch;
        float f20 = localByteArrayOutputStream.yaw;
        float f21 = localByteArrayOutputStream.roll;
        ((List)localObject1).add(new LightFaceFeature(new float[] { f1, f2 }, new float[] { f3, f4, f5, f6 }, new float[] { f7, f8, f9, f10 }, new float[] { f11, f12, f13, f14 }, new float[] { f15, f16, f17, f18 }, f19, f20, f21, true, "", arrayOfFloat1, arrayOfFloat2, null, null, arrayOfFloat3, arrayOfFloat4, null, null, null, null, null));
        i += 1;
      }
      paramBitmap.mLightFaceFeatureList = ((List)localObject1);
      localGYAIFace.cleanupModelData();
      return TransformUtils.lightFaceToPTFaceAttr(paramBitmap);
    }
    return null;
  }
  
  public static boolean hasFaceData(PTFaceAttr paramPTFaceAttr)
  {
    return (paramPTFaceAttr != null) && (paramPTFaceAttr.getFaceCount() > 0);
  }
  
  public static void initDetector(String paramString)
  {
    modelPath = paramString;
  }
  
  private static int initFaceDetect(GYAIFace paramGYAIFace)
  {
    Object localObject = new SDKDeviceConfig();
    ((SDKDeviceConfig)localObject).setDevice("CPU");
    int i = paramGYAIFace.initInstance((SDKDeviceConfig)localObject);
    if (i != 0)
    {
      paramGYAIFace = new StringBuilder();
      paramGYAIFace.append("init face detect error code: ");
      paramGYAIFace.append(i);
      LogUtils.e("AEStaticDetector", paramGYAIFace.toString());
      return i;
    }
    localObject = new SDKModelConfig();
    ((SDKModelConfig)localObject).modelPaths = new HashMap();
    Map localMap = ((SDKModelConfig)localObject).modelPaths;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(modelPath);
    localStringBuilder.append("LightFaceModel.bundle");
    localMap.put("face-dir", localStringBuilder.toString());
    localMap = ((SDKModelConfig)localObject).modelPaths;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(modelPath);
    localStringBuilder.append("LightFaceModel.bundle/face-detection-v535");
    localMap.put("face-detector", localStringBuilder.toString());
    localMap = ((SDKModelConfig)localObject).modelPaths;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(modelPath);
    localStringBuilder.append("LightFaceModel.bundle/face-alignment-v360");
    localMap.put("face-alignment", localStringBuilder.toString());
    return paramGYAIFace.setupWithModel((SDKModelConfig)localObject);
  }
  
  private static void pointToRect(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramArrayOfFloat[0] = paramInt1;
    paramArrayOfFloat[1] = paramInt2;
    paramArrayOfFloat[2] = paramInt3;
    paramArrayOfFloat[3] = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AEStaticDetector
 * JD-Core Version:    0.7.0.1
 */