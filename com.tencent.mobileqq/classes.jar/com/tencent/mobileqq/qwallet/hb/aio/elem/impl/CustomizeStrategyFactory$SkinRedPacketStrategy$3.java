package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CustomizeStrategyFactory$SkinRedPacketStrategy$3
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$3(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramPathResult);
        ((StringBuilder)localObject).append(File.separator);
        paramPathResult = ((StringBuilder)localObject).toString();
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramPathResult);
        localStringBuilder.append("anim_bg");
        ((RedPacketInfo)localObject).specailBackgroundAnimInfo = AnimationView.AnimationInfo.loadFromFolder(localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          paramPathResult = new StringBuilder();
          paramPathResult.append("TYPE_SPECAIL_ANIM specailBackgroundAnimInfo=");
          paramPathResult.append(this.a.specailBackgroundAnimInfo);
          QLog.d("CustomizeStrategyFactory", 2, paramPathResult.toString());
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
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.SkinRedPacketStrategy.3
 * JD-Core Version:    0.7.0.1
 */