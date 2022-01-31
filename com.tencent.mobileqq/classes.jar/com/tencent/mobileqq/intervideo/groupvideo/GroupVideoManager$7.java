package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Handler;
import android.os.Looper;
import aqkz;
import aqlf;
import aqli;
import aqma;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import java.util.List;

public final class GroupVideoManager$7
  implements Runnable
{
  public GroupVideoManager$7(String paramString, aqlf paramaqlf) {}
  
  public void run()
  {
    try
    {
      if ("huiyin2".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {}
      for (List localList = new UpgradeablePluginManager(aqma.a(BaseApplicationImpl.getContext()), "huiyin2", aqli.a()).getCachedLatestPlugin(this.jdField_a_of_type_JavaLangString);; localList = aqkz.a().getCachedLatestPlugin(this.jdField_a_of_type_JavaLangString))
      {
        new Handler(Looper.getMainLooper()).post(new GroupVideoManager.7.1(this, localList));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.7
 * JD-Core Version:    0.7.0.1
 */