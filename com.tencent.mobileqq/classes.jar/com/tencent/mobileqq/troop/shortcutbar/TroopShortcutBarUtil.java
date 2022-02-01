package com.tencent.mobileqq.troop.shortcutbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import tencent.im.oidb.cmd0xece.oidb_0xece.ActiveAppTips;
import tencent.im.oidb.cmd0xece.oidb_0xece.App;
import tencent.im.oidb.cmd0xece.oidb_0xece.RspBody;

public class TroopShortcutBarUtil
{
  private static BaseChatPie a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((BaseActivity.sTopActivity instanceof BaseActivity)))
    {
      Object localObject = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if ((localObject != null) && ((localObject instanceof BaseTroopChatPie)) && (((BaseChatPie)localObject).bb() >= 2))
        {
          String str = ((BaseChatPie)localObject).ae();
          if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public static TroopShortcutBarUtil.RemindGrayTipItem a(oidb_0xece.RspBody paramRspBody)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRspBody != null)
    {
      localObject1 = localObject2;
      if (paramRspBody.active_app_tips.has())
      {
        if (!((oidb_0xece.ActiveAppTips)paramRspBody.active_app_tips.get()).apps.has()) {
          return null;
        }
        paramRspBody = ((oidb_0xece.ActiveAppTips)paramRspBody.active_app_tips.get()).apps.get();
        localObject1 = localObject2;
        if (paramRspBody != null)
        {
          localObject1 = localObject2;
          if (paramRspBody.size() > 0)
          {
            paramRspBody = (oidb_0xece.App)paramRspBody.get(0);
            localObject1 = new TroopShortcutBarUtil.RemindGrayTipItem();
            ((TroopShortcutBarUtil.RemindGrayTipItem)localObject1).a = paramRspBody.appid.get();
            ((TroopShortcutBarUtil.RemindGrayTipItem)localObject1).c = paramRspBody.app_name.get();
            ((TroopShortcutBarUtil.RemindGrayTipItem)localObject1).b = paramRspBody.source.get();
            ((TroopShortcutBarUtil.RemindGrayTipItem)localObject1).d = paramRspBody.url.get();
          }
        }
      }
    }
    return localObject1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      TroopShortcutBarUtil.RemindGrayTipItem localRemindGrayTipItem = new TroopShortcutBarUtil.RemindGrayTipItem();
      if (localRemindGrayTipItem.a(paramString2))
      {
        paramString2 = a(paramString1);
        if (paramString2 != null)
        {
          TroopAppShortcutUtils.a(paramQQAppInterface, paramString2.e, paramString2.f, paramString1, localRemindGrayTipItem.a, localRemindGrayTipItem.d, 0, 0);
          return;
        }
        if ((paramContext != null) && ((paramContext instanceof BaseActivity))) {
          TroopAppShortcutUtils.a(paramQQAppInterface, paramContext, (BaseActivity)paramContext, paramString1, localRemindGrayTipItem.a, localRemindGrayTipItem.d, 0, 0);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ReportController.b(null, "dc00898", "", paramString, "0X800B447", "0X800B447", 0, 0, String.valueOf(d(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, TroopShortcutBarUtil.RemindGrayTipItem paramRemindGrayTipItem)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramRemindGrayTipItem != null) && (!TextUtils.isEmpty(paramRemindGrayTipItem.c)))
    {
      if (TextUtils.isEmpty(paramRemindGrayTipItem.d)) {
        return;
      }
      TroopShortcutBarManager localTroopShortcutBarManager = (TroopShortcutBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
      long l = localTroopShortcutBarManager.b(paramString);
      if (l != 0L) {
        b(paramQQAppInterface, paramString, l);
      }
      String str1 = BaseApplicationImpl.getContext().getResources().getString(2131917661);
      String str2 = BaseApplicationImpl.getContext().getResources().getString(2131917662);
      Object localObject1 = BaseApplicationImpl.getContext().getResources().getString(2131917664);
      String str3 = BaseApplicationImpl.getContext().getResources().getString(2131917663);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(paramRemindGrayTipItem.c);
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(str3);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new UniteGrayTipParam(paramString, paramString, (String)localObject2, 1, -5040, 131091, MessageCache.c());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 62);
      localBundle.putString("textColor", "#40A0FF");
      localBundle.putString("key_action_DATA", paramRemindGrayTipItem.a());
      ((UniteGrayTipParam)localObject1).a(str1.length(), str1.length() + paramRemindGrayTipItem.c.length(), localBundle);
      localBundle = new Bundle();
      localBundle.putInt("key_action", 63);
      localBundle.putString("textColor", "#40A0FF");
      localBundle.putString("key_action_DATA", paramRemindGrayTipItem.a());
      ((UniteGrayTipParam)localObject1).a(str1.length() + paramRemindGrayTipItem.c.length() + str2.length(), ((String)localObject2).length() - str3.length(), localBundle);
      paramRemindGrayTipItem = new MessageForUniteGrayTip();
      paramRemindGrayTipItem.createMessageUniseq();
      paramRemindGrayTipItem.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      UniteGrayTipMsgUtil.a(paramQQAppInterface, paramRemindGrayTipItem);
      localTroopShortcutBarManager.b(paramString, paramRemindGrayTipItem.uniseq);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (!((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).Y(paramString1))
      {
        if (BaseActivity.sTopActivity != null) {
          QQToast.makeText(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131917655), 0).show();
        }
        return;
      }
      if ((!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentUin())) && (!TroopUtils.a(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentUin())))
      {
        if (BaseActivity.sTopActivity != null) {
          QQToast.makeText(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131917665), 0).show();
        }
        return;
      }
      boolean bool1 = c(paramQQAppInterface, paramString1);
      TroopShortcutBarUtil.RemindGrayTipItem localRemindGrayTipItem = new TroopShortcutBarUtil.RemindGrayTipItem();
      if (localRemindGrayTipItem.a(paramString2))
      {
        long l = localRemindGrayTipItem.a;
        boolean bool2 = a(paramQQAppInterface, paramString1, l);
        if ((bool1) && (bool2))
        {
          if (BaseActivity.sTopActivity != null) {
            QQToast.makeText(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131917656), 0).show();
          }
          return;
        }
        new AddTroopAppCgi(new TroopShortcutBarUtil.1(bool1, paramString1, paramQQAppInterface, l), paramString1, localRemindGrayTipItem.a, localRemindGrayTipItem.b, true, null).a(paramQQAppInterface);
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramQQAppInterface = ((TroopShortcutBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.a(paramLong) != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramQQAppInterface) {}
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ThreadManager.excute(new TroopShortcutBarUtil.2(paramQQAppInterface, paramString, paramLong), 32, null, true);
    }
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramQQAppInterface = ((TroopShortcutBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.b() == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramQQAppInterface) {}
    return false;
  }
  
  private static long d(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.g(paramString);
        l1 = l2;
        if (paramQQAppInterface != null) {
          l1 = paramQQAppInterface.dwGroupClassExt;
        }
      }
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil
 * JD-Core Version:    0.7.0.1
 */