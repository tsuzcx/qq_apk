package com.tencent.vas.update.module.impl;

import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.callback.VasBusinessManager;

public class DefaultVasBusinessManager
  extends VasBusinessManager
{
  public IVasUpdateFactory createVasUpdateFactory()
  {
    return DefaultVasUpdateFactory.getInstance();
  }
  
  public BaseUpdateBusiness[] registerBusinessCallback()
  {
    return new BaseUpdateBusiness[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultVasBusinessManager
 * JD-Core Version:    0.7.0.1
 */