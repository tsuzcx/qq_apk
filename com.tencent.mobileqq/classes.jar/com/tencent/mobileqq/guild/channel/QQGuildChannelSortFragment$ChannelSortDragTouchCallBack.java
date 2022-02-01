package com.tencent.mobileqq.guild.channel;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.List;

class QQGuildChannelSortFragment$ChannelSortDragTouchCallBack
  extends BaseDragTouchCallBack<GuildChannelInfoUIData>
{
  private ItemTouchHelper c;
  
  public QQGuildChannelSortFragment$ChannelSortDragTouchCallBack(RecyclerView paramRecyclerView, List<GuildChannelInfoUIData> paramList)
  {
    super(paramRecyclerView, paramList);
  }
  
  public void a(ItemTouchHelper paramItemTouchHelper)
  {
    this.c = paramItemTouchHelper;
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
  
  public boolean isLongPressDragEnabled()
  {
    return (float)DeviceInfoUtil.D() - QQGuildChannelSortFragment.a(this.c) < DeviceInfoUtil.a * 50.0F;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    if (paramInt == 2) {
      paramViewHolder.itemView.setBackgroundResource(2130841011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelSortFragment.ChannelSortDragTouchCallBack
 * JD-Core Version:    0.7.0.1
 */