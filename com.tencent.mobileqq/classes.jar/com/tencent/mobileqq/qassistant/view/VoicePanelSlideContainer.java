package com.tencent.mobileqq.qassistant.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import azfw;
import azfy;
import azgq;
import azgr;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class VoicePanelSlideContainer
  extends RelativeLayout
  implements View.OnLayoutChangeListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 20;
  private Context jdField_a_of_type_AndroidContentContext;
  private azfw jdField_a_of_type_Azfw;
  private azfy jdField_a_of_type_Azfy;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public VoicePanelSlideContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoicePanelSlideContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoicePanelSlideContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramContext != null) {
      this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
    addOnLayoutChangeListener(this);
  }
  
  private void a()
  {
    int i = (int)getY();
    ObjectAnimator localObjectAnimator;
    if (i - this.b > getMeasuredHeight() / 2)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, "y", new float[] { i, this.c });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new azgq(this));
      localObjectAnimator.start();
    }
    do
    {
      return;
      if (i > this.b)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(this, "y", new float[] { i, this.b });
        localObjectAnimator.setDuration(250L);
        localObjectAnimator.addListener(new azgr(this));
        localObjectAnimator.start();
        return;
      }
    } while (i != this.b);
    a(false);
  }
  
  private void a(int paramInt)
  {
    if ((getY() <= this.b) && (paramInt == 0))
    {
      a(false);
      return;
    }
    a(true);
    offsetTopAndBottom(paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Azfw != null) {
      this.jdField_a_of_type_Azfw.b(paramBoolean);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Azfy != null) {
      this.jdField_a_of_type_Azfy.b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Boolean = false;
      continue;
      float f = paramMotionEvent.getY();
      if (Math.abs(this.jdField_a_of_type_Float - f) > this.jdField_a_of_type_Int) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        continue;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.c = ScreenUtil.getRealHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    this.b = ((int)getY());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Boolean = false;
      continue;
      int k = (int)getY();
      int j = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float);
      int i = j;
      if (k + j < this.b) {
        i = this.b - k;
      }
      a(i);
      continue;
      this.jdField_a_of_type_Boolean = false;
      a();
    }
  }
  
  public void setPanelDragListener(azfw paramazfw)
  {
    this.jdField_a_of_type_Azfw = paramazfw;
  }
  
  public void setPanelSlideListener(azfy paramazfy)
  {
    this.jdField_a_of_type_Azfy = paramazfy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer
 * JD-Core Version:    0.7.0.1
 */