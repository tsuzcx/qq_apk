package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import java.util.Calendar;

public class NoDisturbUtil
{
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) && ((paramAppInterface.isBackground_Pause) || (!ReflectionUtil.a(BaseApplicationImpl.sApplication))))
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 23) || (i < 8)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.util.NoDisturbUtil
 * JD-Core Version:    0.7.0.1
 */