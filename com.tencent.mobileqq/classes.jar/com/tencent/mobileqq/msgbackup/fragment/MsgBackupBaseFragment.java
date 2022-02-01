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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.controller.IMsgBackupUICallback;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupBaseFragment
  extends QIphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, IMsgBackupUICallback
{
  protected int a;
  protected long a;
  protected Button a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected MsgBackupObserver a;
  protected QFormSimpleItem a;
  protected Runnable a;
  protected MqqHandler a;
  protected boolean a;
  protected int b;
  protected long b;
  protected Button b;
  protected LinearLayout b;
  protected ProgressBar b;
  protected QFormSimpleItem b;
  protected Runnable b;
  protected MqqHandler b;
  protected int c;
  protected ImageView c;
  protected LinearLayout c;
  protected ProgressBar c;
  protected Runnable c;
  protected boolean c;
  protected int d;
  protected ImageView d;
  protected LinearLayout d;
  protected boolean d;
  public int e;
  protected ImageView e;
  protected LinearLayout e;
  protected boolean e;
  protected TextView g;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  
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
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = new MsgBackupBaseFragment.6(this);
    this.jdField_e_of_type_Int = 2;
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131376279));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131376275));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131371032));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131374643));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131371030));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131371024));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131371025));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371029));
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371028));
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371037));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374644));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131370374));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131371765));
    this.i = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371764));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371034));
    this.j = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371033));
    this.k = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371035));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131371036));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131379114));
    this.jdField_c_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131377844));
  }
  
  protected int a()
  {
    return 2131561436;
  }
  
  protected long a()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (localActivityManager != null) {
      localActivityManager.getMemoryInfo(localMemoryInfo);
    }
    return localMemoryInfo.availMem / 1024L;
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      MsgBackupTimeStats.a("total_transport_cost", null);
      MsgBackupTimeStats.a();
    }
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("speedState------> increment = ");
    localStringBuilder.append(paramLong);
    MsgBackupUtil.b("MsgBackup.MsgBackupBaseFragment", localStringBuilder.toString(), new Object[0]);
  }
  
  public void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    Object localObject = getQBaseActivity().getAppRuntime();
    if ((localObject instanceof AppInterface))
    {
      localObject = (AppInterface)localObject;
      IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
      if (localIMsgBackupTempApi.getUseNewSettings((AppInterface)localObject)) {
        localIMsgBackupTempApi.gotoChatHistoryFragment(paramActivity, localIntent);
      } else {
        QPublicFragmentActivity.start(paramActivity, localIntent, MsgBackupWelcomeFragment.class);
      }
      paramActivity.setResult(1001);
      paramActivity.finish();
      MsgBackupManager.a().d();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    l();
    d();
    e();
    a();
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
    }
    else {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new MsgBackupBaseFragment.7(this, paramTextView, paramString));
    }
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp) {}
  
  protected void a(MsgBackupQryStateRsp paramMsgBackupQryStateRsp) {}
  
  protected void a(Integer paramInteger) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("netConnectionState!!! isConnected = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  protected void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transportStart！------------->isStart = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10011);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    MsgBackupTimeStats.b();
    MsgBackupTimeStats.a(null, "total_transport_cost");
  }
  
  protected void d()
  {
    f();
    if (this.jdField_a_of_type_Int != 4) {
      MsgBackupManager.jdField_d_of_type_Boolean = false;
    }
    MsgBackupManager.jdField_a_of_type_Boolean = false;
  }
  
  protected void e() {}
  
  protected void f()
  {
    ProgressBar localProgressBar = this.jdField_b_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setMax(100);
    }
  }
  
  protected void g()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      MsgBackupManager.a().a().c();
      MsgBackupTransportProcessor.a().b();
      DialogUtil.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690569), localFragmentActivity.getString(2131690568), localFragmentActivity.getString(2131690601), localFragmentActivity.getString(2131690600), new MsgBackupBaseFragment.4(this), new MsgBackupBaseFragment.5(this)).show();
    }
  }
  
  protected void h()
  {
    MsgBackupManager.a().d();
    i();
  }
  
  public void h_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "对端退出了！------------->isExit!!!");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null)
    {
      MsgBackupUtil.a("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 10011: 
      paramMessage = this.jdField_c_of_type_AndroidWidgetProgressBar;
      if (paramMessage != null)
      {
        paramMessage.setVisibility(8);
        return false;
      }
      break;
    case 10010: 
      g();
      return false;
    case 10009: 
      this.jdField_e_of_type_Boolean = true;
      j();
    }
    return false;
  }
  
  protected void i()
  {
    if (MsgBackupTransportProcessor.a().e() == 2)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      return;
    }
    MsgBackupCompleteFragment.c(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  protected void j() {}
  
  protected void k()
  {
    Object localObject = getQBaseActivity().getAppRuntime();
    if ((localObject instanceof BaseQQAppInterface))
    {
      localObject = (BaseQQAppInterface)localObject;
      MsgBackupUtil.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((BaseQQAppInterface)localObject).isBackgroundStop), Boolean.valueOf(((BaseQQAppInterface)localObject).isBackgroundPause) });
      if ((((BaseQQAppInterface)localObject).isBackgroundPause) || (((BaseQQAppInterface)localObject).isBackgroundStop))
      {
        MsgBackupUtil.a("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
        localObject = null;
        try
        {
          Intent localIntent = new Intent(BaseApplication.getContext(), Class.forName("com.tencent.mobileqq.activity.SplashActivity"));
          localObject = localIntent;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
        }
        ((Intent)localObject).putExtra("param_notifyid", 524);
        localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
        NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841470).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
        localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
        localObject = localBuilder.build();
        QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
      }
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
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("toPage = ");
      paramBundle.append(this.jdField_a_of_type_Int);
      paramBundle.append("; mBizType = ");
      paramBundle.append(this.jdField_b_of_type_Int);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, paramBundle.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
 * JD-Core Version:    0.7.0.1
 */