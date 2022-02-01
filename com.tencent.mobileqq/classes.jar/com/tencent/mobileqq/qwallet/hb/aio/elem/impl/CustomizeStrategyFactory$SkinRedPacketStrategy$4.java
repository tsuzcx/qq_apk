package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$SkinRedPacketStrategy$4
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$4(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {
      try
      {
        this.a.resPath = paramPathResult;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TYPE_POP_ANIM path=");
          localStringBuilder.append(paramPathResult);
          QLog.d("CustomizeStrategyFactory", 2, localStringBuilder.toString());
        }
      }
      catch (Throwable paramPathResult)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.d().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.SkinRedPacketStrategy.4
 * JD-Core Version:    0.7.0.1
 */