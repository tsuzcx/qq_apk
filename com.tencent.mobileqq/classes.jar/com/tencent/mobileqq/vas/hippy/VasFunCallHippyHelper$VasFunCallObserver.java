package com.tencent.mobileqq.vas.hippy;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

public class VasFunCallHippyHelper$VasFunCallObserver
  extends VipFunCallObserver
{
  Promise jdField_a_of_type_ComTencentMttHippyModulesPromise;
  
  public VasFunCallHippyHelper$VasFunCallObserver(VasFunCallHippyHelper paramVasFunCallHippyHelper) {}
  
  public void a(Promise paramPromise)
  {
    this.jdField_a_of_type_ComTencentMttHippyModulesPromise = paramPromise;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      localObject = (Bundle)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqVasHippyVasFunCallHippyHelper.a(false, 0);
      if (localObject == null)
      {
        QLog.e("VasFunCallHippyHelper", 1, "fcObserver.onUpdate dataBundle=null");
        this.jdField_a_of_type_ComTencentMttHippyModulesPromise.reject("fcObserver.onUpdate dataBundle=null");
        return;
      }
      int i = ((Bundle)localObject).getInt("result", -1);
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMttHippyModulesPromise.reject(VasHippyUtils.a(i, "fcObserver.onUpdate dataBundle is null", null));
        return;
      }
      this.jdField_a_of_type_ComTencentMttHippyModulesPromise.resolve(VasHippyUtils.a(0, "success", paramObject));
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("fcObserver.onUpdate ret=");
        paramObject.append(i);
        paramObject.append(", type=");
        paramObject.append(paramInt);
        paramObject.append(", isSuccess=");
        paramObject.append(paramBoolean);
        QLog.d("VasFunCallHippyHelper", 2, paramObject.toString());
      }
      paramObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramObject == null) {
        return;
      }
      paramObject.removeObserver(this);
      return;
    }
    catch (Exception paramObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fcObserver onUpdate Err:");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e("VasFunCallHippyHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasFunCallHippyHelper.VasFunCallObserver
 * JD-Core Version:    0.7.0.1
 */