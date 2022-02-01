package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import bekc;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import eipc.EIPCModule;
import eipc.EIPCResult;

class LiveDelivery$5
  implements TianShuGetAdvCallback
{
  LiveDelivery$5(LiveDelivery paramLiveDelivery, int paramInt1, EIPCModule paramEIPCModule, int paramInt2) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    paramGetAdsRsp = this.this$0.getAdsInfo(paramGetAdsRsp, this.val$posId);
    if (paramGetAdsRsp == null) {
      return;
    }
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putString("type", paramGetAdsRsp.jdField_a_of_type_JavaLangString);
    localEIPCResult.data.putString("pic", paramGetAdsRsp.c);
    localEIPCResult.data.putString("url", paramGetAdsRsp.b);
    if (paramGetAdsRsp.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem != null) {
      localEIPCResult.data.putInt("adId", paramGetAdsRsp.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get());
    }
    this.val$moudle.callbackResult(this.val$callbackId, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.5
 * JD-Core Version:    0.7.0.1
 */