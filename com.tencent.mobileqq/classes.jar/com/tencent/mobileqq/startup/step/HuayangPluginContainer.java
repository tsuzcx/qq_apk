package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginContainerLoader;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader;
import java.io.File;
import java.util.List;

public class HuayangPluginContainer
  extends Step
{
  protected boolean a()
  {
    Object localObject1 = HuayangPluginNewDownloader.a(BaseApplicationImpl.getContext());
    Object localObject2 = new UpgradeablePluginManager((File)localObject1, "group_video");
    UpgradeablePluginManager localUpgradeablePluginManager = new UpgradeablePluginManager((File)localObject1, "hy_sixgod");
    localObject1 = new DynamicPluginContainerLoader();
    localObject2 = ((UpgradeablePluginManager)localObject2).getCachedLatestPlugin("group_video");
    if (localObject2 != null) {}
    try
    {
      if (!((List)localObject2).isEmpty())
      {
        ((DynamicPluginContainerLoader)localObject1).load((InstalledPlugin)((List)localObject2).get(0));
      }
      else
      {
        localObject2 = localUpgradeablePluginManager.getCachedLatestPlugin("hy_sixgod");
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          ((DynamicPluginContainerLoader)localObject1).load((InstalledPlugin)((List)localObject2).get(0));
        }
      }
    }
    catch (Exception localException) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HuayangPluginContainer
 * JD-Core Version:    0.7.0.1
 */