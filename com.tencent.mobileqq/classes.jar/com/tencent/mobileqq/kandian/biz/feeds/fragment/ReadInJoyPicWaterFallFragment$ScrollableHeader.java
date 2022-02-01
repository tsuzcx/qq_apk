package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView.ScrollableHeader;

class ReadInJoyPicWaterFallFragment$ScrollableHeader
  extends FrameLayout
  implements ReadInjoyXRecyclerView.ScrollableHeader
{
  Rect a = new Rect();
  
  public ReadInJoyPicWaterFallFragment$ScrollableHeader(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyPicWaterFallFragment$ScrollableHeader(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    getHitRect(this.a);
    return this.a.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ScrollableHeader
 * JD-Core Version:    0.7.0.1
 */