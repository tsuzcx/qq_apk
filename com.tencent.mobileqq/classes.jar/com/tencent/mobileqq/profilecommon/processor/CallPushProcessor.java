package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class CallPushProcessor
  extends AbsProfileCommonProcessor
{
  public CallPushProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "CallPushProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return paramInt == 27393;
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 27393)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CallPushProcessor", 2, "call_push ok");
      }
      if ((this.appRuntime instanceof QQAppInterface)) {
        ((VipSetFunCallHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).a(1, new Bundle(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.CallPushProcessor
 * JD-Core Version:    0.7.0.1
 */