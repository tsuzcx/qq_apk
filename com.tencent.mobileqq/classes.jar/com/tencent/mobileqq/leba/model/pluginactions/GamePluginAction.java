package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

public class GamePluginAction
  extends PluginAction
{
  public GamePluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    super.a(paramView, paramLebaGridItemInfo);
    paramView = a();
    StatisticCollector.a(this.a).a(paramView, paramView.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    String str = IndividuationUrlHelper.a("vipGameCenter");
    if (!TextUtils.isEmpty(str)) {
      paramLebaGridItemInfo.a.jumpInfo = str;
    }
    paramLebaGridItemInfo = a(paramLebaGridItemInfo);
    paramLebaGridItemInfo.c("platformId=qq_m");
    paramLebaGridItemInfo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.GamePluginAction
 * JD-Core Version:    0.7.0.1
 */