package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import java.util.Comparator;

class k$1
  implements Comparator<View>
{
  k$1(k paramk) {}
  
  public int a(View paramView1, View paramView2)
  {
    Integer localInteger = HippyViewGroupController.getViewZIndex(paramView1);
    paramView1 = Integer.valueOf(0);
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = paramView1;
    }
    localInteger = HippyViewGroupController.getViewZIndex(paramView2);
    paramView2 = localInteger;
    if (localInteger == null) {
      paramView2 = paramView1;
    }
    return ((Integer)localObject).intValue() - paramView2.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.k.1
 * JD-Core Version:    0.7.0.1
 */