package com.tencent.mobileqq.kandian.biz.ugc.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IRIJUgcVideoPublishService
  extends IRuntimeService
{
  public abstract void addReleaseCallback(@NonNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback);
  
  public abstract void addToDB(UgcVideo paramUgcVideo);
  
  public abstract void addVideoPublishCallback(@NonNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback);
  
  public abstract void addVideoTask(@NonNull UgcVideo paramUgcVideo, boolean paramBoolean);
  
  public abstract void deleteFromDB(UgcVideo paramUgcVideo);
  
  public abstract void getAllUploadStatusVideos(long paramLong, @NonNull IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback paramIGetAllUploadStatusVideosCallback);
  
  public abstract void pauseAllVideoTask();
  
  public abstract void pauseVideoTask(UgcVideo paramUgcVideo);
  
  public abstract void preUploadVideoTask(@NonNull UgcVideo paramUgcVideo, boolean paramBoolean, IRIJUgcVideoPublishService.IUploadVideoStatusCallback paramIUploadVideoStatusCallback);
  
  public abstract void removeReleaseCallback(@NonNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback);
  
  public abstract void removeVideoPublishCallback(@NonNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback);
  
  public abstract void removeVideoTask(UgcVideo paramUgcVideo);
  
  public abstract void updateDB(UgcVideo paramUgcVideo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService
 * JD-Core Version:    0.7.0.1
 */