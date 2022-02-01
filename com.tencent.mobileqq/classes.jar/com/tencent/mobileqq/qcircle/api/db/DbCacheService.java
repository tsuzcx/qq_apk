package com.tencent.mobileqq.qcircle.api.db;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.Class<+Lcom.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DbCacheService
{
  private static final int DATABASE_VERSION = 116;
  public static int DB_TYPE_NORMAL = 0;
  public static int DB_TYPE_PERSISTED = 1;
  public static int DB_TYPE_PICTURE = 2;
  public static int DB_TYPE_UNDEFINED = -1;
  public static final int DEFAULT_UIN = -1;
  public static final int PERSISTED_DATABASE_VERSION = 1;
  public static final String TAG = "QCircleDbCacheDatabase.DbCacheService";
  private static DbCacheService sInstance;
  private int dbOptiSync = -1;
  private IDBManagerWrapper.OnCloseListener mCacheCloseListener = new DbCacheService.1(this);
  private final HashMap<String, DbCacheManager> mCacheMap = new HashMap();
  private Context mContext;
  
  private DbCacheService(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static DbCacheService getInstance()
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null)
      {
        sInstance = new DbCacheService(MobileQQ.sMobileQQ.waitAppRuntime(null).getApplicationContext());
        DbCacheExceptionHandler.getInstance().attachContext(MobileQQ.sMobileQQ.waitAppRuntime(null).getApplicationContext());
      }
      DbCacheService localDbCacheService = sInstance;
      return localDbCacheService;
    }
    finally {}
  }
  
  public void close()
  {
    try
    {
      synchronized (this.mCacheMap)
      {
        Iterator localIterator = this.mCacheMap.values().iterator();
        while (localIterator.hasNext())
        {
          DbCacheManager localDbCacheManager = (DbCacheManager)localIterator.next();
          if (localDbCacheManager != null)
          {
            localDbCacheManager.removeCloseListener(this.mCacheCloseListener);
            localDbCacheManager.close();
          }
        }
      }
      this.mCacheMap.clear();
    }
    catch (Exception localException)
    {
      RFLog.e("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, new Object[] { localException });
      return;
    }
  }
  
  public void close(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Iterator localIterator;
      try
      {
        synchronized (this.mCacheMap)
        {
          localIterator = this.mCacheMap.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject = (Map.Entry)localIterator.next();
          if (localObject == null) {
            break label137;
          }
          localObject = (DbCacheManager)((Map.Entry)localObject).getValue();
          if (localObject != null)
          {
            if (!paramString.equals(((DbCacheManager)localObject).getDbName())) {
              continue;
            }
            ((DbCacheManager)localObject).removeCloseListener(this.mCacheCloseListener);
            ((DbCacheManager)localObject).close();
            localIterator.remove();
          }
        }
        localIterator.remove();
      }
      catch (Exception paramString)
      {
        RFLog.e("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, new Object[] { paramString });
        return;
      }
      continue;
      label137:
      localIterator.remove();
    }
  }
  
  public DbCacheManager getCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (this.mContext == null) {
      throw new RuntimeException("call initiate(Context context) before this");
    }
    if (paramString == null) {
      throw new RuntimeException("invalid table name");
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.mCacheMap)
      {
        localObject = DbCacheManager.uniqueKey(paramLong, paramInt1, paramString);
        localObject = (DbCacheManager)this.mCacheMap.get(localObject);
        if (localObject == null)
        {
          if (this.dbOptiSync == -1) {
            this.dbOptiSync = getDbOptiSync();
          }
          paramClass = new DbCacheManager(this.mContext, paramClass, paramLong, paramInt1, paramInt2, paramString, this.dbOptiSync);
          paramClass.addCloseListener(this.mCacheCloseListener);
          this.mCacheMap.put(paramClass.uniqueKey(), paramClass);
          localObject = AbstractDbCacheManager.generateDbName(paramLong, paramInt1);
          if (EncryptUtil.isTargetTable((String)localObject, paramString))
          {
            if (!EncryptUtil.isNeedEncrypt()) {
              break label362;
            }
            paramInt1 = 1;
            localObject = "dbencrypt_" + (String)localObject + paramString;
            int i = LocalMultiProcConfig.getInt4Uin((String)localObject, -1, paramLong);
            paramInt2 = i;
            if (i == -1)
            {
              LocalMultiProcConfig.getInt4Uin((String)localObject, paramInt1, paramLong);
              paramInt2 = paramInt1;
            }
            if (paramInt1 != paramInt2)
            {
              paramClass.clearData();
              RFLog.e("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, new Object[] { "detele table:", paramString, " Encrypt config:", Integer.valueOf(paramInt1), " sp:", Integer.valueOf(paramInt2) });
              LocalMultiProcConfig.getInt4Uin((String)localObject, paramInt1, paramLong);
            }
          }
          else
          {
            return paramClass;
          }
          if (!RFLog.isColorLevel()) {
            continue;
          }
          RFLog.e("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, new Object[] { "not detele table:", paramString, " Encrypt config:", Integer.valueOf(paramInt1), " sp:", Integer.valueOf(paramInt2) });
        }
      }
      paramClass = (Class<? extends IDBCacheDataWrapper>)localObject;
      continue;
      label362:
      paramInt1 = 0;
    }
  }
  
  public DbCacheManager getCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, String paramString)
  {
    if (paramLong == -1L) {
      return getResistedCacheManager(paramClass, paramString);
    }
    return getCacheManager(paramClass, paramLong, DB_TYPE_NORMAL, 117, paramString);
  }
  
  public int getDbOptiSync()
  {
    int i = QCircleConfig.getInstance().getConfigValue("QZoneSetting", "DbOptiSync", Integer.valueOf(1)).intValue();
    RFLog.w("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, "dbOptiSync=" + i);
    return i;
  }
  
  public DbCacheManager getPictureViewerCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, String paramString)
  {
    return getCacheManager(paramClass, paramLong, DB_TYPE_PICTURE, 117, paramString);
  }
  
  public DbCacheManager getResistedCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, String paramString)
  {
    return getCacheManager(paramClass, -1L, DB_TYPE_PERSISTED, 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheService
 * JD-Core Version:    0.7.0.1
 */