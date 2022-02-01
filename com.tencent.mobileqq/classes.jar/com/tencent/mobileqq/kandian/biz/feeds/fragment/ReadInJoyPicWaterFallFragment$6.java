package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ReadInJoyPicWaterFallFragment$6
  implements ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface
{
  ReadInJoyPicWaterFallFragment$6(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public AbsBaseArticleInfo a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a.size() > 0) && (paramInt < this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a.size())) {
      return (AbsBaseArticleInfo)this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a.get(paramInt);
    }
    return null;
  }
  
  public List<AbsBaseArticleInfo> a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.notifyDataSetChanged();
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ReadInJoyPicWaterFallFragment.b(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a.remove(paramAbsBaseArticleInfo);
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.notifyItemRemoved(paramInt);
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a(paramList);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    Map localMap = ReadinjoyReportUtils.a(this.a.b());
    String str = RIJKanDianFolderStatus.getFolderStatus(this.a.b());
    ThreadManager.post(new ReadInJoyPicWaterFallFragment.6.1(this, this.a.g(), paramMap, paramBoolean, localMap, str), 5, null, false);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    this.a.a(paramMap, paramBoolean, paramMap1, paramString);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    ReadInJoyPicWaterFallFragment localReadInJoyPicWaterFallFragment = this.a;
    localReadInJoyPicWaterFallFragment.jdField_a_of_type_JavaUtilSet = paramSet;
    localReadInJoyPicWaterFallFragment.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a(paramBoolean, paramString);
  }
  
  public boolean a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.getItemCount() == 0;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.c();
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.a.removeAll(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.b(paramBoolean);
  }
  
  public void c()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.d();
  }
  
  public void c(List<ChannelCoverInfo> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshSubChannelData channelList size:");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshSubChannelData mClassificationListView =");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView);
      ((StringBuilder)localObject).append(",showSub = ");
      ((StringBuilder)localObject).append(this.a.e);
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView != null)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ChannelCoverInfo)paramList.next();
        this.a.jdField_a_of_type_JavaUtilArrayList.add(new ReadInJoyPicWaterFallFragment.ClassData((ChannelCoverInfo)localObject, ((ChannelCoverInfo)localObject).mChannelCoverName, String.valueOf(((ChannelCoverInfo)localObject).mChannelCoverId)));
      }
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.6
 * JD-Core Version:    0.7.0.1
 */