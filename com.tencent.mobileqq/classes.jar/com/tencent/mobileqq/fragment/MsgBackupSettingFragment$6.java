package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthHandler;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class MsgBackupSettingFragment$6
  implements Runnable
{
  MsgBackupSettingFragment$6(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void run()
  {
    MsgBackupUserData.Builder localBuilder = new MsgBackupUserData.Builder();
    ArrayList localArrayList = new ArrayList(2);
    QLog.d("MsgBackup", 1, "loadSo start");
    Object localObject = this.this$0;
    ((MsgBackupSettingFragment)localObject).a = new MsgBackupJniProxy(((MsgBackupSettingFragment)localObject).getBaseActivity());
    QLog.d("MsgBackup", 1, "loadSo end");
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    long l = this.this$0.a.createSession(1, Long.parseLong(this.this$0.getBaseActivity().app.getCurrentAccountUin()), i, new MsgBackupNotifier());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createSession end, session = ");
    ((StringBuilder)localObject).append(l);
    QLog.d("MsgBackup", 1, ((StringBuilder)localObject).toString());
    i = this.this$0.a.start(l, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start ret = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", ip = ");
    ((StringBuilder)localObject).append(MsgBackupSettingFragment.a(this.this$0)[0]);
    ((StringBuilder)localObject).append(", udpport = ");
    ((StringBuilder)localObject).append(MsgBackupSettingFragment.a(this.this$0));
    ((StringBuilder)localObject).append(", tcpport = ");
    ((StringBuilder)localObject).append(MsgBackupSettingFragment.b(this.this$0));
    QLog.d("MsgBackup", 1, ((StringBuilder)localObject).toString());
    localBuilder.c(MsgBackupSettingFragment.b(this.this$0)[1]);
    localBuilder.b(MsgBackupSettingFragment.b(this.this$0)[0]);
    localBuilder.a(MsgBackupSettingFragment.a(this.this$0)[0]);
    localArrayList.add(Integer.valueOf(MsgBackupSettingFragment.b(this.this$0).intValue()));
    localArrayList.add(Integer.valueOf(MsgBackupSettingFragment.a(this.this$0).intValue()));
    localBuilder.a(localArrayList);
    localBuilder.a(4);
    MsgBackupSettingFragment.a(this.this$0).a(localBuilder.a(), 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */