package cooperation.qzone.video;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import java.net.URLEncoder;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TcSdkDownloadReportServlet
  extends MSFServlet
{
  public static final String TAG = "TcSdkDownloadReportServlet";
  
  private void report(Intent paramIntent, String paramString)
  {
    for (;;)
    {
      try
      {
        String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "TcSDKReportURL", "https://btrace.qq.com/kvcollect");
        String str2 = paramIntent.getStringExtra("uin");
        String str3 = QUA.getQUA3();
        String str4 = Build.MODEL;
        String str5 = Build.VERSION.RELEASE;
        paramIntent = paramIntent.getStringExtra("report_msg");
        boolean bool = NetworkState.isNetSupport();
        j = 0;
        if (!bool)
        {
          i = 0;
        }
        else
        {
          i = NetworkState.getNetworkType();
          if (i == 1) {
            break label363;
          }
          if (i == 2) {
            break label358;
          }
          if (i == 3) {
            break label353;
          }
          if (i == 4) {
            break label348;
          }
          if (i == 5) {
            break label342;
          }
          i = 5;
          j = NetworkState.getApnValue();
          if (j == 1) {
            break label386;
          }
          if (j == 2) {
            break label380;
          }
          if (j == 3) {
            break label374;
          }
          if (j == 4) {
            break label368;
          }
          j = 4;
        }
        paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append("?BossId=3590&Pwd=1432018701&userLocalIP=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("&uin=");
        localStringBuilder.append(str2);
        localStringBuilder.append("&apn=");
        localStringBuilder.append(j);
        localStringBuilder.append("&netStatus=");
        localStringBuilder.append(i);
        localStringBuilder.append("&deviceID=");
        localStringBuilder.append(str4);
        localStringBuilder.append("&deviceOS=");
        localStringBuilder.append(str5);
        localStringBuilder.append("&SDKReportDetailJSONStr=");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append("&QUA=");
        localStringBuilder.append(str3);
        localStringBuilder.append("&_dc=");
        localStringBuilder.append(Math.random());
        paramIntent = new TcSdkDownloadReportServlet.ReportRunnable(this, localStringBuilder.toString().trim().replace(" ", ""));
        QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.w("TcSdkDownloadReportServlet", 2, "", paramIntent);
        return;
      }
      label342:
      int i = 6;
      continue;
      label348:
      i = 4;
      continue;
      label353:
      i = 3;
      continue;
      label358:
      i = 2;
      continue;
      label363:
      i = 1;
      continue;
      label368:
      int j = 5;
      continue;
      label374:
      j = 3;
      continue;
      label380:
      j = 2;
      continue;
      label386:
      j = 1;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    for (;;)
    {
      try
      {
        String str = paramFromServiceMsg.getServiceCmd();
        if (paramIntent != null)
        {
          if (!MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(str)) {
            break label74;
          }
          paramFromServiceMsg = (String)paramFromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            QLog.w("TcSdkDownloadReportServlet", 2, "can not get ip address");
          }
          report(paramIntent, paramFromServiceMsg);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.w("TcSdkDownloadReportServlet", 2, "", paramIntent);
      }
      return;
      label74:
      paramFromServiceMsg = "";
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = MsfMsgUtil.getGatewayIpMsg(null);
    paramPacket.setTimeout(30000L);
    paramPacket.setNeedCallback(true);
    paramPacket.setNeedRemindSlowNetwork(false);
    sendToMSF(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.video.TcSdkDownloadReportServlet
 * JD-Core Version:    0.7.0.1
 */