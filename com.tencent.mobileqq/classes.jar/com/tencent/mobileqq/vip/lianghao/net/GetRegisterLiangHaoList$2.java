package com.tencent.mobileqq.vip.lianghao.net;

import bdxv;
import bdyd;
import bdye;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(bdyd parambdyd, bdxv parambdxv, bdye parambdye) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bdxv != null) && (this.jdField_a_of_type_Bdxv.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bdxv.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bdxv.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Bdye.a(this.jdField_a_of_type_Bdxv);
      return;
    }
    this.jdField_a_of_type_Bdye.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */