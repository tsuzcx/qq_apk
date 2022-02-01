package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.ChangeInfoPair;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.app.utils.ExtensionInfoLogUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData;
import com.tencent.mobileqq.mutualmark.info.MutualMarkInfo;
import com.tencent.mobileqq.mutualmark.info.MutualMarkPullInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;

public class MutualMarkDataS2CHandleHelper
{
  private static int a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    int k = 0;
    int i = -1;
    if (paramMutualMarkData.uint32_result.has()) {
      i = paramMutualMarkData.uint32_result.get();
    }
    int j = k;
    if (i == 0)
    {
      j = k;
      if (paramExtensionInfo != null)
      {
        ArrayList localArrayList = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramMutualMarkData = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramMutualMarkData.hasNext())
          {
            MutualMarkPullInfo localMutualMarkPullInfo = MutualMarkPullInfo.a((mutualmark.MutualMark)paramMutualMarkData.next());
            if (localMutualMarkPullInfo != null)
            {
              localArrayList.add(localMutualMarkPullInfo);
              if ((!TextUtils.isEmpty(localMutualMarkPullInfo.e)) && (!TextUtils.isEmpty(localMutualMarkPullInfo.f))) {
                MutualMarkManger.a(paramQQAppInterface).a(localMutualMarkPullInfo.e, localMutualMarkPullInfo.f);
              }
            }
          }
        }
        a(localArrayList, paramExtensionInfo);
        if (!localArrayList.isEmpty()) {
          QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " pullInfos:" + localArrayList);
        }
        j = 1;
      }
    }
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Add msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    if (paramMutualMarkData == null) {}
    String str;
    FriendsManager localFriendsManager;
    Object localObject2;
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = paramMutualMarkData.uint64_frd_uin.get();
      } while (l <= 0L);
      str = String.valueOf(l);
      localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = localFriendsManager.a(str);
      ExtensionInfoLogUtils.a("MutualMarkDataS2CHandleHelper", "handleGet0x5e0MutualMarkData before friendsManager.getExtensionInfo，friendUin:", (ExtensionInfo)localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localFriendsManager.e(str);
      i = a(paramQQAppInterface, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0))
      {
        ExtensionInfoLogUtils.a("MutualMarkDataS2CHandleHelper", "handleGet0x5e0MutualMarkData before save，friendUin:", (ExtensionInfo)localObject1);
        localFriendsManager.a((ExtensionInfo)localObject1);
      }
    } while ((localObject2 == null) || ((i & 0x2) == 0));
    localFriendsManager.a((Friends)localObject2);
    paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
  }
  
  private static boolean a(ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo paramRelationalChainPushInfo, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramRelationalChainPushInfo == null) || (paramExtensionInfo == null)) {}
    while (paramRelationalChainPushInfo.jdField_a_of_type_Int <= 0) {
      return false;
    }
    Object localObject = null;
    ExtensionMutualMarkData localExtensionMutualMarkData = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
    paramExtensionInfo = (ExtensionInfo)localObject;
    if (localExtensionMutualMarkData.a != null) {
      paramExtensionInfo = (MutualMarkInfo)localExtensionMutualMarkData.a.get(Long.valueOf(paramRelationalChainPushInfo.jdField_a_of_type_Int));
    }
    localObject = paramExtensionInfo;
    if (paramExtensionInfo == null) {
      localObject = new MutualMarkInfo();
    }
    boolean bool = ((MutualMarkInfo)localObject).a(paramRelationalChainPushInfo, paramLong);
    if (bool)
    {
      if (localExtensionMutualMarkData.a == null) {
        localExtensionMutualMarkData.a = new ConcurrentHashMap();
      }
      localExtensionMutualMarkData.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
    }
    return bool;
  }
  
  private static boolean a(ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramExtSnsRelationChainChangePushInfo != null)
    {
      if (paramExtensionInfo != null) {
        break label19;
      }
      bool2 = bool1;
    }
    label19:
    Object localObject;
    do
    {
      return bool2;
      localObject = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
      if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int != 2) {
        break;
      }
      bool2 = bool1;
    } while (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo == null);
    long l = paramExtSnsRelationChainChangePushInfo.a();
    if ((((ExtensionMutualMarkData)localObject).a != null) && (((ExtensionMutualMarkData)localObject).a.containsKey(Long.valueOf(l)))) {
      ((ExtensionMutualMarkData)localObject).a.remove(Long.valueOf(l));
    }
    for (bool1 = true;; bool1 = false)
    {
      return bool1;
      bool1 = bool3;
      if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
        bool1 = false | a(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo, paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
      if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject = paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ExtSnsRelationChainChangePushInfo.ChangeInfoPair localChangeInfoPair = (ExtSnsRelationChainChangePushInfo.ChangeInfoPair)((Iterator)localObject).next();
        if ((localChangeInfoPair != null) && (localChangeInfoPair.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)) {
          bool1 |= a(localChangeInfoPair.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo, paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int, paramExtensionInfo);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Oidb_0xd6b.MutualMarkData localMutualMarkData = new Oidb_0xd6b.MutualMarkData();
      try
      {
        localMutualMarkData.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localMutualMarkData;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramArrayOfByte = null;
          localException.printStackTrace();
        }
        i = a(paramQQAppInterface, paramExtensionInfo, paramString, paramArrayOfByte);
      }
      if (paramArrayOfByte != null) {}
    }
    for (;;)
    {
      return false;
      int i;
      while (i != 0)
      {
        return true;
        i = 0;
      }
    }
  }
  
  private static boolean a(ArrayList<MutualMarkPullInfo> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    ExtensionMutualMarkData localExtensionMutualMarkData = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MutualMarkPullInfo localMutualMarkPullInfo = (MutualMarkPullInfo)localIterator.next();
      if (localMutualMarkPullInfo != null)
      {
        paramArrayList = null;
        if (localExtensionMutualMarkData.a != null) {
          paramArrayList = (MutualMarkInfo)localExtensionMutualMarkData.a.get(Long.valueOf(localMutualMarkPullInfo.a));
        }
        paramExtensionInfo = paramArrayList;
        if (paramArrayList == null) {
          paramExtensionInfo = new MutualMarkInfo();
        }
        paramExtensionInfo.a(localMutualMarkPullInfo);
        localArrayList.add(paramExtensionInfo);
      }
    }
    if (localExtensionMutualMarkData.a == null) {
      localExtensionMutualMarkData.a = new ConcurrentHashMap();
    }
    if (!localExtensionMutualMarkData.a.isEmpty()) {
      localExtensionMutualMarkData.a.clear();
    }
    paramArrayList = localArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramExtensionInfo = (MutualMarkInfo)paramArrayList.next();
      if (paramExtensionInfo != null) {
        localExtensionMutualMarkData.a.put(Long.valueOf(paramExtensionInfo.a), paramExtensionInfo);
      }
    }
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Del msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, ExtensionInfo paramExtensionInfo)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int == 2)
    {
      if (!MutualMarkConfigHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.a())) {}
    }
    else {
      do
      {
        return true;
        if ((paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int != 10003) && (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int != 11001)) {
          break;
        }
      } while (MutualMarkConfigHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.a()));
    }
    while (!MutualMarkConfigHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.a(), paramExtSnsRelationChainChangePushInfo.d())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Modify msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Recover msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramPushMsg0x210C7Info);
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramPushMsg0x210C7Info);
    if (!MutualMarkUtils.a(paramQQAppInterface)) {
      MutualMarkGrayTipsHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (!a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo, paramExtensionInfo)) {
      QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushCommonUpdate not enable update");
    }
    while (!a(paramExtSnsRelationChainChangePushInfo, paramExtensionInfo)) {
      return;
    }
    if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int == 1) {
      MutualMarkDataCenter.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo.a());
    }
    ExtensionInfoLogUtils.a("MutualMarkDataS2CHandleHelper", "handleMutualMarkDataPushCommonUpdate before save，friendUin:", paramExtensionInfo);
    paramFriendsManager.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramExtSnsRelationChainChangePushInfo.b())) && (!TextUtils.isEmpty(paramExtSnsRelationChainChangePushInfo.c()))) {
      MutualMarkManger.a(paramQQAppInterface).a(paramExtSnsRelationChainChangePushInfo.b(), paramExtSnsRelationChainChangePushInfo.c());
    }
    if ((b(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo, paramExtensionInfo)) && (!MutualMarkUtils.a(paramQQAppInterface))) {
      MutualMarkGrayTipsHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
    for (;;)
    {
      paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
      return;
      QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper
 * JD-Core Version:    0.7.0.1
 */