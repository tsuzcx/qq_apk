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
  public static final VideoState.Companion a;
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
  @Nullable
  private VideoView jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  @NotNull
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  @NotNull
  private AtomicInteger b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoStatemachineVideoState$Companion = new VideoState.Companion(null);
  }
  
  public VideoState(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
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
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((VideoView)localObject1).tag;
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" handleAction curState: ");
          localStringBuilder.append(a());
          localStringBuilder.append(", curAction: ");
          localStringBuilder.append(b());
          QLog.d("VideoState", 1, localStringBuilder.toString());
          if (b().get() == 7)
          {
            localObject1 = a();
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
    int i = a().get();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = a();
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
    a().set(paramInt);
    d();
    localObject = a();
    if (localObject != null) {
      ((VideoPlayController)localObject).a(i, paramInt);
    }
  }
  
  @NotNull
  public AtomicInteger b()
  {
    return this.b;
  }
  
  public final void d()
  {
    VideoPlayController localVideoPlayController = a();
    if (localVideoPlayController != null) {
      localVideoPlayController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.VideoState
 * JD-Core Version:    0.7.0.1
 */