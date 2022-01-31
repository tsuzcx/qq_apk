package com.tencent.mobileqq.fragment;

import ahmt;
import android.os.Handler;
import aqje;
import axty;
import bbjn;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  public QQSettingMsgClearFragment$1$1(aqje paramaqje) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a.getActivity(), QQSettingMsgClearFragment.a(this.a.a));
    axty.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    bbjn.a(QQSettingMsgClearFragment.a(this.a.a).c());
    ahmt.a().a(0L);
    QQSettingMsgHistoryActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */