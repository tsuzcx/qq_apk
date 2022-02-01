package com.tencent.mobileqq.soload.temp.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.temp.api.ISoloadOtherService;
import java.io.File;

public class SoloadOtherServiceImpl
  implements ISoloadOtherService
{
  public static boolean retryUnzip(IPreloadService.PathResult paramPathResult)
  {
    if ((TextUtils.isEmpty(paramPathResult.filePath)) || (TextUtils.isEmpty(paramPathResult.folderPath))) {
      return false;
    }
    synchronized (PreloadStaticApi.a)
    {
      QWalletTools.a(paramPathResult.folderPath);
    }
    synchronized (PreloadStaticApi.a)
    {
      boolean bool = PreloadStaticApi.a(paramPathResult.filePath, paramPathResult.folderPath);
      return bool;
      paramPathResult = finally;
      throw paramPathResult;
    }
  }
  
  public void addReportItem(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    VACDReportUtil.a(paramLong, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
  
  public void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    VACDReportUtil.endReport(paramLong, paramString1, paramString2, paramInt, paramString3);
  }
  
  public int getFileExistStatusInMainProcess(String paramString)
  {
    return ComIPCUtils.a(paramString);
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
    PreloadStaticApi.a().getResPath(localDownloadParam, new SoloadOtherServiceImpl.1(this, paramOnSoGetPathListener));
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
    Object localObject = new DownloadParam();
    ((DownloadParam)localObject).filePos = 1;
    ((DownloadParam)localObject).url = paramString2;
    ((DownloadParam)localObject).md5ForChecked = paramString3;
    localObject = PreloadStaticApi.a((DownloadParam)localObject);
    boolean bool2;
    label83:
    long l;
    boolean bool1;
    int i;
    if ((localObject != null) && (!TextUtils.isEmpty(((IPreloadService.PathResult)localObject).folderPath)))
    {
      paramString1 = new File(((IPreloadService.PathResult)localObject).folderPath, paramString1).getAbsolutePath();
      if ((localObject == null) || (!retryUnzip((IPreloadService.PathResult)localObject))) {
        break label266;
      }
      bool2 = true;
      l = -1L;
      if (!bool2) {
        break label290;
      }
      l = IOUtil.getCRC32Value(new File(paramString1));
      if (!paramBoolean) {
        break label281;
      }
      if (l != paramLong1) {
        break label272;
      }
      bool1 = true;
      i = 0;
      label125:
      if (i == 0) {
        break label304;
      }
      if ((localObject == null) || (TextUtils.isEmpty(((IPreloadService.PathResult)localObject).filePath))) {
        break label299;
      }
      paramString1 = MD5Coding.encodeFile2HexStr(((IPreloadService.PathResult)localObject).filePath);
      label155:
      if ((TextUtils.isEmpty(paramString3)) || (paramString3.equalsIgnoreCase(paramString1))) {
        break label304;
      }
      PreloadStaticApi.a(paramString2, false, 1);
    }
    label266:
    label272:
    label281:
    label290:
    label299:
    label304:
    for (boolean bool3 = false;; bool3 = true)
    {
      VACDReportUtil.a(paramString4, "qqwallet", "SoLoadCRC", paramLong2 + "_" + paramLong1 + "_" + bool2 + "_" + l + "_" + paramBoolean + "_" + bool3, null, paramInt, null);
      return bool1;
      paramString1 = "";
      break;
      bool2 = false;
      break label83;
      bool1 = false;
      i = 1;
      break label125;
      bool1 = true;
      i = 0;
      break label125;
      bool1 = false;
      i = 1;
      break label125;
      paramString1 = null;
      break label155;
    }
  }
  
  public boolean isQQProcess()
  {
    return BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface;
  }
  
  public void singleReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    VACDReportUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    return VACDReportUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.temp.api.impl.SoloadOtherServiceImpl
 * JD-Core Version:    0.7.0.1
 */