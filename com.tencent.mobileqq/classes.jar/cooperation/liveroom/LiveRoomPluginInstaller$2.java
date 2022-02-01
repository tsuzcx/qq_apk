package cooperation.liveroom;

import cooperation.plugin.IPluginManager;

class LiveRoomPluginInstaller$2
  implements Runnable
{
  LiveRoomPluginInstaller$2(LiveRoomPluginInstaller paramLiveRoomPluginInstaller, IPluginManager paramIPluginManager, String paramString) {}
  
  public void run()
  {
    this.val$pluginManager.installPlugin("LiveRoomPlugin.apk", new LiveRoomPluginInstaller.MyOnPluginInstallListener(this.this$0, this.val$from));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginInstaller.2
 * JD-Core Version:    0.7.0.1
 */