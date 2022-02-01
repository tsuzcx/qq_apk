package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.widget.GridView;

public class AvatarGridView
  extends GridView
{
  protected int a;
  protected WindowManager a;
  protected boolean a;
  
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
    this.jdField_a_of_type_AndroidViewWindowManager = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 4;
    setChildrenDrawingOrderEnabled(true);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i;
    if (getAdapter() != null)
    {
      localObject = getAdapter();
      i = paramInt1 - 1;
      if ((((ListAdapter)localObject).getItem(i) instanceof AvatarInfo))
      {
        localObject = (AvatarInfo)getAdapter().getItem(i);
        break label52;
      }
    }
    Object localObject = null;
    label52:
    if ((localObject != null) && (((AvatarInfo)localObject).b != 0) && (((AvatarInfo)localObject).b == 4)) {
      i = paramInt1 - 1;
    } else {
      i = paramInt1;
    }
    if (i > 4)
    {
      i = paramInt1 - 1;
      if (paramInt2 == i) {
        return 3;
      }
      int j = paramInt1 - 2;
      if (paramInt2 == j) {
        return 4;
      }
      if (paramInt2 == 4) {
        return j;
      }
      if (paramInt2 == 3) {
        return i;
      }
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public int getNumColumns()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public void setNumColumns(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.setNumColumns(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarGridView
 * JD-Core Version:    0.7.0.1
 */