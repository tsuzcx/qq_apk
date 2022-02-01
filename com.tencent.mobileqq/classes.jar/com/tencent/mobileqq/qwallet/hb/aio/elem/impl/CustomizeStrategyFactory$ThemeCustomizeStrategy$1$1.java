package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeCustomizeStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$ThemeCustomizeStrategy$1$1(CustomizeStrategyFactory.ThemeCustomizeStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {
      try
      {
        this.a.a.background = paramPathResult;
        if (QLog.isColorLevel())
        {
          paramPathResult = new StringBuilder();
          paramPathResult.append("ThemeCustomizeStrategy info.background=");
          paramPathResult.append(this.a.a.background);
          QLog.d("CustomizeStrategyFactory", 2, paramPathResult.toString());
        }
      }
      catch (Throwable paramPathResult)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.ThemeCustomizeStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */