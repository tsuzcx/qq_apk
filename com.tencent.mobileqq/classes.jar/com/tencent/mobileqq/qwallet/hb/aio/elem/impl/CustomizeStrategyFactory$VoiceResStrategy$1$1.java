package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CustomizeStrategyFactory$VoiceResStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$VoiceResStrategy$1$1(CustomizeStrategyFactory.VoiceResStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramPathResult);
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("aio.png");
        localObject = localStringBuilder.toString();
        float f = CustomizeStrategyFactory.d;
        double d = f * 47.0F;
        Double.isNaN(d);
        paramInt = (int)(d + 0.5D);
        localObject = SafeBitmapFactory.decodeFile((String)localObject, BaseImageUtil.a((String)localObject, paramInt));
        if (localObject != null) {
          this.a.a.icon = ((Bitmap)localObject);
        }
        this.a.a.resPath = paramPathResult;
        if (QLog.isColorLevel())
        {
          paramPathResult = new StringBuilder();
          paramPathResult.append("VOICE_LOCK_RES info.icon=");
          paramPathResult.append(this.a.a.icon);
          paramPathResult.append(",resPath=");
          paramPathResult.append(this.a.a.resPath);
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
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.VoiceResStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */