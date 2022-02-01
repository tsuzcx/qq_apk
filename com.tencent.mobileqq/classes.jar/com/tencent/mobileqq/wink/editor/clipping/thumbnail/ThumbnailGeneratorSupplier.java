package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorSupplier;", "", "generatedListener", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "thumbnailWidth", "", "thumbnailHeight", "generateHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;IILcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;)V", "getGenerateHandler", "()Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;", "getGeneratedListener", "()Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "getThumbnailHeight", "()I", "getThumbnailWidth", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailGeneratorSupplier
{
  @NotNull
  private final IThumbnailGeneratedListener a;
  private final int b;
  private final int c;
  @NotNull
  private final IRunnableHandler d;
  
  public ThumbnailGeneratorSupplier(@NotNull IThumbnailGeneratedListener paramIThumbnailGeneratedListener, int paramInt1, int paramInt2, @NotNull IRunnableHandler paramIRunnableHandler)
  {
    this.a = paramIThumbnailGeneratedListener;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramIRunnableHandler;
  }
  
  @NotNull
  public final IThumbnailGeneratedListener a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  @NotNull
  public final IRunnableHandler d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailGeneratorSupplier
 * JD-Core Version:    0.7.0.1
 */