package com.tencent.mobileqq.troop.troopnotification.adapter;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class DelMenuBuilder$1
  extends SwipTextViewMenuBuilder
{
  DelMenuBuilder$1(DelMenuBuilder paramDelMenuBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      int i = paramArrayOfSwipRightMenuItem.length;
      paramInt = 0;
      if (i > 0)
      {
        paramArrayOfSwipRightMenuItem[0].menuId = 0;
        paramArrayOfSwipRightMenuItem[0].menuType = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.DelMenuBuilder.1
 * JD-Core Version:    0.7.0.1
 */