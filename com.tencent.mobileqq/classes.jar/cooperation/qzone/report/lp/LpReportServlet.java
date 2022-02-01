package cooperation.qzone.report.lp;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.ProtocolUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class LpReportServlet
  extends MSFServlet
{
  public static final String TAG = "LpReport.LpReportServlet";
  private static final int TIMEOUT = 60000;
  
  private static void prepareReport(int paramInt, String paramString)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance();
    Statistic localStatistic = localStatisticCollector.getStatistic();
    localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
    localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
    localStatistic.setValue(WnsKeys.CommandId, "ClientReport.update.ClientReport");
    localStatistic.setValue(WnsKeys.APN, ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAPN());
    localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt));
    localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getLongAccountUin()));
    localStatistic.setValue(WnsKeys.Qua, ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localStatistic.setValue(WnsKeys.Build, "5770");
    if ((paramInt != 0) && (!TextUtils.isEmpty(paramString)))
    {
      localStatistic.setValue(WnsKeys.Detail, paramString);
      localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(1));
    }
    localStatisticCollector.put(localStatistic);
    if (paramInt != 0) {
      localStatisticCollector.forceReport();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    for (;;)
    {
      int[] arrayOfInt;
      String[] arrayOfString;
      try
      {
        arrayOfInt = new int[1];
        arrayOfString = new String[1];
        if (paramFromServiceMsg == null) {
          break label170;
        }
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LpReport.LpReportServlet", 4, "LpReportServlet onReceive success.");
          }
          ProtocolUtils.decode(paramFromServiceMsg.getWupBuffer(), "ClientReport", arrayOfInt, arrayOfString);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("LpReportServlet onReceive fail. resultCode:");
          if (paramFromServiceMsg == null) {
            break label164;
          }
          paramIntent = Integer.valueOf(paramFromServiceMsg.getResultCode());
          localStringBuilder.append(paramIntent);
          QZLog.e("LpReport.LpReportServlet", 1, new Object[] { localStringBuilder.toString() });
          arrayOfInt[0] = (paramFromServiceMsg.getResultCode() + 300000);
          arrayOfString[0] = paramFromServiceMsg.getBusinessFailMsg();
        }
        if (arrayOfInt[0] != 1000006)
        {
          prepareReport(arrayOfInt[0], arrayOfString[0]);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QZLog.e("LpReport.LpReportServlet", 1, paramIntent, new Object[0]);
      }
      return;
      label164:
      paramIntent = "";
      continue;
      label170:
      arrayOfInt[0] = -1111;
      arrayOfString[0] = "fromServiceMsg == null";
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if ((paramIntent instanceof LpReportNewIntent))
    {
      LpReportNewIntent localLpReportNewIntent = (LpReportNewIntent)paramIntent;
      LpReportRequest localLpReportRequest = new LpReportRequest(localLpReportNewIntent.type, localLpReportNewIntent.info, localLpReportNewIntent.extra_info, localLpReportNewIntent.multi_info);
      Object localObject = localLpReportRequest.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SQQzoneSvc.");
      ((StringBuilder)localObject).append(localLpReportRequest.uniKey());
      paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
      paramPacket.putSendData(paramIntent);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("startReport, tabletype = ");
        paramIntent.append(localLpReportNewIntent.type);
        paramIntent.append(", size = ");
        int i;
        if (localLpReportNewIntent.multi_info != null) {
          i = localLpReportNewIntent.multi_info.size();
        } else {
          i = 0;
        }
        paramIntent.append(i);
        QLog.i("LpReport.LpReportServlet", 2, paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportServlet
 * JD-Core Version:    0.7.0.1
 */