package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import org.json.JSONException;

class ReadInjoyWebShareHelper$3$1
  implements Runnable
{
  ReadInjoyWebShareHelper$3$1(ReadInjoyWebShareHelper.3 param3, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = ReadInjoyWebShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$3.this$0).a();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$3.this$0.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$3.a, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$3.c, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$3.d, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$3.e, 13);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */