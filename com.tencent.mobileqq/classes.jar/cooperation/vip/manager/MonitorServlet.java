package cooperation.vip.manager;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.vip.pb.mobile_monitor_report.ExceptionReport;
import cooperation.vip.pb.mobile_monitor_report.PkgExceptionReq;
import cooperation.vip.pb.mobile_monitor_report.PkgRsp;
import cooperation.vip.pb.mobile_monitor_report.PkgTraceReq;
import cooperation.vip.pb.mobile_monitor_report.TraceReport;
import cooperation.vip.pb.mobile_monitor_report.UserCommReport;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.new_year_2014.Unisso.UniSsoServerReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerReqComm;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;

public class MonitorServlet
  extends MSFServlet
{
  private static int a()
  {
    int j = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    int i = 4;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            return 1;
          }
        }
        else {
          return 5;
        }
      }
      else {
        return 6;
      }
    }
    else {
      i = 3;
    }
    return i;
  }
  
  private static mobile_monitor_report.UserCommReport a()
  {
    mobile_monitor_report.UserCommReport localUserCommReport = new mobile_monitor_report.UserCommReport();
    localUserCommReport.qua.set(String.valueOf(QUA.getQUA3()));
    localUserCommReport.imei.set(String.valueOf(MobileInfoUtil.getImei()));
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    localUserCommReport.city_code.set(str);
    localUserCommReport.mobile_type.set(Build.MODEL);
    localUserCommReport.net_type.set(a());
    localUserCommReport.from_id.set(2);
    return localUserCommReport;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    else
    {
      localObject = null;
    }
    mobile_monitor_report.PkgRsp localPkgRsp = new mobile_monitor_report.PkgRsp();
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000) {
      try
      {
        paramFromServiceMsg = new Unisso.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom((byte[])localObject);
        long l = paramFromServiceMsg.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("MonitorServlet", 1, new Object[] { " unissoResult=", Long.valueOf(l) });
        }
        localPkgRsp.mergeFrom(paramFromServiceMsg.rspdata.get().toByteArray());
        i = localPkgRsp.ret.get();
        if (i == 0)
        {
          MonitorManager.a().a(localPkgRsp.mult_cnt.get(), localPkgRsp.mult_delay.get());
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("onReceive ret ");
            paramFromServiceMsg.append(i);
            QLog.d("MonitorServlet", 2, paramFromServiceMsg.toString());
          }
          notifyObserver(paramIntent, 1000, true, new Bundle(), MonitorObserver.class);
          return;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive ret ");
        paramFromServiceMsg.append(i);
        QLog.d("MonitorServlet", 2, paramFromServiceMsg.toString());
        notifyObserver(paramIntent, 1000, false, new Bundle(), MonitorObserver.class);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive exception ");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.e("MonitorServlet", 2, ((StringBuilder)localObject).toString());
        notifyObserver(paramIntent, 1000, false, new Bundle(), MonitorObserver.class);
        return;
      }
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("onReceive result fail with result ");
    paramFromServiceMsg.append(i);
    QLog.e("MonitorServlet", 2, paramFromServiceMsg.toString());
    notifyObserver(paramIntent, 1000, false, new Bundle(), MonitorObserver.class);
  }
  
  public static void a(List<mobile_monitor_report.ExceptionReport> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    mobile_monitor_report.PkgExceptionReq localPkgExceptionReq = new mobile_monitor_report.PkgExceptionReq();
    localPkgExceptionReq.exception_report.set(paramList);
    paramList = a();
    localPkgExceptionReq.user_comm_report.set(paramList);
    paramList = new NewIntent(localAppRuntime.getApplication(), MonitorServlet.class);
    Unisso.UniSsoServerReq localUniSsoServerReq = new Unisso.UniSsoServerReq();
    Unisso.UniSsoServerReqComm localUniSsoServerReqComm = new Unisso.UniSsoServerReqComm();
    localUniSsoServerReqComm.platform.set(109L);
    localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
    localUniSsoServerReqComm.mqqver.set("8.7.0");
    localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
    localUniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(localPkgExceptionReq.toByteArray()));
    paramList.putExtra("data", WupUtil.a(localUniSsoServerReq.toByteArray()));
    paramList.putExtra("cmd", "MobileReport.ExceptionReport");
    localAppRuntime.startServlet(paramList);
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    else
    {
      localObject = null;
    }
    mobile_monitor_report.PkgRsp localPkgRsp = new mobile_monitor_report.PkgRsp();
    int i = paramFromServiceMsg.getResultCode();
    if ((i == 1000) && (localObject != null)) {
      try
      {
        paramFromServiceMsg = new Unisso.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom((byte[])localObject);
        long l = paramFromServiceMsg.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("MonitorServlet", 1, new Object[] { " unissoResult=", Long.valueOf(l) });
        }
        localPkgRsp.mergeFrom(paramFromServiceMsg.rspdata.get().toByteArray());
        i = localPkgRsp.ret.get();
        if (i == 0)
        {
          MonitorManager.a().a(localPkgRsp.mult_cnt.get(), localPkgRsp.mult_delay.get());
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("onReceive ret ");
            paramFromServiceMsg.append(i);
            QLog.d("MonitorServlet", 2, paramFromServiceMsg.toString());
          }
          notifyObserver(paramIntent, 1000, true, new Bundle(), MonitorObserver.class);
          return;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive ret ");
        paramFromServiceMsg.append(i);
        QLog.d("MonitorServlet", 2, paramFromServiceMsg.toString());
        notifyObserver(paramIntent, 1000, false, new Bundle(), MonitorObserver.class);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive exception ");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.e("MonitorServlet", 2, ((StringBuilder)localObject).toString());
        notifyObserver(paramIntent, 1000, false, new Bundle(), MonitorObserver.class);
        return;
      }
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("onReceive result fail with result ");
    paramFromServiceMsg.append(i);
    QLog.e("MonitorServlet", 2, paramFromServiceMsg.toString());
    notifyObserver(paramIntent, 1000, false, new Bundle(), MonitorObserver.class);
  }
  
  public static void b(List<mobile_monitor_report.TraceReport> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    mobile_monitor_report.PkgTraceReq localPkgTraceReq = new mobile_monitor_report.PkgTraceReq();
    localPkgTraceReq.trace_report.set(paramList);
    paramList = a();
    localPkgTraceReq.user_comm_report.set(paramList);
    paramList = new NewIntent(localAppRuntime.getApplication(), MonitorServlet.class);
    Unisso.UniSsoServerReq localUniSsoServerReq = new Unisso.UniSsoServerReq();
    Unisso.UniSsoServerReqComm localUniSsoServerReqComm = new Unisso.UniSsoServerReqComm();
    localUniSsoServerReqComm.platform.set(109L);
    localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
    localUniSsoServerReqComm.mqqver.set("8.7.0");
    localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
    localUniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(localPkgTraceReq.toByteArray()));
    paramList.putExtra("data", WupUtil.a(localUniSsoServerReq.toByteArray()));
    paramList.putExtra("cmd", "MobileReport.TraceReport");
    localAppRuntime.startServlet(paramList);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      QLog.d("MonitorServlet", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if (str == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resp:");
        localStringBuilder.append(str);
        localStringBuilder.append(" is ");
        if (bool) {
          localObject = "";
        } else {
          localObject = "not";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" success");
        QLog.d("MonitorServlet", 2, localStringBuilder.toString());
      }
      if (str.equals("MobileReport.ExceptionReport"))
      {
        a(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("MobileReport.TraceReport")) {
        b(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("MonitorServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.MonitorServlet
 * JD-Core Version:    0.7.0.1
 */