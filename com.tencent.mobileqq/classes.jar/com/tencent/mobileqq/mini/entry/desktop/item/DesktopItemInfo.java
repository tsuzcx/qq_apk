package com.tencent.mobileqq.mini.entry.desktop.item;

public abstract class DesktopItemInfo
{
  public static final int TYPE_APP_LIST = 6;
  public static final int TYPE_MINI_APP = 2;
  public static final int TYPE_MINI_EMPTY = 3;
  public static final int TYPE_MINI_MODULE_GUIDE = 4;
  public static final int TYPE_MINI_SEARCH = 5;
  public static final int TYPE_MODULE_DITTO = 11;
  public static final int TYPE_MODULE_FRIENDS_PK = 10;
  public static final int TYPE_MODULE_INFO = 1;
  public static final int TYPE_MODULE_INFO_NEW = 7;
  public static final int TYPE_MODULE_POPULARITY_LIST = 9;
  public static final int TYPE_MODULE_RECOMMEND = 8;
  public boolean deleteEnable;
  public boolean dragEnable;
  public boolean dropEnable;
  private boolean isFixApp;
  public boolean isTemp;
  public int mModuleType;
  public int visible = 0;
  
  public int getModuleType()
  {
    return this.mModuleType;
  }
  
  public boolean isFixApp()
  {
    return this.isFixApp;
  }
  
  public void setIsFixApp(boolean paramBoolean)
  {
    this.isFixApp = paramBoolean;
  }
  
  public void setIsTemp(boolean paramBoolean)
  {
    this.isTemp = paramBoolean;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.visible = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
 * JD-Core Version:    0.7.0.1
 */