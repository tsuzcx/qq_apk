package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoPlayController$destroyPlayer$1
  extends Lambda
  implements Function0<Unit>
{
  VideoPlayController$destroyPlayer$1(VideoPlayController paramVideoPlayController, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject;
    if (this.this$0.i() != null)
    {
      localObject = this.this$0.i();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((IPlayer)localObject).k();
    }
    this.this$0.a((IPlayer)null);
    VideoPlayController.a(this.this$0, (IPlayerFactory)null);
    this.this$0.a("");
    this.this$0.a((VideoPlayListener)null);
    if (VideoPlayController.c(this.this$0) != null)
    {
      localObject = VideoPlayController.c(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((VideoPluginInstall)localObject).c();
      VideoPlayController.a(this.this$0, (VideoPluginInstall)null);
    }
    this.$runnable.invoke();
    VideoPlayController.d(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.destroyPlayer.1
 * JD-Core Version:    0.7.0.1
 */