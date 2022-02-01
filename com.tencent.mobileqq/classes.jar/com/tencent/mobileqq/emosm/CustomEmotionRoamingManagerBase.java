package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

public abstract class CustomEmotionRoamingManagerBase<T extends CustomEmotionBase>
  implements IRuntimeService
{
  public static final String TAG = "CustomEmotionRoamingManagerBase";
  protected AtomicBoolean isInSync = new AtomicBoolean(false);
  protected CopyOnWriteArrayList<WeakReference<SyncListener>> listeners = new CopyOnWriteArrayList();
  protected BaseQQAppInterface mApp = null;
  protected String uin;
  
  public void addSyncListener(SyncListener paramSyncListener)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramSyncListener) {
        return;
      }
    }
    paramSyncListener = new WeakReference(paramSyncListener);
    this.listeners.add(paramSyncListener);
  }
  
  protected abstract CustomEmotionRoamingDBManagerBase<T> getDBManager();
  
  protected abstract CustomEmoRoamingBaseHandler<T> getRoamingHandler();
  
  protected abstract int getUploadProcessorID();
  
  public boolean isInSyncing()
  {
    return this.isInSync.compareAndSet(false, true);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    this.uin = this.mApp.getCurrentAccountUin();
  }
  
  public void onDestroy()
  {
    this.listeners.clear();
    this.isInSync.set(false);
  }
  
  public void removeSyncListener(SyncListener paramSyncListener)
  {
    if (paramSyncListener == null) {
      return;
    }
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramSyncListener) {
        this.listeners.remove(localWeakReference);
      }
    }
  }
  
  public void resetSyncState()
  {
    this.isInSync.set(false);
  }
  
  public abstract void syncLocalDel();
  
  public void syncRoaming()
  {
    if (this.mApp == null) {
      return;
    }
    CustomEmoRoamingBaseHandler localCustomEmoRoamingBaseHandler = getRoamingHandler();
    if (localCustomEmoRoamingBaseHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomEmotionRoamingManagerBase", 2, "------------start syncRoaming----------");
      }
      localCustomEmoRoamingBaseHandler.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
 * JD-Core Version:    0.7.0.1
 */