package com.tencent.mobileqq.troop.data;

import axrn;
import aznq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class TroopAndDiscMsgProxy$2
  implements Runnable
{
  public TroopAndDiscMsgProxy$2(aznq paramaznq, boolean paramBoolean) {}
  
  public void run()
  {
    axrn localaxrn = axrn.a(BaseApplication.getContext());
    String str = aznq.a(this.this$0).getCurrentAccountUin();
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */