package com.tencent.mobileqq.managers;

import android.text.TextUtils;
import aseh;
import axqy;

public class CUOpenCardGuideMng$CUOpenCardClickableSpan$2
  implements Runnable
{
  public CUOpenCardGuideMng$CUOpenCardClickableSpan$2(aseh paramaseh) {}
  
  public void run()
  {
    String str;
    if (this.this$0.a == 1) {
      str = "0X8008127";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        axqy.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (this.this$0.a == 2) {
        str = "0X8008125";
      } else if ((this.this$0.a == 3) || (this.this$0.a == 4)) {
        str = "0X800813F";
      } else {
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.2
 * JD-Core Version:    0.7.0.1
 */