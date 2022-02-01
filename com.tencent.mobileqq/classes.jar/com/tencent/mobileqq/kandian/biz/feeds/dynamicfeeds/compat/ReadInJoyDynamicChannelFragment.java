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
  private ReadInJoyDynamicChannelAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyDynamicChannelFragment.1(this);
  private TopBannerInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo;
  private XRecyclerView.RefreshCallback jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback = new ReadInJoyDynamicChannelFragment.2(this);
  private int e;
  
  public ReadInJoyDynamicChannelFragment()
  {
    this.jdField_e_of_type_Int = 1;
  }
  
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
      if (paramTopBannerInfo.mChannelId != this.c) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo = paramTopBannerInfo;
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "refreshBanner mChannelID = ", Integer.valueOf(this.c) });
      i();
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
            ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter.a(), b(), ProteusSupportUtilBase.a(localDynamicItem.a));
            ProteusSupportUtilBase.a(localProteusItemView, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter.a(), b(), localDynamicItem.a);
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
  
  private void j()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDynamicChannelFragment.3(this), 3000L);
  }
  
  public void a()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      j();
      ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.c) });
  }
  
  public void aB_()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter = new ReadInJoyDynamicChannelAdapter(a(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView(), this.c);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter);
  }
  
  public void c(int paramInt)
  {
    ReadInJoyLogicEngine.a().a(this.c, null, -1, true, false, this.jdField_e_of_type_Int, null, -1L, null, this.d, 0L, 0L, null, paramInt, false, null, 0, null);
    this.jdField_e_of_type_Int += 1;
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter != null)
    {
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.c) });
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter.a());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "mAdapter is null.");
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback);
  }
  
  public void onBindHeader(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, position = ", Integer.valueOf(paramInt) });
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo;
    if ((localObject != null) && (((TopBannerInfo)localObject).dynamicItems.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.dynamicItems.size()))
    {
      localObject = (TopBannerInfo.DynamicItem)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.dynamicItems.get(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((TopBannerInfo.DynamicItem)localObject).a)))
      {
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if (paramViewHolder != null)
        {
          QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, json = ", ((TopBannerInfo.DynamicItem)localObject).a });
          ProteusSupportUtilBase.a(paramViewHolder, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter.a(), b(), ((TopBannerInfo.DynamicItem)localObject).a);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyDynamicChannelAdapter localReadInJoyDynamicChannelAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsCompatReadInJoyDynamicChannelAdapter;
    if (localReadInJoyDynamicChannelAdapter != null) {
      localReadInJoyDynamicChannelAdapter.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */