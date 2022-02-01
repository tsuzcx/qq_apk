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
  private static volatile boolean e = false;
  EntityManager a = null;
  private ConcurrentHashMap<String, List<QCallRecord>> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> c = new ConcurrentHashMap();
  private Object d = new Object();
  private int f = 20;
  private final List<QCallRecent> g = new ArrayList(20);
  private final Map<String, QCallRecent> h = new HashMap();
  private boolean i;
  
  public QCallProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private Cursor a(String paramString)
  {
    paramString = UinMD5Cache.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select name from sqlite_master where (type='table') and (name like 'qc/_%/_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' escape '/') and (name not like 'qc/_");
    localStringBuilder.append(3000);
    localStringBuilder.append("/_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' escape '/') and (name not like 'qc/_");
    localStringBuilder.append(8);
    localStringBuilder.append("/_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' escape '/') order by name;");
    paramString = localStringBuilder.toString();
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
    if ((paramQCallRecent != null) && (paramQCallRecent.uin != null) && (paramQCallRecent.uin.length() >= 2)) {
      if ((paramQCallRecent != null) && (paramQCallRecent.uin != null)) {
        if (paramQCallRecent.uin.length() < 2) {
          return;
        }
      }
    }
    for (;;)
    {
      synchronized (this.g)
      {
        j = paramQCallRecent.type;
        int m = 0;
        localObject1 = paramQCallRecent;
        if (j != 1)
        {
          localObject1 = paramQCallRecent;
          if (paramQCallRecent.type != 3000)
          {
            localObject1 = paramQCallRecent;
            if (paramQCallRecent.type != 8)
            {
              localObject2 = new ArrayList();
              localObject1 = UinTypeUtil.d;
              k = localObject1.length;
              j = 0;
              if (j < k)
              {
                n = localObject1[j];
                if (n == paramQCallRecent.type) {
                  break label729;
                }
                QCallRecent localQCallRecent = (QCallRecent)this.h.remove(i(paramQCallRecent.uin, n));
                if (localQCallRecent == null) {
                  break label729;
                }
                ((ArrayList)localObject2).add(localQCallRecent);
                break label729;
              }
              k = ((ArrayList)localObject2).size();
              localObject1 = paramQCallRecent;
              if (k > 0)
              {
                if (paramQCallRecent.getStatus() != 1000) {
                  break label736;
                }
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(0);
                this.g.remove(localObject1);
                ((QCallRecent)localObject1).type = paramQCallRecent.type;
                ((QCallRecent)localObject1).troopUin = paramQCallRecent.troopUin;
                ((QCallRecent)localObject1).displayName = paramQCallRecent.displayName;
                ((QCallRecent)localObject1).lastCallTime = paramQCallRecent.lastCallTime;
                ((QCallRecent)localObject1).lastCallMsg = paramQCallRecent.lastCallMsg;
                ((QCallRecent)localObject1).sendFlag = paramQCallRecent.sendFlag;
                ((QCallRecent)localObject1).isVideo = paramQCallRecent.isVideo;
                ((QCallRecent)localObject1).missedCallCount = paramQCallRecent.missedCallCount;
                ((QCallRecent)localObject1).isLastCallRealMissed = paramQCallRecent.isLastCallRealMissed;
                j = 1;
                paramQCallRecent = (QCallRecent)localObject1;
                if (j >= k) {
                  break label741;
                }
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(j);
                this.g.remove(localObject1);
                a((QCallRecent)localObject1);
                j += 1;
                continue;
              }
            }
          }
        }
        Object localObject2 = this.h.keySet();
        paramQCallRecent = new String[((Set)localObject2).size()];
        ((Set)localObject2).toArray(paramQCallRecent);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("saveRecentCall before put:");
          ((StringBuilder)localObject2).append(Arrays.toString(paramQCallRecent));
          QLog.d("QCallProxy", 2, ((StringBuilder)localObject2).toString());
        }
        this.h.put(i(((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type), localObject1);
        localObject2 = this.h.keySet();
        paramQCallRecent = new String[((Set)localObject2).size()];
        ((Set)localObject2).toArray(paramQCallRecent);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("saveRecentCall after put:");
          ((StringBuilder)localObject2).append(Arrays.toString(paramQCallRecent));
          QLog.d("QCallProxy", 2, ((StringBuilder)localObject2).toString());
        }
        this.g.remove(localObject1);
        int n = this.g.size();
        j = 0;
        int k = m;
        if (j < n)
        {
          paramQCallRecent = (QCallRecent)this.g.get(j);
          if (((QCallRecent)localObject1).lastCallTime <= paramQCallRecent.lastCallTime) {
            break label747;
          }
          this.g.add(j, localObject1);
          k = 1;
        }
        if (k == 0) {
          this.g.add(this.g.size(), localObject1);
        }
        if (paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            paramQCallRecent = new StringBuilder();
            paramQCallRecent.append("insertOrUpdateRecentCallToDB uin: ");
            paramQCallRecent.append(((QCallRecent)localObject1).uin);
            paramQCallRecent.append(",callstatus:");
            paramQCallRecent.append(((QCallRecent)localObject1).state);
            QLog.d("QCallProxy", 2, paramQCallRecent.toString());
          }
          b((QCallRecent)localObject1);
        }
        return;
      }
      return;
      Utils.a("QCallProxy");
      return;
      label729:
      j += 1;
      continue;
      label736:
      int j = 0;
      continue;
      label741:
      Object localObject1 = paramQCallRecent;
      continue;
      label747:
      j += 1;
    }
  }
  
  private int b(String paramString)
  {
    paramString = paramString.split("[^0-9]");
    try
    {
      int k = paramString.length;
      int j = 0;
      while (j < k)
      {
        String str = paramString[j];
        if ((str != null) && (str.length() > 0))
        {
          j = Integer.parseInt(str);
          return j;
        }
        j += 1;
      }
      return -1;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QCallProxy", 2, paramString.getMessage(), paramString);
      }
    }
  }
  
  private boolean b(QCallRecord paramQCallRecord)
  {
    this.proxyManager.addMsgQueue(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 3, null);
    return true;
  }
  
  private String e(String paramString, int paramInt)
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
  
  private EntityManager f()
  {
    ??? = this.a;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.d)
    {
      if ((this.a == null) || (!this.a.isOpen())) {
        this.a = this.app.getEntityManagerFactory().createEntityManager();
      }
      return this.a;
    }
  }
  
  private Object f(String arg1, int paramInt)
  {
    String str = e(???, paramInt);
    if (!this.c.containsKey(str)) {
      synchronized (this.c)
      {
        if (!this.c.containsKey(str)) {
          this.c.put(str, new Object());
        }
      }
    }
    return this.c.get(localObject);
  }
  
  private boolean g(String paramString, int paramInt)
  {
    if ((paramInt != 3000) && (paramInt != 8)) {
      ThreadManager.excute(new QCallProxy.3(this, paramString), 16, null, false);
    } else {
      this.proxyManager.addMsgQueue(paramString, paramInt, QCallRecord.getTableName(paramString, paramInt), null, null, 2, null);
    }
    return true;
  }
  
  /* Error */
  private List<QCallRecord> h(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/tencent/mobileqq/qcall/QCallProxy:app	Lmqq/app/AppRuntime;
    //   4: checkcast 102	com/tencent/mobileqq/app/QQAppInterface
    //   7: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   10: astore 8
    //   12: aload 8
    //   14: ifnonnull +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: iload_2
    //   20: sipush 3000
    //   23: if_icmpeq +277 -> 300
    //   26: iload_2
    //   27: bipush 8
    //   29: if_icmpne +6 -> 35
    //   32: goto +268 -> 300
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 67	com/tencent/mobileqq/qcall/QCallProxy:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +199 -> 243
    //   47: new 53	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 148	java/util/ArrayList:<init>	()V
    //   54: astore 6
    //   56: aload 7
    //   58: ldc_w 401
    //   61: invokeinterface 406 2 0
    //   66: istore_2
    //   67: aload 6
    //   69: astore_1
    //   70: aload 7
    //   72: invokeinterface 409 1 0
    //   77: ifeq +168 -> 245
    //   80: aload 7
    //   82: iload_2
    //   83: invokeinterface 412 2 0
    //   88: invokestatic 417	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_1
    //   92: aload 8
    //   94: aload_1
    //   95: invokevirtual 420	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   98: istore_3
    //   99: iload_3
    //   100: ifle +125 -> 225
    //   103: iload_3
    //   104: aload_0
    //   105: getfield 51	com/tencent/mobileqq/qcall/QCallProxy:f	I
    //   108: if_icmple +39 -> 147
    //   111: aload 8
    //   113: ldc_w 422
    //   116: iconst_3
    //   117: anewarray 46	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_1
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_1
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: iload_3
    //   131: aload_0
    //   132: getfield 51	com/tencent/mobileqq/qcall/QCallProxy:f	I
    //   135: isub
    //   136: invokestatic 425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: invokestatic 429	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   143: invokevirtual 433	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   146: pop
    //   147: new 76	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   154: astore 9
    //   156: aload 9
    //   158: ldc_w 435
    //   161: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 9
    //   167: aload_1
    //   168: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 9
    //   174: ldc_w 437
    //   177: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 9
    //   183: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_1
    //   187: aload_0
    //   188: invokespecial 439	com/tencent/mobileqq/qcall/QCallProxy:f	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   191: ldc 165
    //   193: aload_1
    //   194: aconst_null
    //   195: invokevirtual 442	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +12 -> 212
    //   203: aload 6
    //   205: aload_1
    //   206: invokeinterface 446 2 0
    //   211: pop
    //   212: aload 6
    //   214: new 448	com/tencent/mobileqq/qcall/QCallProxy$4
    //   217: dup
    //   218: aload_0
    //   219: invokespecial 449	com/tencent/mobileqq/qcall/QCallProxy$4:<init>	(Lcom/tencent/mobileqq/qcall/QCallProxy;)V
    //   222: invokestatic 144	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   225: goto -158 -> 67
    //   228: aload 6
    //   230: astore_1
    //   231: goto +58 -> 289
    //   234: astore_1
    //   235: goto +35 -> 270
    //   238: aconst_null
    //   239: astore_1
    //   240: goto +49 -> 289
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: astore 6
    //   248: aload 7
    //   250: ifnull +159 -> 409
    //   253: aload 7
    //   255: invokeinterface 452 1 0
    //   260: aload_1
    //   261: astore 6
    //   263: goto +146 -> 409
    //   266: astore_1
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 7
    //   272: ifnull +10 -> 282
    //   275: aload 7
    //   277: invokeinterface 452 1 0
    //   282: aload_1
    //   283: athrow
    //   284: aconst_null
    //   285: astore_1
    //   286: aload_1
    //   287: astore 7
    //   289: aload_1
    //   290: astore 6
    //   292: aload 7
    //   294: ifnull +115 -> 409
    //   297: goto -44 -> 253
    //   300: aload_1
    //   301: iload_2
    //   302: invokestatic 392	com/tencent/mobileqq/data/QCallRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   305: astore_1
    //   306: aload 8
    //   308: aload_1
    //   309: invokevirtual 420	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   312: istore_2
    //   313: aload_0
    //   314: getfield 51	com/tencent/mobileqq/qcall/QCallProxy:f	I
    //   317: istore_3
    //   318: iload_2
    //   319: iload_3
    //   320: if_icmple +36 -> 356
    //   323: aload 8
    //   325: ldc_w 422
    //   328: iconst_3
    //   329: anewarray 46	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload_1
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: aload_1
    //   339: aastore
    //   340: dup
    //   341: iconst_2
    //   342: iload_2
    //   343: iload_3
    //   344: isub
    //   345: invokestatic 425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: invokestatic 429	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   352: invokevirtual 433	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   355: pop
    //   356: new 76	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   363: astore 6
    //   365: aload 6
    //   367: ldc_w 435
    //   370: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 6
    //   376: aload_1
    //   377: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 6
    //   383: ldc_w 437
    //   386: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 6
    //   392: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: astore_1
    //   396: aload_0
    //   397: invokespecial 439	com/tencent/mobileqq/qcall/QCallProxy:f	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   400: ldc 165
    //   402: aload_1
    //   403: aconst_null
    //   404: invokevirtual 442	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   407: astore 6
    //   409: aload 6
    //   411: ifnull +62 -> 473
    //   414: invokestatic 457	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   417: lstore 4
    //   419: aload 6
    //   421: invokeinterface 154 1 0
    //   426: astore_1
    //   427: aload_1
    //   428: invokeinterface 159 1 0
    //   433: ifeq +40 -> 473
    //   436: aload_1
    //   437: invokeinterface 163 1 0
    //   442: checkcast 165	com/tencent/mobileqq/data/QCallRecord
    //   445: astore 7
    //   447: aload 7
    //   449: ifnull -22 -> 427
    //   452: aload 7
    //   454: getfield 184	com/tencent/mobileqq/data/QCallRecord:time	J
    //   457: lload 4
    //   459: lcmp
    //   460: ifle -33 -> 427
    //   463: aload 7
    //   465: lload 4
    //   467: putfield 184	com/tencent/mobileqq/data/QCallRecord:time	J
    //   470: goto -43 -> 427
    //   473: aload 6
    //   475: areturn
    //   476: astore_1
    //   477: goto -193 -> 284
    //   480: astore_1
    //   481: goto -243 -> 238
    //   484: astore_1
    //   485: goto -257 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	QCallProxy
    //   0	488	1	paramString	String
    //   0	488	2	paramInt	int
    //   98	247	3	j	int
    //   417	49	4	l	long
    //   54	420	6	localObject1	Object
    //   40	424	7	localObject2	Object
    //   10	314	8	localSQLiteDatabase	SQLiteDatabase
    //   154	28	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   47	56	234	finally
    //   56	67	234	finally
    //   70	99	234	finally
    //   103	147	234	finally
    //   147	199	234	finally
    //   203	212	234	finally
    //   212	225	234	finally
    //   35	42	266	finally
    //   35	42	476	java/lang/Exception
    //   47	56	480	java/lang/Exception
    //   56	67	484	java/lang/Exception
    //   70	99	484	java/lang/Exception
    //   103	147	484	java/lang/Exception
    //   147	199	484	java/lang/Exception
    //   203	212	484	java/lang/Exception
    //   212	225	484	java/lang/Exception
  }
  
  private String i(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public List<QCallRecent> a(QCallProxy.QueryRecentCallsListener arg1)
  {
    ThreadManager.post(new QCallProxy.5(this, ???), 5, null, false);
    synchronized (this.g)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.g.iterator();
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
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<QCallRecord> a(String paramString, int paramInt)
  {
    String str = e(paramString, paramInt);
    Object localObject2 = f(paramString, paramInt);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getListRecord ThreadName:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      ((StringBuilder)localObject1).append(" getListRecord friendUin:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",uinType:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("QCallProxy", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = (List)this.b.get(str);
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = h(paramString, paramInt);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getListRecord ThreadName:");
        ((StringBuilder)localObject1).append(Thread.currentThread().getName());
        ((StringBuilder)localObject1).append(" getListRecord (DB) records size:");
        ((StringBuilder)localObject1).append(paramString.size());
        QLog.d("QCallProxy", 2, ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getListRecord");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("QCallProxy", 2, ((StringBuilder)localObject1).toString());
      }
      paramString = a(paramString);
      this.b.put(str, paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a()
  {
    ConcurrentHashMap localConcurrentHashMap = this.b;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    synchronized (this.g)
    {
      this.g.remove(paramQCallRecent);
      this.h.remove(i(paramQCallRecent.uin, paramQCallRecent.type));
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
      synchronized (f(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        String str = e(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        Object localObject2 = (List)this.b.get(str);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        }
        ((List)localObject1).add(paramQCallRecord);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("insertRecord ThreadName:");
          ((StringBuilder)localObject2).append(Thread.currentThread().getName());
          ((StringBuilder)localObject2).append(" insertRecord records size:");
          if (localObject1 != null)
          {
            j = ((List)localObject1).size();
            ((StringBuilder)localObject2).append(j);
            QLog.d("QCallProxy", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          this.b.put(str, a((List)localObject1));
          b(paramQCallRecord);
          return;
        }
      }
      int j = 0;
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!e(paramString1, paramInt1).equals(e(paramString2, paramInt2)))
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
        b(paramString1, paramInt1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    SharedPreferences.Editor localEditor = ((QQAppInterface)this.app).getApp().getSharedPreferences(((QQAppInterface)this.app).getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("Conversation_call_prompt_flag", false);
    localEditor.commit();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====start====");
    }
    this.i = ((QQAppInterface)this.app).getApp().getSharedPreferences(((QQAppInterface)this.app).getCurrentAccountUin(), 0).getBoolean("Conversation_call_prompt_flag", true);
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    try
    {
      Object localObject5 = localEntityManager.query(QCallRecent.class, false, null, null, null, null, "lastCallTime desc", null);
      List localList = this.g;
      if (localObject5 != null) {}
      try
      {
        if (((List)localObject5).size() > 0)
        {
          Object localObject6 = localObject5;
          Object localObject4;
          if (((List)localObject5).size() > 100)
          {
            long l1 = System.currentTimeMillis();
            localObject4 = localObject5;
            try
            {
              Object localObject1 = new StringBuffer();
              localObject4 = localObject5;
              ((StringBuffer)localObject1).append("delete from");
              localObject4 = localObject5;
              ((StringBuffer)localObject1).append("recent_call");
              localObject4 = localObject5;
              ((StringBuffer)localObject1).append(" where lastCallTime < ");
              localObject4 = localObject5;
              ((StringBuffer)localObject1).append(((QCallRecent)((List)localObject5).get(90)).lastCallTime);
              localObject4 = localObject5;
              ((StringBuffer)localObject1).append(";");
              localObject4 = localObject5;
              boolean bool = localEntityManager.execSQL(((StringBuffer)localObject1).toString());
              localObject1 = localObject5;
              if (bool)
              {
                localObject4 = localObject5;
                localObject1 = new ArrayList(((List)localObject5).subList(0, 90));
              }
              localObject4 = localObject1;
              localObject6 = localObject1;
              if (QLog.isColorLevel())
              {
                localObject4 = localObject1;
                long l2 = System.currentTimeMillis();
                localObject4 = localObject1;
                localObject5 = new StringBuilder();
                localObject4 = localObject1;
                ((StringBuilder)localObject5).append("doInit cache data > 100 isOk = ");
                localObject4 = localObject1;
                ((StringBuilder)localObject5).append(bool);
                localObject4 = localObject1;
                ((StringBuilder)localObject5).append(",time:");
                localObject4 = localObject1;
                ((StringBuilder)localObject5).append(l2 - l1);
                localObject4 = localObject1;
                QLog.d("QCallProxy", 2, ((StringBuilder)localObject5).toString());
                localObject6 = localObject1;
              }
            }
            catch (Exception localException)
            {
              localObject6 = localObject4;
              if (QLog.isDevelopLevel())
              {
                QLog.e("QCallProxy", 4, localException.getMessage(), localException);
                localObject6 = localObject4;
              }
            }
          }
          this.g.clear();
          Iterator localIterator = localObject6.iterator();
          while (localIterator.hasNext())
          {
            localObject4 = (QCallRecent)localIterator.next();
            if ((((QCallRecent)localObject4).state == 5) || (((QCallRecent)localObject4).state == 6) || (((QCallRecent)localObject4).state == 7) || (((QCallRecent)localObject4).state == 1)) {
              ((QCallRecent)localObject4).state = 0;
            }
            if ((((QCallRecent)localObject4).uin != null) && (((QCallRecent)localObject4).uin.length() >= 2)) {
              this.g.add(localObject4);
            }
          }
          localIterator = this.g.iterator();
          while (localIterator.hasNext())
          {
            localObject4 = (QCallRecent)localIterator.next();
            this.h.put(i(((QCallRecent)localObject4).uin, ((QCallRecent)localObject4).type), localObject4);
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QCallProxy", 4, this.g.toString());
        }
        localEntityManager.close();
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "recentDoInit ====end====");
        }
        return;
      }
      finally {}
      throw localObject3;
    }
    finally
    {
      localEntityManager.close();
    }
    for (;;) {}
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
  
  public void b(String paramString, int paramInt)
  {
    Object localObject = e(paramString, paramInt);
    localObject = (List)this.b.get(localObject);
    if (localObject != null) {
      ((List)localObject).clear();
    }
    g(paramString, paramInt);
  }
  
  public QCallRecent c(String paramString, int paramInt)
  {
    synchronized (this.h)
    {
      QCallRecent localQCallRecent2 = (QCallRecent)this.h.get(i(paramString, paramInt));
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
  
  public void c(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, false);
  }
  
  public boolean c()
  {
    return (this.i) && (this.g.size() > 0);
  }
  
  public QCallRecent d(String paramString, int paramInt)
  {
    synchronized (this.h)
    {
      paramString = (QCallRecent)this.h.get(i(paramString, paramInt));
      return paramString;
    }
  }
  
  public List<QCallRecent> d()
  {
    return a(null);
  }
  
  public void d(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, true);
  }
  
  public void destroy()
  {
    EntityManager localEntityManager = this.a;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.a.close();
    }
    e();
    a();
    e = false;
  }
  
  public void e()
  {
    synchronized (this.g)
    {
      this.g.clear();
      this.h.clear();
      return;
    }
  }
  
  public void init()
  {
    if (e) {
      return;
    }
    e = true;
    ThreadManager.excute(new QCallProxy.1(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy
 * JD-Core Version:    0.7.0.1
 */