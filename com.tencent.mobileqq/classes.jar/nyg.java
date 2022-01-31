import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class nyg
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
  
  public nye a()
  {
    nye localnye = new nye(null);
    nye.a(localnye, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    nye.a(localnye, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    nye.a(localnye, this.jdField_a_of_type_Long);
    nye.a(localnye, this.jdField_c_of_type_Int);
    nye.a(localnye, this.jdField_a_of_type_AndroidOsBundle);
    nye.a(localnye, this.jdField_a_of_type_AndroidContentContext);
    nye.a(localnye, this.jdField_b_of_type_OrgJsonJSONObject);
    nye.a(localnye, this.jdField_a_of_type_JavaLangString);
    nye.b(localnye, this.jdField_b_of_type_Int);
    nye.b(localnye, this.jdField_c_of_type_OrgJsonJSONObject);
    nye.c(localnye, this.jdField_a_of_type_Int);
    nye.c(localnye, this.jdField_d_of_type_OrgJsonJSONObject);
    nye.a(localnye, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    nye.d(localnye, this.jdField_a_of_type_OrgJsonJSONObject);
    nye.e(localnye, this.e);
    nye.d(localnye, this.jdField_d_of_type_Int);
    nye.f(localnye, this.f);
    localnye.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (nye.a(localnye) == null) {
          nye.f(localnye, new JSONObject());
        }
        if (nye.a(localnye).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(nye.a(localnye).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          nye.a(localnye).put("statistics_data_report", localJSONObject.toString());
          return localnye;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        nye.a(localnye).put("statistics_data_report", localJSONObject.toString());
        return localnye;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localnye;
  }
  
  public nyg a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public nyg a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public nyg a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public nyg a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public nyg a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public nyg a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public nyg a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public nyg a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public nyg a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nyg a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public nyg b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public nyg b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nyg c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public nyg c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public nyg d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public nyg d(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    return this;
  }
  
  public nyg e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyg
 * JD-Core Version:    0.7.0.1
 */