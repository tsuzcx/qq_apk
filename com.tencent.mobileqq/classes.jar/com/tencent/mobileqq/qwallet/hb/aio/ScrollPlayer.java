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
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(AnimationView paramAnimationView)
  {
    reset();
    this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAnimationView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (jdField_a_of_type_Boolean)
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 500L);
      }
      else
      {
        a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer
 * JD-Core Version:    0.7.0.1
 */