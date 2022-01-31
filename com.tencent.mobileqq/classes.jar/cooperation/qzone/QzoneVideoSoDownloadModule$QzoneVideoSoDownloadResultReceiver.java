package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import bfsd;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private bfsd a;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(bfsd parambfsd)
  {
    super(null);
    this.a = parambfsd;
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