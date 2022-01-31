package com.tencent.mobileqq.mini.entry;

import bace;
import bbds;
import com.tencent.qphone.base.util.QLog;

class MiniAppUtils$4$1
  implements Runnable
{
  MiniAppUtils$4$1(MiniAppUtils.4 param4, bbds parambbds) {}
  
  public void run()
  {
    try
    {
      String str = this.this$0.val$filePath + "__temp";
      bace.a(str, this.val$cgiState.d);
      bace.b(str, this.this$0.val$filePath);
      QLog.d("MiniAppUtils", 1, "--- prefetch cache data finished :" + this.this$0.val$requestUrl);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppUtils", 1, "saveToMiniAppStorage ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.4.1
 * JD-Core Version:    0.7.0.1
 */