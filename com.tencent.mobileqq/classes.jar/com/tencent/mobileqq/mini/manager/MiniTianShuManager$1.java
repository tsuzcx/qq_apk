package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.List;

final class MiniTianShuManager$1
  implements TianShuGetAdvCallback
{
  MiniTianShuManager$1(TianShuGetAdvCallback paramTianShuGetAdvCallback) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    this.val$tianShuGetAdvCallback.onGetAdvs(paramBoolean, paramGetAdsRsp);
    MiniTianShuManager.access$000().remove(this);
    paramGetAdsRsp = new StringBuilder();
    paramGetAdsRsp.append("remove callback ");
    paramGetAdsRsp.append(MiniTianShuManager.access$000().size());
    QLog.i("MiniTianShuManager", 1, paramGetAdsRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager.1
 * JD-Core Version:    0.7.0.1
 */