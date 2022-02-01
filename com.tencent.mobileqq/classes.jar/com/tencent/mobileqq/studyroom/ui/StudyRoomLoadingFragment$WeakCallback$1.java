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
      QQToast.makeText(localStudyRoomLoadingFragment.getQBaseActivity().getApplicationContext(), 1, 2131896777, 0).show();
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
      localStudyRoomLoadingFragment.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.1
 * JD-Core Version:    0.7.0.1
 */