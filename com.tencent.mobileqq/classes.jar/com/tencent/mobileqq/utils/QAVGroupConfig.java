package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class QAVGroupConfig
{
  private static QAVGroupConfig.ConfigInfo a;
  
  public static int a()
  {
    return a().d;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int j = a(((TroopManager)localObject3).c(paramString));
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getGroupMemberNum, groupUin[");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("], memberCount[");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    int n = c();
    int m = 0;
    int k = 0;
    Object localObject2 = localObject1;
    int i = m;
    if (j - 10 < n)
    {
      localObject3 = ((TroopManager)localObject3).b(String.valueOf(paramString));
      localObject2 = localObject1;
      i = m;
      if (localObject3 != null)
      {
        paramString = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
        paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        localObject2 = ((List)localObject3).iterator();
        i = k;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TroopMemberInfo)((Iterator)localObject2).next();
          if ((!paramString.isRobotUin(((TroopMemberInfo)localObject3).memberuin)) && (!paramQQAppInterface.f(((TroopMemberInfo)localObject3).memberuin)))
          {
            i += 1;
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("\nisRobotUin[");
            localStringBuilder.append(((TroopMemberInfo)localObject3).memberuin);
            localStringBuilder.append("]");
            localObject1 = localStringBuilder.toString();
          }
        }
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append((String)localObject1);
        paramQQAppInterface.append("\nCalcCount[");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append("]");
        localObject2 = paramQQAppInterface.toString();
      }
    }
    if (i == 0) {
      i = j;
    }
    if (QLog.isDevelopLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("");
      paramQQAppInterface.append((String)localObject2);
      paramQQAppInterface.append(", time[");
      paramQQAppInterface.append(System.currentTimeMillis() - l);
      paramQQAppInterface.append("]");
      QLog.w("QAVGroupConfig", 1, paramQQAppInterface.toString());
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramBoolean) {
        return a(paramQQAppInterface, paramString);
      }
      return ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    }
    return 0;
  }
  
  static int a(TroopInfo paramTroopInfo)
  {
    int i = paramTroopInfo.wMemberNumClient;
    if (QQAudioHelper.c())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMemberNum, troopuin[");
      localStringBuilder.append(paramTroopInfo.troopuin);
      localStringBuilder.append("], wMemberNumClient[");
      localStringBuilder.append(paramTroopInfo.wMemberNumClient);
      localStringBuilder.append("], wMemberNum[");
      localStringBuilder.append(paramTroopInfo.wMemberNum);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramTroopInfo.uin);
      localStringBuilder.append("], troopcode[");
      localStringBuilder.append(paramTroopInfo.troopcode);
      localStringBuilder.append("]");
      QLog.w("QAVGroupConfig", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = a(paramQQAppInterface, true, paramString);
    int k = paramQQAppInterface.getTroopMask(paramString);
    Object localObject = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    boolean bool2 = ((TroopGagMgr)localObject).a(paramString, paramQQAppInterface.getCurrentAccountUin());
    boolean bool4 = ((TroopGagMgr)localObject).a(paramString);
    boolean bool5 = ((TroopGagMgr)localObject).b(paramString);
    paramQQAppInterface = ((TroopGagMgr)localObject).a(paramString);
    boolean bool3 = false;
    boolean bool1;
    int i;
    if ((!bool5) && (bool2))
    {
      bool1 = true;
      i = 2131695639;
    }
    else if ((!bool4) && (paramQQAppInterface != null) && (paramQQAppInterface.a != 0L))
    {
      bool1 = true;
      i = 2131695638;
    }
    else
    {
      bool1 = false;
      i = 0;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("mask", k);
    ((Bundle)localObject).putInt("num", j);
    ((Bundle)localObject).putBoolean("isAdmin", bool4);
    ((Bundle)localObject).putBoolean("isOwner", bool5);
    ((Bundle)localObject).putBoolean("forceDisableInviteBox", bool1);
    ((Bundle)localObject).putInt("errId", i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGroupMask, troopUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mask[");
    localStringBuilder.append(k);
    localStringBuilder.append("], num[");
    localStringBuilder.append(j);
    localStringBuilder.append("], isOwner[");
    localStringBuilder.append(bool5);
    localStringBuilder.append("], isMemberGaged[");
    localStringBuilder.append(bool2);
    localStringBuilder.append("], isAdmin[");
    localStringBuilder.append(bool4);
    localStringBuilder.append("], gagTimeStamp[");
    bool2 = bool3;
    if (paramQQAppInterface != null)
    {
      bool2 = bool3;
      if (paramQQAppInterface.a != 0L) {
        bool2 = true;
      }
    }
    localStringBuilder.append(bool2);
    localStringBuilder.append("], forceDisableInviteBox[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("]");
    QLog.w("QAVGroupConfig", 1, localStringBuilder.toString());
    return localObject;
  }
  
  public static QAVGroupConfig.ConfigInfo a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = QAVGroupConfig.ConfigInfo.a(QAVConfig.b(276).a);
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(String paramString)
  {
    paramString = QAVGroupConfig.ConfigInfo.a(paramString);
    try
    {
      a = paramString;
      return;
    }
    finally {}
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    ITroopManagerBizHandler localITroopManagerBizHandler = (ITroopManagerBizHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
    if (localITroopManagerBizHandler != null) {
      if (localITroopInfoHandler == null) {
        return;
      }
    }
    try
    {
      l = Long.parseLong(paramString2);
    }
    catch (Exception localException)
    {
      long l;
      label43:
      Object localObject;
      break label43;
    }
    l = 0L;
    if (l == 0L) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(QQAudioHelper.b());
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = String.valueOf(l);
    paramQQAppInterface.addObserver(new QAVGroupConfig.1(l, paramString1, paramQQAppInterface, (String)localObject));
    localITroopManagerBizHandler.a(l, 480);
    paramString2 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
    if (paramString2.maxInviteMemNum == 0)
    {
      paramQQAppInterface.addObserver(new QAVGroupConfig.2((String)localObject, paramQQAppInterface, paramString1));
      localITroopInfoHandler.a((String)localObject);
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("getGroupInfo[");
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append("], troopuin[");
    paramQQAppInterface.append(l);
    paramQQAppInterface.append("], maxInviteMemNum[");
    paramQQAppInterface.append(paramString2.maxInviteMemNum);
    paramQQAppInterface.append("]");
    QLog.w("QAVGroupConfig", 1, paramQQAppInterface.toString());
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, long paramLong, boolean paramBoolean)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", String.valueOf(paramLong));
    paramVideoAppInterface = paramVideoAppInterface.a(6, 0, 0, (Bundle)localObject, null);
    int j;
    int i;
    if (paramVideoAppInterface != null)
    {
      int k = paramVideoAppInterface.getInt("mask", 1);
      int m = paramVideoAppInterface.getInt("num");
      boolean bool = paramVideoAppInterface.getBoolean("forceDisableInviteBox");
      j = k;
      i = m;
      if (QLog.isColorLevel())
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("canShowInviteBox, forceDisableInviteBox[");
        paramVideoAppInterface.append(bool);
        paramVideoAppInterface.append("], mask[");
        paramVideoAppInterface.append(k);
        paramVideoAppInterface.append("], num[");
        paramVideoAppInterface.append(m);
        paramVideoAppInterface.append("]");
        QLog.i("QAVGroupConfig", 2, paramVideoAppInterface.toString());
        j = k;
        i = m;
      }
    }
    else
    {
      j = 1;
      i = 0;
    }
    if (paramBoolean) {
      return true;
    }
    if (1 == j)
    {
      if (QQAudioHelper.b())
      {
        j = QQAudioHelper.a(6);
        if (j == 1) {
          return true;
        }
        if (j == 0) {
          return false;
        }
      }
      paramVideoAppInterface = a();
      if (i > paramVideoAppInterface.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGAudioInvite, 成员太多, relationId[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("], show_invite_box[");
        ((StringBuilder)localObject).append(paramVideoAppInterface.e);
        ((StringBuilder)localObject).append("], MemberNum[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("]");
        QLog.w("QAVGroupConfig", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      return true;
    }
    QAVGroupConfig.Report.a(j);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    boolean bool1 = paramQQAppInterface.a(paramString);
    boolean bool2 = paramQQAppInterface.b(paramString);
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (1 == QQAudioHelper.a(7))
    {
      QQAudioHelper.a(HardCodeUtil.a(2131708909));
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
    boolean bool1 = false;
    boolean bool6 = false;
    if (localTroopInfo != null)
    {
      boolean bool2;
      if ((localTroopInfo.dwAdditionalFlag & 1L) == 1L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3;
      if ((localTroopInfo.dwCmdUinUinFlag & 1L) == 1L) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      int i = a(localTroopInfo);
      long l2 = localTroopInfo.troopPrivilegeFlag;
      long l1 = 0L;
      Object localObject1;
      if ((l2 & 0x6100000) == 0L)
      {
        localObject1 = HardCodeUtil.a(2131708906);
        bool1 = true;
      }
      else if ((localTroopInfo.troopPrivilegeFlag & 0x2000000) == 33554432L)
      {
        if (i > 50) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject1 = HardCodeUtil.a(2131708907);
      }
      else if ((localTroopInfo.troopPrivilegeFlag & 0x4000000) == 67108864L)
      {
        if (i > 100) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject1 = HardCodeUtil.a(2131708908);
      }
      else
      {
        if ((localTroopInfo.troopPrivilegeFlag & 0x100000) == 1048576L) {
          localObject1 = HardCodeUtil.a(2131708912);
        } else {
          localObject1 = "";
        }
        bool1 = false;
      }
      boolean bool4 = bool1;
      Object localObject2 = localObject1;
      if (bool1)
      {
        bool4 = bool1;
        localObject2 = localObject1;
        if (localTroopInfo.isAdmin())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708911));
          localObject2 = ((StringBuilder)localObject2).toString();
          bool4 = false;
        }
      }
      int j = localTroopInfo.getMemNumForAutoInviteIntoGroup(paramQQAppInterface.getCurrentUin());
      boolean bool5;
      if (j >= 0)
      {
        if (i >= j) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool5 = bool1;
        localObject1 = localObject2;
        if (bool1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708910));
          localObject1 = ((StringBuilder)localObject1).toString();
          bool5 = bool1;
        }
      }
      else
      {
        bool5 = false;
        localObject1 = localObject2;
      }
      bool1 = bool6;
      if (!bool4) {
        if (bool5) {
          bool1 = bool6;
        } else {
          bool1 = true;
        }
      }
      paramQQAppInterface = ((TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramString2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCanAutoInviteMemIntoTroop[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("], groupUin[");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("][");
      ((StringBuilder)localObject2).append(localTroopInfo.troopname);
      ((StringBuilder)localObject2).append("], \n群禁言时间戳[");
      ((StringBuilder)localObject2).append(localTroopInfo.dwGagTimeStamp);
      ((StringBuilder)localObject2).append("], \n群禁言[");
      if (paramQQAppInterface != null) {
        l1 = paramQQAppInterface.a;
      }
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], \n被禁言到期时间戳[");
      ((StringBuilder)localObject2).append(localTroopInfo.dwGagTimeStamp_me);
      ((StringBuilder)localObject2).append("], \n群成员数量[");
      ((StringBuilder)localObject2).append(localTroopInfo.wMemberNum);
      ((StringBuilder)localObject2).append("], \n群成员数量Client[");
      ((StringBuilder)localObject2).append(localTroopInfo.wMemberNumClient);
      ((StringBuilder)localObject2).append("], \n最大的邀请自动入群人数[");
      ((StringBuilder)localObject2).append(localTroopInfo.maxInviteMemNum);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("], \n后台配置_每次选人上限[");
      ((StringBuilder)localObject2).append(b());
      ((StringBuilder)localObject2).append("], \n后台配置_通话成员邀请上限[");
      ((StringBuilder)localObject2).append(c());
      ((StringBuilder)localObject2).append("], \nmMemberInvitingFlag[");
      ((StringBuilder)localObject2).append(localTroopInfo.mMemberInvitingFlag);
      ((StringBuilder)localObject2).append("], \nisOnlyTroopMemberInviteOption[");
      ((StringBuilder)localObject2).append(localTroopInfo.isOnlyTroopMemberInviteOption());
      ((StringBuilder)localObject2).append("], \n群能力标记位troopPrivilegeFlag[");
      ((StringBuilder)localObject2).append(localTroopInfo.troopPrivilegeFlag);
      ((StringBuilder)localObject2).append("], \n群标记位dwGroupFlagExt3[");
      ((StringBuilder)localObject2).append(localTroopInfo.dwGroupFlagExt3);
      ((StringBuilder)localObject2).append("], \n群的加入方式cGroupOption[");
      ((StringBuilder)localObject2).append(localTroopInfo.cGroupOption);
      ((StringBuilder)localObject2).append("], \nneedAdminCheck[");
      ((StringBuilder)localObject2).append(bool4);
      ((StringBuilder)localObject2).append("], \nneedAgree[");
      ((StringBuilder)localObject2).append(bool5);
      ((StringBuilder)localObject2).append("], \nbOwner[");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(localTroopInfo.dwAdditionalFlag);
      ((StringBuilder)localObject2).append("], \nbAdmin[");
      ((StringBuilder)localObject2).append(bool3);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(localTroopInfo.dwCmdUinUinFlag);
      ((StringBuilder)localObject2).append("], \nisAdmin[");
      ((StringBuilder)localObject2).append(localTroopInfo.isAdmin());
      ((StringBuilder)localObject2).append("], \nlog[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], \n可以邀请[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("]");
      QLog.w("QAVGroupConfig", 1, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public static int b()
  {
    return a().c;
  }
  
  public static int c()
  {
    return a().b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig
 * JD-Core Version:    0.7.0.1
 */