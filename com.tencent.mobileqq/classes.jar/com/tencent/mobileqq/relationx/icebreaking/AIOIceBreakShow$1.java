package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.qphone.base.util.QLog;

class AIOIceBreakShow$1
  implements Runnable
{
  AIOIceBreakShow$1(AIOIceBreakShow paramAIOIceBreakShow, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = this.a;
    if (i == 1)
    {
      AIOIceBreakShow.a(this.this$0).e(this.b);
      AIOIceBreakShow.a(this.this$0).c();
    }
    else if (IceBreakingUtil.d(i))
    {
      AIOIceBreakShow.a(this.this$0).b(this.b);
      AIOIceBreakShow.a(this.this$0).d();
    }
    else if (IceBreakingUtil.e(this.a))
    {
      AIOIceBreakShow.a(this.this$0).c(this.b);
      AIOIceBreakShow.a(this.this$0).e();
    }
    else
    {
      AIOIceBreakShow.a(this.this$0).d(this.b);
      AIOIceBreakShow.a(this.this$0).b();
    }
    QLog.d("AIOIceBreakShow", 1, String.format("markEnteredFlag, type = %s, uin = %s", new Object[] { Integer.valueOf(this.a), this.b }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.1
 * JD-Core Version:    0.7.0.1
 */