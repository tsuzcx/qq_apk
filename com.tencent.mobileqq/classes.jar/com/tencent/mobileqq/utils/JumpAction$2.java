package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bbeg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class JumpAction$2
  implements Runnable
{
  public JumpAction$2(bbeg parambbeg) {}
  
  public void run()
  {
    if (bbeg.a(this.this$0) == null) {}
    String str;
    do
    {
      return;
      str = bbeg.a(this.this$0).getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.a(str, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.2
 * JD-Core Version:    0.7.0.1
 */