package com.tencent.mqpsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mqpsdk.secsrv.MQPIntChkService;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService;
import java.util.LinkedHashMap;
import java.util.Map;

public class MQPSecServiceManager
{
  public Context a = null;
  public INetTransportProvider b = null;
  private Map<String, Object> c = null;
  
  public MQPSecServiceManager(Context paramContext, INetTransportProvider paramINetTransportProvider)
  {
    this.a = paramContext;
    this.b = paramINetTransportProvider;
  }
  
  public Object a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    if (this.c == null) {
      this.c = new LinkedHashMap();
    }
    if (this.c.containsKey(paramString)) {
      return this.c.get(paramString);
    }
    if (TextUtils.equals(paramString, "intchk")) {
      localObject = new MQPIntChkService(this);
    } else if (TextUtils.equals(paramString, "sig_check")) {
      localObject = new MQPSigCheckService(this);
    }
    if (localObject != null) {
      this.c.put(paramString, localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqpsdk.MQPSecServiceManager
 * JD-Core Version:    0.7.0.1
 */