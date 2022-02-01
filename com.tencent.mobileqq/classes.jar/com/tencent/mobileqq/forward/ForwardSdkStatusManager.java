package com.tencent.mobileqq.forward;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class ForwardSdkStatusManager
  implements Manager
{
  private ForwardD55Manager a;
  private Map<String, Map<String, Object>> b = new HashMap();
  
  public ForwardSdkStatusManager()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> init");
    this.a = new ForwardD55Manager();
  }
  
  public ForwardD55Manager a()
  {
    return this.a;
  }
  
  public Map<String, Object> a(String paramString)
  {
    Map localMap = (Map)this.b.remove(paramString);
    boolean bool = false;
    if (localMap == null) {
      bool = true;
    }
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, new Object[] { "--> cache key:", paramString, " obj is Empty? ->", Boolean.valueOf(bool) });
    return localMap;
  }
  
  public void a(String paramString, Map<String, Object> paramMap)
  {
    this.b.put(paramString, paramMap);
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, new Object[] { "--> cache key:", paramString });
  }
  
  public void onDestroy()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> onDestroy");
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkStatusManager
 * JD-Core Version:    0.7.0.1
 */