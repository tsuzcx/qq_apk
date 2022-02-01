package com.tencent.mobileqq.guild.privatechannel;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
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

public class GuildPrivateMemberListViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public ImageView a;
  private final GuildPrivateMemberListAdapter b;
  private TextView c;
  private CheckBox d;
  private GuildPrivateMemberListAdapter.UserInfoUIData e;
  private View f;
  
  public GuildPrivateMemberListViewHolder(GuildPrivateMemberListAdapter paramGuildPrivateMemberListAdapter)
  {
    this.b = paramGuildPrivateMemberListAdapter;
  }
  
  private void a()
  {
    CheckBox localCheckBox = this.d;
    if ((localCheckBox != null) && (localCheckBox.isShown()) && (this.d.isEnabled()))
    {
      localCheckBox = this.d;
      localCheckBox.setChecked(localCheckBox.isChecked() ^ true);
    }
  }
  
  private void a(ImageView paramImageView, GuildUserAvatar paramGuildUserAvatar)
  {
    paramGuildUserAvatar = ((IGPSService)this.b.e().getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, 0);
    int i = (int)(DeviceInfoUtil.a * 36.0F);
    paramImageView.setImageDrawable(((IQQGuildAvatarApi)this.b.e().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramGuildUserAvatar, i, i, null));
  }
  
  private void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    this.a.setOnClickListener(this);
    paramUserInfoUIData = this.b.d().a(paramUserInfoUIData.mTinyId);
    if (paramUserInfoUIData != null)
    {
      a(this.a, paramUserInfoUIData);
      return;
    }
    paramUserInfoUIData = new BitmapDrawable(QQGuildUIUtil.a(true));
    this.a.setImageDrawable(paramUserInfoUIData);
  }
  
  private void b(int paramInt, GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData, boolean paramBoolean)
  {
    CheckBox localCheckBox = this.d;
    localCheckBox.setVisibility(0);
    boolean bool = paramUserInfoUIData.mSelectable;
    localCheckBox.setEnabled(bool);
    if (bool)
    {
      localCheckBox.setTag(paramUserInfoUIData);
      localCheckBox.setOnCheckedChangeListener(this);
      localCheckBox.setChecked(paramBoolean);
      return;
    }
    localCheckBox.setOnCheckedChangeListener(null);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625113, null);
    paramViewGroup.setTag(this);
    paramViewGroup.findViewById(2131436054).setOnClickListener(this);
    this.a = ((ImageView)paramViewGroup.findViewById(2131435959));
    this.c = ((TextView)paramViewGroup.findViewById(2131436071));
    this.d = ((CheckBox)paramViewGroup.findViewById(2131445517));
    this.f = paramViewGroup.findViewById(2131431715);
    if (this.b.b == 1)
    {
      this.d.setVisibility(8);
      this.f.setVisibility(8);
    }
    else if (this.b.b == 0)
    {
      this.d.setVisibility(0);
      this.f.setVisibility(8);
    }
    else if (this.b.b == 2)
    {
      this.d.setVisibility(8);
      this.f.setVisibility(0);
      this.f.setOnClickListener(this);
    }
    paramViewGroup.findViewById(2131436045).setVisibility(8);
    return paramViewGroup;
  }
  
  public void a(int paramInt, GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData, boolean paramBoolean)
  {
    this.e = paramUserInfoUIData;
    if (this.b.b == 0) {
      b(paramInt, paramUserInfoUIData, paramBoolean);
    } else if (this.b.b == 2) {
      if (this.e.mSelectable == true) {
        this.f.setVisibility(0);
      } else {
        this.f.setVisibility(8);
      }
    }
    this.a.setTag(paramUserInfoUIData);
    if (TextUtils.isEmpty(paramUserInfoUIData.mTinyId) == true) {
      this.a.setImageResource(2130840827);
    } else {
      a(paramUserInfoUIData);
    }
    this.c.setText(paramUserInfoUIData.mName);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.b.a(paramCompoundButton, paramBoolean))
    {
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(false);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (this.b.b == 1) {
      this.b.a(this.e);
    } else if (this.b.b == 0) {
      a();
    } else if ((this.b.b == 2) && (i == 2131431715)) {
      this.b.b(this.e);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListViewHolder
 * JD-Core Version:    0.7.0.1
 */