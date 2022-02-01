package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private QzoneVideoSoDownloadModule.DownloadResultCallback mCallback;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(QzoneVideoSoDownloadModule.DownloadResultCallback paramDownloadResultCallback)
  {
    super(null);
    this.mCallback = paramDownloadResultCallback;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.mCallback != null) {
      this.mCallback.callback(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */