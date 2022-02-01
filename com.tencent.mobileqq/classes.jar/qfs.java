import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class qfs
  extends uaj
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  qfs(ArticleInfo paramArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramWeakReference;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = localObject;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Object localObject1 = ((rho)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
        if (paramActionSheetItem.action == 13)
        {
          localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject1 != null)
          {
            localObject2 = qgl.a((Activity)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
            if (ouh.a() == 1)
            {
              bool = true;
              ((Intent)localObject2).putExtra("fast_biu_type", bool);
              ((Activity)localObject1).startActivityForResult((Intent)localObject2, 55577);
              ((Activity)localObject1).overridePendingTransition(0, 0);
            }
          }
          else
          {
            return super.a(paramInt, paramActionSheetItem);
          }
        }
      }
    }
    catch (NullPointerException localNullPointerException1)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("PgcShortContentProteusItem", 1, localNullPointerException1.toString());
        String str1 = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
        continue;
        boolean bool = false;
        continue;
        try
        {
          localObject2 = new JSONArray();
          JSONObject localJSONObject = new JSONObject();
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
          localJSONObject.put("sourceName", anni.a(2131701510));
          localJSONObject.put("WXShareFromQQKandian", 1);
          localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
          localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
          localJSONObject.put("src_action", "plugin");
          localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
          localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
          localJSONObject.put("desc", ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131717171));
          localJSONObject.put("menu_title", anni.a(2131712353));
          localJSONObject.put("share_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getShareUrl());
          localJSONObject.put("keepShareUrl", 1);
          localJSONObject.put("image_url", str1);
          localJSONObject.put("weibo_title", anni.a(2131711799));
          localJSONObject.put("uin", "");
          localJSONObject.put("puin", 0);
          if (qfa.a(this.jdField_a_of_type_Qfa) == null) {
            qfa.a(this.jdField_a_of_type_Qfa, new tpa());
          }
          str1 = null;
          if (paramActionSheetItem.action == 72) {
            str1 = paramActionSheetItem.uin;
          }
          qfa.a(this.jdField_a_of_type_Qfa).a(localJSONObject, paramInt, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, paramActionSheetItem.uinType, paramActionSheetItem.label);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        catch (NullPointerException localNullPointerException2)
        {
          for (;;)
          {
            QLog.e("PgcShortContentProteusItem", 1, localNullPointerException2.toString());
          }
        }
        return super.a(paramInt, paramActionSheetItem);
        String str2 = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfs
 * JD-Core Version:    0.7.0.1
 */