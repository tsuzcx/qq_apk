package com.tencent.timi.game.team.impl.operate;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.scheme.tools.smoba.SmobaSchemeUtil;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;
import mqq.util.LogUtil;
import trpc.yes.common.SmobaDataOuterClass.YoloTeamInfo;
import trpc.yes.common.SmobaDataOuterClass.YoloTeamMemberInfo;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;
import trpc.yes.common.YoloRoomOuterClass.YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameRouteInfo;

public class TeamActionBtnView
  extends FrameLayout
  implements ITeamActionBtn
{
  private static long c;
  private CommonButton a;
  private long b;
  
  public TeamActionBtnView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TeamActionBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TeamActionBtnView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    Context localContext = getContext();
    Activity localActivity;
    if ((localContext != null) && ((localContext instanceof Activity))) {
      localActivity = (Activity)localContext;
    } else {
      localActivity = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leaveAndJumpOtherRooms - ");
    localStringBuilder.append(localContext);
    Logger.a("GangupActionBtnView", localStringBuilder.toString());
    if ((localActivity != null) && (!localActivity.isFinishing()) && ((localActivity instanceof TimiGameBaseActivity))) {
      ((TimiGameBaseActivity)localActivity).a();
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b, false, 0, new TeamActionBtnView.10(this, localActivity), true);
  }
  
  private void a(Context paramContext)
  {
    this.a = new CommonButton(paramContext);
    this.a.setGravity(17);
    this.a.setTextSize(1, 16.0F);
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void a(YoloBattleSmobaOuterClass.YoloSmobaOneSchema paramYoloSmobaOneSchema)
  {
    if ((paramYoloSmobaOneSchema != null) && (!TextUtils.isEmpty(paramYoloSmobaOneSchema.schema.get())))
    {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b, "GangupActionBtnView");
      SmobaSchemeUtil.a(paramYoloSmobaOneSchema.schema.get());
    }
  }
  
  private boolean a(int paramInt, String paramString1, String paramString2)
  {
    return paramInt == 9200107;
  }
  
  private void b()
  {
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoTeamList-openExpandHall topActivity - ");
    localStringBuilder.append(localQBaseActivity);
    Logger.a("GangupActionBtnView", localStringBuilder.toString());
    if (localQBaseActivity != null) {
      ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a(localQBaseActivity, new ExpandHallLaunchParam());
    }
  }
  
  private boolean b(Context paramContext)
  {
    if (((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b).m())
    {
      if ((paramContext != null) && ((paramContext instanceof Activity))) {
        paramContext = (Activity)paramContext;
      } else {
        paramContext = null;
      }
      if ((paramContext != null) && (!paramContext.isFinishing())) {
        new CommonDialog.Builder(paramContext).a("无法加入游戏队伍").c("由于王者队伍变更了游戏模式，暂时无法加入。我们为你推荐了其他车队噢！").d("去看看").a(new TeamActionBtnView.9(this)).e("取消").b(new TeamActionBtnView.8(this)).a().show();
      } else {
        CustomToastView.a("由于王者队伍变更了游戏模式，暂时无法加入。我们为你推荐了其他车队噢！");
      }
      return false;
    }
    return true;
  }
  
  private void c()
  {
    c = System.currentTimeMillis();
  }
  
  private boolean d()
  {
    long l = c;
    l = Math.min(15L, (15000L - (System.currentTimeMillis() - l)) / 1000L);
    if (l <= 0L) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("已经为你疯狂call队长啦，稍等");
    localStringBuilder.append(l);
    localStringBuilder.append("秒后再提醒TA吧");
    CustomToastView.a(localStringBuilder.toString());
    return false;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList, long paramLong, int paramInt, YoloBattleSmobaOuterClass.YoloSmobaOneSchema paramYoloSmobaOneSchema, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo)
  {
    long l = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    int j;
    if (paramLong == l) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b).b();
    if (localObject1 != null) {
      i = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_data_info.min_player_num.get();
    } else {
      i = 1;
    }
    int k;
    if (localObject1 != null) {
      k = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).game_data_info.smoba_game_data_info.game_mode.get();
    } else {
      k = 0;
    }
    if (localObject1 != null) {
      localObject1 = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).game_data_info.smoba_game_data_info.mode_name.get();
    } else {
      localObject1 = "";
    }
    if ((paramYoloGameRouteInfo != null) && (paramYoloGameRouteInfo.smoba_game_route_info.has())) {
      paramYoloGameRouteInfo = paramYoloGameRouteInfo.smoba_game_route_info.team_info;
    } else {
      paramYoloGameRouteInfo = null;
    }
    if ((paramYoloGameRouteInfo != null) && (paramYoloGameRouteInfo.memberlist.size() > 0))
    {
      localObject2 = paramYoloGameRouteInfo.memberlist.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramYoloGameRouteInfo = (SmobaDataOuterClass.YoloTeamMemberInfo)((Iterator)localObject2).next();
        if (paramYoloGameRouteInfo.uid.get() == l) {
          break label240;
        }
      }
    }
    paramYoloGameRouteInfo = null;
    label240:
    boolean bool1;
    if ((paramYoloSmobaOneSchema != null) && (paramYoloGameRouteInfo != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramYoloGameRouteInfo = new StringBuilder();
    paramYoloGameRouteInfo.append("updateBtn hostUid=");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong);
    paramYoloGameRouteInfo.append(LogUtil.getSafePrintUin(((StringBuilder)localObject2).toString()));
    paramYoloGameRouteInfo.append(", gameStatus=");
    paramYoloGameRouteInfo.append(paramInt);
    paramYoloGameRouteInfo.append(", speakingPosInfoList=");
    paramYoloGameRouteInfo.append(paramList.size());
    paramYoloGameRouteInfo.append(", minPlayer=");
    paramYoloGameRouteInfo.append(i);
    paramYoloGameRouteInfo.append(", isPlayerInSmobaTeam=");
    paramYoloGameRouteInfo.append(bool1);
    Logger.a("GangupActionBtnView", paramYoloGameRouteInfo.toString());
    if ((paramInt == 3) && (((paramYoloSmobaOneSchema != null) && (!bool1)) || (paramYoloSmobaOneSchema == null)))
    {
      this.a.setText("游戏中");
      this.a.setTextColor(-4671304);
      this.a.setBackgroundResource(2130853043);
      this.a.setOnClickListener(null);
      return;
    }
    if ((paramYoloSmobaOneSchema == null) && ((paramInt == 2) || (((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b).l() != null)))
    {
      this.a.setText("加入游戏");
      this.a.setTextColor(-1);
      this.a.setBackgroundResource(2130853044);
      this.a.setOnClickListener(new TeamActionBtnView.1(this));
      return;
    }
    if (j != 0)
    {
      if (paramYoloSmobaOneSchema != null)
      {
        paramList = TeamUtil.a(this.b);
        ((IReportService)ServiceCenter.a(IReportService.class)).a(this.a, true, "进入游戏", "em_yes_game_launch", paramList);
        this.a.setText("进入游戏");
        this.a.setTextColor(-1);
        this.a.setBackgroundResource(2130853044);
        this.a.setOnClickListener(new TeamActionBtnView.2(this, bool1, paramYoloSmobaOneSchema));
        return;
      }
      if (paramInt == 1)
      {
        this.a.setText("等待确认");
        this.a.setTextColor(-4671304);
        this.a.setBackgroundResource(2130853043);
        this.a.setOnClickListener(null);
        return;
      }
      paramList = paramList.iterator();
      paramInt = 0;
      while (paramList.hasNext())
      {
        paramYoloSmobaOneSchema = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.next();
        if ((paramYoloSmobaOneSchema.ready_status.get() != 1) && (paramYoloSmobaOneSchema.uid.get() != 0L) && (paramYoloSmobaOneSchema.uid.get() != l))
        {
          bool1 = false;
          break label775;
        }
        if (paramYoloSmobaOneSchema.uid.get() != 0L) {
          paramInt += 1;
        }
      }
      bool1 = true;
      label775:
      boolean bool2;
      if (paramInt >= i) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool1)
      {
        this.a.setText("立即发车");
        this.a.setTextColor(-1);
        this.a.setBackgroundResource(2130853044);
        this.a.setOnClickListener(new TeamActionBtnView.3(this, bool2, k, (String)localObject1, i));
        return;
      }
      this.a.setText("立即发车");
      this.a.setTextColor(-4671304);
      this.a.setBackgroundResource(2130853043);
      this.a.setOnClickListener(new TeamActionBtnView.4(this, bool1, i));
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramYoloGameRouteInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.next();
      if (paramYoloGameRouteInfo.uid.get() == l) {
        if (paramYoloGameRouteInfo.ready_status.get() == 1)
        {
          i = 1;
          break label960;
        }
      }
    }
    int i = 0;
    label960:
    if (paramYoloSmobaOneSchema != null)
    {
      paramList = TeamUtil.a(this.b);
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this.a, true, "进入游戏", "em_yes_game_launch", paramList);
      this.a.setText("进入游戏");
      this.a.setTextColor(-1);
      this.a.setBackgroundResource(2130853044);
      this.a.setOnClickListener(new TeamActionBtnView.5(this, bool1, paramYoloSmobaOneSchema));
      return;
    }
    if (((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b).l() == null)
    {
      if (paramInt == 2) {
        return;
      }
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (i != 0)
          {
            paramList = TeamUtil.a(this.b);
            ((IReportService)ServiceCenter.a(IReportService.class)).a(this.a, true, "提醒队长发车", "em_yes_gamelaunch_remind", paramList);
            this.a.setText("提醒队长发车");
            this.a.setTextColor(-1);
            this.a.setBackgroundResource(2130853044);
            this.a.setOnClickListener(new TeamActionBtnView.6(this));
            return;
          }
          this.a.setText("准备");
          this.a.setTextColor(-1);
          this.a.setBackgroundResource(2130853044);
          this.a.setOnClickListener(new TeamActionBtnView.7(this));
          return;
        }
        if (paramYoloSmobaOneSchema == null)
        {
          this.a.setText("游戏中");
          this.a.setTextColor(-4671304);
          this.a.setBackgroundResource(2130853043);
          this.a.setOnClickListener(null);
        }
      }
      else
      {
        if (((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b).c(l) != null)
        {
          this.a.setText("等待确认");
          this.a.setTextColor(-4671304);
          this.a.setBackgroundResource(2130853043);
          this.a.setOnClickListener(null);
          return;
        }
        this.a.setText("队伍创建中");
        this.a.setTextColor(-4671304);
        this.a.setBackgroundResource(2130853043);
        this.a.setOnClickListener(null);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a(getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView
 * JD-Core Version:    0.7.0.1
 */