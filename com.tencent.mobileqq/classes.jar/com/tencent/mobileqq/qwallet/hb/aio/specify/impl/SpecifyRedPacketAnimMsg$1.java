package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.qwallet.temp.ISpriteVideoViewTemp.OnFrameEndListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg.OnAnimEndListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpecifyRedPacketAnimMsg$1
  implements ISpriteVideoViewTemp.OnFrameEndListener
{
  boolean a = false;
  
  SpecifyRedPacketAnimMsg$1(SpecifyRedPacketAnimMsg paramSpecifyRedPacketAnimMsg, ISpecifyRedPacketAnimMsg.OnAnimEndListener paramOnAnimEndListener) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if (!this.a)
    {
      if (SpecifyRedPacketAnimMsg.a(this.c)) {
        return;
      }
      this.a = true;
      if (SpecifyRedPacketAnimMsg.b(this.c) != null) {
        ThreadManager.getUIHandler().removeCallbacks(SpecifyRedPacketAnimMsg.b(this.c));
      }
      ISpecifyRedPacketAnimMsg.OnAnimEndListener localOnAnimEndListener = this.b;
      if (localOnAnimEndListener != null) {
        localOnAnimEndListener.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyRedPacketAnimMsg.1
 * JD-Core Version:    0.7.0.1
 */