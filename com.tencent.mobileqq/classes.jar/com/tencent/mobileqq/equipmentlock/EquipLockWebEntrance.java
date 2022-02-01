package com.tencent.mobileqq.equipmentlock;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class EquipLockWebEntrance
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  
  private static String a(int paramInt)
  {
    Object localObject2 = EquipmentLockImpl.a().g();
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("https")) {
        if (((String)localObject2).startsWith("http"))
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    else
    {
      localObject1 = "https://accounts.qq.com/cn2/manage/mobile_h5/mobile_index";
    }
    localObject2 = new StringBuilder((String)localObject1);
    if (((String)localObject1).contains("?")) {
      ((StringBuilder)localObject2).append("&");
    } else {
      ((StringBuilder)localObject2).append("?");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("type=");
    ((StringBuilder)localObject1).append(Integer.toString(paramInt));
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    ((StringBuilder)localObject2).append("&plat=1");
    ((StringBuilder)localObject2).append("&app=1");
    ((StringBuilder)localObject2).append("&version=8.8.17.5770");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&device=");
    ((StringBuilder)localObject1).append(URLEncoder.encode(Build.DEVICE));
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&system=");
    ((StringBuilder)localObject1).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&systemInt=");
    ((StringBuilder)localObject1).append(Integer.toString(Build.VERSION.SDK_INT));
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    return ((StringBuilder)localObject2).toString();
  }
  
  private static String a(String paramString, AppInterface paramAppInterface)
  {
    if (paramString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "handlePhoneContact url is null");
      }
      return paramString;
    }
    Object localObject1 = null;
    if (paramAppInterface != null)
    {
      paramAppInterface = (IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.getSelfBindInfo();
        if (paramAppInterface == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "mgr can't find stat");
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mgr find stat, nationCode=");
            ((StringBuilder)localObject1).append(paramAppInterface.nationCode);
            ((StringBuilder)localObject1).append(" no.=");
            ((StringBuilder)localObject1).append(paramAppInterface.mobileNo);
            QLog.d("EquipLockWebEntrance", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = paramAppInterface.nationCode;
          paramAppInterface = paramAppInterface.mobileNo;
          break label172;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("EquipLockWebEntrance", 2, "mgr is null");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("EquipLockWebEntrance", 2, "getEntranceIntent:app is null");
    }
    paramAppInterface = null;
    label172:
    Object localObject2 = paramString;
    if (localObject1 != null)
    {
      localObject2 = paramString;
      if (((String)localObject1).length() > 0)
      {
        localObject2 = paramString;
        if (paramAppInterface != null)
        {
          localObject2 = paramString;
          if (paramAppInterface.length() > 0)
          {
            paramString = new StringBuilder(paramString);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("&area=");
            ((StringBuilder)localObject2).append((String)localObject1);
            paramString.append(((StringBuilder)localObject2).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("&mob=");
            ((StringBuilder)localObject1).append(paramAppInterface);
            paramString.append(((StringBuilder)localObject1).toString());
            localObject2 = paramString.toString();
          }
        }
      }
    }
    return localObject2;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enter actCaller is null");
      }
      return;
    }
    paramAppInterface = b(paramActivity, paramAppInterface, paramInt);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, paramAppInterface, false, -1);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enterForResult actCaller is null");
      }
      return;
    }
    if (paramAppInterface == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enterForResult app is null");
      }
      return;
    }
    paramAppInterface = b(paramActivity, paramAppInterface, paramInt1);
    if (paramString != null) {
      paramAppInterface.putExtra("tag", paramString);
    }
    paramAppInterface.putExtra("needResult", true);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, paramAppInterface, true, paramInt2);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "subaccountEnter actCaller is null");
      }
      return;
    }
    Object localObject1 = a(paramInt);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AuthDevUgAct url=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("EquipLockWebEntrance", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("subAccountUin", paramString2);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("globalEnter currentUin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" reqUin=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" isSubaccount=");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("EquipLockWebEntrance", 2, ((StringBuilder)localObject1).toString());
    }
    ((Intent)localObject2).putExtra("isSubaccount", bool1);
    ((Intent)localObject2).putExtra("avoidLoginWeb", bool1);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, (Intent)localObject2, false, -1);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "subaccountEnter actCaller is null");
      }
      return;
    }
    Object localObject1 = a(paramInt1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AuthDevUgAct url=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("EquipLockWebEntrance", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("subAccountUin", paramString2);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("globalEnter currentUin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" reqUin=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" isSubaccount=");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("EquipLockWebEntrance", 2, ((StringBuilder)localObject1).toString());
    }
    ((Intent)localObject2).putExtra("isSubaccount", bool1);
    ((Intent)localObject2).putExtra("avoidLoginWeb", bool1);
    if (paramString3 != null) {
      ((Intent)localObject2).putExtra("tag", paramString3);
    }
    ((Intent)localObject2).putExtra("needResult", true);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, (Intent)localObject2, true, paramInt2);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  private static Intent b(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent actCaller is null");
      }
      return null;
    }
    if (paramAppInterface == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent app is null");
      }
      return null;
    }
    String str = paramAppInterface.getCurrentAccountUin();
    paramAppInterface = a(a(paramInt), paramAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AuthDevUgAct url=");
      localStringBuilder.append(paramAppInterface);
      QLog.d("EquipLockWebEntrance", 2, localStringBuilder.toString());
    }
    paramActivity = new Intent(paramActivity, QQBrowserActivity.class);
    paramActivity.putExtra("portraitOnly", true);
    paramActivity.putExtra("url", paramAppInterface);
    paramActivity.putExtra("uin", str);
    paramActivity.putExtra("hide_operation_bar", true);
    paramActivity.putExtra("hide_more_button", true);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance
 * JD-Core Version:    0.7.0.1
 */