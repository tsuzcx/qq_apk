package com.tencent.qqmini.sdk.core.plugins;

import android.view.View;
import bgok;
import bgsi;
import bgsn;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class ShareJsPlugin$4$3
  implements bgsn
{
  ShareJsPlugin$4$3(ShareJsPlugin.4 param4, bgsi parambgsi) {}
  
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
      QMLog.e("ShareJsPlugin", this.this$1.val$req.a + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.4.3
 * JD-Core Version:    0.7.0.1
 */