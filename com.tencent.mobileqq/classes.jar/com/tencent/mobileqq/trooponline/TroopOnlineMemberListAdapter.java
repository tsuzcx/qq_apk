package com.tencent.mobileqq.trooponline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TroopOnlineMemberListAdapter
  extends BaseAdapter
{
  protected List<TroopOnlineMemberItem> a = new ArrayList(15);
  protected List<String> b = new ArrayList(15);
  protected QQAppInterface c;
  protected String d;
  
  public TroopOnlineMemberListAdapter(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.c = paramQQAppInterface;
    this.d = paramString;
  }
  
  private void a(TroopOnlineMemberListAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.g.length() > 0) {
      paramViewHolder.g.delete(0, paramViewHolder.g.length());
    }
    StringBuilder localStringBuilder = paramViewHolder.g;
    localStringBuilder.append(paramViewHolder.e.getText().toString());
    localStringBuilder.append(",");
    localStringBuilder.append(paramViewHolder.d.getText().toString());
    paramViewHolder.a.setContentDescription(paramViewHolder.g.toString());
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(List<TroopOnlineMemberItem> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626734, paramViewGroup, false);
      localObject = new TroopOnlineMemberListAdapter.ViewHolder(this);
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).a = paramView;
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).c = ((ImageView)paramView.findViewById(2131436366));
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).d = ((RoundTextView)paramView.findViewById(2131448793));
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).e = ((TextView)paramView.findViewById(2131448598));
      paramView.setTag(localObject);
      localView = paramView;
      if (AppSetting.e)
      {
        paramView.setFocusable(true);
        ((TroopOnlineMemberListAdapter.ViewHolder)localObject).g = new StringBuilder();
        localView = paramView;
      }
    }
    TroopOnlineMemberListAdapter.ViewHolder localViewHolder = (TroopOnlineMemberListAdapter.ViewHolder)localView.getTag();
    TroopOnlineMemberItem localTroopOnlineMemberItem = (TroopOnlineMemberItem)this.a.get(paramInt);
    localViewHolder.f = localTroopOnlineMemberItem;
    localViewHolder.c.setImageDrawable(FaceDrawable.getFaceDrawable(this.c, 1, localTroopOnlineMemberItem.b));
    if ((localTroopOnlineMemberItem.c != null) && (localTroopOnlineMemberItem.c.startsWith("LV")))
    {
      localViewHolder.d.setVisibility(8);
    }
    else
    {
      localViewHolder.d.setVisibility(0);
      localViewHolder.d.setText(localTroopOnlineMemberItem.c);
      localViewHolder.d.setRoundBgColor(localTroopOnlineMemberItem.d);
    }
    localViewHolder.b = localTroopOnlineMemberItem.b;
    Object localObject = (TroopOnlineMemberListAdapter.TmiCallBackForName)localViewHolder.e.getTag();
    localViewHolder.e.setText(localTroopOnlineMemberItem.e);
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = new TroopOnlineMemberListAdapter.TmiCallBackForName(this, null);
      localViewHolder.e.setTag(paramView);
    }
    if (AppSetting.e) {
      a(localViewHolder);
    }
    paramView.a = localViewHolder;
    ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.d, localViewHolder.b, paramView);
    if (!this.b.contains(localViewHolder.b))
    {
      new ReportTask(this.c).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.d, localTroopOnlineMemberItem.c }).a();
      this.b.add(localViewHolder.b);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */