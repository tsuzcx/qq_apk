package com.tencent.mobileqq.microapp.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements TextView.OnEditorActionListener
{
  d(a parama, WebEditText paramWebEditText, PageWebview paramPageWebview) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6))
    {
      bool = false;
    }
    else
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("inputId", a.a(this.c));
        localJSONObject.put("value", this.a.getText().toString());
        this.b.evaluateSubcribeJS("onKeyboardConfirm", localJSONObject.toString(), this.b.pageWebviewId);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.c.a(true);
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.d
 * JD-Core Version:    0.7.0.1
 */