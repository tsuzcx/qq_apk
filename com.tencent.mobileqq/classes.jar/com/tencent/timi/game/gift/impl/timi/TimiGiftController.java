package com.tencent.timi.game.gift.impl.timi;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.timi.game.component.chat.util.MessageUtil;
import com.tencent.timi.game.databasecore.impl.livedata.IDbLiveData;
import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.gift.api.OnSelectGiftToUserListener;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.event.GiftPanelControlEvent;
import com.tencent.timi.game.gift.impl.receiver.IReceiverCore;
import com.tencent.timi.game.gift.impl.receiver.ReceiverUpdateCallback;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter;
import com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter.IOnClickListener;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "giftSdkProvider", "Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "roomId", "", "selfUid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "receiverAdapter", "Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter;", "receiverCore", "Lcom/tencent/timi/game/gift/impl/receiver/IReceiverCore;", "giftLayerView", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;", "receiverSelectorView", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverSelectorView;", "sceneId", "", "(Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;JLtrpc/yes/common/CommonOuterClass$QQUserId;Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter;Lcom/tencent/timi/game/gift/impl/receiver/IReceiverCore;Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;Lcom/tencent/timi/game/gift/impl/timi/ReceiverSelectorView;Ljava/lang/String;)V", "giftPanelView", "Lcom/tencent/mobileqq/qqgift/mvvm/business/view/IQQGiftPanelView;", "isGiftPanelVisible", "", "msgListener", "com/tencent/timi/game/gift/impl/timi/TimiGiftController$msgListener$1", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController$msgListener$1;", "myUid", "getMyUid", "()J", "onSelectGiftToUserListener", "Lcom/tencent/timi/game/gift/api/OnSelectGiftToUserListener;", "panelEventListener", "com/tencent/timi/game/gift/impl/timi/TimiGiftController$panelEventListener$1", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController$panelEventListener$1;", "receiverUpdateCallback", "com/tencent/timi/game/gift/impl/timi/TimiGiftController$receiverUpdateCallback$1", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController$receiverUpdateCallback$1;", "resourcePath", "destroy", "", "isSdkDestroy", "dismissGiftPanel", "doBeforeSendGift", "data", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "isPanelVisible", "markGiftPanelVisible", "onReceiveEvent", "p0", "replaceAllReceiver", "receiverList", "", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "resetReceiver", "setGiftBannerViewHolder", "giftBannerViewHolder", "Landroid/view/View;", "setOnSelectGiftToUserListener", "listener", "showCertainReceiver", "uid", "showGiftPanel", "subSceneId", "updateRoomId", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftController
  implements SimpleEventReceiver<SimpleBaseEvent>
{
  public static final TimiGiftController.Companion a = new TimiGiftController.Companion(null);
  private String b;
  private boolean c;
  private IQQGiftPanelView d;
  private final TimiGiftController.receiverUpdateCallback.1 e;
  private OnSelectGiftToUserListener f;
  private final TimiGiftController.msgListener.1 g;
  private final TimiGiftController.panelEventListener.1 h;
  private final GiftSdkProvider i;
  private long j;
  private CommonOuterClass.QQUserId k;
  private final ReceiverAdapter l;
  private final IReceiverCore m;
  private final TimiGiftLayerView n;
  private final ReceiverSelectorView o;
  private final String p;
  
  public TimiGiftController(@Nullable GiftSdkProvider paramGiftSdkProvider, long paramLong, @NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable ReceiverAdapter paramReceiverAdapter, @NotNull IReceiverCore paramIReceiverCore, @NotNull TimiGiftLayerView paramTimiGiftLayerView, @NotNull ReceiverSelectorView paramReceiverSelectorView, @NotNull String paramString)
  {
    this.i = paramGiftSdkProvider;
    this.j = paramLong;
    this.k = paramQQUserId;
    this.l = paramReceiverAdapter;
    this.m = paramIReceiverCore;
    this.n = paramTimiGiftLayerView;
    this.o = paramReceiverSelectorView;
    this.p = paramString;
    paramGiftSdkProvider = this.l;
    if (paramGiftSdkProvider != null) {
      paramGiftSdkProvider.a(1);
    }
    this.b = "";
    this.e = new TimiGiftController.receiverUpdateCallback.1(this);
    this.g = new TimiGiftController.msgListener.1(this);
    this.h = new TimiGiftController.panelEventListener.1(this);
    this.m.a((ReceiverUpdateCallback)this.e);
    paramGiftSdkProvider = this.l;
    if (paramGiftSdkProvider != null) {
      paramGiftSdkProvider.a((ReceiverAdapter.IOnClickListener)new TimiGiftController.1(this));
    }
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.j).a((IMsgListener)this.g);
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
    int i1 = MessageUtil.a.a(this.j);
    GiftResourceManager.a.a(i1);
  }
  
  private final void a(CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramQQUserId != null)
    {
      paramQQUserId = CollectionsKt.listOf(new ReceiverInfoModel(paramQQUserId, 0, "", false, true, false, 40, null));
      if (paramQQUserId != null) {}
    }
    else
    {
      paramQQUserId = CollectionsKt.emptyList();
    }
    a(paramQQUserId);
  }
  
  private final boolean a(GiftServiceData paramGiftServiceData)
  {
    Object localObject2 = this.m.a();
    if (((List)localObject2).isEmpty())
    {
      Logger.c("TimiGiftPresenter", "none selected receiver");
      return true;
    }
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      int i1;
      if (((ReceiverInfoModel)localObject1).a().uid.get() == d()) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        break label99;
      }
    }
    Object localObject1 = null;
    label99:
    if (localObject1 != null)
    {
      Logger.c("TimiGiftPresenter", "can not select self");
      return true;
    }
    localObject1 = (ReceiverInfoModel)CollectionsKt.getOrNull((List)localObject2, 0);
    if (localObject1 != null)
    {
      localObject1 = ((ReceiverInfoModel)localObject1).a();
      if (localObject1 != null)
      {
        localObject2 = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(((CommonOuterClass.QQUserId)localObject1).uid.get()).a();
        if (localObject2 != null)
        {
          localObject2 = (IUserInfo)((LoadDataWrapper)localObject2).a();
          if (localObject2 != null)
          {
            localObject3 = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(this.k.uid.get()).a();
            if (localObject3 != null)
            {
              IUserInfo localIUserInfo = (IUserInfo)((LoadDataWrapper)localObject3).a();
              if (localIUserInfo != null)
              {
                paramGiftServiceData.p = ((Map)new LinkedHashMap());
                localObject3 = paramGiftServiceData.p;
                ((Map)localObject3).put("sender_nick", localIUserInfo.c(this.k));
                ((Map)localObject3).put("sender_avatar", localIUserInfo.e(this.k));
                ((Map)localObject3).put("receiver_nick", ((IUserInfo)localObject2).c((CommonOuterClass.QQUserId)localObject1));
                ((Map)localObject3).put("receiver_avatar", ((IUserInfo)localObject2).e((CommonOuterClass.QQUserId)localObject1));
                ((Map)localObject3).put("receiver_uin", String.valueOf(((CommonOuterClass.QQUserId)localObject1).uid.get()));
                localObject3 = new GiftSendReqData();
                ((GiftSendReqData)localObject3).a = this.k.uid.get();
                ((GiftSendReqData)localObject3).b = ((CommonOuterClass.QQUserId)localObject1).uid.get();
                ConcurrentHashMap localConcurrentHashMap = ((GiftSendReqData)localObject3).f;
                localConcurrentHashMap.put("room_id", String.valueOf(this.j));
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("sender_user_from", this.k.user_from.get());
                localJSONObject.put("sender_guild_id", this.k.guild_id.get());
                localJSONObject.put("sender_nick", localIUserInfo.c(this.k));
                localJSONObject.put("sender_avatar", localIUserInfo.e(this.k));
                localJSONObject.put("receiver_user_from", ((CommonOuterClass.QQUserId)localObject1).user_from.get());
                localJSONObject.put("receiver_guild_id", ((CommonOuterClass.QQUserId)localObject1).guild_id.get());
                localJSONObject.put("receiver_nick", ((IUserInfo)localObject2).c((CommonOuterClass.QQUserId)localObject1));
                localJSONObject.put("receiver_avatar", ((IUserInfo)localObject2).e((CommonOuterClass.QQUserId)localObject1));
                localJSONObject.put("gift_name", paramGiftServiceData.b);
                localJSONObject.put("material_id", paramGiftServiceData.g);
                localJSONObject.put("effect_level", paramGiftServiceData.e);
                localJSONObject.put("combo_seq", paramGiftServiceData.m);
                localConcurrentHashMap.put("client_str", localJSONObject.toString());
                localConcurrentHashMap.put("user_from", String.valueOf(((CommonOuterClass.QQUserId)localObject1).user_from.get()));
                localConcurrentHashMap.put("guild_id", String.valueOf(((CommonOuterClass.QQUserId)localObject1).guild_id.get()));
                paramGiftServiceData = this.i;
                if (paramGiftServiceData != null)
                {
                  paramGiftServiceData = paramGiftServiceData.b();
                  if (paramGiftServiceData != null) {
                    paramGiftServiceData.a((GiftSendReqData)localObject3);
                  }
                }
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  private final long d()
  {
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    return ((ILoginCoreService)localIService).a();
  }
  
  public final void a()
  {
    this.c = true;
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "giftBannerViewHolder");
    this.n.setGiftBannerViewHolder(paramView);
  }
  
  public final void a(@NotNull OnSelectGiftToUserListener paramOnSelectGiftToUserListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnSelectGiftToUserListener, "listener");
    this.f = paramOnSelectGiftToUserListener;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "subSceneId");
    Object localObject1 = this.i;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((GiftSdkProvider)localObject1).d();
    } else {
      localObject1 = null;
    }
    this.d = ((IQQGiftPanelView)localObject1);
    Object localObject3 = this.d;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((IQQGiftPanelView)localObject3).a((IQQGiftPanelView.OnPanelEventListener)this.h);
      }
      ((IQQGiftPanelView)localObject3).setPanelEventListener((IQQGiftPanelView.OnPanelEventListener)localObject1);
    }
    localObject1 = this.o.getParent();
    if ((localObject1 instanceof ViewGroup)) {
      ((ViewGroup)localObject1).removeView((View)this.o);
    }
    localObject1 = this.d;
    if (localObject1 != null)
    {
      localObject2 = ((IQQGiftPanelView)localObject1).getListHeaderView();
      if (localObject2 != null)
      {
        ((IQQGiftPanelView)localObject1).getListHeaderView().setPadding(((LinearLayout)localObject2).getPaddingLeft(), 0, ((LinearLayout)localObject2).getPaddingRight(), ((LinearLayout)localObject2).getPaddingBottom());
        ((LinearLayout)localObject2).addView((View)this.o, new ViewGroup.LayoutParams(-1, -2));
      }
      localObject2 = new QQGiftDtParams();
      ((QQGiftDtParams)localObject2).b = String.valueOf(this.k.uid.get());
      ((QQGiftDtParams)localObject2).d = String.valueOf(this.j);
      ((QQGiftDtParams)localObject2).i = this.p;
      ((QQGiftDtParams)localObject2).j = paramString;
      paramString = this.m.a();
      if ((paramString.size() == 1) && (((ReceiverInfoModel)paramString.get(0)).e())) {
        ((QQGiftDtParams)localObject2).c = String.valueOf(((ReceiverInfoModel)paramString.get(0)).a().uid.get());
      }
      ((IQQGiftPanelView)localObject1).setDtParams((QQGiftDtParams)localObject2);
      ((IQQGiftPanelView)localObject1).a((View)this.n);
      paramString = this.f;
      if (paramString != null)
      {
        localObject3 = (Iterable)this.m.a();
        localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(((ReceiverInfoModel)((Iterator)localObject3).next()).a());
        }
        paramString.a((List)localObject2, this.b);
      }
      this.n.setGiftPanelView((View)((IQQGiftPanelView)localObject1).getContentView());
    }
  }
  
  public final void a(@NotNull List<ReceiverInfoModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "receiverList");
    if (!this.c) {
      return;
    }
    if ((paramList.size() == 1) && (((ReceiverInfoModel)paramList.get(0)).e()))
    {
      this.o.setCertainReceiverNameVisibility(true);
      this.o.setCertainReceiverName(((ReceiverInfoModel)paramList.get(0)).a());
    }
    else
    {
      this.o.setCertainReceiverNameVisibility(false);
    }
    this.m.a(paramList, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    GiftSdkProvider localGiftSdkProvider = this.i;
    if (localGiftSdkProvider != null) {
      localGiftSdkProvider.a(paramBoolean);
    }
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.j).b((IMsgListener)this.g);
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this);
  }
  
  public final void b()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((IQQGiftPanelView)localObject).b();
    }
    this.b = "";
    localObject = this.f;
    if (localObject != null) {
      ((OnSelectGiftToUserListener)localObject).a(CollectionsKt.emptyList(), null);
    }
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  @NotNull
  public ArrayList<Class<SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(GiftPanelControlEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof GiftPanelControlEvent)) {
      ThreadPool.a((Runnable)new TimiGiftController.onReceiveEvent.1(this, paramSimpleBaseEvent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController
 * JD-Core Version:    0.7.0.1
 */