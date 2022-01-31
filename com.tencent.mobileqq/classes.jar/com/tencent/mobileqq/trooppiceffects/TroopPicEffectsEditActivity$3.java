package com.tencent.mobileqq.trooppiceffects;

import atqd;
import atqs;
import axvo;
import axvt;
import axvx;
import azsi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, atqd paramatqd) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    atqs.a((CompressInfo)localObject);
    axvt localaxvt = new axvt();
    localaxvt.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localaxvt.c = this.this$0.jdField_b_of_type_JavaLangString;
    localaxvt.d = this.this$0.app.getCurrentAccountUin();
    localaxvt.jdField_a_of_type_Int = 1;
    localaxvt.jdField_b_of_type_Int = 1;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.e = this.a.jdField_a_of_type_Int;
    localaxvt.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localaxvt.f = this.a.f;
    localObject = new axvx();
    localaxvt.jdField_a_of_type_JavaLangObject = localObject;
    ((axvx)localObject).jdField_a_of_type_Boolean = false;
    localaxvt.jdField_a_of_type_Atqq = new azsi(this.this$0);
    localaxvt.jdField_i_of_type_Boolean = this.a.c;
    localaxvt.j = this.a.e;
    localaxvt.jdField_b_of_type_Int = 55;
    localaxvt.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localaxvt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */