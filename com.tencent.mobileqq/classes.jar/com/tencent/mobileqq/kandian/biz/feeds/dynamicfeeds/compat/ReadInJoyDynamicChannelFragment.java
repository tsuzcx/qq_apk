package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.DynamicItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ReadInJoyDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private ReadInJoyDynamicChannelAdapter s;
  private int t = 1;
  private TopBannerInfo u;
  private ReadInJoyObserver v = new ReadInJoyDynamicChannelFragment.1(this);
  private XRecyclerView.RefreshCallback w = new ReadInJoyDynamicChannelFragment.2(this);
  
  public static ReadInJoyDynamicChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyDynamicChannelFragment localReadInJoyDynamicChannelFragment = new ReadInJoyDynamicChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoyDynamicChannelFragment.setArguments(localBundle);
    return localReadInJoyDynamicChannelFragment;
  }
  
  private void a(TopBannerInfo paramTopBannerInfo)
  {
    if (paramTopBannerInfo != null)
    {
      if (paramTopBannerInfo.mChannelId != this.d) {
        return;
      }
      this.u = paramTopBannerInfo;
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "refreshBanner mChannelID = ", Integer.valueOf(this.d) });
      x();
      if (paramTopBannerInfo.isDynamicItemsEmpty()) {
        return;
      }
      if (paramTopBannerInfo.dynamicItems.size() > 0)
      {
        int i = 0;
        while (i < paramTopBannerInfo.dynamicItems.size())
        {
          TopBannerInfo.DynamicItem localDynamicItem = (TopBannerInfo.DynamicItem)paramTopBannerInfo.dynamicItems.get(i);
          if ((localDynamicItem != null) && (!TextUtils.isEmpty(localDynamicItem.a)))
          {
            QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "json = ", localDynamicItem.a });
            ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(this.s.a(), w(), ProteusSupportUtilBase.a(localDynamicItem.a));
            ProteusSupportUtilBase.a(localProteusItemView, this.s.a(), w(), localDynamicItem.a);
            a(localProteusItemView);
          }
          else
          {
            QLog.d("ReadInJoyDynamicChannelFragment", 2, "refreshBanner, dynamicJSON is null.");
          }
          i += 1;
        }
      }
      QLog.d("ReadInJoyDynamicChannelFragment", 2, "refreshBanner, dynamicItems is null.");
    }
  }
  
  private void a(ConcurrentHashMap<Long, AbsBaseArticleInfo> paramConcurrentHashMap)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDynamicChannelFragment.4(this, paramConcurrentHashMap));
  }
  
  private void y()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDynamicChannelFragment.3(this), 3000L);
  }
  
  public void a()
  {
    if (!this.o)
    {
      this.o = true;
      y();
      ReadInJoyLogicEngine.a().a(this.d, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.d) });
  }
  
  public void cX_()
  {
    this.s = new ReadInJoyDynamicChannelAdapter(v(), this.c.getRecyclerView(), this.d);
    this.c.getRecyclerView().setAdapter(this.s);
  }
  
  public void cY_()
  {
    this.c.setRefreshCallback(this.w);
  }
  
  public void cZ_()
  {
    this.s.notifyDataSetChanged();
  }
  
  public void e(int paramInt)
  {
    ReadInJoyLogicEngine.a().a(this.d, null, -1, true, false, this.t, null, -1L, null, this.m, 0L, 0L, null, paramInt, false, null, 0, null);
    this.t += 1;
  }
  
  public void n()
  {
    super.n();
    if (this.s != null)
    {
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.d) });
      a(this.s.d());
      this.s.c();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "mAdapter is null.");
  }
  
  public void onBindHeader(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, position = ", Integer.valueOf(paramInt) });
    Object localObject = this.u;
    if ((localObject != null) && (((TopBannerInfo)localObject).dynamicItems.size() > 0) && (paramInt >= 0) && (paramInt < this.u.dynamicItems.size()))
    {
      localObject = (TopBannerInfo.DynamicItem)this.u.dynamicItems.get(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((TopBannerInfo.DynamicItem)localObject).a)))
      {
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if (paramViewHolder != null)
        {
          QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, json = ", ((TopBannerInfo.DynamicItem)localObject).a });
          ProteusSupportUtilBase.a(paramViewHolder, this.s.a(), w(), ((TopBannerInfo.DynamicItem)localObject).a);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.v);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.v);
    ReadInJoyDynamicChannelAdapter localReadInJoyDynamicChannelAdapter = this.s;
    if (localReadInJoyDynamicChannelAdapter != null) {
      localReadInJoyDynamicChannelAdapter.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */