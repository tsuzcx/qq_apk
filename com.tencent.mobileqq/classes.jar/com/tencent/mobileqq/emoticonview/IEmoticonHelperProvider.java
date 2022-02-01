package com.tencent.mobileqq.emoticonview;

public abstract interface IEmoticonHelperProvider
{
  public static final int ID_CAMERA_EMOTICON_HELPER = 3;
  public static final int ID_CMSHOW_EMOTICON_HELPER = 9;
  public static final int ID_DTREPORT_EMOTICON_HELPER = 10;
  public static final int ID_EMOTICON_EXTEND_HELPER = 1;
  public static final int ID_FAV_EMOTICON_HELPER = 2;
  public static final int ID_HOTPIC_SEARCH_EMOTICON_HELPER = 7;
  public static final int ID_MALL_EMOTICON_HELPER = 5;
  public static final int ID_POPOUT_EMOTICON_HELPER = 11;
  public static final int ID_SETTING_EMOTICON_HELPER = 6;
  public static final int ID_SORT_EMOTICON_HELPER = 8;
  public static final int ID_SYSTEM_EMOJI_EMOTICON_HELPER = 4;
  
  public abstract <T extends AbstractEmoticonPanelHelper> T getHelper(int paramInt);
  
  public abstract void register(int paramInt, AbstractEmoticonPanelHelper paramAbstractEmoticonPanelHelper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmoticonHelperProvider
 * JD-Core Version:    0.7.0.1
 */