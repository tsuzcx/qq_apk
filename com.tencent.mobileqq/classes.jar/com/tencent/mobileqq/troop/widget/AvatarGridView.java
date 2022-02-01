package com.tencent.mobileqq.troop.widget;

import akjf;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import com.tencent.widget.GridView;

public class AvatarGridView
  extends GridView
{
  protected int a = 4;
  
  public AvatarGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public AvatarGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setChildrenDrawingOrderEnabled(true);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = getAdapter();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localListAdapter != null)
    {
      localObject1 = localObject2;
      if ((getAdapter().getItem(paramInt1 - 1) instanceof akjf)) {
        localObject1 = (akjf)getAdapter().getItem(paramInt1 - 1);
      }
    }
    int i;
    if (localObject1 != null) {
      if ((((akjf)localObject1).b != 0) && (((akjf)localObject1).b == 4)) {
        i = paramInt1 - 1;
      }
    }
    while (i > 4) {
      if (paramInt2 == paramInt1 - 1)
      {
        return 3;
        i = paramInt1;
        continue;
        i = paramInt1;
      }
      else
      {
        if (paramInt2 == paramInt1 - 2) {
          return 4;
        }
        if (paramInt2 == 4) {
          return paramInt1 - 2;
        }
        if (paramInt2 == 3) {
          return paramInt1 - 1;
        }
      }
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public int getNumColumns()
  {
    return this.a;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public void setNumColumns(int paramInt)
  {
    this.a = paramInt;
    super.setNumColumns(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarGridView
 * JD-Core Version:    0.7.0.1
 */