package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.RangeDownloadReport;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("It has been reported! url=");
          ((StringBuilder)localObject1).append(this.val$downloadResult.getUrl());
          QLog.w("MiniProgramLpReportDC05325", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        MiniProgramLpReportDC05325.access$000().put(Long.valueOf(this.val$downloadResult.getProcess().startTimestamp), Boolean.valueOf(true));
        Object localObject1 = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
        Object localObject2 = MiniProgramReportHelper.newEntry("uid", String.valueOf(CommonDataAdapter.a().a()));
        Object localObject3 = MiniProgramReportHelper.newEntry("launchid", (String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getProcess().startTimestamp);
        Object localObject4 = MiniProgramReportHelper.newEntry("timestamp", ((StringBuilder)localObject1).toString());
        Object localObject5 = MiniProgramReportHelper.newEntry("qua", QUA.getQUA3());
        Object localObject6 = MiniProgramReportHelper.newEntry("deviceinfo", PlatformInfor.g().getDeviceInfor());
        COMM.Entry localEntry1 = MiniProgramReportHelper.newEntry("network_type", MiniProgramLpReportDC05325.getNetworkType());
        COMM.Entry localEntry2 = MiniProgramReportHelper.newEntry("userip", this.val$downloadResult.getContent().clientip);
        if (this.val$miniAppConfig == null) {
          break label1695;
        }
        localObject1 = this.val$miniAppConfig.config.appId;
        COMM.Entry localEntry3 = MiniProgramReportHelper.newEntry("appid", (String)localObject1);
        if (this.val$miniAppConfig == null) {
          break label1701;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$miniAppConfig.config.getReportType());
        localObject1 = ((StringBuilder)localObject1).toString();
        COMM.Entry localEntry4 = MiniProgramReportHelper.newEntry("app_type", (String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$resourceType);
        COMM.Entry localEntry5 = MiniProgramReportHelper.newEntry("resource_type", ((StringBuilder)localObject1).toString());
        COMM.Entry localEntry6 = MiniProgramReportHelper.newEntry("download_url", this.val$downloadResult.getUrl());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(MiniProgramLpReportDC05325.getRetCode(this.val$downloadResult));
        COMM.Entry localEntry7 = MiniProgramReportHelper.newEntry("ret_code", ((StringBuilder)localObject1).toString());
        COMM.Entry localEntry8 = MiniProgramReportHelper.newEntry("download_channel", MiniProgramLpReportDC05325.getProtocol(this.val$downloadResult));
        if (this.val$downloadResult.getReport() == null) {
          break label1707;
        }
        localObject1 = this.val$downloadResult.getReport().remoteAddress;
        COMM.Entry localEntry9 = MiniProgramReportHelper.newEntry("download_ip", (String)localObject1);
        if (this.val$downloadResult.getReport() == null) {
          break label1713;
        }
        localObject1 = this.val$downloadResult.getReport().content_type;
        COMM.Entry localEntry10 = MiniProgramReportHelper.newEntry("download_ip_type", (String)localObject1);
        if (this.val$downloadResult.getReport() == null) {
          break label1719;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getReport().currAttempCount);
        localObject1 = ((StringBuilder)localObject1).toString();
        COMM.Entry localEntry11 = MiniProgramReportHelper.newEntry("retry_count", (String)localObject1);
        boolean bool = TextUtils.isEmpty(this.val$downloadResult.getContent().redirectUrl);
        if (bool) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        COMM.Entry localEntry12 = MiniProgramReportHelper.newEntry("redirect_count", (String)localObject1);
        COMM.Entry localEntry13 = MiniProgramReportHelper.newEntry("direct_out_ip_count", "-1");
        COMM.Entry localEntry14 = MiniProgramReportHelper.newEntry("x_nws_log_uuid", MiniProgramLpReportDC05325.getHeader(this.val$downloadResult, "X-NWS-LOG-UUID"));
        if (this.val$downloadResult.getReport() == null) {
          break label1725;
        }
        localObject1 = this.val$downloadResult.getReport().content_type;
        COMM.Entry localEntry15 = MiniProgramReportHelper.newEntry("content_type", (String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getContent().length);
        COMM.Entry localEntry16 = MiniProgramReportHelper.newEntry("content_length", ((StringBuilder)localObject1).toString());
        COMM.Entry localEntry17 = MiniProgramReportHelper.newEntry("content_encoding", this.val$downloadResult.getContent().encoding);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getProcess().duration);
        COMM.Entry localEntry18 = MiniProgramReportHelper.newEntry("time_cost", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getProcess().totalDuration);
        COMM.Entry localEntry19 = MiniProgramReportHelper.newEntry("time_cost_queue", ((StringBuilder)localObject1).toString());
        if (this.val$downloadResult.getReport() == null) {
          break label1731;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getReport().t_recvrsp);
        localObject1 = ((StringBuilder)localObject1).toString();
        COMM.Entry localEntry20 = MiniProgramReportHelper.newEntry("time_cost_header", (String)localObject1);
        if (this.val$downloadResult.getReport() == null) {
          break label1737;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.val$downloadResult.getReport().t_recvdata);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject1 = MiniProgramReportHelper.newEntry("time_cost_data", (String)localObject1);
        COMM.Entry localEntry21 = MiniProgramReportHelper.newEntry("download_mode", String.valueOf(this.val$downloadResult.getReport().downloadMode));
        COMM.Entry localEntry22 = MiniProgramReportHelper.newEntry("time_cost_range_receive", String.valueOf(this.val$downloadResult.getReport().timeCostForRangeReceivePhase));
        COMM.Entry localEntry23 = MiniProgramReportHelper.newEntry("time_cost_range_merge", String.valueOf(this.val$downloadResult.getReport().timeCostForRangeMergePhase));
        COMM.Entry localEntry24 = MiniProgramReportHelper.newEntry("protocol", this.val$downloadResult.getReport().protocol);
        COMM.Entry localEntry25 = MiniProgramReportHelper.newEntry("perf_level", String.valueOf(DeviceInfoUtils.a()));
        COMM.Entry localEntry26 = MiniProgramReportHelper.newEntry("range_number", String.valueOf(this.val$downloadResult.getReport().rangeNumber));
        COMM.Entry localEntry27 = MiniProgramReportHelper.newEntry("range_type", "0");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.valueOf(CommonDataAdapter.a().a()));
        DownloadResult.Process localProcess = this.val$downloadResult.getProcess();
        try
        {
          localStringBuilder.append(localProcess.startTimestamp);
          localObject2 = new ArrayList(Arrays.asList(new COMM.Entry[] { localObject2, localObject3, localObject4, localObject5, localObject6, localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, localEntry11, localEntry12, localEntry13, localEntry14, localEntry15, localEntry16, localEntry17, localEntry18, localEntry19, localEntry20, localObject1, localEntry21, localEntry22, localEntry23, localEntry24, localEntry25, localEntry26, localEntry27, MiniProgramReportHelper.newEntry("download_id", localStringBuilder.toString()), MiniProgramReportHelper.newEntry("range_id", "0") }));
          localObject1 = new ArrayList();
          ((List)localObject1).add(localObject2);
          if ((this.val$downloadResult.getReport().downloadMode == Downloader.DownloadMode.RangeMode.ordinal()) && (this.val$downloadResult.getReport().rangeDownloadReports != null))
          {
            localObject3 = this.val$downloadResult.getReport().rangeDownloadReports.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (RangeDownloadReport)((Iterator)localObject3).next();
              localObject5 = new ArrayList();
              localObject6 = ((ArrayList)localObject2).iterator();
              if (((Iterator)localObject6).hasNext())
              {
                localEntry1 = (COMM.Entry)((Iterator)localObject6).next();
                localEntry1 = (COMM.Entry)new COMM.Entry().mergeFrom(localEntry1.toByteArray());
                if ("content_length".equals(localEntry1.key.get())) {
                  localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject4).getContentLength()));
                }
                if ("time_cost".equals(localEntry1.key.get())) {
                  localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject4).getTimeCost()));
                }
                if ("time_cost_header".equals(localEntry1.key.get())) {
                  localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject4).getTimeCostHeader()));
                }
                if ("time_cost_data".equals(localEntry1.key.get())) {
                  localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject4).getTimeCostData()));
                }
                if ("range_type".equals(localEntry1.key.get())) {
                  localEntry1.value.set("1");
                }
                if ("range_id".equals(localEntry1.key.get())) {
                  localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject4).getRangeId()));
                }
                ((List)localObject5).add(localEntry1);
                continue;
              }
              ((List)localObject1).add(localObject5);
              continue;
            }
          }
          localObject2 = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            ((List)localObject2).add(MiniProgramReportHelper.newSingleReportData(10, (List)((Iterator)localObject1).next(), null));
            continue;
          }
          MiniProgramReporter.getInstance().batchAddAll((List)localObject2);
          return;
        }
        catch (Throwable localThrowable1) {}
        QLog.e("MiniProgramLpReportDC05325", 1, "", localThrowable2);
      }
      catch (Throwable localThrowable2) {}
      return;
      label1695:
      String str = "";
      continue;
      label1701:
      str = "";
      continue;
      label1707:
      str = "";
      continue;
      label1713:
      str = "";
      continue;
      label1719:
      str = "";
      continue;
      label1725:
      str = "";
      continue;
      label1731:
      str = "";
      continue;
      label1737:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325.1
 * JD-Core Version:    0.7.0.1
 */