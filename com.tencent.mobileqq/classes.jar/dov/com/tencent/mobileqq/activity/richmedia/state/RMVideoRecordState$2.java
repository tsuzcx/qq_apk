package dov.com.tencent.mobileqq.activity.richmedia.state;

import alud;
import bnhp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class RMVideoRecordState$2
  implements Runnable
{
  public RMVideoRecordState$2(bnhp parambnhp) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风读取数据错误...");
    }
    localRMVideoStateMgr.f = true;
    localRMVideoStateMgr.d = false;
    if (localRMVideoStateMgr.a != null)
    {
      if (localRMVideoStateMgr.a.i != -1) {
        break label95;
      }
      localRMVideoStateMgr.b(0, alud.a(2131713867), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风被禁用,音频录制失败 errorcode=" + localRMVideoStateMgr.a.i);
      }
      return;
      label95:
      if (localRMVideoStateMgr.a.i == -2) {
        localRMVideoStateMgr.b(0, alud.a(2131713863), false);
      } else if (localRMVideoStateMgr.a.i == -3) {
        localRMVideoStateMgr.b(0, alud.a(2131713862), false);
      } else {
        localRMVideoStateMgr.b(0, alud.a(2131713865), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2
 * JD-Core Version:    0.7.0.1
 */