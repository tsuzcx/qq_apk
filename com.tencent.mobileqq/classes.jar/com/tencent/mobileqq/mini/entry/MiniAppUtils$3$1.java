package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.qphone.base.util.QLog;

class MiniAppUtils$3$1
  implements Runnable
{
  MiniAppUtils$3$1(MiniAppUtils.3 param3, WebSoCgiService.WebSoCgiState paramWebSoCgiState) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.val$filePath);
      ((StringBuilder)localObject).append("__temp");
      localObject = ((StringBuilder)localObject).toString();
      FileUtils.writeFile((String)localObject, this.val$cgiState.d);
      FileUtils.moveFile((String)localObject, this.this$0.val$filePath);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--- prefetch cache data finished :");
      ((StringBuilder)localObject).append(this.this$0.val$requestUrl);
      QLog.d("MiniAppUtils", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppUtils", 1, "saveToMiniAppStorage ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.3.1
 * JD-Core Version:    0.7.0.1
 */