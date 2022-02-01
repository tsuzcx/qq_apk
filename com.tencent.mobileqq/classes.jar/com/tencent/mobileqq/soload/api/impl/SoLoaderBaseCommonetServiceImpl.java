package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.report.IVACDReportStaticApi;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.MobileQQ;

public class SoLoaderBaseCommonetServiceImpl
  implements ISoLoaderBaseCommonetService
{
  private boolean checkMd5(SoLoaderBaseCommonetServiceImpl.ResPathReportModel paramResPathReportModel, IPreloadService.PathResult paramPathResult, String paramString1, String paramString2)
  {
    if (paramResPathReportModel.c)
    {
      if ((paramPathResult != null) && (!TextUtils.isEmpty(paramPathResult.filePath))) {
        paramResPathReportModel = MD5Coding.encodeFile2HexStr(paramPathResult.filePath);
      } else {
        paramResPathReportModel = null;
      }
      if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equalsIgnoreCase(paramResPathReportModel)))
      {
        PreloadStaticApi.a(paramString1, false, 1);
        return false;
      }
    }
    return true;
  }
  
  private IPreloadService.PathResult getResPathResult(String paramString1, String paramString2)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = paramString1;
    localDownloadParam.md5ForChecked = paramString2;
    return PreloadStaticApi.a(localDownloadParam);
  }
  
  private long getRetryUnzipCrc(IPreloadService.PathResult paramPathResult, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((paramPathResult != null) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
        paramPathResult = new File(paramPathResult.folderPath, paramString).getAbsolutePath();
      } else {
        paramPathResult = "";
      }
      return IOUtil.getCRC32Value(new File(paramPathResult));
    }
    return -1L;
  }
  
  public static boolean retryUnzip(IPreloadService.PathResult paramPathResult)
  {
    if (!TextUtils.isEmpty(paramPathResult.filePath))
    {
      if (TextUtils.isEmpty(paramPathResult.folderPath)) {
        return false;
      }
      synchronized (PreloadStaticApi.b)
      {
        FileUtils.delete(paramPathResult.folderPath, false);
        synchronized (PreloadStaticApi.b)
        {
          boolean bool = PreloadStaticApi.a(paramPathResult.filePath, paramPathResult.folderPath);
          return bool;
        }
      }
    }
    return false;
  }
  
  private boolean validateCRC(boolean paramBoolean1, boolean paramBoolean2, long paramLong, SoLoaderBaseCommonetServiceImpl.ResPathReportModel paramResPathReportModel)
  {
    boolean bool = true;
    if (paramBoolean1)
    {
      paramBoolean1 = bool;
      if (!paramBoolean2) {
        return paramBoolean1;
      }
      if (paramResPathReportModel.b == paramLong) {
        return true;
      }
    }
    paramBoolean1 = false;
    return paramBoolean1;
  }
  
  public void addReportItem(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).addReportItem(paramLong, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
  
  public void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).endReport(paramLong, paramString1, paramString2, paramInt, paramString3);
  }
  
  public int getFileExistStatusInMainProcess(String paramString)
  {
    if ((MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface)) {
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          return 2;
        }
        return 1;
      }
      catch (Throwable paramString)
      {
        QLog.e("getFileExistStatus", 1, paramString, new Object[0]);
        return 3;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 18);
    localBundle.putString("path", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("SoLoadIPCModule", "ComIPCUtils", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      try
      {
        if (paramString.data.containsKey("res"))
        {
          int i = paramString.data.getInt("res");
          return i;
        }
        return 4;
      }
      catch (Throwable paramString)
      {
        QLog.e("getFileExistStatus IPC", 1, paramString, new Object[0]);
        return 5;
      }
    }
    return 6;
  }
  
  public String getResFolderPathSync(String paramString1, String paramString2)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = paramString1;
    localDownloadParam.md5ForChecked = paramString2;
    paramString1 = PreloadStaticApi.a(localDownloadParam);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.folderPath))) {
      return paramString1.folderPath;
    }
    return null;
  }
  
  public void getResPathAsync(String paramString1, String paramString2, boolean paramBoolean, OnSoGetPathListener paramOnSoGetPathListener)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = paramString1;
    localDownloadParam.md5ForChecked = paramString2;
    localDownloadParam.isPreDownload = paramBoolean;
    PreloadStaticApi.a().getResPath(localDownloadParam, new SoLoaderBaseCommonetServiceImpl.1(this, paramOnSoGetPathListener));
  }
  
  public String getResPathSync(String paramString1, String paramString2, String paramString3)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = paramString2;
    localDownloadParam.md5ForChecked = paramString3;
    paramString2 = PreloadStaticApi.a(localDownloadParam);
    if ((paramString2 != null) && (paramString2.folderPath != null)) {
      return new File(paramString2.folderPath, paramString1).getAbsolutePath();
    }
    return null;
  }
  
  public boolean getResPathSyncWithUnZip(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, String paramString4, int paramInt)
  {
    IPreloadService.PathResult localPathResult = getResPathResult(paramString2, paramString3);
    SoLoaderBaseCommonetServiceImpl.ResPathReportModel localResPathReportModel = new SoLoaderBaseCommonetServiceImpl.ResPathReportModel(localPathResult);
    boolean bool1 = localResPathReportModel.a;
    localResPathReportModel.b = getRetryUnzipCrc(localPathResult, paramString1, bool1);
    bool1 = validateCRC(bool1, paramBoolean, paramLong1, localResPathReportModel);
    localResPathReportModel.c = (bool1 ^ true);
    boolean bool2 = checkMd5(localResPathReportModel, localPathResult, paramString2, paramString3);
    paramString1 = new StringBuilder();
    paramString1.append(paramLong2);
    paramString1.append("_");
    paramString1.append(paramLong1);
    paramString1.append("_");
    paramString1.append(localResPathReportModel.a);
    paramString1.append("_");
    paramString1.append(localResPathReportModel.b);
    paramString1.append("_");
    paramString1.append(paramBoolean);
    paramString1.append("_");
    paramString1.append(bool2);
    VACDReportUtil.b(paramString4, "qqwallet", "SoLoadCRC", paramString1.toString(), null, paramInt, null);
    return bool1;
  }
  
  public boolean isQQProcess()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface;
  }
  
  public void singleReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).singleReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    return ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).startReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderBaseCommonetServiceImpl
 * JD-Core Version:    0.7.0.1
 */