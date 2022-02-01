package cooperation.qqreader.js;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReaderJsPlugin$2
  implements View.OnClickListener
{
  ReaderJsPlugin$2(ReaderJsPlugin paramReaderJsPlugin) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().loadUrl("javascript:" + ReaderJsPlugin.a(this.a) + "()");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.js.ReaderJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */