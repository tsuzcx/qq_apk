package cooperation.groupvideo;

import cooperation.plugin.IPluginManager;

class GVideoPluginInstallerActivity$3
  implements Runnable
{
  GVideoPluginInstallerActivity$3(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity) {}
  
  public void run()
  {
    if (this.this$0.mPluginManager == null) {
      return;
    }
    this.this$0.mPluginManager.installPlugin("group_video_plugin.apk", GVideoPluginInstallerActivity.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.groupvideo.GVideoPluginInstallerActivity.3
 * JD-Core Version:    0.7.0.1
 */