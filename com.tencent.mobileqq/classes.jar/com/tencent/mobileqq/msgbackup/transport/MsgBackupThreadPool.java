package com.tencent.mobileqq.msgbackup.transport;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;

@Deprecated
public class MsgBackupThreadPool
{
  private static short jdField_a_of_type_Short = 0;
  private static boolean jdField_a_of_type_Boolean = false;
  private Handler[] jdField_a_of_type_ArrayOfAndroidOsHandler;
  private HandlerThread[] jdField_a_of_type_ArrayOfAndroidOsHandlerThread;
  
  private MsgBackupThreadPool()
  {
    MsgBackupUtil.a("MsgBackupMsgBackupThreadPool", "MsgBackupThreadPool constructor--------->", new Object[0]);
    jdField_a_of_type_Boolean = true;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfAndroidOsHandlerThread = new HandlerThread[5];
    this.jdField_a_of_type_ArrayOfAndroidOsHandler = new Handler[5];
    int i = 0;
    while (i < 5)
    {
      this.jdField_a_of_type_ArrayOfAndroidOsHandlerThread[i] = new HandlerThread("msgbackup_thread_" + i);
      this.jdField_a_of_type_ArrayOfAndroidOsHandlerThread[i].start();
      this.jdField_a_of_type_ArrayOfAndroidOsHandler[i] = new Handler(this.jdField_a_of_type_ArrayOfAndroidOsHandlerThread[i].getLooper());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupThreadPool
 * JD-Core Version:    0.7.0.1
 */