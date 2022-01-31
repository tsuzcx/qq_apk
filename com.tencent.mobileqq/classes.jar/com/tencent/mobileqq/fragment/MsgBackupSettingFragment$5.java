package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import asoi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
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
    long l = localMsgBackupJniProxy.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), new MsgBackupNotifier());
    QLog.d("MsgBackup", 1, "createSession end, session = " + l);
    MsgBackupSettingFragment.a(this.this$0, new MsgBackupEndPoint());
    MsgBackupSettingFragment.b(this.this$0, new MsgBackupEndPoint());
    int i = localMsgBackupJniProxy.start(l, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    QLog.d("MsgBackup", 1, "after start called with ret = " + i + ", ipv4 = " + asoi.a(MsgBackupSettingFragment.a(this.this$0).ipv4) + ", port = " + MsgBackupSettingFragment.a(this.this$0).port);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */