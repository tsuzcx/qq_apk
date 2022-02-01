package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class GifAnimationDrawable$InvalidationHandler
  extends Handler
{
  private final WeakReference<GifAnimationDrawable> a;
  
  public GifAnimationDrawable$InvalidationHandler(GifAnimationDrawable paramGifAnimationDrawable)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramGifAnimationDrawable);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    GifAnimationDrawable localGifAnimationDrawable;
    do
    {
      return;
      localGifAnimationDrawable = (GifAnimationDrawable)this.a.get();
    } while (localGifAnimationDrawable == null);
    GifAnimationDrawable.a(localGifAnimationDrawable, (GifAnimationDrawable.Frame)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GifAnimationDrawable.InvalidationHandler
 * JD-Core Version:    0.7.0.1
 */