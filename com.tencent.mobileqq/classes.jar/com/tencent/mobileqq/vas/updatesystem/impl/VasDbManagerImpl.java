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
    Object localObject = a();
    boolean bool2 = ((EntityManager)localObject).isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        ((EntityManager)localObject).persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
      }
      else if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002))
      {
        bool1 = ((EntityManager)localObject).update(paramEntity);
      }
      ((EntityManager)localObject).close();
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateEntity em closed e=");
      ((StringBuilder)localObject).append(paramEntity.getTableName());
      QLog.d("VasUpdate_DbImpl", 2, ((StringBuilder)localObject).toString());
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DBdeleteItem: table = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" itemId = ");
      localStringBuilder.append(paramString);
      QLog.d("VasUpdate_DbImpl", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        a().delete(LocalFileMd5Entity.TABLE_NAME, "mItemId=?", new String[] { paramString });
        return;
      }
      a().delete(ShouldUpdateEntity.TABLE_NAME, "mItemId=?", new String[] { paramString });
      return;
    }
    a().delete(LocalUpdateEntity.TABLE_NAME, "mItemId=?", new String[] { paramString });
  }
  
  public List<IDbManager.ItemInfo> selectAllItem(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("DBselectAllItems: table = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("VasUpdate_DbImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          localObject2 = a().query(LocalFileMd5Entity.class);
          if (localObject2 == null) {
            return null;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (LocalFileMd5Entity)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new IDbManager.ItemInfo();
              ((IDbManager.ItemInfo)localObject4).itemId = ((LocalFileMd5Entity)localObject3).mItemId;
              ((IDbManager.ItemInfo)localObject4).content = ((LocalFileMd5Entity)localObject3).mContent;
              ((ArrayList)localObject1).add(localObject4);
            }
          }
        }
      }
      else
      {
        localObject2 = a().query(ShouldUpdateEntity.class);
        if (localObject2 == null) {
          return null;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ShouldUpdateEntity)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject4 = new IDbManager.ItemInfo();
            ((IDbManager.ItemInfo)localObject4).itemId = ((ShouldUpdateEntity)localObject3).mItemId;
            ((IDbManager.ItemInfo)localObject4).content = ((ShouldUpdateEntity)localObject3).mContent;
            ((ArrayList)localObject1).add(localObject4);
          }
        }
      }
    }
    else
    {
      localObject2 = a().query(LocalUpdateEntity.class);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LocalUpdateEntity)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          localObject4 = new IDbManager.ItemInfo();
          ((IDbManager.ItemInfo)localObject4).itemId = ((LocalUpdateEntity)localObject3).mItemId;
          ((IDbManager.ItemInfo)localObject4).content = ((LocalUpdateEntity)localObject3).mContent;
          ((ArrayList)localObject1).add(localObject4);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IDbManager.ItemInfo)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("DBselectAllItems table = ");
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject4).append(" itemId = ");
          ((StringBuilder)localObject4).append(((IDbManager.ItemInfo)localObject3).itemId);
          ((StringBuilder)localObject4).append(" content = ");
          ((StringBuilder)localObject4).append(((IDbManager.ItemInfo)localObject3).content);
          QLog.d("VasUpdate_DbImpl", 2, ((StringBuilder)localObject4).toString());
        }
      }
    }
    return localObject1;
  }
  
  public String selectItem(int paramInt, String paramString)
  {
    Object localObject = "";
    List localList;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            paramString = (String)localObject;
          } else {
            paramString = MobileQQ.getContext().getSharedPreferences("quick_update_common", 0).getString(paramString, "");
          }
        }
        else
        {
          localList = a().query(LocalFileMd5Entity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
          paramString = (String)localObject;
          if (localList != null)
          {
            paramString = (String)localObject;
            if (localList.size() >= 1)
            {
              paramString = (String)localObject;
              if (localList.get(0) != null) {
                paramString = ((LocalFileMd5Entity)localList.get(0)).mContent;
              }
            }
          }
        }
      }
      else
      {
        localList = a().query(ShouldUpdateEntity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
        paramString = (String)localObject;
        if (localList != null)
        {
          paramString = (String)localObject;
          if (localList.size() >= 1)
          {
            paramString = (String)localObject;
            if (localList.get(0) != null) {
              paramString = ((ShouldUpdateEntity)localList.get(0)).mContent;
            }
          }
        }
      }
    }
    else
    {
      localList = a().query(LocalUpdateEntity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      paramString = (String)localObject;
      if (localList != null)
      {
        paramString = (String)localObject;
        if (localList.size() >= 1)
        {
          paramString = (String)localObject;
          if (localList.get(0) != null) {
            paramString = ((LocalUpdateEntity)localList.get(0)).mContent;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DBselectItem table = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" , result = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VasUpdate_DbImpl", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public void updateItem(int paramInt, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DBupdateItem: table = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" itemId = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" content = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("VasUpdate_DbImpl", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = false;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            localObject = MobileQQ.getContext().getSharedPreferences("quick_update_common", 0).edit();
            ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
            bool = ((SharedPreferences.Editor)localObject).commit();
          }
        }
        else
        {
          localObject = new LocalFileMd5Entity();
          ((LocalFileMd5Entity)localObject).mItemId = paramString1;
          ((LocalFileMd5Entity)localObject).mContent = paramString2;
          bool = a((Entity)localObject);
        }
      }
      else
      {
        localObject = new ShouldUpdateEntity();
        ((ShouldUpdateEntity)localObject).mItemId = paramString1;
        ((ShouldUpdateEntity)localObject).mContent = paramString2;
        bool = a((Entity)localObject);
      }
    }
    else
    {
      localObject = new LocalUpdateEntity();
      ((LocalUpdateEntity)localObject).mItemId = paramString1;
      ((LocalUpdateEntity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
    }
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DBupdateItem table = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" itemId = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" content = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" fail");
      QLog.e("VasUpdate_DbImpl", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasDbManagerImpl
 * JD-Core Version:    0.7.0.1
 */