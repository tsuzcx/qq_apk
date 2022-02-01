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
    if ((this.a.getSwiftTitleUI().d != null) && (this.a.getSwiftTitleUI().h != null) && (this.a.getSwiftTitleUI().o != null) && (!paramBoolean) && (paramInt1 == 4)) {
      if ((!this.a.getUIStyleHandler().f.b) && (!this.a.getUIStyle().v))
      {
        this.a.getSwiftTitleUI().h.setImageResource(2130851512);
        this.a.getSwiftTitleUI().c(-16777216);
      }
      else
      {
        paramString1 = ImageUtil.a(this.a.getResources().getDrawable(2130851512), -1);
        this.a.getSwiftTitleUI().h.setImageDrawable(paramString1);
        this.a.getSwiftTitleUI().c(-1);
      }
    }
    ((SwiftBrowserShareMenuHandler)this.a.mComponentsProvider.a(4)).i();
    this.a.getUIStyleHandler().k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */