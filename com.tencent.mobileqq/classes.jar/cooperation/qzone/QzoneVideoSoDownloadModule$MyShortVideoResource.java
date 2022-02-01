package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.qphone.base.util.QLog;

class QzoneVideoSoDownloadModule$MyShortVideoResource
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  ResultReceiver mReceiver;
  
  public QzoneVideoSoDownloadModule$MyShortVideoResource(QzoneVideoSoDownloadModule paramQzoneVideoSoDownloadModule, ResultReceiver paramResultReceiver)
  {
    this.mReceiver = paramResultReceiver;
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" filePath=");
    localStringBuilder.append(paramString2);
    QLog.i("QzoneVideoSoDownloadModule", 1, localStringBuilder.toString());
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        paramString1 = this.this$0;
        paramString2 = this.mReceiver;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131910022));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QzoneVideoSoDownloadModule.access$000(paramString1, paramString2, -3, localStringBuilder.toString());
        ShortVideoErrorReport.b(2, paramInt);
        return;
      }
      if (this.mReceiver != null)
      {
        paramString1 = new Bundle();
        this.mReceiver.send(0, paramString1);
      }
    }
  }
  
  public void onNetWorkNone()
  {
    QLog.e("QzoneVideoSoDownloadModule", 1, "onNetWorkNone");
    QzoneVideoSoDownloadModule.access$000(this.this$0, this.mReceiver, -3, HardCodeUtil.a(2131910014));
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateProgress: name=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" curOffset=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" totalLen=");
      localStringBuilder.append(paramLong2);
      QLog.d("QzoneVideoSoDownloadModule", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.MyShortVideoResource
 * JD-Core Version:    0.7.0.1
 */