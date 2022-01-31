package com.tencent.qqmini.sdk.runtime.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils.TruncateAt;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;

public class CoverTextView
  extends CoverView
{
  private TextView a;
  
  public CoverTextView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = new TextView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.a.setGravity(16);
    addView(this.a, paramContext);
  }
  
  public TextView a()
  {
    return this.a;
  }
  
  public void setAlpha(float paramFloat)
  {
    super.setAlpha(paramFloat);
    this.a.setAlpha(paramFloat);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    this.a.setBackgroundColor(paramInt);
  }
  
  public void setBorder(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt3);
    localGradientDrawable.setCornerRadius(DisplayUtil.getDensity(getContext()) * paramFloat);
    if (paramInt1 > 0) {
      localGradientDrawable.setStroke(paramInt1, paramInt2);
    }
    this.a.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.a.setEllipsize(paramTruncateAt);
  }
  
  public void setGravity(int paramInt)
  {
    this.a.setGravity(paramInt | 0x10);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.a.setIncludeFontPadding(paramBoolean);
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.a.setLineSpacing(paramFloat1, paramFloat2);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setScaleX(float paramFloat)
  {
    this.a.setScaleX(paramFloat);
  }
  
  public void setScaleY(float paramFloat)
  {
    this.a.setScaleY(paramFloat);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.a.setSingleLine(paramBoolean);
  }
  
  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.a.setTextColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.a.setTextSize(paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.a.setTextSize(paramInt, paramFloat);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.a.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CoverTextView
 * JD-Core Version:    0.7.0.1
 */