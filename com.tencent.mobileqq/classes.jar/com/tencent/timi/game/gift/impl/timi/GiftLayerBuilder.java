package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.gift.impl.receiver.IReceiverCore;
import com.tencent.timi.game.gift.impl.receiver.MultiChooseUnSupportReceiverCore;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter;
import com.tencent.timi.game.initer.impl.GiftSdkInitManager;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/GiftLayerBuilder;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "businessId", "", "panelStyle", "qBaseActivity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "roomId", "", "selfUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "build", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "rootView", "Landroid/view/ViewGroup;", "setBusinessId", "setPanelStyle", "setQBaseActivity", "activity", "setRoomId", "setSelfUserId", "userId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftLayerBuilder
{
  private int a;
  private QBaseActivity b;
  private int c;
  private CommonOuterClass.QQUserId d;
  private long e;
  private final Context f;
  
  public GiftLayerBuilder(@NotNull Context paramContext)
  {
    this.f = paramContext;
    this.a = 10001;
    this.c = 1;
  }
  
  @NotNull
  public final GiftLayerBuilder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  @NotNull
  public final GiftLayerBuilder a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }
  
  @NotNull
  public final GiftLayerBuilder a(@NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    this.b = paramQBaseActivity;
    return this;
  }
  
  @NotNull
  public final GiftLayerBuilder a(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    this.d = paramQQUserId;
    return this;
  }
  
  @NotNull
  public final TimiGiftController a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "rootView");
    TimiGiftLayerView localTimiGiftLayerView = new TimiGiftLayerView(this.f, null, 0, 6, null);
    GiftSdkInitManager.a.a(this.a);
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = new GiftSdkProvider(this.a, (QBaseActivity)localObject1, this.c);
    } else {
      localObject1 = null;
    }
    ReceiverAdapter localReceiverAdapter = new ReceiverAdapter(this.f);
    ReceiverSelectorView localReceiverSelectorView = new ReceiverSelectorView(this.f, null, 0, 6, null);
    int i = this.a;
    if ((i != 10005) && (i != 10004)) {
      localObject2 = "2";
    } else {
      localObject2 = "3";
    }
    long l = this.e;
    Object localObject3 = this.d;
    if (localObject3 == null)
    {
      localObject3 = (IUserInfoService)ServiceCenter.a(IUserInfoService.class);
      IService localIService = ServiceCenter.a(ILoginCoreService.class);
      Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
      localObject3 = ((IUserInfoService)localObject3).b(((ILoginCoreService)localIService).a());
    }
    Object localObject2 = new TimiGiftController((GiftSdkProvider)localObject1, l, (CommonOuterClass.QQUserId)localObject3, localReceiverAdapter, (IReceiverCore)new MultiChooseUnSupportReceiverCore(), localTimiGiftLayerView, localReceiverSelectorView, (String)localObject2);
    localTimiGiftLayerView.a((GiftSdkProvider)localObject1);
    paramViewGroup.addView((View)localTimiGiftLayerView, new ViewGroup.LayoutParams(-1, -1));
    localReceiverSelectorView.a((RecyclerView.Adapter)localReceiverAdapter);
    return localObject2;
  }
  
  @NotNull
  public final GiftLayerBuilder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.GiftLayerBuilder
 * JD-Core Version:    0.7.0.1
 */