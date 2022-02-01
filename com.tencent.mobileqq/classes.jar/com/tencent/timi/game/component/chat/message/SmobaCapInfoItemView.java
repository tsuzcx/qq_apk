package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.SmobaDataOuterClass.GameCampSettleInfo;
import trpc.yes.common.SmobaDataOuterClass.PlayerSettleInfo;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleConfig;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleResult;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomBattleResultAction;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarViews", "", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "subItemViews", "Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView;", "addAvatarView", "", "addSubItemView", "renderUI", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaCapInfoItemView
  extends BaseMessageView
{
  private List<SmobaCapInfoSubItemView> a = (List)new ArrayList();
  private List<AvatarRoundImageView> b = (List)new ArrayList();
  private HashMap c;
  
  @JvmOverloads
  public SmobaCapInfoItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SmobaCapInfoItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SmobaCapInfoItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629482);
    int i = 0;
    paramInt = 0;
    while (paramInt <= 4)
    {
      d();
      paramInt += 1;
    }
    paramInt = i;
    while (paramInt <= 2)
    {
      e();
      paramInt += 1;
    }
  }
  
  private final void d()
  {
    LinearLayout localLinearLayout = (LinearLayout)a(2131446512);
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = new SmobaCapInfoSubItemView((Context)localObject, null, 0, 6, null);
    this.a.add(localObject);
    localObject = (View)localObject;
    Intrinsics.checkExpressionValueIsNotNull((LinearLayout)a(2131446512), "subItemLl");
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(LayoutExKt.a(this), LayoutExKt.a(this)));
  }
  
  private final void e()
  {
    LinearLayout localLinearLayout = (LinearLayout)a(2131438849);
    Object localObject = new AvatarRoundImageView(getContext());
    this.b.add(localObject);
    ((AvatarRoundImageView)localObject).setNeedDrawSex(true);
    localObject = (View)localObject;
    Intrinsics.checkExpressionValueIsNotNull((LinearLayout)a(2131446512), "subItemLl");
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(LayoutExKt.b(26), LayoutExKt.b(26));
    localLayoutParams.leftMargin = LayoutExKt.b(8);
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    Object localObject3 = paramIMsg.g().yolo_room_action_msg.yolo_room_action.yolo_smoba_room_battle_result_action;
    Object localObject1 = ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).smoba_battle_result.camp_settle_list;
    localObject1 = (TextView)a(2131447477);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "titleTv");
    ((TextView)localObject1).setText((CharSequence)"你们刚刚结束了一场比赛");
    localObject1 = ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).smoba_battle_result.camp_settle_list.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "action.smoba_battle_result.camp_settle_list.get()");
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = ((Iterator)localObject4).next();
      localObject1 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject2).campsettledetail.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "list.campsettledetail.get()");
      localObject5 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = ((Iterator)localObject5).next();
        if (((SmobaDataOuterClass.PlayerSettleInfo)localObject1).uid.get() > 0L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label201;
        }
      }
      localObject1 = null;
      label201:
      if (localObject1 != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = localObject2;
        break label227;
      }
    }
    localObject1 = null;
    label227:
    localObject4 = (SmobaDataOuterClass.GameCampSettleInfo)localObject1;
    localObject1 = ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).smoba_battle_result.camp_settle_list.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "action.smoba_battle_result.camp_settle_list.get()");
    Object localObject5 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = ((Iterator)localObject5).next();
      localObject1 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject2).campsettledetail.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "list.campsettledetail.get()");
      localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (((SmobaDataOuterClass.PlayerSettleInfo)localObject1).uid.get() > 0L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label369;
        }
      }
      localObject1 = null;
      label369:
      if (localObject1 == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = localObject2;
        break label395;
      }
    }
    localObject1 = null;
    label395:
    localObject1 = (SmobaDataOuterClass.GameCampSettleInfo)localObject1;
    Object localObject2 = (MediumBoldTextView)a(2131445564);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "selfKillCountTv");
    if (localObject4 != null)
    {
      localObject5 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject4).total_kill_count;
      if (localObject5 != null)
      {
        i = ((PBInt32Field)localObject5).get();
        break label450;
      }
    }
    int i = 0;
    label450:
    ((MediumBoldTextView)localObject2).setText((CharSequence)String.valueOf(i));
    localObject2 = (MediumBoldTextView)a(2131439707);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "otherKillCountTv");
    if (localObject1 != null)
    {
      localObject1 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject1).total_kill_count;
      if (localObject1 != null)
      {
        i = ((PBInt32Field)localObject1).get();
        break label510;
      }
    }
    i = 0;
    label510:
    ((MediumBoldTextView)localObject2).setText((CharSequence)String.valueOf(i));
    localObject2 = (TextView)a(2131438793);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "modeTv");
    i = ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).smoba_battle_result.smoba_config.game_mode.get();
    if (i != 1)
    {
      if (i != 2) {
        localObject1 = (CharSequence)"5v5匹配赛";
      } else {
        localObject1 = (CharSequence)"五人排位赛";
      }
    }
    else {
      localObject1 = (CharSequence)"多人排位赛";
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = (TextView)a(2131447351);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "timeTv");
    localObject2 = new StringBuilder();
    if (localObject4 != null)
    {
      localObject5 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject4).battle_duration;
      if (localObject5 != null)
      {
        i = ((PBUInt32Field)localObject5).get();
        break label661;
      }
    }
    i = 0;
    label661:
    ((StringBuilder)localObject2).append(i / 60);
    ((StringBuilder)localObject2).append("分钟");
    ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject2).toString());
    if (localObject4 != null)
    {
      localObject1 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject4).campresult;
      if (localObject1 != null)
      {
        i = ((PBInt32Field)localObject1).get();
        break label721;
      }
    }
    i = 0;
    label721:
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      i = Color.parseColor("#FFE99F");
      ((MediumBoldTextView)a(2131445564)).setTextColor(i);
      ((MediumBoldTextView)a(2131450009)).setTextColor(i);
      ((MediumBoldTextView)a(2131439707)).setTextColor(i);
      ((ConstraintLayout)a(2131431338)).setBackgroundResource(2130853059);
      a(2131438359).setBackgroundResource(2130853060);
      ((ImageView)a(2131430300)).setImageResource(2130853020);
    }
    else
    {
      i = ResUtils.b(2131168464);
      ((MediumBoldTextView)a(2131445564)).setTextColor(i);
      ((MediumBoldTextView)a(2131450009)).setTextColor(i);
      ((MediumBoldTextView)a(2131439707)).setTextColor(i);
      ((ConstraintLayout)a(2131431338)).setBackgroundResource(2130853053);
      a(2131438359).setBackgroundResource(2130853054);
      ((ImageView)a(2131430300)).setImageResource(2130853003);
    }
    localObject1 = ((Iterable)this.a).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ViewExKt.a((View)((Iterator)localObject1).next(), false);
    }
    localObject5 = ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).user_id_list.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "qqUsers");
    localObject2 = (Iterable)localObject5;
    Iterator localIterator = ((Iterable)localObject2).iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      CommonOuterClass.QQUserId localQQUserId1 = (CommonOuterClass.QQUserId)localObject1;
      if (localObject4 != null)
      {
        localObject1 = ((SmobaDataOuterClass.GameCampSettleInfo)localObject4).campsettledetail;
        if (localObject1 != null)
        {
          localObject1 = ((PBRepeatMessageField)localObject1).get();
          if (localObject1 != null)
          {
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              SmobaDataOuterClass.PlayerSettleInfo localPlayerSettleInfo = (SmobaDataOuterClass.PlayerSettleInfo)((Iterator)localObject1).next();
              int j;
              if (localPlayerSettleInfo.uid.get() == localQQUserId1.uid.get()) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0)
              {
                if (localPlayerSettleInfo == null) {
                  break label1314;
                }
                if (i < 2) {
                  ViewExKt.a((View)this.a.get(i), true);
                }
                if (i < ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).battle_result_text.size()) {
                  localObject1 = (String)((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).battle_result_text.get().get(i);
                } else {
                  localObject1 = "";
                }
                SmobaCapInfoSubItemView localSmobaCapInfoSubItemView = (SmobaCapInfoSubItemView)this.a.get(i);
                Intrinsics.checkExpressionValueIsNotNull(localQQUserId1, "qqUserId");
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "desc");
                CommonOuterClass.QQUserId localQQUserId2 = getSelfQQUserId();
                YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = getRoomInfo();
                String str1 = paramIMsg.a();
                String str2 = ((YoloRoomOuterClass.YoloSmobaRoomBattleResultAction)localObject3).smoba_battle_result.battle_id.get();
                Intrinsics.checkExpressionValueIsNotNull(str2, "action.smoba_battle_result.battle_id.get()");
                localSmobaCapInfoSubItemView.a(bool, localQQUserId1, localPlayerSettleInfo, (String)localObject1, localQQUserId2, localYoloRoomInfo, str1, str2);
                break label1314;
              }
            }
            throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
          }
        }
      }
      label1314:
      i += 1;
    }
    if (((List)localObject5).size() > 2)
    {
      localObject1 = (LinearLayout)a(2131438849);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreInfoLl");
      ViewExKt.a((View)localObject1, true);
      localObject1 = (ImageView)a(2131438845);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreArrowIv");
      ViewExKt.a((View)localObject1, true);
      localObject1 = ((Iterable)this.b).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ViewExKt.a((View)((Iterator)localObject1).next(), false);
      }
      localObject1 = ((Iterable)((List)localObject5).subList(2, ((List)localObject5).size())).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((Iterator)localObject1).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject3 = (CommonOuterClass.QQUserId)localObject3;
        ViewExKt.a((View)this.b.get(i), true);
        ((AvatarRoundImageView)this.b.get(i)).setUserId((CommonOuterClass.QQUserId)localObject3);
        i += 1;
      }
    }
    localObject1 = (LinearLayout)a(2131438849);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreInfoLl");
    ViewExKt.a((View)localObject1, false);
    localObject1 = (ImageView)a(2131438845);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreArrowIv");
    ViewExKt.a((View)localObject1, false);
    ((ImageView)a(2131438845)).setOnClickListener((View.OnClickListener)new SmobaCapInfoItemView.renderUI.5(this, paramIMsg, (List)localObject5));
    if (paramIMsg.m() == 1)
    {
      paramIMsg = (LinearLayout)a(2131438849);
      Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "moreInfoLl");
      paramIMsg = (View)paramIMsg;
      i = 0;
      ViewExKt.a(paramIMsg, false);
      paramIMsg = (ImageView)a(2131438845);
      Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "moreArrowIv");
      ViewExKt.a((View)paramIMsg, false);
      paramIMsg = ((Iterable)localObject2).iterator();
      while (paramIMsg.hasNext())
      {
        localObject1 = paramIMsg.next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject1 = (CommonOuterClass.QQUserId)localObject1;
        ViewExKt.a((View)this.a.get(i), true);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaCapInfoItemView
 * JD-Core Version:    0.7.0.1
 */