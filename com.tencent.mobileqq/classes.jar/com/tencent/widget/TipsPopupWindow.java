package com.tencent.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

public class TipsPopupWindow
  extends PopupWindow
  implements TipsLinearLayout.TipsLayoutAnimListener
{
  private FrameLayout a;
  private TipsLinearLayout b;
  private ImageView c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private TipsPopupWindow.DismissRunnable h;
  
  private void c()
  {
    if (this.f)
    {
      this.a.postDelayed(this.h, 1000L);
      return;
    }
    if ((this.d) && (!this.g))
    {
      this.g = true;
      e();
    }
  }
  
  private void d()
  {
    if (!this.d)
    {
      this.b.a();
      this.f = true;
      this.g = false;
    }
    this.d = true;
    this.a.removeCallbacks(this.h);
  }
  
  private void e()
  {
    if (!this.d) {
      return;
    }
    if (this.e) {
      ((Animatable)this.c.getDrawable()).stop();
    }
    this.b.b();
  }
  
  public void a()
  {
    if (this.e) {
      ((Animatable)this.c.getDrawable()).start();
    }
    this.f = false;
  }
  
  public void b()
  {
    this.a.post(new TipsPopupWindow.2(this));
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsPopupWindow", 2, "dismiss");
    }
    this.a.removeCallbacks(this.h);
    this.a.postDelayed(this.h, 300L);
  }
  
  public void showAsDropDown(View paramView)
  {
    super.showAsDropDown(paramView);
    d();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    d();
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TipsPopupWindow
 * JD-Core Version:    0.7.0.1
 */