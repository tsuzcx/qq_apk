package com.tencent.mobileqq.qrscan.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.qrscan.IToolProcStart;
import com.tencent.mobileqq.qrscan.IToolProcStart.Callback;
import com.tencent.qphone.base.util.QLog;

public class PreCallUpToolProc
  implements Handler.Callback, IToolProcStart
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IToolProcStart.Callback jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart$Callback;
  private String jdField_a_of_type_JavaLangString;
  
  public PreCallUpToolProc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PreCallUpToolProc.1(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void c()
  {
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(localBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void a()
  {
    c();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart$Callback = null;
  }
  
  public void a(String paramString, long paramLong, IToolProcStart.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("callUpToolProc from=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart$Callback = paramCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramCallback = new Intent(this.jdField_a_of_type_AndroidContentContext, ARMapThreadStubReceiver.class);
    paramCallback.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
    paramCallback.putExtra("from", paramString);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramCallback);
    paramString = this.jdField_a_of_type_AndroidOsHandler;
    if (paramString != null)
    {
      paramString.removeMessages(108);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(108, paramLong);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 108)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart$Callback;
      if (paramMessage != null) {
        paramMessage.a();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.PreCallUpToolProc
 * JD-Core Version:    0.7.0.1
 */