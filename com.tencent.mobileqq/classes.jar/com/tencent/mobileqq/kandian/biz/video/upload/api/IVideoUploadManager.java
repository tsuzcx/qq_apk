package com.tencent.mobileqq.kandian.biz.video.upload.api;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/upload/api/IVideoUploadManager;", "", "setTroopMemberApiService", "", "service", "Ljava/lang/Object;", "startUpload", "filePath", "", "data", "Landroid/os/Bundle;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoUploadManager
{
  public abstract void a(@Nullable Object paramObject);
  
  public abstract void a(@Nullable String paramString, @Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.upload.api.IVideoUploadManager
 * JD-Core Version:    0.7.0.1
 */