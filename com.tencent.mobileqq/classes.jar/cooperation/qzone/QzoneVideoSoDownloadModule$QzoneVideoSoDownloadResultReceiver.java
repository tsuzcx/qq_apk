package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import bluv;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private bluv a;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(bluv parambluv)
  {
    super(null);
    this.a = parambluv;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.callback(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */