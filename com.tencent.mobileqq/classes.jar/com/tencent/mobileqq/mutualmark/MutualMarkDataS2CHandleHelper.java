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
import org.jetbrains.annotations.NotNull;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;

public class MutualMarkDataS2CHandleHelper
{
  private static int a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    int i;
    if (paramMutualMarkData.uint32_result.has()) {
      i = paramMutualMarkData.uint32_result.get();
    } else {
      i = -1;
    }
    int k = 0;
    int j = k;
    if (i == 0)
    {
      j = k;
      if (paramExtensionInfo != null) {
        j = a(paramQQAppInterface, paramExtensionInfo, paramString, paramMutualMarkData, 0);
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handleMutualMarkData friendUin:");
    paramQQAppInterface.append(paramString);
    paramQQAppInterface.append(" changeType:");
    paramQQAppInterface.append(j);
    paramQQAppInterface.append(" retCode:");
    paramQQAppInterface.append(i);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, paramQQAppInterface.toString());
    return j;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData, int paramInt)
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
          if ((!TextUtils.isEmpty(localMutualMarkPullInfo.n)) && (!TextUtils.isEmpty(localMutualMarkPullInfo.o))) {
            MutualMarkManger.a(paramQQAppInterface).a(localMutualMarkPullInfo.n, localMutualMarkPullInfo.o);
          }
        }
      }
    }
    a(localArrayList, paramExtensionInfo);
    if (!localArrayList.isEmpty())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleMutualMarkData friendUin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(" pullInfos:");
      paramQQAppInterface.append(localArrayList);
      QLog.i("MutualMarkDataS2CHandleHelper", 1, paramQQAppInterface.toString());
    }
    return paramInt | 0x1;
  }
  
  @NotNull
  private static MutualMarkInfo a(ExtensionMutualMarkData paramExtensionMutualMarkData, MutualMarkPullInfo paramMutualMarkPullInfo, MutualMarkInfo paramMutualMarkInfo)
  {
    if (paramExtensionMutualMarkData.a != null) {
      paramMutualMarkInfo = (MutualMarkInfo)paramExtensionMutualMarkData.a.get(Long.valueOf(paramMutualMarkPullInfo.a));
    }
    paramExtensionMutualMarkData = paramMutualMarkInfo;
    if (paramMutualMarkInfo == null) {
      paramExtensionMutualMarkData = new MutualMarkInfo();
    }
    return paramExtensionMutualMarkData;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Add msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    if (paramMutualMarkData == null) {
      return;
    }
    long l = paramMutualMarkData.uint64_frd_uin.get();
    if (l <= 0L) {
      return;
    }
    String str = String.valueOf(l);
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = localFriendsManager.x(str);
    ExtensionInfoLogUtils.a("MutualMarkDataS2CHandleHelper", "handleGet0x5e0MutualMarkData before friendsManager.getExtensionInfo，friendUin:", (ExtensionInfo)localObject2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = str;
    }
    localObject2 = localFriendsManager.m(str);
    int i = a(paramQQAppInterface, (ExtensionInfo)localObject1, str, paramMutualMarkData);
    if ((localObject1 != null) && ((i & 0x1) != 0))
    {
      ExtensionInfoLogUtils.a("MutualMarkDataS2CHandleHelper", "handleGet0x5e0MutualMarkData before save，friendUin:", (ExtensionInfo)localObject1);
      localFriendsManager.a((ExtensionInfo)localObject1);
    }
    if ((localObject2 != null) && ((i & 0x2) != 0))
    {
      localFriendsManager.b((Friends)localObject2);
      paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
    }
  }
  
  private static boolean a(ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo paramRelationalChainPushInfo, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRelationalChainPushInfo != null)
    {
      if (paramExtensionInfo == null) {
        return false;
      }
      bool1 = bool2;
      if (paramRelationalChainPushInfo.a > 0)
      {
        Object localObject = null;
        ExtensionMutualMarkData localExtensionMutualMarkData = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
        paramExtensionInfo = (ExtensionInfo)localObject;
        if (localExtensionMutualMarkData.a != null) {
          paramExtensionInfo = (MutualMarkInfo)localExtensionMutualMarkData.a.get(Long.valueOf(paramRelationalChainPushInfo.a));
        }
        localObject = paramExtensionInfo;
        if (paramExtensionInfo == null) {
          localObject = new MutualMarkInfo();
        }
        bool2 = ((MutualMarkInfo)localObject).a(paramRelationalChainPushInfo, paramLong);
        bool1 = bool2;
        if (bool2)
        {
          if (localExtensionMutualMarkData.a == null) {
            localExtensionMutualMarkData.a = new ConcurrentHashMap();
          }
          localExtensionMutualMarkData.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, ExtensionInfo paramExtensionInfo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramExtSnsRelationChainChangePushInfo != null)
    {
      if (paramExtensionInfo == null) {
        return false;
      }
      Object localObject = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
      if (paramExtSnsRelationChainChangePushInfo.c == 2) {
        return a(paramExtSnsRelationChainChangePushInfo, false, (ExtensionMutualMarkData)localObject);
      }
      if (paramExtSnsRelationChainChangePushInfo.f != null) {
        bool1 = false | a(paramExtSnsRelationChainChangePushInfo.f, paramExtSnsRelationChainChangePushInfo.c, paramExtensionInfo);
      }
      bool2 = bool1;
      if (paramExtSnsRelationChainChangePushInfo.g != null)
      {
        localObject = paramExtSnsRelationChainChangePushInfo.g.iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ExtSnsRelationChainChangePushInfo.ChangeInfoPair localChangeInfoPair = (ExtSnsRelationChainChangePushInfo.ChangeInfoPair)((Iterator)localObject).next();
          if ((localChangeInfoPair != null) && (localChangeInfoPair.b != null)) {
            bool1 |= a(localChangeInfoPair.b, paramExtSnsRelationChainChangePushInfo.c, paramExtensionInfo);
          }
        }
      }
    }
    return bool2;
  }
  
  private static boolean a(ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, boolean paramBoolean, ExtensionMutualMarkData paramExtensionMutualMarkData)
  {
    boolean bool = paramBoolean;
    if (paramExtSnsRelationChainChangePushInfo.e != null)
    {
      long l = paramExtSnsRelationChainChangePushInfo.b();
      bool = paramBoolean;
      if (paramExtensionMutualMarkData.a != null)
      {
        bool = paramBoolean;
        if (paramExtensionMutualMarkData.a.containsKey(Long.valueOf(l)))
        {
          paramExtensionMutualMarkData.a.remove(Long.valueOf(l));
          bool = true;
        }
      }
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    int i;
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
        paramArrayOfByte = null;
        localException.printStackTrace();
      }
      if (paramArrayOfByte == null) {
        return false;
      }
      i = a(paramQQAppInterface, paramExtensionInfo, paramString, paramArrayOfByte);
    }
    else
    {
      i = 0;
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean a(ArrayList<MutualMarkPullInfo> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if (paramArrayList != null)
    {
      if (paramExtensionInfo == null) {
        return false;
      }
      Object localObject = new ArrayList();
      paramExtensionInfo = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MutualMarkPullInfo localMutualMarkPullInfo = (MutualMarkPullInfo)paramArrayList.next();
        if (localMutualMarkPullInfo != null)
        {
          MutualMarkInfo localMutualMarkInfo = a(paramExtensionInfo, localMutualMarkPullInfo, null);
          localMutualMarkInfo.a(localMutualMarkPullInfo);
          ((ArrayList)localObject).add(localMutualMarkInfo);
        }
      }
      if (paramExtensionInfo.a == null) {
        paramExtensionInfo.a = new ConcurrentHashMap();
      }
      if (!paramExtensionInfo.a.isEmpty()) {
        paramExtensionInfo.a.clear();
      }
      paramArrayList = ((ArrayList)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (MutualMarkInfo)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.a.put(Long.valueOf(((MutualMarkInfo)localObject).a), localObject);
        }
      }
      return true;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Del msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, ExtensionInfo paramExtensionInfo)
  {
    if (paramExtSnsRelationChainChangePushInfo.c == 2)
    {
      if (MutualMarkConfigHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b())) {
        return true;
      }
    }
    else if ((paramExtSnsRelationChainChangePushInfo.c != 10003) && (paramExtSnsRelationChainChangePushInfo.c != 11001))
    {
      if (MutualMarkConfigHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b(), paramExtSnsRelationChainChangePushInfo.j())) {
        return true;
      }
    }
    else if (MutualMarkConfigHelper.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b())) {
      return true;
    }
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Modify msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Downgrade_Soon msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Egalitarian_Soon msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Downgrade msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Upgrade msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Recover msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Icon_Light msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Icon_Extinguish msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMutualMarkDataPushType_Icon_Twinkle msginfo:");
    localStringBuilder.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, localStringBuilder.toString());
    m(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    paramFriendsManager = new StringBuilder();
    paramFriendsManager.append("handleMutualMarkDataPushType_GrayTipChannel msginfo:");
    paramFriendsManager.append(paramPushMsg0x210C7Info);
    QLog.i("MutualMarkDataS2CHandleHelper", 1, paramFriendsManager.toString());
    if (!MutualMarkUtils.a(paramQQAppInterface)) {
      MutualMarkGrayTipsHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (!a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo, paramExtensionInfo))
    {
      QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushCommonUpdate not enable update");
      return;
    }
    if (a(paramExtSnsRelationChainChangePushInfo, paramExtensionInfo))
    {
      if (paramExtSnsRelationChainChangePushInfo.c == 1) {
        MutualMarkDataCenter.a(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo.b, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo.b());
      }
      ExtensionInfoLogUtils.a("MutualMarkDataS2CHandleHelper", "handleMutualMarkDataPushCommonUpdate before save，friendUin:", paramExtensionInfo);
      paramFriendsManager.a(paramExtensionInfo);
      if ((!TextUtils.isEmpty(paramExtSnsRelationChainChangePushInfo.f())) && (!TextUtils.isEmpty(paramExtSnsRelationChainChangePushInfo.g()))) {
        MutualMarkManger.a(paramQQAppInterface).a(paramExtSnsRelationChainChangePushInfo.f(), paramExtSnsRelationChainChangePushInfo.g());
      }
      if ((b(paramQQAppInterface, paramExtSnsRelationChainChangePushInfo, paramExtensionInfo)) && (!MutualMarkUtils.a(paramQQAppInterface))) {
        MutualMarkGrayTipsHelper.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      } else {
        QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
      paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramExtSnsRelationChainChangePushInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper
 * JD-Core Version:    0.7.0.1
 */