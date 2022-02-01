package com.tencent.timi.game.component.chat.util;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.QQUserInfoMsg;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/util/MessageUtil;", "", "()V", "TAG", "", "proTipPisition", "", "showKey", "tipList", "", "acquireProfileTipText", "createProfileMessage", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "getGiftSDKBusinessID", "roomId", "", "initTipList", "", "realSendProfileMessage", "manager", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "context", "Landroid/content/Context;", "sendProfileMessage", "sendUserProfileError", "userId", "showProfileSendTip", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageUtil
{
  public static final MessageUtil a = new MessageUtil();
  private static final String b = "MessageUtil";
  private static final String c = "TG_MESSAGE_PROFILE_TIP_SHOWED";
  private static final List<String> d = (List)new ArrayList();
  private static int e;
  
  private final String a()
  {
    if (d.size() == 0)
    {
      Logger.c(b, "acquireProfileTipText  error size==0");
      return "";
    }
    int k = d.size();
    int i = d.size();
    int j = new Random().nextInt(i + 1) % k;
    i = j;
    if (j == e) {
      i = (j + 1) % k;
    }
    e = i;
    return (String)d.get(i);
  }
  
  private final MessageOuterClass.MsgContent a(CommonOuterClass.QQUserId paramQQUserId, IUserInfo paramIUserInfo)
  {
    MessageOuterClass.QQUserInfoMsg localQQUserInfoMsg = new MessageOuterClass.QQUserInfoMsg();
    localQQUserInfoMsg.user_id.set((MessageMicro)paramQQUserId);
    localQQUserInfoMsg.show_scene.set(1);
    localQQUserInfoMsg.qq_user_info.set((MessageMicro)paramIUserInfo.d());
    localQQUserInfoMsg.add_friend_tips_text.set(a());
    paramQQUserId = new MessageOuterClass.MsgContent();
    paramQQUserId.qq_user_info_msg.set((MessageMicro)localQQUserInfoMsg);
    return paramQQUserId;
  }
  
  private final void a(Context paramContext, long paramLong)
  {
    QQToast.makeText(paramContext, (CharSequence)"用户资料获取失败", 0).show();
    paramContext = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendUserProfileError  ");
    localStringBuilder.append(Logger.b(paramLong));
    Logger.a(paramContext, localStringBuilder.toString());
  }
  
  private final void a(CommonOuterClass.QQUserId paramQQUserId, IMsgManager paramIMsgManager, Context paramContext)
  {
    boolean bool = TGSharedPreferenceUtil.b(c, false);
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).c(paramQQUserId.uid.get(), null);
    if (!bool)
    {
      new CommonDialog.Builder(paramContext).c("是否将你的个人资料及王者战绩分享到大厅").e("再考虑一下").b((DialogInterface.OnClickListener)new MessageUtil.showProfileSendTip.1()).d("确认").a((DialogInterface.OnClickListener)new MessageUtil.showProfileSendTip.2(paramQQUserId, paramIMsgManager, paramContext)).a().show();
      return;
    }
    b(paramQQUserId, paramIMsgManager, paramContext);
  }
  
  private final void b(long paramLong)
  {
    if (d.size() > 0) {
      return;
    }
    Logger.a(b, "initTipList ");
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…ass.java).getData(roomId)");
    localObject = ((IRoomGetDataService)localObject).c();
    if (localObject != null)
    {
      localObject = ((YoloRoomOuterClass.YoloRoomConf)localObject).yolo_room_community_conf;
      if (localObject != null)
      {
        localObject = ((YoloRoomOuterClass.YoloRoomCommunityConf)localObject).add_friend_tips_text_list;
        if (localObject != null)
        {
          localObject = ((PBRepeatField)localObject).get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            d.clear();
            d.addAll((Collection)localObject);
            localObject = b;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initTipList success ");
            localStringBuilder.append(d.size());
            Logger.a((String)localObject, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  private final void b(CommonOuterClass.QQUserId paramQQUserId, IMsgManager paramIMsgManager, Context paramContext)
  {
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localIService).a();
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(l, (IResultListener)new MessageUtil.realSendProfileMessage.1(paramIMsgManager, paramQQUserId, paramContext, l));
  }
  
  public final int a(long paramLong)
  {
    IRoomGetDataService localIRoomGetDataService = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong);
    Object localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject != null) {
      localObject = ((IExpandHall)localObject).b();
    } else {
      localObject = null;
    }
    Intrinsics.checkExpressionValueIsNotNull(localIRoomGetDataService, "roomData");
    if (localIRoomGetDataService.a() == 1) {
      return 10003;
    }
    if ((localIRoomGetDataService.a() == 5) && (localObject != null) && (((ExpandHallLaunchParam)localObject).a == 1)) {
      return 10005;
    }
    return 10004;
  }
  
  public final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable IMsgManager paramIMsgManager, @NotNull Context paramContext, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "qqUserId");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    b(paramLong);
    if ((paramContext instanceof QBaseActivity))
    {
      paramQQUserId = new MessageUtil.sendProfileMessage.bindListener.1(paramQQUserId, paramIMsgManager, paramContext);
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((QBaseActivity)paramContext, true, null, (IUserSmobaInfoService.BindSmobaAccountCallback)paramQQUserId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.util.MessageUtil
 * JD-Core Version:    0.7.0.1
 */