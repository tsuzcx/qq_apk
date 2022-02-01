package cooperation.qqdataline;

import android.content.Context;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class DatalineHelper
{
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createDatalineAppInterface processName:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("DatalineHelper", 1, ((StringBuilder)localObject).toString());
    if ((paramBaseApplicationImpl != null) && (paramString != null))
    {
      try
      {
        localObject = Class.forName("com.qqdataline.app.DatalineAppInterface");
      }
      catch (Exception paramBaseApplicationImpl) {}catch (NoSuchMethodException paramBaseApplicationImpl) {}catch (InvocationTargetException paramBaseApplicationImpl) {}catch (InstantiationException paramBaseApplicationImpl) {}catch (IllegalAccessException paramBaseApplicationImpl) {}catch (IllegalArgumentException paramBaseApplicationImpl) {}catch (ClassNotFoundException localClassNotFoundException) {}
      try
      {
        ClassLoader localClassLoader = a(paramBaseApplicationImpl);
        localObject = localClassLoader.loadClass("com.qqdataline.app.DatalineAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        localClassNotFoundException.printStackTrace();
        if (localObject == null)
        {
          QLog.e("DatalineHelper", 1, "createDatalineAppInterface cls is null");
          return null;
        }
        paramBaseApplicationImpl = ((Class)localObject).getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppInterface))) {
          return (AppInterface)paramBaseApplicationImpl;
        }
        QLog.e("DatalineHelper", 1, "createDatalineAppInterface obj is not AppInterface instance");
        return null;
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
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
    }
    QLog.e("DatalineHelper", 1, "createDatalineAppInterface content is null");
    return null;
  }
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qqdataline.apk");
  }
  
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bigTValue:");
      localStringBuilder.append(paramString);
      QLog.d("DATALINE_LOG", 4, localStringBuilder.toString());
    }
    a(paramString, 1);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      QQAppInterface localQQAppInterface = null;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localQQAppInterface = (QQAppInterface)localAppRuntime;
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "DatalineClickReport", paramString, 0, paramInt, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqdataline.DatalineHelper
 * JD-Core Version:    0.7.0.1
 */