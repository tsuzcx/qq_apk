package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;

class MiniAppTextArea1$1
  implements View.OnFocusChangeListener
{
  MiniAppTextArea1$1(MiniAppTextArea1 paramMiniAppTextArea1, WebviewContainer paramWebviewContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!MiniAppTextArea1.access$000(this.this$0)) && (paramBoolean))
    {
      MiniAppTextArea1.access$102(true);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.val$wc.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(paramView, 0);
      }
      if (MiniAppTextArea1.access$200(this.this$0))
      {
        int i = MiniAppTextArea1.access$300(this.this$0);
        int j = MiniAppTextArea1.access$400(this.this$0);
        int k = MiniAppTextArea1.access$500(this.this$0);
        MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().showKeyBoardConfirmView(i - j - k);
      }
    }
    else
    {
      return;
    }
    MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1.1
 * JD-Core Version:    0.7.0.1
 */