package com.tencent.mobileqq.studyroom.utils;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$updateLaunchStep$1$4
  implements View.OnClickListener
{
  StudyRoomQShadowLauncher$updateLaunchStep$1$4(StudyRoomQShadowLauncher.updateLaunchStep.1 param1) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.a;
    if (paramView != null) {
      paramView = (Unit)paramView.invoke();
    }
    paramView = StudyRoomQShadowLauncher.a(this.a.this$0);
    if (paramView != null) {
      paramView.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.updateLaunchStep.1.4
 * JD-Core Version:    0.7.0.1
 */