package com.tencent.mobileqq.kandian.biz.reward.mvp;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask.ITransaction;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.utils.Utils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class RIJRewardTaskTimingPresenter$1
  implements Runnable
{
  RIJRewardTaskTimingPresenter$1(RIJRewardTaskTimingPresenter paramRIJRewardTaskTimingPresenter, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    RIJRewardTask localRIJRewardTask = RIJRewardTaskTimingPresenter.a(this.this$0).a();
    if (localRIJRewardTask == null)
    {
      QLog.e("RIJRewardTaskTimingPresenter", 1, "timingRunnable --> curTask == null");
      return;
    }
    if (RIJRewardTaskTimingPresenter.a(this.this$0).a() >= RIJRewardTaskConfig.b()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (localRIJRewardTask.c() > this.jdField_a_of_type_Int) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timingRunnable --> taskAllCompletedToday: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", overMaxTaskTime: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", rowKey: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", maxTaskTimeInMs: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", type: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", timeDiff: ");
      localStringBuilder.append(RIJRewardTaskTimingPresenter.a(this.this$0));
      QLog.d("RIJRewardTaskTimingPresenter", 2, localStringBuilder.toString());
    }
    boolean bool2 = RIJRewardTaskTimingPresenter.a(this.this$0, bool1, localRIJRewardTask, this.jdField_a_of_type_Int);
    boolean bool3 = RIJRewardTaskTimingPresenter.a(this.this$0, localRIJRewardTask);
    if ((bool2) && (bool3))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("force stopTime: taskAllCompletedToday=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", maxTaskTimeInMs=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("curTask=");
        localStringBuilder.append(localRIJRewardTask);
        QLog.i("RIJRewardTaskTimingPresenter", 2, localStringBuilder.toString());
      }
      return;
    }
    int i = RIJRewardTaskTimingPresenter.a(this.this$0);
    RIJRewardTaskTimingPresenter.a(this.this$0, NetConnInfoCenter.getServerTimeMillis());
    int j = RIJRewardTaskConfig.a();
    int k = RIJRewardTaskTimingPresenter.a(this.this$0).a(true);
    int m = RIJRewardTaskTimingPresenter.a(this.this$0).a(false);
    localRIJRewardTask.a().a(localRIJRewardTask.c() + i).a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("missionCompletedTime=");
      localStringBuilder.append(j);
      localStringBuilder.append(", curTaskProgressInMs=");
      localStringBuilder.append(k);
      QLog.i("RIJRewardTaskTimingPresenter", 2, localStringBuilder.toString());
    }
    boolean bool1 = RIJRewardTaskTimingPresenter.a(this.this$0, k, j);
    bool2 = RIJRewardTaskTimingPresenter.a(this.this$0, m);
    if (bool1)
    {
      RIJRewardTaskTimingPresenter.a(this.this$0).a(0, true);
      if (RIJRewardTaskTimingPresenter.a(this.this$0) != null) {
        RIJRewardTaskTimingPresenter.a(this.this$0).a(0);
      }
    }
    if (bool2) {
      RIJRewardTaskTimingPresenter.a(this.this$0).a(0, false);
    }
    if ((bool1) && (bool2))
    {
      RIJRewardTaskTimingPresenter.a(this.this$0).postDelayed(RIJRewardTaskTimingPresenter.a(this.this$0), 33L);
      return;
    }
    if (!bool1) {
      RIJRewardTaskTimingPresenter.a(this.this$0).a(k + i, true);
    }
    if (!bool2) {
      RIJRewardTaskTimingPresenter.a(this.this$0).a(k + i, false);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (!Utils.a(l, l - i))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("over 24:00, curTs=");
        localStringBuilder.append(l);
        QLog.i("RIJRewardTaskTimingPresenter", 2, localStringBuilder.toString());
      }
      localRIJRewardTask.a().a(0).a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
      RIJRewardTaskTimingPresenter.a(this.this$0).a(0, true);
      RIJRewardTaskTimingPresenter.a(this.this$0).a(0, false);
      if (RIJRewardTaskTimingPresenter.a(this.this$0) != null) {
        RIJRewardTaskTimingPresenter.a(this.this$0).a(0);
      }
    }
    RIJRewardTaskTimingPresenter.a(this.this$0).postDelayed(RIJRewardTaskTimingPresenter.a(this.this$0), 33L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter.1
 * JD-Core Version:    0.7.0.1
 */