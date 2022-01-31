package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
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
  private Map a;
  private Map b;
  private Map c = new LinkedHashMap();
  
  public MSFNetTransportProvider(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.c.put("SecIntChkSvc.MainCmd", "intchk");
    this.c.put("SecSafeChkSvc.MainCmd", "app_scan");
    this.c.put("SecCheckSigSvc.UploadReq", "sig_check");
  }
  
  public int a(Object paramObject)
  {
    if ((paramObject instanceof ToServiceMsg)) {
      b((ToServiceMsg)paramObject);
    }
    return 0;
  }
  
  public INetTransportProvider.INetTransportCodec a(String paramString)
  {
    if (this.a == null) {
      this.a = new LinkedHashMap();
    }
    Object localObject2;
    if (this.a.containsKey(paramString))
    {
      localObject2 = (INetTransportProvider.INetTransportCodec)this.a.get(paramString);
      return localObject2;
    }
    Object localObject1;
    if ((TextUtils.equals(paramString, "intchk")) || (TextUtils.equals(paramString, "app_scan")) || (TextUtils.equals(paramString, "sig_check")))
    {
      if (!this.c.containsValue(paramString)) {
        break label182;
      }
      localObject2 = this.c.keySet().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (String)((Iterator)localObject2).next();
      } while (!((String)this.c.get(localObject1)).equalsIgnoreCase(paramString));
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
        this.a.put(paramString, localObject1);
        return localObject1;
      }
      label182:
      localObject1 = null;
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          } while (this.b == null);
          paramObject = paramFromServiceMsg.getServiceCmd();
        } while (!this.c.containsKey(paramObject));
        paramObject = (String)this.c.get(paramObject);
      } while (!this.b.containsKey(paramObject));
      paramObject = (INetTransportProvider.INetTransportEventListener)this.b.get(paramObject);
    } while (paramObject == null);
    paramObject.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(String paramString, INetTransportProvider.INetTransportEventListener paramINetTransportEventListener)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramINetTransportEventListener == null) {
      return;
    }
    if (this.b == null) {
      this.b = new LinkedHashMap();
    }
    this.b.put(paramString, paramINetTransportEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFNetTransportProvider
 * JD-Core Version:    0.7.0.1
 */