package com.tencent.mobileqq.vip.lianghao.net;

import biao;
import biaw;
import biax;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(biaw parambiaw, biao parambiao, biax parambiax) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Biao != null) && (this.jdField_a_of_type_Biao.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Biao.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Biao.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Biax.a(this.jdField_a_of_type_Biao);
      return;
    }
    this.jdField_a_of_type_Biax.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */