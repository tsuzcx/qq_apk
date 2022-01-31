package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import augc;
import auhn;
import aujh;
import aujq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
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
    this.this$0.jdField_a_of_type_Long = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), new MsgBackupNotifier());
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "createSession end, operator = " + this.this$0.jdField_a_of_type_Long);
    }
    MsgBackupSettingFragment.b(this.this$0, new MsgBackupEndPoint());
    MsgBackupSettingFragment.a(this.this$0, new MsgBackupEndPoint());
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.start(this.this$0.jdField_a_of_type_Long, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "after start called with ret = " + i + ", ipv4 = " + aujq.a(MsgBackupSettingFragment.a(this.this$0).ipv4) + ", udpport = " + MsgBackupSettingFragment.a(this.this$0).port + ", tcpport = " + MsgBackupSettingFragment.b(this.this$0).port);
    }
    localObject = new auhn();
    ((auhn)localObject).c(MsgBackupSettingFragment.a(this.this$0)[1]);
    ((auhn)localObject).b(MsgBackupSettingFragment.a(this.this$0)[0]);
    ArrayList localArrayList = new ArrayList(2);
    ((auhn)localObject).a(aujq.a(aujh.a().b().ipv4));
    localArrayList.add(Integer.valueOf(aujh.a().b().port));
    localArrayList.add(Integer.valueOf(aujh.a().a().port));
    ((auhn)localObject).a(localArrayList);
    localObject = ((auhn)localObject).a();
    ((augc)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(162)).a((MsgBackupUserData)localObject, MsgBackupSettingFragment.c(this.this$0), MsgBackupSettingFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */