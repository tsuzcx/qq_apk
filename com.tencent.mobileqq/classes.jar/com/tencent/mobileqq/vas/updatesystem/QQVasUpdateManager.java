package com.tencent.mobileqq.vas.updatesystem;

import com.tencent.mobileqq.vas.updatesystem.business.NativeUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TestUpdateBusinessV2;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.impl.VasUpdateFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.callback.VasBusinessManager;
import mqq.manager.Manager;

public class QQVasUpdateManager
  extends VasBusinessManager
  implements Manager
{
  private VasUpdateFactory a;
  
  public VasUpdateFactory a()
  {
    return this.a;
  }
  
  protected IVasUpdateFactory createVasUpdateFactory()
  {
    this.a = new VasUpdateFactory();
    return this.a;
  }
  
  public void onDestroy()
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "onDestroy");
    super.onDestory();
  }
  
  public BaseUpdateBusiness[] registerBusinessCallback()
  {
    return new BaseUpdateBusiness[] { new TroopNickNameBusiness(), new QQValueViewBusiness(), new TestUpdateBusinessV2() };
  }
  
  protected BaseUpdateBusiness registerCommonBusinessCallback()
  {
    return new NativeUpdateBusiness();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.QQVasUpdateManager
 * JD-Core Version:    0.7.0.1
 */