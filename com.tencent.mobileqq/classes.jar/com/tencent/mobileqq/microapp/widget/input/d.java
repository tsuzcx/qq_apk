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
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6)) {
      return false;
    }
    try
    {
      paramTextView = new JSONObject();
      paramTextView.put("inputId", a.a(this.c));
      paramTextView.put("value", this.a.getText().toString());
      this.b.evaluateSubcribeJS("onKeyboardConfirm", paramTextView.toString(), this.b.pageWebviewId);
    }
    catch (JSONException paramTextView)
    {
      paramTextView.printStackTrace();
    }
    this.c.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.d
 * JD-Core Version:    0.7.0.1
 */