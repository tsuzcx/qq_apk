package com.tencent.mobileqq.guild.message.chatpie;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemGuildPriorityHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class GuildChatpieMenuAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private GuildMenuDialogFragment a;
  private QQCustomMenu b;
  private int c = 0;
  
  public GuildChatpieMenuAdapter(GuildMenuDialogFragment paramGuildMenuDialogFragment)
  {
    this.a = paramGuildMenuDialogFragment;
  }
  
  private void a(View paramView, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("aio_menu_name_button", paramString1);
    localHashMap.put("aio_menu_location_button", paramString2);
    localHashMap.put("msg_type", Integer.valueOf(this.c));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(paramView, "em_msg_more", localHashMap);
  }
  
  public QQCustomMenuItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.b())) {
      return this.b.a(paramInt);
    }
    return null;
  }
  
  public void a(QQCustomMenu paramQQCustomMenu)
  {
    this.b = paramQQCustomMenu;
    QQCustomMenuItemGuildPriorityHelper.a(this.b);
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int getCount()
  {
    return this.b.b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QQCustomMenuItem localQQCustomMenuItem = a(paramInt);
    if (localQQCustomMenuItem != null)
    {
      GuildChatpieMenuAdapter.ChatpieMenuItemViewHolder localChatpieMenuItemViewHolder;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624980, paramViewGroup, false);
        localChatpieMenuItemViewHolder = new GuildChatpieMenuAdapter.ChatpieMenuItemViewHolder();
        localChatpieMenuItemViewHolder.a = ((ImageView)paramView.findViewById(2131435219));
        localChatpieMenuItemViewHolder.b = ((TextView)paramView.findViewById(2131447062));
        paramView.setTag(localChatpieMenuItemViewHolder);
        paramView.setOnClickListener(this);
      }
      else
      {
        localChatpieMenuItemViewHolder = (GuildChatpieMenuAdapter.ChatpieMenuItemViewHolder)paramView.getTag();
      }
      paramView.setId(localQQCustomMenuItem.b());
      localChatpieMenuItemViewHolder.a.setBackgroundDrawable(paramView.getResources().getDrawable(localQQCustomMenuItem.c()));
      localChatpieMenuItemViewHolder.b.setText(localQQCustomMenuItem.a());
      localChatpieMenuItemViewHolder.c = localQQCustomMenuItem;
      a(paramView, localQQCustomMenuItem.a(), String.valueOf(paramInt));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    GuildChatpieMenuAdapter.ChatpieMenuItemViewHolder localChatpieMenuItemViewHolder = (GuildChatpieMenuAdapter.ChatpieMenuItemViewHolder)paramView.getTag();
    if (localChatpieMenuItemViewHolder != null) {
      this.a.a(localChatpieMenuItemViewHolder.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.chatpie.GuildChatpieMenuAdapter
 * JD-Core Version:    0.7.0.1
 */