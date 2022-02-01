package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.FileUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LoadToPlayInter;
import java.util.HashMap;
import org.json.JSONObject;

class CustomLottieView$3
  implements Runnable
{
  CustomLottieView$3(CustomLottieView paramCustomLottieView, String paramString, LoadToPlayInter paramLoadToPlayInter) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(FileUtil.readString(this.jdField_a_of_type_JavaLangString)).getJSONObject("starframe");
      if (localJSONObject == null) {
        break label189;
      }
      i = localJSONObject.getInt("starframe");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CustomLottieView.a(this.this$0).getLogger().e(CustomLottieView.a(this.this$0), " e =" + localException.toString(), new Object[0]);
        localException.printStackTrace();
        continue;
        label189:
        int i = 0;
      }
    }
    CustomLottieView.a(this.this$0, (int)(i * 1.0F / 30.0F + 0.5F) * 1000000);
    Log.e(CustomLottieView.a(this.this$0), "t=" + CustomLottieView.a(this.this$0));
    CustomLottieView.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(CustomLottieView.a(this.this$0)));
    if (this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLoadToPlayInter != null) {
      this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponent_interfaceShowviewLoadToPlayInter.onPrepareStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.3
 * JD-Core Version:    0.7.0.1
 */