package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import augd;
import augk;
import augo;
import augu;
import auhk;
import auhs;
import auht;
import aujh;
import aujo;
import aujp;
import aujq;
import bdgm;
import bdjz;
import bdoo;
import bexc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class MsgBackupCompleteFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, augk, bexc
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
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
    aujq.a("MsgBackupCompleteFragment", "go is called! isfromMsgTab = %b, auto = %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    Intent localIntent;
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      localIntent = new Intent();
      localIntent.putExtra("import_total_count", paramInt1);
      localIntent.putExtra("import_finish_count", paramInt2);
      localIntent.putExtra("page_type", paramInt3);
      localIntent.putExtra("auto_import_key", paramBoolean1);
      localIntent.putExtra("is_from_pc_handle", paramBoolean3);
      if (paramBoolean2) {
        PublicFragmentActivity.a(paramContext, localIntent, MsgBackupCompleteFragment.class);
      }
    }
    else
    {
      return;
    }
    PublicFragmentActivity.a(paramContext, localIntent, MsgBackupCompleteFragment.class, 1000);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, 3, paramBoolean);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370431);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370429);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370428));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370427));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370436));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370424));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370435));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378997));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131371662));
  }
  
  private void b()
  {
    bdoo.b(this.jdField_a_of_type_AndroidViewView, 8);
    bdoo.b(this.jdField_b_of_type_AndroidViewView, 0);
    bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841018);
    }
    this.vg.setTitle(getString(2131690414));
    this.vg.setLeftBackVisible(8);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
      bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
      this.vg.setTitle(getString(2131690414));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690457);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690458, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
      return;
    case 1: 
      this.vg.setTitle(getString(2131690414));
      bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
      if (this.jdField_b_of_type_Boolean)
      {
        e(0, this.jdField_b_of_type_Int);
        e();
      }
      for (;;)
      {
        this.vg.setOnItemSelectListener(this);
        return;
        bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 0);
        this.vg.setRightButton(2131690654);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690464);
        i = this.jdField_c_of_type_Int;
        j = augo.jdField_a_of_type_Int;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690421, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.jdField_b_of_type_Int) }));
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131690460);
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690460));
        }
        aujo.a("0X800A24B");
      }
    case 2: 
      this.vg.setTitle(getString(2131690414));
      bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
      bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
      i = this.jdField_c_of_type_Int;
      j = augo.jdField_a_of_type_Int;
      aujq.a("MsgBackupCompleteFragment", "TYPE_PHONE_IMPORT_COMPLETE ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(augo.jdField_a_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690461);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690442, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.jdField_b_of_type_Int) }));
      aujo.a("0X800A24F");
      return;
    case 3: 
      this.vg.setTitle(getString(2131690388));
      bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
      bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
      bdoo.b(this.jdField_c_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690451);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690483, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
      this.vg.setOnItemSelectListener(this);
      aujo.a("0X800A262");
      return;
    case 4: 
      this.vg.setTitle(getString(2131690385));
      bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
      if (this.jdField_b_of_type_Boolean)
      {
        this.vg.setRightViewTextVisible(8);
        e(0, this.jdField_b_of_type_Int);
        e();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131690460);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690460));
      }
      bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 0);
      this.vg.setRightButton(2131690654);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690464);
      i = this.jdField_c_of_type_Int;
      j = augo.jdField_a_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690421, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.jdField_b_of_type_Int) }));
      this.vg.setOnItemSelectListener(this);
      return;
    }
    this.vg.setTitle(getString(2131690385));
    bdoo.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    int i = this.jdField_c_of_type_Int;
    int j = augo.jdField_a_of_type_Int;
    aujq.a("MsgBackupCompleteFragment", "TYPE_PC_IMPORT_COMPLETED ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(augo.jdField_a_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690452);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690484, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.jdField_b_of_type_Int) }));
    aujo.a("0X800A286");
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 0, false, true, false);
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      this.vg.setOnItemSelectListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841021);
      String str = getString(2131690459, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (augd.a().a() == 3) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690419);
      }
      for (;;)
      {
        bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
        if ((paramInt2 <= 0) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
          break;
        }
        paramInt1 = paramInt1 * 100 / paramInt2;
        bdoo.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690419);
      }
    }
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2)
  {
    aujq.a("MsgBackupCompleteFragment", "tranfer not auto completed! so display whether import page!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 1, false);
  }
  
  private void d()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_Int = localBundle.getInt("page_type", 0);
    this.jdField_b_of_type_Boolean = localBundle.getBoolean("auto_import_key", false);
    this.jdField_b_of_type_Int = localBundle.getInt("import_total_count", this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = localBundle.getInt("import_finish_count", this.jdField_c_of_type_Int);
    aujo.a();
    aujo.a.c = this.jdField_c_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "handlerArg, page type = " + this.jdField_a_of_type_Int + " ;import total count = " + this.jdField_b_of_type_Int + "; finish count = " + this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 0) {
      aujo.a("0X800A240");
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      this.vg.setOnItemSelectListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841023);
      String str = getString(2131690459, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (augd.a().a() == 3) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690419);
      }
      for (;;)
      {
        bdoo.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
        if ((paramInt2 <= 0) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
          break;
        }
        paramInt1 = paramInt1 * 100 / paramInt2;
        bdoo.b(this.jdField_a_of_type_AndroidWidgetProgressBar, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690419);
      }
    }
  }
  
  public static void d(Context paramContext, int paramInt1, int paramInt2)
  {
    aujq.a("MsgBackupCompleteFragment", "tranfer auto completed! so auto import data!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 1, true, false, false);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "startImport is called!");
    }
    aujp.f = 0L;
    aujp.a(null, "total_daoru_cost");
    this.jdField_a_of_type_Boolean = true;
    this.vg.setRightButton(2131690654);
    Object localObject = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localObject == null) || (((ConcurrentHashMap)localObject).size() == 0)) {
      QQToast.a(getActivity(), "no session to import", 0).a();
    }
    HashSet localHashSet;
    do
    {
      return;
      localHashSet = new HashSet();
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        auhk localauhk = (auhk)((Iterator)localObject).next();
        if (localauhk.jdField_c_of_type_Boolean)
        {
          MsgBackupMsgUserData localMsgBackupMsgUserData = new MsgBackupMsgUserData();
          localMsgBackupMsgUserData.uin = localauhk.jdField_a_of_type_JavaLangString;
          localMsgBackupMsgUserData.uinType = localauhk.jdField_a_of_type_Int;
          localHashSet.add(localMsgBackupMsgUserData);
        }
      }
      if (localHashSet.size() != 0) {
        break;
      }
      aujq.b("MsgBackupCompleteFragment", "no session is completed!--------so jump completed page!", new Object[0]);
      if (this.jdField_a_of_type_Int == 1)
      {
        f(getActivity(), augo.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    h(getActivity(), augo.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    return;
    augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    localObject = new augu();
    ((augu)localObject).jdField_a_of_type_Int = 2;
    ((augu)localObject).jdField_a_of_type_JavaUtilHashSet = localHashSet;
    ((augu)localObject).jdField_b_of_type_Int = localHashSet.size();
    augo.a().a(this);
    augo.a().c((augu)localObject);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "auto import ------> initImportPage!!! finishedCount = " + paramInt1 + ", total" + paramInt2 + ", mPageType = " + this.jdField_a_of_type_Int);
    }
    if (!isDetached())
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public static void e(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 1, true, true, false);
  }
  
  private void f()
  {
    if (getActivity() != null)
    {
      augo.a().d();
      if (getActivity() != null)
      {
        getActivity().setResult(1001);
        getActivity().finish();
      }
    }
  }
  
  public static void f(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 2, false);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int == 1) {
        aujo.a("0X800A252", 5);
      }
      for (;;)
      {
        h();
        return;
        if ((this.jdField_a_of_type_Int == 4) && (this.d)) {
          aujo.a("0X800A266", 2);
        }
      }
    }
    f();
  }
  
  public static void g(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 3, false, true, augo.jdField_c_of_type_Boolean);
  }
  
  private void h()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    bdgm.a(getActivity(), 0, localFragmentActivity.getString(2131690456), localFragmentActivity.getString(2131690455), localFragmentActivity.getString(2131690465), localFragmentActivity.getString(2131690454), new auhs(this), new auht(this)).show();
  }
  
  public static void h(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 5, false);
  }
  
  public static void i(Context paramContext, int paramInt1, int paramInt2)
  {
    aujq.a("MsgBackupCompleteFragment", "restore not auto completed! so display whether import page!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 4, false);
  }
  
  public static void j(Context paramContext, int paramInt1, int paramInt2)
  {
    aujq.a("MsgBackupCompleteFragment", "restore auto completed! so auto import data!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 4, true, false, false);
  }
  
  public static void k(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 4, true, true, false);
  }
  
  protected void a()
  {
    Object localObject = getActivity().app;
    aujq.a("MsgBackupCompleteFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackground_Stop), Boolean.valueOf(((QQAppInterface)localObject).isBackground_Pause) });
    if ((((QQAppInterface)localObject).isBackground_Pause) || (((QQAppInterface)localObject).isBackground_Stop))
    {
      aujq.a("MsgBackupCompleteFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841131).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
      localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
      localObject = localBuilder.build();
      QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(long paramLong) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    g();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "importProgress!!! finishedCount = " + paramInt1 + ", total" + paramInt2 + ", mPageType = " + this.jdField_a_of_type_Int);
    }
    if (!isDetached())
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    if ((this.jdField_a_of_type_Int == 1) && (!this.jdField_c_of_type_Boolean)) {
      if (!this.jdField_b_of_type_Boolean) {
        break label133;
      }
    }
    label133:
    for (paramInt1 = i;; paramInt1 = 1)
    {
      aujo.a("0X800A24E", paramInt1);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      g();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public int getContentLayoutId()
  {
    return 2131561272;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if (i == j)
      {
        aujp.a("total_daoru_cost", null);
        if (this.jdField_a_of_type_Int == 1) {
          f(getActivity(), i, i);
        } else if (this.jdField_a_of_type_Int == 4) {
          h(getActivity(), i, i);
        }
      }
      else if (this.jdField_a_of_type_Int == 1)
      {
        c(i, j);
      }
      else if (this.jdField_a_of_type_Int == 4)
      {
        d(i, j);
      }
    }
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
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click migrate button!");
      }
      e();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click sure btn!");
      }
      f();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click space clean btn!");
      }
      aujo.a("0X800A263");
      augo.a().d();
      paramView = new Intent();
      paramView.putExtra("set_display_type", 1);
      PublicFragmentActivity.a(getActivity(), paramView, QQSettingMsgClearFragment.class);
    } while (getActivity() == null);
    getActivity().setResult(1001);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    augo.a().a(null);
    aujq.a("MsgBackupCompleteFragment", "onDestroyView is from page = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    augo.a().d();
    augo.a().l();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772092);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    augo.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    augo.a().a(getActivity());
  }
  
  public void onStop()
  {
    a();
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
    a(paramView);
    b();
    c();
    aujh.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment
 * JD-Core Version:    0.7.0.1
 */