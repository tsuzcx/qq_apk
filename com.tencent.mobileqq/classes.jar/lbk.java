import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class lbk
  implements Runnable
{
  public lbk(PublicAccountSearchRecommendManager paramPublicAccountSearchRecommendManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      try
      {
        localObject1 = new JSONArray();
        localObject2 = PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          PublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem localPublicAccountSearchHistoryItem = (PublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localPublicAccountSearchHistoryItem.jdField_a_of_type_JavaLangString);
          localJSONObject.put("name", localPublicAccountSearchHistoryItem.b);
          localJSONObject.put("time", localPublicAccountSearchHistoryItem.jdField_a_of_type_Long);
          localJSONObject.put("isPA", localPublicAccountSearchHistoryItem.jdField_a_of_type_Boolean);
          ((JSONArray)localObject1).put(localJSONObject);
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "saveHistoryListToLocal->error:" + localException);
        }
        localException.printStackTrace();
      }
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("search_history_list", localObject1);
    Object localObject1 = ((JSONObject)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "saveHistoryListToLocal->json:" + (String)localObject1);
    }
    SharedPreferences.Editor localEditor = localException.edit();
    localEditor.putString("public_account_search_history", (String)localObject1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbk
 * JD-Core Version:    0.7.0.1
 */