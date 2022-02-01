package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import awnf;
import awoq;
import awql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class MsgBackupSettingFragment$8
  implements Runnable
{
  MsgBackupSettingFragment$8(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "loadSo msgbackup start for client");
    }
    Object localObject = BaseApplicationImpl.getContext();
    this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy = new MsgBackupJniProxy((Context)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "loadSo msgbackup end for client");
    }
    MsgBackupSettingFragment.a(this.this$0, 1);
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), i, new MsgBackupNotifier());
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "createSession end, operator = " + this.this$0.jdField_a_of_type_Long);
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "start ret = " + i + ", ip = " + MsgBackupSettingFragment.a(this.this$0)[0] + ", udpport = " + MsgBackupSettingFragment.a(this.this$0) + ", tcpport = " + MsgBackupSettingFragment.b(this.this$0));
    }
    localObject = new awoq();
    ((awoq)localObject).c(MsgBackupSettingFragment.b(this.this$0)[1]);
    ((awoq)localObject).b(MsgBackupSettingFragment.b(this.this$0)[0]);
    ArrayList localArrayList = new ArrayList(2);
    ((awoq)localObject).a(awql.a().a());
    localArrayList.add(Integer.valueOf(awql.a().b()));
    localArrayList.add(Integer.valueOf(awql.a().a()));
    ((awoq)localObject).a(localArrayList);
    localObject = ((awoq)localObject).a();
    ((awnf)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(162)).a((MsgBackupUserData)localObject, MsgBackupSettingFragment.c(this.this$0), MsgBackupSettingFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */