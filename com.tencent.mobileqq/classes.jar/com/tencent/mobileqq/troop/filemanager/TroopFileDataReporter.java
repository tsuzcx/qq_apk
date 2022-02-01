package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class TroopFileDataReporter
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 404) {
      return 303;
    }
    int i = paramInt2 - 400;
    if ((i >= 0) && (i < 100)) {
      return 304;
    }
    paramInt2 -= 500;
    if ((paramInt2 >= 0) && (paramInt2 < 100)) {
      return 305;
    }
    if (paramInt1 == 9024) {
      return 303;
    }
    if (paramInt1 == 9060) {
      return 304;
    }
    if (paramInt1 == 9061) {
      return 305;
    }
    if ((paramInt1 != 9052) && (paramInt1 != 9055) && (paramInt1 != 9053) && (paramInt1 != 9054)) {
      return paramInt1;
    }
    return 307;
  }
  
  @Deprecated
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem == null) {
      return;
    }
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (paramInt1 != 2) {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 6)
        {
          switch (paramInt1)
          {
          default: 
            return;
          case 10: 
            l = paramItem.transferBeginTime;
            str = paramItem.DownloadIp;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramLong);
            localStringBuilder.append("");
            TroopFileUtils.a(localQQAppInterface, "download", false, l, str, localStringBuilder.toString(), FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
            return;
          }
          l = paramItem.transferBeginTime;
          str = paramItem.DownloadIp;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong);
          localStringBuilder.append("");
          TroopFileUtils.a(localQQAppInterface, "download", true, l, str, localStringBuilder.toString(), FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
        }
      }
      else
      {
        l = paramItem.transferBeginTime;
        str = paramItem.UploadIp;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong);
        localStringBuilder.append("");
        TroopFileUtils.a(localQQAppInterface, "upload", false, l, str, localStringBuilder.toString(), FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
        return;
      }
    }
    long l = paramItem.transferBeginTime;
    String str = paramItem.UploadIp;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    TroopFileUtils.a(localQQAppInterface, "upload", true, l, str, localStringBuilder.toString(), FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, TroopFileDataReporter.ReportTransferItem paramReportTransferItem, String paramString)
  {
    if (paramItem != null)
    {
      if (paramReportTransferItem == null) {
        return;
      }
      Object localObject = TroopFileTransferUtil.a();
      if (localObject == null) {
        return;
      }
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      String str = TroopFileTransferUtil.c();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_group_code", String.valueOf(paramLong));
      localHashMap.put("param_self_uin", localObject);
      localHashMap.put("param_file_name", paramItem.FileName);
      localHashMap.put("param_suffix", FileUtil.a(paramItem.FileName));
      localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
      localHashMap.put("param_uuid", paramItem.FilePath);
      localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
      localHashMap.put("param_life_left_second", String.valueOf(paramReportTransferItem.s));
      localHashMap.put("param_result", String.valueOf(0));
      localHashMap.put("param_sub_reason", String.valueOf(0));
      localHashMap.put("param_http_status_code", String.valueOf(paramReportTransferItem.m));
      localHashMap.put("param_err_msg", "");
      localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
      localHashMap.put("param_proxy_type", String.valueOf(paramReportTransferItem.d));
      localHashMap.put("param_net_type", str);
      localHashMap.put("param_security_time", String.valueOf(paramReportTransferItem.o));
      localHashMap.put("param_server_ip", String.valueOf(paramReportTransferItem.b));
      localHashMap.put("param_server_port", String.valueOf(paramReportTransferItem.c));
      localHashMap.put("param_file_url", paramReportTransferItem.a);
      localHashMap.put("param_start_size", String.valueOf(paramReportTransferItem.e));
      localHashMap.put("param_transfer_size", String.valueOf(paramReportTransferItem.f));
      localHashMap.put("param_transfer_time", String.valueOf(paramReportTransferItem.g));
      localHashMap.put("param_transfer_speed", String.valueOf(paramReportTransferItem.i));
      localHashMap.put("param_fromType", String.valueOf(paramReportTransferItem.t));
      localHashMap.put("param_V6SelectType", String.valueOf(paramReportTransferItem.u));
      localHashMap.put("param_ipAddrType", String.valueOf(paramReportTransferItem.v));
      localHashMap.put("param_stackType", String.valueOf(QFileUtils.d()));
      localHashMap.put("param_loginType", String.valueOf(QFileUtils.e()));
      localHashMap.put("param_ishttps", String.valueOf(paramReportTransferItem.w));
      paramLong = paramReportTransferItem.h;
      long l2 = System.currentTimeMillis();
      long l3 = paramReportTransferItem.h;
      long l1 = 0L;
      if (l3 == 0L) {
        paramLong = l2;
      }
      if (paramLong < 1L) {
        paramLong = 0L;
      } else {
        paramLong = l2 - paramLong;
      }
      if (paramLong < 0L) {
        paramLong = l1;
      }
      int i = TroopFileTransferUtil.Log.b;
      paramItem = new StringBuilder();
      paramItem.append("[GroupDownload]reportDownloadSucInfo. reportType:");
      paramItem.append(paramString);
      paramItem.append(" params:");
      paramItem.append(localHashMap.toString());
      TroopFileTransferUtil.Log.c("TroopFileDataReporter", i, paramItem.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, true, paramLong, 1, localHashMap, "");
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, String paramString, TroopFileDataReporter.ReportTransferItem paramReportTransferItem)
  {
    if (paramItem != null)
    {
      if (paramReportTransferItem == null) {
        return;
      }
      Object localObject = TroopFileTransferUtil.a();
      if (localObject == null) {
        return;
      }
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      String str = TroopFileTransferUtil.c();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_group_code", String.valueOf(paramLong));
      localHashMap.put("param_self_uin", localObject);
      localHashMap.put("param_file_name", paramItem.FileName);
      localHashMap.put("param_suffix", FileUtil.a(paramItem.FileName));
      localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
      localHashMap.put("param_uuid", paramItem.FilePath);
      localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
      localHashMap.put("param_life_left_second", String.valueOf(paramReportTransferItem.s));
      localHashMap.put("param_result", String.valueOf(paramReportTransferItem.k));
      localHashMap.put("param_sub_reason", String.valueOf(paramReportTransferItem.l));
      localHashMap.put("param_http_status_code", String.valueOf(paramReportTransferItem.m));
      localHashMap.put("param_server_return_code", String.valueOf(paramReportTransferItem.n));
      localHashMap.put("param_err_msg", paramReportTransferItem.q);
      localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
      localHashMap.put("param_proxy_type", String.valueOf(paramReportTransferItem.d));
      localHashMap.put("param_net_type", str);
      localHashMap.put("param_security_time", String.valueOf(paramReportTransferItem.o));
      localHashMap.put("param_server_ip", String.valueOf(paramReportTransferItem.b));
      localHashMap.put("param_server_port", String.valueOf(paramReportTransferItem.c));
      localHashMap.put("param_file_url", paramReportTransferItem.a);
      localHashMap.put("param_start_size", String.valueOf(paramReportTransferItem.e));
      localHashMap.put("param_transfer_size", String.valueOf(paramReportTransferItem.f));
      localHashMap.put("param_transfer_time", String.valueOf(paramReportTransferItem.g));
      localHashMap.put("param_transfer_speed", String.valueOf(paramReportTransferItem.i));
      localHashMap.put("param_fromType", String.valueOf(paramReportTransferItem.t));
      localHashMap.put("param_V6SelectType", String.valueOf(paramReportTransferItem.u));
      localHashMap.put("param_ipAddrType", String.valueOf(paramReportTransferItem.v));
      localHashMap.put("param_stackType", String.valueOf(QFileUtils.d()));
      localHashMap.put("param_loginType", String.valueOf(QFileUtils.e()));
      localHashMap.put("param_ishttps", String.valueOf(paramReportTransferItem.w));
      paramLong = paramReportTransferItem.h;
      long l2 = System.currentTimeMillis();
      long l3 = paramReportTransferItem.h;
      long l1 = 0L;
      if (l3 == 0L) {
        paramLong = l2;
      }
      if (paramLong < 1L) {
        paramLong = 0L;
      } else {
        paramLong = l2 - paramLong;
      }
      if (paramLong < 0L) {
        paramLong = l1;
      }
      int i = TroopFileTransferUtil.Log.b;
      paramItem = new StringBuilder();
      paramItem.append("[GroupDownload]reportDownloadFailInfo. reportType:");
      paramItem.append(paramString);
      paramItem.append(" params:");
      paramItem.append(localHashMap.toString());
      TroopFileTransferUtil.Log.c("TroopFileDataReporter", i, paramItem.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, false, paramLong, 1, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataReporter
 * JD-Core Version:    0.7.0.1
 */