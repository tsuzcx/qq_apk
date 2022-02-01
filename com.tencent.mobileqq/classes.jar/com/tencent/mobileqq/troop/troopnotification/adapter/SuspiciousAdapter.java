package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.widget.SwipListView.SwipListListener;

public abstract class SuspiciousAdapter<T>
  extends CommonAdapter<T>
  implements SwipListView.SwipListListener
{
  protected DelMenuBuilder a;
  protected int d = -1;
  
  public SuspiciousAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new DelMenuBuilder(paramContext);
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.d = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter
 * JD-Core Version:    0.7.0.1
 */