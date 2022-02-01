package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DbCacheManager
  extends AbstractDbCacheManager
  implements IDBManagerWrapper
{
  private final ArrayList<WeakReference<DbCacheManager.OnChangeListener>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private final ArrayList<WeakReference<IDBManagerWrapper.OnCloseListener>> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private String c;
  
  protected DbCacheManager(Context paramContext, Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    super(paramContext, paramClass, paramLong, paramInt1, paramInt2, paramString, paramInt3);
  }
  
  private List<DbCacheManager.OnChangeListener> a()
  {
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Object localObject1;
        for (;;)
        {
          localObject1 = localArrayList1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (WeakReference)localIterator.next();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (DbCacheManager.OnChangeListener)((WeakReference)localObject1).get();
          }
          if (localObject1 != null) {
            localArrayList1.add(localObject1);
          }
        }
        return localObject1;
      }
    }
  }
  
  private List<IDBManagerWrapper.OnCloseListener> b()
  {
    Object localObject3;
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        Object localObject1;
        for (;;)
        {
          localObject1 = localArrayList1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (WeakReference)localIterator.next();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (IDBManagerWrapper.OnCloseListener)((WeakReference)localObject1).get();
          }
          if (localObject1 != null) {
            localArrayList1.add(localObject1);
          }
        }
        return localObject1;
      }
    }
  }
  
  private void d()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DbCacheManager.OnChangeListener localOnChangeListener = (DbCacheManager.OnChangeListener)((Iterator)localObject).next();
        if (localOnChangeListener != null) {
          localOnChangeListener.a(this);
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = b();
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
  
  public int a(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString)
  {
    try
    {
      int i = a(paramIDBCacheDataWrapper, paramString, null);
      return i;
    }
    finally {}
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    return super.a(paramString, paramArrayOfString);
  }
  
  /* Error */
  public ArrayList<? extends IDBCacheDataWrapper> a(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 20	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 23	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_2
    //   12: astore 7
    //   14: aload_2
    //   15: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +9 -> 27
    //   21: aload_0
    //   22: getfield 100	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   25: astore 7
    //   27: aload 4
    //   29: astore 8
    //   31: aload 4
    //   33: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +9 -> 45
    //   39: aload_0
    //   40: getfield 102	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:c	Ljava/lang/String;
    //   43: astore 8
    //   45: aload_3
    //   46: astore 4
    //   48: aload 7
    //   50: ifnull +37 -> 87
    //   53: aload_3
    //   54: astore 4
    //   56: aload 7
    //   58: ldc 104
    //   60: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +24 -> 87
    //   66: aload_3
    //   67: ifnull +14 -> 81
    //   70: aload_3
    //   71: arraylength
    //   72: ifle +9 -> 81
    //   75: aload_3
    //   76: astore 4
    //   78: goto +9 -> 87
    //   81: aload_0
    //   82: getfield 111	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_3
    //   91: iload 5
    //   93: iflt +51 -> 144
    //   96: iload 6
    //   98: ifle +46 -> 144
    //   101: new 113	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   108: astore 9
    //   110: aload 9
    //   112: iload 5
    //   114: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 9
    //   120: ldc 120
    //   122: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 9
    //   128: iload 6
    //   130: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 9
    //   136: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 9
    //   141: goto +6 -> 147
    //   144: aconst_null
    //   145: astore 9
    //   147: aload_0
    //   148: aload_1
    //   149: aload 7
    //   151: aload 4
    //   153: aload 8
    //   155: aload 9
    //   157: invokevirtual 130	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +77 -> 239
    //   165: aload_1
    //   166: astore_3
    //   167: aload_1
    //   168: astore_2
    //   169: aload_1
    //   170: invokeinterface 135 1 0
    //   175: ifle +64 -> 239
    //   178: aload_1
    //   179: astore_3
    //   180: aload_1
    //   181: astore_2
    //   182: aload_1
    //   183: invokeinterface 135 1 0
    //   188: istore 6
    //   190: iconst_0
    //   191: istore 5
    //   193: iload 5
    //   195: iload 6
    //   197: if_icmpge +42 -> 239
    //   200: aload_1
    //   201: astore_3
    //   202: aload_1
    //   203: astore_2
    //   204: aload_0
    //   205: aload_1
    //   206: iload 5
    //   208: invokevirtual 138	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   211: astore 4
    //   213: aload 4
    //   215: ifnull +15 -> 230
    //   218: aload_1
    //   219: astore_3
    //   220: aload_1
    //   221: astore_2
    //   222: aload 10
    //   224: aload 4
    //   226: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: iload 5
    //   232: iconst_1
    //   233: iadd
    //   234: istore 5
    //   236: goto -43 -> 193
    //   239: aload_1
    //   240: ifnull +32 -> 272
    //   243: aload_1
    //   244: invokeinterface 141 1 0
    //   249: goto +23 -> 272
    //   252: astore_1
    //   253: goto +24 -> 277
    //   256: astore_1
    //   257: aload_2
    //   258: astore_3
    //   259: aload_1
    //   260: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   263: aload_2
    //   264: ifnull +8 -> 272
    //   267: aload_2
    //   268: astore_1
    //   269: goto -26 -> 243
    //   272: aload_0
    //   273: monitorexit
    //   274: aload 10
    //   276: areturn
    //   277: aload_3
    //   278: ifnull +9 -> 287
    //   281: aload_3
    //   282: invokeinterface 141 1 0
    //   287: aload_1
    //   288: athrow
    //   289: astore_1
    //   290: aload_0
    //   291: monitorexit
    //   292: goto +5 -> 297
    //   295: aload_1
    //   296: athrow
    //   297: goto -2 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	DbCacheManager
    //   0	300	1	paramString1	String
    //   0	300	2	paramString2	String
    //   0	300	3	paramArrayOfString	String[]
    //   0	300	4	paramString3	String
    //   0	300	5	paramInt1	int
    //   0	300	6	paramInt2	int
    //   12	138	7	str1	String
    //   29	125	8	str2	String
    //   108	48	9	localObject	Object
    //   7	268	10	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   147	161	252	finally
    //   169	178	252	finally
    //   182	190	252	finally
    //   204	213	252	finally
    //   222	230	252	finally
    //   259	263	252	finally
    //   147	161	256	java/lang/Exception
    //   169	178	256	java/lang/Exception
    //   182	190	256	java/lang/Exception
    //   204	213	256	java/lang/Exception
    //   222	230	256	java/lang/Exception
    //   14	27	289	finally
    //   31	45	289	finally
    //   56	66	289	finally
    //   70	75	289	finally
    //   81	87	289	finally
    //   101	141	289	finally
    //   243	249	289	finally
    //   272	274	289	finally
    //   281	287	289	finally
    //   287	289	289	finally
    //   290	292	289	finally
  }
  
  public ArrayList<? extends IDBCacheDataWrapper> a(String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    return a(null, paramString1, paramArrayOfString, paramString2, paramInt1, paramInt2);
  }
  
  public List<IDBCacheDataWrapper> a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return a(paramString1, paramArrayOfString, paramString2, 0, 0);
  }
  
  /* Error */
  public List<IDBCacheDataWrapper> a(String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 20	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 23	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: astore 6
    //   14: aload_1
    //   15: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +9 -> 27
    //   21: aload_0
    //   22: getfield 100	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   25: astore 6
    //   27: aload_3
    //   28: astore 7
    //   30: aload_3
    //   31: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +9 -> 43
    //   37: aload_0
    //   38: getfield 102	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:c	Ljava/lang/String;
    //   41: astore 7
    //   43: aload_2
    //   44: astore_3
    //   45: aload 6
    //   47: ldc 104
    //   49: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +22 -> 74
    //   55: aload_2
    //   56: ifnull +13 -> 69
    //   59: aload_2
    //   60: arraylength
    //   61: ifle +8 -> 69
    //   64: aload_2
    //   65: astore_3
    //   66: goto +8 -> 74
    //   69: aload_0
    //   70: getfield 111	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_2
    //   78: iload 4
    //   80: iflt +51 -> 131
    //   83: iload 5
    //   85: ifle +46 -> 131
    //   88: new 113	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   95: astore 8
    //   97: aload 8
    //   99: iload 4
    //   101: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: ldc 120
    //   109: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 8
    //   115: iload 5
    //   117: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 8
    //   123: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 8
    //   128: goto +6 -> 134
    //   131: aconst_null
    //   132: astore 8
    //   134: aload_0
    //   135: aload 6
    //   137: aload_3
    //   138: aload 7
    //   140: aload 8
    //   142: invokevirtual 157	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +80 -> 227
    //   150: aload_3
    //   151: astore_2
    //   152: aload_3
    //   153: astore_1
    //   154: aload_3
    //   155: invokeinterface 135 1 0
    //   160: ifle +67 -> 227
    //   163: aload_3
    //   164: astore_2
    //   165: aload_3
    //   166: astore_1
    //   167: aload_3
    //   168: invokeinterface 135 1 0
    //   173: istore 5
    //   175: iconst_0
    //   176: istore 4
    //   178: iload 4
    //   180: iload 5
    //   182: if_icmpge +45 -> 227
    //   185: aload_3
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: aload_0
    //   190: aload_3
    //   191: iload 4
    //   193: invokevirtual 138	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   196: checkcast 159	com/tencent/mobileqq/qcircle/api/db/DbCacheData
    //   199: astore 6
    //   201: aload 6
    //   203: ifnull +15 -> 218
    //   206: aload_3
    //   207: astore_2
    //   208: aload_3
    //   209: astore_1
    //   210: aload 9
    //   212: aload 6
    //   214: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   217: pop
    //   218: iload 4
    //   220: iconst_1
    //   221: iadd
    //   222: istore 4
    //   224: goto -46 -> 178
    //   227: aload_3
    //   228: ifnull +32 -> 260
    //   231: aload_3
    //   232: astore_1
    //   233: aload_1
    //   234: invokeinterface 141 1 0
    //   239: goto +21 -> 260
    //   242: astore_1
    //   243: goto +22 -> 265
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   253: aload_1
    //   254: ifnull +6 -> 260
    //   257: goto -24 -> 233
    //   260: aload_0
    //   261: monitorexit
    //   262: aload 9
    //   264: areturn
    //   265: aload_2
    //   266: ifnull +9 -> 275
    //   269: aload_2
    //   270: invokeinterface 141 1 0
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: aload_0
    //   279: monitorexit
    //   280: goto +5 -> 285
    //   283: aload_1
    //   284: athrow
    //   285: goto -2 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	DbCacheManager
    //   0	288	1	paramString1	String
    //   0	288	2	paramArrayOfString	String[]
    //   0	288	3	paramString2	String
    //   0	288	4	paramInt1	int
    //   0	288	5	paramInt2	int
    //   12	201	6	localObject1	Object
    //   28	111	7	str	String
    //   95	46	8	localObject2	Object
    //   7	256	9	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   134	146	242	finally
    //   154	163	242	finally
    //   167	175	242	finally
    //   189	201	242	finally
    //   210	218	242	finally
    //   249	253	242	finally
    //   134	146	246	java/lang/Exception
    //   154	163	246	java/lang/Exception
    //   167	175	246	java/lang/Exception
    //   189	201	246	java/lang/Exception
    //   210	218	246	java/lang/Exception
    //   14	27	277	finally
    //   30	43	277	finally
    //   45	55	277	finally
    //   59	64	277	finally
    //   69	74	277	finally
    //   88	128	277	finally
    //   233	239	277	finally
    //   260	262	277	finally
    //   269	275	277	finally
    //   275	277	277	finally
    //   278	280	277	finally
  }
  
  protected void a()
  {
    RFThreadManager.execute(new DbCacheManager.1(this));
  }
  
  public void a(IDBManagerWrapper.OnCloseListener paramOnCloseListener)
  {
    if (paramOnCloseListener == null) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (IDBManagerWrapper.OnCloseListener)((WeakReference)localObject).get();
        }
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == paramOnCloseListener) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramOnCloseListener;
    }
  }
  
  public void addCloseListener(IDBManagerWrapper.OnCloseListener paramOnCloseListener)
  {
    if (paramOnCloseListener == null) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new WeakReference(paramOnCloseListener));
      return;
    }
  }
  
  protected void b()
  {
    d();
  }
  
  public void c()
  {
    try
    {
      a((String)null, null);
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
      long l = a(paramString, null);
      return l;
    }
    finally {}
  }
  
  public boolean dbInsertData(IDBCacheDataWrapper paramIDBCacheDataWrapper)
  {
    try
    {
      boolean bool = a(1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt)
  {
    try
    {
      boolean bool = a(paramInt, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList)
  {
    try
    {
      boolean bool = a(1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, paramList);
      return bool;
    }
    finally {}
  }
  
  public boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList, int paramInt)
  {
    try
    {
      boolean bool = a(paramInt, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, paramList);
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
    return a(paramString1, null, paramString2);
  }
  
  @Deprecated
  public List<IDBCacheDataWrapper> dbQueryData(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return a(paramString1, null, paramString2, paramInt1, paramInt2);
  }
  
  public IDBCacheDataWrapper dbQueryFirstData(String paramString1, String paramString2)
  {
    return dbQueryFirstData(paramString1, paramString2, null);
  }
  
  /* Error */
  public IDBCacheDataWrapper dbQueryFirstData(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: astore 4
    //   5: aload_2
    //   6: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +9 -> 18
    //   12: aload_0
    //   13: getfield 102	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:c	Ljava/lang/String;
    //   16: astore 4
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore 7
    //   27: aload_0
    //   28: aload_1
    //   29: aload_3
    //   30: aload 4
    //   32: ldc 226
    //   34: invokevirtual 157	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_2
    //   38: aload 7
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +37 -> 79
    //   45: aload 7
    //   47: astore_1
    //   48: aload_2
    //   49: astore_3
    //   50: aload_2
    //   51: invokeinterface 135 1 0
    //   56: ifle +23 -> 79
    //   59: aload_2
    //   60: astore_3
    //   61: aload_0
    //   62: aload_2
    //   63: iconst_0
    //   64: invokevirtual 138	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;
    //   67: astore_1
    //   68: goto +11 -> 79
    //   71: astore_3
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: astore_2
    //   76: goto +29 -> 105
    //   79: aload_1
    //   80: astore_3
    //   81: aload_2
    //   82: ifnull +44 -> 126
    //   85: aload_1
    //   86: astore_3
    //   87: aload_2
    //   88: invokeinterface 141 1 0
    //   93: goto +33 -> 126
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_3
    //   99: goto +31 -> 130
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_3
    //   107: aload_2
    //   108: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   111: aload 6
    //   113: astore_3
    //   114: aload_1
    //   115: ifnull +11 -> 126
    //   118: aload 5
    //   120: astore_3
    //   121: aload_1
    //   122: astore_2
    //   123: goto -36 -> 87
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_3
    //   129: areturn
    //   130: aload_3
    //   131: ifnull +9 -> 140
    //   134: aload_3
    //   135: invokeinterface 141 1 0
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: goto +5 -> 150
    //   148: aload_1
    //   149: athrow
    //   150: goto -2 -> 148
    //   153: astore_1
    //   154: goto -24 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	DbCacheManager
    //   0	157	1	paramString1	String
    //   0	157	2	paramString2	String
    //   0	157	3	paramArrayOfString	String[]
    //   3	28	4	str	String
    //   19	100	5	localObject1	Object
    //   22	90	6	localObject2	Object
    //   25	21	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   50	59	71	java/lang/Exception
    //   61	68	71	java/lang/Exception
    //   27	38	96	finally
    //   27	38	102	java/lang/Exception
    //   5	18	142	finally
    //   87	93	142	finally
    //   126	128	142	finally
    //   134	140	142	finally
    //   140	142	142	finally
    //   143	145	142	finally
    //   50	59	153	finally
    //   61	68	153	finally
    //   107	111	153	finally
  }
  
  @Deprecated
  public boolean dbUpdateData(ContentValues paramContentValues, String paramString)
  {
    return false;
  }
  
  public boolean dbUpdateData(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (a(paramContentValues, paramString, paramArrayOfString) == 0) {}
    return false;
  }
  
  @Deprecated
  public boolean dbUpdateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString)
  {
    return false;
  }
  
  public int deleteData(String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = a(paramString, paramArrayOfString);
      return i;
    }
    finally {}
  }
  
  /* Error */
  @Deprecated
  public int getCount(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 113	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   9: astore 6
    //   11: aload 6
    //   13: ldc 237
    //   15: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 6
    //   21: aload_0
    //   22: getfield 239	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 6
    //   31: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 6
    //   36: aload 6
    //   38: astore 7
    //   40: aload_1
    //   41: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +42 -> 86
    //   47: new 113	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   54: astore 7
    //   56: aload 7
    //   58: aload 6
    //   60: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 7
    //   66: ldc 241
    //   68: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 7
    //   74: aload_1
    //   75: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 7
    //   81: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 7
    //   86: aconst_null
    //   87: astore_1
    //   88: aconst_null
    //   89: astore 6
    //   91: iconst_0
    //   92: istore 4
    //   94: iconst_0
    //   95: istore_3
    //   96: iconst_0
    //   97: istore 5
    //   99: aload_0
    //   100: aload 7
    //   102: aload_0
    //   103: getfield 111	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   106: invokevirtual 242	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore 7
    //   111: iload 5
    //   113: istore_2
    //   114: aload 7
    //   116: ifnull +39 -> 155
    //   119: iload 5
    //   121: istore_2
    //   122: aload 7
    //   124: astore 6
    //   126: aload 7
    //   128: astore_1
    //   129: aload 7
    //   131: invokeinterface 245 1 0
    //   136: ifeq +19 -> 155
    //   139: aload 7
    //   141: astore 6
    //   143: aload 7
    //   145: astore_1
    //   146: aload 7
    //   148: iconst_0
    //   149: invokeinterface 249 2 0
    //   154: istore_2
    //   155: iload_2
    //   156: istore_3
    //   157: aload 7
    //   159: ifnull +107 -> 266
    //   162: aload 7
    //   164: astore_1
    //   165: aload_1
    //   166: invokeinterface 141 1 0
    //   171: iload_2
    //   172: istore_3
    //   173: goto +93 -> 266
    //   176: astore_1
    //   177: goto +93 -> 270
    //   180: astore 7
    //   182: aload_1
    //   183: astore 6
    //   185: getstatic 255	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   188: istore_2
    //   189: aload_1
    //   190: astore 6
    //   192: new 113	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   199: astore 8
    //   201: aload_1
    //   202: astore 6
    //   204: aload 8
    //   206: ldc_w 257
    //   209: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: astore 6
    //   216: aload 8
    //   218: aload_0
    //   219: getfield 239	com/tencent/mobileqq/qcircle/api/db/DbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: astore 6
    //   229: ldc_w 259
    //   232: iload_2
    //   233: iconst_2
    //   234: anewarray 261	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload 8
    //   241: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload 7
    //   249: invokevirtual 264	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 267	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: iload 4
    //   262: istore_2
    //   263: goto -98 -> 165
    //   266: aload_0
    //   267: monitorexit
    //   268: iload_3
    //   269: ireturn
    //   270: aload 6
    //   272: ifnull +10 -> 282
    //   275: aload 6
    //   277: invokeinterface 141 1 0
    //   282: aload_1
    //   283: athrow
    //   284: astore_1
    //   285: aload_0
    //   286: monitorexit
    //   287: goto +5 -> 292
    //   290: aload_1
    //   291: athrow
    //   292: goto -2 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	DbCacheManager
    //   0	295	1	paramString	String
    //   113	150	2	i	int
    //   95	174	3	j	int
    //   92	169	4	k	int
    //   97	23	5	m	int
    //   9	267	6	localObject1	Object
    //   38	125	7	localObject2	Object
    //   180	68	7	localException	java.lang.Exception
    //   199	41	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   99	111	176	finally
    //   129	139	176	finally
    //   146	155	176	finally
    //   185	189	176	finally
    //   192	201	176	finally
    //   204	213	176	finally
    //   216	226	176	finally
    //   229	256	176	finally
    //   99	111	180	java/lang/Exception
    //   129	139	180	java/lang/Exception
    //   146	155	180	java/lang/Exception
    //   2	36	284	finally
    //   40	86	284	finally
    //   165	171	284	finally
    //   266	268	284	finally
    //   275	282	284	finally
    //   282	284	284	finally
    //   285	287	284	finally
  }
  
  public boolean isClosed()
  {
    return super.isClosed();
  }
  
  public ArrayList<? extends IDBCacheDataWrapper> queryData()
  {
    return a(null, null, null, 0, 0);
  }
  
  public boolean saveData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt)
  {
    try
    {
      boolean bool = a(paramInt, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, new IDBCacheDataWrapper[] { paramIDBCacheDataWrapper });
      return bool;
    }
    finally {}
  }
  
  public int updateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString, String[] paramArrayOfString)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      paramIDBCacheDataWrapper.writeTo(localContentValues);
      int i = a(localContentValues, paramString, paramArrayOfString);
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheManager
 * JD-Core Version:    0.7.0.1
 */