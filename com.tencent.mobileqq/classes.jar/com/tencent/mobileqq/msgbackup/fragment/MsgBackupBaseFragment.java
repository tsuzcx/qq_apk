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
import augd;
import auge;
import augk;
import augo;
import auhc;
import auhi;
import auhp;
import auhq;
import auhr;
import aujh;
import aujp;
import aujq;
import bdgm;
import bdjz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupBaseFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, augk
{
  protected int a;
  public long a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  public TextView a;
  protected auge a;
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
    this.jdField_a_of_type_Auge = new auhp(this);
    this.jdField_b_of_type_JavaLangRunnable = new MsgBackupBaseFragment.3(this);
    this.jdField_c_of_type_JavaLangRunnable = new MsgBackupBaseFragment.6(this);
    this.jdField_e_of_type_Int = 2;
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131375512));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131375507));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370431));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131373908));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370429));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370423));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131370424));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131370428));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370427));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370436));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131373909));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131369775));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131371052));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371051));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131370433));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370432));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370434));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131370435));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131378274));
    this.jdField_c_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131377003));
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
    aujq.b("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      aujp.a("total_transport_cost", null);
      aujp.a();
    }
  }
  
  public void a(long paramLong)
  {
    aujq.b("MsgBackup.MsgBackupBaseFragment", "speedState------> increment = " + paramLong, new Object[0]);
  }
  
  public void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, new Intent(), MsgBackupWelcomeFragment.class);
    if (paramActivity != null)
    {
      paramActivity.setResult(1001);
      paramActivity.finish();
    }
    augo.a().d();
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
  
  public void a(auhc paramauhc) {}
  
  public void a(auhi paramauhi) {}
  
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
      augo.jdField_d_of_type_Boolean = false;
    }
    augo.a = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "transportStart！------------->isStart = " + paramBoolean);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10011);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    aujp.b();
    aujp.a(null, "total_transport_cost");
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
    augo.a().a().c();
    aujh.a().b();
    bdgm.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690432), localFragmentActivity.getString(2131690431), localFragmentActivity.getString(2131690471), localFragmentActivity.getString(2131690470), new auhq(this), new auhr(this)).show();
  }
  
  public void g()
  {
    augo.a().d();
    h();
  }
  
  public int getContentLayoutId()
  {
    return 2131561272;
  }
  
  protected void h()
  {
    if (aujh.a().a() == 2)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      return;
    }
    MsgBackupCompleteFragment.c(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      aujq.a("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
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
    aujq.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackground_Stop), Boolean.valueOf(((QQAppInterface)localObject).isBackground_Pause) });
    if ((((QQAppInterface)localObject).isBackground_Pause) || (((QQAppInterface)localObject).isBackground_Stop))
    {
      aujq.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841131).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
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
    this.jdField_b_of_type_Int = augd.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
 * JD-Core Version:    0.7.0.1
 */