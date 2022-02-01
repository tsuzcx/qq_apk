package com.tencent.mobileqq.guild.channel;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.List;

class QQGuildChannelListSettingFragment$ChannelSortDragTouchCallBack
  extends BaseDragTouchCallBack<GuildChannelInfoUIData>
{
  public QQGuildChannelListSettingFragment$ChannelSortDragTouchCallBack(RecyclerView paramRecyclerView, List<GuildChannelInfoUIData> paramList)
  {
    super(paramRecyclerView, paramList);
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    paramViewHolder.itemView.setBackgroundResource(2130841008);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getAdapterPosition();
    if (((GuildChannelInfoUIData)this.b.get(i)).c == null) {
      return makeMovementFlags(0, 0);
    }
    return super.getMovementFlags(paramRecyclerView, paramViewHolder);
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    if ((paramViewHolder != null) && (paramInt == 2)) {
      paramViewHolder.itemView.setBackgroundResource(2130841011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.ChannelSortDragTouchCallBack
 * JD-Core Version:    0.7.0.1
 */