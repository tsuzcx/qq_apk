package com.tencent.mobileqq.gamecenter.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gamecenter.data.GameMsgQuickReplyInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class GameMsgQuickReplayAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<GameMsgQuickReplyInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public GameMsgQuickReplayAdapter(Context paramContext, ArrayList<GameMsgQuickReplyInfo> paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public GameMsgQuickReplyInfo a(int paramInt)
  {
    return (GameMsgQuickReplyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GameMsgQuickReplayAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new GameMsgQuickReplayAdapter.ViewHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559140, paramViewGroup, false);
      localViewHolder.a = ((TextView)paramView.findViewById(2131377458));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (GameMsgQuickReplayAdapter.ViewHolder)paramView.getTag();
    }
    GameMsgQuickReplyInfo localGameMsgQuickReplyInfo = a(paramInt);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (bool) {
      localViewHolder.a.setTextColor(Color.parseColor("#ffffff"));
    } else {
      localViewHolder.a.setTextColor(Color.parseColor("#1C1D1E"));
    }
    if (bool) {
      paramView.setBackgroundDrawable(paramView.getResources().getDrawable(2130838593));
    } else {
      paramView.setBackgroundDrawable(paramView.getResources().getDrawable(2130838592));
    }
    localViewHolder.a.setText(localGameMsgQuickReplyInfo.a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.GameMsgQuickReplayAdapter
 * JD-Core Version:    0.7.0.1
 */