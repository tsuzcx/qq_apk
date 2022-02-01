package com.tencent.qqmini.miniapp.core.page.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class WebInputHandler$MyOnEditorActionListener
  implements TextView.OnEditorActionListener
{
  private NativeViewRequestEvent req;
  private WebEditText webEditText;
  
  public WebInputHandler$MyOnEditorActionListener(WebInputHandler paramWebInputHandler, WebEditText paramWebEditText, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    this.webEditText = paramWebEditText;
    this.req = paramNativeViewRequestEvent;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramTextView = new JSONObject();
        paramTextView.put("inputId", WebInputHandler.access$300(this.this$0));
        paramTextView.put("value", this.webEditText.getText().toString());
        this.req.jsService.evaluateSubscribeJS("onKeyboardConfirm", paramTextView.toString(), 0);
        if (!this.webEditText.isConfirmHold()) {
          this.this$0.hideCurrentInput();
        }
        bool1 = bool2;
        if (WebInputHandler.access$200(this.this$0) == null) {
          continue;
        }
        bool1 = bool2;
        if (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() == null) {
          continue;
        }
        WebInputHandler.access$400(this.this$0, new float[] { WebInputHandler.access$200(this.this$0).getPageWebviewContainer().getTranslationY(), 0.0F });
        return true;
      }
      catch (JSONException paramTextView)
      {
        for (;;)
        {
          paramTextView.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.MyOnEditorActionListener
 * JD-Core Version:    0.7.0.1
 */