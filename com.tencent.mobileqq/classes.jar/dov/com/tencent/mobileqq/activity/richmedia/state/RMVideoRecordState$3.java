package dov.com.tencent.mobileqq.activity.richmedia.state;

import bndd;
import bndk;
import wsv;

public class RMVideoRecordState$3
  implements Runnable
{
  public RMVideoRecordState$3(bndd parambndd) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.a())
    {
      wsv.c("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.this$0.b();
    localRMVideoStateMgr.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
 * JD-Core Version:    0.7.0.1
 */