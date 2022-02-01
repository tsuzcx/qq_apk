package com.tencent.mobileqq.webview.swift.component;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class SwiftBrowserUIStyleHandler$1
  implements TouchWebView.OnOverScrollHandler
{
  SwiftBrowserUIStyleHandler$1(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a = false;
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onBack();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a = true;
      Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = Uri.parse((String)localObject);
          if ((localObject != null) && (((Uri)localObject).isHierarchical()))
          {
            localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.getResources().getString(2131714492), new Object[] { ((Uri)localObject).getHost() });
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.setText((CharSequence)localObject);
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.setVisibility(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.setVisibility(8);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.1
 * JD-Core Version:    0.7.0.1
 */