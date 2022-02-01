package com.tencent.timi.game.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import com.tencent.timi.game.utils.StatusBarUtil;

public class BaseSlideUpDialog
  extends FullScreenDialog
{
  private View a;
  private View b;
  private boolean c = false;
  private float d = 1.0F;
  public boolean f = true;
  ValueAnimator g;
  ValueAnimator h;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  
  public BaseSlideUpDialog(Context paramContext)
  {
    this(paramContext, 2131952168);
    StatusBarUtil.a(getWindow());
  }
  
  public BaseSlideUpDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView != null) {
      if ((paramView instanceof ImageView))
      {
        if (Build.VERSION.SDK_INT >= 16) {
          ((ImageView)paramView).setImageAlpha((int)(paramFloat * 255.0F));
        }
      }
      else {
        paramView.setAlpha(paramFloat);
      }
    }
  }
  
  protected void b(View paramView)
  {
    this.a = paramView;
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  protected void c(View paramView)
  {
    this.b = paramView;
  }
  
  public void cancel()
  {
    super.cancel();
    dismiss();
  }
  
  public void dismiss()
  {
    if ((this.a != null) && (this.i))
    {
      ValueAnimator localValueAnimator = this.g;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      if (this.h != null) {
        return;
      }
      this.h = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.h.setInterpolator(CommonAnimationUtil.SlideUpAnimation.b);
      float f1;
      float f2;
      if (this.j)
      {
        f1 = this.a.getWidth();
        f2 = this.d;
      }
      else
      {
        f1 = this.a.getHeight();
        f2 = this.d;
      }
      f1 *= f2;
      this.h.setDuration(t());
      this.h.addUpdateListener(new BaseSlideUpDialog.5(this, f1));
      this.h.addListener(new BaseSlideUpDialog.6(this, f1));
      this.h.start();
      return;
    }
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 22)
    {
      getWindow().addFlags(-2147483648);
      StatusBarUtil.b(getWindow());
    }
  }
  
  protected void s()
  {
    this.k = true;
  }
  
  public void show()
  {
    super.show();
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!this.i) {
        return;
      }
      if (this.b == null)
      {
        localObject = (ViewGroup)((View)localObject).getParent();
        if (localObject != null)
        {
          this.b = new ImageView(getContext());
          if (this.f) {
            ((ImageView)this.b).setImageResource(2130852951);
          }
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          this.b.setLayoutParams(localLayoutParams);
          ((ViewGroup)localObject).addView(this.b, 0);
          if (this.k) {
            this.b.setOnClickListener(new BaseSlideUpDialog.1(this));
          }
        }
      }
      localObject = this.b;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      this.a.setVisibility(4);
      this.g = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.g.setInterpolator(CommonAnimationUtil.SlideUpAnimation.a);
      this.g.setDuration(t());
      this.g.addUpdateListener(new BaseSlideUpDialog.2(this));
      this.g.addListener(new BaseSlideUpDialog.3(this));
      this.a.post(new BaseSlideUpDialog.4(this));
    }
  }
  
  protected long t()
  {
    return 500L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseSlideUpDialog
 * JD-Core Version:    0.7.0.1
 */