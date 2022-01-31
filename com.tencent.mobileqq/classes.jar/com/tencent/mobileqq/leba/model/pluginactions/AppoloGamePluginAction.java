package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.utils.VipUtils;

public class AppoloGamePluginAction
  extends PluginAction
{
  public AppoloGamePluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    super.a(paramView, paramLebaGridItemInfo);
    paramView = a();
    if (paramView == null) {}
    while (!"com.cmshow.game.android".equals(paramLebaGridItemInfo.a.pkgName)) {
      return;
    }
    VipUtils.a(paramView, "cmshow", "Apollo", "clk_tab_game", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.AppoloGamePluginAction
 * JD-Core Version:    0.7.0.1
 */