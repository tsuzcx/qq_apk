package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.KeyboardLayout;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$7
  implements View.OnClickListener
{
  InputJsPlugin$7(InputJsPlugin paramInputJsPlugin, EditText paramEditText, RequestEvent paramRequestEvent, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    try
    {
      String str = this.val$currentET.getText().toString();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", str);
      this.val$req.jsService.evaluateSubscribeJS("onKeyboardConfirm", localJSONObject.toString(), 0);
      if (!this.val$keyboardLayout.isConfirmHold())
      {
        if (this.val$keyboardLayout.getVisibility() != 8) {
          this.val$keyboardLayout.setVisibility(8);
        }
        InputJsPlugin.access$700(this.this$0, this.val$context, this.val$currentET);
      }
      this.val$req.jsService.evaluateSubscribeJS("onKeyboardComplete", localJSONObject.toString(), 0);
      if ((this.val$context instanceof Activity)) {
        DisplayUtil.setActivityFullScreen((Activity)this.val$context);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("InputJsPlugin", "confirm button click callback exception", localJSONException);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InputJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */