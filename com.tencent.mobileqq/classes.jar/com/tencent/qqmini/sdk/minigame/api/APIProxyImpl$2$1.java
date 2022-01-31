package com.tencent.qqmini.sdk.minigame.api;

import android.text.TextUtils;
import bdpg;
import bdpy;
import bdrb;
import com.tencent.mobileqq.triton.sdk.ITSubPackage;

public class APIProxyImpl$2$1
  implements Runnable
{
  public APIProxyImpl$2$1(bdpg parambdpg, bdpy parambdpy, int paramInt, String paramString) {}
  
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_Bdpy != null) {
      str = this.jdField_a_of_type_Bdpy.c(this.jdField_a_of_type_Bdpg.jdField_a_of_type_JavaLangString);
    }
    bdrb.a().i("subpackage", "loadSubPackage callback onInitGpkgInfo, resCode:" + this.jdField_a_of_type_Int + ", dirPath:" + str + ", error msg=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bdpg.jdField_a_of_type_ComTencentMobileqqTritonSdkITSubPackage != null)
    {
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(str)))
      {
        this.jdField_a_of_type_Bdpg.jdField_a_of_type_ComTencentMobileqqTritonSdkITSubPackage.loadFinish(this.jdField_a_of_type_Bdpg.jdField_a_of_type_Long, str, true);
        bdrb.a().e("subpackage", "loadSubpackage loadFinish true");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bdpg.jdField_a_of_type_ComTencentMobileqqTritonSdkITSubPackage.loadFinish(this.jdField_a_of_type_Bdpg.jdField_a_of_type_Long, str, false);
    bdrb.a().e("subpackage", "loadSubpackage loadFinish false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.api.APIProxyImpl.2.1
 * JD-Core Version:    0.7.0.1
 */