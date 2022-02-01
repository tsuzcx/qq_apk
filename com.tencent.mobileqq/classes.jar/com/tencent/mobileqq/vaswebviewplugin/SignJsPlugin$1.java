package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
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
      try
      {
        if ((paramEIPCResult.code == 0) && (paramEIPCResult.data != null))
        {
          paramEIPCResult = paramEIPCResult.data.getSerializable("my_signature");
          if ((paramEIPCResult instanceof RichStatus))
          {
            paramEIPCResult = (RichStatus)paramEIPCResult;
            if (SignatureManagerForTool.a().a == null) {
              SignatureManagerForTool.a().b(paramEIPCResult);
            }
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("bgId", paramEIPCResult.tplId);
            localJSONObject2.put("fontId", paramEIPCResult.fontId);
            localJSONObject2.put("fontType", paramEIPCResult.fontType);
            localJSONObject2.put("actionId", paramEIPCResult.actionId);
            localJSONObject2.put("actionText", paramEIPCResult.actionText);
            SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(paramEIPCResult.tplId);
            if (localSignatureTemplateInfo.a.get())
            {
              if (paramEIPCResult.mStickerInfos == null) {
                break label330;
              }
              if (!paramEIPCResult.mStickerInfos.isEmpty()) {
                break label325;
              }
              break label330;
            }
            i = localSignatureTemplateInfo.E;
            localJSONObject2.put("signType", i);
            localJSONObject1.put("result", 0);
            localJSONObject1.put("data", localJSONObject2);
            this.this$0.callJs(SignJsPlugin.access$000(this.this$0), new String[] { localJSONObject1.toString() });
            if (QLog.isColorLevel())
            {
              paramEIPCResult = new StringBuilder();
              paramEIPCResult.append("getSignature result = ");
              paramEIPCResult.append(localJSONObject1.toString());
              QLog.d("SignJsPlugin", 2, paramEIPCResult.toString());
            }
            return;
          }
        }
      }
      catch (Exception paramEIPCResult)
      {
        QLog.e("SignJsPlugin", 1, "getSignature callback error: ", paramEIPCResult);
        paramEIPCResult = this.this$0;
        paramEIPCResult.callJs(SignJsPlugin.access$000(paramEIPCResult), new String[] { "{\"result\": -1}" });
        return;
      }
      label325:
      int i = 1;
      continue;
      label330:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */