package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

public class DelMenuBuilder
{
  private static final int[] b = { 2131888438 };
  private static final int[] c = { 2130839698 };
  private static final int[] d = { 2131438111 };
  Context a;
  private SwipRightMenuBuilder e;
  
  public DelMenuBuilder(Context paramContext)
  {
    this.a = paramContext;
    a();
  }
  
  public View a(Context paramContext, int paramInt, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.e.createView(paramContext, localView, paramSwipItemBaseHolder, -1);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int i = ((Context)localObject).getResources().getDimensionPixelSize(2131299607);
    int j = this.a.getResources().getDimensionPixelSize(2131299608);
    localObject = d;
    int[] arrayOfInt1 = b;
    int[] arrayOfInt2 = c;
    this.e = new DelMenuBuilder.1(this, 1, 2, new int[] { i, j }, -1, (int[])localObject, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, int paramInt1, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.e;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt1, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    if (paramInt2 != -1)
    {
      if (paramInt1 != paramInt2)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.DelMenuBuilder
 * JD-Core Version:    0.7.0.1
 */