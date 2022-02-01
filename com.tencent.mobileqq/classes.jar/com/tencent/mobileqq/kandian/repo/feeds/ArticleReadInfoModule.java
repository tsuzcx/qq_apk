package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleReadInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class ArticleReadInfoModule
  extends ReadInJoyEngineModule
{
  private AtomicBoolean a = new AtomicBoolean(false);
  private HashMap<Long, ArticleReadInfo> b = new LinkedHashMap();
  private IFindRemovedEntity<ArticleReadInfo> c = new ArticleReadInfoModule.1(this);
  
  public ArticleReadInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    registerEntityFinder(ArticleReadInfo.class, this.c);
  }
  
  private void a(List<ArticleReadInfo> paramList)
  {
    if (this.mMainThreadHandler == null) {
      return;
    }
    this.mMainThreadHandler.post(new ArticleReadInfoModule.3(this, paramList));
  }
  
  public void a()
  {
    if (this.a.get())
    {
      QLog.d("ArticleReadInfoModule", 1, "article read info has loaded");
      return;
    }
    this.mExecutorService.execute(new ArticleReadInfoModule.2(this));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.b.get(Long.valueOf(paramLong1));
    if (localArticleReadInfo == null)
    {
      localArticleReadInfo = new ArticleReadInfo();
      localArticleReadInfo.mArticleID = paramLong1;
      localArticleReadInfo.mLastReadTime = paramLong2;
      localArticleReadInfo.mIsRead = true;
    }
    else
    {
      localArticleReadInfo.mLastReadTime = paramLong2;
      localArticleReadInfo.mIsRead = true;
    }
    a(localArticleReadInfo);
    this.mExecutorService.execute(new ArticleReadInfoModule.4(this, localArticleReadInfo));
  }
  
  public void a(ArticleReadInfo paramArticleReadInfo)
  {
    this.b.put(Long.valueOf(paramArticleReadInfo.mArticleID), paramArticleReadInfo);
  }
  
  public boolean a(long paramLong)
  {
    return this.b.get(Long.valueOf(paramLong)) != null;
  }
  
  public void b(long paramLong)
  {
    Object localObject = (ArticleReadInfo)this.b.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      this.b.remove(Long.valueOf(paramLong));
      this.mExecutorService.execute(new ArticleReadInfoModule.5(this, (ArticleReadInfo)localObject));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DeleteArticle ReadInfo , articleID : ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("ArticleInfo", 2, ((StringBuilder)localObject).toString());
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void unInitialize()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleReadInfoModule
 * JD-Core Version:    0.7.0.1
 */