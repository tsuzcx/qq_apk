package com.tencent.mobileqq.kandian.repo.aladdin;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJKanDianLockScreenPushAladdinConfig
{
  public static int a()
  {
    return Aladdin.getConfig(264).getIntegerFromString("show_timing", 1);
  }
  
  public static String a(Context paramContext)
  {
    return Aladdin.getConfig(264).getString("push_title", paramContext.getResources().getString(2131717943));
  }
  
  public static int b()
  {
    return Aladdin.getConfig(264).getIntegerFromString("open_type", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig
 * JD-Core Version:    0.7.0.1
 */