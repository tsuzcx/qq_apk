package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub1;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginRemoteProcessor
{
  private static PluginRemoteProcessor sInstance;
  private Handler mHandler;
  private volatile boolean mProcessing;
  private LinkedList<PluginRemoteProcessor.WrappedServiceConnection> mQueue = new LinkedList();
  
  private PluginRemoteProcessor()
  {
    Object localObject = IPluginAdapterProxy.getProxy();
    Looper localLooper = null;
    if (localObject != null) {
      localLooper = ((IPluginAdapterProxy)localObject).getSubThreadLooper();
    }
    localObject = localLooper;
    if (localLooper == null) {
      localObject = Looper.getMainLooper();
    }
    this.mHandler = new Handler((Looper)localObject);
  }
  
  public static PluginRemoteProcessor get()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new PluginRemoteProcessor();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void processInner(PluginRemoteProcessor.WrappedServiceConnection paramWrappedServiceConnection)
  {
    Object localObject = null;
    switch (PluginRemoteProcessor.WrappedServiceConnection.access$200(paramWrappedServiceConnection))
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "processInner, " + paramWrappedServiceConnection + ", " + localObject);
      }
      if (localObject != null) {
        break;
      }
      return;
      localObject = PluginRemoteService.Sub1.class;
      continue;
      localObject = PluginRemoteService.Sub2.class;
    }
    Context localContext = PluginRemoteProcessor.WrappedServiceConnection.access$100(paramWrappedServiceConnection).getApplicationContext();
    Intent localIntent = new Intent(localContext, (Class)localObject);
    localIntent.putExtra("key_binder_type", PluginRemoteProcessor.WrappedServiceConnection.access$200(paramWrappedServiceConnection));
    try
    {
      localContext.bindService(localIntent, paramWrappedServiceConnection, 1);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.i("plugin_tag", 1, "processInner", localSecurityException);
      paramWrappedServiceConnection.onServiceDisconnected(new ComponentName(PluginRemoteProcessor.WrappedServiceConnection.access$100(paramWrappedServiceConnection), ((Class)localObject).getCanonicalName()));
    }
  }
  
  private void processInnerDelay(PluginRemoteProcessor.WrappedServiceConnection paramWrappedServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "processInnerDelay. " + paramInt + ", " + paramWrappedServiceConnection);
    }
    this.mHandler.postDelayed(new PluginRemoteProcessor.1(this, paramWrappedServiceConnection), paramInt);
  }
  
  public void cancel(ServiceConnection paramServiceConnection)
  {
    synchronized (this.mQueue)
    {
      Iterator localIterator = this.mQueue.iterator();
      for (;;)
      {
        PluginRemoteProcessor.WrappedServiceConnection localWrappedServiceConnection;
        if (localIterator.hasNext()) {
          localWrappedServiceConnection = (PluginRemoteProcessor.WrappedServiceConnection)localIterator.next();
        }
        try
        {
          if (PluginRemoteProcessor.WrappedServiceConnection.access$000(localWrappedServiceConnection) != paramServiceConnection) {
            continue;
          }
          PluginRemoteProcessor.WrappedServiceConnection.access$100(localWrappedServiceConnection).unbindService(localWrappedServiceConnection);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new PluginRemoteProcessor.WrappedServiceConnection(this, paramServiceConnection, ???, paramInt);
    if (this.mProcessing)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "queue");
      }
      synchronized (this.mQueue)
      {
        this.mQueue.offer(paramServiceConnection);
        return;
      }
    }
    this.mProcessing = true;
    processInnerDelay(paramServiceConnection, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor
 * JD-Core Version:    0.7.0.1
 */