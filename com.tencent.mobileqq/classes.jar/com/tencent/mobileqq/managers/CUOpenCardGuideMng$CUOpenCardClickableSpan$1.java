package com.tencent.mobileqq.managers;

import android.text.TextUtils;
import avmy;
import bcef;

public class CUOpenCardGuideMng$CUOpenCardClickableSpan$1
  implements Runnable
{
  public CUOpenCardGuideMng$CUOpenCardClickableSpan$1(avmy paramavmy) {}
  
  public void run()
  {
    String str;
    if (this.this$0.a == 1) {
      str = "0X8008124";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        bcef.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (this.this$0.a == 2) {
        str = "0X8008126";
      } else if ((this.this$0.a == 3) || (this.this$0.a == 4)) {
        str = "0X800813E";
      } else {
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.1
 * JD-Core Version:    0.7.0.1
 */