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
  public static final VideoPreviewPage.Companion a;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private String jdField_a_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideopreviewVideoPreviewPage$Companion = new VideoPreviewPage.Companion(null);
  }
  
  private final void a(View paramView)
  {
    paramView = paramView.findViewById(R.id.bm);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.sv_video)");
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)paramView);
    paramView = this.jdField_a_of_type_AndroidViewSurfaceView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramView.getHolder();
    paramView = this.jdField_a_of_type_AndroidViewSurfaceHolder;
    if (paramView != null) {
      paramView.addCallback((SurfaceHolder.Callback)this);
    }
  }
  
  private final void f()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("video_url");
      if (localObject == null) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      return;
      localObject = "";
    }
  }
  
  private final void g()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    localMediaPlayer.release();
  }
  
  private final void h()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    float f2 = ((MediaPlayer)localObject).getVideoWidth();
    localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    float f1 = ((MediaPlayer)localObject).getVideoHeight();
    localObject = this.jdField_a_of_type_AndroidViewSurfaceView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    float f3 = f2 / ((SurfaceView)localObject).getWidth();
    localObject = this.jdField_a_of_type_AndroidViewSurfaceView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    f3 = RangesKt.coerceAtLeast(f3, f1 / ((SurfaceView)localObject).getHeight());
    f2 = (float)Math.ceil(f2 / f3);
    f1 = (float)Math.ceil(f1 / f3);
    localObject = new RelativeLayout.LayoutParams((int)f2, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    SurfaceView localSurfaceView = this.jdField_a_of_type_AndroidViewSurfaceView;
    if (localSurfaceView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    }
    localSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.n, paramViewGroup, false);
    f();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view");
    a(paramLayoutInflater);
    ((RelativeLayout)paramLayoutInflater.findViewById(R.id.bb)).setOnClickListener((View.OnClickListener)new VideoPreviewPage.onCreateView.1(this));
    return paramLayoutInflater;
  }
  
  @NotNull
  public Pair<Integer, Integer> a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject == null) {}
    }
    for (localObject = Integer.valueOf(((Resources)localObject).getColor(R.color.b));; localObject = null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return new Pair(localObject, Integer.valueOf(0));
    }
  }
  
  public void a()
  {
    super.a();
    g();
  }
  
  public void surfaceChanged(@Nullable SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    paramSurfaceHolder = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (paramSurfaceHolder == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    }
    paramSurfaceHolder.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
    try
    {
      paramSurfaceHolder.setDataSource(this.jdField_a_of_type_JavaLangString);
      paramSurfaceHolder.prepare();
      paramSurfaceHolder.setOnPreparedListener((MediaPlayer.OnPreparedListener)new VideoPreviewPage.surfaceCreated..inlined.apply.lambda.1(this));
      paramSurfaceHolder.setAudioStreamType(3);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      TLog.d("VideoPreviewFragment", "surfaceCreated: " + paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(@Nullable SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage
 * JD-Core Version:    0.7.0.1
 */