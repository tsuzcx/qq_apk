package com.tencent.mobileqq.search.mostused;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MostUsedCache
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Comparator<MostUsedCache.MostUsedSearchItemModel> jdField_a_of_type_JavaUtilComparator = new MostUsedCache.1();
  private static final Comparator<MostUsedSearch> b = new MostUsedCache.2();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<MostUsedSearch> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean = false;
  
  MostUsedCache(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int i = paramString2.indexOf(paramString1);
    int j = paramString1.length();
    int k = paramString2.length();
    if (i == 0)
    {
      if (j == k) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: new 71	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 72	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 77 1 0
    //   17: new 79	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 82	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: aload_0
    //   26: getfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   29: invokevirtual 86	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: new 53	java/lang/String
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 90	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: iconst_0
    //   41: invokestatic 96	android/util/Base64:encode	([BI)[B
    //   44: invokespecial 99	java/lang/String:<init>	([B)V
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 102 1 0
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: goto +87 -> 147
    //   63: astore_1
    //   64: new 104	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: ldc 107
    //   75: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 114	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   84: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 116
    //   90: iconst_2
    //   91: aload_2
    //   92: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: goto +38 -> 136
    //   101: astore_1
    //   102: new 104	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   109: astore_2
    //   110: aload_2
    //   111: ldc 125
    //   113: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_2
    //   118: aload_1
    //   119: invokevirtual 126	java/io/IOException:toString	()Ljava/lang/String;
    //   122: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc 116
    //   128: iconst_2
    //   129: aload_2
    //   130: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_0
    //   137: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   140: invokeinterface 102 1 0
    //   145: aconst_null
    //   146: areturn
    //   147: aload_0
    //   148: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   151: invokeinterface 102 1 0
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	MostUsedCache
    //   7	51	1	localObject1	Object
    //   59	1	1	localObject2	Object
    //   63	18	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   101	56	1	localIOException	java.io.IOException
    //   71	59	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	48	59	finally
    //   64	98	59	finally
    //   102	136	59	finally
    //   17	48	63	java/lang/IllegalArgumentException
    //   17	48	101	java/io/IOException
  }
  
  public static ArrayList<MostUsedCache.MostUsedSearchItemModel> a(ArrayList<MostUsedCache.MostUsedSearchItemModel> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return paramArrayList;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sortAndDuplicate begin: size: ");
      ((StringBuilder)localObject1).append(paramArrayList.size());
      QLog.d("MostUsedCahcesortAndDuplicate", 2, ((StringBuilder)localObject1).toString());
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
      localObject1 = new ArrayList();
      Object localObject2 = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MostUsedCache.MostUsedSearchItemModel localMostUsedSearchItemModel = (MostUsedCache.MostUsedSearchItemModel)paramArrayList.next();
        int i = localMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType * 100 + localMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType;
        Object localObject3;
        if (((HashMap)localObject2).containsKey(Integer.valueOf(i)))
        {
          localObject3 = (HashMap)((HashMap)localObject2).get(Integer.valueOf(i));
          if (((HashMap)localObject3).containsKey(localMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("more high level exsit ");
            ((StringBuilder)localObject3).append(localMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify);
            QLog.d("MostUsedCahce", 2, ((StringBuilder)localObject3).toString());
          }
          else
          {
            ((HashMap)localObject3).put(localMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify, localMostUsedSearchItemModel);
          }
        }
        else
        {
          localObject3 = new HashMap();
          ((HashMap)localObject3).put(localMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify, localMostUsedSearchItemModel);
          ((HashMap)localObject2).put(Integer.valueOf(i), localObject3);
        }
      }
      if ((((HashMap)localObject2).values() != null) && (((HashMap)localObject2).values().size() > 0))
      {
        paramArrayList = ((HashMap)localObject2).values().iterator();
        while (paramArrayList.hasNext())
        {
          localObject2 = (HashMap)paramArrayList.next();
          if ((localObject2 != null) && (((HashMap)localObject2).values() != null) && (((HashMap)localObject2).values().size() > 0))
          {
            localObject2 = ((HashMap)localObject2).values().iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((MostUsedCache.MostUsedSearchItemModel)((Iterator)localObject2).next());
            }
          }
        }
      }
      Collections.sort((List)localObject1, jdField_a_of_type_JavaUtilComparator);
      paramArrayList = new StringBuilder();
      paramArrayList.append("sortAndDuplicate sorted: size: ");
      paramArrayList.append(((ArrayList)localObject1).size());
      QLog.d("MostUsedCahcesortAndDuplicate", 2, paramArrayList.toString());
      return localObject1;
    }
    return paramArrayList;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 77 1 0
    //   9: new 219	java/io/ObjectInputStream
    //   12: dup
    //   13: new 221	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokevirtual 224	java/lang/String:getBytes	()[B
    //   21: iconst_0
    //   22: invokestatic 227	android/util/Base64:decode	([BI)[B
    //   25: invokespecial 228	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: invokespecial 231	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: ifnull +10 -> 46
    //   39: aload_0
    //   40: getfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   43: invokevirtual 234	java/util/ArrayList:clear	()V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 237	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   51: checkcast 36	java/util/ArrayList
    //   54: putfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   57: invokestatic 243	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   60: lstore_2
    //   61: aload_0
    //   62: getfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   65: sipush 1000
    //   68: lload_2
    //   69: ldc2_w 244
    //   72: lsub
    //   73: invokestatic 248	com/tencent/mobileqq/search/mostused/MostUsedCache:a	(Ljava/util/ArrayList;IJ)V
    //   76: goto +130 -> 206
    //   79: astore_1
    //   80: goto +136 -> 216
    //   83: astore_1
    //   84: new 104	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: ldc 250
    //   97: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 114	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   107: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 116
    //   113: iconst_2
    //   114: aload 4
    //   116: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: goto +84 -> 206
    //   125: astore_1
    //   126: new 104	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   133: astore 4
    //   135: aload 4
    //   137: ldc 252
    //   139: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 4
    //   145: aload_1
    //   146: invokevirtual 253	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   149: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 116
    //   155: iconst_2
    //   156: aload 4
    //   158: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto +42 -> 206
    //   167: astore_1
    //   168: new 104	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc 255
    //   181: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 4
    //   187: aload_1
    //   188: invokevirtual 126	java/io/IOException:toString	()Ljava/lang/String;
    //   191: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 116
    //   197: iconst_2
    //   198: aload 4
    //   200: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   210: invokeinterface 102 1 0
    //   215: return
    //   216: aload_0
    //   217: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   220: invokeinterface 102 1 0
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	MostUsedCache
    //   0	227	1	paramString	String
    //   60	9	2	l	long
    //   91	108	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	46	79	finally
    //   46	76	79	finally
    //   84	122	79	finally
    //   126	164	79	finally
    //   168	206	79	finally
    //   9	46	83	java/lang/IllegalArgumentException
    //   46	76	83	java/lang/IllegalArgumentException
    //   9	46	125	java/lang/ClassNotFoundException
    //   46	76	125	java/lang/ClassNotFoundException
    //   9	46	167	java/io/IOException
    //   46	76	167	java/io/IOException
  }
  
  public static void a(ArrayList<MostUsedSearch> paramArrayList, int paramInt, long paramLong)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Collections.sort(paramArrayList, b);
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        Object localObject = (MostUsedSearch)paramArrayList.get(i);
        if ((localObject != null) && (((MostUsedSearch)localObject).latestUsedTime >= paramLong) && (i < paramInt)) {
          break;
        }
        paramArrayList.remove(i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("list  remove ");
        ((StringBuilder)localObject).append(i);
        QLog.d("MostUsedCahce", 2, ((StringBuilder)localObject).toString());
        i -= 1;
      }
    }
  }
  
  public ArrayList<MostUsedCache.MostUsedSearchItemModel> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface = new ArrayList();
    if (TextUtils.isEmpty(paramString.trim())) {
      return paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    int i = 0;
    try
    {
      for (;;)
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i >= j) {
          break;
        }
        MostUsedSearch localMostUsedSearch = (MostUsedSearch)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int k = a(paramString, localMostUsedSearch.orgKey);
        if (k != 0)
        {
          j = 0;
          while (j < localMostUsedSearch.items.size())
          {
            MostUsedSearchItem localMostUsedSearchItem = (MostUsedSearchItem)localMostUsedSearch.items.get(j);
            long l = NetConnInfoCenter.getServerTimeMillis();
            Object localObject;
            if (localMostUsedSearchItem.timeStamp >= l - 604800000L)
            {
              localObject = new MostUsedCache.MostUsedSearchItemModel(this);
              ((MostUsedCache.MostUsedSearchItemModel)localObject).jdField_a_of_type_Boolean = false;
              ((MostUsedCache.MostUsedSearchItemModel)localObject).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem = new MostUsedSearchItem(localMostUsedSearchItem);
              ((MostUsedCache.MostUsedSearchItemModel)localObject).jdField_a_of_type_Int = k;
              paramQQAppInterface.add(localObject);
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("key:");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append("temp timeStamp over time ");
              ((StringBuilder)localObject).append(localMostUsedSearchItem.timeStamp);
              QLog.d("MostUsedCahce", 2, ((StringBuilder)localObject).toString());
            }
            j += 1;
          }
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface == null)
      {
        QLog.e("MostUsedCahce", 2, "sorted size  is NULL ");
        return paramQQAppInterface;
      }
      paramString = new StringBuilder();
      paramString.append("Result size  is ");
      paramString.append(paramQQAppInterface.size());
      QLog.i("MostUsedCahce", 2, paramString.toString());
      return paramQQAppInterface;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 77 1 0
    //   9: aload_0
    //   10: getfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: getfield 39	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   20: invokevirtual 234	java/util/ArrayList:clear	()V
    //   23: aload_0
    //   24: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   27: invokeinterface 102 1 0
    //   32: getstatic 22	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 46	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_Boolean	Z
    //   43: aload_1
    //   44: monitorexit
    //   45: ldc 116
    //   47: iconst_2
    //   48: ldc_w 322
    //   51: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: return
    //   55: astore_2
    //   56: aload_1
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 102 1 0
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	MostUsedCache
    //   60	11	1	localObject2	Object
    //   55	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	55	finally
    //   56	58	55	finally
    //   9	23	60	finally
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MostUsed");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    if (!this.jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface = a();
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return;
    }
    localEditor.putString((String)localObject, paramQQAppInterface);
    localEditor.apply();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, MostUsedSearchItem paramMostUsedSearchItem)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    int m = 0;
    int k = 0;
    int i;
    if (paramMostUsedSearchItem != null)
    {
      if (TextUtils.isEmpty(paramMostUsedSearchItem.searchKey)) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      i = 0;
    }
    for (;;)
    {
      int j = m;
      for (;;)
      {
        long l1;
        try
        {
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramQQAppInterface = (MostUsedSearch)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (!paramMostUsedSearchItem.searchKey.equals(paramQQAppInterface.orgKey)) {
              break;
            }
            l2 = 0L;
            i = 0;
            j = 0;
            if (i >= paramQQAppInterface.items.size()) {
              break label333;
            }
            MostUsedSearchItem localMostUsedSearchItem = (MostUsedSearchItem)paramQQAppInterface.items.get(i);
            if (l2 == 0L)
            {
              l1 = localMostUsedSearchItem.timeStamp;
            }
            else
            {
              l1 = l2;
              if (l2 > localMostUsedSearchItem.timeStamp)
              {
                l1 = localMostUsedSearchItem.timeStamp;
                j = i;
              }
            }
            if (!MostUsedSearchItem.isSameIdentityItem(localMostUsedSearchItem, paramMostUsedSearchItem)) {
              break label322;
            }
            localMostUsedSearchItem.timeStamp = paramMostUsedSearchItem.timeStamp;
            i = k;
            if (i == 0) {
              break label338;
            }
            if (paramQQAppInterface.items.size() > 2) {
              paramQQAppInterface.items.remove(j);
            }
            paramQQAppInterface.items.add(paramMostUsedSearchItem);
            paramQQAppInterface.latestUsedTime = paramMostUsedSearchItem.timeStamp;
            break label338;
          }
          if (j == 0)
          {
            paramQQAppInterface = new MostUsedSearch();
            paramQQAppInterface.orgKey = paramMostUsedSearchItem.searchKey;
            paramQQAppInterface.items.add(paramMostUsedSearchItem);
            paramQQAppInterface.latestUsedTime = paramMostUsedSearchItem.timeStamp;
            this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
          }
          l1 = NetConnInfoCenter.getServerTimeMillis();
          a(this.jdField_a_of_type_JavaUtilArrayList, 1000, l1 - 604800000L);
          return true;
        }
        finally
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        }
        return false;
        label322:
        i += 1;
        long l2 = l1;
        continue;
        label333:
        i = 1;
        continue;
        label338:
        j = 1;
      }
      i += 1;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("MostUsedCahce", 2, "mCacheName  null");
        return;
      }
      QLog.d("MostUsedCahce", 2, "list  init");
      ??? = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp().getBaseContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MostUsed");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      paramQQAppInterface = ((SharedPreferences)???).getString(localStringBuilder.toString(), "");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        a(paramQQAppInterface);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedCache
 * JD-Core Version:    0.7.0.1
 */