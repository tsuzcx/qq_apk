package org.light.detector;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.gyailib.library.GYAIFaceClassify;
import com.gyailib.library.GYDetectCommonItemParams;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import java.util.HashMap;
import java.util.Map;

public class LightFaceClassifier
{
  private static final String DEVICE_ARM = "ARM";
  private static final String MODEL_KEY = "root-path";
  private static final String TAG = "LightFaceClassifier";
  private static String modelDir = "/sdcard/light_assets/models/LightFaceClassify.bundle";
  private GYAIFaceClassify mFaceClassify;
  
  private SDKModelConfig buildModelConfig()
  {
    SDKModelConfig localSDKModelConfig = new SDKModelConfig();
    localSDKModelConfig.modelPaths = new HashMap();
    localSDKModelConfig.modelPaths.put("root-path", modelDir);
    return localSDKModelConfig;
  }
  
  private int initDevice()
  {
    SDKDeviceConfig localSDKDeviceConfig = new SDKDeviceConfig();
    localSDKDeviceConfig.setDevice("ARM");
    return this.mFaceClassify.initInstance(localSDKDeviceConfig);
  }
  
  private int initModel()
  {
    SDKModelConfig localSDKModelConfig = buildModelConfig();
    return this.mFaceClassify.setupWithModel(localSDKModelConfig);
  }
  
  public static void setModelDir(String paramString)
  {
    modelDir = paramString;
  }
  
  public int clear()
  {
    Object localObject = this.mFaceClassify;
    if (localObject != null)
    {
      int i = ((GYAIFaceClassify)localObject).cleanupModelData();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clear ret:");
      ((StringBuilder)localObject).append(i);
      Log.i("LightFaceClassifier", ((StringBuilder)localObject).toString());
      return i;
    }
    return 0;
  }
  
  public boolean detect(Bitmap paramBitmap, Rect paramRect, float[] paramArrayOfFloat, int paramInt)
  {
    if (this.mFaceClassify != null)
    {
      GYDetectCommonResultStruct localGYDetectCommonResultStruct = new GYDetectCommonResultStruct();
      this.mFaceClassify.forwardDetect(paramBitmap, paramRect, paramArrayOfFloat, localGYDetectCommonResultStruct, paramInt);
      if ((localGYDetectCommonResultStruct.items != null) && (localGYDetectCommonResultStruct.items.length > 0) && (localGYDetectCommonResultStruct.items[0] != null) && (localGYDetectCommonResultStruct.items[0].index == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public int init()
  {
    this.mFaceClassify = new GYAIFaceClassify();
    int i = initDevice();
    if (i != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDevice ret:");
      localStringBuilder.append(i);
      Log.e("LightFaceClassifier", localStringBuilder.toString());
      return i;
    }
    i = initModel();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initModel ret:");
    localStringBuilder.append(i);
    Log.i("LightFaceClassifier", localStringBuilder.toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.detector.LightFaceClassifier
 * JD-Core Version:    0.7.0.1
 */