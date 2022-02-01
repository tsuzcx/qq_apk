package com.tencent.mobileqq.vip.lianghao.net;

import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;
import java.util.List;

class GetRegisterLiangHaoList$2
  implements Runnable
{
  GetRegisterLiangHaoList$2(GetRegisterLiangHaoList paramGetRegisterLiangHaoList, LiangHaoRsp paramLiangHaoRsp, GetRegisterLiangHaoList.RequestCallBack paramRequestCallBack) {}
  
  public void run()
  {
    LiangHaoRsp localLiangHaoRsp = this.a;
    if ((localLiangHaoRsp != null) && (localLiangHaoRsp.b == 0) && (this.a.f != null) && (this.a.f.size() > 0))
    {
      this.b.a(this.a);
      return;
    }
    this.b.a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */