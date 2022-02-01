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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MutualMarkDataCenter
{
  static Comparator<MutualMarkForDisplayInfo> a = new MutualMarkDataCenter.1();
  
  public static MutualMarkForDisplayInfo a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        return null;
      }
      if (((FriendsManager)localObject).a(false))
      {
        QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo disableReactive: true , mutualmark switch is close");
        return null;
      }
      if (!((FriendsManager)localObject).c(paramString))
      {
        QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo fm.isFriendJustInCache: " + paramString + " == false");
        return null;
      }
      localObject = ((FriendsManager)localObject).a(paramString, paramBoolean);
      if (localObject == null)
      {
        QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo extensionInfo == null, queryDBIfNotInCache == " + paramBoolean);
        return null;
      }
      paramString = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject, paramLong);
      paramQQAppInterface = paramString;
    } while (paramString != null);
    return null;
  }
  
  public static MutualMarkForDisplayInfo a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    paramExtensionInfo = a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong);
    if ((paramExtensionInfo != null) && (!paramExtensionInfo.jdField_a_of_type_Boolean))
    {
      MutualMarkConfigIRType localMutualMarkConfigIRType = MutualMarkConfProcessor.a().a(paramExtensionInfo.jdField_a_of_type_Long);
      if (localMutualMarkConfigIRType != null)
      {
        MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = new MutualMarkForDisplayInfo();
        localMutualMarkForDisplayInfo.a(paramExtensionInfo);
        localMutualMarkForDisplayInfo.jdField_c_of_type_Boolean = localMutualMarkConfigIRType.jdField_b_of_type_Boolean;
        localMutualMarkForDisplayInfo.jdField_a_of_type_JavaLangString = localMutualMarkConfigIRType.a(localMutualMarkForDisplayInfo.jdField_b_of_type_Long);
        localMutualMarkForDisplayInfo.jdField_b_of_type_Boolean = localMutualMarkConfigIRType.jdField_a_of_type_Boolean;
        localMutualMarkForDisplayInfo.jdField_b_of_type_Int = localMutualMarkConfigIRType.jdField_b_of_type_Int;
        localMutualMarkForDisplayInfo.jdField_a_of_type_Int = localMutualMarkConfigIRType.jdField_a_of_type_Int;
        localMutualMarkForDisplayInfo.jdField_c_of_type_Int = MutualMarkConfigHelper.a(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo.jdField_a_of_type_Long, localMutualMarkForDisplayInfo.jdField_b_of_type_Long);
        localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString);
        RelationVipHelper.a().a(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo);
        localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString = MutualMarkAlienationHelper.a(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo.jdField_a_of_type_Long, localMutualMarkForDisplayInfo.jdField_b_of_type_Long, localMutualMarkForDisplayInfo.h, localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString);
        if (!localMutualMarkForDisplayInfo.c())
        {
          QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + localMutualMarkForDisplayInfo);
          return null;
        }
        if ((localMutualMarkConfigIRType.a(localMutualMarkForDisplayInfo.jdField_b_of_type_Long)) && (MutualMarkConfigHelper.b(paramQQAppInterface, localMutualMarkForDisplayInfo.jdField_a_of_type_Long, localMutualMarkForDisplayInfo.jdField_b_of_type_Long))) {
          return localMutualMarkForDisplayInfo;
        }
        if ((localMutualMarkConfigIRType.a()) && (MutualMarkConfigHelper.b(paramQQAppInterface, localMutualMarkForDisplayInfo.jdField_a_of_type_Long)))
        {
          paramLong = localMutualMarkConfigIRType.a(localMutualMarkForDisplayInfo.jdField_b_of_type_Long);
          if (paramLong != -1L)
          {
            localMutualMarkForDisplayInfo.jdField_b_of_type_Long = paramLong;
            return localMutualMarkForDisplayInfo;
          }
        }
      }
      else
      {
        QLog.i("MutualMarkDataCenter", 1, "MutualMarkConfBean getMutualMarkConfig(mutualMarkInfo.type): null");
      }
    }
    return null;
  }
  
  public static MutualMarkForDisplayInfo a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
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
    if (!((FriendsManager)localObject).c(paramString))
    {
      QLog.i("MutualMarkDataCenter", 1, "getIntimateMutualMarkDisplayInfo fm.isFriendJustInCache: " + paramString + " == false");
      return null;
    }
    localObject = ((FriendsManager)localObject).a(paramString, paramBoolean);
    if (localObject == null)
    {
      QLog.i("MutualMarkDataCenter", 1, "getIntimateMutualMarkDisplayInfo extensionInfo == null, queryDBIfNotInCache == " + paramBoolean);
      return null;
    }
    return IntimateUtil.a(paramQQAppInterface, paramString, (ExtensionInfo)localObject);
  }
  
  private static MutualMarkInfo a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      return null;
    }
    if (MutualMarkUtils.c(paramLong))
    {
      paramQQAppInterface = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
      if ((paramQQAppInterface.a == null) || (paramQQAppInterface.a.isEmpty())) {
        break label168;
      }
    }
    label168:
    for (paramQQAppInterface = (MutualMarkInfo)paramQQAppInterface.a.get(Long.valueOf(paramLong));; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if ((!MutualMarkUtils.b(paramLong)) || (!IntimateUtil.a(paramLong)) || (paramExtensionInfo.intimate_type != paramLong) || (paramExtensionInfo.intimate_level < 0) || (paramExtensionInfo.intimate_level > 2)) {
        break;
      }
      paramQQAppInterface = new MutualMarkInfo();
      paramQQAppInterface.jdField_a_of_type_Long = paramExtensionInfo.intimate_type;
      paramQQAppInterface.jdField_b_of_type_Long = paramExtensionInfo.intimate_level;
      if (paramExtensionInfo.isExtinguish) {
        paramQQAppInterface.f = 1L;
      }
      paramQQAppInterface.d = paramExtensionInfo.last_intimate_chatTime;
      paramQQAppInterface.c = paramExtensionInfo.intimate_chatDays;
      return paramQQAppInterface;
    }
  }
  
  public static Pair<MutualMarkForDisplayInfo, MutualMarkForDisplayInfo> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = a(paramQQAppInterface, paramString, false, 1);
    Object localObject4;
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      localObject4 = ((ArrayList)localObject2).iterator();
      localObject2 = null;
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (MutualMarkForDisplayInfo)((Iterator)localObject4).next();
        if (!((MutualMarkForDisplayInfo)localObject3).jdField_b_of_type_Boolean)
        {
          if ((localObject2 == null) || (((MutualMarkForDisplayInfo)localObject3).jdField_b_of_type_Int < ((MutualMarkForDisplayInfo)localObject2).jdField_b_of_type_Int)) {
            localObject2 = localObject3;
          }
        }
        else {
          for (;;)
          {
            break;
            if ((localObject1 != null) && (((MutualMarkForDisplayInfo)localObject3).jdField_b_of_type_Int >= localObject1.jdField_b_of_type_Int)) {
              break label182;
            }
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject2 != null) && (TextUtils.isEmpty(((MutualMarkForDisplayInfo)localObject2).jdField_b_of_type_JavaLangString))) {
          RelationVipHelper.a().a(paramQQAppInterface, paramString, (MutualMarkForDisplayInfo)localObject2);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (TextUtils.isEmpty(localObject1.jdField_b_of_type_JavaLangString))
          {
            RelationVipHelper.a().a(paramQQAppInterface, paramString, localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      return new Pair(localObject4, localObject3);
      label182:
      break;
      localObject4 = null;
    }
  }
  
  public static ArrayList<SingleLineTextView.IconDrawableInfo> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<MutualMarkForDisplayInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = (MutualMarkForDisplayInfo)paramArrayList.next();
        SingleLineTextView.IconDrawableInfo localIconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
        localIconDrawableInfo.iconResId = localMutualMarkForDisplayInfo.jdField_c_of_type_Int;
        localIconDrawableInfo.icon_static_url = localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString;
        if (TextUtils.isEmpty(localMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString)) {
          RelationVipHelper.a().a(paramQQAppInterface, paramString, localMutualMarkForDisplayInfo);
        }
        if (!TextUtils.isEmpty(localMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString)) {
          localIconDrawableInfo.iconDynamicUrl = localMutualMarkForDisplayInfo.jdField_b_of_type_JavaLangString;
        }
        localIconDrawableInfo.icon_status_alpha = localMutualMarkForDisplayInfo.a();
        QLog.i("MutualMarkDataCenter", 1, "getRecentListIconDrawableInfos friendUin:" + paramString + " info:" + localMutualMarkForDisplayInfo.toString());
        localArrayList.add(localIconDrawableInfo);
      }
      return localArrayList;
    }
    QLog.i("MutualMarkDataCenter", 1, "getRecentListIconDrawableInfos mutualMarkInfos: null");
    return null;
  }
  
  public static ArrayList<MutualMarkForDisplayInfo> a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 == null) {
      return null;
    }
    if ((paramInt == 2) || (paramInt == 1)) {}
    for (boolean bool = ((FriendsManager)localObject1).a(true); bool; bool = ((FriendsManager)localObject1).a(false))
    {
      QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks disableReactive: true , mutualmark switch is close");
      return null;
    }
    if (!((FriendsManager)localObject1).c(paramString))
    {
      QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks fm.isFriendJustInCache: " + paramString + " == false");
      return null;
    }
    localObject1 = ((FriendsManager)localObject1).a(paramString, paramBoolean);
    if (localObject1 == null)
    {
      QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks extensionInfo == null, queryDBIfNotInCache == " + paramBoolean);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = MutualMarkConfProcessor.a();
    if ((((MutualMarkConfBean)localObject2).a != null) && (((MutualMarkConfBean)localObject2).a.keySet().size() > 0))
    {
      localObject2 = ((MutualMarkConfBean)localObject2).a.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = a(paramQQAppInterface, paramString, (ExtensionInfo)localObject1, ((Long)((Iterator)localObject2).next()).longValue());
        if (localMutualMarkForDisplayInfo != null) {
          localArrayList.add(localMutualMarkForDisplayInfo);
        }
      }
    }
    QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks friendUin:" + paramString + ", displayInfos:" + localArrayList);
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (paramInt != 1) {
      Collections.sort(localArrayList, a);
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (a(paramQQAppInterface, paramString, paramExtensionInfo, paramLong) != null)
      {
        Object localObject = MutualMarkConfProcessor.a().a(paramLong);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b(paramQQAppInterface, paramString, paramExtensionInfo, ((MutualMarkConfigIRType)((Iterator)localObject).next()).jdField_a_of_type_Long);
        }
      }
    }
  }
  
  public static void a(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramMutualMarkForDisplayInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!MutualMarkUtils.c(paramMutualMarkForDisplayInfo.jdField_a_of_type_Long));
        paramExtensionInfo = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
      } while (paramExtensionInfo.a == null);
      paramExtensionInfo = (MutualMarkInfo)paramExtensionInfo.a.get(Long.valueOf(paramMutualMarkForDisplayInfo.jdField_a_of_type_Long));
    } while (paramExtensionInfo == null);
    paramExtensionInfo.jdField_b_of_type_Boolean = paramMutualMarkForDisplayInfo.jdField_a_of_type_Boolean;
    paramExtensionInfo.i = paramMutualMarkForDisplayInfo.i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramBoolean, 0);
    paramBoolean = bool;
    if (paramQQAppInterface != null)
    {
      paramBoolean = bool;
      if (!paramQQAppInterface.isEmpty()) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramExtensionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!MutualMarkUtils.c(paramLong)) {
          break;
        }
        paramQQAppInterface = (ExtensionMutualMarkData)paramExtensionInfo.getBusinessData(ExtensionMutualMarkData.class, new Object[0]);
      } while ((paramQQAppInterface.a == null) || (paramQQAppInterface.a.isEmpty()));
      paramQQAppInterface.a.remove(Long.valueOf(paramLong));
      return;
    } while ((!MutualMarkUtils.b(paramLong)) || (!IntimateUtil.a(paramLong)) || (paramExtensionInfo.intimate_type != paramLong));
    paramExtensionInfo.intimate_type = 0;
    paramExtensionInfo.intimate_level = 0;
    paramExtensionInfo.intimate_chatDays = 0;
    paramExtensionInfo.last_intimate_chatTime = 0L;
    paramExtensionInfo.isExtinguish = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkDataCenter
 * JD-Core Version:    0.7.0.1
 */