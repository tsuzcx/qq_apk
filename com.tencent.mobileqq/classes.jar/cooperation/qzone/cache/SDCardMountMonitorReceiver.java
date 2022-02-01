package cooperation.qzone.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class SDCardMountMonitorReceiver
  extends BroadcastReceiver
{
  private static SDCardMountMonitorReceiver mInstance;
  private boolean canWrite = false;
  private boolean isMountRead = false;
  private boolean isWriteRead = false;
  private boolean mIsRegisteReceiver = false;
  private boolean mIsSDCardMount = false;
  private List<SDCardMountMonitorReceiver.SDCardMountStateListener> observers = new ArrayList();
  
  public static SDCardMountMonitorReceiver getInstance()
  {
    if (mInstance == null) {
      mInstance = new SDCardMountMonitorReceiver();
    }
    return mInstance;
  }
  
  private boolean isCanWrite()
  {
    if (!this.isWriteRead)
    {
      boolean bool;
      if ((Environment.getExternalStorageDirectory().canWrite()) && (CacheManager.isStorageReallyCanwrite(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.canWrite = bool;
      this.isWriteRead = true;
    }
    return this.canWrite;
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      SDCardMountMonitorReceiver.SDCardMountStateListener[] arrayOfSDCardMountStateListener = new SDCardMountMonitorReceiver.SDCardMountStateListener[this.observers.size()];
      this.observers.toArray(arrayOfSDCardMountStateListener);
      int j = arrayOfSDCardMountStateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSDCardMountStateListener[i].onSDCardMountStateChange(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void addListener(SDCardMountMonitorReceiver.SDCardMountStateListener paramSDCardMountStateListener)
  {
    if (paramSDCardMountStateListener == null) {
      return;
    }
    synchronized (this.observers)
    {
      if (!this.observers.contains(paramSDCardMountStateListener)) {
        this.observers.add(paramSDCardMountStateListener);
      }
      return;
    }
  }
  
  public boolean isSDCardCanWrite()
  {
    return (isSDCardMount()) && (isCanWrite());
  }
  
  public boolean isSDCardMount()
  {
    if (!this.isMountRead) {
      try
      {
        this.mIsSDCardMount = "mounted".equals(Environment.getExternalStorageState());
        this.isMountRead = true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getExternalStorageState error:");
        localStringBuilder.append(localException.getMessage());
        QLog.w("CacheManager", 2, localStringBuilder.toString());
      }
    }
    return this.mIsSDCardMount;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.mIsSDCardMount = "mounted".equals(Environment.getExternalStorageState());
    if (this.mIsSDCardMount)
    {
      boolean bool;
      if ((Environment.getExternalStorageDirectory().canWrite()) && (CacheManager.isStorageReallyCanwrite(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.canWrite = bool;
      this.isWriteRead = true;
    }
    this.isMountRead = true;
    CacheManager.onStorageMountChange();
    notifyObservers(this.mIsSDCardMount);
    paramContext = new StringBuilder();
    paramContext.append("SDCardMountMonitorReceiver onReceive mIsSDCardMount:");
    paramContext.append(this.mIsSDCardMount);
    paramContext.append(",canWrite");
    paramContext.append(this.canWrite);
    QLog.i("CacheManager", 1, paramContext.toString());
  }
  
  public void registerReceiver()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      MobileQQ.getContext().registerReceiver(this, localIntentFilter);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.mIsRegisteReceiver = true;
  }
  
  public void removeListener(SDCardMountMonitorReceiver.SDCardMountStateListener paramSDCardMountStateListener)
  {
    synchronized (this.observers)
    {
      this.observers.remove(paramSDCardMountStateListener);
      return;
    }
  }
  
  public void unregisterReceiver()
  {
    SDCardMountMonitorReceiver localSDCardMountMonitorReceiver = mInstance;
    if ((localSDCardMountMonitorReceiver != null) && (localSDCardMountMonitorReceiver.mIsRegisteReceiver == true))
    {
      MobileQQ.getContext().unregisterReceiver(mInstance);
      mInstance.mIsRegisteReceiver = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.cache.SDCardMountMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */