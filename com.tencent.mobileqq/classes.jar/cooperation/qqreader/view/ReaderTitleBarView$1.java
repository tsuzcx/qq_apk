package cooperation.qqreader.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.utils.ReportUtils;

class ReaderTitleBarView$1
  implements View.OnClickListener
{
  ReaderTitleBarView$1(ReaderTitleBarView paramReaderTitleBarView) {}
  
  public void onClick(View paramView)
  {
    ReportUtils.a(ReaderTitleBarView.a(this.a), ReaderTitleBarView.b(this.a), "5", "27", "", "3", "", "", "");
    this.a.a.a.webView.loadUrl("jsbridge://JSTittlebarAction/managerBtnSingleClick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.ReaderTitleBarView.1
 * JD-Core Version:    0.7.0.1
 */