package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QzoneQunFeedJsPlugin$1
  extends BroadcastReceiver
{
  QzoneQunFeedJsPlugin$1(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      QzoneQunFeedJsPlugin.access$000(this.this$0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */