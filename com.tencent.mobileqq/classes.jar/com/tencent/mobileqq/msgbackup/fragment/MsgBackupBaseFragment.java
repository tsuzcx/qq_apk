package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.controller.IMsgBackupUICallback;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupBaseFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, IMsgBackupUICallback
{
  protected int a;
  protected long a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
  protected MsgBackupObserver a;
  protected FormSimpleItem a;
  protected Runnable a;
  protected MqqHandler a;
  protected boolean a;
  protected int b;
  protected long b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected ProgressBar b;
  protected TextView b;
  protected FormSimpleItem b;
  protected Runnable b;
  protected MqqHandler b;
  protected boolean b;
  protected int c;
  protected ImageView c;
  protected LinearLayout c;
  protected ProgressBar c;
  protected TextView c;
  protected Runnable c;
  protected boolean c;
  protected int d;
  protected LinearLayout d;
  protected TextView d;
  protected boolean d;
  public int e;
  protected LinearLayout e;
  protected TextView e;
  
  public MsgBackupBaseFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new MsgBackupBaseFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver = new MsgBackupBaseFragment.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new MsgBackupBaseFragment.3(this);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = new MsgBackupBaseFragment.6(this);
    this.jdField_e_of_type_Int = 2;
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131376783));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131376778));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131371410));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131375128));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131371408));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131371402));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131371403));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131371407));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371406));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371415));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131375129));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131370738));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131372183));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131372182));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131371412));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371411));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371413));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131371414));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131379783));
    this.jdField_c_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131378431));
  }
  
  protected long a()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (localActivityManager != null) {
      localActivityManager.getMemoryInfo(localMemoryInfo);
    }
    return localMemoryInfo.availMem / 1024L;
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      MsgBackupTimeStats.a("total_transport_cost", null);
      MsgBackupTimeStats.a();
    }
  }
  
  public void a(long paramLong)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupBaseFragment", "speedState------> increment = " + paramLong, new Object[0]);
  }
  
  public void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    if (SettingsConfigHelper.a(getActivity().app)) {
      PublicFragmentActivity.a(paramActivity, localIntent, ChatHistorySettingFragment.class);
    }
    for (;;)
    {
      paramActivity.setResult(1001);
      paramActivity.finish();
      MsgBackupManager.a().d();
      return;
      PublicFragmentActivity.a(paramActivity, localIntent, MsgBackupWelcomeFragment.class);
    }
  }
  
  protected void a(TextView paramTextView, String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (paramTextView != null)
      {
        paramTextView.setText(paramString);
        paramTextView.setVisibility(0);
      }
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MsgBackupBaseFragment.7(this, paramTextView, paramString));
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp) {}
  
  protected void a(MsgBackupQryStateRsp paramMsgBackupQryStateRsp) {}
  
  protected void a(Integer paramInteger) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "netConnectionState!!! isConnected = " + paramBoolean);
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b() {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "对端退出了！------------->isExit!!!");
    }
  }
  
  protected void c()
  {
    e();
    if (this.jdField_a_of_type_Int != 4) {
      MsgBackupManager.jdField_d_of_type_Boolean = false;
    }
    MsgBackupManager.jdField_a_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "transportStart！------------->isStart = " + paramBoolean);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10011);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    MsgBackupTimeStats.b();
    MsgBackupTimeStats.a(null, "total_transport_cost");
  }
  
  protected void d() {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    k();
    c();
    d();
    a();
  }
  
  protected void e()
  {
    if (this.jdField_b_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_b_of_type_AndroidWidgetProgressBar.setMax(100);
    }
  }
  
  protected void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    MsgBackupManager.a().a().c();
    MsgBackupTransportProcessor.a().b();
    DialogUtil.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690641), localFragmentActivity.getString(2131690640), localFragmentActivity.getString(2131690673), localFragmentActivity.getString(2131690672), new MsgBackupBaseFragment.4(this), new MsgBackupBaseFragment.5(this)).show();
  }
  
  protected void g()
  {
    MsgBackupManager.a().d();
    h();
  }
  
  public int getContentLayoutId()
  {
    return 2131561594;
  }
  
  protected void h()
  {
    if (MsgBackupTransportProcessor.a().e() == 2)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      return;
    }
    MsgBackupCompleteFragment.c(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      MsgBackupUtil.a("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
    }
    do
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 10009: 
        this.jdField_d_of_type_Boolean = true;
        i();
        return false;
      case 10010: 
        f();
        return false;
      }
    } while (this.jdField_c_of_type_AndroidWidgetProgressBar == null);
    this.jdField_c_of_type_AndroidWidgetProgressBar.setVisibility(8);
    return false;
  }
  
  protected void i() {}
  
  protected void j()
  {
    Object localObject = getActivity().app;
    MsgBackupUtil.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackgroundStop), Boolean.valueOf(((QQAppInterface)localObject).isBackgroundPause) });
    if ((((QQAppInterface)localObject).isBackgroundPause) || (((QQAppInterface)localObject).isBackgroundStop))
    {
      MsgBackupUtil.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841587).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
      localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
      localObject = localBuilder.build();
      QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1000 == paramInt1) && (paramInt2 == 1001))
    {
      if (getActivity() != null) {
        getActivity().setResult(1001);
      }
      onBackEvent();
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper());
    this.jdField_b_of_type_Int = MsgBackupAuthProcessor.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "toPage = " + this.jdField_a_of_type_Int + "; mBizType = " + this.jdField_b_of_type_Int);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
 * JD-Core Version:    0.7.0.1
 */