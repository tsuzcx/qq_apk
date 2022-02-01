import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.1.1;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oce
  implements View.OnClickListener
{
  oce(ocd paramocd) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str;
      if (!this.a.mUIStyleHandler.mUIStyle.isFullScreen)
      {
        str = this.a.mSwiftTitleUI.rightViewText.getText().toString();
        this.a.webView.loadUrl("javascript:onRightBtn(\"" + str + "\")");
      }
      else if (ocd.a(this.a) == 1001)
      {
        ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.1.1(this));
        this.a.getActivity().finish();
      }
      else
      {
        onClick(paramView);
        continue;
        if (!this.a.mUIStyleHandler.mUIStyle.isFullScreen)
        {
          str = this.a.mSwiftTitleUI.leftView.getText().toString();
          if (str.equals(ocd.a(this.a).getStringExtra("leftViewText"))) {
            this.a.doOnBackEvent();
          } else {
            this.a.webView.loadUrl("javascript:onLeftBtn(\"" + str + "\")");
          }
        }
        else
        {
          onClick(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oce
 * JD-Core Version:    0.7.0.1
 */