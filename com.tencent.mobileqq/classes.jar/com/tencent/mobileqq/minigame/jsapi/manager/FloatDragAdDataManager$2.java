package com.tencent.mobileqq.minigame.jsapi.manager;

import bmvh;
import com.tencent.mobileqq.minigame.utils.GameLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;

final class FloatDragAdDataManager$2
  implements bmvh
{
  FloatDragAdDataManager$2(String paramString, int paramInt, FloatDragAdDataManager.DragAdListener paramDragAdListener) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject = null;
    if (paramBoolean) {}
    for (paramGetAdsRsp = FloatDragAdDataManager.access$100(this.val$appId, this.val$scene, paramGetAdsRsp);; paramGetAdsRsp = localObject)
    {
      if (this.val$listener != null) {
        this.val$listener.onRequestDragAdData(paramGetAdsRsp);
      }
      return;
      GameLog.getInstance().e("FloatDragAdDataManager", "TianShuResponse response fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdDataManager.2
 * JD-Core Version:    0.7.0.1
 */