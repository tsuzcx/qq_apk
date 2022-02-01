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
    return this.a.m.size();
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
      paramView = this.a.i.inflate(2131629264, paramViewGroup, false);
      localViewHolder = new BindGroupActivity.ViewHolder();
      localViewHolder.a = ((ImageView)paramView.findViewById(2131432714));
      localViewHolder.b = ((TextView)paramView.findViewById(2131448053));
      paramView.setTag(localViewHolder);
    }
    BindGroupActivity.GroupInfo localGroupInfo = (BindGroupActivity.GroupInfo)this.a.m.get(paramInt);
    localViewHolder.b.setText(localGroupInfo.b);
    localViewHolder.c = localGroupInfo.c;
    Bitmap localBitmap = ImageLoader.a().a(localGroupInfo.c);
    if (localBitmap != null)
    {
      localViewHolder.a.setImageBitmap(localBitmap);
    }
    else
    {
      localViewHolder.a.setImageResource(2130841348);
      ImageLoader.a().a(localGroupInfo.c, this.a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */