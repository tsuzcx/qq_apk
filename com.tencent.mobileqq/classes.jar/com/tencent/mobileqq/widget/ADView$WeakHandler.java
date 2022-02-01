package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.struct.PushBanner;
import java.lang.ref.WeakReference;

class ADView$WeakHandler
  extends Handler
{
  private WeakReference<ADView> a;
  private ADView b;
  
  public ADView$WeakHandler(ADView paramADView)
  {
    this.a = new WeakReference(paramADView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 0)
    {
      if (i == 1) {
        removeMessages(0);
      }
    }
    else
    {
      this.b = ((ADView)this.a.get());
      localObject = this.b;
      if (localObject == null) {
        break label177;
      }
      if (((ADView)localObject).y == null) {
        return;
      }
      if ((this.b.y.getChildCount() > 1) && (this.b.y.getWidth() > 0)) {
        this.b.y.a(this.b.y.getCurrentScreen() + 1);
      }
    }
    try
    {
      localObject = (PushBanner)this.b.y.getChildAt(this.b.y.getCurrentScreen()).getTag();
      i = ((PushBanner)localObject).d * 1000;
      this.b.setContentDescription(((PushBanner)localObject).p);
    }
    catch (Exception localException)
    {
      label155:
      break label155;
    }
    i = 5000;
    sendEmptyMessageDelayed(0, i);
    this.b = null;
    super.handleMessage(paramMessage);
    label177:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView.WeakHandler
 * JD-Core Version:    0.7.0.1
 */