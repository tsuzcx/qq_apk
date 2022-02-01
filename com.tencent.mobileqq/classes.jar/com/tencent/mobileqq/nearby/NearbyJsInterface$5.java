package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class NearbyJsInterface$5
  implements BusinessObserver
{
  NearbyJsInterface$5(NearbyJsInterface paramNearbyJsInterface, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramBundle = new JSONObject(localWebSsoResponseBody.data.get());
        this.b.callJs(new JSONObject(this.a).getString("callback"), new String[] { paramBundle.toString() });
        return;
      }
      if (!QLog.isColorLevel()) {
        break label111;
      }
      QLog.w("followUser js api", 2, " no data!");
      return;
    }
    catch (Exception paramBundle)
    {
      label97:
      label111:
      break label97;
    }
    if (QLog.isColorLevel()) {
      QLog.w("followUser js api", 2, " no data! error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.5
 * JD-Core Version:    0.7.0.1
 */