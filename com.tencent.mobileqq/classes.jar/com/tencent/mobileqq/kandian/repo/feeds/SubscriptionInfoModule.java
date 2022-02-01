package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class SubscriptionInfoModule
  extends ReadInJoyEngineModule
{
  private long a = 0L;
  private volatile boolean b = false;
  private List<SubscriptionFeed> c = null;
  private IPublicAccountObserver d = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
  private IPublicAccountObserver.OnCallback e = new SubscriptionInfoModule.8(this);
  private Handler f = new SubscriptionInfoModule.9(this, ThreadManager.getSubThreadLooper());
  
  public SubscriptionInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.d.setOnCallback(this.e);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.mMainThreadHandler.post(new SubscriptionInfoModule.7(this, paramInt1, paramInt2));
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (!TroopBarAssistantManager.a().b(paramString, (QQAppInterface)this.mApp))
    {
      TroopBarAssistantManager.a().c(paramString, (QQAppInterface)this.mApp);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
      int k = TroopBarAssistantManager.a().d();
      int j = 0;
      Object localObject1 = this.c.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (SubscriptionFeed)((Iterator)localObject1).next();
      } while ((((SubscriptionFeed)localObject2).c == null) || (!((SubscriptionFeed)localObject2).c.equals(paramString)));
      int i = ((SubscriptionFeed)localObject2).b;
      e();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(k);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CD", "0X80064CD", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    this.mExecutorService.execute(new SubscriptionInfoModule.5(this, paramString, paramContext));
    int j = 0;
    paramContext = this.c.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      i = j;
      if (!paramContext.hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)paramContext.next();
    } while ((localSubscriptionFeed.c == null) || (!localSubscriptionFeed.c.equals(paramString)));
    int i = localSubscriptionFeed.b;
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(i);
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CF", "0X80064CF", 0, 0, paramContext.toString(), "", "", "");
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    if (this.mMainThreadHandler == null) {
      return;
    }
    this.mMainThreadHandler.post(new SubscriptionInfoModule.3(this, paramList));
  }
  
  public void b()
  {
    boolean bool = this.mApp instanceof QQAppInterface;
  }
  
  public void b(String paramString)
  {
    TroopBarAssistantManager.a().d(paramString, (QQAppInterface)this.mApp);
    int j = TroopBarAssistantManager.a().d();
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SubscriptionFeed)((Iterator)localObject1).next();
      if ((((SubscriptionFeed)localObject2).c != null) && (((SubscriptionFeed)localObject2).c.equals(paramString)))
      {
        i = ((SubscriptionFeed)localObject2).b;
        break label85;
      }
    }
    int i = 0;
    label85:
    e();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(i);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(j);
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CE", "0X80064CE", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
  }
  
  public void c()
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
      }
      return;
    }
    if (this.mExecutorService == null) {
      return;
    }
    this.mExecutorService.execute(new SubscriptionInfoModule.1(this));
  }
  
  public void c(String paramString)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    TroopBarAssistantManager.a().a(paramString, (QQAppInterface)this.mApp);
    e();
    this.mExecutorService.execute(new SubscriptionInfoModule.6(this, paramString));
    Object localObject = this.mApp.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1014);
    }
    int j = 0;
    localObject = this.c.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      i = j;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)((Iterator)localObject).next();
    } while ((localSubscriptionFeed.c == null) || (!localSubscriptionFeed.c.equals(paramString)));
    int i = localSubscriptionFeed.b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(i);
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064D0", "0X80064D0", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
  }
  
  public void d() {}
  
  public void e()
  {
    if ((this.mApp instanceof QQAppInterface))
    {
      this.mExecutorService.execute(new SubscriptionInfoModule.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface");
    }
  }
  
  public void f()
  {
    a(((KandianMergeManager)((QQAppInterface)this.mApp).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(1), 1);
  }
  
  public int g()
  {
    boolean bool = this.mApp instanceof QQAppInterface;
    int i = 0;
    if (!bool) {
      return 0;
    }
    Iterator localIterator = TroopBarAssistantManager.a().i((QQAppInterface)this.mApp).iterator();
    while (localIterator.hasNext()) {
      i += ((SubscriptionFeed)localIterator.next()).b;
    }
    return i;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void unInitialize()
  {
    this.d = null;
    Handler localHandler = this.f;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.f = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule
 * JD-Core Version:    0.7.0.1
 */