package com.tencent.mobileqq.guild.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.List;

public class QQGuildNotifySettingFragment
  extends QQGuildTitleBarFragment
  implements AdapterView.OnItemClickListener
{
  private IGProGuildInfo o;
  private XListView p;
  private QQGuildNotifySettingFragment.ChannelNotifyAdapter q;
  private ActionSheet r;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo)
  {
    ImageView localImageView1 = (ImageView)this.r.mContentContainer.findViewById(0).findViewById(2131427550);
    ImageView localImageView2 = (ImageView)this.r.mContentContainer.findViewById(1).findViewById(2131427550);
    ImageView localImageView3 = (ImageView)this.r.mContentContainer.findViewById(2).findViewById(2131427550);
    int j = ViewUtils.dip2px(16.0F);
    ImageView[] arrayOfImageView = new ImageView[3];
    arrayOfImageView[0] = localImageView1;
    arrayOfImageView[1] = localImageView2;
    arrayOfImageView[2] = localImageView3;
    int k = arrayOfImageView.length;
    int i = 0;
    while (i < k)
    {
      ViewGroup.LayoutParams localLayoutParams = arrayOfImageView[i].getLayoutParams();
      localLayoutParams.width = j;
      localLayoutParams.height = j;
      i += 1;
    }
    if (paramIGProChannelInfo.getFinalMsgNotify() == 2)
    {
      localImageView2.setImageResource(2130840638);
      localImageView2.setVisibility(0);
      localImageView1.setVisibility(8);
      localImageView3.setVisibility(8);
      return;
    }
    if (paramIGProChannelInfo.getFinalMsgNotify() == 3)
    {
      localImageView3.setImageResource(2130840638);
      localImageView3.setVisibility(0);
      localImageView2.setVisibility(8);
      localImageView1.setVisibility(8);
      return;
    }
    localImageView1.setImageResource(2130840638);
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(8);
    localImageView3.setVisibility(8);
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo, int paramInt)
  {
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).a(paramIGProChannelInfo, paramInt, new QQGuildNotifySettingFragment.2(this));
  }
  
  private void i()
  {
    this.c.setText(getResources().getString(2131916365));
    this.p = ((XListView)this.l.findViewById(2131439469));
    this.p.setOnItemClickListener(this);
  }
  
  private void j()
  {
    this.o = ((IGProGuildInfo)getActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info"));
    List localList = ((IGuildAdapterService)l().getRuntimeService(IGuildAdapterService.class, "")).getChannelList(this.o.getGuildID(), true);
    this.q = new QQGuildNotifySettingFragment.ChannelNotifyAdapter();
    this.q.a(localList);
    this.p.setAdapter(this.q);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
    j();
  }
  
  protected int b()
  {
    return 2131625014;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.q.a(paramInt);
    if (paramAdapterView == null) {
      return;
    }
    if (this.r == null)
    {
      this.r = ActionSheet.create(getActivity());
      this.r.addButton(2131890328);
      this.r.addButton(2131890331);
      this.r.addButton(2131890330);
      this.r.addCancelButton(getString(2131887648));
      paramView = getResources().getString(2131890329);
      this.r.setMainTitle(String.format(paramView, new Object[] { paramAdapterView.getChannelName() }));
    }
    paramView = (TextView)this.r.findViewById(2131427564);
    if (paramView != null) {
      paramView.setText(String.format(getResources().getString(2131890329), new Object[] { paramAdapterView.getChannelName() }));
    }
    this.r.setOnButtonClickListener(new QQGuildNotifySettingFragment.1(this, paramAdapterView));
    this.r.show();
    a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */