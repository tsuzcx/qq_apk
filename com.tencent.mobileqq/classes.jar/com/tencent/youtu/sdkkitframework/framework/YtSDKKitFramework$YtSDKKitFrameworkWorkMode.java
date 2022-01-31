package com.tencent.youtu.sdkkitframework.framework;

import java.util.HashMap;

public enum YtSDKKitFramework$YtSDKKitFrameworkWorkMode
{
  private static HashMap<Integer, YtSDKKitFrameworkWorkMode> map;
  private int value;
  
  static
  {
    int i = 0;
    YT_FW_UNKNOWN = new YtSDKKitFrameworkWorkMode("YT_FW_UNKNOWN", 0, 0);
    YT_FW_OCR_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_OCR_TYPE", 1, 1);
    YT_FW_SILENT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_SILENT_TYPE", 2, 2);
    YT_FW_ACTION_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_ACTION_TYPE", 3, 3);
    YT_FW_REFLECT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_REFLECT_TYPE", 4, 4);
    YT_FW_ACTREFLECT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_ACTREFLECT_TYPE", 5, 5);
    $VALUES = new YtSDKKitFrameworkWorkMode[] { YT_FW_UNKNOWN, YT_FW_OCR_TYPE, YT_FW_SILENT_TYPE, YT_FW_ACTION_TYPE, YT_FW_REFLECT_TYPE, YT_FW_ACTREFLECT_TYPE };
    map = new HashMap();
    YtSDKKitFrameworkWorkMode[] arrayOfYtSDKKitFrameworkWorkMode = values();
    int j = arrayOfYtSDKKitFrameworkWorkMode.length;
    while (i < j)
    {
      YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = arrayOfYtSDKKitFrameworkWorkMode[i];
      map.put(Integer.valueOf(localYtSDKKitFrameworkWorkMode.value), localYtSDKKitFrameworkWorkMode);
      i += 1;
    }
  }
  
  private YtSDKKitFramework$YtSDKKitFrameworkWorkMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static YtSDKKitFrameworkWorkMode valueOf(int paramInt)
  {
    if (map.get(Integer.valueOf(paramInt)) == null) {
      return YT_FW_UNKNOWN;
    }
    return (YtSDKKitFrameworkWorkMode)map.get(Integer.valueOf(paramInt));
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode
 * JD-Core Version:    0.7.0.1
 */