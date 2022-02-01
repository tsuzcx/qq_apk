package com.tencent.mobileqq.nearby.ipc;

import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

public class NearbyProxyObserver
{
  private boolean a;
  
  protected void a() {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 4102)
    {
      if (paramInt != 4124) {
        return;
      }
      a();
      return;
    }
    a((BusinessInfoCheckUpdate.AppInfo)paramVarArgs[0]);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver
 * JD-Core Version:    0.7.0.1
 */