package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler
  extends Handler
{
  GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase paramGestureDetectorCompatImplBase) {}
  
  GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase paramGestureDetectorCompatImplBase, Handler paramHandler)
  {
    super(paramHandler.getLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          if (this.a.b != null)
          {
            if (!this.a.c)
            {
              this.a.b.onSingleTapConfirmed(this.a.e);
              return;
            }
            this.a.d = true;
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown message ");
          localStringBuilder.append(paramMessage);
          throw new RuntimeException(localStringBuilder.toString());
        }
      }
      else {
        this.a.a();
      }
    }
    else {
      this.a.a.onShowPress(this.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler
 * JD-Core Version:    0.7.0.1
 */