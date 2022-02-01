package com.tencent.timi.game.liveroom.impl.ad;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqlive.data.lottery.QQLiveLotteryData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.view.operation.OperationData;
import com.tencent.timi.game.liveroom.impl.view.operation.OperationItem;
import com.tencent.timi.game.utils.Logger;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/ad/TimiTianshuAdManager;", "", "()V", "KEY_JUMP_TYPE", "", "KEY_PIC", "KEY_PRIORITY", "KEY_SCENE", "KEY_URL", "KEY_VIEW_TYPE", "LIVE_BASE_OPERATION_ID", "", "LIVE_OPERATION_ID_1", "LIVE_OPERATION_ID_2", "LIVE_OPERATION_ID_3", "LIVE_OPERATION_ID_4", "LIVE_OPERATION_RED_PACKED_ID", "TAG", "mOperationAdIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMOperationAdIds", "()Ljava/util/ArrayList;", "mOperationAdPosList", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "getMOperationAdPosList", "mTopBaseOperationAdIds", "getMTopBaseOperationAdIds", "mTopBaseOperationAdPosList", "getMTopBaseOperationAdPosList", "buildJumpUrl", "url", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "buildOperationData", "Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationData;", "lotteryList", "Lcom/tencent/mobileqq/qqlive/data/lottery/QQLiveLotteryData;", "handleAdRsp", "", "rsp", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "targetAdIds", "requestOperationAds", "", "tianShuGetAdvCallback", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "ads", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiTianshuAdManager
{
  public static final TimiTianshuAdManager a = new TimiTianshuAdManager();
  @NotNull
  private static final ArrayList<TianShuAdPosItemData> b = new ArrayList();
  @NotNull
  private static final ArrayList<Integer> c = new ArrayList();
  @NotNull
  private static final ArrayList<TianShuAdPosItemData> d = new ArrayList();
  @NotNull
  private static final ArrayList<Integer> e = new ArrayList();
  
  static
  {
    c.add(Integer.valueOf(874));
    c.add(Integer.valueOf(875));
    c.add(Integer.valueOf(876));
    c.add(Integer.valueOf(877));
    Object localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "id");
      localTianShuAdPosItemData.a = localInteger.intValue();
      localTianShuAdPosItemData.b = 3;
      b.add(localTianShuAdPosItemData);
    }
    e.add(Integer.valueOf(878));
    localObject = new TianShuAdPosItemData();
    ((TianShuAdPosItemData)localObject).a = 878;
    ((TianShuAdPosItemData)localObject).b = 1;
    d.add(localObject);
  }
  
  private final String a(String paramString, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramString = Uri.parse(paramString).buildUpon();
    paramString.appendQueryParameter("roomType", String.valueOf(paramLiveRoomExtraInfo.a));
    paramString.appendQueryParameter("gameId", String.valueOf(paramLiveRoomExtraInfo.b));
    paramString.appendQueryParameter("gameTagId", String.valueOf(paramLiveRoomExtraInfo.c));
    paramString.appendQueryParameter("videoSource", String.valueOf(paramLiveRoomExtraInfo.d));
    paramString = paramString.build().toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "uri.build().toString()");
    paramLiveRoomExtraInfo = new StringBuilder();
    paramLiveRoomExtraInfo.append("build url == ");
    paramLiveRoomExtraInfo.append(paramString);
    Logger.a("AnchorOperationContainer_", paramLiveRoomExtraInfo.toString());
    return paramString;
  }
  
  @NotNull
  public final OperationData a(@NotNull ArrayList<QQLiveLotteryData> paramArrayList, @NotNull LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "lotteryList");
    Intrinsics.checkParameterIsNotNull(paramLiveRoomExtraInfo, "extraInfo");
    paramArrayList = paramArrayList.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "lotteryList[0]");
    paramArrayList = (QQLiveLotteryData)paramArrayList;
    Object localObject = new ArrayList();
    OperationItem localOperationItem = new OperationItem(null, null, null, null, null, 0, 0, false, 255, null);
    String str = paramArrayList.jumpUrl;
    Intrinsics.checkExpressionValueIsNotNull(str, "qqLiveLotteryData.jumpUrl");
    localOperationItem.c(a(str, paramLiveRoomExtraInfo));
    paramLiveRoomExtraInfo = paramArrayList.iconUrl;
    Intrinsics.checkExpressionValueIsNotNull(paramLiveRoomExtraInfo, "qqLiveLotteryData.iconUrl");
    localOperationItem.a(paramLiveRoomExtraInfo);
    localOperationItem.b("1");
    localOperationItem.d("0");
    localOperationItem.a(true);
    ((ArrayList)localObject).add(localOperationItem);
    paramLiveRoomExtraInfo = new OperationData(9999, (List)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fetchRedPackData item : jumpUrl == ");
    ((StringBuilder)localObject).append(paramArrayList.jumpUrl);
    ((StringBuilder)localObject).append("， pic == ");
    ((StringBuilder)localObject).append(paramArrayList.iconUrl);
    Logger.a("AnchorOperationContainer_", ((StringBuilder)localObject).toString());
    return paramLiveRoomExtraInfo;
  }
  
  @NotNull
  public final ArrayList<TianShuAdPosItemData> a()
  {
    return b;
  }
  
  @NotNull
  public final List<OperationData> a(@NotNull TianShuAccess.GetAdsRsp paramGetAdsRsp, @NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramGetAdsRsp, "rsp");
    Intrinsics.checkParameterIsNotNull(paramList, "targetAdIds");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("code:");
    ((StringBuilder)localObject1).append(paramGetAdsRsp.code.get());
    ((StringBuilder)localObject1).append(", msg:");
    ((StringBuilder)localObject1).append(paramGetAdsRsp.errmsg.get());
    Logger.a("TimiTianshuAdManager_", 1, ((StringBuilder)localObject1).toString());
    if (paramGetAdsRsp.code.get() == 0)
    {
      localObject1 = paramGetAdsRsp.mapAds;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.mapAds");
      if (!((PBRepeatMessageField)localObject1).isEmpty())
      {
        int k = paramGetAdsRsp.mapAds.size();
        int i = 0;
        while (i < k)
        {
          localObject1 = (TianShuAccess.RspEntry)paramGetAdsRsp.mapAds.get(i);
          int m = ((TianShuAccess.RspEntry)localObject1).key.get();
          if (paramList.contains(Integer.valueOf(m)))
          {
            Object localObject2 = (TianShuAccess.AdPlacementInfo)((TianShuAccess.RspEntry)localObject1).value.get();
            localObject1 = new ArrayList();
            localObject2 = ((TianShuAccess.AdPlacementInfo)localObject2).lst.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (TianShuAccess.AdItem)((Iterator)localObject2).next();
              Object localObject4 = ((TianShuAccess.AdItem)localObject3).argList.get();
              OperationItem localOperationItem = new OperationItem(null, null, null, null, null, 0, 0, false, 255, null);
              localOperationItem.b(((TianShuAccess.AdItem)localObject3).iAdId.get());
              localObject3 = ((List)localObject4).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject3).next();
                String str = ((TianShuAccess.MapEntry)localObject4).key.get();
                if (str != null) {
                  switch (str.hashCode())
                  {
                  default: 
                    break;
                  case 3619493: 
                    if (str.equals("view"))
                    {
                      localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "arg.value.get()");
                      localOperationItem.d((String)localObject4);
                    }
                    break;
                  case 3575610: 
                    if (str.equals("type"))
                    {
                      localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "arg.value.get()");
                      localOperationItem.b((String)localObject4);
                    }
                    break;
                  case 3524345: 
                    if (str.equals("scen"))
                    {
                      localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "arg.value.get()");
                      localOperationItem.e((String)localObject4);
                    }
                    break;
                  case 116079: 
                    if (str.equals("url"))
                    {
                      localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "arg.value.get()");
                      localOperationItem.c((String)localObject4);
                    }
                    break;
                  case 110986: 
                    if (str.equals("pic"))
                    {
                      localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "arg.value.get()");
                      localOperationItem.a((String)localObject4);
                    }
                    break;
                  case -1165461084: 
                    if (str.equals("priority"))
                    {
                      localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "arg.value.get()");
                      localObject4 = StringsKt.toIntOrNull((String)localObject4);
                      int j;
                      if (localObject4 != null) {
                        j = ((Integer)localObject4).intValue();
                      } else {
                        j = 0;
                      }
                      localOperationItem.a(j);
                    }
                    break;
                  }
                }
              }
              ((ArrayList)localObject1).add(localOperationItem);
            }
            if (((ArrayList)localObject1).size() == 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("empty ad:");
              ((StringBuilder)localObject1).append(m);
              Logger.c("TimiTianshuAdManager_", 1, ((StringBuilder)localObject1).toString());
            }
            else
            {
              localObject1 = (List)localObject1;
              CollectionsKt.sort((List)localObject1);
              localObject1 = new OperationData(m, (List)localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("ad(");
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append("):");
              ((StringBuilder)localObject2).append(localObject1);
              Logger.b("TimiTianshuAdManager_", 1, ((StringBuilder)localObject2).toString());
              localArrayList.add(localObject1);
            }
          }
          i += 1;
        }
        return (List)localArrayList;
      }
    }
    return (List)localArrayList;
  }
  
  public final void a(@NotNull TianShuGetAdvCallback paramTianShuGetAdvCallback, @NotNull List<? extends TianShuAdPosItemData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramTianShuGetAdvCallback, "tianShuGetAdvCallback");
    Intrinsics.checkParameterIsNotNull(paramList, "ads");
    ((ITianshuManager)QRoute.api(ITianshuManager.class)).requestAdv(paramList, paramTianShuGetAdvCallback);
  }
  
  @NotNull
  public final ArrayList<Integer> b()
  {
    return c;
  }
  
  @NotNull
  public final ArrayList<TianShuAdPosItemData> c()
  {
    return d;
  }
  
  @NotNull
  public final ArrayList<Integer> d()
  {
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.ad.TimiTianshuAdManager
 * JD-Core Version:    0.7.0.1
 */