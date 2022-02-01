package cooperation.qzone;

import android.os.Handler;
import android.os.Message;

class QZoneLiveVideoDownLoadActivtyV2$2$1
  implements Runnable
{
  QZoneLiveVideoDownLoadActivtyV2$2$1(QZoneLiveVideoDownLoadActivtyV2.2 param2, float paramFloat) {}
  
  public void run()
  {
    if ((int)(this.val$progress * 100.0F) > 0)
    {
      this.this$1.this$0.mHandler.removeMessages(1009);
      this.this$1.this$0.mHandler.obtainMessage(1004, 100, 0).sendToTarget();
      this.this$1.this$0.updateTextProgress(false, true);
    }
    while (!this.this$1.this$0.mIsDownloadSoTimeout) {
      return;
    }
    this.this$1.this$0.mHandler.removeMessages(1009);
    this.this$1.this$0.updateTextProgress(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2.1
 * JD-Core Version:    0.7.0.1
 */