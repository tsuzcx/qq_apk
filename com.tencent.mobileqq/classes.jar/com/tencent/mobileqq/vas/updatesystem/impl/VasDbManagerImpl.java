package com.tencent.mobileqq.vas.updatesystem.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.updatesystem.db.VasUpdateEntityManagerFactory;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalFileMd5Entity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.ShouldUpdateEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IDbManager.ItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VasDbManagerImpl
  implements IDbManager
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemDbVasUpdateEntityManagerFactory.createEntityManager();
  private VasUpdateEntityManagerFactory jdField_a_of_type_ComTencentMobileqqVasUpdatesystemDbVasUpdateEntityManagerFactory = new VasUpdateEntityManagerFactory(a());
  
  private String a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    EntityManager localEntityManager = a();
    if (localEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        localEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        localEntityManager.close();
      }
    }
    do
    {
      return bool1;
      if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
        break;
      }
      bool1 = localEntityManager.update(paramEntity);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("VasUpdate_DbImpl", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public EntityManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemDbVasUpdateEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemDbVasUpdateEntityManagerFactory = new VasUpdateEntityManagerFactory(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemDbVasUpdateEntityManagerFactory.createEntityManager();
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  }
  
  public void deleteItem(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_DbImpl", 2, "DBdeleteItem: table = " + paramInt + " itemId = " + paramString);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a().delete(LocalUpdateEntity.TABLE_NAME, "mItemId=?", new String[] { paramString });
      return;
    case 1: 
      a().delete(ShouldUpdateEntity.TABLE_NAME, "mItemId=?", new String[] { paramString });
      return;
    }
    a().delete(LocalFileMd5Entity.TABLE_NAME, "mItemId=?", new String[] { paramString });
  }
  
  public List<IDbManager.ItemInfo> selectAllItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_DbImpl", 2, "DBselectAllItems: table = " + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    switch (paramInt)
    {
    }
    while (QLog.isColorLevel())
    {
      Object localObject1 = localArrayList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IDbManager.ItemInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          QLog.d("VasUpdate_DbImpl", 2, "DBselectAllItems table = " + paramInt + " itemId = " + ((IDbManager.ItemInfo)localObject2).itemId + " content = " + ((IDbManager.ItemInfo)localObject2).content);
        }
      }
      localObject1 = a().query(LocalUpdateEntity.class);
      if (localObject1 == null) {}
      IDbManager.ItemInfo localItemInfo;
      do
      {
        do
        {
          return null;
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (LocalUpdateEntity)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localItemInfo = new IDbManager.ItemInfo();
              localItemInfo.itemId = ((LocalUpdateEntity)localObject2).mItemId;
              localItemInfo.content = ((LocalUpdateEntity)localObject2).mContent;
              localArrayList.add(localItemInfo);
            }
          }
          localObject1 = a().query(ShouldUpdateEntity.class);
        } while (localObject1 == null);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ShouldUpdateEntity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localItemInfo = new IDbManager.ItemInfo();
            localItemInfo.itemId = ((ShouldUpdateEntity)localObject2).mItemId;
            localItemInfo.content = ((ShouldUpdateEntity)localObject2).mContent;
            localArrayList.add(localItemInfo);
          }
        }
        localObject1 = a().query(LocalFileMd5Entity.class);
      } while (localObject1 == null);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalFileMd5Entity)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localItemInfo = new IDbManager.ItemInfo();
          localItemInfo.itemId = ((LocalFileMd5Entity)localObject2).mItemId;
          localItemInfo.content = ((LocalFileMd5Entity)localObject2).mContent;
          localArrayList.add(localItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public String selectItem(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramString = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_DbImpl", 2, "DBselectItem table = " + paramInt + " , result = " + paramString);
      }
      return paramString;
      paramString = a().query(LocalUpdateEntity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      if ((paramString == null) || (paramString.size() < 1) || (paramString.get(0) == null)) {
        break;
      }
      paramString = ((LocalUpdateEntity)paramString.get(0)).mContent;
      continue;
      paramString = a().query(ShouldUpdateEntity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      if ((paramString == null) || (paramString.size() < 1) || (paramString.get(0) == null)) {
        break;
      }
      paramString = ((ShouldUpdateEntity)paramString.get(0)).mContent;
      continue;
      paramString = a().query(LocalFileMd5Entity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      if ((paramString == null) || (paramString.size() < 1) || (paramString.get(0) == null)) {
        break;
      }
      paramString = ((LocalFileMd5Entity)paramString.get(0)).mContent;
      continue;
      paramString = MobileQQ.getContext().getSharedPreferences("quick_update_common", 0).getString(paramString, "");
    }
  }
  
  public void updateItem(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_DbImpl", 2, "DBupdateItem: table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!bool) {
        QLog.e("VasUpdate_DbImpl", 1, "DBupdateItem table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2 + " fail");
      }
      return;
      Object localObject = new LocalUpdateEntity();
      ((LocalUpdateEntity)localObject).mItemId = paramString1;
      ((LocalUpdateEntity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
      continue;
      localObject = new ShouldUpdateEntity();
      ((ShouldUpdateEntity)localObject).mItemId = paramString1;
      ((ShouldUpdateEntity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
      continue;
      localObject = new LocalFileMd5Entity();
      ((LocalFileMd5Entity)localObject).mItemId = paramString1;
      ((LocalFileMd5Entity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
      continue;
      localObject = MobileQQ.getContext().getSharedPreferences("quick_update_common", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      bool = ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasDbManagerImpl
 * JD-Core Version:    0.7.0.1
 */