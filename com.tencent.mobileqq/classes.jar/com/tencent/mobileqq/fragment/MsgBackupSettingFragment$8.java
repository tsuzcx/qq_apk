package com.tencent.mobileqq.fragment;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthHandler;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
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
    this.this$0.a = new MsgBackupJniProxy((Context)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "loadSo msgbackup end for client");
    }
    MsgBackupSettingFragment.a(this.this$0, 1);
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    localObject = this.this$0;
    ((MsgBackupSettingFragment)localObject).b = ((MsgBackupSettingFragment)localObject).a.createSession(1, Long.parseLong(this.this$0.getBaseActivity().app.getCurrentAccountUin()), i, new MsgBackupNotifier());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createSession end, operator = ");
      ((StringBuilder)localObject).append(this.this$0.b);
      QLog.d("MsgBackup", 2, ((StringBuilder)localObject).toString());
    }
    i = this.this$0.a.start(this.this$0.b, MsgBackupSettingFragment.c(this.this$0), MsgBackupSettingFragment.d(this.this$0), MsgBackupSettingFragment.e(this.this$0));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start ret = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ip = ");
      ((StringBuilder)localObject).append(MsgBackupSettingFragment.c(this.this$0)[0]);
      ((StringBuilder)localObject).append(", udpport = ");
      ((StringBuilder)localObject).append(MsgBackupSettingFragment.d(this.this$0));
      ((StringBuilder)localObject).append(", tcpport = ");
      ((StringBuilder)localObject).append(MsgBackupSettingFragment.e(this.this$0));
      QLog.d("MsgBackup", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new MsgBackupUserData.Builder();
    ((MsgBackupUserData.Builder)localObject).c(MsgBackupSettingFragment.f(this.this$0)[1]);
    ((MsgBackupUserData.Builder)localObject).b(MsgBackupSettingFragment.f(this.this$0)[0]);
    ArrayList localArrayList = new ArrayList(2);
    ((MsgBackupUserData.Builder)localObject).a(MsgBackupTransportProcessor.a().c());
    localArrayList.add(Integer.valueOf(MsgBackupTransportProcessor.a().e()));
    localArrayList.add(Integer.valueOf(MsgBackupTransportProcessor.a().d()));
    ((MsgBackupUserData.Builder)localObject).a(localArrayList);
    localObject = ((MsgBackupUserData.Builder)localObject).a();
    ((MsgBackupAuthHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).a((MsgBackupUserData)localObject, MsgBackupSettingFragment.j(this.this$0), MsgBackupSettingFragment.k(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */