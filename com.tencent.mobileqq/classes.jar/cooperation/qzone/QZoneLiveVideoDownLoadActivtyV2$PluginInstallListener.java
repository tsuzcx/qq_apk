package cooperation.qzone;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;

class QZoneLiveVideoDownLoadActivtyV2$PluginInstallListener
  extends OnQZonePluginInstallListner.Stub
{
  QZoneLiveVideoDownLoadActivtyV2$PluginInstallListener(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, float paramFloat, long paramLong) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "[onInstallError] pluginId=" + paramString + ", errorCode=" + paramInt);
    paramString = this.this$0.mHandler.obtainMessage();
    paramString.what = 1010;
    if (8 == paramInt) {}
    for (paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadErrorNoSpace", "内部存储空间不足，下载失败");; paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadError", "插件下载失败"))
    {
      this.this$0.mHandler.sendMessage(paramString);
      return;
    }
  }
  
  public void onInstallFinish(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.PluginInstallListener
 * JD-Core Version:    0.7.0.1
 */