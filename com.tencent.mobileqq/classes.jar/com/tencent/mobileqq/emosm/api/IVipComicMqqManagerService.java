package com.tencent.mobileqq.emosm.api;

import android.content.Context;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IVipComicMqqManagerService
  extends IRuntimeService
{
  public abstract void delComicEmoticonList(List<String> paramList);
  
  public abstract VipComicFavorEmoStructMsgInfo getComicStructInfo(String paramString);
  
  public abstract Map<String, VipComicFavorEmoStructMsgInfo> getComicStructInfoMap();
  
  public abstract List<CustomEmotionData> getEmoticonList(List<CustomEmotionData> paramList);
  
  public abstract String getFilePath(String paramString);
  
  public abstract void handleComicEmoticon(Context paramContext, List<CustomEmotionData> paramList, Map<String, VipComicFavorEmoStructMsgInfo> paramMap, IPicDownloadListener paramIPicDownloadListener);
  
  public abstract boolean isComicEmoticon(CustomEmotionData paramCustomEmotionData);
  
  public abstract void saveComicStructInfo(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo);
  
  public abstract void setMyComicEmoticon(List<VipComicFavorEmoStructMsgInfo> paramList, boolean paramBoolean);
  
  public abstract void updateComicStructInfo(List<String> paramList);
  
  public abstract void uploadInitComicEmoStructMsgInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService
 * JD-Core Version:    0.7.0.1
 */