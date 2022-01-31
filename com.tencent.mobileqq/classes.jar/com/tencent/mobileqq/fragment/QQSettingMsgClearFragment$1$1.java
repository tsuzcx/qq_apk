package com.tencent.mobileqq.fragment;

import ahae;
import android.os.Handler;
import appq;
import awtx;
import baig;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  public QQSettingMsgClearFragment$1$1(appq paramappq) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a.getActivity(), QQSettingMsgClearFragment.a(this.a.a));
    awtx.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    baig.a(QQSettingMsgClearFragment.a(this.a.a).c());
    ahae.a().a(0L);
    QQSettingMsgHistoryActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */