package com.tencent.mobileqq.webview.swift;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

class WebViewFragment$1
  implements View.OnLayoutChangeListener
{
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Rect b = new Rect();
  
  WebViewFragment$1(WebViewFragment paramWebViewFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.b);
    paramView.getWindowVisibleDisplayFrame(this.b);
    if (this.jdField_a_of_type_AndroidGraphicsRect.width() == this.b.width())
    {
      paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.height() - this.b.height();
      if (paramInt1 < -100)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webViewKernel.a(8589934614L, null);
        return;
      }
      if (paramInt1 > 100) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webViewKernel.a(8589934613L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */