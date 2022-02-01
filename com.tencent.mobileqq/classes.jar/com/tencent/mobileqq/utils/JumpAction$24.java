package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bfvp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class JumpAction$24
  implements Runnable
{
  public JumpAction$24(bfvp parambfvp) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    String str;
    do
    {
      return;
      str = this.this$0.a.getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.a(str, "key_reader_click_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.24
 * JD-Core Version:    0.7.0.1
 */