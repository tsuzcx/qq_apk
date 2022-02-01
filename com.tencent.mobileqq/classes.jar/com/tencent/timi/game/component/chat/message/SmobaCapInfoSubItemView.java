package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.impl.ex.LongExKt;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.SmobaDataOuterClass.PlayerSettleInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "smobaHeroBaseUrl", "", "acquireAddFriendShowFlag", "", "roomId", "", "(Ljava/lang/Long;)Z", "refresh", "", "victory", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "play", "Ltrpc/yes/common/SmobaDataOuterClass$PlayerSettleInfo;", "desc", "selfQQUserId", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "msgId", "battleId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaCapInfoSubItemView
  extends FrameLayout
{
  private final String a = "https://cdn.yes.qq.com/smoba/hero/";
  private HashMap b;
  
  @JvmOverloads
  public SmobaCapInfoSubItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SmobaCapInfoSubItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SmobaCapInfoSubItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629483, (ViewGroup)this);
    ((TimiAvatarRoundImageViewImpl)a(2131446507)).setNeedDrawSex(true);
  }
  
  private final boolean a(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong != null)
    {
      long l = ((Number)paramLong).longValue();
      paramLong = (IRoomService)ServiceCenter.a(IRoomService.class);
      if (paramLong != null)
      {
        paramLong = paramLong.a(l);
        if (paramLong != null)
        {
          paramLong = paramLong.b();
          if (paramLong != null)
          {
            paramLong = paramLong.room_data_info;
            if (paramLong != null)
            {
              paramLong = paramLong.sub_create_from;
              if (paramLong != null)
              {
                i = paramLong.get();
                break label84;
              }
            }
          }
        }
      }
      int i = -1;
      label84:
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(boolean paramBoolean, @NotNull CommonOuterClass.QQUserId paramQQUserId1, @NotNull SmobaDataOuterClass.PlayerSettleInfo paramPlayerSettleInfo, @NotNull String paramString1, @Nullable CommonOuterClass.QQUserId paramQQUserId2, @Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId1, "userId");
    Intrinsics.checkParameterIsNotNull(paramPlayerSettleInfo, "play");
    Intrinsics.checkParameterIsNotNull(paramString1, "desc");
    Intrinsics.checkParameterIsNotNull(paramString2, "msgId");
    Intrinsics.checkParameterIsNotNull(paramString3, "battleId");
    ((TimiAvatarRoundImageViewImpl)a(2131446507)).setUserId(paramQQUserId1);
    ((TimiAvatarTextViewImpl)a(2131446514)).setUserId(paramQQUserId1);
    Object localObject1 = (TextView)a(2131446513);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "subKillCountTv");
    ((TextView)localObject1).setText((CharSequence)String.valueOf(paramPlayerSettleInfo.killcnt.get()));
    localObject1 = (TextView)a(2131446510);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDeadCountTv");
    ((TextView)localObject1).setText((CharSequence)String.valueOf(paramPlayerSettleInfo.deadcnt.get()));
    localObject1 = (TextView)a(2131446506);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "subAssistCountTv");
    ((TextView)localObject1).setText((CharSequence)String.valueOf(paramPlayerSettleInfo.assistcnt.get()));
    localObject1 = (URLImageView)a(2131435017);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(paramPlayerSettleInfo.heroid.get());
    ((URLImageView)localObject1).setBackgroundURL(((StringBuilder)localObject2).toString());
    localObject1 = TimiGameActivityManager.c();
    if (paramYoloRoomInfo != null)
    {
      paramPlayerSettleInfo = paramYoloRoomInfo.room_id;
      if (paramPlayerSettleInfo != null)
      {
        paramPlayerSettleInfo = Long.valueOf(paramPlayerSettleInfo.get());
        break label253;
      }
    }
    paramPlayerSettleInfo = null;
    label253:
    boolean bool3 = a(paramPlayerSettleInfo);
    boolean bool2 = true;
    boolean bool1 = true;
    long l;
    if (localObject1 == null)
    {
      paramPlayerSettleInfo = (ImageView)a(2131427765);
      Intrinsics.checkExpressionValueIsNotNull(paramPlayerSettleInfo, "addFriendIv");
      paramPlayerSettleInfo = (View)paramPlayerSettleInfo;
      if (bool3)
      {
        l = paramQQUserId1.uid.get();
        localObject1 = ServiceCenter.a(ILoginCoreService.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…nCoreService::class.java)");
        if (l != ((ILoginCoreService)localObject1).a()) {}
      }
      else
      {
        bool1 = false;
      }
      ViewExKt.a(paramPlayerSettleInfo, bool1);
    }
    else
    {
      paramPlayerSettleInfo = (ImageView)a(2131427765);
      Intrinsics.checkExpressionValueIsNotNull(paramPlayerSettleInfo, "addFriendIv");
      paramPlayerSettleInfo = (View)paramPlayerSettleInfo;
      if (bool3)
      {
        l = paramQQUserId1.uid.get();
        localObject2 = ServiceCenter.a(ILoginCoreService.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "ServiceCenter.getService…nCoreService::class.java)");
        if ((l != ((ILoginCoreService)localObject2).a()) && (!((ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class)).a(LongExKt.a(paramQQUserId1.uid.get()), (AppRuntime)localObject1)))
        {
          bool1 = bool2;
          break label461;
        }
      }
      bool1 = false;
      label461:
      ViewExKt.a(paramPlayerSettleInfo, bool1);
    }
    ((ImageView)a(2131427765)).setOnClickListener((View.OnClickListener)new SmobaCapInfoSubItemView.refresh.1(this, paramQQUserId2, paramQQUserId1));
    paramPlayerSettleInfo = (TextView)a(2131446511);
    Intrinsics.checkExpressionValueIsNotNull(paramPlayerSettleInfo, "subDescTv");
    paramPlayerSettleInfo.setText((CharSequence)paramString1);
    if (paramBoolean)
    {
      ((LinearLayout)a(2131446509)).setBackgroundResource(2130853063);
      ((TextView)a(2131446511)).setTextColor(Color.parseColor("#B64501"));
    }
    else
    {
      ((LinearLayout)a(2131446509)).setBackgroundResource(2130853062);
      ((TextView)a(2131446511)).setTextColor(ResUtils.b(2131168483));
    }
    paramPlayerSettleInfo = (TimiAvatarRoundImageViewImpl)a(2131446507);
    Intrinsics.checkExpressionValueIsNotNull(paramPlayerSettleInfo, "subAvatarView");
    paramPlayerSettleInfo.setClickable(false);
    paramPlayerSettleInfo = (TimiAvatarTextViewImpl)a(2131446514);
    Intrinsics.checkExpressionValueIsNotNull(paramPlayerSettleInfo, "subNickView");
    paramPlayerSettleInfo.setClickable(false);
    if (paramYoloRoomInfo != null)
    {
      paramPlayerSettleInfo = (IReportService)ServiceCenter.a(IReportService.class);
      paramString1 = (TimiAvatarRoundImageViewImpl)a(2131446507);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "subAvatarView");
      paramString1 = (View)paramString1;
      paramQQUserId2 = new StringBuilder();
      paramQQUserId2.append(paramString2);
      paramQQUserId2.append('_');
      paramQQUserId2.append(paramQQUserId1.uid.get());
      paramQQUserId2 = paramQQUserId2.toString();
      localObject1 = YoloRoomUtil.c(paramYoloRoomInfo);
      ((ConcurrentHashMap)localObject1).put("yes_to_uid", LongExKt.a(paramQQUserId1.uid.get()));
      ((ConcurrentHashMap)localObject1).put("yes_battle_id", paramString3);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "YoloRoomUtil.getCommonRo…ttleId)\n                }");
      IReportService.DefaultImpls.a(paramPlayerSettleInfo, paramString1, false, paramQQUserId2, "em_yes_chat_record_user_head", (Map)localObject1, 2, null);
      paramPlayerSettleInfo = (IReportService)ServiceCenter.a(IReportService.class);
      paramString1 = (ImageView)a(2131427765);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "addFriendIv");
      paramString1 = (View)paramString1;
      paramQQUserId2 = new StringBuilder();
      paramQQUserId2.append(paramString2);
      paramQQUserId2.append('_');
      paramQQUserId2.append(paramQQUserId1.uid.get());
      paramQQUserId2 = paramQQUserId2.toString();
      paramYoloRoomInfo = YoloRoomUtil.c(paramYoloRoomInfo);
      paramYoloRoomInfo.put("yes_to_uid", LongExKt.a(paramQQUserId1.uid.get()));
      paramYoloRoomInfo.put("yes_battle_id", paramString3);
      Intrinsics.checkExpressionValueIsNotNull(paramYoloRoomInfo, "YoloRoomUtil.getCommonRo…ttleId)\n                }");
      IReportService.DefaultImpls.a(paramPlayerSettleInfo, paramString1, false, paramQQUserId2, "em_yes_chat_record_add_friend", (Map)paramYoloRoomInfo, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaCapInfoSubItemView
 * JD-Core Version:    0.7.0.1
 */