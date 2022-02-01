package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.qphone.base.util.QLog;

class MsgBackupSettingFragment$5
  implements Runnable
{
  MsgBackupSettingFragment$5(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void run()
  {
    QLog.d("MsgBackup", 1, "loadSo start");
    Object localObject = new MsgBackupJniProxy(this.this$0.getBaseActivity());
    QLog.d("MsgBackup", 1, "loadSo end");
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    long l = ((MsgBackupJniProxy)localObject).createSession(1, Long.parseLong(this.this$0.getBaseActivity().app.getCurrentAccountUin()), i, new MsgBackupNotifier());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createSession end, session = ");
    localStringBuilder.append(l);
    QLog.d("MsgBackup", 1, localStringBuilder.toString());
    i = ((MsgBackupJniProxy)localObject).start(l, MsgBackupSettingFragment.c(this.this$0), MsgBackupSettingFragment.d(this.this$0), MsgBackupSettingFragment.e(this.this$0));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start ret = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", ip = ");
    ((StringBuilder)localObject).append(MsgBackupSettingFragment.c(this.this$0)[0]);
    ((StringBuilder)localObject).append(", udpport = ");
    ((StringBuilder)localObject).append(MsgBackupSettingFragment.d(this.this$0));
    ((StringBuilder)localObject).append(", tcpport = ");
    ((StringBuilder)localObject).append(MsgBackupSettingFragment.e(this.this$0));
    QLog.d("MsgBackup", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */