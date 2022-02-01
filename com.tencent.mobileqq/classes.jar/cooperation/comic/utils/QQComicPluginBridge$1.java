package cooperation.comic.utils;

import cooperation.plugin.IPluginManager;

final class QQComicPluginBridge$1
  implements Runnable
{
  QQComicPluginBridge$1(IPluginManager paramIPluginManager, QQComicPluginBridge.PluginInstallObserver paramPluginInstallObserver) {}
  
  public void run()
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("comic_plugin.apk", new QQComicPluginBridge.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.QQComicPluginBridge.1
 * JD-Core Version:    0.7.0.1
 */