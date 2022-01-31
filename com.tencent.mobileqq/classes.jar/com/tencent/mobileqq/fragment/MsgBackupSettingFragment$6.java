package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import aroo;
import arpz;
import arsc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
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
    arpz localarpz = new arpz();
    ArrayList localArrayList = new ArrayList(2);
    QLog.d("MsgBackup", 1, "loadSo start");
    this.this$0.a = new MsgBackupJniProxy(this.this$0.getActivity());
    QLog.d("MsgBackup", 1, "loadSo end");
    long l = this.this$0.a.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), new MsgBackupNotifier());
    QLog.d("MsgBackup", 1, "createSession end, session = " + l);
    MsgBackupSettingFragment.a(this.this$0, new MsgBackupEndPoint());
    MsgBackupSettingFragment.b(this.this$0, new MsgBackupEndPoint());
    int i = this.this$0.a.start(l, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    QLog.d("MsgBackup", 1, "after start called with ret = " + i + ", ipv4 = " + arsc.a(MsgBackupSettingFragment.a(this.this$0).ipv4) + ", port = " + MsgBackupSettingFragment.a(this.this$0).port);
    localarpz.c(MsgBackupSettingFragment.a(this.this$0)[1]);
    localarpz.b(MsgBackupSettingFragment.a(this.this$0)[0]);
    localarpz.a(arsc.a(MsgBackupSettingFragment.b(this.this$0).ipv4));
    localArrayList.add(Integer.valueOf(MsgBackupSettingFragment.b(this.this$0).port));
    localArrayList.add(Integer.valueOf(MsgBackupSettingFragment.a(this.this$0).port));
    localarpz.a(localArrayList);
    localarpz.a(4);
    MsgBackupSettingFragment.a(this.this$0).a(localarpz.a(), 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */