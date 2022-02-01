package com.tencent.vas.update.factory.impl;

import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.business.VasBusinessManager;
import com.tencent.vas.update.factory.api.IVasUpdateFactory;

public class DefaultVasBusinessManager
  extends VasBusinessManager
{
  public BaseUpdateBusiness[] c()
  {
    return new BaseUpdateBusiness[0];
  }
  
  protected IVasUpdateFactory d()
  {
    return DefaultVasUpdateFactoryImpl.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.factory.impl.DefaultVasBusinessManager
 * JD-Core Version:    0.7.0.1
 */