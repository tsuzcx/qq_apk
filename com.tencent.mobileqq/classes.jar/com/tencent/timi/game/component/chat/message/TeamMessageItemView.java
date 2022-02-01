package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.AutoUpdateServiceListener;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaUserGameData;
import trpc.yes.common.YoloRoomOuterClass.YoloUserGameData;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/TeamMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarViews", "", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "blueDefaultDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getBlueDefaultDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "blueDefaultDrawable$delegate", "Lkotlin/Lazy;", "blueDrawable", "Lcom/tencent/image/URLDrawable;", "kotlin.jvm.PlatformType", "getBlueDrawable", "()Lcom/tencent/image/URLDrawable;", "blueDrawable$delegate", "grayDefaultDrawable", "getGrayDefaultDrawable", "grayDefaultDrawable$delegate", "grayDrawable", "getGrayDrawable", "grayDrawable$delegate", "orangeDefaultDrawable", "getOrangeDefaultDrawable", "orangeDefaultDrawable$delegate", "orangerDrawable", "getOrangerDrawable", "orangerDrawable$delegate", "roadViews", "Landroid/widget/TextView;", "teamUpdateListener", "com/tencent/timi/game/component/chat/message/TeamMessageItemView$teamUpdateListener$1", "Lcom/tencent/timi/game/component/chat/message/TeamMessageItemView$teamUpdateListener$1;", "onAttachedToWindow", "", "onDetachedFromWindow", "renderUI", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "showAll", "show", "", "showBottom", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamMessageItemView
  extends BaseMessageView
{
  public static final TeamMessageItemView.Companion a = new TeamMessageItemView.Companion(null);
  private List<? extends AvatarRoundImageView> b;
  private List<? extends TextView> c;
  private final Lazy d = LazyKt.lazy((Function0)TeamMessageItemView.blueDefaultDrawable.2.INSTANCE);
  private final Lazy e = LazyKt.lazy((Function0)TeamMessageItemView.orangeDefaultDrawable.2.INSTANCE);
  private final Lazy f = LazyKt.lazy((Function0)TeamMessageItemView.grayDefaultDrawable.2.INSTANCE);
  private final Lazy g = LazyKt.lazy((Function0)new TeamMessageItemView.blueDrawable.2(this));
  private final Lazy h = LazyKt.lazy((Function0)new TeamMessageItemView.orangerDrawable.2(this));
  private final Lazy i = LazyKt.lazy((Function0)new TeamMessageItemView.grayDrawable.2(this));
  private final TeamMessageItemView.teamUpdateListener.1 j = new TeamMessageItemView.teamUpdateListener.1(this);
  private HashMap k;
  
  @JvmOverloads
  public TeamMessageItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TeamMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TeamMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629496);
    this.b = CollectionsKt.listOf(new AvatarRoundImageView[] { (AvatarRoundImageView)a(2131429005), (AvatarRoundImageView)a(2131429006), (AvatarRoundImageView)a(2131429007), (AvatarRoundImageView)a(2131429008), (AvatarRoundImageView)a(2131429009) });
    this.c = CollectionsKt.listOf(new TextView[] { (TextView)a(2131445076), (TextView)a(2131445077), (TextView)a(2131445078), (TextView)a(2131445079), (TextView)a(2131445080) });
    paramContext = ((Iterable)this.b).iterator();
    while (paramContext.hasNext()) {
      ((AvatarRoundImageView)paramContext.next()).setNeedDrawSex(true);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = (AvatarRoundImageView)a(2131429005);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "avatarView1");
    ViewExKt.a((View)localObject, paramBoolean);
    localObject = (AvatarRoundImageView)a(2131429009);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "avatarView5");
    ViewExKt.a((View)localObject, paramBoolean);
    localObject = (TextView)a(2131445076);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "roadView1");
    ViewExKt.a((View)localObject, paramBoolean);
    localObject = (TextView)a(2131445080);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "roadView5");
    ViewExKt.a((View)localObject, paramBoolean);
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject = (ImageView)a(2131432560);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "enterRoomArrow");
    ViewExKt.a((View)localObject, paramBoolean);
    localObject = (TextView)a(2131431933);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dimissDescView");
    ViewExKt.a((View)localObject, paramBoolean ^ true);
  }
  
  private final GradientDrawable getBlueDefaultDrawable()
  {
    return (GradientDrawable)this.d.getValue();
  }
  
  private final URLDrawable getBlueDrawable()
  {
    return (URLDrawable)this.g.getValue();
  }
  
  private final GradientDrawable getGrayDefaultDrawable()
  {
    return (GradientDrawable)this.f.getValue();
  }
  
  private final URLDrawable getGrayDrawable()
  {
    return (URLDrawable)this.i.getValue();
  }
  
  private final GradientDrawable getOrangeDefaultDrawable()
  {
    return (GradientDrawable)this.e.getValue();
  }
  
  private final URLDrawable getOrangerDrawable()
  {
    return (URLDrawable)this.h.getValue();
  }
  
  public View a(int paramInt)
  {
    if (this.k == null) {
      this.k = new HashMap();
    }
    View localView2 = (View)this.k.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.k.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    Object localObject1 = paramIMsg.n();
    if ((localObject1 instanceof MessageOuterClass.ShareYoloRoomMsg)) {
      localObject1 = (MessageOuterClass.ShareYoloRoomMsg)localObject1;
    }
    for (;;)
    {
      break;
      localObject1 = (CharSequence)paramIMsg.l();
      if ((localObject1 != null) && (!StringsKt.isBlank((CharSequence)localObject1))) {
        m = 0;
      } else {
        m = 1;
      }
      if (m == 0) {}
      try
      {
        localObject3 = new MessageOuterClass.ShareYoloRoomMsg();
        localObject1 = paramIMsg.l();
        if (localObject1 == null) {
          break label1541;
        }
        localObject4 = Charsets.UTF_8;
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).getBytes((Charset)localObject4);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject4;
          List localList;
          Ref.IntRef localIntRef;
          Object localObject5;
          continue;
          Object localObject2 = null;
        }
      }
      localObject1 = (MessageOuterClass.ShareYoloRoomMsg)((MessageOuterClass.ShareYoloRoomMsg)localObject3).mergeFrom((byte[])localObject1);
      continue;
      localObject1 = paramIMsg.g().share_yolo_room_msg;
      continue;
      localObject1 = paramIMsg.g().share_yolo_room_msg;
    }
    paramIMsg.a(localObject1);
    localObject4 = ((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_info.game_data_info.smoba_game_data_info;
    localObject3 = (TextView)a(2131439127);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "nameTv");
    ((TextView)localObject3).setText((CharSequence)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_info.introduce.get());
    localObject3 = (TextView)a(2131438793);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "modeTv");
    ((TextView)localObject3).setText((CharSequence)((YoloRoomOuterClass.YoloSmobaGameDataInfo)localObject4).mode_name.get());
    localObject3 = (TextView)a(2131434335);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "gradeRangeTv");
    ((TextView)localObject3).setText((CharSequence)((ISmobaService)ServiceCenter.a(ISmobaService.class)).a(((YoloRoomOuterClass.YoloSmobaGameDataInfo)localObject4).grade_list.get()));
    localObject3 = (List)new ArrayList();
    localList = (List)new ArrayList();
    localIntRef = new Ref.IntRef();
    localIntRef.element = ((YoloRoomOuterClass.YoloSmobaGameDataInfo)localObject4).game_mode.get();
    int m = localIntRef.element;
    if (m != 1)
    {
      if (m != 2)
      {
        a(true);
        ((List)localObject3).addAll((Collection)this.b);
        localList.addAll((Collection)this.c);
      }
      else
      {
        a(true);
        ((List)localObject3).addAll((Collection)this.b);
        localList.addAll((Collection)this.c);
      }
    }
    else
    {
      ((List)localObject3).addAll((Collection)this.b.subList(1, 4));
      localList.addAll((Collection)this.c.subList(1, 4));
      a(false);
    }
    ((ImageView)a(2131429401)).setOnTouchListener(getPositionOnTouchListener());
    ((ImageView)a(2131429401)).setOnLongClickListener(getOnLongClickListner());
    if (paramIMsg.m() == 1)
    {
      ((ImageView)a(2131429401)).setImageDrawable((Drawable)getGrayDrawable());
      ((ImageView)a(2131429401)).setOnClickListener(null);
      b(false);
      paramIMsg = CollectionsKt.withIndex((Iterable)localObject3).iterator();
      while (paramIMsg.hasNext())
      {
        localObject1 = (IndexedValue)paramIMsg.next();
        ((AvatarRoundImageView)((IndexedValue)localObject1).getValue()).setDefaultImage(2130853096);
        ((AvatarRoundImageView)((IndexedValue)localObject1).getValue()).e();
        ((AvatarRoundImageView)((IndexedValue)localObject1).getValue()).setClickable(false);
      }
      paramIMsg = ((Iterable)localList).iterator();
      while (paramIMsg.hasNext()) {
        ((TextView)paramIMsg.next()).setText((CharSequence)"");
      }
      paramIMsg = (TextView)a(2131434335);
      Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "gradeRangeTv");
      ViewExKt.a((View)paramIMsg, false);
      paramIMsg = a(2131432017);
      Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "dividerView");
      ViewExKt.a(paramIMsg, false);
      paramIMsg = (TextView)a(2131438793);
      Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "modeTv");
      ViewExKt.a((View)paramIMsg, false);
      paramIMsg = (TextView)a(2131431933);
      Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "dimissDescView");
      ViewExKt.a((View)paramIMsg, true);
      return;
    }
    localObject5 = (TextView)a(2131434335);
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "gradeRangeTv");
    ViewExKt.a((View)localObject5, true);
    localObject5 = a(2131432017);
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "dividerView");
    ViewExKt.a((View)localObject5, true);
    localObject5 = (TextView)a(2131438793);
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "modeTv");
    ViewExKt.a((View)localObject5, true);
    localObject5 = (TextView)a(2131431933);
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "dimissDescView");
    ViewExKt.a((View)localObject5, false);
    b(true);
    localObject5 = CollectionsKt.withIndex((Iterable)localObject3).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      IndexedValue localIndexedValue = (IndexedValue)((Iterator)localObject5).next();
      if ((((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get().size() > localIndexedValue.getIndex()) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get(localIndexedValue.getIndex())).uid.get() != 0L))
      {
        ((AvatarRoundImageView)localIndexedValue.getValue()).setDefaultImage(2130852950);
        ((AvatarRoundImageView)localIndexedValue.getValue()).setNeedDrawSex(true);
        localObject3 = (AvatarRoundImageView)localIndexedValue.getValue();
        Object localObject6 = new CommonOuterClass.QQUserId();
        ((CommonOuterClass.QQUserId)localObject6).uid.set(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get(localIndexedValue.getIndex())).uid.get());
        ((CommonOuterClass.QQUserId)localObject6).user_from.set(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get(localIndexedValue.getIndex())).user_from.get());
        ((CommonOuterClass.QQUserId)localObject6).guild_id.set(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get(localIndexedValue.getIndex())).guild_id.get());
        ((AvatarRoundImageView)localObject3).setUserId((CommonOuterClass.QQUserId)localObject6);
        m = ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get(localIndexedValue.getIndex())).user_game_data.user_smoba_game_data.hero_lane_type.get();
        localObject6 = (TextView)localList.get(localIndexedValue.getIndex());
        if (m > 0) {
          localObject3 = (CharSequence)TeamLaneHelper.a(m, false);
        } else {
          localObject3 = (CharSequence)"";
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      else
      {
        if ((((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get().size() > localIndexedValue.getIndex()) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_speaking_pos_list.get(localIndexedValue.getIndex())).status.get() != 0)) {
          ((AvatarRoundImageView)localIndexedValue.getValue()).setDefaultImage(2130853101);
        } else {
          ((AvatarRoundImageView)localIndexedValue.getValue()).setDefaultImage(2130853072);
        }
        ((AvatarRoundImageView)localIndexedValue.getValue()).e();
        ((TextView)localList.get(localIndexedValue.getIndex())).setText((CharSequence)"");
      }
      ((AvatarRoundImageView)localIndexedValue.getValue()).setClickable(false);
    }
    m = localIntRef.element;
    if (m != 1)
    {
      if (m != 2) {
        ((ImageView)a(2131429401)).setImageDrawable((Drawable)getBlueDrawable());
      } else {
        ((ImageView)a(2131429401)).setImageDrawable((Drawable)getOrangerDrawable());
      }
    }
    else {
      ((ImageView)a(2131429401)).setImageDrawable((Drawable)getOrangerDrawable());
    }
    ((ImageView)a(2131429401)).setOnClickListener((View.OnClickListener)new TeamMessageItemView.renderUI.4(this, (MessageOuterClass.ShareYoloRoomMsg)localObject1, localIntRef, (YoloRoomOuterClass.YoloSmobaGameDataInfo)localObject4, paramIMsg));
    localObject3 = ((MessageOuterClass.ShareYoloRoomMsg)localObject1).room_info;
    localObject1 = (IReportService)ServiceCenter.a(IReportService.class);
    localObject4 = (ImageView)a(2131429401);
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "bgView");
    localObject4 = (View)localObject4;
    paramIMsg = paramIMsg.a();
    localObject3 = YoloRoomUtil.b((YoloRoomOuterClass.YoloRoomInfo)localObject3);
    ((ConcurrentHashMap)localObject3).putAll((Map)YoloRoomUtil.c(getRoomInfo()));
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "YoloRoomUtil.getCommonTe…mInfo))\n                }");
    IReportService.DefaultImpls.a((IReportService)localObject1, (View)localObject4, false, paramIMsg, "em_yes_chat_join_team", (Map)localObject3, 2, null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TeamInfoAutoUpdateService localTeamInfoAutoUpdateService = TeamInfoAutoUpdateService.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_");
    localStringBuilder.append(this.j.hashCode());
    localTeamInfoAutoUpdateService.a(localStringBuilder.toString(), (TeamInfoAutoUpdateService.AutoUpdateServiceListener)this.j);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TeamInfoAutoUpdateService localTeamInfoAutoUpdateService = TeamInfoAutoUpdateService.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_");
    localStringBuilder.append(this.j.hashCode());
    localTeamInfoAutoUpdateService.a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamMessageItemView
 * JD-Core Version:    0.7.0.1
 */