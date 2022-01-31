package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import bglu;
import bgok;
import com.tencent.qqmini.sdk.core.widget.KeyboardLayout;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$6
  implements TextView.OnEditorActionListener
{
  InputJsPlugin$6(InputJsPlugin paramInputJsPlugin, EditText paramEditText, bgok parambgok, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      paramTextView = this.val$currentET.getText().toString();
      paramKeyEvent = new JSONObject();
      paramKeyEvent.put("value", paramTextView);
      this.val$req.a.a("onKeyboardConfirm", paramKeyEvent.toString(), 0);
      if (this.val$keyboardLayout.getVisibility() != 8) {
        this.val$keyboardLayout.setVisibility(8);
      }
      InputJsPlugin.access$400(this.this$0, this.val$context, this.val$currentET);
      this.val$req.a.a("onKeyboardComplete", paramKeyEvent.toString(), 0);
      if ((this.val$context instanceof Activity)) {
        DisplayUtil.setActivityFullScreen((Activity)this.val$context);
      }
    }
    catch (JSONException paramTextView)
    {
      for (;;)
      {
        QMLog.e("NetworkJsPlugin", "onEditorAction callback exception", paramTextView);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */