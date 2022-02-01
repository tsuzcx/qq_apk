package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public class JoinTroopUtil
  extends QQProgressDialog
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private JoinTroopUtil.JoinTroopCallback jdField_a_of_type_ComTencentMobileqqTroopActivityJoinTroopUtil$JoinTroopCallback;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  private volatile boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  private JoinTroopUtil(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, int paramInt, String paramString3, String paramString4, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    super(paramContext);
    a(paramContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, paramString1, paramString2, paramInt, paramString3, paramString4, paramJoinTroopCallback);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "registerObserver");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION"));
    setOnDismissListener(new JoinTroopUtil.3(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JoinTroopUtil.4(this), 15000L);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, a(), 0, paramInt2);
  }
  
  private void a(@NonNull Context paramContext, @NonNull TroopInfoData paramTroopInfoData, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityJoinTroopUtil$JoinTroopCallback = paramJoinTroopCallback;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    paramTroopInfoData.troopUin = (paramString1 + "");
    paramTroopInfoData.pa = paramInt;
    paramTroopInfoData.troopName = (paramString2 + "");
    if (TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
      paramTroopInfoData.newTroopName = paramTroopInfoData.troopName;
    }
    this.b = (paramString3 + "");
    this.c = (paramString4 + "");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new JoinTroopUtil.1(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new JoinTroopUtil.2(this);
    a();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, boolean paramBoolean, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinTroop by uin");
    }
    paramContext = new JoinTroopUtil(paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, paramJoinTroopCallback);
    paramContext.d(paramBoolean);
    b(paramContext);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "onJoinTroopDone: troopUin = " + paramString + ", ret = " + paramInt + ", trace = " + Log.getStackTraceString(new RuntimeException()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityJoinTroopUtil$JoinTroopCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityJoinTroopUtil$JoinTroopCallback.a(paramString, paramInt);
    }
    dismiss();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("onJoinTroopRsp isSuccess = %s, reqtype = %s, result = %s, troopUin = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if (paramBoolean) {
      if (1 == paramInt1) {
        switch (paramInt2)
        {
        case -1: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp failed");
          }
          a(2131693551, 1);
          a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
        }
      }
    }
    for (;;)
    {
      dismiss();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoWebInfo");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoAIO = " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean) {
        f();
      }
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
      localTroopInfo.troopuin = paramString;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {}
      for (localTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;; localTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localTroopInfo);
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.e(localTroopInfo);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp join forbidden");
      }
      a(2131720199, 1);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      continue;
      if (1 == paramInt1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "onJoinTroopRsp rsp failed");
        }
        TroopUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramInt2);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("handle0x88d isSuccess = %s, troopUin = %s, troopInfo = %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramTroopInfo }));
    }
    String str = String.valueOf(paramLong);
    if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "handle0x88d return due to different uin");
      }
      a(str, 2);
      return;
    }
    if (paramTroopInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "handle0x88d return due to empty troopInfo");
      }
      a(str, 2);
      return;
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramTroopInfo.troopname)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramTroopInfo.troopname;
      }
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramTroopInfo.newTroopName;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        paramTroopInfo.setOnlyTroopMemberInviteOption(false);
        paramTroopInfo.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOnlyTroopMemberInvite = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "handle0x88d return due to HomeworkGroup");
        }
        c();
        a(str, 4);
        return;
      }
      paramBoolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128);
      boolean bool = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512);
      if ((paramBoolean) && (bool))
      {
        d();
        a(str, 4);
        return;
      }
      a(null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "handle0x88d return due rsp failed");
    }
    a(2131719023, 1);
    a(str, 2);
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "realJoinGroup");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      e();
      return false;
    }
    b(paramString);
    return true;
  }
  
  private int b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "doJoinTroop");
    }
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131694457, 1);
      i = 2;
    }
    do
    {
      return i;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 34) && (ExtendFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        ProfileGuideDialogUtils.a(this.jdField_a_of_type_AndroidContentContext).show();
        return 1;
      }
      if (QSecFramework.a().a(1001).booleanValue()) {
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.b)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
        {
          c();
          return 1;
        }
        e();
        return 0;
      }
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 8390785);
        return 0;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("AddTroopUtil", 2, localException.toString());
    return 0;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "unRegisterObserver");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AddTroopUtil", 2, "unRegisterObserver error", localException);
    }
  }
  
  private static void b(@NonNull JoinTroopUtil paramJoinTroopUtil)
  {
    paramJoinTroopUtil.setCancelable(false);
    paramJoinTroopUtil.setCanceledOnTouchOutside(false);
    paramJoinTroopUtil.c(2131694694);
    if (paramJoinTroopUtil.b() == 0)
    {
      if (paramJoinTroopUtil.jdField_a_of_type_AndroidContentContext != null)
      {
        if ((paramJoinTroopUtil.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          if (!((Activity)paramJoinTroopUtil.jdField_a_of_type_AndroidContentContext).isFinishing()) {
            paramJoinTroopUtil.show();
          }
          return;
        }
        paramJoinTroopUtil.show();
        return;
      }
      QLog.e("AddTroopUtil", 2, "joinTroop show dialog fail. mContext is null!");
      return;
    }
    paramJoinTroopUtil.b();
    paramJoinTroopUtil.a(paramJoinTroopUtil.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "jumpJoinTroopVerify");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      paramString = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, "", this.b, this.c, paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      return;
    }
    a(2131720199, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinHomeworkGroup");
    }
    HWTroopUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "gotoWebInfo, url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131718553, 1).b(a());
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3);
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130771999, 2130771992);
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinPayGroup");
    }
    TroopNotificationUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinGroup");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.b, this.c, null, null);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "go2AIO");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);; localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class))
    {
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil
 * JD-Core Version:    0.7.0.1
 */