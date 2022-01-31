package com.tencent.mobileqq.vip.lianghao.net;

import bbyg;
import bbyo;
import bbyp;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(bbyo parambbyo, bbyg parambbyg, bbyp parambbyp) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bbyg != null) && (this.jdField_a_of_type_Bbyg.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bbyg.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bbyg.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Bbyp.a(this.jdField_a_of_type_Bbyg);
      return;
    }
    this.jdField_a_of_type_Bbyp.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */