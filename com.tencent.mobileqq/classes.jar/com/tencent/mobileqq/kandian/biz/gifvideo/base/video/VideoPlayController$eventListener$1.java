package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.video.player.api.IEventListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.VideoState;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.VideoState.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$eventListener$1", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;", "onCaptureImageFailed", "", "player", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "id", "", "errCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onDownloadCallback", "downloadedSizeBytes", "", "totalSizeBytes", "info", "", "onError", "", "module", "errorType", "errorCode", "extraInfo", "onInfo", "what", "extra", "", "onSeekComplete", "onVideoPrepared", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayController$eventListener$1
  implements IEventListener
{
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(@NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    VideoState.a.a(this.a.a(), this.a.b(), this.a.a(), this.a).a(6);
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    VideoPlayController.a(this.a, paramInt1, paramInt2, paramInt3);
    return false;
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    this.a.f((Function0)new VideoPlayController.eventListener.1.onInfo.1(this, paramInt));
    return false;
  }
  
  public void b(@NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    VideoState.a.a(this.a.a(), this.a.b(), this.a.a(), this.a).a(10);
  }
  
  public void c(@NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    if (this.a.b())
    {
      paramIPlayer = this.a.a();
      if (paramIPlayer != null) {
        paramIPlayer.a();
      }
      paramIPlayer = this.a.a();
      if (paramIPlayer != null) {
        paramIPlayer.onSeekComplete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.eventListener.1
 * JD-Core Version:    0.7.0.1
 */