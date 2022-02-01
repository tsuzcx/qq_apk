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
    }
    for (;;)
    {
      int i;
      int j;
      if (!MiniAppTextArea.access$1500(this.this$0))
      {
        if (!paramBoolean) {
          break label512;
        }
        MiniAppTextArea.access$802(this.this$0, true);
        InputMethodManager localInputMethodManager = (InputMethodManager)MiniAppTextArea.access$100(this.this$0).getContext().getSystemService("input_method");
        if (localInputMethodManager != null) {
          localInputMethodManager.showSoftInput(paramView, 0);
        }
        if (MiniAppTextArea.access$1000(this.this$0))
        {
          i = MiniAppTextArea.access$1200(this.this$0);
          j = MiniAppTextArea.access$300(this.this$0);
          int k = MiniAppTextArea.access$1100(this.this$0);
          QMLog.d("MiniAppTextArea", "screenHeight : " + MiniAppTextArea.access$1200(this.this$0));
          QMLog.d("MiniAppTextArea", "showKeyboardHeight : " + MiniAppTextArea.access$300(this.this$0));
          QMLog.d("MiniAppTextArea", "confirmHeight : " + MiniAppTextArea.access$1100(this.this$0));
          MiniAppTextArea.access$1300(this.this$0, i - j - k);
        }
      }
      else
      {
        label218:
        if ((!MiniAppTextArea.access$1700(this.this$0)) && (MiniAppTextArea.access$000(this.this$0)) && (paramBoolean) && (MiniAppTextArea.access$100(this.this$0) != null)) {
          MiniAppTextArea.access$1702(this.this$0, true);
        }
      }
      try
      {
        paramView = new JSONObject();
        paramView.put("inputId", MiniAppTextArea.access$900(this.this$0));
        j = MiniAppTextArea.access$300(this.this$0);
        if (MiniAppTextArea.access$1000(this.this$0))
        {
          i = MiniAppTextArea.access$1100(this.this$0);
          paramView.put("height", (int)((i + j) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
          QMLog.d("MiniAppTextArea", "onKeyboardShow : " + paramView.toString());
          localPageWebviewContainer.evaluateSubscribeJS("onKeyboardShow", paramView.toString());
          if ((paramBoolean) || (MiniAppTextArea.access$100(this.this$0) == null)) {}
        }
      }
      catch (Throwable paramView)
      {
        try
        {
          for (;;)
          {
            paramView = new JSONObject();
            paramView.put("inputId", MiniAppTextArea.access$900(this.this$0));
            paramView.put("value", this.this$0.getText().toString());
            paramView.put("cursor", this.this$0.getText().toString().length());
            QMLog.d("MiniAppTextArea", "onKeyboardComplete : " + paramView.toString());
            localPageWebviewContainer.evaluateSubscribeJS("onKeyboardComplete", paramView.toString());
            MiniAppTextArea.access$1702(this.this$0, false);
            return;
            localPageWebviewContainer = null;
            break;
            MiniAppTextArea.access$1600(this.this$0);
            break label218;
            label512:
            MiniAppTextArea.access$1600(this.this$0);
            break label218;
            i = 0;
          }
          paramView = paramView;
          QMLog.e("MiniAppTextArea", "onFocusChange error", paramView);
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            QMLog.e("MiniAppTextArea", "onFocusChange error", paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.MyOnFocusChangeListener
 * JD-Core Version:    0.7.0.1
 */