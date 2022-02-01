package com.tencent.mobileqq.vip.lianghao.net;

import bgqe;
import bgqm;
import bgqn;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(bgqm parambgqm, bgqe parambgqe, bgqn parambgqn) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bgqe != null) && (this.jdField_a_of_type_Bgqe.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bgqe.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bgqe.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Bgqn.a(this.jdField_a_of_type_Bgqe);
      return;
    }
    this.jdField_a_of_type_Bgqn.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */