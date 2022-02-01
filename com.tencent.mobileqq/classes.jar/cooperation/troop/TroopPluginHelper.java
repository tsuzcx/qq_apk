package cooperation.troop;

import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class TroopPluginHelper
{
  public static final AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    String str;
    if ("troop_member_card_plugin.apk".equals(paramString)) {
      str = "com.tencent.mobileqq.memcard.base.TroopMemberCardAppInterface";
    } else if ("troop_manage_plugin.apk".equals(paramString)) {
      str = "com.tencent.mobileqq.base.TroopManageAppInterface";
    } else {
      str = null;
    }
    for (;;)
    {
      try
      {
        try
        {
          Class localClass = Class.forName(str);
          paramBaseApplicationImpl = localClass;
        }
        catch (Exception paramBaseApplicationImpl) {}catch (NoSuchMethodException paramBaseApplicationImpl) {}catch (InvocationTargetException paramBaseApplicationImpl) {}catch (InstantiationException paramBaseApplicationImpl) {}catch (IllegalAccessException paramBaseApplicationImpl) {}catch (IllegalArgumentException paramBaseApplicationImpl) {}
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        continue;
      }
      try
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, paramString);
        paramBaseApplicationImpl = paramString.loadClass(str);
        BasicClassTypeUtil.setClassLoader(true, paramString);
        if (paramBaseApplicationImpl == null)
        {
          QLog.e("TroopMemCardLog", 1, "*createTroopMemcardAppInterface load class fail");
          return null;
        }
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
          continue;
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    paramBaseApplicationImpl.printStackTrace();
    return null;
    paramBaseApplicationImpl.printStackTrace();
    return null;
    paramBaseApplicationImpl.printStackTrace();
    return null;
    paramBaseApplicationImpl.printStackTrace();
    return null;
    paramBaseApplicationImpl.printStackTrace();
    return null;
    paramBaseApplicationImpl.printStackTrace();
    return null;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginHelper
 * JD-Core Version:    0.7.0.1
 */