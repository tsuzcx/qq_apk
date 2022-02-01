package cooperation.qzone;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.concurrent.atomic.AtomicBoolean;

class QZoneVideoDownloadActivity$1
  extends Handler
{
  QZoneVideoDownloadActivity$1(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1000: 
            if (QLog.isDevelopLevel()) {
              QLog.d("QZoneVideoDownloadActivity", 4, "mIsUIInited=" + QZoneVideoDownloadActivity.access$000(this.this$0));
            }
            break;
          }
        } while (QZoneVideoDownloadActivity.access$000(this.this$0).get());
        this.this$0.setContentView(2131563263);
        this.this$0.initUI();
        QZoneVideoDownloadActivity.access$000(this.this$0).set(true);
        return;
      } while ((this.this$0.mDownloadingText == null) || (this.this$0.mDownloadingBar == null));
      i = paramMessage.arg1;
      this.this$0.mDownloadingText.setText(HardCodeUtil.a(2131712462) + i + HardCodeUtil.a(2131712456));
      this.this$0.mDownloadingBar.setProgress(i);
      return;
    } while ((this.this$0.mDownloadingText == null) || (this.this$0.mDownloadingBar == null));
    int i = paramMessage.arg1;
    this.this$0.mDownloadingText.setText(HardCodeUtil.a(2131712498) + i + HardCodeUtil.a(2131712453));
    this.this$0.mDownloadingBar.setProgress(i);
    return;
    String str2 = HardCodeUtil.a(2131712505);
    String str1 = str2;
    if (paramMessage != null)
    {
      str1 = str2;
      if (paramMessage.obj != null)
      {
        str1 = str2;
        if ((paramMessage.obj instanceof String)) {
          str1 = (String)paramMessage.obj;
        }
      }
    }
    Toast.makeText(this.this$0.getApplicationContext(), str1, 1).show();
    QzoneVideoBeaconReport.reportVideoEvent(this.this$0.uin, "qzone_video_recordtrim", "1005", null);
    this.this$0.finish();
    return;
    Toast.makeText(this.this$0.getApplicationContext(), HardCodeUtil.a(2131712573), 1).show();
    QzoneVideoBeaconReport.reportVideoEvent(this.this$0.uin, "qzone_video_recordtrim", "1006", null);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */