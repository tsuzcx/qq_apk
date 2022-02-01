package com.tencent.mobileqq.guild.window;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveLauncher;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.LiveRoomEventListener;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IContainerBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class GuildLiveChannelFloatWrapper
  extends FloatingBaseProxyWrapper
  implements IGuildFloatWindowWrapper, IContainerBackPressListener
{
  public static final int FLOAT_WINDOW_DEFAULT_SIZE = 211;
  public static final float FLOAT_WINDOW_SIZE_SCALE = 1.777778F;
  public static final int GUILD_LIVE_ORIENTATION_HORIZONTAL = 2;
  public static final int GUILD_LIVE_ORIENTATION_VERTICAL = 1;
  public static final String TAG = "com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper";
  private ImageView a;
  private View b;
  private FrameLayout c;
  private TextView d;
  private int e = -1;
  private int f = -1;
  private int g = 0;
  private IGProGuildInfo h;
  private IGProChannelInfo i;
  private Observer<View> j;
  private Observer<Boolean> k;
  private LiveRoomEventListener l;
  private boolean m = false;
  public IFullScreenViewClickListener mFullScreenViewClickListener;
  
  public GuildLiveChannelFloatWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  private void B()
  {
    QLog.i(TAG, 1, "quitWindowFloat:");
    View localView = this.b;
    if (localView == null) {
      return;
    }
    b(localView);
    localView = this.b.findViewById(2131434670);
    if (localView != null)
    {
      b(localView);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localView.setOutlineProvider(null);
        localView.setClipToOutline(false);
      }
    }
    this.b = null;
  }
  
  private void C()
  {
    g(true);
    GuildFloatWindowManager.a.a(GuildLiveChannelFloatWrapper.class.getName());
    if ((this.h != null) && (this.i != null))
    {
      QQGuildLiveLauncher.a(QQGuildLiveStartParamsCache.a(), null, true, null);
      return;
    }
    QLog.i(TAG, 1, "openGuildLiveChannel: guild info or channel info is null.");
  }
  
  private void D()
  {
    A();
    b(1.0F);
    this.g = 0;
  }
  
  private void E()
  {
    if (n()) {
      return;
    }
    if (m() == null) {}
  }
  
  private void F()
  {
    if (this.j == null) {
      this.j = new GuildLiveChannelFloatWrapper.2(this);
    }
    if (this.k == null) {
      this.k = new GuildLiveChannelFloatWrapper.3(this);
    }
    if (this.l == null) {
      this.l = new GuildLiveChannelFloatWrapper.4(this);
    }
    QQGuildLiveRoomUiData.a().d().observeForever(this.j);
    QQGuildLiveRoomUiData.a().e().observeForever(this.k);
    QQGuildLiveEventHelper.a().a(this.l);
  }
  
  private void G()
  {
    if (this.j != null)
    {
      QQGuildLiveRoomUiData.a().d().removeObserver(this.j);
      this.j = null;
    }
    if (this.k != null)
    {
      QQGuildLiveRoomUiData.a().e().removeObserver(this.k);
      this.k = null;
    }
    if (this.l != null)
    {
      QQGuildLiveEventHelper.a().b(this.l);
      this.l = null;
    }
  }
  
  private void H()
  {
    QLog.e(TAG, 1, "showDefaultNoLive: ");
    Object localObject1 = this.b;
    if (localObject1 == null) {
      return;
    }
    ((ViewGroup)localObject1).removeAllViews();
    Object localObject2 = (TextView)this.b.findViewById(2131434633);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TextView(this.b.getContext());
      ((TextView)localObject1).setId(2131434633);
    }
    ((TextView)localObject1).setText(HardCodeUtil.a(2131890465));
    ((TextView)localObject1).setTextColor(-1);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    ((ViewGroup)this.b).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
  }
  
  private void I()
  {
    QLog.e(TAG, 1, "resetFloatWindow: ");
    if (!h())
    {
      QLog.e(TAG, 1, "resetFloatWindow: has not zoomed, return.");
      return;
    }
    g();
    int n = ViewUtils.dip2px(211.0F);
    c(n, (int)(n / 1.777778F));
    b(1);
    g();
    u();
    this.c = b(m());
    FrameLayout localFrameLayout = new FrameLayout(m());
    localFrameLayout.setId(2131434627);
    localFrameLayout.setBackgroundColor(-16777216);
    a(localFrameLayout);
  }
  
  private void J()
  {
    g(true);
    if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue())
    {
      if (e())
      {
        K();
        return;
      }
      g(false);
      return;
    }
    L();
    g(false);
  }
  
  private void K()
  {
    Object localObject = BaseApplication.getContext();
    Activity localActivity = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
    if (localObject != null)
    {
      if (localActivity == null) {
        return;
      }
      localObject = DialogUtil.a(localActivity, 230, null, ((Context)localObject).getString(2131890431), ((Context)localObject).getString(2131890432), ((Context)localObject).getString(2131890433), new GuildLiveChannelFloatWrapper.6(this), new GuildLiveChannelFloatWrapper.7(this));
      ((QQCustomDialog)localObject).setOnDismissListener(new GuildLiveChannelFloatWrapper.8(this));
      ((QQCustomDialog)localObject).show();
    }
  }
  
  private void L()
  {
    QQGuildLiveRoomCommMgr.a().e();
    GuildFloatWindowManager.a.a(GuildLiveChannelFloatWrapper.class.getName());
    FloatingScreenReporter.d();
  }
  
  private FrameLayout b(Context paramContext)
  {
    paramContext = new FrameLayout(paramContext);
    paramContext.setBackgroundResource(2130840925);
    int n = ViewUtils.dip2px(5.0F);
    paramContext.setPadding(n, n, n, n);
    return paramContext;
  }
  
  private void c(View paramView)
  {
    if (paramView != null)
    {
      d(paramView);
      return;
    }
    I();
    H();
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      GuildFloatWindowManager.a.a(GuildLiveChannelFloatWrapper.class.getName());
      return;
    }
    Activity localActivity = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
    if (localActivity == null)
    {
      QLog.e(TAG, 1, "getCurrentTopActivity null.");
      GuildFloatWindowManager.a.a(GuildLiveChannelFloatWrapper.class.getName());
      return;
    }
    DialogUtil.a(localActivity, 230, null, paramString, null, HardCodeUtil.a(2131890251), new GuildLiveChannelFloatWrapper.5(this), null).show();
  }
  
  private void d(View paramView)
  {
    QLog.e(TAG, 1, "addAndShowLiveView:");
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((ViewGroup)localObject).removeAllViews();
    b(paramView);
    paramView.setId(2131434670);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((ViewGroup)this.b).addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void f(boolean paramBoolean)
  {
    String str = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleLiveOrientationChanged: isLand[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    int n = 1;
    QLog.e(str, 1, (String)localObject);
    if (!paramBoolean) {
      n = 2;
    }
    if (i() != n)
    {
      g();
      b(n);
      g();
    }
  }
  
  private void g(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      View localView = this.b;
      if (localView != null)
      {
        localView.setOutlineProvider(new GuildLiveChannelFloatWrapper.FloatingOutlineProvider(this, paramInt));
        this.b.setClipToOutline(true);
      }
      localView = this.b.findViewById(2131434670);
      if (localView != null)
      {
        localView.setOutlineProvider(new GuildLiveChannelFloatWrapper.FloatingOutlineProvider(this, paramInt));
        localView.setClipToOutline(true);
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    QLog.i(TAG, 1, "enterWindowFloat:");
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int n = localSharedPreferences.getInt("qqfs_floating_center_x", -2147483648);
    int i1 = localSharedPreferences.getInt("qqfs_floating_center_y", -2147483648);
    if ((n != -2147483648) && (i1 != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(n);
      paramFloatingScreenParams.setFloatingCenterY(i1);
    }
    n = super.a(paramFloatingScreenParams, paramView);
    FloatingScreenReporter.a();
    if ((n == 0) && (paramFloatingScreenParams != null) && (paramFloatingScreenParams.getCanZoom())) {
      d();
    }
    F();
    return n;
  }
  
  public void a(int paramInt)
  {
    QLog.i(TAG, 1, "quitWindowFloat:");
    if ((!n()) && (o())) {
      ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).saveFloatingCenter(q(), r());
    }
    B();
    G();
    g(false);
    super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(2130840809);
    paramInt1 = ViewUtils.dip2px(12.0F);
    super.a(paramInt1, paramInt1);
    g(paramInt1);
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    a(this);
    this.a = ((ImageView)d(2131442568));
    this.d = ((TextView)d(2131442570));
    this.d.setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.topMargin += ViewUtils.dip2px(8.0F);
    localLayoutParams.rightMargin += ViewUtils.dip2px(8.0F);
    this.a.setLayoutParams(localLayoutParams);
    this.c = b(paramContext);
  }
  
  public void a(View paramView)
  {
    QLog.i(TAG, 1, "initWidgetWrapper:");
    View localView = this.b;
    if (localView != null) {
      b(localView);
    }
    this.b = paramView;
    paramView = new FrameLayout.LayoutParams(-1, -1);
    int n = ViewUtils.dip2px(1.0F);
    paramView.setMargins(n, n, n, n);
    this.c.addView(this.b, paramView);
    u();
    b(this.c);
    paramView = new FrameLayout.LayoutParams(-1, -1);
    a(this.c, paramView);
    t();
    a(new FrameLayout.LayoutParams(-1, -1));
    if (this.c.findViewById(2131434670) == null) {
      H();
    }
    g(ViewUtils.dip2px(12.0F));
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener) {}
  
  public void a(IFullScreenViewClickListener paramIFullScreenViewClickListener)
  {
    this.mFullScreenViewClickListener = paramIFullScreenViewClickListener;
  }
  
  public void a(IWindowClickListener paramIWindowClickListener)
  {
    super.a(paramIWindowClickListener);
  }
  
  public void a(IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo)
  {
    this.h = paramIGProGuildInfo;
    this.i = paramIGProChannelInfo;
  }
  
  public IGProChannelInfo b()
  {
    return this.i;
  }
  
  public void c()
  {
    a(3);
    FloatingScreenReporter.g();
  }
  
  public void d()
  {
    Context localContext = m();
    if (localContext == null) {
      return;
    }
    if (!((Boolean)BaseSharedPreUtil.a(localContext, "", "key_float_video_has_show_tips", Boolean.valueOf(false))).booleanValue())
    {
      a(true, new View[] { this.d });
      BaseSharedPreUtil.a(localContext, "", true, "key_float_video_has_show_tips", Boolean.valueOf(true));
      ThreadManager.getUIHandler().postDelayed(new GuildLiveChannelFloatWrapper.1(this), 3000L);
    }
  }
  
  public void dz_()
  {
    a(true);
    b(true);
    D();
    E();
  }
  
  public boolean e()
  {
    boolean bool = GuildFloatWindowManager.a.a();
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndForegroundApp: app foreground[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    if (!bool)
    {
      localObject = MobileQQ.getContext();
      ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab((Context)localObject, 0, new Bundle());
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (this.m)
    {
      QLog.i(TAG, 1, "onClick: action processing.");
    }
    else
    {
      int n = paramView.getId();
      if (n == 2131442568) {
        J();
      } else if (n == 2131442576) {
        C();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper
 * JD-Core Version:    0.7.0.1
 */