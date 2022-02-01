package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class TroopAndDiscMsgProxy$2
  implements Runnable
{
  public void run()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((QQAppInterface)TroopAndDiscMsgProxy.a(this.this$0)).getCurrentAccountUin(), "aio_break_point", this.a ^ true, 0L, 0L, new HashMap(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */