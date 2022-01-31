package com.tencent.mobileqq.trooppiceffects;

import awfl;
import awga;
import batw;
import baub;
import bauf;
import bcsu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, awfl paramawfl) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    awga.a((CompressInfo)localObject);
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localbaub.c = this.this$0.jdField_b_of_type_JavaLangString;
    localbaub.d = this.this$0.app.getCurrentAccountUin();
    localbaub.jdField_a_of_type_Int = 1;
    localbaub.jdField_b_of_type_Int = 1;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.e = this.a.jdField_a_of_type_Int;
    localbaub.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localbaub.f = this.a.f;
    localObject = new bauf();
    localbaub.jdField_a_of_type_JavaLangObject = localObject;
    ((bauf)localObject).jdField_a_of_type_Boolean = false;
    localbaub.jdField_a_of_type_Awfy = new bcsu(this.this$0);
    localbaub.jdField_i_of_type_Boolean = this.a.c;
    localbaub.j = this.a.e;
    localbaub.jdField_b_of_type_Int = 55;
    localbaub.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localbaub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */