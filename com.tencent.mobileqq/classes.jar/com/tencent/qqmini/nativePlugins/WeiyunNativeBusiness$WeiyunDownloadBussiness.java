package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunNativeBusiness$WeiyunDownloadBussiness
{
  public static String a;
  private WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule b;
  
  public WeiyunNativeBusiness$WeiyunDownloadBussiness(IMiniAppContext paramIMiniAppContext)
  {
    a = BaseApplicationImpl.getApplication().getQQProcessName();
    this.b = WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.a();
    WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule localWeiyunDownloadClientQIPCModule = this.b;
    if (localWeiyunDownloadClientQIPCModule != null) {
      localWeiyunDownloadClientQIPCModule.a(paramIMiniAppContext);
    }
  }
  
  protected void a(String paramString, RequestEvent paramRequestEvent)
  {
    this.b.a(paramRequestEvent);
    paramRequestEvent = new Bundle();
    paramRequestEvent.putString("downloadId", paramString);
    QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Pause", paramRequestEvent, null);
  }
  
  protected void a(JSONObject paramJSONObject, String paramString, RequestEvent paramRequestEvent)
  {
    this.b.a(paramRequestEvent);
    try
    {
      this.b.a(paramString);
      paramRequestEvent = new Bundle();
      paramRequestEvent.putString("downloadId", paramString);
      paramRequestEvent.putString("process", a);
      paramRequestEvent.putString("file_id", (String)paramJSONObject.get("file_id"));
      paramRequestEvent.putString("filename", (String)paramJSONObject.get("filename"));
      paramRequestEvent.putString("pdir_key", (String)paramJSONObject.get("pdir_key"));
      QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Download", paramRequestEvent, null);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramJSONObject.getString("file_id")))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramJSONObject.getString("filename")))
        {
          boolean bool3 = TextUtils.isEmpty(paramJSONObject.getString("pdir_key"));
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (JSONException paramJSONObject) {}
    return false;
  }
  
  protected void b(String paramString, RequestEvent paramRequestEvent)
  {
    this.b.a(paramRequestEvent);
    this.b.b(paramString);
    paramRequestEvent = new Bundle();
    paramRequestEvent.putString("downloadId", paramString);
    QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Cancel", paramRequestEvent, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.WeiyunNativeBusiness.WeiyunDownloadBussiness
 * JD-Core Version:    0.7.0.1
 */