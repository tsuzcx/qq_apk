package com.tencent.mobileqq.nearby.ipc;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class NearbyProcess$2
  extends NearbyProcessInterface.Stub
{
  NearbyProcess$2(NearbyProcess paramNearbyProcess) {}
  
  public Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    return this.a.b(paramMessage);
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    if (paramBasicTypeDataParcel == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby_ipc_log_tag", 2, paramBasicTypeDataParcel.toString());
    }
    Object[] arrayOfObject = this.a.b(paramBasicTypeDataParcel.a, paramBasicTypeDataParcel.b);
    if (arrayOfObject == null) {
      return null;
    }
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.a, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcess.2
 * JD-Core Version:    0.7.0.1
 */