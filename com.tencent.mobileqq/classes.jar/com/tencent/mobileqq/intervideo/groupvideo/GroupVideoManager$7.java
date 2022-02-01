package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloaderUtil;
import java.util.List;

final class GroupVideoManager$7
  implements Runnable
{
  GroupVideoManager$7(String paramString, IGroupVideoManager.CheckListener paramCheckListener) {}
  
  public void run()
  {
    try
    {
      if ("huiyin2".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        localList = new UpgradeablePluginManager(HuayangPluginNewDownloaderUtil.a(BaseApplicationImpl.getContext()), "huiyin2", IVPluginLoader.a()).getCachedLatestPlugin(this.jdField_a_of_type_JavaLangString);
      } else {
        localList = GroupVideoManager.a().getCachedLatestPlugin(this.jdField_a_of_type_JavaLangString);
      }
    }
    catch (Throwable localThrowable)
    {
      List localList;
      label55:
      break label55;
    }
    localList = null;
    new Handler(Looper.getMainLooper()).post(new GroupVideoManager.7.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.7
 * JD-Core Version:    0.7.0.1
 */