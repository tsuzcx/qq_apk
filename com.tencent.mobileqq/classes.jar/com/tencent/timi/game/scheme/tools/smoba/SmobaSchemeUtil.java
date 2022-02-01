package com.tencent.timi.game.scheme.tools.smoba;

import android.content.Context;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.utils.Logger;

public class SmobaSchemeUtil
{
  public static String a = "SmobaSchemeUtil";
  
  public static String a()
  {
    return "tencentmsdk1104466820://";
  }
  
  public static boolean a(String paramString)
  {
    String str = SchemeUtil.b;
    Object localObject = TimiGameActivityManager.a();
    if (localObject == null) {
      localObject = Env.a();
    }
    boolean bool = SchemeUtil.a((Context)localObject, paramString, str, false);
    paramString = a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchSmobaScheme, ret = ");
    ((StringBuilder)localObject).append(bool);
    Logger.a(paramString, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public static boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("?launchtype=cymini");
    return a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.scheme.tools.smoba.SmobaSchemeUtil
 * JD-Core Version:    0.7.0.1
 */