package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QQSettingUtil
{
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt("setting_quit_" + paramString, 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getApplicationContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("mywallet_flag", 1);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramResources == null) {
      return new SpannableString("");
    }
    if (!QQLevelIconCallback.isQQLevelIconExists(((AppInterface)localObject).getApp(), paramInt1)) {
      QQLevelIconCallback.downloadQQLevelIcon(paramInt1, null, false);
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    if (paramInt2 == 0)
    {
      localObject = new SpannableString("*");
      paramInt2 = (int)paramResources.getDimension(2131298521);
      paramResources = paramResources.getDrawable(2130846162);
      paramResources = VasApngUtil.getOptimizedApngDrawable(ProfileCardUtil.a(paramInt1, ProfileCardUtil.a), paramResources, VasApngUtil.VIP_APNG_TAGS, "halfStar");
      paramResources.setBounds(0, 0, paramInt2, paramInt2);
      if (bool) {
        paramResources.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        ((SpannableString)localObject).setSpan(new ImageSpan(paramResources), 0, 1, 33);
        return localObject;
        paramResources.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      }
    }
    int k = paramInt2 / 64;
    paramInt2 %= 64;
    int m = paramInt2 / 16;
    int i1 = paramInt2 % 16;
    int n = i1 / 4;
    String str1 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt2 = 0;
      localObject = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt2)
        {
          str1 = str1 + (String)localObject;
          j += 1;
        }
        localObject = "!";
        paramInt2 = k;
        continue;
        localObject = "@";
        paramInt2 = m;
        continue;
        localObject = "#";
        paramInt2 = n;
        continue;
        localObject = "%";
        paramInt2 = i1 % 4;
      }
      i += 1;
    }
    if ((paramInt3 > 1) && (str1.length() > paramInt3))
    {
      localObject = str1.substring(0, paramInt3 - 1);
      str1 = (String)localObject + "$";
    }
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str1);
      paramInt3 = (int)paramResources.getDimension(2131298521);
      paramInt2 = 0;
      if (paramInt2 < str1.length())
      {
        String str2 = str1.substring(paramInt2, paramInt2 + 1);
        if ("!".equalsIgnoreCase(str2))
        {
          localObject = paramResources.getDrawable(2130846160);
          localObject = VasApngUtil.getOptimizedApngDrawable(ProfileCardUtil.a(paramInt1, ProfileCardUtil.e), (Drawable)localObject, VasApngUtil.VIP_APNG_TAGS, "crown");
          label448:
          if (localObject != null)
          {
            if (!"&".equalsIgnoreCase(str2)) {
              break label669;
            }
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
            label480:
            if (!bool) {
              break label681;
            }
            ((Drawable)localObject).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt2, paramInt2 + 1, 33);
          paramInt2 += 1;
          break;
          if ("@".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846164);
            localObject = VasApngUtil.getOptimizedApngDrawable(ProfileCardUtil.a(paramInt1, ProfileCardUtil.d), (Drawable)localObject, VasApngUtil.VIP_APNG_TAGS, "sun");
            break label448;
          }
          if ("#".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846161);
            localObject = VasApngUtil.getOptimizedApngDrawable(ProfileCardUtil.a(paramInt1, ProfileCardUtil.c), (Drawable)localObject, VasApngUtil.VIP_APNG_TAGS, "moon");
            break label448;
          }
          if ("%".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846163);
            localObject = VasApngUtil.getOptimizedApngDrawable(ProfileCardUtil.a(paramInt1, ProfileCardUtil.b), (Drawable)localObject, VasApngUtil.VIP_APNG_TAGS, "star");
            break label448;
          }
          if ("$".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130851256);
            break label448;
          }
          localObject = null;
          break label448;
          label669:
          ((Drawable)localObject).setBounds(0, 0, paramInt3, paramInt3);
          break label480;
          label681:
          ((Drawable)localObject).setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
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
    for (localObject = VipGrayConfigHelper.a().a(((QQAppInterface)localObject).getCurrentUin(), paramLong, paramInt, paramBoolean);; localObject = "")
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
          ((URLDrawable)localObject).setURLDrawableListener(new QQSettingUtil.2(paramView));
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), 0, 1, 33);
          paramView = paramResources.getDrawable(2130846185);
          paramView.setBounds(0, 0, (int)paramResources.getDimension(2131297250), UIUtils.a(BaseApplicationImpl.getContext(), 5.0F));
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
    int i = (int)paramResources.getDimension(2131297279);
    Drawable localDrawable;
    if ((paramBoolean1) && (paramInt > 0))
    {
      localSpannableString = new SpannableString("sb");
      paramView = "https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + paramInt + ".png";
      localDrawable = paramResources.getDrawable(2130847429);
      paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
      paramView.setBounds(0, 0, (int)(68.0D * (i / 24.0D)), i);
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.mutate();
        ((URLDrawable)paramView).setURLDrawableListener(new QQSettingUtil.3(localWeakReference));
        localSpannableString.setSpan(new ImageSpan(paramView), 0, 1, 33);
        paramView = paramResources.getDrawable(2130846185);
        paramView.setBounds(0, 0, (int)paramResources.getDimension(2131297250), i);
        localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseClubLevel, bSuperVipOpen=" + paramBoolean1 + ", bQQVipOpen=" + paramBoolean2 + ",iVipLevel=" + paramInt);
      }
      return localSpannableString;
      if ((paramBoolean2) && (paramInt > 0))
      {
        localSpannableString = new SpannableString("vb");
        paramView = "https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + paramInt + ".png";
        localDrawable = paramResources.getDrawable(2130847430);
        paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
        paramView.setBounds(0, 0, (int)(58.0D * (i / 24.0D)), i);
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    if (paramBoolean)
    {
      bool = false;
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
    }
    paramQQAppInterface.logout(bool);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    int i = a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    RouteUtils.a(paramActivity, localIntent, "/base/login", 1000);
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
    paramQQAppInterface.execute(new QQSettingUtil.1(paramQQAppInterface));
  }
  
  static void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramQQAppInterface.getApp();
    boolean bool = SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131694996), "qqsetting_auto_receive_pic_key", true);
    int i;
    Object localObject3;
    if (bool)
    {
      i = 1;
      ((Map)localObject1).put("Clk_auto_receive_pic", Integer.valueOf(i));
      localObject3 = (StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
      if (localObject3 != null)
      {
        bool = ((StatusManager)localObject3).b();
        if (!bool) {
          break label1201;
        }
        i = 1;
        label84:
        ((Map)localObject1).put("Clk_signature_qzone", Integer.valueOf(i));
        if (!ConfigHandler.a(paramQQAppInterface, false)) {
          break label1206;
        }
        i = 1;
        label109:
        ((Map)localObject1).put("Download_new", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131719122), "qqsetting_notify_icon_key", false)) {
          break label1211;
        }
        i = 1;
        label147:
        ((Map)localObject1).put("System_icon", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, paramQQAppInterface.getApp().getString(2131694981), "qqsetting_enter_sendmsg_key", false)) {
          break label1216;
        }
        i = 1;
        label187:
        ((Map)localObject1).put("Enter_sendmsg", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, paramQQAppInterface.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true)) {
          break label1221;
        }
        i = 1;
        label223:
        ((Map)localObject1).put("Mobile_pc_online", Integer.valueOf(i));
        if (!paramQQAppInterface.getLocVisibilityForStatus()) {
          break label1226;
        }
        i = 1;
        label247:
        ((Map)localObject1).put("Visible_same", Integer.valueOf(i));
        if (!paramQQAppInterface.getLocZanAllowedForStatus()) {
          break label1231;
        }
        i = 1;
        label271:
        ((Map)localObject1).put("Same_likeme", Integer.valueOf(i));
        if (!paramQQAppInterface.isPhoneNumSearchable(true)) {
          break label1236;
        }
        i = 1;
        label296:
        ((Map)localObject1).put("Search_number", Integer.valueOf(i));
        if (!NearbySPUtil.b(paramQQAppInterface.getAccount())) {
          break label1241;
        }
        i = 1;
        label323:
        ((Map)localObject1).put("Visible_nearby", Integer.valueOf(i));
        if (!paramQQAppInterface.getLocZanAllowedForPeople()) {
          break label1246;
        }
        i = 1;
        label347:
        ((Map)localObject1).put("Nearby_likeme", Integer.valueOf(i));
        if (paramQQAppInterface.getC2CRoamingSetting() != 0) {
          break label1251;
        }
        i = 0;
        label371:
        if (i == 0) {
          break label1256;
        }
        i = 1;
        label377:
        ((Map)localObject1).put("Latest_chatlog_syn", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.getCurrentAccountUin()) != 2) {
          break label1261;
        }
        i = 1;
        label407:
        if (i == 0) {
          break label1266;
        }
        i = 1;
        label413:
        ((Map)localObject1).put("Gesture_password", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), null, "security_scan_key", "qqsetting_security_scan_key", false)) {
          break label1271;
        }
        i = 1;
        label448:
        ((Map)localObject1).put("Security_check", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.getCurrentAccountUin()) != 2) {
          break label1276;
        }
        i = 1;
        label478:
        if (i == 0) {
          break label1281;
        }
        i = 1;
        label484:
        ((Map)localObject1).put("Setting_Gesture_password", Integer.valueOf(i));
        if (!TroopAssistantManager.a().a()) {
          break label1286;
        }
        i = 1;
        label510:
        ((Map)localObject1).put("Clk_hide_grp_heper", Integer.valueOf(i));
        if (!TroopAssistantManager.a().b()) {
          break label1291;
        }
        i = 1;
        label536:
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
        if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), null, paramQQAppInterface.getApp().getString(2131694985), "qqsetting_screenshot_key", false)) {
          break label1296;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.getVisibilityForNetWorkStatus(false)) {
          break label1301;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X80044D1", "0X80044D1", 0, 0, String.valueOf(i), "", "", "");
        localObject1 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramQQAppInterface.getCurrentAccountUin());
        if (localObject1 != null)
        {
          if (!((Card)localObject1).allowPeopleSee) {
            break label1306;
          }
          i = 1;
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004884", "0X8004884", 0, 0, String.valueOf(i), "", "", "");
        }
        if (!HotChatManager.b(paramQQAppInterface)) {
          break label1311;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004B1E", "0X8004B1E", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.getNotAllowedSeeMyDongtai(false)) {
          break label1316;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5C", "0X8004C5C", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.getShieldHisDongtai(false)) {
          break label1321;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5D", "0X8004C5D", 0, 0, String.valueOf(i), "", "", "");
        localObject3 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        i = ((FriendsManager)localObject3).c();
        if (i <= 0) {
          break label1326;
        }
        localObject1 = "1";
        if (i > 0)
        {
          localObject2 = String.valueOf(i);
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C69", "0X8004C69", 0, 0, (String)localObject1, (String)localObject2, String.valueOf(((FriendsManager)localObject3).b()), "");
          if (((ActivateFriendsManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(false))
          {
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004E0C", "0X8004E0C", 0, i, String.valueOf(i), "", "", "");
            if (!paramQQAppInterface.isCallTabShow) {
              continue;
            }
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004EDE", "0X8004EDE", 0, 0, String.valueOf(i), "", "", "");
            localObject1 = ((CTEntryMng)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).a();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label1195;
            }
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label1195;
            }
            localObject2 = (CTEntry)((Iterator)localObject1).next();
            int j = ((CTEntry)localObject2).a;
            if (!((CTEntry)localObject2).e) {
              continue;
            }
            i = 2;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X80097A1", "0X80097A1", j, 0, String.valueOf(i), "", "", "");
            continue;
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
        i = 1;
        continue;
      }
      catch (Exception paramQQAppInterface) {}
      label1195:
      return;
      i = 0;
      break;
      label1201:
      i = 0;
      break label84;
      label1206:
      i = 0;
      break label109;
      label1211:
      i = 0;
      break label147;
      label1216:
      i = 0;
      break label187;
      label1221:
      i = 0;
      break label223;
      label1226:
      i = 0;
      break label247;
      label1231:
      i = 0;
      break label271;
      label1236:
      i = 0;
      break label296;
      label1241:
      i = 0;
      break label323;
      label1246:
      i = 0;
      break label347;
      label1251:
      i = 1;
      break label371;
      label1256:
      i = 0;
      break label377;
      label1261:
      i = 0;
      break label407;
      label1266:
      i = 0;
      break label413;
      label1271:
      i = 0;
      break label448;
      label1276:
      i = 0;
      break label478;
      label1281:
      i = 0;
      break label484;
      label1286:
      i = 0;
      break label510;
      label1291:
      i = 0;
      break label536;
      label1296:
      i = 0;
      continue;
      label1301:
      i = 0;
      continue;
      label1306:
      i = 0;
      continue;
      label1311:
      i = 0;
      continue;
      label1316:
      i = 0;
      continue;
      label1321:
      i = 0;
      continue;
      label1326:
      localObject1 = "0";
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet").append('|').append(paramQQAppInterface.getCurrentAccountUin()).append('|').append("").append('|').append("wallet").append('|').append("index").append('|').append(0).append('|').append(1).append('|').append(0).append('|').append("").append('|').append("").append('|').append("").append('|').append("").append('|');
      StatisticCollector.getInstance(null).reportToPCliOper(paramQQAppInterface, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil
 * JD-Core Version:    0.7.0.1
 */