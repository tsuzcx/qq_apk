package com.tencent.qqmini.sdk.minigame.plugins;

import behp;
import bekr;
import betc;
import bewe;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateManagerJsPlugin
  extends BaseJsPlugin
{
  public static final String NATIVE_EVENT_NAME_GET_UPDATE_MANAGER = "getUpdateManager";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT = "onUpdateCheckResult";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT = "onUpdateDownloadResult";
  public static final String NATIVE_EVENT_NAME_UPDATE_APP = "updateApp";
  private static final String TAG = "UpdateManagerJsPlugin";
  
  public void getUpdateManager(bekr parambekr)
  {
    betc.a("UpdateManagerJsPlugin", "handleNativeRequest do nothing for " + parambekr.jdField_a_of_type_JavaLangString);
    parambekr.a();
    try
    {
      betc.a("UpdateManagerJsPlugin", "handleUpdateCheckResult() called with:  hasUpdate = [false]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", false);
      parambekr.jdField_a_of_type_Behp.a("onUpdateCheckResult", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException parambekr)
    {
      betc.d("UpdateManagerJsPlugin", "handleNativeRequest", parambekr);
    }
  }
  
  public void onUpdateCheckResult(bekr parambekr)
  {
    betc.c("UpdateManagerJsPlugin", "handleNativeRequest " + parambekr.jdField_a_of_type_JavaLangString + " should not send from JS");
  }
  
  public void onUpdateDownloadResult(bekr parambekr)
  {
    betc.c("UpdateManagerJsPlugin", "handleNativeRequest " + parambekr.jdField_a_of_type_JavaLangString + " should not send from JS");
  }
  
  public void updateApp(bekr parambekr)
  {
    bewe.a();
    betc.a("UpdateManagerJsPlugin", "handleNativeRequest " + parambekr.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.UpdateManagerJsPlugin
 * JD-Core Version:    0.7.0.1
 */