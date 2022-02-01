package dov.com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.qphone.base.util.QLog;

class RMVideoIdleState
  extends RMVideoState
{
  public void a()
  {
    RMVideoStateMgr.a().a.c();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] initState end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoIdleState
 * JD-Core Version:    0.7.0.1
 */