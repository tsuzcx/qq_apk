package com.tencent.qqmini.sdk.core.plugins;

import bgho;
import bgif;
import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NativeFeatureJsPlugin";
  
  public void invokeNativePlugin(bgkd parambgkd)
  {
    try
    {
      String str = new JSONObject(parambgkd.b).optString("api_name", null);
      this.mMiniAppContext.a(bgif.a(parambgkd, str));
      return;
    }
    catch (Throwable parambgkd)
    {
      QMLog.e("NativeFeatureJsPlugin", "invokeNativePlugin err", parambgkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */