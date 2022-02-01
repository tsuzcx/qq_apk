package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.controller.IMsgBackupUICallback;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class MsgBackupCompleteFragment
  extends QIphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, IMsgBackupUICallback, OnItemSelectListener
{
  private int A = 0;
  private boolean B = false;
  private MqqHandler C;
  private boolean D;
  private boolean E = false;
  private boolean F = false;
  private View a;
  private View b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private Button f;
  private Button g;
  private TextView w;
  private ProgressBar x;
  private int y;
  private int z = 0;
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 0, false);
  }
  
  private static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, false, false, paramBoolean);
  }
  
  private static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MsgBackupUtil.a("MsgBackupCompleteFragment", "go is called! isfromMsgTab = %b, auto = %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      Intent localIntent = new Intent();
      localIntent.putExtra("import_total_count", paramInt1);
      localIntent.putExtra("import_finish_count", paramInt2);
      localIntent.putExtra("page_type", paramInt3);
      localIntent.putExtra("auto_import_key", paramBoolean1);
      localIntent.putExtra("is_from_pc_handle", paramBoolean3);
      if (paramBoolean2)
      {
        QPublicFragmentActivity.start(paramContext, localIntent, MsgBackupCompleteFragment.class);
        return;
      }
      QPublicFragmentActivity.startForResult(paramContext, localIntent, MsgBackupCompleteFragment.class, 1000);
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, 3, paramBoolean);
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 0, false, true, false);
  }
  
  private void b(View paramView)
  {
    this.a = paramView.findViewById(2131438371);
    this.b = paramView.findViewById(2131438369);
    this.c = ((ImageView)paramView.findViewById(2131438368));
    this.d = ((TextView)paramView.findViewById(2131438367));
    this.e = ((TextView)paramView.findViewById(2131438376));
    this.f = ((Button)paramView.findViewById(2131438364));
    this.g = ((Button)paramView.findViewById(2131438375));
    this.w = ((TextView)paramView.findViewById(2131448742));
    this.x = ((ProgressBar)paramView.findViewById(2131439914));
  }
  
  private void c()
  {
    ViewUtils.setVisible(this.a, 8);
    ViewUtils.setVisible(this.b, 0);
    ViewUtils.setVisible(this.f, 8);
    ViewUtils.setVisible(this.g, 0);
    if (!this.D) {
      this.c.setImageResource(2130842141);
    }
    this.p.setTitle(getString(2131887465));
    this.p.setLeftBackVisible(8);
    int i = this.y;
    if (i != 0)
    {
      int j;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              this.p.setTitle(getString(2131887441));
              ViewUtils.setVisible(this.g, 0);
              ViewUtils.setVisible(this.f, 8);
              i = this.A;
              j = MsgBackupManager.g;
              MsgBackupUtil.a("MsgBackupCompleteFragment", "TYPE_PC_IMPORT_COMPLETED ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.A), Integer.valueOf(MsgBackupManager.g) });
              this.d.setText(2131887497);
              this.e.setText(getString(2131887522, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.z) }));
              MsgBackupReporter.a("0X800A286");
              return;
            }
            this.p.setTitle(getString(2131887441));
            ViewUtils.setVisible(this.g, 8);
            if (this.D)
            {
              this.p.setRightViewTextVisible(8);
              e(0, this.z);
              f();
              return;
            }
            this.f.setText(2131887504);
            if (AppSetting.e) {
              this.f.setContentDescription(getString(2131887504));
            }
            ViewUtils.setVisible(this.f, 0);
            this.p.setRightButton(2131887653);
            this.d.setText(2131887506);
            i = this.A;
            j = MsgBackupManager.g;
            this.e.setText(getString(2131887471, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.z) }));
            this.p.setOnItemSelectListener(this);
            return;
          }
          this.p.setTitle(getString(2131887444));
          ViewUtils.setVisible(this.g, 0);
          ViewUtils.setVisible(this.f, 8);
          ViewUtils.setVisible(this.w, 0);
          this.d.setText(2131887496);
          this.e.setText(getString(2131887521, new Object[] { Integer.valueOf(this.A), Integer.valueOf(this.z) }));
          this.p.setOnItemSelectListener(this);
          MsgBackupReporter.a("0X800A262");
          return;
        }
        this.p.setTitle(getString(2131887465));
        ViewUtils.setVisible(this.g, 0);
        ViewUtils.setVisible(this.f, 8);
        i = this.A;
        j = MsgBackupManager.g;
        MsgBackupUtil.a("MsgBackupCompleteFragment", "TYPE_PHONE_IMPORT_COMPLETE ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.A), Integer.valueOf(MsgBackupManager.g) });
        this.d.setText(2131887505);
        this.e.setText(getString(2131887489, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.z) }));
        MsgBackupReporter.a("0X800A24F");
        return;
      }
      this.p.setTitle(getString(2131887465));
      ViewUtils.setVisible(this.g, 8);
      if (this.D)
      {
        e(0, this.z);
        f();
      }
      else
      {
        ViewUtils.setVisible(this.f, 0);
        this.p.setRightButton(2131887653);
        this.d.setText(2131887506);
        i = this.A;
        j = MsgBackupManager.g;
        this.e.setText(getString(2131887471, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.z) }));
        this.f.setText(2131887504);
        if (AppSetting.e) {
          this.f.setContentDescription(getString(2131887504));
        }
        MsgBackupReporter.a("0X800A24B");
      }
      this.p.setOnItemSelectListener(this);
      return;
    }
    ViewUtils.setVisible(this.g, 0);
    ViewUtils.setVisible(this.f, 8);
    this.p.setTitle(getString(2131887465));
    this.d.setText(2131887501);
    this.e.setText(getString(2131887502, new Object[] { Integer.valueOf(this.A), Integer.valueOf(this.z) }));
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    int i;
    if (paramInt1 != paramInt2) {
      i = paramInt1 + 1;
    } else {
      i = paramInt1;
    }
    this.p.setOnItemSelectListener(this);
    this.c.setImageResource(2130842144);
    Object localObject = getString(2131887503, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    this.d.setText((CharSequence)localObject);
    this.e.setText(2131887469);
    ViewUtils.setVisible(this.f, 8);
    if (paramInt2 > 0)
    {
      localObject = this.x;
      if (localObject != null)
      {
        paramInt1 = paramInt1 * 100 / paramInt2;
        ViewUtils.setVisible((View)localObject, 0);
        this.x.setProgress(paramInt1);
      }
    }
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2)
  {
    MsgBackupUtil.a("MsgBackupCompleteFragment", "tranfer not auto completed! so display whether import page!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 1, false);
  }
  
  private void d()
  {
    this.g.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    int i;
    if (paramInt1 != paramInt2) {
      i = paramInt1 + 1;
    } else {
      i = paramInt1;
    }
    this.p.setOnItemSelectListener(this);
    this.c.setImageResource(2130842146);
    Object localObject = getString(2131887503, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    this.d.setText((CharSequence)localObject);
    this.e.setText(2131887469);
    ViewUtils.setVisible(this.f, 8);
    if (paramInt2 > 0)
    {
      localObject = this.x;
      if (localObject != null)
      {
        paramInt1 = paramInt1 * 100 / paramInt2;
        ViewUtils.setVisible((View)localObject, 0);
        this.x.setProgress(paramInt1);
      }
    }
  }
  
  public static void d(Context paramContext, int paramInt1, int paramInt2)
  {
    MsgBackupUtil.a("MsgBackupCompleteFragment", "tranfer auto completed! so auto import data!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 1, true, false, false);
  }
  
  private void e()
  {
    Object localObject = getArguments();
    this.y = ((Bundle)localObject).getInt("page_type", 0);
    this.D = ((Bundle)localObject).getBoolean("auto_import_key", false);
    this.z = ((Bundle)localObject).getInt("import_total_count", this.z);
    this.A = ((Bundle)localObject).getInt("import_finish_count", this.A);
    MsgBackupReporter.a();
    MsgBackupReporter.a.h = this.A;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerArg, page type = ");
      ((StringBuilder)localObject).append(this.y);
      ((StringBuilder)localObject).append(" ;import total count = ");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append("; finish count = ");
      ((StringBuilder)localObject).append(this.A);
      QLog.d("MsgBackupCompleteFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.y == 0) {
      MsgBackupReporter.a("0X800A240");
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("auto import ------> initImportPage!!! finishedCount = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", total");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", mPageType = ");
      ((StringBuilder)localObject).append(this.y);
      QLog.d("MsgBackupCompleteFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!isDetached())
    {
      localObject = this.C.obtainMessage(1);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.C.sendMessage((Message)localObject);
    }
  }
  
  public static void e(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 1, true, true, false);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "startImport is called!");
    }
    MsgBackupTimeStats.i = 0L;
    MsgBackupTimeStats.a(null, "total_daoru_cost");
    this.B = true;
    this.p.setRightButton(2131887653);
    Object localObject = MsgBackupManager.a().k;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
    {
      HashSet localHashSet = new HashSet();
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgBackupSessionInfo localMsgBackupSessionInfo = (MsgBackupSessionInfo)((Iterator)localObject).next();
        if (localMsgBackupSessionInfo.g)
        {
          MsgBackupMsgUserData localMsgBackupMsgUserData = new MsgBackupMsgUserData();
          localMsgBackupMsgUserData.uin = localMsgBackupSessionInfo.a;
          localMsgBackupMsgUserData.uinType = localMsgBackupSessionInfo.b;
          localHashSet.add(localMsgBackupMsgUserData);
        }
      }
      if (localHashSet.size() == 0)
      {
        MsgBackupUtil.b("MsgBackupCompleteFragment", "no session is completed!--------so jump completed page!", new Object[0]);
        int i = this.y;
        if (i == 1)
        {
          f(getActivity(), MsgBackupManager.i, this.A);
          return;
        }
        if (i == 4) {
          h(getActivity(), MsgBackupManager.i, this.A);
        }
        return;
      }
      MsgBackupManager.a().k.clear();
      localObject = new MsgBackupRequest();
      ((MsgBackupRequest)localObject).b = 2;
      ((MsgBackupRequest)localObject).a = localHashSet;
      ((MsgBackupRequest)localObject).f = localHashSet.size();
      MsgBackupManager.a().a(this);
      MsgBackupManager.a().c((MsgBackupRequest)localObject);
      return;
    }
    QQToast.makeText(getActivity(), "no session to import", 0).show();
  }
  
  public static void f(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 2, false);
  }
  
  private void g()
  {
    if (getActivity() != null)
    {
      MsgBackupManager.a().g();
      if (getActivity() != null)
      {
        getActivity().setResult(1001);
        getActivity().finish();
      }
    }
  }
  
  public static void g(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 3, false, true, MsgBackupManager.s);
  }
  
  private void h()
  {
    if (this.B)
    {
      int i = this.y;
      if (i == 1) {
        MsgBackupReporter.a("0X800A252", 5);
      } else if ((i == 4) && (this.F)) {
        MsgBackupReporter.a("0X800A266", 2);
      }
      p();
      return;
    }
    g();
  }
  
  public static void h(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 5, false);
  }
  
  public static void i(Context paramContext, int paramInt1, int paramInt2)
  {
    MsgBackupUtil.a("MsgBackupCompleteFragment", "restore not auto completed! so display whether import page!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 4, false);
  }
  
  public static void j(Context paramContext, int paramInt1, int paramInt2)
  {
    MsgBackupUtil.a("MsgBackupCompleteFragment", "restore auto completed! so auto import data!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 4, true, false, false);
  }
  
  public static void k(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 4, true, true, false);
  }
  
  private void p()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    DialogUtil.a(getActivity(), 0, localFragmentActivity.getString(2131887500), localFragmentActivity.getString(2131887499), localFragmentActivity.getString(2131887507), localFragmentActivity.getString(2131887498), new MsgBackupCompleteFragment.1(this), new MsgBackupCompleteFragment.2(this)).show();
  }
  
  protected int a()
  {
    return 2131627792;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void b()
  {
    Object localObject = getQBaseActivity().getAppRuntime();
    if ((localObject instanceof BaseQQAppInterface))
    {
      localObject = (BaseQQAppInterface)localObject;
      MsgBackupUtil.a("MsgBackupCompleteFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((BaseQQAppInterface)localObject).isBackgroundStop), Boolean.valueOf(((BaseQQAppInterface)localObject).isBackgroundPause) });
      if ((((BaseQQAppInterface)localObject).isBackgroundPause) || (((BaseQQAppInterface)localObject).isBackgroundStop))
      {
        MsgBackupUtil.a("MsgBackupCompleteFragment", "fight notification start ....", new Object[0]);
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
  
  public void b(int paramInt1, int paramInt2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("importProgress!!! finishedCount = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", total");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", mPageType = ");
      ((StringBuilder)localObject).append(this.y);
      QLog.d("MsgBackupCompleteFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!isDetached())
    {
      localObject = this.C.obtainMessage(1);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.C.sendMessage((Message)localObject);
    }
    if ((this.y == 1) && (!this.E))
    {
      if (this.D) {
        paramInt1 = i;
      } else {
        paramInt1 = 1;
      }
      MsgBackupReporter.a("0X800A24E", paramInt1);
      this.E = true;
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      h();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if (i == j)
      {
        MsgBackupTimeStats.a("total_daoru_cost", null);
        j = this.y;
        if (j == 1) {
          f(getActivity(), i, i);
        } else if (j == 4) {
          h(getActivity(), i, i);
        }
      }
      else
      {
        int k = this.y;
        if (k == 1) {
          c(i, j);
        } else if (k == 4) {
          d(i, j);
        }
      }
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void m_(boolean paramBoolean) {}
  
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
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131438364)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click migrate button!");
      }
      f();
    }
    else if (i == 2131438375)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click sure btn!");
      }
      g();
    }
    else if (i == 2131448742)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click space clean btn!");
      }
      MsgBackupReporter.a("0X800A263");
      MsgBackupManager.a().g();
      Intent localIntent = new Intent();
      localIntent.putExtra("set_display_type", 1);
      ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).gotoQQSettingMsgClearFragment(getActivity(), localIntent);
      if (getActivity() != null)
      {
        getActivity().setResult(1001);
        getActivity().finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.C = new MqqHandler(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    MsgBackupManager.a().a(null);
    MsgBackupUtil.a("MsgBackupCompleteFragment", "onDestroyView is from page = %d", new Object[] { Integer.valueOf(this.y) });
    MsgBackupManager.a().g();
    MsgBackupManager.a().p();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772188);
    }
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    h();
  }
  
  public void onPause()
  {
    super.onPause();
    MsgBackupManager.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    MsgBackupManager.a().a(getActivity());
  }
  
  public void onStop()
  {
    b();
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    b(paramView);
    c();
    d();
    MsgBackupTransportProcessor.a().k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment
 * JD-Core Version:    0.7.0.1
 */