package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import bacn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class JumpAction$17
  implements Runnable
{
  public JumpAction$17(bacn parambacn) {}
  
  public void run()
  {
    if (bacn.a(this.this$0) == null) {}
    String str;
    do
    {
      return;
      str = bacn.a(this.this$0).getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.a(str, "key_reader_click_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.17
 * JD-Core Version:    0.7.0.1
 */