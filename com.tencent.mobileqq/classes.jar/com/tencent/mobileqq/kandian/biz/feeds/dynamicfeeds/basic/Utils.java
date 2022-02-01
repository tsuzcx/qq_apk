package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class Utils
{
  public static boolean a()
  {
    Object localObject = Aladdin.getConfig(144);
    boolean bool;
    if (localObject != null)
    {
      localObject = ((AladdinConfig)localObject).getString("dc_switch", "0");
      QLog.d("DynamicChannelUtils", 1, new Object[] { "dcSwitch = ", localObject });
      bool = TextUtils.equals((CharSequence)localObject, "1");
    }
    else
    {
      bool = false;
    }
    QLog.d("DynamicChannelUtils", 1, new Object[] { "isDynamicChannelSwitchOn = ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public static void b()
  {
    if (a())
    {
      QLog.d("DynamicChannelUtils", 1, "dynamicChannelSwitch is on, prepare it.");
      ThreadManager.getSubThreadHandler().postDelayed(new Utils.1(), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.Utils
 * JD-Core Version:    0.7.0.1
 */