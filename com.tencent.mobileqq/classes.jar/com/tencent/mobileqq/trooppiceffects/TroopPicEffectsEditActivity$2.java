package com.tencent.mobileqq.trooppiceffects;

import android.app.Dialog;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.ShowPicPrice;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.List;

class TroopPicEffectsEditActivity$2
  extends TroopGiftCallback
{
  TroopPicEffectsEditActivity$2(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<TroopGiftManager.GiveGift> paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    paramString = (TroopGiftManager.ShowPicPrice)this.a.m.get(this.a.l);
    if ((paramString != null) && (paramString.a != 0)) {
      paramInt2 = paramString.a;
    } else {
      paramInt2 = 30;
    }
    if (paramInt1 >= paramInt2)
    {
      paramString = this.a;
      paramString.b(paramString.f);
      return;
    }
    this.a.c();
    paramString = this.a;
    DialogUtil.a(paramString, 230, paramString.getResources().getString(2131895529), this.a.getResources().getString(2131895528), this.a.getResources().getString(2131887648), this.a.getResources().getString(2131895531), new TroopPicEffectsEditActivity.2.1(this), new TroopPicEffectsEditActivity.2.2(this)).show();
    TroopPicEffectsController.a("gold_bean", "gap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.2
 * JD-Core Version:    0.7.0.1
 */