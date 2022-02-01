package com.tencent.mobileqq.hotchat.app;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$5
  implements Runnable
{
  HotChatShare$5(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    if (this.this$0.mLoading != null)
    {
      if (!this.this$0.mLoading.isShowing()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "30s has gone, goto share....");
      }
      this.this$0.hideProgress();
      HotChatShare.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatShare.5
 * JD-Core Version:    0.7.0.1
 */