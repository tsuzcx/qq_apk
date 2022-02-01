import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class qgy
  extends uaj
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private tht jdField_a_of_type_Tht = new qgz(this);
  
  qgy(ArticleInfo paramArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramWeakReference;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = localObject;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    case 3: 
      return 1;
    case 9: 
      return 2;
    case 10: 
      return 3;
    }
    return 4;
  }
  
  private String a()
  {
    String str = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
    }
    QLog.d("OnShareClickListener", 2, "getImageUrl | shareImgUrl : " + str);
    return str;
  }
  
  private void a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!a()) {
      return;
    }
    ((pmm)pha.a().getManager(163)).a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(paramInt), this.jdField_a_of_type_Tht);
  }
  
  private boolean a()
  {
    if (!bgnt.g(qgw.a(this.jdField_a_of_type_Qgw)))
    {
      QQToast.a(qgw.a(this.jdField_a_of_type_Qgw), 1, 2131716972, 0).a();
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 9;
    case 3: 
      return 10;
    }
    return 13;
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
    }
    return "";
  }
  
  private void b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    try
    {
      Object localObject = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", "qq_friend");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("name", "qzone");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("name", "we_chat");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("name", "we_chat_circle");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("upline", localObject);
      localJSONObject.put("belowline", new JSONArray());
      localJSONObject.put("shareCallBack", "");
      localJSONObject.put("title", b());
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
      for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.commentShareUrl;; localObject = "")
      {
        localJSONObject.put("share_url", localObject);
        localJSONObject.put("keepShareUrl", 1);
        localJSONObject.put("image_url", a());
        localJSONObject.put("weibo_title", anni.a(2131711799));
        localJSONObject.put("uin", "");
        localJSONObject.put("puin", 0);
        if (qgw.a(this.jdField_a_of_type_Qgw) == null) {
          qgw.a(this.jdField_a_of_type_Qgw, new tpa());
        }
        localObject = null;
        if (paramActionSheetItem.action == 72) {
          localObject = paramActionSheetItem.uin;
        }
        qgw.a(this.jdField_a_of_type_Qgw).a(localJSONObject, paramInt, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject, paramActionSheetItem.uinType, paramActionSheetItem.label);
        return;
      }
      return;
    }
    catch (JSONException paramActionSheetItem)
    {
      QLog.d("OnShareClickListener", 2, paramActionSheetItem.getMessage());
    }
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    boolean bool = true;
    if (paramActionSheetItem.action == 13)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Intent localIntent;
      if (localActivity != null)
      {
        localIntent = qgl.a(localActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (ouh.a() != 1) {
          break label77;
        }
      }
      for (;;)
      {
        localIntent.putExtra("fast_biu_type", bool);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(0, 0);
        return super.a(paramInt, paramActionSheetItem);
        label77:
        bool = false;
      }
    }
    if ((snh.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (snh.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      a(paramInt, paramActionSheetItem);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      b(paramInt, paramActionSheetItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgy
 * JD-Core Version:    0.7.0.1
 */