package com.tencent.mobileqq.managers;

import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ShieldMsgManger
  implements Manager
{
  private QQConcurrentHashMap<String, ShieldListInfo> a;
  private Object b = new Object();
  private QQAppInterface c;
  
  public ShieldMsgManger(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    if (this.c != null)
    {
      ThreadManager.post(new ShieldMsgManger.1(this), 2, null, false);
      return;
    }
    throw new IllegalArgumentException("ShieldMsgManger this.app = null");
  }
  
  private void a() {}
  
  private boolean a(int paramInt, String paramString)
  {
    paramString = b(paramInt, paramString);
    if (paramString != null) {
      return paramString.isShieldMsg();
    }
    return false;
  }
  
  private boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      paramEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return paramEntityManager.update(paramEntity);
  }
  
  private ShieldListInfo b(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.a == null) {
          b();
        }
        if ((this.a != null) && (paramString != null) && (paramString.length() > 0))
        {
          if (paramInt == 2)
          {
            paramString = b(paramString);
            paramString = (ShieldListInfo)this.a.get(paramString);
            return paramString;
          }
        }
        else {
          return null;
        }
      }
    }
  }
  
  private String b(String paramString)
  {
    String str = paramString.trim();
    Object localObject = str;
    if (!str.startsWith("+"))
    {
      localObject = str;
      if (str.length() == 11)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("+86");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/managers/ShieldMsgManger:b	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 22	com/tencent/mobileqq/managers/ShieldMsgManger:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   14: invokevirtual 122	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore_2
    //   21: new 82	com/tencent/commonsdk/cache/QQConcurrentHashMap
    //   24: dup
    //   25: sipush 1006
    //   28: iconst_0
    //   29: bipush 36
    //   31: invokespecial 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:<init>	(III)V
    //   34: astore 5
    //   36: aload 4
    //   38: ldc 49
    //   40: invokevirtual 129	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +8 -> 55
    //   50: iconst_0
    //   51: istore_1
    //   52: goto +11 -> 63
    //   55: aload 6
    //   57: invokeinterface 134 1 0
    //   62: istore_1
    //   63: iload_2
    //   64: iload_1
    //   65: if_icmpge +45 -> 110
    //   68: aload 6
    //   70: iload_2
    //   71: invokeinterface 137 2 0
    //   76: checkcast 49	com/tencent/mobileqq/data/ShieldListInfo
    //   79: astore 7
    //   81: aload 7
    //   83: ifnull +92 -> 175
    //   86: aload 7
    //   88: getfield 141	com/tencent/mobileqq/data/ShieldListInfo:uin	Ljava/lang/String;
    //   91: ifnull +84 -> 175
    //   94: aload 5
    //   96: aload 7
    //   98: getfield 141	com/tencent/mobileqq/data/ShieldListInfo:uin	Ljava/lang/String;
    //   101: aload 7
    //   103: invokevirtual 145	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: goto +68 -> 175
    //   110: aload_0
    //   111: aload 5
    //   113: putfield 72	com/tencent/mobileqq/managers/ShieldMsgManger:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   116: aload 4
    //   118: invokevirtual 148	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   121: goto +30 -> 151
    //   124: astore 5
    //   126: goto +28 -> 154
    //   129: astore 5
    //   131: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq -18 -> 116
    //   137: ldc 155
    //   139: iconst_2
    //   140: aload 5
    //   142: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   145: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: goto -32 -> 116
    //   151: aload_3
    //   152: monitorexit
    //   153: return
    //   154: aload 4
    //   156: invokevirtual 148	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   159: aload 5
    //   161: athrow
    //   162: astore 4
    //   164: aload_3
    //   165: monitorexit
    //   166: goto +6 -> 172
    //   169: aload 4
    //   171: athrow
    //   172: goto -3 -> 169
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: istore_2
    //   179: goto -116 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ShieldMsgManger
    //   51	15	1	i	int
    //   20	159	2	j	int
    //   4	161	3	localObject1	Object
    //   17	138	4	localEntityManager	EntityManager
    //   162	8	4	localObject2	Object
    //   34	78	5	localQQConcurrentHashMap	QQConcurrentHashMap
    //   124	1	5	localObject3	Object
    //   129	31	5	localException	java.lang.Exception
    //   43	26	6	localList	List
    //   79	23	7	localShieldListInfo	ShieldListInfo
    // Exception table:
    //   from	to	target	type
    //   21	45	124	finally
    //   55	63	124	finally
    //   68	81	124	finally
    //   86	107	124	finally
    //   110	116	124	finally
    //   131	148	124	finally
    //   21	45	129	java/lang/Exception
    //   55	63	129	java/lang/Exception
    //   68	81	129	java/lang/Exception
    //   86	107	129	java/lang/Exception
    //   110	116	129	java/lang/Exception
    //   7	19	162	finally
    //   116	121	162	finally
    //   151	153	162	finally
    //   154	162	162	finally
    //   164	166	162	finally
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    label115:
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.a == null) {
          b();
        }
        if ((this.a != null) && (paramString != null) && (paramString.length() > 0))
        {
          if (paramInt2 != 2) {
            break label115;
          }
          paramString = b(paramString);
          paramString = (ShieldListInfo)this.a.get(paramString);
          if (paramString != null)
          {
            paramString.flags = paramInt1;
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramString);
            ThreadManager.post(new ShieldMsgManger.2(this, localArrayList), 5, null, false);
          }
        }
        return;
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    a(paramInt, paramList, 0);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2)
  {
    ShieldListHandler localShieldListHandler = (ShieldListHandler)this.c.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER);
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    localShieldListHandler.a(paramInt1, arrayOfLong, paramInt2);
  }
  
  public boolean a(String paramString)
  {
    a();
    boolean bool = a(1, paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUinInShieldList:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",result:");
      localStringBuilder.append(bool);
      QLog.d("ShieldMsgManger", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  /* Error */
  public boolean a(List<ShieldListInfo> paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +348 -> 352
    //   7: aload_1
    //   8: invokeinterface 134 1 0
    //   13: ifgt +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 20	com/tencent/mobileqq/managers/ShieldMsgManger:b	Ljava/lang/Object;
    //   22: astore 5
    //   24: aload 5
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 22	com/tencent/mobileqq/managers/ShieldMsgManger:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   34: invokevirtual 122	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore 7
    //   39: aload_0
    //   40: getfield 72	com/tencent/mobileqq/managers/ShieldMsgManger:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   43: ifnonnull +7 -> 50
    //   46: aload_0
    //   47: invokespecial 43	com/tencent/mobileqq/managers/ShieldMsgManger:b	()V
    //   50: aload 7
    //   52: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 225	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   62: aload_1
    //   63: invokeinterface 134 1 0
    //   68: istore_3
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +221 -> 294
    //   76: aload_1
    //   77: iload_2
    //   78: invokeinterface 137 2 0
    //   83: checkcast 49	com/tencent/mobileqq/data/ShieldListInfo
    //   86: astore 8
    //   88: aload_0
    //   89: getfield 72	com/tencent/mobileqq/managers/ShieldMsgManger:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   92: aload 8
    //   94: getfield 141	com/tencent/mobileqq/data/ShieldListInfo:uin	Ljava/lang/String;
    //   97: invokevirtual 86	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 49	com/tencent/mobileqq/data/ShieldListInfo
    //   103: astore 9
    //   105: aload 8
    //   107: getfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   110: ifne +11 -> 121
    //   113: aload 9
    //   115: ifnonnull +6 -> 121
    //   118: goto +236 -> 354
    //   121: aload 9
    //   123: ifnull +144 -> 267
    //   126: aload 9
    //   128: invokevirtual 226	com/tencent/mobileqq/data/ShieldListInfo:getStatus	()I
    //   131: sipush 1001
    //   134: if_icmpeq +14 -> 148
    //   137: aload 9
    //   139: invokevirtual 226	com/tencent/mobileqq/data/ShieldListInfo:getStatus	()I
    //   142: sipush 1002
    //   145: if_icmpne +122 -> 267
    //   148: aload 8
    //   150: getfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   153: aload 9
    //   155: getfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   158: if_icmpeq +45 -> 203
    //   161: aload 9
    //   163: aload 8
    //   165: getfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   168: putfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   171: aload 9
    //   173: aload 8
    //   175: getfield 229	com/tencent/mobileqq/data/ShieldListInfo:source_id	I
    //   178: putfield 229	com/tencent/mobileqq/data/ShieldListInfo:source_id	I
    //   181: aload 9
    //   183: aload 8
    //   185: getfield 232	com/tencent/mobileqq/data/ShieldListInfo:source_sub_id	I
    //   188: putfield 232	com/tencent/mobileqq/data/ShieldListInfo:source_sub_id	I
    //   191: aload_0
    //   192: aload 7
    //   194: aload 9
    //   196: invokespecial 234	com/tencent/mobileqq/managers/ShieldMsgManger:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   199: pop
    //   200: goto +154 -> 354
    //   203: aload 8
    //   205: getfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   208: iconst_1
    //   209: if_icmpne +145 -> 354
    //   212: aload 9
    //   214: getfield 229	com/tencent/mobileqq/data/ShieldListInfo:source_id	I
    //   217: aload 8
    //   219: getfield 229	com/tencent/mobileqq/data/ShieldListInfo:source_id	I
    //   222: if_icmpeq +132 -> 354
    //   225: aload 9
    //   227: aload 8
    //   229: getfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   232: putfield 165	com/tencent/mobileqq/data/ShieldListInfo:flags	I
    //   235: aload 9
    //   237: aload 8
    //   239: getfield 229	com/tencent/mobileqq/data/ShieldListInfo:source_id	I
    //   242: putfield 229	com/tencent/mobileqq/data/ShieldListInfo:source_id	I
    //   245: aload 9
    //   247: aload 8
    //   249: getfield 232	com/tencent/mobileqq/data/ShieldListInfo:source_sub_id	I
    //   252: putfield 232	com/tencent/mobileqq/data/ShieldListInfo:source_sub_id	I
    //   255: aload_0
    //   256: aload 7
    //   258: aload 9
    //   260: invokespecial 234	com/tencent/mobileqq/managers/ShieldMsgManger:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   263: pop
    //   264: goto +90 -> 354
    //   267: aload_0
    //   268: aload 7
    //   270: aload 8
    //   272: invokespecial 234	com/tencent/mobileqq/managers/ShieldMsgManger:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   275: pop
    //   276: aload_0
    //   277: getfield 72	com/tencent/mobileqq/managers/ShieldMsgManger:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   280: aload 8
    //   282: getfield 141	com/tencent/mobileqq/data/ShieldListInfo:uin	Ljava/lang/String;
    //   285: aload 8
    //   287: invokevirtual 145	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: goto +63 -> 354
    //   294: aload 6
    //   296: invokevirtual 237	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   299: aload 6
    //   301: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   304: goto +20 -> 324
    //   307: astore_1
    //   308: goto +31 -> 339
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   316: aload 6
    //   318: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   321: iconst_0
    //   322: istore 4
    //   324: aload 7
    //   326: invokevirtual 148	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   329: aload 5
    //   331: monitorexit
    //   332: aload_0
    //   333: invokespecial 206	com/tencent/mobileqq/managers/ShieldMsgManger:a	()V
    //   336: iload 4
    //   338: ireturn
    //   339: aload 6
    //   341: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   344: aload_1
    //   345: athrow
    //   346: astore_1
    //   347: aload 5
    //   349: monitorexit
    //   350: aload_1
    //   351: athrow
    //   352: iconst_1
    //   353: ireturn
    //   354: iload_2
    //   355: iconst_1
    //   356: iadd
    //   357: istore_2
    //   358: goto -287 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	ShieldMsgManger
    //   0	361	1	paramList	List<ShieldListInfo>
    //   70	288	2	i	int
    //   68	6	3	j	int
    //   1	336	4	bool	boolean
    //   22	326	5	localObject	Object
    //   55	285	6	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   37	288	7	localEntityManager	EntityManager
    //   86	200	8	localShieldListInfo1	ShieldListInfo
    //   103	156	9	localShieldListInfo2	ShieldListInfo
    // Exception table:
    //   from	to	target	type
    //   57	69	307	finally
    //   76	113	307	finally
    //   126	148	307	finally
    //   148	200	307	finally
    //   203	264	307	finally
    //   267	291	307	finally
    //   294	299	307	finally
    //   312	316	307	finally
    //   57	69	311	java/lang/Exception
    //   76	113	311	java/lang/Exception
    //   126	148	311	java/lang/Exception
    //   148	200	311	java/lang/Exception
    //   203	264	311	java/lang/Exception
    //   267	291	311	java/lang/Exception
    //   294	299	311	java/lang/Exception
    //   27	50	346	finally
    //   50	57	346	finally
    //   299	304	346	finally
    //   316	321	346	finally
    //   324	332	346	finally
    //   339	346	346	finally
    //   347	350	346	finally
  }
  
  public boolean a(ConcurrentHashMap<String, ShieldListInfo> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldMsgManger", 2, "<---saveShieldListTotal : begin....");
    }
    synchronized (this.b)
    {
      Object localObject2 = this.c.getWritableDatabase();
      if (localObject2 != null)
      {
        localObject3 = new ShieldListInfo().getTableName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete from ");
        localStringBuilder.append((String)localObject3);
        ((SQLiteDatabase)localObject2).execSQL(localStringBuilder.toString());
      }
      if ((this.a != null) && (this.a.size() > 0)) {
        this.a.clear();
      }
      localObject2 = new ArrayList();
      Object localObject3 = paramConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject2).add(paramConcurrentHashMap.get((String)((Iterator)localObject3).next()));
      }
      boolean bool = a((List)localObject2);
      return bool;
    }
    for (;;)
    {
      throw paramConcurrentHashMap;
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    b(paramInt, paramList, 0);
  }
  
  public void b(int paramInt1, List<Long> paramList, int paramInt2)
  {
    ShieldListHandler localShieldListHandler = (ShieldListHandler)this.c.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER);
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    localShieldListHandler.b(paramInt1, arrayOfLong, paramInt2);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.ShieldMsgManger
 * JD-Core Version:    0.7.0.1
 */