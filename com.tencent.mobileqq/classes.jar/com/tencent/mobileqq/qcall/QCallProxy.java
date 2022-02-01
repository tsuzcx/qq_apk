package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.util.SparseIntArray;
import com.tencent.imcore.message.UinMD5Cache;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QCallProxy
  extends BaseProxy
{
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 20;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List<QCallRecent> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  private final Map<String, QCallRecent> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<String, List<QCallRecord>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public QCallProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private int a(String paramString)
  {
    paramString = paramString.split("[^0-9]");
    int k = -1;
    for (;;)
    {
      try
      {
        int m = paramString.length;
        i = 0;
        j = k;
        if (i < m)
        {
          String str = paramString[i];
          if ((str == null) || (str.length() <= 0)) {
            continue;
          }
          j = Integer.parseInt(str);
        }
      }
      catch (Exception paramString)
      {
        int i;
        int j = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("QCallProxy", 2, paramString.getMessage(), paramString);
      }
      return j;
      i += 1;
    }
    return -1;
  }
  
  private Cursor a(String paramString)
  {
    paramString = UinMD5Cache.a(paramString);
    paramString = "select name from sqlite_master where (type='table') and (name like 'qc/_%/_" + paramString + "' escape '/') and (name not like 'qc/_" + 3000 + "/_" + paramString + "' escape '/') and (name not like 'qc/_" + 8 + "/_" + paramString + "' escape '/') order by name;";
    try
    {
      paramString = ((QQAppInterface)this.app).getReadableDatabase().rawQuery(paramString, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QCallProxy", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  private Object a(String arg1, int paramInt)
  {
    String str = a(???, paramInt);
    if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = ((QQAppInterface)this.app).getCurrentAccountUin().concat("_").concat(paramString);
    if (paramInt != 3000)
    {
      paramString = str;
      if (paramInt != 8) {}
    }
    else
    {
      paramString = str.concat(String.valueOf(paramInt));
    }
    return paramString;
  }
  
  private ArrayList<QCallRecord> a(List<QCallRecord> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new QCallProxy.2(this));
    SparseIntArray localSparseIntArray = new SparseIntArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      QCallRecord localQCallRecord1 = (QCallRecord)localIterator.next();
      if ((localQCallRecord1 != null) && (localQCallRecord1.type != QCallRecord.TYPE_DATE))
      {
        if (localSparseIntArray.get(localQCallRecord1.getDate(), -1) == -1)
        {
          QCallRecord localQCallRecord2 = new QCallRecord(QCallRecord.TYPE_DATE);
          localQCallRecord2.time = localQCallRecord1.time;
          localArrayList.add(localQCallRecord2);
          localSparseIntArray.put(localQCallRecord1.getDate(), 0);
        }
        localArrayList.add(localQCallRecord1);
      }
    }
    paramList.clear();
    return localArrayList;
  }
  
  private void a(QCallRecent paramQCallRecent, boolean paramBoolean)
  {
    if ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      Utils.a("QCallProxy");
    }
    while ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject1 = paramQCallRecent;
    for (;;)
    {
      try
      {
        if (paramQCallRecent.type != 1)
        {
          localObject1 = paramQCallRecent;
          if (paramQCallRecent.type != 3000)
          {
            localObject1 = paramQCallRecent;
            if (paramQCallRecent.type != 8)
            {
              localObject2 = new ArrayList();
              localObject1 = UinTypeUtil.c;
              j = localObject1.length;
              i = 0;
              if (i < j)
              {
                int k = localObject1[i];
                if (k == paramQCallRecent.type) {
                  break label697;
                }
                QCallRecent localQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, k));
                if (localQCallRecent == null) {
                  break label697;
                }
                ((ArrayList)localObject2).add(localQCallRecent);
                break label697;
              }
              j = ((ArrayList)localObject2).size();
              localObject1 = paramQCallRecent;
              if (j > 0)
              {
                if (paramQCallRecent.getStatus() != 1000) {
                  break label692;
                }
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(0);
                this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                ((QCallRecent)localObject1).type = paramQCallRecent.type;
                ((QCallRecent)localObject1).troopUin = paramQCallRecent.troopUin;
                ((QCallRecent)localObject1).displayName = paramQCallRecent.displayName;
                ((QCallRecent)localObject1).lastCallTime = paramQCallRecent.lastCallTime;
                ((QCallRecent)localObject1).lastCallMsg = paramQCallRecent.lastCallMsg;
                ((QCallRecent)localObject1).sendFlag = paramQCallRecent.sendFlag;
                ((QCallRecent)localObject1).isVideo = paramQCallRecent.isVideo;
                ((QCallRecent)localObject1).missedCallCount = paramQCallRecent.missedCallCount;
                ((QCallRecent)localObject1).isLastCallRealMissed = paramQCallRecent.isLastCallRealMissed;
                i = 1;
                paramQCallRecent = (QCallRecent)localObject1;
                localObject1 = paramQCallRecent;
                if (i < j)
                {
                  localObject1 = (QCallRecent)((ArrayList)localObject2).get(i);
                  this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                  a((QCallRecent)localObject1);
                  i += 1;
                  continue;
                }
              }
            }
          }
        }
        paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
        Object localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "saveRecentCall before put:" + Arrays.toString((Object[])localObject2));
        }
        this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type), localObject1);
        paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
        localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "saveRecentCall after put:" + Arrays.toString((Object[])localObject2));
        }
        this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          paramQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilList.get(i);
          if (((QCallRecent)localObject1).lastCallTime > paramQCallRecent.lastCallTime)
          {
            this.jdField_a_of_type_JavaUtilList.add(i, localObject1);
            i = 1;
            if (i == 0) {
              this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), localObject1);
            }
            if (!paramBoolean) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QCallProxy", 2, "insertOrUpdateRecentCallToDB uin: " + ((QCallRecent)localObject1).uin + ",callstatus:" + ((QCallRecent)localObject1).state);
            }
            b((QCallRecent)localObject1);
            return;
          }
          i += 1;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label692:
      int i = 0;
      continue;
      label697:
      i += 1;
    }
  }
  
  private boolean a(QCallRecord paramQCallRecord)
  {
    this.proxyManager.addMsgQueue(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 3, null);
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if ((paramInt == 3000) || (paramInt == 8)) {
      this.proxyManager.addMsgQueue(paramString, paramInt, QCallRecord.getTableName(paramString, paramInt), null, null, 2, null);
    }
    for (;;)
    {
      return true;
      ThreadManager.excute(new QCallProxy.3(this, paramString), 16, null, false);
    }
  }
  
  private String b(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  /* Error */
  private List<QCallRecord> b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 130	com/tencent/mobileqq/qcall/QCallProxy:app	Lmqq/app/AppRuntime;
    //   13: checkcast 132	com/tencent/mobileqq/app/QQAppInterface
    //   16: invokevirtual 397	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   19: astore 10
    //   21: aload 10
    //   23: ifnonnull +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: iload_2
    //   29: sipush 3000
    //   32: if_icmpeq +9 -> 41
    //   35: iload_2
    //   36: bipush 8
    //   38: if_icmpne +164 -> 202
    //   41: aload_1
    //   42: iload_2
    //   43: invokestatic 377	com/tencent/mobileqq/data/QCallRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   46: astore_1
    //   47: aload 10
    //   49: aload_1
    //   50: invokevirtual 400	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   53: istore_2
    //   54: iload_2
    //   55: aload_0
    //   56: getfield 45	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_Int	I
    //   59: if_icmple +39 -> 98
    //   62: aload 10
    //   64: ldc_w 402
    //   67: iconst_3
    //   68: anewarray 40	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_1
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: iload_2
    //   82: aload_0
    //   83: getfield 45	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_Int	I
    //   86: isub
    //   87: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 409	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: invokevirtual 413	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   97: pop
    //   98: new 107	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 415
    //   108: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 417
    //   118: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_1
    //   125: aload_0
    //   126: invokespecial 419	com/tencent/mobileqq/qcall/QCallProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   129: ldc 225
    //   131: aload_1
    //   132: aconst_null
    //   133: invokevirtual 422	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +312 -> 450
    //   141: invokestatic 427	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   144: lstore 4
    //   146: aload_1
    //   147: invokeinterface 214 1 0
    //   152: astore 6
    //   154: aload 6
    //   156: invokeinterface 219 1 0
    //   161: ifeq +289 -> 450
    //   164: aload 6
    //   166: invokeinterface 223 1 0
    //   171: checkcast 225	com/tencent/mobileqq/data/QCallRecord
    //   174: astore 7
    //   176: aload 7
    //   178: ifnull -24 -> 154
    //   181: aload 7
    //   183: getfield 242	com/tencent/mobileqq/data/QCallRecord:time	J
    //   186: lload 4
    //   188: lcmp
    //   189: ifle -35 -> 154
    //   192: aload 7
    //   194: lload 4
    //   196: putfield 242	com/tencent/mobileqq/data/QCallRecord:time	J
    //   199: goto -45 -> 154
    //   202: aload_0
    //   203: aload_1
    //   204: invokespecial 100	com/tencent/mobileqq/qcall/QCallProxy:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   207: astore 6
    //   209: aload 9
    //   211: astore 7
    //   213: aload 6
    //   215: ifnull +195 -> 410
    //   218: new 47	java/util/ArrayList
    //   221: dup
    //   222: invokespecial 208	java/util/ArrayList:<init>	()V
    //   225: astore_1
    //   226: aload 6
    //   228: ldc_w 429
    //   231: invokeinterface 434 2 0
    //   236: istore_2
    //   237: aload 6
    //   239: invokeinterface 437 1 0
    //   244: ifeq +163 -> 407
    //   247: aload 6
    //   249: iload_2
    //   250: invokeinterface 440 2 0
    //   255: invokestatic 445	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore 7
    //   260: aload 10
    //   262: aload 7
    //   264: invokevirtual 400	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   267: istore_3
    //   268: iload_3
    //   269: ifle -32 -> 237
    //   272: iload_3
    //   273: aload_0
    //   274: getfield 45	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_Int	I
    //   277: if_icmple +41 -> 318
    //   280: aload 10
    //   282: ldc_w 402
    //   285: iconst_3
    //   286: anewarray 40	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload 7
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 7
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: iload_3
    //   302: aload_0
    //   303: getfield 45	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_Int	I
    //   306: isub
    //   307: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: invokestatic 409	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   314: invokevirtual 413	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   317: pop
    //   318: new 107	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 415
    //   328: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 7
    //   333: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 417
    //   339: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: astore 7
    //   347: aload_0
    //   348: invokespecial 419	com/tencent/mobileqq/qcall/QCallProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   351: ldc 225
    //   353: aload 7
    //   355: aconst_null
    //   356: invokevirtual 422	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   359: astore 7
    //   361: aload 7
    //   363: ifnull +12 -> 375
    //   366: aload_1
    //   367: aload 7
    //   369: invokeinterface 449 2 0
    //   374: pop
    //   375: aload_1
    //   376: new 451	com/tencent/mobileqq/qcall/QCallProxy$4
    //   379: dup
    //   380: aload_0
    //   381: invokespecial 452	com/tencent/mobileqq/qcall/QCallProxy$4:<init>	(Lcom/tencent/mobileqq/qcall/QCallProxy;)V
    //   384: invokestatic 204	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   387: goto -150 -> 237
    //   390: astore 7
    //   392: aload 6
    //   394: ifnull +78 -> 472
    //   397: aload 6
    //   399: invokeinterface 455 1 0
    //   404: goto -267 -> 137
    //   407: aload_1
    //   408: astore 7
    //   410: aload 7
    //   412: astore_1
    //   413: aload 6
    //   415: ifnull -278 -> 137
    //   418: aload 6
    //   420: invokeinterface 455 1 0
    //   425: aload 7
    //   427: astore_1
    //   428: goto -291 -> 137
    //   431: astore_1
    //   432: aload 8
    //   434: astore 6
    //   436: aload 6
    //   438: ifnull +10 -> 448
    //   441: aload 6
    //   443: invokeinterface 455 1 0
    //   448: aload_1
    //   449: athrow
    //   450: aload_1
    //   451: areturn
    //   452: astore_1
    //   453: goto -17 -> 436
    //   456: astore_1
    //   457: aconst_null
    //   458: astore_1
    //   459: aload 7
    //   461: astore 6
    //   463: goto -71 -> 392
    //   466: astore_1
    //   467: aconst_null
    //   468: astore_1
    //   469: goto -77 -> 392
    //   472: goto -335 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	QCallProxy
    //   0	475	1	paramString	String
    //   0	475	2	paramInt	int
    //   267	40	3	i	int
    //   144	51	4	l	long
    //   152	310	6	localObject1	Object
    //   7	361	7	localObject2	Object
    //   390	1	7	localException	Exception
    //   408	52	7	str	String
    //   4	429	8	localObject3	Object
    //   1	209	9	localObject4	Object
    //   19	262	10	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   226	237	390	java/lang/Exception
    //   237	268	390	java/lang/Exception
    //   272	318	390	java/lang/Exception
    //   318	361	390	java/lang/Exception
    //   366	375	390	java/lang/Exception
    //   375	387	390	java/lang/Exception
    //   202	209	431	finally
    //   218	226	452	finally
    //   226	237	452	finally
    //   237	268	452	finally
    //   272	318	452	finally
    //   318	361	452	finally
    //   366	375	452	finally
    //   375	387	452	finally
    //   202	209	456	java/lang/Exception
    //   218	226	466	java/lang/Exception
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      QCallRecent localQCallRecent2 = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      QCallRecent localQCallRecent1 = localQCallRecent2;
      if (localQCallRecent2 == null)
      {
        localQCallRecent1 = new QCallRecent();
        localQCallRecent1.uin = paramString;
        localQCallRecent1.type = paramInt;
        localQCallRecent1.displayName = localQCallRecent1.uin;
      }
      return localQCallRecent1;
    }
  }
  
  public List<QCallRecent> a()
  {
    return a(null);
  }
  
  public List<QCallRecent> a(QCallProxy.QueryRecentCallsListener arg1)
  {
    ThreadManager.post(new QCallProxy.5(this, ???), 5, null, false);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
        if ((localQCallRecent == null) || (localQCallRecent.uin == null) || (localQCallRecent.uin.length() < 2)) {
          Utils.a("QCallProxy");
        }
        if ((localQCallRecent != null) && (localQCallRecent.uin != null) && (localQCallRecent.uin.length() >= 2)) {
          localArrayList.add(localQCallRecent);
        }
      }
    }
    return localList;
  }
  
  public List<QCallRecord> a(String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Object localObject = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    try
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localList != null) {
        return localList;
      }
      localList = b(paramString, paramInt);
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord (DB) records size:" + paramString.size());
        QLog.d("QCallProxy", 2, "getListRecord" + paramString);
      }
      paramString = a(paramString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramQCallRecent);
      this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, paramQCallRecent.type));
      this.proxyManager.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 5, null);
      return;
    }
  }
  
  public void a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord == null) {
      return;
    }
    for (;;)
    {
      synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        String str = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localList == null)
        {
          localList = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
          localList.add(paramQCallRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("insertRecord ThreadName:").append(Thread.currentThread().getName()).append(" insertRecord records size:");
            if (localList != null)
            {
              i = localList.size();
              QLog.d("QCallProxy", 2, i);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, a(localList));
            a(paramQCallRecord);
            return;
          }
          int i = 0;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = a(paramString, paramInt);
    localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    if (localObject != null) {
      ((List)localObject).clear();
    }
    a(paramString, paramInt);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!a(paramString1, paramInt1).equals(a(paramString2, paramInt2)))
    {
      Object localObject = a(paramString1, paramInt1);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCallRecord localQCallRecord = (QCallRecord)((Iterator)localObject).next();
          localQCallRecord.friendUin = paramString2;
          localQCallRecord.uinType = paramInt2;
          a(localQCallRecord);
        }
        a(paramString1, paramInt1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = ((QQAppInterface)this.app).getApp().getSharedPreferences(((QQAppInterface)this.app).getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("Conversation_call_prompt_flag", false);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public QCallRecent b(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      return paramString;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====start====");
    }
    this.jdField_b_of_type_Boolean = ((QQAppInterface)this.app).getApp().getSharedPreferences(((QQAppInterface)this.app).getCurrentAccountUin(), 0).getBoolean("Conversation_call_prompt_flag", true);
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    List localList2;
    Object localObject5;
    Object localObject4;
    try
    {
      List localList1 = localEntityManager.query(QCallRecent.class, false, null, null, null, null, "lastCallTime desc", null);
      localList2 = this.jdField_a_of_type_JavaUtilList;
      if (localList1 == null) {
        break label522;
      }
      long l1;
      boolean bool;
      Object localObject1;
      label291:
      try
      {
        if (localList1.size() <= 0) {
          break label522;
        }
        localObject5 = localList1;
        if (localList1.size() > 100)
        {
          l1 = System.currentTimeMillis();
          localObject4 = localList1;
        }
      }
      finally {}
    }
    finally
    {
      localEntityManager.close();
    }
    try
    {
      bool = localEntityManager.execSQL("delete from" + "recent_call" + " where lastCallTime < " + ((QCallRecent)localList1.get(90)).lastCallTime + ";");
      localObject1 = localList1;
      if (bool)
      {
        localObject4 = localList1;
        localObject1 = new ArrayList(localList1.subList(0, 90));
      }
      localObject5 = localObject1;
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject4 = localObject1;
        long l2 = System.currentTimeMillis();
        localObject4 = localObject1;
        QLog.d("QCallProxy", 2, "doInit cache data > 100 isOk = " + bool + ",time:" + (l2 - l1));
        localObject5 = localObject1;
      }
    }
    catch (Exception localException)
    {
      localObject5 = localObject4;
      if (!QLog.isDevelopLevel()) {
        break label291;
      }
      QLog.e("QCallProxy", 4, localException.getMessage(), localException);
      localObject5 = localObject4;
      break label291;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    localObject1 = ((List)localObject5).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject4 = (QCallRecent)((Iterator)localObject1).next();
        if ((((QCallRecent)localObject4).state == 5) || (((QCallRecent)localObject4).state == 6) || (((QCallRecent)localObject4).state == 7) || (((QCallRecent)localObject4).state == 1)) {
          ((QCallRecent)localObject4).state = 0;
        }
        if ((((QCallRecent)localObject4).uin != null) && (((QCallRecent)localObject4).uin.length() >= 2)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject4);
        }
      }
      else
      {
        Iterator localIterator;
        while (localIterator.hasNext())
        {
          localObject4 = (QCallRecent)localIterator.next();
          this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject4).uin, ((QCallRecent)localObject4).type), localObject4);
        }
      }
    }
    label522:
    if (QLog.isDevelopLevel()) {
      QLog.d("QCallProxy", 4, this.jdField_a_of_type_JavaUtilList.toString());
    }
    localEntityManager.close();
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====end====");
    }
  }
  
  public void b(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent.getStatus() == 1000)
    {
      this.proxyManager.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 3, null);
      return;
    }
    this.proxyManager.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 4, null);
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void c(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, false);
  }
  
  public void d(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, true);
  }
  
  public void destroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
    c();
    a();
    jdField_a_of_type_Boolean = false;
  }
  
  public void init()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new QCallProxy.1(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy
 * JD-Core Version:    0.7.0.1
 */