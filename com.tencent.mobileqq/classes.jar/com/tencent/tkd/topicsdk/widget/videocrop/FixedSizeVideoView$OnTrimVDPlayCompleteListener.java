package com.tencent.tkd.topicsdk.widget.videocrop;

import android.media.MediaPlayer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView$OnTrimVDPlayCompleteListener;", "", "onArriveTrimEnd", "", "videoView", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView;", "startTime", "", "duration", "onComplete", "mp", "Landroid/media/MediaPlayer;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface FixedSizeVideoView$OnTrimVDPlayCompleteListener
{
  public abstract void a(@NotNull MediaPlayer paramMediaPlayer);
  
  public abstract void a(@NotNull FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FixedSizeVideoView.OnTrimVDPlayCompleteListener
 * JD-Core Version:    0.7.0.1
 */