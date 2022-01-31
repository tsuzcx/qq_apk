import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class nmv
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
  
  public nmt a()
  {
    nmt localnmt = new nmt(null);
    nmt.a(localnmt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    nmt.a(localnmt, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    nmt.a(localnmt, this.jdField_a_of_type_Long);
    nmt.a(localnmt, this.jdField_c_of_type_Int);
    nmt.a(localnmt, this.jdField_a_of_type_AndroidOsBundle);
    nmt.a(localnmt, this.jdField_a_of_type_AndroidContentContext);
    nmt.a(localnmt, this.jdField_b_of_type_OrgJsonJSONObject);
    nmt.a(localnmt, this.jdField_a_of_type_JavaLangString);
    nmt.b(localnmt, this.jdField_b_of_type_Int);
    nmt.b(localnmt, this.jdField_c_of_type_OrgJsonJSONObject);
    nmt.c(localnmt, this.jdField_a_of_type_Int);
    nmt.c(localnmt, this.jdField_d_of_type_OrgJsonJSONObject);
    nmt.a(localnmt, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nmt.d(localnmt, this.jdField_a_of_type_OrgJsonJSONObject);
    nmt.e(localnmt, this.e);
    nmt.d(localnmt, this.jdField_d_of_type_Int);
    nmt.f(localnmt, this.f);
    localnmt.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (nmt.a(localnmt) == null) {
          nmt.f(localnmt, new JSONObject());
        }
        if (nmt.a(localnmt).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(nmt.a(localnmt).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          nmt.a(localnmt).put("statistics_data_report", localJSONObject.toString());
          return localnmt;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        nmt.a(localnmt).put("statistics_data_report", localJSONObject.toString());
        return localnmt;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localnmt;
  }
  
  public nmv a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public nmv a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public nmv a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public nmv a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public nmv a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public nmv a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public nmv a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public nmv a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public nmv a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nmv a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public nmv b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public nmv b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nmv c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public nmv c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nmv d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public nmv d(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    return this;
  }
  
  public nmv e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmv
 * JD-Core Version:    0.7.0.1
 */