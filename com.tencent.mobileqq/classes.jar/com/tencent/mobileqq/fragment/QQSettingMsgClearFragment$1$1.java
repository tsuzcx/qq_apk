package com.tencent.mobileqq.fragment;

import alfy;
import android.os.Handler;
import auxr;
import bdne;
import bhhr;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  public QQSettingMsgClearFragment$1$1(auxr paramauxr) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a.getActivity(), QQSettingMsgClearFragment.a(this.a.a));
    bdne.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    bhhr.a(QQSettingMsgClearFragment.a(this.a.a).getCurrentUin());
    alfy.a().a(0L);
    QQSettingMsgHistoryActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */