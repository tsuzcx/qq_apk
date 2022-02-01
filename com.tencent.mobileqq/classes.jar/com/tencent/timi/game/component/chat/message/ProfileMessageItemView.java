package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import com.tencent.timi.game.profile.api.ui.ProfileMessageView;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.QQUserInfoMsg;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/ProfileMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CPDD_TYPE_TEXT", "alluerInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "cpddType", "isInFleet", "", "isVoiceRoom", "nickColor", "nickNameClickable", "com/tencent/timi/game/component/chat/message/ProfileMessageItemView$nickNameClickable$1", "Lcom/tencent/timi/game/component/chat/message/ProfileMessageItemView$nickNameClickable$1;", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "showAddFriend", "acquireReportParam", "", "", "avatarClick", "", "isFriend", "uid", "", "isInCommunity", "isJustSend", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "isRoBot", "onNickNameClick", "processAvatarClick", "refreshUI", "userInfo", "qqUserInfo", "Ltrpc/yes/common/MessageOuterClass$QQUserInfoMsg;", "renderUI", "reportFleetAddQQFriend", "view", "Landroid/view/View;", "reportProfileClick", "reportProfileNick", "reportRefSimpleParam", "toUserId", "id", "reportSimpleParam", "setTipText", "nick", "tip", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileMessageItemView
  extends BaseMessageView
{
  private boolean a;
  private IUserInfo b;
  private CommonOuterClass.QQUserId c;
  private int d = 1;
  private int e = this.d;
  private final boolean f;
  private final boolean g;
  private final int h = Color.parseColor("#F5A300");
  private final ProfileMessageItemView.nickNameClickable.1 i;
  private HashMap j;
  
  public ProfileMessageItemView(@NotNull Context paramContext)
  {
    super(paramContext);
    setContentView(2131629466);
    paramContext = (RelativeLayout)a(2131440685);
    if (paramContext != null) {
      ViewExKt.a((View)paramContext, LayoutExKt.b(15), new int[] { -1 });
    }
    paramContext = (TextView)a(2131427773);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new ProfileMessageItemView.1(this));
    }
    paramContext = (View.OnClickListener)new ProfileMessageItemView.chatListener.1(this);
    TextView localTextView = (TextView)a(2131445123);
    if (localTextView != null) {
      localTextView.setOnClickListener(paramContext);
    }
    paramContext = (TextView)a(2131430317);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "cardDescribeText");
    paramContext.setMovementMethod(LinkMovementMethod.getInstance());
    this.i = new ProfileMessageItemView.nickNameClickable.1(this);
  }
  
  public ProfileMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2131629466);
    paramContext = (RelativeLayout)a(2131440685);
    if (paramContext != null) {
      ViewExKt.a((View)paramContext, LayoutExKt.b(15), new int[] { -1 });
    }
    paramContext = (TextView)a(2131427773);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new ProfileMessageItemView.1(this));
    }
    paramContext = (View.OnClickListener)new ProfileMessageItemView.chatListener.1(this);
    paramAttributeSet = (TextView)a(2131445123);
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener(paramContext);
    }
    paramContext = (TextView)a(2131430317);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "cardDescribeText");
    paramContext.setMovementMethod(LinkMovementMethod.getInstance());
    this.i = new ProfileMessageItemView.nickNameClickable.1(this);
  }
  
  public ProfileMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629466);
    paramContext = (RelativeLayout)a(2131440685);
    if (paramContext != null) {
      ViewExKt.a((View)paramContext, LayoutExKt.b(15), new int[] { -1 });
    }
    paramContext = (TextView)a(2131427773);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new ProfileMessageItemView.1(this));
    }
    paramContext = (View.OnClickListener)new ProfileMessageItemView.chatListener.1(this);
    paramAttributeSet = (TextView)a(2131445123);
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener(paramContext);
    }
    paramContext = (TextView)a(2131430317);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "cardDescribeText");
    paramContext.setMovementMethod(LinkMovementMethod.getInstance());
    this.i = new ProfileMessageItemView.nickNameClickable.1(this);
  }
  
  private final void a(View paramView)
  {
    Map localMap = i();
    if (localMap != null) {
      ProfileReportUtil.a.a(paramView, "em_yes_chat_userprofile_nickname", localMap);
    }
  }
  
  private final void a(View paramView, long paramLong, String paramString)
  {
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = getRoomInfo();
    if (localYoloRoomInfo != null)
    {
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("yes_ref_room_id", String.valueOf(localYoloRoomInfo.room_id.get()));
      if (this.f) {
        localMap.put("yes_ref_room_type", String.valueOf(4));
      } else {
        localMap.put("yes_ref_room_type", String.valueOf(5));
      }
      localMap.put("yes_to_uid", String.valueOf(paramLong));
      ProfileReportUtil.a.a(paramView, paramString, localMap);
    }
  }
  
  private final void a(IUserInfo paramIUserInfo, MessageOuterClass.QQUserInfoMsg paramQQUserInfoMsg, IMsg paramIMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshUI ");
    ((StringBuilder)localObject).append(LogUtil.getSafePrintUin(String.valueOf(paramIUserInfo.a().longValue())));
    Logger.b("ProfileMessageItemView", ((StringBuilder)localObject).toString());
    localObject = (ProfileMessageView)a(2131440686);
    if (localObject != null) {
      ((ProfileMessageView)localObject).setUserInfo(paramIUserInfo, this.c, e(paramIMsg));
    }
    int k = paramQQUserInfoMsg.show_scene.get();
    boolean bool2 = false;
    boolean bool1;
    if (k == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    paramIUserInfo = paramIUserInfo.c(paramQQUserInfoMsg.user_id);
    if (paramIUserInfo == null) {
      paramIUserInfo = "";
    }
    paramIMsg = paramQQUserInfoMsg.add_friend_tips_text.get();
    Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "qqUserInfo.add_friend_tips_text.get()");
    a(paramIUserInfo, paramIMsg);
    paramIUserInfo = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramIUserInfo, "ServiceCenter.getService…nCoreService::class.java)");
    if (((ILoginCoreService)paramIUserInfo).a() == paramQQUserInfoMsg.user_id.uid.get()) {
      k = 1;
    } else {
      k = 0;
    }
    boolean bool3 = a(paramQQUserInfoMsg.user_id.uid.get());
    paramIUserInfo = a(2131432017);
    if (paramIUserInfo != null)
    {
      if ((this.g) && (k == 0) && (!bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ViewExKt.a(paramIUserInfo, bool1);
    }
    paramIUserInfo = (TextView)a(2131427773);
    if (paramIUserInfo != null)
    {
      paramIUserInfo = (View)paramIUserInfo;
      if ((this.g) && (k == 0) && (!bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ViewExKt.a(paramIUserInfo, bool1);
    }
    paramIUserInfo = (TextView)a(2131445123);
    if (paramIUserInfo != null) {
      ViewExKt.a((View)paramIUserInfo, LayoutExKt.b(14), new int[] { Color.parseColor("#F4A92B") });
    }
    if (this.a)
    {
      paramIUserInfo = (ProfileMessageView)a(2131440686);
      if (paramIUserInfo != null)
      {
        paramIUserInfo = paramIUserInfo.a();
        if (paramIUserInfo != null) {
          ViewExKt.a(paramIUserInfo, true);
        }
      }
      paramIUserInfo = (TextView)a(2131445123);
      if (paramIUserInfo != null) {
        ViewExKt.a((View)paramIUserInfo, false);
      }
    }
    else
    {
      paramIUserInfo = (ProfileMessageView)a(2131440686);
      if (paramIUserInfo != null)
      {
        paramIUserInfo = paramIUserInfo.a();
        if (paramIUserInfo != null) {
          ViewExKt.a(paramIUserInfo, false);
        }
      }
      paramIUserInfo = (TextView)a(2131445123);
      if (paramIUserInfo != null)
      {
        paramIUserInfo = (View)paramIUserInfo;
        bool1 = bool2;
        if (k == 0)
        {
          bool1 = bool2;
          if (!e()) {
            bool1 = true;
          }
        }
        ViewExKt.a(paramIUserInfo, bool1);
      }
      paramIUserInfo = (TextView)a(2131445123);
      if (paramIUserInfo != null) {
        paramIUserInfo.setText(2131917207);
      }
      if (!e())
      {
        paramIUserInfo = (TextView)a(2131445123);
        paramQQUserInfoMsg = this.b;
        if (paramQQUserInfoMsg == null) {
          Intrinsics.throwNpe();
        }
        paramQQUserInfoMsg = paramQQUserInfoMsg.a();
        Intrinsics.checkExpressionValueIsNotNull(paramQQUserInfoMsg, "alluerInfo!!.uid()");
        b(paramIUserInfo, paramQQUserInfoMsg.longValue(), "em_yes_chat_userprofile_sayhi");
      }
    }
    if (this.a)
    {
      c((TextView)a(2131427773));
      b((ProfileMessageView)a(2131440686));
      a((TextView)a(2131430317));
      ((TextView)a(2131430317)).setTextSize(1, 10.0F);
      return;
    }
    paramIUserInfo = (TextView)a(2131427773);
    paramQQUserInfoMsg = this.b;
    if (paramQQUserInfoMsg == null) {
      Intrinsics.throwNpe();
    }
    paramQQUserInfoMsg = paramQQUserInfoMsg.a();
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserInfoMsg, "alluerInfo!!.uid()");
    a(paramIUserInfo, paramQQUserInfoMsg.longValue(), "em_yes_chat_userprofile_add_friend");
    ((TextView)a(2131430317)).setTextSize(1, 12.0F);
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1);
      localStringBuilder.append(" ");
      localStringBuilder.append(getResources().getString(2131917206));
      if (!TextUtils.isEmpty((CharSequence)paramString2))
      {
        localStringBuilder.append("，");
        localStringBuilder.append(paramString2);
      }
      paramString2 = new SpannableString((CharSequence)localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)paramString1))
      {
        paramString2.setSpan(new ForegroundColorSpan(this.h), 0, paramString1.length(), 33);
        paramString2.setSpan(this.i, 0, paramString1.length(), 33);
      }
      paramString1 = (TextView)a(2131430317);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "cardDescribeText");
      paramString1.setText((CharSequence)paramString2);
      paramString1 = (TextView)a(2131430317);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "cardDescribeText");
      ViewExKt.a((View)paramString1, true);
      return;
    }
    paramString1 = (TextView)a(2131430317);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "cardDescribeText");
    paramString2 = (CharSequence)paramString2;
    paramString1.setText(paramString2);
    paramString1 = (TextView)a(2131430317);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "cardDescribeText");
    ViewExKt.a((View)paramString1, TextUtils.isEmpty(paramString2) ^ true);
  }
  
  private final boolean a(long paramLong)
  {
    Object localObject = getContext();
    if ((localObject instanceof QBaseActivity))
    {
      ITGRelationshipService localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
      localObject = ((QBaseActivity)localObject).getAppRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "viewContext.appRuntime");
      return localITGRelationshipService.a(String.valueOf(paramLong), (AppRuntime)localObject);
    }
    return true;
  }
  
  private final void b(View paramView)
  {
    Map localMap = i();
    if (localMap != null) {
      ProfileReportUtil.a.a(paramView, "em_yes_chat_userprofile_user_head", localMap);
    }
  }
  
  private final void b(View paramView, long paramLong, String paramString)
  {
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = getRoomInfo();
    if (localYoloRoomInfo != null)
    {
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("yes_room_id", String.valueOf(localYoloRoomInfo.room_id.get()));
      if (this.f) {
        localMap.put("yes_room_type", String.valueOf(4));
      } else {
        localMap.put("yes_room_type", String.valueOf(5));
      }
      localMap.put("yes_to_uid", String.valueOf(paramLong));
      ProfileReportUtil.a.a(paramView, paramString, localMap);
    }
  }
  
  private final void c(View paramView)
  {
    Map localMap = i();
    if (localMap != null) {
      ProfileReportUtil.a.a(paramView, "em_yes_chat_userprofile_add_friend", localMap);
    }
  }
  
  private final void d()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new ProfileMessageItemView.processAvatarClick.listener.1(this);
    ProfileMessageView localProfileMessageView = (ProfileMessageView)a(2131440686);
    if (localProfileMessageView != null) {
      localProfileMessageView.setAvatarClickListener(localOnClickListener);
    }
  }
  
  private final boolean e()
  {
    Object localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject != null)
    {
      localObject = ((IExpandHall)localObject).b();
      if ((localObject != null) && (((ExpandHallLaunchParam)localObject).a == 2)) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean e(IMsg paramIMsg)
  {
    return System.currentTimeMillis() - paramIMsg.e() < 3000L;
  }
  
  private final boolean f()
  {
    Object localObject = getMsg();
    if (localObject != null)
    {
      localObject = ((IMsg)localObject).d();
      if (localObject != null)
      {
        localObject = ((CommonOuterClass.QQUserId)localObject).uid;
        if ((localObject != null) && (((PBUInt64Field)localObject).get() == 2000L)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private final void g()
  {
    Object localObject = getMsg();
    if (localObject != null) {
      if (f())
      {
        localObject = this.c;
        if (localObject != null)
        {
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          a((CommonOuterClass.QQUserId)localObject);
        }
      }
      else
      {
        a((IMsg)localObject);
      }
    }
  }
  
  private final void h()
  {
    g();
    Map localMap = i();
    if (localMap != null)
    {
      IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
      TextView localTextView = (TextView)a(2131430317);
      if (localTextView != null)
      {
        localIReportService.a("clck", (Object)localTextView, localMap);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
  
  private final Map<String, String> i()
  {
    Map localMap = getReportParam();
    if ((localMap instanceof ConcurrentHashMap))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)localMap;
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((IUserInfo)localObject).a();
        if (localObject != null)
        {
          localObject = String.valueOf(((Long)localObject).longValue());
          if (localObject != null) {
            break label56;
          }
        }
      }
      localObject = "";
      label56:
      localConcurrentHashMap.put("yes_to_uid", localObject);
    }
    return localMap;
  }
  
  public View a(int paramInt)
  {
    if (this.j == null) {
      this.j = new HashMap();
    }
    View localView2 = (View)this.j.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.j.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    MessageOuterClass.QQUserInfoMsg localQQUserInfoMsg = (MessageOuterClass.QQUserInfoMsg)paramIMsg.g().qq_user_info_msg.get();
    if (localQQUserInfoMsg != null)
    {
      Object localObject = (IUserInfoService)ServiceCenter.a(IUserInfoService.class);
      UserProxyCmdOuterClass.QQUserInfo localQQUserInfo = localQQUserInfoMsg.qq_user_info;
      Intrinsics.checkExpressionValueIsNotNull(localQQUserInfo, "it.qq_user_info");
      localObject = ((IUserInfoService)localObject).a(localQQUserInfo);
      this.b = ((IUserInfo)localObject);
      this.c = localQQUserInfoMsg.user_id;
      a((IUserInfo)localObject, localQQUserInfoMsg, paramIMsg);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.ProfileMessageItemView
 * JD-Core Version:    0.7.0.1
 */