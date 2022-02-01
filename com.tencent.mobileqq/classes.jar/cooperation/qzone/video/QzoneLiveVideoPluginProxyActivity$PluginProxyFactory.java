package cooperation.qzone.video;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

class QzoneLiveVideoPluginProxyActivity$PluginProxyFactory
{
  public static Class<? extends PluginProxyActivity> getPluginProxyActivityClass(String paramString)
  {
    if (QzoneLiveVideoPluginProxyActivity.access$100(QzoneLiveVideoPluginProxyActivity.access$000(), paramString)) {
      return QzoneLiveVideoTransparentActivity.class;
    }
    return QzoneLiveVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity.PluginProxyFactory
 * JD-Core Version:    0.7.0.1
 */