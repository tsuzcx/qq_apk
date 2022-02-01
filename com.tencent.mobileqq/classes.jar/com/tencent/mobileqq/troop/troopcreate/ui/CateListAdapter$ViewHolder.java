package com.tencent.mobileqq.troop.troopcreate.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateConfig;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class CateListAdapter$ViewHolder
  implements View.OnClickListener
{
  CateListAdapter a;
  View b;
  TextView c;
  View d;
  ArrayList<SubCateListView> e;
  ArrayList<SingleItemViewHolder> f;
  TroopCateListProvider.TroopCateInfo g;
  View.OnClickListener h = new CateListAdapter.ViewHolder.1(this);
  SubCateListView.OnToggleSubListListener i = new CateListAdapter.ViewHolder.2(this);
  
  public CateListAdapter$ViewHolder(CateListAdapter paramCateListAdapter, View paramView)
  {
    this.a = paramCateListAdapter;
    this.b = paramView;
    this.c = ((TextView)paramView.findViewById(2131437292));
    this.d = paramView.findViewById(2131431509);
    this.f = new ArrayList();
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131437294), 0);
    this.f.add(paramCateListAdapter);
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131437295), 1);
    this.f.add(paramCateListAdapter);
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131437296), 2);
    paramCateListAdapter.i = ((ViewGroup)paramView.findViewById(2131437301));
    this.f.add(paramCateListAdapter);
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131437297), 3);
    this.f.add(paramCateListAdapter);
    this.e = new ArrayList(2);
    paramCateListAdapter = new SubCateListView((ViewStub)this.b.findViewById(2131437298), this.a.d, this.h, this.i);
    this.e.add(paramCateListAdapter);
    paramCateListAdapter = new SubCateListView((ViewStub)this.b.findViewById(2131437299), this.a.d, this.h, this.i);
    this.e.add(paramCateListAdapter);
  }
  
  public void a(TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((SubCateListView)((Iterator)localObject).next()).a();
    }
    this.g = paramTroopCateInfo;
    this.c.setText(paramTroopCateInfo.b);
    this.c.setContentDescription(paramTroopCateInfo.b);
    boolean bool = paramTroopCateInfo.b.equals(CateListAdapter.a);
    int k = 0;
    int j = k;
    if (bool)
    {
      localObject = (ITroopCreateConfig)this.a.g.getRuntimeService(ITroopCreateConfig.class, "");
      bool = TroopCreateUtils.a(this.a.g);
      j = k;
      if (((ITroopCreateConfig)localObject).isShow3KTroopTips())
      {
        localObject = this.d;
        if (bool) {
          j = 8;
        } else {
          j = 0;
        }
        ((View)localObject).setVisibility(j);
        j = k;
      }
    }
    while (j < paramTroopCateInfo.g.size())
    {
      ((SingleItemViewHolder)this.f.get(j)).a(this.a.d, (TroopCateListProvider.TroopCateInfo)paramTroopCateInfo.g.get(j), this);
      j += 1;
    }
    if ((paramTroopCateInfo.g.size() <= 2) && (this.f.size() > 2))
    {
      paramTroopCateInfo = (SingleItemViewHolder)this.f.get(2);
      if ((paramTroopCateInfo != null) && (paramTroopCateInfo.i != null)) {
        paramTroopCateInfo.i.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    SingleItemViewHolder localSingleItemViewHolder = (SingleItemViewHolder)paramView.getTag();
    if ((localSingleItemViewHolder != null) && (localSingleItemViewHolder.b != null))
    {
      TroopCateListProvider.TroopCateInfo localTroopCateInfo = localSingleItemViewHolder.b;
      String str;
      if (localTroopCateInfo.a == null) {
        str = "";
      } else {
        str = localTroopCateInfo.a;
      }
      ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
      if (localTroopCateInfo.h)
      {
        int j = localSingleItemViewHolder.a / 2;
        ((SubCateListView)this.e.get(j)).a(localSingleItemViewHolder, localTroopCateInfo);
      }
      else if (localTroopCateInfo.e == 1)
      {
        if (localTroopCateInfo.a != null) {
          if ((!localTroopCateInfo.a.equals("20001")) && (!localTroopCateInfo.a.equals("20002")))
          {
            if (localTroopCateInfo.a.equals("20003"))
            {
              QLog.e("createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
              ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5Page(QVIPPrettyTroopProcessor.e().a("category"), this.a.g.getCurrentUin(), (Activity)this.a.d);
              ReportController.b(this.a.g, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
            }
            else
            {
              this.a.e.a(localTroopCateInfo.a, null);
            }
          }
          else
          {
            if (((ITroopCreateConfig)this.a.g.getRuntimeService(ITroopCreateConfig.class, "")).isShow3KTroopTips())
            {
              TroopCreateUtils.b(this.a.g);
              this.d.setVisibility(8);
            }
            TroopCreateUtils.b((Activity)this.a.d, localTroopCateInfo.a);
            if (localTroopCateInfo.a.equals("20001")) {
              str = "Clk_type_2";
            } else {
              str = "Clk_type_3";
            }
            ReportController.b(this.a.g, "dc00899", "Grp_create_mobile", "", "chose_type", str, 0, 0, "", "", "", "");
          }
        }
      }
      else
      {
        this.a.e.a(localTroopCateInfo.f, localTroopCateInfo.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.CateListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */