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
    Object localObject1 = IPluginAdapterProxy.getProxy();
    if (localObject1 != null) {
      localObject1 = ((IPluginAdapterProxy)localObject1).getSubThreadLooper();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Looper.getMainLooper();
    }
    this.mHandler = new Handler((Looper)localObject2);
  }
  
  public static PluginRemoteProcessor get()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new PluginRemoteProcessor();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void processInner(PluginRemoteProcessor.WrappedServiceConnection paramWrappedServiceConnection)
  {
    int i = PluginRemoteProcessor.WrappedServiceConnection.access$200(paramWrappedServiceConnection);
    Object localObject1;
    if (i != 0)
    {
      if (i != 1) {
        localObject1 = null;
      } else {
        localObject1 = PluginRemoteService.Sub2.class;
      }
    }
    else {
      localObject1 = PluginRemoteService.Sub1.class;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processInner, ");
      ((StringBuilder)localObject2).append(paramWrappedServiceConnection);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("plugin_tag", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = PluginRemoteProcessor.WrappedServiceConnection.access$100(paramWrappedServiceConnection).getApplicationContext();
    Intent localIntent = new Intent((Context)localObject2, (Class)localObject1);
    localIntent.putExtra("key_binder_type", PluginRemoteProcessor.WrappedServiceConnection.access$200(paramWrappedServiceConnection));
    try
    {
      ((Context)localObject2).bindService(localIntent, paramWrappedServiceConnection, 1);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.i("plugin_tag", 1, "processInner", localSecurityException);
      paramWrappedServiceConnection.onServiceDisconnected(new ComponentName(PluginRemoteProcessor.WrappedServiceConnection.access$100(paramWrappedServiceConnection), ((Class)localObject1).getCanonicalName()));
    }
  }
  
  private void processInnerDelay(PluginRemoteProcessor.WrappedServiceConnection paramWrappedServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processInnerDelay. ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramWrappedServiceConnection);
      QLog.i("plugin_tag", 2, localStringBuilder.toString());
    }
    this.mHandler.postDelayed(new PluginRemoteProcessor.1(this, paramWrappedServiceConnection), paramInt);
  }
  
  public void cancel(ServiceConnection paramServiceConnection)
  {
    synchronized (this.mQueue)
    {
      Iterator localIterator = this.mQueue.iterator();
      while (localIterator.hasNext())
      {
        PluginRemoteProcessor.WrappedServiceConnection localWrappedServiceConnection = (PluginRemoteProcessor.WrappedServiceConnection)localIterator.next();
        try
        {
          if (PluginRemoteProcessor.WrappedServiceConnection.access$000(localWrappedServiceConnection) == paramServiceConnection) {
            PluginRemoteProcessor.WrappedServiceConnection.access$100(localWrappedServiceConnection).unbindService(localWrappedServiceConnection);
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramServiceConnection;
    }
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginRemoteProcessor.process, ");
      localStringBuilder.append(paramInt);
      QLog.i("plugin_tag", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor
 * JD-Core Version:    0.7.0.1
 */