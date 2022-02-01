package com.tencent.timi.game.liveroom.impl.report;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallback;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/report/TGReportUtil;", "", "()V", "TAG", "", "currentRoomId", "", "getCurrentRoomId", "()J", "setCurrentRoomId", "(J)V", "lastTimeHeartTime", "getLastTimeHeartTime", "setLastTimeHeartTime", "getAnchorPageParams", "Ljava/util/concurrent/ConcurrentHashMap;", "getAudiencePageParams", "roomId", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "getEnterRooParam", "getExitRooParam", "getHeartbeatParam", "isAnchor", "", "registerRoomReportCallback", "", "reportUrl", "context", "Landroid/content/Context;", "inputUrl", "selfUin", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGReportUtil
{
  public static final TGReportUtil a = new TGReportUtil();
  private static long b;
  private static long c;
  
  private final ConcurrentHashMap<String, String> b(long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramLiveRoomExtraInfo = a(paramLong, paramLiveRoomExtraInfo);
    Map localMap = (Map)paramLiveRoomExtraInfo;
    localMap.put("dt_pgid", "pg_qqlive_audience");
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    localMap.put("dt_qq", String.valueOf(((ILoginCoreService)localIService).a()));
    return paramLiveRoomExtraInfo;
  }
  
  private final ConcurrentHashMap<String, String> b(boolean paramBoolean, long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    if (paramBoolean)
    {
      paramLiveRoomExtraInfo = a();
      ((Map)paramLiveRoomExtraInfo).put("dt_pgid", "pg_qqlive_anchorlive");
    }
    else
    {
      paramLiveRoomExtraInfo = a(paramLong, paramLiveRoomExtraInfo);
      ((Map)paramLiveRoomExtraInfo).put("dt_pgid", "pg_qqlive_audience");
    }
    Map localMap = (Map)paramLiveRoomExtraInfo;
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    localMap.put("dt_qq", String.valueOf(((ILoginCoreService)localObject).a()));
    if (BaseGesturePWDUtil.isAppOnForeground((Context)MobileQQ.context)) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localMap.put("qq_live_appstatus", localObject);
    return paramLiveRoomExtraInfo;
  }
  
  private final ConcurrentHashMap<String, String> c(long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramLiveRoomExtraInfo = a(paramLong, paramLiveRoomExtraInfo);
    Map localMap = (Map)paramLiveRoomExtraInfo;
    localMap.put("dt_pgid", "pg_qqlive_audience");
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    localMap.put("dt_qq", String.valueOf(((ILoginCoreService)localIService).a()));
    return paramLiveRoomExtraInfo;
  }
  
  @NotNull
  public final ConcurrentHashMap<String, String> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    Object localObject2 = ((ITgLiveRoomService)localObject1).f();
    localObject1 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c(0L);
    if (localObject1 != null) {
      localObject1 = ((IQQLiveAnchorRoom)localObject1).getAnchorRoomInfo();
    } else {
      localObject1 = null;
    }
    Map localMap = (Map)localConcurrentHashMap;
    if (localObject2 != null)
    {
      localObject2 = String.valueOf(((LiveUserInfo)localObject2).uid);
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = "";
    }
    localMap.put("qqlive_user_id", localObject2);
    if (localObject1 != null)
    {
      localObject2 = ((QQLiveAnchorRoomInfo)localObject1).userDta;
      if (localObject2 != null)
      {
        localObject2 = String.valueOf(((QQLiveAnchorDataUserInfo)localObject2).id);
        if (localObject2 != null) {
          break label131;
        }
      }
    }
    localObject2 = "";
    label131:
    localMap.put("qqlive_anchor_id", localObject2);
    if (localObject1 != null)
    {
      localObject2 = ((QQLiveAnchorRoomInfo)localObject1).roomData;
      if (localObject2 != null)
      {
        localObject2 = String.valueOf(((QQLiveAnchorDataRoomInfo)localObject2).getRoomId());
        if (localObject2 != null) {
          break label173;
        }
      }
    }
    localObject2 = "";
    label173:
    localMap.put("qqlive_room_id", localObject2);
    if (localObject1 != null)
    {
      localObject2 = ((QQLiveAnchorRoomInfo)localObject1).roomData;
      if (localObject2 != null)
      {
        localObject2 = ((QQLiveAnchorDataRoomInfo)localObject2).programId;
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).toString();
          if (localObject2 != null) {
            break label221;
          }
        }
      }
    }
    localObject2 = "";
    label221:
    localMap.put("qqlive_program_id", localObject2);
    localMap.put("qqlive_zhibo_type", "0");
    if (localObject1 != null)
    {
      localObject1 = ((QQLiveAnchorRoomInfo)localObject1).roomData;
      if (localObject1 != null)
      {
        localObject1 = ((QQLiveAnchorDataRoomInfo)localObject1).gameInfo;
        if (localObject1 != null)
        {
          localObject1 = String.valueOf(((QQLiveAnchorRoomGameInfo)localObject1).id);
          if (localObject1 != null) {
            break label284;
          }
        }
      }
    }
    localObject1 = "";
    label284:
    localMap.put("qqlive_zhibo_content", localObject1);
    localMap.put("qqlive_coming_way", "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localConcurrentHashMap.get("qqlive_room_id"));
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append((String)localConcurrentHashMap.get("qqlive_program_id"));
    localMap.put("qqlive_enter_id", ((StringBuilder)localObject1).toString());
    localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    localObject1 = ((ITgLiveRoomService)localObject1).d();
    if (localObject1 != null)
    {
      localObject1 = ((IQQLiveSDK)localObject1).getAppId();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localMap.put("qqlive_start_source", localObject1);
    localMap.put("qqlive_abtoken", "");
    return localConcurrentHashMap;
  }
  
  @NotNull
  public final ConcurrentHashMap<String, String> a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject4 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f(paramLong);
    Object localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    Object localObject3 = ((ITgLiveRoomService)localObject1).f();
    Object localObject2 = null;
    if (localObject4 != null) {
      localObject1 = ((IAudienceRoom)localObject4).getRoomInfo();
    } else {
      localObject1 = null;
    }
    if (localObject4 != null) {
      localObject2 = ((IAudienceRoom)localObject4).getAnchorInfo();
    }
    localObject4 = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject4).a();
    localObject4 = (Map)localConcurrentHashMap;
    ((Map)localObject4).put("zengzhi_tracedetail", "");
    if (localObject3 != null)
    {
      localObject3 = String.valueOf(((LiveUserInfo)localObject3).uid);
      if (localObject3 != null) {}
    }
    else
    {
      localObject3 = "";
    }
    ((Map)localObject4).put("qqlive_user_id", localObject3);
    if (localObject2 != null)
    {
      localObject2 = String.valueOf(((BaseAnchorInfo)localObject2).getAnchorUid());
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = "";
    }
    ((Map)localObject4).put("qqlive_anchor_id", localObject2);
    ((Map)localObject4).put("qqlive_room_id", String.valueOf(paramLong));
    if (localObject1 != null)
    {
      localObject1 = ((BaseRoomInfo)localObject1).getProgramId();
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).toString();
        if (localObject1 != null) {
          break label266;
        }
      }
    }
    localObject1 = "";
    label266:
    ((Map)localObject4).put("qqlive_program_id", localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((Map)localObject4).put("qqlive_enter_id", ((StringBuilder)localObject1).toString());
    ((Map)localObject4).put("qqlive_zhibo_type", "0");
    if (paramLiveRoomExtraInfo != null)
    {
      localObject1 = String.valueOf(paramLiveRoomExtraInfo.b);
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((Map)localObject4).put("qqlive_zhibo_content", localObject1);
    if (paramLiveRoomExtraInfo != null)
    {
      localObject1 = paramLiveRoomExtraInfo.e;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((Map)localObject4).put("qqlive_coming_way", localObject1);
    if (paramLiveRoomExtraInfo != null)
    {
      localObject1 = String.valueOf(paramLiveRoomExtraInfo.d);
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((Map)localObject4).put("qqlive_start_source", localObject1);
    if (paramLiveRoomExtraInfo != null)
    {
      paramLiveRoomExtraInfo = paramLiveRoomExtraInfo.f;
      if (paramLiveRoomExtraInfo != null)
      {
        paramLiveRoomExtraInfo = paramLiveRoomExtraInfo.toString();
        if (paramLiveRoomExtraInfo != null) {
          break label498;
        }
      }
    }
    paramLiveRoomExtraInfo = "";
    label498:
    ((Map)localObject4).put("qqlive_abtoken", paramLiveRoomExtraInfo);
    return localConcurrentHashMap;
  }
  
  public final void a(long paramLong)
  {
    b = paramLong;
  }
  
  public final void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "inputUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "selfUin");
    try
    {
      localObject = URLEncoder.encode(paramString1, "UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "URLEncoder.encode(inputUrl, \"UTF-8\")");
      paramString1 = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      label44:
      break label44;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encode shareUrl failed, because UTF-8 is unknown - ");
    ((StringBuilder)localObject).append(paramString1);
    Logger.c("TgReportUtil", ((StringBuilder)localObject).toString());
    paramString1 = "";
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("&qq=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("&_wv=7");
    paramString1 = ((StringBuilder)localObject).toString();
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("hide_more_button", true);
    paramContext.startActivity(paramString2);
  }
  
  public final void a(boolean paramBoolean, long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    if ((paramLong != b) && (paramLong != 0L))
    {
      b = paramLong;
      ILiveRoom localILiveRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).b(0L);
      if (localILiveRoom != null)
      {
        if ((!paramBoolean) && (paramLiveRoomExtraInfo != null))
        {
          Map localMap = (Map)a.b(paramLong, paramLiveRoomExtraInfo);
          localMap.put("qqlive_entertime", String.valueOf(localILiveRoom.getEnterRoomTime()));
          ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("ev_qqlive_enterroom", localMap);
        }
        localILiveRoom.registerReportCallback((IQQLiveReportCallback)new TGReportUtil.registerRoomReportCallback..inlined.apply.lambda.1(localILiveRoom, paramBoolean, paramLiveRoomExtraInfo, paramLong));
        c = System.currentTimeMillis();
        localILiveRoom.startRoomTimer(5000L);
      }
    }
  }
  
  public final long b()
  {
    return c;
  }
  
  public final void b(long paramLong)
  {
    c = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.report.TGReportUtil
 * JD-Core Version:    0.7.0.1
 */