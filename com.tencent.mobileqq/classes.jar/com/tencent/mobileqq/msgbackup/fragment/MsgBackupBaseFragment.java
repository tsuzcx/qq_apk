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
  protected ImageView A;
  protected ProgressBar B;
  protected LinearLayout C;
  protected TextView D;
  protected ImageView E;
  protected TextView F;
  protected TextView G;
  protected Button H;
  protected MqqHandler I;
  protected MqqHandler J;
  protected int K;
  protected ProgressBar L;
  protected ProgressBar M;
  protected Runnable N = new MsgBackupBaseFragment.1(this);
  protected MsgBackupObserver O = new MsgBackupBaseFragment.2(this);
  protected Runnable P = new MsgBackupBaseFragment.3(this);
  protected long Q = 0L;
  protected int R = 0;
  protected int S = 0;
  protected boolean T = false;
  protected boolean U = false;
  protected long V = 0L;
  protected boolean W = false;
  protected boolean X = false;
  protected Runnable Y = new MsgBackupBaseFragment.6(this);
  public int Z = 2;
  protected int a = -1;
  protected LinearLayout b;
  protected LinearLayout c;
  protected LinearLayout d;
  protected LinearLayout e;
  protected QFormSimpleItem f;
  protected QFormSimpleItem g;
  protected Button w;
  protected ImageView x;
  protected TextView y;
  protected TextView z;
  
  private void t()
  {
    this.f = ((QFormSimpleItem)this.t.findViewById(2131444488));
    this.g = ((QFormSimpleItem)this.t.findViewById(2131444484));
    this.b = ((LinearLayout)this.t.findViewById(2131438371));
    this.c = ((LinearLayout)this.t.findViewById(2131442820));
    this.d = ((LinearLayout)this.t.findViewById(2131438369));
    this.e = ((LinearLayout)this.t.findViewById(2131438363));
    this.w = ((Button)this.t.findViewById(2131438364));
    this.x = ((ImageView)this.t.findViewById(2131438368));
    this.y = ((TextView)this.t.findViewById(2131438367));
    this.z = ((TextView)this.t.findViewById(2131438376));
    this.A = ((ImageView)this.t.findViewById(2131442821));
    this.B = ((ProgressBar)this.t.findViewById(2131437636));
    this.C = ((LinearLayout)this.t.findViewById(2131439197));
    this.D = ((TextView)this.t.findViewById(2131439196));
    this.E = ((ImageView)this.t.findViewById(2131438373));
    this.F = ((TextView)this.t.findViewById(2131438372));
    this.G = ((TextView)this.t.findViewById(2131438374));
    this.H = ((Button)this.t.findViewById(2131438375));
    this.L = ((ProgressBar)this.t.findViewById(2131447849));
    this.M = ((ProgressBar)this.t.findViewById(2131446318));
  }
  
  protected int a()
  {
    return 2131627792;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.U), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).gotoChatHistoryFragment(paramActivity, localIntent);
      paramActivity.setResult(1001);
      paramActivity.finish();
      MsgBackupManager.a().g();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    t();
    d();
    e();
    b();
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
      this.I.post(new MsgBackupBaseFragment.7(this, paramTextView, paramString));
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
    this.W = paramBoolean;
    if (paramBoolean) {
      return;
    }
    this.V = SystemClock.elapsedRealtime();
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b() {}
  
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
    Object localObject = this.I.obtainMessage(10011);
    this.I.sendMessage((Message)localObject);
    MsgBackupTimeStats.b();
    MsgBackupTimeStats.a(null, "total_transport_cost");
  }
  
  protected void d()
  {
    f();
    if (this.a != 4) {
      MsgBackupManager.t = false;
    }
    MsgBackupManager.a = false;
  }
  
  protected void e() {}
  
  protected void f()
  {
    ProgressBar localProgressBar = this.L;
    if (localProgressBar != null) {
      localProgressBar.setMax(100);
    }
  }
  
  protected long g()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (localActivityManager != null) {
      localActivityManager.getMemoryInfo(localMemoryInfo);
    }
    return localMemoryInfo.availMem / 1024L;
  }
  
  protected void h()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      MsgBackupManager.a().d().m();
      MsgBackupTransportProcessor.a().k();
      DialogUtil.a(localFragmentActivity, 0, localFragmentActivity.getString(2131887480), localFragmentActivity.getString(2131887479), localFragmentActivity.getString(2131887512), localFragmentActivity.getString(2131887511), new MsgBackupBaseFragment.4(this), new MsgBackupBaseFragment.5(this)).show();
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
      paramMessage = this.M;
      if (paramMessage != null)
      {
        paramMessage.setVisibility(8);
        return false;
      }
      break;
    case 10010: 
      h();
      return false;
    case 10009: 
      this.X = true;
      r();
    }
    return false;
  }
  
  public void m_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "对端退出了！------------->isExit!!!");
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
    this.I = new MqqHandler(this);
    this.J = new MqqHandler(ThreadManager.getSubThreadLooper());
    this.K = MsgBackupAuthProcessor.a().c();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("toPage = ");
      paramBundle.append(this.a);
      paramBundle.append("; mBizType = ");
      paramBundle.append(this.K);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, paramBundle.toString());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.I.removeCallbacksAndMessages(null);
    this.J.removeCallbacks(this.P);
    this.J.removeCallbacks(this.Y);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected void p()
  {
    MsgBackupManager.a().g();
    q();
  }
  
  protected void q()
  {
    if (MsgBackupTransportProcessor.a().i() == 2)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.R, this.S);
      return;
    }
    MsgBackupCompleteFragment.c(getActivity(), this.R, this.S);
  }
  
  protected void r() {}
  
  protected void s()
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
        NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130842312).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
        localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
        localObject = localBuilder.build();
        QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
 * JD-Core Version:    0.7.0.1
 */