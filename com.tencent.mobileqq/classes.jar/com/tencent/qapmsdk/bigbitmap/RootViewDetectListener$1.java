package com.tencent.qapmsdk.bigbitmap;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qapmsdk.bigbitmap.listener.IBitmapExceedListener;
import com.tencent.qapmsdk.common.util.ClassUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class RootViewDetectListener$1
  extends Handler
{
  RootViewDetectListener$1(RootViewDetectListener paramRootViewDetectListener, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((RootViewDetectListener.access$000(this.this$0) != null) && (RootViewDetectListener.access$000(this.this$0).get() != null) && ((RootViewDetectListener.access$000(this.this$0).get() instanceof ViewGroup)))
    {
      paramMessage = new ArrayList();
      RootViewDetectListener.access$200(this.this$0, paramMessage, RootViewDetectListener.access$100(this.this$0), ClassUtil.getClassName(RootViewDetectListener.access$000(this.this$0).get(), null), (View)RootViewDetectListener.access$000(this.this$0).get());
      if (paramMessage.size() > 0) {
        BitmapMonitor.getInstance().exceedBitmapListener.onBitmapExceed(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.RootViewDetectListener.1
 * JD-Core Version:    0.7.0.1
 */