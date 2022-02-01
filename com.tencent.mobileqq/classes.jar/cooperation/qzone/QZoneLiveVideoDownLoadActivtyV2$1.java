package cooperation.qzone;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;

class QZoneLiveVideoDownLoadActivtyV2$1
  implements Runnable
{
  QZoneLiveVideoDownLoadActivtyV2$1(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2, PluginBaseInfo paramPluginBaseInfo) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.manger != null) {
        this.this$0.manger.installPlugin(this.val$pluginInfo.mID, null, this.this$0.mMode);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.1
 * JD-Core Version:    0.7.0.1
 */