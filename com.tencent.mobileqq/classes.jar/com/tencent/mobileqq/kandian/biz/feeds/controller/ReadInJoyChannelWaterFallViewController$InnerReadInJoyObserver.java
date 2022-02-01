package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class ReadInJoyChannelWaterFallViewController$InnerReadInJoyObserver
  extends ReadInJoyObserver
{
  private ReadInJoyChannelWaterFallViewController$InnerReadInJoyObserver(ReadInJoyChannelWaterFallViewController paramReadInJoyChannelWaterFallViewController) {}
  
  private void d(List<Long> paramList)
  {
    Object localObject = RIJQQAppInterfaceUtil.e();
    if (FeedsSPUtils.a((AppRuntime)localObject))
    {
      if (!ReadInJoyHelper.ap((AppRuntime)localObject)) {
        return;
      }
      if (paramList != null)
      {
        if (paramList.isEmpty()) {
          return;
        }
        int j = paramList.size();
        int i = 5;
        if (j <= 5) {
          i = paramList.size();
        }
        localObject = new ArrayList();
        j = 0;
        while (j < i)
        {
          long l = ((Long)paramList.get(j)).longValue();
          AbsBaseArticleInfo localAbsBaseArticleInfo = ReadInJoyLogicEngine.a().a(ReadInJoyChannelWaterFallViewController.a(this.a), l);
          if ((localAbsBaseArticleInfo != null) && (!RIJFeedsType.a(localAbsBaseArticleInfo))) {
            ((ArrayList)localObject).add(localAbsBaseArticleInfo);
          }
          j += 1;
        }
        ReadInJoyLogicEngine.a().d().a((List)localObject);
      }
    }
  }
  
  private void e(String paramString) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (paramInt != ReadInJoyChannelWaterFallViewController.a(this.a)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = ReadInJoyLogicEngine.a().a(ReadInJoyChannelWaterFallViewController.a(this.a), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load history successful ! first article title : ");
      if (localObject2 != null) {
        localObject1 = ((AbsBaseArticleInfo)localObject2).mTitle;
      } else {
        localObject1 = "";
      }
      localStringBuilder.append(RIJAppSetting.b((String)localObject1));
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" articleID : ");
      if (localObject2 != null) {
        localObject1 = Long.valueOf(((AbsBaseArticleInfo)localObject2).mArticleID);
      } else {
        localObject1 = "-1";
      }
      localStringBuilder.append(localObject1);
      localObject1 = localStringBuilder.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ReadInJoyChannelWaterFallViewController_");
      ((StringBuilder)localObject2).append(ReadInJoyChannelWaterFallViewController.a(this.a));
      QLog.d(((StringBuilder)localObject2).toString(), 1, (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("recommendSeq = ");
          localStringBuilder.append(localObject2);
          localStringBuilder.append(",\n ");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
        paramList = new StringBuilder();
        paramList.append("ReadInJoyChannelWaterFallViewController_");
        paramList.append(ReadInJoyChannelWaterFallViewController.a(this.a));
        QLog.d(paramList.toString(), 1, ((StringBuilder)localObject1).toString());
      }
    }
    this.a.a.a(true, true);
    paramList = this.a;
    if (!ReadInJoyChannelWaterFallViewController.a(paramList, ReadInJoyChannelWaterFallViewController.b(paramList) ^ true)) {
      ReadInJoyChannelWaterFallViewController.c(this.a);
    }
    if (!ReadInJoyChannelWaterFallViewController.b(this.a)) {
      ReadInJoyChannelWaterFallViewController.b(this.a, true);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    super.a(paramInt, paramBoolean, paramList);
    if ((paramInt == ReadInJoyChannelWaterFallViewController.a(this.a)) && (paramBoolean) && (paramList != null) && (!paramList.isEmpty())) {
      this.a.a.c(paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo) {}
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().f()) {
      return;
    }
    PreloadManager.a().h();
    ReadInJoyChannelWaterFallViewController.a(this.a);
    if ((paramList != null) && (paramList.size() >= 5))
    {
      int i = 0;
      while (i < 5)
      {
        long l = ((Long)paramList.get(i)).longValue();
        Object localObject = ReadInJoyLogicEngine.a().a(ReadInJoyChannelWaterFallViewController.a(this.a), l);
        if ((localObject != null) && (!RIJFeedsType.a(((AbsBaseArticleInfo)localObject).mArticleContentUrl, ((AbsBaseArticleInfo)localObject).mChannelID, (AbsBaseArticleInfo)localObject)) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!ReadInJoyLogicEngine.a().a(((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().b((String)localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyChannelWaterFallViewController.a(this.a)) {
      return;
    }
    paramInt = ReadInJoyLogicEngine.a().b(Integer.valueOf(paramInt));
    if (paramBoolean1)
    {
      Object localObject1;
      if ((paramList != null) && (paramInt > 0) && (paramList.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder("onChannelRefreshed ");
          Object localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject2).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("recommendSeq = ");
            localStringBuilder.append(localLong);
            localStringBuilder.append(",\n ");
            ((StringBuilder)localObject1).append(localStringBuilder.toString());
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ReadInJoyChannelWaterFallViewController_");
          ((StringBuilder)localObject2).append(ReadInJoyChannelWaterFallViewController.a(this.a));
          QLog.d(((StringBuilder)localObject2).toString(), 1, ((StringBuilder)localObject1).toString());
        }
        ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 1);
        localObject1 = String.format(this.a.cQ_().getResources().getString(2131915228), new Object[] { Integer.valueOf(paramInt) });
        this.a.a.a(true, (String)localObject1);
      }
      else if (this.a.a.b())
      {
        this.a.a.b(true);
        e(this.a.cQ_().getResources().getString(2131915491));
      }
      else
      {
        localObject1 = this.a.cQ_().getResources().getString(2131915227);
        this.a.a.a(true, (String)localObject1);
      }
    }
    else
    {
      if (this.a.a.b()) {
        e(this.a.cQ_().getResources().getString(2131915451));
      }
      this.a.a.b(paramBoolean1);
    }
    a(paramList);
    d(paramList);
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if (paramInt == ReadInJoyChannelWaterFallViewController.a(this.a))
    {
      if (paramList == null) {
        return;
      }
      paramList = ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList);
      this.a.a.b(paramList);
      this.a.a.a();
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyChannelWaterFallViewController.a(this.a))
    {
      ReadInJoyChannelWaterFallViewController.c(this.a, false);
      return;
    }
    if ((paramBoolean1) && (paramList != null)) {
      ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 2);
    }
    if ((paramBoolean1) && (paramList == null)) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    this.a.a.a(paramBoolean1, paramBoolean2 ^ true);
    if ((paramList != null) && (!paramList.isEmpty())) {
      ReadInJoyChannelWaterFallViewController.a(this.a, NetConnInfoCenter.getServerTime());
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("autoLoad:");
      paramList.append(ReadInJoyChannelWaterFallViewController.d(this.a));
      paramList.append(" noMoreData:");
      paramList.append(paramBoolean2);
      paramList.append(" fore:");
      paramList.append(GesturePWDUtils.isAppOnForeground(this.a.cQ_()));
      QLog.d("ReadInJoyChannelWaterFallViewController", 2, paramList.toString());
    }
    if ((!ReadInJoyChannelWaterFallViewController.d(this.a)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(this.a.cQ_())) && (ReadInJoyChannelWaterFallViewController.a(this.a) != 70))
    {
      paramList = this.a.cQ_().getResources().getString(2131915227);
      QQToast.makeText(this.a.cQ_().getApplicationContext(), paramList, 0).show();
    }
    ReadInJoyChannelWaterFallViewController.c(this.a, false);
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if (paramInt == ReadInJoyChannelWaterFallViewController.a(this.a))
    {
      if (paramList == null) {
        return;
      }
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder("refreshChannelData ");
          localStringBuilder1.append("channelID : ");
          localStringBuilder1.append(paramInt);
          localStringBuilder1.append("\n");
          Object localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject).next();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("recommendSeq = ");
            localStringBuilder2.append(localLong);
            localStringBuilder2.append(",\n ");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ReadInJoyChannelWaterFallViewController_");
          ((StringBuilder)localObject).append(ReadInJoyChannelWaterFallViewController.a(this.a));
          QLog.d(((StringBuilder)localObject).toString(), 1, localStringBuilder1.toString());
        }
        ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 1);
        return;
      }
      if (this.a.a.b()) {
        e(this.a.cQ_().getResources().getString(2131915491));
      }
    }
  }
  
  public void cE_()
  {
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController.InnerReadInJoyObserver
 * JD-Core Version:    0.7.0.1
 */