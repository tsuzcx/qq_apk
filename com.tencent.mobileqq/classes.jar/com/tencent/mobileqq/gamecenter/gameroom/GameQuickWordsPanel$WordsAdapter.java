package com.tencent.mobileqq.gamecenter.gameroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;

class GameQuickWordsPanel$WordsAdapter
  extends BaseAdapter
{
  protected int a = -1;
  
  GameQuickWordsPanel$WordsAdapter(GameQuickWordsPanel paramGameQuickWordsPanel) {}
  
  public int getCount()
  {
    return this.b.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.c.get(paramInt);
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
      localView = LayoutInflater.from(this.b.getContext()).inflate(2131624099, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(46.0F, this.b.getResources())));
      paramView = new GameQuickWordsPanel.WordsAdapter.ViewHolder(this);
      paramView.a = ((TextView)localView.findViewById(2131442943));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (GameQuickWordsPanel.WordsAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (String)getItem(paramInt);
    paramView.a.setText((CharSequence)localObject);
    paramView.a.setTextColor(this.a);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    HashMap localHashMap = this.b.g.bI();
    if (localHashMap.containsKey("quickWordColor")) {
      this.a = ((Integer)localHashMap.get("quickWordColor")).intValue();
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.gameroom.GameQuickWordsPanel.WordsAdapter
 * JD-Core Version:    0.7.0.1
 */