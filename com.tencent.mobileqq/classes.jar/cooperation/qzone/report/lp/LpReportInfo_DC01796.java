package cooperation.qzone.report.lp;

import android.text.TextUtils;
import android.util.Log;
import bfpk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_DC01796
  implements LpReportInfo
{
  private static String TAG = "LpReport.LpReportInfo_DC01796";
  private ReportHandler.DownloadReportObject reportObj;
  
  public LpReportInfo_DC01796(ReportHandler.DownloadReportObject paramDownloadReportObject)
  {
    this.reportObj = paramDownloadReportObject;
  }
  
  public String getSimpleInfo()
  {
    return "DC01796";
  }
  
  public String getStringDate()
  {
    Date localDate = new Date();
    if (this.reportObj != null) {
      localDate.setTime(this.reportObj.endTime);
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(localDate);
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.reportObj != null)
    {
      localHashMap.put("Uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      localHashMap.put("tabletype", String.valueOf(12));
      LpReportUtils.safePut(localHashMap, "LogTime", getStringDate());
      localHashMap.put("Event", "download");
      localHashMap.put("RetCode", String.valueOf(this.reportObj.retCode));
      localHashMap.put("TimeCost", String.valueOf(this.reportObj.elapse));
      localHashMap.put("network", String.valueOf(NetworkState.getNetworkType()));
      LpReportUtils.safePut(localHashMap, "url", URLEncoder.encode(this.reportObj.url));
      localHashMap.put("size", String.valueOf(this.reportObj.fileSize));
      localHashMap.put("terminal", "Android-QzoneInQQ");
      LpReportUtils.safePut(localHashMap, "qua", bfpk.a());
      LpReportUtils.safePut(localHashMap, "client_ip", this.reportObj.clientip);
      localHashMap.put("retry", String.valueOf(this.reportObj.retry));
      localHashMap.put("flow", String.valueOf(this.reportObj.flow));
      LpReportUtils.safePut(localHashMap, "content_type", this.reportObj.content_type);
      localHashMap.put("TotalTime", String.valueOf(this.reportObj.totaltime));
      i = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadLinkReportSample", 2);
      if (this.reportObj.retCode != 0) {
        break label475;
      }
    }
    label475:
    for (int i = 100 / i;; i = 1)
    {
      localHashMap.put("freq", String.valueOf(i));
      LpReportUtils.safePut(localHashMap, "sip", this.reportObj.serverIp);
      String str1 = "";
      if (!TextUtils.isEmpty(this.reportObj.strategyInfo)) {
        str1 = "" + this.reportObj.strategyInfo + "|";
      }
      Object localObject = str1;
      if (this.reportObj.t != null)
      {
        String str2 = Log.getStackTraceString(this.reportObj.t);
        localObject = str2;
        if (!TextUtils.isEmpty(str2)) {
          localObject = str2.replaceAll("\n\t", "--");
        }
        localObject = str1 + (String)localObject + "|";
      }
      LpReportUtils.safePut(localHashMap, "extend", (String)localObject);
      LpReportUtils.safePut(localHashMap, "client_log", URLEncoder.encode(this.reportObj.logInfo));
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC01796
 * JD-Core Version:    0.7.0.1
 */