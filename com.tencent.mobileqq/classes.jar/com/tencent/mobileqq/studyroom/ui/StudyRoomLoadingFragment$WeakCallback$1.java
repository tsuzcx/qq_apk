package com.tencent.mobileqq.studyroom.ui;

import android.support.v4.app.FragmentActivity;
import bacd;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class StudyRoomLoadingFragment$WeakCallback$1
  implements Runnable
{
  public StudyRoomLoadingFragment$WeakCallback$1(bacd parambacd) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)bacd.a(this.this$0).get();
    if ((localStudyRoomLoadingFragment == null) || (localStudyRoomLoadingFragment.getActivity() == null)) {
      return;
    }
    QQToast.a(localStudyRoomLoadingFragment.getActivity().getApplicationContext(), 1, 2131699278, 0).a();
    StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
    localStudyRoomLoadingFragment.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.1
 * JD-Core Version:    0.7.0.1
 */