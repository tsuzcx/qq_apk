import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import org.json.JSONException;
import org.json.JSONObject;

public class rlh
  implements wiu
{
  public rlh(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
    if ("onCommentSend".equals(localObject1)) {}
    do
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        localObject3 = paramBundle.getString("commentContent", "");
        int i = paramBundle.getInt("firstLevelComment");
        paramBundle = new JSONObject();
        paramBundle.put("commentId", localObject1);
        paramBundle.put("rowKey", localObject2);
        paramBundle.put("commentContent", localObject3);
        paramBundle.put("firstLevelComment", i + 1 + "");
        paramBundle.put("result", "success");
        paramBundle.put("type", "onCommentSend");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramBundle);
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
          localObject2 = paramBundle.getString("rowKey", "");
          paramBundle = paramBundle.getString("likeStatus", "");
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("commentId", localObject1);
          ((JSONObject)localObject3).put("rowKey", localObject2);
          ((JSONObject)localObject3).put("likeStatus", paramBundle);
          ((JSONObject)localObject3).put("result", "success");
          ((JSONObject)localObject3).put("type", "onCommentLike");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject3);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
      if ("onCommentDelete".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          paramBundle = paramBundle.getString("rowKey", "");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("commentId", localObject1);
          ((JSONObject)localObject2).put("rowKey", paramBundle);
          ((JSONObject)localObject2).put("result", "success");
          ((JSONObject)localObject2).put("type", "onCommentDelete");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject2);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    } while (!"onPanelClose".equals(localObject1));
    try
    {
      paramBundle = paramBundle.getString("rowKey", "");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("rowKey", paramBundle);
      ((JSONObject)localObject1).put("result", "success");
      ((JSONObject)localObject1).put("type", "onPanelClose");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject1);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlh
 * JD-Core Version:    0.7.0.1
 */