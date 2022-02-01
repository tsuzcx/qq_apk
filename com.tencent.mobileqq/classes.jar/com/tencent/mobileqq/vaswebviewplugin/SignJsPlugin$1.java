package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import bbux;
import bhzd;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class SignJsPlugin$1
  implements EIPCResultCallback
{
  SignJsPlugin$1(SignJsPlugin paramSignJsPlugin) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (TextUtils.isEmpty(SignJsPlugin.access$000(this.this$0)))
    {
      QLog.e("SignJsPlugin", 1, "getSignature callback web callback is null");
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      bhzd localbhzd;
      try
      {
        if ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null)) {
          continue;
        }
        paramEIPCResult = paramEIPCResult.data.getSerializable("my_signature");
        if (!(paramEIPCResult instanceof RichStatus)) {
          continue;
        }
        paramEIPCResult = (RichStatus)paramEIPCResult;
        if (bbux.a().a == null) {
          bbux.a().b(paramEIPCResult);
        }
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("bgId", paramEIPCResult.tplId);
        localJSONObject2.put("fontId", paramEIPCResult.fontId);
        localJSONObject2.put("fontType", paramEIPCResult.fontType);
        localJSONObject2.put("actionId", paramEIPCResult.actionId);
        localJSONObject2.put("actionText", paramEIPCResult.actionText);
        localbhzd = bbux.a().a(paramEIPCResult.tplId);
        if (!localbhzd.a.get()) {
          break label319;
        }
        if (paramEIPCResult.mStickerInfos == null) {
          break label328;
        }
        if (!paramEIPCResult.mStickerInfos.isEmpty()) {
          break label314;
        }
      }
      catch (Exception paramEIPCResult)
      {
        JSONObject localJSONObject2;
        QLog.e("SignJsPlugin", 1, "getSignature callback error: ", paramEIPCResult);
        this.this$0.callJs(SignJsPlugin.access$000(this.this$0), new String[] { "{\"result\": -1}" });
        return;
      }
      localJSONObject2.put("signType", i);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("data", localJSONObject2);
      this.this$0.callJs(SignJsPlugin.access$000(this.this$0), new String[] { localJSONObject1.toString() });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SignJsPlugin", 2, "getSignature result = " + localJSONObject1.toString());
      return;
      label314:
      int i = 1;
      continue;
      label319:
      i = localbhzd.g;
      continue;
      label328:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */