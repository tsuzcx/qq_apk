package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;

class MiniAppTextArea$1
  implements View.OnFocusChangeListener
{
  MiniAppTextArea$1(MiniAppTextArea paramMiniAppTextArea, WebviewContainer paramWebviewContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!MiniAppTextArea.access$000(this.this$0)) && (paramBoolean))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.val$wc.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(paramView, 0);
      }
      if (MiniAppTextArea.access$100(this.this$0))
      {
        int i = MiniAppTextArea.access$200(this.this$0);
        int j = MiniAppTextArea.access$300(this.this$0);
        int k = MiniAppTextArea.access$400(this.this$0);
        MiniAppTextArea.access$500(this.this$0).appBrandRuntime.getCurPage().showKeyBoardConfirmView(i - j - k);
      }
    }
    else
    {
      return;
    }
    MiniAppTextArea.access$500(this.this$0).appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea.1
 * JD-Core Version:    0.7.0.1
 */