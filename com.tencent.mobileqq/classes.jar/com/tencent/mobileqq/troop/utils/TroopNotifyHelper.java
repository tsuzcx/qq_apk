package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfig;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopNotifyHelper
{
  private static boolean a = false;
  private static HashSet<Integer> b = new HashSet();
  
  static
  {
    b.add(Integer.valueOf(1));
    b.add(Integer.valueOf(2));
    b.add(Integer.valueOf(10));
    b.add(Integer.valueOf(12));
    b.add(Integer.valueOf(22));
    b.add(Integer.valueOf(13));
  }
  
  public static int a()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("lastshowtime_weak", 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" day");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("week");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("TroopNotifyHelper", 2, new Object[] { "updateLastShowTime:", "year =", ((StringBuilder)localObject).toString() });
    }
    Object localObject = i();
    if (localObject != null)
    {
      ((SharedPreferences)localObject).edit().putInt("lastshowtime_year", paramInt1).apply();
      ((SharedPreferences)localObject).edit().putInt("lastshowtime_day", paramInt2).apply();
      ((SharedPreferences)localObject).edit().putInt("lastshowtime_weak", paramInt3).apply();
    }
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLastUndealMsgSeqseq = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("TroopNotifyHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = i();
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("lastundealmsgseq", paramLong).apply();
    }
  }
  
  public static void a(Context paramContext, TroopNotifyHelper.OnTroopSafeDialogClickConfirm paramOnTroopSafeDialogClickConfirm, Object... paramVarArgs)
  {
    if (paramContext == null) {
      return;
    }
    DialogUtil.a(paramContext, paramContext.getString(2131917612), paramContext.getString(2131917611), null, 2131887648, 2131892542, new TroopNotifyHelper.1(paramOnTroopSafeDialogClickConfirm, paramVarArgs), new TroopNotifyHelper.2()).show();
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, long paramLong, String paramString)
  {
    if (paramStructMsg != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(((structmsg.StructMsg)paramStructMsg.get()).msg_type.get());
      localObject = ((StringBuilder)localObject).toString();
      GroupSystemMsgController.a().a((String)localObject, (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().c((String)localObject);
      GroupSystemMsgController.a().a(paramLong);
      GroupSystemMsgController.a().a(paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a(int paramInt)
  {
    TroopNotificationConfig localTroopNotificationConfig = (TroopNotificationConfig)QConfigManager.b().b(634);
    if (localTroopNotificationConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "troopNotificationConfig is null" });
      }
      return false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troopNotificationConfig = ");
      ((StringBuilder)localObject).append(localTroopNotificationConfig.toString());
      QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", ((StringBuilder)localObject).toString() });
    }
    if (!localTroopNotificationConfig.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, "isGlobalOpen is false");
      }
      return false;
    }
    if ((paramInt >= localTroopNotificationConfig.e) && (localTroopNotificationConfig.e != 0))
    {
      if (h())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, "isShowUndealTipsInTabRecent: undealRedPoint is Showing!");
        }
        return true;
      }
      Calendar.getInstance();
      localObject = b();
      int i;
      int j;
      if (localObject != null)
      {
        i = ((Integer)((List)localObject).get(0)).intValue();
        j = ((Integer)((List)localObject).get(1)).intValue();
        paramInt = ((Integer)((List)localObject).get(2)).intValue();
      }
      else
      {
        paramInt = 0;
        i = 0;
        j = 0;
      }
      if ((1 == i) && (3 == paramInt))
      {
        if (6 != j)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Day is changed, The day update" });
          }
          c(0);
          a(1, 6, 3);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Year is changed, The time update" });
        }
        b(0);
        c(0);
        a(1, 6, 3);
      }
      if ((System.currentTimeMillis() - e()) / 1000L < localTroopNotificationConfig.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "The TimeIntervel is  little" });
        }
        return false;
      }
      if ((1 == i) && (6 == j) && (c() >= localTroopNotificationConfig.d))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneDay =", Integer.valueOf(c()), "totalRemindCntOfOneDay =", Integer.valueOf(localTroopNotificationConfig.d) });
        }
        return false;
      }
      if ((1 == i) && (3 == paramInt) && (a() >= localTroopNotificationConfig.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneWeak =", Integer.valueOf(c()), "totalRemindCntOfOneWeak =", Integer.valueOf(localTroopNotificationConfig.b) });
        }
        return false;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "undealMsgCount =", Integer.valueOf(paramInt), "todoGroupVerifyMsgLevel =", Integer.valueOf(localTroopNotificationConfig.e) });
    }
    return false;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if ((paramStructMsg != null) && (paramAppInterface != null))
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      int k = paramStructMsg.msg.src_id.get();
      int m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
      localSystemMsgActionInfo.group_code.set(paramStructMsg.msg.group_code.get());
      localSystemMsgActionInfo.sig.set(ByteStringMicro.EMPTY);
      localSystemMsgActionInfo.type.set(15);
      if (paramBoolean) {
        localSystemMsgActionInfo.uint32_req_msg_type.set(2);
      }
      paramStructMsg = (IMessageHandler)paramAppInterface.getRuntimeService(IMessageHandler.class, "");
      if (paramStructMsg != null) {
        paramStructMsg.sendGroupSystemMsgAction(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localSystemMsgActionInfo.get(), 3);
      }
      GroupSystemMsgController.a().a(paramAppInterface, 0);
      ReportController.b(null, "dc00898", "", "", "0x800B47E", "0x800B47E", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public static List<Integer> b()
  {
    Object localObject = i();
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    int i = ((SharedPreferences)localObject).getInt("lastshowtime_year", 0);
    localArrayList.add(0, Integer.valueOf(i));
    int j = ((SharedPreferences)localObject).getInt("lastshowtime_day", 0);
    localArrayList.add(1, Integer.valueOf(j));
    int k = ((SharedPreferences)localObject).getInt("lastshowtime_weak", 0);
    localArrayList.add(2, Integer.valueOf(k));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLastShowTimeyear = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" day");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("week");
      ((StringBuilder)localObject).append(k);
      QLog.d("TroopNotifyHelper", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, new Object[] { "updateRemindCntOfOneWeak", "count =", Integer.valueOf(paramInt) });
    }
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneweak", paramInt).apply();
    }
  }
  
  public static void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLastShowTimeInterveltime = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("TroopNotifyHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = i();
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("intervelshowtime", paramLong).apply();
    }
  }
  
  public static int c()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("remindcntofoneday", 0);
  }
  
  public static void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRemindCntOfOneDaycount = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopNotifyHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = i();
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putInt("remindcntofoneday", paramInt).apply();
    }
  }
  
  public static long d()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("lastundealmsgseq", 0L);
  }
  
  public static boolean d(int paramInt)
  {
    return b.contains(Integer.valueOf(paramInt));
  }
  
  public static long e()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("intervelshowtime", 0L);
  }
  
  public static void f()
  {
    Object localObject2 = MobileQQ.sMobileQQ;
    Object localObject1 = null;
    localObject2 = ((MobileQQ)localObject2).waitAppRuntime(null);
    if (localObject2 == null) {
      return;
    }
    localObject2 = (IMessageFacade)((AppRuntime)localObject2).getRuntimeService(IMessageFacade.class, "");
    if (localObject2 != null) {
      localObject1 = ((IMessageFacade)localObject2).getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
    }
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      long l1 = d();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForSystemMsg))
        {
          localObject2 = ((MessageForSystemMsg)localObject2).getSystemMsg();
          if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg.has()) && (((structmsg.SystemMsg)((structmsg.StructMsg)localObject2).msg.get()).sub_type.get() == 1))
          {
            long l2 = ((structmsg.StructMsg)localObject2).msg_seq.get();
            if (l2 > l1) {
              l1 = l2;
            }
          }
        }
      }
      a(l1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateLastUndealMsgSeqnewLastSeq = ");
        ((StringBuilder)localObject1).append(l1);
        QLog.d("TroopNotifyHelper", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static int g()
  {
    Object localObject2 = MobileQQ.sMobileQQ;
    Object localObject1 = null;
    Object localObject3 = ((MobileQQ)localObject2).waitAppRuntime(null);
    if (localObject3 == null) {
      return 0;
    }
    localObject2 = new ArrayList();
    localObject3 = (ITroopNotificationService)((AppRuntime)localObject3).getRuntimeService(ITroopNotificationService.class, "");
    if (localObject3 != null) {
      localObject1 = ((ITroopNotificationService)localObject3).getMessageRecordListFromCache();
    }
    long l = d();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject3 instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localObject3).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg_seq.get() > l)) {
            ((List)localObject2).add(localObject3);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUnReadUndealMsgresult size = ");
      ((StringBuilder)localObject1).append(((List)localObject2).size());
      QLog.d("TroopNotifyHelper", 2, ((StringBuilder)localObject1).toString());
    }
    return ((List)localObject2).size();
  }
  
  public static boolean h()
  {
    return a;
  }
  
  private static SharedPreferences i()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null)
    {
      String str = localAppRuntime.getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify_redpoint");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      return localAppRuntime.getApp().getSharedPreferences(str, 0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNotifyHelper
 * JD-Core Version:    0.7.0.1
 */