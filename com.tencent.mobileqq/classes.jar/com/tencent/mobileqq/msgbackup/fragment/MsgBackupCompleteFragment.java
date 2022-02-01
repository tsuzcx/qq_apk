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
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private TextView g;
  private TextView h;
  private TextView i;
  
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
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371032);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371030);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371029));
    this.g = ((TextView)paramView.findViewById(2131371028));
    this.h = ((TextView)paramView.findViewById(2131371037));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371025));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371036));
    this.i = ((TextView)paramView.findViewById(2131379875));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131372394));
  }
  
  private void c()
  {
    ViewUtils.b(this.jdField_c_of_type_AndroidViewView, 8);
    ViewUtils.b(this.jdField_d_of_type_AndroidViewView, 0);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841340);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690554));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftBackVisible(8);
    int j = this.jdField_a_of_type_Int;
    if (j != 0)
    {
      int k;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5) {
                return;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690530));
              ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
              ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
              j = this.jdField_c_of_type_Int;
              k = MsgBackupManager.jdField_a_of_type_Int;
              MsgBackupUtil.a("MsgBackupCompleteFragment", "TYPE_PC_IMPORT_COMPLETED ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(MsgBackupManager.jdField_a_of_type_Int) });
              this.g.setText(2131690586);
              this.h.setText(getString(2131690611, new Object[] { Integer.valueOf(j - k), Integer.valueOf(this.jdField_b_of_type_Int) }));
              MsgBackupReporter.a("0X800A286");
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690530));
            ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightViewTextVisible(8);
              e(0, this.jdField_b_of_type_Int);
              f();
              return;
            }
            this.jdField_a_of_type_AndroidWidgetButton.setText(2131690593);
            if (AppSetting.jdField_d_of_type_Boolean) {
              this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690593));
            }
            ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 0);
            this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightButton(2131690733);
            this.g.setText(2131690595);
            j = this.jdField_c_of_type_Int;
            k = MsgBackupManager.jdField_a_of_type_Int;
            this.h.setText(getString(2131690560, new Object[] { Integer.valueOf(j - k), Integer.valueOf(this.jdField_b_of_type_Int) }));
            this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690533));
          ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
          ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
          ViewUtils.b(this.i, 0);
          this.g.setText(2131690585);
          this.h.setText(getString(2131690610, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
          MsgBackupReporter.a("0X800A262");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690554));
        ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
        ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
        j = this.jdField_c_of_type_Int;
        k = MsgBackupManager.jdField_a_of_type_Int;
        MsgBackupUtil.a("MsgBackupCompleteFragment", "TYPE_PHONE_IMPORT_COMPLETE ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(MsgBackupManager.jdField_a_of_type_Int) });
        this.g.setText(2131690594);
        this.h.setText(getString(2131690578, new Object[] { Integer.valueOf(j - k), Integer.valueOf(this.jdField_b_of_type_Int) }));
        MsgBackupReporter.a("0X800A24F");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690554));
      ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
      if (this.jdField_c_of_type_Boolean)
      {
        e(0, this.jdField_b_of_type_Int);
        f();
      }
      else
      {
        ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightButton(2131690733);
        this.g.setText(2131690595);
        j = this.jdField_c_of_type_Int;
        k = MsgBackupManager.jdField_a_of_type_Int;
        this.h.setText(getString(2131690560, new Object[] { Integer.valueOf(j - k), Integer.valueOf(this.jdField_b_of_type_Int) }));
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131690593);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690593));
        }
        MsgBackupReporter.a("0X800A24B");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
      return;
    }
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131690554));
    this.g.setText(2131690590);
    this.h.setText(getString(2131690591, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    int j;
    if (paramInt1 != paramInt2) {
      j = paramInt1 + 1;
    } else {
      j = paramInt1;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841343);
    Object localObject = getString(2131690592, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
    this.g.setText((CharSequence)localObject);
    this.h.setText(2131690558);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    if (paramInt2 > 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject != null)
      {
        paramInt1 = paramInt1 * 100 / paramInt2;
        ViewUtils.b((View)localObject, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
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
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    int j;
    if (paramInt1 != paramInt2) {
      j = paramInt1 + 1;
    } else {
      j = paramInt1;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841345);
    Object localObject = getString(2131690592, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
    this.g.setText((CharSequence)localObject);
    this.h.setText(2131690558);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    if (paramInt2 > 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject != null)
      {
        paramInt1 = paramInt1 * 100 / paramInt2;
        ViewUtils.b((View)localObject, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
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
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("page_type", 0);
    this.jdField_c_of_type_Boolean = ((Bundle)localObject).getBoolean("auto_import_key", false);
    this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("import_total_count", this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = ((Bundle)localObject).getInt("import_finish_count", this.jdField_c_of_type_Int);
    MsgBackupReporter.a();
    MsgBackupReporter.a.c = this.jdField_c_of_type_Int;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerArg, page type = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" ;import total count = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("; finish count = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("MsgBackupCompleteFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int == 0) {
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MsgBackupCompleteFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!isDetached())
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
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
    MsgBackupTimeStats.f = 0L;
    MsgBackupTimeStats.a(null, "total_daoru_cost");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightButton(2131690733);
    Object localObject = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
    {
      HashSet localHashSet = new HashSet();
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgBackupSessionInfo localMsgBackupSessionInfo = (MsgBackupSessionInfo)((Iterator)localObject).next();
        if (localMsgBackupSessionInfo.jdField_c_of_type_Boolean)
        {
          MsgBackupMsgUserData localMsgBackupMsgUserData = new MsgBackupMsgUserData();
          localMsgBackupMsgUserData.uin = localMsgBackupSessionInfo.jdField_a_of_type_JavaLangString;
          localMsgBackupMsgUserData.uinType = localMsgBackupSessionInfo.jdField_a_of_type_Int;
          localHashSet.add(localMsgBackupMsgUserData);
        }
      }
      if (localHashSet.size() == 0)
      {
        MsgBackupUtil.b("MsgBackupCompleteFragment", "no session is completed!--------so jump completed page!", new Object[0]);
        int j = this.jdField_a_of_type_Int;
        if (j == 1)
        {
          f(getActivity(), MsgBackupManager.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
          return;
        }
        if (j == 4) {
          h(getActivity(), MsgBackupManager.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        }
        return;
      }
      MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      localObject = new MsgBackupRequest();
      ((MsgBackupRequest)localObject).jdField_a_of_type_Int = 2;
      ((MsgBackupRequest)localObject).jdField_a_of_type_JavaUtilHashSet = localHashSet;
      ((MsgBackupRequest)localObject).jdField_b_of_type_Int = localHashSet.size();
      MsgBackupManager.a().a(this);
      MsgBackupManager.a().c((MsgBackupRequest)localObject);
      return;
    }
    QQToast.a(getActivity(), "no session to import", 0).a();
  }
  
  public static void f(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 2, false);
  }
  
  private void g()
  {
    if (getActivity() != null)
    {
      MsgBackupManager.a().d();
      if (getActivity() != null)
      {
        getActivity().setResult(1001);
        getActivity().finish();
      }
    }
  }
  
  public static void g(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 3, false, true, MsgBackupManager.jdField_c_of_type_Boolean);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int j = this.jdField_a_of_type_Int;
      if (j == 1) {
        MsgBackupReporter.a("0X800A252", 5);
      } else if ((j == 4) && (this.e)) {
        MsgBackupReporter.a("0X800A266", 2);
      }
      i();
      return;
    }
    g();
  }
  
  public static void h(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 5, false);
  }
  
  private void i()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    DialogUtil.a(getActivity(), 0, localFragmentActivity.getString(2131690589), localFragmentActivity.getString(2131690588), localFragmentActivity.getString(2131690596), localFragmentActivity.getString(2131690587), new MsgBackupCompleteFragment.1(this), new MsgBackupCompleteFragment.2(this)).show();
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
  
  protected int a()
  {
    return 2131561436;
  }
  
  protected void a()
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
        NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841470).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
        localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
        localObject = localBuilder.build();
        QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("importProgress!!! finishedCount = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", total");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", mPageType = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MsgBackupCompleteFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!isDetached())
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
    if ((this.jdField_a_of_type_Int == 1) && (!this.jdField_d_of_type_Boolean))
    {
      if (this.jdField_c_of_type_Boolean) {
        paramInt1 = j;
      } else {
        paramInt1 = 1;
      }
      MsgBackupReporter.a("0X800A24E", paramInt1);
      this.jdField_d_of_type_Boolean = true;
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
  
  public void h_(boolean paramBoolean) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      int j = paramMessage.arg1;
      int k = paramMessage.arg2;
      if (j == k)
      {
        MsgBackupTimeStats.a("total_daoru_cost", null);
        k = this.jdField_a_of_type_Int;
        if (k == 1) {
          f(getActivity(), j, j);
        } else if (k == 4) {
          h(getActivity(), j, j);
        }
      }
      else
      {
        int m = this.jdField_a_of_type_Int;
        if (m == 1) {
          c(j, k);
        } else if (m == 4) {
          d(j, k);
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
    int j = paramView.getId();
    if (j == 2131371025)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click migrate button!");
      }
      f();
    }
    else if (j == 2131371036)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click sure btn!");
      }
      g();
    }
    else if (j == 2131379875)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click space clean btn!");
      }
      MsgBackupReporter.a("0X800A263");
      MsgBackupManager.a().d();
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
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    MsgBackupManager.a().a(null);
    MsgBackupUtil.a("MsgBackupCompleteFragment", "onDestroyView is from page = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    MsgBackupManager.a().d();
    MsgBackupManager.a().l();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772142);
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
    a();
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    b(paramView);
    c();
    d();
    MsgBackupTransportProcessor.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment
 * JD-Core Version:    0.7.0.1
 */