package com.tencent.vas.update.business;

import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.factory.api.IVasUpdateFactory;
import com.tencent.vas.update.module.api.IVasUpdateSystem;
import com.tencent.vas.update.module.impl.NotificationModuleImpl;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

public abstract class VasBusinessManager
{
  protected BaseUpdateBusiness[] b;
  protected NotificationModuleImpl c = new NotificationModuleImpl();
  
  public VasBusinessManager()
  {
    VasUpdateWrapper.setVasUpdateWrapper(d());
    f();
    VasUpdateWrapper.getVasUpdateSystem().a(this.c);
  }
  
  private void a(BaseUpdateBusiness[] paramArrayOfBaseUpdateBusiness)
  {
    int j = paramArrayOfBaseUpdateBusiness.length;
    int i = 0;
    while (i < j)
    {
      BaseUpdateBusiness localBaseUpdateBusiness = paramArrayOfBaseUpdateBusiness[i];
      if ((localBaseUpdateBusiness != null) && (localBaseUpdateBusiness.getBid() > 0L)) {
        this.c.a(localBaseUpdateBusiness.getBid(), localBaseUpdateBusiness);
      }
      i += 1;
    }
  }
  
  public BaseUpdateBusiness a(long paramLong)
  {
    if (this.c.a(paramLong) != null) {
      return (BaseUpdateBusiness)this.c.a(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bid doesn't resiter or has been register,you need to reuse the same bid callback,bid = ");
    localStringBuilder.append(paramLong);
    throw new NullPointerException(localStringBuilder.toString());
  }
  
  public <T extends IBusinessCallback> T a(Class<T> paramClass)
  {
    if (this.c.a(paramClass) != null) {
      return this.c.a(paramClass);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bid has been register , you need to reuse the same bid callback，class = ");
    localStringBuilder.append(paramClass);
    throw new NullPointerException(localStringBuilder.toString());
  }
  
  protected BaseUpdateBusiness b()
  {
    return null;
  }
  
  public abstract BaseUpdateBusiness[] c();
  
  protected abstract IVasUpdateFactory d();
  
  public void f()
  {
    this.b = c();
    a(this.b);
    BaseUpdateBusiness localBaseUpdateBusiness = b();
    if (localBaseUpdateBusiness != null) {
      this.c.a(localBaseUpdateBusiness);
    }
  }
  
  public void g()
  {
    this.c.a();
    this.b = null;
  }
  
  public void h()
  {
    VasUpdateWrapper.getVasUpdateSystem().a();
  }
  
  public void i()
  {
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.business.VasBusinessManager
 * JD-Core Version:    0.7.0.1
 */