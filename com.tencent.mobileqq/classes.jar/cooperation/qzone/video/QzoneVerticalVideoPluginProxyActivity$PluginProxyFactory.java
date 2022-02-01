package cooperation.qzone.video;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

class QzoneVerticalVideoPluginProxyActivity$PluginProxyFactory
{
  public static Class<? extends PluginProxyActivity> getPluginProxyActivityClass(String paramString)
  {
    if (QzoneVerticalVideoPluginProxyActivity.access$100(QzoneVerticalVideoPluginProxyActivity.access$000(), paramString)) {
      return QzoneVerticalVideoTransparentActivity.class;
    }
    return QzoneVerticalVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity.PluginProxyFactory
 * JD-Core Version:    0.7.0.1
 */