package com.tencent.mobileqq.startup.step;

import ahca;
import awnu;
import awoa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import xfs;

public class LoadData
  extends Step
{
  protected boolean doStep()
  {
    boolean bool2 = true;
    AppActivity localAppActivity = this.mDirector.a;
    long l = System.currentTimeMillis();
    xfs.a = l;
    if ((!awnu.a()) || (BaseApplicationImpl.isCurrentVersionFirstLaunch) || (PluginUtils.getInstalledPluginPath(localAppActivity, "qzone_plugin.apk").exists())) {}
    for (;;)
    {
      try
      {
        QzonePluginProxyActivity.a(localAppActivity);
        if (localAppActivity != null)
        {
          if (!xfs.a(BaseApplicationImpl.sApplication)) {
            break;
          }
          ahca.a(BaseApplicationImpl.sApplication, true);
        }
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("LoadData", 1, "getQZonePluginClassLoader" + localException);
        continue;
      }
      QLog.e("LoadData", 1, "file == null");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.waitAppRuntime(null);
    if (this.mId == 18)
    {
      bool1 = true;
      if ((!localAppActivity.preloadData(localAppRuntime, bool1)) || (System.currentTimeMillis() - l >= 550L)) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */