package com.tencent.mobileqq.fragment;

import almo;
import android.os.Handler;
import avfr;
import bdnv;
import bhsi;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  public QQSettingMsgClearFragment$1$1(avfr paramavfr) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a.getActivity(), QQSettingMsgClearFragment.a(this.a.a));
    bdnv.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    bhsi.a(QQSettingMsgClearFragment.a(this.a.a).c());
    almo.a().a(0L);
    QQSettingMsgHistoryActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */