package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
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
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
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
import com.tencent.util.QQKRPUtil;
import com.tencent.util.notification.NotificationController;
import cooperation.readinjoy.ReadInJoyHelper;
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
  public static int a;
  public static long a;
  public static String a;
  private static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static CopyOnWriteArrayList<RecentBaseData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public static boolean a;
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
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
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
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
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
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + d);
    }
    return d;
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getNotifyIDForUin mNotifyIdList.size = " + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localInteger != null) {}
      for (int i = localInteger.intValue();; i = -1)
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return i;
      }
    }
    return -1;
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
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    QQKRPUtil.a(paramQQAppInterface, paramMessageRecord);
    a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramBoolean, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but  app is null ,return");
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramQQAppInterface.isLogin()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
          return;
          if (((NotificationController)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).a(paramString, paramInt1)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "startQQLs but is Notification not permitted ,return");
        return;
      } while (jdField_a_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833"));
      bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, String.format("needStartQQLS frienduin[%s], uitype[%s], isFromMisscall[%s], isStartTime[%s]", new Object[] { paramString, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
    } while (!bool);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label687;
      }
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "locking activity:" + (String)localObject);
      }
      if ((!((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) && (!((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) && (!((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        break label649;
      }
      i = 1;
    }
    for (;;)
    {
      label270:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLSalive:" + jdField_b_of_type_Boolean);
      }
      if (paramInt1 == 1)
      {
        jdField_c_of_type_Boolean = true;
        label313:
        if (i != 0) {
          break label660;
        }
        if ((!PhoneStatusTools.e(BaseApplicationImpl.getApplication())) && ((!jdField_b_of_type_Boolean) || (paramBoolean)))
        {
          if ((!a(paramQQAppInterface, paramString, paramInt1, paramBoolean, paramInt2, true)) || (Build.VERSION.SDK_INT > 28)) {
            break label662;
          }
          localObject = new Intent(paramQQAppInterface.getApp(), QQLSActivity.class);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).addFlags(262144);
          ((Intent)localObject).putExtra("notifyId", paramInt2);
          ((Intent)localObject).putExtra("uitype", paramInt1);
          ((Intent)localObject).putExtra("frienduin", paramString);
          paramQQAppInterface.getApp().startActivity((Intent)localObject);
          e = true;
          jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel()) {
            QLog.d("qqls", 2, "need report  LS report needReport=" + g + "hasReport=" + h + "startTimes=" + jdField_b_of_type_Int);
          }
          if ((!h) && (jdField_b_of_type_Int > 2))
          {
            paramString = new HashMap();
            paramString.put("param_hasshowedLs", g + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
            if (QLog.isColorLevel()) {
              QLog.d("qqls", 2, "need report  LS report needReport=" + g);
            }
            h = true;
          }
        }
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label685;
        }
        QLog.d("QQLSActivity", 4, String.format("needStartQQLS end...", new Object[0]));
        return;
        label649:
        i = 0;
        break label270;
        jdField_c_of_type_Boolean = false;
        break label313;
        label660:
        break;
        label662:
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, String.format("needStartQQLS updateLSRencentUser fail...", new Object[0]));
        }
      }
      label685:
      break;
      label687:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      RecentBaseData localRecentBaseData;
      int j;
      int i;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentBaseData = (RecentBaseData)localIterator.next();
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        int k = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LBS_HELLO_UIN))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, localRecentBaseData.getRecentUserType());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
        }
      }
      if (localRecentBaseData.getRecentUserUin().equals(AppConstants.RECOMMEND_CONTACT_UIN))
      {
        i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
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
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
            i = j;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!, thread[" + Thread.currentThread().getId() + "], uin[" + paramString + "], uinType[" + paramInt1 + "], isFromMisscall[" + paramBoolean1);
      }
      localObject3 = paramQQAppInterface.getMessageFacade().b(paramString, paramInt1);
      if ((paramInt1 != 1001) || (MsgBoxUtil.b((MessageRecord)localObject3))) {
        break label2580;
      }
      paramString = AppConstants.NEARBY_LBS_HELLO_UIN;
      if ((!AppConstants.LOCK_SCREEN_DATE_UIN.equals(paramString)) && (!AppConstants.LOCK_SCREEN_LBS_HELLO_UIN.equals(paramString)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString))) {
        break label314;
      }
      paramQQAppInterface = ConversationDataFactory.a(new RecentUser(paramString, paramInt1), paramQQAppInterface, paramQQAppInterface.getApp());
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((RecentBaseData)localObject2).getRecentUserUin() + ((RecentBaseData)localObject2).getRecentUserType());
        }
      }
    }
    if (paramQQAppInterface != null)
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
      if (paramBoolean2) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQAppInterface.getRecentUserUin() + paramQQAppInterface.getRecentUserType(), Integer.valueOf(paramInt2));
      }
    }
    return true;
    label314:
    int i;
    label348:
    RecentUserProxy localRecentUserProxy;
    label538:
    boolean bool;
    label566:
    label600:
    label608:
    int j;
    if ((!ReadInJoyHelper.a(paramQQAppInterface)) && (paramInt1 == 7220) && (AppConstants.KANDIAN_MERGE_UIN.equals(paramString)))
    {
      localObject1 = AppConstants.NEW_KANDIAN_UIN;
      i = 1008;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
      }
      if ((FriendsStatusUtil.a((String)localObject1, paramQQAppInterface)) || (HiddenChatHelper.a((String)localObject1, i, paramQQAppInterface))) {
        return false;
      }
      if (TextUtils.equals((CharSequence)localObject1, AppConstants.TROOP_SUSPICIOUS_MSG_UIN))
      {
        QLog.e("QQLSActivity", 1, "已过滤群通知被过滤: " + QLog.getStackTraceString(new Throwable()));
        return false;
      }
      localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
      localObject2 = localRecentUserProxy.a(true, false).iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label2566;
        }
        paramString = (RecentUser)((Iterator)localObject2).next();
        if (paramString == null) {
          break label2566;
        }
        RecentBaseData localRecentBaseData;
        if (TextUtils.isEmpty(paramString.uin))
        {
          paramString = null;
          if (!QLog.isColorLevel()) {
            break label2583;
          }
          localObject2 = new StringBuilder().append("updateLSRencentUser curUser is not null: ");
          if (paramString == null) {
            break label2673;
          }
          bool = true;
          QLog.d("QQLSActivity", 2, bool + "threadId =" + Thread.currentThread().getId());
          break label2583;
          localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
          } while ((TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LOCK_SCREEN_DATE_UIN)) || (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)));
          paramInt1 = 0;
          if (!TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LBS_HELLO_UIN)) {
            break label1118;
          }
          paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, localRecentBaseData.getRecentUserType());
          label690:
          if ((localRecentBaseData.getRecentUserType() != 3000) && (localRecentBaseData.getRecentUserType() != 0))
          {
            j = localRecentBaseData.getRecentUserType();
            if (j != 8) {
              break label836;
            }
          }
        }
        try
        {
          localRecentBaseData.update(paramQQAppInterface, BaseApplication.getContext());
          if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
            break label2555;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          label758:
          if (!QLog.isColorLevel()) {
            break label2662;
          }
          Object localObject4 = localRecentBaseData.getRecentUserUin();
          int k = localRecentBaseData.getRecentUserType();
          if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
            break label2685;
          }
          bool = true;
          label788:
          QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject4, Integer.valueOf(k), Boolean.valueOf(bool) }));
          break label2662;
          label836:
          if (paramInt1 != 0) {
            break label608;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
          break label608;
          if ((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.getType() == i)) {
            break label538;
          }
          if ((paramString != null) && (paramString.getType() == i) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString.uin)))
          {
            paramString = new RecentUser((String)localObject1, i);
            break label538;
          }
          if (((paramString != null) && (paramString.getType() == i) && (AppConstants.LBS_HELLO_UIN.equals(paramString.uin))) || ((paramString != null) && (paramString.getType() == i) && (AppConstants.DATE_UIN.equals(paramString.uin)))) {
            break label538;
          }
          if ((paramString != null) && (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramString.uin)) && ((AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localObject1)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(localObject1)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(localObject1)))) {
            break label2670;
          }
          if ((paramString != null) && (paramString.getType() == 1032) && (UinTypeUtil.a(i) == 1032))
          {
            break label538;
            label1093:
            if (((QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)).c((String)localObject1, i) != 0) {
              break label600;
            }
            return false;
            label1118:
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN))
            {
              if (((String)localObject1).equals(AppConstants.FRIEND_SYSTEM_MSG_UIN))
              {
                paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, localRecentBaseData.getRecentUserType());
                break label690;
              }
              paramInt1 = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
              break label690;
            }
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.DATE_UIN))
            {
              paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.DATE_UIN, localRecentBaseData.getRecentUserType());
              break label690;
            }
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.VOTE_UIN))
            {
              localObject4 = (DatingProxyManager)paramQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
              if (localObject4 == null) {
                break label2561;
              }
              paramInt1 = ((DatingProxyManager)localObject4).a().a();
              break label2679;
            }
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.PULL_ACTIVE_PUSH_UIN))
            {
              localObject4 = (PullActiveManager)paramQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
              if (localObject4 == null) {
                break label2682;
              }
              paramInt1 = ((PullActiveManager)localObject4).a();
              break label2682;
            }
            paramInt1 = paramQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          }
        }
        catch (Throwable localThrowable)
        {
          while (SafeModeUtil.a(BaseApplicationImpl.sApplication)) {}
          throw new RuntimeException(localThrowable);
        }
      }
      j = 0;
      localObject2 = null;
      if (paramString == null) {
        break label2691;
      }
      if (paramString.uin.equals(AppConstants.LBS_HELLO_UIN))
      {
        paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, paramString.getType());
        paramString = ConversationDataFactory.a(paramString, paramQQAppInterface, paramQQAppInterface.getApp());
      }
      for (;;)
      {
        label1385:
        if ((paramInt1 <= 0) || (paramString == null)) {
          break label2460;
        }
        if ((NewFriendManager.a(paramQQAppInterface, paramString.getRecentUserUin())) && (AppConstants.ACTIVATE_FRIENDS_UIN.equals(paramString.getRecentUserUin()))) {
          paramString.mTitleName = paramQQAppInterface.getApp().getString(2131689539);
        }
        localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        label1439:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentBaseData)((Iterator)localObject1).next();
          if ((!NewFriendManager.a(paramQQAppInterface, ((RecentBaseData)localObject2).getRecentUserUin())) || (!NewFriendManager.a(paramQQAppInterface, paramString.getRecentUserUin()))) {
            break label2106;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
        }
        label1524:
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        if (paramBoolean2) {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getRecentUserUin() + paramString.getRecentUserType(), Integer.valueOf(paramInt2));
        }
        label1573:
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
          break label2546;
        }
        return true;
        if (paramString.uin.equals(AppConstants.RECOMMEND_CONTACT_UIN))
        {
          if (((String)localObject1).equals(AppConstants.FRIEND_SYSTEM_MSG_UIN))
          {
            paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, paramString.getType());
            break;
          }
          paramInt1 = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
          break;
        }
        if (paramString.uin.equals(AppConstants.DATE_UIN))
        {
          paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.DATE_UIN, paramString.getType());
          break;
        }
        paramInt1 = paramQQAppInterface.getConversationFacade().a(paramString.uin, paramString.getType());
        break;
        label1760:
        paramString = (String)localObject2;
        paramInt1 = j;
        if (!StudyModeManager.a())
        {
          i = paramQQAppInterface.getConversationFacade().a((String)localObject1, i);
          paramString = (String)localObject2;
          paramInt1 = i;
          if (localObject3 != null)
          {
            paramString = (String)localObject2;
            paramInt1 = i;
            if (((MessageRecord)localObject3).senderuin != null)
            {
              paramString = new RecentMatchChatListItem((MessageRecord)localObject3);
              paramString.update(paramQQAppInterface, BaseApplication.getContext());
              paramInt1 = i;
              continue;
              label1834:
              if (i == 1012)
              {
                paramString = (DatingProxyManager)paramQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                if (paramString == null) {
                  break label2548;
                }
                paramInt1 = paramString.a().a();
                paramString = paramString.a().a();
                break label2710;
              }
              if (i == 1030)
              {
                paramString = (String)localObject2;
                paramInt1 = j;
                if (paramQQAppInterface.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
                {
                  paramString = (CampusNoticeManager)paramQQAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER);
                  paramInt1 = paramString.a();
                  paramString = paramString.a();
                }
              }
              else
              {
                if (i != 9653) {
                  break label2713;
                }
                paramString = (PullActiveManager)paramQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                paramInt1 = paramString.a();
                paramString = paramString.a;
              }
            }
          }
        }
      }
    }
    label1956:
    label2106:
    label2546:
    label2548:
    label2679:
    label2682:
    for (;;)
    {
      paramString = (String)localObject2;
      paramInt1 = j;
      if (!paramQQAppInterface.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)) {
        break label1385;
      }
      paramString = (PushNoticeManager)paramQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER);
      paramInt1 = 1;
      paramString = paramString.a();
      break label1385;
      label2555:
      label2685:
      do
      {
        localObject3 = localRecentUserProxy.a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject3 == null) {
          break label1385;
        }
        ((RecentUser)localObject3).lastmsgtime = MessageCache.a();
        localObject2 = ConversationDataFactory.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.getApp());
        paramString = (String)localObject2;
        paramInt1 = j;
        if (i != 8) {
          break label1385;
        }
        localObject1 = paramQQAppInterface.getProxyManager().a().a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject1 == null) {
          break label1385;
        }
        ((RecentBaseData)localObject2).mExtraType = ((QCallRecent)localObject1).extraType;
        ((RecentBaseData)localObject2).mPhoneNumber = ((QCallRecent)localObject1).phoneNumber;
        paramString = (String)localObject2;
        paramInt1 = j;
        break label1385;
        if ((TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())) && (((RecentBaseData)localObject2).getRecentUserType() == paramString.getRecentUserType()))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1524;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.LBS_HELLO_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1524;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.SCHEDULE_NOTIFY_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1524;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.DATE_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1524;
        }
        if ((!TextUtils.equals(paramString.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN)) || (!TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin()))) {
          break label1439;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
        break label1524;
        if ((!paramBoolean1) || (paramString == null) || (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString))) {
          break label1573;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        if (!paramBoolean2) {
          break label1573;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getRecentUserUin() + paramString.getRecentUserType(), Integer.valueOf(paramInt2));
        break label1573;
        return false;
        paramString = null;
        paramInt1 = 0;
        break label2710;
        j = 0;
        break label758;
        paramInt1 = 0;
        break label2679;
        paramString = null;
        break label538;
        localObject1 = paramString;
        i = paramInt1;
        break label348;
        break;
        if ((paramString != null) || (i == 1012) || (i == 7432) || (i == 9653) || (i == 1030) || (i == 1035) || (i == 1041) || (i == 1042) || (i == 1044)) {
          break label600;
        }
        if (i != 1045) {
          break label1093;
        }
        break label600;
        if (j > 0) {
          break label608;
        }
        break label836;
        break label538;
        bool = false;
        break label566;
        break label690;
        break label690;
        bool = false;
        break label788;
        if (i == 1044) {
          break label1760;
        }
        if (i != 1045) {
          break label1834;
        }
        break label1760;
        break label1385;
        if ((i == 1035) || (i == 1041)) {
          break label1956;
        }
      } while (i != 1042);
    }
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis();
    if ((jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 5000L))
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
      }
    }
    label77:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
        } while ((TextUtils.isEmpty(((NewFriendMessage)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (((NewFriendMessage)paramObject).jdField_a_of_type_Long == 0L));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693883), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718682), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.RECOMMEND_CONTACT_UIN, 4000, false, MsgPushReportHelper.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.QQLSRecentManager
 * JD-Core Version:    0.7.0.1
 */