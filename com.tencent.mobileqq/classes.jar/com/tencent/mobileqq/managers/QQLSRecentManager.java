package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class QQLSRecentManager
  implements Observer, Manager
{
  public static int a;
  public static long a;
  public static String a;
  private static CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public static boolean a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static int b;
  public static long b;
  public static volatile boolean b;
  public static long c;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g = true;
  public static boolean h;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_Long = -1L;
  }
  
  public QQLSRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_JavaLangString = AppSetting.b;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      d = true;
      return d;
    }
    d = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lock_screen.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + d);
    }
    return d;
  }
  
  public CopyOnWriteArrayList a()
  {
    return jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mDataList clear");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
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
          return;
          if (paramQQAppInterface.isLogin()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
        return;
      } while (jdField_a_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833"));
      bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, String.format("needStartQQLS frienduin[%s], uitype[%s], isFromMisscall[%s], isStartTime[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
    } while (!bool);
    int i;
    if (!paramBoolean)
    {
      Object localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label597;
      }
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "locking activity:" + (String)localObject);
      }
      if ((!((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) && (!((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) && (!((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        break label559;
      }
      i = 1;
    }
    for (;;)
    {
      label232:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLSalive:" + jdField_b_of_type_Boolean);
      }
      if (paramInt == 1)
      {
        jdField_c_of_type_Boolean = true;
        label274:
        if (i != 0) {
          break label570;
        }
        if ((!PhoneStatusTools.d(BaseApplicationImpl.getApplication())) && ((!jdField_b_of_type_Boolean) || (paramBoolean)))
        {
          if (!a(paramQQAppInterface, paramString, paramInt, paramBoolean)) {
            break label572;
          }
          paramString = new Intent(paramQQAppInterface.getApp(), QQLSActivity.class);
          paramString.addFlags(67108864);
          paramString.addFlags(268435456);
          paramString.addFlags(262144);
          paramQQAppInterface.getApp().startActivity(paramString);
          e = true;
          jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel()) {
            QLog.d("qqls", 2, "need report  LS report needReport=" + g + "hasReport=" + h + "startTimes=" + jdField_b_of_type_Int);
          }
          if ((!h) && (jdField_b_of_type_Int > 2))
          {
            paramString = new HashMap();
            paramString.put("param_hasshowedLs", g + "");
            StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
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
          break label595;
        }
        QLog.d("QQLSActivity", 4, String.format("needStartQQLS end...", new Object[0]));
        return;
        label559:
        i = 0;
        break label232;
        jdField_c_of_type_Boolean = false;
        break label274;
        label570:
        break;
        label572:
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, String.format("needStartQQLS updateLSRencentUser fail...", new Object[0]));
        }
      }
      label595:
      break;
      label597:
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
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
        int k = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(localRecentBaseData.a(), localRecentBaseData.a());
        if (localRecentBaseData.a().equals(AppConstants.G))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.G, localRecentBaseData.a());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
        }
      }
      if (localRecentBaseData.a().equals(AppConstants.C))
      {
        i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).d();
      }
      else if (localRecentBaseData.a().equals(AppConstants.X))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.X, localRecentBaseData.a());
      }
      else
      {
        i = j;
        if (localRecentBaseData.a().equals(paramString))
        {
          i = j;
          if (paramInt == localRecentBaseData.a())
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            i = j;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!, thread[" + Thread.currentThread().getId() + "], uin[" + paramString + "], uinType[" + paramInt + "], isFromMisscall[" + paramBoolean);
      }
      if ((!AppConstants.ad.equals(paramString)) && (!AppConstants.ac.equals(paramString))) {
        break label214;
      }
      localObject1 = new RecentUser();
      ((RecentUser)localObject1).uin = paramString;
      ((RecentUser)localObject1).type = paramInt;
      paramQQAppInterface = ConversationDataFactory.a((RecentUser)localObject1, paramQQAppInterface, paramQQAppInterface.getApp());
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (((RecentBaseData)localObject2).a().equals(paramString)) {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        }
      }
    }
    if (paramQQAppInterface != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
    }
    return true;
    label214:
    Object localObject1 = paramString;
    int i = paramInt;
    if (!ReadInJoyHelper.a(paramQQAppInterface))
    {
      localObject1 = paramString;
      i = paramInt;
      if (paramInt == 7220)
      {
        localObject1 = paramString;
        i = paramInt;
        if (AppConstants.as.equals(paramString))
        {
          localObject1 = AppConstants.ar;
          i = 1008;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
    }
    Object localObject3 = paramQQAppInterface.a().a();
    Object localObject2 = ((RecentUserProxy)localObject3).a(true, false).iterator();
    label381:
    int j;
    label389:
    label471:
    boolean bool;
    if (((Iterator)localObject2).hasNext())
    {
      paramString = (RecentUser)((Iterator)localObject2).next();
      if (paramString != null)
      {
        RecentBaseData localRecentBaseData;
        if (TextUtils.isEmpty(paramString.uin))
        {
          paramString = null;
          break label1913;
          break label845;
          localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
          } while ((localRecentBaseData.a().equals(AppConstants.ad)) || (localRecentBaseData.a().equals(AppConstants.ac)));
          paramInt = 0;
          if (!localRecentBaseData.a().equals(AppConstants.G)) {
            break label869;
          }
          paramInt = paramQQAppInterface.a().a(AppConstants.G, localRecentBaseData.a());
        }
        for (;;)
        {
          label535:
          Object localObject4;
          if ((localRecentBaseData.a() == 3000) || (localRecentBaseData.a() == 0) || (localRecentBaseData.a() == 8))
          {
            localRecentBaseData.a(paramQQAppInterface, BaseApplication.getContext());
            if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
              break label1900;
            }
            j = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(localRecentBaseData.a(), localRecentBaseData.a());
            if (!QLog.isColorLevel()) {
              break label1952;
            }
            localObject4 = localRecentBaseData.a();
            int k = localRecentBaseData.a();
            if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
              break label1969;
            }
            bool = true;
            label565:
            QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject4, Integer.valueOf(k), Boolean.valueOf(bool) }));
            break label1952;
          }
          label613:
          if (paramInt != 0) {
            break label1958;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          break label389;
          if ((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.type == i)) {
            break label1913;
          }
          if ((paramString != null) && (paramString.type == i) && (AppConstants.w.equals(paramString.uin)))
          {
            paramString = new RecentUser();
            paramString.uin = ((String)localObject1);
            paramString.type = i;
            break label1913;
          }
          if (((paramString != null) && (paramString.type == i) && (AppConstants.G.equals(paramString.uin))) || ((paramString != null) && (paramString.type == i) && (AppConstants.X.equals(paramString.uin)))) {
            break label1913;
          }
          if ((paramString != null) && (AppConstants.C.equals(paramString.uin)) && ((AppConstants.K.equals(localObject1)) || (AppConstants.ap.equals(localObject1)) || (AppConstants.aw.equals(localObject1)))) {
            break label1960;
          }
          if ((paramString == null) || (paramString.type != 1032) || (MsgProxyUtils.a(i) != 1032)) {
            break;
          }
          break label1913;
          label845:
          if (((QCallFacade)paramQQAppInterface.getManager(37)).c((String)localObject1, i) != 0) {
            break label381;
          }
          return false;
          label869:
          if (localRecentBaseData.a().equals(AppConstants.C))
          {
            if (((String)localObject1).equals(AppConstants.K)) {
              paramInt = paramQQAppInterface.a().a(AppConstants.K, localRecentBaseData.a());
            } else {
              paramInt = ((NewFriendManager)paramQQAppInterface.getManager(33)).d();
            }
          }
          else if (localRecentBaseData.a().equals(AppConstants.X))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.X, localRecentBaseData.a());
          }
          else
          {
            if (localRecentBaseData.a().equals(AppConstants.ab))
            {
              localObject4 = (DatingProxyManager)paramQQAppInterface.getManager(70);
              if (localObject4 == null) {
                break label1906;
              }
              paramInt = ((DatingProxyManager)localObject4).a().a();
              break label1963;
            }
            if (localRecentBaseData.a().equals(AppConstants.ao))
            {
              localObject4 = (PullActiveManager)paramQQAppInterface.getManager(144);
              if (localObject4 == null) {
                break label1966;
              }
              paramInt = ((PullActiveManager)localObject4).a();
              break label1966;
            }
            paramInt = paramQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
          }
        }
        j = 0;
        localObject2 = null;
        if (paramString != null) {
          if (paramString.uin.equals(AppConstants.G))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.G, paramString.type);
            paramString = ConversationDataFactory.a(paramString, paramQQAppInterface, paramQQAppInterface.getApp());
          }
        }
      }
    }
    label1167:
    label1952:
    label1958:
    label1960:
    label1961:
    label1963:
    label1966:
    label1969:
    label1975:
    for (;;)
    {
      label1113:
      if ((paramInt > 0) && (paramString != null))
      {
        if ((NewFriendManager.a(paramQQAppInterface, paramString.a())) && (AppConstants.Z.equals(paramString.a()))) {
          paramString.b = paramQQAppInterface.getApp().getString(2131437235);
        }
        localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentBaseData)((Iterator)localObject1).next();
          if ((NewFriendManager.a(paramQQAppInterface, ((RecentBaseData)localObject2).a())) && (NewFriendManager.a(paramQQAppInterface, paramString.a()))) {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          }
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        }
      }
      for (;;)
      {
        label1221:
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
          break label1891;
        }
        return true;
        if (paramString.uin.equals(AppConstants.C))
        {
          if (((String)localObject1).equals(AppConstants.K))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.K, paramString.type);
            break;
          }
          paramInt = ((NewFriendManager)paramQQAppInterface.getManager(33)).d();
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
          break;
        }
        if (paramString.uin.equals(AppConstants.X))
        {
          paramInt = paramQQAppInterface.a().a(AppConstants.X, paramString.type);
          break;
        }
        paramInt = paramQQAppInterface.a().a(paramString.uin, paramString.type);
        break;
        if (i == 1012)
        {
          paramString = (DatingProxyManager)paramQQAppInterface.getManager(70);
          if (paramString == null) {
            break label1893;
          }
          paramInt = paramString.a().a();
          paramString = paramString.a().a();
          break label1975;
        }
        if (i == 1030)
        {
          paramString = (String)localObject2;
          paramInt = j;
          if (!paramQQAppInterface.a(239)) {
            break label1113;
          }
          paramString = (CampusNoticeManager)paramQQAppInterface.getManager(239);
          paramInt = paramString.a();
          paramString = paramString.a();
          break label1113;
        }
        if (i == 9653)
        {
          paramString = (PullActiveManager)paramQQAppInterface.getManager(144);
          paramInt = paramString.a();
          paramString = paramString.a;
          break label1113;
        }
        localObject3 = ((RecentUserProxy)localObject3).a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt = j;
        if (localObject3 == null) {
          break label1113;
        }
        ((RecentUser)localObject3).lastmsgtime = MessageCache.a();
        localObject2 = ConversationDataFactory.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.getApp());
        paramString = (String)localObject2;
        paramInt = j;
        if (i != 8) {
          break label1113;
        }
        localObject1 = paramQQAppInterface.a().a().a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt = j;
        if (localObject1 == null) {
          break label1113;
        }
        ((RecentBaseData)localObject2).g = ((QCallRecent)localObject1).extraType;
        ((RecentBaseData)localObject2).f = ((QCallRecent)localObject1).phoneNumber;
        paramString = (String)localObject2;
        paramInt = j;
        break label1113;
        if ((((RecentBaseData)localObject2).a().equals(paramString.a())) && (((RecentBaseData)localObject2).a() == paramString.a()))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1221;
        }
        if ((paramString.a().equals(AppConstants.G)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1221;
        }
        if ((paramString.a().equals(AppConstants.ai)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1221;
        }
        if ((paramString.a().equals(AppConstants.X)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          break label1221;
        }
        if ((!paramString.a().equals(AppConstants.C)) || (!((RecentBaseData)localObject2).a().equals(paramString.a()))) {
          break label1167;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        break label1221;
        if ((paramBoolean) && (paramString != null) && (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        }
      }
      label1891:
      return false;
      label1893:
      paramString = null;
      paramInt = 0;
      break label1975;
      label1900:
      j = 0;
      break label535;
      label1906:
      paramInt = 0;
      break label1963;
      paramString = null;
      for (;;)
      {
        label1913:
        if ((paramString != null) || (i == 1012) || (i == 7432) || (i == 9653)) {
          break label1961;
        }
        if (i != 1030) {
          break;
        }
        break label381;
        if (j > 0) {
          break label389;
        }
        break label613;
        break label389;
      }
      break label381;
      break label471;
      break label471;
      bool = false;
      break label565;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
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
          i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).d();
        } while ((TextUtils.isEmpty(((NewFriendMessage)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (((NewFriendMessage)paramObject).a == 0L));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435404), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131434202), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.C, 4000, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.QQLSRecentManager
 * JD-Core Version:    0.7.0.1
 */