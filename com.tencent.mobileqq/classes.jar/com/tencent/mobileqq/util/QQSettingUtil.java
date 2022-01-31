package com.tencent.mobileqq.util;

import akim;
import akin;
import akio;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QQSettingUtil
{
  public static int a;
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt("setting_quit_" + paramString, 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getApplicationContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("mywallet_flag", 1);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt)
  {
    if (paramResources == null) {
      return new SpannableString("");
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = new SpannableString("*");
      paramInt = (int)paramResources.getDimension(2131558555);
      paramResources = paramResources.getDrawable(2130843142);
      paramResources.setBounds(0, 0, paramInt, paramInt);
      ((SpannableString)localObject).setSpan(new ImageSpan(paramResources), 0, 1, 33);
      return localObject;
    }
    int k = paramInt / 64;
    paramInt %= 64;
    int m = paramInt / 16;
    int i1 = paramInt % 16;
    int n = i1 / 4;
    String str1 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt = 0;
      localObject = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt)
        {
          str1 = str1 + (String)localObject;
          j += 1;
        }
        localObject = "!";
        paramInt = k;
        continue;
        localObject = "@";
        paramInt = m;
        continue;
        localObject = "#";
        paramInt = n;
        continue;
        localObject = "%";
        paramInt = i1 % 4;
      }
      i += 1;
    }
    if ((a > 1) && (str1.length() > a))
    {
      localObject = str1.substring(0, a - 1);
      str1 = (String)localObject + "$";
    }
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str1);
      i = (int)paramResources.getDimension(2131558555);
      paramInt = 0;
      if (paramInt < str1.length())
      {
        String str2 = str1.substring(paramInt, paramInt + 1);
        if ("!".equalsIgnoreCase(str2))
        {
          localObject = paramResources.getDrawable(2130843140);
          label345:
          if (localObject != null)
          {
            if (!"&".equalsIgnoreCase(str2)) {
              break label494;
            }
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt, paramInt + 1, 33);
          paramInt += 1;
          break;
          if ("@".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130843144);
            break label345;
          }
          if ("#".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130843141);
            break label345;
          }
          if ("%".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130843143);
            break label345;
          }
          if ("$".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846416);
            break label345;
          }
          localObject = null;
          break label345;
          label494:
          ((Drawable)localObject).setBounds(0, 0, i, i);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseQQLevel, sLevel = " + str1 + ", span = " + localSpannableString);
      }
      return localSpannableString;
    }
  }
  
  public static SpannableString a(View paramView, Resources paramResources, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    }
    for (localObject = VipGrayConfigHelper.a().a(((QQAppInterface)localObject).c(), paramLong, paramInt, paramBoolean);; localObject = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return new SpannableString("");
      }
      SpannableString localSpannableString = new SpannableString("KB");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = URLDrawable.getDrawable((String)localObject, new ColorDrawable(), new ColorDrawable());
        if (((URLDrawable)localObject).getStatus() == 1) {
          ((URLDrawable)localObject).setBounds(0, 0, UIUtils.a(BaseApplicationImpl.getContext(), 47.0F), UIUtils.a(BaseApplicationImpl.getContext(), 14.0F));
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((URLDrawable)localObject).setURLDrawableListener(new akin(paramView));
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), 0, 1, 33);
          paramView = paramResources.getDrawable(2130843157);
          paramView.setBounds(0, 0, (int)paramResources.getDimension(2131558556), UIUtils.a(BaseApplicationImpl.getContext(), 5.0F));
          localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
        }
        return localSpannableString;
        ((URLDrawable)localObject).restartDownload();
        ((URLDrawable)localObject).setBounds(0, 0, 1, 1);
        continue;
        localObject = null;
      }
    }
  }
  
  public static SpannableString a(View paramView, Resources paramResources, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(paramView);
    SpannableString localSpannableString = new SpannableString("");
    paramView = null;
    int i = (int)paramResources.getDimension(2131558555);
    Drawable localDrawable;
    if ((paramBoolean1) && (paramInt > 0))
    {
      localSpannableString = new SpannableString("sb");
      paramView = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + paramInt + ".png";
      localDrawable = paramResources.getDrawable(2130843148);
      paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
      paramView.setBounds(0, 0, (int)(68.0D * (i / 24.0D)), i);
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.mutate();
        ((URLDrawable)paramView).setURLDrawableListener(new akio(localWeakReference));
        localSpannableString.setSpan(new ImageSpan(paramView), 0, 1, 33);
        paramView = paramResources.getDrawable(2130843157);
        paramView.setBounds(0, 0, (int)paramResources.getDimension(2131558556), i);
        localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseClubLevel, bSuperVipOpen=" + paramBoolean1 + ", bQQVipOpen=" + paramBoolean2 + ",iVipLevel=" + paramInt);
      }
      return localSpannableString;
      if ((paramBoolean2) && (paramInt > 0))
      {
        localSpannableString = new SpannableString("vb");
        paramView = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + paramInt + ".png";
        localDrawable = paramResources.getDrawable(2130843156);
        paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
        paramView.setBounds(0, 0, (int)(58.0D * (i / 24.0D)), i);
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    if (paramBoolean)
    {
      bool = false;
      localIntent.putExtra("tab_index", MainFragment.a);
    }
    paramQQAppInterface.logout(bool);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    paramActivity.startActivityForResult(localIntent, 1000);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt("setting_quit_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a(new akim(paramQQAppInterface));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramQQAppInterface.getApp();
    boolean bool = SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131433586), "qqsetting_auto_receive_pic_key", true);
    int i;
    Object localObject3;
    if (bool)
    {
      i = 1;
      ((Map)localObject1).put("Clk_auto_receive_pic", Integer.valueOf(i));
      localObject3 = (StatusManager)paramQQAppInterface.getManager(14);
      if (localObject3 != null)
      {
        bool = ((StatusManager)localObject3).b();
        if (!bool) {
          break label1059;
        }
        i = 1;
        label81:
        ((Map)localObject1).put("Clk_signature_qzone", Integer.valueOf(i));
        if (!ConfigHandler.a(paramQQAppInterface, false)) {
          break label1064;
        }
        i = 1;
        label105:
        ((Map)localObject1).put("Download_new", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131436038), "qqsetting_notify_icon_key", false)) {
          break label1069;
        }
        i = 1;
        label142:
        ((Map)localObject1).put("System_icon", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, paramQQAppInterface.getApp().getString(2131433640), "qqsetting_enter_sendmsg_key", false)) {
          break label1074;
        }
        i = 1;
        label181:
        ((Map)localObject1).put("Enter_sendmsg", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, paramQQAppInterface.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true)) {
          break label1079;
        }
        i = 1;
        label216:
        ((Map)localObject1).put("Mobile_pc_online", Integer.valueOf(i));
        if (!paramQQAppInterface.n()) {
          break label1084;
        }
        i = 1;
        label239:
        ((Map)localObject1).put("Visible_same", Integer.valueOf(i));
        if (!paramQQAppInterface.q()) {
          break label1089;
        }
        i = 1;
        label262:
        ((Map)localObject1).put("Same_likeme", Integer.valueOf(i));
        if (!paramQQAppInterface.b(true)) {
          break label1094;
        }
        i = 1;
        label286:
        ((Map)localObject1).put("Search_number", Integer.valueOf(i));
        if (!NearbySPUtil.b(paramQQAppInterface.getAccount())) {
          break label1099;
        }
        i = 1;
        label312:
        ((Map)localObject1).put("Visible_nearby", Integer.valueOf(i));
        if (!paramQQAppInterface.p()) {
          break label1104;
        }
        i = 1;
        label335:
        ((Map)localObject1).put("Nearby_likeme", Integer.valueOf(i));
        if (paramQQAppInterface.e() != 0) {
          break label1109;
        }
        i = 0;
        label358:
        if (i == 0) {
          break label1114;
        }
        i = 1;
        label364:
        ((Map)localObject1).put("Latest_chatlog_syn", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.getCurrentAccountUin()) != 2) {
          break label1119;
        }
        i = 1;
        label393:
        if (i == 0) {
          break label1124;
        }
        i = 1;
        label399:
        ((Map)localObject1).put("Gesture_password", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), null, "security_scan_key", "qqsetting_security_scan_key", false)) {
          break label1129;
        }
        i = 1;
        label433:
        ((Map)localObject1).put("Security_check", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.getCurrentAccountUin()) != 2) {
          break label1134;
        }
        i = 1;
        label462:
        if (i == 0) {
          break label1139;
        }
        i = 1;
        label468:
        ((Map)localObject1).put("Setting_Gesture_password", Integer.valueOf(i));
        if (!TroopAssistantManager.a().a()) {
          break label1144;
        }
        i = 1;
        label493:
        ((Map)localObject1).put("Clk_hide_grp_heper", Integer.valueOf(i));
        if (!TroopAssistantManager.a().b()) {
          break label1149;
        }
        i = 1;
        label518:
        ((Map)localObject1).put("Clk_grp_heper_top", Integer.valueOf(i));
        localObject2 = ((Map)localObject1).keySet();
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", (String)localObject3, 0, 0, String.valueOf(((Map)localObject1).get(localObject3)), "", "", "");
          continue;
        }
        if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), null, paramQQAppInterface.getApp().getString(2131433595), "qqsetting_screenshot_key", false)) {
          break label1154;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.c(false)) {
          break label1159;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X80044D1", "0X80044D1", 0, 0, String.valueOf(i), "", "", "");
        localObject1 = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramQQAppInterface.getCurrentAccountUin());
        if (localObject1 != null)
        {
          if (!((Card)localObject1).allowPeopleSee) {
            break label1164;
          }
          i = 1;
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004884", "0X8004884", 0, 0, String.valueOf(i), "", "", "");
        }
        if (!HotChatManager.b(paramQQAppInterface)) {
          break label1169;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004B1E", "0X8004B1E", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.d(false)) {
          break label1174;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5C", "0X8004C5C", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.e(false)) {
          break label1179;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5D", "0X8004C5D", 0, 0, String.valueOf(i), "", "", "");
        localObject3 = (FriendsManager)paramQQAppInterface.getManager(50);
        i = ((FriendsManager)localObject3).c();
        if (i <= 0) {
          break label1184;
        }
        localObject1 = "1";
        if (i > 0)
        {
          localObject2 = String.valueOf(i);
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C69", "0X8004C69", 0, 0, (String)localObject1, (String)localObject2, String.valueOf(((FriendsManager)localObject3).b()), "");
          if (((ActivateFriendsManager)paramQQAppInterface.getManager(84)).a(false))
          {
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004E0C", "0X8004E0C", 0, i, String.valueOf(i), "", "", "");
            if (!paramQQAppInterface.n) {
              continue;
            }
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004EDE", "0X8004EDE", 0, 0, String.valueOf(i), "", "", "");
          }
        }
        else
        {
          localObject2 = "";
          continue;
        }
        i = 0;
        continue;
        i = 0;
        continue;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      i = 0;
      break;
      label1059:
      i = 0;
      break label81;
      label1064:
      i = 0;
      break label105;
      label1069:
      i = 0;
      break label142;
      label1074:
      i = 0;
      break label181;
      label1079:
      i = 0;
      break label216;
      label1084:
      i = 0;
      break label239;
      label1089:
      i = 0;
      break label262;
      label1094:
      i = 0;
      break label286;
      label1099:
      i = 0;
      break label312;
      label1104:
      i = 0;
      break label335;
      label1109:
      i = 1;
      break label358;
      label1114:
      i = 0;
      break label364;
      label1119:
      i = 0;
      break label393;
      label1124:
      i = 0;
      break label399;
      label1129:
      i = 0;
      break label433;
      label1134:
      i = 0;
      break label462;
      label1139:
      i = 0;
      break label468;
      label1144:
      i = 0;
      break label493;
      label1149:
      i = 0;
      break label518;
      label1154:
      i = 0;
      continue;
      label1159:
      i = 0;
      continue;
      label1164:
      i = 0;
      continue;
      label1169:
      i = 0;
      continue;
      label1174:
      i = 0;
      continue;
      label1179:
      i = 0;
      continue;
      label1184:
      localObject1 = "0";
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet").append('|').append(paramQQAppInterface.getCurrentAccountUin()).append('|').append("").append('|').append("wallet").append('|').append("index").append('|').append(0).append('|').append(1).append('|').append(0).append('|').append("").append('|').append("").append('|').append("").append('|').append("").append('|');
      StatisticCollector.a(null).b(paramQQAppInterface, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil
 * JD-Core Version:    0.7.0.1
 */