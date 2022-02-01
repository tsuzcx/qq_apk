package com.tencent.mobileqq.fragment;

import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SharedPreUtils;

class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  QQSettingMsgClearFragment$1$1(QQSettingMsgClearFragment.1 param1) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a.getBaseActivity(), QQSettingMsgClearFragment.a(this.a.a));
    StorageReport.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    SharedPreUtils.a(QQSettingMsgClearFragment.a(this.a.a).getCurrentUin());
    QQSettingMsgHistoryActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */