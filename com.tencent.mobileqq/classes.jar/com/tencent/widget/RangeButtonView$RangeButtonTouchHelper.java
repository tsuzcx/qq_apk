package com.tencent.widget;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.List;

class RangeButtonView$RangeButtonTouchHelper
  extends ExploreByTouchHelper
{
  public RangeButtonView$RangeButtonTouchHelper(RangeButtonView paramRangeButtonView, View paramView)
  {
    super(paramView);
  }
  
  public Rect getBoundsForIndex(int paramInt)
  {
    Point localPoint = (Point)RangeButtonView.access$000(this.this$0).getUnitPoints().get(paramInt);
    paramInt = RangeButtonView.access$100(this.this$0).getThumbHeight() / 2;
    return new Rect(localPoint.x - paramInt, localPoint.y - paramInt, localPoint.x + paramInt, localPoint.y + paramInt);
  }
  
  protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    RangeButtonView localRangeButtonView = this.this$0;
    return RangeButtonView.access$200(localRangeButtonView, (int)paramFloat1, (int)paramFloat2, RangeButtonView.access$000(localRangeButtonView).getUintSpace() / 2, RangeButtonView.access$100(this.this$0).getThumbHeight() / 2, false);
  }
  
  protected void getVisibleVirtualViews(List<Integer> paramList)
  {
    int i = 0;
    while (i < RangeButtonView.access$300(this.this$0).size())
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 != 16) {
      return false;
    }
    if (RangeButtonView.access$000(this.this$0) != null)
    {
      if (RangeButtonView.access$100(this.this$0) == null) {
        return false;
      }
      if ((paramInt1 != RangeButtonView.access$500(this.this$0)) && (paramInt1 != -1))
      {
        if (RangeButtonView.access$600(this.this$0) != null) {
          RangeButtonView.access$600(this.this$0).onChange(RangeButtonView.access$500(this.this$0), paramInt1);
        }
        RangeButtonView.access$502(this.this$0, paramInt1);
        this.this$0.invalidate();
      }
      return true;
    }
    return false;
  }
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((RangeButtonView.access$400(this.this$0) != null) && (RangeButtonView.access$400(this.this$0).size() > paramInt)) {
      paramAccessibilityEvent.setContentDescription((CharSequence)RangeButtonView.access$400(this.this$0).get(paramInt));
    }
  }
  
  protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if ((RangeButtonView.access$400(this.this$0) != null) && (RangeButtonView.access$400(this.this$0).size() > paramInt))
    {
      String str = (String)RangeButtonView.access$400(this.this$0).get(paramInt);
      Object localObject = str;
      if (paramInt == RangeButtonView.access$500(this.this$0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131910229));
        localObject = ((StringBuilder)localObject).toString();
      }
      paramAccessibilityNodeInfoCompat.setContentDescription((CharSequence)localObject);
    }
    paramAccessibilityNodeInfoCompat.addAction(16);
    paramAccessibilityNodeInfoCompat.setBoundsInParent(getBoundsForIndex(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.RangeButtonTouchHelper
 * JD-Core Version:    0.7.0.1
 */