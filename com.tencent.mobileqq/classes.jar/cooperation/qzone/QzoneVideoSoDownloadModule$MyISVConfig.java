package cooperation.qzone;

import android.os.ResultReceiver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

class QzoneVideoSoDownloadModule$MyISVConfig
  implements ShortVideoResourceStatus.ISVConfig
{
  private QQAppInterface app;
  private ResultReceiver mReceiver;
  
  public QzoneVideoSoDownloadModule$MyISVConfig(QzoneVideoSoDownloadModule paramQzoneVideoSoDownloadModule, QQAppInterface paramQQAppInterface, ResultReceiver paramResultReceiver)
  {
    this.app = paramQQAppInterface;
    this.mReceiver = paramResultReceiver;
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("QzoneVideoSoDownloadModule", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        QzoneVideoSoDownloadModule.access$000(this.this$0, this.mReceiver, -2, HardCodeUtil.a(2131712482) + paramInt2 + "]");
        ShortVideoErrorReport.b(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        ShortVideoResourceManager.a(this.app, localArrayList, new QzoneVideoSoDownloadModule.MyShortVideoResource(this.this$0, this.mReceiver));
        return;
      }
      QzoneVideoSoDownloadModule.access$000(this.this$0, this.mReceiver, -2, HardCodeUtil.a(2131712566) + paramInt1 + "]");
      ShortVideoErrorReport.b(1, paramInt1);
      return;
    }
    QzoneVideoSoDownloadModule.access$000(this.this$0, this.mReceiver, -2, HardCodeUtil.a(2131712457) + paramInt2 + "]");
    ShortVideoErrorReport.b(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.MyISVConfig
 * JD-Core Version:    0.7.0.1
 */