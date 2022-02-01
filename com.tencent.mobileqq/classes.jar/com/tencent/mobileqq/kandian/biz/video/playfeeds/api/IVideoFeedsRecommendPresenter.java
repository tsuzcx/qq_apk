package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "isFullScreen", "", "()Z", "playManager", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsPlayManager;", "getPlayManager", "()Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsPlayManager;", "getActionBarHeight", "", "getPlayingVideoItemHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "getVideoFeedsReporter", "isKingCardUser", "onDianZanClick", "", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "dianZanDrawable", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsRecommendPresenter
{
  public abstract void a(@NotNull VideoItemHolder paramVideoItemHolder, int paramInt);
  
  public abstract boolean e();
  
  public abstract int r();
  
  @NotNull
  public abstract Object s();
  
  public abstract boolean t();
  
  @Nullable
  public abstract BaseVideoItemHolder u();
  
  @Nullable
  public abstract Activity v();
  
  @NotNull
  public abstract IVideoFeedsPlayManager x();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */