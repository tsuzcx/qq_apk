package com.tencent.widget.calloutpopupwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.KandianTextView;
import com.tencent.mobileqq.util.DisplayUtil;

public class CalloutPopupWindow$Builder
{
  private Context a;
  private String b;
  private float c = 12.0F;
  private int d = -1;
  private int e = 17170445;
  private int f = 17170445;
  private boolean g = true;
  private int h = 5;
  private int i = 49;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private boolean m;
  
  private CalloutPopupWindow$Builder(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Builder a(float paramFloat)
  {
    this.c = paramFloat;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(Drawable paramDrawable)
  {
    this.k = paramDrawable;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public CalloutPopupWindow a()
  {
    try
    {
      int n = DisplayUtil.a(this.a, 300.0F);
      int i1 = DisplayUtil.a(this.a, 120.0F);
      LinearLayout localLinearLayout = new LinearLayout(this.a);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setPadding(DisplayUtil.a(this.a, 10.0F), DisplayUtil.a(this.a, 8.0F), DisplayUtil.a(this.a, 10.0F), DisplayUtil.a(this.a, 8.0F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.m) {
        localObject = new KandianTextView(this.a);
      } else {
        localObject = new TextView(this.a);
      }
      ((TextView)localObject).setTextColor(this.a.getResources().getColor(17170443));
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localLinearLayout.addView((View)localObject);
      if (this.j != null)
      {
        int i2 = localLinearLayout.getPaddingLeft();
        int i3 = localLinearLayout.getPaddingTop();
        int i4 = localLinearLayout.getPaddingRight();
        int i5 = localLinearLayout.getPaddingBottom();
        localLinearLayout.setBackgroundDrawable(this.j);
        localLinearLayout.setPadding(i2, i3, i4, i5);
      }
      ((TextView)localObject).setMaxWidth(n);
      ((TextView)localObject).setMaxHeight(i1);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setText(this.b);
      ((TextView)localObject).setTextSize(this.c);
      ((TextView)localObject).setTextColor(this.d);
      localLinearLayout.measure(n, i1);
      localObject = new CalloutPopupWindow(this.a, localLinearLayout.getMeasuredWidth(), this.i);
      ((CalloutPopupWindow)localObject).d(this.e);
      ((CalloutPopupWindow)localObject).a(this.k);
      ((CalloutPopupWindow)localObject).b(this.l);
      ((CalloutPopupWindow)localObject).e(this.f);
      ((CalloutPopupWindow)localObject).setContentView(localLinearLayout);
      ((CalloutPopupWindow)localObject).a(83);
      if (!this.g) {
        ((CalloutPopupWindow)localObject).setOutsideTouchable(false);
      }
      ((CalloutPopupWindow)localObject).b(DisplayUtil.a(this.a, 6.0F));
      CalloutPopupWindow.a((CalloutPopupWindow)localObject, this.h);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("CalloutPopupWindow", "[build] failed to build window", localThrowable);
    }
    return null;
  }
  
  public Builder b(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public Builder b(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public Builder c(Drawable paramDrawable)
  {
    this.j = paramDrawable;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder
 * JD-Core Version:    0.7.0.1
 */