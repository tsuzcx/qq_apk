import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class nyd
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Bundle jdField_a_of_type_AndroidOsBundle;
  VideoAdInfo jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  JSONObject jdField_b_of_type_OrgJsonJSONObject;
  int jdField_c_of_type_Int;
  JSONObject jdField_c_of_type_OrgJsonJSONObject;
  int jdField_d_of_type_Int;
  JSONObject jdField_d_of_type_OrgJsonJSONObject;
  JSONObject e;
  JSONObject f;
  
  public nyb a()
  {
    nyb localnyb = new nyb(null);
    nyb.a(localnyb, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    nyb.a(localnyb, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    nyb.a(localnyb, this.jdField_a_of_type_Long);
    nyb.a(localnyb, this.jdField_c_of_type_Int);
    nyb.a(localnyb, this.jdField_a_of_type_AndroidOsBundle);
    nyb.a(localnyb, this.jdField_a_of_type_AndroidContentContext);
    nyb.a(localnyb, this.jdField_b_of_type_OrgJsonJSONObject);
    nyb.a(localnyb, this.jdField_a_of_type_JavaLangString);
    nyb.b(localnyb, this.jdField_b_of_type_Int);
    nyb.b(localnyb, this.jdField_c_of_type_OrgJsonJSONObject);
    nyb.c(localnyb, this.jdField_a_of_type_Int);
    nyb.c(localnyb, this.jdField_d_of_type_OrgJsonJSONObject);
    nyb.a(localnyb, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nyb.d(localnyb, this.jdField_a_of_type_OrgJsonJSONObject);
    nyb.e(localnyb, this.e);
    nyb.d(localnyb, this.jdField_d_of_type_Int);
    nyb.f(localnyb, this.f);
    localnyb.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (nyb.a(localnyb) == null) {
          nyb.f(localnyb, new JSONObject());
        }
        if (nyb.a(localnyb).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(nyb.a(localnyb).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          nyb.a(localnyb).put("statistics_data_report", localJSONObject.toString());
          return localnyb;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        nyb.a(localnyb).put("statistics_data_report", localJSONObject.toString());
        return localnyb;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localnyb;
  }
  
  public nyd a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public nyd a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public nyd a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public nyd a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public nyd a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public nyd a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public nyd a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public nyd a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public nyd a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nyd a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public nyd b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public nyd b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nyd c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public nyd c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nyd d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public nyd d(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    return this;
  }
  
  public nyd e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyd
 * JD-Core Version:    0.7.0.1
 */