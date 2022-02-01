package com.tencent.mobileqq.guild.privatechannel;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GuildPrivateSearchItemHolder
  implements View.OnClickListener
{
  public ImageView a;
  private final GuildPrivateSearchGridAdapter b;
  private TextView c;
  private GuildPrivateSearchGridAdapter.GridUIData d;
  
  public GuildPrivateSearchItemHolder(GuildPrivateSearchGridAdapter paramGuildPrivateSearchGridAdapter)
  {
    this.b = paramGuildPrivateSearchGridAdapter;
  }
  
  private void a(ImageView paramImageView, GuildUserAvatar paramGuildUserAvatar)
  {
    paramGuildUserAvatar = ((IGPSService)this.b.c().getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, 0);
    int i = (int)(DeviceInfoUtil.a * 36.0F);
    paramImageView.setImageDrawable(((IQQGuildAvatarApi)this.b.c().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramGuildUserAvatar, i, i, null));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625115, null);
    paramViewGroup.setTag(this);
    paramViewGroup.findViewById(2131437913).setOnClickListener(this);
    this.c = ((TextView)paramViewGroup.findViewById(2131436071));
    this.a = ((ImageView)paramViewGroup.findViewById(2131435959));
    if (this.b.b == 1) {
      paramViewGroup.findViewById(2131437913).setBackground(paramViewGroup.getResources().getDrawable(2130840979));
    }
    return paramViewGroup;
  }
  
  public void a(GuildPrivateSearchGridAdapter.GridUIData paramGridUIData)
  {
    this.d = paramGridUIData;
    this.c.setText(paramGridUIData.c);
    this.a.setTag(paramGridUIData);
    paramGridUIData = this.b.b().a(paramGridUIData.b);
    if (paramGridUIData != null)
    {
      a(this.a, paramGridUIData);
      return;
    }
    paramGridUIData = new BitmapDrawable(QQGuildUIUtil.a(true));
    this.a.setImageDrawable(paramGridUIData);
  }
  
  public void onClick(View paramView)
  {
    this.b.a.g.a(new String[] { this.d.b }, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateSearchItemHolder
 * JD-Core Version:    0.7.0.1
 */