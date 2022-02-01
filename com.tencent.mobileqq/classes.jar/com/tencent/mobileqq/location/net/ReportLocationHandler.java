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
  private static int jdField_a_of_type_Int = 2000;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private ReportLocationHandler.OnGetLocationCallback jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler$OnGetLocationCallback;
  private Long jdField_a_of_type_JavaLangLong;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private int b;
  
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
    ((RoomOperate.ReqReportLocation)localObject).direction.set(paramLocationItem.a());
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
  
  private void b() {}
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, new Object[] { "stopReport: invoked. ", " loopReportStopped: ", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localRunnable);
    }
  }
  
  int a()
  {
    return this.b;
  }
  
  protected LocationHandler a()
  {
    return LocationHandler.a();
  }
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, "destroy: invoked. ");
    }
    c();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
            jdField_a_of_type_Int = i * 1000;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " intervalMillis: ", Integer.valueOf(jdField_a_of_type_Int) });
          return;
        }
        b();
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
      b();
    }
  }
  
  public void a(String paramString, int paramInt, ReportLocationHandler.OnGetLocationCallback paramOnGetLocationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler$OnGetLocationCallback = paramOnGetLocationCallback;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "startReportInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaLangRunnable = new ReportLocationHandler.1(this, paramInt, paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() ^ true;
  }
  
  public boolean a(LocationRoom.RoomKey paramRoomKey)
  {
    if (!a()) {
      return false;
    }
    int i = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    return new LocationRoom.RoomKey(i, localStringBuilder.toString()).equals(paramRoomKey);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(a())) && (a().equals(paramString)) && (a() == paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler
 * JD-Core Version:    0.7.0.1
 */