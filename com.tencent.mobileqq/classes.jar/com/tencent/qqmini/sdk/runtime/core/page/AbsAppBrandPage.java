package com.tencent.qqmini.sdk.runtime.core.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.sdk.runtime.core.page.swipe.SwipeBackLayout;

public abstract class AbsAppBrandPage
  extends SwipeBackLayout
{
  public AbsAppBrandPage(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.a = a();
    if (this.a != null) {
      addView(this.a, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public abstract int a();
  
  public abstract View a();
  
  public abstract AppBrandPageContainer a();
  
  public PageWebview a()
  {
    return null;
  }
  
  public PageWebviewContainer a()
  {
    return null;
  }
  
  public abstract String a();
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AbsAppBrandPage
 * JD-Core Version:    0.7.0.1
 */