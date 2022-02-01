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
  private static int jdField_a_of_type_Int = -1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  INewFriendService jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService;
  private NewFriendActivity.UiHandler jdField_a_of_type_ComTencentMobileqqNewfriendUiActivityNewFriendActivity$UiHandler;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
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
  
  public AppRuntime a()
  {
    return getAppRuntime();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView = new SystemMsgListView(this, this.mFlingHandler);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView.a(getIntent(), this);
    }
    SystemMsgListView localSystemMsgListView = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
    if (localSystemMsgListView != null)
    {
      localSystemMsgListView.b();
      if (isResume()) {
        this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView.c();
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView);
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiActivityNewFriendActivity$UiHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiActivityNewFriendActivity$UiHandler.removeMessages(1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      ((Animatable)localObject).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_b_of_type_Int);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
  }
  
  void b(int paramInt)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new NewFriendActivity.1(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void d()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiActivityNewFriendActivity$UiHandler.obtainMessage(1, 2131718766, 0);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiActivityNewFriendActivity$UiHandler.sendMessageDelayed(localMessage, 1000L);
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
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView.a(paramInt1, paramInt2, paramIntent);
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiActivityNewFriendActivity$UiHandler = new NewFriendActivity.UiHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService = ((INewFriendService)getAppRuntime().getRuntimeService(INewFriendService.class, ""));
    setContentView(2131561240);
    setContentBackgroundResource(2130838739);
    paramBundle = (LinearLayout)findViewById(2131376809);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368866));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131369233));
    this.c.setVisibility(0);
    this.c.setOnClickListener(this);
    this.c.setText(2131689589);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694443);
    a();
    if (AppSetting.d)
    {
      paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
      paramBundle.setContentDescription(paramBundle.getText());
      paramBundle = this.c;
      paramBundle.setContentDescription(paramBundle.getText());
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131693874));
      localStringBuilder.append(HardCodeUtil.a(2131707528));
      paramBundle.setContentDescription(localStringBuilder.toString());
    }
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getMayKnowRecommendRemoteFromNewFrd((AppInterface)getAppRuntime());
    ((INewFriendVerificationService)getAppRuntime().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedRedPoint(getAppRuntime().getCurrentAccountUin());
    paramBundle = getIntent().getStringExtra("from");
    int j = getIntent().getIntExtra("fromSubType", -1);
    if (("from_lsa".equals(paramBundle)) || ("from_notification".equals(paramBundle)))
    {
      int i = j;
      if (j == -1) {
        i = a();
      }
      if (i == 6) {
        a(getAppRuntime(), "0X800A182");
      } else if ((i == 9) || (i == 10) || (i == 1)) {
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
    SystemMsgListView localSystemMsgListView = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
    if (localSystemMsgListView != null)
    {
      localSystemMsgListView.f();
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    SystemMsgListView localSystemMsgListView = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.d();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SystemMsgListView localSystemMsgListView = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.c();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SystemMsgListView localSystemMsgListView = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.b();
    }
  }
  
  protected void doOnStop()
  {
    SystemMsgListView localSystemMsgListView = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView;
    if (localSystemMsgListView != null) {
      localSystemMsgListView.e();
    }
    super.doOnStop();
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369202)
    {
      finish();
    }
    else
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startAddContactsActivity(this, 3, 221);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.markAllDataReaded();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */