package com.tencent.mobileqq.widget.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class SlideBottomDialog
  extends ReportDialog
{
  private TouchControllerFrameLayout a;
  private LinearLayout b;
  private View c;
  private View d;
  private View e;
  private int f;
  private boolean g = true;
  
  public SlideBottomDialog(@NonNull Context paramContext)
  {
    this(paramContext, 2131952168);
  }
  
  public SlideBottomDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    e();
    c();
    d();
  }
  
  private void c()
  {
    this.a = ((TouchControllerFrameLayout)getLayoutInflater().inflate(2131627384, null, false));
    setContentView(this.a);
    this.b = ((LinearLayout)findViewById(2131437598));
    this.d = findViewById(2131449820);
    this.c = findViewById(2131436259);
    this.e = findViewById(2131449804);
    this.a.setHeadView(this.d);
    this.a.setMaxScrollHeight(ViewUtils.dip2px(50.0F));
    this.a.setIsInterceptContentEvent(false);
    this.f = getContext().getResources().getDimensionPixelSize(2131298953);
  }
  
  private void d()
  {
    SlideBottomDialog.1 local1 = new SlideBottomDialog.1(this);
    this.a.setOnClickListener(local1);
    this.c.setOnClickListener(local1);
    this.b.setOnClickListener(new SlideBottomDialog.2(this));
    this.a.setCustomTouchListener(new SlideBottomDialog.3(this));
    setOnDismissListener(new SlideBottomDialog.4(this));
  }
  
  private void e()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localWindow.addFlags(67108864);
      }
      ImmersiveUtils.clearCoverForStatus(localWindow, true);
    }
  }
  
  public void a()
  {
    show();
    this.b.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772014));
  }
  
  public void a(int paramInt)
  {
    this.a.post(new SlideBottomDialog.6(this, paramInt));
  }
  
  public void a(View paramView)
  {
    this.b.addView(paramView);
  }
  
  public void b()
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772018);
    localAnimation.setAnimationListener(new SlideBottomDialog.5(this));
    this.b.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.dialog.SlideBottomDialog
 * JD-Core Version:    0.7.0.1
 */