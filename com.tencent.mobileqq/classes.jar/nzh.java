import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.1.1;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nzh
  implements View.OnClickListener
{
  public nzh(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
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
      if (!this.a.mUIStyleHandler.a.a)
      {
        str = this.a.mSwiftTitleUI.c.getText().toString();
        this.a.webView.loadUrl("javascript:onRightBtn(\"" + str + "\")");
      }
      else if (PublicAccountBrowser.PublicAccountBrowserFragment.a(this.a) == 1001)
      {
        ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.1.1(this));
        this.a.getActivity().finish();
      }
      else
      {
        onClick(paramView);
        continue;
        if (!this.a.mUIStyleHandler.a.a)
        {
          str = this.a.mSwiftTitleUI.a.getText().toString();
          if (str.equals(PublicAccountBrowser.PublicAccountBrowserFragment.a(this.a).getStringExtra("leftViewText"))) {
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
 * Qualified Name:     nzh
 * JD-Core Version:    0.7.0.1
 */