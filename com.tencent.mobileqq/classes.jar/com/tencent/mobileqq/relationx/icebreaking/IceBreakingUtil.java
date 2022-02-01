package com.tencent.mobileqq.relationx.icebreaking;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public class IceBreakingUtil
{
  static int[] a = { -1034, -2060, -2062, -2015, -2065, -2061, -5040, -5021, -2050, -2018, -2023, -2074, -7009, -7010, -7011, -7012, -7015 };
  static int[] b = { 0, 1000, 1004, 1020, 1006, 1001, 1003, 1021, 1022 };
  
  public static int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int j = 6;
    int i = j;
    if (paramQQAppInterface != null)
    {
      if (paramSessionInfo == null) {
        return 6;
      }
      int k = paramSessionInfo.a;
      if (b(k))
      {
        if (((IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramSessionInfo.b, paramSessionInfo.a) == 1) {
          return 2;
        }
        return 1;
      }
      if (c(k)) {
        return 3;
      }
      if (d(k)) {
        return 4;
      }
      i = j;
      if (e(k)) {
        i = 5;
      }
    }
    return i;
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(a.length * 8);
    localStringBuilder.append("msgtype not in (");
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = a;
      if (i >= arrayOfInt.length) {
        break;
      }
      localStringBuilder.append(arrayOfInt[i]);
      if (i == a.length - 1) {
        localStringBuilder.append(")");
      } else {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.ah.a == 0) {
      return paramBaseChatPie.ah.b;
    }
    return paramBaseChatPie.ah.c;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt, MessageForPoke paramMessageForPoke)
  {
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramMessageForPoke != null))
    {
      Object localObject = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("addBreakingIceGrayMsgTwo friends is null,  uin: ");
          paramAppInterface.append(paramString);
          QLog.i("IceBreak.IceBreakingUtil", 2, paramAppInterface.toString());
        }
        return;
      }
      long l = paramMessageForPoke.time;
      localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131903661), new Object[] { ((Friends)localObject).getFriendNickWithAlias() });
      paramMessageForPoke = new UniteGrayTipParam(paramString, paramAppInterface.getCurrentUin(), (String)localObject, paramInt, -5040, 655379, l);
      paramMessageForPoke.g = ((String)localObject);
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramAppInterface, paramMessageForPoke);
      ((MessageForUniteGrayTip)localObject).isread = true;
      ((MessageForUniteGrayTip)localObject).issend = 1;
      UniteGrayTipMsgUtil.a(paramAppInterface, (MessageForUniteGrayTip)localObject);
      ReportController.b(paramAppInterface, "dc00898", "", "", "0X8009891", "0X8009891", 0, 0, "", "", "", "");
      a(IceBreakingUtil.Event.GRAY_WORD_CLK);
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addBreakingIceGrayMsgTwo [uin: %s, uinType: %s, time: %s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l) }));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("addBreakingIceGrayMsgTwo invalidate params uin: ");
      paramAppInterface.append(paramString);
      QLog.i("IceBreak.IceBreakingUtil", 2, paramAppInterface.toString());
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, JSONObject paramJSONObject)
  {
    IceBreakingUtil.reportParams.d = paramJSONObject.optInt("actionId");
    IceBreakingUtil.reportParams.e = paramJSONObject.optInt("type");
    IceBreakingUtil.reportParams.a = ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getReportSessionType(paramBaseChatPie.ah.a);
    IceBreakingUtil.reportParams.b = ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(paramBaseChatPie.d);
    IceBreakingUtil.reportParams.c = 1;
    IceBreakingUtil.reportParams.f = ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getUserStatus(paramBaseChatPie.d);
    IceBreakingUtil.reportParams.h = a(paramBaseChatPie);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
    boolean bool = paramQQAppInterface.j(paramString);
    if ((paramQQAppInterface.k(paramString)) && (QLog.isColorLevel())) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "clearIceBreakingFlag onDelFrd uin: %s %b", new Object[] { paramString, Boolean.valueOf(bool) }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramMessageRecord != null))
    {
      if (paramString.length() < 5) {
        return;
      }
      if ((!MessageUtils.b(paramMessageRecord.msgtype)) && (!MsgProxyUtils.d(paramMessageRecord.msgtype)))
      {
        if (a(paramMessageRecord.msgtype)) {
          return;
        }
        paramQQAppInterface = (IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        if (paramInt == 1)
        {
          paramQQAppInterface.m(paramString);
          return;
        }
        if (paramQQAppInterface.k(paramString))
        {
          paramQQAppInterface.j(paramString);
          if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "clearIceBreakingFlag uin: %s msgtype: %s", new Object[] { paramString, Integer.valueOf(paramMessageRecord.msgtype) }));
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("clearIceBreakingFlag invalidate params uin: ");
      paramQQAppInterface.append(paramString);
      QLog.i("IceBreak.IceBreakingUtil", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject = (IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      Friends localFriends = localFriendsManager.c(paramString);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        if (((IStickerRecManager)paramQQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen())
        {
          if (((IceBreakingMng)localObject).a(true))
          {
            if (((IceBreakingMng)localObject).h(paramString))
            {
              ((IceBreakingMng)localObject).a(paramString);
              if (QLog.isColorLevel())
              {
                paramQQAppInterface = new StringBuilder();
                paramQQAppInterface.append("has matchChat show. uin: ");
                paramQQAppInterface.append(paramString);
                QLog.i("IceBreak.IceBreakingUtil", 2, paramQQAppInterface.toString());
              }
            }
            else
            {
              ((IceBreakingMng)localObject).a(paramString, true);
            }
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("onAddFrdSuc uin: ");
              paramQQAppInterface.append(paramString);
              QLog.i("IceBreak.IceBreakingUtil", 2, paramQQAppInterface.toString());
            }
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc emotionRec switch is off");
        }
        localObject = localFriendsManager.d(paramString, true);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null)
        {
          paramQQAppInterface = new ExtensionInfo();
          paramQQAppInterface.uin = paramString;
        }
        paramQQAppInterface.makeFrdsTs = System.currentTimeMillis();
        localFriendsManager.a(paramQQAppInterface);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("onAddFrdSuc invalidate params uin: ");
      paramQQAppInterface.append(paramString);
      QLog.i("IceBreak.IceBreakingUtil", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new IceBreakingUtil.1(paramString, paramInt, paramQQAppInterface, paramBoolean), 5, null, true);
  }
  
  public static void a(IceBreakingUtil.Event paramEvent)
  {
    int i = IceBreakingUtil.3.a[paramEvent.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        a("grayword", "click");
        return;
      }
      a("cmemoji", "click");
      return;
    }
    a("cmemoji", "expo");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("c2cnew", paramString1, paramString2, new DtReportParamsBuilder().b(IceBreakingUtil.reportParams.a).a(IceBreakingUtil.reportParams.b).c(IceBreakingUtil.reportParams.c).f(Integer.toString(IceBreakingUtil.reportParams.d)).e(IceBreakingUtil.reportParams.e).f(IceBreakingUtil.reportParams.f).a(Integer.valueOf(IceBreakingUtil.reportParams.g)).c(IceBreakingUtil.reportParams.h).a());
  }
  
  public static boolean a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = a;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    boolean bool;
    if (((b(paramInt)) || (c(paramInt)) || (d(paramInt)) || (e(paramInt)) || (f(paramInt))) && (!Utils.c(paramString)) && (!RobotUtils.a(paramQQAppInterface, paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.IceBreakingUtil", 2, String.format("canShowIceBreak, type: %s, uin: %s, canShow: %s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramString.length() >= 5))
    {
      boolean bool = QLog.isColorLevel();
      int j = 1;
      if (bool) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak uin=%s forceLocal=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      }
      if (!((IStickerRecManager)paramQQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen())
      {
        if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak emotionRec switch is off");
        }
        return;
      }
      IceBreakingMng localIceBreakingMng = (IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      if (!localIceBreakingMng.a(false))
      {
        if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak switch is off");
        }
        return;
      }
      if (localIceBreakingMng.f(paramString))
      {
        QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak entered c2c");
        return;
      }
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject = localFriendsManager.c(paramString);
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        if (localIceBreakingMng.k(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak already in break list");
          }
          return;
        }
        float f1 = localIceBreakingMng.f();
        localObject = localFriendsManager.d(paramString, true);
        if ((localObject != null) && (((ExtensionInfo)localObject).makeFrdsTs > 0L) && ((float)(System.currentTimeMillis() - ((ExtensionInfo)localObject).makeFrdsTs) < f1 * 86400000.0F))
        {
          if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak new make friends duration=%d nDay=%.3f", new Object[] { Long.valueOf(System.currentTimeMillis() - ((ExtensionInfo)localObject).makeFrdsTs), Float.valueOf(f1) }));
          }
          return;
        }
        int i;
        if (localObject == null)
        {
          localObject = new ExtensionInfo();
          ((ExtensionInfo)localObject).uin = paramString;
          i = 1;
        }
        else
        {
          i = 0;
        }
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        float f2 = (float)Math.abs(l2 - ((ExtensionInfo)localObject).lastIceBreakChatTs);
        float f3 = 86400000.0F * f1;
        if (f2 < f3)
        {
          if (i != 0) {
            localFriendsManager.a((ExtensionInfo)localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak lastChatTs within nDays=%.3f", new Object[] { Float.valueOf(f1) }));
          }
          return;
        }
        MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().a(paramString, 0, a());
        if (localMessageRecord == null) {
          l1 = 0L;
        } else {
          l1 = localMessageRecord.time * 1000L;
        }
        if (l1 > ((ExtensionInfo)localObject).lastIceBreakChatTs)
        {
          ((ExtensionInfo)localObject).lastIceBreakChatTs = l1;
          i = 1;
        }
        if ((float)Math.abs(l2 - l1) < f3)
        {
          if (i != 0) {
            localFriendsManager.a((ExtensionInfo)localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak last msg within nDays=%.3f", new Object[] { Float.valueOf(f1) }));
          }
          return;
        }
        long l1 = SystemClock.elapsedRealtime();
        if ((!paramBoolean) && ((((ExtensionInfo)localObject).lastIceBreakCheckTs == 0L) || (Math.abs(((ExtensionInfo)localObject).lastIceBreakCheckTs - l1) > 86400000L))) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak reqServer=%b lastCheckTs=%d nDays=%.3f", new Object[] { Boolean.valueOf(bool), Long.valueOf(((ExtensionInfo)localObject).lastIceBreakCheckTs), Float.valueOf(f1) }));
        }
        if (bool)
        {
          if (AppNetConnInfo.isNetSupport())
          {
            ((ExtensionInfo)localObject).lastIceBreakCheckTs = l1;
            ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqLastChatTime(paramString, (int)Math.ceil(f1));
            i = j;
          }
        }
        else if (paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("checkNeedShowIceBreak add_to_breaklist on forceLocal ");
            paramQQAppInterface.append(paramString);
            QLog.i("IceBreak.IceBreakingUtil", 2, paramQQAppInterface.toString());
          }
          localIceBreakingMng.a(paramString, false);
        }
        if (i != 0) {
          localFriendsManager.a((ExtensionInfo)localObject);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak not friend");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkNeedShowIceBreak invalidate params uin: ");
      paramQQAppInterface.append(paramString);
      QLog.i("IceBreak.IceBreakingUtil", 2, paramQQAppInterface.toString());
    }
  }
  
  public static boolean b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = b;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean d(int paramInt)
  {
    return ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatType(paramInt);
  }
  
  public static boolean e(int paramInt)
  {
    return QCircleChatUtil.b(paramInt);
  }
  
  private static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).q(paramString);
  }
  
  public static boolean f(int paramInt)
  {
    return QCircleChatUtil.c(paramInt);
  }
  
  private static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).r(paramString);
  }
  
  private static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).u(paramString);
  }
  
  private static void i(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).t(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil
 * JD-Core Version:    0.7.0.1
 */