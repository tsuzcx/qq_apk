package com.tencent.mobileqq.troop.filemanager.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TroopFileSearchManager
{
  private static volatile TroopFileSearchManager a;
  protected List<IContactSearchable> a;
  protected List<TroopFileSearchableFriend> b = null;
  
  private TroopFileSearchManager()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString1 = a(paramString1);
    boolean bool = TextUtils.isEmpty(paramString1);
    int i = 0;
    if (bool) {
      return 0;
    }
    paramString3 = a(paramString3);
    paramString4 = a(paramString4);
    paramString5 = a(paramString5);
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    paramString8 = a(paramString8);
    if (a(paramString2).contains(paramString1)) {
      return 7;
    }
    if ((!TextUtils.isEmpty(paramString6)) && (paramString6.contains(paramString1))) {
      return 4;
    }
    if (paramString3.contains(paramString1)) {
      return 1;
    }
    if (paramString7.contains(paramString1)) {
      return 5;
    }
    if (paramString8.contains(paramString1)) {
      return 6;
    }
    if ((paramString4.contains(paramString1)) || (paramString5.contains(paramString1))) {
      i = 2;
    }
    return i;
  }
  
  public static TroopFileSearchManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager == null) {
          jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager = new TroopFileSearchManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.trim().toLowerCase();
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      return paramString2;
    }
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 6)) {
      return paramString3;
    }
    if (paramInt == 7) {
      return paramString1;
    }
    return null;
  }
  
  public static ArrayList<Long> a(List<? extends ISearchable> paramList)
  {
    if (paramList != null)
    {
      int j = paramList.size();
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      for (;;)
      {
        Object localObject = localArrayList1;
        if (i >= j) {
          break;
        }
        localObject = (ISearchable)paramList.get(i);
        if ((localObject instanceof ContactSearchableFriend))
        {
          localObject = (ContactSearchableFriend)localObject;
          try
          {
            if ((((ContactSearchableFriend)localObject).a() != 0) && (((ContactSearchableFriend)localObject).a() != 3)) {
              localArrayList1.add(Long.valueOf(Long.parseLong(((ContactSearchableFriend)localObject).e())));
            }
          }
          catch (NullPointerException localNullPointerException)
          {
            localNullPointerException.printStackTrace();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
        i += 1;
      }
    }
    ArrayList<Long> localArrayList = null;
    return localArrayList;
  }
  
  public final ContactSearchableFriend a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      return null;
    }
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (IContactSearchable)this.jdField_a_of_type_JavaUtilList.get(i);
      if (((localObject instanceof ContactSearchableFriend)) && (paramString.equals(((IContactSearchable)localObject).e()))) {
        return (ContactSearchableFriend)localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    StringBuilder localStringBuilder = null;
    for (;;)
    {
      localObject = localStringBuilder;
      if (j >= i) {
        break;
      }
      localObject = (TroopFileSearchableFriend)this.b.get(j);
      if (((TroopFileSearchableFriend)localObject).a.equals(paramString2))
      {
        localObject = TroopFileSearchableFriend.a(paramString1, (TroopFileSearchableFriend)localObject);
        break;
      }
      j += 1;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFriendsSearchedSet() time cost = ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(" , hanzi = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", input = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString2);
      QLog.d("TroopFileSearchManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List<IContactSearchable> a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ExecutorService localExecutorService = Executors.newFixedThreadPool(1);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localExecutorService.submit(new TroopFileSearchManager.CallableForSearchData(this, paramContext, paramQQAppInterface, IContactSearchable.E, paramInt)));
    paramInt = 0;
    try
    {
      while (paramInt < localArrayList2.size())
      {
        paramContext = (List)((Future)localArrayList2.get(paramInt)).get();
        localArrayList1.addAll(paramContext);
        paramContext.clear();
        paramInt += 1;
      }
      localArrayList2.clear();
      localExecutorService.shutdown();
    }
    catch (ExecutionException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (InterruptedException paramContext)
    {
      paramContext.printStackTrace();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("initSearchData() time cost = ");
      paramContext.append(l2 - l1);
      paramContext.append(" , size = ");
      paramContext.append(localArrayList1.size());
      QLog.d("TroopFileSearchManager", 2, paramContext.toString());
    }
    return localArrayList1;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List<IContactSearchable> a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1;
    if (localFriendsManager != null)
    {
      localObject1 = localFriendsManager.a();
      if (localObject1 != null)
      {
        Iterator localIterator1 = ((List)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          localObject1 = (Groups)localIterator1.next();
          Object localObject2 = localFriendsManager.a(String.valueOf(((Groups)localObject1).group_id));
          if (localObject2 != null)
          {
            Iterator localIterator2 = ((List)localObject2).iterator();
            while (localIterator2.hasNext())
            {
              Friends localFriends = (Friends)localIterator2.next();
              if (localFriends.gathtertype == 1) {
                localObject2 = paramContext.getResources().getString(2131720101);
              } else {
                localObject2 = ((Groups)localObject1).group_name;
              }
              localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, (String)localObject2, 0L, paramLong));
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = new Friends();
      ((Friends)localObject1).uin = paramQQAppInterface.getCurrentAccountUin();
      ((Friends)localObject1).name = paramQQAppInterface.getCurrentNickname();
      localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, (Friends)localObject1, paramContext.getResources().getString(2131720101), 0L, paramLong));
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getFriends() time cost = ");
      paramContext.append(paramLong - l);
      paramContext.append(" , size = ");
      paramContext.append(localArrayList.size());
      QLog.d("TroopFileSearchManager", 2, paramContext.toString());
    }
    return localArrayList;
  }
  
  public List<TroopFileSearchableFriend> a(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      Object localObject1 = localFriendsManager.a();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = localFriendsManager.a(String.valueOf(((Groups)((Iterator)localObject1).next()).group_id));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Friends localFriends = (Friends)((Iterator)localObject2).next();
              localArrayList.add(new TroopFileSearchableFriend(paramContext, localFriends.uin, localFriends.name, localFriends.remark));
            }
          }
        }
      }
    }
    if (paramBoolean) {
      localArrayList.add(new TroopFileSearchableFriend(paramContext, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentNickname(), null));
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getFriendsSearchedSet() time cost = ");
      paramContext.append(l2 - l1);
      paramContext.append(" , size = ");
      paramContext.append(localArrayList.size());
      QLog.d("TroopFileSearchManager", 2, paramContext.toString());
    }
    return localArrayList;
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    localList = this.b;
    if (localList != null) {
      localList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager
 * JD-Core Version:    0.7.0.1
 */