package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.app.CameraEmoImg;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ICameraEmotionRoamingDBManagerService
  extends IRuntimeService
{
  public abstract int getCatchDataCount();
  
  public abstract String getCustomEmoticonPath(CameraEmotionData paramCameraEmotionData);
  
  public abstract List<String> getCustomEmoticonResIdsByType(String paramString);
  
  public abstract List<CameraEmotionData> getEmoticonDataList();
  
  public abstract void insertCustomEmotion(CameraEmotionData paramCameraEmotionData);
  
  public abstract void runInCurrentThread(Runnable paramRunnable, int paramInt);
  
  public abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel();
  
  public abstract void trimCache();
  
  public abstract void updateCustomEmotion(CameraEmotionData paramCameraEmotionData);
  
  public abstract void updateLocalDBFromServer(List<CameraEmoImg> paramList, List<String> paramList1, List<String> paramList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
 * JD-Core Version:    0.7.0.1
 */