package com.tencent.mobileqq.multiaio.widget;

import android.view.View;
import java.util.Comparator;

class MultiAIOBaseViewPager$ViewPositionComparator
  implements Comparator<View>
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (MultiAIOBaseViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (MultiAIOBaseViewPager.LayoutParams)paramView2.getLayoutParams();
    if (paramView1.a != paramView2.a)
    {
      if (paramView1.a) {
        return 1;
      }
      return -1;
    }
    return paramView1.e - paramView2.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.ViewPositionComparator
 * JD-Core Version:    0.7.0.1
 */