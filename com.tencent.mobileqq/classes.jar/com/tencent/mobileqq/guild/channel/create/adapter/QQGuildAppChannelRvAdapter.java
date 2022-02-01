package com.tencent.mobileqq.guild.channel.create.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQGuildAppChannelRvAdapter
  extends RecyclerView.Adapter<QQGuildAppChannelItemViewHolder>
{
  public QQGuildAppChannelPageListener a;
  private Context b;
  private List<IAppInfo> c = new ArrayList();
  
  public QQGuildAppChannelRvAdapter(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public QQGuildAppChannelItemViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new QQGuildAppChannelItemViewHolder(LayoutInflater.from(this.b).inflate(2131624986, null), this);
  }
  
  @RequiresApi(api=21)
  public void a(QQGuildAppChannelItemViewHolder paramQQGuildAppChannelItemViewHolder, int paramInt)
  {
    IAppInfo localIAppInfo = (IAppInfo)this.c.get(paramInt);
    paramQQGuildAppChannelItemViewHolder.a(localIAppInfo);
    paramQQGuildAppChannelItemViewHolder.itemView.setTag(localIAppInfo);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramQQGuildAppChannelItemViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(QQGuildAppChannelPageListener paramQQGuildAppChannelPageListener)
  {
    this.a = paramQQGuildAppChannelPageListener;
  }
  
  public void a(List<IAppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.c.clear();
      this.c.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.adapter.QQGuildAppChannelRvAdapter
 * JD-Core Version:    0.7.0.1
 */