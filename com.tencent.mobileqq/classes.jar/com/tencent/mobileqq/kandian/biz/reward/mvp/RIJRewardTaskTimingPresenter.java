package com.tencent.mobileqq.kandian.biz.reward.mvp;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelTimeUtils;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class RIJRewardTaskTimingPresenter
  implements IRIJRewardTaskTimingContract.IPresenter
{
  @NotNull
  private IRIJRewardTaskTimingContract.IModel a;
  private IRIJRewardTaskTimingContract.IView b;
  private Handler c = new Handler(Looper.getMainLooper());
  private Runnable d = null;
  private long e = 0L;
  
  private RIJRewardTaskTimingPresenter(@NotNull IRIJRewardTaskTimingContract.IModel paramIModel)
  {
    this.a = paramIModel;
  }
  
  public static RIJRewardTaskTimingPresenter a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return new RIJRewardTaskTimingPresenter(new RIJRewardTaskTimingModel());
    }
    return new RIJRewardTaskTimingPresenter(new RIJRewardTaskTimingModelForTool());
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt > 600000L) && (RIJUserLevelTimeUtils.a()))
    {
      RIJUserLevelTimeUtils.b(paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > paramInt2) && (RIJRewardTaskConfig.a()))
    {
      c();
      return true;
    }
    return false;
  }
  
  private boolean a(RIJRewardTask paramRIJRewardTask)
  {
    return (paramRIJRewardTask.e() > RIJUserLevelTimeUtils.b()) && (RIJUserLevelTimeUtils.a());
  }
  
  private boolean a(boolean paramBoolean, RIJRewardTask paramRIJRewardTask, int paramInt)
  {
    int i = paramRIJRewardTask.e();
    return ((paramBoolean) || (i > paramInt)) && (RIJRewardTaskConfig.a());
  }
  
  private Runnable b(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    return new RIJRewardTaskTimingPresenter.1(this, paramInt1, paramString, paramInt2);
  }
  
  private int d()
  {
    long l2 = this.e;
    long l1 = 0L;
    if (l2 > 0L) {
      l1 = NetConnInfoCenter.getServerTimeMillis() - this.e;
    }
    return (int)Math.max(l1, 33L);
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    RIJRewardTask localRIJRewardTask = this.a.b();
    Object localObject2 = this.a.a();
    int j = 0;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new RIJRewardTask(paramString, paramInt2, paramInt1, 0);
      localObject1 = localObject2;
      if (localRIJRewardTask != null)
      {
        localObject1 = localObject2;
        if (localRIJRewardTask.b().equals(((RIJRewardTask)localObject2).b()))
        {
          ((RIJRewardTask)localObject2).a(((RIJRewardTask)localObject2).e() + localRIJRewardTask.e());
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startTiming --> curTask: ");
    ((StringBuilder)localObject2).append(localObject1.toString());
    QLog.i("RIJRewardTaskTimingPresenter", 1, ((StringBuilder)localObject2).toString());
    int i = j;
    if (this.a.a(paramString))
    {
      i = j;
      if (localRIJRewardTask != null)
      {
        i = j;
        if (!localRIJRewardTask.b().equals(paramString)) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      QLog.i("RIJRewardTaskTimingPresenter", 1, "startTiming --> hasReadButNotLastRead = true");
      return;
    }
    this.a.a(localObject1);
    this.c.removeCallbacksAndMessages(null);
    this.d = b(paramString, paramInt1, paramInt2);
    this.c.post(this.d);
  }
  
  public void b()
  {
    this.c.removeCallbacksAndMessages(null);
    RIJRewardTask localRIJRewardTask = this.a.a();
    if (localRIJRewardTask == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop timing --> curTask: ");
    localStringBuilder.append(localRIJRewardTask.toString());
    QLog.i("RIJRewardTaskTimingPresenter", 1, localStringBuilder.toString());
    this.a.b(localRIJRewardTask.b());
    this.a.b(localRIJRewardTask);
    this.a.a(null);
  }
  
  public void c()
  {
    RIJRewardTask localRIJRewardTask = this.a.a();
    if (localRIJRewardTask == null)
    {
      QLog.e("RIJRewardTaskTimingPresenter", 1, "reportTaskCompleted, task == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report task progress --> task: ");
    localStringBuilder.append(localRIJRewardTask.toString());
    QLog.i("RIJRewardTaskTimingPresenter", 1, localStringBuilder.toString());
    this.a.a(localRIJRewardTask.b(), localRIJRewardTask.c(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter
 * JD-Core Version:    0.7.0.1
 */