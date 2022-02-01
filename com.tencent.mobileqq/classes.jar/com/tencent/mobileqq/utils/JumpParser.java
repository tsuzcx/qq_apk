package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.jumpcontroller.IJumpParserInterface;
import com.tencent.mobileqq.app.parser.jumpcontroller.JumpActivityInjectUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class JumpParser
{
  private static IJumpParserInterface a;
  
  static
  {
    try
    {
      if (JumpActivityInjectUtil.c.size() > 0)
      {
        a = (IJumpParserInterface)((Class)JumpActivityInjectUtil.c.get(0)).newInstance();
        QLog.d("JumpAction", 1, "JumpParserInject newInstance");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("JumpAction", 1, "JumpParserInject static statement: ", localException);
    }
  }
  
  public static JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString)
  {
    do
    {
      try
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Jump input=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("JumpAction", 2, ((StringBuilder)localObject1).toString());
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2 = new HashMap(1);
        ((HashMap)localObject2).put("keyJumpParserUtilUrlErrorKey", paramString);
        ((HashMap)localObject2).put("keyJumpParserUtilSceneErrorKey", "2");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, (HashMap)localObject2, "", false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("JumpParser parser Exception =");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("JumpAction", 1, ((StringBuilder)localObject2).toString());
        paramBaseQQAppInterface = new JumpAction(paramBaseQQAppInterface, paramContext);
        paramBaseQQAppInterface.d = "";
        paramBaseQQAppInterface.e = "";
        paramBaseQQAppInterface.c = paramString;
        return paramBaseQQAppInterface;
      }
      localObject1 = a.a(paramBaseQQAppInterface, paramContext, paramString);
      return localObject1;
    } while (paramString != null);
    return null;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    try
    {
      str = URLDecoder.decode(paramString);
      localObject = str;
      if (!paramBoolean) {}
    }
    catch (Exception localException1)
    {
      String str;
      Object localObject;
      label22:
      label25:
      label27:
      break label25;
    }
    try
    {
      localObject = str.replaceAll(" ", "+");
      return localObject;
    }
    catch (Exception localException2)
    {
      break label22;
    }
    break label27;
    str = null;
    localObject = str;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JumpParser parser Exception =");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString());
      localObject = str;
    }
    return localObject;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i), paramString1.substring(i + paramString2.length(), paramString1.length()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpParser
 * JD-Core Version:    0.7.0.1
 */