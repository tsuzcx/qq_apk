package com.tencent.mobileqq.vip.lianghao.net;

import bbyu;
import bbzc;
import bbzd;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(bbzc parambbzc, bbyu parambbyu, bbzd parambbzd) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bbyu != null) && (this.jdField_a_of_type_Bbyu.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bbyu.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bbyu.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Bbzd.a(this.jdField_a_of_type_Bbyu);
      return;
    }
    this.jdField_a_of_type_Bbzd.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */