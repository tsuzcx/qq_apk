package cooperation.qzone;

import android.os.ResultReceiver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("QzoneVideoSoDownloadModule", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = this.this$0;
      localResultReceiver = this.mReceiver;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131712432));
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QzoneVideoSoDownloadModule.access$000((QzoneVideoSoDownloadModule)localObject, localResultReceiver, -2, localStringBuilder.toString());
      ShortVideoErrorReport.b(1, paramInt2);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = this.this$0;
      localResultReceiver = this.mReceiver;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131712457));
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QzoneVideoSoDownloadModule.access$000((QzoneVideoSoDownloadModule)localObject, localResultReceiver, -2, localStringBuilder.toString());
      ShortVideoErrorReport.b(1, paramInt2);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.app, (List)localObject);
    if (paramInt1 == 0)
    {
      ShortVideoResourceManager.a(this.app, (List)localObject, new QzoneVideoSoDownloadModule.MyShortVideoResource(this.this$0, this.mReceiver));
      return;
    }
    localObject = this.this$0;
    ResultReceiver localResultReceiver = this.mReceiver;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131712541));
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("]");
    QzoneVideoSoDownloadModule.access$000((QzoneVideoSoDownloadModule)localObject, localResultReceiver, -2, localStringBuilder.toString());
    ShortVideoErrorReport.b(1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.MyISVConfig
 * JD-Core Version:    0.7.0.1
 */