package com.tencent.mobileqq.vip.lianghao;

import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.RequestCallBack;

class RegisterLiangHaoHelper$1
  implements GetRegisterLiangHaoList.RequestCallBack
{
  RegisterLiangHaoHelper$1(RegisterLiangHaoHelper paramRegisterLiangHaoHelper) {}
  
  public void a(int paramInt, String paramString)
  {
    if (RegisterLiangHaoHelper.a(this.a) != null) {
      RegisterLiangHaoHelper.a(this.a).a(false);
    }
  }
  
  public void a(LiangHaoRsp paramLiangHaoRsp)
  {
    RegisterLiangHaoHelper.a(this.a, paramLiangHaoRsp);
    if (RegisterLiangHaoHelper.a(this.a) != null)
    {
      RegisterLiangHaoHelper.a(this.a);
      RegisterLiangHaoHelper.a(this.a).a(paramLiangHaoRsp.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper.1
 * JD-Core Version:    0.7.0.1
 */