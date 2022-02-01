package com.tencent.mobileqq.guild.mainframe;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.GuildContainerController;
import com.tencent.mobileqq.guild.mainframe.helper.GuildMFJumpHelper;
import com.tencent.mobileqq.guild.mainframe.helper.HelperProvider;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController.OnLeftBarItemCountUpdateListener;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListItemAdapter.ItemCountInfo;
import com.tencent.mobileqq.guild.widget.NetStatusInfoView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import mqq.app.AppRuntime;

@Deprecated
class GuildMainFrame
  extends Frame
  implements GuildContextProvider, IGuildMainFrame, GuildLeftBarController.OnLeftBarItemCountUpdateListener
{
  final HelperProvider a;
  private final FrameFragment b;
  private View c;
  private DragFrameLayout d;
  private ImmersiveTitleBar2 e;
  private NetStatusInfoView f;
  private GuildMainViewContext g;
  private GuildLeftBarController h;
  private GuildContainerController i;
  private GuildAttachContainerController j;
  private GuildChatFrameGestureManager k;
  private int l;
  private View m;
  
  public GuildMainFrame(FrameFragment paramFrameFragment)
  {
    this.b = paramFrameFragment;
    this.g = new GuildMainViewContext(this);
    this.a = new HelperProvider(this.g);
    this.h = new GuildLeftBarController(this.g, this);
    this.i = new GuildContainerController(this.g);
    this.j = new GuildAttachContainerController(this.g);
    this.k = new GuildChatFrameGestureManager(this.g);
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new GuildMainFrame.1(this, paramString);
      ((IGPSService)this.aF.getRuntimeService(IGPSService.class, "")).addObserver(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("select_member_list")) {
        return;
      }
      paramIntent = paramIntent.getStringArrayExtra("select_member_list");
      if (paramIntent != null)
      {
        if (paramIntent.length < 1) {
          return;
        }
        paramIntent = paramIntent[0];
        try
        {
          Drawable localDrawable = ((IQQGuildAvatarApi)this.aF.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.aF, paramIntent);
          String str = ((IGPSService)this.aF.getRuntimeService(IGPSService.class, "")).getGuildUserNick(paramIntent);
          if (TextUtils.isEmpty(str)) {
            a(paramIntent);
          }
          ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setSelectMember(paramIntent, str, localDrawable);
          return;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.c = paramLayoutInflater.inflate(2131625041, null);
    this.e = ((ImmersiveTitleBar2)this.c.findViewById(2131447582));
    this.f = ((NetStatusInfoView)this.c.findViewById(2131447739));
    this.d = ((DragFrameLayout)this.c.findViewById(2131432160));
    this.m = this.c.findViewById(2131436915);
    b(this.e);
    SimpleUIUtil.a(this.e, P().getWindow());
    paramLayoutInflater = this.k;
    View localView = this.c;
    paramLayoutInflater.a(localView, localView.findViewById(2131430657));
    this.i.a(this.c.findViewById(2131434689));
    this.h.a(this.c.findViewById(2131437137));
    this.j.a(this.c.findViewById(2131430657));
    return this.c;
  }
  
  public Object a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public void a()
  {
    QLog.d("GuildMainFrame", 1, "onCreate: ");
    super.a();
    this.h.f();
    this.i.f();
    this.j.f();
    this.a.f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    b(paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public void a(Bundle paramBundle)
  {
    ((GuildMFJumpHelper)a(GuildMainFrameConstants.c)).a(paramBundle);
  }
  
  public void a(GuildListItemAdapter.ItemCountInfo paramItemCountInfo)
  {
    View localView = this.m;
    int n = paramItemCountInfo.a();
    int i1 = 0;
    if (n == 0) {
      n = 0;
    } else {
      n = 8;
    }
    localView.setVisibility(n);
    boolean bool = ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
    n = i1;
    if (paramItemCountInfo.a(3) == paramItemCountInfo.a()) {
      n = 1;
    }
    if ((n != 0) && (bool)) {
      this.g.a(4, null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("GuildMainFrame", 1, "onResume: ");
    super.a(paramBoolean);
    this.h.a(paramBoolean);
    this.i.a(paramBoolean);
    this.j.a(paramBoolean);
    this.a.a(paramBoolean);
    this.f.a(paramBoolean);
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).adjustTab(this.g.b());
    if (((IGuildInboxRedService)this.g.a().getRuntimeService(IGuildInboxRedService.class, "")).needFetchNoticeRed()) {
      ((IGuildInboxRedService)this.g.a().getRuntimeService(IGuildInboxRedService.class, "")).fetchNoticeRedPoint((AppInterface)this.aF);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.j.e(paramBoolean1);
      return;
    }
    this.j.d(paramBoolean1);
  }
  
  public void b(int paramInt)
  {
    if (QQTheme.isDefaultOrDIYTheme()) {
      a(this.e, true);
    } else {
      a(this.e, false);
    }
    if (paramInt != -1) {
      c(paramInt);
    }
    SimpleUIUtil.a(this.e, P().getWindow());
    q();
  }
  
  public void b(boolean paramBoolean)
  {
    this.h.b(paramBoolean);
    this.i.b(paramBoolean);
    this.j.b(paramBoolean);
    this.a.b(paramBoolean);
  }
  
  public void bQ_()
  {
    QLog.d("GuildMainFrame", 1, "onPause: ");
    super.bQ_();
    this.h.c();
    this.i.c();
    this.j.c();
    this.a.c();
  }
  
  public void bS_()
  {
    QLog.d("GuildMainFrame", 1, "onStart: ");
    super.bS_();
    this.h.b();
    this.i.b();
    this.j.b();
    this.a.b();
  }
  
  public void c()
  {
    QLog.d("GuildMainFrame", 1, "onStop: ");
    super.c();
    this.h.d();
    this.i.d();
    this.j.d();
    this.a.d();
  }
  
  public void c(int paramInt)
  {
    if (paramInt == this.l) {
      return;
    }
    this.l = paramInt;
    View localView = this.c;
    if (localView != null) {
      localView.setPadding(0, 0, 0, 0);
    }
  }
  
  public GuildMainViewContext cw_()
  {
    return this.g;
  }
  
  public void d()
  {
    QLog.d("GuildMainFrame", 1, "onDestroy: ");
    super.d();
    this.h.e();
    this.i.e();
    this.j.e();
    this.a.e();
    this.f.c();
    this.k.a();
  }
  
  public void f()
  {
    super.f();
  }
  
  public AppRuntime g()
  {
    return this.aF;
  }
  
  public boolean h()
  {
    boolean bool1 = this.h.h();
    boolean bool2 = this.i.h();
    boolean bool3 = this.j.h();
    boolean bool4 = this.a.h();
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4)) {
      return super.h();
    }
    return true;
  }
  
  public GuildLeftBarController j()
  {
    return this.h;
  }
  
  public void k()
  {
    super.k();
    this.h.g();
    this.i.g();
    this.j.g();
    this.a.g();
  }
  
  public GuildContainerController l()
  {
    return this.i;
  }
  
  public GuildAttachContainerController m()
  {
    return this.j;
  }
  
  public GuildChatFrameGestureManager n()
  {
    return this.k;
  }
  
  public DragFrameLayout o()
  {
    return this.d;
  }
  
  public FragmentManager p()
  {
    return this.b.getChildFragmentManager();
  }
  
  public void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildMainFrame
 * JD-Core Version:    0.7.0.1
 */