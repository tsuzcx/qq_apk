package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
import aaqo;
import acnh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import anrb;
import anvx;
import aoep;
import avhz;
import awzf;
import azry;
import azyi;
import azyj;
import bbco;
import bcrg;
import bcsa;
import bdla;
import bgcz;
import bghi;
import bghj;
import bgig;
import bglh;
import bglm;
import bgls;
import bgua;
import bhbu;
import bhbv;
import bhdf;
import bhff;
import bhnp;
import bisy;
import bkyd;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.TroopRobotFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopFileProxyActivity;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import ntx;
import nvs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.HighlightTitle;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ExtraInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.TabInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopUtils
{
  public static String CHECK_API_STATE_CGI_URL = "https://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
  public static final String FILE_TROOP_RECOMMEND_GRAY_TIPS_COOKIE = "troop_recommend_graytips_cookie_";
  private static final String KEY_AIO_TROOP_MINI_APP_ENTRANCE = "AIO_TROOP_MINI_APP_ENTRANCE";
  private static final String KEY_TROOP_APP_HAS_NEW = "key_troop_app_has_new";
  public static final int MAX = 4194304;
  public static final int MSG_SENDER_TYPE_ACTION = 1;
  public static final int MSG_SENDER_TYPE_REQUEST = 2;
  public static final String SP_KEY_OLD_GRAY_TIPS_LAST_ADD_TIME = "old_last_add_time";
  public static final String SP_KEY_TROOP_INFO_EDIT_RED_SHOW_TAG = "red_tag_";
  public static final String SP_KEY_TROOP_MANAGE_EDIT_RED_SHOW = "manage_red";
  public static final String SP_KEY_TROOP_RECOMMEND_GRAY_TIPS_LAST_ADD_TIME = "last_add_time";
  public static final String SP_KEY_TROOP_RECOMMEND_GRAY_TIPS_REPORT_TIMESTAMP = "report_timestamp";
  public static final String SP_TROOP_INFO_EDIT_RED_SHOW = "sp_troop_info_edit_red_show_";
  public static final String SP_TROOP_RECOMMEND_GRAY_TIPS = "sp_troop_recommend_graytips_";
  public static final String TAG = "TroopUtils";
  public static final String TROOP_MANAGE_EDIT_CURRENT_UIN = "troop_manager_edit_current_uin";
  public static final String TROOP_MANAGE_EDIT_RED_NEED_SHOW = "troop_manager_edit_red_show";
  public static final String TROOP_MANAGE_FROM_JUMP_ACTION = "troop_manage_from_jump_action";
  public static final String TROOP_MANAGE_HISTORY_FOR_NEWER_RED_NEED_SHOW = "troop_manage_history_for_newer_red_need";
  public static final String TROOP_MANAGE_HISTORY_FOR_NEWER_RED_SHOWED = "troop_manage_history_for_newer_red_showed";
  public static final String TROOP_RECOMMEND_GRAY_TIPS_DIVIDE = "_";
  public static final String TROOP_SOURCE_FROM = "t_s_f";
  public static final int TROOP_SOURCE_FROM_EXTEND_GROUP = 1002;
  public static final int TROOP_SOURCE_FROM_SEARCH = 1000;
  public static final int TROOP_SOURCE_FROM_SYSTEM_NOTICE = 1001;
  public static final int TYPE_GUEST_VISTOR = 2;
  public static final int TYPE_HOST_VISTOR = 1;
  public static final int TYPE_UNKNOW = -1;
  public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  protected static String TroopAppActivityUrl;
  protected static String TroopAppUrl = "https://qun.qq.com/qqweb/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&sonic=1&gc=";
  public static final String VISTOR_TYPE = "vistor_type";
  public static int mExposureSource;
  private static boolean mIsShowTroopAppShortcutBar;
  private static boolean sEnbaleTipsCountLimit = true;
  
  static
  {
    TroopAppActivityUrl = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
  }
  
  public static boolean IsTroopAdmin(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramLong + "");
    return (paramQQAppInterface != null) && (((paramQQAppInterface.troopowneruin != null) && (paramString.equals(paramQQAppInterface.troopowneruin))) || ((paramQQAppInterface.Administrator != null) && (paramQQAppInterface.Administrator.contains(paramString))));
  }
  
  public static void addTroopRecommendGrayTips(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, List<oidb_0xe3b.HighlightTitle> paramList, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "addTroopRecommendGrayTips " + paramString2 + " " + paramInt1 + " " + paramList + " " + paramInt2 + " " + paramLong);
    }
    avhz localavhz;
    label166:
    int k;
    Bundle localBundle;
    if ((paramQQAppInterface != null) && (paramString1 != null) && (paramString2 != null))
    {
      localavhz = new avhz(paramString1, paramString1, paramString2, 1, -5020, 131088, bcrg.a());
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          oidb_0xe3b.HighlightTitle localHighlightTitle = (oidb_0xe3b.HighlightTitle)localIterator.next();
          if (localHighlightTitle.bytes_highlight_title.has())
          {
            paramList = localHighlightTitle.bytes_highlight_title.get().toStringUtf8();
            k = localHighlightTitle.enum_title_type.get();
            if (QLog.isColorLevel()) {
              QLog.i("TroopUtils", 2, "addTroopRecommendGrayTips highlight " + paramList + " " + k);
            }
            if (TextUtils.isEmpty(paramList)) {
              break label487;
            }
            int j = paramString2.indexOf(paramList, i);
            if (j == -1) {
              break label487;
            }
            localBundle = new Bundle();
            if (k != 0) {
              break label357;
            }
            localBundle.putInt("key_action", 52);
            localBundle.putString("key_action_DATA", paramInt1 + "_" + paramInt2 + "_" + paramLong);
            localBundle.putString("key_a_action_DATA", String.valueOf(localHighlightTitle.uint64_uin.get()));
            label327:
            i = j + paramList.length();
            localavhz.a(j, i, localBundle);
          }
        }
      }
    }
    label357:
    label487:
    for (;;)
    {
      break;
      paramList = null;
      break label166;
      if (k != 1) {
        break label327;
      }
      localBundle.putInt("key_action", 53);
      localBundle.putString("key_action_DATA", paramInt1 + "_" + paramInt2 + "_" + paramLong);
      break label327;
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, localavhz);
      paramString2.saveExtInfoToExtStr("subIdAndGroupClass", paramInt2 + "_" + paramLong);
      paramQQAppInterface.getMessageFacade().addMessage(paramString2, paramQQAppInterface.getCurrentAccountUin());
      setRecommendGrayTipsLastInsertTime(paramQQAppInterface, paramString1, paramString2.time);
      return;
    }
  }
  
  public static void calJoinTroop(TroopInfoData paramTroopInfoData, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTroopInfoData.pa == 19)
    {
      bdla.b(null, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 18)
    {
      bdla.b(null, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 24)
    {
      bdla.b(null, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 17)
    {
      bdla.b(null, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    int i = -1;
    int j;
    switch (paramTroopInfoData.pa)
    {
    default: 
      j = i;
      if (i == -1)
      {
        if (paramTroopInfoData.nStatOption != 7) {
          break label440;
        }
        j = 3;
      }
      break;
    }
    for (;;)
    {
      i = paramTroopInfoData.getStatOption();
      bdla.b(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", j, 0, paramTroopInfoData.troopUin, paramInt1 + "", "" + i, paramInt2 + "");
      bdla.b(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", j, 0, paramTroopInfoData.troopUin, paramInt1 + "", paramInt3 + "", "");
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 6;
      break;
      i = 7;
      break;
      i = 11;
      break;
      label440:
      if (paramTroopInfoData.nStatOption == 8)
      {
        j = 4;
      }
      else
      {
        j = i;
        if (paramTroopInfoData.nStatOption == 10002) {
          j = 10;
        }
      }
    }
  }
  
  public static void checkAndOpenMemberProfileForRecommendTipsClick(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      ThreadManager.getSubThreadHandler().post(new TroopUtils.5(paramQQAppInterface, paramString1, paramString2, paramString3, paramContext));
    }
  }
  
  public static void checkApiState(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, bghi parambghi, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CHECK_API_STATE_CGI_URL);
    String str = paramQQAppInterface.getAccount();
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    paramQQAppInterface = ((TicketManager)localObject).getSkey(str);
    localObject = ((TicketManager)localObject).getPskey(str, "connect.qq.com");
    localBundle.putString("Referer", "https://cgi.connect.qq.com/");
    localBundle.putString("Cookie", "p_skey=" + (String)localObject + ";p_uin=" + str + ";skey=" + paramQQAppInterface + ";uin=" + str);
    localStringBuilder.append("?");
    localStringBuilder.append("appid=" + paramString);
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put("BUNDLE", localBundle);
    paramQQAppInterface.put("CONTEXT", paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "checkApiState params = " + localBundle);
    }
    new bghj(localStringBuilder.toString(), "GET", parambghi, paramInt, paramBundle).a(paramQQAppInterface);
  }
  
  public static boolean checkIsReadInJoySubscribe(View paramView, oidb_0xe83.TabInfo paramTabInfo)
  {
    if ((paramTabInfo != null) && (paramTabInfo.appid.get() == 1106837471L) && ((paramView.getTag(2131378489) instanceof Integer))) {
      return ((Integer)paramView.getTag(2131378489)).intValue() == 1;
    }
    return false;
  }
  
  public static boolean checkIsShowCacheAppInfos(QQAppInterface paramQQAppInterface, String paramString, ArrayList<TroopAppInfo> paramArrayList)
  {
    paramQQAppInterface = (awzf)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    paramQQAppInterface = paramQQAppInterface.a(paramQQAppInterface.a(paramString));
    return (paramQQAppInterface != null) && (paramQQAppInterface.size() > 0);
  }
  
  public static void clearMiniAppEntranceTroopRedPoint(QQAppInterface paramQQAppInterface, String paramString)
  {
    setAIOTroopMiniAppEntranceRedPoint(paramQQAppInterface, paramString, false);
    String str2 = String.valueOf(101618516L);
    ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(61, true, new Object[] { paramString, str2, Boolean.valueOf(false) });
    if (QLog.isColorLevel()) {
      if (paramString != null) {
        break label114;
      }
    }
    for (String str1 = "";; str1 = paramString)
    {
      QLog.d("TroopUtils", 2, new Object[] { "clearMiniAppEntranceTroopRedPoint. troopUin=", str1, ", type=", str2 });
      label114:
      try
      {
        int i = Integer.parseInt(str2);
        if (!TextUtils.isEmpty(paramString)) {
          bglm.a(paramQQAppInterface, paramString, i);
        }
        return;
      }
      catch (NumberFormatException paramQQAppInterface) {}
    }
  }
  
  public static void clearTabListRedDot(QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, long paramLong)
  {
    paramQQAppInterface = (awzf)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    Object localObject = paramQQAppInterface.a(paramTroopInfoData.troopUin);
    if (localObject != null) {
      try
      {
        localRspBody = new oidb_0xe83.RspBody();
        localRspBody.mergeFrom((byte[])localObject);
        localObject = localRspBody.extra_info.tab_infos.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localTabInfo = (oidb_0xe83.TabInfo)((Iterator)localObject).next();
          if (localTabInfo.appid.get() == paramLong)
          {
            localTabInfo.red_point.set(0);
            if (paramLong == 1106837471L)
            {
              localTabInfo.desc.set("");
              localTabInfo.pic.set("");
              continue;
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopUtils.troop.troop_app", 2, "init, cached troopAppListData exception");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      oidb_0xe83.RspBody localRspBody;
      oidb_0xe83.TabInfo localTabInfo;
      paramQQAppInterface.a(paramTroopInfoData.troopUin, localRspBody.toByteArray());
      return;
    }
    QLog.d("TroopUtils.troop.troop_app", 2, "init, cached troopAppListData==null");
  }
  
  public static int configTroopOption(SearchGroup.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.bGroupAllow.has()) && (paramGroupInfo.bGroupAllow.get())) {
      return 2;
    }
    return 3;
  }
  
  public static String constructParams(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      return null;
    }
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localObject = new JSONObject();
      Iterator localIterator = paramBundle1.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((JSONObject)localObject).put(str, wrap(paramBundle1.get(str)));
        continue;
        return paramBundle1;
      }
    }
    catch (JSONException paramBundle1)
    {
      paramBundle1.printStackTrace();
      paramBundle1 = null;
    }
    for (;;)
    {
      localJSONObject2.put("param", localObject);
      if (paramBundle2 != null)
      {
        paramBundle1 = paramBundle2.keySet().iterator();
        while (paramBundle1.hasNext())
        {
          localObject = (String)paramBundle1.next();
          localJSONObject2.put((String)localObject, wrap(paramBundle2.get((String)localObject)));
        }
      }
      localJSONObject1.put("key", localJSONObject2);
      paramBundle1 = localJSONObject1.toString();
    }
  }
  
  public static String convSex(int paramInt)
  {
    if (paramInt == 2) {
      return anvx.a(2131715174);
    }
    return anvx.a(2131715172);
  }
  
  public static final int convSfToReportParam(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
      if (paramString != null)
      {
        if (paramString.isTroopOwner(paramQQAppInterface.getCurrentUin())) {
          return 0;
        }
        if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentUin())) {
          return 1;
        }
        return 2;
      }
    }
    return 2;
  }
  
  public static long convertQQFullVersion2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    int j = 0;
    int m = 0;
    int k = 0;
    int n;
    if (j < paramString.length())
    {
      i = paramString.charAt(j);
      if ((i >= 48) && (i <= 57))
      {
        arrayOfInt[k] = (arrayOfInt[k] * 10 + (i - 48));
        i = 1;
        n = k;
      }
    }
    for (;;)
    {
      j += 1;
      m = i;
      k = n;
      break;
      if ((m != 0) && ((k == 3) || (i == 46)))
      {
        n = k + 1;
        if (n >= arrayOfInt.length)
        {
          long l = arrayOfInt[3] % 10000 + arrayOfInt[2] % 1000 * 10000 + arrayOfInt[1] % 1000 * 10000000 + arrayOfInt[0] % 1000 * 10000000000L;
          if (QLog.isColorLevel()) {
            QLog.i("TroopUtils", 2, String.format("convertQQFullVersion2Long [%s, %s]", new Object[] { Long.valueOf(l), paramString }));
          }
          return l;
        }
        i = 0;
      }
      else
      {
        i = m;
        n = k;
        if (m != 0)
        {
          arrayOfInt[k] = 0;
          i = 0;
          n = k;
        }
      }
    }
  }
  
  public static EntryModel createEntryModel(TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {
      return null;
    }
    EntryModel localEntryModel = new EntryModel(1, Long.parseLong(paramTroopInfo.troopuin), paramTroopInfo.troopname, paramTroopInfo.isAdmin());
    localEntryModel.reportData = ("groupid=" + paramString);
    localEntryModel.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
    return localEntryModel;
  }
  
  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split("\\?");
      if (arrayOfString.length == 2) {
        paramString = arrayOfString[1];
      }
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          arrayOfString = paramString[i].split("=");
          if (arrayOfString.length == 2) {}
          try
          {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
            i += 1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
        }
      }
    }
    return localBundle;
  }
  
  public static void doReportTroop(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramTroopInfoData == null) || (paramQQAppInterface == null)) {
      return;
    }
    int i;
    if (paramBaseActivity.getIntent().getIntExtra("t_s_f", -1) == 1002) {
      i = 20014;
    }
    for (;;)
    {
      String str1 = paramTroopInfoData.troopUin;
      if (!paramTroopInfoData.isMember) {
        break;
      }
      bhbu.a("Grp_set_new", "grpData_admin", "clk_report", 0, 0, new String[] { paramTroopInfoData.troopUin, bhbu.a(paramTroopInfoData) });
      paramTroopInfoData = aaqo.a(str1, 1);
      aaqo.a(paramBaseActivity, str1, null, null, str1, paramQQAppInterface.getAccount(), i, null, paramTroopInfoData);
      return;
      if (paramTroopInfoData.isMember) {
        i = 22000;
      } else {
        i = 22003;
      }
    }
    String str2 = paramTroopInfoData.troopUin;
    if (paramTroopInfoData.isMember) {}
    for (paramTroopInfoData = "1";; paramTroopInfoData = "0")
    {
      bhbu.a("Grp_set_new", "grpData_visitor", "clk_report", 0, 0, new String[] { str2, paramTroopInfoData });
      paramTroopInfoData = null;
      break;
    }
  }
  
  public static String encrypt(String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(getBytesUTF8(paramString));
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = paramString;
      if (arrayOfByte != null)
      {
        localObject = new StringBuilder();
        int j = arrayOfByte.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfByte[i];
          ((StringBuilder)localObject).append(hexDigit(k >>> 4));
          ((StringBuilder)localObject).append(hexDigit(k));
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      do
      {
        Object localObject = paramString;
      } while (!QLog.isColorLevel());
      QLog.e("TroopUtils", 2, "encrypt has exception: " + localNoSuchAlgorithmException.getMessage());
    }
    return localObject;
    return paramString;
  }
  
  public static void enterTroopAio(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    paramContext = ContactUtils.getTroopName((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, false);
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent((Context)localObject, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramContext);
    localIntent.putExtra("isBack2Root", true);
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
    ((Context)localObject).startActivity(localIntent);
  }
  
  public static void expandFoldMsg(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new bglh();
    paramContext.jdField_a_of_type_Int = 1;
    paramContext.jdField_a_of_type_Boolean = true;
    try
    {
      paramContext.jdField_a_of_type_Long = Long.parseLong(paramString2);
      paramContext.b = bkyd.a(paramString3);
      paramQQAppInterface.getMessageFacade().setChangeAndNotify(paramContext);
      bdla.b(null, "dc00898", "", "", "0X800ADF1", "0X800ADF1", 0, 1, "", "", "", "");
      return;
    }
    catch (NumberFormatException paramMessageRecord)
    {
      for (;;)
      {
        QLog.e("TroopUtils", 1, paramMessageRecord, new Object[0]);
        paramContext.jdField_a_of_type_Long = 0L;
      }
    }
  }
  
  public static void foldSameMsg(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new bglh();
    paramContext.jdField_a_of_type_Int = 2;
    paramContext.jdField_a_of_type_Boolean = true;
    paramContext.jdField_a_of_type_Long = bkyd.a(paramString2);
    paramContext.b = bkyd.a(paramString3);
    paramQQAppInterface.getMessageFacade().setChangeAndNotify(paramContext);
    bdla.b(null, "dc00898", "", "", "0X800B190", "0X800B190", 0, 1, "", "", "", "");
  }
  
  public static boolean getAIOTroopMiniAppEntranceRedPoint(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "AIO_TROOP_MINI_APP_ENTRANCE", 0).getBoolean(paramString, false);
  }
  
  public static boolean getBeTipsScenceTypeConfigOpen(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    if ("newJoin".equals(paramString)) {
      if (paramQQAppInterface.jdField_a_of_type_Int == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "checkSwitch scene = " + paramString + ",result = " + bool + ",config.switchOn = " + paramQQAppInterface.jdField_a_of_type_Int + ",config.au_switchOn = " + paramQQAppInterface.h + ",config.hfi_switchOn = " + paramQQAppInterface.l + ",config.nm_switchOn = " + paramQQAppInterface.o + ",config.aor_switchOn = " + paramQQAppInterface.q);
      }
      return bool;
      bool = false;
      continue;
      if ("activeUser".equals(paramString))
      {
        if (paramQQAppInterface.h != 1) {
          bool = false;
        }
      }
      else if ("highFreqInteract".equals(paramString))
      {
        if (paramQQAppInterface.l != 1) {
          bool = false;
        }
      }
      else if ("newMember".equals(paramString))
      {
        if (paramQQAppInterface.o != 1) {
          bool = false;
        }
      }
      else if ("atMeOrReplyMe".equals(paramString))
      {
        if (paramQQAppInterface.q != 1) {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public static int getBknBySkey(String paramString)
  {
    int i = 0;
    if (StringUtil.isEmpty(paramString)) {
      return 0;
    }
    int j = 5381;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static byte[] getBytesUTF8(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static String getDateString(long paramLong)
  {
    String str = "";
    if (paramLong > 0L) {
      str = new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(1000L * paramLong));
    }
    return str;
  }
  
  public static String getDateString(Context paramContext, long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = paramContext.getResources().getString(2131695863) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  public static int getExposureSourceReportVal()
  {
    if (mExposureSource == 1) {
      return 1;
    }
    return 2;
  }
  
  public static String getLocalSkey(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static int getMessageHistoryCont(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          return 0;
          paramQQAppInterface = paramQQAppInterface.getReadableDatabase();
        } while (paramQQAppInterface == null);
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype ");
        localStringBuilder.append(acnh.b());
        localStringBuilder.append(" and isValid=1 ");
        paramString = bhff.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramQQAppInterface, localStringBuilder.toString());
      } while (paramString == null);
      paramQQAppInterface = paramQQAppInterface.rawQuery(paramString.toString(), null);
    } while (paramQQAppInterface == null);
    if ((paramQQAppInterface.getCount() > 0) && (paramStringBuilder != null))
    {
      paramQQAppInterface.moveToLast();
      paramInt = paramQQAppInterface.getColumnIndex("shmsgseq");
    }
    try
    {
      if (!paramQQAppInterface.isNull(paramInt))
      {
        l = paramQQAppInterface.getLong(paramInt);
        if (l > 0L) {
          paramStringBuilder.append(String.valueOf(l));
        }
        paramInt = paramQQAppInterface.getCount();
        paramQQAppInterface.close();
        return paramInt;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("TroopUtils", 1, "lastMessage error:", paramString);
        long l = 0L;
      }
    }
  }
  
  public static String getMsgInfo(structmsg.StructMsg paramStructMsg, String paramString)
  {
    String str = paramString;
    if (paramString.contains("%req_uin%"))
    {
      str = paramStructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        paramString = null;
      }
    }
    do
    {
      return paramString;
      str = paramString.replace("%req_uin%", str);
      paramString = str;
      if (str.contains("%action_uin%"))
      {
        paramString = paramStructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramString = str.replace("%action_uin%", paramString);
      }
      str = paramString;
      if (paramString.contains("%actor_uin%"))
      {
        str = paramStructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = paramString.replace("%actor_uin%", str);
      }
      paramString = str;
    } while (!str.contains("%group_name%"));
    paramStructMsg = paramStructMsg.msg.group_name.get();
    if (TextUtils.isEmpty(paramStructMsg)) {
      return null;
    }
    return str.replace("%group_name%", paramStructMsg);
  }
  
  public static int getMsgSenderType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    }
    return 1;
  }
  
  /* Error */
  public static byte[] getRecommendGrayTipsCookie(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: ifnull +112 -> 124
    //   15: aload 5
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +105 -> 124
    //   22: new 126	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: invokevirtual 918	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokevirtual 1127	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   36: invokevirtual 1131	android/content/Context:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 1136	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 1139	java/io/File:separator	Ljava/lang/String;
    //   48: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 9
    //   53: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_0
    //   64: new 1133	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 1140	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 1143	java/io/File:exists	()Z
    //   77: ifeq +241 -> 318
    //   80: new 1145	java/io/FileInputStream
    //   83: dup
    //   84: aload_0
    //   85: invokespecial 1148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: astore_0
    //   89: aload_0
    //   90: astore_2
    //   91: aload_0
    //   92: invokevirtual 1151	java/io/FileInputStream:available	()I
    //   95: newarray byte
    //   97: astore_1
    //   98: aload_0
    //   99: astore_2
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 1155	java/io/FileInputStream:read	([B)I
    //   105: pop
    //   106: aload_1
    //   107: astore_2
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: astore_0
    //   112: aload_0
    //   113: astore_2
    //   114: aload_1
    //   115: ifnull +9 -> 124
    //   118: aload_1
    //   119: invokevirtual 1156	java/io/FileInputStream:close	()V
    //   122: aload_0
    //   123: astore_2
    //   124: aload_2
    //   125: areturn
    //   126: astore_1
    //   127: aload_0
    //   128: astore_2
    //   129: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq -8 -> 124
    //   135: ldc 46
    //   137: iconst_2
    //   138: new 126	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 1158
    //   148: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_0
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload 4
    //   168: astore_1
    //   169: aload_0
    //   170: astore_2
    //   171: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +31 -> 205
    //   177: aload_0
    //   178: astore_2
    //   179: ldc 46
    //   181: iconst_2
    //   182: new 126	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 1158
    //   192: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_3
    //   196: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_1
    //   206: astore_2
    //   207: aload_0
    //   208: ifnull -84 -> 124
    //   211: aload_0
    //   212: invokevirtual 1156	java/io/FileInputStream:close	()V
    //   215: aload_1
    //   216: areturn
    //   217: astore_0
    //   218: aload_1
    //   219: astore_2
    //   220: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq -99 -> 124
    //   226: ldc 46
    //   228: iconst_2
    //   229: new 126	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 1158
    //   239: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload_1
    //   253: areturn
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_2
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 1156	java/io/FileInputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: astore_1
    //   268: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq -6 -> 265
    //   274: ldc 46
    //   276: iconst_2
    //   277: new 126	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 1158
    //   287: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_1
    //   291: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: goto -35 -> 265
    //   303: astore_0
    //   304: goto -47 -> 257
    //   307: astore_3
    //   308: aload 4
    //   310: astore_1
    //   311: goto -142 -> 169
    //   314: astore_3
    //   315: goto -146 -> 169
    //   318: aconst_null
    //   319: astore_1
    //   320: aload_3
    //   321: astore_0
    //   322: goto -210 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramQQAppInterface	QQAppInterface
    //   0	325	1	paramString	String
    //   10	252	2	localObject1	Object
    //   7	1	3	localObject2	Object
    //   163	33	3	localException1	Exception
    //   307	1	3	localException2	Exception
    //   314	7	3	localException3	Exception
    //   4	305	4	localObject3	Object
    //   1	15	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   118	122	126	java/lang/Exception
    //   64	89	163	java/lang/Exception
    //   211	215	217	java/lang/Exception
    //   64	89	254	finally
    //   261	265	267	java/lang/Exception
    //   91	98	303	finally
    //   100	106	303	finally
    //   171	177	303	finally
    //   179	205	303	finally
    //   91	98	307	java/lang/Exception
    //   100	106	314	java/lang/Exception
  }
  
  public static long getRecommendGrayTipsLastInsertTime(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("last_add_time", 0L);
      }
    }
    return l1;
  }
  
  public static long getRecommendGrayTipsReportTimestamp(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("report_timestamp", -1L);
      }
    }
    return l1;
  }
  
  public static long getRecommendOldGrayTipsLastInsertTime(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("old_last_add_time", 0L);
      }
    }
    return l1;
  }
  
  public static Pair<String, ArrayList<MessageForText.AtTroopMemberInfo>> getSendMsg(Editable paramEditable)
  {
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    paramEditable = bgcz.a(paramEditable, localArrayList);
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo2;
    if (!localArrayList.isEmpty())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo1 = (MessageForText.AtTroopMemberInfo)localArrayList.get(0);
      localAtTroopMemberInfo2 = (MessageForText.AtTroopMemberInfo)localArrayList.get(localArrayList.size() - 1);
      if ((localAtTroopMemberInfo1 == null) || (localAtTroopMemberInfo2 == null)) {
        break label109;
      }
      j = localAtTroopMemberInfo1.startPos;
    }
    label109:
    for (int i = localAtTroopMemberInfo2.startPos + localAtTroopMemberInfo2.textLen;; i = -1)
    {
      if ((j >= 0) && (i >= 0) && (j < i)) {
        paramEditable = paramEditable.substring(j, i);
      }
      for (;;)
      {
        return new Pair(paramEditable, localArrayList);
      }
    }
  }
  
  public static int getTalkType(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return -1;
  }
  
  public static String getTroopAdministrator(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<oidb_0x899.memberlist> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    int j = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < j)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(i);
      if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
      for (;;)
      {
        i += 1;
        break;
        long l = localmemberlist.uint64_member_uin.get();
        if (l != 0L) {
          localStringBuilder.append(String.valueOf(l) + "|");
        }
      }
    }
    paramTroopInfo.Administrator = localStringBuilder.toString();
    if (paramBoolean) {
      ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopInfo);
    }
    return localStringBuilder.toString();
  }
  
  public static boolean getTroopHasNewApp(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_troop_app_has_new", 0).getBoolean(paramString, false);
  }
  
  public static int getTroopIdentity(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 3;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
        return 0;
      }
      if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentAccountUin())) {
        return 1;
      }
      if (TroopInfo.isTroopMember(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin())) {
        return 2;
      }
    }
    return 3;
  }
  
  public static boolean getTroopInfoEditRedShow(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramString != null) {
        bool1 = paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getBoolean("red_tag_" + paramInt, true);
      }
    }
    return bool1;
  }
  
  public static Drawable getTroopLevelBgDrawable(Resources paramResources, int paramInt)
  {
    return getTroopLevelBgDrawable(paramResources, paramInt, paramResources.getDrawable(2130849718));
  }
  
  public static Drawable getTroopLevelBgDrawable(Resources paramResources, int paramInt, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 10) {}
    for (paramResources = paramDrawable.getConstantState().newDrawable(paramResources);; paramResources = paramDrawable.getConstantState().newDrawable(paramResources).mutate())
    {
      paramResources.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramResources.setAlpha(paramInt >>> 24);
      return paramResources;
    }
  }
  
  public static boolean getTroopManageEditRedShow(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (paramString2 != null) {
          bool1 = paramContext.getSharedPreferences("sp_troop_info_edit_red_show_" + paramString1 + "_" + paramString2, 0).getBoolean("manage_red", true);
        }
      }
    }
    return bool1;
  }
  
  public static Bundle getTroopProfileExtra(int paramInt1, GroupInfo paramGroupInfo, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.lCode));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.lUin));
    localBundle.putString("troop_info_name", paramGroupInfo.strName);
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.iFaceId);
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.strIntro);
    localBundle.putString("troop_info_loca", paramGroupInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwCertType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.iMemberCnt);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", (int)paramGroupInfo.dwGroupActiveGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("authSig", paramGroupInfo.strJoinSig);
    if (!TextUtils.isEmpty(paramGroupInfo.strJoinAuth)) {
      localBundle.putString("authKey", paramGroupInfo.strJoinAuth);
    }
    return localBundle;
  }
  
  public static Bundle getTroopProfileExtra(int paramInt1, RecommendTroopInfo paramRecommendTroopInfo, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramRecommendTroopInfo.uin));
    localBundle.putString("troop_code", String.valueOf(paramRecommendTroopInfo.code));
    localBundle.putString("troop_info_name", paramRecommendTroopInfo.name);
    localBundle.putByte("troop_info_opt", (byte)paramRecommendTroopInfo.option);
    localBundle.putString("troop_info_owner", String.valueOf(paramRecommendTroopInfo.ownerUin));
    localBundle.putLong("troop_info_classext", paramRecommendTroopInfo.classId);
    localBundle.putShort("troop_info_faceid", (short)paramRecommendTroopInfo.faceId);
    localBundle.putString("troop_info_fingermemo", paramRecommendTroopInfo.fingerMemo);
    localBundle.putString("troop_info_loca", paramRecommendTroopInfo.location);
    localBundle.putBoolean("troop_info_is_member", paramRecommendTroopInfo.isTroopIn);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramRecommendTroopInfo.flagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramRecommendTroopInfo.authType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramRecommendTroopInfo.curMemberNum);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramRecommendTroopInfo.hotDegree);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle getTroopProfileExtra(int paramInt1, TroopInfo paramTroopInfo, int paramInt2, boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", paramTroopInfo.troopuin);
    localBundle.putString("troop_code", paramTroopInfo.troopcode);
    localBundle.putString("troop_info_name", paramTroopInfo.getTroopName());
    localBundle.putByte("troop_info_opt", (byte)paramTroopInfo.cGroupOption);
    localBundle.putString("troop_info_owner", paramTroopInfo.troopowneruin);
    localBundle.putString("troop_info_admi", paramTroopInfo.Administrator);
    localBundle.putLong("troop_info_classext", paramTroopInfo.dwGroupClassExt);
    localBundle.putShort("troop_info_faceid", paramTroopInfo.troopface);
    localBundle.putString("troop_info_fingermemo", paramTroopInfo.fingertroopmemo);
    localBundle.putString("troop_info_loca", paramTroopInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramTroopInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramTroopInfo.dwAuthGroupType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramTroopInfo.wMemberNum);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramTroopInfo.nTroopGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle getTroopProfileExtra(int paramInt1, SearchGroup.GroupInfo paramGroupInfo, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.dwGroupCode.get()));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.dwGroupUin.get()));
    localBundle.putString("troop_info_name", paramGroupInfo.sGroupName.get());
    localBundle.putByte("troop_info_opt", (byte)configTroopOption(paramGroupInfo));
    localBundle.putString("troop_info_owner", String.valueOf(paramGroupInfo.dwGroupOwnerId.get()));
    localBundle.putLong("troop_info_classext", paramGroupInfo.dwGroupClass.get());
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.dwGroupFaceId.get());
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.sGroupFingerMem.get());
    localBundle.putString("troop_info_loca", paramGroupInfo.sGroupLocation.get());
    localBundle.putBoolean("troop_info_is_member", paramGroupInfo.bGroupIn.get());
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt.get());
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwAuthGroupType.get());
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.dwCurMemberNum.get());
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramGroupInfo.dwGroupHotDegree.get());
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static boolean getmIsShowTroopAppShortcutBar()
  {
    return mIsShowTroopAppShortcutBar;
  }
  
  public static void gotoQZoneQun(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool;
    QZoneHelper.UserInfo localUserInfo;
    if (paramInt != 0)
    {
      bool = true;
      localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = paramQQAppInterface.getCurrentAccountUin();
      localUserInfo.nickname = paramQQAppInterface.getCurrentNickname();
      aoep localaoep = (aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (!TextUtils.isEmpty(paramString1)) {
        localaoep.e(paramString1, true);
      }
      if (bhdf.a(paramQQAppInterface.getCurrentAccountUin(), "troop_photo_message", paramString1) <= 0) {
        break label120;
      }
      QZoneHelper.forwardToQunPassiveFeed(paramActivity, localUserInfo, paramString1, 7);
    }
    for (;;)
    {
      bdla.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_album", 0, 0, paramString1, "", "", "");
      nvs.a(paramQQAppInterface, 66);
      return;
      bool = false;
      break;
      label120:
      QZoneHelper.forwardToQunFeed(paramActivity, localUserInfo, paramString1, paramString2, bool, 7);
    }
  }
  
  public static void handleJoinTroopFailed(Activity paramActivity, int paramInt)
  {
    bisy localbisy = new bisy(paramActivity);
    int i = paramActivity.getResources().getDimensionPixelSize(2131299080);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    default: 
      localbisy.a(2131693399, i, 0, 1);
      return;
    case 2: 
      localbisy.a(anvx.a(2131715178), i, 0, 1);
      return;
    case 3: 
      localbisy.a(anvx.a(2131715167), i, 0, 1);
      return;
    case 4: 
      localbisy.a(anvx.a(2131715173), i, 0, 1);
      return;
    case 5: 
      localbisy.a(anvx.a(2131715168), i, 0, 1);
      return;
    }
    localbisy.a(2131719620, i, 0, 1);
  }
  
  public static void handleModifyName(long paramLong1, String paramString, long paramLong2)
  {
    String str = Long.toString(paramLong1);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(str);
    if (localTroopInfo != null) {
      if (TextUtils.equals(paramString, localTroopInfo.oldTroopName)) {
        break label193;
      }
    }
    label193:
    for (int i = 1;; i = 0)
    {
      localTroopInfo.troopname = paramString;
      localTroopInfo.oldTroopName = paramString;
      localTroopInfo.hasSetNewTroopName = true;
      ((TroopManager)localObject).b(localTroopInfo);
      localObject = (aoep)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      ((aoep)localObject).notifyUI(2, false, null);
      ((anrb)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).notifyUI(43, true, new Object[] { str, paramString, null });
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopUtils", 2, "TroopUtils handleModifyName :" + localTroopInfo.troopname);
        }
        ((aoep)localObject).b(str, String.valueOf(paramLong2), paramString);
      }
      return;
    }
  }
  
  public static boolean hasCreateOrManageTroop()
  {
    Object localObject = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).b();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean hasSetTroopHead(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
    paramString = localTroopManager.d(paramString);
    if (paramString != null) {
      return paramString.hasSetTroopHead();
    }
    return (aoep.jdField_a_of_type_Boolean) && (localTroopManager.b());
  }
  
  public static Bitmap headDrawableToBitamp(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    int i;
    if (j > 0)
    {
      i = k;
      if (k > 0) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "drawable width or height is 0, and use default drawable");
      }
      paramDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      j = paramDrawable.getIntrinsicWidth();
      k = paramDrawable.getIntrinsicHeight();
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopUtils", 2, "the default drawable width or height is 0");
        }
        return null;
      }
    }
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(j, i, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, j, i);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  private static char hexDigit(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static TroopInfo initTroopInfo(QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Context paramContext)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(paramTroopInfoData.troopUin);
      if (localObject != null)
      {
        paramTroopInfoData.isMember = true;
        paramTroopInfoData.updateForTroopChatSetting((TroopInfo)localObject, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
      }
      return localObject;
    }
    return null;
  }
  
  public static TroopInfoData initTroopInfoData(Bundle paramBundle, Context paramContext)
  {
    TroopInfoData localTroopInfoData = new TroopInfoData();
    if (paramBundle == null) {}
    for (;;)
    {
      return localTroopInfoData;
      localTroopInfoData.troopUin = paramBundle.getString("troop_uin");
      localTroopInfoData.troopCode = paramBundle.getString("troop_code");
      try
      {
        long l = Long.parseLong(localTroopInfoData.troopUin);
        if (l > 0L)
        {
          localTroopInfoData.pa = paramBundle.getInt("troop_info_from");
          localTroopInfoData.nStatOption = paramBundle.getInt("troop_info_from_ex");
          localTroopInfoData.remark = paramBundle.getString("param_return_addr");
          localTroopInfoData.isMember = paramBundle.getBoolean("troop_info_is_member");
          localTroopInfoData.troopface = paramBundle.getShort("troop_info_faceid");
          localTroopInfoData.troopName = paramBundle.getString("troop_info_name");
          localTroopInfoData.newTroopName = localTroopInfoData.troopName;
          localTroopInfoData.troopowneruin = paramBundle.getString("troop_info_owner");
          localTroopInfoData.dwGroupClassExt = paramBundle.getLong("troop_info_classext");
          localTroopInfoData.troopLocation = paramBundle.getString("troop_info_loca");
          localTroopInfoData.mRichFingerMemo = paramBundle.getString("troop_info_fingermemo");
          if (!TextUtils.isEmpty(localTroopInfoData.mRichFingerMemo))
          {
            localTroopInfoData.mRichFingerMemo = HttpUtil.removeHtmlTags(localTroopInfoData.mRichFingerMemo);
            localTroopInfoData.mRichFingerMemo = HttpUtil.unEscape(localTroopInfoData.mRichFingerMemo);
          }
          localTroopInfoData.cGroupOption = ((short)paramBundle.getByte("troop_info_opt"));
          localTroopInfoData.mStrJoinQuestion = bhbv.b(paramContext, localTroopInfoData.troopUin);
          localTroopInfoData.nTroopGrade = paramBundle.getInt("TROOP_INFO_TROOP_GRADE");
          localTroopInfoData.mStrJoinAnswer = bhbv.c(paramContext, localTroopInfoData.troopUin);
          localTroopInfoData.dwGroupFlagExt = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
          localTroopInfoData.dwAuthGroupType = paramBundle.getLong("TROOP_INFO_AUTH_TYPE");
          localTroopInfoData.troopTags = TroopInfo.getTags(paramBundle.getString("TROOP_INFO_TAGS_EXT"));
          return localTroopInfoData;
        }
      }
      catch (NumberFormatException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    return localTroopInfoData;
  }
  
  public static void insertHistoryGrayTips(QQAppInterface paramQQAppInterface, String paramString, List<ChatMessage> paramList)
  {
    long l = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    Object localObject1 = null;
    int i;
    ChatMessage localChatMessage;
    Object localObject2;
    if (l > 0L)
    {
      i = 0;
      for (;;)
      {
        if (i < paramList.size())
        {
          localChatMessage = (ChatMessage)paramList.get(i);
          if ((!(localChatMessage instanceof MessageForGrayTips)) && ((!(localChatMessage instanceof MessageForUniteGrayTip)) || (localChatMessage.time == l)))
          {
            if ((localChatMessage instanceof MessageForNewGrayTips))
            {
              localObject2 = localObject1;
              localObject1 = localObject2;
              i += 1;
              continue;
            }
            if ((localChatMessage instanceof MessageForSplitLineTips))
            {
              localObject2 = (MessageForSplitLineTips)localChatMessage;
              ((MessageForSplitLineTips)localObject2).parse();
              if (!anvx.a(2131715170).equalsIgnoreCase(((MessageForSplitLineTips)localObject2).msgContent)) {
                break;
              }
            }
          }
        }
      }
    }
    label266:
    for (;;)
    {
      return;
      localObject2 = localChatMessage;
      if (localChatMessage.time < l) {
        break;
      }
      for (;;)
      {
        if ((i <= 0) || (localObject1 == null)) {
          break label266;
        }
        localObject2 = (MessageForSplitLineTips)bcsa.a(-4012);
        ((MessageForSplitLineTips)localObject2).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), anvx.a(2131715175), l, -4012, 1, l);
        ((MessageForSplitLineTips)localObject2).shmsgseq = localObject1.shmsgseq;
        ((MessageForSplitLineTips)localObject2).isread = true;
        ((MessageForSplitLineTips)localObject2).mNeedTimeStamp = false;
        ((MessageForSplitLineTips)localObject2).msgContent = anvx.a(2131715176);
        ((MessageForSplitLineTips)localObject2).subType = 1;
        paramList.add(i, localObject2);
        return;
        localObject2 = localObject1;
        break;
        continue;
        i = 0;
        localObject1 = null;
      }
    }
  }
  
  public static boolean isArrayEmpty(List<?> paramList)
  {
    return (paramList == null) || (paramList.size() < 1);
  }
  
  public static boolean isEmptyRedPointSP(String paramString)
  {
    String str = SharePreferenceUtils.get(BaseApplicationImpl.getApplication(), paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, String.format("isEmptyRedPointSP [%s, %s]", new Object[] { paramString, str }));
    }
    return TextUtils.isEmpty(str);
  }
  
  public static boolean isEnabledCount()
  {
    return sEnbaleTipsCountLimit;
  }
  
  private static boolean isHostMode(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramInt == 1) || ((paramBoolean1) && (!paramBoolean2));
  }
  
  public static boolean isShowKingTeamRedPoint(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (isEmptyRedPointSP(paramString));
  }
  
  public static boolean isShowRedPoint(boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    if (paramBoolean) {}
    for (boolean bool1 = isEmptyRedPointSP(paramString);; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, String.format("isShowRedPoint [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
      }
      boolean bool2 = bool3;
      if (paramBoolean)
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public static boolean isSupportRevokeMsg(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (TextUtils.equals(paramMessageRecord.senderuin, paramString)) {
        return true;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessageRecord.frienduin);
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramQQAppInterface.isTroopOwner(paramString)) {
        return true;
      }
      if ((paramQQAppInterface.isTroopAdmin(paramString)) && (!paramQQAppInterface.isTroopOwner(paramMessageRecord.senderuin)) && (!paramQQAppInterface.isTroopAdmin(paramMessageRecord.senderuin))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSupportRevokeMsgByTroopOwnerOrMgr(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (TextUtils.equals(paramMessageRecord.senderuin, paramString)) {
        return false;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessageRecord.frienduin);
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramQQAppInterface.isTroopOwner(paramString)) {
        return true;
      }
      if ((paramQQAppInterface.isTroopAdmin(paramString)) && (!paramQQAppInterface.isTroopOwner(paramMessageRecord.senderuin)) && (!paramQQAppInterface.isTroopAdmin(paramMessageRecord.senderuin))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isTroopAdmin(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopAdmin(paramString2);
  }
  
  public static boolean isTroopEditInfoRedExist(QQAppInterface paramQQAppInterface, String paramString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramArrayOfInt != null)
        {
          bool1 = bool2;
          if (paramArrayOfBoolean != null)
          {
            bool1 = bool2;
            if (paramArrayOfInt.length == paramArrayOfBoolean.length)
            {
              paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramArrayOfInt.length) {
        if (paramArrayOfBoolean[i] == 0) {
          break label149;
        }
      }
      label149:
      for (bool1 = paramQQAppInterface.getBoolean("red_tag_" + paramArrayOfInt[i], true); bool1; bool1 = false)
      {
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isTroopOwner(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopOwner(paramString2);
  }
  
  public static boolean isTroopOwnerOrAdmin(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessageRecord.frienduin);
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((paramQQAppInterface.isTroopOwner(paramString)) || (paramQQAppInterface.isTroopAdmin(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isTroopTagNeedRedDot(long paramLong)
  {
    return (paramLong != 10009L) && (paramLong != 10010L) && (paramLong != 10011L) && (paramLong != 32L);
  }
  
  public static boolean isUpdateBeforeSomeVersion(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = paramContext.getSharedPreferences("UserGuide", 0);
          paramContext = ((SharedPreferences)localObject).getString("qq_version_pre", null);
          localObject = ((SharedPreferences)localObject).getString("qq_version_full_pre", null);
          if (!TextUtils.isEmpty(paramContext)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre[%s, %s]", new Object[] { paramContext, localObject }));
        return false;
        if (!TextUtils.equals("4875", paramContext)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { "4875", paramContext }));
      return false;
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = "8.0.0";
      }
      localObject = AppSetting.a();
      if (!TextUtils.equals(paramContext, (CharSequence)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { localObject, paramContext }));
    return false;
    long l1 = convertQQFullVersion2Long(paramString);
    long l2 = convertQQFullVersion2Long(paramContext);
    if (Math.abs(l2) < Math.abs(l1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion some: %s, pre: %s, ret: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  public static void joinGroupOneStep(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, bghi parambghi)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramIntent == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("o");
    Object localObject2;
    String str3;
    String str2;
    if (str1.length() < 10)
    {
      int i = 0;
      while (i < 10 - str1.length())
      {
        ((StringBuilder)localObject1).append("0");
        i += 1;
      }
      ((StringBuilder)localObject1).append(str1);
      localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
      localBundle.putString("Cookie", "uin=" + localObject1 + "; skey=" + ((TicketManager)localObject2).getSkey(str1));
      localBundle.putString("Host", "info.gamecenter.qq.com");
      str3 = paramIntent.getStringExtra("appid");
      str2 = paramIntent.getStringExtra("is_from_game");
      str1 = "";
      localObject1 = "";
      localObject2 = "";
      if ((!"true".equals(str2)) || (TextUtils.isEmpty(str3))) {
        break label499;
      }
      checkApiState(paramQQAppInterface, paramContext, str3, parambghi, 0, null);
      localObject1 = paramIntent.getStringExtra("guild_id");
      str1 = paramIntent.getStringExtra("zone_id");
      paramQQAppInterface = paramIntent.getStringExtra("role_id");
      localObject2 = paramIntent.getStringExtra("gc");
      paramIntent = paramQQAppInterface;
      paramQQAppInterface = (QQAppInterface)localObject2;
    }
    for (;;)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appid", str3);
      ((Bundle)localObject2).putString("guild_id", (String)localObject1);
      ((Bundle)localObject2).putString("zone_id", str1);
      ((Bundle)localObject2).putString("gc", paramQQAppInterface);
      ((Bundle)localObject2).putString("platid", "2");
      ((Bundle)localObject2).putString("roleid", paramIntent);
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("module", "gc_bind_group_svr");
      paramQQAppInterface.putString("method", "join_group");
      paramQQAppInterface = constructParams((Bundle)localObject2, paramQQAppInterface);
      localBundle.putString("param", paramQQAppInterface);
      localBundle.putString("signature", encrypt(paramQQAppInterface + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put("BUNDLE", localBundle);
      paramQQAppInterface.put("CONTEXT", paramContext);
      new bghj(localStringBuilder.toString(), "GET", parambghi, 1, null).a(paramQQAppInterface);
      return;
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(str1);
      break;
      label499:
      str2 = "";
      paramQQAppInterface = (QQAppInterface)localObject2;
      paramIntent = (Intent)localObject1;
      localObject1 = str2;
    }
  }
  
  public static void joinRecommendTroop(Context paramContext, RecommendTroopItem paramRecommendTroopItem, int paramInt)
  {
    paramRecommendTroopItem = paramRecommendTroopItem.getJumpUrl(paramInt);
    Intent localIntent = new Intent(paramContext, JoinGroupTransitActivity.class);
    localIntent.putExtra("source_scheme", paramRecommendTroopItem);
    paramContext.startActivity(localIntent);
  }
  
  public static void jumpRobotPage(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("be_admin_in_the_troop", paramBoolean);
    PublicFragmentActivity.a(paramActivity, localIntent, TroopRobotFragment.class);
    if (QLog.isColorLevel()) {
      QLog.d("TroopUtils", 2, "jumpRobotPage");
    }
  }
  
  public static void notifyUser(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    new bisy(paramContext).a(paramInt2, paramInt1, 0, paramInt3);
  }
  
  public static void openRecommendTroop(Context paramContext, RecommendTroopItem paramRecommendTroopItem, int paramInt1, int paramInt2)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    for (;;)
    {
      try
      {
        localGroupInfo.lCode = Long.valueOf(paramRecommendTroopItem.uin).longValue();
        localGroupInfo.strName = paramRecommendTroopItem.name;
        if (TextUtils.isEmpty(paramRecommendTroopItem.recommendReason))
        {
          localGroupInfo.strIntro = paramRecommendTroopItem.intro;
          localGroupInfo.iMemberCnt = paramRecommendTroopItem.memberNum;
          ArrayList localArrayList = ntx.a(paramRecommendTroopItem);
          if (localArrayList != null) {
            localGroupInfo.labels = localArrayList;
          }
          localGroupInfo.strJoinSig = paramRecommendTroopItem.authSig;
          openTroopInfoActivity(paramContext, getTroopProfileExtra(paramInt1, localGroupInfo, paramInt2, false), 2);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("TroopUtils", 1, "cast string2long error");
        return;
      }
      localGroupInfo.strIntro = paramRecommendTroopItem.recommendReason;
    }
  }
  
  public static void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        bool2 = paramBundle.getBoolean("troop_info_from_troopsetting", false);
        if (paramInt != -1) {
          continue;
        }
        TroopManager localTroopManager = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager == null) {
          continue;
        }
        if (localTroopManager.b(paramBundle.getString("troop_uin")) == null) {
          break label162;
        }
        bool1 = true;
        paramInt = 1;
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          break label161;
        }
        QLog.i("TroopUtils", 2, paramContext.toString());
        return;
        bool1 = false;
        continue;
      }
      localIntent.putExtra("vistor_type", paramInt);
      if (isHostMode(paramInt, bool1, bool2))
      {
        localIntent.setClass(paramContext, ChatSettingForTroop.class);
        paramContext.startActivity(localIntent);
        return;
      }
      PublicFragmentActivity.a(paramContext, localIntent, VisitorTroopCardFragment.class);
      return;
      label161:
      return;
      label162:
      boolean bool1 = false;
      paramInt = 2;
    }
  }
  
  public static void openTroopInfoActivityForResult(Context paramContext, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        bool2 = paramBundle.getBoolean("troop_info_from_troopsetting", false);
        if (paramInt1 != -1) {
          continue;
        }
        TroopManager localTroopManager = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager == null) {
          continue;
        }
        if (localTroopManager.b(paramBundle.getString("troop_uin")) == null) {
          break label173;
        }
        bool1 = true;
        paramInt1 = 1;
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.i("TroopUtils", 2, paramContext.toString());
        return;
        bool1 = false;
        continue;
      }
      localIntent.putExtra("vistor_type", paramInt1);
      if (isHostMode(paramInt1, bool1, bool2))
      {
        localIntent.setClass(paramContext, ChatSettingForTroop.class);
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
        return;
      }
      PublicFragmentActivity.a((Activity)paramContext, localIntent, VisitorTroopCardFragment.class, paramInt2);
      return;
      label172:
      return;
      label173:
      boolean bool1 = false;
      paramInt1 = 2;
    }
  }
  
  public static void openTroopInfoActivityFromAIO(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "openTroopInfoActivityFromAIO." + paramString);
    }
    if (paramContext == null) {}
    TroopInfoData localTroopInfoData;
    Object localObject;
    do
    {
      do
      {
        return;
        localTroopInfoData = new TroopInfoData();
        localTroopInfoData.troopUin = paramString;
        localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      } while (localObject == null);
      localObject = ((TroopManager)localObject).b(paramString);
    } while (localObject == null);
    if (((TroopInfo)localObject).isAdmin())
    {
      localTroopInfoData.updateForTroopChatSetting((TroopInfo)localObject, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
      localTroopInfoData.isMember = true;
      paramQQAppInterface = TroopInfoActivity.a(paramString, 115, localTroopInfoData.troopLat, localTroopInfoData.troopLon, localTroopInfoData.cityId, localTroopInfoData.troopLocation);
      paramQQAppInterface.putInt("troop_type_ex", localTroopInfoData.troopTypeExt);
      paramQQAppInterface.putInt("PARAM_EXIT_ANIMATION", 2);
      TroopInfoActivity.a(paramContext, paramQQAppInterface);
      return;
    }
    ThreadManager.getUIHandler().post(new TroopUtils.4(paramContext));
  }
  
  public static void openTroopRecommendMemberList(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramMessageRecord == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troopUin", paramString1);
    int i;
    int j;
    try
    {
      paramString2 = paramString2.split("_");
      Object localObject;
      if ((paramString2 != null) && (paramString2.length > 2))
      {
        i = Integer.parseInt(paramString2[0]);
        localIntent.putExtra("grayType", i);
        j = Integer.parseInt(paramString2[1]);
        localIntent.putExtra("grayTypeSubId", j);
        if ((paramMessageRecord instanceof MessageForUniteGrayTip))
        {
          localObject = (MessageForUniteGrayTip)paramMessageRecord;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.a != null))
          {
            paramMessageRecord = new ArrayList(5);
            localObject = ((MessageForUniteGrayTip)localObject).tipParam.a.iterator();
          }
        }
      }
      else
      {
        while (((Iterator)localObject).hasNext())
        {
          MessageForGrayTips.HighlightItem localHighlightItem = (MessageForGrayTips.HighlightItem)((Iterator)localObject).next();
          if (localHighlightItem.actionType == 52)
          {
            paramMessageRecord.add(Long.valueOf(Long.parseLong(localHighlightItem.mMsg_A_ActionData)));
            continue;
            TroopRecommendFriendFragment.a(paramContext, localIntent);
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopUtils", 2, "openTroopRecommendMemberList " + paramQQAppInterface);
      }
    }
    for (;;)
    {
      return;
      localIntent.putExtra("grayUinList", paramMessageRecord);
      long l = Long.parseLong(paramString2[2]);
      ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c(paramString1, 2, i);
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(j), "", "", "");
    }
  }
  
  public static void openTroopSetting(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramString1 == null) || (paramContext == null)) {}
    Intent localIntent;
    do
    {
      return;
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localIntent = new Intent();
      localIntent.putExtra("troop_uin", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("focusItem", paramString2);
      }
    } while ((paramQQAppInterface != null) && (paramQQAppInterface.h(paramString1)));
    openTroopInfoActivityForResult(paramContext, localIntent.getExtras(), 1, 2000);
  }
  
  public static void openUserProfileCardForTroopRecommend(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, FriendProfileCardActivity.class);
      localIntent.putExtra("troopUin", paramString2);
      localIntent.putExtra("memberUin", paramString1);
      azry.a(paramContext, paramQQAppInterface, localIntent, paramInt);
    }
  }
  
  /* Error */
  public static String parseReadInJoyparams(View paramView, oidb_0xe83.TabInfo paramTabInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 2127	tencent/im/oidb/cmd0xe83/oidb_0xe83$TabInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4: invokevirtual 1100	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7: invokestatic 2132	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   10: astore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: aload 4
    //   16: ifnull +151 -> 167
    //   19: aload 4
    //   21: ldc_w 2134
    //   24: invokevirtual 2137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload 4
    //   30: ldc_w 645
    //   33: invokevirtual 2137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_1
    //   39: ifnull +21 -> 60
    //   42: aload_1
    //   43: invokestatic 529	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: iload_3
    //   48: istore_2
    //   49: aload_0
    //   50: ldc_w 457
    //   53: iload_2
    //   54: invokestatic 2140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokevirtual 2143	android/view/View:setTag	(ILjava/lang/Object;)V
    //   60: aload 4
    //   62: ifnull +105 -> 167
    //   65: aload_0
    //   66: ldc_w 2144
    //   69: aload 4
    //   71: invokevirtual 2143	android/view/View:setTag	(ILjava/lang/Object;)V
    //   74: new 622	org/json/JSONObject
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 2145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   83: astore_0
    //   84: aload_0
    //   85: ldc_w 2147
    //   88: invokevirtual 2149	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   91: ifeq +76 -> 167
    //   94: aload_0
    //   95: ldc_w 2147
    //   98: invokevirtual 2152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_0
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: ldc 46
    //   107: iconst_1
    //   108: ldc_w 2154
    //   111: aload_1
    //   112: invokestatic 1083	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aconst_null
    //   116: astore 4
    //   118: goto -106 -> 12
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_1
    //   125: ldc 46
    //   127: iconst_1
    //   128: ldc_w 2156
    //   131: aload 4
    //   133: invokestatic 1083	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aconst_null
    //   137: astore 4
    //   139: goto -101 -> 38
    //   142: astore_1
    //   143: ldc 46
    //   145: iconst_1
    //   146: ldc_w 2158
    //   149: aload_1
    //   150: invokestatic 1083	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -104 -> 49
    //   156: astore_0
    //   157: ldc 46
    //   159: iconst_1
    //   160: ldc_w 2160
    //   163: aload_0
    //   164: invokestatic 1083	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: aconst_null
    //   168: areturn
    //   169: astore 4
    //   171: goto -46 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramView	View
    //   0	174	1	paramTabInfo	oidb_0xe83.TabInfo
    //   13	41	2	i	int
    //   46	2	3	j	int
    //   10	107	4	localObject1	Object
    //   121	11	4	localException1	Exception
    //   137	1	4	localObject2	Object
    //   169	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	12	104	java/lang/Exception
    //   19	28	121	java/lang/Exception
    //   42	47	142	java/lang/Exception
    //   74	102	156	java/lang/Exception
    //   28	38	169	java/lang/Exception
  }
  
  public static void preloadWebProcess(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while (!paramQQAppInterface.d());
      paramQQAppInterface.e();
    } while (!QLog.isColorLevel());
    QLog.d("TroopUtils", 2, "start preloadWebProcess");
  }
  
  public static void prepareTroopNotifyData(structmsg.StructMsg paramStructMsg, ProfileActivity.AllInOne paramAllInOne)
  {
    String str2 = null;
    if ((paramStructMsg == null) || (paramStructMsg.msg == null) || (paramAllInOne == null)) {
      return;
    }
    long l1 = paramStructMsg.msg.group_code.get();
    long l2 = paramStructMsg.msg.action_uin.get();
    int i = paramStructMsg.msg.group_msg_type.get();
    if (l1 != 0L) {}
    for (String str1 = String.valueOf(l1);; str1 = null)
    {
      if (l2 != 0L) {
        str2 = String.valueOf(l2);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("troop_uin", str1);
      localBundle.putInt("flc_notify_type", i);
      if ((i == 2) || (i == 22)) {
        localBundle.putString("flc_recommend_uin", str2);
      }
      paramAllInOne.b.putBundle("flc_extra_param", localBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("addFriendTag", 2, String.format("prepareTroopNotifyData [uin:%s, group_code:%s, msg_type:%s, sub_type:%s, req_uin:%s, action_uin:%s, actor_uin:%s]", new Object[] { paramAllInOne.a, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(paramStructMsg.msg.sub_type.get()), Long.valueOf(paramStructMsg.req_uin.get()), Long.valueOf(l2), Long.valueOf(paramStructMsg.msg.actor_uin.get()) }));
      return;
    }
  }
  
  public static int readPictureDegree(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static void removeRobotUin(List<String> paramList)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      bgls localbgls = (bgls)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      localObject = null;
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!localbgls.b(str)) {
          break label88;
        }
        localObject = str;
      }
    }
    label88:
    for (;;)
    {
      break;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.remove(localObject);
      }
      return;
    }
  }
  
  public static String replaceSpecialTag(String paramString, long paramLong, int paramInt, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfoData.bOwner)
    {
      str = "0";
      paramQQAppInterface = paramString.replace("$GCODE$", paramTroopInfoData.troopUin).replace("$CLIENTVER$", "android8.4.10").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (!paramBoolean) {
        break label169;
      }
    }
    label169:
    for (paramString = "1";; paramString = "2")
    {
      paramQQAppInterface = paramQQAppInterface.replace("$ENTERSOURCE$", paramString).replace("$GUIN$", paramTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
      paramString = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
        paramString = paramQQAppInterface.replace("$GNAME$", paramTroopInfoData.newTroopName);
      }
      return paramString;
      if (paramTroopInfoData.bAdmin)
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public static void reportQunMiniApp(oidb_0xe83.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    if (paramAppInfo == null) {
      return;
    }
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = String.valueOf(paramAppInfo.appid.get());
    localMiniAppInfo.name = paramAppInfo.name.get();
    paramAppInfo = new MiniAppConfig(localMiniAppInfo);
    paramAppInfo.launchParam.scene = 2010;
    paramAppInfo.config.via = "2010_3";
    paramAppInfo.launchParam.reportData = ("groupid=" + paramString2 + "&category_tag=");
    MiniProgramLpReportDC04239.reportAsync(paramAppInfo, "page_view", paramString1, null, null);
  }
  
  public static void reportTroopRecommendGrayTipsExpose(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface != null) && (paramMessageForUniteGrayTip != null))
    {
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("subIdAndGroupClass");
      if (paramMessageForUniteGrayTip == null) {}
    }
    try
    {
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.split("_");
      if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.length > 1))
      {
        int i = Integer.parseInt(paramMessageForUniteGrayTip[0]);
        bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800AD4E", "0X800AD4E", (int)Long.parseLong(paramMessageForUniteGrayTip[1]), 0, String.valueOf(i), "", "", "");
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopUtils", 2, "reportTroopRecommendGrayTipsExpose " + paramQQAppInterface);
    }
  }
  
  public static String saveMemberUinStringToDB(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      paramArrayList = TroopInfo.convertMemberUinListToString(paramArrayList, 5);
      if (!TextUtils.equals(paramTroopInfo.memberListToShow, paramArrayList))
      {
        updateTroopInfoToDB(paramTroopInfo, paramQQAppInterface, paramBoolean);
        return paramArrayList;
      }
    }
    return null;
  }
  
  /* Error */
  public static void saveRecommendGrayTipsCookie(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 46
    //   8: iconst_2
    //   9: new 126	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 2340
    //   19: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: ifnull +90 -> 123
    //   36: aload_1
    //   37: ifnull +86 -> 123
    //   40: aload_2
    //   41: ifnull +82 -> 123
    //   44: new 126	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: invokevirtual 918	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 1127	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   58: invokevirtual 1131	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 1136	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 1139	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 9
    //   75: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_0
    //   86: new 2342	java/io/FileOutputStream
    //   89: dup
    //   90: new 1133	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 1140	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: invokespecial 2343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore_1
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: aload_2
    //   106: invokevirtual 2346	java/io/FileOutputStream:write	([B)V
    //   109: aload_1
    //   110: astore_0
    //   111: aload_1
    //   112: invokevirtual 2349	java/io/FileOutputStream:flush	()V
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 2350	java/io/FileOutputStream:close	()V
    //   123: return
    //   124: astore_0
    //   125: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -5 -> 123
    //   131: ldc 46
    //   133: iconst_2
    //   134: new 126	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 2352
    //   144: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: return
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_0
    //   163: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +31 -> 197
    //   169: aload_1
    //   170: astore_0
    //   171: ldc 46
    //   173: iconst_2
    //   174: new 126	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 2354
    //   184: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_2
    //   188: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_1
    //   198: ifnull -75 -> 123
    //   201: aload_1
    //   202: invokevirtual 2350	java/io/FileOutputStream:close	()V
    //   205: return
    //   206: astore_0
    //   207: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -87 -> 123
    //   213: ldc 46
    //   215: iconst_2
    //   216: new 126	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 2352
    //   226: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: return
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 2350	java/io/FileOutputStream:close	()V
    //   251: aload_1
    //   252: athrow
    //   253: astore_0
    //   254: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -6 -> 251
    //   260: ldc 46
    //   262: iconst_2
    //   263: new 126	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 2352
    //   273: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto -35 -> 251
    //   289: astore_1
    //   290: goto -47 -> 243
    //   293: astore_2
    //   294: goto -133 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramQQAppInterface	QQAppInterface
    //   0	297	1	paramString	String
    //   0	297	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   119	123	124	java/lang/Exception
    //   86	102	158	java/lang/Exception
    //   201	205	206	java/lang/Exception
    //   86	102	240	finally
    //   247	251	253	java/lang/Exception
    //   104	109	289	finally
    //   111	115	289	finally
    //   163	169	289	finally
    //   171	197	289	finally
    //   104	109	293	java/lang/Exception
    //   111	115	293	java/lang/Exception
  }
  
  public static void secRecognize(boolean paramBoolean, View paramView)
  {
    if (QSecFramework.a().a(1001).booleanValue())
    {
      if (paramBoolean) {
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(2), paramView }, null);
      }
    }
    else {
      return;
    }
    QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
  }
  
  public static void setAIOTroopMiniAppEntranceRedPoint(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "AIO_TROOP_MINI_APP_ENTRANCE", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static void setEnabledCount(boolean paramBoolean)
  {
    sEnbaleTipsCountLimit = paramBoolean;
  }
  
  public static void setOldRecommendGrayTipsLastInsertTime(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setOldRecommendGrayTipsLastInsertTime " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("old_last_add_time", paramLong).commit();
    }
  }
  
  public static void setRecommendGrayTipsLastInsertTime(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setRecommendGrayTipsLastInsertTime " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("last_add_time", paramLong).commit();
    }
  }
  
  public static void setRedPointSP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!isEmptyRedPointSP(paramString));
      SharePreferenceUtils.set(BaseApplicationImpl.getApplication(), paramString, paramString);
    } while (!QLog.isColorLevel());
    QLog.i("TroopUtils", 2, String.format("setRedPointSP [%s, %s]", new Object[] { paramString, paramString }));
  }
  
  public static void setRedPointSP(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      setRedPointSP(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  public static void setTroopHasNewApp(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_troop_app_has_new", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static void setTroopInfoEditRedShow(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopInfoEditRedShow " + paramString + " " + paramInt + " " + paramBoolean);
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putBoolean("red_tag_" + paramInt, paramBoolean).commit();
    }
  }
  
  public static void setTroopManageEditRedShow(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopInfoEditRedShow " + paramString2 + " " + paramBoolean);
    }
    if ((paramContext != null) && (paramString1 != null) && (paramString2 != null)) {
      paramContext.getSharedPreferences("sp_troop_info_edit_red_show_" + paramString1 + "_" + paramString2, 0).edit().putBoolean("manage_red", paramBoolean).commit();
    }
  }
  
  public static void setTroopRecommendGrayTipsReportTimestamp(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopRecommendGrayTipsReportTimestamp " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("report_timestamp", paramLong).commit();
    }
  }
  
  public static void setmIsShowTroopAppShortcutBar(boolean paramBoolean)
  {
    mIsShowTroopAppShortcutBar = paramBoolean;
  }
  
  public static void shareGroup(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "shareGroup:" + paramString);
    }
    TroopInfoData localTroopInfoData = new TroopInfoData();
    localTroopInfoData.troopUin = paramString;
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null)
      {
        localTroopInfoData.updateForTroopChatSetting(paramString, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
        localTroopInfoData.isMember = true;
        if ((paramContext instanceof BaseActivity))
        {
          paramQQAppInterface = new bgua((BaseActivity)paramContext, localTroopInfoData);
          paramQQAppInterface.a(true);
          if (Looper.myLooper() == Looper.getMainLooper()) {
            break label142;
          }
          ThreadManager.getUIHandler().post(new TroopUtils.3(paramQQAppInterface, localTroopInfoData));
        }
      }
    }
    return;
    label142:
    paramQQAppInterface.a(localTroopInfoData);
  }
  
  public static bgua shareTroop(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramTroopInfoData == null) || (paramQQAppInterface == null)) {
      return null;
    }
    paramBaseActivity = new bgua(paramBaseActivity, paramTroopInfoData, new TroopUtils.1(paramTroopInfoData));
    paramBaseActivity.a(paramTroopInfoData);
    bdla.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_share", 0, 0, paramTroopInfoData.troopUin, "", "", "");
    if (paramTroopInfoData.isMember) {
      bhbu.a("Grp_set_new", "grpData_admin", "clk_share", 0, 0, new String[] { paramTroopInfoData.troopUin, bhbu.a(paramTroopInfoData) });
    }
    return paramBaseActivity;
  }
  
  public static void startChatBackgroundSettingActivity(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, bhnp.a(paramActivity, "background", ""), 33554432L, localIntent, true, paramInt);
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  public static void startTroopAppActivity(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2 = (bgig)paramQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR);
    if (paramString2 != null) {
      if (!((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString1).isHomeworkTroop()) {
        break label170;
      }
    }
    label170:
    for (int i = 32;; i = 0)
    {
      paramString2 = paramString2.a(1104864064, i);
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.url))) {}
      for (paramString2 = paramString2.url.replace("$GCODE$", paramString1);; paramString2 = null)
      {
        String str = paramString2;
        if (paramString2 == null) {
          str = TroopAppUrl + paramString1;
        }
        localIntent.putExtra("url", str);
        paramActivity.startActivityForResult(localIntent, 12001);
        bdla.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, paramString1, "", "", "");
        return;
      }
    }
  }
  
  public static void startTroopAppActivityActivity(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", TroopAppActivityUrl + str);
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    bdla.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
  }
  
  public static void startTroopFile(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if (bhdf.a(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bhdf.a(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString, 0);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopFileProxyActivity.a, paramString);
      localIntent.putExtra("param_from", 3000);
      TroopFileProxyActivity.a(paramActivity, localIntent, 14, paramQQAppInterface.getCurrentAccountUin());
      bdla.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp", "Clk_grpinfo_files", 0, 0, paramString, "0", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + paramString);
      }
      nvs.a(paramQQAppInterface, 67);
      return;
    }
  }
  
  public static JSONArray toJSONArray(Object paramObject)
  {
    JSONArray localJSONArray = new JSONArray();
    if (!paramObject.getClass().isArray()) {
      throw new JSONException("Not a primitive array: " + paramObject.getClass());
    }
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(wrap(Array.get(paramObject, i)));
      i += 1;
    }
    return localJSONArray;
  }
  
  public static void updateEntryItem(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean, String paramString1, String paramString2, azyj paramazyj)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363685);
    paramView = (TextView)paramView.findViewById(2131376668);
    paramView.getLayoutParams().height = ViewUtils.dpToPx(22.0F);
    paramView.setGravity(16);
    if (TextUtils.isEmpty(paramCharSequence1)) {
      if (TextUtils.isEmpty(paramCharSequence3)) {
        paramView.setVisibility(8);
      }
    }
    while (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence3);
      continue;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence1, TextView.BufferType.SPANNABLE);
      if (paramBoolean)
      {
        paramView = azyi.a(paramView, paramString2, paramString1);
        if (paramView != null) {
          paramView.a(paramazyj);
        }
      }
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  public static void updateRedPoint(boolean paramBoolean, TextView paramTextView)
  {
    if (paramBoolean)
    {
      paramTextView.setVisibility(0);
      paramTextView.setBackgroundResource(0);
      paramTextView.setCompoundDrawablePadding(AIOUtils.dp2px(10.0F, BaseApplicationImpl.getApplication().getResources()));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841419, 0);
      return;
    }
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public static void updateRedPoint(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, TextView paramTextView)
  {
    if ((isShowRedPoint(paramBoolean1, paramString)) || (paramBoolean2) || (paramBoolean3)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "isShowRedPoint:" + paramBoolean1);
      }
      updateRedPoint(paramBoolean1, paramTextView);
      return;
    }
  }
  
  public static void updateTroopInfoToDB(TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramTroopInfo != null) && (paramBoolean)) {
      ThreadManager.post(new TroopUtils.2(paramQQAppInterface, paramTroopInfo), 5, null, false);
    }
  }
  
  public static Object wrap(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = JSONObject.NULL;
    }
    for (;;)
    {
      return localObject;
      localObject = paramObject;
      if (!(paramObject instanceof JSONArray))
      {
        localObject = paramObject;
        if (!(paramObject instanceof JSONObject))
        {
          localObject = paramObject;
          if (!paramObject.equals(JSONObject.NULL)) {
            try
            {
              if ((paramObject instanceof Collection)) {
                return new JSONArray((Collection)paramObject);
              }
              if (paramObject.getClass().isArray()) {
                return toJSONArray(paramObject);
              }
              if ((paramObject instanceof Map)) {
                return new JSONObject((Map)paramObject);
              }
              localObject = paramObject;
              if (!(paramObject instanceof Boolean))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Byte))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Character))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Double))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Float))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Integer))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Long))
                          {
                            localObject = paramObject;
                            if (!(paramObject instanceof Short))
                            {
                              localObject = paramObject;
                              if (!(paramObject instanceof String)) {
                                if (paramObject.getClass().getPackage().getName().startsWith("java."))
                                {
                                  paramObject = paramObject.toString();
                                  return paramObject;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramObject) {}
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils
 * JD-Core Version:    0.7.0.1
 */