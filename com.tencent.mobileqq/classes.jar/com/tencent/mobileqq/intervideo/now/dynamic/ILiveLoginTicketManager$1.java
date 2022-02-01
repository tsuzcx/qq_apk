package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.Doraemon.APICallback;
import org.json.JSONObject;

class ILiveLoginTicketManager$1
  implements APICallback
{
  ILiveLoginTicketManager$1(ILiveLoginTicketManager paramILiveLoginTicketManager, APICallback paramAPICallback) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback.a(paramInt, paramString);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    ILiveLoginTicketManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager, paramJSONObject.optString("access_token"));
    ILiveLoginTicketManager.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager, paramJSONObject.optString("openid"));
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback.a(paramJSONObject);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback.b(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.ILiveLoginTicketManager.1
 * JD-Core Version:    0.7.0.1
 */