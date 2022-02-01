package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.cmd0xe36.cmd0xe36.RspBody;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BridgeModuleHelper$2
  extends ProtoUtils.TroopProtocolObserver
{
  BridgeModuleHelper$2(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("yyy_0xe36 error code: ");
    paramBundle.append(paramInt);
    QLog.i("BridgeModuleHelper", 1, paramBundle.toString());
    if (paramInt == 0)
    {
      paramBundle = new cmd0xe36.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = 0;
        paramArrayOfByte = "";
        if (paramBundle.code.has()) {
          paramInt = paramBundle.code.get();
        }
        if (paramBundle.wording.has()) {
          paramArrayOfByte = paramBundle.wording.get();
        }
        paramBundle = new StringBuilder();
        paramBundle.append("yyy_0xe36 code: ");
        paramBundle.append(paramInt);
        paramBundle.append("\nwording: ");
        paramBundle.append(paramArrayOfByte);
        QLog.i("BridgeModuleHelper", 1, paramBundle.toString());
        if ((paramInt != 0) && (!TextUtils.isEmpty(paramArrayOfByte)))
        {
          paramBundle = new JSONObject();
          paramBundle.put("wording", paramArrayOfByte);
          this.a.invokeCallJS(this.b, paramBundle);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("yyy_0xe36 error: ");
        paramBundle.append(paramArrayOfByte.toString());
        QLog.i("BridgeModuleHelper", 1, paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.2
 * JD-Core Version:    0.7.0.1
 */