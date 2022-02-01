package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.Serializable;

public class FlashChatItem
  implements Serializable
{
  public static final int FREETYPE_FREE = 1;
  public static final int FREETYPE_SVIP = 5;
  public static final int FREETYPE_VIP = 4;
  public static final int ID_NORMAL = -100001;
  public static final int ID_RANDOM = -100000;
  public static FlashChatItem sDefaultItem = new FlashChatItem(-100000, HardCodeUtil.a(2131704722));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlashChatItem{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.appName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedType=");
    localStringBuilder.append(this.feedType);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mainView='");
    localStringBuilder.append(this.mainView);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver='");
    localStringBuilder.append(this.ver);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatItem
 * JD-Core Version:    0.7.0.1
 */