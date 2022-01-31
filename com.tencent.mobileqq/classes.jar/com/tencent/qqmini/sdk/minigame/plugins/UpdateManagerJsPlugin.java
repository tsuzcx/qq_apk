package com.tencent.qqmini.sdk.minigame.plugins;

import begy;
import beka;
import besl;
import bevn;
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
  
  public void getUpdateManager(beka parambeka)
  {
    besl.a("UpdateManagerJsPlugin", "handleNativeRequest do nothing for " + parambeka.jdField_a_of_type_JavaLangString);
    parambeka.a();
    try
    {
      besl.a("UpdateManagerJsPlugin", "handleUpdateCheckResult() called with:  hasUpdate = [false]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", false);
      parambeka.jdField_a_of_type_Begy.a("onUpdateCheckResult", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("UpdateManagerJsPlugin", "handleNativeRequest", parambeka);
    }
  }
  
  public void onUpdateCheckResult(beka parambeka)
  {
    besl.c("UpdateManagerJsPlugin", "handleNativeRequest " + parambeka.jdField_a_of_type_JavaLangString + " should not send from JS");
  }
  
  public void onUpdateDownloadResult(beka parambeka)
  {
    besl.c("UpdateManagerJsPlugin", "handleNativeRequest " + parambeka.jdField_a_of_type_JavaLangString + " should not send from JS");
  }
  
  public void updateApp(beka parambeka)
  {
    bevn.a();
    besl.a("UpdateManagerJsPlugin", "handleNativeRequest " + parambeka.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.UpdateManagerJsPlugin
 * JD-Core Version:    0.7.0.1
 */