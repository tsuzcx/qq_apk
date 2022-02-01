package com.tencent.qqmini.miniapp.core.page.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

class MiniAppTextArea$MyOnFocusChangeListener
  implements View.OnFocusChangeListener
{
  private MiniAppTextArea$MyOnFocusChangeListener(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    PageWebviewContainer localPageWebviewContainer;
    if (MiniAppTextArea.access$100(this.this$0) != null) {
      localPageWebviewContainer = MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer();
    } else {
      localPageWebviewContainer = null;
    }
    Object localObject;
    int i;
    int j;
    if (!MiniAppTextArea.access$1700(this.this$0)) {
      if (paramBoolean)
      {
        MiniAppTextArea.access$802(this.this$0, true);
        localObject = (InputMethodManager)MiniAppTextArea.access$100(this.this$0).getContext().getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).showSoftInput(paramView, 0);
        }
        if (MiniAppTextArea.access$1200(this.this$0))
        {
          i = MiniAppTextArea.access$1400(this.this$0);
          j = MiniAppTextArea.access$300(this.this$0);
          int k = MiniAppTextArea.access$1300(this.this$0);
          paramView = new StringBuilder();
          paramView.append("screenHeight : ");
          paramView.append(MiniAppTextArea.access$1400(this.this$0));
          QMLog.d("MiniAppTextArea", paramView.toString());
          paramView = new StringBuilder();
          paramView.append("showKeyboardHeight : ");
          paramView.append(MiniAppTextArea.access$300(this.this$0));
          QMLog.d("MiniAppTextArea", paramView.toString());
          paramView = new StringBuilder();
          paramView.append("confirmHeight : ");
          paramView.append(MiniAppTextArea.access$1300(this.this$0));
          QMLog.d("MiniAppTextArea", paramView.toString());
          MiniAppTextArea.access$1500(this.this$0, i - j - k);
        }
        else
        {
          MiniAppTextArea.access$1800(this.this$0);
        }
      }
      else
      {
        MiniAppTextArea.access$1800(this.this$0);
      }
    }
    if ((!MiniAppTextArea.access$1900(this.this$0)) && (MiniAppTextArea.access$000(this.this$0)) && (paramBoolean) && (MiniAppTextArea.access$100(this.this$0) != null)) {
      MiniAppTextArea.access$1902(this.this$0, true);
    }
    for (;;)
    {
      try
      {
        paramView = new JSONObject();
        paramView.put("inputId", MiniAppTextArea.access$900(this.this$0));
        j = MiniAppTextArea.access$300(this.this$0);
        if (!MiniAppTextArea.access$1200(this.this$0)) {
          break label587;
        }
        i = MiniAppTextArea.access$1300(this.this$0);
        paramView.put("height", (int)((j + i) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onKeyboardShow : ");
        ((StringBuilder)localObject).append(paramView.toString());
        QMLog.d("MiniAppTextArea", ((StringBuilder)localObject).toString());
        localPageWebviewContainer.evaluateSubscribeJS("onKeyboardShow", paramView.toString());
      }
      catch (Throwable paramView)
      {
        QMLog.e("MiniAppTextArea", "onFocusChange error", paramView);
      }
      if ((!paramBoolean) && (MiniAppTextArea.access$100(this.this$0) != null))
      {
        try
        {
          paramView = new JSONObject();
          paramView.put("inputId", MiniAppTextArea.access$900(this.this$0));
          paramView.put("value", this.this$0.getText().toString());
          paramView.put("cursor", this.this$0.getText().toString().length());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onKeyboardComplete : ");
          ((StringBuilder)localObject).append(paramView.toString());
          QMLog.d("MiniAppTextArea", ((StringBuilder)localObject).toString());
          localPageWebviewContainer.evaluateSubscribeJS("onKeyboardComplete", paramView.toString());
        }
        catch (Exception paramView)
        {
          QMLog.e("MiniAppTextArea", "onFocusChange error", paramView);
        }
        MiniAppTextArea.access$1902(this.this$0, false);
      }
      return;
      label587:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.MyOnFocusChangeListener
 * JD-Core Version:    0.7.0.1
 */