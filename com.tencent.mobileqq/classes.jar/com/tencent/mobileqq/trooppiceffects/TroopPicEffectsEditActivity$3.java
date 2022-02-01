package com.tencent.mobileqq.trooppiceffects;

import ayyg;
import ayyz;
import bdzi;
import bdzn;
import bdzr;
import bgbo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;

class TroopPicEffectsEditActivity$3
  implements Runnable
{
  TroopPicEffectsEditActivity$3(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, ayyg paramayyg) {}
  
  public void run()
  {
    this.this$0.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.a.g, 0);
    ((CompressInfo)localObject).f = 0;
    ayyz.a((CompressInfo)localObject);
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_b_of_type_JavaLangString = this.this$0.app.getAccount();
    localbdzn.c = this.this$0.jdField_b_of_type_JavaLangString;
    localbdzn.d = this.this$0.app.getCurrentAccountUin();
    localbdzn.jdField_a_of_type_Int = 1;
    localbdzn.jdField_b_of_type_Int = 1;
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.e = this.a.jdField_a_of_type_Int;
    localbdzn.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localbdzn.f = this.a.f;
    localObject = new bdzr();
    localbdzn.jdField_a_of_type_JavaLangObject = localObject;
    ((bdzr)localObject).jdField_a_of_type_Boolean = false;
    localbdzn.jdField_a_of_type_Ayyt = new bgbo(this.this$0);
    localbdzn.jdField_i_of_type_Boolean = this.a.c;
    localbdzn.j = this.a.e;
    localbdzn.jdField_b_of_type_Int = 55;
    localbdzn.jdField_a_of_type_Long = System.currentTimeMillis();
    this.this$0.app.a().a(localbdzn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.3
 * JD-Core Version:    0.7.0.1
 */