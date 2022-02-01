package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class TempSettingProcessor
  extends AbsProfileCommonProcessor
{
  public TempSettingProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(int paramInt, ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTempSettingInBoxSwitch() called with: type = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bytesValue = [");
      localStringBuilder.append(paramByteStringMicro);
      localStringBuilder.append("]");
      QLog.d("TempSettingProcessor", 2, localStringBuilder.toString());
    }
    paramByteStringMicro = paramByteStringMicro.toByteArray();
    int i = paramByteStringMicro.length;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 1) {
      i = (short)paramByteStringMicro[0];
    } else {
      i = ByteBuffer.wrap(paramByteStringMicro).asShortBuffer().get();
    }
    paramByteStringMicro = (TempMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
    if (paramInt == 45079)
    {
      bool1 = bool2;
      if (i != 1) {
        bool1 = true;
      }
      boolean bool3 = paramByteStringMicro.b((short)paramInt);
      bool2 = bool1;
      bool1 = bool3;
    }
    else
    {
      bool2 = paramByteStringMicro.a((short)paramInt);
      if (i == 1) {
        bool1 = true;
      }
    }
    paramByteStringMicro.a((short)paramInt, false, "", bool2, bool1);
  }
  
  public String getProcessorKey()
  {
    return "TempSettingProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return (paramInt == 45079) || (paramInt == 45075) || (paramInt == 45076) || (paramInt == 45077);
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    switch (paramInt)
    {
    case 45078: 
    case 45080: 
    default: 
      return;
    }
    if ((this.appRuntime instanceof QQAppInterface)) {
      a(paramInt, paramByteStringMicro, (QQAppInterface)this.appRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.TempSettingProcessor
 * JD-Core Version:    0.7.0.1
 */