package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunDownloadFilePlugin
  implements NativePlugin
{
  private static final String ACTION_CANCEL_DOWNLOAD_TASK = "cancelDownloadTask";
  private static final String ACTION_CREATE_DOWNLOAD_TASK = "createDownloadTask";
  private static final String ACTION_PAUSE_DOWNLOAD_TASK = "pauseDownloadTask";
  public static final String TAG = "[mini] WeiyunDownloadFilePlugin";
  private NativePlugin.JSContext mJSContext;
  private WeiyunNativeBusiness.WeiyunDownloadBussiness mWeiyunDownloadBussiness;
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    JSONObject localJSONObject;
    try
    {
      this.mJSContext = paramJSContext;
      localJSONObject = new JSONObject(paramJSONObject.optString("data"));
      paramJSONObject = localJSONObject.getString("action");
      if ((TextUtils.isEmpty(paramJSONObject)) || ((!paramJSONObject.equals("createDownloadTask")) && (!paramJSONObject.equals("pauseDownloadTask")) && (!paramJSONObject.equals("cancelDownloadTask")))) {
        return;
      }
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "create weiyun Download");
      if (this.mWeiyunDownloadBussiness == null) {
        this.mWeiyunDownloadBussiness = new WeiyunNativeBusiness.WeiyunDownloadBussiness();
      }
      localJSONObject = new JSONObject(localJSONObject.getString("data"));
      if (paramJSONObject.equals("createDownloadTask"))
      {
        if (this.mWeiyunDownloadBussiness.isLegal(localJSONObject))
        {
          this.mWeiyunDownloadBussiness.doDownloadWeiyun(localJSONObject, localJSONObject.getString("file_id"), paramJSContext);
          paramJSContext.evaluateCallback(true, null, "");
          return;
        }
        paramJSContext.evaluateCallback(false, null, "download params illegal.");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    if (paramJSONObject.equals("pauseDownloadTask"))
    {
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "pause weiyun Download");
      this.mWeiyunDownloadBussiness.pause(localJSONObject.getString("file_id"), paramJSContext);
      return;
    }
    if (paramJSONObject.equals("cancelDownloadTask"))
    {
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "cacel weiyun Download");
      this.mWeiyunDownloadBussiness.cancel(localJSONObject.getString("file_id"), paramJSContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.WeiyunDownloadFilePlugin
 * JD-Core Version:    0.7.0.1
 */