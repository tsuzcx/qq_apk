package com.tencent.mobileqq.troop.troopcreate.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NewTroopSearchResultDialog
  extends ActionSheet
  implements View.OnClickListener
{
  XListView a;
  AppInterface b = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  View c;
  ImageView d;
  ITroopCreateService e = (ITroopCreateService)this.b.getRuntimeService(ITroopCreateService.class, "");
  ITroopCreateInfoService.TroopCreateCallback f;
  Activity g;
  int h = 0;
  long i = 0L;
  private ArrayList<ITroopSearchService.SearchResult> j;
  
  public NewTroopSearchResultDialog(Activity paramActivity, ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback)
  {
    super(paramActivity);
    this.g = paramActivity;
    this.f = paramTroopCreateCallback;
  }
  
  public void a(ArrayList<ITroopSearchService.SearchResult> paramArrayList)
  {
    this.j = paramArrayList;
  }
  
  public void onClick(View paramView)
  {
    int k = ((ITroopCreateInfoService)this.b.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo().createFrom;
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (paramView.getTag() != null)
    {
      localObject1 = (NewTroopSearchResultDialog.ViewHolder)paramView.getTag();
      this.e.onReuseTroop(((NewTroopSearchResultDialog.ViewHolder)localObject1).a);
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(k);
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.h);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
      this.e.terminateLogic();
    }
    else if (2131431504 == paramView.getId())
    {
      if (System.currentTimeMillis() - this.i > 1500L)
      {
        this.i = System.currentTimeMillis();
        this.e.createTroop(this.g, this.f);
      }
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(k);
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.h);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
    }
    else if (2131430817 == paramView.getId())
    {
      this.e.terminateLogic();
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    Object localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131626682, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      ((LinearLayout)localObject1).setBackgroundColor(-15921907);
    }
    addView((View)localObject1);
    Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
    this.a = ((XListView)((LinearLayout)localObject1).findViewById(2131445451));
    localObject2 = this.j;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      localObject2 = new NewTroopSearchResultDialog.ListAdapter(this, this.j);
      this.a.setAdapter((ListAdapter)localObject2);
      this.a.setMaxHeight(Utils.a(200.0F, getContext().getResources()));
      this.c = ((LinearLayout)localObject1).findViewById(2131431504);
      this.c.setOnClickListener(this);
      int k = this.j.size();
      localObject2 = String.format(HardCodeUtil.a(2131905391), new Object[] { Integer.valueOf(k) });
      ((TextView)((LinearLayout)localObject1).findViewById(2131444746)).setText((CharSequence)localObject2);
      localObject2 = ((ITroopCreateInfoService)this.b.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo();
      this.h = (((TroopCreateInfo)localObject2).inviteMembers.size() - 1);
      Object localObject3 = String.format(HardCodeUtil.a(2131905397), new Object[] { Integer.valueOf(this.h) });
      ((TextView)this.c.findViewById(2131445536)).setText((CharSequence)localObject3);
      ((SingleLineTextView)this.c.findViewById(2131448054)).setText(((TroopCreateInfo)localObject2).disPlayTroopName);
      this.d = ((ImageView)((LinearLayout)localObject1).findViewById(2131430817));
      this.d.setOnClickListener(this);
      super.show();
      localObject1 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(((TroopCreateInfo)localObject2).createFrom);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.h);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
      return;
    }
    dismiss();
    this.e.terminateLogic();
    this.g.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopSearchResultDialog
 * JD-Core Version:    0.7.0.1
 */