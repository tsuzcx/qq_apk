package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private QzoneVideoSoDownloadModule.DownloadResultCallback a;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(QzoneVideoSoDownloadModule.DownloadResultCallback paramDownloadResultCallback)
  {
    super(null);
    this.a = paramDownloadResultCallback;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */