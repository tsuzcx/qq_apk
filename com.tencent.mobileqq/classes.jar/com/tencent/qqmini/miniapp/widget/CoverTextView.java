package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils.TruncateAt;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;

public class CoverTextView
  extends CoverView
{
  private TextView textView;
  
  public CoverTextView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.textView = new TextView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.textView.setGravity(16);
    addView(this.textView, paramContext);
  }
  
  public TextView getTextView()
  {
    return this.textView;
  }
  
  public void setAlpha(float paramFloat)
  {
    super.setAlpha(paramFloat);
    this.textView.setAlpha(paramFloat);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    this.textView.setBackgroundColor(paramInt);
  }
  
  public void setBorder(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt3);
    localGradientDrawable.setCornerRadius(DisplayUtil.getDensity(getContext()) * paramFloat);
    if (paramInt1 > 0) {
      localGradientDrawable.setStroke(paramInt1, paramInt2);
    }
    this.textView.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.textView.setEllipsize(paramTruncateAt);
  }
  
  public void setGravity(int paramInt)
  {
    this.textView.setGravity(paramInt | 0x10);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.textView.setIncludeFontPadding(paramBoolean);
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.textView.setLineSpacing(paramFloat1, paramFloat2);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.textView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setScaleX(float paramFloat)
  {
    this.textView.setScaleX(paramFloat);
  }
  
  public void setScaleY(float paramFloat)
  {
    this.textView.setScaleY(paramFloat);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.textView.setSingleLine(paramBoolean);
  }
  
  public void setText(String paramString)
  {
    this.textView.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.textView.setTextColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.textView.setTextSize(paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.textView.setTextSize(paramInt, paramFloat);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.textView.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CoverTextView
 * JD-Core Version:    0.7.0.1
 */