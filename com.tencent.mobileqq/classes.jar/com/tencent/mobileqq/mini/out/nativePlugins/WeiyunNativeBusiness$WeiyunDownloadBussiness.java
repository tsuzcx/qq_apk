package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunNativeBusiness$WeiyunDownloadBussiness
{
  private static final String TAG = "WeiyunNativeBusiness$WeiyunDownloadBussiness";
  public static String WEIYUN_PROCESS_NAME;
  private WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule mClientQIPCModule;
  
  public WeiyunNativeBusiness$WeiyunDownloadBussiness()
  {
    WEIYUN_PROCESS_NAME = BaseApplicationImpl.getApplication().getQQProcessName();
    this.mClientQIPCModule = WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.getInstance();
  }
  
  protected void cancel(String paramString, JSContext paramJSContext)
  {
    this.mClientQIPCModule.setWeiyunDownloadFileJsContext(paramJSContext);
    this.mClientQIPCModule.unregisterModule(paramString);
    paramJSContext = new Bundle();
    paramJSContext.putString("downloadId", paramString);
    QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Cancel", paramJSContext, null);
  }
  
  protected void doDownloadWeiyun(JSONObject paramJSONObject, String paramString, JSContext paramJSContext)
  {
    this.mClientQIPCModule.setWeiyunDownloadFileJsContext(paramJSContext);
    try
    {
      this.mClientQIPCModule.registerModule(paramString);
      paramJSContext = new Bundle();
      paramJSContext.putString("downloadId", paramString);
      paramJSContext.putString("process", WEIYUN_PROCESS_NAME);
      paramJSContext.putString("file_id", (String)paramJSONObject.get("file_id"));
      paramJSContext.putString("filename", (String)paramJSONObject.get("filename"));
      paramJSContext.putString("pdir_key", (String)paramJSONObject.get("pdir_key"));
      QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Download", paramJSContext, null);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected String getFileId(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new JSONObject((String)paramJSONObject.get("param")).getString("file_id");
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected boolean isLegal(JSONObject paramJSONObject)
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
  
  protected void pause(String paramString, JSContext paramJSContext)
  {
    this.mClientQIPCModule.setWeiyunDownloadFileJsContext(paramJSContext);
    paramJSContext = new Bundle();
    paramJSContext.putString("downloadId", paramString);
    QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Pause", paramJSContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.WeiyunNativeBusiness.WeiyunDownloadBussiness
 * JD-Core Version:    0.7.0.1
 */