import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

final class sgc
  implements wxt
{
  sgc(ryd paramryd, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
    if ("onCommentSend".equals(localObject1)) {}
    for (;;)
    {
      String str;
      Object localObject2;
      int i;
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        str = paramBundle.getString("rowKey", "");
        localObject2 = paramBundle.getString("commentContent", "");
        i = paramBundle.getInt("firstLevelComment");
        paramBundle = paramBundle.getString("parentCommentId", "");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", "onCommentSend");
        localJSONObject.put("commentId", localObject1);
        localJSONObject.put("rowKey", str);
        localJSONObject.put("commentContent", localObject2);
        localJSONObject.put("firstLevelComment", i + 1);
        localJSONObject.put("parentCommentID", paramBundle);
        localJSONObject.put("result", "success");
        if (this.jdField_a_of_type_Ryd != null) {
          this.jdField_a_of_type_Ryd.a(this.jdField_a_of_type_JavaLangString, localJSONObject);
        }
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if ("onCommentLike".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          str = paramBundle.getString("rowKey", "");
          paramBundle = paramBundle.getString("likeStatus", "");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("type", "onCommentLike");
          ((JSONObject)localObject2).put("rowKey", str);
          ((JSONObject)localObject2).put("commentId", localObject1);
          ((JSONObject)localObject2).put("likeStatus", paramBundle);
          ((JSONObject)localObject2).put("result", "success");
          if (this.jdField_a_of_type_Ryd == null) {
            continue;
          }
          this.jdField_a_of_type_Ryd.a(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject2);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      } else if ("onCommentDelete".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          str = paramBundle.getString("rowKey", "");
          i = paramBundle.getInt("totalDeleteCount", 0);
          paramBundle = new JSONObject();
          paramBundle.put("type", "onCommentDelete");
          paramBundle.put("totalDelete", i);
          paramBundle.put("commentID", localObject1);
          paramBundle.put("rowKey", str);
          paramBundle.put("result", "success");
          if (this.jdField_a_of_type_Ryd == null) {
            continue;
          }
          this.jdField_a_of_type_Ryd.a(this.jdField_a_of_type_JavaLangString, paramBundle);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      } else if ("onPanelClose".equals(localObject1)) {
        try
        {
          paramBundle = paramBundle.getString("rowKey", "");
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("type", "onPanelClose");
          ((JSONObject)localObject1).put("rowKey", paramBundle);
          ((JSONObject)localObject1).put("result", "success");
          if (this.jdField_a_of_type_Ryd != null)
          {
            this.jdField_a_of_type_Ryd.a(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject1);
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sgc
 * JD-Core Version:    0.7.0.1
 */