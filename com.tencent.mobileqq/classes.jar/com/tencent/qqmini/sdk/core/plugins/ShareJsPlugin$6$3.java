package com.tencent.qqmini.sdk.core.plugins;

import android.view.View;
import bdfz;
import bdje;
import bdjj;
import bdnw;
import org.json.JSONException;
import org.json.JSONObject;

class ShareJsPlugin$6$3
  implements bdjj
{
  ShareJsPlugin$6$3(ShareJsPlugin.6 param6, bdje parambdje) {}
  
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
      bdnw.d("ShareJsPlugin", this.this$1.val$req.a + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.6.3
 * JD-Core Version:    0.7.0.1
 */