package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import acku;
import aclb;
import actj;
import agas;
import agaz;
import ahnp;
import ajmo;
import ajwc;
import ajxl;
import ajya;
import ampl;
import amzj;
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
import aogm;
import aqvb;
import aqvc;
import asxz;
import asyd;
import asyj;
import asyk;
import avps;
import awzy;
import axmv;
import axqy;
import bafc;
import bbcz;
import bbdj;
import bbdv;
import bbfj;
import bbgu;
import bblm;
import bbln;
import bblo;
import bblp;
import bblq;
import bblr;
import bbls;
import bblt;
import bblu;
import bblv;
import bblw;
import bbqd;
import bbqz;
import bbtq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
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
  static HashMap<String, Integer> a;
  
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
  
  public static int a(aogm paramaogm)
  {
    int k = 0;
    int i;
    int j;
    if ((paramaogm.mVipType & 0x2) != 0)
    {
      i = 1;
      j = k;
      if (!paramaogm.mVipHide)
      {
        if ((paramaogm.mBigVipHide) || (paramaogm.mBigVipLevel <= 0)) {
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
      if (((paramaogm.mVipType & 0x100) != 0) && (paramaogm.mVipLevel > 0)) {
        return i + 512;
      }
      j = k;
    } while (paramaogm.mVipType == 0);
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = ((ajxl)paramQQAppInterface.getManager(51)).e(paramString);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 0;
      } while ((paramQQAppInterface == null) || (!asxz.a().a()));
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
      paramQQAppInterface = (ajxl)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface == null) {
        break label120;
      }
      if (!paramBoolean) {
        break label77;
      }
      paramQQAppInterface = paramQQAppInterface.e(str);
      if (paramQQAppInterface == null) {
        break label101;
      }
      paramBoolean = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label87;
      }
      i = 3;
    }
    label77:
    label87:
    label101:
    label120:
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
    label76:
    int k;
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (ajxl)paramAppRuntime.getManager(51);
      if (paramAppRuntime == null) {
        break label151;
      }
      paramAppRuntime = paramAppRuntime.e(str);
      if (paramAppRuntime == null) {
        break label133;
      }
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label117;
      }
      i = 1;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label122;
      }
      j = 2;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label127;
      }
      k = 4;
      label89:
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
        m = 8;
      }
      i = m | k | 0x0 | i | j;
    }
    label117:
    label122:
    label127:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label76;
        k = 0;
        break label89;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    label133:
    label151:
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
      localObject = ajya.a(2131716806);
    }
    String str;
    for (;;)
    {
      str = ajya.a(2131716798);
      switch (paramInt2)
      {
      default: 
        return null;
        label126:
        if (j == 1) {
          localObject = ajya.a(2131716790);
        } else if (j == 2) {
          localObject = ajya.a(2131716815);
        } else {
          localObject = j + ajya.a(2131716809);
        }
        break;
      }
    }
    localObject = new SpannableString(ajya.a(2131716788) + (String)localObject + ajya.a(2131716803) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(ajya.a(2131716822) + (String)localObject + ajya.a(2131716786) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(ajya.a(2131716795) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(ajya.a(2131716810) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    return new SpannableString(ajya.a(2131716801) + (String)localObject + ajya.a(2131716819));
    return new SpannableString(ajya.a(2131716796) + (String)localObject + ajya.a(2131716789));
    return new SpannableString(ajya.a(2131716792));
    return new SpannableString(ajya.a(2131716808));
    return new SpannableString(ajya.a(2131716811));
    return new SpannableString(ajya.a(2131716804));
    localObject = new SpannableString(ajya.a(2131716816) + (String)localObject + ajya.a(2131716785) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(ajya.a(2131716817) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    paramInt1 = a(i, paramInt1) + 30;
    if (paramInt1 >= 0) {
      if (paramInt1 == 0) {
        localObject = ajya.a(2131716794);
      }
    }
    for (;;)
    {
      localObject = new SpannableString(ajya.a(2131716812) + (String)localObject + ajya.a(2131716802) + str);
      paramInt1 = ((SpannableString)localObject).length() - str.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
      return localObject;
      if (paramInt1 == 1)
      {
        localObject = ajya.a(2131716821);
      }
      else if (paramInt1 == 2)
      {
        localObject = ajya.a(2131716800);
      }
      else
      {
        localObject = paramInt1 + ajya.a(2131716797);
        continue;
        localObject = ajya.a(2131716787);
      }
    }
    return new SpannableString(ajya.a(2131716799));
    return new SpannableString(ajya.a(2131716807));
    return new SpannableString(ajya.a(2131716813));
    return new SpannableString(ajya.a(2131716791));
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
      paramAppRuntime = (ajxl)paramAppRuntime.getManager(51);
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
      paramAppRuntime = (ajxl)paramAppRuntime.getManager(51);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(str);
        if (paramAppRuntime != null)
        {
          if (((!paramBoolean) || ((paramBoolean) && (paramAppRuntime.isHideBigClub == 0))) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))) {
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
  
  public static void a(Activity paramActivity, bblr parambblr)
  {
    if ((parambblr == null) || (paramActivity == null) || (TextUtils.isEmpty(parambblr.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambblr.d)) || (TextUtils.isEmpty(parambblr.e)) || (TextUtils.isEmpty(parambblr.b)) || (TextUtils.isEmpty(parambblr.c)) || (parambblr.jdField_a_of_type_Int < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", parambblr.b);
        ((JSONObject)localObject).put("aid", parambblr.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(parambblr.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("offerId", parambblr.e);
        ((JSONObject)localObject).put("serviceName", parambblr.c);
        ((JSONObject)localObject).put("userId", parambblr.jdField_a_of_type_JavaLangString);
        if (!parambblr.jdField_a_of_type_Boolean) {
          ((JSONObject)localObject).put("isCanChange", false);
        }
        localObject = ((JSONObject)localObject).toString();
        if (parambblr.f == null) {
          break label233;
        }
        parambblr = parambblr.f;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, parambblr);
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
      parambblr = "";
    }
  }
  
  public static void a(Context paramContext)
  {
    String str = bbqd.a("kuoliePersonalCardMaster");
    Object localObject = new StringBuilder(str);
    if (str.contains("?")) {
      ((StringBuilder)localObject).append("&platform=1");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("&qq=" + "0");
      ((StringBuilder)localObject).append("&adtag=" + "qita");
      ((StringBuilder)localObject).append("&aid=" + "mvip.pingtai.mobileqq.androidziliaoka.fromqita");
      str = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + str);
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
      return;
      ((StringBuilder)localObject).append("?platform=1");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener, paramString4, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt, boolean paramBoolean)
  {
    paramContext = bbdj.a(paramContext, 0, ajya.a(2131716805), paramString2, paramString3, ajya.a(2131716784), new bblm(paramBoolean, paramContext, paramString1, paramString4, paramInt), paramOnClickListener);
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    String str = ajya.a(2131716814);
    if (paramBoolean) {}
    for (int i = 16;; i = 9)
    {
      paramContext = bbdj.a(paramContext, 0, str, a(0, i).toString(), ajya.a(2131716820), null, null, new bbln());
      if (!paramContext.isShowing()) {
        paramContext.show();
      }
      return;
    }
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = bbqz.a(paramString, bbqz.b, paramDrawable, null, new bblp(paramResources, paramString, paramImageView, paramDrawable));
    if (paramString != null)
    {
      int i = actj.a(15.0F, paramResources);
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
    bbls.a(paramView);
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
      paramView.append(bbqd.a("NameplateClickSvip"));
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
      paramView = bbqd.a("NameplateClickDefault");
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString, ahnp paramahnp)
  {
    ajxl localajxl = (ajxl)((BaseActivity)paramContext).app.getManager(51);
    if ((localajxl != null) && (localajxl.b(paramString) != null)) {
      VipUtils.UpdateRecentEfficientVipIconTask.a(paramContext, paramString, paramahnp);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - start");
      }
      paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
      paramahnp.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    } while (localajxl == null);
    paramView = new VipUtils.UpdateRecentEfficientVipIconTask(paramView, paramContext, paramString, paramahnp);
    bbls.a(paramView);
    ThreadManagerV2.executeOnSubThread(new VipUtils.3(localajxl, paramString, paramView));
  }
  
  public static void a(View paramView, aogm paramaogm)
  {
    int i = a(paramaogm);
    Context localContext = paramView.getContext();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      if (paramaogm.mIsMyFeed) {
        if (i >> 8 == 3) {
          a(localQQAppInterface, localContext, "dhykl");
        }
      }
    }
    for (;;)
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009F0C", "0X8009F0C", 0, 0, "", "", "", "");
      return;
      a(localContext);
      continue;
      b(paramView, i, paramaogm.mUin);
      continue;
      QLog.e("VipUtils", 1, "klClickVipIcon: app is null");
    }
  }
  
  public static void a(aogm paramaogm, ImageView paramImageView)
  {
    int k = 1;
    int j = 0;
    Resources localResources = paramImageView.getResources();
    int i;
    String str;
    int m;
    if ((paramaogm.mVipType & 0x2) != 0)
    {
      i = 1;
      str = bblt.a(paramaogm);
      if (!a()) {
        break label182;
      }
      m = a(paramaogm);
      if (TextUtils.isEmpty(str)) {
        break label182;
      }
      if (m >> 8 != 3) {
        break label119;
      }
      if (i == 0) {
        break label97;
      }
      a(localResources, paramImageView, str, localResources.getDrawable(2130846160));
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
        a(localResources, paramImageView, str, localResources.getDrawable(2130846158));
        i = k;
        break label80;
        label119:
        if (m >> 8 != 2) {
          break label182;
        }
        if (i != 0)
        {
          a(localResources, paramImageView, str, localResources.getDrawable(2130846160));
          i = k;
          break label80;
        }
        a(localResources, paramImageView, str, localResources.getDrawable(2130846158));
        i = k;
        break label80;
      }
      label182:
      i = 0;
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
        axqy.b(localQQAppInterface, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        ajmo.a(paramAppInterface, paramString1, paramString2, paramString3, "", paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        paramAppInterface.reportClickEvent("P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        break;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
    {
      axqy.b(null, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
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
          axqy.b(localQQAppInterface, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          ajmo.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          return;
        }
      }
      if (paramAppInterface != null)
      {
        if (TextUtils.isEmpty(paramString1)) {}
        for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
        {
          paramAppInterface.reportClickEvent("P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          break;
        }
      }
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        axqy.b(null, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        break;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      bblr localbblr = new bblr();
      localbblr.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localbblr.d = paramString;
      localbblr.e = "1450000515";
      localbblr.b = "LTMCLUB";
      localbblr.c = paramBaseActivity.getString(2131695433);
      localbblr.jdField_a_of_type_Int = paramInt;
      localbblr.f = "vip";
      a(paramBaseActivity, localbblr);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    bblr localbblr;
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      localbblr = new bblr();
      localbblr.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localbblr.d = paramString;
      localbblr.jdField_a_of_type_Int = paramInt;
      localbblr.jdField_a_of_type_Boolean = paramBoolean2;
      if (!paramBoolean1) {
        break label103;
      }
      localbblr.e = "1450000516";
      localbblr.b = "CJCLUBT";
      localbblr.c = paramBaseActivity.getString(2131719975);
    }
    for (localbblr.f = "svip";; localbblr.f = "vip")
    {
      a(paramBaseActivity, localbblr);
      return;
      label103:
      localbblr.e = "1450000515";
      localbblr.b = "LTMCLUB";
      localbblr.c = paramBaseActivity.getString(2131695433);
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
    ajxl localajxl = (ajxl)paramQQAppInterface.getManager(51);
    if (localajxl != null)
    {
      paramString1 = localajxl.e(paramString1);
      if (paramString1 != null) {}
      for (int i = paramString1.bigClubTemplateId;; i = 0)
      {
        a(paramQQAppInterface, paramContext, paramInt >> 8 | (paramInt & 0xF) << 8, i, paramString2);
        return;
      }
    }
    a(paramQQAppInterface, paramContext, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, aclb paramaclb, acku paramacku)
  {
    if (axmv.b())
    {
      paramaclb.e.setTextColor(paramResources.getColor(2131166854));
      return;
    }
    if (b(paramacku.h) != 0)
    {
      paramaclb.e.setTextColor(paramResources.getColor(2131166986));
      return;
    }
    switch (a(paramacku.e))
    {
    default: 
      paramaclb.e.setTextColor(paramResources.getColor(2131166854));
      return;
    case 1: 
    case 3: 
      paramaclb.e.setTextColor(paramResources.getColor(2131166986));
      return;
    case 2: 
      paramaclb.e.setTextColor(paramResources.getColor(2131166986));
      return;
    }
    paramaclb.e.setTextColor(paramResources.getColor(2131166986));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, agaz paramagaz, agas paramagas)
  {
    if (axmv.b())
    {
      paramagaz.e.setTextColor(paramResources.getColor(2131166854));
      return;
    }
    if (b(paramagas.h) != 0)
    {
      paramagaz.e.setTextColor(paramResources.getColor(2131166986));
      return;
    }
    switch (a(paramagas.e))
    {
    default: 
      paramagaz.e.setTextColor(paramResources.getColor(2131166854));
      return;
    case 1: 
    case 3: 
      paramagaz.e.setTextColor(paramResources.getColor(2131166986));
      return;
    case 2: 
      paramagaz.e.setTextColor(paramResources.getColor(2131166986));
      return;
    }
    paramagaz.e.setTextColor(paramResources.getColor(2131166986));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, bafc parambafc, agas paramagas)
  {
    if (axmv.b())
    {
      parambafc.a.setTextColor(paramResources.getColor(2131166854));
      return;
    }
    if (b(paramagas.h) != 0)
    {
      parambafc.a.setTextColor(paramResources.getColor(2131166986));
      return;
    }
    switch (a(paramagas.e))
    {
    default: 
      parambafc.a.setTextColor(paramResources.getColor(2131166854));
      return;
    case 1: 
    case 3: 
      parambafc.a.setTextColor(paramResources.getColor(2131166986));
      return;
    case 2: 
      parambafc.a.setTextColor(paramResources.getColor(2131166986));
      return;
    }
    parambafc.a.setTextColor(paramResources.getColor(2131166986));
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
  
  public static void a(QQAppInterface paramQQAppInterface, aogm paramaogm, NavBarAIO paramNavBarAIO, ImageView paramImageView, boolean paramBoolean)
  {
    if (axmv.b()) {
      QLog.d("VipUtils", 1, "updateVipTitleAndCard strangerInfo , SimpleUIMode is open now");
    }
    while (!a()) {
      return;
    }
    String str = bblt.a(paramaogm);
    int i = a(paramaogm);
    if (i >> 8 == 3) {
      paramNavBarAIO.setTitleIconRight(str, 2130846160);
    }
    while (i != 0)
    {
      paramImageView.setContentDescription(ajya.a(2131716793));
      paramImageView.setFocusableInTouchMode(true);
      paramImageView.setOnTouchListener(new bblw(paramQQAppInterface, paramBoolean, paramImageView, paramaogm.mUin, a(paramaogm), true));
      return;
      if (i >> 8 == 2) {
        paramNavBarAIO.setTitleIconRight(str, 2130846160);
      } else {
        paramNavBarAIO.setTitleIconRight("", 0);
      }
    }
    paramImageView.setOnTouchListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NavBarAIO paramNavBarAIO, ImageView paramImageView, boolean paramBoolean)
  {
    if (axmv.b())
    {
      QLog.d("VipUtils", 1, "updateVipTitleAndCard, SimpleUIMode is open now");
      paramNavBarAIO.setTitleIconRight("", 0);
      paramImageView.setOnTouchListener(null);
      return;
    }
    Object localObject = bblt.a(paramQQAppInterface, paramString);
    paramBoolean = bblt.a(localObject[0]);
    label129:
    int i;
    if (paramBoolean)
    {
      bblu localbblu = bblu.a(localObject[0]);
      if ((!bblt.b(localObject[1])) && (!localbblu.a()))
      {
        paramNavBarAIO.setTitleIconRight(bblt.a(paramQQAppInterface, paramString, localbblu, false), bblt.a(localbblu));
        paramImageView.setContentDescription(ajya.a(2131716818));
        paramImageView.setFocusableInTouchMode(true);
        localObject = bblv.a(paramQQAppInterface, paramString, "VIA_AIO_TITLE");
        ((bblv)localObject).a();
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
      paramNavBarAIO.setTitleIconRight(bblt.a(paramQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB), 2130846160);
      NamePlateCfgInfo.vipNamePlateExposeReport(paramQQAppInterface, paramString);
    }
    for (;;)
    {
      if (a(paramQQAppInterface, paramString, false) != 3) {
        break label325;
      }
      paramImageView.setContentDescription(ajya.a(2131716818));
      paramImageView.setFocusableInTouchMode(true);
      paramQQAppInterface = bblv.a(paramQQAppInterface, paramString, "VIA_AIO_TITLE");
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
        localObject = bblt.a(paramQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
        if ((i & 0xF) == 1) {
          paramNavBarAIO.setTitleIconRight((String)localObject, 2130846160);
        } else {
          paramNavBarAIO.setTitleIconRight((String)localObject, 2130846158);
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
        bbtq.a(paramQQAppInterface).b();
        return;
      }
      if (asxz.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 2, "handle0x210_0x120push not authorized user, ignore.");
    return;
    b(paramQQAppInterface, paramMsgBody);
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Context paramContext, String paramString, int paramInt)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    Object localObject = paramSingleLineTextView.a();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getCurrDrawable() != null)
      {
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        paramString = bbqz.a(paramString, bbqz.b, (Drawable)localObject, null, new bblo(bool, paramSingleLineTextView, paramContext));
        if (!bool) {
          break label158;
        }
        if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
          paramString.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    for (;;)
    {
      paramSingleLineTextView.setCompoundDrawablePadding((int)bbdv.a(paramContext, 5.0F));
      paramSingleLineTextView.setCompoundDrawables(null, a(actj.a(15.0F, paramContext.getResources()), paramString));
      return;
      localObject = paramContext.getResources().getDrawable(paramInt);
      break;
      localObject = paramContext.getResources().getDrawable(paramInt);
      break;
      label158:
      if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
        paramString.getCurrDrawable().setColorFilter(null);
      }
    }
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Friends paramFriends, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = bblt.a(paramFriends.nameplateVipType);
    if (bool)
    {
      if (bblt.a(paramFriends.grayNameplateFlag)) {
        break label97;
      }
      a(paramSingleLineTextView, paramContext, bblt.a(paramQQAppInterface, paramFriends.uin, bblu.a(paramFriends.nameplateVipType), false), bblt.a(bblu.a(paramFriends.nameplateVipType)));
    }
    for (;;)
    {
      if (!bool)
      {
        if ((paramFriends.isHideBigClub != 0) || (!paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))) {
          break;
        }
        a(paramSingleLineTextView, paramContext, bblt.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_BIGCLUB), 2130846160);
      }
      return;
      label97:
      paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
    if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
    {
      a(paramSingleLineTextView, paramContext, bblt.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_SUPERVIP), 2130846158);
      return;
    }
    if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
    {
      a(paramSingleLineTextView, paramContext, bblt.a(paramQQAppInterface, paramFriends.uin, EVIPSPEC.E_SP_QQVIP), 2130846159);
      return;
    }
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public static void a(String paramString1, asyd paramasyd, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (paramasyd == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch ((int)paramasyd.a)
          {
          default: 
            return;
          case 5: 
            if (paramasyd.b == 1L)
            {
              i = a(paramQQAppInterface, paramString1, 0);
              VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", paramString2, "", 0, 0, 0, "", "" + (i + 1), "", "" + 1, "" + 1, "", "", 0, 0, 0, 0);
              return;
            }
            break;
          }
        } while (paramasyd.b != 2L);
        i = a(paramQQAppInterface, paramString1, 0);
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 1, "" + 2, "", "", 0, 0, 0, 0);
        return;
        if (paramasyd.b == 1L)
        {
          i = a(paramQQAppInterface, paramString1, 1);
          VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 2, "" + 1, "", "", 0, 0, 0, 0);
          return;
        }
      } while (paramasyd.b != 2L);
      int i = a(paramQQAppInterface, paramString1, 1);
      VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 2, "" + 2, "", "", 0, 0, 0, 0);
      return;
      paramString1 = a(a(paramQQAppInterface, paramString1, 5), paramString2);
    } while (TextUtils.isEmpty(paramString1));
    axqy.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
  }
  
  public static boolean a()
  {
    amzj localamzj = (amzj)ampl.a().a(465);
    if (localamzj == null) {
      return false;
    }
    return localamzj.jdField_a_of_type_Boolean;
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
    //   3: getstatic 1039	com/tencent/mobileqq/utils/VipUtils:a	Ljava/util/HashMap;
    //   6: ifnonnull +13 -> 19
    //   9: new 1041	java/util/HashMap
    //   12: dup
    //   13: invokespecial 1042	java/util/HashMap:<init>	()V
    //   16: putstatic 1039	com/tencent/mobileqq/utils/VipUtils:a	Ljava/util/HashMap;
    //   19: getstatic 1039	com/tencent/mobileqq/utils/VipUtils:a	Ljava/util/HashMap;
    //   22: aload_0
    //   23: invokevirtual 1045	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 130	java/lang/Integer
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +21 -> 54
    //   36: aload 4
    //   38: invokevirtual 138	java/lang/Integer:intValue	()I
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
    //   54: getstatic 1039	com/tencent/mobileqq/utils/VipUtils:a	Ljava/util/HashMap;
    //   57: aload_0
    //   58: iload_1
    //   59: invokestatic 1048	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokevirtual 1051	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    ((StringBuilder)localObject).append(bbqd.a("NameplateClickSvip"));
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
      bblr localbblr = new bblr();
      localbblr.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localbblr.d = paramString;
      localbblr.e = "1450000516";
      localbblr.b = "CJCLUBT";
      localbblr.c = paramBaseActivity.getString(2131719975);
      localbblr.jdField_a_of_type_Int = paramInt;
      localbblr.f = "svip";
      a(paramBaseActivity, localbblr);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = paramContext.getSharedPreferences(str1, 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = bbfj.a(paramQQAppInterface.getApp().getApplicationContext());
    if (!str2.contains("?"))
    {
      localStringBuilder.append(str2 + "?platform=1&type=20001&networkInfo=" + i + "&aid=" + paramString);
      str2 = localStringBuilder.toString();
      paramString = ((avps)paramQQAppInterface.getManager(36)).a(String.valueOf(100400));
      paramQQAppInterface = ((avps)paramQQAppInterface.getManager(36)).a(str2, paramString);
      if ((paramString == null) || (paramString.iNewFlag.get() == 0) || (paramString.type.get() != 0)) {
        break label326;
      }
    }
    label326:
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
      paramString.putExtra("leftBtnText", paramContext.getResources().getString(2131689548));
      VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramQQAppInterface, 256L, paramString, false, -1);
      return;
      localStringBuilder.append(str2 + "&platform=1&type=20001&networkInfo=" + i + "&aid=" + paramString);
      break;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    String str1 = paramMsgBody.uint32_notice_type.get() + "";
    Object localObject2 = asxz.a(str1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "addFriendGrayTips grayStr is empty, ignore.");
      }
      return;
    }
    Object localObject3 = (ajxl)paramQQAppInterface.getManager(51);
    Object localObject1 = String.valueOf(paramMsgBody.uint64_frd_uin.get());
    Object localObject4 = bbcz.m(paramQQAppInterface, (String)localObject1);
    long l1 = paramMsgBody.uint32_notice_time.get();
    long l2 = paramMsgBody.uint32_notice_type.get();
    localObject4 = asyj.a(paramQQAppInterface, (String)localObject2, (String)localObject4, (ajxl)localObject3);
    Object localObject5 = asyj.a(paramQQAppInterface, (String)((List)localObject4).get(0), (String)localObject1);
    localObject3 = asyj.a(paramQQAppInterface.getApp(), (String)((List)localObject5).get(0));
    paramMsgBody = ((asyk)((List)localObject3).get(0)).jdField_a_of_type_JavaLangString;
    ((List)localObject4).remove(0);
    ((List)localObject5).remove(0);
    ((List)localObject3).remove(0);
    localObject2 = new aqvb((String)localObject1, (String)localObject1, paramMsgBody, 0, -5020, 2097153, awzy.a());
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
            ((aqvb)localObject2).a(j, str2.length() + j, localBundle);
          }
          if (QLog.isColorLevel()) {
            QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramMsgBody + "iconPos=" + j + "icon=" + str2 + "grayStr=" + paramMsgBody);
          }
        }
        i += 1;
      }
    }
    label429:
    label492:
    int m;
    if ((localObject4 != null) && (((List)localObject4).size() > 0))
    {
      Collections.sort((List)localObject4, new bblq());
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
            break label518;
          }
        }
      }
    }
    label518:
    label1071:
    for (;;)
    {
      label506:
      int n;
      if (m < 0)
      {
        j += 1;
        break label429;
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
          break label1071;
        }
        ((ArrayList)localObject5).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
        if (m >= 0)
        {
          ((aqvb)localObject2).a(m, i, localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("VipUtils", 2, "spanPos=" + m + " fromIndex=" + i);
          }
        }
        break label506;
        break label492;
        i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject4 = (asyk)((List)localObject3).get(i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("key_action", 1);
          ((Bundle)localObject5).putString("key_action_DATA", ((asyk)localObject4).b.replace("{uin}", (CharSequence)localObject1));
          j = ((asyk)localObject4).jdField_a_of_type_Int;
          if (j >= 0) {
            ((aqvb)localObject2).a(j, ((asyk)localObject4).jdField_a_of_type_JavaLangString.length() + j, (Bundle)localObject5);
          }
          i += 1;
        }
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).hasRead = 0;
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (aqvb)localObject2);
        localObject2 = new StringBuilder(21);
        ((StringBuilder)localObject2).append(l1).append("_").append(l2);
        ((MessageForUniteGrayTip)localObject3).saveExtInfoToExtStr("friendIconType", str1);
        ((MessageForUniteGrayTip)localObject3).tipParam.d = ((StringBuilder)localObject2).toString();
        localObject1 = paramQQAppInterface.a().b((String)localObject1, 0);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).subType == ((MessageForUniteGrayTip)localObject3).subType) && (((MessageForUniteGrayTip)localObject1).tipParam.c.equals(((MessageForUniteGrayTip)localObject3).tipParam.c)) && (((MessageForUniteGrayTip)localObject3).tipParam.a - ((MessageForUniteGrayTip)localObject1).tipParam.a <= 1L))
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
        aqvc.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject3);
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
    if (ajwc.a() > 17.0F)
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
        return actj.a(f, localResources);
        i = 0;
        break;
      }
    case 1: 
      if (i != 0) {}
      for (f = 130.0F;; f = 150.0F) {
        return actj.a(f, localResources);
      }
    case 2: 
      if (i != 0) {}
      for (;;)
      {
        return actj.a(f, localResources);
        f = 150.0F;
      }
    }
    if (i != 0) {}
    for (f = 50.0F;; f = 100.0F) {
      return actj.a(f, localResources);
    }
  }
  
  public static int e(int paramInt)
  {
    float f = 180.0F;
    int i;
    Resources localResources;
    if (ajwc.a() > 17.0F)
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
      return actj.a(f, localResources);
      i = 0;
      break;
      if (i != 0) {}
      for (f = 160.0F;; f = 180.0F) {
        return actj.a(f, localResources);
      }
      f = 200.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */