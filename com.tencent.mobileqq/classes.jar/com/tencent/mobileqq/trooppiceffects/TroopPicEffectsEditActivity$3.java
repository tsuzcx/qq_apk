package com.tencent.mobileqq.trooppiceffects;

import azqt;
import azrm;
import beyb;
import beyg;
import beyk;
import bhbp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, azqt paramazqt) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    azrm.a((CompressInfo)localObject);
    beyg localbeyg = new beyg();
    localbeyg.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localbeyg.c = this.this$0.jdField_b_of_type_JavaLangString;
    localbeyg.d = this.this$0.app.getCurrentAccountUin();
    localbeyg.jdField_a_of_type_Int = 1;
    localbeyg.jdField_b_of_type_Int = 1;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.e = this.a.jdField_a_of_type_Int;
    localbeyg.i = ((CompressInfo)localObject).e;
    localbeyg.f = this.a.f;
    localObject = new beyk();
    localbeyg.jdField_a_of_type_JavaLangObject = localObject;
    ((beyk)localObject).jdField_a_of_type_Boolean = false;
    localbeyg.jdField_a_of_type_Azrg = new bhbp(this.this$0);
    localbeyg.j = this.a.c;
    localbeyg.k = this.a.e;
    localbeyg.jdField_b_of_type_Int = 55;
    localbeyg.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localbeyg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */