package com.tencent.mobileqq.guild.chatpie.helper;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class GuildTitleBarHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  private GuildChatContext b;
  private TextView c = null;
  private NavBarAIO d = null;
  private View e = null;
  private GPServiceObserver f = new GuildTitleBarHelper.1(this);
  
  public GuildTitleBarHelper(GuildChatContext paramGuildChatContext)
  {
    this.b = paramGuildChatContext;
    this.a = paramGuildChatContext.a();
  }
  
  private void a(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    Drawable localDrawable = this.b.s().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, AIOUtils.b(20.0F, this.b.s().getResources()), AIOUtils.b(20.0F, this.b.s().getResources()));
    this.c.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2) {
      return;
    }
    a(2130840881);
  }
  
  private void b()
  {
    Object localObject = this.b.s().findViewById(2131437136);
    if (localObject != null) {
      ((View)localObject).setPadding(0, ((View)localObject).getTop(), 0, ((View)localObject).getPaddingBottom());
    }
    localObject = this.b.K();
    if (localObject != null)
    {
      this.c = ((TextView)((NavBarAIO)localObject).findViewById(2131427973));
      if (this.c == null)
      {
        this.c = new TextView(this.b.b());
        this.c.setId(2131427973);
        this.c.setPadding(ViewUtils.dpToPx(1.0F), 0, 0, 0);
        this.c.setSingleLine(true);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(1, 2131437136);
        localLayoutParams.addRule(15);
        ((NavBarAIO)localObject).addView(this.c, localLayoutParams);
      }
    }
  }
  
  private void c()
  {
    this.b.d(false);
    this.d = ((NavBarAIO)this.b.s().findViewById(2131444897));
    ImageView localImageView1 = (ImageView)this.b.s().findViewById(2131436666);
    ImageView localImageView2 = (ImageView)this.b.s().findViewById(2131436194);
    TextView localTextView1 = (TextView)this.b.s().findViewById(2131436180);
    Object localObject = this.b.U();
    if (localObject != null) {
      localObject = ((IGProChannelInfo)localObject).getChannelName();
    } else {
      localObject = this.b.b().getIntent().getStringExtra("channel_name");
    }
    if (localObject != null)
    {
      TextView localTextView2 = this.c;
      if (localTextView2 != null)
      {
        localTextView2.setText((CharSequence)localObject);
        this.c.setTextSize(2, 16.0F);
        this.c.setVisibility(0);
        this.c.setMaxEms(10);
        this.c.setTextColor(-16777216);
      }
    }
    if (localImageView2 != null)
    {
      if ((this.b.Y()) || (!e())) {
        localImageView2.setVisibility(8);
      }
      localImageView2.setBackgroundResource(0);
      localImageView2.setImageResource(2130841005);
      localImageView2.setOnClickListener(new -..Lambda.GuildTitleBarHelper.Gb5c7gVrPndfrKEhJfpfcdEhInQ(this));
    }
    if (localTextView1 != null) {
      localTextView1.setVisibility(8);
    }
    if (localImageView1 != null)
    {
      localImageView1.setBackgroundResource(0);
      localImageView1.setImageResource(2130841043);
      localImageView1.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView1.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localImageView1.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.dpToPx(13.0F);
        ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(17.0F);
        ((LinearLayout.LayoutParams)localObject).width = ViewUtils.dip2px(17.0F);
        localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((NavBarAIO)localObject).setBackgroundColor(-65538);
      this.d.a(false);
    }
    f();
    i();
    j();
    a();
  }
  
  private void d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((GuildChatContext)localObject).U();
      if (localObject != null)
      {
        if (((IQQGuildService)this.b.a().getRuntimeService(IQQGuildService.class, "")).isCurrentGuildManager(this.b.a(), this.b.S())) {
          ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(this.a, this.b.b(), ((IGProChannelInfo)localObject).getGuildId(), ((IGProChannelInfo)localObject).getChannelUin());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openChannelSetting error channelId:");
        ((StringBuilder)localObject).append(this.b.T());
        QLog.e("GuildTitleBarHelper", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean e()
  {
    GuildChatContext localGuildChatContext = this.b;
    if ((localGuildChatContext != null) && (localGuildChatContext.U() != null)) {
      return ((IQQGuildService)this.b.a().getRuntimeService(IQQGuildService.class, "")).isCurrentGuildManager(this.b.a(), this.b.S());
    }
    return false;
  }
  
  private void f()
  {
    a(this.b.V(), this.b.I());
  }
  
  private void g()
  {
    this.c = ((TextView)this.b.s().findViewById(2131447463));
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setOnClickListener(this.b.R());
    }
  }
  
  private void h()
  {
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).deleteObserver(this.f);
    LinearLayout localLinearLayout = (LinearLayout)this.b.s().findViewById(2131437136);
    TextView localTextView = this.c;
    if ((localTextView != null) && (localLinearLayout != null)) {
      localLinearLayout.removeView(localTextView);
    }
  }
  
  private void i()
  {
    if (this.e == null)
    {
      this.e = new View(this.b.b());
      this.e.setBackgroundColor(-1841688);
      Object localObject = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.d;
      if (localObject != null) {
        ((NavBarAIO)localObject).addView(this.e);
      }
    }
  }
  
  private void j()
  {
    View localView = this.b.s().findViewById(2131432290);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.b.s().findViewById(2131432291);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a()
  {
    Object localObject = (TextView)this.b.s().findViewById(2131448219);
    if (localObject != null)
    {
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setTextSize(1, 10.0F);
      ((TextView)localObject).setBackgroundResource(2130841049);
      ((TextView)localObject).setGravity(17);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.leftMargin = 0;
        localLayoutParams.rightMargin = ViewUtils.dpToPx(4.0F);
        ((TextView)localObject).setLayoutParams(localLayoutParams);
      }
    }
    localObject = this.b.s().findViewById(2131447534);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public String getTag()
  {
    return "GuildTitleBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 7, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 7)
      {
        if (paramInt != 15) {
          return;
        }
        h();
        return;
      }
      c();
      return;
    }
    g();
    b();
    c();
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).addObserver(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildTitleBarHelper
 * JD-Core Version:    0.7.0.1
 */