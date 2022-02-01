package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.weiyun.channel.HttpChannel;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.mobileqq.weiyun.sdk.download.WyDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.uploader.UploadRequest;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class WyReportUtils
{
  public static void a(String paramString1, String paramString2, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean, long paramLong)
  {
    try
    {
      WyReportUtils.ReportInfo localReportInfo = new WyReportUtils.ReportInfo();
      localReportInfo.a = paramWeiyunDownloadStatusInfo.b;
      localReportInfo.b = paramWeiyunDownloadStatusInfo.c;
      DownloadJobContext localDownloadJobContext2 = paramWeiyunDownloadStatusInfo.i;
      DownloadJobContext localDownloadJobContext1 = localDownloadJobContext2;
      if (localDownloadJobContext2 == null) {
        localDownloadJobContext1 = WyDownloader.a().b(paramLong);
      }
      if (localDownloadJobContext1 != null)
      {
        localReportInfo.h = localDownloadJobContext1.c().c;
        localReportInfo.j = localDownloadJobContext1.c().e;
        localReportInfo.k = localDownloadJobContext1.c().b;
        localReportInfo.g = localDownloadJobContext1.c().d;
        localReportInfo.l = paramWeiyunDownloadStatusInfo.f;
        paramWeiyunDownloadStatusInfo = localDownloadJobContext1.k();
        if (paramWeiyunDownloadStatusInfo != null) {
          localReportInfo.f = paramWeiyunDownloadStatusInfo.mReqUrl;
        }
      }
      a(paramString1, paramString2, localReportInfo, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("report download exception =");
        paramString2.append(paramString1.getMessage());
        QLog.e("WyReportUtils", 2, paramString2.toString(), paramString1);
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, WyReportUtils.ReportInfo paramReportInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramReportInfo.a));
    localHashMap.put("serverip", paramReportInfo.c);
    localHashMap.put("param_errMsg", paramReportInfo.b);
    localHashMap.put("param_errorDesc", String.valueOf(paramReportInfo.b));
    localHashMap.put("param_Server", paramReportInfo.c);
    localHashMap.put("param_ftnIP", paramReportInfo.c);
    localHashMap.put("param_innerServerIp", paramReportInfo.d);
    localHashMap.put("param_serverPort", String.valueOf(paramReportInfo.e));
    localHashMap.put("param_url", paramReportInfo.f);
    localHashMap.put("param_MD5", paramReportInfo.g);
    Object localObject;
    if (paramReportInfo.i) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localHashMap.put("param_isDowngrade", localObject);
    localHashMap.put("param_fsizeo", String.valueOf(paramReportInfo.j));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
    for (;;)
    {
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", paramReportInfo.c);
        ((JSONObject)localObject).put("t_server_port", paramReportInfo.e);
        ((JSONObject)localObject).put("t_url", paramReportInfo.f);
        ((JSONObject)localObject).put("t_file_name", paramReportInfo.h);
        ((JSONObject)localObject).put("t_file_id", paramReportInfo.k);
        ((JSONObject)localObject).put("t_file_path", paramReportInfo.l);
        ((JSONObject)localObject).put("t_file_size", paramReportInfo.j);
        ((JSONObject)localObject).put("t_file_sha", paramReportInfo.g);
        ((JSONObject)localObject).put("t_err_code", paramReportInfo.a);
        long l = 0L;
        if (paramString1 != null) {
          if (paramString1.startsWith("weiyun_")) {
            l = Long.parseLong(paramString1.substring(7));
          } else {
            l = Long.parseLong(paramString1);
          }
        }
        ((JSONObject)localObject).put("t_uin", l);
        ((JSONObject)localObject).put("t_terminal", "Android_mobileQQ");
        if (paramBoolean2)
        {
          i = 1;
          ((JSONObject)localObject).put("t_action", i);
          ((JSONObject)localObject).put("t_app_ver", ApkUtils.b(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", paramReportInfo.b);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          HttpChannel.a("https://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        return;
      }
      int i = 2;
    }
  }
  
  public static void a(String paramString1, String paramString2, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean, long paramLong)
  {
    for (;;)
    {
      try
      {
        WyReportUtils.ReportInfo localReportInfo = new WyReportUtils.ReportInfo();
        localReportInfo.a = paramStatusInfo.errorCode;
        localReportInfo.b = paramStatusInfo.errorMsg;
        UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
        UploadJobContext localUploadJobContext1 = localUploadJobContext2;
        if (localUploadJobContext2 == null) {
          localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
        }
        if (localUploadJobContext1 != null)
        {
          localReportInfo.h = localUploadJobContext1.file().fileName;
          localReportInfo.j = localUploadJobContext1.file().fileSize;
          localReportInfo.k = paramStatusInfo.fileId;
          localReportInfo.g = localUploadJobContext1.file().sha;
          paramStatusInfo = localUploadJobContext1.uploadRequest();
          if (paramStatusInfo != null)
          {
            localReportInfo.c = paramStatusInfo.serverIp();
            localReportInfo.e = paramStatusInfo.serverPort();
            localReportInfo.f = paramStatusInfo.serverName();
          }
        }
        if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload())
        {
          bool = true;
          localReportInfo.i = bool;
          a(paramString1, paramString2, localReportInfo, paramBoolean, false);
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("report upload exception =");
          paramString2.append(paramString1.getMessage());
          QLog.e("WyReportUtils", 2, paramString2.toString(), paramString1);
        }
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.WyReportUtils
 * JD-Core Version:    0.7.0.1
 */