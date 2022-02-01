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
import avtf;
import avtg;
import avtm;
import avtq;
import avue;
import avuk;
import avur;
import avus;
import avut;
import avwk;
import avwt;
import avwu;
import bfur;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupBaseFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, avtm
{
  protected int a;
  public long a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  public TextView a;
  protected avtg a;
  protected FormSimpleItem a;
  protected Runnable a;
  protected MqqHandler a;
  public boolean a;
  public int b;
  protected long b;
  public Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected ProgressBar b;
  protected TextView b;
  protected FormSimpleItem b;
  protected Runnable b;
  protected MqqHandler b;
  protected boolean b;
  public int c;
  protected ImageView c;
  protected LinearLayout c;
  protected ProgressBar c;
  protected TextView c;
  protected Runnable c;
  protected boolean c;
  public int d;
  protected LinearLayout d;
  protected TextView d;
  public boolean d;
  public int e;
  protected LinearLayout e;
  protected TextView e;
  
  public MsgBackupBaseFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new MsgBackupBaseFragment.1(this);
    this.jdField_a_of_type_Avtg = new avur(this);
    this.jdField_b_of_type_JavaLangRunnable = new MsgBackupBaseFragment.3(this);
    this.jdField_c_of_type_JavaLangRunnable = new MsgBackupBaseFragment.6(this);
    this.jdField_e_of_type_Int = 2;
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131376142));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131376137));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370947));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131374519));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370945));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370939));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131370940));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131370944));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370943));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370952));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131374520));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131370280));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131371689));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371688));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131370949));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370948));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370950));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131370951));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131379064));
    this.jdField_c_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131377729));
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
    avwu.b("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      avwt.a("total_transport_cost", null);
      avwt.a();
    }
  }
  
  public void a(long paramLong)
  {
    avwu.b("MsgBackup.MsgBackupBaseFragment", "speedState------> increment = " + paramLong, new Object[0]);
  }
  
  public void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, new Intent(), MsgBackupWelcomeFragment.class);
    if (paramActivity != null)
    {
      paramActivity.setResult(1001);
      paramActivity.finish();
    }
    avtq.a().d();
  }
  
  public void a(TextView paramTextView, String paramString)
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
  
  public void a(avue paramavue) {}
  
  public void a(avuk paramavuk) {}
  
  public void a(Integer paramInteger) {}
  
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
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
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
      avtq.jdField_d_of_type_Boolean = false;
    }
    avtq.a = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "transportStart！------------->isStart = " + paramBoolean);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10011);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    avwt.b();
    avwt.a(null, "total_transport_cost");
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
    avtq.a().a().c();
    avwk.a().b();
    bfur.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690464), localFragmentActivity.getString(2131690463), localFragmentActivity.getString(2131690496), localFragmentActivity.getString(2131690495), new avus(this), new avut(this)).show();
  }
  
  public void g()
  {
    avtq.a().d();
    h();
  }
  
  public int getContentLayoutId()
  {
    return 2131561422;
  }
  
  protected void h()
  {
    if (avwk.a().e() == 2)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      return;
    }
    MsgBackupCompleteFragment.c(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      avwu.a("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
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
    avwu.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackgroundStop), Boolean.valueOf(((QQAppInterface)localObject).isBackgroundPause) });
    if ((((QQAppInterface)localObject).isBackgroundPause) || (((QQAppInterface)localObject).isBackgroundStop))
    {
      avwu.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841438).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
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
    this.jdField_b_of_type_Int = avtf.a().a();
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