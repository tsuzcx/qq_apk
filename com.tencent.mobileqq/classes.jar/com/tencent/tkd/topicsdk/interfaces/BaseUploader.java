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
  
  public abstract void a();
  
  public final void a(@Nullable IUploadListener paramIUploadListener)
  {
    this.a = paramIUploadListener;
  }
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void b();
  
  public abstract void b(@NotNull String paramString);
  
  public abstract void c();
  
  @Nullable
  public final IUploadListener d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.BaseUploader
 * JD-Core Version:    0.7.0.1
 */