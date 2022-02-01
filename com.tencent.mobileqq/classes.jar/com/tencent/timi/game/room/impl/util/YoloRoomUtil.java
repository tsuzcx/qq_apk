package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.RoomInterceptCheckCallback;
import com.tencent.timi.game.room.api.RoomInterceptCheckParam;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.room.impl.network.CreateYoloRoomServlet;
import com.tencent.timi.game.room.impl.network.GetHallDiversionRecommendRoomServlet;
import com.tencent.timi.game.room.impl.network.GetUserOnlineRouteInfoListServlet;
import com.tencent.timi.game.room.impl.network.LeaveYoloRoomServlet;
import com.tencent.timi.game.room.impl.network.RecoverYoloRoomServlet;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.SimpleTaskListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import trpc.yes.common.RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloCommunityRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloLiveRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCreateRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams;

public class YoloRoomUtil
{
  public static String a(List<Integer> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(paramList.get(i));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    Logger.a("YoloRoomUtil", "refreshRoomRoute");
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(new YoloRoomUtil.1());
  }
  
  public static void a(long paramLong, IResultListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp> paramIResultListener)
  {
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetUserOnlineRouteInfoListServlet.a(paramLong), UserProxyCmdOuterClass.GetUserRouteInfoRsp.class, new YoloRoomUtil.11(paramLong, paramIResultListener));
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportGangupAutoLaunchSmobaActive - ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
    localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).b();
    if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomInfo)localObject).room_type.get() == 1)) {
      a(new YoloRoomUtil.15((YoloRoomOuterClass.YoloRoomInfo)localObject, paramLong));
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp> paramIResultListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendExitRoomNetReq ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", type= ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isForceExit= ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomUtil", localStringBuilder.toString());
    ((NetApi)ServiceCenter.a(NetApi.class)).a(LeaveYoloRoomServlet.a(paramLong, paramBoolean, paramInt), YoloRoomOuterClass.YoloRoomLeaveRsp.class, new YoloRoomUtil.3(paramLong, paramIResultListener));
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAndEnterExpandHallRoom , enterFrom=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", yoloRoomType=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", activity = ");
    ((StringBuilder)localObject).append(paramActivity);
    Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
    localObject = paramActivity;
    if (paramActivity == null)
    {
      localObject = TimiGameActivityManager.a();
      paramActivity = new StringBuilder();
      paramActivity.append("fix activity, new is ");
      paramActivity.append(localObject);
      Logger.c("YoloRoomUtil", paramActivity.toString());
    }
    if ((localObject != null) && ((localObject instanceof TimiGameBaseActivity)) && (!((Activity)localObject).isFinishing())) {
      ((TimiGameBaseActivity)localObject).a();
    }
    paramActivity = (NetApi)ServiceCenter.a(NetApi.class);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    paramActivity.a(GetHallDiversionRecommendRoomServlet.a(paramInt1, i, paramInt2), RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp.class, new YoloRoomUtil.6(paramIResultListener, (Activity)localObject));
  }
  
  public static void a(Activity paramActivity, RoomInterceptCheckParam paramRoomInterceptCheckParam, RoomInterceptCheckCallback paramRoomInterceptCheckCallback)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramRoomInterceptCheckParam.e);
    if ((!paramRoomInterceptCheckParam.a) && (localYoloRoomManager != null) && (paramRoomInterceptCheckParam.e == localYoloRoomManager.u()))
    {
      if (paramRoomInterceptCheckCallback != null)
      {
        paramRoomInterceptCheckCallback.b();
        a(paramActivity, localYoloRoomManager.b(), 0);
      }
    }
    else
    {
      paramRoomInterceptCheckCallback = new YoloRoomUtil.8(paramRoomInterceptCheckParam, paramRoomInterceptCheckCallback, paramActivity);
      if (paramRoomInterceptCheckParam.b == 1)
      {
        ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), new YoloRoomUtil.9(paramActivity, paramRoomInterceptCheckParam, paramRoomInterceptCheckCallback));
        return;
      }
      paramRoomInterceptCheckCallback.a();
    }
  }
  
  private static void a(SimpleTaskListener<IUserInfo> paramSimpleTaskListener)
  {
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), new YoloRoomUtil.14(paramSimpleTaskListener));
  }
  
  public static void a(boolean paramBoolean, int paramInt, YoloRoomOuterClass.YoloRoomParams paramYoloRoomParams, YoloRoomOuterClass.YoloSmobaRoomParams paramYoloSmobaRoomParams, YoloRoomOuterClass.YoloLiveRoomParams paramYoloLiveRoomParams, YoloRoomOuterClass.YoloCommunityRoomParams paramYoloCommunityRoomParams, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener)
  {
    YoloRoomOuterClass.YoloRoomParams localYoloRoomParams = new YoloRoomOuterClass.YoloRoomParams();
    localYoloRoomParams.set(paramYoloRoomParams);
    localYoloRoomParams.room_type.set(paramInt);
    paramYoloRoomParams = new StringBuilder();
    paramYoloRoomParams.append("createYoloRoom autoJumpMainPage=");
    paramYoloRoomParams.append(paramBoolean);
    paramYoloRoomParams.append(", yoloRoomType=");
    paramYoloRoomParams.append(paramInt);
    Logger.a("YoloRoomUtil", paramYoloRoomParams.toString());
    ((NetApi)ServiceCenter.a(NetApi.class)).a(CreateYoloRoomServlet.a(localYoloRoomParams, paramYoloSmobaRoomParams, paramYoloCommunityRoomParams, paramYoloLiveRoomParams), YoloRoomOuterClass.YoloRoomCreateRsp.class, new YoloRoomUtil.7(paramIResultListener, paramBoolean, paramInt));
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList, boolean paramBoolean2, GuildShequnParams paramGuildShequnParams, long paramLong2, IResultListener<YoloRoomOuterClass.YoloRoomInfo> paramIResultListener)
  {
    Object localObject = paramActivity;
    paramActivity = new StringBuilder();
    paramActivity.append("enterYoloRoom ");
    paramActivity.append(paramLong1);
    paramActivity.append(", autoJumpMainPage=");
    paramActivity.append(paramBoolean1);
    paramActivity.append(", enterFrom=");
    paramActivity.append(paramInt1);
    paramActivity.append(", subEnterFrom=");
    paramActivity.append(paramInt2);
    paramActivity.append(", yoloRoomType=");
    paramActivity.append(paramInt3);
    paramActivity.append(", joinSmobaGameMode=");
    paramActivity.append(paramInt4);
    paramActivity.append(", joinSmobaHostArea=");
    paramActivity.append(paramInt5);
    paramActivity.append(", isSelfMicOpen=");
    paramActivity.append(paramBoolean2);
    paramActivity.append(", activity = ");
    paramActivity.append(localObject);
    Logger.a("YoloRoomUtil", paramActivity.toString());
    paramActivity = (Activity)localObject;
    if (localObject == null)
    {
      paramActivity = TimiGameActivityManager.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fix activity, new is ");
      ((StringBuilder)localObject).append(paramActivity);
      Logger.c("YoloRoomUtil", ((StringBuilder)localObject).toString());
    }
    if (paramInt4 > 0) {
      localObject = RoomInterceptCheckParam.a(paramInt3, paramInt1, paramInt2, paramLong1, paramInt4, paramInt5, paramList);
    } else {
      localObject = RoomInterceptCheckParam.a(paramInt3, paramInt1, paramInt2, paramLong1);
    }
    a(paramActivity, (RoomInterceptCheckParam)localObject, new YoloRoomUtil.5(paramLong1, paramActivity, paramInt1, paramInt2, paramBoolean2, paramInt3, paramGuildShequnParams, paramLong2, paramBoolean1, paramIResultListener, paramList, paramInt4));
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != 920003)
    {
      if (paramInt != 920009) {
        return false;
      }
      CustomToastView.a("你已不在房间内");
      return true;
    }
    CustomToastView.a("房间已解散");
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleCommonJoinRoomError ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramString);
    Logger.c("YoloRoomUtil", ((StringBuilder)localObject1).toString());
    if (paramInt2 == 920002)
    {
      paramString = "车队已人满";
      localObject1 = "来晚啦，车队已人满，暂时无法加入，我们为你推荐了其他车队噢";
    }
    else if (paramInt2 == 920003)
    {
      paramString = "车队已关闭";
      localObject1 = "来晚啦，车队已解散，我们为你推荐了其他车队噢";
    }
    else if (paramInt2 == 9200119)
    {
      paramString = "车队已开始游戏";
      localObject1 = "来晚啦，车队已开始游戏，我们为你推荐了其他车队噢";
    }
    else if (paramInt2 == 9200121)
    {
      paramString = "无法加入";
      localObject1 = "王者内房间模式变更，无法加入，我们为你推荐了其他车队噢";
    }
    else
    {
      paramString = "";
      localObject1 = paramString;
    }
    if ((paramInt1 != 1) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      CustomToastView.a(((String)localObject1).replace("，我们为你推荐了其他车队噢", ""));
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramInt1 == 1))
    {
      Object localObject2 = TimiGameActivityManager.a();
      if ((localObject2 != null) && (!((QBaseActivity)localObject2).isFinishing()))
      {
        localObject1 = new CommonDialog.Builder((Context)localObject2).a(paramString).c((String)localObject1).d("去看看").a(new YoloRoomUtil.13()).e("取消").b(new YoloRoomUtil.12()).a();
        if (paramInt2 == 920003)
        {
          paramString = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
          if (paramString != null)
          {
            localObject2 = c(paramString);
            boolean bool = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramString.room_id.get()).o();
            paramString = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
            if (paramString != null)
            {
              paramString.e().a(localObject1);
            }
            else
            {
              IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
              if (bool) {
                paramString = "pg_sgrp_smoba_cpdd";
              } else {
                paramString = "pg_kl_smoba_cpdd";
              }
              localIReportService.a(localObject1, paramString);
            }
            if (bool)
            {
              ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject1).a(), false, "", "em_yes_closed_team_win_cancel", (Map)localObject2);
              ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject1).b(), false, "", "em_yes_closed_team_win_confirm", (Map)localObject2);
            }
            else
            {
              ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject1).a(), false, "", "em_yes_closed_team_win_confirm", (Map)localObject2);
              ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject1).b(), false, "", "em_yes_closed_team_win_cancel", (Map)localObject2);
            }
          }
        }
        ((CommonDialog)localObject1).show();
        return true;
      }
      CustomToastView.a((String)localObject1);
      return true;
    }
    return paramInt2 == -1244;
  }
  
  public static boolean a(Context paramContext, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchRoomMainPage - ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramYoloRoomInfo);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramYoloRoomInfo.room_id.get());
    Logger.a("YoloRoomUtil", localStringBuilder.toString());
    if (paramContext == null) {
      return false;
    }
    if ((paramYoloRoomInfo != null) && (paramYoloRoomInfo.room_id.has()))
    {
      if (!paramYoloRoomInfo.room_type.has()) {
        return false;
      }
      if (paramYoloRoomInfo.room_type.get() != 1) {
        return true;
      }
      ((ITeamService)ServiceCenter.a(ITeamService.class)).a(paramContext, paramYoloRoomInfo, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    boolean bool2 = false;
    if ((paramYoloRoomInfo != null) && (paramYoloRoomInfo.room_id.has()))
    {
      if (!paramYoloRoomInfo.room_type.has()) {
        return false;
      }
      Object localObject = YoloRoomList.a().b(paramYoloRoomInfo.room_id.get());
      boolean bool1;
      if (localObject != null) {
        bool1 = ((YoloRoomManager)localObject).D();
      } else {
        bool1 = false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forceRefreshFloatBall, isShowFloatingView = ");
      if (!bool1) {
        bool2 = true;
      }
      ((StringBuilder)localObject).append(bool2);
      Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
      if (!bool1) {
        YoloRoomFloatViewUtil.a(paramYoloRoomInfo.room_id.get(), paramYoloRoomInfo.room_type.get(), paramYoloRoomInfo);
      }
      return true;
    }
    return false;
  }
  
  public static ConcurrentHashMap<String, String> b(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramYoloRoomInfo.room_type.get() == 1)
    {
      localConcurrentHashMap.put("yes_team_id", String.valueOf(paramYoloRoomInfo.room_id.get()));
      localConcurrentHashMap.put("yes_team_name", paramYoloRoomInfo.introduce.get());
      if ((paramYoloRoomInfo.game_data_info.has()) && (paramYoloRoomInfo.game_data_info.smoba_game_data_info.has()))
      {
        List localList1 = paramYoloRoomInfo.game_data_info.smoba_game_data_info.grade_list.get();
        List localList2 = paramYoloRoomInfo.game_data_info.smoba_game_data_info.need_lane_type.get();
        localConcurrentHashMap.put("yes_team_rank", a(localList1));
        localConcurrentHashMap.put("yes_team_branch", a(localList2));
        localConcurrentHashMap.put("yes_game_mode", String.valueOf(paramYoloRoomInfo.game_data_info.smoba_game_data_info.mode_name.get()));
      }
    }
    return localConcurrentHashMap;
  }
  
  public static void b()
  {
    Object localObject1 = TimiGameActivityManager.a();
    Object localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("jumpToTeamList-openExpandHall topActivity - ");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append(", curHall = ");
    ((StringBuilder)localObject3).append(localObject2);
    Logger.a("YoloRoomUtil", ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      ((IExpandHall)localObject2).f();
      return;
    }
    localObject2 = new ExpandHallLaunchParam();
    ((ExpandHallLaunchParam)localObject2).h = true;
    localObject3 = (IExpandHallService)ServiceCenter.a(IExpandHallService.class);
    if (localObject1 == null) {
      localObject1 = Env.a();
    }
    ((IExpandHallService)localObject3).a((Context)localObject1, (ExpandHallLaunchParam)localObject2);
  }
  
  private static void b(long paramLong, int paramInt)
  {
    a(paramLong, true, paramInt, new YoloRoomUtil.2(paramLong));
  }
  
  private static void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    TimiGameBaseActivity localTimiGameBaseActivity = TimiGameActivityManager.b();
    if (localTimiGameBaseActivity != null) {
      localTimiGameBaseActivity.a();
    }
    ((NetApi)ServiceCenter.a(NetApi.class)).a(RecoverYoloRoomServlet.a(paramLong), YoloRoomOuterClass.YoloRoomRecoverRsp.class, new YoloRoomUtil.4(localTimiGameBaseActivity, paramLong, paramInt, paramBoolean));
  }
  
  private static void b(YoloRoomManager paramYoloRoomManager, RoomInterceptCheckCallback paramRoomInterceptCheckCallback)
  {
    paramYoloRoomManager.a(false, 0, new YoloRoomUtil.10(paramRoomInterceptCheckCallback), true);
  }
  
  public static ConcurrentHashMap<String, String> c(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramYoloRoomInfo != null) {
      if (paramYoloRoomInfo.room_type.get() == 1)
      {
        localConcurrentHashMap.putAll(b(paramYoloRoomInfo));
        long l = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramYoloRoomInfo.room_id.get()).p();
        if (l != 0L)
        {
          localConcurrentHashMap.put("yes_ref_room_id", String.valueOf(l));
          localConcurrentHashMap.put("yes_ref_room_type", String.valueOf(5));
        }
        paramYoloRoomInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramYoloRoomInfo.room_id.get()).q();
        if (paramYoloRoomInfo != null)
        {
          localConcurrentHashMap.put("yes_ref_qq_group_num", String.valueOf(paramYoloRoomInfo.a));
          localConcurrentHashMap.put("yes_ref_channel_num", String.valueOf(paramYoloRoomInfo.b));
          localConcurrentHashMap.put("yes_ref_channel_name", String.valueOf(paramYoloRoomInfo.c));
          return localConcurrentHashMap;
        }
      }
      else
      {
        localConcurrentHashMap.put("yes_room_type", String.valueOf(paramYoloRoomInfo.room_type.get()));
        localConcurrentHashMap.put("yes_room_id", String.valueOf(paramYoloRoomInfo.room_id.get()));
        paramYoloRoomInfo = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
        if ((paramYoloRoomInfo != null) && (paramYoloRoomInfo.e() != null)) {
          localConcurrentHashMap.putAll(paramYoloRoomInfo.e().t());
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  private static boolean d()
  {
    boolean bool = FloatingPermission.a(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasFloatWindowPermission = ");
    localStringBuilder.append(bool);
    Logger.a("YoloRoomUtil", localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil
 * JD-Core Version:    0.7.0.1
 */