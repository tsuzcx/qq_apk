package dov.com.qq.im.capture.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import bopn;

public abstract class StoryToastView
  extends LinearLayout
  implements Handler.Callback
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  
  public StoryToastView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StoryToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Animator a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
      this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bopn(this));
    }
    return this.jdField_a_of_type_AndroidAnimationAnimator;
  }
  
  private void a()
  {
    if (getVisibility() == 8) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    a().start();
  }
  
  protected abstract void a(Context paramContext);
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryToastView
 * JD-Core Version:    0.7.0.1
 */