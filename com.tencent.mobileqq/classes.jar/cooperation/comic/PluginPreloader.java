package cooperation.comic;

import alta;
import altb;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class PluginPreloader
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(PluginPreloadStrategy paramPluginPreloadStrategy)
  {
    a(paramPluginPreloadStrategy, 0L);
  }
  
  public static void a(PluginPreloadStrategy paramPluginPreloadStrategy, long paramLong)
  {
    if ((paramPluginPreloadStrategy == null) || (paramPluginPreloadStrategy.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new alta(paramPluginPreloadStrategy), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, PluginPreloadStrategy paramPluginPreloadStrategy, int paramInt, PluginPreloader.ExtraResult paramExtraResult)
  {
    paramPluginPreloadStrategy.a(paramExtraResult);
    if (paramPluginPreloadStrategy.jdField_b_of_type_JavaLangString != null)
    {
      IPluginManager localIPluginManager = (IPluginManager)paramAppRuntime.getManager(26);
      if (localIPluginManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + paramPluginPreloadStrategy.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        PluginPreloadReportUtils.a(paramAppRuntime, 1, paramPluginPreloadStrategy.jdField_b_of_type_Int, paramPluginPreloadStrategy.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(paramPluginPreloadStrategy.d) });
        return;
      }
      PluginInfo localPluginInfo = localIPluginManager.a(paramPluginPreloadStrategy.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + paramPluginPreloadStrategy.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        PluginPreloadReportUtils.a(paramAppRuntime, 1, paramPluginPreloadStrategy.jdField_b_of_type_Int, paramPluginPreloadStrategy.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(paramPluginPreloadStrategy.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        PluginPreloadReportUtils.a(paramAppRuntime, 0, paramPluginPreloadStrategy.jdField_b_of_type_Int, paramPluginPreloadStrategy.c, paramExtraResult.jdField_a_of_type_Int, paramExtraResult.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(paramPluginPreloadStrategy.d) });
        paramPluginPreloadStrategy.a();
        return;
      }
      if ((paramPluginPreloadStrategy.jdField_a_of_type_Boolean) && (NetworkUtil.h(BaseApplicationImpl.getContext())))
      {
        localIPluginManager.installPlugin(paramPluginPreloadStrategy.jdField_b_of_type_JavaLangString, new altb(paramAppRuntime, paramPluginPreloadStrategy, paramExtraResult, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + paramPluginPreloadStrategy.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      PluginPreloadReportUtils.a(paramAppRuntime, 1, paramPluginPreloadStrategy.jdField_b_of_type_Int, paramPluginPreloadStrategy.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(paramPluginPreloadStrategy.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    PluginPreloadReportUtils.a(paramAppRuntime, 0, paramPluginPreloadStrategy.jdField_b_of_type_Int, paramPluginPreloadStrategy.c, paramExtraResult.jdField_a_of_type_Int, paramExtraResult.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(paramPluginPreloadStrategy.d) });
    paramPluginPreloadStrategy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.PluginPreloader
 * JD-Core Version:    0.7.0.1
 */