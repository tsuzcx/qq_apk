package com.tencent.mobileqq.nearby.interestTag;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class ShowTagNamePopupWindow
  extends PopupWindow
{
  private TextView a;
  private ImageView b;
  private String c;
  private long d;
  private float e;
  private int f;
  private ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback g;
  private View.OnClickListener h = new ShowTagNamePopupWindow.1(this);
  
  public ShowTagNamePopupWindow(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.e = paramContext.getResources().getDisplayMetrics().density;
    this.f = paramInt2;
    setWidth(this.f);
    double d1 = this.e * 42.0F;
    Double.isNaN(d1);
    setHeight((int)(d1 + 0.5D));
    View localView = LayoutInflater.from(paramContext).inflate(2131625597, null);
    setContentView(localView);
    a(paramContext, localView, paramInt1);
    setOutsideTouchable(true);
  }
  
  private void a(Context paramContext, View paramView, int paramInt)
  {
    this.a = ((TextView)paramView.findViewById(2131448977));
    this.a.getTextSize();
    this.b = ((ImageView)paramView.findViewById(2131429861));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.findViewById(2131435629).getLayoutParams();
    float f1 = this.e;
    double d1 = 10.0F * f1;
    Double.isNaN(d1);
    int i = (int)(d1 + 0.5D);
    if (paramInt <= 0)
    {
      localLayoutParams.leftMargin = 0;
    }
    else if (paramInt < (this.f - i) / 2)
    {
      localLayoutParams.leftMargin = (paramInt + (int)((f1 * 40.0F - i) / 2.0F));
    }
    else
    {
      int j = paramContext.getResources().getDisplayMetrics().widthPixels;
      f1 = this.e;
      d1 = f1 * 40.0F;
      Double.isNaN(d1);
      int k = (int)(d1 + 0.5D);
      int m = this.f;
      if (paramInt > j - k - (m - i) / 2)
      {
        localLayoutParams.leftMargin = (m + paramInt + (int)((f1 * 40.0F - i) / 2.0F) - paramContext.getResources().getDisplayMetrics().widthPixels);
      }
      else
      {
        d1 = (m - i) / 2;
        Double.isNaN(d1);
        localLayoutParams.leftMargin = ((int)(d1 + 0.5D));
      }
    }
    paramView.setOnClickListener(this.h);
    setBackgroundDrawable(paramContext.getResources().getDrawable(2130853309));
  }
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramInterestTagInfo.tagName))
    {
      this.c = paramInterestTagInfo.tagName;
      this.a.setText(this.c);
    }
    this.d = paramInterestTagInfo.tagId;
  }
  
  public void a(ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback paramIShowTagNamePopupWindowCallback)
  {
    this.g = paramIShowTagNamePopupWindowCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow
 * JD-Core Version:    0.7.0.1
 */