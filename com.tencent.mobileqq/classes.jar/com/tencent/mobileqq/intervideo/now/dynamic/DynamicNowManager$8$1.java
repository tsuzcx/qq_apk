package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver.IBusinessInitFinish;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import org.json.JSONObject;

class DynamicNowManager$8$1
  extends DefaultLiveTicketObserver
{
  DynamicNowManager$8$1(DynamicNowManager.8 param8, IBusinessExpireObserver.IBusinessInitFinish paramIBusinessInitFinish) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver$IBusinessInitFinish.a();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject = new BizLoginRequest();
    paramJSONObject.jdField_a_of_type_JavaLangString = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$8.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$8.jdField_a_of_type_AndroidOsBundle);
    paramJSONObject.jdField_a_of_type_Int = 8;
    paramJSONObject.g = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$8.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a();
    paramJSONObject.f = DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$8.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).b();
    paramJSONObject.b = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager$8.jdField_a_of_type_JavaLangString;
    LiteLiveSDKFactory.a().a(paramJSONObject);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver$IBusinessInitFinish.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.8.1
 * JD-Core Version:    0.7.0.1
 */