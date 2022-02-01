package com.tencent.mobileqq.vip.lianghao.net;

import bijv;
import bikd;
import bike;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(bikd parambikd, bijv parambijv, bike parambike) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bijv != null) && (this.jdField_a_of_type_Bijv.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bijv.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bijv.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Bike.a(this.jdField_a_of_type_Bijv);
      return;
    }
    this.jdField_a_of_type_Bike.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */