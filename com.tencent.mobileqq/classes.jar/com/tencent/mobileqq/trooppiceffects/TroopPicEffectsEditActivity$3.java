package com.tencent.mobileqq.trooppiceffects;

import awju;
import awkj;
import bayf;
import bayk;
import bayo;
import bcxd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, awju paramawju) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    awkj.a((CompressInfo)localObject);
    bayk localbayk = new bayk();
    localbayk.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localbayk.c = this.this$0.jdField_b_of_type_JavaLangString;
    localbayk.d = this.this$0.app.getCurrentAccountUin();
    localbayk.jdField_a_of_type_Int = 1;
    localbayk.jdField_b_of_type_Int = 1;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.e = this.a.jdField_a_of_type_Int;
    localbayk.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localbayk.f = this.a.f;
    localObject = new bayo();
    localbayk.jdField_a_of_type_JavaLangObject = localObject;
    ((bayo)localObject).jdField_a_of_type_Boolean = false;
    localbayk.jdField_a_of_type_Awkh = new bcxd(this.this$0);
    localbayk.jdField_i_of_type_Boolean = this.a.c;
    localbayk.j = this.a.e;
    localbayk.jdField_b_of_type_Int = 55;
    localbayk.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localbayk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */