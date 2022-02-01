package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopAioBlueTipsView
  extends TroopAioAgent
  implements View.OnClickListener
{
  protected boolean d = false;
  protected String e;
  protected Context f;
  protected View g;
  protected AIOTipsController h;
  protected String i = "";
  
  protected void a()
  {
    this.d = false;
  }
  
  protected void b()
  {
    this.d = false;
    this.g = null;
    this.e = null;
    this.f = null;
    this.i = null;
  }
  
  public void c()
  {
    AIOTipsController localAIOTipsController = this.h;
    if (localAIOTipsController != null) {
      localAIOTipsController.a(null);
    }
  }
  
  boolean d()
  {
    View localView = this.g;
    return (localView != null) && (localView.getVisibility() != 8);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!StringUtil.isEmpty(this.e))
    {
      localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.e);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      paramView.getContext().startActivity((Intent)localObject);
    }
    else
    {
      localObject = this.h;
      if (localObject != null) {
        ((AIOTipsController)localObject).a(null);
      }
      ReportController.b(this.D, "P_CliOper", "Grp_AIO", "", "sys_msg", "Clk_notice", 0, 0, this.i, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioBlueTipsView
 * JD-Core Version:    0.7.0.1
 */