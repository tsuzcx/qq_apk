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
    if (paramMessage == null) {
      return;
    }
    int i;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1004: 
      if (this.this$0.mDownloadingText != null)
      {
        if (this.this$0.mDownloadingBar == null) {
          return;
        }
        i = paramMessage.arg1;
        paramMessage = this.this$0.mDownloadingText;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131712437));
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131712431));
        paramMessage.setText(((StringBuilder)localObject).toString());
        this.this$0.mDownloadingBar.setProgress(i);
        return;
      }
      return;
    case 1003: 
      Toast.makeText(this.this$0.getApplicationContext(), HardCodeUtil.a(2131712548), 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(this.this$0.uin, "qzone_video_recordtrim", "1006", null);
      this.this$0.finish();
      return;
    case 1002: 
      String str = HardCodeUtil.a(2131712480);
      localObject = str;
      if (paramMessage != null)
      {
        localObject = str;
        if (paramMessage.obj != null)
        {
          localObject = str;
          if ((paramMessage.obj instanceof String)) {
            localObject = (String)paramMessage.obj;
          }
        }
      }
      Toast.makeText(this.this$0.getApplicationContext(), (CharSequence)localObject, 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(this.this$0.uin, "qzone_video_recordtrim", "1005", null);
      this.this$0.finish();
      return;
    case 1001: 
      if (this.this$0.mDownloadingText != null)
      {
        if (this.this$0.mDownloadingBar == null) {
          return;
        }
        i = paramMessage.arg1;
        paramMessage = this.this$0.mDownloadingText;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131712473));
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131712428));
        paramMessage.setText(((StringBuilder)localObject).toString());
        this.this$0.mDownloadingBar.setProgress(i);
        return;
      }
      return;
    }
    if (QLog.isDevelopLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("mIsUIInited=");
      paramMessage.append(QZoneVideoDownloadActivity.access$000(this.this$0));
      QLog.d("QZoneVideoDownloadActivity", 4, paramMessage.toString());
    }
    if (!QZoneVideoDownloadActivity.access$000(this.this$0).get())
    {
      this.this$0.setContentView(2131563087);
      this.this$0.initUI();
      QZoneVideoDownloadActivity.access$000(this.this$0).set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */