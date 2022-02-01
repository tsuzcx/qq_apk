package com.tencent.mobileqq.studyroom.ui;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

class StudyRoomLoadingFragment$WeakCallback$1
  implements Runnable
{
  StudyRoomLoadingFragment$WeakCallback$1(StudyRoomLoadingFragment.WeakCallback paramWeakCallback) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)StudyRoomLoadingFragment.WeakCallback.a(this.this$0).get();
    if (localStudyRoomLoadingFragment != null)
    {
      if (localStudyRoomLoadingFragment.getQBaseActivity() == null) {
        return;
      }
      QQToast.a(localStudyRoomLoadingFragment.getQBaseActivity().getApplicationContext(), 1, 2131698812, 0).a();
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
      localStudyRoomLoadingFragment.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.1
 * JD-Core Version:    0.7.0.1
 */