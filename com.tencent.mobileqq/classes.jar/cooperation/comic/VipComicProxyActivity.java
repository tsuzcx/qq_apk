package cooperation.comic;

import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

public class VipComicProxyActivity
  extends PluginProxyActivity
{
  public static Class a(String paramString)
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
  
  public String getPluginID()
  {
    return "comic_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.VipComicProxyActivity
 * JD-Core Version:    0.7.0.1
 */