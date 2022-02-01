package com.tencent.mobileqq.managers;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DraftTextManager
{
  private static LruCache<String, DraftTextInfo> b = new LruCache(10);
  private static LruCache<String, DraftSummaryInfo> c = new LruCache(99);
  private static HashSet<String> d = new HashSet();
  private static volatile DraftTextManager e;
  private Object a = new Object();
  
  private static DraftSummaryInfo a(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo == null) {
      return null;
    }
    DraftSummaryInfo localDraftSummaryInfo = new DraftSummaryInfo();
    localDraftSummaryInfo.setUin(paramDraftTextInfo.uin);
    localDraftSummaryInfo.setType(paramDraftTextInfo.type);
    localDraftSummaryInfo.setTime(paramDraftTextInfo.time);
    localDraftSummaryInfo.setAtInfoStr(paramDraftTextInfo.mAtInfoStr);
    if ((paramDraftTextInfo.sourceMsgSeq != 0L) && (TextUtils.isEmpty(paramDraftTextInfo.text)))
    {
      localDraftSummaryInfo.setSummary(" ");
      return localDraftSummaryInfo;
    }
    localDraftSummaryInfo.setSummary(a(paramDraftTextInfo.text));
    return localDraftSummaryInfo;
  }
  
  public static DraftTextManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (e == null) {
        try
        {
          if (e == null)
          {
            e = new DraftTextManager();
            b(paramQQAppInterface);
          }
        }
        finally {}
      }
      return e;
    }
    throw new IllegalArgumentException("DraftTextManager this.app == null");
  }
  
  private static String a(String paramString)
  {
    return Utils.a(paramString, 50);
  }
  
  private static String b(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = c(paramQQAppInterface).iterator();
    while (paramQQAppInterface.hasNext())
    {
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)paramQQAppInterface.next();
      if ((!TextUtils.isEmpty(localDraftTextInfo.text)) || (localDraftTextInfo.sourceMsgSeq != 0L))
      {
        String str = b(localDraftTextInfo.uin, localDraftTextInfo.type);
        d.add(str);
        b.put(str, localDraftTextInfo);
        c.put(str, a(localDraftTextInfo));
      }
    }
  }
  
  /* Error */
  private static List<DraftTextInfo> c(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   4: invokevirtual 159	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_0
    //   8: aload_0
    //   9: ldc 44
    //   11: new 44	com/tencent/mobileqq/data/DraftTextInfo
    //   14: dup
    //   15: invokespecial 160	com/tencent/mobileqq/data/DraftTextInfo:<init>	()V
    //   18: invokevirtual 164	com/tencent/mobileqq/data/DraftTextInfo:getTableName	()Ljava/lang/String;
    //   21: iconst_0
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +29 -> 62
    //   36: aload_2
    //   37: invokeinterface 174 1 0
    //   42: istore_1
    //   43: iload_1
    //   44: ifle +18 -> 62
    //   47: aload_0
    //   48: invokevirtual 177	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: goto +20 -> 74
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   62: aload_0
    //   63: invokevirtual 177	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   66: new 182	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 183	java/util/ArrayList:<init>	()V
    //   73: areturn
    //   74: aload_0
    //   75: invokevirtual 177	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramQQAppInterface	QQAppInterface
    //   42	2	1	i	int
    //   31	21	2	localList	List
    //   53	1	2	localObject	Object
    //   57	22	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   8	32	53	finally
    //   36	43	53	finally
    //   58	62	53	finally
    //   8	32	57	java/lang/Exception
    //   36	43	57	java/lang/Exception
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Get draft text| uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" draftList=");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(" cache=");
      ((StringBuilder)localObject).append(b);
      QLog.d("DraftTextManger", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = b(paramString, paramInt);
    if (!d.contains(localObject)) {
      return null;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)b.get(localObject);
    if (localDraftTextInfo != null) {
      return localDraftTextInfo.text;
    }
    paramQQAppInterface = d(paramQQAppInterface, paramString, paramInt);
    if ((paramQQAppInterface != null) && (!StringUtil.isEmpty(paramQQAppInterface.text))) {
      b.put(localObject, paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.text;
    }
    return "";
  }
  
  public void a()
  {
    e = null;
    d.clear();
    b = new LruCache(10);
    c = new LruCache(99);
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo)
  {
    // Byte code:
    //   0: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 209
    //   8: iconst_2
    //   9: ldc 238
    //   11: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 38	com/tencent/mobileqq/managers/DraftTextManager:a	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnonnull +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_2
    //   29: getfield 48	com/tencent/mobileqq/data/DraftTextInfo:uin	Ljava/lang/String;
    //   32: aload_2
    //   33: getfield 56	com/tencent/mobileqq/data/DraftTextInfo:type	I
    //   36: invokestatic 135	com/tencent/mobileqq/managers/DraftTextManager:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore 4
    //   41: getstatic 34	com/tencent/mobileqq/managers/DraftTextManager:d	Ljava/util/HashSet;
    //   44: aload 4
    //   46: invokevirtual 218	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   49: ifne +12 -> 61
    //   52: getstatic 34	com/tencent/mobileqq/managers/DraftTextManager:d	Ljava/util/HashSet;
    //   55: aload 4
    //   57: invokevirtual 139	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: getstatic 26	com/tencent/mobileqq/managers/DraftTextManager:b	Landroid/support/v4/util/LruCache;
    //   64: aload 4
    //   66: aload_2
    //   67: invokevirtual 143	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: getstatic 28	com/tencent/mobileqq/managers/DraftTextManager:c	Landroid/support/v4/util/LruCache;
    //   74: aload 4
    //   76: aload_2
    //   77: invokestatic 145	com/tencent/mobileqq/managers/DraftTextManager:a	(Lcom/tencent/mobileqq/data/DraftTextInfo;)Lcom/tencent/mobileqq/data/DraftSummaryInfo;
    //   80: invokevirtual 143	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 240	com/tencent/mobileqq/managers/DraftTextManager$1
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 243	com/tencent/mobileqq/managers/DraftTextManager$1:<init>	(Lcom/tencent/mobileqq/managers/DraftTextManager;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DraftTextInfo;)V
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 249	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   101: aload_3
    //   102: monitorexit
    //   103: return
    //   104: astore_1
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	DraftTextManager
    //   0	109	1	paramQQAppInterface	QQAppInterface
    //   0	109	2	paramDraftTextInfo	DraftTextInfo
    //   18	88	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	27	104	finally
    //   28	61	104	finally
    //   61	103	104	finally
    //   105	107	104	finally
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = b(paramString, paramInt);
    return d.contains(paramString);
  }
  
  public DraftSummaryInfo b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = b(paramString, paramInt);
    if (!d.contains(str)) {
      return null;
    }
    Object localObject = (DraftSummaryInfo)c.get(str);
    if (localObject != null) {
      return localObject;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)b.get(str);
    localObject = localDraftTextInfo;
    if (localDraftTextInfo == null) {
      localObject = d(paramQQAppInterface, paramString, paramInt);
    }
    paramQQAppInterface = a((DraftTextInfo)localObject);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary()))) {
      c.put(str, paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.a)
    {
      String str = b(paramString, paramInt);
      if (!d.contains(str)) {
        return false;
      }
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)b.get(str);
      d.remove(str);
      b.remove(str);
      c.remove(str);
      ThreadManager.post(new DraftTextManager.2(this, localDraftTextInfo, paramQQAppInterface, paramString, paramInt), 8, null, false);
      return false;
    }
  }
  
  /* Error */
  public DraftTextInfo d(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mobileqq/managers/DraftTextManager:a	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_1
    //   10: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   13: invokevirtual 159	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 44
    //   20: new 44	com/tencent/mobileqq/data/DraftTextInfo
    //   23: dup
    //   24: invokespecial 160	com/tencent/mobileqq/data/DraftTextInfo:<init>	()V
    //   27: invokevirtual 164	com/tencent/mobileqq/data/DraftTextInfo:getTableName	()Ljava/lang/String;
    //   30: iconst_0
    //   31: ldc_w 267
    //   34: iconst_2
    //   35: anewarray 269	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_2
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: iload_3
    //   45: invokestatic 273	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   48: aastore
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +32 -> 90
    //   61: aload_2
    //   62: invokeinterface 174 1 0
    //   67: ifle +23 -> 90
    //   70: aload_2
    //   71: iconst_0
    //   72: invokeinterface 276 2 0
    //   77: checkcast 44	com/tencent/mobileqq/data/DraftTextInfo
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 177	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   85: aload 4
    //   87: monitorexit
    //   88: aload_2
    //   89: areturn
    //   90: aload_1
    //   91: invokevirtual 177	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   94: goto +15 -> 109
    //   97: astore_2
    //   98: goto +22 -> 120
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   106: goto -16 -> 90
    //   109: aload 4
    //   111: monitorexit
    //   112: new 44	com/tencent/mobileqq/data/DraftTextInfo
    //   115: dup
    //   116: invokespecial 160	com/tencent/mobileqq/data/DraftTextInfo:<init>	()V
    //   119: areturn
    //   120: aload_1
    //   121: invokevirtual 177	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_1
    //   127: aload 4
    //   129: monitorexit
    //   130: goto +5 -> 135
    //   133: aload_1
    //   134: athrow
    //   135: goto -2 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	DraftTextManager
    //   0	138	1	paramQQAppInterface	QQAppInterface
    //   0	138	2	paramString	String
    //   0	138	3	paramInt	int
    //   4	124	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	57	97	finally
    //   61	81	97	finally
    //   102	106	97	finally
    //   17	57	101	java/lang/Exception
    //   61	81	101	java/lang/Exception
    //   9	17	126	finally
    //   81	88	126	finally
    //   90	94	126	finally
    //   109	112	126	finally
    //   120	126	126	finally
    //   127	130	126	finally
  }
  
  public DraftTextInfo e(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = b(paramString, paramInt);
    DraftTextInfo localDraftTextInfo;
    if (d.contains(str)) {
      localDraftTextInfo = (DraftTextInfo)b.get(str);
    } else {
      localDraftTextInfo = null;
    }
    Object localObject = localDraftTextInfo;
    if (localDraftTextInfo == null)
    {
      paramQQAppInterface = d(paramQQAppInterface, paramString, paramInt);
      localObject = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject = paramQQAppInterface;
        if (!StringUtil.isEmpty(paramQQAppInterface.text))
        {
          b.put(str, paramQQAppInterface);
          localObject = paramQQAppInterface;
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager
 * JD-Core Version:    0.7.0.1
 */