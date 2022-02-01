package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.util.QQKRPUtil;
import com.tencent.util.notification.NotificationController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class QQLSRecentManager
  implements Observer, Manager
{
  public static int a = 0;
  public static long a = 0L;
  public static String a;
  private static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static CopyOnWriteArrayList<RecentBaseData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public static boolean a = false;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static int b;
  public static long b;
  public static volatile boolean b;
  public static long c;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g = true;
  public static boolean h = false;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    d = false;
    e = false;
    f = false;
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_Long = -1L;
    jdField_b_of_type_Int = 0;
  }
  
  public QQLSRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_JavaLangString = AppSetting.c;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("QQLSRecentManager deviceInfo=");
      paramQQAppInterface.append(jdField_a_of_type_JavaLangString);
      QLog.d("QQLSActivity", 2, paramQQAppInterface.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      d = true;
      return d;
    }
    d = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.lock_screen.name());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPhoneNeedBright need bright before sensor = ");
      localStringBuilder.append(d);
      QLog.d("QQLSActivity", 2, localStringBuilder.toString());
    }
    return d;
  }
  
  public int a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNotifyIDForUin mNotifyIdList.size = ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    int i = -1;
    int j = i;
    if (bool)
    {
      localObject = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      j = i;
    }
    return j;
  }
  
  public CopyOnWriteArrayList<RecentBaseData> a()
  {
    return jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mDataList clear");
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but  app is null ,return");
      }
    }
    else if (!paramAppInterface.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
      }
    }
    else if (!((NotificationController)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).a(paramString, paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but is Notification not permitted ,return");
      }
    }
    else
    {
      if (jdField_a_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833")) {
        return;
      }
      boolean bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, String.format("needStartQQLS frienduin[%s], uitype[%s], isFromMisscall[%s], isStartTime[%s]", new Object[] { paramString, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
      if (!bool) {
        return;
      }
      Object localObject;
      if (!paramBoolean)
      {
        localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("locking activity:");
            localStringBuilder.append((String)localObject);
            QLog.d("QQLSActivity", 2, localStringBuilder.toString());
          }
          if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity")))
          {
            i = 1;
            break label287;
          }
        }
        int i = 0;
        label287:
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("QQLSRecentManager.getInstance().isLSalive:");
          ((StringBuilder)localObject).append(jdField_b_of_type_Boolean);
          QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt1 == 1) {
          jdField_c_of_type_Boolean = true;
        } else {
          jdField_c_of_type_Boolean = false;
        }
        if (i != 0) {
          return;
        }
      }
      if ((!PhoneStatusTools.e(BaseApplicationImpl.getApplication())) && ((!jdField_b_of_type_Boolean) || (paramBoolean))) {
        if ((a(paramAppInterface, paramString, paramInt1, paramBoolean, paramInt2, true)) && (Build.VERSION.SDK_INT <= 28))
        {
          localObject = new Intent(paramAppInterface.getApp(), QQLSActivity.class);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).addFlags(262144);
          ((Intent)localObject).putExtra("notifyId", paramInt2);
          ((Intent)localObject).putExtra("uitype", paramInt1);
          ((Intent)localObject).putExtra("frienduin", paramString);
          paramAppInterface.getApp().startActivity((Intent)localObject);
          e = true;
          jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("need report  LS report needReport=");
            paramString.append(g);
            paramString.append("hasReport=");
            paramString.append(h);
            paramString.append("startTimes=");
            paramString.append(jdField_b_of_type_Int);
            QLog.d("qqls", 2, paramString.toString());
          }
          if ((!h) && (jdField_b_of_type_Int > 2))
          {
            paramString = new HashMap();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(g);
            ((StringBuilder)localObject).append("");
            paramString.put("param_hasshowedLs", ((StringBuilder)localObject).toString());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
            if (QLog.isColorLevel())
            {
              paramAppInterface = new StringBuilder();
              paramAppInterface.append("need report  LS report needReport=");
              paramAppInterface.append(g);
              QLog.d("qqls", 2, paramAppInterface.toString());
            }
            h = true;
          }
        }
        else if (QLog.isDevelopLevel())
        {
          QLog.d("QQLSActivity", 4, String.format("needStartQQLS updateLSRencentUser fail...", new Object[0]));
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, String.format("needStartQQLS end...", new Object[0]));
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    QQKRPUtil.a(paramQQAppInterface, paramMessageRecord);
    a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramBoolean, paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeUnreadMsg mDataList= ");
        ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject).next();
        int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        int k = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        int i;
        ConcurrentHashMap localConcurrentHashMap;
        StringBuilder localStringBuilder;
        if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LBS_HELLO_UIN))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, localRecentBaseData.getRecentUserType());
        }
        else if (localRecentBaseData.getRecentUserUin().equals(AppConstants.RECOMMEND_CONTACT_UIN))
        {
          i = ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
        }
        else if (localRecentBaseData.getRecentUserUin().equals(AppConstants.DATE_UIN))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.DATE_UIN, localRecentBaseData.getRecentUserType());
        }
        else
        {
          i = j;
          if (localRecentBaseData.getRecentUserUin().equals(paramString))
          {
            i = j;
            if (paramInt == localRecentBaseData.getRecentUserType())
            {
              jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
              localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(localRecentBaseData.getRecentUserUin());
              localStringBuilder.append(localRecentBaseData.getRecentUserType());
              localConcurrentHashMap.remove(localStringBuilder.toString());
              i = j;
            }
          }
        }
        if ((i == 0) && (k == 0))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localRecentBaseData.getRecentUserUin());
          localStringBuilder.append(localRecentBaseData.getRecentUserType());
          localConcurrentHashMap.remove(localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("after removeUnreadMsg mDataList= ");
        paramString.append(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        QLog.d("QQLSActivity", 2, paramString.toString());
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean a(AppInterface paramAppInterface, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i;
    boolean bool;
    int j;
    label1275:
    label2941:
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!, thread[");
        paramString.append(Thread.currentThread().getId());
        paramString.append("], uin[");
        paramString.append((String)localObject1);
        paramString.append("], uinType[");
        paramString.append(paramInt1);
        paramString.append("], isFromMisscall[");
        paramString.append(paramBoolean1);
        QLog.d("QQLSActivity", 2, paramString.toString());
      }
      Object localObject3 = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab((String)localObject1, paramInt1);
      paramString = (String)localObject1;
      if (paramInt1 == 1001)
      {
        paramString = (String)localObject1;
        if (!MsgBoxUtil.b((MessageRecord)localObject3)) {
          paramString = AppConstants.NEARBY_LBS_HELLO_UIN;
        }
      }
      Object localObject2;
      Object localObject4;
      if ((!AppConstants.LOCK_SCREEN_DATE_UIN.equals(paramString)) && (!AppConstants.LOCK_SCREEN_LBS_HELLO_UIN.equals(paramString)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString)))
      {
        localObject2 = paramString;
        i = paramInt1;
        if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle())
        {
          localObject2 = paramString;
          i = paramInt1;
          if (paramInt1 == 7220)
          {
            localObject2 = paramString;
            i = paramInt1;
            if (AppConstants.KANDIAN_MERGE_UIN.equals(paramString))
            {
              localObject2 = AppConstants.NEW_KANDIAN_UIN;
              i = 1008;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("updateLSRencentUser size= ");
          paramString.append(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
          paramString.append("threadId =");
          paramString.append(Thread.currentThread().getId());
          QLog.d("QQLSActivity", 2, paramString.toString());
        }
        if ((!FriendsStatusUtil.a((String)localObject2, paramAppInterface)) && (!HiddenChatHelper.a((String)localObject2, i, paramAppInterface)))
        {
          if (TextUtils.equals((CharSequence)localObject2, AppConstants.TROOP_SUSPICIOUS_MSG_UIN))
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("已过滤群通知被过滤: ");
            paramAppInterface.append(QLog.getStackTraceString(new Throwable()));
            QLog.e("QQLSActivity", 1, paramAppInterface.toString());
            return false;
          }
          localObject4 = ((QQAppInterface)paramAppInterface).getProxyManager().a();
          localObject1 = ((RecentUserProxy)localObject4).a(true, false).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label2930;
            }
            paramString = (RecentUser)((Iterator)localObject1).next();
            if ((paramString == null) || (TextUtils.isEmpty(paramString.uin))) {
              break label2930;
            }
            if ((paramString != null) && (((String)localObject2).equals(paramString.uin)) && (paramString.getType() == i)) {
              break label2927;
            }
            if ((paramString != null) && (paramString.getType() == i) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString.uin))) {
              paramString = new RecentUser((String)localObject2, i);
            } else {
              if (((paramString != null) && (paramString.getType() == i) && (AppConstants.LBS_HELLO_UIN.equals(paramString.uin))) || ((paramString != null) && (paramString.getType() == i) && (AppConstants.DATE_UIN.equals(paramString.uin))) || ((paramString != null) && (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramString.uin)) && ((AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localObject2)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(localObject2)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(localObject2))))) {
                break label2927;
              }
            }
          } while ((paramString == null) || (paramString.getType() != 1032) || (UinTypeUtil.a(i) != 1032));
          break label2927;
          if (!QLog.isColorLevel()) {
            break label2941;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateLSRencentUser curUser is not null: ");
          if (paramString == null) {
            break label2935;
          }
          bool = true;
          ((StringBuilder)localObject1).append(bool);
          ((StringBuilder)localObject1).append("threadId =");
          ((StringBuilder)localObject1).append(Thread.currentThread().getId());
          QLog.d("QQLSActivity", 2, ((StringBuilder)localObject1).toString());
          break label2941;
          if (((QCallFacade)paramAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)).c((String)localObject2, i) == 0) {
            return false;
          }
          localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject1).next();
            if ((TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LOCK_SCREEN_DATE_UIN)) || (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))) {
              break label3048;
            }
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LBS_HELLO_UIN))
            {
              paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.LBS_HELLO_UIN, localRecentBaseData.getRecentUserType());
            }
            else if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN))
            {
              if (((String)localObject2).equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) {
                paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.FRIEND_SYSTEM_MSG_UIN, localRecentBaseData.getRecentUserType());
              } else {
                paramInt1 = ((INewFriendService)paramAppInterface.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount();
              }
            }
            else if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.DATE_UIN))
            {
              paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.DATE_UIN, localRecentBaseData.getRecentUserType());
            }
            else
            {
              Object localObject5;
              if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.VOTE_UIN))
              {
                localObject5 = (DatingProxyManager)paramAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                if (localObject5 == null) {
                  break label3023;
                }
                paramInt1 = ((DatingProxyManager)localObject5).a().a();
                break label3020;
              }
              if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.PULL_ACTIVE_PUSH_UIN))
              {
                localObject5 = (PullActiveManager)paramAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                if (localObject5 == null) {
                  break label3023;
                }
                paramInt1 = ((PullActiveManager)localObject5).a();
                break label3020;
              }
              paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            }
            if ((localRecentBaseData.getRecentUserType() != 3000) && (localRecentBaseData.getRecentUserType() != 0))
            {
              j = localRecentBaseData.getRecentUserType();
              if (j != 8) {
                break label1275;
              }
            }
            try
            {
              localRecentBaseData.update((QQAppInterface)paramAppInterface, BaseApplication.getContext());
            }
            catch (Throwable localThrowable)
            {
              if (!SafeModeUtil.a(BaseApplicationImpl.sApplication)) {
                break label1338;
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
              break label3028;
            }
            j = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            if (!QLog.isColorLevel()) {
              break label3040;
            }
            Object localObject6 = localRecentBaseData.getRecentUserUin();
            int k = localRecentBaseData.getRecentUserType();
            if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
              break label3034;
            }
            bool = true;
            QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject6, Integer.valueOf(k), Boolean.valueOf(bool) }));
            break label3040;
            if (paramInt1 != 0) {
              break label3045;
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            localObject6 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localRecentBaseData.getRecentUserUin());
            localStringBuilder.append(localRecentBaseData.getRecentUserType());
            ((ConcurrentHashMap)localObject6).remove(localStringBuilder.toString());
            break label3045;
            throw new RuntimeException((Throwable)localObject6);
          }
          if (paramString == null) {
            break label3057;
          }
          if (paramString.uin.equals(AppConstants.LBS_HELLO_UIN))
          {
            paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.LBS_HELLO_UIN, paramString.getType());
            break label3051;
          }
          if (paramString.uin.equals(AppConstants.RECOMMEND_CONTACT_UIN))
          {
            if (((String)localObject2).equals(AppConstants.FRIEND_SYSTEM_MSG_UIN))
            {
              paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.FRIEND_SYSTEM_MSG_UIN, paramString.getType());
              break label3051;
            }
            paramInt1 = ((INewFriendService)paramAppInterface.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount();
            ReportController.b(paramAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
          }
          else
          {
            localObject1 = paramString;
            if (((RecentUser)localObject1).uin.equals(AppConstants.DATE_UIN))
            {
              paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(AppConstants.DATE_UIN, ((RecentUser)localObject1).getType());
              break label3054;
            }
            paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
            break label3054;
          }
          paramString = ConversationDataFactory.a(paramString, (BaseQQAppInterface)paramAppInterface, paramAppInterface.getApp());
          break label1902;
          if (i == 1012)
          {
            paramString = (DatingProxyManager)paramAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
            if (paramString == null) {
              break label3108;
            }
            paramInt1 = paramString.a().a();
            paramString = paramString.a().a();
          }
          else if (i == 1030)
          {
            if (!((QQAppInterface)paramAppInterface).isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)) {
              break label3108;
            }
            paramString = (CampusNoticeManager)paramAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER);
            paramInt1 = paramString.a();
            paramString = paramString.a();
          }
          else
          {
            if (i != 9653) {
              break label3076;
            }
            paramString = (PullActiveManager)paramAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
            paramInt1 = paramString.a();
            paramString = paramString.a;
            break label1902;
            paramString = ((RecentUserProxy)localObject4).a((String)localObject2, i);
            if (paramString == null) {
              break label3108;
            }
            paramString.lastmsgtime = MessageCache.a();
            localObject1 = ConversationDataFactory.a(paramString, (QQAppInterface)paramAppInterface, paramAppInterface.getApp());
            paramString = (String)localObject1;
            if (i != 8) {
              break label3110;
            }
            localObject2 = ((QQAppInterface)paramAppInterface).getProxyManager().a().a((String)localObject2, i);
            paramString = (String)localObject1;
            if (localObject2 == null) {
              break label3110;
            }
            ((RecentBaseData)localObject1).mExtraType = ((QCallRecent)localObject2).extraType;
            ((RecentBaseData)localObject1).mPhoneNumber = ((QCallRecent)localObject2).phoneNumber;
            paramString = (String)localObject1;
            break label3110;
            if (!((QQAppInterface)paramAppInterface).isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)) {
              break label3108;
            }
            paramString = ((PushNoticeManager)paramAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a();
            paramInt1 = 1;
            break label1902;
            if (StudyModeManager.a()) {
              break label3108;
            }
            paramInt1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount((String)localObject2, i);
            if ((localObject3 == null) || (((MessageRecord)localObject3).senderuin == null)) {
              break label3103;
            }
            paramString = new RecentMatchChatListItem((MessageRecord)localObject3);
            paramString.update((BaseQQAppInterface)paramAppInterface, BaseApplication.getContext());
          }
          if ((paramInt1 > 0) && (paramString != null))
          {
            if ((((INewFriendApi)QRoute.api(INewFriendApi.class)).shouldMergeNewFriendContact(paramAppInterface, paramString.getRecentUserUin())) && (AppConstants.ACTIVATE_FRIENDS_UIN.equals(paramString.getRecentUserUin()))) {
              paramString.mTitleName = paramAppInterface.getApp().getString(2131689566);
            }
            localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (RecentBaseData)((Iterator)localObject1).next();
              if ((((INewFriendApi)QRoute.api(INewFriendApi.class)).shouldMergeNewFriendContact(paramAppInterface, ((RecentBaseData)localObject2).getRecentUserUin())) && (((INewFriendApi)QRoute.api(INewFriendApi.class)).shouldMergeNewFriendContact(paramAppInterface, paramString.getRecentUserUin())))
              {
                jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
                paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
                ((StringBuilder)localObject1).append(paramString.getRecentUserType());
                paramAppInterface.remove(((StringBuilder)localObject1).toString());
              }
              else if ((TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())) && (((RecentBaseData)localObject2).getRecentUserType() == paramString.getRecentUserType()))
              {
                jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
                paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
                ((StringBuilder)localObject1).append(paramString.getRecentUserType());
                paramAppInterface.remove(((StringBuilder)localObject1).toString());
              }
              else if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.LBS_HELLO_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
              {
                jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
                paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
                ((StringBuilder)localObject1).append(paramString.getRecentUserType());
                paramAppInterface.remove(((StringBuilder)localObject1).toString());
              }
              else if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.SCHEDULE_NOTIFY_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
              {
                jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
                paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
                ((StringBuilder)localObject1).append(paramString.getRecentUserType());
                paramAppInterface.remove(((StringBuilder)localObject1).toString());
              }
              else if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.DATE_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
              {
                jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
                paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
                ((StringBuilder)localObject1).append(paramString.getRecentUserType());
                paramAppInterface.remove(((StringBuilder)localObject1).toString());
              }
              else if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
              {
                jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
                paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
                ((StringBuilder)localObject1).append(paramString.getRecentUserType());
                paramAppInterface.remove(((StringBuilder)localObject1).toString());
              }
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
            if (paramBoolean2)
            {
              paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
              ((StringBuilder)localObject1).append(paramString.getRecentUserType());
              paramAppInterface.put(((StringBuilder)localObject1).toString(), Integer.valueOf(paramInt2));
            }
          }
          else if ((paramBoolean1) && (paramString != null) && (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
            if (paramBoolean2)
            {
              paramAppInterface = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString.getRecentUserUin());
              ((StringBuilder)localObject1).append(paramString.getRecentUserType());
              paramAppInterface.put(((StringBuilder)localObject1).toString(), Integer.valueOf(paramInt2));
            }
          }
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("QQLSRecentManager.updateLSRencentUser mDataList.size = ");
            paramAppInterface.append(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
            QLog.d("QQLSActivity", 2, paramAppInterface.toString());
          }
          return jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0;
        }
        else
        {
          return false;
        }
      }
      else
      {
        paramAppInterface = ConversationDataFactory.a(new RecentUser(paramString, paramInt1), (QQAppInterface)paramAppInterface, paramAppInterface.getApp());
        localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentBaseData)((Iterator)localObject1).next();
          if (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString))
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
            localObject3 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((RecentBaseData)localObject2).getRecentUserUin());
            ((StringBuilder)localObject4).append(((RecentBaseData)localObject2).getRecentUserType());
            ((ConcurrentHashMap)localObject3).remove(((StringBuilder)localObject4).toString());
          }
        }
        if (paramAppInterface != null)
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramAppInterface);
          if (paramBoolean2)
          {
            paramString = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramAppInterface.getRecentUserUin());
            ((StringBuilder)localObject1).append(paramAppInterface.getRecentUserType());
            paramString.put(((StringBuilder)localObject1).toString(), Integer.valueOf(paramInt2));
          }
        }
        return true;
      }
    }
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = jdField_c_of_type_Long;
    if ((l2 > 0L) && (l1 - l2 < 5000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "isNeedStart false ,less than 5sec");
      }
      return false;
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel())
      {
        paramObservable = new StringBuilder();
        paramObservable.append("QQLSRecentManager new friend update~~~~~ ");
        paramObservable.append(Thread.currentThread().getId());
        QLog.d("QQLSActivity", 2, paramObservable.toString());
      }
      if (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
        }
        return;
      }
      int i = ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
      paramObservable = (NewFriendMessage)paramObject;
      if (!TextUtils.isEmpty(paramObservable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if (paramObservable.a == 0L) {
          return;
        }
        if ((i != 0) && (!f))
        {
          boolean bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
          boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718400), "qqsetting_notify_showcontent_key", true);
          if ((Boolean.valueOf(bool1).booleanValue()) && (Boolean.valueOf(bool2).booleanValue())) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.RECOMMEND_CONTACT_UIN, 4000, false, MsgPushReportHelper.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000, null));
          }
        }
        else if (QLog.isColorLevel())
        {
          paramObservable = new StringBuilder();
          paramObservable.append("QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio");
          paramObservable.append(f);
          QLog.d("QQLSActivity", 2, paramObservable.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.QQLSRecentManager
 * JD-Core Version:    0.7.0.1
 */