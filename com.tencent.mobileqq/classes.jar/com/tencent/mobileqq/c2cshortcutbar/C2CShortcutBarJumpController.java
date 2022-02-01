package com.tencent.mobileqq.c2cshortcutbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
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
  
  private static void a(BaseChatPie paramBaseChatPie, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if (String.valueOf(101761547).equals(paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString)) {
      ListenTogetherUtils.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), 2, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    do
    {
      do
      {
        return;
        if (String.valueOf(101817424).equals(paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString))
        {
          a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
      } while ((!String.valueOf(101872203).equals(paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString)) || (AvGameEntranceUtil.a(paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      paramC2CShortcutAppInfo = (AvGameManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    } while (paramC2CShortcutAppInfo == null);
    paramC2CShortcutAppInfo.a(paramBaseChatPie.a(), 2, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = paramQQAppInterface.a(4, -1, paramString);
    Bundle localBundle = TogetherUtils.a(bool, 3);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramString, 2, 4, 3, localBundle);
      return;
    }
    paramQQAppInterface.a(paramContext, paramString, 2, 4, 3, localBundle);
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    a();
    List localList = C2CShortcutBarManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.a = new C2CShortcutBarStoreController(paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localList, new C2CShortcutBarJumpController.1(this, paramBaseChatPie), paramBaseChatPie instanceof LimitChatPie);
    this.a.a();
    ReportController.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B32B", "0X800B32B", C2CShortcutBarManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
    return true;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    byte[] arrayOfByte;
    int j;
    int i;
    if (paramC2CShortcutAppInfo.jdField_a_of_type_Boolean)
    {
      arrayOfByte = null;
      if (!(paramBaseChatPie instanceof LimitChatPie)) {
        break label196;
      }
      j = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (1044 == j)
      {
        i = 163;
        arrayOfByte = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarJumpController", 2, "sendArk() curType = " + i + " sig = " + arrayOfByte);
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).createUpdatableMsg(paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString, "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, -1, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, arrayOfByte, new C2CShortcutBarJumpController.2(this, paramBaseChatPie));
      return true;
      i = j;
      if (1045 == j)
      {
        i = 166;
        arrayOfByte = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        continue;
        return false;
        label196:
        i = 0;
      }
    }
  }
  
  private static void b(BaseChatPie paramBaseChatPie, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if ((!TextUtils.isEmpty(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString)) && (paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString.startsWith("mqqapi")))
    {
      paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString = a(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent(paramBaseChatPie.a(), JumpActivity.class);
      localIntent.setData(Uri.parse(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString));
      paramBaseChatPie.a().startActivity(localIntent);
    }
  }
  
  private static void c(BaseChatPie paramBaseChatPie, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if ((!TextUtils.isEmpty(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString)) && ((paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString.startsWith("http")) || (paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString.startsWith("https"))))
    {
      Intent localIntent = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", a(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBaseChatPie.a().startActivity(localIntent);
    }
  }
  
  private static void d(BaseChatPie paramBaseChatPie, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if ((!TextUtils.isEmpty(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString))) {
      if (!(paramBaseChatPie instanceof LimitChatPie)) {
        break label122;
      }
    }
    label122:
    for (int i = 4017;; i = 4016)
    {
      EntryModel localEntryModel = new EntryModel(0, Long.valueOf(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), ContactUtils.i(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), false);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramBaseChatPie.a(), a(paramC2CShortcutAppInfo.jdField_d_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramC2CShortcutAppInfo.jdField_a_of_type_JavaLangString), i, localEntryModel, null);
      return;
    }
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.b();
      this.a = null;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    paramBaseChatPie.a().runOnUiThread(new C2CShortcutBarJumpController.3(this, paramBaseChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie, C2CShortcutAppInfo paramC2CShortcutAppInfo, boolean paramBoolean)
  {
    if ((paramC2CShortcutAppInfo == null) || (paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.a() == null) || (paramBaseChatPie.a() == null))
    {
      QLog.d("C2CShortcutBarJumpController", 1, "handlerJumpAction() param is null just return ");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarJumpController", 2, new Object[] { "isClickManager", Boolean.valueOf(paramBoolean), " { info = ", paramC2CShortcutAppInfo.toString() });
    }
    if (paramBoolean)
    {
      a(paramBaseChatPie);
      return;
    }
    switch (paramC2CShortcutAppInfo.jdField_d_of_type_Int)
    {
    default: 
      QLog.d("C2CShortcutBarJumpController", 1, new Object[] { "handlerJumpAction() unknown type: ", Long.valueOf(paramC2CShortcutAppInfo.jdField_a_of_type_Long) });
      return;
    case 1: 
      b(paramBaseChatPie, paramC2CShortcutAppInfo);
      return;
    case 2: 
      c(paramBaseChatPie, paramC2CShortcutAppInfo);
      return;
    case 3: 
      d(paramBaseChatPie, paramC2CShortcutAppInfo);
      return;
    case 4: 
      a(paramBaseChatPie, paramC2CShortcutAppInfo);
      return;
    }
    a(paramBaseChatPie, paramC2CShortcutAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController
 * JD-Core Version:    0.7.0.1
 */