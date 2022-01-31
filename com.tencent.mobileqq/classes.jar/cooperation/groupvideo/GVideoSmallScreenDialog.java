package cooperation.groupvideo;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class GVideoSmallScreenDialog
  extends PluginProxyActivity
{
  public String getPluginID()
  {
    return "group_video_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return GVideoSmallScreenDialog.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GVideoSmallScreenDialog
 * JD-Core Version:    0.7.0.1
 */