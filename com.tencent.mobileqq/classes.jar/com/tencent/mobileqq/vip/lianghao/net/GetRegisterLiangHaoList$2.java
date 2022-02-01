package com.tencent.mobileqq.vip.lianghao.net;

import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;
import java.util.List;

class GetRegisterLiangHaoList$2
  implements Runnable
{
  GetRegisterLiangHaoList$2(GetRegisterLiangHaoList paramGetRegisterLiangHaoList, LiangHaoRsp paramLiangHaoRsp, GetRegisterLiangHaoList.RequestCallBack paramRequestCallBack) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp != null) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetGetRegisterLiangHaoList$RequestCallBack.a(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetGetRegisterLiangHaoList$RequestCallBack.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */