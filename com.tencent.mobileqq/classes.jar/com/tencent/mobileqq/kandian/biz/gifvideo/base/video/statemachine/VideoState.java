package com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine;

import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/statemachine/VideoState;", "", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "videoView", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getState", "setState", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getVideoView", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "setVideoView", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;)V", "changeToNewState", "", "newState", "", "goToNextState", "handleAction", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public class VideoState
{
  public static final VideoState.Companion a = new VideoState.Companion(null);
  @NotNull
  private AtomicInteger b;
  @NotNull
  private AtomicInteger c;
  @Nullable
  private VideoView d;
  @Nullable
  private VideoPlayController e;
  
  public VideoState(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
    this.b = paramAtomicInteger1;
    this.c = paramAtomicInteger2;
    this.d = paramVideoView;
    this.e = paramVideoPlayController;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = d();
        if (localObject1 != null)
        {
          localObject1 = ((VideoView)localObject1).tag;
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" handleAction curState: ");
          localStringBuilder.append(b());
          localStringBuilder.append(", curAction: ");
          localStringBuilder.append(c());
          QLog.d("VideoState", 1, localStringBuilder.toString());
          if (c().get() == 7)
          {
            localObject1 = e();
            if (localObject1 != null) {
              ((VideoPlayController)localObject1).e((Function0)new VideoState.handleAction.1(this));
            }
            return;
          }
          return;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public final void a(int paramInt)
  {
    int i = b().get();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = d();
    if (localObject != null) {
      localObject = ((VideoView)localObject).tag;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" change state from ");
    localStringBuilder.append(i);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramInt);
    QLog.d("VideoState", 1, localStringBuilder.toString());
    b().set(paramInt);
    h();
    localObject = e();
    if (localObject != null) {
      ((VideoPlayController)localObject).a(i, paramInt);
    }
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
  
  public final void h()
  {
    VideoPlayController localVideoPlayController = e();
    if (localVideoPlayController != null) {
      localVideoPlayController.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.VideoState
 * JD-Core Version:    0.7.0.1
 */