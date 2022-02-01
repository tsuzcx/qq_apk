package com.tencent.timi.game.liveroom.impl.view.message;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.timi.game.component.chat.at.AtMessageClickListener;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.util.EmotionCodecUtils;
import com.tencent.timi.game.liveroom.api.message.ILiveMsg;
import com.tencent.timi.game.liveroom.impl.message.AnchorLiveSysMsg;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUser;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorTextMsgItemView;", "Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "anchorSpan", "Landroid/text/SpannableStringBuilder;", "getAnchorSpan", "()Landroid/text/SpannableStringBuilder;", "anchorSpan$delegate", "Lkotlin/Lazy;", "atBgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getAtBgDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "atBgDrawable$delegate", "atUserInfoMap", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "nickClickSpan", "Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView$NickNameLongClick;", "getNickClickSpan", "()Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView$NickNameLongClick;", "nickClickSpan$delegate", "spannable", "sysBgDrawable", "getSysBgDrawable", "sysBgDrawable$delegate", "uidAtInfoMap", "", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "handleAtMsg", "", "msg", "Lcom/tencent/timi/game/liveroom/api/message/ILiveMsg;", "anchorId", "renderEnterRoom", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "renderFollow", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "renderLive", "renderSysMsg", "Lcom/tencent/timi/game/liveroom/impl/message/AnchorLiveSysMsg;", "resetUserInfoMap", "data", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class AnchorTextMsgItemView
  extends AnchorBaseTextMsgItemView
{
  private final String a = "AnchorTextMsgItemView";
  private Map<String, CommonOuterClass.QQUserId> b = (Map)new LinkedHashMap();
  private Map<Long, MessageOuterClass.AtUser> c = (Map)new LinkedHashMap();
  private final SpannableStringBuilder d = new SpannableStringBuilder();
  private final Lazy e;
  private final Lazy f;
  private final Lazy g;
  private final Lazy h;
  
  @JvmOverloads
  public AnchorTextMsgItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorTextMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorTextMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = LazyKt.lazy((Function0)new AnchorTextMsgItemView.anchorSpan.2(this, paramContext));
    this.f = LazyKt.lazy((Function0)AnchorTextMsgItemView.atBgDrawable.2.INSTANCE);
    this.g = LazyKt.lazy((Function0)AnchorTextMsgItemView.sysBgDrawable.2.INSTANCE);
    this.h = LazyKt.lazy((Function0)AnchorTextMsgItemView.nickClickSpan.2.INSTANCE);
  }
  
  private final void b(ILiveMsg paramILiveMsg, long paramLong)
  {
    Object localObject1 = paramILiveMsg.d();
    AnchorBaseTextMsgItemView.NickNameLongClick localNickNameLongClick = null;
    if (localObject1 != null)
    {
      localObject1 = ((MessageOuterClass.TimMsgBody)localObject1).content;
      if (localObject1 != null)
      {
        localObject1 = ((MessageOuterClass.MsgContent)localObject1).at_user_msg;
        break label41;
      }
    }
    localObject1 = null;
    label41:
    if (localObject1 != null)
    {
      localObject2 = ((MessageOuterClass.AtUserMsg)localObject1).user_list;
      if (localObject2 != null)
      {
        localObject2 = ((PBRepeatMessageField)localObject2).get();
        break label71;
      }
    }
    Object localObject2 = null;
    label71:
    a((List)localObject2);
    localObject2 = localNickNameLongClick;
    if (localObject1 != null)
    {
      localObject1 = ((MessageOuterClass.AtUserMsg)localObject1).text;
      localObject2 = localNickNameLongClick;
      if (localObject1 != null) {
        localObject2 = ((PBStringField)localObject1).get();
      }
    }
    localObject1 = EmotionCodecUtils.c((String)localObject2);
    this.d.clear();
    this.d.clearSpans();
    this.d.append((CharSequence)localObject1);
    localObject2 = SpecialMsgUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "text");
    ((SpecialMsgUtil)localObject2).a(0, (String)localObject1, this.b, this.d, ResUtils.b(2131168306), false, (AtMessageClickListener)new AnchorTextMsgItemView.handleAtMsg.1(this));
    if (paramILiveMsg.b().mSpeakId == paramLong) {
      localObject1 = getAnchorSpan();
    } else {
      localObject1 = "";
    }
    localObject1 = (CharSequence)localObject1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramILiveMsg.b().mSpeakerName);
    ((StringBuilder)localObject2).append(65306);
    localObject2 = ((StringBuilder)localObject2).toString();
    localNickNameLongClick = getNickClickSpan();
    LiveUserInfo localLiveUserInfo = new LiveUserInfo();
    localLiveUserInfo.nick = paramILiveMsg.b().mSpeakerName;
    localLiveUserInfo.uid = paramILiveMsg.b().mSpeakId;
    localLiveUserInfo.headUrl = paramILiveMsg.b().mLogo;
    localNickNameLongClick.a(localLiveUserInfo, getRoomId());
    setSpanText(CollectionsKt.listOf(new CharSequence[] { localObject1, (CharSequence)a((String)localObject2, (CharacterStyle)localNickNameLongClick), (CharSequence)new QQText((CharSequence)this.d, 3, 16) }));
  }
  
  private final SpannableStringBuilder getAnchorSpan()
  {
    return (SpannableStringBuilder)this.e.getValue();
  }
  
  private final GradientDrawable getAtBgDrawable()
  {
    return (GradientDrawable)this.f.getValue();
  }
  
  private final AnchorBaseTextMsgItemView.NickNameLongClick getNickClickSpan()
  {
    return (AnchorBaseTextMsgItemView.NickNameLongClick)this.h.getValue();
  }
  
  private final GradientDrawable getSysBgDrawable()
  {
    return (GradientDrawable)this.g.getValue();
  }
  
  public final void a(@NotNull FollowPushMessage paramFollowPushMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramFollowPushMessage, "msg");
    setBackgroundDrawable((Drawable)getBgDrawable());
    String str = String.valueOf(paramFollowPushMessage.nick);
    AnchorBaseTextMsgItemView.NickNameLongClick localNickNameLongClick = getNickClickSpan();
    LiveUserInfo localLiveUserInfo = new LiveUserInfo();
    localLiveUserInfo.nick = paramFollowPushMessage.nick;
    localLiveUserInfo.uid = paramFollowPushMessage.uid;
    localLiveUserInfo.headUrl = paramFollowPushMessage.icon;
    localNickNameLongClick.a(localLiveUserInfo, getRoomId());
    setSpanText(CollectionsKt.listOf(new CharSequence[] { (CharSequence)a(str, (CharacterStyle)localNickNameLongClick), (CharSequence)" 关注了主播" }));
  }
  
  public final void a(@NotNull LiveMessageData.SpeakerInfo paramSpeakerInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramSpeakerInfo, "msg");
    setBackgroundDrawable((Drawable)getBgDrawable());
    String str = String.valueOf(paramSpeakerInfo.mSpeakerName);
    AnchorBaseTextMsgItemView.NickNameLongClick localNickNameLongClick = getNickClickSpan();
    LiveUserInfo localLiveUserInfo = new LiveUserInfo();
    localLiveUserInfo.nick = paramSpeakerInfo.mSpeakerName;
    localLiveUserInfo.uid = paramSpeakerInfo.mSpeakId;
    localLiveUserInfo.headUrl = paramSpeakerInfo.mLogo;
    localNickNameLongClick.a(localLiveUserInfo, getRoomId());
    setSpanText(CollectionsKt.listOf(new CharSequence[] { (CharSequence)a(str, (CharacterStyle)localNickNameLongClick), (CharSequence)" 进入了房间" }));
  }
  
  public final void a(@NotNull ILiveMsg paramILiveMsg, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramILiveMsg, "msg");
    Object localObject1 = paramILiveMsg.d();
    if (localObject1 != null)
    {
      localObject1 = ((MessageOuterClass.TimMsgBody)localObject1).msg_type;
      if ((localObject1 != null) && (((PBInt32Field)localObject1).get() == 70))
      {
        setBackgroundDrawable((Drawable)getAtBgDrawable());
        b(paramILiveMsg, paramLong);
        return;
      }
    }
    setBackgroundDrawable((Drawable)getBgDrawable());
    String str = EmotionCodecUtils.c(paramILiveMsg.c());
    if (paramILiveMsg.b().mSpeakId == paramLong) {
      localObject1 = getAnchorSpan();
    } else {
      localObject1 = "";
    }
    localObject1 = (CharSequence)localObject1;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramILiveMsg.b().mSpeakerName);
    ((StringBuilder)localObject2).append(65306);
    localObject2 = ((StringBuilder)localObject2).toString();
    AnchorBaseTextMsgItemView.NickNameLongClick localNickNameLongClick = getNickClickSpan();
    LiveUserInfo localLiveUserInfo = new LiveUserInfo();
    localLiveUserInfo.nick = paramILiveMsg.b().mSpeakerName;
    localLiveUserInfo.uid = paramILiveMsg.b().mSpeakId;
    localLiveUserInfo.headUrl = paramILiveMsg.b().mLogo;
    localNickNameLongClick.a(localLiveUserInfo, getRoomId());
    setSpanText(CollectionsKt.listOf(new CharSequence[] { localObject1, (CharSequence)a((String)localObject2, (CharacterStyle)localNickNameLongClick), (CharSequence)new QQText((CharSequence)str, 3, 16) }));
  }
  
  public final void a(@NotNull AnchorLiveSysMsg paramAnchorLiveSysMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramAnchorLiveSysMsg, "msg");
    setBackgroundDrawable((Drawable)getSysBgDrawable());
    setSpanText(CollectionsKt.listOf(paramAnchorLiveSysMsg.a()));
  }
  
  public final void a(@Nullable List<MessageOuterClass.AtUser> paramList)
  {
    this.b.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        MessageOuterClass.AtUser localAtUser = (MessageOuterClass.AtUser)paramList.next();
        if (localAtUser.user_id.uid.get() != 0L)
        {
          CommonOuterClass.QQUserId localQQUserId = (CommonOuterClass.QQUserId)localAtUser.user_id.get();
          String str = localAtUser.nick_name.get();
          if (!TextUtils.isEmpty((CharSequence)str))
          {
            Map localMap = this.b;
            Intrinsics.checkExpressionValueIsNotNull(str, "atUserName");
            Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "atUserId");
            localMap.put(str, localQQUserId);
          }
          this.c.put(Long.valueOf(localQQUserId.uid.get()), localAtUser);
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("atUserInfoMap =");
    paramList.append(this.b);
    Logger.a("TxtMsgView ", paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorTextMsgItemView
 * JD-Core Version:    0.7.0.1
 */