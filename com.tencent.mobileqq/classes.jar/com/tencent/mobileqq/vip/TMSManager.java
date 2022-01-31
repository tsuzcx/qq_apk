package com.tencent.mobileqq.vip;

import aksq;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.OrderCheckResult;
import dualsim.common.PhoneGetResult;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class TMSManager
{
  public static AtomicBoolean a = new AtomicBoolean();
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir("lib", 0).getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "libtmsdualcore.so";
    }
    return paramContext + File.separator + "libtmsdualcore.so";
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      try
      {
        QLog.e("TMSManager", 1, "error: " + paramInt);
      }
      finally {}
    }
  }
  
  public static void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    ThreadManager.post(new aksq(paramCallback, paramBoolean), 5, null, false);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(OrderCheckResult paramOrderCheckResult)
  {
    return (paramOrderCheckResult.errCode == -10006) && ((paramOrderCheckResult.subErrCode == -20011) || (paramOrderCheckResult.subErrCode == -20014));
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "libtmsdualcore.zip";
    }
    return paramContext + File.separator + "libtmsdualcore.zip";
  }
  
  private static void b(OrderCheckResult paramOrderCheckResult, PhoneGetResult paramPhoneGetResult)
  {
    VipInfoHandler localVipInfoHandler = null;
    int i = -1;
    if (paramOrderCheckResult == null)
    {
      QLog.e("TMSManager", 1, "tmsQuery return null");
      return;
    }
    Object localObject1 = "";
    label34:
    Object localObject2;
    label233:
    boolean bool;
    SharedPreferences localSharedPreferences;
    int j;
    if (paramOrderCheckResult.requestParamType == 1)
    {
      localObject1 = "imsi";
      if (QLog.isColorLevel())
      {
        localObject1 = AIOUtils.a().append("checkKingcardSyn result:").append(paramOrderCheckResult.errCode).append(" detailCode:").append(paramOrderCheckResult.subErrCode).append(" isKingCard:").append(paramOrderCheckResult.isKingCard).append(" freeType:").append(paramOrderCheckResult.freeType).append(" requestParamType:").append((String)localObject1).append(" requestParamValue:").append(paramOrderCheckResult.requestParamType).append(" iCardType:").append(paramOrderCheckResult.product).append(" iCardStatus:").append(paramOrderCheckResult.cardStatus).append(" networkCode:").append(paramOrderCheckResult.networkCode);
        if (paramPhoneGetResult != null) {
          ((StringBuilder)localObject1).append("\ngetPhoneNumber errorCode:").append(paramPhoneGetResult.errorCode).append(" DetailCode:").append(paramPhoneGetResult.subErrCode).append(" PhoneNumber:").append(paramPhoneGetResult.phoneNumber).append(" source:").append(paramPhoneGetResult.source);
        }
        QLog.d("TMSManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject2 != null) {
        break label525;
      }
      localObject1 = null;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label570;
      }
      bool = a(paramOrderCheckResult);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + (String)localObject1, 4);
      j = localSharedPreferences.getInt("kingCardSdk", -1);
      if (paramOrderCheckResult.errCode == 0) {
        break label535;
      }
      if (bool) {
        i = 0;
      }
    }
    for (;;)
    {
      label301:
      if (QLog.isColorLevel()) {
        QLog.d("TMSManager", 2, "afterCheckKingCardSyn: errCode=" + paramOrderCheckResult.errCode + " oldStatus=" + j + " newStatus=" + i + " notUnicom=" + bool);
      }
      if (j != i) {
        localSharedPreferences.edit().putInt("kingCardSdk", i).putInt("toast_version", 0).putInt("popup_version_v2", 0).commit();
      }
      if (!(localObject2 instanceof QQAppInterface)) {
        break;
      }
      localObject2 = (QQAppInterface)localObject2;
      if (paramPhoneGetResult == null) {}
      for (paramPhoneGetResult = localVipInfoHandler;; paramPhoneGetResult = paramPhoneGetResult.phoneNumber)
      {
        localVipInfoHandler = (VipInfoHandler)((QQAppInterface)localObject2).a(27);
        if (!bool) {
          localVipInfoHandler.a((String)localObject1, paramPhoneGetResult, paramOrderCheckResult.isKingCard, paramOrderCheckResult.product, paramOrderCheckResult.cardStatus);
        }
        if (j == i) {
          break;
        }
        localVipInfoHandler.a(((TicketManager)((QQAppInterface)localObject2).getManager(2)).getSkey((String)localObject1), (String)localObject1);
        return;
        if (paramOrderCheckResult.requestParamType == 2)
        {
          localObject1 = "phoneNumber";
          break label34;
        }
        if (paramOrderCheckResult.requestParamType != 3) {
          break label34;
        }
        localObject1 = "cache";
        break label34;
        label525:
        localObject1 = ((AppRuntime)localObject2).getAccount();
        break label233;
        label535:
        if (!paramOrderCheckResult.isKingCard) {
          break label580;
        }
        if (paramOrderCheckResult.product == 90155946)
        {
          i = 2;
          break label301;
        }
        i = 1;
        break label301;
      }
      label570:
      QLog.e("TMSManager", 1, "tmsQuery can't get uin");
      return;
      label580:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager
 * JD-Core Version:    0.7.0.1
 */