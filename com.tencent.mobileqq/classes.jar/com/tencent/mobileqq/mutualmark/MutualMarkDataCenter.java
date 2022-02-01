package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper;
import com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.info.MutualMarkInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView.IconDrawableInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class MutualMarkDataCenter
{
  static Comparator<MutualMarkForDisplayInfo> a = new MutualMarkDataCenter.1();
  
  public static MutualMarkForDisplayInfo a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        return null;
      }
      if (((FriendsManager)localObject).a(false))
      {
        QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo disableReactive: true , mutualmark switch is close");
        return null;
      }
      if (!((FriendsManager)localObject).o(paramString))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getMutualMarkDisplayInfo fm.isFriendJustInCache: ");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(" == false");
        QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
        return null;
      }
      localObject = ((FriendsManager)localObject).d(paramString, paramBoolean);
      if (localObject == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getMutualMarkDisplayInfo extensionInfo == null, queryDBIfNotInCache == ");
        paramQQAppInterface.append(paramBoolean);
        QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
        return null;
      }
      paramQQAppInterface = b(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface;
      }
    }
    return null;
  }
  
  public static MutualMarkForDisplayInfo a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        return null;
      }
      if (((FriendsManager)localObject).a(false))
      {
        QLog.i("MutualMarkDataCenter", 1, "getIntimateMutualMarkDisplayInfo disableReactive: true , mutualmark switch is close");
        return null;
      }
      if (!((FriendsManager)localObject).o(paramString))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getIntimateMutualMarkDisplayInfo fm.isFriendJustInCache: ");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(" == false");
        QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
        return null;
      }
      localObject = ((FriendsManager)localObject).d(paramString, paramBoolean);
      if (localObject == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getIntimateMutualMarkDisplayInfo extensionInfo == null, queryDBIfNotInCache == ");
        paramQQAppInterface.append(paramBoolean);
        QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
        return null;
      }
      return IntimateUtil.a(paramQQAppInterface, paramString, (ExtensionInfo)localObject);
    }
    return null;
  }
  
  public static Pair<MutualMarkForDisplayInfo, MutualMarkForDisplayInfo> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = a(paramQQAppInterface, paramString, false, 1);
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject4 = ((ArrayList)localObject1).iterator();
      localObject1 = null;
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (MutualMarkForDisplayInfo)((Iterator)localObject4).next();
        if (!((MutualMarkForDisplayInfo)localObject3).m)
        {
          if ((localObject2 == null) || (((MutualMarkForDisplayInfo)localObject3).n < localObject2.n)) {
            localObject2 = localObject3;
          }
        }
        else if ((localObject1 == null) || (((MutualMarkForDisplayInfo)localObject3).n < ((MutualMarkForDisplayInfo)localObject1).n)) {
          localObject1 = localObject3;
        }
      }
      if ((localObject2 != null) && (TextUtils.isEmpty(localObject2.r))) {
        RelationVipHelper.a().a(paramQQAppInterface, paramString, localObject2);
      }
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (TextUtils.isEmpty(((MutualMarkForDisplayInfo)localObject1).r))
        {
          RelationVipHelper.a().a(paramQQAppInterface, paramString, (MutualMarkForDisplayInfo)localObject1);
          localObject4 = localObject2;
          localObject3 = localObject1;
        }
      }
    }
    else
    {
      localObject3 = null;
    }
    return new Pair(localObject4, localObject3);
  }
  
  public static ArrayList<SingleLineTextView.IconDrawableInfo> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<MutualMarkForDisplayInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        paramArrayList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramArrayList = (MutualMarkForDisplayInfo)localIterator.next();
        SingleLineTextView.IconDrawableInfo localIconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
        localIconDrawableInfo.iconResId = paramArrayList.q;
        localIconDrawableInfo.icon_static_url = paramArrayList.s;
        if (TextUtils.isEmpty(paramArrayList.r)) {
          RelationVipHelper.a().a(paramQQAppInterface, paramString, paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.r)) {
          localIconDrawableInfo.iconDynamicUrl = paramArrayList.r;
        }
        localIconDrawableInfo.icon_status_alpha = paramArrayList.d();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecentListIconDrawableInfos friendUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" info:");
        localStringBuilder.append(paramArrayList.toString());
        QLog.i("MutualMarkDataCenter", 1, localStringBuilder.toString());
        localArrayList.add(localIconDrawableInfo);
      }
    }
    QLog.i("MutualMarkDataCenter", 1, "getRecentListIconDrawableInfos mutualMarkInfos: null");
    paramArrayList = null;
    return paramArrayList;
  }
  
  public static ArrayList<MutualMarkForDisplayInfo> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 == null) {
      return null;
    }
    boolean bool;
    if ((paramInt != 2) && (paramInt != 1)) {
      bool = ((FriendsManager)localObject1).a(false);
    } else {
      bool = ((FriendsManager)localObject1).a(true);
    }
    if (bool)
    {
      QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks disableReactive: true , mutualmark switch is close");
      return null;
    }
    if (!((FriendsManager)localObject1).o(paramString))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFriendMutualMarks fm.isFriendJustInCache: ");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(" == false");
      QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
      return null;
    }
    ExtensionInfo localExtensionInfo = ((FriendsManager)localObject1).d(paramString, paramBoolean);
    if (localExtensionInfo == null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFriendMutualMarks extensionInfo == null, queryDBIfNotInCache == ");
      paramQQAppInterface.append(paramBoolean);
      QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
      return null;
    }
    localObject1 = new ArrayList();
    Object localObject2 = MutualMarkConfProcessor.a();
    if ((((MutualMarkConfBean)localObject2).f != null) && (((MutualMarkConfBean)localObject2).f.keySet().size() > 0)) {
      localObject2 = ((MutualMarkConfBean)localObject2).f.keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      long l = ((Long)((Iterator)localObject2).next()).longValue();
      Object localObject3 = b(paramQQAppInterface, paramString, localExtensionInfo, l);
      if (localObject3 != null)
      {
        ((ArrayList)localObject1).add(localObject3);
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getFriendMutualMarks friendUin:");
        ((StringBuilder)localObject3).append(MobileQQ.getShortUinStr(paramString));
        ((StringBuilder)localObject3).append(", mutualMarkType: ");
        ((StringBuilder)localObject3).append(l);
        ((StringBuilder)localObject3).append(", extensionInfo");
        ((StringBuilder)localObject3).append(localExtensionInfo);
        QLog.i("MutualMarkDataCenter", 1, ((StringBuilder)localObject3).toString());
        continue;
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getFriendMutualMarks friendUin:");
        paramQQAppInterface.append(MobileQQ.getShortUinStr(paramString));
        paramQQAppInterface.append(", MutualMarkConfBean:");
        paramQQAppInterface.append(localObject2);
        QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("getFriendMutualMarks friendUin:");
    paramQQAppInterface.append(paramString);
    paramQQAppInterface.append(", displayInfos:");
    paramQQAppInterface.append(localObject1);
    QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
    if (((ArrayList)localObject1).isEmpty()) {
      return localObject1;
    }
    if (paramInt != 1) {
      Collections.sort((List)localObject1, a);
    }
    return localObject1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramExtensionInfo == null) {
        return;
      }
      if (d(paramQQAppInterface, paramString, paramExtensionInfo, paramLong) != null)
      {
        Object localObject = MutualMarkConfProcessor.a().c(paramLong);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            c(paramQQAppInterface, paramString, paramExtensionInfo, ((MutualMarkConfigIRType)((Iterator)localObject).next()).a);
          }
        }
      }
    }
  }
  
  public static void a(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo != null)
    {
      if (paramMutualMarkForDisplayInfo == null) {
        return;
      }
      if (MutualMarkUtils.c(paramMutualMarkForDisplayInfo.a))
      {
        paramExtensionInfo = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
        if (paramExtensionInfo.a != null)
        {
          paramExtensionInfo = (MutualMarkInfo)paramExtensionInfo.a.get(Long.valueOf(paramMutualMarkForDisplayInfo.a));
          if (paramExtensionInfo != null)
          {
            paramExtensionInfo.n = paramMutualMarkForDisplayInfo.j;
            paramExtensionInfo.o = paramMutualMarkForDisplayInfo.k;
          }
        }
      }
    }
  }
  
  public static MutualMarkForDisplayInfo b(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramExtensionInfo != null))
    {
      MutualMarkInfo localMutualMarkInfo = d(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
      if ((localMutualMarkInfo != null) && (!localMutualMarkInfo.m))
      {
        paramExtensionInfo = MutualMarkConfProcessor.a();
        MutualMarkConfigIRType localMutualMarkConfigIRType = paramExtensionInfo.b(localMutualMarkInfo.a);
        if (localMutualMarkConfigIRType != null)
        {
          MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = new MutualMarkForDisplayInfo();
          localMutualMarkForDisplayInfo.a(localMutualMarkInfo);
          localMutualMarkForDisplayInfo.p = localMutualMarkConfigIRType.f;
          localMutualMarkForDisplayInfo.o = localMutualMarkConfigIRType.c(localMutualMarkForDisplayInfo.b);
          localMutualMarkForDisplayInfo.m = localMutualMarkConfigIRType.d;
          localMutualMarkForDisplayInfo.n = localMutualMarkConfigIRType.e;
          localMutualMarkForDisplayInfo.l = localMutualMarkConfigIRType.c;
          localMutualMarkForDisplayInfo.q = MutualMarkConfigHelper.b(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo.a, localMutualMarkForDisplayInfo.b);
          localMutualMarkForDisplayInfo.s = MutualMarkUtils.g(localMutualMarkForDisplayInfo.s);
          RelationVipHelper.a().a(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo);
          localMutualMarkForDisplayInfo.s = MutualMarkAlienationHelper.a(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo.a, localMutualMarkForDisplayInfo.b, localMutualMarkForDisplayInfo.i, localMutualMarkForDisplayInfo.s);
          if (!localMutualMarkForDisplayInfo.c())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("getMutualMarkDisPlayInfo IconResource InValid displayInfo:");
            paramQQAppInterface.append(localMutualMarkForDisplayInfo);
            paramQQAppInterface.append(", friendUin");
            paramQQAppInterface.append(MobileQQ.getShortUinStr(paramString));
            QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
            return null;
          }
          if ((localMutualMarkConfigIRType.b(localMutualMarkForDisplayInfo.b)) && (MutualMarkConfigHelper.b(paramQQAppInterface, localMutualMarkForDisplayInfo.a, localMutualMarkForDisplayInfo.b))) {
            return localMutualMarkForDisplayInfo;
          }
          if ((localMutualMarkConfigIRType.a()) && (MutualMarkConfigHelper.b(paramQQAppInterface, localMutualMarkForDisplayInfo.a)))
          {
            long l = localMutualMarkConfigIRType.d(localMutualMarkForDisplayInfo.b);
            if (l != -1L)
            {
              localMutualMarkForDisplayInfo.b = l;
              return localMutualMarkForDisplayInfo;
            }
          }
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(paramString);
            paramQQAppInterface.append("getMutualMarkDisPlayInfo# displayInfo:");
            paramQQAppInterface.append(localMutualMarkForDisplayInfo);
            paramQQAppInterface.append(", bean:");
            paramQQAppInterface.append(paramExtensionInfo);
            paramQQAppInterface.append(",type = ");
            paramQQAppInterface.append(paramLong);
            QLog.i("MutualMarkDataCenter", 2, paramQQAppInterface.toString());
          }
        }
        else
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("MutualMarkConfBean getMutualMarkConfig(mutualMarkInfo.type): null，type = ");
          paramQQAppInterface.append(paramLong);
          paramQQAppInterface.append("，bean = ");
          paramQQAppInterface.append(paramExtensionInfo);
          QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getMutualMarkDisPlayInfo# may null，mutualMarkInfo: ");
        paramQQAppInterface.append(localMutualMarkInfo);
        QLog.i("MutualMarkDataCenter", 2, paramQQAppInterface.toString());
      }
      return null;
    }
    return null;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramBoolean, 0);
    return (paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty());
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramExtensionInfo == null) {
        return;
      }
      if (MutualMarkUtils.c(paramLong))
      {
        paramQQAppInterface = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
        if ((paramQQAppInterface.a != null) && (!paramQQAppInterface.a.isEmpty())) {
          paramQQAppInterface.a.remove(Long.valueOf(paramLong));
        }
      }
      else if ((MutualMarkUtils.b(paramLong)) && (IntimateUtil.a(paramLong)) && (paramExtensionInfo.intimate_type == paramLong))
      {
        paramExtensionInfo.intimate_type = 0;
        paramExtensionInfo.intimate_level = 0;
        paramExtensionInfo.intimate_chatDays = 0;
        paramExtensionInfo.last_intimate_chatTime = 0L;
        paramExtensionInfo.isExtinguish = false;
      }
    }
  }
  
  private static MutualMarkInfo d(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramExtensionInfo == null) {
          return null;
        }
        if (MutualMarkUtils.c(paramLong))
        {
          paramQQAppInterface = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
          if ((paramQQAppInterface.a != null) && (!paramQQAppInterface.a.isEmpty()))
          {
            localObject1 = (MutualMarkInfo)paramQQAppInterface.a.get(Long.valueOf(paramLong));
            paramQQAppInterface = (QQAppInterface)localObject1;
            if (localObject1 == null)
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("getMutualMarkInfo# extensionMutualMarkData.mutualMarks.get(type), ");
              paramQQAppInterface.append(paramLong);
              paramQQAppInterface.append(", mutualMarkInfo == null");
              QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
              paramQQAppInterface = (QQAppInterface)localObject1;
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getMutualMarkInfo# extensionInfo.getBusinessData(ExtensionMutualMarkData.class), ");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append(", extensionMutualMarkData = ");
            ((StringBuilder)localObject1).append(paramQQAppInterface);
            QLog.i("MutualMarkDataCenter", 1, ((StringBuilder)localObject1).toString());
            paramQQAppInterface = localObject2;
          }
        }
        else
        {
          paramQQAppInterface = localObject2;
          if (MutualMarkUtils.b(paramLong)) {
            if (IntimateUtil.a(paramLong))
            {
              paramQQAppInterface = localObject2;
              if (paramExtensionInfo.intimate_type == paramLong)
              {
                paramQQAppInterface = localObject2;
                if (paramExtensionInfo.intimate_level >= 0)
                {
                  paramQQAppInterface = localObject2;
                  if (paramExtensionInfo.intimate_level <= 2)
                  {
                    paramQQAppInterface = new MutualMarkInfo();
                    paramQQAppInterface.a = paramExtensionInfo.intimate_type;
                    paramQQAppInterface.b = paramExtensionInfo.intimate_level;
                    if (paramExtensionInfo.isExtinguish) {
                      paramQQAppInterface.g = 1L;
                    }
                    paramQQAppInterface.e = paramExtensionInfo.last_intimate_chatTime;
                    paramQQAppInterface.d = paramExtensionInfo.intimate_chatDays;
                  }
                }
              }
            }
            else
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("getMutualMarkInfo# IntimateUtil.isFriendIntimateType(type)=false, ");
              paramQQAppInterface.append(paramLong);
              QLog.i("MutualMarkDataCenter", 1, paramQQAppInterface.toString());
              paramQQAppInterface = localObject2;
            }
          }
        }
        localObject1 = paramQQAppInterface;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getMutualMarkInfo# mutualMarkInfo, ");
          ((StringBuilder)localObject1).append(paramQQAppInterface);
          ((StringBuilder)localObject1).append(", uin:");
          ((StringBuilder)localObject1).append(MobileQQ.getShortUinStr(paramString));
          ((StringBuilder)localObject1).append(", extensionInfo:");
          ((StringBuilder)localObject1).append(paramExtensionInfo);
          ((StringBuilder)localObject1).append(", type:");
          ((StringBuilder)localObject1).append(paramLong);
          QLog.i("MutualMarkDataCenter", 2, ((StringBuilder)localObject1).toString());
          localObject1 = paramQQAppInterface;
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkDataCenter
 * JD-Core Version:    0.7.0.1
 */