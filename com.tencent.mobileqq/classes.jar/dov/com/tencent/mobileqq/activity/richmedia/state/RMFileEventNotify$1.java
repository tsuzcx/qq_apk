package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.widget.Toast;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

class RMFileEventNotify$1
  implements Runnable
{
  RMFileEventNotify$1(RMFileEventNotify paramRMFileEventNotify) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[runOnUIThread][stopWatching-delete-quit]");
    }
    Toast.makeText(VideoEnvironment.getContext(), HardCodeUtil.a(2131713406), 1).show();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a("RMFileEventNotify");
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMFileEventNotify.1
 * JD-Core Version:    0.7.0.1
 */