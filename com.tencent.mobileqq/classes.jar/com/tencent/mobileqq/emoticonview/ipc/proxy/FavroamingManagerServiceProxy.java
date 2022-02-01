package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;

public class FavroamingManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<IFavroamingManagerService>
{
  public static final String TAG = "FavroamingManagerServiceProxy";
  
  public FavroamingManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IFavroamingManagerService.class);
  }
  
  public void addSyncListener(SyncListener<CustomEmotionData> paramSyncListener)
  {
    if (this.manager != null) {
      ((IFavroamingManagerService)this.manager).addSyncListener(paramSyncListener);
    }
  }
  
  public void cacheAccessibilityEmotionData()
  {
    if (this.manager != null) {
      ((IFavroamingManagerService)this.manager).cacheAccessibilityEmotionData();
    }
  }
  
  public CharSequence getAccessibilityDescription(int paramInt)
  {
    if (this.manager != null) {
      return ((IFavroamingManagerService)this.manager).getAccessibilityDescription(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean isInSyncing()
  {
    if (this.manager != null) {
      return ((IFavroamingManagerService)this.manager).isInSyncing();
    }
    return false;
  }
  
  public void removeSyncListener(SyncListener<CustomEmotionData> paramSyncListener)
  {
    if (this.manager != null) {
      ((IFavroamingManagerService)this.manager).removeSyncListener(paramSyncListener);
    }
  }
  
  public void syncLocalDel()
  {
    if (this.manager != null) {
      ((IFavroamingManagerService)this.manager).syncLocalDel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */