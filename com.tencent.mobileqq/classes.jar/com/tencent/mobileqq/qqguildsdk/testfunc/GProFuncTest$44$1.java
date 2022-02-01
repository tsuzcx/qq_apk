package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$44$1
  implements ILoadUserProfileInfoCallback
{
  GProFuncTest$44$1(GProFuncTest.44 param44) {}
  
  public void onLoadUserProfileInfo(int paramInt, String paramString, IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" result : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg :");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    GProFuncTest.a(this.a.b, paramIGProUserProfileInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.44.1
 * JD-Core Version:    0.7.0.1
 */