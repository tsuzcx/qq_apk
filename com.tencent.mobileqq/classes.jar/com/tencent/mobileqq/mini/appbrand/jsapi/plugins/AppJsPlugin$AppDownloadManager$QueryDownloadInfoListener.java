package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import bmxp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

class AppJsPlugin$AppDownloadManager$QueryDownloadInfoListener
  implements bmxp
{
  private String mAppid;
  private AppJsPlugin.IWaldlCallback mCallback;
  
  public AppJsPlugin$AppDownloadManager$QueryDownloadInfoListener(AppJsPlugin.AppDownloadManager paramAppDownloadManager, String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
  {
    this.mAppid = paramString;
    this.mCallback = paramIWaldlCallback;
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13169");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    paramIntent = null;
    Object localObject = null;
    QLog.i("AppJsPlugin_AppDownloadManager", 1, "onCmdRsp ret=" + paramLong + ",cmd=" + paramString + ",dataJson=" + paramJSONObject);
    AppJsPlugin.IWaldlCallback localIWaldlCallback;
    if ("13169".equals(paramString))
    {
      try
      {
        localIWaldlCallback = this.mCallback;
        if (localIWaldlCallback == null) {
          return;
        }
        this.mCallback = null;
        if (paramLong != 0L)
        {
          localIWaldlCallback.onResult(false, null);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("AppJsPlugin_AppDownloadManager", 1, "exception. ", paramIntent);
        return;
      }
      paramString = localObject;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("v_appd_down_load_info");
        if (paramJSONObject == null) {
          break label186;
        }
        paramString = localObject;
        paramIntent = paramJSONObject.getJSONObject(0);
      }
      catch (Throwable paramIntent)
      {
        QLog.e("AppJsPlugin_AppDownloadManager", 1, "exception. ", paramIntent);
        if (paramString == null) {
          break label179;
        }
      }
      paramString = paramIntent;
      localIWaldlCallback.onResult(bool, paramIntent);
      return;
      boolean bool = true;
      label162:
      localIWaldlCallback.onResult(bool, paramString);
      return;
      label179:
      label186:
      do
      {
        bool = false;
        break;
        bool = false;
        break label162;
        return;
      } while (paramIntent == null);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.AppDownloadManager.QueryDownloadInfoListener
 * JD-Core Version:    0.7.0.1
 */