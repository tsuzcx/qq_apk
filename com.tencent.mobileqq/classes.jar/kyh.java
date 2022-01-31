import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class kyh
  implements View.OnClickListener
{
  public kyh(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      onClick(paramView);
      return;
    case 2131363410: 
      if (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.a)
      {
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.getText().toString();
        this.a.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:onRightBtn(\"" + paramView + "\")");
        return;
      }
      if (PublicAccountBrowser.PublicAccountBrowserFragment.a(this.a) == 1001)
      {
        ThreadManager.executeOnSubThread(new kyi(this));
        this.a.getActivity().finish();
        return;
      }
      onClick(paramView);
      return;
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.a)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.getText().toString();
      if (paramView.equals(PublicAccountBrowser.PublicAccountBrowserFragment.a(this.a).getStringExtra("leftViewText")))
      {
        this.a.n();
        return;
      }
      this.a.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:onLeftBtn(\"" + paramView + "\")");
      return;
    }
    onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kyh
 * JD-Core Version:    0.7.0.1
 */