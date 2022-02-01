package dov.com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.biz.qqstory.support.logging.SLog;

class RMVideoRecordState$3
  implements Runnable
{
  RMVideoRecordState$3(RMVideoRecordState paramRMVideoRecordState) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.a())
    {
      SLog.c("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.this$0.b();
    localRMVideoStateMgr.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
 * JD-Core Version:    0.7.0.1
 */