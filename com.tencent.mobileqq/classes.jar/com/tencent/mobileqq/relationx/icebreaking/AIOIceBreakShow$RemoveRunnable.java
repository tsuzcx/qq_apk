package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class AIOIceBreakShow$RemoveRunnable
  implements Runnable
{
  private final int a;
  private final String b;
  
  public AIOIceBreakShow$RemoveRunnable(AIOIceBreakShow paramAIOIceBreakShow, int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public void run()
  {
    IceBreakingMng localIceBreakingMng = (IceBreakingMng)AIOIceBreakShow.e(this.this$0).d.getManager(QQManagerFactory.ICE_BREAKING_MNG);
    if (QLog.isColorLevel())
    {
      int i = this.a;
      if (i == 1) {
        localIceBreakingMng.m(this.b);
      } else if (IceBreakingUtil.d(i)) {
        localIceBreakingMng.n(this.b);
      } else if (IceBreakingUtil.e(this.a)) {
        localIceBreakingMng.o(this.b);
      } else {
        localIceBreakingMng.j(this.b);
      }
      QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", new Object[] { Integer.valueOf(this.a), this.b }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.RemoveRunnable
 * JD-Core Version:    0.7.0.1
 */