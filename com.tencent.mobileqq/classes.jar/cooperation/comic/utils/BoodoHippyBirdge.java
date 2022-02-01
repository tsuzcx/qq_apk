package cooperation.comic.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.module.boodo.BoodoModuleProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.config.business.QQComicConfBean.BoodoHippyConfig;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.lang.reflect.Constructor;
import java.util.List;

public class BoodoHippyBirdge
{
  public static IBoodoHippyApiBuilder a;
  public static boolean a;
  
  public static BoodoModuleProxy a()
  {
    if (a != null) {
      return a.a();
    }
    QLog.i("BoodoHippyBirdge", 1, "createBoodoModuleImp");
    return null;
  }
  
  public static HippyAPIProvider a()
  {
    if (a != null) {
      return a.a();
    }
    QLog.i("BoodoHippyBirdge", 1, "getBoodoProvider");
    return null;
  }
  
  public static void a()
  {
    try
    {
      Constructor localConstructor = PluginStatic.getOrCreateClassLoader(BaseApplicationImpl.getContext(), "comic_plugin.apk").loadClass("com.qqcomic.app.BoodoPluginTask").getDeclaredConstructor(new Class[0]);
      localConstructor.setAccessible(true);
      localConstructor.newInstance(new Object[0]);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.e("BoodoHippyBirdge", 1, localClassNotFoundException, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("BoodoHippyBirdge", 1, localIllegalAccessException, new Object[0]);
      return;
    }
    catch (InstantiationException localInstantiationException)
    {
      QLog.e("BoodoHippyBirdge", 1, localInstantiationException, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BoodoHippyBirdge", 1, localException, new Object[0]);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener)
  {
    if (paramQQAppInterface == null)
    {
      if (paramICheckPluginListener != null) {
        paramICheckPluginListener.a(-1, null);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BoodoHippyBirdge", 2, "checkPluginInstall");
    }
    ThreadManagerV2.excute(new BoodoHippyBirdge.2(paramQQAppInterface, paramICheckPluginListener, paramContext), 16, null, false);
  }
  
  public static void a(Context paramContext, BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener)
  {
    if (BaseApplicationImpl.sProcessId != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "checkPluginInstall not in ProcessQQ");
      }
      paramContext = new Bundle();
      QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "check_qqcomic_plugin", paramContext, new BoodoHippyBirdge.1(paramICheckPluginListener));
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      a(paramContext, (QQAppInterface)localObject, paramICheckPluginListener);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if ("QQBoodoComic".equals(paramString)) {
      return true;
    }
    if (!QQComicConfBean.a().mAllModules.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, new Object[] { "isBoodoModule moduleName:", paramString });
      }
      return QQComicConfBean.a().mAllModules.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.BoodoHippyBirdge
 * JD-Core Version:    0.7.0.1
 */