package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class MostUsedSearchResultManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MostUsedCache jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedCache = new MostUsedCache("Cahce_");
  
  public MostUsedSearchResultManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ArrayList<MostUsedCache.MostUsedSearchItemModel> a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedCache;
    if (localObject != null)
    {
      localObject = ((MostUsedCache)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      paramString = (String)localObject;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (((ArrayList)localObject).size() > 10)
        {
          paramString = new ArrayList(((ArrayList)localObject).subList(0, 10));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tmpResult subList 10 ,orglist is ");
          localStringBuilder.append(((ArrayList)localObject).size());
          QLog.i("MostUsedSearchResultManager", 2, localStringBuilder.toString());
          return paramString;
        }
      }
    }
    else
    {
      QLog.e("MostUsedSearchResultManager", 2, "Match with null cache");
      paramString = null;
    }
    return paramString;
  }
  
  public void a()
  {
    MostUsedCache localMostUsedCache = this.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedCache;
    if (localMostUsedCache != null)
    {
      localMostUsedCache.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("MostUsedSearchResultManager", 2, "init");
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "init with null cache ");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      String str;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        str = paramString2;
      }
      else
      {
        paramString2 = "";
        str = paramString1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UpdateItemUsed : key= ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" mostusedKey= ");
      localStringBuilder.append(paramString2);
      QLog.d("MostUsedSearchResultManager", 2, localStringBuilder.toString());
      int i = MostUseConstants.a(paramInt);
      if (!a(i)) {
        return;
      }
      paramString1 = new MostUsedSearchItem(str, NetConnInfoCenter.getServerTimeMillis(), paramString3, paramInt, i);
      ThreadManager.getSubThreadHandler().post(new MostUsedSearchResultManager.1(this, paramString1));
    }
  }
  
  boolean a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return paramInt == 3;
    }
    return true;
  }
  
  public void b()
  {
    MostUsedCache localMostUsedCache = this.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedCache;
    if (localMostUsedCache != null) {
      localMostUsedCache.a();
    }
  }
  
  public void onDestroy()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedCache = null;
    QLog.d("MostUsedSearchResultManager", 2, "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager
 * JD-Core Version:    0.7.0.1
 */