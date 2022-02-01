package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class ProgressView
  extends FrameLayout
{
  private TextView a;
  
  public ProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561839, this);
    this.a = ((TextView)findViewById(2131378460));
    findViewById(2131363507).setBackgroundColor(Color.parseColor("#1c1c1d"));
  }
  
  public void setProgressText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.a.setVisibility(0);
      this.a.setText(paramCharSequence);
      return;
    }
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressView
 * JD-Core Version:    0.7.0.1
 */