package com.tencent.mobileqq.studyroom.utils;

import com.tencent.mobileqq.qroute.module.IQRoutePlugin.OnOpenResultListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onOpenResult"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$loadPlugin$param$1
  implements IQRoutePlugin.OnOpenResultListener
{
  StudyRoomQShadowLauncher$loadPlugin$param$1(StudyRoomQShadowLauncher paramStudyRoomQShadowLauncher, CountDownLatch paramCountDownLatch) {}
  
  public final void onOpenResult(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load result ");
    localStringBuilder.append(paramBoolean);
    QLog.i("studyroom.QShadowLauncher", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      StudyRoomQShadowLauncher.a(this.a, 5, null, null, null, null, 30, null);
      StudyRoomQShadowLauncher.a(this.a, 0);
    }
    else
    {
      StudyRoomQShadowLauncher.a(this.a, 4, "加载失败，请重试!", "请检查网络设置后重试", "重新加载", null, 16, null);
      StudyRoomQShadowLauncher.a(this.a, 5);
    }
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.loadPlugin.param.1
 * JD-Core Version:    0.7.0.1
 */