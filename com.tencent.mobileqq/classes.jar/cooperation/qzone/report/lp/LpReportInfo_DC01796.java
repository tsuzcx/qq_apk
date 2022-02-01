package cooperation.qzone.report.lp;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    ReportHandler.DownloadReportObject localDownloadReportObject = this.reportObj;
    if (localDownloadReportObject != null) {
      localDate.setTime(localDownloadReportObject.endTime);
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(localDate);
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.reportObj != null)
    {
      localHashMap.put("Uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
      localHashMap.put("tabletype", String.valueOf(12));
      LpReportUtils.safePut(localHashMap, "LogTime", getStringDate());
      localHashMap.put("Event", "download");
      localHashMap.put("RetCode", String.valueOf(this.reportObj.retCode));
      localHashMap.put("TimeCost", String.valueOf(this.reportObj.elapse));
      localHashMap.put("network", String.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType()));
      LpReportUtils.safePut(localHashMap, "url", URLEncoder.encode(this.reportObj.url));
      localHashMap.put("size", String.valueOf(this.reportObj.fileSize));
      localHashMap.put("terminal", "Android-QzoneInQQ");
      LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
      LpReportUtils.safePut(localHashMap, "client_ip", this.reportObj.clientip);
      localHashMap.put("retry", String.valueOf(this.reportObj.retry));
      localHashMap.put("flow", String.valueOf(this.reportObj.flow));
      LpReportUtils.safePut(localHashMap, "content_type", this.reportObj.content_type);
      localHashMap.put("TotalTime", String.valueOf(this.reportObj.totaltime));
      int i = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadLinkReportSample", 2);
      if (this.reportObj.retCode == 0) {
        i = 100 / i;
      } else {
        i = 1;
      }
      localHashMap.put("freq", String.valueOf(i));
      LpReportUtils.safePut(localHashMap, "sip", this.reportObj.serverIp);
      Object localObject1 = "";
      if (!TextUtils.isEmpty(this.reportObj.strategyInfo))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.reportObj.strategyInfo);
        ((StringBuilder)localObject1).append("|");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = localObject1;
      if (this.reportObj.t != null)
      {
        Object localObject3 = Log.getStackTraceString(this.reportObj.t);
        localObject2 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = ((String)localObject3).replaceAll("\n\t", "--");
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("|");
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      LpReportUtils.safePut(localHashMap, "extend", (String)localObject2);
      LpReportUtils.safePut(localHashMap, "client_log", URLEncoder.encode(this.reportObj.logInfo));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC01796
 * JD-Core Version:    0.7.0.1
 */