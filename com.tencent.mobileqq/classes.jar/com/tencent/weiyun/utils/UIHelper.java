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
  private static final Object SCREEN_SIZE_LOCK = new Object();
  private static final String TAG = "UIHelper";
  private static final SparseArray<String> THUMBNAIL_SPEC = new SparseArray(UIHelper.ThumbnailSpec.size());
  private static final String VIDEO_THUMB_SPEC_MIDDLE = "/128";
  private static final String VIDEO_THUMB_SPEC_XLARGE = "/640";
  private static volatile int WINDOW_SCREEN_HEIGHT_LAND = -1;
  private static volatile String WINDOW_SCREEN_SIZE_LAND = "";
  private static volatile String WINDOW_SCREEN_SIZE_PORT = "";
  private static volatile int WINDOW_SCREEN_WIDTH_LAND = -1;
  
  static
  {
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
    int i = UIHelper.1.$SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[paramThumbnailSpec.ordinal()];
    if ((i != 1) && (i != 2)) {
      return "/640";
    }
    return "/128";
  }
  
  public static int getWindowScreenHeight(Context paramContext)
  {
    getWindowScreenSize(paramContext);
    int i;
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
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
        if ((WINDOW_SCREEN_WIDTH_LAND < 0) || (WINDOW_SCREEN_HEIGHT_LAND < 0))
        {
          WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
          if (paramContext.getResources().getConfiguration().orientation == 2)
          {
            i = 1;
            if (Build.VERSION.SDK_INT >= 13)
            {
              paramContext = new Point();
              localWindowManager.getDefaultDisplay().getSize(paramContext);
              if (i != 0) {
                j = paramContext.x;
              } else {
                j = paramContext.y;
              }
              WINDOW_SCREEN_WIDTH_LAND = j;
              if (i != 0) {
                i = paramContext.y;
              } else {
                i = paramContext.x;
              }
              WINDOW_SCREEN_HEIGHT_LAND = i;
            }
            else
            {
              j = localWindowManager.getDefaultDisplay().getWidth();
              k = localWindowManager.getDefaultDisplay().getHeight();
              if (i == 0) {
                break label328;
              }
              m = j;
              WINDOW_SCREEN_WIDTH_LAND = m;
              if (i == 0) {
                break label334;
              }
              WINDOW_SCREEN_HEIGHT_LAND = k;
            }
            paramContext = new StringBuilder();
            paramContext.append(Integer.toString(WINDOW_SCREEN_WIDTH_LAND));
            paramContext.append('*');
            paramContext.append(Integer.toString(WINDOW_SCREEN_HEIGHT_LAND));
            WINDOW_SCREEN_SIZE_LAND = paramContext.toString();
            paramContext = new StringBuilder();
            paramContext.append(Integer.toString(WINDOW_SCREEN_HEIGHT_LAND));
            paramContext.append('*');
            paramContext.append(Integer.toString(WINDOW_SCREEN_WIDTH_LAND));
            WINDOW_SCREEN_SIZE_PORT = paramContext.toString();
            paramContext = new StringBuilder();
            paramContext.append("Get ScreenSize(lw=");
            paramContext.append(WINDOW_SCREEN_WIDTH_LAND);
            paramContext.append(", lh=");
            paramContext.append(WINDOW_SCREEN_HEIGHT_LAND);
            paramContext.append(")");
            Log.d("UIHelper", paramContext.toString());
          }
        }
        else
        {
          return;
        }
      }
      int i = 0;
      continue;
      label328:
      int m = k;
      continue;
      label334:
      int k = j;
    }
  }
  
  public static String getWindowScreenSizeStr(Context paramContext)
  {
    getWindowScreenSize(paramContext);
    int i;
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return WINDOW_SCREEN_SIZE_LAND;
    }
    return WINDOW_SCREEN_SIZE_PORT;
  }
  
  public static int getWindowScreenWidth(Context paramContext)
  {
    getWindowScreenSize(paramContext);
    int i;
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return WINDOW_SCREEN_WIDTH_LAND;
    }
    return WINDOW_SCREEN_HEIGHT_LAND;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.utils.UIHelper
 * JD-Core Version:    0.7.0.1
 */