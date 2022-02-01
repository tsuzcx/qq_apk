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
    paramString = (TroopGiftManager.ShowPicPrice)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if ((paramString == null) || (paramString.jdField_a_of_type_Int == 0)) {}
    for (paramInt2 = 30; paramInt1 >= paramInt2; paramInt2 = paramString.jdField_a_of_type_Int)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.c();
    DialogUtil.a(this.a, 230, this.a.getResources().getString(2131697750), this.a.getResources().getString(2131697749), this.a.getResources().getString(2131690800), this.a.getResources().getString(2131697752), new TroopPicEffectsEditActivity.2.1(this), new TroopPicEffectsEditActivity.2.2(this)).show();
    TroopPicEffectsController.a("gold_bean", "gap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.2
 * JD-Core Version:    0.7.0.1
 */