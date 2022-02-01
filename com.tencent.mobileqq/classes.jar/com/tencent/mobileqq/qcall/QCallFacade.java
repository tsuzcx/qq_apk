package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

public class QCallFacade
  extends Observable
  implements Manager
{
  private QQAppInterface a;
  private FriendListObserver b = new QCallFacade.1(this);
  private DiscussionObserver c = new QCallFacade.2(this);
  
  public QCallFacade(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.b);
    paramQQAppInterface.addObserver(this.c);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    QCallFacade localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    int i;
    if (localQCallFacade != null) {
      i = localQCallFacade.b();
    } else {
      i = 0;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCountWhenCallTabHidden, callUnReadCount[%s], isConversationTabShow[%s], isInCallList[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramQQAppInterface.isConversationTabShow), Boolean.valueOf(paramQQAppInterface.isInCallList) }));
    }
    return i;
  }
  
  public static QCallFacade.CallUnreadCountInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage)
  {
    return new QCallFacade.CallUnreadCountInfo(paramQQAppInterface, paramString, paramInt1, paramInt2, paramMessage, null);
  }
  
  private void a(int paramInt)
  {
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
    if (a().c())
    {
      setChanged();
      notifyObservers(Boolean.valueOf(true));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int[] arrayOfInt = UinTypeUtil.d;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (k != paramInt) {
        b(paramQQAppInterface, paramString, k);
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    try
    {
      Object localObject = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface == null) {
        return;
      }
      localObject = ((Context)localObject).getSharedPreferences("call_time_use_up", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append("_show_flag");
      localObject = ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append("_wording");
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  private void a(QCallRecent paramQCallRecent, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, String.format("saveRecentCall[%s], [%s]", new Object[] { paramString, paramQCallRecent }));
    }
    a().d(paramQCallRecent);
    if ((UinTypeUtil.b(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  private long b(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    return localBaseApplication.getSharedPreferences("voice_tab_time", 0).getLong(paramQQAppInterface, 0L);
  }
  
  private QCallRecent b(MessageForVideo paramMessageForVideo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("save ");
      localStringBuilder.append(paramQCallRecent);
      QLog.d("QCallFacade", 2, localStringBuilder.toString());
    }
    a().c(paramQCallRecent);
    if ((UinTypeUtil.b(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.e(paramString, paramInt) > 0))
    {
      paramQQAppInterface.a(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  private QCallRecord c(MessageForVideo paramMessageForVideo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      localQQAppInterface.getProxyManager().i().init();
    }
  }
  
  private int i(String paramString, int paramInt)
  {
    List localList = g(paramString, paramInt);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      int k;
      for (int j = 0; i < localList.size(); j = k)
      {
        QCallRecord localQCallRecord = (QCallRecord)localList.get(i);
        k = j;
        if (localQCallRecord != null)
        {
          k = j;
          if (localQCallRecord.type == QCallRecord.TYPE_REALRECORD)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            k = j + 1;
          }
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount, uin[%s], type[%s], count[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j) }));
      }
      return j;
    }
    if (QLog.isColorLevel()) {
      QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount count 0, uin[%s], type[%s]]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    return 0;
  }
  
  private boolean j(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIsRealMissed friendUin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",uinType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QCallFacade", 2, ((StringBuilder)localObject).toString());
    }
    paramString = g(paramString, paramInt);
    boolean bool2 = false;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramInt = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (paramInt >= paramString.size()) {
          break;
        }
        localObject = (QCallRecord)paramString.get(paramInt);
        if ((localObject != null) && (((QCallRecord)localObject).type == QCallRecord.TYPE_REALRECORD))
        {
          if (!((QCallRecord)localObject).isMissCall())
          {
            bool1 = bool2;
            if (((QCallRecord)localObject).state != 1) {
              break;
            }
          }
          bool1 = true;
          break;
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("checkIsRealMissed ret:");
        paramString.append(bool1);
        QLog.d("QCallFacade", 2, paramString.toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "checkIsRealMissed CallRecord count 0");
    }
    return false;
  }
  
  public int a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord.msgtype == -2046) {
      return 2;
    }
    if ((paramMessageRecord.msgtype != -2026) && (!UinTypeUtil.b(paramInt))) {
      return 0;
    }
    return 1;
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount, uin为空, uin[%s], type[%s], time[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      }
      return 0;
    }
    paramString = a().a(paramString, paramInt);
    int i = 0;
    j = 0;
    try
    {
      Object localObject;
      while (i < paramString.size())
      {
        localObject = (QCallRecord)paramString.get(i);
        int k;
        if (((QCallRecord)localObject).type == QCallRecord.TYPE_DATE)
        {
          k = j;
        }
        else
        {
          if (!((QCallRecord)localObject).isMissCall()) {
            break;
          }
          k = j;
          if (((QCallRecord)localObject).time > paramLong)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("fetchUnReadCount", 4, String.format("getMissCallRecordCount, uinType[%s], qcr.time[%s], time[%s], %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(((QCallRecord)localObject).time), Long.valueOf(paramLong), localObject }));
            }
            k = j + 1;
          }
        }
        i += 1;
        j = k;
      }
      return j;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMissCallRecordCount:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("QCallFacade", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public QCallProxy a()
  {
    e();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      return localQQAppInterface.getProxyManager().i();
    }
    return null;
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = a().d();
    if (localObject1 == null) {
      return "";
    }
    long l2 = b(this.a);
    Object localObject3 = ((List)localObject1).iterator();
    localObject1 = null;
    int i = 0;
    int j = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (QCallRecent)((Iterator)localObject3).next();
      long l1;
      if (((QCallRecent)localObject2).readTime > l2) {
        l1 = ((QCallRecent)localObject2).readTime;
      } else {
        l1 = l2;
      }
      if ((((QCallRecent)localObject2).lastCallTime > l1) && (((QCallRecent)localObject2).isMissedCall()))
      {
        int m = j + 1;
        if (((QCallRecent)localObject2).uin == null)
        {
          j = m;
        }
        else
        {
          List localList = a().a(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          j = 0;
          while (j < localList.size())
          {
            QCallRecord localQCallRecord = (QCallRecord)localList.get(j);
            int k;
            if (localQCallRecord.type == QCallRecord.TYPE_DATE)
            {
              k = i;
              localObject2 = localObject1;
            }
            else
            {
              if (!localQCallRecord.isMissCall()) {
                break;
              }
              k = i;
              localObject2 = localObject1;
              if (localQCallRecord.time > l1)
              {
                if (i == 0) {
                  localObject1 = (QCallRecord)localList.get(j);
                }
                k = i + 1;
                localObject2 = localObject1;
              }
            }
            j += 1;
            i = k;
            localObject1 = localObject2;
          }
          j = m;
        }
      }
    }
    Object localObject2 = new StringBuilder();
    if ((i != 1) && (j != 1))
    {
      paramString = this.a.getApp();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(j);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject2).append(paramString.getString(2131893296, new Object[] { localObject1, ((StringBuilder)localObject3).toString() }));
    }
    else if (paramBoolean)
    {
      if (paramString != null)
      {
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(this.a.getApp().getString(2131893339));
      }
    }
    else if ((localObject1 != null) && (((QCallRecord)localObject1).isVideo()))
    {
      ((StringBuilder)localObject2).append(this.a.getApp().getString(2131893717));
    }
    else
    {
      ((StringBuilder)localObject2).append(this.a.getApp().getString(2131893113));
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addQCallRecentAndCallRecord issend=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", discussId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", senderUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("QCallFacade", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).friendUin = String.valueOf(paramLong);
    ((QCallRecord)localObject).issend = paramInt;
    ((QCallRecord)localObject).isVideo = 0;
    ((QCallRecord)localObject).time = MessageCache.c();
    ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
    if (paramInt == 1) {
      ((QCallRecord)localObject).state = 4;
    } else {
      ((QCallRecord)localObject).state = 3;
    }
    ((QCallRecord)localObject).uinType = 3000;
    a().a((QCallRecord)localObject);
    localObject = a().c(String.valueOf(paramLong), 3000);
    ((QCallRecent)localObject).uin = String.valueOf(paramLong);
    ((QCallRecent)localObject).lastCallTime = MessageCache.c();
    ((QCallRecent)localObject).type = 3000;
    ((QCallRecent)localObject).sendFlag = paramInt;
    ((QCallRecent)localObject).troopUin = String.valueOf(paramLong);
    ((QCallRecent)localObject).memberCount = this.a.getAVNotifyCenter().c(2, paramLong);
    ((QCallRecent)localObject).missedCallCount = i(String.valueOf(paramLong), 3000);
    if (paramInt == 1) {
      ((QCallRecent)localObject).state = 4;
    } else {
      ((QCallRecent)localObject).state = 3;
    }
    ((QCallRecent)localObject).senderUin = paramString;
    ((QCallRecent)localObject).isLastCallRealMissed = j(String.valueOf(paramLong), 3000);
    ((QCallRecent)localObject).isSystemCall = 0;
    a((QCallRecent)localObject, "when_addQCallRecentAndCallRecord");
  }
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, String.format("addQCallRecent, issend[%s], discussId[%s], senderUin[%s] , pstnUserInfo[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString1, paramString2 }));
    }
    QCallRecent localQCallRecent = a().c(String.valueOf(paramLong), 3000);
    localQCallRecent.uin = String.valueOf(paramLong);
    localQCallRecent.lastCallTime = MessageCache.c();
    localQCallRecent.type = 3000;
    localQCallRecent.sendFlag = paramInt;
    localQCallRecent.troopUin = String.valueOf(paramLong);
    localQCallRecent.memberCount = this.a.getAVNotifyCenter().c(2, paramLong);
    localQCallRecent.missedCallCount = i(String.valueOf(paramLong), 3000);
    if (localQCallRecent.state != 1) {
      if (paramInt == 1) {
        localQCallRecent.state = 4;
      } else {
        localQCallRecent.state = 0;
      }
    }
    localQCallRecent.pstnInfo = paramString2;
    localQCallRecent.senderUin = paramString1;
    localQCallRecent.isLastCallRealMissed = j(String.valueOf(paramLong), 3000);
    localQCallRecent.isSystemCall = 0;
    a(localQCallRecent, "when_addQCallRecent");
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, "-1", paramString2, 2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.e("QCallFacade", 2, String.format("addMissCallMsg, uinType[%s], discussId[%s], peerUin[%s], senderUin[%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3 }));
    }
    if (this.a == null) {
      return;
    }
    long l1;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Throwable paramString2)
    {
      label79:
      break label79;
    }
    if (paramInt1 == 3000) {
      i = 2;
    } else if ((paramInt1 != 1) && (paramInt1 == 0)) {
      i = 3;
    }
    paramString2 = new QCallRecord();
    paramString2.friendUin = paramString1;
    paramString2.issend = 0;
    paramString2.isVideo = 0;
    paramString2.time = MessageCache.c();
    paramString2.type = QCallRecord.TYPE_REALRECORD;
    paramString2.state = paramInt2;
    paramString2.uinType = paramInt1;
    a().a(paramString2);
    paramString2 = a().c(paramString1, paramInt1);
    paramString2.uin = paramString1;
    paramString2.lastCallTime = MessageCache.c();
    paramString2.type = paramInt1;
    paramString2.sendFlag = 0;
    paramString2.troopUin = paramString1;
    paramString2.memberCount = this.a.getAVNotifyCenter().c(i, l1);
    paramString2.state = paramInt2;
    paramString2.missedCallCount = i(paramString1, paramInt1);
    paramString2.senderUin = paramString3;
    paramString2.isLastCallRealMissed = j(paramString1, paramInt1);
    paramString2.isSystemCall = 0;
    a(paramString2, "when_addMissCallMsg");
    if (this.a.isLogin()) {
      ((IAppBadgeService)this.a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public void a(long paramLong)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    String str = this.a.getCurrentAccountUin();
    localBaseApplication.getSharedPreferences("voice_tab_time", 0).edit().putLong(str, paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("fetchUnReadCount", 2, String.format("设置saveVoiceTabTime, time[%s]", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDissCall-->discussid=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" friendUin=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" b=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" time=");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(" isSend=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("QCallFacade", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong1 != 0L)
    {
      if (paramLong2 == 0L) {
        return;
      }
      if (((DiscussionManager)this.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(String.valueOf(paramLong1)) == null) {
        return;
      }
      if (this.a.getCurrentAccountUin().equals(String.valueOf(paramLong2)))
      {
        localObject = a().c(String.valueOf(paramLong1), 3000);
        ((QCallRecent)localObject).lastCallTime = MessageCache.c();
        if (paramBoolean1)
        {
          ((QCallRecent)localObject).state = 1;
        }
        else
        {
          ((QCallRecent)localObject).state = 3;
          ((QCallRecent)localObject).time = paramLong3;
          QCallRecord localQCallRecord;
          if (paramLong3 > 0L)
          {
            localQCallRecord = new QCallRecord();
            localQCallRecord.friendUin = String.valueOf(paramLong1);
            localQCallRecord.isVideo = 0;
            localQCallRecord.time = MessageCache.c();
            localQCallRecord.talkTime = String.valueOf(paramLong3);
            localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
            localQCallRecord.uinType = 3000;
            if (paramBoolean2)
            {
              localQCallRecord.state = 4;
              localQCallRecord.issend = 1;
            }
            else
            {
              localQCallRecord.state = 3;
              localQCallRecord.issend = 0;
            }
            a().a(localQCallRecord);
          }
          else
          {
            localQCallRecord = new QCallRecord();
            localQCallRecord.friendUin = String.valueOf(paramLong1);
            localQCallRecord.issend = 1;
            localQCallRecord.isVideo = 0;
            localQCallRecord.time = MessageCache.c();
            localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
            localQCallRecord.state = 4;
            localQCallRecord.uinType = 3000;
            a().a(localQCallRecord);
          }
        }
        a((QCallRecent)localObject, "when_updateDissCall");
      }
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo)
  {
    paramMessageForVideo.parse();
    paramMessageForVideo = b(paramMessageForVideo);
    a(paramMessageForVideo, "when_insertMessage");
    if (this.a != null)
    {
      QQAppInterface localQQAppInterface;
      if ((paramMessageForVideo != null) && (paramMessageForVideo.type == 3000))
      {
        localQQAppInterface = this.a;
        if (paramMessageForVideo.isSend()) {
          paramMessageForVideo = "1";
        } else {
          paramMessageForVideo = "0";
        }
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, paramMessageForVideo, "", "", "");
      }
      else
      {
        localQQAppInterface = this.a;
        if (paramMessageForVideo.isSend()) {
          paramMessageForVideo = "1";
        } else {
          paramMessageForVideo = "0";
        }
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, paramMessageForVideo, "", "", "");
      }
      if ((this.a.mainActivityIsForeground) && (this.a.isConversationTabShow) && (this.a.isInCallList)) {
        a(MessageCache.c());
      }
      this.a.refreshMsgTabUnreadNum(true, 0);
      if (this.a.isLogin()) {
        ((IAppBadgeService)this.a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
      }
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo, boolean paramBoolean)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertCallRecord updateRecentMissedCallCount:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", msg :");
      ((StringBuilder)localObject).append(paramMessageForVideo.toString());
      QLog.d("QCallFacade", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = c(paramMessageForVideo);
    a().a((QCallRecord)localObject);
    if (paramBoolean)
    {
      localObject = a().d(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      if (localObject != null)
      {
        ((QCallRecent)localObject).missedCallCount = i(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("insertCallRecord QCallRecent update MissCallCount");
          localStringBuilder.append(((QCallRecent)localObject).missedCallCount);
          QLog.d("QCallFacade", 2, localStringBuilder.toString());
        }
        ((QCallRecent)localObject).isLastCallRealMissed = j(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        a((QCallRecent)localObject, "when_insertCallRecord");
      }
    }
    setChanged();
    notifyObservers(g(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      return;
    }
    a().a(paramQCallRecent);
    a(-1);
  }
  
  public void a(String paramString)
  {
    d(paramString, 0);
    d(paramString, 1000);
    d(paramString, 1020);
    d(paramString, 1004);
    d(paramString, 1024);
    d(paramString, 8);
  }
  
  public void a(String paramString, int paramInt)
  {
    QCallRecent localQCallRecent = a().d(paramString, paramInt);
    if (localQCallRecent == null) {
      return;
    }
    long l = localQCallRecent.readTime;
    localQCallRecent.readTime = MessageCache.c();
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("updateQCallRecentReadTime, uin[%s], type[%s], readTime[%s], src[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(localQCallRecent.readTime), Long.valueOf(l) }));
    }
    a(localQCallRecent, "when_updateQCallRecentReadTime");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, 0, 0, null, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    QLog.d("QCallFacade", 1, String.format("updateDoubleCallStatus, peerUin[%s], uinType[%s], extraType[%s], bindType[%s], bindId[%s], status[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2, Integer.valueOf(paramInt4) }));
    if (paramInt1 != 1011)
    {
      if (paramInt1 == -1) {
        return;
      }
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      if (paramInt1 == 0)
      {
        localObject = (FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject != null) && (!((FriendsManager)localObject).n(paramString1))) {
          return;
        }
      }
      if (paramString1 == null) {
        return;
      }
      if ((paramInt1 == 3000) && (((DiscussionManager)this.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(paramString1) == null)) {
        return;
      }
      paramString1 = a().c(paramString1, paramInt1);
      if ((paramInt4 == 6) || (paramInt4 == 5) || (paramString1.isMissedCall())) {
        paramString1.lastCallTime = MessageCache.c();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateDoubleCallStatus lastCallTime = ");
        ((StringBuilder)localObject).append(paramString1.lastCallTime);
        QLog.d("QCallFacade", 2, ((StringBuilder)localObject).toString());
      }
      paramString1.state = paramInt4;
      paramString1.extraType = paramInt2;
      paramString1.bindId = paramString2;
      paramString1.bindType = paramInt3;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1.callType = 1;
      }
      if (paramInt4 == 0)
      {
        a(paramString1, "when_updateDoubleCallStatus");
        return;
      }
      b(paramString1);
    }
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    QCallProxy localQCallProxy = a();
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).uinType = paramInt1;
    ((QCallRecord)localObject).state = 58;
    ((QCallRecord)localObject).contactId = paramInt2;
    ((QCallRecord)localObject).friendUin = paramString1;
    ((QCallRecord)localObject).time = paramLong;
    localQCallProxy.a((QCallRecord)localObject);
    localObject = localQCallProxy.c(paramString1, paramInt1);
    ((QCallRecent)localObject).uin = paramString1;
    ((QCallRecent)localObject).type = paramInt1;
    if (paramLong > ((QCallRecent)localObject).lastCallTime) {
      ((QCallRecent)localObject).lastCallTime = paramLong;
    }
    ((QCallRecent)localObject).contactId = paramInt2;
    ((QCallRecent)localObject).isSystemCall = 1;
    ((QCallRecent)localObject).sendFlag = 1;
    ((QCallRecent)localObject).phoneNumber = paramString2;
    localQCallProxy.d((QCallRecent)localObject);
    notifyObservers(g(paramString1, paramInt1));
    setChanged();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a().a(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public int b()
  {
    if (this.a == null) {
      return 0;
    }
    if (a().d() == null) {
      return 0;
    }
    Object localObject1 = this.a.getProxyManager().g();
    if (localObject1 == null) {
      return 0;
    }
    localObject1 = ((RecentUserProxy)localObject1).a(false);
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return 0;
      }
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject1).next();
        Object localObject2;
        if (localRecentUser.getType() == 3000)
        {
          localObject2 = (DiscussionManager)this.a.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          DiscussionMemberInfo localDiscussionMemberInfo = ((DiscussionManager)localObject2).b(localRecentUser.uin, this.a.getCurrentAccountUin());
          if ((localDiscussionMemberInfo != null) && ((localDiscussionMemberInfo.flag & 0x1) == 1))
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, 开启了免打扰, disc[%s]", new Object[] { localRecentUser.uin }));
            continue;
          }
          localObject2 = ((DiscussionManager)localObject2).d(localRecentUser.uin);
          if ((localObject2 == null) || (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()) || (((DiscussionInfo)localObject2).isHidden()))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getMissCallTotalCount, invalid discussion, uin[");
            ((StringBuilder)localObject2).append(localRecentUser.uin);
            ((StringBuilder)localObject2).append("], unread[");
            ((StringBuilder)localObject2).append(e(localRecentUser.uin, localRecentUser.getType()));
            ((StringBuilder)localObject2).append("]");
            QLog.i("QCallFacade", 2, ((StringBuilder)localObject2).toString());
            continue;
          }
        }
        if ((localRecentUser.getType() != 0) || ((!FriendsStatusUtil.a(localRecentUser.uin, this.a)) && (!HiddenChatHelper.a(localRecentUser.uin, localRecentUser.getType(), this.a))))
        {
          localObject2 = (ITempMsgBoxManager)this.a.getRuntimeService(ITempMsgBoxManager.class, "");
          if ((!((ITempMsgBoxManager)localObject2).isBelongToMsgBox(localRecentUser.uin, localRecentUser.getType())) && (!((ITempMsgBoxManager)localObject2).isBelongToFilterBox(localRecentUser.uin, localRecentUser.getType()))) {
            if (localRecentUser.getType() == 10007) {
              QLog.d("QCallFacade", 1, "QCallFacade but type is game msg");
            } else {
              i += e(localRecentUser.uin, localRecentUser.getType());
            }
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, count[%s]", new Object[] { Integer.valueOf(i) }));
      }
      return i;
    }
    return 0;
  }
  
  public int b(String paramString, int paramInt)
  {
    paramString = a().d(paramString, paramInt);
    if (paramString != null) {
      return paramString.state;
    }
    return 0;
  }
  
  @Deprecated
  public void b(String paramString)
  {
    Object localObject1 = (IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "");
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = null;
    PhoneContact localPhoneContact;
    if (localObject1 == null) {
      localPhoneContact = null;
    } else {
      localPhoneContact = ((IPhoneContactService)localObject1).queryContactByCodeNumber(paramString);
    }
    if (localPhoneContact != null)
    {
      boolean bool = TextUtils.isEmpty(localPhoneContact.uin);
      int j = 1;
      int k = bool ^ true;
      int i;
      if ((k != 0) && (!localPhoneContact.uin.equals("0"))) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = localObject2;
      if (i != 0) {
        if (localFriendsManager == null) {
          localObject1 = localObject2;
        } else {
          localObject1 = localFriendsManager.m(localPhoneContact.uin);
        }
      }
      if ((localObject1 != null) && (((Friends)localObject1).isFriend())) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = localPhoneContact.uin;
        i = 0;
      }
      else if (k != 0)
      {
        localObject1 = localPhoneContact.mobileCode;
        i = 1006;
      }
      else
      {
        localObject1 = localPhoneContact.mobileNo;
        i = 56938;
      }
      long l = MessageCache.c();
      a((String)localObject1, i, localPhoneContact.contactID, l, paramString);
    }
  }
  
  public int c()
  {
    Object localObject = a().d();
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    long l2 = b(this.a);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      long l1;
      if (localQCallRecent.readTime > l2) {
        l1 = localQCallRecent.readTime;
      } else {
        l1 = l2;
      }
      if ((localQCallRecent.lastCallTime > l1) && (localQCallRecent.isMissedCall())) {
        i += 1;
      }
    }
    return i;
  }
  
  public QCallRecent c(String paramString, int paramInt)
  {
    return a().d(paramString, paramInt);
  }
  
  public ArrayList<MessageRecord> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().d();
    if (localObject == null) {
      return localArrayList;
    }
    long l2 = b(this.a);
    Iterator localIterator = ((List)localObject).iterator();
    label378:
    while (localIterator.hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
      long l1;
      if (localQCallRecent.readTime > l2) {
        l1 = localQCallRecent.readTime;
      } else {
        l1 = l2;
      }
      if ((localQCallRecent.lastCallTime > l1) && (localQCallRecent.isMissedCall()) && (localQCallRecent.uin != null))
      {
        List localList = a().a(localQCallRecent.uin, localQCallRecent.type);
        int i = 0;
        for (;;)
        {
          if (i >= localList.size()) {
            break label378;
          }
          QCallRecord localQCallRecord = (QCallRecord)localList.get(i);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            if (localQCallRecord.time > l1)
            {
              if (localQCallRecent.type == 3000)
              {
                localObject = MessageRecordFactory.a(-2016);
                ((MessageRecord)localObject).msg = this.a.getApp().getString(2131893393);
                ((MessageRecord)localObject).frienduin = localQCallRecent.troopUin;
                ((MessageRecord)localObject).msgtype = -2016;
                ((MessageRecord)localObject).senderuin = "";
              }
              else
              {
                localObject = MessageRecordFactory.a(-2009);
                ((MessageRecord)localObject).frienduin = localQCallRecent.uin;
                ((MessageRecord)localObject).msgtype = -2009;
                if (localQCallRecord.isVideo()) {
                  ((MessageRecord)localObject).msg = this.a.getApp().getString(2131893394);
                } else {
                  ((MessageRecord)localObject).msg = this.a.getApp().getString(2131893392);
                }
                ((MessageRecord)localObject).senderuin = localQCallRecord.senderuin;
              }
              ((MessageRecord)localObject).istroop = localQCallRecent.type;
              ((MessageRecord)localObject).time = localQCallRecord.time;
              localArrayList.add(localObject);
            }
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMissCallMessageRecordList = list size");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public void d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCallRecent localQCallRecent = a().d(paramString, paramInt);
    if (localQCallRecent != null) {
      a(localQCallRecent);
    }
    h(paramString, paramInt);
    if (this.a.isLogin()) {
      ((IAppBadgeService)this.a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public int e(String paramString, int paramInt)
  {
    paramString = c(paramString, paramInt);
    if ((paramString != null) && (paramString.isMissedCall()))
    {
      long l2 = b(this.a);
      long l1 = l2;
      if (paramString.readTime > l2) {
        l1 = paramString.readTime;
      }
      return a(paramString.uin, paramString.type, l1);
    }
    return 0;
  }
  
  public int f(String paramString, int paramInt)
  {
    Object localObject1 = a().d();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount fail, friendUin[%s], uinType[%s]", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      return 0;
    }
    long l2 = b(this.a);
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
      if ((paramString.equals(((QCallRecent)localObject2).uin)) && (paramInt == ((QCallRecent)localObject2).type))
      {
        long l1;
        if (((QCallRecent)localObject2).readTime > l2) {
          l1 = ((QCallRecent)localObject2).readTime;
        } else {
          l1 = l2;
        }
        if ((((QCallRecent)localObject2).lastCallTime > l1) && (((QCallRecent)localObject2).isMissedCall()) && (((QCallRecent)localObject2).uin != null))
        {
          localObject2 = a().a(paramString, paramInt);
          int j = 0;
          while (j < ((List)localObject2).size())
          {
            QCallRecord localQCallRecord = (QCallRecord)((List)localObject2).get(j);
            int k;
            if (localQCallRecord.type == QCallRecord.TYPE_DATE)
            {
              k = i;
            }
            else
            {
              if (!localQCallRecord.isMissCall()) {
                break;
              }
              k = i;
              if (localQCallRecord.time > l1) {
                k = i + 1;
              }
            }
            j += 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  public List<QCallRecord> g(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getListRecord friendUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",uinType:");
      localStringBuilder.append(paramInt);
      QLog.d("QCallFacade", 2, localStringBuilder.toString());
    }
    return a().a(paramString, paramInt);
  }
  
  public void h(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearAllRecord friendUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",uinType:");
      localStringBuilder.append(paramInt);
      QLog.d("QCallFacade", 2, localStringBuilder.toString());
    }
    a().b(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    this.a.removeObserver(this.b);
    this.a.removeObserver(this.c);
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallFacade
 * JD-Core Version:    0.7.0.1
 */