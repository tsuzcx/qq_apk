package dov.com.tencent.mobileqq.activity.richmedia.state;

import anzj;
import bran;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class RMVideoRecordState$2
  implements Runnable
{
  public RMVideoRecordState$2(bran parambran) {}
  
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
      localRMVideoStateMgr.b(0, anzj.a(2131712355), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风被禁用,音频录制失败 errorcode=" + localRMVideoStateMgr.a.i);
      }
      return;
      label95:
      if (localRMVideoStateMgr.a.i == -2) {
        localRMVideoStateMgr.b(0, anzj.a(2131712351), false);
      } else if (localRMVideoStateMgr.a.i == -3) {
        localRMVideoStateMgr.b(0, anzj.a(2131712350), false);
      } else {
        localRMVideoStateMgr.b(0, anzj.a(2131712353), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2
 * JD-Core Version:    0.7.0.1
 */