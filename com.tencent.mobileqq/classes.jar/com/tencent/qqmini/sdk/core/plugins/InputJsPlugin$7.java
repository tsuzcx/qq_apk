package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import bglu;
import bgok;
import com.tencent.qqmini.sdk.core.widget.KeyboardLayout;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$7
  implements View.OnClickListener
{
  InputJsPlugin$7(InputJsPlugin paramInputJsPlugin, EditText paramEditText, bgok parambgok, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = this.val$currentET.getText().toString();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramView);
      this.val$req.a.a("onKeyboardConfirm", localJSONObject.toString(), 0);
      if (!this.val$keyboardLayout.a())
      {
        if (this.val$keyboardLayout.getVisibility() != 8) {
          this.val$keyboardLayout.setVisibility(8);
        }
        InputJsPlugin.access$400(this.this$0, this.val$context, this.val$currentET);
      }
      this.val$req.a.a("onKeyboardComplete", localJSONObject.toString(), 0);
      if ((this.val$context instanceof Activity)) {
        DisplayUtil.setActivityFullScreen((Activity)this.val$context);
      }
      return;
    }
    catch (JSONException paramView)
    {
      QMLog.e("NetworkJsPlugin", "confirm button click callback exception", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */