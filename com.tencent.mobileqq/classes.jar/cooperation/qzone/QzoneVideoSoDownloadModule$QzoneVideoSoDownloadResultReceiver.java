package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import bjgp;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private bjgp a;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(bjgp parambjgp)
  {
    super(null);
    this.a = parambjgp;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.callback(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */