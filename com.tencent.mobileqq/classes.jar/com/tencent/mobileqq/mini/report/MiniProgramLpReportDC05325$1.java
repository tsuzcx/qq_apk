package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.text.TextUtils;
import bcyb;
import bgyh;
import bgyi;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

final class MiniProgramLpReportDC05325$1
  implements Runnable
{
  MiniProgramLpReportDC05325$1(DownloadResult paramDownloadResult, MiniAppConfig paramMiniAppConfig, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (MiniProgramLpReportDC05325.access$000().containsKey(Long.valueOf(this.val$downloadResult.getProcess().startTimestamp)))
        {
          QLog.w("MiniProgramLpReportDC05325", 1, "It has been reported! url=" + this.val$downloadResult.getUrl());
          return;
        }
        MiniProgramLpReportDC05325.access$000().put(Long.valueOf(this.val$downloadResult.getProcess().startTimestamp), Boolean.valueOf(true));
        Object localObject = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
        COMM.Entry localEntry1 = MiniProgramReportHelper.newEntry("uid", String.valueOf(bcyb.a().a()));
        COMM.Entry localEntry2 = MiniProgramReportHelper.newEntry("launchid", (String)localObject);
        COMM.Entry localEntry3 = MiniProgramReportHelper.newEntry("timestamp", "" + this.val$downloadResult.getProcess().startTimestamp);
        COMM.Entry localEntry4 = MiniProgramReportHelper.newEntry("qua", bgyi.a());
        COMM.Entry localEntry5 = MiniProgramReportHelper.newEntry("deviceinfo", bgyh.a().c());
        COMM.Entry localEntry6 = MiniProgramReportHelper.newEntry("network_type", MiniProgramLpReportDC05325.getNetworkType());
        COMM.Entry localEntry7 = MiniProgramReportHelper.newEntry("userip", this.val$downloadResult.getContent().clientip);
        if (this.val$miniAppConfig != null)
        {
          localObject = this.val$miniAppConfig.config.appId;
          COMM.Entry localEntry8 = MiniProgramReportHelper.newEntry("appid", (String)localObject);
          if (this.val$miniAppConfig == null) {
            break label958;
          }
          localObject = "" + this.val$miniAppConfig.config.getReportType();
          COMM.Entry localEntry9 = MiniProgramReportHelper.newEntry("app_type", (String)localObject);
          COMM.Entry localEntry10 = MiniProgramReportHelper.newEntry("resource_type", "" + this.val$resourceType);
          COMM.Entry localEntry11 = MiniProgramReportHelper.newEntry("download_url", this.val$downloadResult.getUrl());
          COMM.Entry localEntry12 = MiniProgramReportHelper.newEntry("ret_code", "" + MiniProgramLpReportDC05325.getRetCode(this.val$downloadResult));
          COMM.Entry localEntry13 = MiniProgramReportHelper.newEntry("download_channel", MiniProgramLpReportDC05325.getProtocol(this.val$downloadResult));
          if (this.val$downloadResult.getReport() == null) {
            break label964;
          }
          localObject = this.val$downloadResult.getReport().remoteAddress;
          COMM.Entry localEntry14 = MiniProgramReportHelper.newEntry("download_ip", (String)localObject);
          if (this.val$downloadResult.getReport() == null) {
            break label970;
          }
          localObject = this.val$downloadResult.getReport().content_type;
          COMM.Entry localEntry15 = MiniProgramReportHelper.newEntry("download_ip_type", (String)localObject);
          if (this.val$downloadResult.getReport() == null) {
            break label976;
          }
          localObject = "" + this.val$downloadResult.getReport().currAttempCount;
          COMM.Entry localEntry16 = MiniProgramReportHelper.newEntry("retry_count", (String)localObject);
          if (!TextUtils.isEmpty(this.val$downloadResult.getContent().redirectUrl)) {
            break label982;
          }
          localObject = "0";
          COMM.Entry localEntry17 = MiniProgramReportHelper.newEntry("redirect_count", (String)localObject);
          COMM.Entry localEntry18 = MiniProgramReportHelper.newEntry("direct_out_ip_count", "-1");
          COMM.Entry localEntry19 = MiniProgramReportHelper.newEntry("x_nws_log_uuid", MiniProgramLpReportDC05325.getHeader(this.val$downloadResult, "X-NWS-LOG-UUID"));
          if (this.val$downloadResult.getReport() == null) {
            break label989;
          }
          localObject = this.val$downloadResult.getReport().content_type;
          COMM.Entry localEntry20 = MiniProgramReportHelper.newEntry("content_type", (String)localObject);
          COMM.Entry localEntry21 = MiniProgramReportHelper.newEntry("content_length", "" + this.val$downloadResult.getContent().length);
          COMM.Entry localEntry22 = MiniProgramReportHelper.newEntry("content_encoding", this.val$downloadResult.getContent().encoding);
          COMM.Entry localEntry23 = MiniProgramReportHelper.newEntry("time_cost", "" + this.val$downloadResult.getProcess().duration);
          COMM.Entry localEntry24 = MiniProgramReportHelper.newEntry("time_cost_queue", "" + this.val$downloadResult.getProcess().totalDuration);
          if (this.val$downloadResult.getReport() == null) {
            break label995;
          }
          localObject = "" + this.val$downloadResult.getReport().t_recvrsp;
          COMM.Entry localEntry25 = MiniProgramReportHelper.newEntry("time_cost_header", (String)localObject);
          if (this.val$downloadResult.getReport() == null) {
            break label952;
          }
          localObject = "" + this.val$downloadResult.getReport().t_recvdata;
          localObject = MiniProgramReportHelper.newSingleReportData(10, new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, localEntry11, localEntry12, localEntry13, localEntry14, localEntry15, localEntry16, localEntry17, localEntry18, localEntry19, localEntry20, localEntry21, localEntry22, localEntry23, localEntry24, localEntry25, MiniProgramReportHelper.newEntry("time_cost_data", (String)localObject) })), null);
          MiniProgramReporter.getInstance().addData((APP_REPORT_TRANSFER.SingleDcData)localObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniProgramLpReportDC05325", 1, "", localThrowable);
        return;
      }
      String str = "";
      continue;
      label952:
      str = "";
      continue;
      label958:
      str = "";
      continue;
      label964:
      str = "";
      continue;
      label970:
      str = "";
      continue;
      label976:
      str = "";
      continue;
      label982:
      str = "1";
      continue;
      label989:
      str = "";
      continue;
      label995:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325.1
 * JD-Core Version:    0.7.0.1
 */