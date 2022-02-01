package cooperation.qzone;

import android.os.Handler;
import android.os.Message;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener.Stub;

class QZoneLiveVideoDownLoadActivtyV2$2
  extends OnQZoneLiveSoDownloadListener.Stub
{
  QZoneLiveVideoDownLoadActivtyV2$2(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2) {}
  
  public void onDownloadBegin()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 1;
    this.this$0.mHandler.sendMessage(localMessage);
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadSoTimeout", 60000);
    this.this$0.mHandler.sendEmptyMessageDelayed(1009, i);
  }
  
  public void onDownloadCancel() {}
  
  public void onDownloadFail(int paramInt)
  {
    this.this$0.mHandler.obtainMessage(1008).sendToTarget();
  }
  
  public void onDownloadProgress(float paramFloat)
  {
    this.this$0.runOnUiThread(new QZoneLiveVideoDownLoadActivtyV2.2.1(this, paramFloat));
  }
  
  public void onDownloadSuccess()
  {
    this.this$0.runOnUiThread(new QZoneLiveVideoDownLoadActivtyV2.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2
 * JD-Core Version:    0.7.0.1
 */