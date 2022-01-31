package com.tencent.qqmini.sdk.core.plugins;

import bglv;
import bgmm;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NativeFeatureJsPlugin";
  
  public void invokeNativePlugin(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.b).optString("api_name", null);
      this.mMiniAppContext.a(bgmm.a(parambgok, str));
      return;
    }
    catch (Throwable parambgok)
    {
      QMLog.e("NativeFeatureJsPlugin", "invokeNativePlugin err", parambgok);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */