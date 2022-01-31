package com.tencent.mobileqq.trooppiceffects;

import auod;
import auos;
import ayvx;
import aywc;
import aywg;
import baua;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, auod paramauod) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    auos.a((CompressInfo)localObject);
    aywc localaywc = new aywc();
    localaywc.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localaywc.c = this.this$0.jdField_b_of_type_JavaLangString;
    localaywc.d = this.this$0.app.getCurrentAccountUin();
    localaywc.jdField_a_of_type_Int = 1;
    localaywc.jdField_b_of_type_Int = 1;
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.e = this.a.jdField_a_of_type_Int;
    localaywc.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localaywc.f = this.a.f;
    localObject = new aywg();
    localaywc.jdField_a_of_type_JavaLangObject = localObject;
    ((aywg)localObject).jdField_a_of_type_Boolean = false;
    localaywc.jdField_a_of_type_Auoq = new baua(this.this$0);
    localaywc.jdField_i_of_type_Boolean = this.a.c;
    localaywc.j = this.a.e;
    localaywc.jdField_b_of_type_Int = 55;
    localaywc.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localaywc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */