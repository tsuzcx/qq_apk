package com.tencent.mobileqq.vip.lianghao.net;

import android.os.SystemClock;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;

class GetRegisterLiangHaoList$1
  implements Runnable
{
  GetRegisterLiangHaoList$1(GetRegisterLiangHaoList paramGetRegisterLiangHaoList) {}
  
  public void run()
  {
    GetRegisterLiangHaoList.a(this.this$0, SystemClock.elapsedRealtime());
    LiangHaoRsp localLiangHaoRsp = GetRegisterLiangHaoList.a(this.this$0);
    GetRegisterLiangHaoList.a(this.this$0, localLiangHaoRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.1
 * JD-Core Version:    0.7.0.1
 */