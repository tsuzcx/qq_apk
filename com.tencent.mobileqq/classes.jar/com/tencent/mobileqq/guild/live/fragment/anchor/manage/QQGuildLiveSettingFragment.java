package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QQGuildLiveSettingFragment
  extends QQGuildChannelInfoSettingFragment
{
  private RelativeLayout p;
  private TextView q;
  private final List<String> r = new ArrayList();
  private final List<String> s = new ArrayList();
  private final List<String> t = new ArrayList();
  private boolean u = false;
  
  private void a(int paramInt, String paramString)
  {
    if (p())
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, "handleSetLiveChannelAnchorResult: illegalStatus");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSetLiveChannelAnchorResult: code[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] errMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.i("QGL.QQGuildLiveSettingFragment", 1, localStringBuilder.toString());
    q();
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    IGProChannelInfo localIGProChannelInfo = j();
    String str = i();
    List localList = b(paramList);
    paramList = c(paramList);
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setLiveChannelAnchorList(str, localIGProChannelInfo.getChannelUin(), localList, paramList, new QQGuildLiveSettingFragment.1(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    IGProChannelInfo localIGProChannelInfo = j();
    String str = i();
    IGPSService localIGPSService = (IGPSService)l().getRuntimeService(IGPSService.class, "");
    if (paramBoolean1) {
      this.t.clear();
    }
    localIGPSService.getVisibleMemberList(str, localIGProChannelInfo.getChannelUin(), 0, true, new QQGuildLiveSettingFragment.4(this, paramBoolean2));
  }
  
  private List<String> b(List<String> paramList)
  {
    paramList = new ArrayList(paramList);
    paramList.removeAll(this.r);
    return paramList;
  }
  
  private List<String> c(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.r);
    localArrayList.removeAll(paramList);
    return localArrayList;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.u) {
      return;
    }
    if (p())
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, "fetchAdminList: illegalStatus");
      return;
    }
    this.u = true;
    IGProChannelInfo localIGProChannelInfo = j();
    String str = i();
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getUserList(str, 0L, false, new QQGuildLiveSettingFragment.2(this, localIGProChannelInfo, paramBoolean));
  }
  
  private void n()
  {
    this.p = ((RelativeLayout)this.l.findViewById(2131434572));
    this.q = ((TextView)this.l.findViewById(2131434573));
    this.p.setVisibility(0);
    this.p.setOnClickListener(this);
    b(false);
  }
  
  private void o()
  {
    GuildLiveAuthorSelectMemberFragment.a(getQBaseActivity(), l(), this.o.getGuildId(), this.o.getChannelUin(), getString(2131890471), 0, (String[])this.r.toArray(new String[0]), 99, 1001);
    q();
  }
  
  private boolean p()
  {
    return getActivity() == null;
  }
  
  private void q()
  {
    if (this.u) {
      return;
    }
    this.u = true;
    IGProChannelInfo localIGProChannelInfo = j();
    String str = i();
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).fetchLiveChannelAnchorList(str, localIGProChannelInfo.getChannelUin(), new QQGuildLiveSettingFragment.3(this));
  }
  
  private void r()
  {
    this.r.removeAll(this.s);
    int i = j().getVisibleType();
    if (i == 2) {
      this.r.retainAll(this.t);
    }
    if (i == 1) {
      this.r.clear();
    }
    QLog.d("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "updateLiveChannelAnchorListAndCount: ", Integer.valueOf(this.s.size()), " admins, ", Integer.valueOf(this.r.size()), " anchors" });
    i = this.s.size();
    int j = this.r.size();
    this.q.setText(getString(2131890348, new Object[] { Integer.valueOf(i + j) }));
  }
  
  protected void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    super.a(paramInt, paramString, paramIGProSecurityResult);
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult))) {
      c(false);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    n();
    c(true);
  }
  
  protected void k()
  {
    super.k();
  }
  
  protected void m()
  {
    super.m();
    c(false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringArrayExtra("select_member_list");
        if (paramIntent != null) {
          paramIntent = Arrays.asList(paramIntent);
        } else {
          paramIntent = Collections.emptyList();
        }
        a(paramIntent);
        return;
      }
      QLog.i("QGL.QQGuildLiveSettingFragment", 1, "onActivityResult: return error.");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434572) {
      o();
    } else {
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.QQGuildLiveSettingFragment
 * JD-Core Version:    0.7.0.1
 */