package com.tencent.mobileqq.mini.share;

import android.app.Activity;
import babr;
import bafb;
import bbmy;

class MiniProgramShareUtils$2$1
  implements Runnable
{
  MiniProgramShareUtils$2$1(MiniProgramShareUtils.2 param2, boolean paramBoolean, Boolean paramBoolean1, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((!this.val$isSuc) && (this.this$0.val$listener != null)) {
      this.this$0.val$listener.onShared(this.val$finalNeedShareCallback.booleanValue(), false);
    }
    if (this.val$finalErrCode == -100070004L)
    {
      if (this.this$0.val$listener != null) {
        this.this$0.val$listener.onShared(this.val$finalNeedShareCallback.booleanValue(), false);
      }
      babr.a(this.this$0.val$activity, 233, this.this$0.val$activity.getString(2131653599), this.val$finalErrMsg, new MiniProgramShareUtils.2.1.1(this), null).show();
      return;
    }
    bbmy.a(this.this$0.val$activity, 1, 2131653599, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramShareUtils.2.1
 * JD-Core Version:    0.7.0.1
 */