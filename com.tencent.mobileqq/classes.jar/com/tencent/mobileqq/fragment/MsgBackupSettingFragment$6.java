package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import avte;
import avup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
    avup localavup = new avup();
    ArrayList localArrayList = new ArrayList(2);
    QLog.d("MsgBackup", 1, "loadSo start");
    this.this$0.a = new MsgBackupJniProxy(this.this$0.getActivity());
    QLog.d("MsgBackup", 1, "loadSo end");
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    long l = this.this$0.a.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), i, new MsgBackupNotifier());
    QLog.d("MsgBackup", 1, "createSession end, session = " + l);
    i = this.this$0.a.start(l, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    QLog.d("MsgBackup", 1, "start ret = " + i + ", ip = " + MsgBackupSettingFragment.a(this.this$0)[0] + ", udpport = " + MsgBackupSettingFragment.a(this.this$0) + ", tcpport = " + MsgBackupSettingFragment.b(this.this$0));
    localavup.c(MsgBackupSettingFragment.b(this.this$0)[1]);
    localavup.b(MsgBackupSettingFragment.b(this.this$0)[0]);
    localavup.a(MsgBackupSettingFragment.a(this.this$0)[0]);
    localArrayList.add(Integer.valueOf(MsgBackupSettingFragment.b(this.this$0).intValue()));
    localArrayList.add(Integer.valueOf(MsgBackupSettingFragment.a(this.this$0).intValue()));
    localavup.a(localArrayList);
    localavup.a(4);
    MsgBackupSettingFragment.a(this.this$0).a(localavup.a(), 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */