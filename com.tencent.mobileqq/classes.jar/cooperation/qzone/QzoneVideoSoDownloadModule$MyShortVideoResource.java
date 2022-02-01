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
    QLog.i("QzoneVideoSoDownloadModule", 1, "onDownloadFinish name=" + paramString1 + " result=" + paramInt + " filePath=" + paramString2);
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label102;
      }
      QzoneVideoSoDownloadModule.access$000(this.this$0, this.mReceiver, -3, HardCodeUtil.a(2131712454) + paramInt + "]");
      ShortVideoErrorReport.b(2, paramInt);
    }
    label102:
    while (this.mReceiver == null) {
      return;
    }
    paramString1 = new Bundle();
    this.mReceiver.send(0, paramString1);
  }
  
  public void onNetWorkNone()
  {
    QLog.e("QzoneVideoSoDownloadModule", 1, "onNetWorkNone");
    QzoneVideoSoDownloadModule.access$000(this.this$0, this.mReceiver, -3, HardCodeUtil.a(2131712445));
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneVideoSoDownloadModule", 4, "onUpdateProgress: name=" + paramString + " curOffset=" + paramLong1 + " totalLen=" + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.MyShortVideoResource
 * JD-Core Version:    0.7.0.1
 */