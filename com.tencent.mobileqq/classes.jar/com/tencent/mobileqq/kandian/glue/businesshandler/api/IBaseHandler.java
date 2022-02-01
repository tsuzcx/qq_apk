package com.tencent.mobileqq.kandian.glue.businesshandler.api;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IBaseHandler;", "", "attachToViewGroup", "", "channelReportMap", "", "", "Lcom/tencent/mobileqq/kandian/repo/report/BaseReportData;", "reportIDSet", "", "", "reportDataMap", "detachFromViewGroup", "isExposure", "", "getActivity", "Landroid/app/Activity;", "getChannelID", "getChannelType", "getCount", "getData", "position", "getDataFetchManager", "getDataManager", "getDatas", "", "getFaceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "getFeedsLastReadVisiable", "getFeedsType", "(I)Ljava/lang/Integer;", "getHandlerID", "getListView", "Lcom/tencent/widget/AbsListView;", "getReadInJoyAdapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "getReadInJoyBaseListViewGroup", "getSlideLeftOutAnimation", "Landroid/view/animation/AnimationSet;", "isMyView", "viewType", "onActivityResult", "requestcode", "resultcode", "intent", "Landroid/content/Intent;", "onAdapterGetView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBackPressed", "()Ljava/lang/Boolean;", "onBackToTop", "needRefresh", "type", "onChannelArticleLoaded", "channelID", "articleSeqList", "onChannelRefreshed", "isSuccess", "noMoreData", "onDataChangedDrawCompletion", "listView", "onDestroy", "onEndRefresh", "onFeedsItemClick", "Lcom/tencent/widget/AdapterView;", "view", "positionIncludeHeaderAndFooter", "dataPosition", "onImageClick", "context", "Landroid/content/Context;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "rowKey", "", "source", "onListViewDrawFinished", "onListViewGroupInit", "rootView", "Lcom/tencent/widget/ListView;", "from", "onListViewGroupInited", "onListViewScroll", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onListViewScrollStateChanged", "scrollState", "onLoadMoreArticle", "onNotifyDataSetChange", "onPause", "onPostGetAdapterView", "itemView", "info", "onRegionClick", "onResume", "onRijChannelBannerRefreshed", "channelId", "channelBannerInfoList", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelBannerInfo;", "onSetData", "newDatas", "onStart", "onStartTopRefresh", "refreshType", "onStop", "setListViewGroup", "listViewGroup", "setReadInJoyAdapter", "adapter", "triggleBackToTop", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBaseHandler
{
  @Nullable
  public abstract View a(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup);
  
  public abstract void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent);
  
  public abstract void a(int paramInt, @Nullable List<Long> paramList);
  
  public abstract void a(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable String paramString, int paramInt);
  
  public abstract void a(@Nullable View paramView1, @Nullable View paramView2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt);
  
  public abstract void a(@Nullable View paramView, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt);
  
  public abstract void a(@Nullable View paramView, @Nullable ListView paramListView);
  
  public abstract void a(@Nullable View paramView, @Nullable ListView paramListView, long paramLong);
  
  public abstract void a(@Nullable ViewGroup paramViewGroup);
  
  public abstract void a(@Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract void a(@Nullable AbsListView paramAbsListView);
  
  public abstract void a(@Nullable AbsListView paramAbsListView, int paramInt);
  
  public abstract void a(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(@Nullable AdapterView<?> paramAdapterView, @Nullable View paramView, int paramInt, long paramLong);
  
  public abstract void a(@Nullable List<? extends AbsBaseArticleInfo> paramList);
  
  public abstract void a(@Nullable Map<Integer, ? extends BaseReportData> paramMap);
  
  public abstract void a(@Nullable Map<Long, ? extends BaseReportData> paramMap, boolean paramBoolean);
  
  public abstract void a(@Nullable Set<Long> paramSet, @Nullable Map<Long, ? extends BaseReportData> paramMap);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract void a(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2);
  
  @Nullable
  public abstract IReadInJoyBaseAdapter b();
  
  public abstract void b(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2);
  
  public abstract void c(int paramInt);
  
  public abstract boolean d(int paramInt);
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract void o();
  
  @Nullable
  public abstract Boolean p();
  
  public abstract void q();
  
  public abstract void r();
  
  public abstract int s();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler
 * JD-Core Version:    0.7.0.1
 */