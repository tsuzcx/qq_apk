package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.common.wormhole.log.ILogAdapter;
import com.tencent.qphone.base.util.QLog;

class WormholeEngine$1$1$1
  implements ILogAdapter
{
  WormholeEngine$1$1$1(WormholeEngine.1.1 param1) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (QLog.isColorLevel()) {
            QLog.d(paramString1, 2, paramString2);
          }
        }
        else {
          QLog.e(paramString1, 2, paramString2);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.w(paramString1, 2, paramString2);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeEngine.1.1.1
 * JD-Core Version:    0.7.0.1
 */