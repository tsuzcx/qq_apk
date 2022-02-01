package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

public class TroopFileItemBuilder
{
  public static final int[] a = { 2131895316, 2131895317, 2131895315 };
  public static final int[] b = { 2130839699, 2130839699, 2130839698 };
  public static final int[] c = { 2131448132, 2131448133, 2131448131 };
  protected SwipRightMenuBuilder d;
  
  public final View a(Context paramContext, int paramInt, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.d == null) {
      this.d = a(paramContext);
    }
    return this.d.createView(paramContext, localView, paramSwipItemBaseHolder, -1);
  }
  
  public SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299607);
    int j = paramContext.getResources().getDimensionPixelSize(2131299608);
    paramContext = c;
    int[] arrayOfInt1 = a;
    int[] arrayOfInt2 = b;
    return new TroopFileItemBuilder.1(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.d;
    if (localSwipRightMenuBuilder != null) {
      localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, 0, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */