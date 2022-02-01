package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgBackupTransportExecutor
{
  private static MsgBackupTransportExecutor jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportExecutor;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private MsgBackupTransportExecutor()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.corePoolsize = i;
      localThreadPoolParams.maxPooolSize = i;
      localThreadPoolParams.priority = 5;
      localThreadPoolParams.poolThreadName = "msgbackup_Tranport_Executor";
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    }
  }
  
  public static MsgBackupTransportExecutor a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportExecutor == null) {
        jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportExecutor = new MsgBackupTransportExecutor();
      }
      MsgBackupTransportExecutor localMsgBackupTransportExecutor = jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportExecutor;
      return localMsgBackupTransportExecutor;
    }
    finally {}
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgbackup destroy-------------> destroyed = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    MsgBackupUtil.a("MsgBackupMsgBackupTransportExecutor", localStringBuilder.toString(), new Object[0]);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(Runnable paramRunnable)
  {
    Executor localExecutor = this.jdField_a_of_type_JavaUtilConcurrentExecutor;
    if (localExecutor == null)
    {
      MsgBackupUtil.a("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
      return;
    }
    localExecutor.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportExecutor
 * JD-Core Version:    0.7.0.1
 */