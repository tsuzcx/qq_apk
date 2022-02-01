package com.tencent.mobileqq.vip.lianghao.net;

import com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp;

class CheckRegisterLiangHao$2
  implements Runnable
{
  CheckRegisterLiangHao$2(CheckRegisterLiangHao paramCheckRegisterLiangHao, CheckRegisterLiangHao.RequestCallBack paramRequestCallBack, LiangHaoStatusRsp paramLiangHaoStatusRsp) {}
  
  public void run()
  {
    CheckRegisterLiangHao.RequestCallBack localRequestCallBack = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetCheckRegisterLiangHao$RequestCallBack;
    String str = CheckRegisterLiangHao.a(this.this$0);
    LiangHaoStatusRsp localLiangHaoStatusRsp = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoStatusRsp;
    boolean bool;
    if ((localLiangHaoStatusRsp != null) && (localLiangHaoStatusRsp.a)) {
      bool = true;
    } else {
      bool = false;
    }
    localRequestCallBack.a(str, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.2
 * JD-Core Version:    0.7.0.1
 */