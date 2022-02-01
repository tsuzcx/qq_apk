package com.tencent.timi.game.room.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.initer.impl.GiftSdkInitManager;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomPage;
import com.tencent.timi.game.room.api.YoloRoomInterceptor;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomFamilyListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomForbiddenSpeechListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomSmobaListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomTgpaListener;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.room.api.wrapper.IRoomLiveVideoService;
import com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic;
import com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog;
import com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.Builder;
import com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.DoubleCheckListener;
import com.tencent.timi.game.room.impl.family.CustomFamilyActionHandler;
import com.tencent.timi.game.room.impl.network.DoYoloRoomCmdServlet;
import com.tencent.timi.game.room.impl.network.GetYoloRoomDataServlet;
import com.tencent.timi.game.room.impl.smoba.CustomSmobaActionHandler;
import com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic;
import com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil;
import com.tencent.timi.game.room.impl.util.YoloRoomIMUtil;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.scheme.tools.smoba.SmobaSchemeUtil;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.group.IGroupListener;
import com.tencent.timi.game.tim.api.group.IGroupManager;
import com.tencent.timi.game.tim.api.group.IGroupMemberInfo;
import com.tencent.timi.game.tim.api.impl.ex.LongExKt;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.timi.game.ui.utils.TimeUtils;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.SmobaDataOuterClass.YoloTeamInfo;
import trpc.yes.common.SmobaDataOuterClass.YoloTeamMemberInfo;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaSchema;
import trpc.yes.common.YoloRoomOuterClass.DoYoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.GetYoloRoomDataRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloBattleOBRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAgreeSpeakingAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomApplySpeakingAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCloseGameAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdReq;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomForbiddenSpeechAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomForbiddenSpeechConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomGameResultLikeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInvitedSpeakingAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutSpeakingAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomPushSwitch;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomReadyStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomReadyStatusChangeCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSmobaConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosChangeCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosListInitAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingUserStatusUpdateAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomStartGameAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomStartGameCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomStartGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUpdateGameRouteInfoAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomVoiceSwitchChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomVoiceSwitchChangeCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomChooceHeroAction;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomChooceHeroCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomRemindOwnerStartGameAction;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomRemindStartGameCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloUserGameData;
import trpc.yes.wuji.WujiSafeOuterClass.WujiSafeConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloSmobaRoomConf;

public class YoloRoomManager
  implements SimpleEventReceiver, IRoomDoOpService, IRoomGetDataService, IRoomListenerService
{
  private volatile long A = 0L;
  private HashMap<Long, Boolean> B = new HashMap();
  private volatile boolean C = false;
  private volatile boolean D = false;
  private HashMap<String, WeakReference<IRoomPage>> E = new HashMap();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomSmobaListener> F = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomFamilyListener> G = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomCommonListener> H = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomAudioListener> I = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomLifecycleListener> J = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomTgpaListener> K = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomMediaEnvCheckCallback> L = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomForbiddenSpeechListener> M = new CopyOnWriteArrayList();
  private HashMap<Integer, YoloRoomInterceptor> N = new HashMap();
  private List<IYoloRoomActionHandler> O = new ArrayList();
  private YoloRoomMediaLogic P;
  private RoomGameDoubleCheckDialog Q;
  private Dialog R;
  private YoloRoomChatManager S;
  private IGroupListener T = new YoloRoomManager.4(this);
  private boolean U = false;
  private boolean V = false;
  private Runnable W = new YoloRoomManager.41(this);
  private IRoomAudioService X = new YoloRoomManager.49(this);
  private IRoomLiveVideoService Y = new YoloRoomManager.50(this);
  private YoloRoomInterface.YoloRoomAudioListener Z = new YoloRoomManager.51(this);
  private YoloRoomOuterClass.YoloRoomInfo a;
  private YoloRoomInterface.YoloRoomCommonListener aa = new YoloRoomManager.52(this);
  private YoloRoomInterface.YoloRoomSmobaListener ab = new YoloRoomManager.53(this);
  private YoloRoomInterface.YoloRoomLifecycleListener ac = new YoloRoomManager.54(this);
  private YoloRoomInterface.YoloRoomFamilyListener ad = new YoloRoomManager.55(this);
  private YoloRoomInterface.YoloRoomTgpaListener ae = new YoloRoomManager.56(this);
  private YoloRoomInterface.YoloRoomMediaEnvCheckCallback af = new YoloRoomManager.57(this);
  private YoloRoomOuterClass.YoloRoomUserData b;
  private MutableLiveData<YoloRoomOuterClass.YoloRoomInfo> c = new YoloRoomManager.1(this);
  private long d;
  private long e;
  private long f;
  private int g;
  private int h;
  private List<Long> i = new CopyOnWriteArrayList();
  private List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> j = new ArrayList();
  private int k = -1;
  private YoloRoomOuterClass.YoloRoomConf l;
  private long m;
  private int n = 0;
  private YoloRoomOuterClass.YoloGameRouteInfo o;
  private YoloBattleSmobaOuterClass.YoloSmobaOneSchema p;
  private boolean q;
  private int r = -1;
  private long s = 0L;
  private long t = 0L;
  private int u = 15000;
  private long v = 0L;
  private volatile boolean w = false;
  private volatile boolean x = true;
  private volatile boolean y = false;
  private volatile boolean z = false;
  
  public YoloRoomManager(long paramLong)
  {
    this.d = paramLong;
    this.O.add(new CustomSmobaActionHandler(this, this.ab));
    this.O.add(new CustomFamilyActionHandler(this, this.ad));
    this.S = new YoloRoomChatManager();
    this.S.a(new YoloRoomManager.2(this));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private boolean G()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomInfo)localObject).game_route_info.has()) && (this.a.game_route_info.smoba_game_route_info.has()) && (this.a.game_route_info.smoba_game_route_info.team_info.has()) && (this.a.game_data_info.has()) && (this.a.game_data_info.smoba_game_data_info.has()))
    {
      int i1 = this.a.game_data_info.smoba_game_data_info.game_mode.get();
      localObject = this.a.game_route_info.smoba_game_route_info.team_info;
      if (i1 == 1)
      {
        if ((localObject != null) && (((SmobaDataOuterClass.YoloTeamInfo)localObject).maxteammembernum.get() != 3)) {
          return true;
        }
      }
      else if ((i1 == 2) && (localObject != null) && (((SmobaDataOuterClass.YoloTeamInfo)localObject).maxteammembernum.get() != 5)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean H()
  {
    if (a() == 5) {
      return I();
    }
    if (a() == 1)
    {
      WujiYoloRoomOuterClass.WujiYoloSmobaRoomConf localWujiYoloSmobaRoomConf = c().yolo_room_smoba_conf.yolo_smoba_room_conf;
      return (localWujiYoloSmobaRoomConf != null) && (localWujiYoloSmobaRoomConf.is_use_voice.get());
    }
    return true;
  }
  
  private boolean I()
  {
    YoloRoomOuterClass.YoloRoomConf localYoloRoomConf = c();
    if (localYoloRoomConf == null) {
      return true;
    }
    return localYoloRoomConf.yolo_room_community_conf.wuji_yolo_room_community_conf.speaking_list_switch.get();
  }
  
  private void J()
  {
    try
    {
      if (this.P == null)
      {
        boolean bool = a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
        this.P = new YoloRoomMediaLogic(this.g, this.d);
        this.P.a(bool, this.Z);
        if (bool) {
          this.P.a(true);
        }
      }
      return;
    }
    finally {}
  }
  
  private void K()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenNetErrorNotInRoom, mRoomId = ");
    localStringBuilder.append(this.d);
    Logger.c("YoloRoomManager", localStringBuilder.toString());
    if (this.d != 0L) {
      b(true, 0, null, false);
    }
    L();
  }
  
  private void L()
  {
    Logger.c("YoloRoomManager", "onExitRoom");
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).d().b(this.T);
    N();
    O();
  }
  
  private void M()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEnterNewRoom - ");
    localStringBuilder.append(u());
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    this.ac.a(u(), a());
    if (a() == 1) {
      GiftSdkInitManager.a.a(10003);
    }
    YoloRoomList.a().a(u(), a());
  }
  
  private void N()
  {
    long l1 = u();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyExitRoom - ");
    localStringBuilder.append(l1);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (l1 != 0L)
    {
      if (a() == 1) {
        GiftSdkInitManager.a.b(10003);
      }
      this.ac.b(l1, a());
      YoloRoomList.a().b(l1, a());
      YoloRoomList.a().a(l1);
      YoloRoomFloatViewUtil.b(l1, a());
    }
  }
  
  private void O()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resetAll, mRoomId= ");
    ((StringBuilder)localObject).append(u());
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    this.a = null;
    this.b = null;
    this.c.setValue(this.a);
    this.d = 0L;
    c(false);
    this.x = true;
    this.w = false;
    this.u = 15000;
    this.v = 0L;
    this.m = 0L;
    this.s = 0L;
    this.t = 0L;
    this.k = -1;
    this.p = null;
    this.q = false;
    localObject = this.P;
    if (localObject != null)
    {
      ((YoloRoomMediaLogic)localObject).a();
      this.P.b();
      this.P = null;
    }
  }
  
  private void P()
  {
    YoloRoomOuterClass.YoloRoomDoubleCheckPlayer localYoloRoomDoubleCheckPlayer = c(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlePlayerDoubleCheck - selfDoubleCheckPlayer = ");
    localStringBuilder.append(localYoloRoomDoubleCheckPlayer);
    localStringBuilder.append(" - ");
    Object localObject = this.Q;
    if (localObject != null) {
      localObject = Boolean.valueOf(((RoomGameDoubleCheckDialog)localObject).isShowing());
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (localYoloRoomDoubleCheckPlayer != null)
    {
      localObject = this.Q;
      if ((localObject != null) && (((RoomGameDoubleCheckDialog)localObject).isShowing()))
      {
        this.Q.a(x(), 0L);
        return;
      }
      C();
    }
  }
  
  private void Q()
  {
    try
    {
      ThreadPool.b(this.W);
      return;
    }
    catch (Exception localException)
    {
      Logger.a("YoloRoomManager", "loop removeCallback error", localException);
    }
  }
  
  private void R()
  {
    b(true);
  }
  
  private void S()
  {
    long l1 = this.d;
    boolean bool = this.w;
    int i1 = 1;
    if (bool)
    {
      Logger.b("YoloRoomManager", "requestingRoomData = true,waiting for request finish");
      this.y = true;
      return;
    }
    this.w = true;
    bool = this.C;
    this.C = false;
    if (a() != 1) {
      bool = true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestRoomData - ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", clientMaxId = ");
    ((StringBuilder)localObject).append(this.s);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    localObject = (NetApi)ServiceCenter.a(NetApi.class);
    long l2 = this.d;
    long l3 = this.s;
    if (!bool) {
      i1 = 0;
    }
    ((NetApi)localObject).a(GetYoloRoomDataServlet.a(l2, l3, i1), YoloRoomOuterClass.GetYoloRoomDataRsp.class, new YoloRoomManager.42(this, l1));
  }
  
  private void T()
  {
    if (a() == 1)
    {
      Object localObject1 = this.p;
      int i1 = 0;
      Object localObject2;
      if (localObject1 != null)
      {
        long l1 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
        localObject1 = this.o;
        Object localObject3 = null;
        if ((localObject1 != null) && (((YoloRoomOuterClass.YoloGameRouteInfo)localObject1).smoba_game_route_info.has())) {
          localObject2 = this.o.smoba_game_route_info.team_info;
        } else {
          localObject2 = null;
        }
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject1 = localObject3;
          if (((SmobaDataOuterClass.YoloTeamInfo)localObject2).memberlist.get().size() > 0)
          {
            localObject2 = ((SmobaDataOuterClass.YoloTeamInfo)localObject2).memberlist.get().iterator();
            do
            {
              localObject1 = localObject3;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (SmobaDataOuterClass.YoloTeamMemberInfo)((Iterator)localObject2).next();
            } while (((SmobaDataOuterClass.YoloTeamMemberInfo)localObject1).uid.get() != l1);
          }
        }
        if (localObject1 != null) {
          i1 = 1;
        }
      }
      if (i1 == 0)
      {
        localObject1 = TimiGameActivityManager.a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notifyGameStarted isPlayerInSmobaTeam is false! ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" - ");
        ((StringBuilder)localObject2).append(this.R);
        Logger.c("YoloRoomManager", ((StringBuilder)localObject2).toString());
        localObject2 = this.R;
        if ((localObject2 != null) && (((Dialog)localObject2).isShowing())) {
          return;
        }
        if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
        {
          this.R = new CommonDialog.Builder((Context)localObject1).a("队伍已开始游戏了").c("换个房间，寻找新的队友开黑吧！").e("取消").b(new YoloRoomManager.47(this)).d("换个房间").a(new YoloRoomManager.46(this)).a();
          this.R.show();
          return;
        }
        CustomToastView.a("队伍已开始游戏了\n换个房间，寻找新的队友开黑吧！");
      }
    }
  }
  
  private long U()
  {
    long l1 = this.A + 1L;
    this.B.put(Long.valueOf(l1), Boolean.valueOf(true));
    this.A = l1;
    return l1;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateRequestRoomDataGap - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("s");
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (paramInt > 0) {
      this.u = (paramInt * 1000);
    }
  }
  
  private void a(int paramInt1, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt2)
  {
    a(paramYoloRoomSpeakingPosInfo, paramInt2);
    this.aa.a(paramInt1, paramYoloRoomSpeakingPosInfo, this.j);
  }
  
  private void a(long paramLong, int paramInt1, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUserKickedOutRoom - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramInt1);
    Logger.c("YoloRoomManager", ((StringBuilder)localObject).toString());
    if (paramYoloRoomSpeakingPosInfo != null) {
      a(paramYoloRoomSpeakingPosInfo, paramInt2);
    }
    this.aa.b(paramLong, paramYoloRoomSpeakingPosInfo, this.j);
    if ((paramLong == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()) && (v()))
    {
      localObject = "你被踢出房间";
      paramYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject;
      if (paramInt1 != 0) {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3) {
              paramYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject;
            } else {
              paramYoloRoomSpeakingPosInfo = "长时间没有活动，你已被踢出房间";
            }
          }
          else {
            paramYoloRoomSpeakingPosInfo = "长时间没有准备，你已被踢出房间";
          }
        }
        else {
          paramYoloRoomSpeakingPosInfo = "由于没有确认，你已被踢出房间";
        }
      }
      CustomToastView.a(paramYoloRoomSpeakingPosInfo);
      Logger.c("YoloRoomManager", "onUserKickedOutRoom self kicked out!");
      L();
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    this.aa.a(paramLong1, paramLong2);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.aa.a(paramLong1, paramLong2, paramLong3);
  }
  
  private void a(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt)
  {
    a(paramYoloRoomSpeakingPosInfo, paramInt);
    this.aa.a(paramLong, paramYoloRoomSpeakingPosInfo, this.j);
  }
  
  private void a(String paramString, int paramInt, YoloRoomOuterClass.YoloBattleOBStatusChangeAction paramYoloBattleOBStatusChangeAction)
  {
    if (paramInt != this.r)
    {
      this.r = paramInt;
      Object localObject2 = paramYoloBattleOBStatusChangeAction.ob_url.get();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.o.battle_ob_route_info.battle_ob_url.get();
      }
      localObject2 = this.o.battle_ob_route_info;
      ((YoloRoomOuterClass.YoloBattleOBRouteInfo)localObject2).battle_ob_url.set((String)localObject1);
      ((YoloRoomOuterClass.YoloBattleOBRouteInfo)localObject2).battle_ob_status.set(this.r);
      localObject1 = new YoloRoomOuterClass.YoloGameRouteInfo();
      ((YoloRoomOuterClass.YoloGameRouteInfo)localObject1).set(this.o);
      ((YoloRoomOuterClass.YoloGameRouteInfo)localObject1).battle_ob_route_info.set((MessageMicro)localObject2);
      this.o = ((YoloRoomOuterClass.YoloGameRouteInfo)localObject1);
    }
    this.aa.a(paramString, paramInt, paramYoloBattleOBStatusChangeAction);
  }
  
  private void a(String paramString, YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction)
  {
    int i1 = paramYoloRoomAction.action_type.get();
    long l1 = paramYoloRoomAction.client_seq_id.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleRoomActionFromImMsg ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(", msgId = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", clientTid = ");
    ((StringBuilder)localObject).append(l1);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    paramString = new ArrayList();
    if ((i1 != 16) && (i1 != 17)) {
      if (i1 != 29)
      {
        if (i1 != 203)
        {
          switch (i1)
          {
          default: 
            switch (i1)
            {
            default: 
              paramYoloRoomAction = new StringBuilder();
              paramYoloRoomAction.append("handleRoomActionFromImMsg not handled! - ");
              paramYoloRoomAction.append(i1);
              Logger.a("YoloRoomManager", paramYoloRoomAction.toString());
              break;
            case 102: 
              f(paramYoloRoomAction.yolo_room_leave_action.user_id.uid.get());
              break;
            case 101: 
              paramYoloRoomAction = paramYoloRoomAction.yolo_room_enter_action;
              if ((paramYoloRoomAction.user_id.uid.get() != 0L) && (!paramString.contains(Long.valueOf(paramYoloRoomAction.user_id.uid.get())))) {
                paramString.add(Long.valueOf(paramYoloRoomAction.user_id.uid.get()));
              }
              e(paramYoloRoomAction.user_id.uid.get());
            }
            break;
          case 26: 
            paramYoloRoomAction = paramYoloRoomAction.yolo_room_agree_speaking_action;
            a(paramYoloRoomAction.user_id.uid.get(), paramYoloRoomAction.expire_time.get());
            break;
          case 25: 
            g(paramYoloRoomAction.yolo_room_apply_speaking_action.user_id.uid.get());
            break;
          case 24: 
            paramYoloRoomAction = paramYoloRoomAction.yolo_room_invited_speaking_action;
            a(paramYoloRoomAction.invite_user_id.uid.get(), paramYoloRoomAction.invited_user_id.uid.get(), paramYoloRoomAction.expire_time.get());
            break;
          }
        }
        else
        {
          paramYoloRoomAction = paramYoloRoomAction.yolo_smoba_room_remind_owner_start_game_action;
          if (((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a() == paramYoloRoomAction.owner_user_id.uid.get())
          {
            Logger.a("YoloRoomManager", "YOLO_ACTION_TYPE_SMOBA_REMIND_OWNER_START_GAME");
            CustomToastView.a("你的队员等不及喊你发车啦，快回去看看吧");
            this.aa.a(true);
          }
        }
      }
      else
      {
        paramYoloRoomAction = paramYoloRoomAction.yolo_room_forbidden_speech_action;
        if ((paramYoloRoomAction != null) && (paramYoloRoomAction.user_id.uid.get() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()))
        {
          localObject = this.M.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((YoloRoomInterface.YoloRoomForbiddenSpeechListener)((Iterator)localObject).next()).a(paramYoloRoomAction.end_time.get());
          }
        }
      }
    }
    if (paramString.size() > 0) {
      b(paramString);
    }
  }
  
  private void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) || (a(paramInt, "onSpeakingPosListChanged")))
    {
      this.j.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.j.addAll(paramList);
      }
      this.k = paramInt;
      paramList = new StringBuilder();
      paramList.append("onSpeakingPosListChanged, posListVersion = ");
      paramList.append(paramInt);
      paramList.append(", isForceUpdateList = ");
      paramList.append(paramBoolean);
      Logger.a("YoloRoomManager", paramList.toString());
      this.aa.a(this.j);
    }
  }
  
  private void a(List<YoloRoomOuterClass.YoloRoomModifyInfoActionContent> paramList, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    if (b().room_id.get() == paramYoloRoomInfo.room_id.get()) {
      a(paramYoloRoomInfo);
    }
    this.aa.b(paramList);
  }
  
  private void a(YoloBattleSmobaOuterClass.YoloSmobaOneSchema paramYoloSmobaOneSchema, boolean paramBoolean)
  {
    if (paramYoloSmobaOneSchema != null)
    {
      boolean bool;
      if (f() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()) {
        bool = true;
      } else {
        bool = false;
      }
      if ((!paramBoolean) && (!bool))
      {
        localObject = this.Q;
        if ((localObject == null) || (!((RoomGameDoubleCheckDialog)localObject).isShowing())) {
          C();
        }
        paramYoloSmobaOneSchema = new YoloRoomManager.45(this, paramYoloSmobaOneSchema);
        localObject = this.Q;
        if (localObject != null)
        {
          ((RoomGameDoubleCheckDialog)localObject).a(paramYoloSmobaOneSchema);
          return;
        }
        Logger.a("YoloRoomManager", "notifyLaunchGame# mDoubleCheckDialog is null");
        paramYoloSmobaOneSchema.a();
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyLaunchGame# direct launch game, isSelfOwner = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", isJoinGame = ");
      ((StringBuilder)localObject).append(paramBoolean);
      Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
      localObject = this.Q;
      if ((localObject != null) && (((RoomGameDoubleCheckDialog)localObject).isShowing()))
      {
        this.Q.dismiss();
        this.Q = null;
      }
      YoloRoomUtil.a(u(), A());
      b("direct launch game");
      SmobaSchemeUtil.a(paramYoloSmobaOneSchema.schema.get());
    }
  }
  
  private void a(YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction)
  {
    int i1 = paramYoloRoomAction.action_type.get();
    ArrayList localArrayList = new ArrayList();
    if (i1 != 28)
    {
      paramYoloRoomAction = new StringBuilder();
      paramYoloRoomAction.append("handleRoomActionFromImGroupNotifyMsg not handled! - ");
      paramYoloRoomAction.append(i1);
      Logger.a("YoloRoomManager", paramYoloRoomAction.toString());
    }
    else if ((paramYoloRoomAction.yolo_room_game_result_like_action.to_user_id.uid.get() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()) && (a() == 1))
    {
      localArrayList.add(Long.valueOf(paramYoloRoomAction.yolo_room_game_result_like_action.from_user_id.uid.get()));
    }
    if (localArrayList.size() > 0) {
      b(localArrayList);
    }
  }
  
  private void a(YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction, List<Long> paramList)
  {
    int i3 = paramYoloRoomAction.action_type.get();
    long l1 = paramYoloRoomAction.client_seq_id.get();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleRoomAction ");
    ((StringBuilder)localObject1).append(i3);
    ((StringBuilder)localObject1).append(", actionId = ");
    ((StringBuilder)localObject1).append(paramYoloRoomAction.action_id.get());
    ((StringBuilder)localObject1).append(", actionTime = ");
    ((StringBuilder)localObject1).append(paramYoloRoomAction.action_time.get());
    ((StringBuilder)localObject1).append(", clientTid = ");
    ((StringBuilder)localObject1).append(l1);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject1).toString());
    if (i3 != 27)
    {
      Object localObject2;
      if (i3 != 105)
      {
        if (i3 != 201)
        {
          if (i3 != 251)
          {
            int i2 = 0;
            int i1;
            if (i3 != 280)
            {
              if (i3 != 107)
              {
                if (i3 != 108)
                {
                  switch (i3)
                  {
                  default: 
                    switch (i3)
                    {
                    default: 
                      paramList = this.O.iterator();
                      do
                      {
                        i1 = i2;
                        if (!paramList.hasNext()) {
                          break;
                        }
                      } while (!((IYoloRoomActionHandler)paramList.next()).a(i3, paramYoloRoomAction));
                      i1 = 1;
                      if (i1 != 0) {
                        break;
                      }
                      paramList = new StringBuilder();
                      paramList.append("handleRoomAction not handled! - ");
                      paramList.append(i3);
                      paramList.append(" - ");
                      paramList.append(paramYoloRoomAction);
                      Logger.a("YoloRoomManager", paramList.toString());
                      return;
                    case 22: 
                      a(paramYoloRoomAction, paramYoloRoomAction.yolo_room_double_check_action.room_info, i3);
                      P();
                      return;
                    case 21: 
                      a(paramYoloRoomAction, paramYoloRoomAction.yolo_room_join_game_action.room_info, i3);
                      return;
                    case 20: 
                      a(paramYoloRoomAction, paramYoloRoomAction.yolo_room_start_game_action.room_info, i3);
                      a(this.p, false);
                      return;
                    case 19: 
                      paramList = paramYoloRoomAction.yolo_room_kick_out_room_action;
                      if ((!paramList.room_speaking_pos.has()) || (a(paramList.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_KICK_OUT_ROOM"))) {
                        a(paramList.user_id.uid.get(), (int)paramList.reason.get(), paramList.room_speaking_pos, paramList.speaking_pos_list_version.get());
                      }
                      if (this.a == null) {
                        break;
                      }
                      YoloRoomIMUtil.a.a(paramYoloRoomAction, this.a.tim_group_id.get());
                      return;
                    case 18: 
                      paramYoloRoomAction = paramYoloRoomAction.yolo_room_kick_out_speaking_action;
                      if (!a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_KICK_OUT_SPEAKING")) {
                        break;
                      }
                      a(paramYoloRoomAction.user_id.uid.get(), paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
                      return;
                    }
                    break;
                  case 15: 
                    paramYoloRoomAction = paramYoloRoomAction.yolo_room_speaking_pos_status_change_action;
                    if (!a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SPEAKING_POS_STATUS_CHANGE")) {
                      break;
                    }
                    c(paramYoloRoomAction.op.get(), paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
                    return;
                  case 14: 
                    paramYoloRoomAction = paramYoloRoomAction.yolo_room_modify_info_action;
                    a(paramYoloRoomAction.action_content_list.get(), paramYoloRoomAction.room_info);
                    if ((!paramYoloRoomAction.room_speaking_pos_list.has()) || (paramYoloRoomAction.room_speaking_pos_list.size() <= 0)) {
                      break;
                    }
                    Logger.a("YoloRoomManager", "onModifyRoomInfo update speakingPosList");
                    a(paramYoloRoomAction.room_speaking_pos_list.get(), paramYoloRoomAction.speaking_pos_list_version.get(), false);
                    return;
                  case 13: 
                    paramYoloRoomAction = paramYoloRoomAction.yolo_room_voice_switch_change_action;
                    if (!a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_VOICE_SWITCH_CHANGE")) {
                      break;
                    }
                    d(paramYoloRoomAction.op.get(), paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
                    return;
                  case 12: 
                    paramYoloRoomAction = paramYoloRoomAction.yolo_room_ready_status_change_action;
                    if (!a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_READY_STATUS_CHANGE")) {
                      break;
                    }
                    b(paramYoloRoomAction.op.get(), paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
                    return;
                  case 11: 
                    paramYoloRoomAction = paramYoloRoomAction.yolo_room_speaking_pos_change_action;
                    if (!a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SPEAKING_POS_CHANGE")) {
                      break;
                    }
                    a(paramYoloRoomAction.op.get(), paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
                    return;
                  }
                }
                else
                {
                  a(paramYoloRoomAction, paramYoloRoomAction.yolo_room_update_game_route_info_action.room_info, i3);
                  if ((this.n == 0) && (!TextUtils.isEmpty(paramYoloRoomAction.yolo_room_update_game_route_info_action.status_change_text.get()))) {
                    YoloRoomIMUtil.a.a(paramYoloRoomAction, this.a.tim_group_id.get());
                  }
                }
              }
              else {
                a(paramYoloRoomAction, paramYoloRoomAction.yolo_room_close_game_action.room_info, i3);
              }
            }
            else
            {
              paramYoloRoomAction = paramYoloRoomAction.yolo_battle_ob_status_change_action;
              i2 = paramYoloRoomAction.status.get();
              i1 = i2;
              if (i2 <= 0)
              {
                paramList = new StringBuilder();
                paramList.append("YOLO_ACTION_TYPE_BATTLE_OB_STATUS_CHANGE get exception obStatus ");
                paramList.append(paramYoloRoomAction.status);
                Logger.a("YoloRoomManager", paramList.toString());
                i1 = 0;
              }
              a("", i1, paramYoloRoomAction);
            }
          }
          else
          {
            paramYoloRoomAction = paramYoloRoomAction.yolo_smoba_room_owner_change_action;
            paramList = new StringBuilder();
            paramList.append("SmobaRoomOwnerChange, reason = ");
            paramList.append(paramYoloRoomAction.reason.get());
            paramList.append(", toUserId = ");
            paramList.append(paramYoloRoomAction.to_user_id.uid.get());
            Logger.c("YoloRoomManager", paramList.toString());
            if (f() != paramYoloRoomAction.to_user_id.uid.get())
            {
              if (((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a() == f()) {
                Logger.c("YoloRoomManager", "SmobaRoomOwnerChange self is not owner any more!");
              }
              paramList = new YoloRoomOuterClass.YoloRoomInfo();
              paramList.set(b());
              paramList.owner_uid.set(paramYoloRoomAction.to_user_id.uid.get());
              a(paramList);
            }
            paramList = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
            a(paramYoloRoomAction.room_speaking_pos_list.get(), paramYoloRoomAction.speaking_pos_list_version.get(), true);
            localObject1 = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
            if ((paramList != null) && (localObject1 != null))
            {
              if (paramList.voice_switch.get() != ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).voice_switch.get())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("YOLO_ACTION_TYPE_SMOBA_OWNER_CHANGE - self VoiceSwitch changed! old=");
                ((StringBuilder)localObject2).append(paramList.voice_switch.get());
                ((StringBuilder)localObject2).append(", new=");
                ((StringBuilder)localObject2).append(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).voice_switch.get());
                Logger.c("YoloRoomManager", ((StringBuilder)localObject2).toString());
                d(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).voice_switch.get(), (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1, paramYoloRoomAction.speaking_pos_list_version.get());
              }
            }
            else if ((paramList != null) && (localObject1 == null) && (paramYoloRoomAction.reason.get() == 2))
            {
              paramList = new StringBuilder();
              paramList.append("SmobaRoomOwnerChange self kicked! - ");
              paramList.append(paramYoloRoomAction.reason.get());
              Logger.c("YoloRoomManager", paramList.toString());
              a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), 3, null, this.k);
            }
            ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(paramYoloRoomAction.to_user_id.uid.get(), new YoloRoomManager.43(this, paramYoloRoomAction));
            this.aa.c(paramYoloRoomAction.to_user_id.uid.get());
          }
        }
        else
        {
          paramYoloRoomAction = paramYoloRoomAction.yolo_smoba_room_chooce_hero_action;
          if (a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SMOBA_CHOOCE_HERO")) {
            b(paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
          }
        }
      }
      else
      {
        localObject1 = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
        paramYoloRoomAction = paramYoloRoomAction.yolo_room_speaking_pos_list_init_action;
        a(paramYoloRoomAction.room_speaking_pos_list.get(), paramYoloRoomAction.speaking_pos_list_version.get(), true);
        localObject2 = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
        if ((localObject1 != null) && (localObject2 != null) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).voice_switch.get() != ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2).voice_switch.get()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("YOLO_ACTION_TYPE_SPEAKING_POS_LIST_INIT - self VoiceSwitch changed! old=");
          localStringBuilder.append(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).voice_switch.get());
          localStringBuilder.append(", new=");
          localStringBuilder.append(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2).voice_switch.get());
          Logger.c("YoloRoomManager", localStringBuilder.toString());
          d(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2).voice_switch.get(), (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2, paramYoloRoomAction.speaking_pos_list_version.get());
        }
        paramYoloRoomAction = paramYoloRoomAction.room_speaking_pos_list.get().iterator();
        while (paramYoloRoomAction.hasNext())
        {
          localObject1 = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramYoloRoomAction.next();
          if ((((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).uid.get() != 0L) && (!paramList.contains(Long.valueOf(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).uid.get())))) {
            paramList.add(Long.valueOf(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject1).uid.get()));
          }
        }
      }
    }
    else
    {
      paramYoloRoomAction = paramYoloRoomAction.yolo_room_speaking_user_status_update_action;
      if (a(paramYoloRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SPEAKING_USER_STATUS_UPDATE")) {
        b(paramYoloRoomAction.room_speaking_pos, paramYoloRoomAction.speaking_pos_list_version.get());
      }
    }
  }
  
  private void a(YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, int paramInt)
  {
    int i1 = this.n;
    a(paramYoloRoomInfo);
    boolean bool;
    if (this.n != i1) {
      bool = true;
    } else {
      bool = false;
    }
    paramYoloRoomAction = new StringBuilder();
    paramYoloRoomAction.append("onYoloRoomInfoUpdate ");
    paramYoloRoomAction.append(paramInt);
    paramYoloRoomAction.append(", roomGameStatus = ");
    paramYoloRoomAction.append(this.n);
    paramYoloRoomAction.append(", isGameStatusChanged = ");
    paramYoloRoomAction.append(bool);
    Logger.a("YoloRoomManager", paramYoloRoomAction.toString());
    this.aa.a(bool, this.n, this.a.game_route_info);
    if ((bool) && (this.n == 3)) {
      T();
    }
  }
  
  private void a(YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localIterator.next();
      if (localYoloRoomSpeakingPosInfo.pos.get() == paramYoloRoomSpeakingPosInfo.pos.get()) {
        localArrayList.add(paramYoloRoomSpeakingPosInfo);
      } else {
        localArrayList.add(localYoloRoomSpeakingPosInfo);
      }
    }
    a(localArrayList, paramInt, false);
  }
  
  private void a(YoloRoomOuterClass.YoloRoomUserData paramYoloRoomUserData)
  {
    Logger.a("YoloRoomManager", "updateRoomUserData");
    this.b = paramYoloRoomUserData;
  }
  
  private void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenNetErrorNeedAutoExitRoom ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.c("YoloRoomManager", localStringBuilder.toString());
    c(false);
    b(true, 0, null, true);
  }
  
  private void b(int paramInt1, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt2)
  {
    a(paramYoloRoomSpeakingPosInfo, paramInt2);
    this.aa.b(paramInt1, paramYoloRoomSpeakingPosInfo, this.j);
  }
  
  private void b(long paramLong, @NotNull List<? extends IGroupMemberInfo> paramList)
  {
    if ((v()) && (paramLong == b().tim_group_id.get()) && (paramList.size() > 0))
    {
      if (this.V)
      {
        Logger.c("YoloRoomManager", "handleSelfKickedFromIm but mManualClickLeaveRoom");
        return;
      }
      String str1 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).b();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IGroupMemberInfo localIGroupMemberInfo = (IGroupMemberInfo)paramList.next();
        if (str1.equals(localIGroupMemberInfo.a()))
        {
          Logger.c("YoloRoomManager", "handleSelfKickedFromIm self kicked out!");
          str1 = LongExKt.a(paramLong);
          String str2 = localIGroupMemberInfo.a();
          if (a() == 1) {
            paramList = "你已被移出车队";
          } else {
            paramList = "你已被移出房间";
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localIGroupMemberInfo.a());
          ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).d().a(str1, localArrayList, new YoloRoomManager.5(this, str2, paramList));
        }
      }
    }
  }
  
  public static void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenLaunchSmoba - ");
    localStringBuilder.append(paramString);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    YoloRoomTGPALogic.a(paramString);
  }
  
  private static void b(List<Long> paramList)
  {
    if (paramList != null) {
      paramList.size();
    }
  }
  
  private void b(YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt)
  {
    a(paramYoloRoomSpeakingPosInfo, paramInt);
    this.aa.a(paramYoloRoomSpeakingPosInfo, this.j);
  }
  
  private void b(boolean paramBoolean1, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp> paramIResultListener, boolean paramBoolean2)
  {
    boolean bool2 = this.z;
    c(false);
    int i1 = a();
    this.V = true;
    boolean bool1;
    if (i1 == 5) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leaveRoomInner, isForceExit= ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", mRoomId= ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", leaveFrom= ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", roomType= ");
    localStringBuilder.append(i1);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    YoloRoomUtil.a(this.d, paramBoolean1, i1, new YoloRoomManager.8(this, bool1, paramIResultListener, paramBoolean2, bool2));
    if (bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("leaveRoomInner, CallbackSuccessImmediately roomType= ");
      localStringBuilder.append(i1);
      Logger.a("YoloRoomManager", localStringBuilder.toString());
      L();
      if (paramIResultListener != null) {
        paramIResultListener.a(null);
      }
    }
  }
  
  private void c(int paramInt1, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt2)
  {
    a(paramYoloRoomSpeakingPosInfo, paramInt2);
    this.aa.c(paramInt1, paramYoloRoomSpeakingPosInfo, this.j);
  }
  
  private void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoopingRequestRoomData curValue = ");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", newValue = ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    this.z = paramBoolean;
  }
  
  private void d(int paramInt1, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVoiceSwitchChanged - ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", uid= ");
    ((StringBuilder)localObject).append(paramYoloRoomSpeakingPosInfo.uid.get());
    ((StringBuilder)localObject).append(", listVersion= ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    localObject = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    a(paramYoloRoomSpeakingPosInfo, paramInt2);
    if (paramYoloRoomSpeakingPosInfo.uid.get() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()) {
      if (paramInt1 == 3)
      {
        CustomToastView.a("已被管理员禁麦");
        Logger.a("YoloRoomManager", "onVoiceSwitchChanged mic forbidden by owner!");
        a(false);
      }
      else if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject).voice_switch.get() == 3))
      {
        CustomToastView.a("管理员已解除了你的麦位静音，可以恢复语音聊天啦");
        Logger.a("YoloRoomManager", "onVoiceSwitchChanged mic resumed by owner!");
      }
    }
    this.aa.d(paramInt1, paramYoloRoomSpeakingPosInfo, this.j);
  }
  
  private void e(long paramLong)
  {
    this.aa.a(paramLong);
  }
  
  private void f(long paramLong)
  {
    this.aa.b(paramLong);
  }
  
  private void f(IResultListener<YoloRoomMediaLogic> paramIResultListener)
  {
    if (!H())
    {
      if (paramIResultListener != null) {
        paramIResultListener.a(-999, "当前房间语音功能暂未开放");
      }
      this.af.a(false);
      return;
    }
    YoloRoomMediaLogic localYoloRoomMediaLogic = this.P;
    if (localYoloRoomMediaLogic == null)
    {
      Logger.a("YoloRoomManager", "checkMediaTrtcEnv call requestQQAudioEnv");
      this.U = true;
      TimiGameQQTrtcUtil.a(new YoloRoomManager.6(this, paramIResultListener));
      return;
    }
    this.U = false;
    if (paramIResultListener != null) {
      paramIResultListener.a(localYoloRoomMediaLogic);
    }
  }
  
  private void g(long paramLong)
  {
    this.aa.d(paramLong);
  }
  
  private boolean h(long paramLong)
  {
    return (paramLong != 0L) && (this.B.get(Long.valueOf(paramLong)) == null);
  }
  
  public boolean A()
  {
    YoloRoomMediaLogic localYoloRoomMediaLogic = this.P;
    return (localYoloRoomMediaLogic != null) && (localYoloRoomMediaLogic.d());
  }
  
  public YoloRoomMediaLogic B()
  {
    return this.P;
  }
  
  public void C()
  {
    int i1 = b().game_route_info.expire_time.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDoubleCheckDialog - ");
    Object localObject = this.Q;
    if (localObject != null) {
      localObject = Boolean.valueOf(((RoomGameDoubleCheckDialog)localObject).isShowing());
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", expireTimeSeconds = ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" ");
    long l1 = i1;
    localStringBuilder.append(TimeUtils.a(100L * l1, "HH:mm:ss:SSS"));
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    localObject = this.Q;
    if ((localObject != null) && (((RoomGameDoubleCheckDialog)localObject).isShowing())) {
      this.Q.dismiss();
    }
    this.Q = null;
    localObject = TimiGameActivityManager.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDoubleCheckDialog  topActivity = ");
      localStringBuilder.append(localObject);
      Logger.a("YoloRoomManager", localStringBuilder.toString());
      this.Q = new RoomGameDoubleCheckDialog.Builder((Context)localObject).a(u(), x(), l1 * 1000L + 800L);
      this.Q.setOnDismissListener(new YoloRoomManager.40(this));
      this.Q.show();
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDoubleCheckDialog but topActivity is invalid ");
    localStringBuilder.append(localObject);
    Logger.c("YoloRoomManager", localStringBuilder.toString());
  }
  
  public boolean D()
  {
    return this.D;
  }
  
  public void E()
  {
    Logger.a("YoloRoomManager", "notifySmobaLeaveTeamFromTGPA");
    this.ae.a();
  }
  
  public IRoomAudioService F()
  {
    return this.X;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public long a(int paramInt, YoloRoomOuterClass.YoloRoomCmdReq paramYoloRoomCmdReq, DoYoloRoomCmdResultListsner paramDoYoloRoomCmdResultListsner)
  {
    long l1 = U();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doYoloRoomCmd - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mRoomId = ");
    localStringBuilder.append(this.d);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (this.d == 0L)
    {
      paramYoloRoomCmdReq = new StringBuilder();
      paramYoloRoomCmdReq.append("doYoloRoomCmd - ");
      paramYoloRoomCmdReq.append(paramInt);
      paramYoloRoomCmdReq.append(", mRoomId invalid!!!");
      Logger.c("YoloRoomManager", paramYoloRoomCmdReq.toString());
      if (paramDoYoloRoomCmdResultListsner != null) {
        paramDoYoloRoomCmdResultListsner.a(10000, "数据异常，请稍后重试", l1, true);
      }
      return l1;
    }
    ((NetApi)ServiceCenter.a(NetApi.class)).a(DoYoloRoomCmdServlet.a(this.d, paramInt, l1, paramYoloRoomCmdReq), YoloRoomOuterClass.DoYoloRoomCmdRsp.class, new YoloRoomManager.44(this, l1, paramInt, paramDoYoloRoomCmdResultListsner));
    return l1;
  }
  
  public void a(int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "chooseHeroLane has inject");
    YoloRoomOuterClass.YoloSmobaRoomChooceHeroCmd localYoloSmobaRoomChooceHeroCmd = new YoloRoomOuterClass.YoloSmobaRoomChooceHeroCmd();
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_smoba_room_chooce_hero.set(localYoloSmobaRoomChooceHeroCmd);
    localYoloRoomCmdReq.yolo_smoba_room_chooce_hero.hero_lane_type.set(paramInt);
    a(201, localYoloRoomCmdReq, new YoloRoomManager.31(this, paramInt, paramIResultListener));
  }
  
  public void a(int paramInt1, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList, int paramInt2, long paramLong, YoloRoomOuterClass.YoloRoomConf paramYoloRoomConf, YoloRoomOuterClass.YoloRoomUserData paramYoloRoomUserData)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onJoinNewRoom - JoinRoomType.");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", roomId = ");
    ((StringBuilder)localObject).append(paramYoloRoomInfo.room_id.get());
    ((StringBuilder)localObject).append(", roomType = ");
    ((StringBuilder)localObject).append(paramYoloRoomInfo.room_type.get());
    ((StringBuilder)localObject).append(", latestActionId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", maxClientActionId = ");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append(", speakingPosListVersion = ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    if (paramInt1 == 2)
    {
      localObject = this.a;
      if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomInfo)localObject).room_id.get() == paramYoloRoomInfo.room_id.get()))
      {
        bool = true;
        break label177;
      }
    }
    boolean bool = false;
    label177:
    if (!bool)
    {
      O();
      this.m = System.currentTimeMillis();
    }
    YoloRoomIMUtil.a.a(paramYoloRoomInfo);
    a(paramYoloRoomInfo);
    a(paramYoloRoomUserData);
    this.l = paramYoloRoomConf;
    paramYoloRoomConf = this.l;
    if ((paramYoloRoomConf != null) && (paramYoloRoomConf.yolo_room_common_conf.has()))
    {
      a(this.l.yolo_room_common_conf.get_data_pull_time.get());
      YoloRoomCommonConfManager.a.a(this.l.yolo_room_common_conf.safe_conf.send_interval_times.get());
      YoloRoomCommonConfManager.a.b(this.l.yolo_room_common_conf.safe_conf.game_room_send_interval_times.get());
    }
    else
    {
      Logger.c("YoloRoomManager", "onJoinNewRoom, no commonConf - ");
    }
    paramYoloRoomConf = this.l;
    if ((paramYoloRoomConf != null) && (paramYoloRoomConf.yolo_room_community_conf.has()))
    {
      paramYoloRoomConf = new StringBuilder();
      paramYoloRoomConf.append("is_show_third_part_gift");
      paramYoloRoomConf.append(this.l.yolo_room_community_conf.wuji_yolo_room_community_conf.is_show_third_part_gift.get());
      Logger.b("YoloRoomManager", paramYoloRoomConf.toString());
    }
    if (paramLong > this.s) {
      this.s = paramLong;
    }
    int i1 = this.g;
    a(paramList, paramInt2, true);
    paramYoloRoomConf = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramYoloRoomUserData = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.next();
      if (paramYoloRoomUserData.uid.get() != 0L) {
        paramYoloRoomConf.add(Long.valueOf(paramYoloRoomUserData.uid.get()));
      }
    }
    b(paramYoloRoomConf);
    f(new YoloRoomManager.3(this));
    paramYoloRoomConf = this.a.game_route_info;
    paramList = this.a.game_data_info;
    if ((!bool) && (this.n == 1)) {
      P();
    }
    paramInt2 = this.g;
    if (paramInt2 <= 0)
    {
      paramList = new StringBuilder();
      paramList.append("mRoomType is null! - ");
      paramList.append(this.g);
      Logger.c("YoloRoomManager", paramList.toString());
    }
    else if (paramInt2 == 1)
    {
      paramYoloRoomConf = paramYoloRoomConf.smoba_game_route_info;
      paramList = paramList.smoba_game_data_info;
    }
    c(true);
    b(bool);
    if (!bool) {
      M();
    }
    paramLong = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    if ((paramYoloRoomInfo.room_type.get() == 1) && (paramInt1 == 0) && (paramYoloRoomInfo.create_uid.get() == paramLong) && (paramYoloRoomInfo.room_data_info.sub_create_from.get() != 2)) {
      YoloRoomIMUtil.a.a(paramYoloRoomInfo.tim_group_id.get());
    }
    paramYoloRoomInfo = this.l;
    if ((paramYoloRoomInfo != null) && (paramYoloRoomInfo.yolo_room_common_conf.has())) {
      a(u(), this.l.yolo_room_common_conf.forbidden_speech_conf_list.get());
    }
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).d().a(this.T);
    ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_team_join_success", YoloRoomUtil.c(b()));
  }
  
  public void a(long paramLong, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeVoiceSwitch - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    long l2 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    long l1 = paramLong;
    if (paramLong == 0L) {
      l1 = l2;
    }
    if (l1 == l2)
    {
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      a(bool);
    }
    localObject = new YoloRoomOuterClass.YoloRoomVoiceSwitchChangeCmd();
    ((YoloRoomOuterClass.YoloRoomVoiceSwitchChangeCmd)localObject).op.set(paramInt);
    ((YoloRoomOuterClass.YoloRoomVoiceSwitchChangeCmd)localObject).uid.set(l1);
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_room_voice_switch_change_cmd.set((MessageMicro)localObject);
    a(13, localYoloRoomCmdReq, new YoloRoomManager.14(this, paramIResultListener));
  }
  
  public void a(long paramLong, String paramString)
  {
    int i1;
    if ((paramLong > 0L) && (paramLong > this.v)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNewActionDataFromOnlinePush - ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", lastNewDataPushTimeStamp = ");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", AlreadyHandled = ");
    localStringBuilder.append(i1 ^ 0x1);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (i1 != 0)
    {
      this.v = paramLong;
      b(true);
    }
  }
  
  public void a(long paramLong, List<YoloRoomOuterClass.YoloRoomForbiddenSpeechConf> paramList)
  {
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext())
    {
      YoloRoomInterface.YoloRoomForbiddenSpeechListener localYoloRoomForbiddenSpeechListener = (YoloRoomInterface.YoloRoomForbiddenSpeechListener)localIterator.next();
      localYoloRoomForbiddenSpeechListener.a(paramList);
      localYoloRoomForbiddenSpeechListener.a(paramLong);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(YoloRoomInterface.YoloRoomAudioListener paramYoloRoomAudioListener)
  {
    if ((paramYoloRoomAudioListener != null) && (!this.I.contains(paramYoloRoomAudioListener))) {
      this.I.add(paramYoloRoomAudioListener);
    }
  }
  
  public void a(YoloRoomInterface.YoloRoomCommonListener paramYoloRoomCommonListener)
  {
    if ((paramYoloRoomCommonListener != null) && (!this.H.contains(paramYoloRoomCommonListener))) {
      this.H.add(paramYoloRoomCommonListener);
    }
  }
  
  public void a(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener)
  {
    if ((paramYoloRoomLifecycleListener != null) && (!this.J.contains(paramYoloRoomLifecycleListener))) {
      this.J.add(paramYoloRoomLifecycleListener);
    }
  }
  
  public void a(YoloRoomInterface.YoloRoomMediaEnvCheckCallback paramYoloRoomMediaEnvCheckCallback)
  {
    if (paramYoloRoomMediaEnvCheckCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("waitMediaEnvCallback, mIsCheckingTrtc = ");
      localStringBuilder.append(this.U);
      localStringBuilder.append(" - ");
      localStringBuilder.append(B());
      Logger.a("YoloRoomManager", localStringBuilder.toString());
      if (B() != null)
      {
        paramYoloRoomMediaEnvCheckCallback.a(true);
        return;
      }
      if (!this.U)
      {
        paramYoloRoomMediaEnvCheckCallback.a(false);
        return;
      }
      if (!this.L.contains(paramYoloRoomMediaEnvCheckCallback)) {
        this.L.add(paramYoloRoomMediaEnvCheckCallback);
      }
    }
  }
  
  public void a(IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "outSpeaking");
    YoloRoomOuterClass.YoloRoomSpeakingPosChangeCmd localYoloRoomSpeakingPosChangeCmd = new YoloRoomOuterClass.YoloRoomSpeakingPosChangeCmd();
    localYoloRoomSpeakingPosChangeCmd.op.set(2);
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_room_speaking_pos_change_cmd.set(localYoloRoomSpeakingPosChangeCmd);
    a(11, localYoloRoomCmdReq, new YoloRoomManager.11(this, paramIResultListener));
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder;
      if (paramString.contains("LogIgnore"))
      {
        if (Env.b())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("clientUpdateHeartBeat - ");
          localStringBuilder.append(paramString);
          Logger.a("YoloRoomManager", localStringBuilder.toString());
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clientUpdateHeartBeat - ");
        localStringBuilder.append(paramString);
        Logger.a("YoloRoomManager", localStringBuilder.toString());
      }
    }
    this.C = true;
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.a = paramYoloRoomInfo;
    this.c.setValue(this.a);
    this.d = this.a.room_id.get();
    this.g = this.a.room_type.get();
    this.e = this.a.create_uid.get();
    this.f = this.a.owner_uid.get();
    this.o = this.a.game_route_info;
    int i1;
    if (this.a.game_route_info.has()) {
      i1 = this.a.game_route_info.game_status.get();
    } else {
      i1 = 0;
    }
    this.n = i1;
    this.p = d(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    this.q = G();
  }
  
  public void a(YoloRoomOuterClass.YoloRoomModifyInfoCmd paramYoloRoomModifyInfoCmd, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    int i1 = i();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("modifyRoomInfo, gameStatus = ");
    ((StringBuilder)localObject).append(i1);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    localObject = new YoloRoomOuterClass.YoloRoomCmdReq();
    ((YoloRoomOuterClass.YoloRoomCmdReq)localObject).yolo_room_modify_info_cmd.set(paramYoloRoomModifyInfoCmd);
    a(14, (YoloRoomOuterClass.YoloRoomCmdReq)localObject, new YoloRoomManager.17(this, paramIResultListener));
  }
  
  public void a(YoloRoomOuterClass.YoloRoomPushSwitch paramYoloRoomPushSwitch)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateRoomPushSwitch - ");
    ((StringBuilder)localObject).append(paramYoloRoomPushSwitch);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    if (paramYoloRoomPushSwitch == null) {
      new YoloRoomOuterClass.YoloRoomPushSwitch();
    }
    paramYoloRoomPushSwitch = new YoloRoomOuterClass.YoloRoomUserData();
    localObject = this.b;
    if (localObject != null) {
      paramYoloRoomPushSwitch.set((MessageMicro)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMicEnable - ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(this.P);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      f(new YoloRoomManager.9(this, paramBoolean));
      return;
    }
    localObject = this.P;
    if (localObject != null) {
      ((YoloRoomMediaLogic)localObject).b(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "openCloseSpeakingPos");
    YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeCmd localYoloRoomSpeakingPosStatusChangeCmd = new YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeCmd();
    localYoloRoomSpeakingPosStatusChangeCmd.op.set(paramBoolean ^ true);
    localYoloRoomSpeakingPosStatusChangeCmd.pos.set(paramInt);
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_room_speaking_pos_status_change_cmd.set(localYoloRoomSpeakingPosStatusChangeCmd);
    a(15, localYoloRoomCmdReq, new YoloRoomManager.13(this, paramIResultListener, paramBoolean));
  }
  
  public void a(boolean paramBoolean1, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp> paramIResultListener, boolean paramBoolean2)
  {
    if (this.d == 0L)
    {
      if (paramIResultListener != null) {
        paramIResultListener.a(-10001, "mRoomId is 0");
      }
      return;
    }
    YoloRoomInterceptor localYoloRoomInterceptor = z();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leaveRoom - ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" - ");
    localStringBuilder.append(localYoloRoomInterceptor);
    Logger.c("YoloRoomManager", localStringBuilder.toString());
    if ((localYoloRoomInterceptor != null) && (!paramBoolean1))
    {
      localYoloRoomInterceptor.a(new YoloRoomManager.7(this, paramBoolean1, paramInt, paramIResultListener, paramBoolean2));
      return;
    }
    b(paramBoolean1, paramInt, paramIResultListener, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inSpeaking - ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramBoolean2);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    f(new YoloRoomManager.10(this, paramBoolean1, paramInt, paramBoolean2, paramIResultListener));
  }
  
  public void a(boolean paramBoolean, IRoomPage paramIRoomPage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyRoomPageShowStatus - ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramIRoomPage.getPageName());
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (paramBoolean) {
      this.E.put(paramIRoomPage.getPageName(), new WeakReference(paramIRoomPage));
    } else {
      this.E.remove(paramIRoomPage.getPageName());
    }
    boolean bool = false;
    paramBoolean = bool;
    if (this.E.size() > 0)
    {
      paramIRoomPage = this.E.entrySet().iterator();
      for (;;)
      {
        paramBoolean = bool;
        if (!paramIRoomPage.hasNext()) {
          break;
        }
        if (((WeakReference)((Map.Entry)paramIRoomPage.next()).getValue()).get() != null)
        {
          paramBoolean = true;
          break;
        }
        Logger.c("YoloRoomManager", "notifyRoomPageShowStatus check, value.get is null");
      }
    }
    this.D = paramBoolean;
    paramBoolean ^= true;
    paramIRoomPage = new StringBuilder();
    paramIRoomPage.append("notifyRoomPageShowStatus show/hide floating - ");
    paramIRoomPage.append(paramBoolean);
    Logger.a("YoloRoomManager", paramIRoomPage.toString());
    if (paramBoolean)
    {
      YoloRoomFloatViewUtil.a(u(), a(), b());
      return;
    }
    YoloRoomFloatViewUtil.a(u(), a());
  }
  
  public void a(boolean paramBoolean, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doReady - ");
    ((StringBuilder)localObject1).append(paramBoolean);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject1).toString());
    localObject1 = new YoloRoomOuterClass.YoloRoomReadyStatusChangeCmd();
    Object localObject2 = ((YoloRoomOuterClass.YoloRoomReadyStatusChangeCmd)localObject1).op;
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ((PBInt32Field)localObject2).set(i1);
    localObject2 = new YoloRoomOuterClass.YoloRoomCmdReq();
    ((YoloRoomOuterClass.YoloRoomCmdReq)localObject2).yolo_room_ready_status_change_cmd.set((MessageMicro)localObject1);
    a(12, (YoloRoomOuterClass.YoloRoomCmdReq)localObject2, new YoloRoomManager.12(this, paramIResultListener));
  }
  
  public void a(boolean paramBoolean, YoloRoomOuterClass.YoloUserGameData paramYoloUserGameData, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (paramInt <= this.k)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpeakingPosListVersion is old from action - ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", curVersion is ");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", actionVersion is ");
      localStringBuilder.append(paramInt);
      Logger.c("YoloRoomManager", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return b(paramLong) != null;
  }
  
  public YoloRoomOuterClass.YoloRoomInfo b()
  {
    return this.a;
  }
  
  public YoloRoomOuterClass.YoloRoomSpeakingPosInfo b(long paramLong)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localIterator.next();
      if (localYoloRoomSpeakingPosInfo.uid.get() == paramLong) {
        return localYoloRoomSpeakingPosInfo;
      }
    }
    return null;
  }
  
  public void b(YoloRoomInterface.YoloRoomAudioListener paramYoloRoomAudioListener)
  {
    if ((paramYoloRoomAudioListener != null) && (this.I.contains(paramYoloRoomAudioListener))) {
      this.I.remove(paramYoloRoomAudioListener);
    }
  }
  
  public void b(YoloRoomInterface.YoloRoomCommonListener paramYoloRoomCommonListener)
  {
    if ((paramYoloRoomCommonListener != null) && (this.H.contains(paramYoloRoomCommonListener))) {
      this.H.remove(paramYoloRoomCommonListener);
    }
  }
  
  public void b(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener)
  {
    if ((paramYoloRoomLifecycleListener != null) && (this.J.contains(paramYoloRoomLifecycleListener))) {
      this.J.remove(paramYoloRoomLifecycleListener);
    }
  }
  
  public void b(IResultListener<YoloRoomOuterClass.YoloRoomStartGameCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "startGame");
    YoloRoomOuterClass.YoloRoomStartGameCmd localYoloRoomStartGameCmd = new YoloRoomOuterClass.YoloRoomStartGameCmd();
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_room_start_game_cmd.set(localYoloRoomStartGameCmd);
    a(20, localYoloRoomCmdReq, new YoloRoomManager.21(this, paramIResultListener));
  }
  
  public void b(boolean paramBoolean)
  {
    Q();
    if (this.z)
    {
      int i1 = this.u;
      Runnable localRunnable = this.W;
      long l1;
      if (paramBoolean) {
        l1 = 0L;
      } else {
        l1 = i1;
      }
      ThreadPool.a(localRunnable, l1);
    }
  }
  
  public YoloRoomOuterClass.YoloRoomConf c()
  {
    return this.l;
  }
  
  public YoloRoomOuterClass.YoloRoomDoubleCheckPlayer c(long paramLong)
  {
    Object localObject = x();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        YoloRoomOuterClass.YoloRoomDoubleCheckPlayer localYoloRoomDoubleCheckPlayer = (YoloRoomOuterClass.YoloRoomDoubleCheckPlayer)((Iterator)localObject).next();
        if (localYoloRoomDoubleCheckPlayer.uid.get() == paramLong) {
          return localYoloRoomDoubleCheckPlayer;
        }
      }
    }
    return null;
  }
  
  public void c(IResultListener<YoloRoomOuterClass.YoloRoomJoinGameCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "joinGame");
    YoloRoomOuterClass.YoloRoomJoinGameCmd localYoloRoomJoinGameCmd = new YoloRoomOuterClass.YoloRoomJoinGameCmd();
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_room_join_game_cmd.set(localYoloRoomJoinGameCmd);
    a(21, localYoloRoomCmdReq, new YoloRoomManager.22(this, paramIResultListener));
  }
  
  public YoloBattleSmobaOuterClass.YoloSmobaOneSchema d(long paramLong)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((YoloRoomOuterClass.YoloRoomInfo)localObject).game_route_info.has()) && (this.a.game_route_info.smoba_game_route_info.has())) {
      localObject = this.a.game_route_info.smoba_game_route_info.smoba_schema;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((YoloBattleSmobaOuterClass.YoloSmobaSchema)localObject).schemas.size() > 0))
    {
      int i1 = 0;
      while (i1 < ((YoloBattleSmobaOuterClass.YoloSmobaSchema)localObject).schemas.size())
      {
        YoloBattleSmobaOuterClass.YoloSmobaOneSchema localYoloSmobaOneSchema = (YoloBattleSmobaOuterClass.YoloSmobaOneSchema)((YoloBattleSmobaOuterClass.YoloSmobaSchema)localObject).schemas.get(i1);
        if (localYoloSmobaOneSchema.uid.get() == paramLong) {
          return localYoloSmobaOneSchema;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public YoloRoomOuterClass.YoloRoomUserData d()
  {
    return this.b;
  }
  
  public void d(IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "remindStartGame");
    YoloRoomOuterClass.YoloSmobaRoomRemindStartGameCmd localYoloSmobaRoomRemindStartGameCmd = new YoloRoomOuterClass.YoloSmobaRoomRemindStartGameCmd();
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_smoba_room_remind_start_game_cmd.set(localYoloSmobaRoomRemindStartGameCmd);
    a(203, localYoloRoomCmdReq, new YoloRoomManager.30(this, paramIResultListener));
  }
  
  public int e()
  {
    return this.h;
  }
  
  public void e(IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener)
  {
    Logger.a("YoloRoomManager", "doubleCheck");
    YoloRoomOuterClass.YoloRoomDoubleCheckCmd localYoloRoomDoubleCheckCmd = new YoloRoomOuterClass.YoloRoomDoubleCheckCmd();
    YoloRoomOuterClass.YoloRoomCmdReq localYoloRoomCmdReq = new YoloRoomOuterClass.YoloRoomCmdReq();
    localYoloRoomCmdReq.yolo_room_double_check_cmd.set(localYoloRoomDoubleCheckCmd);
    a(22, localYoloRoomCmdReq, new YoloRoomManager.23(this, paramIResultListener));
  }
  
  public long f()
  {
    return this.f;
  }
  
  public YoloRoomOuterClass.YoloSmobaGameDataInfo g()
  {
    if (1 == this.g)
    {
      YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = this.a;
      if ((localYoloRoomInfo != null) && (localYoloRoomInfo.game_data_info.has()) && (this.a.game_data_info.smoba_game_data_info.has())) {
        return this.a.game_data_info.smoba_game_data_info;
      }
    }
    return null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AppBecomeForegroundEvent.class);
    localArrayList.add(AppBecomeBackgroundEvent.class);
    return localArrayList;
  }
  
  public List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> h()
  {
    return this.j;
  }
  
  public int i()
  {
    return this.n;
  }
  
  public YoloRoomOuterClass.YoloGameRouteInfo j()
  {
    return this.o;
  }
  
  public YoloBattleSmobaOuterClass.YoloSmobaOneSchema k()
  {
    return this.p;
  }
  
  public YoloBattleSmobaOuterClass.YoloSmobaOneSchema l()
  {
    return d(f());
  }
  
  public boolean m()
  {
    return this.q;
  }
  
  public CommonOuterClass.QQUserId n()
  {
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    if (localYoloRoomSpeakingPosInfo != null) {
      return localYoloRoomSpeakingPosInfo.user_id;
    }
    return null;
  }
  
  public boolean o()
  {
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    return (localYoloRoomSpeakingPosInfo != null) && (localYoloRoomSpeakingPosInfo.user_from.get() == 2);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AppBecomeForegroundEvent))
    {
      Logger.a("YoloRoomManager", "AppBecomeForegroundEvent called");
      a(false, null, null);
      return;
    }
    if ((paramSimpleBaseEvent instanceof AppBecomeBackgroundEvent))
    {
      Logger.a("YoloRoomManager", "AppBecomeBackgroundEvent called");
      a(true, null, null);
    }
  }
  
  public long p()
  {
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
    if ((localYoloRoomSpeakingPosInfo != null) && (localYoloRoomSpeakingPosInfo.from_room_id != null)) {
      return localYoloRoomSpeakingPosInfo.from_room_id.get();
    }
    return 0L;
  }
  
  public GuildShequnParams q()
  {
    if (o())
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = b(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a());
      return new GuildShequnParams(localYoloRoomSpeakingPosInfo.guild_id.get(), localYoloRoomSpeakingPosInfo.channel_id.get(), localYoloRoomSpeakingPosInfo.channel_name.get());
    }
    return null;
  }
  
  public ConcurrentHashMap<String, String> r()
  {
    return YoloRoomUtil.c(b());
  }
  
  public void s()
  {
    O();
    Q();
    this.O.clear();
    t();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void t()
  {
    YoloRoomChatManager localYoloRoomChatManager = this.S;
    if (localYoloRoomChatManager != null)
    {
      localYoloRoomChatManager.b();
      this.S = null;
    }
  }
  
  public long u()
  {
    return this.d;
  }
  
  public boolean v()
  {
    return this.d > 0L;
  }
  
  public String w()
  {
    int i1 = a();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return "";
            }
            return "ROOM_TYPE_COMMUNITY";
          }
          return "ROOM_TYPE_CHAT";
        }
        return "ROOM_TYPE_LIVE";
      }
      return "ROOM_TYPE_FAMILY";
    }
    return "ROOM_TYPE_SMOBA";
  }
  
  public List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> x()
  {
    YoloRoomOuterClass.YoloGameRouteInfo localYoloGameRouteInfo = b().game_route_info;
    if ((localYoloGameRouteInfo != null) && (localYoloGameRouteInfo.game_status.get() == 1)) {
      return localYoloGameRouteInfo.double_check_players.get();
    }
    return null;
  }
  
  public void y()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLogout - ");
    localStringBuilder.append(u());
    localStringBuilder.append(" - ");
    localStringBuilder.append(w());
    Logger.c("YoloRoomManager", localStringBuilder.toString());
    L();
  }
  
  public YoloRoomInterceptor z()
  {
    int i1 = a();
    return (YoloRoomInterceptor)this.N.get(Integer.valueOf(i1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager
 * JD-Core Version:    0.7.0.1
 */