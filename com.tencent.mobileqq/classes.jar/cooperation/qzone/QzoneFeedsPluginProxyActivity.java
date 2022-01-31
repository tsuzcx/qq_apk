package cooperation.qzone;

import aabk;
import android.content.Intent;
import android.os.Bundle;

public class QzoneFeedsPluginProxyActivity
  extends QzonePluginProxyActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    if (getIntent().getIntExtra("hc_code", 0) != 0) {
      aabk.a().a(getIntent().getIntExtra("hc_code", 0), true);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneFeedsPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */