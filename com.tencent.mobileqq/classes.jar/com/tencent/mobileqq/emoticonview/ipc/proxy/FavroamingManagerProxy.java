package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;

public class FavroamingManagerProxy
  extends AbsManagerProxy<FavroamingManager>
{
  public static final String TAG = "FavroamingManagerProxy";
  
  public FavroamingManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.FAV_ROAMING_MANAGER);
  }
  
  public void addSyncListener(SyncListener<CustomEmotionData> paramSyncListener)
  {
    if (this.manager != null) {
      ((FavroamingManager)this.manager).a(paramSyncListener);
    }
  }
  
  public void cacheAccessibilityEmotionData()
  {
    if (this.manager != null) {
      ((FavroamingManager)this.manager).h();
    }
  }
  
  public CharSequence getAccessibilityDescription(int paramInt)
  {
    if (this.manager != null) {
      return ((FavroamingManager)this.manager).a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean isInSyncing()
  {
    if (this.manager != null) {
      return ((FavroamingManager)this.manager).a();
    }
    return false;
  }
  
  public void removeSyncListener(SyncListener<CustomEmotionData> paramSyncListener)
  {
    if (this.manager != null) {
      ((FavroamingManager)this.manager).b(paramSyncListener);
    }
  }
  
  public void syncLocalDel()
  {
    if (this.manager != null) {
      ((FavroamingManager)this.manager).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerProxy
 * JD-Core Version:    0.7.0.1
 */