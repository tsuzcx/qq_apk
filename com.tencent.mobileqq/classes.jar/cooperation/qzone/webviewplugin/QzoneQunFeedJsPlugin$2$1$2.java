package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QzonePluginProxyActivity;

class QzoneQunFeedJsPlugin$2$1$2
  implements DialogInterface.OnClickListener
{
  QzoneQunFeedJsPlugin$2$1$2(QzoneQunFeedJsPlugin.2.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.this$2.this$1.this$0.parentPlugin.mRuntime.a().getAccount();
    Intent localIntent = new Intent();
    String str = this.this$2.this$1.this$0.parentPlugin.mRuntime.a().getResources().getString(2131717528);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", "jhan_plxz");
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(this.this$2.this$1.this$0.parentPlugin.mRuntime.a(), paramDialogInterface, localIntent, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1.2
 * JD-Core Version:    0.7.0.1
 */