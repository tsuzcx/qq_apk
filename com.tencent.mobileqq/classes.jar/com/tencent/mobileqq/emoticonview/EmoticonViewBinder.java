package com.tencent.mobileqq.emoticonview;

public abstract class EmoticonViewBinder
{
  public static final int TYPE_BIG_EMOTICON = 6;
  public static final int TYPE_CAMERA_EMOTICON = 11;
  public static final int TYPE_EMOJI = 2;
  public static final int TYPE_ENTRANCE_EMOTICON_SETTING = 101;
  public static final int TYPE_ENTRANCE_SECOND_TAB = 100;
  public static final int TYPE_FAVORITE = 5;
  public static final int TYPE_HOTPIC_SEARCH_EMOTICON = 12;
  public static final int TYPE_MAGIC_FACE = 9;
  public static final int TYPE_PLUS_BUTTON = 13;
  public static final int TYPE_RECENT = 3;
  public static final int TYPE_RECENT_AND_FAV = 4;
  public static final int TYPE_RECOMMEND = 8;
  public static final int TYPE_SETTING_BUTTON = 14;
  public static final int TYPE_SMALL_EMOTICON = 10;
  public static final int TYPE_SYSTEM = 1;
  public static final int TYPE_SYSTEM_AND_EMOJI = 7;
  public int type;
  
  public EmoticonViewBinder(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void destroy() {}
  
  public int getPanelPageCount()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonViewBinder
 * JD-Core Version:    0.7.0.1
 */