package com.tencent.mobileqq.guild.setting;

import android.content.res.Resources;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.client.GuildClientPresenceUtils;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class QQGuildMemberListItemViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final int j = Utils.a(115.0F, MobileQQ.sMobileQQ.getResources());
  private static final int k = Utils.a(64.0F, MobileQQ.sMobileQQ.getResources());
  public View a;
  public ImageView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public CheckBox f;
  public TextView g;
  public TextView h;
  public TextView i;
  private final QQGuildMemberListAdapter l;
  
  public QQGuildMemberListItemViewHolder(QQGuildMemberListAdapter paramQQGuildMemberListAdapter)
  {
    this.l = paramQQGuildMemberListAdapter;
  }
  
  private void a()
  {
    CheckBox localCheckBox = this.f;
    if ((localCheckBox != null) && (localCheckBox.isShown()) && (this.f.isEnabled()))
    {
      localCheckBox = this.f;
      localCheckBox.setChecked(localCheckBox.isChecked() ^ true);
    }
  }
  
  private void a(int paramInt, QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem, boolean paramBoolean)
  {
    if (this.l.b().c())
    {
      this.f.setVisibility(0);
      boolean bool = b(paramUserInfoItem.c);
      this.f.setEnabled(bool);
      this.a.setEnabled(bool);
      if (bool)
      {
        this.f.setTag(Integer.valueOf(paramInt));
        this.f.setOnCheckedChangeListener(this);
        this.f.setChecked(paramBoolean);
        return;
      }
      this.f.setOnCheckedChangeListener(null);
      return;
    }
    this.f.setVisibility(8);
    this.a.setEnabled(true);
    this.f.setOnCheckedChangeListener(null);
  }
  
  private void a(View paramView, QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem)
  {
    boolean bool = this.l.b().m();
    Integer localInteger = Integer.valueOf(0);
    if (bool)
    {
      if (paramUserInfoItem.c.d() == 2)
      {
        paramView.setTag(-3, localInteger);
      }
      else if (paramUserInfoItem.c.f() == 1)
      {
        paramView.setTag(-3, Integer.valueOf(k));
        this.d.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).rightMargin = (-k);
      }
      else
      {
        paramView.setTag(-3, Integer.valueOf(j + k));
        this.d.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).rightMargin = (-k - j);
      }
    }
    else if (this.l.b().n())
    {
      if ((paramUserInfoItem.c.d() != 0) && (paramUserInfoItem.c.f() != 1))
      {
        paramView.setTag(-3, localInteger);
      }
      else
      {
        paramView.setTag(-3, Integer.valueOf(k));
        this.d.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).rightMargin = (-k);
      }
    }
    else {
      paramView.setTag(-3, localInteger);
    }
    if (this.l.c().getCurrentUin().equals(paramUserInfoItem.c.a())) {
      paramView.setTag(-3, localInteger);
    }
  }
  
  private void a(ImageView paramImageView, GuildUserAvatar paramGuildUserAvatar)
  {
    paramGuildUserAvatar = ((IGPSService)this.l.c().getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, 0);
    int m = (int)(DeviceInfoUtil.a * 36.0F);
    paramImageView.setImageDrawable(((IQQGuildAvatarApi)this.l.c().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramGuildUserAvatar, m, m, null));
  }
  
  private void a(QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem)
  {
    this.b.setOnClickListener(this);
    this.b.setTag(paramUserInfoItem);
    paramUserInfoItem = this.l.a().a(paramUserInfoItem);
    if (paramUserInfoItem != null)
    {
      a(this.b, paramUserInfoItem);
      return;
    }
    paramUserInfoItem = new BitmapDrawable(QQGuildUIUtil.a(true));
    this.b.setImageDrawable(paramUserInfoItem);
  }
  
  private void a(QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem, int paramInt)
  {
    if (paramUserInfoItem.c.d() == 2)
    {
      if (this.h.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.g.getLayoutParams()).leftMargin = Utils.a(4.0F, MobileQQ.sMobileQQ.getResources());
      }
      this.g.setText(BaseApplication.getContext().getString(2131890501));
      this.g.setVisibility(0);
      return;
    }
    if ((paramUserInfoItem.c.d() == 1) && (paramInt == 1))
    {
      this.g.setText(BaseApplication.getContext().getString(2131890506));
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
  
  private void b(View paramView, QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem)
  {
    if (this.l.b().m())
    {
      if (paramUserInfoItem.c.d() == 1)
      {
        this.d.setText(paramView.getResources().getString(2131890569));
        this.d.setBackgroundColor(-3684405);
        return;
      }
      this.d.setText(paramView.getResources().getString(2131890591));
      this.d.setBackgroundColor(-25856);
    }
  }
  
  private boolean b(IGProUserInfo paramIGProUserInfo)
  {
    if (paramIGProUserInfo.d() == 2) {
      return false;
    }
    if (paramIGProUserInfo.d() == 1) {
      return this.l.b().m();
    }
    return this.l.b().n();
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625085, null);
    paramViewGroup.setTag(this);
    this.b = ((ImageView)paramViewGroup.findViewById(2131435959));
    this.c = ((TextView)paramViewGroup.findViewById(2131436071));
    this.d = ((TextView)paramViewGroup.findViewById(2131436072));
    this.e = ((TextView)paramViewGroup.findViewById(2131436070));
    this.f = ((CheckBox)paramViewGroup.findViewById(2131445517));
    this.g = ((TextView)paramViewGroup.findViewById(2131436045));
    this.h = ((TextView)paramViewGroup.findViewById(2131436069));
    this.i = ((TextView)paramViewGroup.findViewById(2131435968));
    QQGuildUtil.a(paramViewGroup, "em_sgrp_member_list_member_click", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.d, "em_sgrp_member_list_member_manage", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.e, "em_sgrp_member_list_member_manage_set", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.h, "em_sgrp_memberlist_otherapp_identity", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    QQGuildUtil.a(this.i, "em_sgrp_memberlist_otherapp_status", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    this.a = paramViewGroup;
    return paramViewGroup;
  }
  
  public void a(int paramInt1, QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem, boolean paramBoolean, int paramInt2)
  {
    a(paramInt1, paramUserInfoItem, paramBoolean);
    a(this.a, paramUserInfoItem);
    b(this.a, paramUserInfoItem);
    a(paramUserInfoItem);
    this.c.setText(QQGuildUtil.a(paramUserInfoItem.c));
    this.c.setTag(paramUserInfoItem);
    this.c.setOnClickListener(this);
    a(paramUserInfoItem.c);
    a(paramUserInfoItem, paramInt2);
    this.d.setTag(paramUserInfoItem);
    this.d.setOnClickListener(this);
    this.e.setTag(paramUserInfoItem);
    this.e.setOnClickListener(this);
    this.a.setTag(2131436054, paramUserInfoItem);
    this.a.setOnClickListener(this);
  }
  
  public void a(IGProUserInfo paramIGProUserInfo)
  {
    IGProClientIdentityInfo localIGProClientIdentityInfo = paramIGProUserInfo.i();
    IGProClientPresenceInfo localIGProClientPresenceInfo = paramIGProUserInfo.j();
    if ((localIGProClientIdentityInfo != null) && (!TextUtils.isEmpty(localIGProClientIdentityInfo.b())))
    {
      this.h.setText(paramIGProUserInfo.i().b());
      this.h.setVisibility(0);
      paramIGProUserInfo = new HashMap();
      paramIGProUserInfo.put("sgrp_otherapp_id", localIGProClientIdentityInfo.a());
      VideoReport.setElementParams(this.h, paramIGProUserInfo);
    }
    else
    {
      this.h.setVisibility(8);
    }
    paramIGProUserInfo = GuildClientPresenceUtils.a(localIGProClientPresenceInfo);
    if (TextUtils.isEmpty(paramIGProUserInfo))
    {
      this.i.setVisibility(8);
      return;
    }
    this.i.setText(paramIGProUserInfo);
    this.i.setVisibility(0);
    paramIGProUserInfo = new HashMap();
    paramIGProUserInfo.put("sgrp_otherapp_id", Integer.valueOf(localIGProClientPresenceInfo.a()));
    VideoReport.setElementParams(this.h, paramIGProUserInfo);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.l.onCheckedChanged(paramCompoundButton, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (this.l.b().c())
    {
      a();
    }
    else
    {
      int n = paramView.getId();
      boolean bool2 = false;
      boolean bool1 = false;
      int m = 1;
      Object localObject1;
      Object localObject2;
      if ((n != 2131436054) && (paramView.getId() != 2131436071) && (paramView.getId() != 2131435959))
      {
        if (paramView.getId() == 2131436070)
        {
          localObject1 = (QQGuildMemberListAdapter.UserInfoItem)paramView.getTag();
          localObject2 = new ArrayList();
          ((List)localObject2).add(((QQGuildMemberListAdapter.UserInfoItem)localObject1).c);
          QQGuildMemberListAdapter localQQGuildMemberListAdapter = this.l;
          if (((QQGuildMemberListAdapter.UserInfoItem)localObject1).c.f() != 1) {
            bool1 = true;
          }
          localQQGuildMemberListAdapter.a((List)localObject2, bool1);
          localObject1 = new HashMap();
          ((Map)localObject1).put("sgrp_member_op_result", Integer.valueOf(3));
          VideoReport.reportEvent("clck", paramView, (Map)localObject1);
        }
        else if (paramView.getId() == 2131436072)
        {
          localObject1 = (QQGuildMemberListAdapter.UserInfoItem)paramView.getTag();
          this.l.b().a(((QQGuildMemberListAdapter.UserInfoItem)localObject1).c);
          localObject2 = new HashMap();
          if ((localObject1 != null) && (((QQGuildMemberListAdapter.UserInfoItem)localObject1).c != null))
          {
            if (((QQGuildMemberListAdapter.UserInfoItem)localObject1).c.d() == 1) {
              m = 2;
            }
            ((Map)localObject2).put("sgrp_member_op_result", Integer.valueOf(m));
            VideoReport.reportEvent("clck", this.a.findViewById(2131436070), (Map)localObject2);
          }
        }
      }
      else
      {
        m = paramView.getId();
        localObject1 = null;
        if (m == 2131436054)
        {
          VideoReport.reportEvent("clck", paramView, null);
          localObject1 = (QQGuildMemberListAdapter.UserInfoItem)paramView.getTag(2131436054);
        }
        else
        {
          localObject2 = this.a;
          if (localObject2 != null)
          {
            VideoReport.reportEvent("clck", localObject2, null);
            localObject1 = (QQGuildMemberListAdapter.UserInfoItem)paramView.getTag();
          }
        }
        if ((((QQGuildMemberListAdapter.UserInfoItem)localObject1).c != null) && (this.l.d() != null))
        {
          bool1 = bool2;
          if (((QQGuildMemberListAdapter.UserInfoItem)localObject1).c.f() == 1) {
            bool1 = true;
          }
          this.l.h();
          this.l.b().a(this.l.d(), this.l.i(), ((QQGuildMemberListAdapter.UserInfoItem)localObject1).c.a(), bool1);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListItemViewHolder
 * JD-Core Version:    0.7.0.1
 */