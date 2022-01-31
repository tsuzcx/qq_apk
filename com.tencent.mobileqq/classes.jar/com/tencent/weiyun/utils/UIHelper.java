package com.tencent.weiyun.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;

public class UIHelper
{
  private static final Object SCREEN_SIZE_LOCK;
  private static final String TAG = "UIHelper";
  private static final SparseArray<String> THUMBNAIL_SPEC;
  private static final String VIDEO_THUMB_SPEC_MIDDLE = "/128";
  private static final String VIDEO_THUMB_SPEC_XLARGE = "/640";
  private static volatile int WINDOW_SCREEN_HEIGHT_LAND;
  private static volatile String WINDOW_SCREEN_SIZE_LAND;
  private static volatile String WINDOW_SCREEN_SIZE_PORT;
  private static volatile int WINDOW_SCREEN_WIDTH_LAND = -1;
  
  static
  {
    WINDOW_SCREEN_HEIGHT_LAND = -1;
    WINDOW_SCREEN_SIZE_LAND = "";
    WINDOW_SCREEN_SIZE_PORT = "";
    SCREEN_SIZE_LOCK = new Object();
    THUMBNAIL_SPEC = new SparseArray(UIHelper.ThumbnailSpec.size());
    THUMBNAIL_SPEC.put(UIHelper.ThumbnailSpec.SMALL.value(), "64*64");
    THUMBNAIL_SPEC.put(UIHelper.ThumbnailSpec.MIDDLE.value(), "128*128");
    THUMBNAIL_SPEC.put(UIHelper.ThumbnailSpec.LARGE.value(), "256*256");
    THUMBNAIL_SPEC.put(UIHelper.ThumbnailSpec.XLARGE.value(), "640*640");
    THUMBNAIL_SPEC.put(UIHelper.ThumbnailSpec.XXLARGE.value(), "1024*1024");
  }
  
  public static String getThumbnailSpec(Context paramContext, UIHelper.ThumbnailSpec paramThumbnailSpec)
  {
    if (UIHelper.ThumbnailSpec.SCREEN.value() == paramThumbnailSpec.value())
    {
      if (paramContext != null) {
        return getWindowScreenSizeStr(paramContext);
      }
      return (String)THUMBNAIL_SPEC.get(UIHelper.ThumbnailSpec.XXLARGE.value());
    }
    return (String)THUMBNAIL_SPEC.get(paramThumbnailSpec.value());
  }
  
  public static String getVideoThumbSpec(UIHelper.ThumbnailSpec paramThumbnailSpec)
  {
    switch (UIHelper.1.$SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[paramThumbnailSpec.ordinal()])
    {
    default: 
      return "/640";
    }
    return "/128";
  }
  
  public static int getWindowScreenHeight(Context paramContext)
  {
    getWindowScreenSize(paramContext);
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return WINDOW_SCREEN_HEIGHT_LAND;
    }
    return WINDOW_SCREEN_WIDTH_LAND;
  }
  
  private static void getWindowScreenSize(Context paramContext)
  {
    for (;;)
    {
      int j;
      synchronized (SCREEN_SIZE_LOCK)
      {
        WindowManager localWindowManager;
        if ((WINDOW_SCREEN_WIDTH_LAND < 0) || (WINDOW_SCREEN_HEIGHT_LAND < 0))
        {
          localWindowManager = (WindowManager)paramContext.getSystemService("window");
          if (paramContext.getResources().getConfiguration().orientation != 2) {
            break label297;
          }
          i = 1;
          if (Build.VERSION.SDK_INT < 13) {
            continue;
          }
          paramContext = new Point();
          localWindowManager.getDefaultDisplay().getSize(paramContext);
          if (i != 0)
          {
            j = paramContext.x;
            WINDOW_SCREEN_WIDTH_LAND = j;
            if (i == 0) {
              continue;
            }
            i = paramContext.y;
            WINDOW_SCREEN_HEIGHT_LAND = i;
            WINDOW_SCREEN_SIZE_LAND = Integer.toString(WINDOW_SCREEN_WIDTH_LAND) + '*' + Integer.toString(WINDOW_SCREEN_HEIGHT_LAND);
            WINDOW_SCREEN_SIZE_PORT = Integer.toString(WINDOW_SCREEN_HEIGHT_LAND) + '*' + Integer.toString(WINDOW_SCREEN_WIDTH_LAND);
            Log.d("UIHelper", "Get ScreenSize(lw=" + WINDOW_SCREEN_WIDTH_LAND + ", lh=" + WINDOW_SCREEN_HEIGHT_LAND + ")");
          }
        }
        else
        {
          return;
        }
        j = paramContext.y;
        continue;
        i = paramContext.x;
        continue;
        j = localWindowManager.getDefaultDisplay().getWidth();
        k = localWindowManager.getDefaultDisplay().getHeight();
        if (i != 0)
        {
          m = j;
          WINDOW_SCREEN_WIDTH_LAND = m;
          if (i == 0) {
            break label292;
          }
          WINDOW_SCREEN_HEIGHT_LAND = k;
        }
      }
      int m = k;
      continue;
      label292:
      int k = j;
      continue;
      label297:
      int i = 0;
    }
  }
  
  public static String getWindowScreenSizeStr(Context paramContext)
  {
    getWindowScreenSize(paramContext);
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return WINDOW_SCREEN_SIZE_LAND;
    }
    return WINDOW_SCREEN_SIZE_PORT;
  }
  
  public static int getWindowScreenWidth(Context paramContext)
  {
    getWindowScreenSize(paramContext);
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return WINDOW_SCREEN_WIDTH_LAND;
    }
    return WINDOW_SCREEN_HEIGHT_LAND;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.utils.UIHelper
 * JD-Core Version:    0.7.0.1
 */