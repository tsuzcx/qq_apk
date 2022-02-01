package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
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
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.TroopRobotFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.NumberUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopFileProxyActivity;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.HighlightTitle;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopUtils
{
  public static int a;
  protected static String a;
  private static boolean a;
  protected static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://qun.qq.com/qqweb/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&sonic=1&gc=";
    b = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
    c = "https://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = 0;
  }
  
  private static char a(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 1) {
      return 1;
    }
    return 2;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 3;
    }
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramString = localTroopManager.b(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
        return 0;
      }
      if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentAccountUin())) {
        return 1;
      }
      if (localTroopManager.m(paramQQAppInterface.getCurrentAccountUin())) {
        return 2;
      }
    }
    return 3;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
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
        localStringBuilder.append(UinTypeUtil.a());
        localStringBuilder.append(" and isValid=1 ");
        paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramQQAppInterface, localStringBuilder.toString());
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
  
  public static int a(String paramString)
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
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
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
  
  public static long a(String paramString)
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
  
  public static Bitmap a(Drawable paramDrawable)
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
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, paramResources.getDrawable(2130850114));
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 10) {}
    for (paramResources = paramDrawable.getConstantState().newDrawable(paramResources);; paramResources = paramDrawable.getConstantState().newDrawable(paramResources).mutate())
    {
      paramResources.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramResources.setAlpha(paramInt >>> 24);
      return paramResources;
    }
  }
  
  public static Bundle a(int paramInt1, GroupInfo paramGroupInfo, int paramInt2, boolean paramBoolean)
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
  
  public static Pair<String, ArrayList<AtTroopMemberInfo>> a(Editable paramEditable)
  {
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    paramEditable = AtTroopMemberSpan.a(paramEditable, localArrayList);
    AtTroopMemberInfo localAtTroopMemberInfo2;
    if (!localArrayList.isEmpty())
    {
      AtTroopMemberInfo localAtTroopMemberInfo1 = (AtTroopMemberInfo)localArrayList.get(0);
      localAtTroopMemberInfo2 = (AtTroopMemberInfo)localArrayList.get(localArrayList.size() - 1);
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
  
  public static TroopInfo a(QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Context paramContext)
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
  
  public static EntryModel a(TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {
      return null;
    }
    EntryModel localEntryModel = new EntryModel(1, Long.parseLong(paramTroopInfo.troopuin), paramTroopInfo.troopname, paramTroopInfo.isAdmin());
    localEntryModel.reportData = ("groupid=" + paramString);
    localEntryModel.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
    return localEntryModel;
  }
  
  public static TroopInfoData a(Bundle paramBundle, BaseActivity paramBaseActivity)
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
          localTroopInfoData.mStrJoinQuestion = TroopSystemMsgUtil.a(paramBaseActivity, localTroopInfoData.troopUin);
          localTroopInfoData.nTroopGrade = paramBundle.getInt("TROOP_INFO_TROOP_GRADE");
          localTroopInfoData.mStrJoinAnswer = TroopSystemMsgUtil.b(paramBaseActivity, localTroopInfoData.troopUin);
          localTroopInfoData.dwGroupFlagExt = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
          localTroopInfoData.dwAuthGroupType = paramBundle.getLong("TROOP_INFO_AUTH_TYPE");
          localTroopInfoData.troopTags = TroopInfo.getTags(paramBundle.getString("TROOP_INFO_TAGS_EXT"));
          return localTroopInfoData;
        }
      }
      catch (NumberFormatException paramBundle)
      {
        a(paramBaseActivity, paramBaseActivity.getTitleBarHeight(), 2131694717, 1);
        paramBundle.printStackTrace();
      }
    }
    return localTroopInfoData;
  }
  
  public static TroopShareUtility a(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramTroopInfoData == null) || (paramQQAppInterface == null)) {
      return null;
    }
    paramBaseActivity = new TroopShareUtility(paramBaseActivity, paramTroopInfoData, new TroopUtils.1(paramTroopInfoData));
    paramBaseActivity.a(paramTroopInfoData);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_share", 0, 0, paramTroopInfoData.troopUin, "", "", "");
    if (paramTroopInfoData.isMember) {
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_share", 0, 0, new String[] { paramTroopInfoData.troopUin, TroopReportor.a(paramTroopInfoData) });
    }
    return paramBaseActivity;
  }
  
  public static Object a(Object paramObject)
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
                return a(paramObject);
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
  
  public static String a(long paramLong)
  {
    String str = "";
    if (paramLong > 0L) {
      str = new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(1000L * paramLong));
    }
    return str;
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = paramContext.getResources().getString(2131696111) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  public static String a(Bundle paramBundle1, Bundle paramBundle2)
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
        ((JSONObject)localObject).put(str, a(paramBundle1.get(str)));
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
          localJSONObject2.put((String)localObject, a(paramBundle2.get((String)localObject)));
        }
      }
      localJSONObject1.put("key", localJSONObject2);
      paramBundle1 = localJSONObject1.toString();
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<oidb_0x899.memberlist> paramList, boolean paramBoolean)
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
  
  public static String a(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      paramArrayList = TroopInfo.convertMemberUinListToString(paramArrayList, 5);
      if (!TextUtils.equals(paramTroopInfo.memberListToShow, paramArrayList))
      {
        a(paramTroopInfo, paramQQAppInterface, paramBoolean);
        return paramArrayList;
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(a(paramString));
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
          ((StringBuilder)localObject).append(a(k >>> 4));
          ((StringBuilder)localObject).append(a(k));
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
  
  public static String a(String paramString, long paramLong, int paramInt, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfoData.bOwner)
    {
      str = "0";
      paramQQAppInterface = paramString.replace("$GCODE$", paramTroopInfoData.troopUin).replace("$CLIENTVER$", "android8.5.5").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
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
  
  public static String a(structmsg.StructMsg paramStructMsg, String paramString)
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
  
  public static JSONArray a(Object paramObject)
  {
    JSONArray localJSONArray = new JSONArray();
    if (!paramObject.getClass().isArray()) {
      throw new JSONException("Not a primitive array: " + paramObject.getClass());
    }
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(a(Array.get(paramObject, i)));
      i += 1;
    }
    return localJSONArray;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2)
  {
    String str = Long.toString(paramLong1);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(str);
    if (localTroopInfo != null) {
      if (TextUtils.equals(paramString, localTroopInfo.oldTroopName)) {
        break label200;
      }
    }
    label200:
    for (int i = 1;; i = 0)
    {
      localTroopInfo.troopname = paramString;
      localTroopInfo.oldTroopName = paramString;
      localTroopInfo.hasSetNewTroopName = true;
      localTroopManager.b(localTroopInfo);
      ((TroopListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).notifyUI(TroopNotificationConstants.b, false, null);
      ((BizTroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).notifyUI(43, true, new Object[] { str, paramString, null });
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopUtils", 2, "TroopUtils handleModifyName :" + localTroopInfo.troopname);
        }
        ((TroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(str, String.valueOf(paramLong2), paramString);
      }
      return;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    QQToastNotifier localQQToastNotifier = new QQToastNotifier(paramActivity);
    int i = paramActivity.getResources().getDimensionPixelSize(2131299166);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    default: 
      localQQToastNotifier.a(2131693551, i, 0, 1);
      return;
    case 2: 
      localQQToastNotifier.a(HardCodeUtil.a(2131715672), i, 0, 1);
      return;
    case 3: 
      localQQToastNotifier.a(HardCodeUtil.a(2131715661), i, 0, 1);
      return;
    case 4: 
      localQQToastNotifier.a(HardCodeUtil.a(2131715667), i, 0, 1);
      return;
    case 5: 
      localQQToastNotifier.a(HardCodeUtil.a(2131715662), i, 0, 1);
      return;
    }
    localQQToastNotifier.a(2131720198, i, 0, 1);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, IndividuationUrlHelper.a(paramActivity, "background", ""), 33554432L, localIntent, true, paramInt);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("be_admin_in_the_troop", paramBoolean);
    PublicFragmentActivity.a(paramActivity, localIntent, TroopRobotFragment.class);
    if (QLog.isColorLevel()) {
      QLog.d("TroopUtils", 2, "jumpRobotPage");
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    new QQToastNotifier(paramContext).a(paramInt2, paramInt1, 0, paramInt3);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
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
          break label163;
        }
        bool1 = true;
        paramInt = 1;
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          break label162;
        }
        QLog.i("TroopUtils", 2, paramContext.toString());
        return;
        bool1 = false;
        continue;
      }
      localIntent.putExtra("vistor_type", paramInt);
      if (a(paramInt, bool1, bool2))
      {
        localIntent.setClass(paramContext, ChatSettingForTroop.class);
        paramContext.startActivity(localIntent);
        return;
      }
      PublicFragmentActivity.a(paramContext, localIntent, VisitorTroopCardFragment.class);
      return;
      label162:
      return;
      label163:
      boolean bool1 = false;
      paramInt = 2;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt1, int paramInt2)
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
          break label174;
        }
        bool1 = true;
        paramInt1 = 1;
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          break label173;
        }
        QLog.i("TroopUtils", 2, paramContext.toString());
        return;
        bool1 = false;
        continue;
      }
      localIntent.putExtra("vistor_type", paramInt1);
      if (a(paramInt1, bool1, bool2))
      {
        localIntent.setClass(paramContext, ChatSettingForTroop.class);
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
        return;
      }
      PublicFragmentActivity.a((Activity)paramContext, localIntent, VisitorTroopCardFragment.class, paramInt2);
      return;
      label173:
      return;
      label174:
      boolean bool1 = false;
      paramInt1 = 2;
    }
  }
  
  public static void a(Context paramContext, RecommendTroopItem paramRecommendTroopItem, int paramInt)
  {
    paramRecommendTroopItem = paramRecommendTroopItem.getJumpUrl(paramInt);
    Intent localIntent = new Intent(paramContext, JoinGroupTransitActivity.class);
    localIntent.putExtra("source_scheme", paramRecommendTroopItem);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, RecommendTroopItem paramRecommendTroopItem, int paramInt1, int paramInt2)
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
          ArrayList localArrayList = GroupViewAdapter.a(paramRecommendTroopItem);
          if (localArrayList != null) {
            localGroupInfo.labels = localArrayList;
          }
          localGroupInfo.strJoinSig = paramRecommendTroopItem.authSig;
          a(paramContext, a(paramInt1, localGroupInfo, paramInt2, false), 2);
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
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopInfoEditRedShow " + paramString2 + " " + paramBoolean);
    }
    if ((paramContext != null) && (paramString1 != null) && (paramString2 != null)) {
      paramContext.getSharedPreferences("sp_troop_info_edit_red_show_" + paramString1 + "_" + paramString2, 0).edit().putBoolean("manage_red", paramBoolean).commit();
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    paramContext = ContactUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, false);
    Intent localIntent = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramContext);
    localIntent.putExtra("isBack2Root", true);
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
    ((Context)localObject).startActivity(localIntent);
  }
  
  public static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean, String paramString1, String paramString2, LongClickCopyAction.ICopyListener paramICopyListener)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363778);
    paramView = (TextView)paramView.findViewById(2131377063);
    paramView.getLayoutParams().height = ViewUtils.b(22.0F);
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
        paramView = LongClickCopyAction.attachCopyAction(paramView, paramString2, paramString1);
        if (paramView != null) {
          paramView.setCopyListener(paramICopyListener);
        }
      }
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  public static void a(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
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
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_report", 0, 0, new String[] { paramTroopInfoData.troopUin, TroopReportor.a(paramTroopInfoData) });
      paramTroopInfoData = NewReportPlugin.a(str1, 1);
      NewReportPlugin.a(paramBaseActivity, str1, null, null, str1, paramQQAppInterface.getAccount(), i, null, paramTroopInfoData);
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
      TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_report", 0, 0, new String[] { str2, paramTroopInfoData });
      paramTroopInfoData = null;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while (!paramQQAppInterface.isNeedPreloadWebProcess());
      paramQQAppInterface.startWebProcess(-1, null);
    } while (!QLog.isColorLevel());
    QLog.d("TroopUtils", 2, "start preloadWebProcess");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if (DBUtils.a(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        DBUtils.a(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString, 0);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramString);
      localIntent.putExtra("param_from", 3000);
      TroopFileProxyActivity.a(paramActivity, localIntent, 14, paramQQAppInterface.getCurrentAccountUin());
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp", "Clk_grpinfo_files", 0, 0, paramString, "0", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + paramString);
      }
      BnrReport.a(paramQQAppInterface, 67);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2 = (TroopAppMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR);
    if (paramString2 != null) {
      if (!((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString1).isHomeworkTroop()) {
        break label174;
      }
    }
    label174:
    for (int i = 32;; i = 0)
    {
      paramString2 = paramString2.a(1104864064, i);
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.url))) {}
      for (paramString2 = paramString2.url.replace("$GCODE$", paramString1);; paramString2 = null)
      {
        String str = paramString2;
        if (paramString2 == null) {
          str = jdField_a_of_type_JavaLangString + paramString1;
        }
        localIntent.putExtra("url", str);
        paramActivity.startActivityForResult(localIntent, 12001);
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, paramString1, "", "", "");
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool;
    QZoneHelper.UserInfo localUserInfo;
    if (paramInt != 0)
    {
      bool = true;
      localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = paramQQAppInterface.getCurrentAccountUin();
      localUserInfo.nickname = paramQQAppInterface.getCurrentNickname();
      TroopHandler localTroopHandler = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (!TextUtils.isEmpty(paramString1)) {
        localTroopHandler.d(paramString1, true);
      }
      if (DBUtils.a(paramQQAppInterface.getCurrentAccountUin(), "troop_photo_message", paramString1) <= 0) {
        break label124;
      }
      QZoneHelper.forwardToQunPassiveFeed(paramActivity, localUserInfo, paramString1, 7);
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_album", 0, 0, paramString1, "", "", "");
      BnrReport.a(paramQQAppInterface, 66);
      return;
      bool = false;
      break;
      label124:
      QZoneHelper.forwardToQunFeed(paramActivity, localUserInfo, paramString1, paramString2, bool, 7);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, HttpWebCgiAsyncTask.Callback paramCallback)
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
        break label502;
      }
      a(paramQQAppInterface, paramContext, str3, paramCallback, 0, null);
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
      paramQQAppInterface = a((Bundle)localObject2, paramQQAppInterface);
      localBundle.putString("param", paramQQAppInterface);
      localBundle.putString("signature", a(paramQQAppInterface + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put("BUNDLE", localBundle);
      paramQQAppInterface.put("CONTEXT", paramContext);
      new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "GET", paramCallback, 1, null).a(paramQQAppInterface);
      return;
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(str1);
      break;
      label502:
      str2 = "";
      paramQQAppInterface = (QQAppInterface)localObject2;
      paramIntent = (Intent)localObject1;
      localObject1 = str2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", b + str);
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
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
          paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
          if (paramMessageRecord.tipParam != null)
          {
            localObject = paramMessageRecord.tipParam.a();
            if (localObject != null)
            {
              paramMessageRecord = new ArrayList(5);
              localObject = ((ArrayList)localObject).iterator();
            }
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
      ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c(paramString1, 2, i);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(j), "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new TroopMsgData();
    paramContext.jdField_a_of_type_Int = 1;
    paramContext.jdField_a_of_type_Boolean = true;
    try
    {
      paramContext.jdField_a_of_type_Long = Long.parseLong(paramString2);
      paramContext.b = NumberUtil.a(paramString3);
      paramQQAppInterface.getMessageFacade().a(paramContext);
      ReportController.b(null, "dc00898", "", "", "0X800ADF1", "0X800ADF1", 0, 1, "", "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
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
          paramQQAppInterface = new TroopShareUtility((BaseActivity)paramContext, localTroopInfoData);
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, FriendProfileCardActivity.class);
      localIntent.putExtra("troopUin", paramString2);
      localIntent.putExtra("memberUin", paramString1);
      TroopMemberCardUtils.a(paramContext, paramQQAppInterface, localIntent, paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
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
    new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "GET", paramCallback, paramInt, paramBundle).a(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
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
    a(paramContext, localIntent.getExtras(), 1, 2000);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      ThreadManager.getSubThreadHandler().post(new TroopUtils.5(paramQQAppInterface, paramString1, paramString2, paramString3, paramContext));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramContext == null) || (paramTextView == null) || (paramMessageRecord == null)) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!SchoolTroopKeywordManager.a(paramQQAppInterface, paramSessionInfo));
      l = System.currentTimeMillis();
      paramSessionInfo = ((SchoolTroopKeywordManager)paramQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER)).a(paramSessionInfo, paramMessageRecord);
      if ((paramSessionInfo != null) && (paramSessionInfo.b != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(paramQQAppInterface, paramContext, paramSessionInfo), paramSessionInfo.c, paramSessionInfo.d, 17);
        paramTextView.setTag(2131367117, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
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
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AD4E", "0X800AD4E", (int)Long.parseLong(paramMessageForUniteGrayTip[1]), 0, String.valueOf(i), "", "", "");
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopUtils", 2, "reportTroopRecommendGrayTipsExpose " + paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopInfoEditRedShow " + paramString + " " + paramInt + " " + paramBoolean);
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putBoolean("red_tag_" + paramInt, paramBoolean).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopRecommendGrayTipsReportTimestamp " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("report_timestamp", paramLong).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, List<oidb_0xe3b.HighlightTitle> paramList, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "addTroopRecommendGrayTips " + paramString2 + " " + paramInt1 + " " + paramList + " " + paramInt2 + " " + paramLong);
    }
    UniteGrayTipParam localUniteGrayTipParam;
    label172:
    int k;
    Bundle localBundle;
    if ((paramQQAppInterface != null) && (paramString1 != null) && (paramString2 != null))
    {
      localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramString1, paramString2, 1, -5020, 131088, MessageCache.a());
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
              break label495;
            }
            int j = paramString2.indexOf(paramList, i);
            if (j == -1) {
              break label495;
            }
            localBundle = new Bundle();
            if (k != 0) {
              break label365;
            }
            localBundle.putInt("key_action", 52);
            localBundle.putString("key_action_DATA", paramInt1 + "_" + paramInt2 + "_" + paramLong);
            localBundle.putString("key_a_action_DATA", String.valueOf(localHighlightTitle.uint64_uin.get()));
            label335:
            i = j + paramList.length();
            localUniteGrayTipParam.a(j, i, localBundle);
          }
        }
      }
    }
    label365:
    label495:
    for (;;)
    {
      break;
      paramList = null;
      break label172;
      if (k != 1) {
        break label335;
      }
      localBundle.putInt("key_action", 53);
      localBundle.putString("key_action_DATA", paramInt1 + "_" + paramInt2 + "_" + paramLong);
      break label335;
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, localUniteGrayTipParam);
      paramString2.saveExtInfoToExtStr("subIdAndGroupClass", paramInt2 + "_" + paramLong);
      paramQQAppInterface.getMessageFacade().a(paramString2, paramQQAppInterface.getCurrentAccountUin());
      b(paramQQAppInterface, paramString1, paramString2.time);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List<ChatMessage> paramList)
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
              if (!HardCodeUtil.a(2131715664).equalsIgnoreCase(((MessageForSplitLineTips)localObject2).msgContent)) {
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
        localObject2 = (MessageForSplitLineTips)MessageRecordFactory.a(-4012);
        ((MessageForSplitLineTips)localObject2).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), HardCodeUtil.a(2131715669), l, -4012, 1, l);
        ((MessageForSplitLineTips)localObject2).shmsgseq = localObject1.shmsgseq;
        ((MessageForSplitLineTips)localObject2).isread = true;
        ((MessageForSplitLineTips)localObject2).mNeedTimeStamp = false;
        ((MessageForSplitLineTips)localObject2).msgContent = HardCodeUtil.a(2131715670);
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_troop_app_has_new", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 155
    //   8: iconst_2
    //   9: new 83	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1900
    //   19: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: ifnull +91 -> 124
    //   36: aload_1
    //   37: ifnull +87 -> 124
    //   40: aload_2
    //   41: ifnull +83 -> 124
    //   44: new 83	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 179	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   58: invokevirtual 1904	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 1909	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 1912	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 1914
    //   76: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_0
    //   87: new 1916	java/io/FileOutputStream
    //   90: dup
    //   91: new 1906	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 1917	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 1920	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokevirtual 1923	java/io/FileOutputStream:write	([B)V
    //   110: aload_1
    //   111: astore_0
    //   112: aload_1
    //   113: invokevirtual 1926	java/io/FileOutputStream:flush	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 1927	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -5 -> 124
    //   132: ldc 155
    //   134: iconst_2
    //   135: new 83	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 1929
    //   145: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: return
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: astore_0
    //   164: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +31 -> 198
    //   170: aload_1
    //   171: astore_0
    //   172: ldc 155
    //   174: iconst_2
    //   175: new 83	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 1931
    //   185: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_2
    //   189: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_1
    //   199: ifnull -75 -> 124
    //   202: aload_1
    //   203: invokevirtual 1927	java/io/FileOutputStream:close	()V
    //   206: return
    //   207: astore_0
    //   208: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -87 -> 124
    //   214: ldc 155
    //   216: iconst_2
    //   217: new 83	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 1929
    //   227: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: return
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 1927	java/io/FileOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_0
    //   255: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -6 -> 252
    //   261: ldc 155
    //   263: iconst_2
    //   264: new 83	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 1929
    //   274: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: goto -35 -> 252
    //   290: astore_1
    //   291: goto -47 -> 244
    //   294: astore_2
    //   295: goto -133 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramQQAppInterface	QQAppInterface
    //   0	298	1	paramString	String
    //   0	298	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   120	124	125	java/lang/Exception
    //   87	103	159	java/lang/Exception
    //   202	206	207	java/lang/Exception
    //   87	103	241	finally
    //   248	252	254	java/lang/Exception
    //   105	110	290	finally
    //   112	116	290	finally
    //   164	170	290	finally
    //   172	198	290	finally
    //   105	110	294	java/lang/Exception
    //   112	116	294	java/lang/Exception
  }
  
  public static void a(TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramTroopInfo != null) && (paramBoolean)) {
      ThreadManager.post(new TroopUtils.2(paramQQAppInterface, paramTroopInfo), 5, null, false);
    }
  }
  
  public static void a(TroopInfoData paramTroopInfoData, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTroopInfoData.pa == 19)
    {
      ReportController.b(null, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 18)
    {
      ReportController.b(null, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 24)
    {
      ReportController.b(null, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 17)
    {
      ReportController.b(null, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
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
          break label464;
        }
        j = 3;
      }
      break;
    }
    for (;;)
    {
      i = paramTroopInfoData.getStatOption();
      ReportController.b(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", j, 0, paramTroopInfoData.troopUin, paramInt1 + "", "" + i, paramInt2 + "");
      ReportController.b(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", j, 0, paramTroopInfoData.troopUin, paramInt1 + "", paramInt3 + "", "");
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
      label464:
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
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!b(paramString));
      SharePreferenceUtils.a(BaseApplicationImpl.getApplication(), paramString, paramString);
    } while (!QLog.isColorLevel());
    QLog.i("TroopUtils", 2, String.format("setRedPointSP [%s, %s]", new Object[] { paramString, paramString }));
  }
  
  public static void a(List<String> paramList)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      localObject = null;
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!localTroopRobotManager.b(str)) {
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
  
  public static void a(oidb_0xe83.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    if (paramAppInfo == null) {
      return;
    }
    SimpleMiniAppConfig.SimpleMiniAppInfo localSimpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
    localSimpleMiniAppInfo.appId = String.valueOf(paramAppInfo.appid.get());
    localSimpleMiniAppInfo.name = paramAppInfo.name.get();
    paramAppInfo = new SimpleMiniAppConfig(localSimpleMiniAppInfo);
    paramAppInfo.launchParam.scene = 2010;
    paramAppInfo.config.via = "2010_3";
    paramAppInfo.launchParam.reportData = ("groupid=" + paramString2 + "&category_tag=");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramAppInfo, "page_view", paramString1, null, null);
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, ProfileActivity.AllInOne paramAllInOne)
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
      QLog.i("addFriendTag", 2, String.format("prepareTroopNotifyData [uin:%s, group_code:%s, msg_type:%s, sub_type:%s, req_uin:%s, action_uin:%s, actor_uin:%s]", new Object[] { paramAllInOne.jdField_a_of_type_JavaLangString, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(paramStructMsg.msg.sub_type.get()), Long.valueOf(paramStructMsg.req_uin.get()), Long.valueOf(l2), Long.valueOf(paramStructMsg.msg.actor_uin.get()) }));
      return;
    }
  }
  
  public static void a(boolean paramBoolean, View paramView)
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
  
  public static void a(boolean paramBoolean, TextView paramTextView)
  {
    if (paramBoolean)
    {
      paramTextView.setVisibility(0);
      paramTextView.setBackgroundResource(0);
      paramTextView.setCompoundDrawablePadding(AIOUtils.a(10.0F, BaseApplicationImpl.getApplication().getResources()));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841559, 0);
      return;
    }
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public static void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, TextView paramTextView)
  {
    if ((a(paramBoolean1, paramString)) || (paramBoolean2) || (paramBoolean3)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "isShowRedPoint:" + paramBoolean1);
      }
      a(paramBoolean1, paramTextView);
      return;
    }
  }
  
  public static boolean a()
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
  
  private static boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramInt == 1) || ((paramBoolean1) && (!paramBoolean2));
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong != 10009L) && (paramLong != 10010L) && (paramLong != 10011L) && (paramLong != 32L);
  }
  
  public static boolean a(Context paramContext, String paramString)
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
        if (!TextUtils.equals("5105", paramContext)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { "5105", paramContext }));
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
    long l1 = a(paramString);
    long l2 = a(paramContext);
    if (Math.abs(l2) < Math.abs(l1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion some: %s, pre: %s, ret: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramLong + "");
    return (paramQQAppInterface != null) && (((paramQQAppInterface.troopowneruin != null) && (paramString.equals(paramQQAppInterface.troopowneruin))) || ((paramQQAppInterface.Administrator != null) && (paramQQAppInterface.Administrator.contains(paramString))));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_troop_app_has_new", 0).getBoolean(paramString, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return TroopInfoUtil.a(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<TroopAppInfo> paramArrayList)
  {
    paramQQAppInterface = (TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    paramQQAppInterface = paramQQAppInterface.a(paramQQAppInterface.a(paramString));
    return (paramQQAppInterface != null) && (paramQQAppInterface.size() > 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
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
          break label151;
        }
      }
      label151:
      for (bool1 = paramQQAppInterface.getBoolean("red_tag_" + paramArrayOfInt[i], true); bool1; bool1 = false)
      {
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
    paramString = localTroopManager.d(paramString);
    if (paramString != null) {
      return paramString.hasSetTroopHead();
    }
    return (TroopListHandler.a()) && (localTroopManager.b());
  }
  
  public static boolean a(List<?> paramList)
  {
    return (paramList == null) || (paramList.size() < 1);
  }
  
  public static boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    if (paramBoolean) {}
    for (boolean bool1 = b(paramString);; bool1 = false)
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
  
  /* Error */
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString)
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
    //   12: ifnull +113 -> 125
    //   15: aload 5
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +106 -> 125
    //   22: new 83	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokevirtual 179	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   36: invokevirtual 1904	android/content/Context:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 1909	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 1912	java/io/File:separator	Ljava/lang/String;
    //   48: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 1914
    //   54: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore_0
    //   65: new 1906	java/io/File
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 1917	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 2230	java/io/File:exists	()Z
    //   78: ifeq +241 -> 319
    //   81: new 2232	java/io/FileInputStream
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 2233	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_0
    //   90: aload_0
    //   91: astore_2
    //   92: aload_0
    //   93: invokevirtual 2236	java/io/FileInputStream:available	()I
    //   96: newarray byte
    //   98: astore_1
    //   99: aload_0
    //   100: astore_2
    //   101: aload_0
    //   102: aload_1
    //   103: invokevirtual 2240	java/io/FileInputStream:read	([B)I
    //   106: pop
    //   107: aload_1
    //   108: astore_2
    //   109: aload_0
    //   110: astore_1
    //   111: aload_2
    //   112: astore_0
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: ifnull +9 -> 125
    //   119: aload_1
    //   120: invokevirtual 2241	java/io/FileInputStream:close	()V
    //   123: aload_0
    //   124: astore_2
    //   125: aload_2
    //   126: areturn
    //   127: astore_1
    //   128: aload_0
    //   129: astore_2
    //   130: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -8 -> 125
    //   136: ldc 155
    //   138: iconst_2
    //   139: new 83	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 2243
    //   149: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: areturn
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_0
    //   167: aload 4
    //   169: astore_1
    //   170: aload_0
    //   171: astore_2
    //   172: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +31 -> 206
    //   178: aload_0
    //   179: astore_2
    //   180: ldc 155
    //   182: iconst_2
    //   183: new 83	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 2243
    //   193: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_1
    //   207: astore_2
    //   208: aload_0
    //   209: ifnull -84 -> 125
    //   212: aload_0
    //   213: invokevirtual 2241	java/io/FileInputStream:close	()V
    //   216: aload_1
    //   217: areturn
    //   218: astore_0
    //   219: aload_1
    //   220: astore_2
    //   221: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq -99 -> 125
    //   227: ldc 155
    //   229: iconst_2
    //   230: new 83	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 2243
    //   240: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_1
    //   254: areturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_2
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 2241	java/io/FileInputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_1
    //   269: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -6 -> 266
    //   275: ldc 155
    //   277: iconst_2
    //   278: new 83	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 2243
    //   288: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_1
    //   292: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: goto -35 -> 266
    //   304: astore_0
    //   305: goto -47 -> 258
    //   308: astore_3
    //   309: aload 4
    //   311: astore_1
    //   312: goto -142 -> 170
    //   315: astore_3
    //   316: goto -146 -> 170
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_3
    //   322: astore_0
    //   323: goto -210 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramQQAppInterface	QQAppInterface
    //   0	326	1	paramString	String
    //   10	253	2	localObject1	Object
    //   7	1	3	localObject2	Object
    //   164	33	3	localException1	Exception
    //   308	1	3	localException2	Exception
    //   315	7	3	localException3	Exception
    //   4	306	4	localObject3	Object
    //   1	15	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   119	123	127	java/lang/Exception
    //   65	90	164	java/lang/Exception
    //   212	216	218	java/lang/Exception
    //   65	90	255	finally
    //   262	266	268	java/lang/Exception
    //   92	99	304	finally
    //   101	107	304	finally
    //   172	178	304	finally
    //   180	206	304	finally
    //   92	99	308	java/lang/Exception
    //   101	107	315	java/lang/Exception
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static int b(int paramInt)
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
  
  public static final int b(QQAppInterface paramQQAppInterface, String paramString)
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
  
  public static int b(String paramString)
  {
    int i = 0;
    if (StringUtil.a(paramString)) {
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
  
  public static long b(QQAppInterface paramQQAppInterface, String paramString)
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
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new TroopMsgData();
    paramContext.jdField_a_of_type_Int = 2;
    paramContext.jdField_a_of_type_Boolean = true;
    paramContext.jdField_a_of_type_Long = NumberUtil.a(paramString2);
    paramContext.b = NumberUtil.a(paramString3);
    paramQQAppInterface.getMessageFacade().a(paramContext);
    ReportController.b(null, "dc00898", "", "", "0X800B190", "0X800B190", 0, 1, "", "", "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
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
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setRecommendGrayTipsLastInsertTime " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("last_add_time", paramLong).commit();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "AIO_TROOP_MINI_APP_ENTRANCE", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
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
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
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
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopAdmin(paramString2);
  }
  
  public static boolean b(String paramString)
  {
    String str = SharePreferenceUtils.a(BaseApplicationImpl.getApplication(), paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, String.format("isEmptyRedPointSP [%s, %s]", new Object[] { paramString, str }));
    }
    return TextUtils.isEmpty(str);
  }
  
  public static boolean b(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (b(paramString));
  }
  
  public static long c(QQAppInterface paramQQAppInterface, String paramString)
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
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setOldRecommendGrayTipsLastInsertTime " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("old_last_add_time", paramLong).commit();
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils
 * JD-Core Version:    0.7.0.1
 */