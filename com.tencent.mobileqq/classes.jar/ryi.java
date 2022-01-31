import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.sheetItemClickProcessor.1;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ryi
  extends shb
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ryp> jdField_a_of_type_JavaUtilList;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private List<ryp> b;
  
  public ryi(boolean paramBoolean, List<ryp> paramList1, List<ryp> paramList2, JSONObject paramJSONObject, WeakReference paramWeakReference, String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramWeakReference;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramString;
    Object localObject;
    this.jdField_a_of_type_JavaLangString = localObject;
    this.jdField_a_of_type_Boolean = paramList1;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.b = paramJSONObject;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return false;
    }
    int i;
    if (paramInteger.intValue() == 2) {
      i = 0;
    }
    for (;;)
    {
      String str1 = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(paramInteger.intValue());
      Object localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(this.jdField_a_of_type_JavaUtilList, this.b, paramInteger.intValue());
        if ((localObject1 != null) && (((ryp)localObject1).jdField_a_of_type_Boolean)) {
          paramInteger = new JSONObject();
        }
      }
      try
      {
        paramInteger.put("type", i);
        paramInteger.put("action", str1);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramInteger);
        }
        label127:
        return true;
        if (paramInteger.intValue() == 3)
        {
          i = 1;
          continue;
        }
        if (paramInteger.intValue() == 4)
        {
          i = 2;
          continue;
        }
        if (paramInteger.intValue() == 5)
        {
          i = 3;
          continue;
        }
        if (paramInteger.intValue() == 6)
        {
          i = 4;
          continue;
        }
        if (paramInteger.intValue() == 1)
        {
          i = 7;
          continue;
        }
        if (paramInteger.intValue() == 14)
        {
          i = 8;
          continue;
        }
        i = -1;
        continue;
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          return true;
        }
        Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url");
        localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("puin");
        BridgeModule.access$302(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, true);
        if (paramInteger.intValue() == 14)
        {
          ((ClipboardManager)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("clipboard")).setText((CharSequence)localObject2);
          wim.a(2, 2131691309);
        }
        for (;;)
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("type", i);
            ((JSONObject)localObject1).put("action", str1);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject1);
            }
            label344:
            return super.a(paramInteger);
            if (paramInteger.intValue() == 7)
            {
              BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a((String)localObject2);
              continue;
            }
            if (paramInteger.intValue() == 8)
            {
              BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).b((String)localObject2);
              continue;
            }
            if (paramInteger.intValue() == 1) {
              continue;
            }
            if (paramInteger.intValue() == 12)
            {
              localObject1 = (QQAppInterface)onk.a();
              if (localObject1 == null) {
                continue;
              }
              localObject1 = ((QQAppInterface)localObject1).getAccount();
              localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
              String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc");
              String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("image_url");
              bgpd.a(0, (String)localObject2, this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url"), null, str2, str3, null, null, false, -1L).c((String)localObject1).b((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, 2, null);
              continue;
            }
            if (paramInteger.intValue() == 20)
            {
              ThreadManager.executeOnSubThread(new BridgeModule.sheetItemClickProcessor.1(this, (String)localObject2));
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
              BridgeModule.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).d((String)localObject2);
              continue;
            }
            if (paramInteger.intValue() == 17)
            {
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localObject1 = AddFriendLogicActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 1, (String)localObject1, null, 3096, 1, this.jdField_a_of_type_OrgJsonJSONObject.optString("nick_name"), null, null, null, null);
              ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject1);
              continue;
            }
            if (paramInteger.intValue() == 16)
            {
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localObject2 = actn.a(new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), SplashActivity.class), null);
              ((Intent)localObject2).putExtra("uin", (String)localObject1);
              ((Intent)localObject2).putExtra("uintype", 0);
              ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject2);
              continue;
            }
            if (paramInteger.intValue() == 21)
            {
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localObject2 = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), AccountDetailActivity.class);
              ((Intent)localObject2).putExtra("uin", (String)localObject1);
              ((Intent)localObject2).putExtra("from_js", true);
              ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject2);
              continue;
            }
            if (paramInteger.intValue() == 11)
            {
              localObject1 = BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(this.jdField_a_of_type_JavaUtilList, this.b, paramInteger.intValue());
              if (!(localObject1 instanceof ryq)) {
                continue;
              }
              localObject1 = ((ryq)localObject1).b;
              BridgeModule.access$600(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, (String)localObject1);
              continue;
            }
            if ((paramInteger.intValue() == 22) || (paramInteger.intValue() == 23)) {
              continue;
            }
            BridgeModule.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a(this.jdField_a_of_type_OrgJsonJSONObject, paramInteger.intValue(), (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          catch (JSONException localJSONException)
          {
            break label344;
          }
        }
      }
      catch (JSONException paramInteger)
      {
        break label127;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryi
 * JD-Core Version:    0.7.0.1
 */