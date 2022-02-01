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
import bpws;
import bpwt;

public abstract class StoryToastView
  extends LinearLayout
  implements Handler.Callback
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private Animator b;
  
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
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bpws(this));
    }
    return this.jdField_a_of_type_AndroidAnimationAnimator;
  }
  
  private Animator b()
  {
    if (this.b == null)
    {
      this.b = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
      this.b.setDuration(300L);
      this.b.addListener(new bpwt(this));
    }
    return this.b;
  }
  
  private void c()
  {
    if (getVisibility() == 8) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    b().start();
  }
  
  public void a()
  {
    a(true);
  }
  
  protected abstract void a(Context paramContext);
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(0);
      a().start();
      return;
    }
    setVisibility(0);
  }
  
  public void b()
  {
    if (a().isRunning()) {
      a().cancel();
    }
    if (getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      setVisibility(4);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryToastView
 * JD-Core Version:    0.7.0.1
 */