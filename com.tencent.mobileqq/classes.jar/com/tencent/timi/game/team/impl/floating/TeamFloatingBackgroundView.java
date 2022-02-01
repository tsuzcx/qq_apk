package com.tencent.timi.game.team.impl.floating;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.float_window.FloatingAnimateInfo;
import com.tencent.timi.game.float_window.FloatingAnimateInfo.Companion;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.FloatingConfigParams.FloatingBuilder;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
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
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/floating/TeamFloatingBackgroundView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/float_window/IFloatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commonListener", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "getCommonListener", "()Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "setCommonListener", "(Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;)V", "dialogShowing", "", "getDialogShowing", "()Z", "setDialogShowing", "(Z)V", "floatingAnimateInfo", "Lcom/tencent/timi/game/float_window/FloatingAnimateInfo;", "gamingColor", "getGamingColor", "()I", "msgListener", "com/tencent/timi/game/team/impl/floating/TeamFloatingBackgroundView$msgListener$1", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingBackgroundView$msgListener$1;", "readyColor", "getReadyColor", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "selfUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "teamingColor", "toastDuration", "getToastDuration", "doRemind", "", "msg", "", "getAnimateInfo", "getAvatarView", "Lcom/tencent/timi/game/team/impl/floating/WaveAvatarRoundView;", "getFloatingConfigParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "getReportParam", "", "getStateView", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingStateView;", "getView", "Landroid/view/View;", "handlerJump", "init", "isAtSelf", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onAttachFloat", "onBackground", "onDetachFloat", "onForground", "onHide", "onLeaveTeam", "onShow", "refresh", "updateAnimateInfo", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingBackgroundView
  extends FrameLayout
  implements IFloatView
{
  public static final TeamFloatingBackgroundView.Companion a = new TeamFloatingBackgroundView.Companion(null);
  private static boolean l;
  private static boolean m;
  private boolean b;
  private final long c = 3000L;
  private long d;
  private final int e = Color.parseColor("#00CC8F");
  private final int f = Color.parseColor("#ffffff");
  private final int g = Color.parseColor("#F5B534");
  private final FloatingAnimateInfo h = new FloatingAnimateInfo();
  private CommonOuterClass.QQUserId i;
  private final TeamFloatingBackgroundView.msgListener.1 j = new TeamFloatingBackgroundView.msgListener.1(this);
  @NotNull
  private SimpleYoloRoomCommonListener k = (SimpleYoloRoomCommonListener)new TeamFloatingBackgroundView.commonListener.1(this);
  private HashMap n;
  
  @JvmOverloads
  public TeamFloatingBackgroundView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TeamFloatingBackgroundView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TeamFloatingBackgroundView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FrameLayout.inflate(getContext(), 2131629493, (ViewGroup)this);
  }
  
  private final void a(String paramString)
  {
    if (!l)
    {
      m = true;
      ((TeamFloatingStateView)a(2131446313)).setRedPointVisible(4);
      ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim(paramString);
      postDelayed((Runnable)new TeamFloatingBackgroundView.doRemind.1(this), this.c);
      h();
    }
  }
  
  private final boolean a(IMsg paramIMsg)
  {
    return (paramIMsg.g().at_user_msg.user_list.size() > 0) && (SpecialMsgUtil.a.a(paramIMsg, this.i));
  }
  
  private final Map<String, String> getReportParam()
  {
    Object localObject = TeamUtil.a(this.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "map");
    localObject = (Map)localObject;
    ((Map)localObject).put("pgid", "pg_yes_smoba_team");
    return localObject;
  }
  
  private final void h()
  {
    Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…         .getData(roomId)");
    int i1 = ((IRoomGetDataService)localObject1).i();
    localObject1 = (CommonOuterClass.QQUserId)null;
    Object localObject3 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d);
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
          Object localObject4 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d);
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
            this.i = localYoloRoomSpeakingPosInfo.user_id;
            localObject1 = localObject2;
          }
        }
      }
    }
    ((WaveAvatarRoundView)a(2131450040)).a((CommonOuterClass.QQUserId)localObject2);
    if (3 == i1)
    {
      m = false;
      ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim("游戏中");
      ((TeamFloatingStateView)a(2131446313)).setRedPointVisible(4);
      ((WaveAvatarRoundView)a(2131450040)).setTeamCountVisible(8);
    }
    else
    {
      if (m) {
        ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim("发车提醒");
      } else {
        ((TeamFloatingStateView)a(2131446313)).setTeamStateWithAnim("组队中");
      }
      localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d);
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
          break label511;
        }
      }
      i1 = 1;
      label511:
      localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d);
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
          break label653;
        }
      }
      int i2 = 1;
      label653:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append('/');
      ((StringBuilder)localObject1).append(i1);
      localObject1 = new SpannableString((CharSequence)((StringBuilder)localObject1).toString());
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.f), 0, 1, 33);
      ((WaveAvatarRoundView)a(2131450040)).setTeamCountVisible(0);
      ((WaveAvatarRoundView)a(2131450040)).setTeamCountText((CharSequence)localObject1);
    }
    ((WaveAvatarRoundView)a(2131450040)).setAvatarClickListener((View.OnClickListener)new TeamFloatingBackgroundView.refresh.2(this));
    setOnClickListener((View.OnClickListener)new TeamFloatingBackgroundView.refresh.3(this));
    ((ImageView)a(2131430813)).setOnClickListener((View.OnClickListener)new TeamFloatingBackgroundView.refresh.4(this));
  }
  
  private final void i()
  {
    k();
    if (!this.b)
    {
      m = false;
      ((IReportService)ServiceCenter.a(IReportService.class)).a("clck", (Object)this, getReportParam());
      IRoomService localIRoomService = (IRoomService)ServiceCenter.a(IRoomService.class);
      Context localContext = (Context)MobileQQ.getContext();
      IRoomGetDataService localIRoomGetDataService = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d);
      Intrinsics.checkExpressionValueIsNotNull(localIRoomGetDataService, "ServiceCenter.getService…ass.java).getData(roomId)");
      localIRoomService.a(localContext, localIRoomGetDataService.b(), 4);
      h();
    }
  }
  
  private final void j()
  {
    if (!this.b)
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).a("clck", (Object)this, getReportParam());
      Object localObject = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject).element = TimiGameActivityManager.a();
      QBaseActivity localQBaseActivity = (QBaseActivity)((Ref.ObjectRef)localObject).element;
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "activity");
      localObject = new CommonDialog.Builder((Context)localQBaseActivity).c("确定要离开车队吗？").a(17).a((DialogInterface.OnClickListener)new TeamFloatingBackgroundView.onLeaveTeam.dialog.1(this, (Ref.ObjectRef)localObject)).e("取消").b((DialogInterface.OnClickListener)TeamFloatingBackgroundView.onLeaveTeam.dialog.2.a).a();
      ((CommonDialog)localObject).setOnShowListener((DialogInterface.OnShowListener)new TeamFloatingBackgroundView.onLeaveTeam.1(this));
      ((CommonDialog)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new TeamFloatingBackgroundView.onLeaveTeam.2(this));
      ((CommonDialog)localObject).show();
    }
  }
  
  private final void k()
  {
    FloatingAnimateInfo localFloatingAnimateInfo = this.h;
    WaveAvatarRoundView localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    float f1 = ViewExKt.a((View)localWaveAvatarRoundView);
    localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    localFloatingAnimateInfo.a(f1 + localWaveAvatarRoundView.getWidth() * 0.5F);
    localFloatingAnimateInfo = this.h;
    localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    f1 = ViewExKt.b((View)localWaveAvatarRoundView);
    localWaveAvatarRoundView = (WaveAvatarRoundView)a(2131450040);
    Intrinsics.checkExpressionValueIsNotNull(localWaveAvatarRoundView, "waveAvatar");
    localFloatingAnimateInfo.b(f1 + localWaveAvatarRoundView.getHeight() * 0.5F);
    this.h.c(CommonExKt.b(46));
    this.h.a(FloatingAnimateInfo.a.a().d());
  }
  
  public View a(int paramInt)
  {
    if (this.n == null) {
      this.n = new HashMap();
    }
    View localView2 = (View)this.n.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.n.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public IFloatView a(long paramLong)
  {
    this.d = paramLong;
    return (IFloatView)this;
  }
  
  public void a()
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a("imp", (Object)this, getReportParam());
    h();
  }
  
  public void b()
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a("imp_end", (Object)this, getReportParam());
    k();
  }
  
  public void c()
  {
    Map localMap = getReportParam();
    Object localObject = getParent();
    if (localObject != null)
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).a(localObject, "pg_yes_smoba_team");
      ((IReportService)ServiceCenter.a(IReportService.class)).a((View)this, false, "", "em_yes_smoba_team_floating", localMap);
      localObject = (IReportService)ServiceCenter.a(IReportService.class);
      ImageView localImageView = (ImageView)a(2131430813);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "closeIv");
      ((IReportService)localObject).a((View)localImageView, false, "", "em_yes_smoba_team_floating_close", localMap);
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.d).a((YoloRoomInterface.YoloRoomCommonListener)this.k);
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.d).a((IMsgListener)this.j);
    h();
  }
  
  public void d()
  {
    FloatingAnimateInfo.a.a().a((Bitmap)null);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.d).a((YoloRoomInterface.YoloRoomCommonListener)this.k);
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.d);
  }
  
  public void e() {}
  
  public void f() {}
  
  @NotNull
  public FloatingAnimateInfo getAnimateInfo()
  {
    return this.h;
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
    return this.k;
  }
  
  public final boolean getDialogShowing()
  {
    return this.b;
  }
  
  @NotNull
  public FloatingConfigParams getFloatingConfigParams()
  {
    return new FloatingConfigParams.FloatingBuilder().a(CommonExKt.a(76), CommonExKt.a(90)).a();
  }
  
  public final int getGamingColor()
  {
    return this.e;
  }
  
  public final int getReadyColor()
  {
    return this.g;
  }
  
  public final long getRoomId()
  {
    return this.d;
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
    return this.c;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  public final void setCommonListener(@NotNull SimpleYoloRoomCommonListener paramSimpleYoloRoomCommonListener)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleYoloRoomCommonListener, "<set-?>");
    this.k = paramSimpleYoloRoomCommonListener;
  }
  
  public final void setDialogShowing(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.d = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingBackgroundView
 * JD-Core Version:    0.7.0.1
 */