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
  private QQAppInterface a;
  private Context c;
  private Handler d;
  private TroopManager e;
  private ITroopMngHandler f;
  private TroopMngObserver g;
  private JoinTroopUtil.JoinTroopCallback h;
  private BroadcastReceiver i;
  private TroopInfoData j = new TroopInfoData();
  private String k;
  private String l;
  private volatile boolean m;
  
  private JoinTroopUtil(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, int paramInt, String paramString3, String paramString4, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    super(paramContext);
    a(paramContext, this.j, paramString1, paramString2, paramInt, paramString3, paramString4, paramJoinTroopCallback);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this.c).notifyUser(paramInt1, a(), 0, paramInt2);
  }
  
  private void a(@NonNull Context paramContext, @NonNull TroopInfoData paramTroopInfoData, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "init");
    }
    this.c = paramContext;
    this.d = new Handler(Looper.getMainLooper());
    this.h = paramJoinTroopCallback;
    this.a = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.e = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER));
    this.f = ((ITroopMngHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER));
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
    this.k = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(paramString4);
    paramContext.append("");
    this.l = paramContext.toString();
    this.m = false;
    this.g = new JoinTroopUtil.1(this);
    this.i = new JoinTroopUtil.2(this);
    b();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, boolean paramBoolean, JoinTroopUtil.JoinTroopCallback paramJoinTroopCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinTroop by uin");
    }
    paramContext = new JoinTroopUtil(paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, paramJoinTroopCallback);
    paramContext.d(paramBoolean);
    e(paramContext);
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
    Object localObject = this.h;
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
              a(2131891060, 1);
              a(this.j.troopUin, 2);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddTroopUtil", 2, "onJoinTroopRsp join forbidden");
              }
              a(2131917537, 1);
              a(this.j.troopUin, 2);
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onJoinTroopRsp gotoAIO = ");
              ((StringBuilder)localObject).append(this.m);
              QLog.d("AddTroopUtil", 2, ((StringBuilder)localObject).toString());
            }
            if (this.m) {
              h();
            }
            Object localObject = this.e.g(paramString);
            ((TroopInfo)localObject).troopuin = paramString;
            if (TextUtils.isEmpty(this.j.troopName)) {
              ((TroopInfo)localObject).troopname = this.j.newTroopName;
            } else {
              ((TroopInfo)localObject).troopname = this.j.troopName;
            }
            this.e.a((TroopInfo)localObject);
            this.e.e((TroopInfo)localObject);
            a(this.j.troopUin, 1);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoWebInfo");
          }
          this.f.a(Long.parseLong(paramString), Long.parseLong(this.a.getAccount()));
        }
      }
    }
    else if (1 == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp rsp failed");
      }
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed((Activity)this.c, paramInt2);
      a(this.j.troopUin, 2);
    }
    dismiss();
  }
  
  private void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("handle0x88d isSuccess = %s, troopUin = %s, troopInfo = %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramTroopInfo }));
    }
    String str = String.valueOf(paramLong);
    if (!str.equals(this.j.troopUin))
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
        this.j.troopName = paramTroopInfo.troopname;
      }
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        this.j.newTroopName = paramTroopInfo.newTroopName;
      }
      this.j.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      this.j.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.j.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.j.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        paramTroopInfo.setOnlyTroopMemberInviteOption(false);
        paramTroopInfo.cGroupOption = 2;
        paramTroopInfo = this.j;
        paramTroopInfo.cGroupOption = 2;
        paramTroopInfo.isOnlyTroopMemberInvite = false;
      }
      if ((this.j.isHomeworkTroop()) && (this.j.cGroupOption != 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "handle0x88d return due to HomeworkGroup");
        }
        e();
        a(str, 4);
        return;
      }
      paramBoolean = TroopInfo.hasPayPrivilege(this.j.mTroopPrivilegeFlag, 128);
      boolean bool = TroopInfo.hasPayPrivilege(this.j.mTroopPrivilegeFlag, 512);
      if ((paramBoolean) && (bool))
      {
        f();
        a(str, 4);
        return;
      }
      b(null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "handle0x88d return due rsp failed");
    }
    a(2131916242, 1);
    a(str, 2);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "registerObserver");
    }
    this.a.addObserver(this.g);
    this.c.registerReceiver(this.i, new IntentFilter("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION"));
    setOnDismissListener(new JoinTroopUtil.3(this));
    this.d.postDelayed(new JoinTroopUtil.4(this), 15000L);
  }
  
  private boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "realJoinGroup");
    }
    if (this.j.cGroupOption == 1)
    {
      g();
      return false;
    }
    c(paramString);
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "unRegisterObserver");
    }
    this.d.removeCallbacksAndMessages(null);
    this.a.removeObserver(this.g);
    try
    {
      this.c.unregisterReceiver(this.i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AddTroopUtil", 2, "unRegisterObserver error", localException);
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "jumpJoinTroopVerify");
    }
    if (this.j.cGroupOption != 3)
    {
      int n = this.j.getStatOption();
      paramString = AddFriendLogicActivity.a(this.c, this.j.troopUin, this.j.newTroopName, this.j.cGroupOption, n, this.j.mStrJoinQuestion, this.j.mStrJoinAnswer, null, "", this.k, this.l, paramString);
      this.c.startActivity(paramString);
      this.a.removeObserver(this.g);
      return;
    }
    a(2131917537, 0);
    a(this.j.troopUin, 2);
  }
  
  private int d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "doJoinTroop");
    }
    if (!NetworkUtil.isNetSupport(this.c))
    {
      a(2131892102, 1);
      return 2;
    }
    if ((this.j.pa == 34) && (((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.a.getCurrentAccountUin())))
    {
      ProfileGuideDialogUtils.a(this.c).show();
      return 1;
    }
    if (QSecFramework.c().a(1001).booleanValue()) {
      QSecFramework.c().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
    }
    if ((this.j.cGroupOption != 1) && (TextUtils.isEmpty(this.k))) {
      try
      {
        long l1 = Long.parseLong(this.j.troopUin);
        this.f.a(l1, 8390785);
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
    if (this.j.isHomeworkTroop())
    {
      e();
      return 1;
    }
    g();
    return 0;
  }
  
  private void d(String paramString)
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
      QQToast.makeText(this.c, 2, 2131915703, 1).show(a());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?_wv=1031&troopUin=");
      ((StringBuilder)localObject).append(this.j.troopUin);
      ((StringBuilder)localObject).append("&isVerify=");
      ((StringBuilder)localObject).append(0);
      paramString = ((StringBuilder)localObject).toString();
      localObject = new Intent(this.c, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      this.c.startActivity((Intent)localObject);
      paramString = this.c;
      if ((paramString instanceof Activity)) {
        ((Activity)paramString).overridePendingTransition(2130772014, 2130772007);
      }
    }
    a(this.j.troopUin, 3);
  }
  
  private void d(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinHomeworkGroup");
    }
    HWTroopUtils.a(this.c, this.a.getCurrentAccountUin(), this.j.troopUin, "join");
  }
  
  private static void e(@NonNull JoinTroopUtil paramJoinTroopUtil)
  {
    paramJoinTroopUtil.setCancelable(false);
    paramJoinTroopUtil.setCanceledOnTouchOutside(false);
    paramJoinTroopUtil.c(2131892360);
    if (paramJoinTroopUtil.d() == 0)
    {
      Context localContext = paramJoinTroopUtil.c;
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
      paramJoinTroopUtil.c();
      paramJoinTroopUtil.a(paramJoinTroopUtil.j.troopUin, 2);
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinPayGroup");
    }
    TroopNotificationUtils.a(this.c, this.j.troopUin, "");
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinGroup");
    }
    this.f.a(this.j.troopUin, "", this.j.getStatOption(), this.k, this.l, null, null);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "go2AIO");
    }
    if (this.j.pa == 30) {
      localIntent = new Intent(this.c, ChatActivity.class);
    } else {
      localIntent = new Intent(this.c, SplashActivity.class);
    }
    Intent localIntent = AIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", this.j.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.j.newTroopName);
    this.c.startActivity(localIntent);
  }
  
  public int a()
  {
    return this.c.getResources().getDimensionPixelSize(2131299920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil
 * JD-Core Version:    0.7.0.1
 */