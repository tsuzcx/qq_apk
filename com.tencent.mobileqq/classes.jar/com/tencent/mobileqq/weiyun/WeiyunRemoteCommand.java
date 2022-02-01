package com.tencent.mobileqq.weiyun;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class WeiyunRemoteCommand
  extends RemoteCommand
{
  private static WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand$OnStateChangeListener;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  public WeiyunRemoteCommand()
  {
    super("weiyun.notify_state");
  }
  
  public void a(WeiyunRemoteCommand.OnStateChangeListener paramOnStateChangeListener)
  {
    jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if (i != jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      paramBundle = jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand$OnStateChangeListener;
      if (paramBundle != null) {
        paramBundle.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.WeiyunRemoteCommand
 * JD-Core Version:    0.7.0.1
 */