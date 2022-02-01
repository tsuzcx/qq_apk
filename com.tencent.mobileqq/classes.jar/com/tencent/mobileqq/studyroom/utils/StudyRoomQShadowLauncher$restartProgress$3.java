package com.tencent.mobileqq.studyroom.utils;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$restartProgress$3
  implements Runnable
{
  StudyRoomQShadowLauncher$restartProgress$3(StudyRoomQShadowLauncher paramStudyRoomQShadowLauncher) {}
  
  public final void run()
  {
    if (StudyRoomQShadowLauncher.v(this.this$0) > 90)
    {
      StudyRoomQShadowLauncher.g(this.this$0).a();
      QLog.i("studyroom.QShadowLauncher", 1, "touch max fake progress");
      return;
    }
    StudyRoomQShadowLauncher localStudyRoomQShadowLauncher = this.this$0;
    StudyRoomQShadowLauncher.b(localStudyRoomQShadowLauncher, StudyRoomQShadowLauncher.v(localStudyRoomQShadowLauncher) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.restartProgress.3
 * JD-Core Version:    0.7.0.1
 */