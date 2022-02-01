package org.light.detector;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.light.bean.LightFaceFeature;

public class LightFaceDetector
{
  private static final String DEVICE_CPU = "CPU";
  private static final String MODEL_KEY_ROOT = "face-root";
  private static final String TAG = "LightFaceDetector";
  private static String modelDir = "/sdcard/light_assets/models/LightFaceModel.bundle/";
  private GYAIFace gyaiFace = new GYAIFace();
  
  private List<LightFaceFeature> buildFaceList(FaceDetector paramFaceDetector)
  {
    if ((paramFaceDetector.faces != null) && (paramFaceDetector.faces.length != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramFaceDetector = paramFaceDetector.faces;
      int j = paramFaceDetector.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFaceDetector[i];
        LightFaceFeature localLightFaceFeature = new LightFaceFeature();
        localLightFaceFeature.faceBoundsRect[0] = localObject.boundsX;
        localLightFaceFeature.faceBoundsRect[1] = localObject.boundsY;
        localLightFaceFeature.faceBoundsRect[2] = localObject.boundsW;
        localLightFaceFeature.faceBoundsRect[3] = localObject.boundsH;
        localLightFaceFeature.yaw = localObject.yaw;
        localLightFaceFeature.roll = localObject.roll;
        localLightFaceFeature.pitch = localObject.pitch;
        System.arraycopy(localObject.fFeatures, 0, localLightFaceFeature.facePoint83, 0, 166);
        localArrayList.add(localLightFaceFeature);
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private SDKModelConfig buildModelConfig()
  {
    SDKModelConfig localSDKModelConfig = new SDKModelConfig();
    localSDKModelConfig.modelPaths = new HashMap();
    localSDKModelConfig.modelPaths.put("face-root", modelDir);
    return localSDKModelConfig;
  }
  
  private int initDevice()
  {
    SDKDeviceConfig localSDKDeviceConfig = new SDKDeviceConfig();
    localSDKDeviceConfig.setDevice("CPU");
    return this.gyaiFace.initInstance(localSDKDeviceConfig);
  }
  
  private int initModel()
  {
    SDKModelConfig localSDKModelConfig = buildModelConfig();
    return this.gyaiFace.setupWithModel(localSDKModelConfig);
  }
  
  private static void updateModelPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      modelDir = paramString;
    }
  }
  
  public int clear()
  {
    Object localObject = this.gyaiFace;
    if (localObject != null)
    {
      int i = ((GYAIFace)localObject).cleanupModelData();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clear ret:");
      ((StringBuilder)localObject).append(i);
      Log.i("LightFaceDetector", ((StringBuilder)localObject).toString());
      return i;
    }
    return 0;
  }
  
  public List<LightFaceFeature> detect(Bitmap paramBitmap, int paramInt)
  {
    if (this.gyaiFace != null)
    {
      FaceDetector localFaceDetector = new FaceDetector();
      this.gyaiFace.forwardDetect(paramBitmap, localFaceDetector, paramInt);
      return buildFaceList(localFaceDetector);
    }
    return null;
  }
  
  public int init()
  {
    this.gyaiFace = new GYAIFace();
    int i = initDevice();
    if (i != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDevice ret:");
      localStringBuilder.append(i);
      Log.e("LightFaceDetector", localStringBuilder.toString());
      return i;
    }
    i = initModel();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initModel ret:");
    localStringBuilder.append(i);
    Log.i("LightFaceDetector", localStringBuilder.toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.detector.LightFaceDetector
 * JD-Core Version:    0.7.0.1
 */