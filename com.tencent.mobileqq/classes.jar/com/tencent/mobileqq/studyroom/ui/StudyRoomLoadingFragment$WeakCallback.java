package com.tencent.mobileqq.studyroom.ui;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.studyroom.utils.PluginUtils.PluginCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class StudyRoomLoadingFragment$WeakCallback
  implements PluginUtils.PluginCallback
{
  private WeakReference<StudyRoomLoadingFragment> a;
  
  public StudyRoomLoadingFragment$WeakCallback(StudyRoomLoadingFragment paramStudyRoomLoadingFragment)
  {
    this.a = new WeakReference(paramStudyRoomLoadingFragment);
  }
  
  public void a(Throwable paramThrowable)
  {
    ThreadManager.getUIHandler().post(new StudyRoomLoadingFragment.WeakCallback.1(this));
  }
  
  public void onCloseLoadingView()
  {
    QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onCloseLoadingView");
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)this.a.get();
    if (localStudyRoomLoadingFragment != null)
    {
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
      localStudyRoomLoadingFragment.a();
    }
  }
  
  public void onEnterComplete()
  {
    QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onEnterComplete");
    ThreadManager.getUIHandler().postDelayed(new StudyRoomLoadingFragment.WeakCallback.3(this), 2000L);
  }
  
  public void onShowLoadingView(View paramView)
  {
    QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onShowLoadingView");
    ThreadManager.getUIHandler().post(new StudyRoomLoadingFragment.WeakCallback.2(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback
 * JD-Core Version:    0.7.0.1
 */