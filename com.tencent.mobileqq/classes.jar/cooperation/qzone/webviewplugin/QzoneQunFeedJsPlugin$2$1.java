package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import anvx;
import bhdj;
import bifw;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  QzoneQunFeedJsPlugin$2$1(QzoneQunFeedJsPlugin.2 param2) {}
  
  public void run()
  {
    QzoneQunFeedJsPlugin.access$102(this.this$1.this$0, this.this$1.val$args[0]);
    Activity localActivity = this.this$1.this$0.parentPlugin.mRuntime.a();
    if (QzoneQunFeedJsPlugin.access$200(this.this$1.this$0) == null) {
      QzoneQunFeedJsPlugin.access$202(this.this$1.this$0, bhdj.a(localActivity, 230).setTitle(anvx.a(2131711737)).setMessage(anvx.a(2131711741)).setPositiveButton(anvx.a(2131711738), new QzoneQunFeedJsPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131717404), new QzoneQunFeedJsPlugin.2.1.1(this)));
    }
    if (!QzoneQunFeedJsPlugin.access$200(this.this$1.this$0).isShowing()) {
      QzoneQunFeedJsPlugin.access$200(this.this$1.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */