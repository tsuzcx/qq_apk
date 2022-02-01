package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.util.Log;
import com.tencent.falco.base.libapi.lottie.LoadToPlayInter;
import com.tencent.falco.utils.FileUtil;
import com.tencent.qphone.base.util.QLog;
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
      Object localObject1 = new JSONObject(FileUtil.readString(this.a)).getJSONObject("starframe");
      int i = 0;
      if (localObject1 != null) {
        i = ((JSONObject)localObject1).getInt("starframe");
      }
      CustomLottieView.a(this.this$0, (int)(i * 1.0F / 30.0F + 0.5F) * 1000000);
      localObject1 = CustomLottieView.a(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("t=");
      ((StringBuilder)localObject2).append(CustomLottieView.b(this.this$0));
      Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
      CustomLottieView.c(this.this$0).put(this.a, Integer.valueOf(CustomLottieView.b(this.this$0)));
    }
    catch (Exception localException)
    {
      Object localObject2 = CustomLottieView.a(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" e =");
      localStringBuilder.append(localException.toString());
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      localException.printStackTrace();
    }
    LoadToPlayInter localLoadToPlayInter = this.b;
    if (localLoadToPlayInter != null) {
      localLoadToPlayInter.onPrepareStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.3
 * JD-Core Version:    0.7.0.1
 */