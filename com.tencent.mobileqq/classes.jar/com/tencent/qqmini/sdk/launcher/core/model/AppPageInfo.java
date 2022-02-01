package com.tencent.qqmini.sdk.launcher.core.model;

public class AppPageInfo
{
  public static final int FLAG_GET_ALL = -1;
  public static final int FLAG_GET_NONE = 0;
  public static final int FLAG_GET_PAGE_ID = 1;
  public static final int FLAG_GET_PAGE_URL = 2;
  public static final int FLAG_GET_PAGE_WINDOW_HEIGHT = 8;
  public static final int FLAG_GET_PAGE_WINDOW_WIDTH = 4;
  public static final int FLAG_GET_SURFACE_VIEW_HEIGHT = 32;
  public static final int FLAG_GET_SURFACE_VIEW_WIDTH = 16;
  public static final int FLAG_GET_WEB_VIEW_URL = 64;
  public int pageId;
  public String pageUrl;
  public int surfaceViewHeight;
  public int surfaceViewWidth;
  public String webViewUrl;
  public int windowHeight;
  public int windowWidth;
  
  public static boolean enableGetAll(int paramInt)
  {
    return paramInt == -1;
  }
  
  public static boolean enableGetPageId(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean enableGetPageUrl(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean enableGetPageWindowHeight(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean enableGetPageWindowWidth(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean enableGetWebViewUrl(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo
 * JD-Core Version:    0.7.0.1
 */