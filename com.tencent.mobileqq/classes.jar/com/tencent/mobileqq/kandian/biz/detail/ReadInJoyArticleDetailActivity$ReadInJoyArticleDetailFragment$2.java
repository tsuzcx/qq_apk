package com.tencent.mobileqq.kandian.biz.detail;

import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebTitleBarProxy;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$2
  extends WebTitleBarProxy
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$2(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment, WebUiUtils.WebTitleBarInterface paramWebTitleBarInterface)
  {
    super(paramWebTitleBarInterface);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.a.getSwiftTitleUI().a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramAPICallback);
    if ((this.a.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView != null) && (this.a.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView != null) && (this.a.getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup != null) && (!paramBoolean) && (paramInt1 == 4)) {
      if ((!this.a.getUIStyleHandler().a.b) && (!this.a.getUIStyle().m))
      {
        this.a.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849807);
        this.a.getSwiftTitleUI().c(-16777216);
      }
      else
      {
        paramString1 = ImageUtil.a(this.a.getResources().getDrawable(2130849807), -1);
        this.a.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
        this.a.getSwiftTitleUI().c(-1);
      }
    }
    ((SwiftBrowserShareMenuHandler)this.a.mComponentsProvider.a(4)).c();
    this.a.getUIStyleHandler().k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */