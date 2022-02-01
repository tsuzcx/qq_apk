package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$PanelStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$PanelStrategy$1$1(CustomizeStrategyFactory.PanelStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {
      try
      {
        float f = CustomizeStrategyFactory.a;
        double d = f * 50.0F;
        Double.isNaN(d);
        paramInt = (int)(d + 0.5D);
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramPathResult, BaseImageUtil.a(paramPathResult, paramInt));
        if (localBitmap != null) {
          this.a.a.icon = localBitmap;
        }
        this.a.a.resPath = paramPathResult;
        if (QLog.isColorLevel())
        {
          paramPathResult = new StringBuilder();
          paramPathResult.append("PanelStrategy info.icon=");
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
    CustomizeStrategyFactory.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.PanelStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */