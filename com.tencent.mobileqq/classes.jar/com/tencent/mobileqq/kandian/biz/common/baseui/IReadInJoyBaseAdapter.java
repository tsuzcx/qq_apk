package com.tencent.mobileqq.kandian.biz.common.baseui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.framework.PrefetchListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "", "addCurrentAppearedAdId", "", "id", "", "checkPlayableArea", "listView", "Lcom/tencent/widget/AbsListView;", "delay", "", "clearAdIds", "deleteHeaderUnInterested", "position", "articleList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "dislikeInfos", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeInfo;", "dislikeInfo", "isComplain", "", "needDeleteItem", "getADFeedsVideoAppDownlodManager", "getActivity", "Landroid/app/Activity;", "getArticleInfo", "getChanelType", "getChannelID", "getCount", "getCurrentVideoPlayPositon", "", "getData", "", "getDataAbs", "getFaceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "getGdtMonitorJumpClickParams", "Ljava/lang/Object;", "getItem", "getItemViewType", "getLastCheckAdTime", "getListView", "Lcom/tencent/widget/ListView;", "getReadArticleInfo", "channelID", "getRecommendADVideoFeedsManager", "getSlideLeftOutAnimation", "Landroid/view/animation/AnimationSet;", "getSupplementUtil", "Lcom/tencent/mobileqq/kandian/biz/ad/entity/IExposureSupplementManager;", "getVideoPlayManager", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/api/IVideoPlayManager;", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "handleAdExposureTime", "adExposureTime", "Ljava/util/HashMap;", "isEmpty", "isNeedShowLastReadPositionView", "notifyDataSetChanged", "openFullVideoPlayActivity", "videoParams", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "articleInfo", "setADFeedsVideoAppDownlodManager", "adFeedsVideoAppDownlodManager", "setGdtMonitorEnterTime", "time", "setGdtMonitorJumpClickParams", "value", "setLastCheckAdTime", "adTime", "setPrefetchListener", "listener", "Lcom/tencent/mobileqq/kandian/biz/framework/PrefetchListener;", "setSupplementUtil", "supplementUtil", "kandian-api_release"}, k=1, mv={1, 1, 16})
@IgnoreDenyDependencyToSelf
public abstract interface IReadInJoyBaseAdapter
{
  public abstract int a();
  
  public abstract long a();
  
  @Nullable
  public abstract Activity a();
  
  @Nullable
  public abstract AnimationSet a();
  
  @Nullable
  public abstract IFaceDecoder a();
  
  @Nullable
  public abstract IExposureSupplementManager a();
  
  @Nullable
  public abstract IVideoPlayManager a();
  
  @Nullable
  public abstract AbsBaseArticleInfo a(int paramInt);
  
  @Nullable
  public abstract ListView a();
  
  @Nullable
  public abstract Object a();
  
  @Nullable
  public abstract List<AbsBaseArticleInfo> a();
  
  public abstract void a();
  
  public abstract void a(int paramInt, @Nullable ArrayList<AbsBaseArticleInfo> paramArrayList, @Nullable ArrayList<DislikeInfo> paramArrayList1, @Nullable Object paramObject, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(long paramLong);
  
  public abstract void a(@Nullable IExposureSupplementManager paramIExposureSupplementManager);
  
  public abstract void a(@Nullable PrefetchListener paramPrefetchListener);
  
  public abstract void a(@Nullable VideoPlayParam paramVideoPlayParam, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void a(@Nullable AbsListView paramAbsListView, int paramInt);
  
  public abstract void a(@Nullable Object paramObject);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull HashMap<String, Long> paramHashMap);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract long b();
  
  @Nullable
  public abstract AbsBaseArticleInfo b(int paramInt);
  
  @Nullable
  public abstract Object b();
  
  @Nullable
  public abstract List<AbsBaseArticleInfo> b();
  
  public abstract void b(long paramLong);
  
  @Nullable
  public abstract Object c();
  
  public abstract int getCount();
  
  @Nullable
  public abstract Object getItem(int paramInt);
  
  public abstract int getItemViewType(int paramInt);
  
  @Nullable
  public abstract View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup);
  
  public abstract void notifyDataSetChanged();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter
 * JD-Core Version:    0.7.0.1
 */