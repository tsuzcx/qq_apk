package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import bize;
import bizf;
import bizg;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MSFNetTransportProvider
  extends BusinessHandler
  implements bize
{
  private Map<String, bizf> mCodecMap;
  private Map<String, bizg> mEventListenerMap;
  private Map<String, String> mServiceNameMap = new LinkedHashMap();
  
  public MSFNetTransportProvider(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.mServiceNameMap.put("SecIntChkSvc.MainCmd", "intchk");
    this.mServiceNameMap.put("SecSafeChkSvc.MainCmd", "app_scan");
    this.mServiceNameMap.put("SecCheckSigSvc.UploadReq", "sig_check");
  }
  
  public bizf getCodec(String paramString)
  {
    if (this.mCodecMap == null) {
      this.mCodecMap = new LinkedHashMap();
    }
    Object localObject2;
    if (this.mCodecMap.containsKey(paramString))
    {
      localObject2 = (bizf)this.mCodecMap.get(paramString);
      return localObject2;
    }
    Object localObject1;
    if ((TextUtils.equals(paramString, "intchk")) || (TextUtils.equals(paramString, "app_scan")) || (TextUtils.equals(paramString, "sig_check")))
    {
      if (!this.mServiceNameMap.containsValue(paramString)) {
        break label182;
      }
      localObject2 = this.mServiceNameMap.keySet().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (String)((Iterator)localObject2).next();
      } while (!((String)this.mServiceNameMap.get(localObject1)).equalsIgnoreCase(paramString));
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = new MSFCodec((String)localObject1);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        this.mCodecMap.put(paramString, localObject1);
        return localObject1;
      }
      label182:
      localObject1 = null;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {}
    label11:
    do
    {
      do
      {
        do
        {
          break label11;
          do
          {
            return;
          } while (this.mEventListenerMap == null);
          paramObject = paramFromServiceMsg.getServiceCmd();
        } while (!this.mServiceNameMap.containsKey(paramObject));
        paramObject = (String)this.mServiceNameMap.get(paramObject);
      } while (!this.mEventListenerMap.containsKey(paramObject));
      paramObject = (bizg)this.mEventListenerMap.get(paramObject);
    } while (paramObject == null);
    paramObject.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public int send(Object paramObject)
  {
    if ((paramObject instanceof ToServiceMsg)) {
      sendPbReq((ToServiceMsg)paramObject);
    }
    return 0;
  }
  
  public void setNetTransportEventListener(String paramString, bizg parambizg)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (parambizg == null) {
      return;
    }
    if (this.mEventListenerMap == null) {
      this.mEventListenerMap = new LinkedHashMap();
    }
    this.mEventListenerMap.put(paramString, parambizg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFNetTransportProvider
 * JD-Core Version:    0.7.0.1
 */