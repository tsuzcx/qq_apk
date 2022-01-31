package cooperation.weiyun;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class WeiyunRemoteCommand
  extends RemoteCommand
{
  private static WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  public WeiyunRemoteCommand()
  {
    super("weiyun.notify_state");
  }
  
  public int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void a(WeiyunRemoteCommand.OnStateChangeListener paramOnStateChangeListener)
  {
    jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if (i != jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      if (jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener != null) {
        jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.WeiyunRemoteCommand
 * JD-Core Version:    0.7.0.1
 */