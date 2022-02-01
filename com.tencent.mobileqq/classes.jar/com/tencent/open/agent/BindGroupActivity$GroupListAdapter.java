package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class BindGroupActivity$GroupListAdapter
  extends AgentBaseAdapter
{
  protected BindGroupActivity$GroupListAdapter(BindGroupActivity paramBindGroupActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BindGroupActivity.ViewHolder localViewHolder;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localViewHolder = (BindGroupActivity.ViewHolder)paramView.getTag();
    }
    else
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562819, paramViewGroup, false);
      localViewHolder = new BindGroupActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366401));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379316));
      paramView.setTag(localViewHolder);
    }
    BindGroupActivity.GroupInfo localGroupInfo = (BindGroupActivity.GroupInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupInfo.b);
    localViewHolder.jdField_a_of_type_JavaLangString = localGroupInfo.c;
    Bitmap localBitmap = ImageLoader.a().a(localGroupInfo.c);
    if (localBitmap != null)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    else
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840582);
      ImageLoader.a().a(localGroupInfo.c, this.a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */