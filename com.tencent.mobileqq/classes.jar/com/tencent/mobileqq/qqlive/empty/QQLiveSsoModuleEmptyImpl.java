package com.tencent.mobileqq.qqlive.empty;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQLiveSsoModuleEmptyImpl
  implements IQQLiveSsoModule
{
  private void a(int paramInt, QQLiveBusinessObserver paramQQLiveBusinessObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleCallback, notifyType:");
    localStringBuilder.append(paramInt);
    QLog.e("QQLiveSsoModuleEmptyImpl", 1, localStringBuilder.toString());
    if (paramQQLiveBusinessObserver == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new -..Lambda.QQLiveSsoModuleEmptyImpl.FqpuIuza8rELr3hpkaUpQZoozJw(paramQQLiveBusinessObserver, paramInt));
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, QQLiveBusinessObserver paramQQLiveBusinessObserver)
  {
    a(paramInt, paramQQLiveBusinessObserver);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, QQLiveBusinessObserver paramQQLiveBusinessObserver)
  {
    a(0, paramQQLiveBusinessObserver);
  }
  
  public void destroy() {}
  
  public void init(IQQLiveSDK paramIQQLiveSDK) {}
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.empty.QQLiveSsoModuleEmptyImpl
 * JD-Core Version:    0.7.0.1
 */