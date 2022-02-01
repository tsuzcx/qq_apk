package com.tencent.mobileqq.richstatus;

import android.widget.TextView;

class AioFriendTitleHelper$2
  implements Runnable
{
  AioFriendTitleHelper$2(AioFriendTitleHelper paramAioFriendTitleHelper, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    AioFriendTitleHelper.a(this.this$0, this.a);
    if ((!this.this$0.h()) || (!this.a))
    {
      AioFriendTitleHelper.b(this.this$0).setText(this.b);
      this.this$0.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.2
 * JD-Core Version:    0.7.0.1
 */