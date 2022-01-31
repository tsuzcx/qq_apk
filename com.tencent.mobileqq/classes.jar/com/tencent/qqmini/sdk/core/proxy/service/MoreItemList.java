package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.SharedPreferences;
import bfhm;
import com.tencent.qqmini.sdk.ui.MoreItem;
import java.util.ArrayList;

public class MoreItemList
  extends ArrayList<MoreItem>
{
  public static final int ABOUT = 5;
  public static final int COMPLAINT = 6;
  public static final int DEBUG = 7;
  private static final int FIRST_BUILTIN_ITEM = 1;
  public static final int MONITOR = 8;
  public static final int SHARE_QQ = 1;
  public static final int SHARE_QZONE = 2;
  public static final int SHARE_WX_FRIEND = 3;
  public static final int SHARE_WX_MOMENT = 4;
  private static final String TAG = "MoreItemList";
  
  private static boolean getEnableDebug(String paramString)
  {
    return bfhm.a().getBoolean(paramString + "_debug", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MoreItemList
 * JD-Core Version:    0.7.0.1
 */