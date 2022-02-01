package dov.com.tencent.mobileqq.activity.richmedia.state;

import amtj;
import bbub;
import bnum;
import com.tencent.qphone.base.util.QLog;

public class RMVideoInitState$3
  implements Runnable
{
  public RMVideoInitState$3(bnum parambnum) {}
  
  public void run()
  {
    boolean bool = bbub.a(bbub.y);
    if (bool)
    {
      RMVideoStateMgr.a().a(1102, amtj.a(2131712573), true);
      return;
    }
    try
    {
      if ((!this.this$0.d) && (this.this$0.f)) {
        RMVideoStateMgr.a().a(1102, amtj.a(2131712576) + 1102, true);
      }
      RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoInitState", 2, "[ERR_CODE_INIT_TIMEOUT]初始化失败,code=1102 mIsReadAVCodec=" + this.this$0.a + " mIsReadCamera=" + this.this$0.b + " black=" + bool + " rmStateMgr.mIsAudioReady=" + localRMVideoStateMgr.c + " rmStateMgr.mVideoCacheDir=" + localRMVideoStateMgr.a);
      }
      RMVideoStateMgr.b(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.3
 * JD-Core Version:    0.7.0.1
 */