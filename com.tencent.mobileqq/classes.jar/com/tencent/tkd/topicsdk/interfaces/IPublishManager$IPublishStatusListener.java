package com.tencent.tkd.topicsdk.interfaces;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishStatusListener;", "", "onFailedStatus", "", "onPauseStatus", "onProgress", "progress", "", "speed", "", "uploadedSize", "", "fileSize", "onUploadSuccessStatus", "onUploadVideoCoverSuccessStatus", "coverUrl", "onUploadingStatus", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublishManager$IPublishStatusListener
{
  public abstract void a();
  
  public abstract void a(int paramInt, @NotNull String paramString, long paramLong1, long paramLong2);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishStatusListener
 * JD-Core Version:    0.7.0.1
 */