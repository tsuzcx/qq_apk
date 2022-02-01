package com.tencent.mobileqq.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfoCheckUtil;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  protected LruCache<String, String> a;
  protected QQAppInterface a;
  protected ConcurrentHashMap<Long, TroopFeedsDataManager> a;
  public boolean a;
  protected ConcurrentHashMap<String, MessageInfo> b = new ConcurrentHashMap();
  
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
      try
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
        }
      }
      finally {}
    }
    TroopInfoCheckUtil.a();
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.b.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("messageInfoMap: update__:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessageInfo.a());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessageInfo.a());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessageInfo.a());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, ((StringBuilder)localObject).toString());
    }
    MessageInfo localMessageInfo = (MessageInfo)this.b.get(paramString);
    Object localObject = localMessageInfo;
    if (paramMessageInfo != null)
    {
      if (!paramMessageInfo.a()) {
        return localMessageInfo;
      }
      if (localMessageInfo == null)
      {
        paramMessageInfo = new MessageInfo(paramMessageInfo);
        this.b.put(paramString, paramMessageInfo);
        localObject = paramMessageInfo;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("messageInfoMap: put:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("TroopInfoManager_At_Me_DISC", 2, ((StringBuilder)localObject).toString());
          return paramMessageInfo;
        }
      }
      else
      {
        localMessageInfo.a(paramMessageInfo);
        localObject = localMessageInfo;
        if (QLog.isColorLevel())
        {
          paramMessageInfo = new StringBuilder();
          paramMessageInfo.append("messageInfoMap: update:");
          paramMessageInfo.append(paramString);
          QLog.d("TroopInfoManager_At_Me_DISC", 2, paramMessageInfo.toString());
          localObject = localMessageInfo;
        }
      }
    }
    return localObject;
  }
  
  public TroopFeedsDataManager a(Long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    TroopFeedsDataManager localTroopFeedsDataManager2 = (TroopFeedsDataManager)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    TroopFeedsDataManager localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
    if (localTroopFeedsDataManager2 == null)
    {
      localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
      if (paramBoolean)
      {
        localTroopFeedsDataManager1 = new TroopFeedsDataManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, localTroopFeedsDataManager1);
      }
    }
    return localTroopFeedsDataManager1;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append("_");
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.apply();
  }
  
  public void a(Long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(paramLong);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Base64Util.encodeToString(paramArrayOfByte, 2));
  }
  
  public byte[] a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.b.remove(paramString);
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopFeedsDataManager localTroopFeedsDataManager = (TroopFeedsDataManager)((Iterator)localObject).next();
        if (localTroopFeedsDataManager != null) {
          localTroopFeedsDataManager.deleteObservers();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager
 * JD-Core Version:    0.7.0.1
 */