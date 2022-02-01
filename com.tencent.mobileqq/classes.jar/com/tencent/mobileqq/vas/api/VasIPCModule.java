package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class VasIPCModule
  extends QIPCModule
{
  private static VasIPCModule a;
  
  private VasIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static VasIPCModule a()
  {
    try
    {
      if (a == null) {
        a = new VasIPCModule("VasIPCModule");
      }
      VasIPCModule localVasIPCModule = a;
      return localVasIPCModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall action = ");
      localStringBuilder.append(paramString);
      QLog.d("VasIPCModule", 2, localStringBuilder.toString());
    }
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCall missing action = ");
    localStringBuilder.append(paramString);
    QLog.e("VasIPCModule", 1, localStringBuilder.toString());
    return RemoteProxy.a(this, paramString, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.VasIPCModule
 * JD-Core Version:    0.7.0.1
 */