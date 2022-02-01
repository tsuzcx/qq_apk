package com.tencent.mobileqq.studyroom.ui;

import mqq.util.WeakReference;

class StudyRoomLoadingFragment$WeakCallback$3
  implements Runnable
{
  StudyRoomLoadingFragment$WeakCallback$3(StudyRoomLoadingFragment.WeakCallback paramWeakCallback) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)StudyRoomLoadingFragment.WeakCallback.a(this.this$0).get();
    if (localStudyRoomLoadingFragment != null)
    {
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
      localStudyRoomLoadingFragment.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.3
 * JD-Core Version:    0.7.0.1
 */