package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.component.chat.util.MessageUtil;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.initer.impl.GiftSdkInitManager;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.utils.Logger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.GiftMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curBusinessId", "curGiftId", "curRoomId", "", "giftSDK", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "getGiftSDK", "()Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "getGiftImageView", "Lcom/tencent/image/URLImageView;", "getReportParams", "", "", "roomId", "toUid", "getSendGiftDetailTextView", "Landroid/widget/TextView;", "getUsrNameClickView", "Landroid/view/View;", "getUsrNameTextView", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "loadGiftImage", "", "giftID", "businessId", "loadGiftImageInner", "materialID", "renderUI", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class SendGiftMessageBaseItemView
  extends BaseMessageView
{
  public static final SendGiftMessageBaseItemView.Companion a = new SendGiftMessageBaseItemView.Companion(null);
  private int b;
  private long c;
  private int d;
  private HashMap e;
  
  @JvmOverloads
  public SendGiftMessageBaseItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SendGiftMessageBaseItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SendGiftMessageBaseItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final Map<String, String> a(long paramLong1, long paramLong2)
  {
    Object localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
    if (localObject2 != null)
    {
      localObject2 = ((IExpandHall)localObject2).b();
      if ((localObject2 != null) && (((ExpandHallLaunchParam)localObject2).a == 2))
      {
        localObject1 = TeamUtil.a(paramLong1);
        ((ConcurrentHashMap)localObject1).put("yes_to_uid", String.valueOf(paramLong2));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "TeamUtil.getCommonRoomIn…, \"$toUid\")\n            }");
        return (Map)localObject1;
      }
    }
    localObject2 = TuplesKt.to("yes_room_id", String.valueOf(paramLong1));
    if (localObject1 != null)
    {
      localObject1 = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_type;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((PBInt32Field)localObject1).get());
        break label134;
      }
    }
    localObject1 = null;
    label134:
    return MapsKt.mapOf(new Pair[] { localObject2, TuplesKt.to("yes_room_type", String.valueOf(localObject1)), TuplesKt.to("yes_to_uid", String.valueOf(paramLong2)) });
  }
  
  private final void a(int paramInt1, int paramInt2, IQQGiftSDK paramIQQGiftSDK)
  {
    paramIQQGiftSDK.g().a(paramInt2, (IQQGiftPanelResDownloadCallback)new SendGiftMessageBaseItemView.loadGiftImageInner.1(this, paramInt1));
  }
  
  private final void a(IQQGiftSDK paramIQQGiftSDK, int paramInt1, int paramInt2)
  {
    Object localObject1 = new GiftListData(1, String.valueOf(paramInt2), "", "");
    List localList = paramIQQGiftSDK.d().a((GiftListData)localObject1);
    Object localObject2 = (Collection)localList;
    if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if (paramInt2 != 0)
    {
      paramIQQGiftSDK.d().a((GiftListData)localObject1, (IQQGiftListCallback)new SendGiftMessageBaseItemView.loadGiftImage.1(this, paramInt1, paramIQQGiftSDK));
      return;
    }
    localObject2 = ((Iterable)localList).iterator();
    do
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      localList = null;
      if (!bool) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((GiftServiceData)localObject1).a == paramInt1) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
    } while (paramInt2 == 0);
    break label163;
    localObject1 = null;
    label163:
    localObject2 = (GiftServiceData)localObject1;
    localObject1 = localList;
    if (localObject2 != null) {
      localObject1 = Integer.valueOf(((GiftServiceData)localObject2).g);
    }
    if (localObject1 == null)
    {
      Logger.c("SendGiftMessageBaseItemView", "materialID is null");
      return;
    }
    a(paramInt1, ((Integer)localObject1).intValue(), paramIQQGiftSDK);
  }
  
  private final IQQGiftSDK getGiftSDK()
  {
    IQQGiftSDK localIQQGiftSDK = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(this.d);
    Intrinsics.checkExpressionValueIsNotNull(localIQQGiftSDK, "giftSDK");
    if ((localIQQGiftSDK.a()) && (!localIQQGiftSDK.k())) {
      return localIQQGiftSDK;
    }
    return null;
  }
  
  public View a(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    this.b = 0;
    this.c = 0L;
    MessageOuterClass.GiftMsg localGiftMsg = paramIMsg.g().gift_msg;
    if (localGiftMsg != null)
    {
      this.b = localGiftMsg.gift_id.get();
      this.c = localGiftMsg.room_id.get();
      int i = MessageUtil.a.a(localGiftMsg.room_id.get());
      GiftSdkInitManager.a.a(i);
      getGiftImageView().setImageDrawable(null);
      getUsrNameTextView().setUserId(localGiftMsg.recv_user_id);
      TextView localTextView = getSendGiftDetailTextView();
      String str = ResUtils.c(2131916246);
      Intrinsics.checkExpressionValueIsNotNull(str, "ResUtils.getString(R.string.send_gift_to_someone)");
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localGiftMsg.gift_name.get();
      arrayOfObject[1] = Integer.valueOf(localGiftMsg.total_num.get());
      str = String.format(str, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
      localTextView.setText((CharSequence)str);
      getUsrNameClickView().setOnClickListener((View.OnClickListener)new SendGiftMessageBaseItemView.renderUI..inlined.also.lambda.1(localGiftMsg, this, paramIMsg));
      getGiftImageView().setImageDrawable(null);
      ((IReportService)ServiceCenter.a(IReportService.class)).a(getUsrNameClickView(), true, String.valueOf(paramIMsg.a()), "em_yes_chat_nickname", a(localGiftMsg.room_id.get(), localGiftMsg.recv_user_id.uid.get()));
      this.d = i;
      paramIMsg = getGiftSDK();
      if (paramIMsg != null) {
        a(paramIMsg, this.b, this.d);
      }
    }
  }
  
  @NotNull
  public abstract URLImageView getGiftImageView();
  
  @NotNull
  public abstract TextView getSendGiftDetailTextView();
  
  @NotNull
  public abstract View getUsrNameClickView();
  
  @NotNull
  public abstract AvatarTextView getUsrNameTextView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView
 * JD-Core Version:    0.7.0.1
 */