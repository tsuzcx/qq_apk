package com.tencent.viola.nativevue;

import android.text.TextUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import org.json.JSONObject;

public class NativeVueEngine
{
  public static String CURRENT_URL = null;
  private static final String TAG = "NativeVueEngine";
  
  private native boolean initNaive(String paramString1, String paramString2);
  
  private static void logD(String paramString)
  {
    ViolaLogUtils.d("NativeVueEngine", paramString);
  }
  
  private static void logE(String paramString)
  {
    ViolaUtils.reportNVError(paramString, CURRENT_URL);
    ViolaLogUtils.e("NativeVueEngine", paramString);
  }
  
  public native String createDom(String paramString1, String paramString2);
  
  public boolean init(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return initNaive(paramString1, paramString2);
  }
  
  public boolean init(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    return initNaive("violaEnv", paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.nativevue.NativeVueEngine
 * JD-Core Version:    0.7.0.1
 */