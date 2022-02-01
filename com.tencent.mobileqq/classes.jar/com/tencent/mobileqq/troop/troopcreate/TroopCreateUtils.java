package com.tencent.mobileqq.troop.troopcreate;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopCreateUtils
{
  public static Dialog a;
  
  public static String a(ArrayList<String> paramArrayList)
  {
    Collections.sort(paramArrayList, new TroopCreateUtils.1());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    int j = 0;
    int k;
    int i;
    int m;
    label187:
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      paramArrayList = (String)localIterator.next();
      if (j <= 2) {
        if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
          for (;;)
          {
            try
            {
              k = localStringBuffer.toString().getBytes("utf-8").length;
              i = paramArrayList.getBytes("utf-8").length;
              m = 30 - k;
              if (m <= 0) {
                break label290;
              }
              if (j != 0) {
                break label327;
              }
              if (i > 20)
              {
                if (i >= 14)
                {
                  paramArrayList = paramArrayList.substring(0, paramArrayList.length() - 1);
                  i = paramArrayList.getBytes("utf-8").length;
                  continue;
                }
                localStringBuffer.append(paramArrayList);
                localStringBuffer.append("…");
                localStringBuffer.append("、");
              }
              else
              {
                localStringBuffer.append(paramArrayList);
                localStringBuffer.append("、");
              }
            }
            catch (Exception paramArrayList)
            {
              paramArrayList.printStackTrace();
            }
            localObject2 = localObject1;
            if (k >= m + 3) {
              continue;
            }
            localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
            m = ((String)localObject1).getBytes("utf-8").length;
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localStringBuffer.append((String)localObject2);
        localStringBuffer.append("…");
        localStringBuffer.append("、");
      }
      else
      {
        localStringBuffer.append(paramArrayList);
        localStringBuffer.append("、");
      }
      j += 1;
      break;
      label290:
      if (localStringBuffer.toString().endsWith("、")) {
        localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
      }
      return localStringBuffer.toString();
      label327:
      k = m;
      if (m < 3) {
        k = 3;
      }
      if (k < i)
      {
        localObject1 = paramArrayList;
        int n = 0;
        m = i;
        i = n;
        break label187;
      }
      localObject2 = paramArrayList;
      i = 0;
    }
  }
  
  public static String a(AppRuntime paramAppRuntime, TroopCreateInfo.InviteMemberInfo paramInviteMemberInfo, String paramString)
  {
    if (paramInviteMemberInfo == null) {
      return "";
    }
    if (paramAppRuntime == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(paramInviteMemberInfo.jdField_a_of_type_JavaLangString);
      paramAppRuntime.append("");
      return paramAppRuntime.toString();
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ((ITroopMemberNameService)paramAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString, paramInviteMemberInfo.jdField_a_of_type_JavaLangString);
      if (!TextUtils.equals(paramString, paramInviteMemberInfo.jdField_a_of_type_JavaLangString)) {
        return paramString;
      }
    }
    if (paramAppRuntime.getAccount().equals(paramInviteMemberInfo.jdField_a_of_type_JavaLangString)) {
      return paramInviteMemberInfo.b;
    }
    paramString = (IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    if (paramString.isFriend(paramInviteMemberInfo.jdField_a_of_type_JavaLangString))
    {
      paramAppRuntime = paramString.getFriend(paramInviteMemberInfo.jdField_a_of_type_JavaLangString, true);
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.name))) {
        return paramAppRuntime.name;
      }
      return paramInviteMemberInfo.jdField_a_of_type_JavaLangString;
    }
    if (paramInviteMemberInfo.jdField_a_of_type_Int == 1)
    {
      paramAppRuntime = ((ITroopMemberInfoService)paramAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramInviteMemberInfo.c, paramInviteMemberInfo.jdField_a_of_type_JavaLangString);
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.friendnick))) {
        return paramAppRuntime.friendnick;
      }
    }
    else if (paramInviteMemberInfo.jdField_a_of_type_Int == 2)
    {
      paramAppRuntime = ((IDiscussionService)paramAppRuntime.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNickName(paramAppRuntime, paramInviteMemberInfo.c, paramInviteMemberInfo.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramAppRuntime)) {
        return paramAppRuntime;
      }
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append(paramInviteMemberInfo.jdField_a_of_type_JavaLangString);
    paramAppRuntime.append("");
    return paramAppRuntime.toString();
  }
  
  public static List<TroopCreateInfo.InviteMemberInfo> a(List<ResultRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramList.next();
      localArrayList.add(new TroopCreateInfo.InviteMemberInfo(localResultRecord.uin, localResultRecord.name, localResultRecord.type, localResultRecord.uinType, localResultRecord.groupUin, localResultRecord.phone, localResultRecord.lastChooseTime, localResultRecord.isNewTroop, localResultRecord.gameLevelIcon));
    }
    return localArrayList;
  }
  
  public static void a()
  {
    Dialog localDialog = a;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        a.dismiss();
      }
      a = null;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (!(paramActivity instanceof QBaseActivity)) {
      return;
    }
    Dialog localDialog = a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      return;
    }
    paramActivity = (QBaseActivity)paramActivity;
    if (paramActivity.isFinishing()) {
      return;
    }
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getTitleBarHeight());
    paramActivity.a(paramString);
    paramActivity.setCancelable(false);
    paramActivity.setOnDismissListener(new TroopCreateUtils.2());
    a = paramActivity;
    try
    {
      a.show();
      return;
    }
    catch (WindowManager.BadTokenException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopCreateUtils", 2, paramActivity.getMessage());
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    String str = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.7.0", Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("url", str);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    a(paramContext, localIntent, "/base/browser");
    ((Activity)paramContext).overridePendingTransition(2130772006, 2130772007);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "enterTroopCreate");
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str;
    if ((paramInt != 1) && (paramInt != 2)) {
      str = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.7.0", Integer.valueOf(0) });
    } else {
      str = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.7.0", Integer.valueOf(1) });
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("url", str);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("troop_create_from", paramInt);
    a(paramContext, localIntent, "/base/browser", 51);
    ((Activity)paramContext).overridePendingTransition(2130772006, 2130772007);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "enterTroopCreateForResult");
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, int paramInt)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.setRequestCode(paramInt);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.7.0", Integer.valueOf(0) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(String.format("&initgrouptype=%s", new Object[] { paramString }));
    paramString = localStringBuilder.toString();
    localObject = new Intent();
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("isShowAd", false);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    a(paramContext, (Intent)localObject, "/base/browser");
    ((Activity)paramContext).overridePendingTransition(2130772006, 2130772007);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "enterTroopCreateFromH5");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    BaseAIOUtils.a(localIntent, null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("isBack2Root", true);
    if ((paramContext instanceof Application)) {
      localIntent.setFlags(268435456);
    }
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    a(paramContext, localIntent, "/base/start/splash");
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    Object localObject = paramAppInterface;
    if (paramAppInterface == null) {
      localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    paramAppInterface = ((AppInterface)localObject).getPreferences();
    localObject = ((AppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("show_new_create_big_troop2_");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    paramAppInterface.edit().putBoolean((String)localObject, true).apply();
  }
  
  public static void a(AppRuntime paramAppRuntime, List<TroopCreateInfo.InviteMemberInfo> paramList)
  {
    Object localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((TroopCreateInfo.InviteMemberInfo)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString.equals(paramAppRuntime.getCurrentAccountUin())) {
        i = 1;
      }
    }
    if (i == 0)
    {
      localObject = new TroopCreateInfo.InviteMemberInfo();
      ((TroopCreateInfo.InviteMemberInfo)localObject).jdField_a_of_type_JavaLangString = paramAppRuntime.getCurrentUin();
      ((TroopCreateInfo.InviteMemberInfo)localObject).jdField_a_of_type_Int = 0;
      paramAppRuntime = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(((TroopCreateInfo.InviteMemberInfo)localObject).jdField_a_of_type_JavaLangString, true);
      if (paramAppRuntime != null) {
        paramAppRuntime = paramAppRuntime.getFriendNick();
      } else {
        paramAppRuntime = String.valueOf(((TroopCreateInfo.InviteMemberInfo)localObject).b);
      }
      ((TroopCreateInfo.InviteMemberInfo)localObject).b = paramAppRuntime;
      paramList.add(localObject);
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    Object localObject = paramAppInterface;
    if (paramAppInterface == null) {
      localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    paramAppInterface = ((AppInterface)localObject).getPreferences();
    localObject = ((AppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("show_new_create_big_troop2_");
    localStringBuilder.append((String)localObject);
    return paramAppInterface.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if (paramString.equals("20001")) {
      paramString = QVIPPrettyTroopProcessor.c().a();
    } else if (paramString.equals("20002")) {
      paramString = QVIPPrettyTroopProcessor.c().b();
    } else {
      paramString = "";
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    a(paramActivity, localIntent, "/base/browser");
  }
  
  public static void b(AppRuntime paramAppRuntime, List<ResultRecord> paramList)
  {
    Object localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((ResultRecord)((Iterator)localObject).next()).uin.equals(paramAppRuntime.getCurrentAccountUin())) {
        i = 1;
      }
    }
    if (i == 0)
    {
      localObject = new ResultRecord();
      ((ResultRecord)localObject).uin = paramAppRuntime.getCurrentUin();
      ((ResultRecord)localObject).type = 0;
      paramAppRuntime = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(((ResultRecord)localObject).uin, true);
      if (paramAppRuntime != null) {
        paramAppRuntime = paramAppRuntime.getFriendNick();
      } else {
        paramAppRuntime = String.valueOf(((ResultRecord)localObject).name);
      }
      ((ResultRecord)localObject).name = paramAppRuntime;
      paramList.add(localObject);
    }
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", paramString);
    a(paramActivity, localIntent, "/base/browser");
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("openCreateHWTroopPage");
      paramActivity.append(paramString);
      QLog.d("createNewTroop.NewTroopCateView", 2, paramActivity.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils
 * JD-Core Version:    0.7.0.1
 */