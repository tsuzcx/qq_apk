package com.tencent.mobileqq.mini.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import org.json.JSONException;
import org.json.JSONObject;

class WebInputHandler$4
  implements TextView.OnEditorActionListener
{
  WebInputHandler$4(WebInputHandler paramWebInputHandler, WebEditText paramWebEditText, PageWebview paramPageWebview) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramTextView = new JSONObject();
        paramTextView.put("inputId", WebInputHandler.access$100(this.this$0));
        paramTextView.put("value", this.val$webEditText.getText().toString());
        this.val$pageWebview.evaluateSubcribeJS("onKeyboardConfirm", paramTextView.toString(), this.val$pageWebview.pageWebviewId);
        if (this.val$webEditText.isConfirmHold()) {
          continue;
        }
        this.this$0.hideCurrentInput(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler.4
 * JD-Core Version:    0.7.0.1
 */