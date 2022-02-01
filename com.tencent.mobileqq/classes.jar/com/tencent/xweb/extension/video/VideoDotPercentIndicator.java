package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import org.xwalk.core.Log;

public class VideoDotPercentIndicator
  extends LinearLayout
{
  private LayoutInflater a;
  private int b;
  
  public VideoDotPercentIndicator(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public VideoDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    setDotsNum(0);
  }
  
  public void setDotsNum(int paramInt)
  {
    if (paramInt <= 1) {
      paramInt = 8;
    }
    this.b = paramInt;
    removeAllViews();
    paramInt = 0;
    while (paramInt < this.b)
    {
      addView((ImageView)this.a.inflate(2131629725, this, false));
      paramInt += 1;
    }
  }
  
  public void setProgress(float paramFloat)
  {
    float f = paramFloat / 100.0F;
    paramFloat = f;
    if (f < 0.0F) {
      paramFloat = 0.0F;
    }
    f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    int k = (int)Math.rint(this.b * f);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPercent percent:");
    localStringBuilder.append(f);
    localStringBuilder.append(" dotsOnNum:");
    localStringBuilder.append(k);
    Log.v("MicroMsg.AppBrandDotPercentIndicator", localStringBuilder.toString());
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= k) {
        break;
      }
      j = i;
      if (i >= getChildCount()) {
        break;
      }
      ((ImageView)getChildAt(i)).setImageResource(2130853734);
      i += 1;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(2130853733);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */