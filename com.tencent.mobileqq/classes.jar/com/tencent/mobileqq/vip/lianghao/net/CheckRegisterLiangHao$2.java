package com.tencent.mobileqq.vip.lianghao.net;

import com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp;

class CheckRegisterLiangHao$2
  implements Runnable
{
  CheckRegisterLiangHao$2(CheckRegisterLiangHao paramCheckRegisterLiangHao, CheckRegisterLiangHao.RequestCallBack paramRequestCallBack, LiangHaoStatusRsp paramLiangHaoStatusRsp) {}
  
  public void run()
  {
    CheckRegisterLiangHao.RequestCallBack localRequestCallBack = this.a;
    String str = CheckRegisterLiangHao.b(this.this$0);
    LiangHaoStatusRsp localLiangHaoStatusRsp = this.b;
    boolean bool;
    if ((localLiangHaoStatusRsp != null) && (localLiangHaoStatusRsp.b)) {
      bool = true;
    } else {
      bool = false;
    }
    localRequestCallBack.a(str, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.2
 * JD-Core Version:    0.7.0.1
 */