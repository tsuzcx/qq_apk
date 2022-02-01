package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.common.MmrExtensionsKt;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;
import com.tencent.tkd.topicsdk.ucrop.view.UCropView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SystemCaptureProxy;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "isForCapture", "", "(Z)V", "_onPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "duration", "", "gestureCropView", "Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "height", "mediaPlayer", "Landroid/media/MediaPlayer;", "metadataRetriever", "Landroid/media/MediaMetadataRetriever;", "preparedListenerSet", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "released", "seekCompleteListener", "uCropView", "Lcom/tencent/tkd/topicsdk/ucrop/view/UCropView;", "useScaleAPI", "videoDuration", "", "getVideoDuration", "()J", "width", "addCapturePreparedListener", "", "listener", "capture", "captureTask", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "captureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "getCoverPath", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "coverPath", "getFrameAtTime", "Landroid/graphics/Bitmap;", "option", "getScaleFrameAtTime", "getVideoValue", "key", "init", "containerView", "Landroid/view/ViewGroup;", "notifyListeners", "onSeekComplete", "prepare", "release", "seek", "position", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SystemCaptureProxy
  implements MediaPlayer.OnSeekCompleteListener, ICaptureProxy
{
  public static final SystemCaptureProxy.Companion a = new SystemCaptureProxy.Companion(null);
  private final MediaMetadataRetriever b;
  private final Set<CapturePreparedListener> c;
  private int d;
  private VideoCaptureView.CaptureVideoInfo e;
  private int f;
  private int g;
  private volatile boolean h;
  private volatile boolean i;
  private MediaPlayer.OnSeekCompleteListener j;
  private IGestureCropView k;
  private UCropView l;
  private MediaPlayer m;
  private MediaPlayer.OnPreparedListener n;
  private boolean o;
  
  public SystemCaptureProxy()
  {
    this(false, 1, null);
  }
  
  public SystemCaptureProxy(boolean paramBoolean)
  {
    this.o = paramBoolean;
    this.b = new MediaMetadataRetriever();
    this.c = ((Set)new HashSet());
    this.h = true;
    this.n = ((MediaPlayer.OnPreparedListener)new SystemCaptureProxy._onPreparedListener.1(this));
  }
  
  private final int a(int paramInt)
  {
    String str = this.b.extractMetadata(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "metadataRetriever.extractMetadata(key)");
    return Integer.parseInt(str);
  }
  
  @RequiresApi(27)
  private final Bitmap a(int paramInt, CaptureTask paramCaptureTask)
  {
    try
    {
      Bitmap localBitmap = this.b.getScaledFrameAtTime(paramCaptureTask.c() * 1000, paramInt, paramCaptureTask.d(), paramCaptureTask.e());
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
      Bitmap localBitmap = this.b.getFrameAtTime(paramCaptureTask.c() * 1000, paramInt);
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
  
  private final void c()
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = this.b;
      VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.e;
      if (localCaptureVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      if (MmrExtensionsKt.a(localMediaMetadataRetriever, localCaptureVideoInfo.f()) != null)
      {
        this.d = a(9);
        this.f = a(18);
        this.g = a(19);
        ThreadManagerKt.a((Function0)new SystemCaptureProxy.prepare..inlined.isNotNull.lambda.1(this));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      TLog.b("SystemCaptureProxy", (Throwable)localNumberFormatException);
    }
  }
  
  private final void d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((CapturePreparedListener)localIterator.next()).a(this.f, this.g, a());
    }
  }
  
  public long a()
  {
    int i1 = this.d;
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.e;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    i1 = RangesKt.coerceAtMost(i1, localCaptureVideoInfo.b());
    localCaptureVideoInfo = this.e;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    return i1 - localCaptureVideoInfo.a();
  }
  
  public void a(int paramInt, @Nullable MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.j = paramOnSeekCompleteListener;
    paramOnSeekCompleteListener = this.l;
    if (paramOnSeekCompleteListener != null) {
      paramOnSeekCompleteListener.a(paramInt);
    }
  }
  
  public void a(@NotNull CapturePreparedListener paramCapturePreparedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCapturePreparedListener, "listener");
    this.c.add(paramCapturePreparedListener);
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
    this.e = paramCaptureVideoInfo;
    if ((this.o) && (paramViewGroup != null))
    {
      Object localObject = LayoutInflater.from(AppContext.a.a()).inflate(R.layout.v, paramViewGroup, false);
      if (localObject != null)
      {
        UCropView localUCropView = (UCropView)localObject;
        localObject = localUCropView.getGestureCropView();
        if (localObject != null)
        {
          GestureCropHandler localGestureCropHandler = ((IGestureCropView)localObject).getGestureCropHandler();
          localGestureCropHandler.b(false);
          localGestureCropHandler.a(paramCaptureVideoInfo.e());
        }
        else
        {
          localObject = null;
        }
        this.k = ((IGestureCropView)localObject);
        localUCropView.setVideo(paramCaptureVideoInfo.f(), paramCaptureVideoInfo.c(), paramCaptureVideoInfo.d(), this.n);
        this.l = localUCropView;
        paramViewGroup.addView((View)this.l);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.ucrop.view.UCropView");
      }
    }
    ThreadManagerKt.c((Function0)new SystemCaptureProxy.init.2(this));
  }
  
  public void a(@NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    String str = TopicSDK.a.a().b().q().b();
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((IGestureCropView)localObject).getGestureCropHandler();
      if (localObject != null) {
        ((GestureCropHandler)localObject).a(Bitmap.CompressFormat.JPEG, 90, str, (BitmapCropCallback)new SystemCaptureProxy.getCoverPath.1(paramFunction1));
      }
    }
  }
  
  public void b()
  {
    this.i = true;
    this.k = ((IGestureCropView)null);
    MediaPlayer localMediaPlayer = this.m;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    this.b.release();
  }
  
  public void onSeekComplete(@Nullable MediaPlayer paramMediaPlayer)
  {
    MediaPlayer.OnSeekCompleteListener localOnSeekCompleteListener = this.j;
    if (localOnSeekCompleteListener != null) {
      localOnSeekCompleteListener.onSeekComplete(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SystemCaptureProxy
 * JD-Core Version:    0.7.0.1
 */