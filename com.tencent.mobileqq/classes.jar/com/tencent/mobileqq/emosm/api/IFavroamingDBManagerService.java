package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFavroamingDBManagerService<T extends CustomEmotionBase>
  extends IRuntimeService
{
  public abstract EmoticonInfo convertEmotionDataToInfo(CustomEmotionData paramCustomEmotionData);
  
  public abstract void delOverflow(List<CustomEmotionData> paramList);
  
  public abstract void deleteCustomEmotion(CustomEmotionData paramCustomEmotionData);
  
  public abstract void deleteCustomEmotionList(List<CustomEmotionData> paramList);
  
  public abstract void deleteDB(List<String> paramList);
  
  public abstract List<CustomEmotionData> findMagicEmosById(String paramString);
  
  public abstract String getCustomEmoticonPath(CustomEmotionData paramCustomEmotionData);
  
  public abstract List<String> getCustomEmoticonResIdsByType(String paramString);
  
  public abstract CustomEmotionData getCustomEmotionDataBYResId(List<CustomEmotionData> paramList, String paramString);
  
  public abstract List<CustomEmotionData> getEmoticonDataList();
  
  public abstract List<CustomEmotionData> getEmoticonDataListFromDB();
  
  public abstract List<T> getEmoticonDatasByType(String paramString);
  
  public abstract CustomEmotionData getEmotionDataByUrl(String paramString);
  
  public abstract List<String> getLocalFavDataNotInServer(List<String> paramList1, List<String> paramList2);
  
  public abstract void insertCustomEmotion(CustomEmotionData paramCustomEmotionData);
  
  public abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel();
  
  public abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview();
  
  public abstract void trimCache();
  
  public abstract void updateCache(CustomEmotionData paramCustomEmotionData, int paramInt);
  
  public abstract void updateCustomEmotion(CustomEmotionData paramCustomEmotionData);
  
  public abstract void updateCustomEmotionDataListInDB(List<CustomEmotionData> paramList, int paramInt);
  
  public abstract boolean updateDeletedEmoticon(CustomEmotionData paramCustomEmotionData, int paramInt);
  
  public abstract List<CustomEmotionData> updateFavEmotionsInLocalEx(List<String> paramList1, List<String> paramList2, String paramString, List<Integer> paramList);
  
  public abstract CustomEmotionData updateUpload(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
 * JD-Core Version:    0.7.0.1
 */