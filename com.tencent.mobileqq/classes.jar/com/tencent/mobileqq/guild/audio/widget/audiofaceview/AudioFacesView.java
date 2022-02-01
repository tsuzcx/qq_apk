package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.audio.GuildAudioChannelData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard.CardShowListener;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;

public class AudioFacesView
  extends RecyclerView
{
  private BaseQQAppInterface a;
  private IGProChannelInfo b;
  private IGProGuildInfo c;
  private FaceAdapter d;
  private View e;
  private LocalUserInfo f;
  private UserInfoList g;
  private boolean h;
  private long i;
  private final AudioRoomObserver j = new AudioFacesView.3(this);
  
  public AudioFacesView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioFacesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AudioFacesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, UserInfo paramUserInfo)
  {
    Object localObject = this.g.a(paramUserInfo.h);
    paramUserInfo = new GuildProfileData(this.b.getGuildId(), this.b.toString(), paramUserInfo.h, 1, 3);
    localObject = new GuildAudioChannelData(this.b.getChannelUin(), this.b.getType(), this.f.h, this.f.k, ((UserInfo)localObject).h, ((UserInfo)localObject).k, ((UserInfo)localObject).o, ((UserInfo)localObject).p);
    paramUserInfo.getExtras().putParcelable("key_channel_data", (Parcelable)localObject);
    paramUserInfo.getGuildBaseProfileData().d(this.b.getChannelUin());
    localObject = new AudioFacesView.2(this);
    GuildProfileCard.a((Activity)paramView.getContext(), paramUserInfo, (GuildProfileCard.CardShowListener)localObject);
  }
  
  public void a()
  {
    this.a.removeObserver(this.j);
  }
  
  public void a(Context paramContext)
  {
    setLayoutManager(new SafeLinearLayoutManager(paramContext, 1, false));
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, View paramView, int paramInt)
  {
    this.a = paramBaseQQAppInterface;
    this.e = paramView;
    this.d = new FaceAdapter(paramBaseQQAppInterface, paramInt);
    this.d.a(new AudioFacesView.1(this));
    setAdapter(this.d);
    setItemAnimator(null);
    setClipChildren(false);
  }
  
  public void a(LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList)
  {
    this.f = paramLocalUserInfo;
    this.g = paramUserInfoList;
    if (paramLocalUserInfo.c)
    {
      this.e.setVisibility(8);
      setVisibility(0);
    }
    else if (paramUserInfoList.a.size() <= 0)
    {
      this.e.setVisibility(0);
      setVisibility(8);
    }
    else
    {
      this.e.setVisibility(8);
      setVisibility(0);
    }
    if ((this.h) && (getItemAnimator() == null))
    {
      paramLocalUserInfo = new FaceItemAnimation();
      paramLocalUserInfo.setSupportsChangeAnimations(false);
      setItemAnimator(paramLocalUserInfo);
    }
    this.h = true;
    this.d.a(paramUserInfoList.a, this.f);
  }
  
  public void a(IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo)
  {
    this.b = paramIGProChannelInfo;
    this.c = paramIGProGuildInfo;
    this.a.addObserver(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView
 * JD-Core Version:    0.7.0.1
 */