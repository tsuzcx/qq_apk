package cooperation.qqindividuality;

import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class QQIndividualityRuntimeHelper
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl != null) && (paramString != null)) {}
    try
    {
      try
      {
        localClass = Class.forName("com.qqindividuality.application.QQIndividualityRuntime");
      }
      catch (Exception paramBaseApplicationImpl) {}catch (NoSuchMethodException paramBaseApplicationImpl) {}catch (InvocationTargetException paramBaseApplicationImpl) {}catch (InstantiationException paramBaseApplicationImpl) {}catch (IllegalAccessException paramBaseApplicationImpl) {}catch (IllegalArgumentException paramBaseApplicationImpl) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      label44:
      ClassLoader localClassLoader;
      break label44;
    }
    try
    {
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qqindividuality_plugin.apk");
      localClass = localClassLoader.loadClass("com.qqindividuality.application.QQIndividualityRuntime");
      BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      if (localClass == null)
      {
        if (!QLog.isColorLevel()) {
          break label222;
        }
        QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() cls == null");
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() 1 ");
      }
      paramBaseApplicationImpl = localClass.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      if (!(paramBaseApplicationImpl instanceof AppRuntime)) {
        break label200;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() succ");
      }
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (ClassNotFoundException paramBaseApplicationImpl)
    {
      paramBaseApplicationImpl.printStackTrace();
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
    label200:
    return null;
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() application == null || processName == null");
    }
    return null;
    label222:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityRuntimeHelper
 * JD-Core Version:    0.7.0.1
 */