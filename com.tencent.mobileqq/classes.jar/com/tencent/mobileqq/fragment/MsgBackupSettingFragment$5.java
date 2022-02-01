package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
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
    MsgBackupJniProxy localMsgBackupJniProxy = new MsgBackupJniProxy(this.this$0.getActivity());
    QLog.d("MsgBackup", 1, "loadSo end");
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    long l = localMsgBackupJniProxy.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), i, new MsgBackupNotifier());
    QLog.d("MsgBackup", 1, "createSession end, session = " + l);
    i = localMsgBackupJniProxy.start(l, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    QLog.d("MsgBackup", 1, "start ret = " + i + ", ip = " + MsgBackupSettingFragment.a(this.this$0)[0] + ", udpport = " + MsgBackupSettingFragment.a(this.this$0) + ", tcpport = " + MsgBackupSettingFragment.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */