package com.tencent.mobileqq.webview.sonic;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class SonicRuntimeImpl$1
  implements Runnable
{
  SonicRuntimeImpl$1(SonicRuntimeImpl paramSonicRuntimeImpl) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplication.getContext().getApplicationContext(), "无法在系统内核下启用Sonic", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicRuntimeImpl.1
 * JD-Core Version:    0.7.0.1
 */