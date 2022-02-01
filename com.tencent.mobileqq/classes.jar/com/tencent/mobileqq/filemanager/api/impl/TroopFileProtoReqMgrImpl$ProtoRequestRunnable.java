package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

class TroopFileProtoReqMgrImpl$ProtoRequestRunnable
  implements Runnable
{
  long jdField_a_of_type_Long;
  TroopFileProtoReqMgrImpl.ProtoResponse jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  
  TroopFileProtoReqMgrImpl$ProtoRequestRunnable(TroopFileProtoReqMgrImpl paramTroopFileProtoReqMgrImpl)
  {
    this.c = false;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_MqqAppNewIntent.getIntExtra("key_runnable_index", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cookie<");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append("> sendToMsf. scheduleIndex:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" timeOut:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("timeout", this.jdField_a_of_type_Long);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentMobileqqAppStatictisInfo;
    ((StatictisInfo)localObject).c += 1;
    TroopFileProtoReqMgrImpl.access$000(this.this$0).put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse);
    this.this$0.sendToMsf(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl.ProtoRequestRunnable
 * JD-Core Version:    0.7.0.1
 */