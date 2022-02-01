package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.kandian.base.view.widget.RainView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyRainAnimationController
{
  private ViewGroup a;
  private RainView b;
  private Context c;
  private boolean d = true;
  private ReadInJoyRainAnimationController.AnimatorHandler e;
  
  public ReadInJoyRainAnimationController(ViewGroup paramViewGroup, Context paramContext)
  {
    this.a = paramViewGroup;
    this.c = paramContext;
    this.e = new ReadInJoyRainAnimationController.AnimatorHandler(this);
  }
  
  public void a()
  {
    this.d = false;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRainAnimationController", 2, "rain animation show");
    }
    if (this.a.findViewWithTag("ReadInJoyRainAnimationController") == null)
    {
      this.b = new RainView(this.c);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      this.a.addView(this.b, localLayoutParams);
      this.b.setTag("ReadInJoyRainAnimationController");
    }
    this.b.setAnimationEndListener(new ReadInJoyRainAnimationController.AnimationEndListenerImp(this));
    this.b.a(this.a.getWidth(), this.a.getTop(), this.a.getBottom(), paramString);
  }
  
  public void b()
  {
    if ((c()) && (this.b != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRainAnimationController", 2, "rain animation hide");
      }
      this.b.o();
      this.a.removeView(this.b);
    }
  }
  
  public boolean c()
  {
    return this.a.findViewWithTag("ReadInJoyRainAnimationController") != null;
  }
  
  public boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyRainAnimationController
 * JD-Core Version:    0.7.0.1
 */