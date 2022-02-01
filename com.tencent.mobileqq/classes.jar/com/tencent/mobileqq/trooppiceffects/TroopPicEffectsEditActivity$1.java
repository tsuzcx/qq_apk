package com.tencent.mobileqq.trooppiceffects;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.widget.Button;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.ShowPicPrice;

class TroopPicEffectsEditActivity$1
  extends TroopGiftCallback
{
  TroopPicEffectsEditActivity$1(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(SparseArray<TroopGiftManager.ShowPicPrice> paramSparseArray)
  {
    Object localObject = this.a;
    ((TroopPicEffectsEditActivity)localObject).jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    localObject = (TroopGiftManager.ShowPicPrice)((TroopPicEffectsEditActivity)localObject).jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if (localObject != null) {
      paramSparseArray = ((TroopGiftManager.ShowPicPrice)localObject).a;
    } else {
      paramSparseArray = "30金豆秀一下";
    }
    if (localObject != null) {
      localObject = ((TroopGiftManager.ShowPicPrice)localObject).b;
    } else {
      localObject = null;
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int i = 0;
    int j;
    if (!bool)
    {
      i = paramSparseArray.indexOf((String)localObject);
      j = ((String)localObject).length() + i;
    }
    else
    {
      j = 0;
    }
    paramSparseArray = new SpannableString(paramSparseArray);
    paramSparseArray.setSpan(new StrikethroughSpan(), i, j, 18);
    this.a.jdField_a_of_type_AndroidWidgetButton.setText(paramSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.1
 * JD-Core Version:    0.7.0.1
 */