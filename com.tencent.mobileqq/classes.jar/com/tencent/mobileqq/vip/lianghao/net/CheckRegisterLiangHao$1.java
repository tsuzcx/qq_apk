package com.tencent.mobileqq.vip.lianghao.net;

import android.os.SystemClock;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp;

class CheckRegisterLiangHao$1
  implements Runnable
{
  CheckRegisterLiangHao$1(CheckRegisterLiangHao paramCheckRegisterLiangHao) {}
  
  public void run()
  {
    CheckRegisterLiangHao.a(this.this$0, SystemClock.elapsedRealtime());
    LiangHaoStatusRsp localLiangHaoStatusRsp = CheckRegisterLiangHao.a(this.this$0);
    CheckRegisterLiangHao.a(this.this$0, localLiangHaoStatusRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.1
 * JD-Core Version:    0.7.0.1
 */