package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class RobotUtils
{
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (paramAbsShareMsg != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramAbsShareMsg.mMsgServiceID != 14) {
        return null;
      }
      if (!a(paramAbsShareMsg.mMsgUrl)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isTroopRobotCard, url:");
        ((StringBuilder)localObject).append(paramAbsShareMsg.mMsgUrl);
        ((StringBuilder)localObject).append(" troopuin:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("RobotUtils", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = b(paramAbsShareMsg.mMsgUrl, "gc");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopuin in url:");
        localStringBuilder.append((String)localObject);
        QLog.d("RobotUtils", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString)))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("has troopuin:");
          paramString.append(paramAbsShareMsg.mMsgUrl);
          QLog.d("RobotUtils", 2, paramString.toString());
        }
        return null;
      }
      paramString = a(paramAbsShareMsg.mMsgUrl, paramString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("attach troopuin:");
        ((StringBuilder)localObject).append(paramAbsShareMsg.mMsgUrl);
        QLog.d("RobotUtils", 2, ((StringBuilder)localObject).toString());
      }
      return paramString;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("gc=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("&");
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://web.qun.qq.com/qunrobot/timingmessageedit?");
    localStringBuilder.append(paramString);
    localStringBuilder.append("r_uin=2854196310&f_id=41&type=2&slot=0&_wwv=128");
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url ");
      localStringBuilder.append(paramString);
      QLog.d("RobotUtils", 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return paramString1;
      }
      str = a(paramString1, "gc", paramString2);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      int i = paramString1.indexOf("?");
      if ((i > 0) && (i < paramString1.length()))
      {
        i += 1;
        localObject = paramString1.substring(i).split("&");
        if ((localObject != null) && (localObject.length != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1.substring(0, i));
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append("=");
          paramString1 = paramString1.toString();
          int j = 0;
          int k = 0;
          i = 1;
          while (j < localObject.length)
          {
            if (!TextUtils.isEmpty(localObject[j]))
            {
              if (i != 0) {
                i = 0;
              } else {
                localStringBuilder.append("&");
              }
              if (paramString1.equalsIgnoreCase(localObject[j].substring(0, paramString1.length())))
              {
                localStringBuilder.append(paramString1);
                localStringBuilder.append(paramString3);
                k = 1;
              }
              else
              {
                localStringBuilder.append(localObject[j]);
              }
            }
            j += 1;
          }
          if (k == 0)
          {
            localStringBuilder.append("&");
            localStringBuilder.append(paramString2);
            localStringBuilder.append("=");
            localStringBuilder.append(paramString3);
          }
          return localStringBuilder.toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("=");
        ((StringBuilder)localObject).append(paramString3);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append(paramString3);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotProfileUrl(paramString1, paramString2);
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131713408));
    if (WebViewPluginFactory.a.containsKey("robotsummary")) {
      paramString2.putExtra("insertPluginsArray", new String[] { "robotsummary" });
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invokeRobotFunction, troopuin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" robotuin:");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(" robotname:");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append(" offurl:");
      ((StringBuilder)localObject).append(paramString7);
      ((StringBuilder)localObject).append(" offtitle:");
      ((StringBuilder)localObject).append(paramString8);
      ((StringBuilder)localObject).append(" onurl:");
      ((StringBuilder)localObject).append(paramString5);
      ((StringBuilder)localObject).append(" ontitle:");
      ((StringBuilder)localObject).append(paramString6);
      QLog.d("RobotUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString8)))
    {
      if (TextUtils.isEmpty(paramString7)) {
        return;
      }
      if (paramContext == null) {
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("troopuin", paramString1);
      ((Bundle)localObject).putString("robotuin", paramString3);
      ((Bundle)localObject).putString("robotname", paramString4);
      ((Bundle)localObject).putString("onurl", paramString5);
      ((Bundle)localObject).putString("ontitle", paramString6);
      ((Bundle)localObject).putString("offurl", paramString7);
      ((Bundle)localObject).putString("offtitle", paramString8);
      paramString5 = AIOUtils.a(new Intent(paramContext, SplashActivity.class), null);
      if (paramInt == 1)
      {
        paramString5.putExtra("uin", paramString1);
        paramString5.putExtra("uintype", 1);
        paramString5.putExtra("uinname", paramString2);
      }
      else if (paramInt == 0)
      {
        paramString5.putExtra("uin", paramString3);
        paramString5.putExtra("uintype", 1043);
        paramString5.putExtra("uinname", paramString4);
      }
      paramString5.putExtra("key_invoke_troop_robot_function", (Bundle)localObject);
      paramString5.putExtra("isBack2Root", true);
      paramContext.startActivity(paramString5);
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RobotUtils", 2, "openGroupManagerBookCard with empty troopUin");
      return;
    }
    paramString = a(paramString);
    Intent localIntent = new Intent(paramQBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131713410));
    if (WebViewPluginFactory.a.containsKey("robotsummary")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "robotsummary" });
    }
    paramQBaseActivity.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ((paramQQAppInterface != null) && (!a(paramQQAppInterface, paramString2))) {
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
    paramQQAppInterface.append(paramString2);
    Object localObject1 = paramQQAppInterface.toString();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("AppCmd://OpenContactInfo/?uin=");
    paramQQAppInterface.append(paramString2);
    Object localObject2 = paramQQAppInterface.toString();
    paramQQAppInterface = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotProfileUrl(paramString1, paramString2);
    paramString1 = new StringBuilder();
    paramString1.append(HardCodeUtil.a(2131713409));
    paramString1.append(paramString2);
    paramString1 = paramString1.toString();
    Object localObject3 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(14);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(HardCodeUtil.a(2131713412));
    ((StringBuilder)localObject4).append(paramString3);
    localObject2 = ((AbsShareMsg.Builder)localObject3).a(((StringBuilder)localObject4).toString()).a(2).a(1).a("web", paramQQAppInterface, (String)localObject2, (String)localObject1, (String)localObject1).d(paramActivity.getResources().getString(2131718146)).a();
    localObject3 = new StructMsgItemLayoutDefault();
    ((AbsStructMsgItem)localObject3).b(1);
    ((AbsStructMsgItem)localObject3).a(HardCodeUtil.a(2131713411));
    localObject4 = new StructMsgItemLayout2();
    ((AbsStructMsgItem)localObject4).b(1);
    ((AbsStructMsgItem)localObject4).a(new StructMsgItemCover((String)localObject1));
    ((AbsStructMsgItem)localObject4).a(new StructMsgItemTitle(paramString3));
    ((AbsStructMsgItem)localObject4).a(new StructMsgItemSummary(paramString1));
    ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
    ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject4);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("forward_type", 42);
    ((Bundle)localObject1).putInt("structmsg_service_id", 14);
    ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    ((Bundle)localObject1).putBoolean("k_dataline", false);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("uin", paramString2);
    ((Intent)localObject2).putExtra("uinname", paramString3);
    ForwardBaseOption.a(paramActivity, (Intent)localObject2, paramInt);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder(300);
      paramActivity.append("forwardTroopRobotCard [");
      paramActivity.append("nickname: ");
      paramActivity.append(paramString3);
      paramActivity.append(", info: ");
      paramActivity.append(paramString1);
      paramActivity.append(", url: ");
      paramActivity.append(paramQQAppInterface);
      paramActivity.append("]");
      QLog.i("RobotUtils", 2, paramActivity.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Long.parseLong(paramString2);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", paramString3, "");
      return;
    }
    catch (Exception paramString2)
    {
      label27:
      break label27;
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "0", "", paramString3, "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotProfileUrl(null, null);
    int i = str.indexOf("?");
    if (i <= 0) {
      return false;
    }
    str = str.substring(0, i);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!str.equalsIgnoreCase(paramString.substring(0, str.length()))) {
      return false;
    }
    return !TextUtils.isEmpty(b(paramString, "robot_uin"));
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    if (!a(localQQAppInterface, paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append("notifyMemChange err");
      paramString1.append(paramString2);
      QLog.i("RobotUtils", 2, paramString1.toString());
      return false;
    }
    ((ITroopRobotHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean));
    return true;
  }
  
  public static String b(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)localAppRuntime, paramString, false);
    }
    return null;
  }
  
  public static final String b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      int i = paramString1.indexOf("?");
      if (i > 0)
      {
        if (i >= paramString1.length()) {
          return null;
        }
        paramString1 = paramString1.substring(i + 1).split("&");
        if (paramString1 != null)
        {
          if (paramString1.length == 0) {
            return null;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("=");
          paramString2 = localStringBuilder.toString();
          i = 0;
          while (i < paramString1.length)
          {
            if ((!TextUtils.isEmpty(paramString1[i])) && (paramString2.equalsIgnoreCase(paramString1[i].substring(0, paramString2.length())))) {
              return paramString1[i].substring(paramString2.length());
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RobotUtils
 * JD-Core Version:    0.7.0.1
 */