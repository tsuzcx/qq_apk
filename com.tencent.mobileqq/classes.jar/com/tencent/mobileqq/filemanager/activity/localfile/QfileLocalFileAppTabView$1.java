package com.tencent.mobileqq.filemanager.activity.localfile;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

class QfileLocalFileAppTabView$1
  implements Runnable
{
  QfileLocalFileAppTabView$1(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    if (this.this$0.getAccessAppListPermission())
    {
      QfileLocalFileAppTabView.a(this.this$0);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QfileLocalFileAppTabView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1
 * JD-Core Version:    0.7.0.1
 */