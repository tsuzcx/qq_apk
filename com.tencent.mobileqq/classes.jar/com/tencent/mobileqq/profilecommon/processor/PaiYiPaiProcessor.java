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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePaiYiPaiEffect() called with: bytesValue = [");
      localStringBuilder.append(paramByteStringMicro);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiProcessor", 2, localStringBuilder.toString());
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((PaiYiPaiManager)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(s);
  }
  
  private void b(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePaiYiPaiAction() called with: bytesValue = [");
      localStringBuilder.append(paramByteStringMicro);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiProcessor", 2, localStringBuilder.toString());
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((PaiYiPaiManager)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(s);
  }
  
  private void c(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePaiYiPaiSwitch() called with: bytesValue = [");
      localStringBuilder.append(paramByteStringMicro);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiProcessor", 2, localStringBuilder.toString());
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
    if (paramInt != 27390) {
      switch (paramInt)
      {
      default: 
        return;
      case 42434: 
        if (!(this.appRuntime instanceof QQAppInterface)) {
          break;
        }
        b(paramByteStringMicro, (QQAppInterface)this.appRuntime);
        return;
      case 42433: 
        if (!(this.appRuntime instanceof QQAppInterface)) {
          break;
        }
        c(paramByteStringMicro, (QQAppInterface)this.appRuntime);
        return;
      }
    } else if ((this.appRuntime instanceof QQAppInterface)) {
      a(paramByteStringMicro, (QQAppInterface)this.appRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.PaiYiPaiProcessor
 * JD-Core Version:    0.7.0.1
 */