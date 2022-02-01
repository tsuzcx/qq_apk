package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalUtils;

final class IceBreakingUtil$1
  implements Runnable
{
  IceBreakingUtil$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.a;
    if ((str != null) && (str.length() > 4))
    {
      if (!PortalUtils.b(this.a)) {
        return;
      }
      if (IceBreakingUtil.b(this.b))
      {
        IceBreakingUtil.a(this.c, this.a, this.d);
        return;
      }
      if (IceBreakingUtil.c(this.b))
      {
        IceBreakingUtil.b(this.c, this.a);
        return;
      }
      if (IceBreakingUtil.d(this.b))
      {
        IceBreakingUtil.c(this.c, this.a);
        return;
      }
      if (IceBreakingUtil.e(this.b))
      {
        IceBreakingUtil.d(this.c, this.a);
        return;
      }
      if (IceBreakingUtil.f(this.b)) {
        IceBreakingUtil.e(this.c, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil.1
 * JD-Core Version:    0.7.0.1
 */