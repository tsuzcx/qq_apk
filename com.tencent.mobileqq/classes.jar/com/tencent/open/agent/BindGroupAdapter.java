package com.tencent.open.agent;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class BindGroupAdapter
  extends FacePreloadBaseAdapter
{
  private Context a;
  private List<TroopInfo> b;
  
  public BindGroupAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  private void a(BindGroupAdapter.ViewHolder paramViewHolder, TroopInfo paramTroopInfo)
  {
    paramViewHolder.y = paramTroopInfo.troopuin;
    paramViewHolder.z = 4;
    paramViewHolder.c = paramTroopInfo;
    paramViewHolder.a.setText(paramTroopInfo.getTroopDisplayName());
    if (paramTroopInfo.isThirdAppBind())
    {
      paramViewHolder.b.setVisibility(0);
      paramViewHolder.b.setText(HardCodeUtil.a(2131899354));
    }
    else
    {
      paramViewHolder.b.setVisibility(8);
    }
    paramViewHolder.A.setImageBitmap(a(4, paramTroopInfo.troopuin));
  }
  
  public TroopInfo a(int paramInt)
  {
    return (TroopInfo)this.b.get(paramInt);
  }
  
  public void a(List<TroopInfo> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (paramList != null)
      {
        this.b.clear();
        this.b.addAll(paramList);
        notifyDataSetChanged();
      }
    }
    else {
      ThreadManager.getUIHandler().post(new BindGroupAdapter.1(this, paramList));
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2131625993, null);
      paramView = new BindGroupAdapter.ViewHolder();
      paramView.A = ((ImageView)localView.findViewById(2131435631));
      paramView.a = ((TextView)localView.findViewById(2131448988));
      paramView.b = ((TextView)localView.findViewById(2131448997));
      localView.setTag(paramView);
    }
    else
    {
      BindGroupAdapter.ViewHolder localViewHolder = (BindGroupAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    a(paramView, a(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupAdapter
 * JD-Core Version:    0.7.0.1
 */