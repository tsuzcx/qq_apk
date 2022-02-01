package com.tencent.mobileqq.weiyun.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class WeiyunUploadDownloadServiceImpl$WeiyunDownloadServiceQIPCModule
  extends QIPCModule
{
  public WeiyunUploadDownloadServiceImpl$WeiyunDownloadServiceQIPCModule(WeiyunUploadDownloadServiceImpl paramWeiyunUploadDownloadServiceImpl, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCall action|");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" params|");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append(" callbackId|");
    ((StringBuilder)localObject).append(paramInt);
    LogUtility.c("WeiyunDownloadServiceIPC", ((StringBuilder)localObject).toString());
    if (paramBundle == null) {
      localObject = null;
    } else {
      localObject = paramBundle.getString("process");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      WeiyunUploadDownloadServiceImpl.access$002((String)localObject);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localAppRuntime == null)
      {
        LogUtility.c("WeiyunDownloadServiceIPC", "onCall action but appInterface is null");
        return null;
      }
      if ((("WeiyunDownloadServiceIPC_Action__Download".equals(paramString)) || ("WeiyunDownloadServiceIPC_Action__Resume".equals(paramString))) && (paramBundle != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WeiyunDownloadServiceIPC", 2, "AIDL : start weiyunDownload");
        }
        localObject = (String)paramBundle.get("file_id");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          LogUtility.c("WeiyunDownloadServiceIPC", "onCall action but file_id is null");
          return null;
        }
        FileManagerEntity localFileManagerEntity = ((IQQFileDataCenter)localAppRuntime.getRuntimeService(IQQFileDataCenter.class, "")).queryByFileIdForMemory((String)localObject);
        localObject = localFileManagerEntity;
        if (localFileManagerEntity == null)
        {
          if ("WeiyunDownloadServiceIPC_Action__Resume".equals(paramString)) {
            return null;
          }
          localObject = ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).newEntityByWeiYunMiniAppParams(paramBundle);
          ((IQQFileEngine)localAppRuntime.getRuntimeService(IQQFileEngine.class, "")).reciveFile((FileManagerEntity)localObject);
        }
        paramString = (String)paramBundle.get("downloadId");
        ((FileManagerEntity)localObject).nOpType = 50;
        ((FileManagerEntity)localObject).cloudType = 2;
        ((FileManagerEntity)localObject).miniAppDownloadId = paramString;
        WeiyunUploadDownloadServiceImpl.access$100(this.a).put(paramString, Long.valueOf(((FileManagerEntity)localObject).nSessionId));
        if (FileUtils.fileExists(((FileManagerEntity)localObject).getFilePath()))
        {
          paramString = new Bundle();
          paramString.putString("taskId", ((FileManagerEntity)localObject).miniAppDownloadId);
          paramString.putString("filePath", ((FileManagerEntity)localObject).getFilePath());
          QIPCServerHelper.getInstance().callClient(WeiyunUploadDownloadServiceImpl.access$000(), "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
          paramString = new Bundle();
          paramString.putString("taskId", ((FileManagerEntity)localObject).miniAppDownloadId);
          paramString.putInt("retCode", 1);
          paramString.putString("retMsg", "");
          QIPCServerHelper.getInstance().callClient(WeiyunUploadDownloadServiceImpl.access$000(), "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Complete", paramString, null);
          return null;
        }
        ((IQQFileDataCenter)localAppRuntime.getRuntimeService(IQQFileDataCenter.class, "")).insertToMemMap((FileManagerEntity)localObject);
        ((IQQFileEngine)localAppRuntime.getRuntimeService(IQQFileEngine.class, "")).resume(((FileManagerEntity)localObject).nSessionId);
        return null;
      }
      if ((("WeiyunDownloadServiceIPC_Action__Cancel".equals(paramString)) || ("WeiyunDownloadServiceIPC_Action__Pause".equals(paramString))) && (paramBundle != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WeiyunDownloadServiceIPC", 2, "AIDL : end weiyunDownload");
        }
        paramString = paramBundle.getString("downloadId");
        ((IQQFileEngine)localAppRuntime.getRuntimeService(IQQFileEngine.class, "all")).pause(((Long)WeiyunUploadDownloadServiceImpl.access$100(this.a).get(paramString)).longValue());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunUploadDownloadServiceImpl.WeiyunDownloadServiceQIPCModule
 * JD-Core Version:    0.7.0.1
 */