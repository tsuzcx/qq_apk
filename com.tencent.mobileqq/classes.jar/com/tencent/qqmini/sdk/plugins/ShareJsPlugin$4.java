package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ShareJsPlugin$4
  implements Runnable
{
  ShareJsPlugin$4(ShareJsPlugin paramShareJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localActionSheet = ActionSheet.create(ShareJsPlugin.access$600(this.this$0).getAttachedActivity());
        localJSONObject = new JSONObject(this.val$req.jsonParams);
        localJSONArray = localJSONObject.optJSONArray("itemList");
        int i = localJSONObject.optInt("actionSheetType", 0);
        switch (i)
        {
        case 0: 
          QMLog.e("ShareJsPlugin", this.val$req.event + " actionSheetType undefined: " + i);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ActionSheet localActionSheet;
        JSONObject localJSONObject;
        JSONArray localJSONArray;
        QMLog.e("ShareJsPlugin", this.val$req.event + " error.", localJSONException);
        return;
      }
      ShareJsPlugin.access$700(this.this$0, localActionSheet, localJSONObject, localJSONArray, this.val$req);
      return;
      ShareJsPlugin.access$800(this.this$0, this.val$req);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */