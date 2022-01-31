package com.tencent.qqmini.sdk.core.plugins;

import android.view.View;
import bekr;
import beny;
import beod;
import betc;
import org.json.JSONException;
import org.json.JSONObject;

class ShareJsPlugin$6$3
  implements beod
{
  ShareJsPlugin$6$3(ShareJsPlugin.6 param6, beny parambeny) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("tapIndex", paramInt);
      this.this$1.val$req.a(paramView);
      this.val$actionSheet.dismiss();
      return;
    }
    catch (JSONException paramView)
    {
      betc.d("ShareJsPlugin", this.this$1.val$req.a + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.6.3
 * JD-Core Version:    0.7.0.1
 */