package com.tencent.mobileqq.qassistant.core;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.FriendSortConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendSortHelper
{
  private static float jdField_a_of_type_Float = 0.85F;
  private static FriendSortConfig jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig;
  
  public static float a()
  {
    return jdField_a_of_type_Float;
  }
  
  private long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getRecentUserProxy();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.b(paramString, paramInt);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.lastmsgtime;
        }
      }
    }
    return 0L;
  }
  
  private FriendSortConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig == null)
    {
      jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig = a(BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getString("FriendSort", ""));
      if (jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig == null) {
        jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig = new FriendSortConfig();
      }
    }
    return jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig;
  }
  
  public static FriendSortConfig a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a(paramString))) {
      try
      {
        paramString = new JSONObject(paramString);
        FriendSortConfig localFriendSortConfig = new FriendSortConfig();
        localFriendSortConfig.jdField_a_of_type_Float = Float.valueOf(paramString.getString("recognitionWeight")).floatValue();
        localFriendSortConfig.b = Float.valueOf(paramString.getString("messageTime")).floatValue();
        localFriendSortConfig.c = Float.valueOf(paramString.getString("topFriend")).floatValue();
        localFriendSortConfig.d = Float.valueOf(paramString.getString("careFriend")).floatValue();
        jdField_a_of_type_ComTencentMobileqqQassistantDataFriendSortConfig = localFriendSortConfig;
        return localFriendSortConfig;
      }
      catch (JSONException paramString)
      {
        AssistantUtils.a("FriendSortHelper", "parseContent exception :" + paramString.getMessage());
        return null;
      }
      catch (Exception paramString)
      {
        AssistantUtils.a("FriendSortHelper", "parseContent exception :" + paramString.getMessage());
        return null;
      }
    }
    return null;
  }
  
  private List<FriendItemInfo> a(List<FriendItemInfo> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AssistantUtils.a("FriendSortHelper", "computeRecentTimeWeight friendInfoList is null");
      localObject = null;
      return localObject;
    }
    Collections.sort(paramList, new FriendSortComparator(2));
    Object localObject = paramList.iterator();
    int i = 0;
    label50:
    if (((Iterator)localObject).hasNext())
    {
      if (((FriendItemInfo)((Iterator)localObject).next()).jdField_a_of_type_Long <= 0L) {
        break label171;
      }
      i += 1;
    }
    label171:
    for (;;)
    {
      break label50;
      int k = i + 1;
      int m = paramList.size();
      i = j;
      localObject = paramList;
      if (i >= m) {
        break;
      }
      localObject = (FriendItemInfo)paramList.get(i);
      j = k - i - 1;
      if ((((FriendItemInfo)localObject).jdField_a_of_type_Long > 0L) && (j > 0)) {}
      for (((FriendItemInfo)localObject).b = (j * 1.0F / k);; ((FriendItemInfo)localObject).b = 0.0F)
      {
        i += 1;
        break;
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        jdField_a_of_type_Float = Float.parseFloat(paramString);
        return;
      }
      catch (Exception paramString)
      {
        AssistantUtils.a("FriendSortHelper", "parseFriendConfidence exception :" + paramString.getMessage());
        return;
      }
    }
    AssistantUtils.a("FriendSortHelper", "parseFriendConfidence confidence is null");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
      return (paramQQAppInterface != null) && (paramQQAppInterface.globalSwitch == 1);
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = paramQQAppInterface.getRecentUserProxy();
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(paramString, paramInt);
          bool1 = bool2;
          if (paramQQAppInterface != null)
          {
            bool1 = bool2;
            if (paramQQAppInterface.showUpTime > 0L) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private List<FriendItemInfo> b(QQAppInterface paramQQAppInterface, List<FriendItemInfo> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty()))
    {
      AssistantUtils.a("FriendSortHelper", "computeFriendScore friendInfoList is null");
      return null;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      FriendItemInfo localFriendItemInfo = (FriendItemInfo)localIterator.next();
      if ((localFriendItemInfo.jdField_a_of_type_Int == 0) && (a(paramQQAppInterface, localFriendItemInfo.jdField_a_of_type_JavaLangString)))
      {
        i = 1;
        label79:
        localFriendItemInfo.d = i;
        if (!a(paramQQAppInterface, localFriendItemInfo.jdField_a_of_type_JavaLangString, localFriendItemInfo.jdField_a_of_type_Int)) {
          break label141;
        }
      }
      label141:
      for (int i = 1;; i = 0)
      {
        localFriendItemInfo.c = i;
        localFriendItemInfo.jdField_a_of_type_Long = a(paramQQAppInterface, localFriendItemInfo.jdField_a_of_type_JavaLangString, localFriendItemInfo.jdField_a_of_type_Int);
        break;
        i = 0;
        break label79;
      }
    }
    a(paramList);
    return b(paramList);
  }
  
  private List<FriendItemInfo> b(List<FriendItemInfo> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AssistantUtils.a("FriendSortHelper", "computeTotalScore friendInfoList is null");
      localObject = null;
      return localObject;
    }
    FriendSortConfig localFriendSortConfig = a();
    if (localFriendSortConfig == null)
    {
      AssistantUtils.a("FriendSortHelper", "computeTotalScore sortConfig is null");
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (FriendItemInfo)localIterator.next();
      ((FriendItemInfo)localObject).e = (localFriendSortConfig.jdField_a_of_type_Float * ((FriendItemInfo)localObject).jdField_a_of_type_Float + localFriendSortConfig.b * ((FriendItemInfo)localObject).b + localFriendSortConfig.c * ((FriendItemInfo)localObject).c + localFriendSortConfig.d * ((FriendItemInfo)localObject).d);
    }
  }
  
  public List<FriendItemInfo> a(QQAppInterface paramQQAppInterface, List<FriendItemInfo> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty()))
    {
      AssistantUtils.a("FriendSortHelper", "sortFriendList friendInfoList is null");
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      b(paramQQAppInterface, paramList);
      Collections.sort(paramList, new FriendSortComparator(1));
      paramQQAppInterface = paramList;
    } while (paramList.size() <= 5);
    return paramList.subList(0, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.FriendSortHelper
 * JD-Core Version:    0.7.0.1
 */