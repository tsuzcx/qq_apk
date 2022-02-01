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
  
  public void a()
  {
    this.a.o.notifyDataSetChanged();
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ReadInJoyPicWaterFallFragment.b(this.a);
    this.a.o.b.remove(paramAbsBaseArticleInfo);
    this.a.o.notifyItemRemoved(paramInt);
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.a.o.a(paramList);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    Map localMap = ReadinjoyReportUtils.a(this.a.d());
    String str = RIJKanDianFolderStatus.getFolderStatus(this.a.d());
    ThreadManager.post(new ReadInJoyPicWaterFallFragment.6.1(this, this.a.y(), paramMap, paramBoolean, localMap, str), 5, null, false);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    this.a.a(paramMap, paramBoolean, paramMap1, paramString);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    ReadInJoyPicWaterFallFragment localReadInJoyPicWaterFallFragment = this.a;
    localReadInJoyPicWaterFallFragment.s = paramSet;
    localReadInJoyPicWaterFallFragment.t = paramMap;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.n.a(paramBoolean, paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.n.a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public AbsBaseArticleInfo b(int paramInt)
  {
    if ((this.a.o.b.size() > 0) && (paramInt < this.a.o.b.size())) {
      return (AbsBaseArticleInfo)this.a.o.b.get(paramInt);
    }
    return null;
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    this.a.o.b.removeAll(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.n.a(paramBoolean);
  }
  
  public boolean b()
  {
    return this.a.o.getItemCount() == 0;
  }
  
  public List<AbsBaseArticleInfo> c()
  {
    return this.a.o.b;
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
      ((StringBuilder)localObject).append(this.a.a);
      ((StringBuilder)localObject).append(",showSub = ");
      ((StringBuilder)localObject).append(this.a.d);
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.a != null)
    {
      this.a.r.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ChannelCoverInfo)paramList.next();
        this.a.r.add(new ReadInJoyPicWaterFallFragment.ClassData((ChannelCoverInfo)localObject, ((ChannelCoverInfo)localObject).mChannelCoverName, String.valueOf(((ChannelCoverInfo)localObject).mChannelCoverId)));
      }
      this.a.o.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    this.a.n.h();
  }
  
  public void e()
  {
    this.a.n.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.6
 * JD-Core Version:    0.7.0.1
 */