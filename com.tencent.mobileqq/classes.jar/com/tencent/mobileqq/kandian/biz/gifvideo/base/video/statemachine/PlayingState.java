package com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine;

import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/statemachine/PlayingState;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/statemachine/VideoState;", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "videoView", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getState", "setState", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getVideoView", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "setVideoView", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;)V", "handleAction", "", "pause", "stop", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PlayingState
  extends VideoState
{
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
  @Nullable
  private VideoView jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  @NotNull
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  @NotNull
  private AtomicInteger b;
  
  public PlayingState(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
    super(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger1;
    this.b = paramAtomicInteger2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView = paramVideoView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController = paramVideoPlayController;
  }
  
  @Nullable
  public VideoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
  }
  
  @Nullable
  public VideoView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  }
  
  @NotNull
  public AtomicInteger a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public void a()
  {
    super.a();
    int i = b().get();
    if (i != 5)
    {
      if (i != 6) {
        return;
      }
      b();
      return;
    }
    c();
  }
  
  @NotNull
  public AtomicInteger b()
  {
    return this.b;
  }
  
  public final void b()
  {
    VideoPlayController localVideoPlayController = a();
    if (localVideoPlayController != null) {
      localVideoPlayController.c((Function0)new PlayingState.stop.1(this));
    }
  }
  
  public final void c()
  {
    VideoPlayController localVideoPlayController = a();
    if (localVideoPlayController != null) {
      localVideoPlayController.d((Function0)new PlayingState.pause.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.PlayingState
 * JD-Core Version:    0.7.0.1
 */