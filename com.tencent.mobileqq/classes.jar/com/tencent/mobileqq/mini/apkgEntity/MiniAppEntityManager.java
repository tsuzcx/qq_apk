package com.tencent.mobileqq.mini.apkgEntity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.UTFDataFormatException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class MiniAppEntityManager
  implements Manager
{
  private static final long APPINFO_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_appinfoentity_interval_time", 172800000L);
  private static final long OTHER_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_otherentity_interval_time", 345600000L);
  private static final String TAG = "MiniAppEntityManager";
  private static final HashMap<String, MiniAppEntityManager> sManagerHolder = new HashMap();
  private final EntityManager mEntityManager;
  private final MiniAppEntityManagerFactory miniAppEntityManagerFactory;
  
  private MiniAppEntityManager(String paramString)
  {
    this.miniAppEntityManagerFactory = new MiniAppEntityManagerFactory(paramString);
    this.mEntityManager = this.miniAppEntityManagerFactory.createEntityManager();
    verifyAuthenticationAsync();
  }
  
  private void deleteDbFile()
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject1 != null)
      {
        localObject1 = ((AppRuntime)localObject1).getAccount();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = BaseApplicationImpl.getContext();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("miniapp_");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(".db");
          localObject2 = ((BaseApplication)localObject2).getDatabasePath(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("deleteDbFile db : ");
          localStringBuilder.append(((File)localObject2).getPath());
          QLog.e("MiniAppEntityManager", 1, localStringBuilder.toString());
          FileUtils.deleteFile(((File)localObject2).getPath());
          localObject2 = BaseApplicationImpl.getContext();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("miniapp_");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(".db-journal");
          localObject2 = ((BaseApplication)localObject2).getDatabasePath(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("deleteDbFile dbJournal : ");
          localStringBuilder.append(((File)localObject2).getPath());
          QLog.e("MiniAppEntityManager", 1, localStringBuilder.toString());
          FileUtils.deleteFile(((File)localObject2).getPath());
          localObject2 = BaseApplicationImpl.getContext();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("miniapp_");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(".db-wal");
          localObject2 = ((BaseApplication)localObject2).getDatabasePath(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("deleteDbFile dbWal : ");
          localStringBuilder.append(((File)localObject2).getPath());
          QLog.e("MiniAppEntityManager", 1, localStringBuilder.toString());
          FileUtils.deleteFile(((File)localObject2).getPath());
          localObject2 = BaseApplicationImpl.getContext();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("miniapp_");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(".db-shm");
          localObject1 = ((BaseApplication)localObject2).getDatabasePath(localStringBuilder.toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("deleteDbFile dbShm : ");
          ((StringBuilder)localObject2).append(((File)localObject1).getPath());
          QLog.e("MiniAppEntityManager", 1, ((StringBuilder)localObject2).toString());
          FileUtils.deleteFile(((File)localObject1).getPath());
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppEntityManager", 1, "deleteDbFile error,", localThrowable);
    }
  }
  
  @Nullable
  public static MiniAppEntityManager get()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (MiniAppEntityManager)localAppRuntime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
    }
    return get(localAppRuntime.getAccount());
  }
  
  @Nullable
  public static MiniAppEntityManager get(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      MiniAppEntityManager localMiniAppEntityManager2 = (MiniAppEntityManager)sManagerHolder.get(paramString);
      MiniAppEntityManager localMiniAppEntityManager1 = localMiniAppEntityManager2;
      if (localMiniAppEntityManager2 == null)
      {
        localMiniAppEntityManager1 = new MiniAppEntityManager(paramString);
        sManagerHolder.put(paramString, localMiniAppEntityManager1);
      }
      return localMiniAppEntityManager1;
    }
    finally {}
  }
  
  private static void removeCachedManager(@NonNull MiniAppEntityManager paramMiniAppEntityManager)
  {
    try
    {
      sManagerHolder.values().remove(paramMiniAppEntityManager);
      return;
    }
    finally {}
  }
  
  private void verifyAuthenticationAsync()
  {
    ThreadManagerV2.excute(new MiniAppEntityManager.1(this), 32, null, true);
  }
  
  public void checkDB()
  {
    try
    {
      QLog.d("miniapp-db", 1, "checkDB");
      long l1 = System.currentTimeMillis() - APPINFO_DELETE_TIME;
      long l2 = System.currentTimeMillis();
      long l3 = OTHER_DELETE_TIME;
      try
      {
        execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppInfoEntity.class.getSimpleName(), Long.valueOf(l1) }));
        execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppByIdEntity.class.getSimpleName(), Long.valueOf(l1) }));
        execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppByLinkEntity.class.getSimpleName(), Long.valueOf(l1) }));
        execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppShowInfoEntity.class.getSimpleName(), Long.valueOf(l2 - l3) }));
        execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppInfoByIdEntity.class.getSimpleName(), Long.valueOf(l1) }));
        execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", new Object[] { MiniAppInfoByLinkEntity.class.getSimpleName(), Long.valueOf(l1) }));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppEntityManager", 1, "checkDB  error,", localThrowable);
        if ((localThrowable instanceof UTFDataFormatException))
        {
          QLog.e("MiniAppEntityManager", 1, "checkDB  error instanceof UTFDataFormatException, delete db file.");
          deleteDbFile();
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean clearEntityTable(String paramString)
  {
    try
    {
      EntityManager localEntityManager = this.mEntityManager;
      if (localEntityManager == null) {
        return false;
      }
      localEntityManager = this.mEntityManager;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DELETE FROM ");
      localStringBuilder.append(paramString);
      boolean bool = localEntityManager.execSQL(localStringBuilder.toString());
      return bool;
    }
    finally {}
  }
  
  public boolean execSQL(String paramString)
  {
    try
    {
      EntityManager localEntityManager = this.mEntityManager;
      if (localEntityManager == null) {
        return false;
      }
      boolean bool = this.mEntityManager.execSQL(paramString);
      return bool;
    }
    finally {}
  }
  
  public Entity find(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    try
    {
      EntityManager localEntityManager = this.mEntityManager;
      if (localEntityManager == null) {
        return null;
      }
      paramClass = this.mEntityManager.query(paramClass, true, paramString, paramArrayOfString, null, null, null, "1");
      if (paramClass != null)
      {
        paramClass = (Entity)paramClass.get(0);
        return paramClass;
      }
      return null;
    }
    finally {}
  }
  
  public EntityTransaction getTransaction()
  {
    EntityManager localEntityManager = this.mEntityManager;
    if (localEntityManager == null) {
      return null;
    }
    return localEntityManager.getTransaction();
  }
  
  public boolean insertOrReplaceEntity(Entity paramEntity)
  {
    try
    {
      EntityManager localEntityManager = this.mEntityManager;
      boolean bool = false;
      if (localEntityManager == null) {
        return false;
      }
      int i;
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityManager.persistOrReplace(paramEntity);
        i = paramEntity.getStatus();
        if (i == 1001) {
          bool = true;
        }
        return bool;
      }
      if (paramEntity.getStatus() != 1001)
      {
        i = paramEntity.getStatus();
        if (i != 1002) {
          return false;
        }
      }
      bool = this.mEntityManager.update(paramEntity);
      return bool;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    Object localObject = this.mEntityManager;
    if (localObject != null) {
      ((EntityManager)localObject).close();
    }
    localObject = this.miniAppEntityManagerFactory;
    if ((localObject != null) && (((MiniAppEntityManagerFactory)localObject).isOpen())) {
      this.miniAppEntityManagerFactory.close();
    }
    removeCachedManager(this);
  }
  
  public List<? extends Entity> queryEntity(Class<? extends Entity> paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      EntityManager localEntityManager = this.mEntityManager;
      if (localEntityManager == null) {
        return null;
      }
      paramClass = this.mEntityManager.query(paramClass, paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5);
      return paramClass;
    }
    finally {}
  }
  
  public boolean removeEntity(Entity paramEntity)
  {
    try
    {
      EntityManager localEntityManager = this.mEntityManager;
      if (localEntityManager == null) {
        return false;
      }
      if (paramEntity != null)
      {
        boolean bool = this.mEntityManager.remove(paramEntity);
        return bool;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager
 * JD-Core Version:    0.7.0.1
 */