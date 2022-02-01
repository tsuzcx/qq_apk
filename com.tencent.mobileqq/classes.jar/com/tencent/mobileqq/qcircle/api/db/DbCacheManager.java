package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DbCacheManager
  extends AbstractDbCacheManager
  implements IDBManagerWrapper
{
  private final ArrayList<WeakReference<DbCacheManager.OnChangeListener>> mChangeListeners = new ArrayList();
  private final ArrayList<WeakReference<IDBManagerWrapper.OnCloseListener>> mCloseListeners = new ArrayList();
  private String mSelection;
  private String mSortOrder;
  private String[] mWhereArgs;
  
  protected DbCacheManager(Context paramContext, Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    super(paramContext, paramClass, paramLong, paramInt1, paramInt2, paramString, paramInt3);
  }
  
  private List<DbCacheManager.OnChangeListener> collectChangeListener()
  {
    ArrayList localArrayList1;
    Object localObject2;
    for (;;)
    {
      synchronized (this.mChangeListeners)
      {
        if (this.mChangeListeners.size() <= 0) {
          break;
        }
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.mChangeListeners.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localWeakReference = null;
          if (localWeakReference == null) {
            continue;
          }
          localArrayList1.add(localWeakReference);
        }
      }
      localObject2 = (DbCacheManager.OnChangeListener)localObject1.get();
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      continue;
      label99:
      localObject2 = localArrayList1;
    }
  }
  
  private List<IDBManagerWrapper.OnCloseListener> collectCloseListener()
  {
    ArrayList localArrayList1;
    Object localObject2;
    for (;;)
    {
      synchronized (this.mCloseListeners)
      {
        if (this.mCloseListeners.size() <= 0) {
          break;
        }
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.mCloseListeners.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localWeakReference = null;
          if (localWeakReference == null) {
            continue;
          }
          localArrayList1.add(localWeakReference);
        }
      }
      localObject2 = (IDBManagerWrapper.OnCloseListener)localObject1.get();
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      continue;
      label99:
      localObject2 = localArrayList1;
    }
  }
  
  private static boolean equals(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  private void notifyClosed()
  {
    Object localObject = collectCloseListener();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IDBManagerWrapper.OnCloseListener localOnCloseListener = (IDBManagerWrapper.OnCloseListener)((Iterator)localObject).next();
        if (localOnCloseListener != null) {
          localOnCloseListener.onClosed(this);
        }
      }
    }
  }
  
  private void notifyDataChanged()
  {
    Object localObject = collectChangeListener();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DbCacheManager.OnChangeListener localOnChangeListener = (DbCacheManager.OnChangeListener)((Iterator)localObject).next();
        if (localOnChangeListener != null) {
          localOnChangeListener.onChanged(this);
        }
      }
    }
  }
  
  public void addChangeListener(DbCacheManager.OnChangeListener paramOnChangeListener)
  {
    if (paramOnChangeListener == null) {
      return;
    }
    synchronized (this.mChangeListeners)
    {
      this.mChangeListeners.add(new WeakReference(paramOnChangeListener));
      return;
    }
  }
  
  public void addCloseListener(IDBManagerWrapper.OnCloseListener paramOnCloseListener)
  {
    if (paramOnCloseListener == null) {
      return;
    }
    synchronized (this.mCloseListeners)
    {
      this.mCloseListeners.add(new WeakReference(paramOnCloseListener));
      return;
    }
  }
  
  public void clear2MaxCapacity(int paramInt, String paramString)
  {
    if (paramInt <= 0) {}
    while (!isDataCreatorValid()) {
      return;
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete from ").append(this.mTable).append(" where _id not in (select _id from ").append(this.mTable);
        if (TextUtils.isEmpty(paramString))
        {
          paramString = this.mSortOrder;
          String str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str = this.mDataCreator.sortOrder();
          }
          if (!TextUtils.isEmpty(str))
          {
            localStringBuilder.append(" order by ");
            localStringBuilder.append(str);
          }
          localStringBuilder.append(" limit 0,").append(paramInt).append(")");
          execSQL(localStringBuilder.toString());
          return;
        }
      }
      finally {}
    }
  }
  
  public void clearData()
  {
    try
    {
      delete((String)null, null);
      return;
    }
    finally {}
  }
  
  public void close()
  {
    super.close();
  }
  
  @Deprecated
  public long dbDeleteData(String paramString)
  {
    try
    {
      long l = delete(paramString, null);
      return l;
    }
    finally {}
  }
  
  public boolean dbInsertData(IDBCacheDataWrapper paramIDBCacheDataWrapper)
  {
    try
    {
      boolean bool = save(1, this.mSelection, this.mWhereArgs, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt)
  {
    try
    {
      boolean bool = save(paramInt, this.mSelection, this.mWhereArgs, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList)
  {
    try
    {
      boolean bool = save(1, this.mSelection, this.mWhereArgs, paramList);
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList, int paramInt)
  {
    try
    {
      boolean bool = save(paramInt, this.mSelection, this.mWhereArgs, paramList);
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList, int paramInt, String paramString)
  {
    throw new RuntimeException("not implements this method dbInsertData(List<? extends IDBCacheDataWrapper> datas, int strategy, String where)");
  }
  
  @Deprecated
  public List<IDBCacheDataWrapper> dbQueryData(String paramString1, String paramString2)
  {
    return dbQueryData(paramString1, null, paramString2);
  }
  
  @Deprecated
  public List<IDBCacheDataWrapper> dbQueryData(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return dbQueryData(paramString1, null, paramString2, paramInt1, paramInt2);
  }
  
  public List<IDBCacheDataWrapper> dbQueryData(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return dbQueryData(paramString1, paramArrayOfString, paramString2, 0, 0);
  }
  
  /* Error */
  public List<IDBCacheDataWrapper> dbQueryData(String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: new 22	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 25	java/util/ArrayList:<init>	()V
    //   13: astore 11
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_1
    //   18: astore 6
    //   20: aload_1
    //   21: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +9 -> 33
    //   27: aload_0
    //   28: getfield 170	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mSelection	Ljava/lang/String;
    //   31: astore 6
    //   33: aload_3
    //   34: astore 7
    //   36: aload_3
    //   37: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifeq +9 -> 49
    //   43: aload_0
    //   44: getfield 128	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mSortOrder	Ljava/lang/String;
    //   47: astore 7
    //   49: aload_2
    //   50: astore_3
    //   51: aload 6
    //   53: ldc 210
    //   55: invokevirtual 213	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +14 -> 72
    //   61: aload_2
    //   62: ifnull +146 -> 208
    //   65: aload_2
    //   66: arraylength
    //   67: ifle +141 -> 208
    //   70: aload_2
    //   71: astore_3
    //   72: iload 4
    //   74: iflt +195 -> 269
    //   77: iload 5
    //   79: ifle +190 -> 269
    //   82: new 108	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   89: iload 4
    //   91: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc 215
    //   96: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 5
    //   101: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 8
    //   109: aload 10
    //   111: astore_1
    //   112: aload 9
    //   114: astore_2
    //   115: aload_0
    //   116: aload 6
    //   118: aload_3
    //   119: aload 7
    //   121: aload 8
    //   123: invokevirtual 219	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:getCursor	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +88 -> 216
    //   131: aload_3
    //   132: astore_1
    //   133: aload_3
    //   134: astore_2
    //   135: aload_3
    //   136: invokeinterface 224 1 0
    //   141: ifle +75 -> 216
    //   144: aload_3
    //   145: astore_1
    //   146: aload_3
    //   147: astore_2
    //   148: aload_3
    //   149: invokeinterface 224 1 0
    //   154: istore 5
    //   156: iconst_0
    //   157: istore 4
    //   159: iload 4
    //   161: iload 5
    //   163: if_icmpge +53 -> 216
    //   166: aload_3
    //   167: astore_1
    //   168: aload_3
    //   169: astore_2
    //   170: aload_0
    //   171: aload_3
    //   172: iload 4
    //   174: invokevirtual 227	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:get	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   177: checkcast 229	com/tencent/mobileqq/qcircle/api/db/DbCacheData
    //   180: astore 6
    //   182: aload 6
    //   184: ifnull +15 -> 199
    //   187: aload_3
    //   188: astore_1
    //   189: aload_3
    //   190: astore_2
    //   191: aload 11
    //   193: aload 6
    //   195: invokevirtual 63	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: iload 4
    //   201: iconst_1
    //   202: iadd
    //   203: istore 4
    //   205: goto -46 -> 159
    //   208: aload_0
    //   209: getfield 172	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mWhereArgs	[Ljava/lang/String;
    //   212: astore_3
    //   213: goto -141 -> 72
    //   216: aload_3
    //   217: ifnull +9 -> 226
    //   220: aload_3
    //   221: invokeinterface 230 1 0
    //   226: aload_0
    //   227: monitorexit
    //   228: aload 11
    //   230: areturn
    //   231: astore_3
    //   232: aload_1
    //   233: astore_2
    //   234: aload_3
    //   235: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   238: aload_1
    //   239: ifnull -13 -> 226
    //   242: aload_1
    //   243: invokeinterface 230 1 0
    //   248: goto -22 -> 226
    //   251: astore_1
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: aload_2
    //   258: ifnull +9 -> 267
    //   261: aload_2
    //   262: invokeinterface 230 1 0
    //   267: aload_1
    //   268: athrow
    //   269: aconst_null
    //   270: astore 8
    //   272: goto -163 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	DbCacheManager
    //   0	275	1	paramString1	String
    //   0	275	2	paramArrayOfString	String[]
    //   0	275	3	paramString2	String
    //   0	275	4	paramInt1	int
    //   0	275	5	paramInt2	int
    //   18	176	6	localObject1	Object
    //   34	86	7	str1	String
    //   107	164	8	str2	String
    //   1	112	9	localObject2	Object
    //   4	106	10	localObject3	Object
    //   13	216	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   115	127	231	java/lang/Exception
    //   135	144	231	java/lang/Exception
    //   148	156	231	java/lang/Exception
    //   170	182	231	java/lang/Exception
    //   191	199	231	java/lang/Exception
    //   20	33	251	finally
    //   36	49	251	finally
    //   51	61	251	finally
    //   65	70	251	finally
    //   82	109	251	finally
    //   208	213	251	finally
    //   220	226	251	finally
    //   226	228	251	finally
    //   242	248	251	finally
    //   252	254	251	finally
    //   261	267	251	finally
    //   267	269	251	finally
    //   115	127	256	finally
    //   135	144	256	finally
    //   148	156	256	finally
    //   170	182	256	finally
    //   191	199	256	finally
    //   234	238	256	finally
  }
  
  public IDBCacheDataWrapper dbQueryFirstData(String paramString1, String paramString2)
  {
    return dbQueryFirstData(paramString1, paramString2, null);
  }
  
  /* Error */
  public IDBCacheDataWrapper dbQueryFirstData(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_2
    //   9: astore 4
    //   11: aload_2
    //   12: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +9 -> 24
    //   18: aload_0
    //   19: getfield 128	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mSortOrder	Ljava/lang/String;
    //   22: astore 4
    //   24: aload_0
    //   25: aload_1
    //   26: aload_3
    //   27: aload 4
    //   29: ldc 241
    //   31: invokevirtual 219	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:getCursor	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_1
    //   35: aload 6
    //   37: astore_3
    //   38: aload_1
    //   39: ifnull +26 -> 65
    //   42: aload 6
    //   44: astore_3
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: invokeinterface 224 1 0
    //   53: ifle +12 -> 65
    //   56: aload_1
    //   57: astore_2
    //   58: aload_0
    //   59: aload_1
    //   60: iconst_0
    //   61: invokevirtual 227	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:get	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   64: astore_3
    //   65: aload_3
    //   66: astore_2
    //   67: aload_1
    //   68: ifnull +11 -> 79
    //   71: aload_1
    //   72: invokeinterface 230 1 0
    //   77: aload_3
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: areturn
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_3
    //   89: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   92: aload 5
    //   94: astore_2
    //   95: aload_1
    //   96: ifnull -17 -> 79
    //   99: aload_1
    //   100: invokeinterface 230 1 0
    //   105: aload 5
    //   107: astore_2
    //   108: goto -29 -> 79
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +9 -> 129
    //   123: aload_2
    //   124: invokeinterface 230 1 0
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: goto -13 -> 119
    //   135: astore_3
    //   136: goto -50 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	DbCacheManager
    //   0	139	1	paramString1	String
    //   0	139	2	paramString2	String
    //   0	139	3	paramArrayOfString	String[]
    //   9	19	4	str	String
    //   1	105	5	localObject1	Object
    //   4	39	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	35	83	java/lang/Exception
    //   11	24	111	finally
    //   71	77	111	finally
    //   79	81	111	finally
    //   99	105	111	finally
    //   112	114	111	finally
    //   123	129	111	finally
    //   129	131	111	finally
    //   24	35	116	finally
    //   47	56	131	finally
    //   58	65	131	finally
    //   88	92	131	finally
    //   47	56	135	java/lang/Exception
    //   58	65	135	java/lang/Exception
  }
  
  public boolean dbSaveData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt)
  {
    try
    {
      boolean bool = save(paramInt, this.mSelection, null, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public boolean dbUpdateData(ContentValues paramContentValues, String paramString)
  {
    return false;
  }
  
  public boolean dbUpdateData(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (update(paramContentValues, paramString, paramArrayOfString) == 0) {}
    return false;
  }
  
  @Deprecated
  public boolean dbUpdateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString)
  {
    return false;
  }
  
  public boolean dbUpdateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString, String[] paramArrayOfString)
  {
    if (paramIDBCacheDataWrapper == null) {}
    ContentValues localContentValues;
    do
    {
      return false;
      localContentValues = new ContentValues();
      paramIDBCacheDataWrapper.writeTo(localContentValues);
    } while (update(localContentValues, paramString, paramArrayOfString) == 0);
    return true;
  }
  
  public int deleteData(String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = delete(paramString, paramArrayOfString);
      return i;
    }
    finally {}
  }
  
  @Deprecated
  public int deleteData(Collection<String> paramCollection)
  {
    try
    {
      int i = delete(paramCollection);
      return i;
    }
    finally {}
  }
  
  public void executeSQL(String paramString)
  {
    try
    {
      execSQL(paramString);
      return;
    }
    finally {}
  }
  
  public int getCount()
  {
    for (;;)
    {
      Object localObject1;
      Object localObject4;
      try
      {
        localObject1 = "select count(1) from " + this.mTable;
        Object localObject5 = localObject1;
        if (!TextUtils.isEmpty(this.mSelection)) {
          localObject5 = (String)localObject1 + " where " + this.mSelection;
        }
        localObject4 = null;
        localObject1 = null;
        try
        {
          localObject5 = rawQuery((String)localObject5, this.mWhereArgs);
          if (localObject5 == null) {
            break label193;
          }
          localObject1 = localObject5;
          localObject4 = localObject5;
          if (!((Cursor)localObject5).moveToFirst()) {
            break label193;
          }
          localObject1 = localObject5;
          localObject4 = localObject5;
          i = ((Cursor)localObject5).getInt(0);
          j = i;
          if (localObject5 != null)
          {
            ((Cursor)localObject5).close();
            j = i;
          }
        }
        catch (Exception localException)
        {
          localObject4 = localObject1;
          localException.printStackTrace();
          if (localObject1 == null) {
            break label188;
          }
          ((Cursor)localObject1).close();
          j = 0;
          continue;
        }
        finally
        {
          if (localObject4 == null) {
            continue;
          }
          localObject4.close();
        }
        return j;
      }
      finally {}
      label188:
      int j = 0;
      continue;
      label193:
      int i = 0;
    }
  }
  
  @Deprecated
  public int getCount(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = "select count(1) from " + this.mTable;
        Object localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString)) {
          localObject2 = (String)localObject1 + " where " + paramString;
        }
        localObject1 = null;
        paramString = null;
        try
        {
          localObject2 = rawQuery((String)localObject2, this.mWhereArgs);
          if (localObject2 == null) {
            break label230;
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (!((Cursor)localObject2).moveToFirst()) {
            break label230;
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          i = ((Cursor)localObject2).getInt(0);
          j = i;
          if (localObject2 != null)
          {
            ((Cursor)localObject2).close();
            j = i;
          }
        }
        catch (Exception localException)
        {
          localObject1 = paramString;
          QLog.e("DbCacheManager", 1, new Object[] { "[getCount] table:" + this.mTable, localException.getMessage() });
          if (paramString == null) {
            break label225;
          }
          paramString.close();
          j = 0;
          continue;
        }
        finally
        {
          if (localObject1 == null) {
            continue;
          }
          ((Cursor)localObject1).close();
        }
        return j;
      }
      finally {}
      label225:
      int j = 0;
      continue;
      label230:
      int i = 0;
    }
  }
  
  public int getCount(String paramString, String[] paramArrayOfString)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = "select count(1) from " + this.mTable;
        Object localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString)) {
          localObject2 = (String)localObject1 + " where " + paramString;
        }
        localObject1 = null;
        paramString = null;
        try
        {
          paramArrayOfString = rawQuery((String)localObject2, paramArrayOfString);
          if (paramArrayOfString == null) {
            break label180;
          }
          paramString = paramArrayOfString;
          localObject1 = paramArrayOfString;
          if (!paramArrayOfString.moveToFirst()) {
            break label180;
          }
          paramString = paramArrayOfString;
          localObject1 = paramArrayOfString;
          i = paramArrayOfString.getInt(0);
          j = i;
          if (paramArrayOfString != null)
          {
            paramArrayOfString.close();
            j = i;
          }
        }
        catch (Exception paramArrayOfString)
        {
          localObject1 = paramString;
          paramArrayOfString.printStackTrace();
          if (paramString == null) {
            break label174;
          }
          paramString.close();
          j = 0;
          continue;
        }
        finally
        {
          if (localObject1 == null) {
            continue;
          }
          ((Cursor)localObject1).close();
        }
        return j;
      }
      finally {}
      label174:
      int j = 0;
      continue;
      label180:
      int i = 0;
    }
  }
  
  public String getFilter()
  {
    return this.mSelection;
  }
  
  public String getSortOrder()
  {
    return this.mSortOrder;
  }
  
  public boolean isClosed()
  {
    return super.isClosed();
  }
  
  protected void onChanged()
  {
    notifyDataChanged();
  }
  
  protected void onClosed()
  {
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).executeOnSubThread(new DbCacheManager.1(this));
  }
  
  public ArrayList<? extends IDBCacheDataWrapper> queryData()
  {
    return queryData(null, null, null, 0, 0);
  }
  
  public ArrayList<? extends IDBCacheDataWrapper> queryData(int paramInt1, int paramInt2)
  {
    return queryData(null, null, null, paramInt1, paramInt2);
  }
  
  public ArrayList<? extends IDBCacheDataWrapper> queryData(String paramString, String[] paramArrayOfString)
  {
    return queryData(paramString, paramArrayOfString, null, 0, 0);
  }
  
  public ArrayList<? extends IDBCacheDataWrapper> queryData(String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    return queryDataWithColumn(null, paramString1, paramArrayOfString, paramString2, paramInt1, paramInt2);
  }
  
  /* Error */
  public ArrayList<? extends IDBCacheDataWrapper> queryDataWithColumn(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: new 22	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 25	java/util/ArrayList:<init>	()V
    //   13: astore 12
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_2
    //   18: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +185 -> 206
    //   24: aload_0
    //   25: getfield 170	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mSelection	Ljava/lang/String;
    //   28: astore 7
    //   30: aload 4
    //   32: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +177 -> 212
    //   38: aload_0
    //   39: getfield 128	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mSortOrder	Ljava/lang/String;
    //   42: astore 4
    //   44: aload 7
    //   46: ifnull +236 -> 282
    //   49: aload 7
    //   51: ldc 210
    //   53: invokevirtual 213	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +226 -> 282
    //   59: aload_3
    //   60: ifnull +155 -> 215
    //   63: aload_3
    //   64: arraylength
    //   65: ifle +150 -> 215
    //   68: goto +220 -> 288
    //   71: iload 5
    //   73: iflt +203 -> 276
    //   76: iload 6
    //   78: ifle +198 -> 276
    //   81: new 108	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   88: iload 5
    //   90: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc 215
    //   95: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload 6
    //   100: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore 9
    //   108: aload 11
    //   110: astore_2
    //   111: aload 10
    //   113: astore_3
    //   114: aload_0
    //   115: aload_1
    //   116: aload 7
    //   118: aload 8
    //   120: aload 4
    //   122: aload 9
    //   124: invokevirtual 337	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:getCursorWithColumn	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +94 -> 223
    //   132: aload_1
    //   133: astore_2
    //   134: aload_1
    //   135: astore_3
    //   136: aload_1
    //   137: invokeinterface 224 1 0
    //   142: ifle +81 -> 223
    //   145: aload_1
    //   146: astore_2
    //   147: aload_1
    //   148: astore_3
    //   149: aload_1
    //   150: invokeinterface 224 1 0
    //   155: istore 6
    //   157: iconst_0
    //   158: istore 5
    //   160: iload 5
    //   162: iload 6
    //   164: if_icmpge +59 -> 223
    //   167: aload_1
    //   168: astore_2
    //   169: aload_1
    //   170: astore_3
    //   171: aload_0
    //   172: aload_1
    //   173: iload 5
    //   175: invokevirtual 227	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:get	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +15 -> 197
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: astore_3
    //   189: aload 12
    //   191: aload 4
    //   193: invokevirtual 63	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: iload 5
    //   199: iconst_1
    //   200: iadd
    //   201: istore 5
    //   203: goto -43 -> 160
    //   206: aload_2
    //   207: astore 7
    //   209: goto -179 -> 30
    //   212: goto -168 -> 44
    //   215: aload_0
    //   216: getfield 172	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mWhereArgs	[Ljava/lang/String;
    //   219: astore_3
    //   220: goto +68 -> 288
    //   223: aload_1
    //   224: ifnull +9 -> 233
    //   227: aload_1
    //   228: invokeinterface 230 1 0
    //   233: aload_0
    //   234: monitorexit
    //   235: aload 12
    //   237: areturn
    //   238: astore_1
    //   239: aload_2
    //   240: astore_3
    //   241: aload_1
    //   242: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   245: aload_2
    //   246: ifnull -13 -> 233
    //   249: aload_2
    //   250: invokeinterface 230 1 0
    //   255: goto -22 -> 233
    //   258: astore_1
    //   259: aload_0
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: aload_3
    //   265: ifnull +9 -> 274
    //   268: aload_3
    //   269: invokeinterface 230 1 0
    //   274: aload_1
    //   275: athrow
    //   276: aconst_null
    //   277: astore 9
    //   279: goto -171 -> 108
    //   282: aload_3
    //   283: astore 8
    //   285: goto -214 -> 71
    //   288: aload_3
    //   289: astore 8
    //   291: goto -220 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	DbCacheManager
    //   0	294	1	paramString1	String
    //   0	294	2	paramString2	String
    //   0	294	3	paramArrayOfString	String[]
    //   0	294	4	paramString3	String
    //   0	294	5	paramInt1	int
    //   0	294	6	paramInt2	int
    //   28	180	7	str1	String
    //   118	172	8	arrayOfString	String[]
    //   106	172	9	str2	String
    //   1	111	10	localObject1	Object
    //   4	105	11	localObject2	Object
    //   13	223	12	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   114	128	238	java/lang/Exception
    //   136	145	238	java/lang/Exception
    //   149	157	238	java/lang/Exception
    //   171	180	238	java/lang/Exception
    //   189	197	238	java/lang/Exception
    //   17	30	258	finally
    //   30	44	258	finally
    //   49	59	258	finally
    //   63	68	258	finally
    //   81	108	258	finally
    //   215	220	258	finally
    //   227	233	258	finally
    //   233	235	258	finally
    //   249	255	258	finally
    //   259	261	258	finally
    //   268	274	258	finally
    //   274	276	258	finally
    //   114	128	263	finally
    //   136	145	263	finally
    //   149	157	263	finally
    //   171	180	263	finally
    //   189	197	263	finally
    //   241	245	263	finally
  }
  
  public IDBCacheDataWrapper queryFirstData(String paramString, String[] paramArrayOfString)
  {
    return queryFirstData(paramString, paramArrayOfString, null);
  }
  
  public IDBCacheDataWrapper queryFirstData(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return (IDBCacheDataWrapper)queryFirstDataWithColumn(null, paramString1, paramArrayOfString, paramString2);
  }
  
  /* Error */
  public Object queryFirstDataWithColumn(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload 4
    //   7: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +64 -> 74
    //   13: aload_0
    //   14: getfield 128	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:mSortOrder	Ljava/lang/String;
    //   17: astore 4
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: aload 4
    //   25: ldc 241
    //   27: invokevirtual 337	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:getCursorWithColumn	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +426 -> 458
    //   35: aload_3
    //   36: invokeinterface 224 1 0
    //   41: ifle +417 -> 458
    //   44: aload_1
    //   45: ifnonnull +32 -> 77
    //   48: aload_0
    //   49: aload_3
    //   50: iconst_0
    //   51: invokevirtual 227	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:get	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   54: astore_2
    //   55: aload_2
    //   56: astore 4
    //   58: aload_3
    //   59: ifnull +393 -> 452
    //   62: aload_3
    //   63: invokeinterface 230 1 0
    //   68: aload_2
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: areturn
    //   74: goto -55 -> 19
    //   77: aload_3
    //   78: ifnull +16 -> 94
    //   81: aload_3
    //   82: invokeinterface 348 1 0
    //   87: istore 6
    //   89: iload 6
    //   91: ifeq +22 -> 113
    //   94: aload_3
    //   95: ifnull +9 -> 104
    //   98: aload_3
    //   99: invokeinterface 230 1 0
    //   104: aload_0
    //   105: monitorexit
    //   106: aconst_null
    //   107: areturn
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: aload_3
    //   114: invokeinterface 275 1 0
    //   119: istore 6
    //   121: iload 6
    //   123: ifeq +335 -> 458
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore 4
    //   131: aload_3
    //   132: invokeinterface 351 1 0
    //   137: ifne +244 -> 381
    //   140: aload_2
    //   141: astore 4
    //   143: aload_3
    //   144: invokeinterface 355 1 0
    //   149: astore 8
    //   151: aload_2
    //   152: astore 7
    //   154: aload 8
    //   156: ifnull +178 -> 334
    //   159: aload_2
    //   160: astore 4
    //   162: aload 8
    //   164: arraylength
    //   165: istore 5
    //   167: aload_2
    //   168: astore 7
    //   170: iload 5
    //   172: ifle +162 -> 334
    //   175: iconst_0
    //   176: istore 5
    //   178: aload_2
    //   179: astore 4
    //   181: iload 5
    //   183: aload 8
    //   185: arraylength
    //   186: if_icmpge +144 -> 330
    //   189: aload 4
    //   191: astore_2
    //   192: aload_1
    //   193: aload 8
    //   195: iload 5
    //   197: aaload
    //   198: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +264 -> 465
    //   204: aload_3
    //   205: aload_3
    //   206: aload 8
    //   208: iload 5
    //   210: aaload
    //   211: invokeinterface 358 2 0
    //   216: invokeinterface 361 2 0
    //   221: tableswitch	default:+242 -> 463, 0:+256->477, 1:+35->256, 2:+72->293, 3:+55->276, 4:+92->313
    //   257: aload_3
    //   258: aload_1
    //   259: invokeinterface 358 2 0
    //   264: invokeinterface 279 2 0
    //   269: invokestatic 367	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: astore_2
    //   273: goto +192 -> 465
    //   276: aload_3
    //   277: aload_3
    //   278: aload_1
    //   279: invokeinterface 358 2 0
    //   284: invokeinterface 371 2 0
    //   289: astore_2
    //   290: goto +175 -> 465
    //   293: aload_3
    //   294: aload_3
    //   295: aload_1
    //   296: invokeinterface 358 2 0
    //   301: invokeinterface 375 2 0
    //   306: invokestatic 380	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   309: astore_2
    //   310: goto +155 -> 465
    //   313: aload_3
    //   314: aload_3
    //   315: aload_1
    //   316: invokeinterface 358 2 0
    //   321: invokeinterface 384 2 0
    //   326: astore_2
    //   327: goto +138 -> 465
    //   330: aload 4
    //   332: astore 7
    //   334: aload 7
    //   336: astore 4
    //   338: aload_3
    //   339: invokeinterface 387 1 0
    //   344: pop
    //   345: aload 7
    //   347: astore_2
    //   348: goto -220 -> 128
    //   351: astore 7
    //   353: aload_3
    //   354: astore_2
    //   355: aload 4
    //   357: astore_1
    //   358: aload 7
    //   360: astore_3
    //   361: aload_3
    //   362: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   365: aload_1
    //   366: astore 4
    //   368: aload_2
    //   369: ifnull +83 -> 452
    //   372: aload_2
    //   373: invokeinterface 230 1 0
    //   378: goto -308 -> 70
    //   381: aload_2
    //   382: astore 4
    //   384: aload_3
    //   385: invokeinterface 230 1 0
    //   390: goto -335 -> 55
    //   393: astore_1
    //   394: aload_3
    //   395: ifnull +9 -> 404
    //   398: aload_3
    //   399: invokeinterface 230 1 0
    //   404: aload_1
    //   405: athrow
    //   406: astore_1
    //   407: aconst_null
    //   408: astore_3
    //   409: goto -15 -> 394
    //   412: astore_1
    //   413: aload_2
    //   414: astore_3
    //   415: goto -21 -> 394
    //   418: astore_3
    //   419: aconst_null
    //   420: astore_1
    //   421: aload 7
    //   423: astore_2
    //   424: goto -63 -> 361
    //   427: astore 4
    //   429: aconst_null
    //   430: astore_1
    //   431: aload_3
    //   432: astore_2
    //   433: aload 4
    //   435: astore_3
    //   436: goto -75 -> 361
    //   439: astore 7
    //   441: aload_3
    //   442: astore_2
    //   443: aload 4
    //   445: astore_1
    //   446: aload 7
    //   448: astore_3
    //   449: goto -88 -> 361
    //   452: aload 4
    //   454: astore_1
    //   455: goto -385 -> 70
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -405 -> 55
    //   463: aconst_null
    //   464: astore_2
    //   465: iload 5
    //   467: iconst_1
    //   468: iadd
    //   469: istore 5
    //   471: aload_2
    //   472: astore 4
    //   474: goto -293 -> 181
    //   477: aconst_null
    //   478: astore_2
    //   479: goto -14 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	DbCacheManager
    //   0	482	1	paramString1	String
    //   0	482	2	paramString2	String
    //   0	482	3	paramArrayOfString	String[]
    //   0	482	4	paramString3	String
    //   165	305	5	i	int
    //   87	35	6	bool	boolean
    //   1	345	7	str	String
    //   351	71	7	localException1	Exception
    //   439	8	7	localException2	Exception
    //   149	58	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   5	19	108	finally
    //   62	68	108	finally
    //   70	72	108	finally
    //   98	104	108	finally
    //   104	106	108	finally
    //   109	111	108	finally
    //   372	378	108	finally
    //   398	404	108	finally
    //   404	406	108	finally
    //   131	140	351	java/lang/Exception
    //   143	151	351	java/lang/Exception
    //   162	167	351	java/lang/Exception
    //   338	345	351	java/lang/Exception
    //   384	390	351	java/lang/Exception
    //   35	44	393	finally
    //   48	55	393	finally
    //   81	89	393	finally
    //   113	121	393	finally
    //   131	140	393	finally
    //   143	151	393	finally
    //   162	167	393	finally
    //   181	189	393	finally
    //   192	256	393	finally
    //   256	273	393	finally
    //   276	290	393	finally
    //   293	310	393	finally
    //   313	327	393	finally
    //   338	345	393	finally
    //   384	390	393	finally
    //   19	31	406	finally
    //   361	365	412	finally
    //   19	31	418	java/lang/Exception
    //   35	44	427	java/lang/Exception
    //   48	55	427	java/lang/Exception
    //   81	89	427	java/lang/Exception
    //   113	121	427	java/lang/Exception
    //   181	189	439	java/lang/Exception
    //   192	256	439	java/lang/Exception
    //   256	273	439	java/lang/Exception
    //   276	290	439	java/lang/Exception
    //   293	310	439	java/lang/Exception
    //   313	327	439	java/lang/Exception
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return super.rawQuery(paramString, paramArrayOfString);
  }
  
  /* Error */
  public List<? extends IDBCacheDataWrapper> rawQueryForListCacheData(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 22	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 25	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: monitorenter
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: invokespecial 388	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +80 -> 105
    //   28: aload_1
    //   29: astore 5
    //   31: aload_1
    //   32: astore 6
    //   34: aload_1
    //   35: invokeinterface 224 1 0
    //   40: ifle +65 -> 105
    //   43: aload_1
    //   44: astore 5
    //   46: aload_1
    //   47: astore 6
    //   49: aload_1
    //   50: invokeinterface 224 1 0
    //   55: istore 4
    //   57: iconst_0
    //   58: istore_3
    //   59: iload_3
    //   60: iload 4
    //   62: if_icmpge +43 -> 105
    //   65: aload_1
    //   66: astore 5
    //   68: aload_1
    //   69: astore 6
    //   71: aload_0
    //   72: aload_1
    //   73: iload_3
    //   74: invokevirtual 227	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:get	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   77: checkcast 229	com/tencent/mobileqq/qcircle/api/db/DbCacheData
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +16 -> 98
    //   85: aload_1
    //   86: astore 5
    //   88: aload_1
    //   89: astore 6
    //   91: aload 7
    //   93: aload_2
    //   94: invokevirtual 63	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   97: pop
    //   98: iload_3
    //   99: iconst_1
    //   100: iadd
    //   101: istore_3
    //   102: goto -43 -> 59
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 230 1 0
    //   115: aload_0
    //   116: monitorexit
    //   117: aload 7
    //   119: areturn
    //   120: astore_1
    //   121: aload 5
    //   123: astore 6
    //   125: aload_1
    //   126: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   129: aload 5
    //   131: ifnull -16 -> 115
    //   134: aload 5
    //   136: invokeinterface 230 1 0
    //   141: goto -26 -> 115
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: aload 6
    //   152: ifnull +10 -> 162
    //   155: aload 6
    //   157: invokeinterface 230 1 0
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	DbCacheManager
    //   0	164	1	paramString	String
    //   0	164	2	paramArrayOfString	String[]
    //   58	44	3	i	int
    //   55	8	4	j	int
    //   15	120	5	str	String
    //   12	144	6	localObject	Object
    //   7	111	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   17	24	120	java/lang/Exception
    //   34	43	120	java/lang/Exception
    //   49	57	120	java/lang/Exception
    //   71	81	120	java/lang/Exception
    //   91	98	120	java/lang/Exception
    //   109	115	144	finally
    //   115	117	144	finally
    //   134	141	144	finally
    //   145	147	144	finally
    //   155	162	144	finally
    //   162	164	144	finally
    //   17	24	149	finally
    //   34	43	149	finally
    //   49	57	149	finally
    //   71	81	149	finally
    //   91	98	149	finally
    //   125	129	149	finally
  }
  
  public void removeCloseListener(IDBManagerWrapper.OnCloseListener paramOnCloseListener)
  {
    if (paramOnCloseListener == null) {
      return;
    }
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mCloseListeners)
      {
        localIterator = this.mCloseListeners.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (WeakReference)localIterator.next();
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            break label78;
          }
          localIterator.remove();
        }
      }
      Object localObject = (IDBManagerWrapper.OnCloseListener)((WeakReference)localObject).get();
      continue;
      label78:
      if (localObject == paramOnCloseListener) {
        localIterator.remove();
      }
    }
  }
  
  public boolean saveData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt)
  {
    try
    {
      boolean bool = save(paramInt, this.mSelection, this.mWhereArgs, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  public boolean saveData(Collection<? extends IDBCacheDataWrapper> paramCollection, int paramInt)
  {
    try
    {
      boolean bool = save(paramInt, this.mSelection, this.mWhereArgs, paramCollection);
      return bool;
    }
    finally {}
  }
  
  public boolean saveData(IDBCacheDataWrapper[] paramArrayOfIDBCacheDataWrapper, int paramInt)
  {
    try
    {
      boolean bool = save(paramInt, this.mSelection, this.mWhereArgs, paramArrayOfIDBCacheDataWrapper);
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public void setFilter(String paramString)
  {
    if (equals(this.mSelection, paramString)) {
      return;
    }
    this.mSelection = paramString;
  }
  
  @Deprecated
  public void setSortOrder(String paramString)
  {
    if (equals(this.mSortOrder, paramString)) {
      return;
    }
    this.mSortOrder = paramString;
  }
  
  @Deprecated
  public void setwhereArgs(String[] paramArrayOfString)
  {
    this.mWhereArgs = paramArrayOfString;
  }
  
  public int updateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString)
  {
    try
    {
      int i = update(paramIDBCacheDataWrapper, paramString, null);
      return i;
    }
    finally {}
  }
  
  public int updateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString, String[] paramArrayOfString)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      paramIDBCacheDataWrapper.writeTo(localContentValues);
      int i = update(localContentValues, paramString, paramArrayOfString);
      return i;
    }
    finally {}
  }
  
  public int updateData(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, String[] paramArrayOfString3)
  {
    try
    {
      int i = update(paramArrayOfString1, paramArrayOfString2, paramString, paramArrayOfString3);
      return i;
    }
    finally {}
  }
  
  public int updateDatas(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, String[] paramArrayOfString3)
  {
    try
    {
      int i = update2(paramArrayOfString1, paramArrayOfString2, paramString, paramArrayOfString3);
      return i;
    }
    finally {}
  }
  
  public int updateDates(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    try
    {
      int i = update(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheManager
 * JD-Core Version:    0.7.0.1
 */