package com.tencent.qqmini.miniapp.core.page.widget;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppTextArea$2
  implements Runnable
{
  MiniAppTextArea$2(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void run()
  {
    QMLog.e("MiniAppTextArea", "hideCurrentInput set isFocused false");
    MiniAppTextArea.access$802(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.2
 * JD-Core Version:    0.7.0.1
 */