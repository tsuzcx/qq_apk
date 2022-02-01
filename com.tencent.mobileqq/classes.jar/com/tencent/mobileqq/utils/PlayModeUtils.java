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
    String str = "";
    boolean bool1 = SonicHelper.a(paramFloat);
    boolean bool2 = SonicHelper.a(paramFloat, SonicHelper.b);
    boolean bool3 = SonicHelper.a(paramFloat, SonicHelper.c);
    if ((paramInt == 0) && (bool1)) {
      if (bool3)
      {
        paramFloat = 2.0F;
        if (!paramBoolean3) {
          break label95;
        }
        str = HardCodeUtil.a(2131708199) + paramFloat + HardCodeUtil.a(2131708185);
      }
    }
    label95:
    do
    {
      do
      {
        return str;
        paramFloat = 1.5F;
        break;
        if (paramBoolean2) {
          return HardCodeUtil.a(2131708211) + paramFloat + HardCodeUtil.a(2131708206);
        }
        if (paramBoolean1) {
          return HardCodeUtil.a(2131708194) + paramFloat + HardCodeUtil.a(2131708193);
        }
        return HardCodeUtil.a(2131708184) + paramFloat + HardCodeUtil.a(2131708191);
      } while (paramInt == 0);
      str = HardCodeUtil.a(2131708200);
      if (bool2) {
        return "当前为1.5倍速播放";
      }
    } while (!bool3);
    return "当前为2倍速播放";
  }
  
  public static int b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    if (!AppSetting.d)
    {
      if (paramBoolean3) {
        i = 2131719525;
      }
    }
    else {
      return i;
    }
    if (paramBoolean2) {
      return 2131719527;
    }
    if (paramBoolean1) {
      return 2131719528;
    }
    return 2131719526;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PlayModeUtils
 * JD-Core Version:    0.7.0.1
 */