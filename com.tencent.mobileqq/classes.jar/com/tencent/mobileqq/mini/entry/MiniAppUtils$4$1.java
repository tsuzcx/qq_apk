package com.tencent.mobileqq.mini.entry;

import bgyr;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class MiniAppUtils$4$1
  implements Runnable
{
  MiniAppUtils$4$1(MiniAppUtils.4 param4, bgyr parambgyr) {}
  
  public void run()
  {
    try
    {
      String str = this.this$0.val$filePath + "__temp";
      FileUtils.writeFile(str, this.val$cgiState.d);
      FileUtils.moveFile(str, this.this$0.val$filePath);
      QLog.d("MiniAppUtils", 1, "--- prefetch cache data finished :" + this.this$0.val$requestUrl);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppUtils", 1, "saveToMiniAppStorage ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.4.1
 * JD-Core Version:    0.7.0.1
 */