package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;

class QzoneWanbaJsPlugin$1
  extends BroadcastReceiver
{
  QzoneWanbaJsPlugin$1(QzoneWanbaJsPlugin paramQzoneWanbaJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getStringExtra("callback");
      int i = paramIntent.getIntExtra("ret", 1);
      QZLog.i("QzoneWanbaJsPlugin", "收到广播消息 callback=" + paramContext + ",ret=" + i);
      this.this$0.parentPlugin.callJs(paramContext, new String[] { "{'ret':" + i + "}" });
      return;
    }
    catch (Exception paramContext)
    {
      QZLog.e("QzoneWanbaJsPlugin", "callback error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWanbaJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */