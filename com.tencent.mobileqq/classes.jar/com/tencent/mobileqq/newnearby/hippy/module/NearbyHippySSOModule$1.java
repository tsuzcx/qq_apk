package com.tencent.mobileqq.newnearby.hippy.module;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.wifi.Base64;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class NearbyHippySSOModule$1
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyHippySSOModule$1(NearbyHippySSOModule paramNearbyHippySSOModule, byte[] paramArrayOfByte, Promise paramPromise) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("sendData onResult rsp-errorCode=");
    paramBundle.append(paramInt);
    QLog.d("NearbyHippySSOModule", 2, paramBundle.toString());
    paramBundle = new HippyMap();
    paramBundle.pushInt("code", paramInt);
    if (paramArrayOfByte == null)
    {
      QLog.d("NearbyHippySSOModule", 2, "sendData onResult data = null");
    }
    else
    {
      paramArrayOfByte = Base64.b(paramArrayOfByte, 2);
      if (this.a != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendData onResult data=");
        localStringBuilder.append(paramArrayOfByte);
        QLog.d("NearbyHippySSOModule", 2, localStringBuilder.toString());
        paramBundle.pushString("body", paramArrayOfByte);
      }
      else
      {
        QLog.d("NearbyHippySSOModule", 2, "sendData onResult Base64.encodeToString getNull");
      }
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("sendData onResult rsp-data=");
    paramArrayOfByte.append(paramBundle.toJSONObject().toString());
    QLog.d("NearbyHippySSOModule", 2, paramArrayOfByte.toString());
    this.b.resolve(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.module.NearbyHippySSOModule.1
 * JD-Core Version:    0.7.0.1
 */