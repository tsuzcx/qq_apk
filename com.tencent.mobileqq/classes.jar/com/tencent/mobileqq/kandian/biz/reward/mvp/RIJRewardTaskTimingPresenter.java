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
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @NotNull
  private IRIJRewardTaskTimingContract.IModel jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel;
  private IRIJRewardTaskTimingContract.IView jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IView;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  
  private RIJRewardTaskTimingPresenter(@NotNull IRIJRewardTaskTimingContract.IModel paramIModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel = paramIModel;
  }
  
  private int a()
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = 0L;
    if (l2 > 0L) {
      l1 = NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long;
    }
    return (int)Math.max(l1, 33L);
  }
  
  public static RIJRewardTaskTimingPresenter a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return new RIJRewardTaskTimingPresenter(new RIJRewardTaskTimingModel());
    }
    return new RIJRewardTaskTimingPresenter(new RIJRewardTaskTimingModelForTool());
  }
  
  private Runnable a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    return new RIJRewardTaskTimingPresenter.1(this, paramInt1, paramString, paramInt2);
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
      b();
      return true;
    }
    return false;
  }
  
  private boolean a(RIJRewardTask paramRIJRewardTask)
  {
    return (paramRIJRewardTask.c() > RIJUserLevelTimeUtils.a()) && (RIJUserLevelTimeUtils.a());
  }
  
  private boolean a(boolean paramBoolean, RIJRewardTask paramRIJRewardTask, int paramInt)
  {
    int i = paramRIJRewardTask.c();
    return ((paramBoolean) || (i > paramInt)) && (RIJRewardTaskConfig.a());
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a();
    if (localRIJRewardTask == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop timing --> curTask: ");
    localStringBuilder.append(localRIJRewardTask.toString());
    QLog.i("RIJRewardTaskTimingPresenter", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a(localRIJRewardTask.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.b(localRIJRewardTask);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a(null);
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.b();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a();
    int j = 0;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new RIJRewardTask(paramString, paramInt2, paramInt1, 0);
      localObject1 = localObject2;
      if (localRIJRewardTask != null)
      {
        localObject1 = localObject2;
        if (localRIJRewardTask.a().equals(((RIJRewardTask)localObject2).a()))
        {
          ((RIJRewardTask)localObject2).a(((RIJRewardTask)localObject2).c() + localRIJRewardTask.c());
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startTiming --> curTask: ");
    ((StringBuilder)localObject2).append(localObject1.toString());
    QLog.i("RIJRewardTaskTimingPresenter", 1, ((StringBuilder)localObject2).toString());
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a(paramString))
    {
      i = j;
      if (localRIJRewardTask != null)
      {
        i = j;
        if (!localRIJRewardTask.a().equals(paramString)) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      QLog.i("RIJRewardTaskTimingPresenter", 1, "startTiming --> hasReadButNotLastRead = true");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a(localObject1);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaLangRunnable = a(paramString, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b()
  {
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a();
    if (localRIJRewardTask == null)
    {
      QLog.e("RIJRewardTaskTimingPresenter", 1, "reportTaskCompleted, task == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report task progress --> task: ");
    localStringBuilder.append(localRIJRewardTask.toString());
    QLog.i("RIJRewardTaskTimingPresenter", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardMvpIRIJRewardTaskTimingContract$IModel.a(localRIJRewardTask.a(), localRIJRewardTask.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter
 * JD-Core Version:    0.7.0.1
 */