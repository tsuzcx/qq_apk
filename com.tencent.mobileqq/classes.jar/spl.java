import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.sheetItemClickProcessor.1;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class spl
  extends syt
{
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<sps> jdField_a_of_type_JavaUtilList;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private List<sps> b;
  
  public spl(boolean paramBoolean, List<sps> paramList1, List<sps> paramList2, JSONObject paramJSONObject, WeakReference paramWeakReference, String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramWeakReference;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramString;
    Object localObject;
    BridgeModule.shareCallBackId = localObject;
    this.jdField_a_of_type_Boolean = paramList1;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.b = paramJSONObject;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return false;
    }
    BridgeModule.shareCallBackType = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(paramInteger.intValue());
    BridgeModule.shareCallBackName = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(paramInteger.intValue());
    Object localObject1;
    if ("1".equals(this.jdField_a_of_type_OrgJsonJSONObject.optString("from")))
    {
      localObject1 = Uri.parse(this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url")).buildUpon();
      if (paramInteger.intValue() != 2) {
        break label212;
      }
      ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "2");
    }
    label212:
    Object localObject3;
    Object localObject2;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("share_url", ((Uri.Builder)localObject1).build().toString());
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(this.jdField_a_of_type_JavaUtilList, this.b, paramInteger.intValue());
        if ((localObject1 != null) && (((sps)localObject1).jdField_a_of_type_Boolean)) {
          paramInteger = new JSONObject();
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          paramInteger.put("type", BridgeModule.shareCallBackType);
          paramInteger.put("action", BridgeModule.shareCallBackName);
          paramInteger.put("fromCallback", 0);
          if (!TextUtils.isEmpty(BridgeModule.shareCallBackId)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(BridgeModule.shareCallBackId, paramInteger);
          }
          return true;
          if (paramInteger.intValue() == 3) {
            ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "3");
          } else if ((paramInteger.intValue() == 4) || (paramInteger.intValue() == 5)) {
            ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "6");
          } else if (paramInteger.intValue() == 1) {
            ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "4");
          }
        }
        localJSONException1 = localJSONException1;
        QLog.e(BridgeModule.TAG, 1, "processClick error=" + localJSONException1.getMessage());
      }
      catch (JSONException paramInteger)
      {
        for (;;)
        {
          QLog.e(BridgeModule.TAG, 1, "processClick webhandle error=" + paramInteger.getMessage());
        }
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        return true;
      }
      localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url");
      localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("puin");
      BridgeModule.access$302(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, true);
      if (paramInteger.intValue() != 14) {
        break label483;
      }
    }
    ((ClipboardManager)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("clipboard")).setText((CharSequence)localObject3);
    xxb.a(2, 2131691362);
    for (;;)
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("type", BridgeModule.shareCallBackType);
        ((JSONObject)localObject2).put("action", BridgeModule.shareCallBackName);
        ((JSONObject)localObject2).put("fromCallback", 0);
        if (!TextUtils.isEmpty(BridgeModule.shareCallBackId)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(BridgeModule.shareCallBackId, localObject2);
        }
        return super.a(paramInteger);
        label483:
        if (paramInteger.intValue() == 7)
        {
          BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a((String)localObject3);
          continue;
        }
        if (paramInteger.intValue() == 8)
        {
          BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).b((String)localObject3);
          continue;
        }
        if (paramInteger.intValue() == 1) {
          continue;
        }
        if (paramInteger.intValue() == 12)
        {
          localObject2 = (QQAppInterface)ors.a();
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((QQAppInterface)localObject2).getAccount();
          localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
          String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc");
          String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("image_url");
          biqt.a(0, (String)localObject3, this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url"), null, str1, str2, null, null, false, -1L).c((String)localObject2).b((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject2, 2, null);
          continue;
        }
        if (paramInteger.intValue() == 20)
        {
          ThreadManager.executeOnSubThread(new BridgeModule.sheetItemClickProcessor.1(this, (String)localObject3));
          continue;
        }
        if (paramInteger.intValue() == 9)
        {
          BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).c();
          continue;
        }
        if (paramInteger.intValue() == 10) {
          continue;
        }
        if (paramInteger.intValue() == 13)
        {
          BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).d((String)localObject3);
          continue;
        }
        if (paramInteger.intValue() == 17)
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject2 = AddFriendLogicActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 1, (String)localObject2, null, 3096, 1, this.jdField_a_of_type_OrgJsonJSONObject.optString("nick_name"), null, null, null, null);
          ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject2);
          continue;
        }
        if (paramInteger.intValue() == 16)
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject3 = aekt.a(new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), SplashActivity.class), null);
          ((Intent)localObject3).putExtra("uin", (String)localObject2);
          ((Intent)localObject3).putExtra("uintype", 0);
          ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject3);
          continue;
        }
        if (paramInteger.intValue() == 21)
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject3 = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), AccountDetailActivity.class);
          ((Intent)localObject3).putExtra("uin", (String)localObject2);
          ((Intent)localObject3).putExtra("from_js", true);
          ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject3);
          continue;
        }
        if (paramInteger.intValue() == 11)
        {
          localObject2 = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(this.jdField_a_of_type_JavaUtilList, this.b, paramInteger.intValue());
          if (!(localObject2 instanceof spt)) {
            continue;
          }
          localObject2 = ((spt)localObject2).b;
          BridgeModule.access$600(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, (String)localObject2);
          continue;
        }
        if ((paramInteger.intValue() == 22) || (paramInteger.intValue() == 23)) {
          continue;
        }
        BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(this.jdField_a_of_type_OrgJsonJSONObject, paramInteger.intValue(), (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QLog.e(BridgeModule.TAG, 1, "processClick error=" + localJSONException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spl
 * JD-Core Version:    0.7.0.1
 */