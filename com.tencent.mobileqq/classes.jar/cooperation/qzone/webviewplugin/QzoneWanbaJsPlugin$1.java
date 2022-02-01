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
      paramIntent = new StringBuilder();
      paramIntent.append("收到广播消息 callback=");
      paramIntent.append(paramContext);
      paramIntent.append(",ret=");
      paramIntent.append(i);
      QZLog.i("QzoneWanbaJsPlugin", paramIntent.toString());
      paramIntent = this.this$0.parentPlugin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'ret':");
      localStringBuilder.append(i);
      localStringBuilder.append("}");
      paramIntent.callJs(paramContext, new String[] { localStringBuilder.toString() });
      return;
    }
    catch (Exception paramContext)
    {
      QZLog.e("QzoneWanbaJsPlugin", "callback error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWanbaJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */