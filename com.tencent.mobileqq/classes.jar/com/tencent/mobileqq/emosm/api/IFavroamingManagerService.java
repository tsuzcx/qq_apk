package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFavroamingManagerService
  extends IRuntimeService
{
  public abstract void addCustomEmotions(List<String> paramList, IFavroamingManagerService.AddCustomEmotionsCallback paramAddCustomEmotionsCallback);
  
  public abstract void addSyncListener(SyncListener<CustomEmotionData> paramSyncListener);
  
  public abstract void asyncIncreaseEmotionClickNum(CustomEmotionData paramCustomEmotionData);
  
  public abstract void cacheAccessibilityEmotionData();
  
  public abstract void cancelAddCustomEmotions();
  
  public abstract String getAccessibilityDescription(Integer paramInteger);
  
  public abstract int getUploadProcessorID();
  
  public abstract boolean isInSyncing();
  
  public abstract void removeCacheAccessibilityEmotionData(Integer paramInteger);
  
  public abstract void removeSyncListener(SyncListener<CustomEmotionData> paramSyncListener);
  
  public abstract void resetSyncState();
  
  public abstract void syncIncreaseEmoticonExposeNum(CustomEmotionData paramCustomEmotionData);
  
  public abstract void syncLocalDel();
  
  public abstract void syncRoaming();
  
  public abstract TransferRequest syncUpload(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack);
  
  public abstract void syncUpload(CustomEmotionData paramCustomEmotionData);
  
  public abstract void syncUpload(List<CustomEmotionData> paramList);
  
  public abstract void updateCustomEmotionDataOCR(CustomEmotionData paramCustomEmotionData);
  
  public abstract void updateCustomEmotionDataOCRReq(CustomEmotionData paramCustomEmotionData, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IFavroamingManagerService
 * JD-Core Version:    0.7.0.1
 */