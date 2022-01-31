package com.tencent.qqmini.sdk.minigame.plugins;

import bglu;
import bgok;
import bgzg;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
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
  
  public void getUpdateManager(bgok parambgok)
  {
    QMLog.d("UpdateManagerJsPlugin", "handleNativeRequest do nothing for " + parambgok.jdField_a_of_type_JavaLangString);
    parambgok.a();
    try
    {
      QMLog.d("UpdateManagerJsPlugin", "handleUpdateCheckResult() called with:  hasUpdate = [false]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", false);
      parambgok.jdField_a_of_type_Bglu.a("onUpdateCheckResult", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException parambgok)
    {
      QMLog.e("UpdateManagerJsPlugin", "handleNativeRequest", parambgok);
    }
  }
  
  public void onUpdateCheckResult(bgok parambgok)
  {
    QMLog.w("UpdateManagerJsPlugin", "handleNativeRequest " + parambgok.jdField_a_of_type_JavaLangString + " should not send from JS");
  }
  
  public void onUpdateDownloadResult(bgok parambgok)
  {
    QMLog.w("UpdateManagerJsPlugin", "handleNativeRequest " + parambgok.jdField_a_of_type_JavaLangString + " should not send from JS");
  }
  
  public void updateApp(bgok parambgok)
  {
    bgzg.a();
    QMLog.d("UpdateManagerJsPlugin", "handleNativeRequest " + parambgok.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.UpdateManagerJsPlugin
 * JD-Core Version:    0.7.0.1
 */