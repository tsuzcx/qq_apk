package cooperation.qqreader.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import bgvo;
import bgwb;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;

public class ReaderContentPageActivity
  extends ReaderBaseWebActivity
{
  private boolean a;
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.a) {
      return ReaderSplashPageFragment.a(getIntent());
    }
    return super.a(paramWebViewTabBarData);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.a) {}
    Object localObject;
    Window localWindow;
    do
    {
      do
      {
        return;
        localObject = (ReaderBaseFragment)b();
      } while ((localObject == null) || (!((ReaderBaseFragment)localObject).b));
      localObject = (bgwb)((ReaderBaseFragment)localObject).a;
      localWindow = getWindow();
    } while ((localObject == null) || (localWindow == null));
    ((bgwb)localObject).a(false, localWindow);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.a = getIntent().getBooleanExtra("is_to_splash_activity", false);
    if (this.a) {
      g();
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    bgvo.c("ReaderContentPageActivity", "mIsSplash = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageActivity
 * JD-Core Version:    0.7.0.1
 */