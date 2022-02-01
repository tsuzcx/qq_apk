package cooperation.comic;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class VipComicProxyActivity
  extends PluginProxyActivity
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if (paramString.equals("com.qqcomic.activity.reader.VipComicLandReadingActivity")) {
      return VipComicLandReaderProxyActivity.class;
    }
    if (paramString.equals("com.qqcomic.activity.reader.VipComicPortraitReadingActivity")) {
      return VipComicPortraitReaderProxyActivity.class;
    }
    if (paramString.equals("com.qqcomic.activity.media.VipComicMediaPlayActivity")) {
      return VipComicPlayProxyActivity.class;
    }
    return VipComicProxyActivity.class;
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
    return "comic_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.VipComicProxyActivity
 * JD-Core Version:    0.7.0.1
 */