package com.tencent.mobileqq.newfriend.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class NewFriendActivity
  extends QBaseActivity
  implements View.OnClickListener, BaseNewFriendView.INewFriendContext
{
  private static int g = -1;
  INewFriendService a;
  QQProgressDialog b;
  private FrameLayout c;
  private TextView d;
  private TextView e;
  private TextView f;
  private SystemMsgListView h;
  private Drawable i;
  private Drawable[] j;
  private int k;
  private NewFriendActivity.UiHandler l;
  
  public static int a()
  {
    return g;
  }
  
  public static void a(int paramInt)
  {
    g = paramInt;
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, NewFriendActivity.class);
    localIntent.putExtra("EntranceId", paramInt);
    localIntent.setFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    ThreadManager.excute(new NewFriendActivity.2(paramAppRuntime, paramString), 16, null, false);
  }
  
  public AppRuntime b()
  {
    return getAppRuntime();
  }
  
  void b(int paramInt)
  {
    if ((!isFinishing()) && (this.b == null))
    {
      this.b = new QQProgressDialog(this, getTitleBarHeight());
      this.b.setOnDismissListener(new NewFriendActivity.1(this));
      this.b.c(paramInt);
      this.b.setCanceledOnTouchOutside(false);
      this.b.setCancelable(false);
      this.b.show();
    }
  }
  
  void c()
  {
    if (this.h == null)
    {
      this.h = new SystemMsgListView(this, this.mFlingHandler);
      this.h.a(getIntent(), this);
    }
    SystemMsgListView localSystemMsgListView = this.h;
    if (localSystemMsgListView != null)
    {
      localSystemMsgListView.b();
      if (isResume()) {
        this.h.c();
      }
      this.c.removeAllViews();
      this.c.addView(this.h);
    }
  }
  
  public void d()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      ((Animatable)localObject).stop();
      this.i = null;
      this.d.setCompoundDrawablePadding(this.k);
      localObject = this.d;
      Drawable[] arrayOfDrawable = this.j;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.h.a(paramInt1, paramInt2, paramIntent);
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.l = new NewFriendActivity.UiHandler(this);
    this.a = ((INewFriendService)getAppRuntime().getRuntimeService(INewFriendService.class, ""));
    setContentView(2131627596);
    setContentBackgroundResource(2130838958);
    paramBundle = (LinearLayout)findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.c = ((FrameLayout)findViewById(2131435800));
    this.d = ((TextView)findViewById(2131436227));
    this.e = ((TextView)findViewById(2131436180));
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131436211));
    this.f.setVisibility(0);
    this.f.setOnClickListener(this);
    this.f.setText(2131886199);
    this.d.setText(2131892123);
    c();
    if (AppSetting.e)
    {
      paramBundle = this.d;
      paramBundle.setContentDescription(paramBundle.getText());
      paramBundle = this.f;
      paramBundle.setContentDescription(paramBundle.getText());
      paramBundle = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131891479));
      localStringBuilder.append(HardCodeUtil.a(2131905343));
      paramBundle.setContentDescription(localStringBuilder.toString());
    }
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getMayKnowRecommendRemoteFromNewFrd((AppInterface)getAppRuntime());
    ((INewFriendVerificationService)getAppRuntime().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedRedPoint(getAppRuntime().getCurrentAccountUin());
    paramBundle = getIntent().getStringExtra("from");
    int n = getIntent().getIntExtra("fromSubType", -1);
    if (("from_lsa".equals(paramBundle)) || ("from_notification".equals(paramBundle)))
    {
      int m = n;
      if (n == -1) {
        m = a();
      }
      if (m == 6) {
        a(getAppRuntime(), "0X800A182");
      } else if ((m == 9) || (m == 10) || (m == 1)) {
        a(getAppRuntime(), "0X8009CBC");
      }
    }
    paramBundle = (NewFriendServiceImpl)getAppRuntime().getRuntimeService(INewFriendService.class, "");
    paramBundle.setIsGuideBindReported(false);
    paramBundle.setIsGuidePermissionReported(false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    SystemMsgListView localSystemMsgListView = this.h;
    if (localSystemMsgListView != null)
    {
      localSystemMsgListView.f();
      this.h = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    SystemMsgListView localSystemMsgListView = this.h;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.d();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SystemMsgListView localSystemMsgListView = this.h;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.c();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SystemMsgListView localSystemMsgListView = this.h;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.b();
    }
  }
  
  protected void doOnStop()
  {
    SystemMsgListView localSystemMsgListView = this.h;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.e();
    }
    super.doOnStop();
  }
  
  public void e()
  {
    if (this.i == null)
    {
      this.i = getResources().getDrawable(2130839590);
      this.j = this.d.getCompoundDrawables();
      this.k = this.d.getCompoundDrawablePadding();
      this.d.setCompoundDrawablePadding(10);
      TextView localTextView = this.d;
      Drawable localDrawable = this.i;
      Drawable[] arrayOfDrawable = this.j;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.i).start();
    }
  }
  
  public void f()
  {
    Message localMessage = this.l.obtainMessage(1, 2131916272, 0);
    this.l.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean g()
  {
    boolean bool;
    if (this.l.hasMessages(1))
    {
      this.l.removeMessages(1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    QQProgressDialog localQQProgressDialog = this.b;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.cancel();
      this.b = null;
      bool = true;
    }
    return bool;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436180)
    {
      finish();
    }
    else
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startAddContactsActivity(this, 3, 221);
      this.a.markAllDataReaded();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */