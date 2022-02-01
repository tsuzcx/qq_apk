package com.tencent.mobileqq.vas.troopgift;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.Coordinate;
import com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.GetPostReq;
import com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.GetPostRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/GestureGiftController;", "Lcom/tencent/mobileqq/vas/troopgift/AbsTroopGiftController;", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "closeAnimation", "Lkotlin/Function0;", "", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/app/BaseActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "tagGiftDiyDrawable", "needPag", "", "playAnimation", "toList", "", "", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Lcom/tencent/trpcprotocol/qqva/post/post/GestureGiftCoordinateBean$Coordinate;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GestureGiftController
  extends AbsTroopGiftController
{
  @NotNull
  private final String a = "GestureGiftController";
  private final String b = "gift_diy_drawable";
  
  public GestureGiftController(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0, @NotNull BaseActivity paramBaseActivity)
  {
    super(paramTroopGiftData, paramFunction0, paramBaseActivity);
  }
  
  @NotNull
  public final List<List<Integer>> a(@NotNull PBRepeatMessageField<GestureGiftCoordinateBean.Coordinate> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "$this$toList");
    List localList = (List)new ArrayList();
    paramPBRepeatMessageField = paramPBRepeatMessageField.get();
    Intrinsics.checkExpressionValueIsNotNull(paramPBRepeatMessageField, "this.get()");
    paramPBRepeatMessageField = ((Iterable)paramPBRepeatMessageField).iterator();
    while (paramPBRepeatMessageField.hasNext())
    {
      GestureGiftCoordinateBean.Coordinate localCoordinate = (GestureGiftCoordinateBean.Coordinate)paramPBRepeatMessageField.next();
      localList.add(CollectionsKt.listOf(new Integer[] { Integer.valueOf(localCoordinate.x.get()), Integer.valueOf(localCoordinate.y.get()), Integer.valueOf(localCoordinate.z.get()) }));
    }
    return localList;
  }
  
  public void a()
  {
    Object localObject1 = QVipSDKProcessor.e();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QVipSDKProcessor.get()");
    if (!((QVipSDKConfig)localObject1).i())
    {
      QLog.e(b(), 2, "GestureGift manage close");
      j();
      return;
    }
    QLog.d(b(), 2, "playAnimation");
    localObject1 = k().giftData.dataForClient.orderId;
    GestureGiftCoordinateBean.GetPostReq localGetPostReq = new GestureGiftCoordinateBean.GetPostReq();
    Object localObject2 = TroopGiftResManager.a;
    String str = k().giftData.dataForClient.giftResourceAnd;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.giftResourceAnd");
    localObject2 = ((TroopGiftResManager)localObject2).b(new String[] { str });
    QLog.d(b(), 2, localObject2[0].getPath());
    localGetPostReq.orderNum.set((String)localObject1);
    PbProtocol.a("trpc.qqva.post.postGift.GetPostInfo", (MessageMicro)localGetPostReq, GestureGiftCoordinateBean.GetPostRsp.class, (BusinessObserver)new GestureGiftController.playAnimation.1(this, (File[])localObject2));
  }
  
  @NotNull
  public String b()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.GestureGiftController
 * JD-Core Version:    0.7.0.1
 */