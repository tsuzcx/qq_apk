package com.tencent.timi.game.team.impl.floating;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.float_window.BusFloatManager;
import com.tencent.timi.game.float_window.BusFloatManager.Companion;
import com.tencent.timi.game.float_window.FloatingAnimateInfo;
import com.tencent.timi.game.float_window.FloatingAnimateInfo.Companion;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.FloatingConfigParams.FloatingBuilder;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.CommonExKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/float_window/IFloatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundHeartBeat", "com/tencent/timi/game/team/impl/floating/TeamFloatingView$backgroundHeartBeat$1", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$backgroundHeartBeat$1;", "commonListener", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "getCommonListener", "()Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "setCommonListener", "(Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;)V", "currentRemindStatus", "", "getCurrentRemindStatus", "()Ljava/lang/String;", "setCurrentRemindStatus", "(Ljava/lang/String;)V", "dialogShowing", "", "getDialogShowing", "()Z", "setDialogShowing", "(Z)V", "floatingAnimateInfo", "Lcom/tencent/timi/game/float_window/FloatingAnimateInfo;", "forgroundStatus", "gamingColor", "getGamingColor", "()I", "mMicDataListener", "Lcom/tencent/timi/game/room/api/YoloRoomInterface$YoloRoomAudioListener;", "mVoiceIndex", "getMVoiceIndex", "setMVoiceIndex", "(I)V", "msgListener", "com/tencent/timi/game/team/impl/floating/TeamFloatingView$msgListener$1", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$msgListener$1;", "readyColor", "getReadyColor", "remindingStatusRestor", "com/tencent/timi/game/team/impl/floating/TeamFloatingView$remindingStatusRestor$1", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$remindingStatusRestor$1;", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "selfUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "teamingColor", "toastDuration", "getToastDuration", "doRemind", "", "msg", "shake", "getAnimateInfo", "getAvatarView", "Lcom/tencent/timi/game/team/impl/floating/WaveAvatarRoundView;", "getFloatingConfigParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "getReportParam", "Ljava/util/concurrent/ConcurrentHashMap;", "getStateView", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingStateView;", "getView", "Landroid/view/View;", "handleVoiceAnim", "memberMicLevelList", "handlerJump", "init", "isAtSelf", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onAttachFloat", "onBackground", "onDetachFloat", "onForground", "onHide", "onLeaveTeam", "onShow", "refresh", "updateAnimateInfo", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingView
  extends FrameLayout
  implements IFloatView
{
  public static final TeamFloatingView.Companion a = new TeamFloatingView.Companion(null);
  private static boolean r;
  private static boolean s;
  @NotNull
  private String b = "";
  private boolean c;
  private final long d = 3000L;
  private long e;
  private int f;
  private final int g = Color.parseColor("#00CC8F");
  private final int h = Color.parseColor("#ffffff");
  private final int i = Color.parseColor("#F5B534");
  private final FloatingAnimateInfo j = new FloatingAnimateInfo();
  private CommonOuterClass.QQUserId k;
  private boolean l = true;
  private TeamFloatingView.remindingStatusRestor.1 m = new TeamFloatingView.remindingStatusRestor.1(this);
  private TeamFloatingView.backgroundHeartBeat.1 n = new TeamFloatingView.backgroundHeartBeat.1(this);
  private final TeamFloatingView.msgListener.1 o = new TeamFloatingView.msgListener.1(this);
  @NotNull
  private SimpleYoloRoomCommonListener p = (SimpleYoloRoomCommonListener)new TeamFloatingView.commonListener.1(this);
  private YoloRoomInterface.YoloRoomAudioListener q = (YoloRoomInterface.YoloRoomAudioListener)new TeamFloatingView.mMicDataListener.1(this);
  private HashMap t;
  
  @JvmOverloads
  public TeamFloatingView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TeamFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TeamFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FrameLayout.inflate(getContext(), 2131629493, (ViewGroup)this);
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    if (!r)
    {
      s = true;
      ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim(paramString);
      ((TeamFloatingStateView)a(2131446313)).setRedPointVisible(0);
      ((TeamFloatingStateView)a(2131446313)).c();
      View localView = a(2131434393);
      Intrinsics.checkExpressionValueIsNotNull(localView, "groundRedDot");
      localView.setVisibility(0);
      if ((paramBoolean) && (!TextUtils.equals((CharSequence)this.b, (CharSequence)paramString)))
      {
        this.b = paramString;
        ((WaveAvatarRoundView)a(2131450040)).a();
      }
      i();
      removeCallbacks((Runnable)this.m);
      postDelayed((Runnable)this.m, 3000L);
    }
  }
  
  private final void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap.size() <= 0) {
      return;
    }
    paramConcurrentHashMap = ((Map)paramConcurrentHashMap).entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      String str = (String)localEntry.getKey();
      int i1;
      if (((Number)localEntry.getValue()).intValue() >= 10) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (this.f % 5 == 0)
      {
        if ((WaveAvatarRoundView)a(2131450040) == null) {
          return;
        }
        if (i1 != 0) {
          ((WaveAvatarRoundView)a(2131450040)).b();
        } else {
          ((WaveAvatarRoundView)a(2131450040)).c();
        }
      }
      this.f += 1;
    }
  }
  
  private final boolean a(IMsg paramIMsg)
  {
    return (paramIMsg.g().at_user_msg.user_list.size() > 0) && (SpecialMsgUtil.a.a(paramIMsg, this.k));
  }
  
  private final ConcurrentHashMap<String, String> getReportParam()
  {
    ConcurrentHashMap localConcurrentHashMap = TeamUtil.a(this.e);
    Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "map");
    ((Map)localConcurrentHashMap).put("pgid", "pg_yes_smoba_team");
    return localConcurrentHashMap;
  }
  
  private final void i()
  {
    Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…         .getData(roomId)");
    int i1 = ((IRoomGetDataService)localObject1).i();
    localObject1 = (CommonOuterClass.QQUserId)null;
    Object localObject3 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
    Object localObject2 = localObject1;
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo;
    if (localObject3 != null)
    {
      localObject3 = ((IRoomGetDataService)localObject3).h();
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((Iterator)localObject3).next();
          Object localObject4 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "ServiceCenter.getService…         .getData(roomId)");
          localObject2 = localObject1;
          if (((IRoomGetDataService)localObject4).f() == localYoloRoomSpeakingPosInfo.uid.get()) {
            localObject2 = localYoloRoomSpeakingPosInfo.user_id;
          }
          long l1 = localYoloRoomSpeakingPosInfo.uid.get();
          localObject4 = ServiceCenter.a(ILoginCoreService.class);
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "ServiceCenter.getService…nCoreService::class.java)");
          localObject1 = localObject2;
          if (l1 == ((ILoginCoreService)localObject4).a())
          {
            this.k = localYoloRoomSpeakingPosInfo.user_id;
            localObject1 = localObject2;
          }
        }
      }
    }
    ((WaveAvatarRoundView)a(2131450040)).a((CommonOuterClass.QQUserId)localObject2);
    if (3 == i1)
    {
      s = false;
      this.b = "";
      localObject1 = a(2131434393);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "groundRedDot");
      ((View)localObject1).setVisibility(8);
      localObject1 = (TeamFloatingStateView)a(2131446313);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "stateView");
      if (!((TeamFloatingStateView)localObject1).getTeamState().equals("游戏中")) {
        ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim("游戏中");
      }
      ((TeamFloatingStateView)a(2131446313)).setRedPointVisible(4);
      ((TeamFloatingStateView)a(2131446313)).e();
      ((WaveAvatarRoundView)a(2131450040)).setTeamCountVisible(8);
      ((ImageView)a(2131434392)).setImageResource(2130852958);
    }
    else
    {
      if (!s)
      {
        localObject1 = (TeamFloatingStateView)a(2131446313);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "stateView");
        if (!((TeamFloatingStateView)localObject1).getTeamState().equals("组队中")) {
          ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim("组队中");
        }
        ((TeamFloatingStateView)a(2131446313)).setRedPointVisible(4);
        ((TeamFloatingStateView)a(2131446313)).e();
        localObject1 = a(2131434393);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "groundRedDot");
        ((View)localObject1).setVisibility(4);
      }
      localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
      if (localObject1 != null)
      {
        localObject1 = ((IRoomGetDataService)localObject1).h();
        if (localObject1 != null)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject3;
            if ((localYoloRoomSpeakingPosInfo.status.get() != 2) && (localYoloRoomSpeakingPosInfo.status.get() != 1)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i1 != 0) {
              ((Collection)localObject1).add(localObject3);
            }
          }
          i1 = ((List)localObject1).size();
          break label665;
        }
      }
      i1 = 1;
      label665:
      localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
      if (localObject1 != null)
      {
        localObject1 = ((IRoomGetDataService)localObject1).h();
        if (localObject1 != null)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject3).uid.get() > 0L) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (i2 != 0) {
              ((Collection)localObject1).add(localObject3);
            }
          }
          i2 = ((List)localObject1).size();
          break label807;
        }
      }
      int i2 = 1;
      label807:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append('/');
      ((StringBuilder)localObject1).append(i1);
      localObject1 = new SpannableString((CharSequence)((StringBuilder)localObject1).toString());
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.h), 0, 1, 33);
      ((WaveAvatarRoundView)a(2131450040)).setTeamCountVisible(0);
      ((WaveAvatarRoundView)a(2131450040)).setTeamCountText((CharSequence)localObject1);
      ((ImageView)a(2131434392)).setImageResource(2130852959);
    }
    ((WaveAvatarRoundView)a(2131450040)).setAvatarClickListener((View.OnClickListener)new TeamFloatingView.refresh.2(this));
    setOnClickListener((View.OnClickListener)new TeamFloatingView.refresh.3(this));
    ((ImageView)a(2131430813)).setOnClickListener((View.OnClickListener)new TeamFloatingView.refresh.4(this));
  }
  
  private final void j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void k()
  {
    if (!this.c)
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).a("clck", (Object)this, (Map)getReportParam());
      Object localObject = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject).element = TimiGameActivityManager.a();
      QBaseActivity localQBaseActivity = (QBaseActivity)((Ref.ObjectRef)localObject).element;
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "activity");
      localObject = new CommonDialog.Builder((Context)localQBaseActivity).c("确定要离开车队吗？").a(17).a((DialogInterface.OnClickListener)new TeamFloatingView.onLeaveTeam.dialog.1(this, (Ref.ObjectRef)localObject)).e("取消").b((DialogInterface.OnClickListener)TeamFloatingView.onLeaveTeam.dialog.2.a).a();
      ((CommonDialog)localObject).setOnShowListener((DialogInterface.OnShowListener)new TeamFloatingView.onLeaveTeam.1(this));
      ((CommonDialog)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new TeamFloatingView.onLeaveTeam.2(this));
      ((CommonDialog)localObject).show();
    }
  }
  
  private final void l()
  {
    FloatingAnimateInfo localFloatingAnimateInfo = this.j;
    WaveAvatarRoundView localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    float f1 = ViewExKt.a((View)localWaveAvatarRoundView);
    localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    localFloatingAnimateInfo.a(f1 + localWaveAvatarRoundView.getWidth() * 0.5F);
    localFloatingAnimateInfo = this.j;
    localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    f1 = ViewExKt.b((View)localWaveAvatarRoundView);
    localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    localFloatingAnimateInfo.b(f1 + localWaveAvatarRoundView.getHeight() * 0.5F);
    this.j.c(CommonExKt.b(46));
    this.j.a(FloatingAnimateInfo.a.a().d());
  }
  
  public View a(int paramInt)
  {
    if (this.t == null) {
      this.t = new HashMap();
    }
    View localView2 = (View)this.t.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.t.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public IFloatView a(long paramLong)
  {
    this.e = paramLong;
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(paramLong).a(this.q);
    return (IFloatView)this;
  }
  
  public void a()
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a("imp", (Object)this, (Map)getReportParam());
    i();
    ((TeamFloatingStateView)a(2131446313)).a();
    ((WaveAvatarRoundView)a(2131450040)).d();
    removeCallbacks((Runnable)this.n);
    postDelayed((Runnable)this.n, 3000L);
  }
  
  public void b()
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a("imp_end", (Object)this, (Map)getReportParam());
    l();
    removeCallbacks((Runnable)this.m);
    removeCallbacks((Runnable)this.n);
  }
  
  public void c()
  {
    Object localObject1 = getReportParam();
    Object localObject2 = getParent();
    if (localObject2 != null)
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).a(localObject2, "pg_yes_smoba_team");
      localObject2 = (IReportService)ServiceCenter.a(IReportService.class);
      Object localObject3 = (View)this;
      localObject1 = (Map)localObject1;
      ((IReportService)localObject2).a((View)localObject3, false, "", "em_yes_smoba_team_floating", (Map)localObject1);
      localObject2 = (IReportService)ServiceCenter.a(IReportService.class);
      localObject3 = (ImageView)a(2131430813);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "closeIv");
      ((IReportService)localObject2).a((View)localObject3, false, "", "em_yes_smoba_team_floating_close", (Map)localObject1);
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.e).a((YoloRoomInterface.YoloRoomCommonListener)this.p);
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.e).a((IMsgListener)this.o);
    i();
  }
  
  public void d()
  {
    FloatingAnimateInfo.a.a().a((Bitmap)null);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.e).b((YoloRoomInterface.YoloRoomCommonListener)this.p);
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.e);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.e).b(this.q);
    removeCallbacks((Runnable)this.m);
    removeCallbacks((Runnable)this.n);
  }
  
  public void e()
  {
    Object localObject = (ConstraintLayout)a(2131433613);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "foregroundContainer");
    ((ConstraintLayout)localObject).setVisibility(8);
    localObject = (FrameLayout)a(2131434394);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "groundViewContainer");
    ((FrameLayout)localObject).setVisibility(0);
    BusFloatManager.a.a().a(String.valueOf(this.e), CommonExKt.a(55), CommonExKt.a(19));
    this.l = false;
  }
  
  public void f()
  {
    Object localObject = (ConstraintLayout)a(2131433613);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "foregroundContainer");
    ((ConstraintLayout)localObject).setVisibility(0);
    localObject = (FrameLayout)a(2131434394);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "groundViewContainer");
    ((FrameLayout)localObject).setVisibility(8);
    BusFloatManager.a.a().a(String.valueOf(this.e), CommonExKt.a(78), CommonExKt.a(84));
    this.l = true;
  }
  
  @NotNull
  public FloatingAnimateInfo getAnimateInfo()
  {
    return this.j;
  }
  
  @NotNull
  public final WaveAvatarRoundView getAvatarView()
  {
    WaveAvatarRoundView localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    return localWaveAvatarRoundView;
  }
  
  @NotNull
  public final SimpleYoloRoomCommonListener getCommonListener()
  {
    return this.p;
  }
  
  @NotNull
  public final String getCurrentRemindStatus()
  {
    return this.b;
  }
  
  public final boolean getDialogShowing()
  {
    return this.c;
  }
  
  @NotNull
  public FloatingConfigParams getFloatingConfigParams()
  {
    return new FloatingConfigParams.FloatingBuilder().a(CommonExKt.a(78), CommonExKt.a(91)).a();
  }
  
  public final int getGamingColor()
  {
    return this.g;
  }
  
  public final int getMVoiceIndex()
  {
    return this.f;
  }
  
  public final int getReadyColor()
  {
    return this.i;
  }
  
  public final long getRoomId()
  {
    return this.e;
  }
  
  @NotNull
  public final TeamFloatingStateView getStateView()
  {
    TeamFloatingStateView localTeamFloatingStateView = (TeamFloatingStateView)a(2131446313);
    Intrinsics.checkExpressionValueIsNotNull(localTeamFloatingStateView, "stateView");
    return localTeamFloatingStateView;
  }
  
  public final long getToastDuration()
  {
    return this.d;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  public final void setCommonListener(@NotNull SimpleYoloRoomCommonListener paramSimpleYoloRoomCommonListener)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleYoloRoomCommonListener, "<set-?>");
    this.p = paramSimpleYoloRoomCommonListener;
  }
  
  public final void setCurrentRemindStatus(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final void setDialogShowing(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void setMVoiceIndex(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.e = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView
 * JD-Core Version:    0.7.0.1
 */