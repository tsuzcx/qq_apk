package cooperation.qzone;

import android.os.Bundle;

public class QzoneTransNoTitlePluginProxyActivity
  extends QzonePluginProxyActivity
{
  public boolean compatibleAndroidOreo()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneTransNoTitlePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */