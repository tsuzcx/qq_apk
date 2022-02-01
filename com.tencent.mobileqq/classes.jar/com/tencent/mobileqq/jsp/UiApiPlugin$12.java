package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class UiApiPlugin$12
  implements ITroopMemberApiClientApi.Callback
{
  UiApiPlugin$12(UiApiPlugin paramUiApiPlugin, Map paramMap) {}
  
  public void callback(Bundle paramBundle)
  {
    String str = paramBundle.getString("action");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ("onCommentSend".equals(str)) {
      try
      {
        str = (String)this.a.get(str);
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        localObject3 = paramBundle.getString("commentContent", "");
        int i = paramBundle.getInt("firstLevelComment");
        paramBundle = new JSONObject();
        paramBundle.put("commentId", localObject1);
        paramBundle.put("rowKey", localObject2);
        paramBundle.put("commentContent", localObject3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i + 1);
        ((StringBuilder)localObject1).append("");
        paramBundle.put("firstLevelComment", ((StringBuilder)localObject1).toString());
        paramBundle.put("result", "success");
        this.b.callJs(str, new String[] { paramBundle.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if ("onCommentLike".equals(str)) {
      try
      {
        str = (String)this.a.get(str);
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        paramBundle = paramBundle.getString("likeStatus", "");
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("commentId", localObject1);
        ((JSONObject)localObject3).put("rowKey", localObject2);
        ((JSONObject)localObject3).put("likeStatus", paramBundle);
        ((JSONObject)localObject3).put("result", "success");
        this.b.callJs(str, new String[] { ((JSONObject)localObject3).toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if ("onCommentDelete".equals(str)) {
      try
      {
        str = (String)this.a.get(str);
        localObject1 = paramBundle.getString("commentId", "");
        paramBundle = paramBundle.getString("rowKey", "");
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("commentId", localObject1);
        ((JSONObject)localObject2).put("rowKey", paramBundle);
        ((JSONObject)localObject2).put("result", "success");
        this.b.callJs(str, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if ("onPanelClose".equals(str)) {
      try
      {
        str = (String)this.a.get(str);
        paramBundle = paramBundle.getString("rowKey", "");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("rowKey", paramBundle);
        ((JSONObject)localObject1).put("result", "success");
        this.b.callJs(str, new String[] { ((JSONObject)localObject1).toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.12
 * JD-Core Version:    0.7.0.1
 */