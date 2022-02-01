package com.tencent.mobileqq.qwallet.hb.aio;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.Player;
import java.lang.ref.WeakReference;

public final class ScrollPlayer
  extends AnimationView.Player
{
  public static boolean a;
  
  public ScrollPlayer(AnimationView paramAnimationView)
  {
    super(paramAnimationView);
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public void a(AnimationView paramAnimationView)
  {
    reset();
    this.i.clear();
    this.i = new WeakReference(paramAnimationView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (a)
      {
        paramMessage = this.j.obtainMessage(1);
        this.j.sendMessageDelayed(paramMessage, 500L);
      }
      else
      {
        a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer
 * JD-Core Version:    0.7.0.1
 */