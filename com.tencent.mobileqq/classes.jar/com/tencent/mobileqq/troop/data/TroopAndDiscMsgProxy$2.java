package com.tencent.mobileqq.troop.data;

import azri;
import bbqi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class TroopAndDiscMsgProxy$2
  implements Runnable
{
  public TroopAndDiscMsgProxy$2(bbqi parambbqi, boolean paramBoolean) {}
  
  public void run()
  {
    azri localazri = azri.a(BaseApplication.getContext());
    String str = bbqi.a(this.this$0).getCurrentAccountUin();
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      localazri.a(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */