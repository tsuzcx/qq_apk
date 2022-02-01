package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public abstract class TrooFileTextViewMenuBuilder
  extends SwipRightMenuBuilder
{
  protected final int a;
  protected final int[] a;
  protected final int[] b;
  protected final int[] c;
  protected final int[] d;
  
  public TrooFileTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.d = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt2;
    this.b = paramArrayOfInt3;
    this.c = paramArrayOfInt4;
  }
  
  public View createRightMenuItem(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.d[paramInt], this.jdField_a_of_type_Int));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
  
  public View updateRightMenuItem(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    boolean bool = paramObject instanceof Object[];
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (bool)
    {
      paramObject = (Object[])paramObject;
      TroopFileInfo localTroopFileInfo;
      if ((paramObject.length == 2) && ((paramObject[1] instanceof TroopFileInfo))) {
        localTroopFileInfo = (TroopFileInfo)paramObject[1];
      } else {
        localTroopFileInfo = null;
      }
      localObject1 = localObject3;
      if (paramSwipRightMenuItem != null)
      {
        localObject1 = localObject3;
        if (paramSwipRightMenuItem.menuType >= 0)
        {
          localObject1 = localObject3;
          if (paramSwipRightMenuItem.menuId >= 0)
          {
            if (localTroopFileInfo == null) {
              return null;
            }
            paramObject = localObject2;
            if ((paramSwipRightMenuItem.menuView instanceof SimpleTextView)) {
              paramObject = (SimpleTextView)paramSwipRightMenuItem.menuView;
            }
            localObject1 = paramObject;
            if (paramObject != null)
            {
              paramInt = this.b[paramSwipRightMenuItem.menuId];
              int i = this.c[paramSwipRightMenuItem.menuId];
              int j = this.jdField_a_of_type_ArrayOfInt[paramSwipRightMenuItem.menuId];
              paramObject.setVisibility(0);
              paramObject.setText(paramObject.getContext().getResources().getString(paramInt));
              paramObject.setBackgroundResource(i);
              paramObject.setId(j);
              paramObject.setTag(localTroopFileInfo);
              paramObject.setContentDescription(paramObject.getResources().getString(paramInt));
              paramObject.setOnClickListener(paramOnClickListener);
              paramSwipRightMenuItem.menuWidth = this.d[paramSwipRightMenuItem.menuType];
              paramSwipRightMenuItem.menuHeight = this.jdField_a_of_type_Int;
              localObject1 = paramObject;
            }
          }
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TrooFileTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */