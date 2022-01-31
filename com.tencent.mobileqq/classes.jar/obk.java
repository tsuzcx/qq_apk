import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class obk
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
  
  public obi a()
  {
    obi localobi = new obi(null);
    obi.a(localobi, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    obi.a(localobi, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    obi.a(localobi, this.jdField_a_of_type_Long);
    obi.a(localobi, this.jdField_c_of_type_Int);
    obi.a(localobi, this.jdField_a_of_type_AndroidOsBundle);
    obi.a(localobi, this.jdField_a_of_type_AndroidContentContext);
    obi.a(localobi, this.jdField_b_of_type_OrgJsonJSONObject);
    obi.a(localobi, this.jdField_a_of_type_JavaLangString);
    obi.b(localobi, this.jdField_b_of_type_Int);
    obi.b(localobi, this.jdField_c_of_type_OrgJsonJSONObject);
    obi.c(localobi, this.jdField_a_of_type_Int);
    obi.c(localobi, this.jdField_d_of_type_OrgJsonJSONObject);
    obi.a(localobi, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    obi.d(localobi, this.jdField_a_of_type_OrgJsonJSONObject);
    obi.e(localobi, this.e);
    obi.d(localobi, this.jdField_d_of_type_Int);
    obi.f(localobi, this.f);
    localobi.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (obi.a(localobi) == null) {
          obi.f(localobi, new JSONObject());
        }
        if (obi.a(localobi).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(obi.a(localobi).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          obi.a(localobi).put("statistics_data_report", localJSONObject.toString());
          return localobi;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        obi.a(localobi).put("statistics_data_report", localJSONObject.toString());
        return localobi;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localobi;
  }
  
  public obk a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public obk a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public obk a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public obk a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public obk a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public obk a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public obk a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public obk a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public obk a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public obk a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public obk b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public obk b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public obk c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public obk c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public obk d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public obk d(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    return this;
  }
  
  public obk e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obk
 * JD-Core Version:    0.7.0.1
 */