package dov.com.tencent.mobileqq.activity.richmedia.state;

import alud;
import android.widget.Toast;
import bnhk;
import bnhw;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class RMFileEventNotify$1
  implements Runnable
{
  public RMFileEventNotify$1(bnhk parambnhk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[runOnUIThread][stopWatching-delete-quit]");
    }
    Toast.makeText(VideoEnvironment.a(), alud.a(2131713843), 1).show();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a("RMFileEventNotify");
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMFileEventNotify.1
 * JD-Core Version:    0.7.0.1
 */