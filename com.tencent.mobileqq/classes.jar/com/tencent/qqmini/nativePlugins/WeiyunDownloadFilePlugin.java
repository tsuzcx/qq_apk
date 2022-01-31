package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import bgok;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunDownloadFilePlugin
  extends BaseJsPlugin
{
  private static final String ACTION_CANCEL_DOWNLOAD_TASK = "cancelDownloadTask";
  private static final String ACTION_CREATE_DOWNLOAD_TASK = "createDownloadTask";
  private static final String ACTION_PAUSE_DOWNLOAD_TASK = "pauseDownloadTask";
  public static final String TAG = "[mini] WeiyunDownloadFilePlugin";
  private WeiyunNativeBusiness.WeiyunDownloadBussiness mWeiyunDownloadBussiness;
  
  private JSONObject getParam(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("[mini] WeiyunDownloadFilePlugin", "Failed to parse jsonParams=" + parambgok.b);
    }
    return null;
  }
  
  public void weiyunDownload(bgok parambgok)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      localJSONObject = new JSONObject(getParam(parambgok).optString("data"));
      str = localJSONObject.getString("action");
      if ((TextUtils.isEmpty(str)) || ((!str.equals("createDownloadTask")) && (!str.equals("pauseDownloadTask")) && (!str.equals("cancelDownloadTask")))) {
        return;
      }
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "create weiyun Download");
      if (this.mWeiyunDownloadBussiness == null) {
        this.mWeiyunDownloadBussiness = new WeiyunNativeBusiness.WeiyunDownloadBussiness();
      }
      localJSONObject = new JSONObject(localJSONObject.getString("data"));
      if (str.equals("createDownloadTask"))
      {
        if (this.mWeiyunDownloadBussiness.isLegal(localJSONObject))
        {
          this.mWeiyunDownloadBussiness.doDownloadWeiyun(localJSONObject, localJSONObject.getString("file_id"), parambgok);
          parambgok.a();
          return;
        }
        parambgok.a("download params illegal.");
        return;
      }
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
      return;
    }
    if (str.equals("pauseDownloadTask"))
    {
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "pause weiyun Download");
      this.mWeiyunDownloadBussiness.pause(localJSONObject.getString("file_id"), parambgok);
      return;
    }
    if (str.equals("cancelDownloadTask"))
    {
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "cacel weiyun Download");
      this.mWeiyunDownloadBussiness.cancel(localJSONObject.getString("file_id"), parambgok);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.WeiyunDownloadFilePlugin
 * JD-Core Version:    0.7.0.1
 */