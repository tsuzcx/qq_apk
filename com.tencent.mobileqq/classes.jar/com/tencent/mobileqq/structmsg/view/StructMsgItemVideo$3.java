package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.structmsg.CGILoader;

class StructMsgItemVideo$3
  implements Runnable
{
  StructMsgItemVideo$3(StructMsgItemVideo paramStructMsgItemVideo, Context paramContext, View paramView) {}
  
  public void run()
  {
    String str = CGILoader.a(this.a, this.this$0.ap, StructMsgItemVideo.a(this.this$0));
    this.this$0.ax.obtainMessage().obj = this.b;
    if (!TextUtils.isEmpty(str))
    {
      StructMsgItemVideo.a(this.this$0, this.a, str);
      return;
    }
    StructMsgItemVideo.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3
 * JD-Core Version:    0.7.0.1
 */