package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.IResultListener;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

public class TeamUtil
{
  private static final String a = "TeamUtil";
  
  public static ConcurrentHashMap<String, String> a(long paramLong)
  {
    return ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).r();
  }
  
  public static void a(long paramLong, Activity paramActivity)
  {
    a(paramLong, paramActivity, null);
  }
  
  public static void a(long paramLong, Activity paramActivity, IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp> paramIResultListener)
  {
    LoadingUtils.a.a(paramActivity);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong, false, 0, new TeamUtil.5(paramActivity, paramIResultListener), true);
  }
  
  public static void a(Activity paramActivity, long paramLong)
  {
    new CommonDialog.Builder(paramActivity).c("确定要离开车队吗？").a(17).a(new TeamUtil.2(paramLong, paramActivity)).e("取消").b(new TeamUtil.1()).a().show();
  }
  
  public static void b(Activity paramActivity, long paramLong)
  {
    paramActivity = new CommonDialog.Builder(paramActivity).c("收起车队需开启悬浮球权限，否则将退出车队").d("去开启").a(new TeamUtil.4(paramActivity)).e("退出车队").b(new TeamUtil.3(paramLong, paramActivity)).a();
    ConcurrentHashMap localConcurrentHashMap = a(paramLong);
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramActivity, "pg_yes_smoba_team");
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramActivity.a(), false, "", "em_yes_floating_authorize_win_open", localConcurrentHashMap);
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramActivity.b(), false, "", "em_yes_floating_authorize_win_leave", localConcurrentHashMap);
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamUtil
 * JD-Core Version:    0.7.0.1
 */