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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.TmViewHolder;
import com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper.HighLightUrlPattern;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.quickat.ui.QuickAtListAdapter.ViewHolder;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.config.business.qvip.QVipExtendIconConfig;
import com.tencent.mobileqq.vas.theme.ThemeCleaner;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView;
import gxh_message.Dialogue;
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
  static long a;
  static HashMap<String, Integer> b;
  
  public static int a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    paramAppInterface = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4))
    {
      if ((paramInt == 5) && (paramAppInterface != null)) {
        return paramAppInterface.relationIconFlag >> paramInt * 2 & 0x7;
      }
    }
    else if ((paramAppInterface != null) && (RelationVipHelper.a().b())) {
      return paramAppInterface.relationIconFlag >> paramInt * 2 & 0x3;
    }
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.getCurrentAccountUin();
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      int i = 2;
      if (paramQQAppInterface != null)
      {
        if (paramBoolean) {
          paramQQAppInterface = paramQQAppInterface.m(str);
        } else {
          paramQQAppInterface = paramQQAppInterface.d(str);
        }
        if (paramQQAppInterface != null)
        {
          paramBoolean = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
          if (paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            i = 3;
          } else if (!paramBoolean) {
            i = 1;
          }
          return i;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getUserStatus Friends is null");
          return -1;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("VipUtils", 2, "getUserStatus FriendsManagerImp is null");
      }
    }
    return -1;
  }
  
  public static int a(StrangerInfo paramStrangerInfo)
  {
    int i;
    if ((paramStrangerInfo.mVipType & 0x2) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (!paramStrangerInfo.mVipHide)
    {
      if ((!paramStrangerInfo.mBigVipHide) && (paramStrangerInfo.mBigVipLevel > 0)) {
        return i + 768;
      }
      if (((paramStrangerInfo.mVipType & 0x100) != 0) && (paramStrangerInfo.mVipLevel > 0)) {
        return i + 512;
      }
      i = paramStrangerInfo.mVipType;
    }
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
      return Integer.valueOf(paramString).intValue();
    }
    return paramInt;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    int i = VasUtil.b(paramAppRuntime).getVipStatus().getPrivilegeFlags(paramString);
    if ((i & 0x4) != 0) {
      return 2;
    }
    if ((i & 0x2) != 0) {
      return 1;
    }
    return 0;
  }
  
  public static Drawable a(int paramInt, Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i != 0) && (j != 0)) {
      paramDrawable.setBounds(0, 0, i * paramInt / j, paramInt);
    }
    return paramDrawable;
  }
  
  private static String a(int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            if ("C2C_click".equals(paramString)) {
              return "0X800A9C9";
            }
            if ("C2C_show".equals(paramString)) {
              return "0X800A9C7";
            }
          }
        }
        else
        {
          if ("C2C_click".equals(paramString)) {
            return "0X800A9CC";
          }
          if ("C2C_show".equals(paramString)) {
            return "0X800A9CA";
          }
        }
      }
      else
      {
        if ("C2C_click".equals(paramString)) {
          return "0X800A75D";
        }
        if ("C2C_show".equals(paramString)) {
          return "0X800A75B";
        }
      }
    }
    else
    {
      if ("C2C_click".equals(paramString)) {
        return "0X800A9C6";
      }
      if ("C2C_show".equals(paramString)) {
        return "0X800A9C4";
      }
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    int i = VasUtil.b(paramAppInterface).getVipStatus().getPrivilegeFlags(paramString);
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
    if (VasUtil.b(paramQQAppInterface).getVipStatus().isBigClub()) {
      return "bvip";
    }
    if (VasUtil.b(paramQQAppInterface).getVipStatus().isSVip()) {
      return "svip";
    }
    if (VasUtil.b(paramQQAppInterface).getVipStatus().isVip()) {
      return "vip";
    }
    return "normal";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString.replace("-", "_");
    paramString = str;
    if (!str.contains("_"))
    {
      paramString = new StringBuilder();
      paramString.append("jhan_");
      paramString.append(str);
      paramString = paramString.toString();
    }
    return paramString;
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
        paramAppRuntime = paramAppRuntime.m(str);
        if (paramAppRuntime != null)
        {
          int i;
          int j;
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)))
          {
            i = paramAppRuntime.getServiceType(EVIPSPEC.E_SP_BIGCLUB);
            j = 768;
          }
          for (;;)
          {
            return (short)(i | j);
            if ((paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)))
            {
              i = paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP);
              j = 512;
            }
            else
            {
              if ((paramEVIPSPEC != EVIPSPEC.E_SP_QQVIP) || (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
                break;
              }
              i = paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP);
              j = 256;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
          return 0;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
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
        paramAppRuntime = paramAppRuntime.m(str);
        if (paramAppRuntime != null)
        {
          int i;
          int j;
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))
          {
            i = paramAppRuntime.getServiceType(EVIPSPEC.E_SP_BIGCLUB);
            j = 768;
          }
          for (;;)
          {
            return (short)(i | j);
            if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
            {
              i = paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP);
              j = 512;
            }
            else
            {
              if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                break;
              }
              i = paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP);
              j = 256;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
          return 0;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
      }
    }
    return 0;
  }
  
  public static void a(Activity paramActivity, VipUtils.RechargeParams paramRechargeParams)
  {
    Object localObject;
    if ((paramRechargeParams != null) && (paramActivity != null) && (!TextUtils.isEmpty(paramRechargeParams.a)) && (!TextUtils.isEmpty(paramRechargeParams.d)) && (!TextUtils.isEmpty(paramRechargeParams.e)) && (!TextUtils.isEmpty(paramRechargeParams.b)) && (!TextUtils.isEmpty(paramRechargeParams.c)))
    {
      if (paramRechargeParams.g < 1) {
        return;
      }
      localObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", paramRechargeParams.b);
        ((JSONObject)localObject).put("aid", paramRechargeParams.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(paramRechargeParams.g));
        ((JSONObject)localObject).put("offerId", paramRechargeParams.e);
        ((JSONObject)localObject).put("serviceName", paramRechargeParams.c);
        ((JSONObject)localObject).put("userId", paramRechargeParams.a);
        if (!paramRechargeParams.h) {
          ((JSONObject)localObject).put("isCanChange", false);
        }
        localObject = ((JSONObject)localObject).toString();
        if (paramRechargeParams.f == null) {
          break label242;
        }
        paramRechargeParams = paramRechargeParams.f;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, paramRechargeParams);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramRechargeParams = new StringBuilder();
          paramRechargeParams.append("openRechargeDialog exception : ");
          paramRechargeParams.append(paramActivity.getMessage());
          QLog.e("VipUtils", 2, paramRechargeParams.toString());
        }
      }
      return;
      label242:
      paramRechargeParams = "";
    }
  }
  
  public static void a(Context paramContext)
  {
    a(0, "mvip.pingtai.mobileqq.androidziliaoka.fromqita", "qita", IndividuationUrlHelper.a("kuoliePersonalCardMaster"), paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("extendnameplatejumpurl_");
    ((StringBuilder)localObject).append(paramInt);
    String str = IndividuationUrlHelper.a(((StringBuilder)localObject).toString());
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "https://h5.qzone.qq.com/v2/vip/dhy/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32";
    }
    VasWebviewUtil.a(paramContext, (String)localObject, 256L, null, false, -1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener, paramString4, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt, boolean paramBoolean)
  {
    paramContext = DialogUtil.a(paramContext, 0, HardCodeUtil.a(2131913720), paramString2, paramString3, HardCodeUtil.a(2131913699), new VipUtils.1(paramBoolean, paramContext, paramString1, paramString4, paramInt), paramOnClickListener);
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    String str = HardCodeUtil.a(2131913729);
    int i;
    if (paramBoolean) {
      i = 16;
    } else {
      i = 9;
    }
    paramContext = DialogUtil.a(paramContext, 0, str, c(0, i).toString(), HardCodeUtil.a(2131913735), null, null, new VipUtils.2());
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, new VipUtils.5(paramResources, paramString, paramImageView, paramDrawable));
    if (paramString != null)
    {
      int i = AIOUtils.b(15.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        paramImageView.setColorFilter(1996488704);
        return;
      }
      paramImageView.setColorFilter(0);
    }
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
    if (VasUtil.b(localQQAppInterface).getVipStatus().isSVip())
    {
      paramView = new StringBuilder();
      paramView.append(IndividuationUrlHelper.a("NameplateClickSvip"));
      paramView.append("&qq=");
      paramView.append(paramString);
      paramView = paramView.toString();
      paramString = "click_pk";
    }
    else
    {
      paramView = IndividuationUrlHelper.a("NameplateClickDefault");
      paramString = "click_getit";
    }
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    localIntent.putExtra("url", paramView);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localContext.startActivity(localIntent);
    VasWebviewUtil.a(localQQAppInterface.getCurrentAccountUin(), "nameplate", paramString, "", 1, 0, 0, "", "", "");
  }
  
  public static void a(View paramView, Context paramContext, String paramString, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    FriendsManager localFriendsManager = (FriendsManager)((BaseActivity)paramContext).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localFriendsManager != null) && (localFriendsManager.b(paramString) != null))
    {
      VipUtils.UpdateRecentEfficientVipIconTask.a(paramContext, paramString, paramRecentEfficientItemBuilderHolder);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - start");
    }
    paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
    paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    if (localFriendsManager != null)
    {
      paramView = new VipUtils.UpdateRecentEfficientVipIconTask(paramView, paramContext, paramString, paramRecentEfficientItemBuilderHolder);
      VipUtils.UpdateRecentEfficientVipIconTask.Manager.a(paramView);
      ThreadManagerV2.executeOnSubThread(new VipUtils.3(localFriendsManager, paramString, paramView));
    }
  }
  
  public static void a(View paramView, StrangerInfo paramStrangerInfo)
  {
    int i = a(paramStrangerInfo);
    Context localContext = paramView.getContext();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      if (paramStrangerInfo.mIsMyFeed)
      {
        if (i >> 8 == 3) {
          a(localQQAppInterface, localContext, "dhykl");
        } else {
          a(localContext);
        }
      }
      else {
        b(paramView, i, paramStrangerInfo.mUin);
      }
    }
    else {
      QLog.e("VipUtils", 1, "klClickVipIcon: app is null");
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009F0C", "0X8009F0C", 0, 0, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    VasVipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    VasVipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, int paramInt, String paramString)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      VipUtils.RechargeParams localRechargeParams = new VipUtils.RechargeParams();
      localRechargeParams.a = paramQBaseActivity.getAppRuntime().getCurrentAccountUin();
      localRechargeParams.d = paramString;
      localRechargeParams.e = "1450000515";
      localRechargeParams.b = "LTMCLUB";
      localRechargeParams.c = paramQBaseActivity.getString(2131892806);
      localRechargeParams.g = paramInt;
      localRechargeParams.f = "vip";
      a(paramQBaseActivity, localRechargeParams);
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      VipUtils.RechargeParams localRechargeParams = new VipUtils.RechargeParams();
      localRechargeParams.a = paramQBaseActivity.getAppRuntime().getCurrentAccountUin();
      localRechargeParams.d = paramString;
      localRechargeParams.g = paramInt;
      localRechargeParams.h = paramBoolean2;
      if (paramBoolean1)
      {
        localRechargeParams.e = "1450000516";
        localRechargeParams.b = "CJCLUBT";
        localRechargeParams.c = paramQBaseActivity.getString(2131916948);
        localRechargeParams.f = "svip";
      }
      else
      {
        localRechargeParams.e = "1450000515";
        localRechargeParams.b = "LTMCLUB";
        localRechargeParams.c = paramQBaseActivity.getString(2131892806);
        localRechargeParams.f = "vip";
      }
      a(paramQBaseActivity, localRechargeParams);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, long paramLong, String paramString)
  {
    String str = NamePlateCfgInfo.getVipNamePlateJumUrl(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramInt, paramLong);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NamePlate clickFriendVipIcon jumpUrl = ");
      localStringBuilder.append(str);
      localStringBuilder.append(" aid = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" vipType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" namePlateId = ");
      localStringBuilder.append(paramLong);
      QLog.i("VipUtils", 2, localStringBuilder.toString());
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
      paramString1 = localFriendsManager.m(paramString1);
      int i;
      if (paramString1 != null) {
        i = paramString1.bigClubTemplateId;
      } else {
        i = 0;
      }
      a(paramQQAppInterface, paramContext, paramInt >> 8 | (paramInt & 0xF) << 8, i, paramString2);
      return;
    }
    a(paramQQAppInterface, paramContext, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, ChatHistoryTroopMemberFragment.TmViewHolder paramTmViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (SimpleUIUtil.e())
    {
      paramTmViewHolder.j.setTextColor(paramResources.getColor(2131167993));
      return;
    }
    if (c(paramATroopMember.O) != 0)
    {
      paramTmViewHolder.j.setTextColor(paramResources.getColor(2131168187));
      return;
    }
    int i = b(paramATroopMember.L);
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramTmViewHolder.j.setTextColor(paramResources.getColor(2131167993));
            return;
          }
          paramTmViewHolder.j.setTextColor(paramResources.getColor(2131168187));
        }
      }
      else
      {
        paramTmViewHolder.j.setTextColor(paramResources.getColor(2131168187));
        return;
      }
    }
    paramTmViewHolder.j.setTextColor(paramResources.getColor(2131168187));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (SimpleUIUtil.e())
    {
      paramViewHolder.b.setTextColor(paramResources.getColor(2131167993));
      return;
    }
    if (c(paramATroopMember.O) != 0)
    {
      paramViewHolder.b.setTextColor(paramResources.getColor(2131168187));
      return;
    }
    int i = b(paramATroopMember.L);
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramViewHolder.b.setTextColor(paramResources.getColor(2131167993));
            return;
          }
          paramViewHolder.b.setTextColor(paramResources.getColor(2131168187));
        }
      }
      else
      {
        paramViewHolder.b.setTextColor(paramResources.getColor(2131168187));
        return;
      }
    }
    paramViewHolder.b.setTextColor(paramResources.getColor(2131168187));
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
    VasWebviewUtil.b(paramContext, paramString, 256L, localIntent, false, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StrangerInfo paramStrangerInfo, NavBarAIO paramNavBarAIO, ImageView paramImageView, boolean paramBoolean)
  {
    if (SimpleUIUtil.e())
    {
      QLog.d("VipUtils", 1, "updateVipTitleAndCard strangerInfo , SimpleUIMode is open now");
      return;
    }
    if (a())
    {
      String str = VipUtils.VipIconUtils.a(paramStrangerInfo);
      int i = a(paramStrangerInfo);
      int j = i >> 8;
      if (j == 3) {
        paramNavBarAIO.setTitleIconRight(str, 2130848951);
      } else if (j == 2) {
        paramNavBarAIO.setTitleIconRight(str, 2130848951);
      } else {
        paramNavBarAIO.setTitleIconRight("", 0);
      }
      if (i != 0)
      {
        paramImageView.setContentDescription(HardCodeUtil.a(2131913708));
        paramImageView.setFocusableInTouchMode(true);
        paramImageView.setOnTouchListener(new VipUtils.VipTouchListener(paramQQAppInterface, paramBoolean, paramImageView, paramStrangerInfo.mUin, a(paramStrangerInfo), true));
        return;
      }
      paramImageView.setOnTouchListener(null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NavBarAIO paramNavBarAIO, ImageView paramImageView, boolean paramBoolean)
  {
    if (SimpleUIUtil.e())
    {
      QLog.d("VipUtils", 1, "updateVipTitleAndCard, SimpleUIMode is open now");
      paramNavBarAIO.setTitleIconRight("", 0);
      paramImageView.setOnTouchListener(null);
      return;
    }
    Object localObject = VipUtils.VipIconUtils.a(paramQQAppInterface, paramString);
    paramBoolean = VipUtils.VipIconUtils.a(localObject[0]);
    if (paramBoolean)
    {
      VipUtils.VipIconUtils.NamePlateVipTpye localNamePlateVipTpye = VipUtils.VipIconUtils.NamePlateVipTpye.a(localObject[0]);
      if ((!VipUtils.VipIconUtils.b(localObject[1])) && (!localNamePlateVipTpye.a()))
      {
        paramNavBarAIO.setTitleIconRight(VipUtils.VipIconUtils.a(paramQQAppInterface, paramString, localNamePlateVipTpye, false), VipUtils.VipIconUtils.a(localNamePlateVipTpye));
        paramImageView.setContentDescription(HardCodeUtil.a(2131913733));
        paramImageView.setFocusableInTouchMode(true);
        localObject = VipUtils.VipIconUtils.VipIconTouchListener.a(paramQQAppInterface, paramString, "VIA_AIO_TITLE");
        ((VipUtils.VipIconUtils.VipIconTouchListener)localObject).a();
        paramImageView.setOnTouchListener((View.OnTouchListener)localObject);
      }
      else
      {
        paramNavBarAIO.setTitleIconRight("", 0);
        paramImageView.setOnTouchListener(null);
      }
    }
    if (!paramBoolean)
    {
      int i = b(paramQQAppInterface, paramString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindView: vip=");
        ((StringBuilder)localObject).append(i);
        QLog.d("FriendChatPie", 2, ((StringBuilder)localObject).toString());
      }
      int j = i >> 8;
      if (j == 3)
      {
        paramNavBarAIO.setTitleIconRight(VipUtils.VipIconUtils.a(paramQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB), 2130848951);
        NamePlateCfgInfo.vipNamePlateExposeReport(paramQQAppInterface, paramString);
      }
      else if (j == 2)
      {
        localObject = VipUtils.VipIconUtils.a(paramQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
        if ((i & 0xF) == 1) {
          paramNavBarAIO.setTitleIconRight((String)localObject, 2130848951);
        } else {
          paramNavBarAIO.setTitleIconRight((String)localObject, 2130848949);
        }
      }
      else
      {
        paramNavBarAIO.setTitleIconRight("", 0);
      }
      if (a(paramQQAppInterface, paramString, false) == 3)
      {
        paramImageView.setContentDescription(HardCodeUtil.a(2131913733));
        paramImageView.setFocusableInTouchMode(true);
        paramQQAppInterface = VipUtils.VipIconUtils.VipIconTouchListener.a(paramQQAppInterface, paramString, "VIA_AIO_TITLE");
        paramQQAppInterface.a();
        paramImageView.setOnTouchListener(paramQQAppInterface);
        return;
      }
      paramImageView.setOnTouchListener(null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    if (b(String.valueOf(paramMsgBody.uint64_frd_uin.get()), paramMsgBody.uint32_notice_time.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "handle0x210_0x120push duplicate push, ignore.");
      }
      return;
    }
    if ((paramMsgBody.uint32_src_app_id.get() == 1) && (paramMsgBody.uint32_notice_type.get() == 14))
    {
      TroopKeywordManager.a(paramQQAppInterface).c();
      return;
    }
    if ((paramMsgBody.uint32_src_app_id.get() == 3) && (paramMsgBody.uint32_notice_type.get() == 15)) {
      ThemeCleaner.a(paramQQAppInterface, String.valueOf(paramMsgBody.uint32_clear_themeid.get()));
    }
    if (!RelationVipHelper.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "handle0x210_0x120push not authorized user, ignore.");
      }
      return;
    }
    b(paramQQAppInterface, paramMsgBody);
  }
  
  public static void a(StrangerInfo paramStrangerInfo, ImageView paramImageView)
  {
    Resources localResources = paramImageView.getResources();
    int i = paramStrangerInfo.mVipType;
    int k = 1;
    int j = 0;
    if ((i & 0x2) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    String str = VipUtils.VipIconUtils.a(paramStrangerInfo);
    if (a())
    {
      int m = a(paramStrangerInfo);
      if (!TextUtils.isEmpty(str))
      {
        m >>= 8;
        if (m == 3)
        {
          if (i != 0)
          {
            a(localResources, paramImageView, str, localResources.getDrawable(2130848951));
            i = k;
            break label172;
          }
          a(localResources, paramImageView, str, localResources.getDrawable(2130848949));
          i = k;
          break label172;
        }
        if (m == 2)
        {
          if (i != 0)
          {
            a(localResources, paramImageView, str, localResources.getDrawable(2130848951));
            i = k;
            break label172;
          }
          a(localResources, paramImageView, str, localResources.getDrawable(2130848949));
          i = k;
          break label172;
        }
      }
    }
    i = 0;
    label172:
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    paramImageView.setVisibility(i);
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
      if (((URLDrawable)localObject).getCurrDrawable() != null) {
        localObject = ((URLDrawable)localObject).getCurrDrawable();
      } else {
        localObject = paramContext.getResources().getDrawable(paramInt);
      }
    }
    else
    {
      localObject = paramContext.getResources().getDrawable(paramInt);
    }
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, (Drawable)localObject, null, new VipUtils.4(bool, paramSingleLineTextView, paramContext));
    if (bool)
    {
      if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
        paramString.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    else if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
      paramString.getCurrDrawable().setColorFilter(null);
    }
    paramString = a(AIOUtils.b(15.0F, paramContext.getResources()), paramString);
    if ((paramFriends != null) && (paramFriends.bigClubExtTemplateId > 0))
    {
      paramFriends = VipUtils.VipIconUtils.a(IndividuationUrlHelper.a("extendnameplateiconurl"), String.valueOf(paramFriends.bigClubExtTemplateId));
      paramFriends = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramFriends);
      if ((paramFriends != null) && (paramFriends.getCurrDrawable() != null)) {
        if (bool) {
          paramFriends.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        } else {
          paramFriends.getCurrDrawable().setColorFilter(null);
        }
      }
      paramSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(paramContext, 2.0F));
      paramSingleLineTextView.setCompoundDrawables(null, paramString, a(AIOUtils.b(15.0F, paramContext.getResources()), paramFriends));
      return;
    }
    paramSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(paramContext, 5.0F));
    paramSingleLineTextView.setCompoundDrawables(null, paramString, null);
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Friends paramFriends, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = VipUtils.VipIconUtils.a(paramFriends.nameplateVipType);
    if (bool) {
      if (!VipUtils.VipIconUtils.a(paramFriends.grayNameplateFlag))
      {
        String str = VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(paramFriends.nameplateVipType), false);
        int i = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(paramFriends.nameplateVipType));
        Friends localFriends;
        if (a(paramFriends.nameplateVipType)) {
          localFriends = paramFriends;
        } else {
          localFriends = null;
        }
        a(paramSingleLineTextView, paramContext, str, i, localFriends);
      }
      else
      {
        paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
    }
    if (!bool)
    {
      if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))
      {
        a(paramSingleLineTextView, paramContext, VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_BIGCLUB), 2130848951, paramFriends);
        return;
      }
      if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        a(paramSingleLineTextView, paramContext, VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_SUPERVIP), 2130848949);
        return;
      }
      if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        a(paramSingleLineTextView, paramContext, VipUtils.VipIconUtils.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_QQVIP), 2130848950);
        return;
      }
      paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
  }
  
  public static void a(String paramString1, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (paramMutualMarkForDisplayInfo == null) {
      return;
    }
    int i = (int)paramMutualMarkForDisplayInfo.a;
    if (i != 5)
    {
      if (i != 12)
      {
        if (i != 19) {
          return;
        }
        paramString1 = a(a(paramQQAppInterface, paramString1, 5), paramString2);
        if (!TextUtils.isEmpty(paramString1)) {
          ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (paramMutualMarkForDisplayInfo.b == 1L)
        {
          i = a(paramQQAppInterface, paramString1, 1);
          paramString1 = paramQQAppInterface.getCurrentAccountUin();
          paramMutualMarkForDisplayInfo = new StringBuilder();
          paramMutualMarkForDisplayInfo.append("");
          paramMutualMarkForDisplayInfo.append(i + 1);
          paramMutualMarkForDisplayInfo = paramMutualMarkForDisplayInfo.toString();
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("");
          paramQQAppInterface.append(2);
          paramQQAppInterface = paramQQAppInterface.toString();
          paramString2 = new StringBuilder();
          paramString2.append("");
          paramString2.append(1);
          VasWebviewUtil.a(paramString1, "friendspark", "C2C_show", "", 0, 0, 0, "", paramMutualMarkForDisplayInfo, "", paramQQAppInterface, paramString2.toString(), "", "", 0, 0, 0, 0);
          return;
        }
        if (paramMutualMarkForDisplayInfo.b == 2L)
        {
          i = a(paramQQAppInterface, paramString1, 1);
          paramString1 = paramQQAppInterface.getCurrentAccountUin();
          paramMutualMarkForDisplayInfo = new StringBuilder();
          paramMutualMarkForDisplayInfo.append("");
          paramMutualMarkForDisplayInfo.append(i + 1);
          paramMutualMarkForDisplayInfo = paramMutualMarkForDisplayInfo.toString();
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("");
          paramQQAppInterface.append(2);
          paramQQAppInterface = paramQQAppInterface.toString();
          paramString2 = new StringBuilder();
          paramString2.append("");
          paramString2.append(2);
          VasWebviewUtil.a(paramString1, "friendspark", "C2C_show", "", 0, 0, 0, "", paramMutualMarkForDisplayInfo, "", paramQQAppInterface, paramString2.toString(), "", "", 0, 0, 0, 0);
        }
      }
    }
    else
    {
      if (paramMutualMarkForDisplayInfo.b == 1L)
      {
        i = a(paramQQAppInterface, paramString1, 0);
        paramString1 = paramQQAppInterface.getCurrentAccountUin();
        paramMutualMarkForDisplayInfo = new StringBuilder();
        paramMutualMarkForDisplayInfo.append("");
        paramMutualMarkForDisplayInfo.append(i + 1);
        paramMutualMarkForDisplayInfo = paramMutualMarkForDisplayInfo.toString();
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("");
        paramQQAppInterface.append(1);
        paramQQAppInterface = paramQQAppInterface.toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(1);
        VasWebviewUtil.a(paramString1, "friendspark", paramString2, "", 0, 0, 0, "", paramMutualMarkForDisplayInfo, "", paramQQAppInterface, localStringBuilder.toString(), "", "", 0, 0, 0, 0);
        return;
      }
      if (paramMutualMarkForDisplayInfo.b == 2L)
      {
        i = a(paramQQAppInterface, paramString1, 0);
        paramString1 = paramQQAppInterface.getCurrentAccountUin();
        paramMutualMarkForDisplayInfo = new StringBuilder();
        paramMutualMarkForDisplayInfo.append("");
        paramMutualMarkForDisplayInfo.append(i + 1);
        paramMutualMarkForDisplayInfo = paramMutualMarkForDisplayInfo.toString();
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("");
        paramQQAppInterface.append(1);
        paramQQAppInterface = paramQQAppInterface.toString();
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(2);
        VasWebviewUtil.a(paramString1, "friendspark", "C2C_show", "", 0, 0, 0, "", paramMutualMarkForDisplayInfo, "", paramQQAppInterface, paramString2.toString(), "", "", 0, 0, 0, 0);
      }
    }
  }
  
  public static boolean a()
  {
    QVipExtendIconConfig localQVipExtendIconConfig = (QVipExtendIconConfig)QConfigManager.b().b(465);
    if (localQVipExtendIconConfig == null) {
      return false;
    }
    return localQVipExtendIconConfig.a;
  }
  
  public static boolean a(int paramInt)
  {
    VipUtils.VipIconUtils.NamePlateVipTpye localNamePlateVipTpye = VipUtils.VipIconUtils.NamePlateVipTpye.a(paramInt);
    return (localNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.g) || (localNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.h);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return false;
      }
      Date localDate1 = new Date(paramInt1 * 1000L);
      Date localDate2 = new Date(paramInt2 * 1000L);
      bool1 = bool2;
      if (localDate1.getYear() == localDate2.getYear())
      {
        bool1 = bool2;
        if (localDate1.getMonth() == localDate2.getMonth())
        {
          bool1 = bool2;
          if (localDate1.getDay() == localDate2.getDay()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString3);
    if (paramString3.contains("?")) {
      localStringBuilder.append("&platform=1");
    } else {
      localStringBuilder.append("?platform=1");
    }
    localStringBuilder.append("&qq=0");
    paramString3 = new StringBuilder();
    paramString3.append("&adtag=");
    paramString3.append(paramString2);
    localStringBuilder.append(paramString3.toString());
    paramString2 = new StringBuilder();
    paramString2.append("&aid=");
    paramString2.append(paramString1);
    localStringBuilder.append(paramString2.toString());
    if (paramInt == 1) {
      localStringBuilder.append("&jumplevelset=1");
    }
    paramString1 = localStringBuilder.toString();
    long l = System.currentTimeMillis();
    if (ProfileUtils.isValidClick(a, l))
    {
      a = l;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("gotoQQVipWeb() url = ");
        paramString2.append(paramString1);
        QLog.d("Q.profilecard.FrdProfileCard", 2, paramString2.toString());
      }
      paramString2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramString3 = new Intent(paramContext, QQBrowserActivity.class);
      paramString3.putExtra("uin", paramString2.getCurrentAccountUin());
      paramString3.putExtra("url", paramString1);
      paramString3.putExtra("hide_more_button", true);
      paramString3.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(paramString3);
      return false;
    }
    return true;
  }
  
  public static int b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -100))
    {
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
    return 0;
  }
  
  public static int b(int paramInt1, int paramInt2)
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
  
  public static Dialogue b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new Dialogue();
      try
      {
        ((Dialogue)localObject).mergeFrom(paramString.getBytes());
        return localObject;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject;
        localObject = localException2;
      }
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      paramString = null;
    }
    return paramString;
  }
  
  public static short b(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime, paramString, true);
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
  
  public static void b(QBaseActivity paramQBaseActivity, int paramInt, String paramString)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      VipUtils.RechargeParams localRechargeParams = new VipUtils.RechargeParams();
      localRechargeParams.a = paramQBaseActivity.getAppRuntime().getCurrentAccountUin();
      localRechargeParams.d = paramString;
      localRechargeParams.e = "1450000516";
      localRechargeParams.b = "CJCLUBT";
      localRechargeParams.c = paramQBaseActivity.getString(2131916948);
      localRechargeParams.g = paramInt;
      localRechargeParams.f = "svip";
      a(paramQBaseActivity, localRechargeParams);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    Object localObject = paramContext.getSharedPreferences(str, 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = NetworkUtil.getSystemNetwork(paramQQAppInterface.getApp().getApplicationContext());
    StringBuilder localStringBuilder2;
    if (!((String)localObject).contains("?"))
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append("?platform=1&type=20001&networkInfo=");
      localStringBuilder2.append(i);
      localStringBuilder2.append("&aid=");
      localStringBuilder2.append(paramString);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append("&platform=1&type=20001&networkInfo=");
      localStringBuilder2.append(i);
      localStringBuilder2.append("&aid=");
      localStringBuilder2.append(paramString);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    paramString = localStringBuilder1.toString();
    localObject = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    paramQQAppInterface = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100400));
    paramString = ((IRedTouchManager)localObject).wrapperRedTouchUrl(paramString, paramQQAppInterface);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.iNewFlag.get() != 0)
      {
        bool1 = bool2;
        if (paramQQAppInterface.type.get() == 0) {
          bool1 = true;
        }
      }
    }
    long l = System.currentTimeMillis();
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
    paramQQAppInterface.putExtra("startOpenPageTime", l);
    paramQQAppInterface.putExtra("portraitOnly", true);
    paramQQAppInterface.putExtra("uin", str);
    paramQQAppInterface.putExtra("hide_operation_bar", true);
    paramQQAppInterface.putExtra("hide_more_button", true);
    paramQQAppInterface.putExtra("has_red_dot", bool1);
    paramQQAppInterface.putExtra("leftBtnText", paramContext.getResources().getString(2131886137));
    VasWebviewUtil.b(paramContext, paramString, 256L, paramQQAppInterface, false, -1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMsgBody.uint32_notice_type.get());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = RelationVipHelper.a((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "addFriendGrayTips grayStr is empty, ignore.");
      }
      return;
    }
    Object localObject3 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str = String.valueOf(paramMsgBody.uint64_frd_uin.get());
    Object localObject4 = ContactUtils.g(paramQQAppInterface, str);
    long l1 = paramMsgBody.uint32_notice_time.get();
    long l2 = paramMsgBody.uint32_notice_type.get();
    List localList1 = HotReactiveHelper.a(paramQQAppInterface, (String)localObject2, (String)localObject4, (FriendsManager)localObject3);
    localObject3 = HotReactiveHelper.a(paramQQAppInterface, (String)localList1.get(0), str);
    List localList2 = HotReactiveHelper.b(paramQQAppInterface.getApp(), (String)((List)localObject3).get(0));
    paramMsgBody = ((HotReactiveHelper.HighLightUrlPattern)localList2.get(0)).a;
    localList1.remove(0);
    ((List)localObject3).remove(0);
    localList2.remove(0);
    long l3 = MessageCache.c();
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(str, str, paramMsgBody, 0, -5020, 2097153, l3);
    localObject4 = localObject1;
    localObject2 = paramMsgBody;
    Object localObject5;
    int j;
    if (localObject3 != null)
    {
      localObject4 = localObject1;
      localObject2 = paramMsgBody;
      if (((List)localObject3).size() > 0)
      {
        i = 0;
        for (;;)
        {
          localObject4 = localObject1;
          localObject2 = paramMsgBody;
          if (i >= ((List)localObject3).size()) {
            break;
          }
          localObject5 = new Bundle();
          localObject4 = (String)((List)localObject3).get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((Bundle)localObject5).putString("image_resource", (String)localObject4);
            localObject2 = paramMsgBody;
            j = ((String)localObject2).lastIndexOf((String)localObject4);
            if (j >= 0) {
              localUniteGrayTipParam.a(j, j + ((String)localObject4).length(), (Bundle)localObject5);
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("addHotFriendAIOGrayTips grayStr=");
              ((StringBuilder)localObject5).append((String)localObject2);
              ((StringBuilder)localObject5).append("iconPos=");
              ((StringBuilder)localObject5).append(j);
              ((StringBuilder)localObject5).append("icon=");
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("grayStr=");
              ((StringBuilder)localObject5).append((String)localObject2);
              QLog.d("reactive", 2, ((StringBuilder)localObject5).toString());
            }
          }
          i += 1;
        }
      }
    }
    paramMsgBody = (SubMsgType0x120.MsgBody)localObject2;
    localObject1 = paramMsgBody;
    l3 = l1;
    long l4 = l2;
    if (localList1 != null)
    {
      localObject1 = paramMsgBody;
      l3 = l1;
      l4 = l2;
      if (localList1.size() > 0)
      {
        Collections.sort(localList1, new VipUtils.6());
        localObject5 = new ArrayList();
        j = 0;
        for (;;)
        {
          localObject1 = paramMsgBody;
          l3 = l1;
          l4 = l2;
          if (j >= localList1.size()) {
            break;
          }
          Bundle localBundle = new Bundle();
          localObject2 = (String)localList1.get(j);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localBundle.putInt("key_action", 11);
            localBundle.putString("key_action_DATA", (String)localObject2);
            i = 0;
            localObject1 = paramMsgBody;
            for (paramMsgBody = (SubMsgType0x120.MsgBody)localObject2;; paramMsgBody = (SubMsgType0x120.MsgBody)localObject3)
            {
              int m = ((String)localObject1).indexOf(paramMsgBody, i);
              if (m < 0)
              {
                localObject2 = localObject1;
                localObject1 = paramMsgBody;
              }
              int k;
              for (paramMsgBody = (SubMsgType0x120.MsgBody)localObject2;; paramMsgBody = (SubMsgType0x120.MsgBody)localObject2)
              {
                localObject3 = localObject1;
                break label864;
                k = paramMsgBody.length() + m;
                localObject3 = ((ArrayList)localObject5).iterator();
                localObject2 = localObject1;
                while (((Iterator)localObject3).hasNext())
                {
                  localObject1 = (Pair)((Iterator)localObject3).next();
                  if ((m >= ((Integer)((Pair)localObject1).first).intValue()) && (m < ((Integer)((Pair)localObject1).second).intValue()))
                  {
                    i = 1;
                    break label725;
                  }
                }
                i = 0;
                label725:
                localObject1 = paramMsgBody;
                if (i == 0) {
                  break;
                }
                i = k;
              }
              ((ArrayList)localObject5).add(new Pair(Integer.valueOf(m), Integer.valueOf(k)));
              i = k;
              paramMsgBody = (SubMsgType0x120.MsgBody)localObject2;
              localObject3 = localObject1;
              if (m >= 0)
              {
                localUniteGrayTipParam.a(m, k, localBundle);
                i = k;
                paramMsgBody = (SubMsgType0x120.MsgBody)localObject2;
                localObject3 = localObject1;
                if (QLog.isColorLevel())
                {
                  paramMsgBody = new StringBuilder();
                  paramMsgBody.append("spanPos=");
                  paramMsgBody.append(m);
                  paramMsgBody.append(" fromIndex=");
                  paramMsgBody.append(k);
                  QLog.d("VipUtils", 2, paramMsgBody.toString());
                  localObject3 = localObject1;
                  paramMsgBody = (SubMsgType0x120.MsgBody)localObject2;
                  i = k;
                }
              }
              label864:
              if (m < 0) {
                break;
              }
              localObject1 = paramMsgBody;
            }
          }
          j += 1;
        }
      }
    }
    int i = 0;
    while (i < localList2.size())
    {
      paramMsgBody = (HotReactiveHelper.HighLightUrlPattern)localList2.get(i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 1);
      ((Bundle)localObject2).putString("key_action_DATA", paramMsgBody.b.replace("{uin}", str));
      j = paramMsgBody.c;
      if (j >= 0) {
        localUniteGrayTipParam.a(j, paramMsgBody.a.length() + j, (Bundle)localObject2);
      }
      i += 1;
    }
    paramMsgBody = new MessageForUniteGrayTip();
    paramMsgBody.hasRead = 0;
    paramMsgBody.initGrayTipMsg(paramQQAppInterface, localUniteGrayTipParam);
    localObject2 = new StringBuilder(21);
    ((StringBuilder)localObject2).append(l3);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(l4);
    paramMsgBody.saveExtInfoToExtStr("friendIconType", (String)localObject4);
    paramMsgBody.tipParam.p = ((StringBuilder)localObject2).toString();
    localObject2 = paramQQAppInterface.getMessageFacade().h(str, 0);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = (MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1);
      if ((localObject2 instanceof MessageForUniteGrayTip))
      {
        localObject2 = (MessageForUniteGrayTip)localObject2;
        if ((((MessageForUniteGrayTip)localObject2).tipParam != null) && (((MessageForUniteGrayTip)localObject2).subType == paramMsgBody.subType) && (((MessageForUniteGrayTip)localObject2).tipParam.g.equals(paramMsgBody.tipParam.g)) && (paramMsgBody.tipParam.j - ((MessageForUniteGrayTip)localObject2).tipParam.j <= 1L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
          }
          return;
        }
      }
    }
    VasWebviewUtil.a(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "aio_show", "", 0, 0, 0, "", (String)localObject4, "", "", "", "", "", 0, 0, 0, 0);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      UniteGrayTipMsgUtil.a(paramQQAppInterface, paramMsgBody);
    }
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    try
    {
      if (b == null) {
        b = new HashMap();
      }
      Integer localInteger = (Integer)b.get(paramString);
      if (localInteger != null)
      {
        int i = localInteger.intValue();
        if (i == paramInt) {
          return true;
        }
      }
      b.put(paramString, Integer.valueOf(paramInt));
      return false;
    }
    finally {}
  }
  
  public static int c(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -100))
    {
      if ((paramInt & 0x2) != 0) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static SpannableString c(int paramInt1, int paramInt2)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = b(i, paramInt1);
    if (j >= 0)
    {
      if (j == 0)
      {
        localObject1 = HardCodeUtil.a(2131913721);
      }
      else if (j == 1)
      {
        localObject1 = HardCodeUtil.a(2131913705);
      }
      else if (j == 2)
      {
        localObject1 = HardCodeUtil.a(2131913730);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913724));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else {
      localObject1 = "";
    }
    Object localObject2 = HardCodeUtil.a(2131913713);
    switch (paramInt2)
    {
    default: 
      return null;
    case 16: 
      return new SpannableString(HardCodeUtil.a(2131913706));
    case 15: 
      return new SpannableString(HardCodeUtil.a(2131913728));
    case 14: 
      return new SpannableString(HardCodeUtil.a(2131913722));
    case 13: 
      return new SpannableString(HardCodeUtil.a(2131913714));
    case 12: 
      paramInt1 = b(i, paramInt1) + 30;
      if (paramInt1 >= 0)
      {
        if (paramInt1 == 0)
        {
          localObject1 = HardCodeUtil.a(2131913709);
        }
        else if (paramInt1 == 1)
        {
          localObject1 = HardCodeUtil.a(2131913736);
        }
        else if (paramInt1 == 2)
        {
          localObject1 = HardCodeUtil.a(2131913715);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913712));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else {
        localObject1 = HardCodeUtil.a(2131913702);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131913727));
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(HardCodeUtil.a(2131913717));
      localStringBuilder.append((String)localObject2);
      localObject1 = new SpannableString(localStringBuilder.toString());
      paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
      return localObject1;
    case 11: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913732));
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
      paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
      return localObject1;
    case 10: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131913731));
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(HardCodeUtil.a(2131913700));
      localStringBuilder.append((String)localObject2);
      localObject1 = new SpannableString(localStringBuilder.toString());
      paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
      return localObject1;
    case 9: 
      return new SpannableString(HardCodeUtil.a(2131913719));
    case 8: 
      return new SpannableString(HardCodeUtil.a(2131913726));
    case 7: 
      return new SpannableString(HardCodeUtil.a(2131913723));
    case 6: 
      return new SpannableString(HardCodeUtil.a(2131913707));
    case 5: 
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913711));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913704));
      return new SpannableString(((StringBuilder)localObject2).toString());
    case 4: 
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913716));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913734));
      return new SpannableString(((StringBuilder)localObject2).toString());
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913725));
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
      paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
      return localObject1;
    case 2: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913710));
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
      paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
      return localObject1;
    case 1: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131913737));
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(HardCodeUtil.a(2131913701));
      localStringBuilder.append((String)localObject2);
      localObject1 = new SpannableString(localStringBuilder.toString());
      paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
      return localObject1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913703));
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(HardCodeUtil.a(2131913718));
    localStringBuilder.append((String)localObject2);
    Object localObject1 = new SpannableString(localStringBuilder.toString());
    paramInt1 = ((SpannableString)localObject1).length() - ((String)localObject2).length();
    ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, ((String)localObject2).length() + paramInt1, 34);
    return localObject1;
  }
  
  public static void c(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "", paramString, 0, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static int d(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    int i = 1;
    while (i < 32)
    {
      if (paramInt >> i == 0) {
        return i + 1;
      }
      i += 1;
    }
    return 1;
  }
  
  public static int e(int paramInt)
  {
    int i;
    if (FontSettingManager.getFontLevel() > 17.0F) {
      i = 1;
    } else {
      i = 0;
    }
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    float f = 180.0F;
    if (paramInt != 1)
    {
      if (i == 0) {
        f = 200.0F;
      }
      return AIOUtils.b(f, localResources);
    }
    if (i != 0) {
      f = 160.0F;
    }
    return AIOUtils.b(f, localResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */