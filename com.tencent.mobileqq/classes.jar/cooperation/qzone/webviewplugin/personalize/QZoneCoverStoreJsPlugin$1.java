package cooperation.qzone.webviewplugin.personalize;

import android.view.View;
import android.view.View.OnClickListener;
import bifw;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper.QZoneCoverConstants;

class QZoneCoverStoreJsPlugin$1
  implements View.OnClickListener
{
  QZoneCoverStoreJsPlugin$1(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mRuntime.a() != null) && (this.this$0.mRuntime.a() != null))
    {
      String str = QZoneHelper.QZoneCoverConstants.getCoverStoreUrl("qzone", String.valueOf(1), this.this$0.mRuntime.a().getAccount(), this.this$0.mRuntime.a().getAccount());
      this.this$0.mRuntime.a().loadUrl(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */