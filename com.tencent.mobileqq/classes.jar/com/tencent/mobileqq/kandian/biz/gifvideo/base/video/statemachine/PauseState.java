package com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine;

import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/statemachine/PauseState;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/statemachine/VideoState;", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "videoView", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getState", "setState", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getVideoView", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "setVideoView", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;)V", "handleAction", "", "resume", "stop", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PauseState
  extends VideoState
{
  @NotNull
  private AtomicInteger b;
  @NotNull
  private AtomicInteger c;
  @Nullable
  private VideoView d;
  @Nullable
  private VideoPlayController e;
  
  public PauseState(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
    super(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    this.b = paramAtomicInteger1;
    this.c = paramAtomicInteger2;
    this.d = paramVideoView;
    this.e = paramVideoPlayController;
  }
  
  public void a()
  {
    super.a();
    int i = c().get();
    if (i != 3) {
      if (i != 4)
      {
        if (i != 6)
        {
          if (i == 8) {}
        }
        else {
          g();
        }
      }
      else
      {
        f();
        return;
      }
    }
    f();
  }
  
  @NotNull
  public AtomicInteger b()
  {
    return this.b;
  }
  
  @NotNull
  public AtomicInteger c()
  {
    return this.c;
  }
  
  @Nullable
  public VideoView d()
  {
    return this.d;
  }
  
  @Nullable
  public VideoPlayController e()
  {
    return this.e;
  }
  
  public final void f()
  {
    VideoPlayController localVideoPlayController = e();
    if (localVideoPlayController != null) {
      localVideoPlayController.b((Function0)new PauseState.resume.1(this));
    }
  }
  
  public final void g()
  {
    VideoPlayController localVideoPlayController = e();
    if (localVideoPlayController != null) {
      localVideoPlayController.c((Function0)new PauseState.stop.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.PauseState
 * JD-Core Version:    0.7.0.1
 */