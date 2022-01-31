package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import begy;
import beka;
import besl;
import bffu;
import com.tencent.qqmini.sdk.core.widget.KeyboardLayout;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$7
  implements View.OnClickListener
{
  InputJsPlugin$7(InputJsPlugin paramInputJsPlugin, EditText paramEditText, beka parambeka, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
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
        bffu.a((Activity)this.val$context);
      }
      return;
    }
    catch (JSONException paramView)
    {
      besl.d("NetworkJsPlugin", "confirm button click callback exception", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */