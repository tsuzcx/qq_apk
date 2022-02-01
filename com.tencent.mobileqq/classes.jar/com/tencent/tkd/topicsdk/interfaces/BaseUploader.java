package com.tencent.tkd.topicsdk.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseUploader
{
  @Nullable
  private IUploadListener a;
  
  public BaseUploader a(BaseUploader.UploaderType paramUploaderType)
  {
    return this;
  }
  
  @Nullable
  public final IUploadListener a()
  {
    return this.a;
  }
  
  public abstract void a();
  
  public final void a(@Nullable IUploadListener paramIUploadListener)
  {
    this.a = paramIUploadListener;
  }
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void b();
  
  public abstract void b(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.BaseUploader
 * JD-Core Version:    0.7.0.1
 */