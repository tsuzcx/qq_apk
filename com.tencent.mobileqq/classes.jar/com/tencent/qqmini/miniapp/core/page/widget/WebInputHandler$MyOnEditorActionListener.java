package com.tencent.qqmini.miniapp.core.page.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6))
    {
      bool1 = false;
    }
    else
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("inputId", WebInputHandler.access$300(this.this$0));
        localJSONObject.put("value", this.webEditText.getText().toString());
        this.req.jsService.evaluateSubscribeJS("onKeyboardConfirm", localJSONObject.toString(), 0);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (!this.webEditText.isConfirmHold()) {
        this.this$0.hideCurrentInput();
      }
      bool1 = bool2;
      if (WebInputHandler.access$200(this.this$0) != null)
      {
        bool1 = bool2;
        if (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() != null)
        {
          WebInputHandler localWebInputHandler = this.this$0;
          WebInputHandler.access$400(localWebInputHandler, new float[] { WebInputHandler.access$200(localWebInputHandler).getPageWebviewContainer().getTranslationY(), 0.0F });
          bool1 = bool2;
        }
      }
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.MyOnEditorActionListener
 * JD-Core Version:    0.7.0.1
 */