package com.tencent.mobileqq.nearby.now.send.uploader;

import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;

public abstract interface ImageFeedsUploader$UploadListener
{
  public abstract void a(PicFeedUploadInfo paramPicFeedUploadInfo);
  
  public abstract void a(PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult);
  
  public abstract void b(PicFeedUploadInfo paramPicFeedUploadInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.UploadListener
 * JD-Core Version:    0.7.0.1
 */