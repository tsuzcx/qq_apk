package com.tencent.mobileqq.mini.entry.desktop.item;

public abstract class DesktopItemInfo
{
  public static final int TYPE_APP_LIST = 6;
  public static final int TYPE_CHESS_ROOM_CARD_ENTRY = 14;
  public static final int TYPE_CHESS_ROOM_ENTRY = 15;
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
  public static final int TYPE_MOST_COMMONLY_USED = 12;
  public static final int TYPE_SPRING_ENTRY = 13;
  public boolean deleteEnable = false;
  public boolean dragEnable = false;
  public boolean dropEnable = false;
  private boolean isFixApp = false;
  public boolean isTemp = false;
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
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    this.visible = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
 * JD-Core Version:    0.7.0.1
 */