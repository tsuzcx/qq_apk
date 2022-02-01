package com.tencent.mobileqq.c2cshortcutbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreController;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class C2CShortcutBarJumpController
{
  private C2CShortcutBarStoreController a;
  
  private static String a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    return paramString1.replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramString2).replace("$APPID$", paramString3);
  }
  
  private static void a(Activity paramActivity, AIOShortcutBarContext paramAIOShortcutBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if ((!TextUtils.isEmpty(paramC2CShortcutAppInfo.e)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramC2CShortcutAppInfo.e)))
    {
      int i;
      if (paramAIOShortcutBarContext.a() == 5) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = 4017;
      } else {
        i = 4016;
      }
      paramAIOShortcutBarContext = new EntryModel(0, Long.valueOf(paramSessionInfo.b).longValue(), ContactUtils.c(paramQQAppInterface, paramSessionInfo.b), false);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramActivity, a(paramC2CShortcutAppInfo.e, paramQQAppInterface, paramSessionInfo.b, paramC2CShortcutAppInfo.a), i, paramAIOShortcutBarContext, null);
    }
  }
  
  private static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if (String.valueOf(101761547).equals(paramC2CShortcutAppInfo.a))
    {
      ListenTogetherUtils.b(paramQQAppInterface, paramActivity, 2, paramSessionInfo.b, 0);
      return;
    }
    if (String.valueOf(101817424).equals(paramC2CShortcutAppInfo.a))
    {
      a(paramQQAppInterface, paramActivity, paramSessionInfo.b);
      return;
    }
    if (String.valueOf(101872203).equals(paramC2CShortcutAppInfo.a))
    {
      if (AvGameEntranceUtils.a((BaseActivity)paramActivity, paramSessionInfo.b)) {
        return;
      }
      paramQQAppInterface = (IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class, "");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.createAvGameRoom(paramActivity, 2, paramSessionInfo.b, 0);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = paramQQAppInterface.b(4, -1, paramString);
    Bundle localBundle = TogetherUtils.a(bool, 3);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramString, 2, 4, 3, localBundle);
      return;
    }
    paramQQAppInterface.a(paramContext, paramString, 2, 4, 3, localBundle);
  }
  
  private boolean a(Activity paramActivity, AIOShortcutBarContext paramAIOShortcutBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    a();
    List localList = C2CShortcutBarManager.a(paramQQAppInterface).b(paramSessionInfo.b);
    String str = paramSessionInfo.b;
    C2CShortcutBarJumpController.1 local1 = new C2CShortcutBarJumpController.1(this, paramActivity, paramAIOShortcutBarContext, paramQQAppInterface, paramSessionInfo);
    boolean bool;
    if (paramAIOShortcutBarContext.a() == 5) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = new C2CShortcutBarStoreController(paramActivity, paramQQAppInterface, str, localList, local1, bool);
    this.a.a();
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B32B", "0X800B32B", C2CShortcutBarManager.a(paramQQAppInterface).a(paramSessionInfo.b), 0, "", "", "", "");
    return true;
  }
  
  private static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if ((!TextUtils.isEmpty(paramC2CShortcutAppInfo.e)) && (paramC2CShortcutAppInfo.e.startsWith("mqqapi")))
    {
      paramC2CShortcutAppInfo.e = a(paramC2CShortcutAppInfo.e, paramQQAppInterface, paramSessionInfo.b, paramC2CShortcutAppInfo.a);
      paramQQAppInterface = new Intent(paramActivity, JumpActivity.class);
      paramQQAppInterface.setData(Uri.parse(paramC2CShortcutAppInfo.e));
      paramActivity.startActivity(paramQQAppInterface);
    }
  }
  
  private boolean b(Activity paramActivity, AIOShortcutBarContext paramAIOShortcutBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if (paramC2CShortcutAppInfo.k)
    {
      int i;
      if (paramAIOShortcutBarContext.a() == 5)
      {
        i = paramSessionInfo.a;
        if (1044 == i)
        {
          paramAIOShortcutBarContext = paramQQAppInterface.getMsgCache().a(paramSessionInfo.b, paramQQAppInterface.getCurrentAccountUin(), true);
          i = 163;
        }
        else if (1045 == i)
        {
          paramAIOShortcutBarContext = paramQQAppInterface.getMsgCache().a(paramSessionInfo.b, paramQQAppInterface.getCurrentAccountUin(), false);
          i = 166;
        }
        else
        {
          paramAIOShortcutBarContext = null;
        }
      }
      else
      {
        paramAIOShortcutBarContext = null;
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("sendArk() curType = ");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(" sig = ");
        paramQQAppInterface.append(paramAIOShortcutBarContext);
        QLog.d("C2CShortcutBarJumpController", 2, paramQQAppInterface.toString());
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).createUpdatableMsg(paramC2CShortcutAppInfo.a, "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, -1, paramSessionInfo.b, i, paramAIOShortcutBarContext, new C2CShortcutBarJumpController.2(this, paramActivity));
      return true;
    }
    return false;
  }
  
  private static void c(Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if ((!TextUtils.isEmpty(paramC2CShortcutAppInfo.e)) && ((paramC2CShortcutAppInfo.e.startsWith("http")) || (paramC2CShortcutAppInfo.e.startsWith("https"))))
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", a(paramC2CShortcutAppInfo.e, paramQQAppInterface, paramSessionInfo.b, paramC2CShortcutAppInfo.a));
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramActivity.startActivity(localIntent);
    }
  }
  
  public void a()
  {
    C2CShortcutBarStoreController localC2CShortcutBarStoreController = this.a;
    if (localC2CShortcutBarStoreController != null)
    {
      localC2CShortcutBarStoreController.b();
      this.a = null;
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.runOnUiThread(new C2CShortcutBarJumpController.3(this, paramActivity));
  }
  
  public void a(Activity paramActivity, AIOShortcutBarContext paramAIOShortcutBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, C2CShortcutAppInfo paramC2CShortcutAppInfo, boolean paramBoolean)
  {
    if ((paramC2CShortcutAppInfo != null) && (paramAIOShortcutBarContext != null) && (paramQQAppInterface != null) && (paramActivity != null) && (paramSessionInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarJumpController", 2, new Object[] { "isClickManager", Boolean.valueOf(paramBoolean), " { info = ", paramC2CShortcutAppInfo.toString() });
      }
      if (paramBoolean)
      {
        a(paramActivity, paramAIOShortcutBarContext, paramQQAppInterface, paramSessionInfo);
        return;
      }
      int i = paramC2CShortcutAppInfo.n;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                QLog.d("C2CShortcutBarJumpController", 1, new Object[] { "handlerJumpAction() unknown type: ", Long.valueOf(paramC2CShortcutAppInfo.b) });
                return;
              }
              a(paramActivity, paramQQAppInterface, paramSessionInfo, paramC2CShortcutAppInfo);
              return;
            }
            b(paramActivity, paramAIOShortcutBarContext, paramQQAppInterface, paramSessionInfo, paramC2CShortcutAppInfo);
            return;
          }
          a(paramActivity, paramAIOShortcutBarContext, paramQQAppInterface, paramSessionInfo, paramC2CShortcutAppInfo);
          return;
        }
        c(paramActivity, paramQQAppInterface, paramSessionInfo, paramC2CShortcutAppInfo);
        return;
      }
      b(paramActivity, paramQQAppInterface, paramSessionInfo, paramC2CShortcutAppInfo);
      return;
    }
    QLog.d("C2CShortcutBarJumpController", 1, "handlerJumpAction() param is null just return ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController
 * JD-Core Version:    0.7.0.1
 */