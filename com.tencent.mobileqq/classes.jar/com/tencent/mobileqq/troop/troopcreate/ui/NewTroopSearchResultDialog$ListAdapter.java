package com.tencent.mobileqq.troop.troopcreate.ui;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class NewTroopSearchResultDialog$ListAdapter
  extends BaseAdapter
{
  List<ITroopSearchService.SearchResult> a;
  
  NewTroopSearchResultDialog$ListAdapter(List<ITroopSearchService.SearchResult> paramList)
  {
    Object localObject;
    this.a = localObject;
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
  
  @SuppressLint({"SetTextI18n"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b.getContext()).inflate(2131626683, null);
      paramView = new NewTroopSearchResultDialog.ViewHolder(this.b);
      paramView.b = ((SingleLineTextView)localView.findViewById(2131439121));
      paramView.d = ((ImageView)localView.findViewById(2131434940));
      paramView.c = ((TextView)localView.findViewById(2131436844));
      localView.setOnClickListener(this.b);
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (NewTroopSearchResultDialog.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = (ITroopSearchService.SearchResult)getItem(paramInt);
    paramView.b.setText(((ITroopSearchService.SearchResult)localObject1).a.getTroopDisplayName());
    StringBuilder localStringBuilder;
    if (((ITroopSearchService.SearchResult)localObject1).a.lastMsgTime != 0L)
    {
      paramView.c.setVisibility(0);
      localObject2 = paramView.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905393));
      localStringBuilder.append(TimeManager.a().a(((ITroopSearchService.SearchResult)localObject1).a.troopuin, ((ITroopSearchService.SearchResult)localObject1).a.lastMsgTime));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    else if (((ITroopSearchService.SearchResult)localObject1).a.troopCreateTime != 0L)
    {
      paramView.c.setVisibility(0);
      localObject2 = paramView.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905398));
      localStringBuilder.append(TimeManager.a().a(((ITroopSearchService.SearchResult)localObject1).a.troopuin, ((ITroopSearchService.SearchResult)localObject1).a.troopCreateTime));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    else
    {
      paramView.c.setVisibility(8);
    }
    int i;
    if (((ITroopSearchService.SearchResult)localObject1).a.hasSetTroopHead()) {
      i = 4;
    } else {
      i = 113;
    }
    Object localObject2 = FaceDrawable.getFaceDrawable(this.b.b, i, ((ITroopSearchService.SearchResult)localObject1).a.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
    paramView.d.setImageDrawable((Drawable)localObject2);
    paramView.a = ((ITroopSearchService.SearchResult)localObject1).a.troopuin;
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopSearchResultDialog.ListAdapter
 * JD-Core Version:    0.7.0.1
 */