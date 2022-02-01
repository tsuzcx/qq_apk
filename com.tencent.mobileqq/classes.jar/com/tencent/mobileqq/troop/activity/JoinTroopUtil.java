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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
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
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private JoinTroopUtil.JoinTroopCallback jdField_a_of_type_ComTencentMobileqqTroopActivityJoinTroopUtil$JoinTroopCallback;
  private ITroopMngHandler jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMngHandler;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
  private volatile boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  private JoinTroopUtil(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, int paramInt, String paramString3, String paramString4, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    super(paramContext);
    a(paramContext, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, paramString1, paramString2, paramInt, paramString3, paramString4, paramJoinTroopCallback);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "registerObserver");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMngHandler = ((ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER));
    paramContext = new StringBuilder();
    paramContext.append(paramString1);
    paramContext.append("");
    paramTroopInfoData.troopUin = paramContext.toString();
    paramTroopInfoData.pa = paramInt;
    paramContext = new StringBuilder();
    paramContext.append(paramString2);
    paramContext.append("");
    paramTroopInfoData.troopName = paramContext.toString();
    if (TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
      paramTroopInfoData.newTroopName = paramTroopInfoData.troopName;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramString3);
    paramContext.append("");
    this.b = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(paramString4);
    paramContext.append("");
    this.c = paramContext.toString();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new JoinTroopUtil.1(this);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onJoinTroopDone: troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ret = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", trace = ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(new RuntimeException()));
      QLog.d("AddTroopUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityJoinTroopUtil$JoinTroopCallback;
    if (localObject != null) {
      ((JoinTroopUtil.JoinTroopCallback)localObject).a(paramString, paramInt);
    }
    dismiss();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("onJoinTroopRsp isSuccess = %s, reqtype = %s, result = %s, troopUin = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if (paramBoolean)
    {
      if (1 == paramInt1) {
        if (paramInt2 != -2)
        {
          if ((paramInt2 != 0) && (paramInt2 != 1))
          {
            if (paramInt2 != 2)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddTroopUtil", 2, "onJoinTroopRsp failed");
              }
              a(2131693506, 1);
              a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 2);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddTroopUtil", 2, "onJoinTroopRsp join forbidden");
              }
              a(2131719932, 1);
              a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 2);
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onJoinTroopRsp gotoAIO = ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
              QLog.d("AddTroopUtil", 2, ((StringBuilder)localObject).toString());
            }
            if (this.jdField_a_of_type_Boolean) {
              f();
            }
            Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
            ((TroopInfo)localObject).troopuin = paramString;
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName)) {
              ((TroopInfo)localObject).troopname = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
            } else {
              ((TroopInfo)localObject).troopname = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.e((TroopInfo)localObject);
            a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 1);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoWebInfo");
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMngHandler.a(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        }
      }
    }
    else if (1 == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp rsp failed");
      }
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed((Activity)this.jdField_a_of_type_AndroidContentContext, paramInt2);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 2);
    }
    dismiss();
  }
  
  private void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("handle0x88d isSuccess = %s, troopUin = %s, troopInfo = %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramTroopInfo }));
    }
    String str = String.valueOf(paramLong);
    if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))
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
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName = paramTroopInfo.troopname;
      }
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName = paramTroopInfo.newTroopName;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        paramTroopInfo.setOnlyTroopMemberInviteOption(false);
        paramTroopInfo.cGroupOption = 2;
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        paramTroopInfo.cGroupOption = 2;
        paramTroopInfo.isOnlyTroopMemberInvite = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "handle0x88d return due to HomeworkGroup");
        }
        c();
        a(str, 4);
        return;
      }
      paramBoolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128);
      boolean bool = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512);
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
    a(2131718739, 1);
    a(str, 2);
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "realJoinGroup");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1)
    {
      e();
      return false;
    }
    b(paramString);
    return true;
  }
  
  private int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "doJoinTroop");
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131694422, 1);
      return 2;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 34) && (((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      ProfileGuideDialogUtils.a(this.jdField_a_of_type_AndroidContentContext).show();
      return 1;
    }
    if (QSecFramework.a().a(1001).booleanValue()) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.b))) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMngHandler.a(l, 8390785);
        return 0;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AddTroopUtil", 2, localException.toString());
        }
        return 0;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop())
    {
      c();
      return 1;
    }
    e();
    return 0;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "unRegisterObserver");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
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
    paramJoinTroopUtil.c(2131694668);
    if (paramJoinTroopUtil.b() == 0)
    {
      Context localContext = paramJoinTroopUtil.jdField_a_of_type_AndroidContentContext;
      if (localContext != null)
      {
        if ((localContext instanceof Activity))
        {
          if (!((Activity)localContext).isFinishing()) {
            paramJoinTroopUtil.show();
          }
        }
        else {
          paramJoinTroopUtil.show();
        }
      }
      else {
        QLog.e("AddTroopUtil", 2, "joinTroop show dialog fail. mContext is null!");
      }
    }
    else
    {
      paramJoinTroopUtil.b();
      paramJoinTroopUtil.a(paramJoinTroopUtil.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 2);
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "jumpJoinTroopVerify");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption();
      paramString = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, null, "", this.b, this.c, paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      return;
    }
    a(2131719932, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 2);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinHomeworkGroup");
    }
    HWTroopUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "join");
  }
  
  private void c(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoWebInfo, url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AddTroopUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131718221, 1).b(a());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?_wv=1031&troopUin=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      ((StringBuilder)localObject).append("&isVerify=");
      ((StringBuilder)localObject).append(0);
      paramString = ((StringBuilder)localObject).toString();
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      paramString = this.jdField_a_of_type_AndroidContentContext;
      if ((paramString instanceof Activity)) {
        ((Activity)paramString).overridePendingTransition(2130772011, 2130772004);
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 3);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinPayGroup");
    }
    TroopNotificationUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "");
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
    this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMngHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption(), this.b, this.c, null, null);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "go2AIO");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 30) {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    } else {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    }
    Intent localIntent = AIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil
 * JD-Core Version:    0.7.0.1
 */