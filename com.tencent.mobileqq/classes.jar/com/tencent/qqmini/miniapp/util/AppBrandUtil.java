package com.tencent.qqmini.miniapp.util;

public class AppBrandUtil
{
  public static com.tencent.smtt.sdk.ValueCallback convertValueCallback(android.webkit.ValueCallback paramValueCallback)
  {
    if (paramValueCallback != null) {
      return new AppBrandUtil.1(paramValueCallback);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */