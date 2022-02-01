package com.tencent.mobileqq.wink;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQWinkEnvironment
{
  public static Context a()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public static AppRuntime b()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static AppInterface c()
  {
    return (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("peak");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.QQWinkEnvironment
 * JD-Core Version:    0.7.0.1
 */