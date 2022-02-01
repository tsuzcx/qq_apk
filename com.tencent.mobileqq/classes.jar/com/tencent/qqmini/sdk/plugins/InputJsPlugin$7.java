package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.KeyboardLayout;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$7
  implements TextView.OnEditorActionListener
{
  InputJsPlugin$7(InputJsPlugin paramInputJsPlugin, EditText paramEditText, RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6)) {
      return false;
    }
    try
    {
      paramTextView = this.val$currentET.getText().toString();
      paramKeyEvent = new JSONObject();
      paramKeyEvent.put("value", paramTextView);
      this.val$req.jsService.evaluateSubscribeJS("onKeyboardConfirm", paramKeyEvent.toString(), 0);
      if (this.val$keyboardLayout.getVisibility() != 8) {
        this.val$keyboardLayout.setVisibility(8);
      }
      InputJsPlugin.access$700(this.this$0, this.val$context, this.val$currentET);
      this.val$req.jsService.evaluateSubscribeJS("onKeyboardComplete", paramKeyEvent.toString(), 0);
      if ((this.val$context instanceof Activity)) {
        DisplayUtil.setActivityFullScreen((Activity)this.val$context);
      }
    }
    catch (JSONException paramTextView)
    {
      QMLog.e("InputJsPlugin", "onEditorAction callback exception", paramTextView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InputJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */