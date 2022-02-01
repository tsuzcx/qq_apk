package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import bmvx;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private bmvx a;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(bmvx parambmvx)
  {
    super(null);
    this.a = parambmvx;
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