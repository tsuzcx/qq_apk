package com.tencent.mobileqq.nearby;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NearbyEntityManagerFactory
  extends EntityManagerFactory
{
  public static HashMap<String, Class<?>> a = new HashMap();
  
  public NearbyEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  private void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        String str1 = SecurityUtile.decode(((Cursor)localObject1).getString(0));
        Cursor localCursor = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str1 });
        Object localObject3 = (Class)a.get(str1.trim());
        if ((localCursor != null) && (localObject3 != null))
        {
          Object localObject4 = TableBuilder.getValidField((Class)localObject3);
          if (localCursor.moveToFirst())
          {
            localObject3 = SecurityUtile.decode(localCursor.getString(0)).split(",");
            localObject4 = ((List)localObject4).iterator();
            label266:
            while (((Iterator)localObject4).hasNext())
            {
              Field localField = (Field)((Iterator)localObject4).next();
              int i = 1;
              while (i < localObject3.length)
              {
                String str2 = localObject3[i].trim().split(" ")[0];
                if (localField.getName().equals(str2))
                {
                  i = 1;
                  break label212;
                }
                i += 1;
              }
              i = 0;
              label212:
              if (i == 0)
              {
                boolean bool;
                if (localField.isAnnotationPresent(defaultzero.class))
                {
                  bool = true;
                }
                else
                {
                  if (localField.isAnnotationPresent(defaultValue.class))
                  {
                    i = ((defaultValue)localField.getAnnotation(defaultValue.class)).defaultInteger();
                    bool = true;
                    break label266;
                  }
                  bool = false;
                }
                i = 0;
                localArrayList.add(TableBuilder.addColumn(str1, localField.getName(), (String)TableBuilder.TYPES.get(localField.getType()), bool, i));
              }
            }
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
      }
      ((Cursor)localObject1).close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramSQLiteDatabase.execSQL((String)((Iterator)localObject1).next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nearby_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, localStringBuilder.toString(), 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("nearby_");
      localStringBuilder.append(paramString);
      this.name = localStringBuilder.toString();
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase) {}
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(paramSQLiteDatabase);
  }
  
  public boolean verifyAuthentication()
  {
    boolean bool3 = this.name.matches("^nearby_[0-9]*$");
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      EntityManager localEntityManager = createEntityManager();
      NearbyEntityManagerFactory.VerifyEntity localVerifyEntity = (NearbyEntityManagerFactory.VerifyEntity)localEntityManager.find(NearbyEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "nearby_verify_entity" });
      if (localVerifyEntity == null)
      {
        localVerifyEntity = new NearbyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localVerifyEntity.flags = "nearby_verify_entity";
        localEntityManager.persistOrReplace(localVerifyEntity);
        return true;
      }
      if (localVerifyEntity.flags.equals("nearby_verify_entity"))
      {
        bool1 = bool2;
        if (localVerifyEntity.name.equals(this.name)) {}
      }
      else
      {
        this.mInnerDbHelper.a();
        localVerifyEntity = new NearbyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.persistOrReplace(localVerifyEntity);
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */