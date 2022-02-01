package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class PaiYiPaiProcessor
  extends AbsProfileCommonProcessor
{
  public PaiYiPaiProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiProcessor", 2, "handlePaiYiPaiEffect() called with: bytesValue = [" + paramByteStringMicro + "]");
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((PaiYiPaiManager)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(s);
  }
  
  private void b(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiProcessor", 2, "handlePaiYiPaiAction() called with: bytesValue = [" + paramByteStringMicro + "]");
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((PaiYiPaiManager)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(s);
  }
  
  private void c(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiProcessor", 2, "handlePaiYiPaiSwitch() called with: bytesValue = [" + paramByteStringMicro + "]");
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((PaiYiPaiManager)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a(s);
  }
  
  public String getProcessorKey()
  {
    return "PaiYiPaiProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return (paramInt == 42433) || (paramInt == 42434) || (paramInt == 27390);
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(this.appRuntime instanceof QQAppInterface));
        c(paramByteStringMicro, (QQAppInterface)this.appRuntime);
        return;
      } while (!(this.appRuntime instanceof QQAppInterface));
      b(paramByteStringMicro, (QQAppInterface)this.appRuntime);
      return;
    } while (!(this.appRuntime instanceof QQAppInterface));
    a(paramByteStringMicro, (QQAppInterface)this.appRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.PaiYiPaiProcessor
 * JD-Core Version:    0.7.0.1
 */