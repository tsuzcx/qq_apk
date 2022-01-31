package com.tencent.mobileqq.microapp.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements TextView.OnEditorActionListener
{
  d(a parama, WebEditText paramWebEditText, PageWebview paramPageWebview) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      paramTextView = new JSONObject();
      paramTextView.put("inputId", a.a(this.c));
      paramTextView.put("value", this.a.getText().toString());
      this.b.evaluateSubcribeJS("onKeyboardConfirm", paramTextView.toString(), this.b.pageWebviewId);
      this.c.a(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.d
 * JD-Core Version:    0.7.0.1
 */