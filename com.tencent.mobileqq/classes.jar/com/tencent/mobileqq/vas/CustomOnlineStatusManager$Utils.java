package com.tencent.mobileqq.vas;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FrdCustomOnlineStatusChange;

public class CustomOnlineStatusManager$Utils
{
  public static String a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if (paramCustomOnlineStatusMsg == null) {
      return "";
    }
    try
    {
      if (paramCustomOnlineStatusMsg.uHasCustomInfo.get() == 1)
      {
        String str = paramCustomOnlineStatusMsg.sCustomDesc.get();
        paramCustomOnlineStatusMsg = paramCustomOnlineStatusMsg.sCustomModel.get();
        if ((str != null) && (paramCustomOnlineStatusMsg != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(paramCustomOnlineStatusMsg);
          paramCustomOnlineStatusMsg = localStringBuilder.toString();
          return paramCustomOnlineStatusMsg;
        }
      }
    }
    catch (Exception paramCustomOnlineStatusMsg)
    {
      QLog.d("CustomOnlineStatusManager", 1, paramCustomOnlineStatusMsg, new Object[0]);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    Object localObject3 = Build.MODEL;
    Object localObject5 = MsfSdkUtils.getIMEIForMain("bussiness_id_customize_online_status");
    String str1 = MobileInfoUtil.getImei();
    Object localObject1 = localObject3;
    Object localObject2 = localObject5;
    Object localObject4;
    try
    {
      localObject3 = URLEncoder.encode((String)localObject3, "utf-8");
      localObject1 = localObject3;
      localObject2 = localObject5;
      localObject5 = URLEncoder.encode((String)localObject5, "utf-8");
      localObject1 = localObject3;
      localObject2 = localObject5;
      String str2 = URLEncoder.encode(str1, "utf-8");
      localObject1 = localObject3;
      localObject2 = localObject5;
      localObject3 = str2;
    }
    catch (Exception localException)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("addExtParamsForUrl");
      ((StringBuilder)localObject5).append(localException.getMessage());
      QLog.e("CustomOnlineStatusManager", 1, ((StringBuilder)localObject5).toString());
      localObject4 = str1;
    }
    paramString = new StringBuilder(paramString);
    paramString.append("&systemName=android");
    paramString.append("&model=");
    paramString.append(localObject1);
    paramString.append("&msfImei=");
    paramString.append(localObject2);
    paramString.append("&identifier=");
    paramString.append(localObject4);
    return paramString.toString();
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null)
    {
      QLog.e("CustomOnlineStatusManager", 1, "activity == null");
      return;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("selfSet_leftViewText", paramActivity.getString(2131887812));
    localIntent.putExtra("leftViewText", paramActivity.getString(2131887812));
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("finish_animation_up_down", true);
    localObject = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1";
    if ("panel".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1");
      paramString.append("&src=1");
      localObject = paramString.toString();
      paramString = "0X8009F76";
    }
    for (;;)
    {
      break;
      if ("settings".equals(paramString))
      {
        paramString = new StringBuilder();
        paramString.append("https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1");
        paramString.append("&src=2");
        localObject = paramString.toString();
        paramString = "0X8009F77";
      }
      else if ("aio".equals(paramString))
      {
        paramString = new StringBuilder();
        paramString.append("https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1");
        paramString.append("&src=3");
        localObject = paramString.toString();
        paramString = "0X8009F78";
      }
      else
      {
        paramString = "";
      }
    }
    VasWebviewUtil.b(paramActivity, a((String)localObject), 256L, localIntent, false, 299);
    paramActivity.overridePendingTransition(2130772014, 2130772007);
    if (!TextUtils.isEmpty(paramString)) {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(SubMsgType0x27.FrdCustomOnlineStatusChange paramFrdCustomOnlineStatusChange)
  {
    long l = paramFrdCustomOnlineStatusChange.uint64_uin.get();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPush uni = ");
      localStringBuilder.append(paramFrdCustomOnlineStatusChange.uint64_uin.get());
      QLog.d("CustomOnlineStatusManager", 4, localStringBuilder.toString());
    }
    if (l == BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "sync owner");
      }
      b();
      return;
    }
    if (!TextUtils.isEmpty(String.valueOf(l)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "sync friend");
      }
      b(String.valueOf(l));
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String b(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if (paramCustomOnlineStatusMsg == null) {
      return "";
    }
    try
    {
      if (paramCustomOnlineStatusMsg.uHasCustomInfo.get() == 1)
      {
        paramCustomOnlineStatusMsg = paramCustomOnlineStatusMsg.sCustomModel.get();
        if (paramCustomOnlineStatusMsg != null) {
          return paramCustomOnlineStatusMsg;
        }
      }
    }
    catch (Exception paramCustomOnlineStatusMsg)
    {
      QLog.d("CustomOnlineStatusManager", 1, paramCustomOnlineStatusMsg, new Object[0]);
    }
    return "";
  }
  
  private static void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((VipInfoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(localQQAppInterface.getLongAccountUin());
  }
  
  private static void b(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    try
    {
      localFriendListHandler.getOnlineInfo(paramString, false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CustomOnlineStatusManager", 1, paramString, new Object[0]);
    }
  }
  
  public static int c(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if ((paramCustomOnlineStatusMsg != null) && (paramCustomOnlineStatusMsg.uUpdateInterval.get() > 0)) {
      return paramCustomOnlineStatusMsg.uUpdateInterval.get();
    }
    return 30000;
  }
  
  public static int d(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if (paramCustomOnlineStatusMsg != null) {
      return paramCustomOnlineStatusMsg.uHasCustomInfo.get();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils
 * JD-Core Version:    0.7.0.1
 */