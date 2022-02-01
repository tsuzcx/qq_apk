package com.tencent.mobileqq.troop.widget;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

class TroopFileItemBuilder$1
  extends TrooFileTextViewMenuBuilder
{
  TroopFileItemBuilder$1(TroopFileItemBuilder paramTroopFileItemBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length != 2) {
        return;
      }
      paramObject = paramObject[0];
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        if ((paramArrayOfSwipRightMenuItem != null) && (paramArrayOfSwipRightMenuItem.length > 0))
        {
          if (paramObject.length != 3) {
            return;
          }
          if ((paramArrayOfSwipRightMenuItem.length > 0) && (paramObject[0] != 0))
          {
            paramArrayOfSwipRightMenuItem[0].menuId = 0;
            paramArrayOfSwipRightMenuItem[0].menuType = 0;
            i = 1;
          }
          else
          {
            i = 0;
          }
          paramInt = i;
          if (i < paramArrayOfSwipRightMenuItem.length)
          {
            paramInt = i;
            if (paramObject[1] != 0)
            {
              paramArrayOfSwipRightMenuItem[i].menuId = 1;
              paramArrayOfSwipRightMenuItem[i].menuType = 1;
              paramInt = i + 1;
            }
          }
          int i = paramInt;
          if (paramInt < paramArrayOfSwipRightMenuItem.length)
          {
            i = paramInt;
            if (paramObject[2] != 0)
            {
              paramArrayOfSwipRightMenuItem[paramInt].menuId = 2;
              paramArrayOfSwipRightMenuItem[paramInt].menuType = 0;
              break label192;
            }
          }
          while (i < paramArrayOfSwipRightMenuItem.length)
          {
            paramArrayOfSwipRightMenuItem[i].menuId = -1;
            paramArrayOfSwipRightMenuItem[i].menuType = -1;
            paramInt = i;
            label192:
            i = paramInt + 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */