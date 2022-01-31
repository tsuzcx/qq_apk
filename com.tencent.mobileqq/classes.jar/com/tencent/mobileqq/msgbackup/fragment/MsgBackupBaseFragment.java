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
import askt;
import asku;
import asla;
import asle;
import asls;
import asly;
import asmf;
import asmg;
import asmh;
import asnx;
import asof;
import asog;
import bbcv;
import bbgg;
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
  implements Handler.Callback, View.OnClickListener, asla
{
  protected int a;
  public long a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  public TextView a;
  protected asku a;
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
    this.jdField_a_of_type_Asku = new asmf(this);
    this.jdField_b_of_type_JavaLangRunnable = new MsgBackupBaseFragment.3(this);
    this.jdField_c_of_type_JavaLangRunnable = new MsgBackupBaseFragment.6(this);
    this.jdField_e_of_type_Int = 2;
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131374989));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131374984));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370147));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131373406));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370145));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370139));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131370140));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131370144));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370143));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370152));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131373407));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131369495));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370722));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370721));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131370149));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370148));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370150));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131370151));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131377679));
    this.jdField_c_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.mContentView.findViewById(2131376447));
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
    asog.b("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      asof.a("total_transport_cost", null);
      asof.a();
    }
  }
  
  public void a(long paramLong)
  {
    asog.b("MsgBackup.MsgBackupBaseFragment", "speedState------> increment = " + paramLong, new Object[0]);
  }
  
  public void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, new Intent(), MsgBackupWelcomeFragment.class);
    if (paramActivity != null)
    {
      paramActivity.setResult(1001);
      paramActivity.finish();
    }
    asle.a().d();
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
  
  public void a(asls paramasls) {}
  
  public void a(asly paramasly) {}
  
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
      asle.jdField_d_of_type_Boolean = false;
    }
    asle.a = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "transportStart！------------->isStart = " + paramBoolean);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10011);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    asof.b();
    asof.a(null, "total_transport_cost");
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
    asle.a().a().c();
    asnx.a().b();
    bbcv.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690381), localFragmentActivity.getString(2131690380), localFragmentActivity.getString(2131690420), localFragmentActivity.getString(2131690419), new asmg(this), new asmh(this)).show();
  }
  
  public void g()
  {
    asle.a().d();
    h();
  }
  
  public int getContentLayoutId()
  {
    return 2131561068;
  }
  
  protected void h()
  {
    if (asnx.a().a() == 2)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      return;
    }
    MsgBackupCompleteFragment.c(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      asog.a("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
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
    asog.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackground_Stop), Boolean.valueOf(((QQAppInterface)localObject).isBackground_Pause) });
    if ((((QQAppInterface)localObject).isBackground_Pause) || (((QQAppInterface)localObject).isBackground_Stop))
    {
      asog.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841015).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
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
    this.jdField_b_of_type_Int = askt.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
 * JD-Core Version:    0.7.0.1
 */