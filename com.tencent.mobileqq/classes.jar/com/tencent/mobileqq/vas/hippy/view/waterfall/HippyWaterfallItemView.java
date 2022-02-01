package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class HippyWaterfallItemView
  extends HippyViewGroup
{
  private int a;
  
  public HippyWaterfallItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int getType()
  {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setType(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallItemView
 * JD-Core Version:    0.7.0.1
 */