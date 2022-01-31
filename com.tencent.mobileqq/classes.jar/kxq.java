import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public final class kxq
  implements Runnable
{
  public kxq(String paramString, int paramInt1, int paramInt2, Context paramContext, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt3, JSONObject paramJSONObject, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject1).put("type", this.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("ts", System.currentTimeMillis());
      ((JSONObject)localObject1).put("origin", this.b);
      ((JSONObject)localObject1).put("oudid", "1");
      ((JSONObject)localObject1).put("device_info", NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext));
      ((JSONObject)localObject1).put("ad_info", NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.c));
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        ((JSONObject)localObject1).put("video_info", this.jdField_a_of_type_OrgJsonJSONObject);
      }
      Object localObject2 = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "report json = " + (String)localObject2);
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      localObject1 = new WebSsoBody.WebSsoRequestBody();
      ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), PublicAccountServlet.class);
      ((NewIntent)localObject2).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_report_new");
      ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
      ((NewIntent)localObject2).setObserver(new kxr(this));
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxq
 * JD-Core Version:    0.7.0.1
 */