package com.tencent.mobileqq.qrscan.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qrscan.QRCodeBusinessObserver;
import com.tencent.mobileqq.qrscan.QRCodeServlet;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class QRDataApiImpl
  implements IQRDataApi
{
  public void requestUrlDecode(AppRuntime paramAppRuntime, String paramString, JSONObject paramJSONObject, Bundle paramBundle, QRCodeBusinessObserver paramQRCodeBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.getContext(), QRCodeServlet.class);
    localNewIntent.putExtra("d", paramString);
    localNewIntent.putExtra("cmd", "QRCodeSvc.decode");
    localNewIntent.putExtra("bqq", "1");
    if (paramJSONObject != null)
    {
      paramString = new String[9];
      int i = 0;
      paramString[0] = "md5";
      paramString[1] = "fromuin";
      paramString[2] = "touin";
      paramString[3] = "imei";
      paramString[4] = "ip";
      paramString[5] = "url";
      paramString[6] = "guid";
      paramString[7] = "uuid";
      paramString[8] = "type";
      int j = paramString.length;
      while (i < j)
      {
        String str = paramString[i];
        if (paramJSONObject.has(str)) {
          localNewIntent.putExtra(str, paramJSONObject.optString(str));
        }
        i += 1;
      }
    }
    if (paramBundle != null) {
      localNewIntent.putExtra("extra", paramBundle);
    }
    localNewIntent.setObserver(paramQRCodeBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void requestUrlEncode(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, QRCodeBusinessObserver paramQRCodeBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.getContext(), QRCodeServlet.class);
    localNewIntent.putExtra("d", paramString);
    localNewIntent.putExtra("cmd", "QRCodeSvc.encode");
    if (paramBundle != null) {
      localNewIntent.putExtra("extra", paramBundle);
    }
    localNewIntent.setObserver(paramQRCodeBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRDataApiImpl
 * JD-Core Version:    0.7.0.1
 */