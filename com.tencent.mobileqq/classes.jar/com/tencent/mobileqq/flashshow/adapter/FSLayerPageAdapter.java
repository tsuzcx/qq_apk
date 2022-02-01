package com.tencent.mobileqq.flashshow.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.manager.FSLayerScrollStatusManager;
import com.tencent.mobileqq.flashshow.manager.IFSLayerScrollerStatus;
import com.tencent.mobileqq.flashshow.manager.scroller.FSLayerPlayerScroller;
import com.tencent.mobileqq.flashshow.manager.scroller.FSLayerReporterScroller;
import com.tencent.mobileqq.flashshow.widgets.FSBaseListViewAdapter;
import com.tencent.mobileqq.flashshow.widgets.feed.FSLayerFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;

public class FSLayerPageAdapter
  extends FSBaseListViewAdapter<FSFeedData>
  implements IFSLayerScrollerStatus
{
  private FSLayerScrollStatusManager a;
  private FSLayerPlayerScroller b;
  private FSLayerReporterScroller c;
  private IFSFeedIoc d;
  private Activity e;
  
  private void e()
  {
    this.b = new FSLayerPlayerScroller();
    this.c = new FSLayerReporterScroller();
    this.a = new FSLayerScrollStatusManager();
    this.a.a(this.b);
    this.a.a(this.c);
  }
  
  public Activity a()
  {
    return this.e;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.a(paramInt1, paramFloat, paramInt2);
  }
  
  public void a(Activity paramActivity)
  {
    this.e = paramActivity;
  }
  
  public void a(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.onActivityResumed(a());
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.a(paramFSFeedSelectInfo);
  }
  
  public void a(IFSFeedIoc paramIFSFeedIoc)
  {
    this.d = paramIFSFeedIoc;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((FSFeedData)localIterator.next()).b().id.get())) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    super.onActivityDestroyed(a());
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.a();
  }
  
  public void b(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.onActivityPaused(a());
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.b(paramFSFeedSelectInfo);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      i += 1;
      if (TextUtils.equals(paramString, ((FSFeedData)localIterator.next()).b().id.get()))
      {
        localIterator.remove();
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, getItemCount() - i);
        return true;
      }
    }
    return false;
  }
  
  public void c(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.onActivityStopped(a());
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.c(paramFSFeedSelectInfo);
  }
  
  public boolean c()
  {
    return getItemCount() == 0;
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((FSFeedData)localIterator.next()).b().poster.id.get())) {
        return true;
      }
    }
    return false;
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.d(paramFSFeedSelectInfo);
  }
  
  public boolean d(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((FSFeedData)localIterator.next()).b().poster.id.get()))
      {
        localIterator.remove();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    FSLayerScrollStatusManager localFSLayerScrollStatusManager = this.a;
    if (localFSLayerScrollStatusManager == null) {
      return;
    }
    localFSLayerScrollStatusManager.e(paramFSFeedSelectInfo);
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    e();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (ArrayUtils.a(paramInt, getDataList())) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((FSLayerScrollStatusManager)localObject).a(paramViewHolder);
    }
    localObject = (FSFeedData)getDataList().get(paramInt);
    ((FSLayerPageAdapter.LayerPagerHolder)paramViewHolder).a((FSFeedData)localObject, paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new FSLayerFeedItemView(paramViewGroup.getContext());
    paramViewGroup.setFeedIoc(this.d);
    paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return new FSLayerPageAdapter.LayerPagerHolder(paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.a;
    if (paramRecyclerView != null) {
      paramRecyclerView.a();
    }
  }
  
  public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    Object localObject = this.a;
    if (localObject != null) {
      ((FSLayerScrollStatusManager)localObject).a(paramViewHolder);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FSLayerPageAdapter onViewAttachedToWindow  holder = ");
    ((StringBuilder)localObject).append(paramViewHolder);
    QLog.d("FSLayerPageAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSLayerPageAdapter onViewDetachedFromWindow  holder = ");
    localStringBuilder.append(paramViewHolder);
    QLog.d("FSLayerPageAdapter", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter
 * JD-Core Version:    0.7.0.1
 */