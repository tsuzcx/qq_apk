package com.tencent.widget;

import android.view.View;

public class SwipRightMenuBuilder$SwipRightMenuItem
{
  public int menuHeight;
  public int menuId;
  public int menuType;
  public View menuView;
  public int menuWidth;
  
  public void reset()
  {
    this.menuType = -1;
    this.menuId = -1;
    this.menuWidth = 0;
    this.menuHeight = 0;
    this.menuView = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("menuType = ");
    localStringBuilder.append(this.menuType);
    localStringBuilder.append(",");
    localStringBuilder.append("menuId = ");
    localStringBuilder.append(this.menuId);
    localStringBuilder.append(",");
    localStringBuilder.append("menuWidth = ");
    localStringBuilder.append(this.menuWidth);
    localStringBuilder.append(",");
    localStringBuilder.append("menuHeight = ");
    localStringBuilder.append(this.menuHeight);
    localStringBuilder.append(",");
    localStringBuilder.append("menuView = ");
    localStringBuilder.append(this.menuView);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem
 * JD-Core Version:    0.7.0.1
 */