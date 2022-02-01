package com.tencent.mobileqq.flashchat;

import anvx;
import java.io.Serializable;

public class FlashChatItem
  implements Serializable
{
  public static final int FREETYPE_FREE = 1;
  public static final int FREETYPE_SVIP = 5;
  public static final int FREETYPE_VIP = 4;
  public static final int ID_NORMAL = -100001;
  public static final int ID_RANDOM = -100000;
  public static FlashChatItem sDefaultItem = new FlashChatItem(-100000, anvx.a(2131704094));
  public String appName;
  public String color = "#02A7E3";
  public int feedType;
  public String iconUrl;
  public int id;
  public String mainView;
  public String name;
  public int tabType;
  public String ver;
  
  public FlashChatItem() {}
  
  public FlashChatItem(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.name = paramString;
  }
  
  public String toString()
  {
    return "FlashChatItem{id=" + this.id + ", appName='" + this.appName + '\'' + ", feedType=" + this.feedType + ", name='" + this.name + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", mainView='" + this.mainView + '\'' + ", ver='" + this.ver + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatItem
 * JD-Core Version:    0.7.0.1
 */