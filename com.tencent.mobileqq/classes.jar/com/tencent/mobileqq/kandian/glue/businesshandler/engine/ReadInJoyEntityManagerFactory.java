package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.kandian.biz.reward.RedPacketTaskData;
import com.tencent.mobileqq.kandian.repo.common.InterestLabelInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleExposureInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleReadInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelTopCookie;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyEntityManagerFactory
  extends EntityManagerFactory
{
  public ReadInJoyEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.tag = "ReadInJoy.MessageNode.EntityManagerFactory";
  }
  
  private void a(com.tencent.mobileqq.app.SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = b(paramSQLiteDatabase);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str1 = arrayOfString[i];
        if ((!"android_metadata".equals(str1)) && (!"sqlite_sequence".equals(str1))) {
          try
          {
            paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str1));
          }
          catch (SQLiteException localSQLiteException)
          {
            String str2 = this.tag;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[DB] dropAllTable ");
            localStringBuilder.append(str1);
            QLog.e(str2, 1, localStringBuilder.toString(), localSQLiteException);
            SQLiteOpenHelper.throwDebugException(localSQLiteException);
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.decode(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {}
        try
        {
          Object localObject;
          if (str.equals("ArticleInfo"))
          {
            localObject = BaseArticleInfo.class;
          }
          else if (str.equals(ArticleReadInfo.TABLE_NAME))
          {
            localObject = ArticleReadInfo.class;
          }
          else if (str.equals(ChannelInfo.TABLE_NAME))
          {
            localObject = ChannelInfo.class;
          }
          else if (str.equals(ChannelTopCookie.TABLE_NAME))
          {
            localObject = ChannelTopCookie.class;
          }
          else if (str.equals(InterestLabelInfo.TABLE_NAME))
          {
            localObject = InterestLabelInfo.class;
          }
          else if (str.equals(AdvertisementInfo.TABLE_NAME))
          {
            localObject = AdvertisementInfo.class;
          }
          else if (str.equals(ChannelCoverInfo.TABLE_NAME))
          {
            localObject = ChannelCoverInfo.class;
          }
          else if (str.equals(WeiShiVideoArticleInfo.TABLE_NAME))
          {
            localObject = WeiShiVideoArticleInfo.class;
          }
          else if (str.equals(ArticleExposureInfo.TABLE_NAME))
          {
            localObject = ArticleExposureInfo.class;
          }
          else if (str.equals(RedPacketTaskData.TABLE_NAME))
          {
            localObject = RedPacketTaskData.class;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(".");
            ((StringBuilder)localObject).append(str);
            localObject = Class.forName(((StringBuilder)localObject).toString());
          }
          OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          label284:
          break label284;
        }
        localCursor2.close();
      }
      localCursor1.close();
    }
    else
    {
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          paramSQLiteDatabase.execSQL((String)paramString.next());
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
        for (;;)
        {
          throw paramString;
        }
      }
    }
  }
  
  /* Error */
  private String[] b(com.tencent.mobileqq.app.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: ldc 77
    //   15: aconst_null
    //   16: invokevirtual 190	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 5
    //   21: aload 8
    //   23: astore 4
    //   25: aload 5
    //   27: ifnull +107 -> 134
    //   30: aload 6
    //   32: astore_1
    //   33: aload 8
    //   35: astore 4
    //   37: aload 5
    //   39: invokeinterface 193 1 0
    //   44: ifeq +90 -> 134
    //   47: aload 6
    //   49: astore_1
    //   50: aload 5
    //   52: invokeinterface 197 1 0
    //   57: anewarray 27	java/lang/String
    //   60: astore 4
    //   62: iconst_0
    //   63: istore_2
    //   64: aload 4
    //   66: astore_1
    //   67: aload 4
    //   69: iload_2
    //   70: aload 5
    //   72: iconst_0
    //   73: invokeinterface 96 2 0
    //   78: invokestatic 101	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   81: aastore
    //   82: aload 4
    //   84: astore_1
    //   85: aload 5
    //   87: invokeinterface 92 1 0
    //   92: istore_3
    //   93: iload_3
    //   94: ifne +6 -> 100
    //   97: goto +37 -> 134
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -40 -> 64
    //   107: astore_1
    //   108: aload 5
    //   110: astore 4
    //   112: goto +85 -> 197
    //   115: astore 7
    //   117: aload 5
    //   119: astore 4
    //   121: aload_1
    //   122: astore 6
    //   124: aload 7
    //   126: astore 5
    //   128: aload 4
    //   130: astore_1
    //   131: goto +30 -> 161
    //   134: aload 5
    //   136: ifnull +10 -> 146
    //   139: aload 5
    //   141: invokeinterface 155 1 0
    //   146: aload 4
    //   148: areturn
    //   149: astore_1
    //   150: goto +47 -> 197
    //   153: astore 5
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 7
    //   160: astore_1
    //   161: aload_1
    //   162: astore 4
    //   164: aload_0
    //   165: getfield 14	com/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyEntityManagerFactory:tag	Ljava/lang/String;
    //   168: iconst_1
    //   169: ldc 199
    //   171: aload 5
    //   173: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: astore 4
    //   179: aload 5
    //   181: invokestatic 72	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: aload_1
    //   189: invokeinterface 155 1 0
    //   194: aload 6
    //   196: areturn
    //   197: aload 4
    //   199: ifnull +10 -> 209
    //   202: aload 4
    //   204: invokeinterface 155 1 0
    //   209: goto +5 -> 214
    //   212: aload_1
    //   213: athrow
    //   214: goto -2 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	ReadInJoyEntityManagerFactory
    //   0	217	1	paramSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   63	41	2	i	int
    //   92	2	3	bool	boolean
    //   4	199	4	localObject1	Object
    //   19	121	5	localObject2	Object
    //   153	27	5	localException1	Exception
    //   10	185	6	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   7	1	7	localObject3	Object
    //   115	44	7	localException2	Exception
    //   1	33	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   37	47	107	finally
    //   50	62	107	finally
    //   67	82	107	finally
    //   85	93	107	finally
    //   37	47	115	java/lang/Exception
    //   50	62	115	java/lang/Exception
    //   67	82	115	java/lang/Exception
    //   85	93	115	java/lang/Exception
    //   12	21	149	finally
    //   164	176	149	finally
    //   179	184	149	finally
    //   12	21	153	java/lang/Exception
  }
  
  public void a()
  {
    if ((this.dbHelper != null) && (this.mInnerDbHelper != null))
    {
      a(this.dbHelper.getWritableDatabase());
      return;
    }
    QLog.d(this.tag, 2, "removeDatabases: failed. please call build first.");
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mInnerDbHelper != null)
    {
      Cursor localCursor = this.mInnerDbHelper.getReadableDatabase().rawQuery("select distinct tbl_name from Sqlite_master", null);
      if (localCursor != null)
      {
        while (localCursor.moveToNext()) {
          localArrayList.add(SecurityUtile.decode(localCursor.getString(0)));
        }
        localCursor.close();
      }
    }
    return localArrayList;
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readinjoy_message_node_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, localStringBuilder.toString(), 115);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new BaseArticleInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleReadInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AdvertisementInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new WeiShiVideoArticleInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleExposureInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RedPacketTaskData()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on ArticleInfo for each row begin  delete from ");
    localStringBuilder.append(ArticleReadInfo.TABLE_NAME);
    localStringBuilder.append(" where mArticleID = old.mArticleID; end ");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  protected String getPackageName()
  {
    return "com.tencent.mobileqq.kandian.repo.db.struct";
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.tag;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[DB]|upgrade. oldver=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",newver=");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    paramInt1 = 1;
    QLog.i((String)localObject1, 1, (String)localObject2);
    a(getPackageName(), paramSQLiteDatabase);
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ");
      ((StringBuilder)localObject1).append(ArticleReadInfo.TABLE_NAME);
      ((StringBuilder)localObject1).append(" limit 1 ");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString());
    }
    catch (Exception localException)
    {
      label120:
      break label120;
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArticleReadInfo()));
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on ArticleInfo for each row begin  delete from ");
    ((StringBuilder)localObject1).append(ArticleReadInfo.TABLE_NAME);
    ((StringBuilder)localObject1).append(" where mArticleID = old.mArticleID; end ");
    paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString());
  }
  
  public boolean verifyAuthentication()
  {
    try
    {
      if (this.name.matches("^[0-9]*$"))
      {
        EntityManager localEntityManager = createEntityManager();
        ReadInJoyEntityManagerFactory.VerifyEntity localVerifyEntity = (ReadInJoyEntityManagerFactory.VerifyEntity)localEntityManager.find(ReadInJoyEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "readinjoy_message_node_verify_entity" });
        if (localVerifyEntity == null)
        {
          localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
          localVerifyEntity.name = this.name;
          localEntityManager.persistOrReplace(localVerifyEntity);
          return true;
        }
        if ((!localVerifyEntity.flags.equals("readinjoy_message_node_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
        {
          this.mInnerDbHelper.dropAllTable();
          localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
          localVerifyEntity.name = this.name;
          localEntityManager.persistOrReplace(localVerifyEntity);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.tag, 1, localException, new Object[0]);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */