package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CustomizeStrategyFactory$SkinRedPacketStrategy$2
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$2(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    Object localObject1 = paramPathResult.folderPath;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        paramInt = this.a.skinType;
        if (paramInt == 1)
        {
          paramPathResult = new StringBuilder();
          paramPathResult.append((String)localObject1);
          paramPathResult.append(File.separator);
          paramPathResult = paramPathResult.toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramPathResult);
          ((StringBuilder)localObject2).append("corner.png");
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramPathResult);
          ((StringBuilder)localObject3).append("base_bg.png");
          localObject3 = ((StringBuilder)localObject3).toString();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramPathResult);
          ((StringBuilder)localObject4).append("anim_fg");
          localObject4 = ((StringBuilder)localObject4).toString();
          float f = CustomizeStrategyFactory.d;
          double d = f * 50.0F;
          Double.isNaN(d);
          paramInt = (int)(d + 0.5D);
          f = CustomizeStrategyFactory.d;
          f = CustomizeStrategyFactory.d;
          d = f * 50.0F;
          Double.isNaN(d);
          int i = (int)(d + 0.5D);
          BitmapFactory.Options localOptions = BaseImageUtil.a((String)localObject2, paramInt);
          this.a.corner = SafeBitmapFactory.decodeFile((String)localObject2, localOptions);
          this.a.resPath = ((String)localObject1);
          this.a.background = ((String)localObject3);
          this.a.animInfo = AnimationView.AnimationInfo.loadFromFolder((String)localObject4);
          localObject1 = SkinRedPkgElem.b;
          int j = localObject1.length;
          paramInt = 0;
          if (paramInt < j)
          {
            localObject2 = localObject1[paramInt];
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramPathResult);
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(".png");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject3 = SafeBitmapFactory.decodeFile((String)localObject3, BaseImageUtil.a((String)localObject3, i));
            if (localObject3 == null) {
              break label491;
            }
            this.a.attribute.putParcelable((String)localObject2, (Parcelable)localObject3);
            break label491;
          }
          if (QLog.isColorLevel())
          {
            paramPathResult = new StringBuilder();
            paramPathResult.append("TYPE_AIO_REDPACKET background=");
            paramPathResult.append(this.a.background);
            paramPathResult.append(",animInfo=");
            paramPathResult.append(this.a.animInfo);
            QLog.d("CustomizeStrategyFactory", 2, paramPathResult.toString());
          }
        }
        else if (this.a.skinType == 2)
        {
          this.a.resPath = ((String)localObject1);
          if (QLog.isColorLevel())
          {
            paramPathResult = new StringBuilder();
            paramPathResult.append("TYPE_POP_REDPACKET path=");
            paramPathResult.append((String)localObject1);
            QLog.d("CustomizeStrategyFactory", 2, paramPathResult.toString());
          }
        }
      }
      catch (Throwable paramPathResult)
      {
        paramPathResult.printStackTrace();
      }
      CustomizeStrategyFactory.d().a(this.a);
      return;
      label491:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.SkinRedPacketStrategy.2
 * JD-Core Version:    0.7.0.1
 */