package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.content.res.Configuration;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class KanDianViewController$KandianViewControllerObserver
  extends ReadInJoyObserver
{
  protected KanDianViewController$KandianViewControllerObserver(KanDianViewController paramKanDianViewController) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt, paramAbsBaseArticleInfo, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString, List<AbsBaseArticleInfo> paramList, IInsertArticleCallback paramIInsertArticleCallback)
  {
    int i;
    if (paramInt == 1) {
      i = 0;
    } else {
      i = 100;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertArticleList, rowKey: ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" articleList: ");
    localStringBuilder.append(paramList);
    localStringBuilder.append(" delayTime:");
    localStringBuilder.append(i);
    QLog.d("KanDianViewController", 1, new Object[] { localObject, localStringBuilder.toString() });
    ThreadManager.getUIHandler().postDelayed(new KanDianViewController.KandianViewControllerObserver.1(this, paramString, paramList, paramIInsertArticleCallback, paramInt), i);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (KanDianViewController.a(this.a) != null)
    {
      KanDianViewController.a(this.a).f();
      KanDianViewController.a(this.a).g();
    }
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramConfiguration);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(Long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("followArticle, pUin: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("KanDianViewController", 1, ((StringBuilder)localObject).toString());
    if (((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup)) && (KanDianViewController.a(this.a).a() == 0) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a() != null) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a() != null))
    {
      localObject = ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a().a();
      KanDianViewController.a(this.a, paramLong, (List)localObject);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    KanDianViewController.a(this.a).put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void as_()
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).r();
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c()
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).n();
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup)))
    {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).b(paramInt, paramList);
      KanDianViewController.a(this.a, true);
    }
  }
  
  public void d(int paramInt, List<ChannelBannerInfo> paramList)
  {
    if ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void j_(int paramInt)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.KandianViewControllerObserver
 * JD-Core Version:    0.7.0.1
 */