package com.tencent.mobileqq.kandian.biz.ugc.upload;

import org.jetbrains.annotations.NotNull;

public abstract interface IVideoUploadListener<R>
{
  public abstract void a(int paramInt, @NotNull String paramString);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(R paramR);
  
  public abstract void a(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.IVideoUploadListener
 * JD-Core Version:    0.7.0.1
 */