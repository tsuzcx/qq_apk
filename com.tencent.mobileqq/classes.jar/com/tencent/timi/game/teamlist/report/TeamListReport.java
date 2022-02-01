package com.tencent.timi.game.teamlist.report;

import android.view.View;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TeamListReport
{
  private static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    IExpandHall localIExpandHall = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localIExpandHall != null)
    {
      localHashMap.putAll(localIExpandHall.e().t());
      localHashMap.putAll(localIExpandHall.e().s());
    }
    return localHashMap;
  }
  
  public static void a(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_create_team", localMap);
  }
  
  public static void a(View paramView, String paramString1, String paramString2, List<Integer> paramList1, List<Integer> paramList2, String paramString3)
  {
    Map localMap = a();
    localMap.put("yes_team_id", paramString1);
    localMap.put("yes_team_name", paramString2);
    paramString2 = new StringBuilder();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramString2.append((Integer)paramList1.next());
      paramString2.append(",");
    }
    localMap.put("yes_team_rank", paramString2.toString());
    paramString2 = new StringBuilder();
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramString2.append((Integer)paramList1.next());
      paramString2.append(",");
    }
    localMap.put("yes_team_branch", paramString2.toString());
    localMap.put("yes_game_mode", paramString3);
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, paramString1, "em_yes_slidecard_smoba_team", localMap);
  }
  
  public static void b(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_slidecard_more_team", localMap);
  }
  
  public static void b(View paramView, String paramString1, String paramString2, List<Integer> paramList1, List<Integer> paramList2, String paramString3)
  {
    Map localMap = a();
    localMap.put("yes_team_id", paramString1);
    localMap.put("yes_team_name", paramString2);
    paramString2 = new StringBuilder();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramString2.append((Integer)paramList1.next());
      paramString2.append(",");
    }
    localMap.put("yes_team_rank", paramString2.toString());
    paramString2 = new StringBuilder();
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramString2.append((Integer)paramList1.next());
      paramString2.append(",");
    }
    localMap.put("yes_team_branch", paramString2.toString());
    localMap.put("yes_game_mode", paramString3);
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, paramString1, "em_yes_teamlist_panel_smoba_team", localMap);
  }
  
  public static void c(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_slidecard_view_more", localMap);
  }
  
  public static void d(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_teamfilter_panel_close", localMap);
  }
  
  public static void e(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_teamfilter_panel_create_team", localMap);
  }
  
  public static void f(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_teamfilter_panel_teamfilter", localMap);
  }
  
  public static void g(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_teamfilter_panel_confirm", localMap);
  }
  
  public static void h(View paramView)
  {
    Map localMap = a();
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, "em_yes_teamfilter_panel_reset", localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.report.TeamListReport
 * JD-Core Version:    0.7.0.1
 */