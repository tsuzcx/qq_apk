package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;

class SignatureManagerForTool$3
  implements EIPCResultCallback
{
  SignatureManagerForTool$3(SignatureManagerForTool paramSignatureManagerForTool) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = paramEIPCResult.data;
    if (localObject == null) {
      return;
    }
    int i = ((Bundle)localObject).getInt("notify_type");
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 8)
        {
          if (i != 9) {
            return;
          }
          i = ((Bundle)localObject).getInt("key_history_signature_num");
          SignatureManagerForTool.f(this.a);
          paramEIPCResult = new ArrayList();
          paramEIPCResult.add(Integer.valueOf(8));
          paramEIPCResult.add(Integer.valueOf(i));
          this.a.notifyObservers(paramEIPCResult);
          return;
        }
        ((Bundle)localObject).getLong("bid");
        paramEIPCResult = ((Bundle)localObject).getString("scid");
        if (!TextUtils.isEmpty(paramEIPCResult))
        {
          i = ((Bundle)localObject).getInt("download_result");
          if ((paramEIPCResult.startsWith("signature.sticker.")) && (i == 0))
          {
            paramEIPCResult = paramEIPCResult.substring(18, paramEIPCResult.length() - 4);
            if (TextUtils.isDigitsOnly(paramEIPCResult))
            {
              i = Integer.parseInt(paramEIPCResult);
              SignatureManagerForTool.e(this.a);
              paramEIPCResult = new ArrayList();
              paramEIPCResult.add(Integer.valueOf(7));
              paramEIPCResult.add(Integer.valueOf(i));
              this.a.notifyObservers(paramEIPCResult);
            }
          }
        }
      }
      else
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("change_status_callback_data", paramEIPCResult.data);
        i = paramEIPCResult.data.getInt("result");
        int j = paramEIPCResult.data.getInt("type");
        SignatureManagerForTool.d(this.a);
        paramEIPCResult = new ArrayList();
        paramEIPCResult.add(Integer.valueOf(6));
        paramEIPCResult.add(Integer.valueOf(i));
        paramEIPCResult.add(localObject);
        paramEIPCResult.add(Integer.valueOf(j));
        this.a.notifyObservers(paramEIPCResult);
      }
    }
    else
    {
      paramEIPCResult = ((Bundle)localObject).getSerializable("my_signature");
      if ((paramEIPCResult instanceof RichStatus))
      {
        SignatureManagerForTool.c(this.a);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Integer.valueOf(5));
        ((ArrayList)localObject).add(paramEIPCResult);
        this.a.notifyObservers(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.3
 * JD-Core Version:    0.7.0.1
 */