package com.tencent.mobileqq.vip.lianghao.net;

import bece;
import becm;
import becn;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(becm parambecm, bece parambece, becn parambecn) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bece != null) && (this.jdField_a_of_type_Bece.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bece.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bece.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Becn.a(this.jdField_a_of_type_Bece);
      return;
    }
    this.jdField_a_of_type_Becn.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */