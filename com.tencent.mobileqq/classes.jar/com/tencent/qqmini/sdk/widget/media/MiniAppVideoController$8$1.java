package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;

class MiniAppVideoController$8$1
  implements Runnable
{
  MiniAppVideoController$8$1(MiniAppVideoController.8 param8) {}
  
  public void run()
  {
    MiniAppVideoController.access$300(this.this$1.this$0).updateCenterBtn(MiniAppVideoController.access$000(this.this$1.this$0));
    MiniAppVideoController.access$300(this.this$1.this$0).hideControllerPopContainer();
    MiniAppVideoController.access$2600(this.this$1.this$0).removeMessages(2002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.8.1
 * JD-Core Version:    0.7.0.1
 */