package com.tencent.mobileqq.utils;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;

public class PlayModeUtils
{
  public static int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      return 1;
    }
    if (paramBoolean2) {
      return 2;
    }
    if (paramBoolean1) {
      return 3;
    }
    return 4;
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, float paramFloat)
  {
    boolean bool1 = SonicHelper.a(paramFloat);
    boolean bool2 = SonicHelper.a(paramFloat, SonicHelper.b);
    boolean bool3 = SonicHelper.a(paramFloat, SonicHelper.c);
    Object localObject;
    if ((paramInt == 0) && (bool1))
    {
      if (bool3) {
        paramFloat = 2.0F;
      } else {
        paramFloat = 1.5F;
      }
      if (paramBoolean3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708208));
        ((StringBuilder)localObject).append(paramFloat);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708194));
        return ((StringBuilder)localObject).toString();
      }
      if (paramBoolean2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708220));
        ((StringBuilder)localObject).append(paramFloat);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708215));
        return ((StringBuilder)localObject).toString();
      }
      if (paramBoolean1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708203));
        ((StringBuilder)localObject).append(paramFloat);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708202));
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708193));
      ((StringBuilder)localObject).append(paramFloat);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708200));
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt != 0)
    {
      localObject = HardCodeUtil.a(2131708209);
      if (bool2) {
        return "当前为1.5倍速播放";
      }
      if (bool3) {
        return "当前为2倍速播放";
      }
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public static int b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!AppSetting.d)
    {
      if (paramBoolean3) {
        return 2131719243;
      }
      if (paramBoolean2) {
        return 2131719245;
      }
      if (paramBoolean1) {
        return 2131719246;
      }
      return 2131719244;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PlayModeUtils
 * JD-Core Version:    0.7.0.1
 */