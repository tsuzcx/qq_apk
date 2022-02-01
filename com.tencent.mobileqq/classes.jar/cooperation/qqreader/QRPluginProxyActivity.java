package cooperation.qqreader;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QRPluginProxyActivity
  extends PluginProxyActivity
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if ("com.qqreader.pureader.SSReaderActivity".equals(paramString)) {
      return QRReaderPageProxyActivity.class;
    }
    return QRPluginProxyActivity.class;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qqreaderplugin.apk";
  }
  
  public final Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.remove("android:fragments");
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    paramBundle = getIntent();
    if (paramBundle != null) {
      paramBundle.putExtra("big_brother_source_key", "biz_src_jc_neirong");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.QRPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */