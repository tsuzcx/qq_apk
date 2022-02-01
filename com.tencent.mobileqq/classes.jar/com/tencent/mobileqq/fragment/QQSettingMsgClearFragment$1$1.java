package com.tencent.mobileqq.fragment;

import alay;
import android.os.Handler;
import aunr;
import bcvc;
import bgsg;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  public QQSettingMsgClearFragment$1$1(aunr paramaunr) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a.getActivity(), QQSettingMsgClearFragment.a(this.a.a));
    bcvc.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    bgsg.a(QQSettingMsgClearFragment.a(this.a.a).c());
    alay.a().a(0L);
    QQSettingMsgHistoryActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */