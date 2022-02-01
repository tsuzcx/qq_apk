package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.RoomInterceptCheckParam;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.Random;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUser;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams;

public class TeamConfigPageHelper
{
  private static String[] a = { "极速发车，快来！", "快上车，不解释！", "一起来玩，滴~", "来不及解释啦，快上车啊！", "车速较快，即将发车！" };
  private static Random b = new Random();
  
  public static String a()
  {
    String[] arrayOfString = a;
    return arrayOfString[b.nextInt(arrayOfString.length)];
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, long paramLong1, GuildShequnParams paramGuildShequnParams, long paramLong2, CommonOuterClass.QQUserId paramQQUserId, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openTeamCreatePage ");
    localStringBuilder.append(paramActivity);
    localStringBuilder.append(", yoloRoomCreateFrom = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", baseRoomId = ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", toShareExpandHallTimGroupId = ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", toShareUserId = ");
    localStringBuilder.append(paramQQUserId);
    Logger.a("TeamConfigPageHelper", localStringBuilder.toString());
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramActivity, RoomInterceptCheckParam.a(1), new TeamConfigPageHelper.1(paramInt1, paramInt2, paramLong1, paramGuildShequnParams, paramActivity, paramLong2, paramQQUserId, paramString));
  }
  
  public static void a(Activity paramActivity, long paramLong)
  {
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c(new TeamConfigPageHelper.2(paramLong, paramActivity));
  }
  
  public static void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, long paramLong, CommonOuterClass.QQUserId paramQQUserId, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendRoomMsgToExpandHall expandHallRoomId = ");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(", shareUserId = ");
    ((StringBuilder)localObject1).append(paramQQUserId);
    Logger.a("TeamConfigPageHelper", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleTeamInviteClick_");
    ((StringBuilder)localObject1).append(paramQQUserId.uid.get());
    if (NoDoubleClickUtils.b(((StringBuilder)localObject1).toString(), ((IRoomService)ServiceCenter.a(IRoomService.class)).c().b() * 1000L))
    {
      CustomToastView.a("说话太快了，休息一下吧");
      Logger.c("TeamConfigPageHelper", "sendRoomMsgToExpandHall but too quick!");
      return;
    }
    localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    int i;
    if ((localObject1 != null) && (((IExpandHall)localObject1).b().a == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), ((IExpandHall)localObject1).b().c);
    } else {
      localObject1 = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    }
    Object localObject2 = new MessageOuterClass.ShareYoloRoomMsg();
    ((MessageOuterClass.ShareYoloRoomMsg)localObject2).room_info.set(paramYoloRoomInfo);
    ((MessageOuterClass.ShareYoloRoomMsg)localObject2).room_speaking_pos_list.set(((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramYoloRoomInfo.room_id.get()).h());
    paramYoloRoomInfo = new MessageOuterClass.MsgContent();
    paramYoloRoomInfo.share_yolo_room_msg.set((MessageMicro)localObject2);
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramLong).a((CommonOuterClass.QQUserId)localObject1, 78, paramYoloRoomInfo);
    localObject2 = a();
    paramYoloRoomInfo = new MessageOuterClass.AtUserMsg();
    PBStringField localPBStringField = paramYoloRoomInfo.text;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject2);
    localPBStringField.set(localStringBuilder.toString());
    localObject2 = new MessageOuterClass.AtUser();
    ((MessageOuterClass.AtUser)localObject2).nick_name.set(paramString);
    ((MessageOuterClass.AtUser)localObject2).user_id.set(paramQQUserId);
    paramYoloRoomInfo.user_list.add((MessageMicro)localObject2);
    paramQQUserId = new MessageOuterClass.MsgContent();
    paramQQUserId.at_user_msg.set(paramYoloRoomInfo);
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramLong).a((CommonOuterClass.QQUserId)localObject1, 70, paramQQUserId);
    CustomToastView.a("邀请成功，等待上车");
  }
  
  private static TeamConfigDialog.OnActionClickListener b(Activity paramActivity, long paramLong1, long paramLong2, CommonOuterClass.QQUserId paramQQUserId, String paramString)
  {
    return new TeamConfigPageHelper.3(paramLong2, paramQQUserId, paramString, paramLong1);
  }
  
  private static void b(TeamConfigDialog paramTeamConfigDialog, YoloRoomOuterClass.YoloRoomParams paramYoloRoomParams, YoloRoomOuterClass.YoloSmobaRoomParams paramYoloSmobaRoomParams, long paramLong)
  {
    paramTeamConfigDialog.a();
    YoloRoomOuterClass.YoloRoomModifyInfoCmd localYoloRoomModifyInfoCmd = new YoloRoomOuterClass.YoloRoomModifyInfoCmd();
    localYoloRoomModifyInfoCmd.room_params.set(paramYoloRoomParams);
    localYoloRoomModifyInfoCmd.smoba_room_params.set(paramYoloSmobaRoomParams);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(paramLong).a(localYoloRoomModifyInfoCmd, new TeamConfigPageHelper.4(paramTeamConfigDialog));
  }
  
  private static void b(TeamConfigDialog paramTeamConfigDialog, YoloRoomOuterClass.YoloRoomParams paramYoloRoomParams, YoloRoomOuterClass.YoloSmobaRoomParams paramYoloSmobaRoomParams, long paramLong, CommonOuterClass.QQUserId paramQQUserId, String paramString)
  {
    paramTeamConfigDialog.a();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(true, paramYoloRoomParams, paramYoloSmobaRoomParams, new TeamConfigPageHelper.5(paramLong, paramQQUserId, paramString, paramTeamConfigDialog));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigPageHelper
 * JD-Core Version:    0.7.0.1
 */