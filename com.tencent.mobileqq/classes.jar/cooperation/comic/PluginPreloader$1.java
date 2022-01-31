package cooperation.comic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.text.TextUtils;
import bdgk;
import bimc;
import bime;
import bimi;
import bimk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public final class PluginPreloader$1
  implements Runnable
{
  public PluginPreloader$1(bime parambime) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    int i = (int)(bdgk.e() >> 20);
    try
    {
      bimk localbimk = new bimk();
      Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (this.a.jdField_a_of_type_JavaLangString.equals(localRunningAppProcessInfo.processName))
          {
            if ((this.a.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) && (!QIPCServerHelper.getInstance().isModuleRunning(this.a.jdField_c_of_type_JavaLangString)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + "  preload:ok:loadmodule " + this.a.jdField_c_of_type_JavaLangString);
              }
              localbimk.jdField_a_of_type_Int = 1;
              localbimk.jdField_a_of_type_JavaLangString = "preload:ok:loadmodule";
              bimi.a(localAppRuntime, this.a, i, localbimk);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + "  preload:fail:procexist " + this.a.jdField_a_of_type_JavaLangString);
            }
            bimc.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:procexist", i, new String[] { String.valueOf(this.a.d) });
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + " preload:fail:exception " + localException.getMessage());
      }
      bimc.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:exception", i, new String[] { String.valueOf(this.a.d), localException.getMessage() });
      return;
    }
    if (!this.a.a(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, this.a.jdField_a_of_type_JavaLangString + " is not allowed to preload.");
      }
      bimc.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, localException.jdField_a_of_type_Int, localException.jdField_a_of_type_JavaLangString, i, new String[] { String.valueOf(this.a.d) });
      return;
    }
    if (i < this.a.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.a.jdField_b_of_type_Int + "  preload:fail:memorylimit (" + i + "MB)");
      }
      bimc.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, 3, "preload:fail:memorylimit", i, new String[] { String.valueOf(this.a.d), String.valueOf(this.a.jdField_a_of_type_Int) });
      return;
    }
    if (!this.a.b(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the plugin is inactive.");
      }
      bimc.a(localAppRuntime, 1, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, localException.jdField_a_of_type_Int, localException.jdField_a_of_type_JavaLangString, i, new String[] { String.valueOf(this.a.d) });
      return;
    }
    bimi.a(localAppRuntime, this.a, i, localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.PluginPreloader.1
 * JD-Core Version:    0.7.0.1
 */