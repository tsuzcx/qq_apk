package cooperation.qqpim;

import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class QQPimPluginRuntimeHelper
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl != null) && (paramString != null)) {}
    try
    {
      try
      {
        localClass = Class.forName("com.qqpim.application.QQPimPluginRuntime");
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
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qqpim_plugin.apk");
      localClass = localClassLoader.loadClass("com.qqpim.application.QQPimPluginRuntime");
      BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      if (localClass == null)
      {
        if (!QLog.isColorLevel()) {
          break label230;
        }
        QLog.d(QQPimDefineList.a, 2, "createQQPimRuntime() cls == null");
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(QQPimDefineList.a, 2, "createQQPimRuntime() 1 ");
      }
      paramBaseApplicationImpl = localClass.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
        break label207;
      }
      if (QLog.isColorLevel()) {
        QLog.d(QQPimDefineList.a, 2, "createQQPimRuntime() succ");
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
    label207:
    return null;
    if (QLog.isColorLevel()) {
      QLog.d(QQPimDefineList.a, 2, "createQQPimRuntime() application == null || processName == null");
    }
    return null;
    label230:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginRuntimeHelper
 * JD-Core Version:    0.7.0.1
 */