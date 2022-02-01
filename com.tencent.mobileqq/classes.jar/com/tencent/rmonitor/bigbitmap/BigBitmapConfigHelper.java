package com.tencent.rmonitor.bigbitmap;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;

public final class BigBitmapConfigHelper
{
  public static float a()
  {
    float f2 = ConfigProxy.INSTANCE.getConfig().b(152).f.f / 100.0F;
    float f1 = f2;
    if (f2 < 1.5F) {
      f1 = 1.5F;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.BigBitmapConfigHelper
 * JD-Core Version:    0.7.0.1
 */