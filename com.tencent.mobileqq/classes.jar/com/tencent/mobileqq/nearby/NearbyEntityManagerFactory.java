package com.tencent.mobileqq.nearby;

import ambz;
import android.database.Cursor;
import awgf;
import awhf;
import awhl;
import awhm;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NearbyEntityManagerFactory
  extends QQEntityManagerFactory
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
    String str1;
    Cursor localCursor;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null) {
      if (((Cursor)localObject1).moveToNext())
      {
        str1 = SecurityUtile.b(((Cursor)localObject1).getString(0));
        localCursor = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str1 });
        localObject3 = (Class)a.get(str1.trim());
        if ((localCursor != null) && (localObject3 != null))
        {
          localObject4 = awhf.a((Class)localObject3);
          if (localCursor.moveToFirst())
          {
            localObject3 = SecurityUtile.b(localCursor.getString(0)).split(",");
            localObject4 = ((List)localObject4).iterator();
          }
        }
      }
    }
    label391:
    label394:
    for (;;)
    {
      label138:
      Field localField;
      if (((Iterator)localObject4).hasNext())
      {
        localField = (Field)((Iterator)localObject4).next();
        i = 1;
        label162:
        if (i >= localObject3.length) {
          break label391;
        }
        String str2 = localObject3[i].trim().split(" ")[0];
        if (!localField.getName().equals(str2)) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label394;
        }
        boolean bool;
        if (localField.isAnnotationPresent(awhm.class))
        {
          i = 0;
          bool = true;
        }
        for (;;)
        {
          localArrayList.add(awhf.a(str1, localField.getName(), (String)awhf.a.get(localField.getType()), bool, i));
          break label138;
          i += 1;
          break label162;
          if (localField.isAnnotationPresent(awhl.class))
          {
            i = ((awhl)localField.getAnnotation(awhl.class)).a();
            bool = true;
            continue;
            if (localCursor == null) {
              break;
            }
            localCursor.close();
            break;
            ((Cursor)localObject1).close();
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            paramSQLiteDatabase.beginTransaction();
            try
            {
              localObject1 = localArrayList.iterator();
              while (((Iterator)localObject1).hasNext()) {
                paramSQLiteDatabase.execSQL((String)((Iterator)localObject1).next());
              }
              paramSQLiteDatabase.setTransactionSuccessful();
            }
            finally
            {
              paramSQLiteDatabase.endTransaction();
              com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            }
            paramSQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            return;
          }
          i = 0;
          bool = false;
        }
      }
    }
  }
  
  public ambz build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "nearby_" + paramString + ".db", null, 1);
      this.dbHelper = new ambz(this.mInnerDbHelper);
      this.name = ("nearby_" + paramString);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase) {}
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(paramSQLiteDatabase);
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^nearby_[0-9]*$"))
    {
      awgf localawgf = createEntityManager();
      NearbyEntityManagerFactory.VerifyEntity localVerifyEntity = (NearbyEntityManagerFactory.VerifyEntity)localawgf.a(NearbyEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "nearby_verify_entity" });
      if (localVerifyEntity == null)
      {
        localVerifyEntity = new NearbyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localVerifyEntity.flags = "nearby_verify_entity";
        localawgf.b(localVerifyEntity);
        return true;
      }
      if ((!localVerifyEntity.flags.equals("nearby_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localVerifyEntity = new NearbyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localawgf.b(localVerifyEntity);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */