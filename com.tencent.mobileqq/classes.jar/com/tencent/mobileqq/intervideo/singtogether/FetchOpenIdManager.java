package com.tencent.mobileqq.intervideo.singtogether;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public class FetchOpenIdManager
  implements Manager
{
  private int jdField_a_of_type_Int = -1;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FetchOpenIdManager.3(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FetchOpenIdObserver jdField_a_of_type_ComTencentMobileqqIntervideoSingtogetherFetchOpenIdObserver = new FetchOpenIdManager.2(this);
  private HashMap<Long, HashMap<Long, String>> jdField_a_of_type_JavaUtilHashMap;
  private List<OpenIdItem> jdField_a_of_type_JavaUtilList;
  
  public FetchOpenIdManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqIntervideoSingtogetherFetchOpenIdObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(paramQQAppInterface);
  }
  
  /* Error */
  private OpenIdItem a(OpenIdItem paramOpenIdItem, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 70 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 76 1 0
    //   20: ifeq +125 -> 145
    //   23: aload 4
    //   25: invokeinterface 80 1 0
    //   30: checkcast 82	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem
    //   33: astore_3
    //   34: aload_3
    //   35: getfield 86	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   38: aload_1
    //   39: getfield 86	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   42: lcmp
    //   43: ifne -30 -> 13
    //   46: aload_3
    //   47: getfield 89	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   50: aload_1
    //   51: getfield 89	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   54: lcmp
    //   55: ifne -42 -> 13
    //   58: iload_2
    //   59: ifeq +11 -> 70
    //   62: aload_3
    //   63: aload_1
    //   64: getfield 93	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   67: putfield 93	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   70: aload_3
    //   71: astore_1
    //   72: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +66 -> 141
    //   78: ldc 100
    //   80: iconst_2
    //   81: new 102	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   88: ldc 105
    //   90: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: getfield 86	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   97: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: ldc 114
    //   102: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: getfield 89	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   109: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc 116
    //   114: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: getfield 93	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   121: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 118
    //   126: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload_2
    //   130: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   133: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: areturn
    //   145: aload_0
    //   146: getfield 46	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   149: aload_1
    //   150: invokeinterface 133 2 0
    //   155: pop
    //   156: goto -15 -> 141
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	FetchOpenIdManager
    //   0	164	1	paramOpenIdItem	OpenIdItem
    //   0	164	2	paramBoolean	boolean
    //   33	107	3	localOpenIdItem	OpenIdItem
    //   11	13	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	159	finally
    //   13	58	159	finally
    //   62	70	159	finally
    //   72	139	159	finally
    //   145	156	159	finally
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManagerV2.excute(new FetchOpenIdManager.1(this, paramQQAppInterface), 16, null, true);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void b(long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      HashMap localHashMap2 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localHashMap1);
      }
      localHashMap1.put(Long.valueOf(paramLong2), paramString);
      return;
    }
    finally {}
  }
  
  public String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong2));
        if (localObject1 != null)
        {
          localObject1 = (String)((HashMap)localObject1).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdManager", 2, " getOpenId openId=" + (String)localObject1 + " uin=" + paramLong1 + " state= " + this.jdField_a_of_type_Int);
          }
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool) {
            return localObject1;
          }
          if ((this.jdField_a_of_type_Int == 0) || (!paramBoolean)) {
            continue;
          }
          FetchOpenIdServlet.a(paramLong1, paramLong2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
        }
        String str = "";
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +47 -> 52
    //   8: ldc 100
    //   10: iconst_2
    //   11: new 102	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   18: ldc 191
    //   20: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 171
    //   29: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: lload_3
    //   33: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: ldc 193
    //   38: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload 5
    //   43: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 41	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   56: lload_1
    //   57: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 38	java/util/HashMap
    //   66: astore 7
    //   68: aload 7
    //   70: astore 6
    //   72: aload 7
    //   74: ifnonnull +26 -> 100
    //   77: new 38	java/util/HashMap
    //   80: dup
    //   81: invokespecial 39	java/util/HashMap:<init>	()V
    //   84: astore 6
    //   86: aload_0
    //   87: getfield 41	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   90: lload_1
    //   91: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: aload 6
    //   96: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: aload_0
    //   101: getfield 36	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   104: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   107: invokevirtual 203	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   110: astore 7
    //   112: aload 6
    //   114: lload_3
    //   115: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aload 5
    //   120: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: new 82	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem
    //   127: dup
    //   128: invokespecial 204	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:<init>	()V
    //   131: astore 6
    //   133: aload 6
    //   135: lload_1
    //   136: putfield 89	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   139: aload 6
    //   141: aload 5
    //   143: putfield 93	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   146: aload 6
    //   148: lload_3
    //   149: putfield 86	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   152: aload_0
    //   153: aload 6
    //   155: iconst_1
    //   156: invokespecial 64	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:a	(Lcom/tencent/mobileqq/intervideo/singtogether/OpenIdItem;Z)Lcom/tencent/mobileqq/intervideo/singtogether/OpenIdItem;
    //   159: astore 5
    //   161: aload 5
    //   163: invokevirtual 208	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:getStatus	()I
    //   166: sipush 1000
    //   169: if_icmpne +18 -> 187
    //   172: aload 7
    //   174: aload 5
    //   176: invokevirtual 214	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   179: aload 7
    //   181: invokevirtual 217	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   184: aload_0
    //   185: monitorexit
    //   186: return
    //   187: aload 7
    //   189: aload 5
    //   191: invokevirtual 221	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   194: pop
    //   195: goto -16 -> 179
    //   198: astore 5
    //   200: aload_0
    //   201: monitorexit
    //   202: aload 5
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	FetchOpenIdManager
    //   0	205	1	paramLong1	long
    //   0	205	3	paramLong2	long
    //   0	205	5	paramString	String
    //   70	84	6	localObject1	Object
    //   66	122	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	198	finally
    //   52	68	198	finally
    //   77	100	198	finally
    //   100	179	198	finally
    //   179	184	198	finally
    //   187	195	198	finally
  }
  
  /* Error */
  public boolean a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 41	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   9: lload_1
    //   10: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   13: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 38	java/util/HashMap
    //   19: astore 7
    //   21: iload 6
    //   23: istore 5
    //   25: aload 7
    //   27: ifnull +25 -> 52
    //   30: aload 7
    //   32: lload_3
    //   33: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 225	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 167	java/lang/String
    //   42: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +163 -> 208
    //   48: iload 6
    //   50: istore 5
    //   52: aload_0
    //   53: getfield 46	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   56: invokeinterface 70 1 0
    //   61: astore 8
    //   63: aload 8
    //   65: invokeinterface 76 1 0
    //   70: ifeq +144 -> 214
    //   73: aload 8
    //   75: invokeinterface 80 1 0
    //   80: checkcast 82	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem
    //   83: astore 7
    //   85: aload 7
    //   87: getfield 86	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   90: lload_3
    //   91: lcmp
    //   92: ifne -29 -> 63
    //   95: aload 7
    //   97: getfield 89	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   100: lload_1
    //   101: lcmp
    //   102: ifne -39 -> 63
    //   105: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +58 -> 166
    //   111: ldc 100
    //   113: iconst_2
    //   114: new 102	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   121: ldc 105
    //   123: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 7
    //   128: getfield 86	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   131: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc 114
    //   136: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 7
    //   141: getfield 89	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   144: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: ldc 116
    //   149: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 7
    //   154: getfield 93	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   157: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 46	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   170: aload 7
    //   172: invokeinterface 227 2 0
    //   177: pop
    //   178: aload_0
    //   179: getfield 36	com/tencent/mobileqq/intervideo/singtogether/FetchOpenIdManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   185: invokevirtual 203	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   188: astore 8
    //   190: aload 8
    //   192: aload 7
    //   194: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   197: pop
    //   198: aload 8
    //   200: invokevirtual 217	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   203: aload_0
    //   204: monitorexit
    //   205: iload 5
    //   207: ireturn
    //   208: iconst_1
    //   209: istore 5
    //   211: goto -159 -> 52
    //   214: goto -11 -> 203
    //   217: astore 7
    //   219: aload_0
    //   220: monitorexit
    //   221: aload 7
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FetchOpenIdManager
    //   0	224	1	paramLong1	long
    //   0	224	3	paramLong2	long
    //   23	187	5	bool1	boolean
    //   1	48	6	bool2	boolean
    //   19	174	7	localObject1	Object
    //   217	5	7	localObject2	Object
    //   61	138	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	21	217	finally
    //   30	48	217	finally
    //   52	63	217	finally
    //   63	166	217	finally
    //   166	203	217	finally
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqIntervideoSingtogetherFetchOpenIdObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_Int = -1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager
 * JD-Core Version:    0.7.0.1
 */