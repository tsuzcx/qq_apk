package com.tencent.mobileqq.troop.data;

import azmz;
import bblz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class TroopAndDiscMsgProxy$2
  implements Runnable
{
  public TroopAndDiscMsgProxy$2(bblz parambblz, boolean paramBoolean) {}
  
  public void run()
  {
    azmz localazmz = azmz.a(BaseApplication.getContext());
    String str = bblz.a(this.this$0).getCurrentAccountUin();
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      localazmz.a(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */