package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import bcds;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunNativeBusiness$WeiyunDownloadBussiness$WeiyunDownloadClientQIPCModule
  extends QIPCModule
{
  public static final String ACTION_COMPLETE = "WeiyunDownloadClientIPC_Action__Complete";
  public static final String ACTION_FAIL = "WeiyunDownloadClientIPC_Action__Fail";
  public static final String ACTION_PROGRESS = "WeiyunDownloadClientIPC_Action__Progress";
  public static final String ACTION_SUC = "WeiyunDownloadClientIPC_Action__Suc";
  public static final String MODULE_NAME = "Module_WeiyunDownloadClient";
  public static final String TAG = "WeiyunDownloadClientIPC";
  private CopyOnWriteArraySet<String> downloadIdList = new CopyOnWriteArraySet();
  private WeakReference<NativePlugin.JSContext> weiyunDownloadFileJsContextWeakReference;
  
  private WeiyunNativeBusiness$WeiyunDownloadBussiness$WeiyunDownloadClientQIPCModule()
  {
    super("Module_WeiyunDownloadClient");
  }
  
  public static WeiyunDownloadClientQIPCModule getInstance()
  {
    return WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.WeiyunDownloadClient.access$100();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bcds.c("WeiyunDownloadClientIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    if (paramBundle == null) {}
    for (;;)
    {
      return null;
      Object localObject1;
      Object localObject2;
      if (paramString.equals("WeiyunDownloadClientIPC_Action__Suc"))
      {
        try
        {
          paramString = paramBundle.getString("filePath");
          localObject1 = new JSONObject();
          localObject2 = new File(paramString);
          ((JSONObject)localObject1).put("taskId", paramBundle.get("taskId"));
          ((JSONObject)localObject1).put("eventName", "onProgressUpdate");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("progress", 100);
          localJSONObject.put("writtenBytes", ((File)localObject2).length());
          localJSONObject.put("totalBytes", ((File)localObject2).length());
          ((JSONObject)localObject1).put("data", localJSONObject);
          localObject2 = (NativePlugin.JSContext)this.weiyunDownloadFileJsContextWeakReference.get();
          if (localObject2 != null) {
            ((NativePlugin.JSContext)localObject2).callJs("onWeiyunDownLoadEvent", (JSONObject)localObject1);
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("taskId", paramBundle.get("taskId"));
          ((JSONObject)localObject1).put("eventName", "success");
          paramBundle = new JSONObject();
          paramBundle.put("statusCode", 200);
          paramBundle.put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath(paramString));
          ((JSONObject)localObject1).put("data", paramBundle);
          if (localObject2 == null) {
            continue;
          }
          ((NativePlugin.JSContext)localObject2).callJs("onWeiyunDownLoadEvent", (JSONObject)localObject1);
          return null;
        }
        catch (JSONException paramString)
        {
          QLog.e("WeiyunDownloadClientIPC", 2, "WeiyunDownload--onDownloadSuc--onWeiyunDownLoadEvent fail---");
          return null;
        }
      }
      else if (paramString.equals("WeiyunDownloadClientIPC_Action__Fail"))
      {
        paramString = new JSONObject();
        try
        {
          localObject1 = paramBundle.getString("errCode");
          localObject2 = paramBundle.getString("errMsg");
          paramString.put("taskId", paramBundle.get("taskId"));
          paramString.put("eventName", "fail");
          paramBundle = new JSONObject();
          paramBundle.put("errCode", localObject1);
          paramBundle.put("errMsg", localObject2);
          paramString.put("data", paramBundle);
          paramBundle = (NativePlugin.JSContext)this.weiyunDownloadFileJsContextWeakReference.get();
          if (paramBundle == null) {
            continue;
          }
          paramBundle.callJs("onWeiyunDownLoadEvent", paramString);
          return null;
        }
        catch (Exception paramString)
        {
          QLog.e("WeiyunDownloadClientIPC", 2, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
          return null;
        }
      }
      else
      {
        if (paramString.equals("WeiyunDownloadClientIPC_Action__Complete"))
        {
          paramString = new JSONObject();
          try
          {
            paramInt = paramBundle.getInt("retCode");
            localObject1 = paramBundle.getString("retMsg");
            paramString.put("taskId", paramBundle.get("taskId"));
            paramString.put("eventName", "complete");
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("retCode", paramInt);
            ((JSONObject)localObject2).put("retMsg", localObject1);
            paramString.put("data", localObject2);
            localObject1 = (NativePlugin.JSContext)this.weiyunDownloadFileJsContextWeakReference.get();
            if (localObject1 != null) {
              ((NativePlugin.JSContext)localObject1).callJs("onWeiyunDownLoadEvent", paramString);
            }
            unregisterModule(paramBundle.getString("taskId"));
            return null;
          }
          catch (Exception paramString)
          {
            QLog.e("WeiyunDownloadClientIPC", 2, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
            return null;
          }
        }
        if (paramString.equals("WeiyunDownloadClientIPC_Action__Progress"))
        {
          paramString = new JSONObject();
          try
          {
            paramInt = paramBundle.getInt("progress");
            long l1 = paramBundle.getLong("currSize");
            long l2 = paramBundle.getLong("totalSize");
            paramString.put("taskId", paramBundle.get("taskId"));
            paramString.put("eventName", "onProgressUpdate");
            paramBundle = new JSONObject();
            paramBundle.put("progress", paramInt);
            paramBundle.put("writtenBytes", l1);
            paramBundle.put("totalBytes", l2);
            paramString.put("data", paramBundle);
            paramBundle = (NativePlugin.JSContext)this.weiyunDownloadFileJsContextWeakReference.get();
            if (paramBundle != null)
            {
              paramBundle.callJs("onWeiyunDownLoadEvent", paramString);
              return null;
            }
          }
          catch (Exception paramString)
          {
            QLog.e("WeiyunDownloadClientIPC", 2, "WeiyunDownload--onProgressUpdate--onWeiyunDownLoadEvent fail---");
          }
        }
      }
    }
    return null;
  }
  
  public void registerModule(String paramString)
  {
    try
    {
      if (this.downloadIdList.size() == 0) {
        QIPCClientHelper.getInstance().register(this);
      }
      this.downloadIdList.add(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", paramString);
    }
  }
  
  public void setWeiyunDownloadFileJsContext(NativePlugin.JSContext paramJSContext)
  {
    this.weiyunDownloadFileJsContextWeakReference = new WeakReference(paramJSContext);
  }
  
  public void unregisterModule()
  {
    try
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", localException);
    }
  }
  
  public void unregisterModule(String paramString)
  {
    try
    {
      this.downloadIdList.remove(paramString);
      if (this.downloadIdList.size() == 0) {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */