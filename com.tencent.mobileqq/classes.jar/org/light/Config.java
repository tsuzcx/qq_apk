package org.light;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.bean.LightAIDataWrapper;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;
import org.light.callback.ExternalRenderCallback;
import org.light.device.LightDeviceUtils;
import org.light.listener.IOnClickWatermarkListener;
import org.light.listener.OnGetQQNumberEventListener;
import org.light.listener.WatermarkDelegate;
import org.light.utils.LightLogUtil;

public class Config
{
  private static final String ML_AND_MIDDLE = "middle";
  private static final String ML_AND_SMALL = "low";
  private static final String ML_HIGH = "high";
  private static final String ML_LOW = "low";
  private static final String ML_VERY_HIGH = "veryhigh";
  private Context appContext = null;
  protected long nativeHandle = 0L;
  
  private String aiModelLevelByDefault()
  {
    if (getPhonePrefLevel() >= 5) {
      return "high";
    }
    return "low";
  }
  
  private String aiModelLevelForBgSegAgent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "veryhigh";
    }
    if (!Build.BRAND.toLowerCase().startsWith("huawei"))
    {
      if (Build.BRAND.toLowerCase().startsWith("honor")) {
        return "low";
      }
      int i = getPhonePrefLevel();
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if ((i != 4) && (i != 5)) {
            return "middle";
          }
          return "high";
        }
        return "middle";
      }
    }
    return "low";
  }
  
  private int getPhonePrefLevel()
  {
    try
    {
      if (this.appContext == null) {
        this.appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      }
      int i = LightDeviceUtils.getPhonePerfLevel(this.appContext);
      return i;
    }
    catch (Exception localException)
    {
      LightLogUtil.e(localException);
    }
    return 3;
  }
  
  private native String nativeGetConfigData();
  
  private native void nativeSetConfigData(String paramString);
  
  protected void finalize()
  {
    super.finalize();
  }
  
  public HashMap<String, String> getConfigData()
  {
    localHashMap = new HashMap();
    Object localObject = nativeGetConfigData();
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, ((JSONObject)localObject).getString(str));
      }
      return localHashMap;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public native String getCurrentPerfReportData();
  
  public LightFaceData getFaceData()
  {
    LightFaceData localLightFaceData = nativeGetFaceData();
    if (localLightFaceData == null) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localLightFaceData.imageSize[0] * localLightFaceData.imageSize[1] * 4);
    nativeGetFaceImage(localByteBuffer);
    if (localByteBuffer != null)
    {
      localLightFaceData.imageByteBuffer = localByteBuffer;
      localLightFaceData.imageData = localByteBuffer.array();
    }
    localLightFaceData.mLightFaceFeatureList = getFaceFeature();
    return localLightFaceData;
  }
  
  public List<LightFaceFeature> getFaceFeature()
  {
    Object localObject = new ArrayList();
    LightFaceFeature[] arrayOfLightFaceFeature = nativeGetFaceFeature();
    if (arrayOfLightFaceFeature != null) {
      localObject = Arrays.asList(arrayOfLightFaceFeature);
    }
    return localObject;
  }
  
  public native void nativeFinalize();
  
  public native LightAIDataWrapper nativeGetAIData(String[] paramArrayOfString, int paramInt);
  
  public native LightFaceData nativeGetFaceData();
  
  public native LightFaceFeature[] nativeGetFaceFeature();
  
  public native void nativeGetFaceImage(ByteBuffer paramByteBuffer);
  
  public native String nativeGetHandInfo();
  
  public native int[] nativeGetViewPoint();
  
  public native void nativeSetAIData(LightAIDataWrapper paramLightAIDataWrapper);
  
  public native void nativeSetFaceData(LightFaceData paramLightFaceData);
  
  public native void onLowMemory();
  
  public native void onPause();
  
  public native void onResume();
  
  public void registerFont(String paramString1, String paramString2, String paramString3)
  {
    LightEngine.RegisterFont(new FontAsset(paramString1, paramString2), paramString3);
  }
  
  public void setAIDataWrapper(LightAIDataWrapper paramLightAIDataWrapper)
  {
    nativeSetAIData(paramLightAIDataWrapper);
  }
  
  public void setConfigData(Map<String, String> paramMap)
  {
    long l1 = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    long l2 = System.currentTimeMillis();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      long l3 = System.currentTimeMillis();
      paramMap = localJSONObject.toString();
      long l4 = System.currentTimeMillis();
      Log.e("setConfigData", paramMap);
      nativeSetConfigData(paramMap);
      long l5 = System.currentTimeMillis();
      paramMap = new StringBuilder();
      paramMap.append("setConfigData cost time:");
      paramMap.append(l5 - l1);
      paramMap.append("\n[performance]setConfigData new JSONObject cost time:");
      paramMap.append(l2 - l1);
      paramMap.append("\n[performance]setConfigData entryset cost time:");
      paramMap.append(l3 - l2);
      paramMap.append("\n[performance]setConfigData json2string cost time:");
      paramMap.append(l4 - l3);
      paramMap.append("\n[performance]setConfigData  nativeSetConfigData cost time:");
      paramMap.append(l5 - l4);
      Log.i("[performance]", paramMap.toString());
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public native void setDetectShorterEdgeLength(int paramInt, String paramString);
  
  public native void setDowngradeStrategy(String paramString, int paramInt);
  
  public native void setExternalRenderCallback(ExternalRenderCallback paramExternalRenderCallback);
  
  public void setFaceData(LightFaceData paramLightFaceData)
  {
    if (paramLightFaceData != null) {
      nativeSetFaceData(paramLightFaceData);
    }
  }
  
  public native void setHorizontalFov(float paramFloat);
  
  public void setLightAIModelPath(String paramString1, String paramString2)
  {
    String str;
    if ("BG_SEG_AGENT".equals(paramString2)) {
      str = aiModelLevelForBgSegAgent(true);
    } else {
      str = aiModelLevelByDefault();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LEVEL :");
    localStringBuilder.append(str);
    Log.i("config phoneLevel", localStringBuilder.toString());
    setLightAIModelPath(paramString1, str, paramString2);
  }
  
  public native void setLightAIModelPath(String paramString1, String paramString2, String paramString3);
  
  public native void setLightBenchConfig(String paramString);
  
  public native void setLightBenchConfigWithValue(String paramString, float paramFloat);
  
  public native void setLightBenchEnable(boolean paramBoolean);
  
  public native void setLightBenchEnableWithValue(boolean paramBoolean, float paramFloat);
  
  public native void setOnClickWatermarkListener(IOnClickWatermarkListener paramIOnClickWatermarkListener);
  
  public void setOnGetQQNumberEventListener(OnGetQQNumberEventListener paramOnGetQQNumberEventListener) {}
  
  public native void setRenderSize(int paramInt1, int paramInt2);
  
  public native void setSyncMode(boolean paramBoolean);
  
  public native void setUseFenceForDetectDrawSync(boolean paramBoolean);
  
  public native void setWatermarkDelegate(String paramString, WatermarkDelegate paramWatermarkDelegate);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.Config
 * JD-Core Version:    0.7.0.1
 */