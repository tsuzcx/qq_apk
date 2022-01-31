package com.tencent.mobileqq.nearby.redtouch;

import aeyw;
import com.tencent.mobileqq.app.QQAppInterface;

public class DefaultRedPointPreHandler
  implements aeyw
{
  QQAppInterface a;
  
  public DefaultRedPointPreHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt == 10016) || (paramInt == 10015)) {
      bool1 = Util.a(this.a);
    }
    for (;;)
    {
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramRedTouchItem.isClosed = bool1;
        return;
        if (paramInt != 100601) {
          break label60;
        }
        bool1 = Util.b(this.a);
        break;
      }
      label60:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.DefaultRedPointPreHandler
 * JD-Core Version:    0.7.0.1
 */