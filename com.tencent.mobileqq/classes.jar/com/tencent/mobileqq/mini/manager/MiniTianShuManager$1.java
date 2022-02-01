package com.tencent.mobileqq.mini.manager;

import bmvh;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.List;

final class MiniTianShuManager$1
  implements bmvh
{
  MiniTianShuManager$1(bmvh parambmvh) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    this.val$tianShuGetAdvCallback.onGetAdvs(paramBoolean, paramGetAdsRsp);
    MiniTianShuManager.access$000().remove(this);
    QLog.i("MiniTianShuManager", 1, "remove callback " + MiniTianShuManager.access$000().size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager.1
 * JD-Core Version:    0.7.0.1
 */