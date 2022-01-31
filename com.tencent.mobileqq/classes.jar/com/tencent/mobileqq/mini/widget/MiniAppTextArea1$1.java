package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppTextArea1$1
  implements View.OnFocusChangeListener
{
  MiniAppTextArea1$1(MiniAppTextArea1 paramMiniAppTextArea1, WebviewContainer paramWebviewContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    int i;
    int j;
    if ((!MiniAppTextArea1.access$000(this.this$0)) && (paramBoolean))
    {
      MiniAppTextArea1.access$102(this.this$0, true);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.val$wc.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(paramView, 0);
      }
      if (!MiniAppTextArea1.access$200(this.this$0)) {
        break label434;
      }
      i = MiniAppTextArea1.access$300(this.this$0);
      j = MiniAppTextArea1.access$400(this.this$0);
      int k = MiniAppTextArea1.access$500(this.this$0);
      MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().showKeyBoardConfirmView(i - j - k);
    }
    for (;;)
    {
      if ((!MiniAppTextArea1.access$700(this.this$0)) && (MiniAppTextArea1.access$800(this.this$0)) && (paramBoolean) && (MiniAppTextArea1.access$600(this.this$0) != null)) {
        MiniAppTextArea1.access$702(this.this$0, true);
      }
      try
      {
        paramView = new JSONObject();
        paramView.put("inputId", MiniAppTextArea1.access$900(this.this$0));
        j = MiniAppTextArea1.access$400(this.this$0);
        if (MiniAppTextArea1.access$200(this.this$0))
        {
          i = MiniAppTextArea1.access$500(this.this$0);
          paramView.put("height", (int)((i + j) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
          QLog.d("MiniAppTextArea1", 1, "onKeyboardShow : " + paramView.toString());
          MiniAppTextArea1.access$600(this.this$0).getPageWebview().evaluateSubcribeJS("onKeyboardShow", paramView.toString(), MiniAppTextArea1.access$600(this.this$0).getPageWebview().pageWebviewId);
          if ((paramBoolean) || (MiniAppTextArea1.access$600(this.this$0) == null)) {}
        }
      }
      catch (Throwable paramView)
      {
        try
        {
          for (;;)
          {
            paramView = new JSONObject();
            paramView.put("inputId", MiniAppTextArea1.access$900(this.this$0));
            paramView.put("value", this.this$0.getText().toString());
            paramView.put("cursor", this.this$0.getText().toString().length());
            QLog.d("MiniAppTextArea1", 1, "onKeyboardComplete : " + paramView.toString());
            MiniAppTextArea1.access$600(this.this$0).getPageWebview().evaluateSubcribeJS("onKeyboardComplete", paramView.toString(), MiniAppTextArea1.access$600(this.this$0).getPageWebview().pageWebviewId);
            MiniAppTextArea1.access$702(this.this$0, false);
            return;
            label434:
            MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
            break;
            i = 0;
          }
          paramView = paramView;
          QLog.e("MiniAppTextArea1", 2, "onFocusChange error", paramView);
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            QLog.e("MiniAppTextArea1", 2, "onFocusChange error", paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1.1
 * JD-Core Version:    0.7.0.1
 */