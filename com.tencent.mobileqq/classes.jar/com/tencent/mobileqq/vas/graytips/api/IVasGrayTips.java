package com.tencent.mobileqq.vas.graytips.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.FromChannel;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/graytips/api/IVasGrayTips;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "requestUnitGrayTips", "", "cmd", "", "channel", "Lcom/tencent/pb/vas/uni_gray_tip/UniGrayTip$FromChannel;", "map", "", "", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "transformFrom", "peerType", "Companion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasGrayTips
  extends QRouteApi
{
  public static final IVasGrayTips.Companion Companion = IVasGrayTips.Companion.a;
  public static final int FROM_AIO = 1;
  public static final int KEY_WORDS = 1;
  public static final int PASS_DATE = 2;
  
  public abstract void requestUnitGrayTips(int paramInt, @NotNull UniGrayTip.FromChannel paramFromChannel, @Nullable Map<String, String> paramMap, @Nullable BusinessObserver paramBusinessObserver);
  
  public abstract int transformFrom(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.graytips.api.IVasGrayTips
 * JD-Core Version:    0.7.0.1
 */