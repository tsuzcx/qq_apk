package com.tencent.tkd.topicsdk.videoprocess.videopreview;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videopreview/VideoPreviewPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "Landroid/view/SurfaceHolder$Callback;", "()V", "mediaPlayer", "Landroid/media/MediaPlayer;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "surfaceView", "Landroid/view/SurfaceView;", "videoPath", "", "changeVideoSize", "", "getImmersiveStatusBarStatus", "Lkotlin/Pair;", "", "initData", "initSurfaceView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPause", "releaseMediaPlayer", "surfaceChanged", "holder", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoPreviewPage
  extends BaseSDKPage
  implements SurfaceHolder.Callback
{
  public static final VideoPreviewPage.Companion a = new VideoPreviewPage.Companion(null);
  private SurfaceView c;
  private MediaPlayer d;
  private SurfaceHolder e;
  private String f = "";
  
  private final void a(View paramView)
  {
    paramView = paramView.findViewById(R.id.am);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.sv_video)");
    this.c = ((SurfaceView)paramView);
    paramView = this.c;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    this.e = paramView.getHolder();
    paramView = this.e;
    if (paramView != null) {
      paramView.addCallback((SurfaceHolder.Callback)this);
    }
  }
  
  private final void n()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("video_url");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.f = ((String)localObject);
  }
  
  private final void o()
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    localMediaPlayer.release();
  }
  
  private final void p()
  {
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    float f2 = ((MediaPlayer)localObject).getVideoWidth();
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    float f1 = ((MediaPlayer)localObject).getVideoHeight();
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    float f3 = f2 / ((SurfaceView)localObject).getWidth();
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    f3 = RangesKt.coerceAtLeast(f3, f1 / ((SurfaceView)localObject).getHeight());
    f2 = (float)Math.ceil(f2 / f3);
    f1 = (float)Math.ceil(f1 / f3);
    localObject = new RelativeLayout.LayoutParams((int)f2, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    SurfaceView localSurfaceView = this.c;
    if (localSurfaceView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    localSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.h, paramViewGroup, false);
    n();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view");
    a(paramLayoutInflater);
    ((RelativeLayout)paramLayoutInflater.findViewById(R.id.ac)).setOnClickListener((View.OnClickListener)new VideoPreviewPage.onCreateView.1(this));
    return paramLayoutInflater;
  }
  
  @NotNull
  public Pair<Integer, Integer> c()
  {
    Object localObject = b();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject != null)
      {
        localObject = Integer.valueOf(((Resources)localObject).getColor(R.color.b));
        break label34;
      }
    }
    localObject = null;
    label34:
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return new Pair(localObject, Integer.valueOf(0));
  }
  
  public void f()
  {
    super.f();
    o();
  }
  
  public void surfaceChanged(@Nullable SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    this.d = new MediaPlayer();
    paramSurfaceHolder = this.d;
    if (paramSurfaceHolder == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    paramSurfaceHolder.setDisplay(this.e);
    try
    {
      paramSurfaceHolder.setDataSource(this.f);
      paramSurfaceHolder.prepare();
      paramSurfaceHolder.setOnPreparedListener((MediaPlayer.OnPreparedListener)new VideoPreviewPage.surfaceCreated..inlined.apply.lambda.1(this));
      paramSurfaceHolder.setAudioStreamType(3);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("surfaceCreated: ");
      localStringBuilder.append(paramSurfaceHolder);
      TLog.d("VideoPreviewFragment", localStringBuilder.toString());
    }
  }
  
  public void surfaceDestroyed(@Nullable SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage
 * JD-Core Version:    0.7.0.1
 */