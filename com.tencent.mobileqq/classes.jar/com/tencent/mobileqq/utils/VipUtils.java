package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.TmViewHolder;
import com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder;
import com.tencent.mobileqq.apollo.api.uitls.IApolloConfigDataReportHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.qvip.QVipExtendIconConfig;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper.HighLightUrlPattern;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeCleaner;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.quickat.ui.QuickAtListAdapter.ViewHolder;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x120.SubMsgType0x120.MsgBody;

public class VipUtils
{
  static long jdField_a_of_type_Long;
  static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  
  public static int a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -100)) {
      return 0;
    }
    if ((paramInt & 0x2) != 0)
    {
      if ((paramInt & 0x100) != 0) {
        return 4;
      }
      return 3;
    }
    if ((paramInt & 0x100) != 0) {
      return 2;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    Date localDate1 = new Date(paramInt1 * 1000L);
    Date localDate2 = new Date(paramInt2 * 1000L);
    localDate1.setHours(0);
    localDate1.setMinutes(0);
    localDate1.setSeconds(0);
    localDate2.setHours(0);
    localDate2.setMinutes(0);
    localDate2.setSeconds(0);
    return (int)((localDate2.getTime() - localDate1.getTime()) / 86400000L);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    int j = a(paramQQAppInterface, paramString);
    if ((j & 0x4) != 0) {
      i = 2;
    }
    while ((j & 0x2) == 0) {
      return i;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 0;
      } while ((paramQQAppInterface == null) || (!RelationVipHelper.a().a()));
      return paramQQAppInterface.relationIconFlag >> paramInt * 2 & 0x3;
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.relationIconFlag >> paramInt * 2 & 0x7;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int j = -1;
    int i = j;
    String str;
    if (paramQQAppInterface != null)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.getCurrentAccountUin();
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramQQAppInterface == null) {
        break label121;
      }
      if (!paramBoolean) {
        break label78;
      }
      paramQQAppInterface = paramQQAppInterface.e(str);
      if (paramQQAppInterface == null) {
        break label102;
      }
      paramBoolean = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label88;
      }
      i = 3;
    }
    label78:
    label88:
    label102:
    label121:
    do
    {
      for (;;)
      {
        return i;
        paramQQAppInterface = paramQQAppInterface.c(str);
        break;
        if (paramBoolean)
        {
          i = 2;
        }
        else
        {
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("VipUtils", 2, "getUserStatus Friends is null");
          }
          i = -1;
        }
      }
      i = j;
    } while (!QLog.isColorLevel());
    QLog.e("VipUtils", 2, "getUserStatus FriendsManagerImp is null");
    return -1;
  }
  
  public static int a(StrangerInfo paramStrangerInfo)
  {
    int k = 0;
    int i;
    int j;
    if ((paramStrangerInfo.mVipType & 0x2) != 0)
    {
      i = 1;
      j = k;
      if (!paramStrangerInfo.mVipHide)
      {
        if ((paramStrangerInfo.mBigVipHide) || (paramStrangerInfo.mBigVipLevel <= 0)) {
          break label49;
        }
        j = i + 768;
      }
    }
    label49:
    do
    {
      return j;
      i = 0;
      break;
      if (((paramStrangerInfo.mVipType & 0x100) != 0) && (paramStrangerInfo.mVipLevel > 0)) {
        return i + 512;
      }
      j = k;
    } while (paramStrangerInfo.mVipType == 0);
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramInt;
      if (TextUtils.isDigitsOnly(paramString)) {
        i = Integer.valueOf(paramString).intValue();
      }
    }
    return i;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    int j = 0;
    int m = 0;
    int i = j;
    label77:
    int k;
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramAppRuntime == null) {
        break label152;
      }
      paramAppRuntime = paramAppRuntime.e(str);
      if (paramAppRuntime == null) {
        break label134;
      }
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label118;
      }
      i = 1;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label123;
      }
      j = 2;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label128;
      }
      k = 4;
      label90:
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
        m = 8;
      }
      i = m | k | 0x0 | i | j;
    }
    label118:
    label123:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label77;
        k = 0;
        break label90;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    label128:
    label134:
    label152:
    QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
    return 0;
  }
  
  public static Drawable a(int paramInt, Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return paramDrawable;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i == 0) || (j == 0));
    paramDrawable.setBounds(0, 0, i * paramInt / j, paramInt);
    return paramDrawable;
  }
  
  public static SpannableString a(int paramInt1, int paramInt2)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = a(i, paramInt1);
    Object localObject = "";
    if (j >= 0)
    {
      if (j != 0) {
        break label126;
      }
      localObject = HardCodeUtil.a(2131716624);
    }
    String str;
    for (;;)
    {
      str = HardCodeUtil.a(2131716616);
      switch (paramInt2)
      {
      default: 
        return null;
        label126:
        if (j == 1) {
          localObject = HardCodeUtil.a(2131716608);
        } else if (j == 2) {
          localObject = HardCodeUtil.a(2131716633);
        } else {
          localObject = j + HardCodeUtil.a(2131716627);
        }
        break;
      }
    }
    localObject = new SpannableString(HardCodeUtil.a(2131716606) + (String)localObject + HardCodeUtil.a(2131716621) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(HardCodeUtil.a(2131716640) + (String)localObject + HardCodeUtil.a(2131716604) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(HardCodeUtil.a(2131716613) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(HardCodeUtil.a(2131716628) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    return new SpannableString(HardCodeUtil.a(2131716619) + (String)localObject + HardCodeUtil.a(2131716637));
    return new SpannableString(HardCodeUtil.a(2131716614) + (String)localObject + HardCodeUtil.a(2131716607));
    return new SpannableString(HardCodeUtil.a(2131716610));
    return new SpannableString(HardCodeUtil.a(2131716626));
    return new SpannableString(HardCodeUtil.a(2131716629));
    return new SpannableString(HardCodeUtil.a(2131716622));
    localObject = new SpannableString(HardCodeUtil.a(2131716634) + (String)localObject + HardCodeUtil.a(2131716603) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(HardCodeUtil.a(2131716635) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    paramInt1 = a(i, paramInt1) + 30;
    if (paramInt1 >= 0) {
      if (paramInt1 == 0) {
        localObject = HardCodeUtil.a(2131716612);
      }
    }
    for (;;)
    {
      localObject = new SpannableString(HardCodeUtil.a(2131716630) + (String)localObject + HardCodeUtil.a(2131716620) + str);
      paramInt1 = ((SpannableString)localObject).length() - str.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
      return localObject;
      if (paramInt1 == 1)
      {
        localObject = HardCodeUtil.a(2131716639);
      }
      else if (paramInt1 == 2)
      {
        localObject = HardCodeUtil.a(2131716618);
      }
      else
      {
        localObject = paramInt1 + HardCodeUtil.a(2131716615);
        continue;
        localObject = HardCodeUtil.a(2131716605);
      }
    }
    return new SpannableString(HardCodeUtil.a(2131716617));
    return new SpannableString(HardCodeUtil.a(2131716625));
    return new SpannableString(HardCodeUtil.a(2131716631));
    return new SpannableString(HardCodeUtil.a(2131716609));
  }
  
  private static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return "";
            if ("C2C_click".equals(paramString)) {
              return "0X800A9C6";
            }
          } while (!"C2C_show".equals(paramString));
          return "0X800A9C4";
          if ("C2C_click".equals(paramString)) {
            return "0X800A75D";
          }
        } while (!"C2C_show".equals(paramString));
        return "0X800A75B";
        if ("C2C_click".equals(paramString)) {
          return "0X800A9CC";
        }
      } while (!"C2C_show".equals(paramString));
      return "0X800A9CA";
      if ("C2C_click".equals(paramString)) {
        return "0X800A9C9";
      }
    } while (!"C2C_show".equals(paramString));
    return "0X800A9C7";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    int i = a(paramAppInterface, paramString);
    if ((i & 0x4) != 0) {
      return "2";
    }
    if ((i & 0x2) != 0) {
      return "1";
    }
    return "0";
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (a(paramQQAppInterface)) {
      return "bvip";
    }
    if (b(paramQQAppInterface)) {
      return "svip";
    }
    if (c(paramQQAppInterface)) {
      return "vip";
    }
    return "normal";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.replace("-", "_");
      paramString = str;
    } while (str.contains("_"));
    return "jhan_" + str;
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime, paramString, true);
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString, EVIPSPEC paramEVIPSPEC)
  {
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(str);
        if (paramAppRuntime != null)
        {
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_BIGCLUB) | 0x300);
          }
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) | 0x200);
          }
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) | 0x100);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
        }
      }
      for (;;)
      {
        return 0;
        if (QLog.isColorLevel()) {
          QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
        }
      }
    }
    return 0;
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(str);
        if (paramAppRuntime != null)
        {
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_BIGCLUB) | 0x300);
          }
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) | 0x200);
          }
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) | 0x100);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
        }
      }
      for (;;)
      {
        return 0;
        if (QLog.isColorLevel()) {
          QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
        }
      }
    }
    return 0;
  }
  
  public static void a(Activity paramActivity, VipUtils.RechargeParams paramRechargeParams)
  {
    if ((paramRechargeParams == null) || (paramActivity == null) || (TextUtils.isEmpty(paramRechargeParams.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramRechargeParams.d)) || (TextUtils.isEmpty(paramRechargeParams.e)) || (TextUtils.isEmpty(paramRechargeParams.b)) || (TextUtils.isEmpty(paramRechargeParams.c)) || (paramRechargeParams.jdField_a_of_type_Int < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", paramRechargeParams.b);
        ((JSONObject)localObject).put("aid", paramRechargeParams.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(paramRechargeParams.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("offerId", paramRechargeParams.e);
        ((JSONObject)localObject).put("serviceName", paramRechargeParams.c);
        ((JSONObject)localObject).put("userId", paramRechargeParams.jdField_a_of_type_JavaLangString);
        if (!paramRechargeParams.jdField_a_of_type_Boolean) {
          ((JSONObject)localObject).put("isCanChange", false);
        }
        localObject = ((JSONObject)localObject).toString();
        if (paramRechargeParams.f == null) {
          break label233;
        }
        paramRechargeParams = paramRechargeParams.f;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, paramRechargeParams);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VipUtils", 2, "openRechargeDialog exception : " + paramActivity.getMessage());
      return;
      label233:
      paramRechargeParams = "";
    }
  }
  
  public static void a(Context paramContext)
  {
    a(0, "mvip.pingtai.mobileqq.androidziliaoka.fromqita", "qita", IndividuationUrlHelper.a("kuoliePersonalCardMaster"), paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str2 = IndividuationUrlHelper.a("extendnameplatejumpurl_" + paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://h5.qzone.qq.com/v2/vip/dhy/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32";
    }
    VasWebviewUtil.openQQBrowserActivity(paramContext, str1, 256L, null, false, -1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener, paramString4, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt, boolean paramBoolean)
  {
    paramContext = DialogUtil.a(paramContext, 0, HardCodeUtil.a(2131716623), paramString2, paramString3, HardCodeUtil.a(2131716602), new VipUtils.1(paramBoolean, paramContext, paramString1, paramString4, paramInt), paramOnClickListener);
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    String str = HardCodeUtil.a(2131716632);
    if (paramBoolean) {}
    for (int i = 16;; i = 9)
    {
      paramContext = DialogUtil.a(paramContext, 0, str, a(0, i).toString(), HardCodeUtil.a(2131716638), null, null, new VipUtils.2());
      if (!paramContext.isShowing()) {
        paramContext.show();
      }
      return;
    }
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, new VipUtils.5(paramResources, paramString, paramImageView, paramDrawable));
    if (paramString != null)
    {
      int i = AIOUtils.a(15.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
        paramImageView.setColorFilter(1996488704);
      }
    }
    else
    {
      return;
    }
    paramImageView.setColorFilter(0);
  }
  
  public static void a(View paramView)
  {
    VipUtils.UpdateRecentEfficientVipIconTask.Manager.a(paramView);
  }
  
  public static void a(View paramView, int paramInt, String paramString)
  {
    Context localContext = paramView.getContext();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt >> 8 == 3)
    {
      a(localQQAppInterface, localContext, paramInt, paramString, "jhan_dhyc2cicon");
      return;
    }
    if (b(localQQAppInterface))
    {
      paramView = new StringBuilder();
      paramView.append(IndividuationUrlHelper.a("NameplateClickSvip"));
      paramView.append("&qq=");
      paramView.append(paramString);
      paramView = paramView.toString();
    }
    for (paramString = "click_pk";; paramString = "click_getit")
    {
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("fragmentStyle", 3);
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localContext.startActivity(localIntent);
      VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.getCurrentAccountUin(), "nameplate", paramString, "", 1, 0, 0, "", "", "");
      return;
      paramView = IndividuationUrlHelper.a("NameplateClickDefault");
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    FriendsManager localFriendsManager = (FriendsManager)((BaseActivity)paramContext).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localFriendsManager != null) && (localFriendsManager.a(paramString) != null)) {
      VipUtils.UpdateRecentEfficientVipIconTask.a(paramContext, paramString, paramRecentEfficientItemBuilderHolder);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - start");
      }
      paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
      paramRecentEfficientItemBuilderHolder.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    } while (localFriendsManager == null);
    paramView = new VipUtils.UpdateRecentEfficientVipIconTask(paramView, paramContext, paramString, paramRecentEfficientItemBuilderHolder);
    VipUtils.UpdateRecentEfficientVipIconTask.Manager.a(paramView);
    ThreadManagerV2.executeOnSubThread(new VipUtils.3(localFriendsManager, paramString, paramView));
  }
  
  public static void a(View paramView, StrangerInfo paramStrangerInfo)
  {
    int i = a(paramStrangerInfo);
    Context localContext = paramView.getContext();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      if (paramStrangerInfo.mIsMyFeed) {
        if (i >> 8 == 3) {
          a(localQQAppInterface, localContext, "dhykl");
        }
      }
    }
    for (;;)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009F0C", "0X8009F0C", 0, 0, "", "", "", "");
      return;
      a(localContext);
      continue;
      b(paramView, i, paramStrangerInfo.mUin);
      continue;
      QLog.e("VipUtils", 1, "klClickVipIcon: app is null");
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        ReportController.b(localQQAppInterface, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        ((IApolloConfigDataReportHelper)QRoute.api(IApolloConfigDataReportHelper.class)).interceptReport(paramAppInterface, paramString1, paramString2, paramString3, "", paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        AppIntefaceReportWrap.a(paramAppInterface, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        break;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
    {
      ReportController.b(null, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      break;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if (paramString4 == null) {
      paramString4 = "";
    }
    for (;;)
    {
      if ((paramAppInterface instanceof QQAppInterface))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
        if (TextUtils.isEmpty(paramString1)) {}
        for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
        {
          ReportController.b(localQQAppInterface, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          ((IApolloConfigDataReportHelper)QRoute.api(IApolloConfigDataReportHelper.class)).interceptReport(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          return;
        }
      }
      if (paramAppInterface != null)
      {
        if (TextUtils.isEmpty(paramString1)) {}
        for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
        {
          AppIntefaceReportWrap.a(paramAppInterface, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          break;
        }
      }
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        ReportController.b(null, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        break;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      VipUtils.RechargeParams localRechargeParams = new VipUtils.RechargeParams();
      localRechargeParams.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localRechargeParams.d = paramString;
      localRechargeParams.e = "1450000515";
      localRechargeParams.b = "LTMCLUB";
      localRechargeParams.c = paramBaseActivity.getString(2131695088);
      localRechargeParams.jdField_a_of_type_Int = paramInt;
      localRechargeParams.f = "vip";
      a(paramBaseActivity, localRechargeParams);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    VipUtils.RechargeParams localRechargeParams;
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      localRechargeParams = new VipUtils.RechargeParams();
      localRechargeParams.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localRechargeParams.d = paramString;
      localRechargeParams.jdField_a_of_type_Int = paramInt;
      localRechargeParams.jdField_a_of_type_Boolean = paramBoolean2;
      if (!paramBoolean1) {
        break label103;
      }
      localRechargeParams.e = "1450000516";
      localRechargeParams.b = "CJCLUBT";
      localRechargeParams.c = paramBaseActivity.getString(2131719674);
    }
    for (localRechargeParams.f = "svip";; localRechargeParams.f = "vip")
    {
      a(paramBaseActivity, localRechargeParams);
      return;
      label103:
      localRechargeParams.e = "1450000515";
      localRechargeParams.b = "LTMCLUB";
      localRechargeParams.c = paramBaseActivity.getString(2131695088);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, long paramLong, String paramString)
  {
    String str = NamePlateCfgInfo.getVipNamePlateJumUrl(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramInt, paramLong);
    if (QLog.isColorLevel()) {
      QLog.i("VipUtils", 2, "NamePlate clickFriendVipIcon jumpUrl = " + str + " aid = " + paramString + " vipType = " + paramInt + " namePlateId = " + paramLong);
    }
    if (paramLong > 0L) {
      NamePlateCfgInfo.vipNamePlateClickReport(paramQQAppInterface, paramLong);
    }
    if (TextUtils.isEmpty(str))
    {
      a(paramQQAppInterface, paramContext, paramString);
      return;
    }
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", str);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      paramString1 = localFriendsManager.e(paramString1);
      if (paramString1 != null) {}
      for (int i = paramString1.bigClubTemplateId;; i = 0)
      {
        a(paramQQAppInterface, paramContext, paramInt >> 8 | (paramInt & 0xF) << 8, i, paramString2);
        return;
      }
    }
    a(paramQQAppInterface, paramContext, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    if (SimpleUIUtil.a())
    {
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167033));
      return;
    }
    if (b(paramATroopMember.i) != 0)
    {
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
      return;
    }
    switch (a(paramATroopMember.f))
    {
    default: 
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167033));
      return;
    case 1: 
    case 3: 
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
      return;
    case 2: 
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
      return;
    }
    paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, ChatHistoryTroopMemberFragment.TmViewHolder paramTmViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (SimpleUIUtil.a())
    {
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167033));
      return;
    }
    if (b(paramATroopMember.j) != 0)
    {
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
      return;
    }
    switch (a(paramATroopMember.g))
    {
    default: 
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167033));
      return;
    case 1: 
    case 3: 
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
      return;
    case 2: 
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
      return;
    }
    paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167177));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (SimpleUIUtil.a())
    {
      paramViewHolder.a.setTextColor(paramResources.getColor(2131167033));
      return;
    }
    if (b(paramATroopMember.j) != 0)
    {
      paramViewHolder.a.setTextColor(paramResources.getColor(2131167177));
      return;
    }
    switch (a(paramATroopMember.g))
    {
    default: 
      paramViewHolder.a.setTextColor(paramResources.getColor(2131167033));
      return;
    case 1: 
    case 3: 
      paramViewHolder.a.setTextColor(paramResources.getColor(2131167177));
      return;
    case 2: 
      paramViewHolder.a.setTextColor(paramResources.getColor(2131167177));
      return;
    }
    paramViewHolder.a.setTextColor(paramResources.getColor(2131167177));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramString = String.format("https://h5.qzone.qq.com/bigVip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source=%s&_proxy=1", new Object[] { paramString });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("uin", paramQQAppInterface);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramString, 256L, localIntent, false, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StrangerInfo paramStrangerInfo, NavBarAIO paramNavBarAIO, ImageView paramImageView, boolean paramBoolean)
  {
    if (SimpleUIUtil.a()) {
      QLog.d("VipUtils", 1, "updateVipTitleAndCard strangerInfo , SimpleUIMode is open now");
    }
    while (!a()) {
      return;
    }
    String str = VipUtils.VipIconUtils.a(paramStrangerInfo);
    int i = a(paramStrangerInfo);
    if (i >> 8 == 3) {
      paramNavBarAIO.setTitleIconRight(str, 2130847431);
    }
    while (i != 0)
    {
      paramImageView.setContentDescription(HardCodeUtil.a(2131716611));
      paramImageView.setFocusableInTouchMode(true);
      paramImageView.setOnTouchListener(new VipUtils.VipTouchListener(paramQQAppInterface, paramBoolean, paramImageView, paramStrangerInfo.mUin, a(paramStrangerInfo), true));
      return;
      if (i >> 8 == 2) {
        paramNavBarAIO.setTitleIconRight(str, 2130847431);
      } else {
        paramNavBarAIO.setTitleIconRight("", 0);
      }
    }
    paramImageView.setOnTouchListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NavBarAIO paramNavBarAIO, ImageView paramImageView, boolean paramBoolean)
  {
    if (SimpleUIUtil.a())
    {
      QLog.d("VipUtils", 1, "updateVipTitleAndCard, SimpleUIMode is open now");
      paramNavBarAIO.setTitleIconRight("", 0);
      paramImageView.setOnTouchListener(null);
      return;
    }
    Object localObject = VipUtils.VipIconUtils.a(paramQQAppInterface, paramString);
    paramBoolean = VipUtils.VipIconUtils.a(localObject[0]);
    label129:
    int i;
    if (paramBoolean)
    {
      VipUtils.VipIconUtils.NamePlateVipTpye localNamePlateVipTpye = VipUtils.VipIconUtils.NamePlateVipTpye.a(localObject[0]);
      if ((!VipUtils.VipIconUtils.b(localObject[1])) && (!localNamePlateVipTpye.a()))
      {
        paramNavBarAIO.setTitleIconRight(VipUtils.VipIconUtils.a(paramQQAppInterface, paramString, localNamePlateVipTpye, false), VipUtils.VipIconUtils.a(localNamePlateVipTpye));
        paramImageView.setContentDescription(HardCodeUtil.a(2131716636));
        paramImageView.setFocusableInTouchMode(true);
        localObject = VipUtils.VipIconUtils.VipIconTouchListener.a(paramQQAppInterface, paramString, "VIA_AIO_TITLE");
        ((VipUtils.VipIconUtils.VipIconTouchListener)localObject).a();
        paramImageView.setOnTouchListener((View.OnTouchListener)localObject);
      }
    }
    else
    {
      if (paramBoolean) {
        break label261;
      }
      i = a(paramQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "bindView: vip=" + i);
      }
      if (i >> 8 != 3) {
        break label263;
      }
      paramNavBarAIO.setTitleIconRight(VipUtils.VipIconUtils.a(paramQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB), 2130847431);
      NamePlateCfgInfo.vipNamePlateExposeReport(paramQQAppInterface, paramString);
    }
    for (;;)
    {
      if (a(paramQQAppInterface, paramString, false) != 3) {
        break label325;
      }
      paramImageView.setContentDescription(HardCodeUtil.a(2131716636));
      paramImageView.setFocusableInTouchMode(true);
      paramQQAppInterface = VipUtils.VipIconUtils.VipIconTouchListener.a(paramQQAppInterface, paramString, "VIA_AIO_TITLE");
      paramQQAppInterface.a();
      paramImageView.setOnTouchListener(paramQQAppInterface);
      return;
      paramNavBarAIO.setTitleIconRight("", 0);
      paramImageView.setOnTouchListener(null);
      break label129;
      label261:
      break;
      label263:
      if (i >> 8 == 2)
      {
        localObject = VipUtils.VipIconUtils.a(paramQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
        if ((i & 0xF) == 1) {
          paramNavBarAIO.setTitleIconRight((String)localObject, 2130847431);
        } else {
          paramNavBarAIO.setTitleIconRight((String)localObject, 2130847429);
        }
      }
      else
      {
        paramNavBarAIO.setTitleIconRight("", 0);
      }
    }
    label325:
    paramImageView.setOnTouchListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    if (a(String.valueOf(paramMsgBody.uint64_frd_uin.get()), paramMsgBody.uint32_notice_time.get())) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "handle0x210_0x120push duplicate push, ignore.");
      }
    }
    do
    {
      return;
      if ((paramMsgBody.uint32_src_app_id.get() == 1) && (paramMsgBody.uint32_notice_type.get() == 14))
      {
        TroopKeywordManager.a(paramQQAppInterface).b();
        return;
      }
      if ((paramMsgBody.uint32_src_app_id.get() == 3) && (paramMsgBody.uint32_notice_type.get() == 15)) {
        ThemeCleaner.a(paramQQAppInterface, String.valueOf(paramMsgBody.uint32_clear_themeid.get()));
      }
      if (RelationVipHelper.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 2, "handle0x210_0x120push not authorized user, ignore.");
    return;
    b(paramQQAppInterface, paramMsgBody);
  }
  
  public static void a(StrangerInfo paramStrangerInfo, ImageView paramImageView)
  {
    int k = 1;
    int j = 0;
    Resources localResources = paramImageView.getResources();
    int i;
    String str;
    int m;
    if ((paramStrangerInfo.mVipType & 0x2) != 0)
    {
      i = 1;
      str = VipUtils.VipIconUtils.a(paramStrangerInfo);
      if (!a()) {
        break label182;
      }
      m = a(paramStrangerInfo);
      if (TextUtils.isEmpty(str)) {
        break label182;
      }
      if (m >> 8 != 3) {
        break label119;
      }
      if (i == 0) {
        break label97;
      }
      a(localResources, paramImageView, str, localResources.getDrawable(2130847431));
      i = k;
    }
    for (;;)
    {
      label80:
      if (i != 0) {}
      for (i = j;; i = 8)
      {
        paramImageView.setVisibility(i);
        return;
        i = 0;
        break;
        label97:
        a(localResources, paramImageView, str, localResources.getDrawable(2130847429));
        i = k;
        break label80;
        label119:
        if (m >> 8 != 2) {
          break label182;
        }
        if (i != 0)
        {
          a(localResources, paramImageView, str, localResources.getDrawable(2130847431));
          i = k;
          break label80;
        }
        a(localResources, paramImageView, str, localResources.getDrawable(2130847429));
        i = k;
        break label80;
      }
      label182:
      i = 0;
    }
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Context paramContext, String paramString, int paramInt)
  {
    a(paramSingleLineTextView, paramContext, paramString, paramInt, null);
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Context paramContext, String paramString, int paramInt, Friends paramFriends)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    Object localObject = paramSingleLineTextView.getRightDrawable();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getCurrDrawable() != null)
      {
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, (Drawable)localObject, null, new VipUtils.4(bool, paramSingleLineTextView, paramContext));
        if (!bool) {
          break label240;
        }
        if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
          paramString.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
        label100:
        paramString = a(AIOUtils.a(15.0F, paramContext.getResources()), paramString);
        if ((paramFriends == null) || (paramFriends.bigClubExtTemplateId <= 0)) {
          break label274;
        }
        paramFriends = VasApngFactory.a(VipUtils.VipIconUtils.a(IndividuationUrlHelper.a("extendnameplateiconurl"), String.valueOf(paramFriends.bigClubExtTemplateId)));
        if ((paramFriends != null) && (paramFriends.getCurrDrawable() != null))
        {
          if (!bool) {
            break label262;
          }
          paramFriends.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    for (;;)
    {
      paramSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(paramContext, 2.0F));
      paramSingleLineTextView.setCompoundDrawables(null, paramString, a(AIOUtils.a(15.0F, paramContext.getResources()), paramFriends));
      return;
      localObject = paramContext.getResources().getDrawable(paramInt);
      break;
      localObject = paramContext.getResources().getDrawable(paramInt);
      break;
      label240:
      if ((paramString == null) || (paramString.getCurrDrawable() == null)) {
        break label100;
      }
      paramString.getCurrDrawable().setColorFilter(null);
      break label100;
      label262:
      paramFriends.getCurrDrawable().setColorFilter(null);
    }
    label274:
    paramSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(paramContext, 5.0F));
    paramSingleLineTextView.setCompoundDrawables(null, paramString, null);
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Friends paramFriends, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = VipUtils.VipIconUtils.a(paramFriends.nameplateVipType);
    Friends localFriends;
    if (bool)
    {
      if (VipUtils.VipIconUtils.a(paramFriends.grayNameplateFlag)) {
        break label120;
      }
      String str = VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(paramFriends.nameplateVipType), false);
      int i = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(paramFriends.nameplateVipType));
      if (!a(paramFriends.nameplateVipType)) {
        break label114;
      }
      localFriends = paramFriends;
      a(paramSingleLineTextView, paramContext, str, i, localFriends);
    }
    for (;;)
    {
      if (!bool)
      {
        if (!paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
          break label129;
        }
        a(paramSingleLineTextView, paramContext, VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_BIGCLUB), 2130847431, paramFriends);
      }
      return;
      label114:
      localFriends = null;
      break;
      label120:
      paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
    label129:
    if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
    {
      a(paramSingleLineTextView, paramContext, VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_SUPERVIP), 2130847429);
      return;
    }
    if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
    {
      a(paramSingleLineTextView, paramContext, VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_QQVIP), 2130847430);
      return;
    }
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "", paramString, 0, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (paramMutualMarkForDisplayInfo == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch ((int)paramMutualMarkForDisplayInfo.jdField_a_of_type_Long)
          {
          default: 
            return;
          case 5: 
            if (paramMutualMarkForDisplayInfo.b == 1L)
            {
              i = a(paramQQAppInterface, paramString1, 0);
              VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", paramString2, "", 0, 0, 0, "", "" + (i + 1), "", "" + 1, "" + 1, "", "", 0, 0, 0, 0);
              return;
            }
            break;
          }
        } while (paramMutualMarkForDisplayInfo.b != 2L);
        i = a(paramQQAppInterface, paramString1, 0);
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 1, "" + 2, "", "", 0, 0, 0, 0);
        return;
        if (paramMutualMarkForDisplayInfo.b == 1L)
        {
          i = a(paramQQAppInterface, paramString1, 1);
          VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 2, "" + 1, "", "", 0, 0, 0, 0);
          return;
        }
      } while (paramMutualMarkForDisplayInfo.b != 2L);
      int i = a(paramQQAppInterface, paramString1, 1);
      VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 2, "" + 2, "", "", 0, 0, 0, 0);
      return;
      paramString1 = a(a(paramQQAppInterface, paramString1, 5), paramString2);
    } while (TextUtils.isEmpty(paramString1));
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
  }
  
  public static boolean a()
  {
    QVipExtendIconConfig localQVipExtendIconConfig = (QVipExtendIconConfig)QConfigManager.a().a(465);
    if (localQVipExtendIconConfig == null) {
      return false;
    }
    return localQVipExtendIconConfig.jdField_a_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    VipUtils.VipIconUtils.NamePlateVipTpye localNamePlateVipTpye = VipUtils.VipIconUtils.NamePlateVipTpye.a(paramInt);
    return (localNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.f) || (localNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.g);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    Date localDate1;
    Date localDate2;
    do
    {
      return false;
      localDate1 = new Date(paramInt1 * 1000L);
      localDate2 = new Date(paramInt2 * 1000L);
    } while ((localDate1.getYear() != localDate2.getYear()) || (localDate1.getMonth() != localDate2.getMonth()) || (localDate1.getDay() != localDate2.getDay()));
    return true;
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString3);
    if (paramString3.contains("?")) {
      localStringBuilder.append("&platform=1");
    }
    for (;;)
    {
      localStringBuilder.append("&qq=0");
      localStringBuilder.append("&adtag=" + paramString2);
      localStringBuilder.append("&aid=" + paramString1);
      if (paramInt == 1) {
        localStringBuilder.append("&jumplevelset=1");
      }
      paramString1 = localStringBuilder.toString();
      long l = System.currentTimeMillis();
      if (!ProfileActivity.a(jdField_a_of_type_Long, l)) {
        break;
      }
      jdField_a_of_type_Long = l;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + paramString1);
      }
      paramString2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramString3 = new Intent(paramContext, QQBrowserActivity.class);
      paramString3.putExtra("uin", paramString2.getCurrentAccountUin());
      paramString3.putExtra("url", paramString1);
      paramString3.putExtra("hide_more_button", true);
      paramString3.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(paramString3);
      return false;
      localStringBuilder.append("?platform=1");
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x8) != 0;
  }
  
  /* Error */
  public static boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 1104	com/tencent/mobileqq/utils/VipUtils:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +13 -> 19
    //   9: new 1106	java/util/HashMap
    //   12: dup
    //   13: invokespecial 1107	java/util/HashMap:<init>	()V
    //   16: putstatic 1104	com/tencent/mobileqq/utils/VipUtils:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: getstatic 1104	com/tencent/mobileqq/utils/VipUtils:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   22: aload_0
    //   23: invokevirtual 1110	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 140	java/lang/Integer
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +21 -> 54
    //   36: aload 4
    //   38: invokevirtual 148	java/lang/Integer:intValue	()I
    //   41: istore_2
    //   42: iload_2
    //   43: iload_1
    //   44: if_icmpne +10 -> 54
    //   47: iconst_1
    //   48: istore_3
    //   49: ldc 2
    //   51: monitorexit
    //   52: iload_3
    //   53: ireturn
    //   54: getstatic 1104	com/tencent/mobileqq/utils/VipUtils:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   57: aload_0
    //   58: iload_1
    //   59: invokestatic 1113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokevirtual 1116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: iconst_0
    //   67: istore_3
    //   68: goto -19 -> 49
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramString	String
    //   0	77	1	paramInt	int
    //   41	4	2	i	int
    //   48	20	3	bool	boolean
    //   29	8	4	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   3	19	71	finally
    //   19	31	71	finally
    //   36	42	71	finally
    //   54	66	71	finally
  }
  
  public static int b(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -100)) {
      return 0;
    }
    if ((paramInt & 0x2) != 0) {
      return 2;
    }
    return 1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true);
  }
  
  public static void b(View paramView, int paramInt, String paramString)
  {
    paramView = paramView.getContext();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt >> 8 == 3)
    {
      a((QQAppInterface)localObject, paramView, "dhykl");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(IndividuationUrlHelper.a("NameplateClickSvip"));
    ((StringBuilder)localObject).append("&source=kl&qq=");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new Intent(paramView, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("fragmentStyle", 3);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("isTransparentTitle", true);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    paramView.startActivity((Intent)localObject);
  }
  
  public static void b(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      VipUtils.RechargeParams localRechargeParams = new VipUtils.RechargeParams();
      localRechargeParams.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localRechargeParams.d = paramString;
      localRechargeParams.e = "1450000516";
      localRechargeParams.b = "CJCLUBT";
      localRechargeParams.c = paramBaseActivity.getString(2131719674);
      localRechargeParams.jdField_a_of_type_Int = paramInt;
      localRechargeParams.f = "svip";
      a(paramBaseActivity, localRechargeParams);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = paramContext.getSharedPreferences(str1, 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = NetworkUtil.a(paramQQAppInterface.getApp().getApplicationContext());
    if (!str2.contains("?"))
    {
      localStringBuilder.append(str2 + "?platform=1&type=20001&networkInfo=" + i + "&aid=" + paramString);
      str2 = localStringBuilder.toString();
      paramString = ((RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf(100400));
      paramQQAppInterface = ((RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(str2, paramString);
      if ((paramString == null) || (paramString.iNewFlag.get() == 0) || (paramString.type.get() != 0)) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      long l = System.currentTimeMillis();
      paramString = new Intent(paramContext, QQBrowserActivity.class);
      paramString.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      paramString.putExtra("startOpenPageTime", l);
      paramString.putExtra("portraitOnly", true);
      paramString.putExtra("uin", str1);
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("has_red_dot", bool);
      paramString.putExtra("leftBtnText", paramContext.getResources().getString(2131689502));
      VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramQQAppInterface, 256L, paramString, false, -1);
      return;
      localStringBuilder.append(str2 + "&platform=1&type=20001&networkInfo=" + i + "&aid=" + paramString);
      break;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    String str1 = paramMsgBody.uint32_notice_type.get() + "";
    Object localObject2 = RelationVipHelper.a(str1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "addFriendGrayTips grayStr is empty, ignore.");
      }
      return;
    }
    Object localObject3 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = String.valueOf(paramMsgBody.uint64_frd_uin.get());
    Object localObject4 = ContactUtils.m(paramQQAppInterface, (String)localObject1);
    long l1 = paramMsgBody.uint32_notice_time.get();
    long l2 = paramMsgBody.uint32_notice_type.get();
    localObject4 = HotReactiveHelper.a(paramQQAppInterface, (String)localObject2, (String)localObject4, (FriendsManager)localObject3);
    Object localObject5 = HotReactiveHelper.a(paramQQAppInterface, (String)((List)localObject4).get(0), (String)localObject1);
    localObject3 = HotReactiveHelper.a(paramQQAppInterface.getApp(), (String)((List)localObject5).get(0));
    paramMsgBody = ((HotReactiveHelper.HighLightUrlPattern)((List)localObject3).get(0)).jdField_a_of_type_JavaLangString;
    ((List)localObject4).remove(0);
    ((List)localObject5).remove(0);
    ((List)localObject3).remove(0);
    localObject2 = new UniteGrayTipParam((String)localObject1, (String)localObject1, paramMsgBody, 0, -5020, 2097153, MessageCache.a());
    int i;
    Bundle localBundle;
    String str2;
    int j;
    if ((localObject5 != null) && (((List)localObject5).size() > 0))
    {
      i = 0;
      while (i < ((List)localObject5).size())
      {
        localBundle = new Bundle();
        str2 = (String)((List)localObject5).get(i);
        if (!TextUtils.isEmpty(str2))
        {
          localBundle.putString("image_resource", str2);
          j = paramMsgBody.lastIndexOf(str2);
          if (j >= 0) {
            ((UniteGrayTipParam)localObject2).a(j, str2.length() + j, localBundle);
          }
          if (QLog.isColorLevel()) {
            QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramMsgBody + "iconPos=" + j + "icon=" + str2 + "grayStr=" + paramMsgBody);
          }
        }
        i += 1;
      }
    }
    label430:
    label493:
    int m;
    if ((localObject4 != null) && (((List)localObject4).size() > 0))
    {
      Collections.sort((List)localObject4, new VipUtils.6());
      localObject5 = new ArrayList();
      j = 0;
      if (j < ((List)localObject4).size())
      {
        localBundle = new Bundle();
        str2 = (String)((List)localObject4).get(j);
        if (!TextUtils.isEmpty(str2))
        {
          localBundle.putInt("key_action", 11);
          localBundle.putString("key_action_DATA", str2);
          i = 0;
          m = paramMsgBody.indexOf(str2, i);
          if (m >= 0) {
            break label519;
          }
        }
      }
    }
    label519:
    label1072:
    for (;;)
    {
      label507:
      int n;
      if (m < 0)
      {
        j += 1;
        break label430;
        n = str2.length();
        i = m + n;
        Iterator localIterator = ((ArrayList)localObject5).iterator();
        Pair localPair;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localPair = (Pair)localIterator.next();
        } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
      }
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label1072;
        }
        ((ArrayList)localObject5).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
        if (m >= 0)
        {
          ((UniteGrayTipParam)localObject2).a(m, i, localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("VipUtils", 2, "spanPos=" + m + " fromIndex=" + i);
          }
        }
        break label507;
        break label493;
        i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject4 = (HotReactiveHelper.HighLightUrlPattern)((List)localObject3).get(i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("key_action", 1);
          ((Bundle)localObject5).putString("key_action_DATA", ((HotReactiveHelper.HighLightUrlPattern)localObject4).b.replace("{uin}", (CharSequence)localObject1));
          j = ((HotReactiveHelper.HighLightUrlPattern)localObject4).jdField_a_of_type_Int;
          if (j >= 0) {
            ((UniteGrayTipParam)localObject2).a(j, ((HotReactiveHelper.HighLightUrlPattern)localObject4).jdField_a_of_type_JavaLangString.length() + j, (Bundle)localObject5);
          }
          i += 1;
        }
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).hasRead = 0;
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
        localObject2 = new StringBuilder(21);
        ((StringBuilder)localObject2).append(l1).append("_").append(l2);
        ((MessageForUniteGrayTip)localObject3).saveExtInfoToExtStr("friendIconType", str1);
        ((MessageForUniteGrayTip)localObject3).tipParam.d = ((StringBuilder)localObject2).toString();
        localObject1 = paramQQAppInterface.getMessageFacade().b((String)localObject1, 0);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).subType == ((MessageForUniteGrayTip)localObject3).subType) && (((MessageForUniteGrayTip)localObject1).tipParam.c.equals(((MessageForUniteGrayTip)localObject3).tipParam.c)) && (((MessageForUniteGrayTip)localObject3).tipParam.jdField_a_of_type_Long - ((MessageForUniteGrayTip)localObject1).tipParam.jdField_a_of_type_Long <= 1L))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
            return;
          }
        }
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "aio_show", "", 0, 0, 0, "", str1, "", "", "", "", "", 0, 0, 0, 0);
        if (TextUtils.isEmpty(paramMsgBody)) {
          break;
        }
        UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject3);
        return;
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x4) != 0;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return 1;
      int i = 1;
      while (i < 32)
      {
        if (paramInt >> i == 0) {
          return 1 + i;
        }
        i += 1;
      }
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
  
  public static int d(int paramInt)
  {
    float f = 130.0F;
    int i;
    Resources localResources;
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      i = 1;
      localResources = BaseApplicationImpl.getApplication().getResources();
    }
    switch (paramInt)
    {
    default: 
      if (i != 0) {}
      for (f = 160.0F;; f = 180.0F)
      {
        return AIOUtils.a(f, localResources);
        i = 0;
        break;
      }
    case 1: 
      if (i != 0) {}
      for (f = 130.0F;; f = 150.0F) {
        return AIOUtils.a(f, localResources);
      }
    case 2: 
      if (i != 0) {}
      for (;;)
      {
        return AIOUtils.a(f, localResources);
        f = 150.0F;
      }
    }
    if (i != 0) {}
    for (f = 50.0F;; f = 100.0F) {
      return AIOUtils.a(f, localResources);
    }
  }
  
  public static int e(int paramInt)
  {
    float f = 180.0F;
    int i;
    Resources localResources;
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      i = 1;
      localResources = BaseApplicationImpl.getApplication().getResources();
      switch (paramInt)
      {
      default: 
        if (i == 0) {
          break;
        }
      }
    }
    for (;;)
    {
      return AIOUtils.a(f, localResources);
      i = 0;
      break;
      if (i != 0) {}
      for (f = 160.0F;; f = 180.0F) {
        return AIOUtils.a(f, localResources);
      }
      f = 200.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */