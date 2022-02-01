package com.tencent.mobileqq.studyroom.utils;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$initLoadingView$1$1
  implements View.OnClickListener
{
  StudyRoomQShadowLauncher$initLoadingView$1$1(StudyRoomQShadowLauncher.initLoadingView.1 param1) {}
  
  public final void onClick(View paramView)
  {
    if (StudyRoomQShadowLauncher.b(this.a.this$0) != null) {
      StudyRoomQShadowLauncher.a(this.a.this$0).cancel(true);
    }
    StudyRoomQShadowLauncher.a(this.a.this$0).onCloseLoadingView();
    StudyRoomQShadowLauncher.a(this.a.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.initLoadingView.1.1
 * JD-Core Version:    0.7.0.1
 */