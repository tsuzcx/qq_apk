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
  Promise a;
  
  public VasFunCallHippyHelper$VasFunCallObserver(VasFunCallHippyHelper paramVasFunCallHippyHelper) {}
  
  public void a(Promise paramPromise)
  {
    this.a = paramPromise;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      localObject = (Bundle)paramObject;
      this.b.a(false, 0);
      if (localObject == null)
      {
        QLog.e("VasFunCallHippyHelper", 1, "fcObserver.onUpdate dataBundle=null");
        this.a.reject("fcObserver.onUpdate dataBundle=null");
        return;
      }
      int i = ((Bundle)localObject).getInt("result", -1);
      if (i != 0)
      {
        this.a.reject(VasHippyUtils.a(i, "fcObserver.onUpdate dataBundle is null", null));
        return;
      }
      this.a.resolve(VasHippyUtils.a(0, "success", paramObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasFunCallHippyHelper.VasFunCallObserver
 * JD-Core Version:    0.7.0.1
 */