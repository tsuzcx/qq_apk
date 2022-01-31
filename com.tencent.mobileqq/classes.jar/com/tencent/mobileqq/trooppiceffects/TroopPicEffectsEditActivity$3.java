package com.tencent.mobileqq.trooppiceffects;

import auob;
import auoq;
import ayvv;
import aywa;
import aywe;
import batm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, auob paramauob) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    auoq.a((CompressInfo)localObject);
    aywa localaywa = new aywa();
    localaywa.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localaywa.c = this.this$0.jdField_b_of_type_JavaLangString;
    localaywa.d = this.this$0.app.getCurrentAccountUin();
    localaywa.jdField_a_of_type_Int = 1;
    localaywa.jdField_b_of_type_Int = 1;
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.e = this.a.jdField_a_of_type_Int;
    localaywa.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localaywa.f = this.a.f;
    localObject = new aywe();
    localaywa.jdField_a_of_type_JavaLangObject = localObject;
    ((aywe)localObject).jdField_a_of_type_Boolean = false;
    localaywa.jdField_a_of_type_Auoo = new batm(this.this$0);
    localaywa.jdField_i_of_type_Boolean = this.a.c;
    localaywa.j = this.a.e;
    localaywa.jdField_b_of_type_Int = 55;
    localaywa.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localaywa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */