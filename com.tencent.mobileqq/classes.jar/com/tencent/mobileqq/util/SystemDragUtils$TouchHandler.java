package com.tencent.mobileqq.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.selectable.AIOMenuWrapper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler
  extends Handler
{
  static int a = -1;
  WeakReference<Context> b;
  OnLongClickAndTouchListener c;
  
  private void a(OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu Called");
    if ((paramOnLongClickAndTouchListener instanceof ChatAdapter1.BubbleOnlongClickListener))
    {
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is BubbleOnlongClickListener");
      paramOnLongClickAndTouchListener = ((ChatAdapter1.BubbleOnlongClickListener)paramOnLongClickAndTouchListener).a;
      if ((paramOnLongClickAndTouchListener != null) && (paramOnLongClickAndTouchListener.e()))
      {
        QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper dismiss");
        paramOnLongClickAndTouchListener.f();
        return;
      }
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper notshow");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dismissBubbleMenu listener is: ");
    localStringBuilder.append(paramOnLongClickAndTouchListener.getClass());
    QLog.d("SystemDragUtils", 1, localStringBuilder.toString());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == a) && ((paramMessage.obj instanceof View)) && (this.b.get() != null))
    {
      paramMessage = (BaseBubbleBuilder.ViewHolder)AIOUtils.b((View)paramMessage.obj);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DRAG TRIGGER: holder is: ");
      localStringBuilder.append(paramMessage.getClass());
      QLog.d("SystemDragUtils", 1, localStringBuilder.toString());
      if (paramMessage.q != null)
      {
        ThreadManager.executeOnFileThread(new SystemDragUtils.TouchHandler.1(this, paramMessage));
        return;
      }
      QLog.e("SystemDragUtils", 1, "DRAG TRIGGER: holder message is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler
 * JD-Core Version:    0.7.0.1
 */