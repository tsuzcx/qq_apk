package com.tencent.mobileqq.kandian.base.video.player.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;", "", "onCaptureImageFailed", "", "player", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "id", "", "errCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onDownloadCallback", "downloadedSizeBytes", "", "totalSizeBytes", "info", "", "onError", "", "module", "errorType", "errorCode", "extraInfo", "onInfo", "what", "extra", "onSeekComplete", "onVideoPrepared", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEventListener
{
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(@NotNull IPlayer paramIPlayer);
  
  public abstract void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2);
  
  public abstract void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap);
  
  public abstract boolean a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString);
  
  public abstract boolean a(@NotNull IPlayer paramIPlayer, int paramInt, @Nullable Object paramObject);
  
  public abstract void b(@NotNull IPlayer paramIPlayer);
  
  public abstract void c(@NotNull IPlayer paramIPlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.api.IEventListener
 * JD-Core Version:    0.7.0.1
 */