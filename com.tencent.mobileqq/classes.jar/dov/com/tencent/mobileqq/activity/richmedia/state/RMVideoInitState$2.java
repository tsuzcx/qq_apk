package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import bnum;
import bobu;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class RMVideoInitState$2
  implements Runnable
{
  public RMVideoInitState$2(bnum parambnum) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.b())
    {
      RMVideoStateMgr.b(null);
      if (!localRMVideoStateMgr.b()) {
        return;
      }
    }
    File localFile = new File(bobu.a + File.separator + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      label84:
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
      }
      localRMVideoStateMgr.a.postDelayed(this.this$0.a, 20000L);
      localRMVideoStateMgr.f();
      localRMVideoStateMgr.g();
      localRMVideoStateMgr.e();
      try
      {
        AVCodec.get().init();
        this.this$0.c = true;
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
        }
        this.this$0.g = false;
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          this.this$0.c = false;
        }
      }
    }
    catch (IOException localIOException)
    {
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
 * JD-Core Version:    0.7.0.1
 */