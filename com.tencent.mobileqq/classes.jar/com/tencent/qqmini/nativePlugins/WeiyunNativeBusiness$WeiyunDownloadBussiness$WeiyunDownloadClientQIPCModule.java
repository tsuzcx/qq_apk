package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
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
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private WeakReference<RequestEvent> jdField_a_of_type_JavaLangRefWeakReference;
  private CopyOnWriteArraySet<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  
  private WeiyunNativeBusiness$WeiyunDownloadBussiness$WeiyunDownloadClientQIPCModule()
  {
    super("Module_WeiyunDownloadClient");
  }
  
  public static WeiyunDownloadClientQIPCModule a()
  {
    return WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.WeiyunDownloadClient.a();
  }
  
  public void a(IMiniAppContext paramIMiniAppContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public void a(RequestEvent paramRequestEvent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRequestEvent);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() == 0) {
        QIPCClientHelper.getInstance().register(this);
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", paramString);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() == 0)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", paramString);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onCall action|");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" params|");
    ((StringBuilder)localObject1).append(paramBundle);
    ((StringBuilder)localObject1).append(" callbackId|");
    ((StringBuilder)localObject1).append(paramInt);
    LogUtility.c("WeiyunDownloadClientIPC", ((StringBuilder)localObject1).toString());
    if (paramBundle == null) {
      return null;
    }
    if (paramString.equals("WeiyunDownloadClientIPC_Action__Suc")) {}
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
      localObject2 = (RequestEvent)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 != null) {
        ((RequestEvent)localObject2).jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", ((JSONObject)localObject1).toString(), 0);
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("taskId", paramBundle.get("taskId"));
      ((JSONObject)localObject1).put("eventName", "success");
      paramBundle = new JSONObject();
      paramBundle.put("statusCode", 200);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext != null) {
        paramBundle.put("tempFilePath", ((IMiniAppFileManager)this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getManager(IMiniAppFileManager.class)).getWxFilePath(paramString));
      }
      ((JSONObject)localObject1).put("data", paramBundle);
      if (localObject2 == null) {
        break label779;
      }
      ((RequestEvent)localObject2).jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", ((JSONObject)localObject1).toString(), 0);
    }
    catch (JSONException paramString)
    {
      Object localObject2;
      label339:
      break label339;
    }
    QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onDownloadSuc--onWeiyunDownLoadEvent fail---");
    break label779;
    if (paramString.equals("WeiyunDownloadClientIPC_Action__Fail")) {
      paramString = new JSONObject();
    }
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
      paramBundle = (RequestEvent)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle == null) {
        break label779;
      }
      paramBundle.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", paramString.toString(), 0);
    }
    catch (Exception paramString)
    {
      label473:
      break label473;
    }
    QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
    break label779;
    if (paramString.equals("WeiyunDownloadClientIPC_Action__Complete")) {
      paramString = new JSONObject();
    }
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
      localObject1 = (RequestEvent)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        ((RequestEvent)localObject1).jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", paramString.toString(), 0);
      }
      b(paramBundle.getString("taskId"));
    }
    catch (Exception paramString)
    {
      label622:
      break label622;
    }
    QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
    break label779;
    if (paramString.equals("WeiyunDownloadClientIPC_Action__Progress")) {
      paramString = new JSONObject();
    }
    try
    {
      paramInt = paramBundle.getInt("progress");
      l1 = paramBundle.getLong("currSize");
    }
    catch (Exception paramString)
    {
      long l1;
      long l2;
      label771:
      label779:
      break label771;
    }
    try
    {
      l2 = paramBundle.getLong("totalSize");
      paramString.put("taskId", paramBundle.get("taskId"));
      paramString.put("eventName", "onProgressUpdate");
      paramBundle = new JSONObject();
      paramBundle.put("progress", paramInt);
      paramBundle.put("writtenBytes", l1);
      paramBundle.put("totalBytes", l2);
      paramString.put("data", paramBundle);
      paramBundle = (RequestEvent)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle == null) {
        break label779;
      }
      paramBundle.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", paramString.toString(), 0);
    }
    catch (Exception paramString)
    {
      break label771;
    }
    QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onProgressUpdate--onWeiyunDownLoadEvent fail---");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */