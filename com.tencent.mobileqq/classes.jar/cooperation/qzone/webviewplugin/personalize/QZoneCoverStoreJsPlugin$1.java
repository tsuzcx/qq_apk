package cooperation.qzone.webviewplugin.personalize;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper.QZoneCoverConstants;

class QZoneCoverStoreJsPlugin$1
  implements View.OnClickListener
{
  QZoneCoverStoreJsPlugin$1(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mRuntime.b() != null) && (this.this$0.mRuntime.a() != null))
    {
      paramView = QZoneHelper.QZoneCoverConstants.getCoverStoreUrl("qzone", String.valueOf(1), this.this$0.mRuntime.b().getAccount(), this.this$0.mRuntime.b().getAccount());
      this.this$0.mRuntime.a().loadUrl(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */