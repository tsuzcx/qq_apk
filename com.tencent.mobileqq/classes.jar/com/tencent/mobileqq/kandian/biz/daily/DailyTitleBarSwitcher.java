package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;

public class DailyTitleBarSwitcher
  extends FrameLayout
{
  private boolean a = false;
  private DailyTitleBar b;
  private DailyTitleBar c;
  private View.OnClickListener d;
  private View.OnClickListener e;
  private final Interpolator f = new DailyTitleBarSwitcher.1(this);
  private final AbsListView.OnScrollListener g = new DailyTitleBarSwitcher.2(this);
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (getChildCount() >= 2)
    {
      this.c = ((DailyTitleBar)getChildAt(0));
      this.b = ((DailyTitleBar)getChildAt(1));
      a(0.0F);
      ImmersiveUtils.setStatusTextColor(false, ((Activity)getContext()).getWindow());
      this.a = true;
    }
  }
  
  private void a(float paramFloat)
  {
    DailyTitleBar localDailyTitleBar = this.b;
    if ((localDailyTitleBar != null) && (this.c != null))
    {
      localDailyTitleBar.setAlpha(paramFloat);
      this.c.setAlpha(1.0F - paramFloat);
      if (paramFloat > 0.0F) {
        ImmersiveUtils.setStatusTextColor(true, ((Activity)getContext()).getWindow());
      } else {
        ImmersiveUtils.setStatusTextColor(false, ((Activity)getContext()).getWindow());
      }
      b();
    }
  }
  
  private void b()
  {
    if (this.e == null) {
      return;
    }
    DailyTitleBar localDailyTitleBar = this.b;
    if ((localDailyTitleBar != null) && (this.c != null))
    {
      if (localDailyTitleBar.getAlpha() < 0.1F)
      {
        this.b.setOnTitleClickListener(this.e);
        this.c.setOnTitleClickListener(this.e);
        return;
      }
      this.b.setOnTitleClickListener(this.d);
      this.c.setOnTitleClickListener(this.d);
    }
  }
  
  public AbsListView.OnScrollListener getOnScrollListener()
  {
    return this.g;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.a) {
      a();
    }
  }
  
  public void setBackgroundViewTitle(String paramString, float paramFloat)
  {
    if (!this.a) {
      a();
    }
    DailyTitleBar localDailyTitleBar = this.c;
    if (localDailyTitleBar != null)
    {
      localDailyTitleBar.setTitleText(paramString);
      this.c.setTitleTextSize(paramFloat);
    }
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.a) {
      a();
    }
    DailyTitleBar localDailyTitleBar = this.b;
    if ((localDailyTitleBar != null) && (this.c != null))
    {
      localDailyTitleBar.setOnLeftButtonClickListener(paramOnClickListener);
      this.c.setOnLeftButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.a) {
      a();
    }
    DailyTitleBar localDailyTitleBar = this.b;
    if ((localDailyTitleBar != null) && (this.c != null))
    {
      localDailyTitleBar.setOnRightButtonClickListener(paramOnClickListener);
      this.c.setOnRightButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.a) {
      a();
    }
    DailyTitleBar localDailyTitleBar = this.b;
    if ((localDailyTitleBar != null) && (this.c != null))
    {
      this.d = paramOnClickListener;
      localDailyTitleBar.setOnTitleClickListener(paramOnClickListener);
      this.c.setOnTitleClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickWeatherListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.a) {
      a();
    }
    DailyTitleBar localDailyTitleBar = this.b;
    if ((localDailyTitleBar != null) && (this.c != null))
    {
      this.e = paramOnClickListener;
      localDailyTitleBar.setOnTitleClickListener(paramOnClickListener);
      this.c.setOnTitleClickListener(paramOnClickListener);
      if (this.e == null)
      {
        this.b.setOnTitleClickListener(this.d);
        this.c.setOnTitleClickListener(this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyTitleBarSwitcher
 * JD-Core Version:    0.7.0.1
 */