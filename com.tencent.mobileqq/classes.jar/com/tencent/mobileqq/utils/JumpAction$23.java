package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bddb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class JumpAction$23
  implements Runnable
{
  public JumpAction$23(bddb parambddb) {}
  
  public void run()
  {
    if (bddb.a(this.this$0) == null) {}
    String str;
    do
    {
      return;
      str = bddb.a(this.this$0).getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.c(str, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.23
 * JD-Core Version:    0.7.0.1
 */