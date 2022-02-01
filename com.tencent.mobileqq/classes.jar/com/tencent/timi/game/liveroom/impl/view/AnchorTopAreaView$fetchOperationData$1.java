package com.tencent.timi.game.liveroom.impl.view;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.timi.game.liveroom.impl.ad.TimiTianshuAdManager;
import com.tencent.timi.game.utils.Logger;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "getAdsRsp", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "kotlin.jvm.PlatformType", "onGetAdvs"}, k=3, mv={1, 1, 16})
final class AnchorTopAreaView$fetchOperationData$1
  implements TianShuGetAdvCallback
{
  AnchorTopAreaView$fetchOperationData$1(AnchorTopAreaView paramAnchorTopAreaView) {}
  
  public final void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestOperationAds result:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", getAdsRsp:");
    ((StringBuilder)localObject).append(paramGetAdsRsp);
    Logger.a("AnchorTopAreaView_", 1, ((StringBuilder)localObject).toString());
    localObject = TimiTianshuAdManager.a;
    Intrinsics.checkExpressionValueIsNotNull(paramGetAdsRsp, "getAdsRsp");
    paramGetAdsRsp = ((TimiTianshuAdManager)localObject).a(paramGetAdsRsp, (List)TimiTianshuAdManager.a.d());
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AnchorTopAreaView.fetchOperationData.1.1(this, paramGetAdsRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.fetchOperationData.1
 * JD-Core Version:    0.7.0.1
 */