package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler$1
  implements Runnable
{
  SystemDragUtils$TouchHandler$1(SystemDragUtils.TouchHandler paramTouchHandler, BaseBubbleBuilder.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    UiThreadUtil.a(new SystemDragUtils.TouchHandler.1.1(this, SystemDragUtils.a((Context)this.this$0.a.get(), this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1
 * JD-Core Version:    0.7.0.1
 */