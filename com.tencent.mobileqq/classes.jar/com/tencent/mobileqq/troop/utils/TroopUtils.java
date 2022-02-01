package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.TroopRobotFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcard.api.IVisitorTroopCardApi;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.NumberUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichMsg;

public class TroopUtils
{
  private static int jdField_a_of_type_Int = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  protected static String a = "https://qun.qq.com/qqweb/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&sonic=1&gc=";
  private static boolean jdField_a_of_type_Boolean = true;
  protected static String b = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
  
  public static int a(int paramInt)
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
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 3;
    int i = j;
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 3;
      }
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      paramString = localTroopManager.b(paramString);
      i = j;
      if (paramString != null)
      {
        if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          return 0;
        }
        if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentAccountUin())) {
          return 1;
        }
        i = j;
        if (localTroopManager.l(paramQQAppInterface.getCurrentAccountUin())) {
          i = 2;
        }
      }
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    boolean bool = StringUtil.a(paramString);
    int i = 0;
    if (bool) {
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
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    int j;
    if (i > 0)
    {
      j = k;
      if (k > 0) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberUtil", 2, "drawable width or height is 0, and use default drawable");
      }
      paramDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
      if ((i <= 0) || (j <= 0)) {
        break label125;
      }
    }
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    return localObject;
    label125:
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberUtil", 2, "the default drawable width or height is 0");
    }
    return null;
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
    ArrayList localArrayList = new ArrayList();
    String str = AtTroopMemberSpan.a(paramEditable, localArrayList);
    paramEditable = str;
    if (!localArrayList.isEmpty())
    {
      paramEditable = (AtTroopMemberInfo)localArrayList.get(0);
      AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)localArrayList.get(localArrayList.size() - 1);
      int j = -1;
      int i;
      if ((paramEditable != null) && (localAtTroopMemberInfo != null))
      {
        j = paramEditable.startPos;
        i = localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen;
      }
      else
      {
        i = -1;
      }
      paramEditable = str;
      if (j >= 0)
      {
        paramEditable = str;
        if (i >= 0)
        {
          paramEditable = str;
          if (j < i) {
            paramEditable = str.substring(j, i);
          }
        }
      }
    }
    return new Pair(paramEditable, localArrayList);
  }
  
  public static TroopShareUtility a(QBaseActivity paramQBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramQBaseActivity != null) && (!paramQBaseActivity.isFinishing()) && (paramTroopInfoData != null) && (paramQQAppInterface != null))
    {
      paramQBaseActivity = new TroopShareUtility(paramQBaseActivity, paramTroopInfoData, new TroopUtils.1(paramTroopInfoData));
      paramQBaseActivity.a(paramTroopInfoData);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_share", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      if (paramTroopInfoData.isMember) {
        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_share", 0, 0, new String[] { paramTroopInfoData.troopUin, TroopReportor.a(paramTroopInfoData) });
      }
      return paramQBaseActivity;
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    int i = paramCard.shGender;
    int j = paramCard.shGender;
    Object localObject = "";
    if (j == 0) {
      paramQQAppInterface = paramQQAppInterface.getApp().getString(2131693879);
    } else if (paramCard.shGender == 1) {
      paramQQAppInterface = paramQQAppInterface.getApp().getString(2131692259);
    } else {
      paramQQAppInterface = "";
    }
    j = paramCard.age;
    String str2 = paramCard.strProvince;
    String str1 = paramCard.strCity;
    j = paramCard.constellation;
    String str3 = NearbyProfileUtil.c(paramCard.constellation);
    boolean bool = TextUtils.isEmpty(str2);
    if (TextUtils.isEmpty(str1)) {
      paramCard = (Card)localObject;
    } else {
      paramCard = str1;
    }
    if ((bool) && (j == 0) && (i == -1))
    {
      paramQQAppInterface = HardCodeUtil.a(2131715211);
    }
    else if ((bool) && (j == 0))
    {
      paramQQAppInterface = HardCodeUtil.a(2131715220);
    }
    else if ((bool) && (i == -1))
    {
      paramQQAppInterface = HardCodeUtil.a(2131715223);
    }
    else if ((j == 0) && (i == -1))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(HardCodeUtil.a(2131715224));
      paramQQAppInterface.append(str2);
      paramQQAppInterface.append(paramCard);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else if (j == 0)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(HardCodeUtil.a(2131715217));
      paramQQAppInterface.append(str2);
      paramQQAppInterface.append(paramCard);
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else if (i == -1)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(HardCodeUtil.a(2131715216));
      paramQQAppInterface.append(str2);
      paramQQAppInterface.append(paramCard);
      paramQQAppInterface.append(HardCodeUtil.a(2131715214));
      paramQQAppInterface.append(str3);
      paramQQAppInterface.append(HardCodeUtil.a(2131715215));
      paramQQAppInterface = paramQQAppInterface.toString();
    }
    else if (bool)
    {
      paramCard = new StringBuilder();
      paramCard.append(str3);
      paramCard.append(paramQQAppInterface);
      paramCard.append(HardCodeUtil.a(2131715222));
      paramQQAppInterface = paramCard.toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715209));
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(paramCard);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715221));
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715212));
      paramQQAppInterface = ((StringBuilder)localObject).toString();
    }
    paramCard = new StringBuilder();
    paramCard.append(paramQQAppInterface);
    paramCard.append("~");
    return paramCard.toString();
  }
  
  public static im_msg_body.RichMsg a(String paramString, int paramInt)
  {
    TroopUtils.5 local5 = new TroopUtils.5();
    local5.mMsgServiceID = 104;
    local5.mMsgBrief = paramString;
    local5.mMsgTemplateID = 1;
    local5.pobingTemplateId = paramInt;
    paramString = HardCodeUtil.a(2131715210);
    Object localObject = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject).a(new TroopUtils.6(""));
    ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(paramString));
    local5.addItem((AbsStructMsgElement)localObject);
    paramString = local5.getXmlBytes();
    if (paramString == null) {
      return null;
    }
    localObject = new im_msg_body.RichMsg();
    ((im_msg_body.RichMsg)localObject).bytes_template_1.set(ByteStringMicro.copyFrom(paramString));
    ((im_msg_body.RichMsg)localObject).uint32_service_id.set(local5.mMsgServiceID);
    return localObject;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2)
  {
    String str = Long.toString(paramLong1);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(str);
    if (localTroopInfo != null)
    {
      boolean bool = TextUtils.equals(paramString, localTroopInfo.oldTroopName);
      localTroopInfo.troopname = paramString;
      localTroopInfo.oldTroopName = paramString;
      localTroopInfo.hasSetNewTroopName = true;
      ((TroopManager)localObject).b(localTroopInfo);
      ((ITroopListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(TroopObserver.TYPE_GET_TROOP_LIST, false, null);
      ((ITroopModifyHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MODIFY_HANDLER)).a(TroopModifyObserver.d, true, new Object[] { str, paramString, null });
      if ((bool ^ true))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("TroopMemberUtil handleModifyName :");
          ((StringBuilder)localObject).append(localTroopInfo.troopname);
          QLog.d("TroopMemberUtil", 2, ((StringBuilder)localObject).toString());
        }
        ((ITroopOnlinePushHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER)).b(str, String.valueOf(paramLong2), paramString);
      }
    }
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
    VasWebviewUtil.b(paramActivity, VasWebviewUtil.a(IndividuationUrlHelper.a(paramActivity, "background", ""), 46), 33554432L, localIntent, true, paramInt);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("be_admin_in_the_troop", paramBoolean);
    PublicFragmentActivity.a(paramActivity, localIntent, TroopRobotFragment.class);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberUtil", 2, "jumpRobotPage");
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        bool2 = false;
        boolean bool3 = paramBundle.getBoolean("troop_info_from_troopsetting", false);
        bool1 = bool2;
        i = paramInt;
        if (paramInt == -1)
        {
          TroopManager localTroopManager = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
          bool1 = bool2;
          i = paramInt;
          if (localTroopManager != null)
          {
            if (localTroopManager.b(paramBundle.getString("troop_uin")) == null) {
              break label198;
            }
            i = 1;
            bool1 = true;
          }
        }
        localIntent.putExtra("vistor_type", i);
        if (a(i, bool1, bool3))
        {
          localIntent.setClass(paramContext, ((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getTroopSettingActivityClass());
          paramContext.startActivity(localIntent);
          return;
        }
        QPublicFragmentActivity.start(paramContext, localIntent, ((IVisitorTroopCardApi)QRoute.api(IVisitorTroopCardApi.class)).getVisitorTroopCardFragmentClass());
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberUtil", 2, paramContext.toString());
        }
      }
      return;
      label198:
      int i = 2;
      boolean bool1 = bool2;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramContext != null) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        bool2 = false;
        boolean bool3 = paramBundle.getBoolean("troop_info_from_troopsetting", false);
        bool1 = bool2;
        i = paramInt1;
        if (paramInt1 == -1)
        {
          TroopManager localTroopManager = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
          bool1 = bool2;
          i = paramInt1;
          if (localTroopManager != null)
          {
            if (localTroopManager.b(paramBundle.getString("troop_uin")) == null) {
              break label211;
            }
            i = 1;
            bool1 = true;
          }
        }
        localIntent.putExtra("vistor_type", i);
        if (a(i, bool1, bool3))
        {
          localIntent.setClass(paramContext, ((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getTroopSettingActivityClass());
          ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
          return;
        }
        QPublicFragmentActivity.startForResult((Activity)paramContext, localIntent, ((IVisitorTroopCardApi)QRoute.api(IVisitorTroopCardApi.class)).getVisitorTroopCardFragmentClass(), paramInt2);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberUtil", 2, paramContext.toString());
        }
      }
      return;
      label211:
      int i = 2;
      boolean bool1 = bool2;
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
    try
    {
      localGroupInfo.lCode = Long.valueOf(paramRecommendTroopItem.uin).longValue();
      localGroupInfo.strName = paramRecommendTroopItem.name;
      if (TextUtils.isEmpty(paramRecommendTroopItem.recommendReason)) {
        localGroupInfo.strIntro = paramRecommendTroopItem.intro;
      } else {
        localGroupInfo.strIntro = paramRecommendTroopItem.recommendReason;
      }
      localGroupInfo.iMemberCnt = paramRecommendTroopItem.memberNum;
      ArrayList localArrayList = GroupViewAdapter.a(paramRecommendTroopItem);
      if (localArrayList != null) {
        localGroupInfo.labels = localArrayList;
      }
      localGroupInfo.strJoinSig = paramRecommendTroopItem.authSig;
      a(paramContext, a(paramInt1, localGroupInfo, paramInt2, false), 2);
      return;
    }
    catch (Exception paramContext)
    {
      label114:
      break label114;
    }
    QLog.d("TroopMemberUtil", 1, "cast string2long error");
  }
  
  public static void a(Context paramContext, Object paramObject, int paramInt)
  {
    a(paramContext, (RecommendTroopItem)paramObject, paramInt);
  }
  
  public static void a(Context paramContext, Object paramObject, int paramInt1, int paramInt2)
  {
    a(paramContext, (RecommendTroopItem)paramObject, paramInt1, paramInt2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTroopInfoEditRedShow ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBoolean);
      QLog.i("TroopMemberUtil", 2, localStringBuilder.toString());
    }
    if ((paramContext != null) && (paramString1 != null) && (paramString2 != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_troop_info_edit_red_show_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("manage_red", paramBoolean).commit();
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
    TextView localTextView = (TextView)paramView.findViewById(2131363707);
    paramView = (TextView)paramView.findViewById(2131376541);
    paramView.getLayoutParams().height = ViewUtils.b(22.0F);
    paramView.setGravity(16);
    if (TextUtils.isEmpty(paramCharSequence1))
    {
      if (TextUtils.isEmpty(paramCharSequence3))
      {
        paramView.setVisibility(8);
      }
      else
      {
        paramView.setVisibility(0);
        paramView.setText(paramCharSequence3);
      }
    }
    else
    {
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
    if (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramQBaseActivity != null) && (!paramQBaseActivity.isFinishing()) && (paramTroopInfoData != null))
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int i;
      if (paramQBaseActivity.getIntent().getIntExtra("t_s_f", -1) == 1002) {
        i = 20014;
      } else if (paramTroopInfoData.isMember) {
        i = 22000;
      } else {
        i = 22003;
      }
      String str1 = paramTroopInfoData.troopUin;
      if (paramTroopInfoData.isMember)
      {
        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_report", 0, 0, new String[] { paramTroopInfoData.troopUin, TroopReportor.a(paramTroopInfoData) });
        paramTroopInfoData = NewReportPlugin.a(str1, 1);
      }
      else
      {
        String str2 = paramTroopInfoData.troopUin;
        if (paramTroopInfoData.isMember) {
          paramTroopInfoData = "1";
        } else {
          paramTroopInfoData = "0";
        }
        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_report", 0, 0, new String[] { str2, paramTroopInfoData });
        paramTroopInfoData = null;
      }
      NewReportPlugin.a(paramQBaseActivity, str1, null, null, str1, paramQQAppInterface.getAccount(), i, null, paramTroopInfoData);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    int i;
    if (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString, 0);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramString);
    localIntent.putExtra("param_from", 3000);
    TroopFileProxyActivity.a(paramActivity, localIntent, 14, paramQQAppInterface.getCurrentAccountUin());
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp", "Clk_grpinfo_files", 0, 0, paramString, "0", "", "");
    if (QLog.isDevelopLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("troopUin :");
      paramActivity.append(paramString);
      QLog.d("Clk_grpinfo_files", 4, paramActivity.toString());
    }
    BnrReport.a(paramQQAppInterface, 67);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2 = (ITroopAppService)paramQQAppInterface.getRuntimeService(ITroopAppService.class, "all");
    if (paramString2 != null)
    {
      localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString1);
      int i = 0;
      if (((TroopInfo)localObject).isHomeworkTroop()) {
        i = 32;
      }
      paramString2 = paramString2.getAppInfo(1104864064, i);
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.url)))
      {
        paramString2 = paramString2.url.replace("$GCODE$", paramString1);
        break label105;
      }
    }
    paramString2 = null;
    label105:
    Object localObject = paramString2;
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(jdField_a_of_type_JavaLangString);
      paramString2.append(paramString1);
      localObject = paramString2.toString();
    }
    localIntent.putExtra("url", (String)localObject);
    paramActivity.startActivityForResult(localIntent, 12001);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, paramString1, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramQQAppInterface.getCurrentAccountUin();
    localUserInfo.nickname = paramQQAppInterface.getCurrentNickname();
    ITroopPhotoHandler localITroopPhotoHandler = (ITroopPhotoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
    if (!TextUtils.isEmpty(paramString1)) {
      localITroopPhotoHandler.a(paramString1, true);
    }
    if (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(paramQQAppInterface.getCurrentAccountUin(), "troop_photo_message", paramString1) > 0) {
      QZoneHelper.forwardToQunPassiveFeed(paramActivity, localUserInfo, paramString1, 7);
    } else {
      QZoneHelper.forwardToQunFeed(paramActivity, localUserInfo, paramString1, paramString2, bool, 7);
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_album", 0, 0, paramString1, "", "", "");
    BnrReport.a(paramQQAppInterface, 66);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(str);
    localIntent.putExtra("url", localStringBuilder.toString());
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      if (paramMessageRecord == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("troopUin", paramString1);
      try
      {
        paramString2 = paramString2.split("_");
        if ((paramString2 != null) && (paramString2.length > 2))
        {
          int i = Integer.parseInt(paramString2[0]);
          localIntent.putExtra("grayType", i);
          int j = Integer.parseInt(paramString2[1]);
          localIntent.putExtra("grayTypeSubId", j);
          if ((paramMessageRecord instanceof MessageForUniteGrayTip))
          {
            paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
            if (paramMessageRecord.tipParam != null)
            {
              Object localObject = paramMessageRecord.tipParam.a();
              if (localObject != null)
              {
                paramMessageRecord = new ArrayList(5);
                localObject = ((ArrayList)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  GrayTipsMessageConstants.HighlightItem localHighlightItem = (GrayTipsMessageConstants.HighlightItem)((Iterator)localObject).next();
                  if (localHighlightItem.actionType == 52) {
                    paramMessageRecord.add(Long.valueOf(Long.parseLong(localHighlightItem.mMsgAActionData)));
                  }
                }
                localIntent.putExtra("grayUinList", paramMessageRecord);
              }
            }
          }
          long l = Long.parseLong(paramString2[2]);
          ((ITroopRecommendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER)).a(paramString1, 2, i);
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(j), "", "", "");
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("openTroopRecommendMemberList ");
          paramMessageRecord.append(paramQQAppInterface);
          QLog.i("TroopMemberUtil", 2, paramMessageRecord.toString());
        }
      }
      TroopRecommendFriendFragment.a(paramContext, localIntent);
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
    }
    catch (NumberFormatException paramMessageRecord)
    {
      QLog.e("TroopMemberUtil", 1, paramMessageRecord, new Object[0]);
      paramContext.jdField_a_of_type_Long = 0L;
    }
    paramContext.b = NumberUtil.a(paramString3);
    paramQQAppInterface.getMessageFacade().a(paramContext);
    ReportController.b(null, "dc00898", "", "", "0X800ADF1", "0X800ADF1", 0, 1, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareGroup:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TroopMemberUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new TroopInfoData();
    ((TroopInfoData)localObject).troopUin = paramString;
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null)
      {
        ((TroopInfoData)localObject).updateForTroopChatSetting(paramString, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
        ((TroopInfoData)localObject).isMember = true;
        if ((paramContext instanceof BaseActivity))
        {
          paramQQAppInterface = new TroopShareUtility((BaseActivity)paramContext, (TroopInfoData)localObject);
          paramQQAppInterface.a(true);
          if (Looper.myLooper() != Looper.getMainLooper())
          {
            ThreadManager.getUIHandler().post(new TroopUtils.2(paramQQAppInterface, (TroopInfoData)localObject));
            return;
          }
          paramQQAppInterface.a((TroopInfoData)localObject);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if (paramContext != null)
    {
      Intent localIntent = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(paramContext, null);
      localIntent.putExtra("troopUin", paramString2);
      localIntent.putExtra("memberUin", paramString1);
      TroopMemberCardUtils.a(paramContext, paramQQAppInterface, localIntent, paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface != null) && (paramString1 != null))
    {
      if (paramContext == null) {
        return;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("focusItem", paramString2);
      }
      if ((paramQQAppInterface != null) && (paramQQAppInterface.g(paramString1))) {
        return;
      }
      a(paramContext, localIntent.getExtras(), 1, 2000);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      ThreadManager.getSubThreadHandler().post(new TroopUtils.4(paramQQAppInterface, paramString1, paramString2, paramString3, paramContext));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramContext != null) && (paramTextView != null))
    {
      if (paramMessageRecord == null) {
        return;
      }
      if (!SchoolTroopKeywordManager.a(paramQQAppInterface, paramSessionInfo)) {
        return;
      }
      long l = System.currentTimeMillis();
      paramSessionInfo = ((SchoolTroopKeywordManager)paramQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER)).a(paramSessionInfo, paramMessageRecord);
      if ((paramSessionInfo != null) && (paramSessionInfo.b != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(paramQQAppInterface, paramContext, paramSessionInfo), paramSessionInfo.c, paramSessionInfo.d, 17);
        paramTextView.setTag(2131366954, "school_troop_span");
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(" updateSchoolTroopHighlight time cost: ");
        paramQQAppInterface.append(System.currentTimeMillis() - l);
        QLog.i("school_troop.BaseBubbleBuilder", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface != null) && (paramMessageForUniteGrayTip != null))
    {
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("subIdAndGroupClass");
      if (paramMessageForUniteGrayTip != null) {
        try
        {
          paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.split("_");
          if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.length > 1))
          {
            int i = Integer.parseInt(paramMessageForUniteGrayTip[0]);
            ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AD4E", "0X800AD4E", (int)Long.parseLong(paramMessageForUniteGrayTip[1]), 0, String.valueOf(i), "", "", "");
            return;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel())
          {
            paramMessageForUniteGrayTip = new StringBuilder();
            paramMessageForUniteGrayTip.append("reportTroopRecommendGrayTipsExpose ");
            paramMessageForUniteGrayTip.append(paramQQAppInterface);
            QLog.i("TroopMemberUtil", 2, paramMessageForUniteGrayTip.toString());
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List<ChatMessage> paramList)
  {
    long l = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    Object localObject1;
    int i;
    Object localObject2;
    if (l > 0L)
    {
      localObject1 = null;
      i = 0;
      while (i < paramList.size())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        localObject2 = localObject1;
        if (!(localChatMessage instanceof MessageForGrayTips)) {
          if ((localChatMessage instanceof MessageForUniteGrayTip))
          {
            localObject2 = localObject1;
            if (localChatMessage.time != l) {}
          }
          else if ((localChatMessage instanceof MessageForNewGrayTips))
          {
            localObject2 = localObject1;
          }
          else
          {
            if ((localChatMessage instanceof MessageForSplitLineTips))
            {
              localObject2 = (MessageForSplitLineTips)localChatMessage;
              ((MessageForSplitLineTips)localObject2).parse();
              if (HardCodeUtil.a(2131715588).equalsIgnoreCase(((MessageForSplitLineTips)localObject2).msgContent)) {
                return;
              }
            }
            if (localChatMessage.time >= l) {
              break;
            }
            localObject2 = localChatMessage;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
      i = 0;
    }
    if ((i > 0) && (localObject1 != null))
    {
      localObject2 = (MessageForSplitLineTips)MessageRecordFactory.a(-4012);
      ((MessageForSplitLineTips)localObject2).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), HardCodeUtil.a(2131715593), l, -4012, 1, l);
      ((MessageForSplitLineTips)localObject2).shmsgseq = localObject1.shmsgseq;
      ((MessageForSplitLineTips)localObject2).isread = true;
      ((MessageForSplitLineTips)localObject2).mNeedTimeStamp = false;
      ((MessageForSplitLineTips)localObject2).msgContent = HardCodeUtil.a(2131715594);
      ((MessageForSplitLineTips)localObject2).subType = 1;
      paramList.add(i, localObject2);
    }
  }
  
  public static void a(List<String> paramList)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ITroopRobotService localITroopRobotService = (ITroopRobotService)((QQAppInterface)localObject).getRuntimeService(ITroopRobotService.class, "all");
      localObject = null;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localITroopRobotService.isRobotUin(str)) {
          localObject = str;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.remove(localObject);
      }
    }
  }
  
  public static void a(boolean paramBoolean, View paramView)
  {
    if (QSecFramework.a().a(1001).booleanValue())
    {
      if (paramBoolean)
      {
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(2), paramView }, null);
        return;
      }
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
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
    boolean bool = true;
    if (paramInt != 1)
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        return true;
      }
      bool = false;
    }
    return bool;
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
        if (paramString2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sp_troop_info_edit_red_show_");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("_");
          localStringBuilder.append(paramString2);
          bool1 = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("manage_red", true);
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramLong != 0L)
      {
        if (paramString == null) {
          return false;
        }
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong);
        localStringBuilder.append("");
        paramQQAppInterface = paramQQAppInterface.b(localStringBuilder.toString());
        bool1 = bool2;
        if (paramQQAppInterface != null) {
          if ((paramQQAppInterface.troopowneruin == null) || (!paramString.equals(paramQQAppInterface.troopowneruin)))
          {
            bool1 = bool2;
            if (paramQQAppInterface.Administrator != null)
            {
              bool1 = bool2;
              if (!paramQQAppInterface.Administrator.contains(paramString)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    boolean bool1 = "newJoin".equals(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (paramQQAppInterface.jdField_a_of_type_Int != 1) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          bool1 = true;
          break label137;
          if ("activeUser".equals(paramString))
          {
            bool1 = bool2;
            if (paramQQAppInterface.h != 1) {
              break label137;
            }
          }
          else if ("highFreqInteract".equals(paramString))
          {
            bool1 = bool2;
            if (paramQQAppInterface.l != 1) {
              break label137;
            }
          }
          else
          {
            if (!"newMember".equals(paramString)) {
              break;
            }
            bool1 = bool2;
            if (paramQQAppInterface.o != 1) {
              break label137;
            }
          }
        }
        bool1 = bool2;
        if (!"atMeOrReplyMe".equals(paramString)) {
          break;
        }
        bool1 = bool2;
      } while (paramQQAppInterface.q == 1);
    }
    label137:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSwitch scene = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",result = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",config.switchOn = ");
      localStringBuilder.append(paramQQAppInterface.jdField_a_of_type_Int);
      localStringBuilder.append(",config.au_switchOn = ");
      localStringBuilder.append(paramQQAppInterface.h);
      localStringBuilder.append(",config.hfi_switchOn = ");
      localStringBuilder.append(paramQQAppInterface.l);
      localStringBuilder.append(",config.nm_switchOn = ");
      localStringBuilder.append(paramQQAppInterface.o);
      localStringBuilder.append(",config.aor_switchOn = ");
      localStringBuilder.append(paramQQAppInterface.q);
      QLog.d("TroopMemberUtil", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return TroopInfoUtil.a(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static boolean a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramString = localTroopManager.d(paramString);
    if (paramString != null) {
      return paramString.hasSetTroopHead();
    }
    return (((ITroopListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a()) && (localTroopManager.b());
  }
  
  public static boolean a(List<?> paramList)
  {
    boolean bool = true;
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 1447	tencent/im/msg/im_msg_body$RichText
    //   12: dup
    //   13: invokespecial 1448	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   16: astore 8
    //   18: aload_1
    //   19: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +87 -> 109
    //   25: new 1450	tencent/im/msg/im_msg_body$Elem
    //   28: dup
    //   29: invokespecial 1451	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   32: astore 9
    //   34: new 1453	tencent/im/msg/im_msg_body$Text
    //   37: dup
    //   38: invokespecial 1454	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   41: astore 10
    //   43: aload 10
    //   45: getfield 1457	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   48: aload_1
    //   49: invokestatic 1461	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   52: invokevirtual 467	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   55: aload 9
    //   57: getfield 1465	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   60: aload 10
    //   62: invokevirtual 1468	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   65: aload 8
    //   67: getfield 1472	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   70: aload 9
    //   72: invokevirtual 1476	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   75: new 1450	tencent/im/msg/im_msg_body$Elem
    //   78: dup
    //   79: invokespecial 1451	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   82: astore 9
    //   84: aload 9
    //   86: getfield 1480	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   89: aload_1
    //   90: sipush 2000
    //   93: invokestatic 1482	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   96: invokevirtual 1483	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   99: aload 8
    //   101: getfield 1472	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   104: aload 9
    //   106: invokevirtual 1476	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   109: new 1485	tencent/im/msg/im_msg_body$MsgBody
    //   112: dup
    //   113: invokespecial 1486	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   116: astore_1
    //   117: aload_1
    //   118: getfield 1490	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   121: aload 8
    //   123: invokevirtual 1491	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   126: new 1493	tencent/im/msg/im_msg$Msg
    //   129: dup
    //   130: invokespecial 1494	tencent/im/msg/im_msg$Msg:<init>	()V
    //   133: astore 9
    //   135: aload 9
    //   137: getfield 1498	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   140: aload_1
    //   141: invokevirtual 1499	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   144: new 1501	tencent/im/msg/im_msg$Group
    //   147: dup
    //   148: invokespecial 1502	tencent/im/msg/im_msg$Group:<init>	()V
    //   151: astore 8
    //   153: new 1504	tencent/im/msg/im_common$User
    //   156: dup
    //   157: invokespecial 1505	tencent/im/msg/im_common$User:<init>	()V
    //   160: astore 10
    //   162: aload 10
    //   164: getfield 1508	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   167: lload_2
    //   168: invokevirtual 1513	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   171: aload 10
    //   173: getfield 1516	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   176: sipush 1001
    //   179: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   182: aload 10
    //   184: getfield 1519	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   187: iconst_1
    //   188: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   191: aload 10
    //   193: getfield 1523	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   196: invokestatic 1527	com/dataline/util/DatalineMathUtil:a	()J
    //   199: l2i
    //   200: invokevirtual 1530	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   203: aload 10
    //   205: getfield 1533	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   208: bipush 109
    //   210: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   213: aload 10
    //   215: getfield 1536	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   218: invokestatic 1540	com/tencent/common/config/AppSetting:a	()I
    //   221: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   224: aload 8
    //   226: getfield 1544	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   229: aload 10
    //   231: invokevirtual 1545	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   234: aload 8
    //   236: getfield 1544	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   239: getfield 1508	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   242: lload_2
    //   243: invokevirtual 1513	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   246: new 1547	tencent/im/msg/im_common$GroupInfo
    //   249: dup
    //   250: invokespecial 1548	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   253: astore_1
    //   254: aload 8
    //   256: getfield 1552	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   259: aload_1
    //   260: invokevirtual 1553	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   263: aload 8
    //   265: getfield 1552	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   268: getfield 1556	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   271: lload 4
    //   273: invokevirtual 1513	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   276: aload 8
    //   278: getfield 1552	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   281: getfield 1560	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   284: iconst_1
    //   285: invokevirtual 1563	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   288: new 1565	tencent/im/msg/im_msg$RoutingHead
    //   291: dup
    //   292: invokespecial 1566	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   295: astore_1
    //   296: aload_1
    //   297: getfield 1570	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   300: aload 8
    //   302: invokevirtual 1571	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   305: new 1573	tencent/im/msg/im_msg$ContentHead
    //   308: dup
    //   309: invokespecial 1574	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   312: astore 8
    //   314: aload 8
    //   316: getfield 1577	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   319: astore 11
    //   321: getstatic 26	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Int	I
    //   324: istore 6
    //   326: iload 6
    //   328: iconst_1
    //   329: iadd
    //   330: putstatic 26	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Int	I
    //   333: aload 11
    //   335: iload 6
    //   337: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   340: new 1579	tencent/im/msg/im_msg$MsgHead
    //   343: dup
    //   344: invokespecial 1580	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   347: astore 11
    //   349: aload 11
    //   351: getfield 1584	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   354: aload 8
    //   356: invokevirtual 1585	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   359: aload 11
    //   361: getfield 1589	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   364: aload_1
    //   365: invokevirtual 1590	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   368: aload 9
    //   370: getfield 1594	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   373: aload 11
    //   375: invokevirtual 1595	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   378: new 1597	tencent/im/msg/im_imagent$Signature
    //   381: dup
    //   382: invokespecial 1598	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   385: astore 11
    //   387: aload 11
    //   389: getfield 1601	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   392: iconst_1
    //   393: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   396: aload 11
    //   398: getfield 1604	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   401: sipush 256
    //   404: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   407: aload_0
    //   408: invokestatic 1609	com/tencent/qqconnect/wtlogin/LoginHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   411: astore_0
    //   412: aload_0
    //   413: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   416: istore 7
    //   418: aload_0
    //   419: astore 8
    //   421: iload 7
    //   423: ifeq +65 -> 488
    //   426: aconst_null
    //   427: areturn
    //   428: astore_1
    //   429: goto +8 -> 437
    //   432: astore_1
    //   433: ldc_w 309
    //   436: astore_0
    //   437: aload_0
    //   438: astore 8
    //   440: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq +45 -> 488
    //   446: new 385	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   453: astore 8
    //   455: aload 8
    //   457: ldc_w 1611
    //   460: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 8
    //   466: aload_1
    //   467: invokevirtual 1614	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   470: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: ldc 105
    //   476: iconst_2
    //   477: aload 8
    //   479: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 1617	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_0
    //   486: astore 8
    //   488: aload 11
    //   490: getfield 1620	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   493: aload 8
    //   495: invokestatic 1461	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   498: invokevirtual 467	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   501: new 1622	tencent/im/msg/im_imagent$ImAgentHead
    //   504: dup
    //   505: invokespecial 1623	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   508: astore_0
    //   509: aload_0
    //   510: getfield 1626	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   513: iconst_3
    //   514: invokevirtual 1563	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   517: aload_0
    //   518: getfield 1630	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   521: aload 11
    //   523: invokevirtual 1631	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   526: aload_0
    //   527: getfield 1634	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   530: aload 10
    //   532: invokevirtual 1545	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   535: aload_0
    //   536: getfield 1635	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   539: astore_1
    //   540: getstatic 26	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Int	I
    //   543: istore 6
    //   545: iload 6
    //   547: iconst_1
    //   548: iadd
    //   549: putstatic 26	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Int	I
    //   552: aload_1
    //   553: iload 6
    //   555: invokevirtual 476	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   558: new 1637	tencent/im/msg/im_msg$MsgSendReq
    //   561: dup
    //   562: invokespecial 1638	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   565: astore_1
    //   566: aload_1
    //   567: getfield 1642	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   570: aload 9
    //   572: invokevirtual 1643	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   575: new 1645	tencent/im/msg/im_imagent$ImAgentPackage
    //   578: dup
    //   579: invokespecial 1646	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   582: astore 8
    //   584: aload 8
    //   586: getfield 1649	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   589: aload_0
    //   590: invokevirtual 1650	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   593: aload 8
    //   595: getfield 1654	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   598: aload_1
    //   599: invokevirtual 1655	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   602: aload 8
    //   604: invokevirtual 1658	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   607: astore 8
    //   609: new 1660	java/io/ByteArrayOutputStream
    //   612: dup
    //   613: aload 8
    //   615: arraylength
    //   616: bipush 8
    //   618: iadd
    //   619: invokespecial 1661	java/io/ByteArrayOutputStream:<init>	(I)V
    //   622: astore_0
    //   623: new 1663	java/io/DataOutputStream
    //   626: dup
    //   627: aload_0
    //   628: invokespecial 1666	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   631: astore_1
    //   632: aload_1
    //   633: aload 8
    //   635: arraylength
    //   636: bipush 8
    //   638: iadd
    //   639: invokevirtual 1669	java/io/DataOutputStream:writeInt	(I)V
    //   642: aload_1
    //   643: bipush 123
    //   645: invokevirtual 1672	java/io/DataOutputStream:write	(I)V
    //   648: aload_1
    //   649: bipush 123
    //   651: invokevirtual 1672	java/io/DataOutputStream:write	(I)V
    //   654: aload_1
    //   655: aload 8
    //   657: invokevirtual 1675	java/io/DataOutputStream:write	([B)V
    //   660: aload_1
    //   661: bipush 125
    //   663: invokevirtual 1672	java/io/DataOutputStream:write	(I)V
    //   666: aload_1
    //   667: bipush 125
    //   669: invokevirtual 1672	java/io/DataOutputStream:write	(I)V
    //   672: aload_0
    //   673: invokevirtual 1676	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   676: astore 8
    //   678: aload_0
    //   679: invokevirtual 1679	java/io/ByteArrayOutputStream:close	()V
    //   682: aload_1
    //   683: invokevirtual 1680	java/io/DataOutputStream:close	()V
    //   686: aload 8
    //   688: areturn
    //   689: astore 8
    //   691: goto +20 -> 711
    //   694: astore 8
    //   696: aload 8
    //   698: invokevirtual 1683	java/lang/Exception:printStackTrace	()V
    //   701: aload_0
    //   702: invokevirtual 1679	java/io/ByteArrayOutputStream:close	()V
    //   705: aload_1
    //   706: invokevirtual 1680	java/io/DataOutputStream:close	()V
    //   709: aconst_null
    //   710: areturn
    //   711: aload_0
    //   712: invokevirtual 1679	java/io/ByteArrayOutputStream:close	()V
    //   715: aload_1
    //   716: invokevirtual 1680	java/io/DataOutputStream:close	()V
    //   719: aload 8
    //   721: athrow
    //   722: astore_0
    //   723: aload 8
    //   725: areturn
    //   726: astore_0
    //   727: aconst_null
    //   728: areturn
    //   729: astore_0
    //   730: goto -11 -> 719
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	paramQQAppInterface	QQAppInterface
    //   0	733	1	paramString	String
    //   0	733	2	paramLong1	long
    //   0	733	4	paramLong2	long
    //   324	230	6	i	int
    //   416	6	7	bool	boolean
    //   16	671	8	localObject1	Object
    //   689	1	8	localObject2	Object
    //   694	30	8	localException	Exception
    //   32	539	9	localObject3	Object
    //   41	490	10	localObject4	Object
    //   319	203	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   412	418	428	java/lang/InterruptedException
    //   407	412	432	java/lang/InterruptedException
    //   632	678	689	finally
    //   696	701	689	finally
    //   632	678	694	java/lang/Exception
    //   678	686	722	java/lang/Exception
    //   701	709	726	java/lang/Exception
    //   711	719	729	java/lang/Exception
  }
  
  public static final int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 2;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
        i = j;
        if (paramString != null)
        {
          if (paramString.isTroopOwner(paramQQAppInterface.getCurrentUin())) {
            return 0;
          }
          i = j;
          if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentUin())) {
            i = 1;
          }
        }
      }
    }
    return i;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openTroopInfoActivityFromAIO.");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("TroopMemberUtil", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramContext == null) {
      return;
    }
    Object localObject1 = new TroopInfoData();
    ((TroopInfoData)localObject1).troopUin = paramString;
    Object localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject2 != null)
    {
      localObject2 = ((TroopManager)localObject2).b(paramString);
      if (localObject2 != null)
      {
        if (((TroopInfo)localObject2).isAdmin())
        {
          ((TroopInfoData)localObject1).updateForTroopChatSetting((TroopInfo)localObject2, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
          ((TroopInfoData)localObject1).isMember = true;
          paramQQAppInterface = TroopInfoUIUtil.a(paramString, 115, ((TroopInfoData)localObject1).troopLat, ((TroopInfoData)localObject1).troopLon, ((TroopInfoData)localObject1).cityId, ((TroopInfoData)localObject1).troopLocation);
          paramQQAppInterface.putInt("troop_type_ex", ((TroopInfoData)localObject1).troopTypeExt);
          paramQQAppInterface.putInt("PARAM_EXIT_ANIMATION", 2);
          ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(paramContext, paramQQAppInterface);
          return;
        }
        ThreadManager.getUIHandler().post(new TroopUtils.3(paramContext));
      }
    }
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
  
  public static boolean b(String paramString)
  {
    String str = SharePreferenceUtils.a(BaseApplicationImpl.getApplication(), paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberUtil", 2, String.format("isEmptyRedPointSP [%s, %s]", new Object[] { paramString, str }));
    }
    return TextUtils.isEmpty(str);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessageRecord.frienduin);
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((paramQQAppInterface.isTroopOwner(paramString)) || (paramQQAppInterface.isTroopAdmin(paramString))) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils
 * JD-Core Version:    0.7.0.1
 */