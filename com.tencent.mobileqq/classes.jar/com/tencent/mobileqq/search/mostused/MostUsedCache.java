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
  private static Object c = new Object();
  private static final Comparator<MostUsedCache.MostUsedSearchItemModel> f = new MostUsedCache.1();
  private static final Comparator<MostUsedSearch> g = new MostUsedCache.2();
  private ArrayList<MostUsedSearch> a = new ArrayList();
  private Lock b = new ReentrantLock();
  private boolean d = false;
  private String e = "";
  
  MostUsedCache(String paramString)
  {
    this.e = paramString;
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
      Collections.sort(paramArrayList, f);
      localObject1 = new ArrayList();
      Object localObject2 = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MostUsedCache.MostUsedSearchItemModel localMostUsedSearchItemModel = (MostUsedCache.MostUsedSearchItemModel)paramArrayList.next();
        int i = localMostUsedSearchItemModel.a.identifyType * 100 + localMostUsedSearchItemModel.a.businessType;
        Object localObject3;
        if (((HashMap)localObject2).containsKey(Integer.valueOf(i)))
        {
          localObject3 = (HashMap)((HashMap)localObject2).get(Integer.valueOf(i));
          if (((HashMap)localObject3).containsKey(localMostUsedSearchItemModel.a.identify))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("more high level exsit ");
            ((StringBuilder)localObject3).append(localMostUsedSearchItemModel.a.identify);
            QLog.d("MostUsedCahce", 2, ((StringBuilder)localObject3).toString());
          }
          else
          {
            ((HashMap)localObject3).put(localMostUsedSearchItemModel.a.identify, localMostUsedSearchItemModel);
          }
        }
        else
        {
          localObject3 = new HashMap();
          ((HashMap)localObject3).put(localMostUsedSearchItemModel.a.identify, localMostUsedSearchItemModel);
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
      Collections.sort((List)localObject1, f);
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
    //   1: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 184 1 0
    //   9: new 186	java/io/ObjectInputStream
    //   12: dup
    //   13: new 188	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokevirtual 192	java/lang/String:getBytes	()[B
    //   21: iconst_0
    //   22: invokestatic 198	android/util/Base64:decode	([BI)[B
    //   25: invokespecial 201	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: invokespecial 204	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   36: ifnull +10 -> 46
    //   39: aload_0
    //   40: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   43: invokevirtual 207	java/util/ArrayList:clear	()V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 210	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   51: checkcast 41	java/util/ArrayList
    //   54: putfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   57: invokestatic 216	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   60: lstore_2
    //   61: aload_0
    //   62: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   65: sipush 1000
    //   68: lload_2
    //   69: ldc2_w 217
    //   72: lsub
    //   73: invokestatic 221	com/tencent/mobileqq/search/mostused/MostUsedCache:a	(Ljava/util/ArrayList;IJ)V
    //   76: goto +130 -> 206
    //   79: astore_1
    //   80: goto +136 -> 216
    //   83: astore_1
    //   84: new 76	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: ldc 223
    //   97: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 224	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   107: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 154
    //   113: iconst_2
    //   114: aload 4
    //   116: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: goto +84 -> 206
    //   125: astore_1
    //   126: new 76	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   133: astore 4
    //   135: aload 4
    //   137: ldc 228
    //   139: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 4
    //   145: aload_1
    //   146: invokevirtual 229	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   149: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 154
    //   155: iconst_2
    //   156: aload 4
    //   158: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto +42 -> 206
    //   167: astore_1
    //   168: new 76	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc 231
    //   181: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 4
    //   187: aload_1
    //   188: invokevirtual 232	java/io/IOException:toString	()Ljava/lang/String;
    //   191: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 154
    //   197: iconst_2
    //   198: aload 4
    //   200: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   210: invokeinterface 235 1 0
    //   215: return
    //   216: aload_0
    //   217: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   220: invokeinterface 235 1 0
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
      Collections.sort(paramArrayList, g);
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
  
  /* Error */
  private String b()
  {
    // Byte code:
    //   0: new 252	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 253	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 184 1 0
    //   17: new 255	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 258	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: aload_0
    //   26: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   29: invokevirtual 262	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: new 58	java/lang/String
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 265	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: iconst_0
    //   41: invokestatic 268	android/util/Base64:encode	([BI)[B
    //   44: invokespecial 269	java/lang/String:<init>	([B)V
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 235 1 0
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: goto +89 -> 149
    //   63: astore_1
    //   64: new 76	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: ldc_w 271
    //   76: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: aload_1
    //   82: invokevirtual 224	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   85: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 154
    //   91: iconst_2
    //   92: aload_2
    //   93: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: goto +39 -> 138
    //   102: astore_1
    //   103: new 76	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   110: astore_2
    //   111: aload_2
    //   112: ldc_w 273
    //   115: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 232	java/io/IOException:toString	()Ljava/lang/String;
    //   124: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 154
    //   130: iconst_2
    //   131: aload_2
    //   132: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   142: invokeinterface 235 1 0
    //   147: aconst_null
    //   148: areturn
    //   149: aload_0
    //   150: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   153: invokeinterface 235 1 0
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	MostUsedCache
    //   7	51	1	localObject1	Object
    //   59	1	1	localObject2	Object
    //   63	19	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   102	57	1	localIOException	java.io.IOException
    //   71	61	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	48	59	finally
    //   64	99	59	finally
    //   103	138	59	finally
    //   17	48	63	java/lang/IllegalArgumentException
    //   17	48	102	java/io/IOException
  }
  
  public ArrayList<MostUsedCache.MostUsedSearchItemModel> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!this.d) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface = new ArrayList();
    if (TextUtils.isEmpty(paramString.trim())) {
      return paramQQAppInterface;
    }
    this.b.lock();
    int i = 0;
    try
    {
      for (;;)
      {
        int j = this.a.size();
        if (i >= j) {
          break;
        }
        MostUsedSearch localMostUsedSearch = (MostUsedSearch)this.a.get(i);
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
              ((MostUsedCache.MostUsedSearchItemModel)localObject).d = false;
              ((MostUsedCache.MostUsedSearchItemModel)localObject).a = new MostUsedSearchItem(localMostUsedSearchItem);
              ((MostUsedCache.MostUsedSearchItemModel)localObject).c = k;
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
      this.b.unlock();
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
      this.b.unlock();
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
    //   1: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 184 1 0
    //   9: aload_0
    //   10: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: getfield 44	com/tencent/mobileqq/search/mostused/MostUsedCache:a	Ljava/util/ArrayList;
    //   20: invokevirtual 207	java/util/ArrayList:clear	()V
    //   23: aload_0
    //   24: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   27: invokeinterface 235 1 0
    //   32: getstatic 27	com/tencent/mobileqq/search/mostused/MostUsedCache:c	Ljava/lang/Object;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 51	com/tencent/mobileqq/search/mostused/MostUsedCache:d	Z
    //   43: aload_1
    //   44: monitorexit
    //   45: ldc 154
    //   47: iconst_2
    //   48: ldc_w 325
    //   51: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: return
    //   55: astore_2
    //   56: aload_1
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 49	com/tencent/mobileqq/search/mostused/MostUsedCache:b	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 235 1 0
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
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MostUsed");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    if (!this.d) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface = b();
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return;
    }
    localEditor.putString((String)localObject, paramQQAppInterface);
    localEditor.apply();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, MostUsedSearchItem paramMostUsedSearchItem)
  {
    if (!this.d) {
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
      this.b.lock();
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
          if (i < this.a.size())
          {
            paramQQAppInterface = (MostUsedSearch)this.a.get(i);
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
            this.a.add(paramQQAppInterface);
          }
          l1 = NetConnInfoCenter.getServerTimeMillis();
          a(this.a, 1000, l1 - 604800000L);
          return true;
        }
        finally
        {
          this.b.unlock();
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
    synchronized (c)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      if (TextUtils.isEmpty(this.e))
      {
        QLog.e("MostUsedCahce", 2, "mCacheName  null");
        return;
      }
      QLog.d("MostUsedCahce", 2, "list  init");
      ??? = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp().getBaseContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MostUsed");
      localStringBuilder.append(this.e);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      paramQQAppInterface = ((SharedPreferences)???).getString(localStringBuilder.toString(), "");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        a(paramQQAppInterface);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedCache
 * JD-Core Version:    0.7.0.1
 */