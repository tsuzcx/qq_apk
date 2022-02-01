package com.tencent.qqprotect.qsec;

import java.util.HashMap;
import mqq.app.MobileQQ;

public class QSecRuntimeImpl
  implements IQSecRuntime
{
  public static IQSecRuntime a;
  private HashMap<String, IRuntimeInterface> b = new HashMap();
  
  public QSecRuntimeImpl()
  {
    a = this;
  }
  
  public void a(IRuntimeInterface paramIRuntimeInterface)
  {
    String str = paramIRuntimeInterface.getInterfaceName();
    if ((str != null) && (!this.b.containsKey(str))) {
      this.b.put(str, paramIRuntimeInterface);
    }
  }
  
  public Object getApplicationContext()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public Object getQQAppInterface()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public int getRuntimeVersion()
  {
    return 1;
  }
  
  public IRuntimeInterface queryRuntimeInterface(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    IRuntimeInterface localIRuntimeInterface = (IRuntimeInterface)this.b.get(paramString);
    if ((localIRuntimeInterface != null) && (!paramString.equals(localIRuntimeInterface.getInterfaceName()))) {
      return null;
    }
    return localIRuntimeInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */