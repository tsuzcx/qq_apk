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
  private Context a;
  private Handler b;
  private IToolProcStart.Callback c;
  private BroadcastReceiver d;
  private String e;
  
  public PreCallUpToolProc(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Handler(this);
    b();
  }
  
  private void b()
  {
    if (this.d == null)
    {
      this.d = new PreCallUpToolProc.1(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
      this.a.registerReceiver(this.d, localIntentFilter);
    }
  }
  
  private void c()
  {
    BroadcastReceiver localBroadcastReceiver = this.d;
    if (localBroadcastReceiver != null)
    {
      this.a.unregisterReceiver(localBroadcastReceiver);
      this.d = null;
    }
  }
  
  public void a()
  {
    c();
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.b = null;
    }
    this.a = null;
    this.c = null;
  }
  
  public void a(String paramString, long paramLong, IToolProcStart.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("callUpToolProc from=%s", new Object[] { paramString }));
    }
    this.c = paramCallback;
    this.e = paramString;
    paramCallback = new Intent(this.a, ARMapThreadStubReceiver.class);
    paramCallback.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
    paramCallback.putExtra("from", paramString);
    this.a.sendBroadcast(paramCallback);
    paramString = this.b;
    if (paramString != null)
    {
      paramString.removeMessages(108);
      this.b.sendEmptyMessageDelayed(108, paramLong);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 108)
    {
      paramMessage = this.c;
      if (paramMessage != null) {
        paramMessage.a();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.PreCallUpToolProc
 * JD-Core Version:    0.7.0.1
 */