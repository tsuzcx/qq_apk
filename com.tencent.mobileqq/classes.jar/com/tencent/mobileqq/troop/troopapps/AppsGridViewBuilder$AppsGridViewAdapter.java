package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AppsGridViewBuilder$AppsGridViewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private List<TroopAppShortcutContainer.TroopAppInfo> a = new ArrayList();
  private AppsGridViewBuilder b;
  private LayoutInflater c;
  private int d = 0;
  
  public AppsGridViewBuilder$AppsGridViewAdapter(AppsGridViewBuilder paramAppsGridViewBuilder, int paramInt)
  {
    this.b = paramAppsGridViewBuilder;
    this.c = LayoutInflater.from(this.b.f);
    this.d = paramInt;
  }
  
  public TroopAppShortcutContainer.TroopAppInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (TroopAppShortcutContainer.TroopAppInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(List<TroopAppShortcutContainer.TroopAppInfo> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    TroopAppShortcutContainer.TroopAppInfo localTroopAppInfo = a(paramInt);
    if (localTroopAppInfo != null) {
      return localTroopAppInfo.a;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      if (i == 0)
      {
        paramView = this.c.inflate(2131625899, paramViewGroup, false);
        localObject1 = new AppsGridViewBuilder.AppsGridViewHolder();
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).a = ((ImageView)paramView.findViewById(2131447897));
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b = ((ImageView)paramView.findViewById(2131447898));
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131447899));
        paramView.setTag(localObject1);
      }
      else
      {
        if (i != 1) {
          break label232;
        }
        paramView = this.c.inflate(2131625900, paramViewGroup, false);
        localObject1 = new AppsGridViewBuilder.AppsGridViewHolder();
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).a = ((ImageView)paramView.findViewById(2131447897));
        paramView.setTag(localObject1);
      }
      localObject2 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.d - 6);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.b.l)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(16.0F);
        ((GradientDrawable)localObject2).setColor(-16777216);
        paramView.setBackgroundDrawable((Drawable)localObject2);
      }
      else
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(16.0F);
        ((GradientDrawable)localObject2).setColor(-1);
        paramView.setBackgroundDrawable((Drawable)localObject2);
        break label253;
        label232:
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break label605;
      }
    }
    else
    {
      localObject1 = (AppsGridViewBuilder.AppsGridViewHolder)paramView.getTag();
    }
    label253:
    Object localObject2 = a(paramInt);
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getItem() == null position:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("AppsGridViewBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).d = ((TroopAppShortcutContainer.TroopAppInfo)localObject2);
      if (i == 0)
      {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).c.setText(((TroopAppShortcutContainer.TroopAppInfo)localObject2).d);
        if (this.b.l) {
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).c.setTextColor(Color.parseColor("#ffffff"));
        }
      }
      Object localObject3;
      if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).a == 1)
      {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).a.setImageDrawable(this.b.f.getResources().getDrawable(2130853399));
        TroopAppShortcutUtils.a(((AppsGridViewBuilder.AppsGridViewHolder)localObject1).a);
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(8);
      }
      else
      {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).a.setOnTouchListener(null);
        localObject3 = this.b.f;
        ImageView localImageView = ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).a;
        String str = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).e;
        boolean bool;
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).m == 1) {
          bool = true;
        } else {
          bool = false;
        }
        TroopAppShortcutUtils.a((Context)localObject3, localImageView, str, 24.0F, bool);
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).k != 0) {
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(0);
        } else {
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(8);
        }
      }
      i = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).a;
      localObject1 = "";
      if ((i == 0) && (((TroopAppShortcutContainer.TroopAppInfo)localObject2).c == 101914115L))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.b.b);
        ((StringBuilder)localObject3).append("");
        QQGameTroopManager.a(1, ((StringBuilder)localObject3).toString(), true);
      }
      if (AppSetting.e)
      {
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).d != null) {
          localObject1 = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).d;
        }
        paramView.setContentDescription((CharSequence)localObject1);
      }
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
    }
    Object localObject1 = paramView;
    label605:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof AppsGridViewBuilder.AppsGridViewHolder)))
    {
      localObject = (AppsGridViewBuilder.AppsGridViewHolder)localObject;
      if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).d != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick appInfo:");
          localStringBuilder.append(((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.toString());
          QLog.d("AppsGridViewBuilder", 2, localStringBuilder.toString());
        }
        if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.a == 1)
        {
          TroopAppShortcutUtils.a(1, this.b.b, this.b.g, this.b.f, this.b.h);
        }
        else if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.a == 0)
        {
          TroopAppShortcutUtils.a(this.b.g, this.b.f, this.b.h, String.valueOf(this.b.b), ((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.c, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.f, 1, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.k);
          long l1 = this.b.b;
          long l2 = this.b.c;
          long l3 = ((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.c;
          int i = this.b.k;
          if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).d.b == 0L) {
            localObject = "1";
          } else {
            localObject = "2";
          }
          ReportController.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsGridViewBuilder.AppsGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */