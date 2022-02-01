package com.tencent.mobileqq.nearby.ipc;

import android.os.Message;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.qphone.base.util.QLog;

class ConnectNearbyProcService$1
  extends MainProcessInterface.Stub
{
  ConnectNearbyProcService$1(ConnectNearbyProcService paramConnectNearbyProcService) {}
  
  public Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    return ConnectNearbyProcService.a(this.a, paramMessage);
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    if (paramBasicTypeDataParcel == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby_ipc_log_tag", 2, paramBasicTypeDataParcel.toString());
    }
    Object[] arrayOfObject = ConnectNearbyProcService.a(this.a, paramBasicTypeDataParcel.a, paramBasicTypeDataParcel.b);
    if (arrayOfObject == null) {
      return null;
    }
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.a, arrayOfObject);
  }
  
  public void a(NearbyProcessInterface paramNearbyProcessInterface)
  {
    ConnectNearbyProcService.a(paramNearbyProcessInterface);
    if (ConnectNearbyProcService.a(this.a) != null) {
      ConnectNearbyProcService.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService.1
 * JD-Core Version:    0.7.0.1
 */