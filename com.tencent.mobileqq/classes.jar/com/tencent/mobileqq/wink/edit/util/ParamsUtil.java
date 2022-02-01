package com.tencent.mobileqq.wink.edit.util;

import com.tencent.mobileqq.wink.QQWinkEnvironment;
import java.util.ArrayList;
import java.util.List;
import org.light.device.LightDeviceUtils;

public class ParamsUtil
{
  private static List<String> a = new ArrayList();
  
  static
  {
    a.add("pbem00");
  }
  
  public static <T> T a(T paramT1, T paramT2, T paramT3)
  {
    long l = LightDeviceUtils.getTotalRamMemory(QQWinkEnvironment.a());
    if (l <= 2147483648L) {
      return paramT1;
    }
    if (l <= 4294967296L) {
      return paramT2;
    }
    return paramT3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.util.ParamsUtil
 * JD-Core Version:    0.7.0.1
 */