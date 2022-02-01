package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$ThemeAnimStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$ThemeAnimStrategy$1$1(CustomizeStrategyFactory.ThemeAnimStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {
      try
      {
        this.a.a.animInfo = AnimationView.AnimationInfo.loadFromFolder(paramPathResult);
        if (QLog.isColorLevel())
        {
          paramPathResult = new StringBuilder();
          paramPathResult.append("TYPE_AIO_REDPACKET background=");
          paramPathResult.append(this.a.a.background);
          paramPathResult.append(",animInfo=");
          paramPathResult.append(this.a.a.animInfo);
          QLog.d("CustomizeStrategyFactory", 2, paramPathResult.toString());
        }
      }
      catch (Throwable paramPathResult)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.d().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.ThemeAnimStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */