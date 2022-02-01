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
import com.tencent.mobileqq.theme.ThemeUtil;
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new GameMsgQuickReplayAdapter.ViewHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559266, paramViewGroup, false);
      paramView.a = ((TextView)localView.findViewById(2131378033));
      localView.setTag(paramView);
      localObject = a(paramInt);
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      if (!bool) {
        break label151;
      }
      paramView.a.setTextColor(Color.parseColor("#ffffff"));
      label83:
      if (!bool) {
        break label166;
      }
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838748));
    }
    for (;;)
    {
      paramView.a.setText(((GameMsgQuickReplyInfo)localObject).a);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (GameMsgQuickReplayAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label151:
      paramView.a.setTextColor(Color.parseColor("#1C1D1E"));
      break label83;
      label166:
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838747));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.GameMsgQuickReplayAdapter
 * JD-Core Version:    0.7.0.1
 */