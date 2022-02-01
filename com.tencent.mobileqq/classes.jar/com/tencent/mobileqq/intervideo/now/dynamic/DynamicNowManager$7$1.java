package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import org.json.JSONObject;

class DynamicNowManager$7$1
  extends DefaultLiveTicketObserver
{
  DynamicNowManager$7$1(DynamicNowManager.7 param7, IBizLoginObserver paramIBizLoginObserver) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    IBizLoginObserver localIBizLoginObserver = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver;
    if (localIBizLoginObserver != null) {
      localIBizLoginObserver.a(paramInt, paramString);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver != null)
    {
      paramJSONObject = new BizLoginRequest();
      paramJSONObject.jdField_a_of_type_JavaLangString = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$7.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$7.jdField_a_of_type_AndroidOsBundle);
      paramJSONObject.jdField_a_of_type_Int = 8;
      paramJSONObject.g = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$7.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a();
      paramJSONObject.f = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$7.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).b();
      paramJSONObject.b = "101490787";
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver.a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.7.1
 * JD-Core Version:    0.7.0.1
 */