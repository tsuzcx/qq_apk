package cooperation.liveroom;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;

class LiveRoomPluginInstaller$1
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  LiveRoomPluginInstaller$1(LiveRoomPluginInstaller paramLiveRoomPluginInstaller, String paramString) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (LiveRoomPluginInstaller.access$000(this.this$0)) {
      return;
    }
    LiveRoomPluginInstaller.access$002(this.this$0, true);
    QLog.i("LiveRoomPluginInstaller", 1, "start download LiveRoomPlugin in tool 2");
    LiveRoomHelper.startTime = NetConnInfoCenter.getServerTimeMillis();
    LiveRoomHelper.report(this.val$from, "install", "start", 0L);
    paramPluginManagerClient.installPlugin("LiveRoomPlugin.apk", new LiveRoomPluginInstaller.MyOnPluginInstallListener(this.this$0, this.val$from));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginInstaller.1
 * JD-Core Version:    0.7.0.1
 */