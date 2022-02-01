package com.tencent.mobileqq.newfriend.ui.builder;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class NewFriendBaseBuilder$1
  extends SwipTextViewMenuBuilder
{
  NewFriendBaseBuilder$1(NewFriendBaseBuilder paramNewFriendBaseBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
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
      int i = this.a.b();
      int j = paramArrayOfSwipRightMenuItem.length;
      paramInt = 1;
      if ((j > 0) && ((i & 0xF) == 1))
      {
        paramArrayOfSwipRightMenuItem[0].menuId = 0;
        paramArrayOfSwipRightMenuItem[0].menuType = 0;
      }
      else
      {
        paramInt = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */