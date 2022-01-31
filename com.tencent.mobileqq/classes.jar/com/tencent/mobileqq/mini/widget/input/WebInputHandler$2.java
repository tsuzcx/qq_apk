package com.tencent.mobileqq.mini.widget.input;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;

class WebInputHandler$2
  implements View.OnFocusChangeListener
{
  WebInputHandler$2(WebInputHandler paramWebInputHandler) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (WebInputHandler.access$000(this.this$0) != null)) {
      WebInputHandler.access$000(this.this$0).hideKeyBoardConfirmView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler.2
 * JD-Core Version:    0.7.0.1
 */