package com.tencent.mobileqq.uftransfer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

public class UFTLogicThread
{
  private static UFTLogicThread jdField_a_of_type_ComTencentMobileqqUftransferUFTLogicThread;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  private UFTLogicThread()
  {
    a();
  }
  
  public static UFTLogicThread a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUftransferUFTLogicThread == null) {
        jdField_a_of_type_ComTencentMobileqqUftransferUFTLogicThread = new UFTLogicThread();
      } else {
        jdField_a_of_type_ComTencentMobileqqUftransferUFTLogicThread.a();
      }
      UFTLogicThread localUFTLogicThread = jdField_a_of_type_ComTencentMobileqqUftransferUFTLogicThread;
      return localUFTLogicThread;
    }
    finally {}
  }
  
  private void a()
  {
    try
    {
      HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
      if (localHandlerThread != null) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("UFTTransferLogicThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      UFTLog.b("[UFTTransfer] UFTLogicThread", 1, "transfer logicThread start...");
      return;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Thread.currentThread() != this.jdField_a_of_type_AndroidOsHandler.getLooper().getThread())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.UFTLogicThread
 * JD-Core Version:    0.7.0.1
 */