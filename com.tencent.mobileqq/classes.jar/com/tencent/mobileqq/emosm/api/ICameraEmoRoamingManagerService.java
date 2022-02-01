package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ICameraEmoRoamingManagerService
  extends IRuntimeService
{
  public abstract void asyncIncreaseEmotionClickNum(CameraEmotionData paramCameraEmotionData);
  
  public abstract long getFileLength(String paramString);
  
  public abstract Size getImageSize(String paramString);
  
  public abstract boolean getIsNeedShowGuide();
  
  public abstract String getListVersion();
  
  public abstract boolean isShowCameraEmoInApp();
  
  public abstract void realUploadCustomEmoticon(CameraEmotionData paramCameraEmotionData);
  
  public abstract void setIsNeedShowGuide(boolean paramBoolean);
  
  public abstract void syncIncreaseEmoticonExposeNum(CameraEmotionData paramCameraEmotionData);
  
  public abstract void syncLocalDel();
  
  public abstract void syncRoaming();
  
  public abstract void updateListVersion(String paramString);
  
  public abstract void uploadCameraEmo(CameraEmotionData paramCameraEmotionData, ICameraEmoRoamingManagerService.ICameraEmoAddCallBack paramICameraEmoAddCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
 * JD-Core Version:    0.7.0.1
 */