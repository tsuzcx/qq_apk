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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691479 };
  private static final int[] b = { 2130839507 };
  private static final int[] c = { 2131370801 };
  Context jdField_a_of_type_AndroidContentContext;
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  
  public DelMenuBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public View a(Context paramContext, int paramInt, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(paramContext, localView, paramSwipItemBaseHolder, -1);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return;
    }
    int i = ((Context)localObject).getResources().getDimensionPixelSize(2131298886);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298887);
    localObject = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = new DelMenuBuilder.1(this, 1, 2, new int[] { i, j }, -1, (int[])localObject, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, int paramInt1, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.DelMenuBuilder
 * JD-Core Version:    0.7.0.1
 */