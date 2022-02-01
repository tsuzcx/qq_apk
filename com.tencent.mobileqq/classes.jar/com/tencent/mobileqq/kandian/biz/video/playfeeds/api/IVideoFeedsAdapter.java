package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IAdapter;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/CustomClickListener;", "Landroid/view/View$OnLongClickListener;", "mIsNeedShowCommentFirstTime", "", "getMIsNeedShowCommentFirstTime", "()Z", "setMIsNeedShowCommentFirstTime", "(Z)V", "canAutoPlayEnterVideo", "holder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "checkExposureAdd", "traceId", "", "followPubAccount", "", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "getActionBarHeight", "", "getActivity", "Landroid/app/Activity;", "getBlackColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getDefaultFaceDrawable", "Landroid/graphics/drawable/Drawable;", "getFullScreenBackground", "getListView", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/view/VideoFeedsRecyclerView;", "getPlayingVideoHolder", "getSeekBaroffBottomDistance", "getVideoBrightnessController", "", "getVideoFeedsHardAdBarManager", "getVideoFeedsPlayManager", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsPlayManager;", "headerMenuClick", "adInfo", "innerGetDrawableFromResource", "resid", "isCommentVisible", "isControllerLayoutShown", "isNowSimpleUI", "negPopupMenuDissmiss", "notifyItemChanged", "position", "notifyItemInserted", "refreshColumnBanner", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "refreshColumnData", "sendMessageDelayed", "msgWhat", "delay", "", "isRemoveHisMessage", "setActionBarHeight", "height", "setOptInfo", "setSeekBaroffBottomDistance", "distance", "showAdNeg", "view", "Landroid/view/View;", "inPosition", "startLikeAnimate", "actionX", "", "actionY", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsAdapter
  extends View.OnClickListener, View.OnLongClickListener, CustomClickListener, IAdapter
{
  public abstract int a();
  
  @Nullable
  public abstract Activity a();
  
  @NotNull
  public abstract ColorDrawable a();
  
  @NotNull
  public abstract Drawable a();
  
  @Nullable
  public abstract Drawable a(int paramInt);
  
  @Nullable
  public abstract IVideoFeedsPlayManager a();
  
  @Nullable
  public abstract VideoFeedsRecyclerView a();
  
  @Nullable
  public abstract BaseVideoItemHolder a();
  
  @Nullable
  public abstract Object a();
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract void a(@Nullable View paramView, int paramInt, @Nullable Object paramObject);
  
  public abstract void a(@Nullable VideoInfo paramVideoInfo, @Nullable VideoItemHolder paramVideoItemHolder);
  
  public abstract void a(@Nullable VideoItemHolder paramVideoItemHolder, @Nullable VideoInfo paramVideoInfo);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean a(@Nullable BaseVideoItemHolder paramBaseVideoItemHolder);
  
  public abstract boolean a(@Nullable String paramString);
  
  public abstract int b();
  
  @NotNull
  public abstract Drawable b();
  
  @NotNull
  public abstract Object b();
  
  public abstract void b(@Nullable VideoInfo paramVideoInfo);
  
  public abstract void b(@Nullable VideoInfo paramVideoInfo, @Nullable VideoItemHolder paramVideoItemHolder);
  
  public abstract boolean b();
  
  public abstract void c(int paramInt);
  
  public abstract boolean c();
  
  public abstract void d(int paramInt);
  
  public abstract boolean d();
  
  public abstract void f();
  
  public abstract void notifyItemChanged(int paramInt);
  
  public abstract void notifyItemInserted(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */