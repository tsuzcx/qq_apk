package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusView
  extends LinearLayout
{
  int a = 1;
  TextView b;
  URLImageView c;
  TextView d;
  
  public OnlineStatusView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  void a()
  {
    setOrientation(0);
    setGravity(16);
    float f = getResources().getDimensionPixelSize(2131297105);
    this.b = new TextView(getContext());
    this.b.setDuplicateParentStateEnabled(false);
    this.b.setIncludeFontPadding(false);
    this.b.setSingleLine(true);
    this.b.setTextColor(getResources().getColor(2131168122));
    this.b.setTextSize(0, f);
    this.b.setText("[");
    this.b.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.b, localLayoutParams);
    this.c = new URLImageView(getContext());
    this.c.setDuplicateParentStateEnabled(false);
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(12.0F), ViewUtils.dip2px(12.0F));
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = ViewUtils.dip2px(2.0F);
    localLayoutParams.rightMargin = ViewUtils.dip2px(2.0F);
    addView(this.c, localLayoutParams);
    this.d = new TextView(getContext());
    this.d.setDuplicateParentStateEnabled(false);
    this.d.setIncludeFontPadding(false);
    this.d.setSingleLine(true);
    this.d.setTextColor(getResources().getColor(2131168122));
    this.d.setTextSize(0, f);
    this.d.setGravity(16);
    localLayoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.d, localLayoutParams);
  }
  
  public CharSequence getDescText()
  {
    CharSequence localCharSequence1 = this.b.getText();
    CharSequence localCharSequence2 = this.d.getText();
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append(localCharSequence1);
    localStringBuilder.append(localCharSequence2);
    return localStringBuilder.toString();
  }
  
  public int getMeasureLength()
  {
    CharSequence localCharSequence1 = this.b.getText();
    CharSequence localCharSequence2 = this.d.getText();
    int i = (int)this.b.getPaint().measureText(localCharSequence1, 0, localCharSequence1.length());
    int j = (int)this.d.getPaint().measureText(localCharSequence2, 0, localCharSequence2.length());
    int k = ViewUtils.dip2px(2.0F);
    int m = ViewUtils.dip2px(12.0F);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "prefixLen:", Integer.valueOf(i), " suffixLen:", Integer.valueOf(j), " iconLen:", Integer.valueOf(m) });
    }
    return i + m + j + k;
  }
  
  public TextView getSuffixTextView()
  {
    return this.d;
  }
  
  public void setDescText(String paramString)
  {
    if (this.a == 2)
    {
      this.b.setVisibility(0);
      TextView localTextView = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.b.setVisibility(8);
    this.d.setText(paramString);
  }
  
  public void setIconDrawable(Drawable paramDrawable)
  {
    this.c.setImageDrawable(paramDrawable);
  }
  
  public void setTextSize(int paramInt)
  {
    TextView localTextView = this.b;
    float f = paramInt;
    localTextView.setTextSize(0, f);
    this.d.setTextSize(0, f);
  }
  
  public void setViewStyle(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusView
 * JD-Core Version:    0.7.0.1
 */