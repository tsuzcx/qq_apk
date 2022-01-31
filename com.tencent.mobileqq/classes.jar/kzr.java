import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class kzr
  implements Runnable
{
  public kzr(PublicAccountSearchRecommendManager paramPublicAccountSearchRecommendManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      try
      {
        localObject1 = new JSONArray();
        localObject2 = PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem localPublicAccountSearchRecommendItem = (PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localPublicAccountSearchRecommendItem.jdField_a_of_type_JavaLangString);
          localJSONObject.put("name", localPublicAccountSearchRecommendItem.b);
          localJSONObject.put("isPA", localPublicAccountSearchRecommendItem.jdField_a_of_type_Boolean);
          ((JSONArray)localObject1).put(localJSONObject);
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "saveRecommendListToLocal->error:" + localException);
        }
        localException.printStackTrace();
      }
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("recommend_title", PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager));
    ((JSONObject)localObject2).put("recommend_cache_time", PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager));
    ((JSONObject)localObject2).put("recommend_fetch_time", PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager));
    ((JSONObject)localObject2).put("recommend_is_forbidden", PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager));
    ((JSONObject)localObject2).put("recommend_content_list", localObject1);
    Object localObject1 = ((JSONObject)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "saveRecommendListToLocal->json:" + (String)localObject1);
    }
    SharedPreferences.Editor localEditor = localException.edit();
    localEditor.putString("public_account_search_recommend", (String)localObject1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzr
 * JD-Core Version:    0.7.0.1
 */