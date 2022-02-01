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
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager = null;
  }
  
  private TroopFileSearchManager()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
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
      return 2;
    }
    return 0;
  }
  
  public static TroopFileSearchManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager == null) {
        jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager = new TroopFileSearchManager();
      }
      return jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager;
    }
    finally {}
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
    if (paramInt == 1) {}
    while ((paramInt == 2) || (paramInt == 3)) {
      return paramString2;
    }
    if (paramInt == 4) {
      return paramString3;
    }
    if (paramInt == 5) {
      return paramString3;
    }
    if (paramInt == 6) {
      return paramString3;
    }
    if (paramInt == 7) {
      return paramString1;
    }
    return null;
  }
  
  public static ArrayList<Long> a(List<? extends ISearchable> paramList)
  {
    ArrayList localArrayList = null;
    int j;
    int i;
    if (paramList != null)
    {
      j = paramList.size();
      localArrayList = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = (ISearchable)paramList.get(i);
        if ((localObject instanceof ContactSearchableFriend))
        {
          localObject = (ContactSearchableFriend)localObject;
          try
          {
            if ((((ContactSearchableFriend)localObject).a() == 0) || (((ContactSearchableFriend)localObject).a() == 3)) {
              break label116;
            }
            localArrayList.add(Long.valueOf(Long.parseLong(((ContactSearchableFriend)localObject).e())));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
          catch (NullPointerException localNullPointerException)
          {
            localNullPointerException.printStackTrace();
          }
        }
      }
      else
      {
        return localArrayList;
      }
      label116:
      i += 1;
    }
  }
  
  public final ContactSearchableFriend a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      IContactSearchable localIContactSearchable = (IContactSearchable)this.jdField_a_of_type_JavaUtilList.get(i);
      if (((localIContactSearchable instanceof ContactSearchableFriend)) && (paramString.equals(localIContactSearchable.e()))) {
        return (ContactSearchableFriend)localIContactSearchable;
      }
      i += 1;
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    int i;
    int j;
    if (this.b == null)
    {
      i = 0;
      j = 0;
      label17:
      if (j >= i) {
        break label152;
      }
      localObject = (TroopFileSearchableFriend)this.b.get(j);
      if (!((TroopFileSearchableFriend)localObject).a.equals(paramString2)) {
        break label143;
      }
    }
    label143:
    label152:
    for (Object localObject = TroopFileSearchableFriend.a(paramString1, (TroopFileSearchableFriend)localObject);; localObject = null)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileSearchManager", 2, "getFriendsSearchedSet() time cost = " + (l2 - l1) + " , hanzi = " + (String)localObject + ", input = " + paramString1 + ", uin = " + paramString2);
      }
      return localObject;
      i = this.b.size();
      break;
      j += 1;
      break label17;
    }
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
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        long l2;
        paramContext.printStackTrace();
      }
    }
    catch (ExecutionException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileSearchManager", 2, "initSearchData() time cost = " + (l2 - l1) + " , size = " + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List<IContactSearchable> a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject;
    if (localFriendsManager != null)
    {
      localObject = localFriendsManager.a();
      if (localObject != null)
      {
        Iterator localIterator1 = ((List)localObject).iterator();
        while (localIterator1.hasNext())
        {
          Groups localGroups = (Groups)localIterator1.next();
          localObject = localFriendsManager.a(String.valueOf(localGroups.group_id));
          if (localObject != null)
          {
            Iterator localIterator2 = ((List)localObject).iterator();
            label106:
            Friends localFriends;
            if (localIterator2.hasNext())
            {
              localFriends = (Friends)localIterator2.next();
              if (localFriends.gathtertype != 1) {
                break label178;
              }
            }
            label178:
            for (localObject = paramContext.getResources().getString(2131720362);; localObject = localGroups.group_name)
            {
              localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, (String)localObject, 0L, paramLong));
              break label106;
              break;
            }
          }
        }
      }
    }
    if (paramBoolean)
    {
      localObject = new Friends();
      ((Friends)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
      ((Friends)localObject).name = paramQQAppInterface.getCurrentNickname();
      localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, (Friends)localObject, paramContext.getResources().getString(2131720362), 0L, paramLong));
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileSearchManager", 2, "getFriends() time cost = " + (paramLong - l) + " , size = " + localArrayList.size());
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileSearchManager", 2, "getFriendsSearchedSet() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager
 * JD-Core Version:    0.7.0.1
 */