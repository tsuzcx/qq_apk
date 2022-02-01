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
  private static LruCache<String, DraftTextInfo> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  private static volatile DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private static HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static LruCache<String, DraftSummaryInfo> b = new LruCache(99);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
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
      if (jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) {
        try
        {
          if (jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null)
          {
            jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = new DraftTextManager();
            a(paramQQAppInterface);
          }
        }
        finally {}
      }
      return jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
    }
    throw new IllegalArgumentException("DraftTextManager this.app == null");
  }
  
  private static String a(String paramString)
  {
    return Utils.a(paramString, 50);
  }
  
  private static String a(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  /* Error */
  private static List<DraftTextInfo> a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   4: invokevirtual 126	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_0
    //   8: aload_0
    //   9: ldc 41
    //   11: new 41	com/tencent/mobileqq/data/DraftTextInfo
    //   14: dup
    //   15: invokespecial 127	com/tencent/mobileqq/data/DraftTextInfo:<init>	()V
    //   18: invokevirtual 131	com/tencent/mobileqq/data/DraftTextInfo:getTableName	()Ljava/lang/String;
    //   21: iconst_0
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 137	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +29 -> 62
    //   36: aload_2
    //   37: invokeinterface 143 1 0
    //   42: istore_1
    //   43: iload_1
    //   44: ifle +18 -> 62
    //   47: aload_0
    //   48: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: goto +20 -> 74
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   62: aload_0
    //   63: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   66: new 151	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 152	java/util/ArrayList:<init>	()V
    //   73: areturn
    //   74: aload_0
    //   75: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
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
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface).iterator();
    while (paramQQAppInterface.hasNext())
    {
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)paramQQAppInterface.next();
      if ((!TextUtils.isEmpty(localDraftTextInfo.text)) || (localDraftTextInfo.sourceMsgSeq != 0L))
      {
        String str = a(localDraftTextInfo.uin, localDraftTextInfo.type);
        jdField_a_of_type_JavaUtilHashSet.add(str);
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, localDraftTextInfo);
        b.put(str, a(localDraftTextInfo));
      }
    }
  }
  
  public DraftSummaryInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      return null;
    }
    Object localObject = (DraftSummaryInfo)b.get(str);
    if (localObject != null) {
      return localObject;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    localObject = localDraftTextInfo;
    if (localDraftTextInfo == null) {
      localObject = a(paramQQAppInterface, paramString, paramInt);
    }
    paramQQAppInterface = a((DraftTextInfo)localObject);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary()))) {
      b.put(str, paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  /* Error */
  public DraftTextInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_1
    //   10: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   13: invokevirtual 126	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 41
    //   20: new 41	com/tencent/mobileqq/data/DraftTextInfo
    //   23: dup
    //   24: invokespecial 127	com/tencent/mobileqq/data/DraftTextInfo:<init>	()V
    //   27: invokevirtual 131	com/tencent/mobileqq/data/DraftTextInfo:getTableName	()Ljava/lang/String;
    //   30: iconst_0
    //   31: ldc 197
    //   33: iconst_2
    //   34: anewarray 199	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: iload_3
    //   44: invokestatic 203	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   47: aastore
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual 137	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +32 -> 89
    //   60: aload_2
    //   61: invokeinterface 143 1 0
    //   66: ifle +23 -> 89
    //   69: aload_2
    //   70: iconst_0
    //   71: invokeinterface 206 2 0
    //   76: checkcast 41	com/tencent/mobileqq/data/DraftTextInfo
    //   79: astore_2
    //   80: aload_1
    //   81: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   84: aload 4
    //   86: monitorexit
    //   87: aload_2
    //   88: areturn
    //   89: aload_1
    //   90: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: goto +15 -> 108
    //   96: astore_2
    //   97: goto +22 -> 119
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   105: goto -16 -> 89
    //   108: aload 4
    //   110: monitorexit
    //   111: new 41	com/tencent/mobileqq/data/DraftTextInfo
    //   114: dup
    //   115: invokespecial 127	com/tencent/mobileqq/data/DraftTextInfo:<init>	()V
    //   118: areturn
    //   119: aload_1
    //   120: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   123: aload_2
    //   124: athrow
    //   125: astore_1
    //   126: aload 4
    //   128: monitorexit
    //   129: goto +5 -> 134
    //   132: aload_1
    //   133: athrow
    //   134: goto -2 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	DraftTextManager
    //   0	137	1	paramQQAppInterface	QQAppInterface
    //   0	137	2	paramString	String
    //   0	137	3	paramInt	int
    //   4	123	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	56	96	finally
    //   60	80	96	finally
    //   101	105	96	finally
    //   17	56	100	java/lang/Exception
    //   60	80	100	java/lang/Exception
    //   9	17	125	finally
    //   80	87	125	finally
    //   89	93	125	finally
    //   108	111	125	finally
    //   119	125	125	finally
    //   126	129	125	finally
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Get draft text| uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" draftList=");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilHashSet);
      ((StringBuilder)localObject).append(" cache=");
      ((StringBuilder)localObject).append(jdField_a_of_type_AndroidSupportV4UtilLruCache);
      QLog.d("DraftTextManger", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramString, paramInt);
    if (!jdField_a_of_type_JavaUtilHashSet.contains(localObject)) {
      return null;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject);
    if (localDraftTextInfo != null) {
      return localDraftTextInfo.text;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    if ((paramQQAppInterface != null) && (!StringUtil.a(paramQQAppInterface.text))) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localObject, paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.text;
    }
    return "";
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = null;
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    b = new LruCache(99);
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo)
  {
    // Byte code:
    //   0: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 230
    //   8: iconst_2
    //   9: ldc 250
    //   11: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 35	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnonnull +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_2
    //   29: getfield 45	com/tencent/mobileqq/data/DraftTextInfo:uin	Ljava/lang/String;
    //   32: aload_2
    //   33: getfield 53	com/tencent/mobileqq/data/DraftTextInfo:type	I
    //   36: invokestatic 171	com/tencent/mobileqq/managers/DraftTextManager:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore 4
    //   41: getstatic 31	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   44: aload 4
    //   46: invokevirtual 185	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   49: ifne +12 -> 61
    //   52: getstatic 31	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   55: aload 4
    //   57: invokevirtual 175	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: getstatic 23	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   64: aload 4
    //   66: aload_2
    //   67: invokevirtual 179	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: getstatic 25	com/tencent/mobileqq/managers/DraftTextManager:b	Landroid/support/v4/util/LruCache;
    //   74: aload 4
    //   76: aload_2
    //   77: invokestatic 181	com/tencent/mobileqq/managers/DraftTextManager:a	(Lcom/tencent/mobileqq/data/DraftTextInfo;)Lcom/tencent/mobileqq/data/DraftSummaryInfo;
    //   80: invokevirtual 179	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 252	com/tencent/mobileqq/managers/DraftTextManager$1
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 255	com/tencent/mobileqq/managers/DraftTextManager$1:<init>	(Lcom/tencent/mobileqq/managers/DraftTextManager;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DraftTextInfo;)V
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 261	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String str = a(paramString, paramInt);
      if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
        return false;
      }
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
      jdField_a_of_type_JavaUtilHashSet.remove(str);
      jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      b.remove(str);
      ThreadManager.post(new DraftTextManager.2(this, localDraftTextInfo, paramQQAppInterface, paramString, paramInt), 8, null, false);
      return false;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    return jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
  
  public DraftTextInfo b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    DraftTextInfo localDraftTextInfo;
    if (jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    } else {
      localDraftTextInfo = null;
    }
    Object localObject = localDraftTextInfo;
    if (localDraftTextInfo == null)
    {
      paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
      localObject = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject = paramQQAppInterface;
        if (!StringUtil.a(paramQQAppInterface.text))
        {
          jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, paramQQAppInterface);
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