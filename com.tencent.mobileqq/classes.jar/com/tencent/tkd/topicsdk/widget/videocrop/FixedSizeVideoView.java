package com.tencent.tkd.topicsdk.widget.videocrop;

import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView;", "Landroid/widget/VideoView;", "Landroid/os/Handler$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "<set-?>", "", "endMilliSec", "getEndMilliSec", "()I", "listener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView$OnTrimVDPlayCompleteListener;", "getListener", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView$OnTrimVDPlayCompleteListener;", "setListener", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView$OnTrimVDPlayCompleteListener;)V", "mPlayHandler", "Landroid/os/Handler;", "playDuration", "getPlayDuration", "startMilliSec", "getStartMilliSec", "handleMessage", "", "msg", "Landroid/os/Message;", "pause", "", "setPlayDuration", "milliSec", "start", "Companion", "OnTrimVDPlayCompleteListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FixedSizeVideoView
  extends VideoView
  implements Handler.Callback
{
  public static final FixedSizeVideoView.Companion a = new FixedSizeVideoView.Companion(null);
  private int b = -1;
  private int c;
  private int d;
  private final Handler e = new Handler(Looper.getMainLooper(), (Handler.Callback)this);
  @Nullable
  private FixedSizeVideoView.OnTrimVDPlayCompleteListener f;
  
  public FixedSizeVideoView(@Nullable Context paramContext)
  {
    super(paramContext);
    super.setOnCompletionListener((MediaPlayer.OnCompletionListener)new FixedSizeVideoView.1(this));
  }
  
  public FixedSizeVideoView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnCompletionListener((MediaPlayer.OnCompletionListener)new FixedSizeVideoView.2(this));
  }
  
  public final int getEndMilliSec()
  {
    return this.d;
  }
  
  @Nullable
  public final FixedSizeVideoView.OnTrimVDPlayCompleteListener getListener()
  {
    return this.f;
  }
  
  public final int getPlayDuration()
  {
    return this.b;
  }
  
  public final int getStartMilliSec()
  {
    return this.c;
  }
  
  public boolean handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    if (paramMessage.what == 0)
    {
      paramMessage = this.f;
      if (paramMessage != null) {
        paramMessage.a(this, this.c, this.b);
      }
    }
    return true;
  }
  
  public void pause()
  {
    super.pause();
    this.e.removeMessages(0);
  }
  
  public final void setListener(@Nullable FixedSizeVideoView.OnTrimVDPlayCompleteListener paramOnTrimVDPlayCompleteListener)
  {
    this.f = paramOnTrimVDPlayCompleteListener;
  }
  
  public final void setPlayDuration(int paramInt)
  {
    setPlayDuration(0, paramInt);
  }
  
  public final void setPlayDuration(int paramInt1, int paramInt2)
  {
    try
    {
      int i = getDuration();
      if (paramInt1 >= i) {
        return;
      }
      this.d = (paramInt2 + paramInt1);
      if (this.d > i) {
        this.d = i;
      }
      this.c = paramInt1;
      this.b = paramInt2;
      seekTo(paramInt1);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayDuration error ");
      localStringBuilder.append(localException);
      TLog.d("FixedSizeVideoView", localStringBuilder.toString());
    }
  }
  
  public void start()
  {
    int i = getCurrentPosition();
    i = this.d - i;
    if (i >= 0)
    {
      super.start();
      this.e.removeMessages(0);
      this.e.sendEmptyMessageDelayed(0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FixedSizeVideoView
 * JD-Core Version:    0.7.0.1
 */