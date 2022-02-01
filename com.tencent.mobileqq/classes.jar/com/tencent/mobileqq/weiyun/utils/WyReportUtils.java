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
      localReportInfo.jdField_a_of_type_Int = paramWeiyunDownloadStatusInfo.jdField_b_of_type_Int;
      localReportInfo.jdField_a_of_type_JavaLangString = paramWeiyunDownloadStatusInfo.jdField_a_of_type_JavaLangString;
      DownloadJobContext localDownloadJobContext2 = paramWeiyunDownloadStatusInfo.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadJobContext;
      DownloadJobContext localDownloadJobContext1 = localDownloadJobContext2;
      if (localDownloadJobContext2 == null) {
        localDownloadJobContext1 = WyDownloader.a().a(paramLong);
      }
      if (localDownloadJobContext1 != null)
      {
        localReportInfo.f = localDownloadJobContext1.a().jdField_b_of_type_JavaLangString;
        localReportInfo.jdField_a_of_type_Long = localDownloadJobContext1.a().jdField_a_of_type_Long;
        localReportInfo.g = localDownloadJobContext1.a().jdField_a_of_type_JavaLangString;
        localReportInfo.e = localDownloadJobContext1.a().c;
        localReportInfo.h = paramWeiyunDownloadStatusInfo.jdField_b_of_type_JavaLangString;
        paramWeiyunDownloadStatusInfo = localDownloadJobContext1.a();
        if (paramWeiyunDownloadStatusInfo != null) {
          localReportInfo.d = paramWeiyunDownloadStatusInfo.mReqUrl;
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
    localHashMap.put("param_FailCode", String.valueOf(paramReportInfo.jdField_a_of_type_Int));
    localHashMap.put("serverip", paramReportInfo.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", paramReportInfo.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(paramReportInfo.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", paramReportInfo.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", paramReportInfo.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", paramReportInfo.c);
    localHashMap.put("param_serverPort", String.valueOf(paramReportInfo.jdField_b_of_type_Int));
    localHashMap.put("param_url", paramReportInfo.d);
    localHashMap.put("param_MD5", paramReportInfo.e);
    Object localObject;
    if (paramReportInfo.jdField_a_of_type_Boolean) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localHashMap.put("param_isDowngrade", localObject);
    localHashMap.put("param_fsizeo", String.valueOf(paramReportInfo.jdField_a_of_type_Long));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
    for (;;)
    {
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", paramReportInfo.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", paramReportInfo.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", paramReportInfo.d);
        ((JSONObject)localObject).put("t_file_name", paramReportInfo.f);
        ((JSONObject)localObject).put("t_file_id", paramReportInfo.g);
        ((JSONObject)localObject).put("t_file_path", paramReportInfo.h);
        ((JSONObject)localObject).put("t_file_size", paramReportInfo.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", paramReportInfo.e);
        ((JSONObject)localObject).put("t_err_code", paramReportInfo.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", ApkUtils.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", paramReportInfo.jdField_a_of_type_JavaLangString);
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
        localReportInfo.jdField_a_of_type_Int = paramStatusInfo.errorCode;
        localReportInfo.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
        UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
        UploadJobContext localUploadJobContext1 = localUploadJobContext2;
        if (localUploadJobContext2 == null) {
          localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
        }
        if (localUploadJobContext1 != null)
        {
          localReportInfo.f = localUploadJobContext1.file().fileName;
          localReportInfo.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
          localReportInfo.g = paramStatusInfo.fileId;
          localReportInfo.e = localUploadJobContext1.file().sha;
          paramStatusInfo = localUploadJobContext1.uploadRequest();
          if (paramStatusInfo != null)
          {
            localReportInfo.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
            localReportInfo.jdField_b_of_type_Int = paramStatusInfo.serverPort();
            localReportInfo.d = paramStatusInfo.serverName();
          }
        }
        if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload())
        {
          bool = true;
          localReportInfo.jdField_a_of_type_Boolean = bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.WyReportUtils
 * JD-Core Version:    0.7.0.1
 */