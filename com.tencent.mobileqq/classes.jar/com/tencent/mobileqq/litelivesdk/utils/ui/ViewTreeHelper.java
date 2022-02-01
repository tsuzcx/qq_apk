package com.tencent.mobileqq.litelivesdk.utils.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.livesdk.livesdkplayer.utils.NotchUtil;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;

public class ViewTreeHelper
{
  private View a;
  private int b;
  private FrameLayout.LayoutParams c;
  private ViewTreeObserver.OnGlobalLayoutListener d;
  private ViewGroup e;
  private Activity f;
  
  public ViewTreeHelper(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.a = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.e = paramViewGroup;
    this.c = ((FrameLayout.LayoutParams)this.a.getLayoutParams());
    this.d = new ViewTreeHelper.1(this);
    this.f = paramActivity;
  }
  
  private void c()
  {
    int i = d();
    if (i != this.b)
    {
      int k = this.a.getRootView().getHeight();
      int j = k - i;
      LogInterface localLogInterface = LogFactory.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("possiblyResizeChildOfContent usableHeightSansKeyboard = ");
      localStringBuilder.append(k);
      localStringBuilder.append(" heightDifference = ");
      localStringBuilder.append(j);
      localLogInterface.c("ViewTreeHelper", localStringBuilder.toString());
      if (j > k / 4)
      {
        k = e();
        this.e.scrollTo(0, j - k);
      }
      else if (this.b > 0)
      {
        this.e.scrollTo(0, 0);
      }
      this.a.requestLayout();
      this.b = i;
    }
  }
  
  private int d()
  {
    Rect localRect = new Rect();
    this.a.getWindowVisibleDisplayFrame(localRect);
    if (DeviceManager.a(BaseApplicationImpl.getContext())) {
      return localRect.bottom - localRect.top;
    }
    return localRect.bottom;
  }
  
  private int e()
  {
    if (!DeviceManager.a(BaseApplicationImpl.getContext())) {
      return 0;
    }
    int i = NotchUtil.getStatusBarHeight(BaseApplicationImpl.getContext());
    int j = DeviceManager.a(this.f);
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("statusBarHeight = ");
    localStringBuilder.append(i);
    localStringBuilder.append(" navigationBarHeight = ");
    localStringBuilder.append(j);
    localLogInterface.c("ViewTreeHelper", localStringBuilder.toString());
    return i + j;
  }
  
  public void a()
  {
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.d);
      return;
    }
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ui.ViewTreeHelper
 * JD-Core Version:    0.7.0.1
 */