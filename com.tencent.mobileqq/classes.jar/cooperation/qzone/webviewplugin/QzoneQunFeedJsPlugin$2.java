package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import cooperation.qzone.remote.logic.WebEventListener;

class QzoneQunFeedJsPlugin$2
  implements WebEventListener
{
  QzoneQunFeedJsPlugin$2(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin, String[] paramArrayOfString) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      bool = paramString.getBoolean("isOpenVip");
      if ((this.val$args != null) && (this.val$args.length > 0))
      {
        if (!bool) {
          break label64;
        }
        QzoneQunFeedJsPlugin.access$300(this.this$0).post(new QzoneQunFeedJsPlugin.2.1(this));
      }
    }
    return;
    label64:
    paramString.getInt("totalNum");
    int i = paramString.getInt("successNum");
    int j = paramString.getInt("failNum");
    boolean bool = paramString.getBoolean("isDownloadCanceled");
    paramString = paramString.getString("path");
    QzoneQunFeedJsPlugin.access$400(this.this$0, i, j, paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */