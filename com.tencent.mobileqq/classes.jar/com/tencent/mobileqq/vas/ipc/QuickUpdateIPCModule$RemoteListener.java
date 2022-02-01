package com.tencent.mobileqq.vas.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.mobileqq.vas.aidl.IDownloadListener;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;

class QuickUpdateIPCModule$RemoteListener
  implements IBinder.DeathRecipient, QuickUpdateListener
{
  private long bid;
  private IDownloadListener listener;
  private String scid;
  
  private QuickUpdateIPCModule$RemoteListener(long paramLong, String paramString, IDownloadListener paramIDownloadListener)
  {
    this.bid = paramLong;
    this.scid = paramString;
    this.listener = paramIDownloadListener;
    try
    {
      paramIDownloadListener.asBinder().linkToDeath(this, 0);
      return;
    }
    catch (RemoteException paramString)
    {
      paramIDownloadListener = new StringBuilder();
      paramIDownloadListener.append("linkToDeath fail: ");
      paramIDownloadListener.append(this);
      QLog.e("QuickUpdateIPCModule", 1, paramIDownloadListener.toString(), paramString);
    }
  }
  
  public void binderDied()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("binderDied: ");
    localStringBuilder.append(this);
    QLog.e("QuickUpdateIPCModule", 1, localStringBuilder.toString());
    UpdateCallbackSelector.getCallback(this.bid).removeListener(this.bid, this.scid, this);
  }
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("onCompleted: ");
    paramString2.append(paramInt1);
    paramString2.append(", ");
    paramString2.append(this);
    QLog.e("QuickUpdateIPCModule", 1, paramString2.toString());
    try
    {
      this.listener.onComplete(paramString1, paramInt1);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("onCompleted: ");
      paramString2.append(this);
      QLog.e("QuickUpdateIPCModule", 1, paramString2.toString(), paramString1);
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    try
    {
      this.listener.onProgress(paramString1, paramLong2, paramLong3);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("onProgress: ");
      paramString2.append(this);
      QLog.e("QuickUpdateIPCModule", 1, paramString2.toString(), paramString1);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.bid);
    localStringBuilder.append("_");
    localStringBuilder.append(this.scid);
    localStringBuilder.append(",");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule.RemoteListener
 * JD-Core Version:    0.7.0.1
 */