package com.tencent.mobileqq.flashshow.player.widget;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.flashshow.player.FSExchangeHelper;
import com.tencent.mobileqq.flashshow.player.FSVideoUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;

public abstract class FSAbsBaseVideoView
  extends FSBaseVideoView
{
  private FSProgressLoadingView g;
  private FeedCloudMeta.StVideo h;
  
  public FSAbsBaseVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.g = new FSProgressLoadingView(paramContext);
  }
  
  public FSAbsBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = new FSProgressLoadingView(paramContext);
  }
  
  public FSAbsBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = new FSProgressLoadingView(paramContext);
  }
  
  private void a(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    this.h = paramStVideo;
    String str = FSVideoUtils.a(paramStVideo);
    super.setVideoPath(paramStVideo.fileId.get(), str, paramInt);
  }
  
  private void a(FeedCloudMeta.StVideoUrl paramStVideoUrl)
  {
    getMainHandler().post(new FSAbsBaseVideoView.2(this, paramStVideoUrl));
  }
  
  protected void b(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    QLog.i("FSBaseVideoView", 1, "triggerDowngradeVideoUrl start");
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    localObject = FSExchangeHelper.a(((FeedCloudMeta.StVideo)localObject).vecVideoUrl.get());
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get())))
    {
      if (paramSuperPlayerVideoInfo.getPlayUrl().equals(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get()))
      {
        QLog.i("FSBaseVideoView", 1, String.format("triggerDowngradeVideoUrl:return url is targetLevelType: %s, levelType:%d", new Object[] { ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), Integer.valueOf(((FeedCloudMeta.StVideoUrl)localObject).levelType.get()) }));
        return;
      }
      a((FeedCloudMeta.StVideoUrl)localObject);
      return;
    }
    QLog.i("FSBaseVideoView", 1, "triggerPlayLowResVideoUrl: url is null");
  }
  
  protected void e()
  {
    super.e();
    if (getProgressBar() != null) {
      getProgressBar().setVisibility(8);
    }
    FSProgressLoadingView localFSProgressLoadingView = this.g;
    if (localFSProgressLoadingView != null) {
      localFSProgressLoadingView.a();
    }
  }
  
  protected void f()
  {
    super.f();
    FSProgressLoadingView localFSProgressLoadingView = this.g;
    if (localFSProgressLoadingView != null) {
      localFSProgressLoadingView.b();
    }
    if (getProgressBar() != null)
    {
      getProgressBar().setVisibility(0);
      getProgressBar().setOnSeekBarChangeListener(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    FSProgressLoadingView localFSProgressLoadingView = this.g;
    if (localFSProgressLoadingView != null) {
      localFSProgressLoadingView.b();
    }
  }
  
  public void release()
  {
    super.release();
  }
  
  public void setLoadingView(View paramView)
  {
    if (paramView != null) {
      this.g.setLoadingView(paramView);
    }
  }
  
  public void setVideoPath(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    FSExchangeHelper.a().a(getContext().hashCode(), paramStVideo, new FSAbsBaseVideoView.1(this, paramInt, paramStVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSAbsBaseVideoView
 * JD-Core Version:    0.7.0.1
 */