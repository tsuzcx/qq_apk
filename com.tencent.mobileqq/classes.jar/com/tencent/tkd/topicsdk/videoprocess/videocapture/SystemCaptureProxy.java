package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import androidx.annotation.RequiresApi;
import com.tencent.tkd.topicsdk.common.MmrExtensionsKt;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SystemCaptureProxy;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "isForCapture", "", "(Z)V", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "duration", "", "height", "mediaPlayer", "Landroid/media/MediaPlayer;", "metadataRetriever", "Landroid/media/MediaMetadataRetriever;", "onPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "preparedListenerSet", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "released", "seekCompleteListener", "useScaleAPI", "videoDuration", "", "getVideoDuration", "()J", "videoView", "Landroid/widget/VideoView;", "width", "addCapturePreparedListener", "", "listener", "capture", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "captureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "getFrameAtTime", "Landroid/graphics/Bitmap;", "option", "getScaleFrameAtTime", "getVideoValue", "key", "init", "containerView", "Landroid/view/ViewGroup;", "notifyListeners", "onSeekComplete", "prepare", "release", "seek", "position", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SystemCaptureProxy
  implements MediaPlayer.OnSeekCompleteListener, ICaptureProxy
{
  public static final SystemCaptureProxy.Companion a;
  private int jdField_a_of_type_Int;
  private final MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private MediaPlayer.OnPreparedListener jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener;
  private MediaPlayer.OnSeekCompleteListener jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private VideoView jdField_a_of_type_AndroidWidgetVideoView;
  private VideoCaptureView.CaptureVideoInfo jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
  private final Set<CapturePreparedListener> jdField_a_of_type_JavaUtilSet;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureSystemCaptureProxy$Companion = new SystemCaptureProxy.Companion(null);
  }
  
  public SystemCaptureProxy()
  {
    this(false, 1, null);
  }
  
  public SystemCaptureProxy(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
    this.jdField_a_of_type_JavaUtilSet = ((Set)new HashSet());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener = ((MediaPlayer.OnPreparedListener)new SystemCaptureProxy.onPreparedListener.1(this));
  }
  
  private final int a(int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.extractMetadata(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "metadataRetriever.extractMetadata(key)");
    return Integer.parseInt(str);
  }
  
  @RequiresApi(27)
  private final Bitmap a(int paramInt, CaptureTask paramCaptureTask)
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getScaledFrameAtTime(paramCaptureTask.a() * 1000, paramInt, paramCaptureTask.b(), paramCaptureTask.c());
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFrameAtTime failed for captureTask, ");
      localStringBuilder.append(paramCaptureTask);
      localStringBuilder.append(", ");
      localStringBuilder.append(localThrowable);
      TLog.d("SystemCaptureProxy", localStringBuilder.toString());
    }
    return null;
  }
  
  private final Bitmap b(int paramInt, CaptureTask paramCaptureTask)
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getFrameAtTime(paramCaptureTask.a() * 1000, paramInt);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFrameAtTime failed for captureTask, ");
      localStringBuilder.append(paramCaptureTask);
      localStringBuilder.append(", ");
      localStringBuilder.append(localThrowable);
      TLog.d("SystemCaptureProxy", localStringBuilder.toString());
    }
    return null;
  }
  
  private final void b()
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
      VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
      if (localCaptureVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      if (MmrExtensionsKt.a(localMediaMetadataRetriever, localCaptureVideoInfo.a()) != null)
      {
        this.jdField_a_of_type_Int = a(9);
        this.jdField_b_of_type_Int = a(18);
        this.jdField_c_of_type_Int = a(19);
        ThreadManagerKt.a((Function0)new SystemCaptureProxy.prepare..inlined.isNotNull.lambda.1(this));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      TLog.b("SystemCaptureProxy", (Throwable)localNumberFormatException);
    }
  }
  
  private final void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((CapturePreparedListener)localIterator.next()).a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, a());
    }
  }
  
  public long a()
  {
    int i = this.jdField_a_of_type_Int;
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    i = RangesKt.coerceAtMost(i, localCaptureVideoInfo.b());
    localCaptureVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    return i - localCaptureVideoInfo.a();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetVideoView = ((VideoView)null);
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
  }
  
  public void a(int paramInt, @Nullable MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
    paramOnSeekCompleteListener = this.jdField_a_of_type_AndroidWidgetVideoView;
    if (paramOnSeekCompleteListener != null) {
      paramOnSeekCompleteListener.seekTo(paramInt);
    }
  }
  
  public void a(@NotNull CapturePreparedListener paramCapturePreparedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCapturePreparedListener, "listener");
    this.jdField_a_of_type_JavaUtilSet.add(paramCapturePreparedListener);
  }
  
  public void a(@NotNull CaptureTask paramCaptureTask, @Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramCaptureTask, "captureTask");
      ThreadManagerKt.c((Function0)new SystemCaptureProxy.capture.1(this, paramCaptureTask, paramOnCaptureCallback));
      return;
    }
    finally
    {
      paramCaptureTask = finally;
      throw paramCaptureTask;
    }
  }
  
  public void a(@NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureVideoInfo, "captureVideoInfo");
    if (this.jdField_c_of_type_Boolean)
    {
      if (paramViewGroup != null)
      {
        this.jdField_a_of_type_AndroidWidgetVideoView = new VideoView(AppContext.a.a());
        paramViewGroup.addView((View)this.jdField_a_of_type_AndroidWidgetVideoView);
      }
      paramViewGroup = this.jdField_a_of_type_AndroidWidgetVideoView;
      if (paramViewGroup != null) {
        paramViewGroup.setVideoPath(paramCaptureVideoInfo.a());
      }
      paramViewGroup = this.jdField_a_of_type_AndroidWidgetVideoView;
      if (paramViewGroup != null)
      {
        Object localObject = paramViewGroup.getLayoutParams();
        if (localObject != null)
        {
          localObject = (RelativeLayout.LayoutParams)localObject;
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
      }
      paramViewGroup = this.jdField_a_of_type_AndroidWidgetVideoView;
      if (paramViewGroup != null) {
        paramViewGroup.setOnPreparedListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener);
      }
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo = paramCaptureVideoInfo;
    ThreadManagerKt.c((Function0)new SystemCaptureProxy.init.2(this));
  }
  
  public void onSeekComplete(@Nullable MediaPlayer paramMediaPlayer)
  {
    MediaPlayer.OnSeekCompleteListener localOnSeekCompleteListener = this.jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener;
    if (localOnSeekCompleteListener != null) {
      localOnSeekCompleteListener.onSeekComplete(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SystemCaptureProxy
 * JD-Core Version:    0.7.0.1
 */