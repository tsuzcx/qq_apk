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
    try
    {
      Object localObject1 = ActionSheet.create(ShareJsPlugin.access$600(this.this$0).getAttachedActivity());
      localObject2 = new JSONObject(this.val$req.jsonParams);
      JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("itemList");
      int i = ((JSONObject)localObject2).optInt("actionSheetType", 0);
      if (i != 0)
      {
        if (i != 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.val$req.event);
          ((StringBuilder)localObject1).append(" actionSheetType undefined: ");
          ((StringBuilder)localObject1).append(i);
          QMLog.e("ShareJsPlugin", ((StringBuilder)localObject1).toString());
          return;
        }
        ShareJsPlugin.access$800(this.this$0, this.val$req);
        return;
      }
      ShareJsPlugin.access$700(this.this$0, (ActionSheet)localObject1, (JSONObject)localObject2, localJSONArray, this.val$req);
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.val$req.event);
      ((StringBuilder)localObject2).append(" error.");
      QMLog.e("ShareJsPlugin", ((StringBuilder)localObject2).toString(), localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */