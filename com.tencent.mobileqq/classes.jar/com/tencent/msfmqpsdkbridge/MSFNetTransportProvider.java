package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportEventListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MSFNetTransportProvider
  extends BusinessHandler
  implements INetTransportProvider
{
  private Map<String, INetTransportProvider.INetTransportCodec> mCodecMap = null;
  private Map<String, INetTransportProvider.INetTransportEventListener> mEventListenerMap = null;
  private Map<String, String> mServiceNameMap = new LinkedHashMap();
  
  public MSFNetTransportProvider(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.mServiceNameMap.put("SecIntChkSvc.MainCmd", "intchk");
    this.mServiceNameMap.put("SecSafeChkSvc.MainCmd", "app_scan");
    this.mServiceNameMap.put("SecCheckSigSvc.UploadReq", "sig_check");
  }
  
  public INetTransportProvider.INetTransportCodec getCodec(String paramString)
  {
    if (this.mCodecMap == null) {
      this.mCodecMap = new LinkedHashMap();
    }
    if (this.mCodecMap.containsKey(paramString)) {
      return (INetTransportProvider.INetTransportCodec)this.mCodecMap.get(paramString);
    }
    if ((TextUtils.equals(paramString, "intchk")) || (TextUtils.equals(paramString, "app_scan")) || (TextUtils.equals(paramString, "sig_check")))
    {
      if (this.mServiceNameMap.containsValue(paramString))
      {
        Iterator localIterator = this.mServiceNameMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (((String)this.mServiceNameMap.get(localObject)).equalsIgnoreCase(paramString)) {
            break label144;
          }
        }
      }
      localObject = null;
      label144:
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new MSFCodec((String)localObject);
        break label165;
      }
    }
    Object localObject = null;
    label165:
    if (localObject != null) {
      this.mCodecMap.put(paramString, localObject);
    }
    return localObject;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      if (this.mEventListenerMap == null) {
        return;
      }
      paramObject = paramFromServiceMsg.getServiceCmd();
      if (!this.mServiceNameMap.containsKey(paramObject)) {
        return;
      }
      paramObject = (String)this.mServiceNameMap.get(paramObject);
      if (!this.mEventListenerMap.containsKey(paramObject)) {
        return;
      }
      paramObject = (INetTransportProvider.INetTransportEventListener)this.mEventListenerMap.get(paramObject);
      if (paramObject == null) {
        return;
      }
      paramObject.a(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  public int send(Object paramObject)
  {
    if ((paramObject instanceof ToServiceMsg)) {
      sendPbReq((ToServiceMsg)paramObject);
    }
    return 0;
  }
  
  public void setNetTransportEventListener(String paramString, INetTransportProvider.INetTransportEventListener paramINetTransportEventListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramINetTransportEventListener == null) {
      return;
    }
    if (this.mEventListenerMap == null) {
      this.mEventListenerMap = new LinkedHashMap();
    }
    this.mEventListenerMap.put(paramString, paramINetTransportEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFNetTransportProvider
 * JD-Core Version:    0.7.0.1
 */