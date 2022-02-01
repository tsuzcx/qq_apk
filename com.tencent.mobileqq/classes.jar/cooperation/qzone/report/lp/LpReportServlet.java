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
    localStatistic.setValue(WnsKeys.Build, "5105");
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
          break label158;
        }
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LpReport.LpReportServlet", 4, "LpReportServlet onReceive success.");
          }
          ProtocolUtils.decode(paramFromServiceMsg.getWupBuffer(), "ClientReport", arrayOfInt, arrayOfString);
          if (arrayOfInt[0] == 1000006) {
            break;
          }
          prepareReport(arrayOfInt[0], arrayOfString[0]);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("LpReportServlet onReceive fail. resultCode:");
        if (paramFromServiceMsg != null)
        {
          paramIntent = Integer.valueOf(paramFromServiceMsg.getResultCode());
          QZLog.e("LpReport.LpReportServlet", 1, new Object[] { paramIntent });
          arrayOfInt[0] = (paramFromServiceMsg.getResultCode() + 300000);
          arrayOfString[0] = paramFromServiceMsg.getBusinessFailMsg();
          continue;
        }
        paramIntent = "";
      }
      catch (Exception paramIntent)
      {
        QZLog.e("LpReport.LpReportServlet", 1, paramIntent, new Object[0]);
        return;
      }
      continue;
      label158:
      arrayOfInt[0] = -1111;
      arrayOfString[0] = "fromServiceMsg == null";
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    LpReportNewIntent localLpReportNewIntent;
    if ((paramIntent instanceof LpReportNewIntent))
    {
      localLpReportNewIntent = (LpReportNewIntent)paramIntent;
      LpReportRequest localLpReportRequest = new LpReportRequest(localLpReportNewIntent.type, localLpReportNewIntent.info, localLpReportNewIntent.extra_info, localLpReportNewIntent.multi_info);
      byte[] arrayOfByte = localLpReportRequest.encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localLpReportRequest.uniKey());
      paramPacket.putSendData(paramIntent);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("startReport, tabletype = ").append(localLpReportNewIntent.type).append(", size = ");
        if (localLpReportNewIntent.multi_info == null) {
          break label164;
        }
      }
    }
    label164:
    for (int i = localLpReportNewIntent.multi_info.size();; i = 0)
    {
      QLog.i("LpReport.LpReportServlet", 2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportServlet
 * JD-Core Version:    0.7.0.1
 */