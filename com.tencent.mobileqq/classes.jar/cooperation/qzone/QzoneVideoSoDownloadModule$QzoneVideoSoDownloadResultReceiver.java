package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qzonehub.api.DownloadResultCallback;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private DownloadResultCallback mCallback;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(DownloadResultCallback paramDownloadResultCallback)
  {
    super(null);
    this.mCallback = paramDownloadResultCallback;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    DownloadResultCallback localDownloadResultCallback = this.mCallback;
    if (localDownloadResultCallback != null) {
      localDownloadResultCallback.callback(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */