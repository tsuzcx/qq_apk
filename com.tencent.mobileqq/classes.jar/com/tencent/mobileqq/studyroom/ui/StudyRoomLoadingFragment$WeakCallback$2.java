package com.tencent.mobileqq.studyroom.ui;

import android.view.View;
import android.view.ViewGroup;
import bacd;
import mqq.util.WeakReference;

public class StudyRoomLoadingFragment$WeakCallback$2
  implements Runnable
{
  public StudyRoomLoadingFragment$WeakCallback$2(bacd parambacd, View paramView) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)bacd.a(this.this$0).get();
    if (localStudyRoomLoadingFragment != null)
    {
      View localView = localStudyRoomLoadingFragment.getView();
      if ((localView instanceof ViewGroup)) {
        ((ViewGroup)localView).addView(this.a);
      }
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.2
 * JD-Core Version:    0.7.0.1
 */