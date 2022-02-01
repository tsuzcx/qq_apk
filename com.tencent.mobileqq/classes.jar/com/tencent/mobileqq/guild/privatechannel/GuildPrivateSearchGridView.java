package com.tencent.mobileqq.guild.privatechannel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.GridView;
import androidx.annotation.RequiresApi;

public class GuildPrivateSearchGridView
  extends GridView
{
  private int a;
  
  public GuildPrivateSearchGridView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildPrivateSearchGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildPrivateSearchGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @RequiresApi(api=21)
  public GuildPrivateSearchGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @RequiresApi(api=16)
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = getMinimumHeight();
    paramInt2 = i;
    if (k == 1073741824)
    {
      paramInt2 = this.a;
      if (i <= paramInt2) {
        paramInt2 = i;
      }
      if (paramInt2 <= j) {
        paramInt2 = j;
      }
    }
    i = paramInt2;
    if (k == 0)
    {
      i = this.a;
      if (paramInt2 > i) {
        paramInt2 = i;
      }
      if (paramInt2 > j) {
        i = paramInt2;
      } else {
        i = j;
      }
    }
    paramInt2 = i;
    if (k == -2147483648)
    {
      paramInt2 = this.a;
      if (i <= paramInt2) {
        paramInt2 = i;
      }
      if (paramInt2 <= j) {
        paramInt2 = j;
      }
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, k));
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateSearchGridView
 * JD-Core Version:    0.7.0.1
 */