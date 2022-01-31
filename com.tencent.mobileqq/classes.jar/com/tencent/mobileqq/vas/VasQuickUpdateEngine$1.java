package com.tencent.mobileqq.vas;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class VasQuickUpdateEngine$1
  implements Runnable
{
  VasQuickUpdateEngine$1(VasQuickUpdateEngine paramVasQuickUpdateEngine) {}
  
  public void run()
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getApplication(), "xplatform", 0, false);
      bool = SoLoadUtil.a(BaseApplicationImpl.getApplication(), "vasscupdate", 0, false);
      VasQuickUpdateEngine.hasSoLoaded.set(true);
      if (bool)
      {
        VasQuickUpdateEngine.isSoLoadFail.set(false);
        this.this$0.initEngine(VasQuickUpdateEngine.ENGINE_CONFIG_PATH);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("VasQuickUpdateEngine", 1, "load lib fail: ", localThrowable);
        VasQuickUpdateEngine.isSoLoadFail.set(true);
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.1
 * JD-Core Version:    0.7.0.1
 */