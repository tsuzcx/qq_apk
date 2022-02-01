package cooperation.qqreader.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.view.ReaderTitleBarView;

public class ReaderContentPageActivity
  extends ReaderBaseWebActivity
{
  private boolean a = false;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
        localObject = (ReaderBaseFragment)getCurrentWebViewFragment();
      } while ((localObject == null) || (!((ReaderBaseFragment)localObject).b));
      localObject = (ReaderTitleBarView)((ReaderBaseFragment)localObject).mSwiftTitleUI;
      localWindow = getWindow();
    } while ((localObject == null) || (localWindow == null));
    ((ReaderTitleBarView)localObject).a(false, localWindow);
  }
  
  public WebViewFragment getFragmentByTabBarData(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.a) {
      return ReaderSplashPageFragment.a(getIntent());
    }
    return super.getFragmentByTabBarData(paramWebViewTabBarData);
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
      disableSwipeLayout();
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    Log.c("ReaderContentPageActivity", "mIsSplash = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageActivity
 * JD-Core Version:    0.7.0.1
 */