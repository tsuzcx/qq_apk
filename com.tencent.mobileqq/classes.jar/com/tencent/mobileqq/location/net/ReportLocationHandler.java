package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate.ReqReportLocation;
import tencent.im.oidb.location.RoomOperate.RspReportLocation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class ReportLocationHandler
  extends BaseProto<LocationHandler>
{
  private static int a = 2000;
  private final Handler b = new Handler(ThreadManager.getSubThreadLooper());
  private final AtomicBoolean c = new AtomicBoolean(true);
  private Runnable d;
  private int e;
  private Long f;
  private ReportLocationHandler.OnGetLocationCallback g;
  
  private void a(int paramInt, long paramLong, LocationItem paramLocationItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uinType = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], sessionUin = [");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], locationItem = [");
      ((StringBuilder)localObject).append(paramLocationItem);
      ((StringBuilder)localObject).append("]");
      QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocation: invoked. ", ((StringBuilder)localObject).toString() });
    }
    Object localObject = new RoomOperate.ReqReportLocation();
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    qq_lbs_share.RoomKey localRoomKey = LocationProtoUtil.a(localAppRuntime, 0, paramLong);
    ((RoomOperate.ReqReportLocation)localObject).room_key.set(localRoomKey);
    ((RoomOperate.ReqReportLocation)localObject).room_key.setHasFlag(true);
    ((RoomOperate.ReqReportLocation)localObject).direction.set(paramLocationItem.b());
    paramLocationItem = paramLocationItem.a();
    if (paramLocationItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocation: invoked. ", " latLng: ", paramLocationItem });
      }
      return;
    }
    ((RoomOperate.ReqReportLocation)localObject).lat.set(paramLocationItem.latitude);
    ((RoomOperate.ReqReportLocation)localObject).lon.set(paramLocationItem.longitude);
    paramLocationItem = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), "QQLBSShareSvc.report_location");
    paramLocationItem.putWupBuffer(((RoomOperate.ReqReportLocation)localObject).toByteArray());
    a().sendPbReq(paramLocationItem);
  }
  
  private void g() {}
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, new Object[] { "stopReport: invoked. ", " loopReportStopped: ", this.c });
    }
    this.c.set(true);
    Runnable localRunnable = this.d;
    if (localRunnable != null) {
      this.b.removeCallbacks(localRunnable);
    }
  }
  
  protected LocationHandler a()
  {
    return LocationHandler.a();
  }
  
  public void a(String paramString, int paramInt, ReportLocationHandler.OnGetLocationCallback paramOnGetLocationCallback)
  {
    this.g = paramOnGetLocationCallback;
    if (!this.c.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "startReportInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.c.set(false);
    this.d = new ReportLocationHandler.1(this, paramInt, paramString);
    this.b.post(this.d);
  }
  
  public boolean a(LocationRoom.RoomKey paramRoomKey)
  {
    if (!c()) {
      return false;
    }
    int i = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.f);
    return new LocationRoom.RoomKey(i, localStringBuilder.toString()).equals(paramRoomKey);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(e())) && (e().equals(paramString)) && (d() == paramInt);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, "destroy: invoked. ");
    }
    h();
    this.b.removeCallbacksAndMessages(null);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject))
    {
      try
      {
        paramToServiceMsg = (RoomOperate.RspReportLocation)new RoomOperate.RspReportLocation().mergeFrom((byte[])paramObject);
        if (LocationProtoUtil.a((qq_lbs_share.ResultInfo)paramToServiceMsg.msg_result.get()))
        {
          i = paramToServiceMsg.req_interval.get();
          if (i != 0) {
            a = i * 1000;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " intervalMillis: ", Integer.valueOf(a) });
          return;
        }
        g();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ReportLocationHandler", 1, "requestReportLocationResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    else
    {
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
        }
      }
      g();
    }
  }
  
  public boolean c()
  {
    return this.c.get() ^ true;
  }
  
  int d()
  {
    return this.e;
  }
  
  String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler
 * JD-Core Version:    0.7.0.1
 */