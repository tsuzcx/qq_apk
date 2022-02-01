package cooperation.qqreader.ui;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import bmqw;
import bmrh;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
        localObject = (ReaderBaseFragment)a();
      } while ((localObject == null) || (!((ReaderBaseFragment)localObject).b));
      localObject = (bmrh)((ReaderBaseFragment)localObject).mSwiftTitleUI;
      localWindow = getWindow();
    } while ((localObject == null) || (localWindow == null));
    ((bmrh)localObject).a(false, localWindow);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
    bmqw.c("ReaderContentPageActivity", "mIsSplash = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageActivity
 * JD-Core Version:    0.7.0.1
 */