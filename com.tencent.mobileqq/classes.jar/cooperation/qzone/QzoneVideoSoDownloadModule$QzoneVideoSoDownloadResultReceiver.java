package cooperation.qzone;

import android.os.Bundle;
import android.os.ResultReceiver;
import bhak;

public class QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver
  extends ResultReceiver
{
  private bhak a;
  
  public QzoneVideoSoDownloadModule$QzoneVideoSoDownloadResultReceiver(bhak parambhak)
  {
    super(null);
    this.a = parambhak;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.callback(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */