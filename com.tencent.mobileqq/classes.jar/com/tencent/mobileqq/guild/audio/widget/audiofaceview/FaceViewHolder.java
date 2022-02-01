package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.widget.VolumnAnimateView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.qphone.base.util.QLog;

public class FaceViewHolder
  extends RecyclerView.ViewHolder
{
  ImageView a;
  ImageView b;
  ImageView c;
  TextView d;
  VolumnAnimateView e;
  String f;
  LocalUserInfo g;
  BaseQQAppInterface h;
  
  public FaceViewHolder(View paramView, BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramView);
    this.h = paramBaseQQAppInterface;
    this.a = ((ImageView)paramView.findViewById(2131434535));
    this.b = ((ImageView)paramView.findViewById(2131434536));
    this.c = ((ImageView)paramView.findViewById(2131434537));
    this.d = ((TextView)paramView.findViewById(2131434538));
    this.e = ((VolumnAnimateView)paramView.findViewById(2131434542));
  }
  
  private Drawable a(GuildUserAvatar paramGuildUserAvatar)
  {
    return ((IQQGuildAvatarApi)this.h.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.h, paramGuildUserAvatar, 0);
  }
  
  private void a()
  {
    Object localObject1 = ((IGPSService)this.h.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrl(this.f);
    if ((localObject1 != null) && (!((GuildUserAvatar)localObject1).c().isEmpty()))
    {
      Object localObject2 = a((GuildUserAvatar)localObject1);
      this.a.setImageDrawable((Drawable)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAvatarUrl tinyId:");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append(", avatar url:");
      ((StringBuilder)localObject2).append(((GuildUserAvatar)localObject1).c());
      QLog.i("FaceViewHolder", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getAvatarUrl tinyId:");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append(", avatar url: null");
    QLog.i("FaceViewHolder", 1, ((StringBuilder)localObject1).toString());
  }
  
  private void a(UserInfo paramUserInfo)
  {
    if (this.g.c)
    {
      if (paramUserInfo.o)
      {
        this.c.setVisibility(0);
        this.e.setVisibility(8);
      }
      else
      {
        this.c.setVisibility(8);
      }
      if ((paramUserInfo.m) && (!paramUserInfo.p))
      {
        this.b.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setVolumn(paramUserInfo.n);
      }
      else
      {
        this.b.setVisibility(0);
        this.e.setVisibility(8);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramUserInfo.h);
        localStringBuilder.append("info isMicOn");
        localStringBuilder.append(paramUserInfo.m);
        localStringBuilder.append(" muteToMe: ");
        localStringBuilder.append(paramUserInfo.o);
        QLog.i("FaceViewHolder", 1, localStringBuilder.toString());
      }
    }
    else
    {
      this.b.setVisibility(8);
      this.e.setVisibility(8);
    }
  }
  
  public void a(UserInfo paramUserInfo, LocalUserInfo paramLocalUserInfo)
  {
    this.f = paramUserInfo.h;
    this.g = paramLocalUserInfo;
    this.d.setText(paramUserInfo.i);
    a();
    a(paramUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceViewHolder
 * JD-Core Version:    0.7.0.1
 */