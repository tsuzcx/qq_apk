package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TroopEnterEffectController$4
  extends CallBacker
{
  TroopEnterEffectController$4(TroopEnterEffectController paramTroopEnterEffectController) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_")) && (paramInt1 == 0))
    {
      paramInt1 = TroopEnterEffectController.b(paramString1);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("download Res callback success id = ");
        paramString1.append(paramInt1);
        QLog.d("TroopEnterEffect.Controller", 2, paramString1.toString());
      }
      if (paramInt1 > 0)
      {
        paramString1 = (TroopEnterEffectData)this.a.g.get(paramInt1);
        this.a.g.remove(paramInt1);
        if (paramString1 != null)
        {
          paramString2 = new StringBuilder();
          paramString2.append(TroopEnterEffectController.a);
          paramString2.append(paramInt1);
          if (TroopGiftUtil.a(new File(paramString2.toString()))) {
            this.a.f.post(new TroopEnterEffectController.4.1(this, paramInt1, paramString1));
          }
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("mResDownloadCallback effectData = null id = ");
          paramString1.append(paramInt1);
          QLog.e("TroopEnterEffect.Controller", 1, paramString1.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4
 * JD-Core Version:    0.7.0.1
 */