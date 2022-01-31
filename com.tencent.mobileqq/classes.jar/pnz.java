import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class pnz
  extends syt
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  pnz(ArticleInfo paramArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramWeakReference;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = localObject;
  }
  
  protected boolean a(Integer paramInteger)
  {
    Object localObject1 = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
    for (;;)
    {
      try
      {
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          continue;
        }
        localObject2 = ((qms)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
        localObject1 = localObject2;
      }
      catch (NullPointerException localNullPointerException2)
      {
        Object localObject2;
        JSONObject localJSONObject;
        QLog.e("PgcShortContentProteusItem", 1, localNullPointerException2.toString());
        continue;
        String str = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
        continue;
      }
      try
      {
        localObject2 = new JSONArray();
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "qq_friend");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject2).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "qzone");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject2).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject2).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat_circle");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject2).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("upline", localObject2);
        localJSONObject.put("belowline", new JSONArray());
        localJSONObject.put("shareCallBack", "");
        localJSONObject.put("title", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaLangString);
        localJSONObject.put("back", true);
        localJSONObject.put("sourceName", alpo.a(2131703091));
        localJSONObject.put("WXShareFromQQKandian", 1);
        localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("src_action", "plugin");
        localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("desc", ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131719031));
        localJSONObject.put("menu_title", alpo.a(2131713962));
        localJSONObject.put("share_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getShareUrl());
        localJSONObject.put("keepShareUrl", 1);
        localJSONObject.put("image_url", localObject1);
        localJSONObject.put("weibo_title", alpo.a(2131713408));
        localJSONObject.put("uin", "");
        localJSONObject.put("puin", 0);
        if (pnh.a(this.jdField_a_of_type_Pnh) == null) {
          pnh.a(this.jdField_a_of_type_Pnh, new spp());
        }
        pnh.a(this.jdField_a_of_type_Pnh).a(localJSONObject, paramInteger.intValue(), (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      catch (NullPointerException localNullPointerException1)
      {
        QLog.e("PgcShortContentProteusItem", 1, localNullPointerException1.toString());
      }
    }
    return super.a(paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnz
 * JD-Core Version:    0.7.0.1
 */