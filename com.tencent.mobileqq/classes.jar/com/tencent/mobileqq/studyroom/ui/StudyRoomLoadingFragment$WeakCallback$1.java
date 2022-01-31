package com.tencent.mobileqq.studyroom.ui;

import android.support.v4.app.FragmentActivity;
import azxu;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class StudyRoomLoadingFragment$WeakCallback$1
  implements Runnable
{
  public StudyRoomLoadingFragment$WeakCallback$1(azxu paramazxu) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)azxu.a(this.this$0).get();
    if ((localStudyRoomLoadingFragment == null) || (localStudyRoomLoadingFragment.getActivity() == null)) {
      return;
    }
    QQToast.a(localStudyRoomLoadingFragment.getActivity().getApplicationContext(), 1, 2131699266, 0).a();
    StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
    localStudyRoomLoadingFragment.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.1
 * JD-Core Version:    0.7.0.1
 */