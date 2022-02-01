package com.tencent.mobileqq.onlinestatus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.manager.IAutoReplyManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AutoReplyManagerImpl
  implements IAutoReplyManager
{
  private AppInterface a;
  private EntityManager b;
  private Object c = new Object();
  private List<AutoReplyText> d;
  
  public AutoReplyManagerImpl(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = paramAppInterface.getEntityManagerFactory().createEntityManager();
    d();
  }
  
  private void d()
  {
    ThreadManager.getFileThreadHandler().post(new AutoReplyManagerImpl.1(this));
  }
  
  public List<AutoReplyText> a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return new ArrayList(this.d);
    }
    localObject = new ArrayList();
    ((List)localObject).add(new AutoReplyText(HardCodeUtil.a(2131899099), 0));
    ((List)localObject).add(new AutoReplyText(HardCodeUtil.a(2131899098), 1));
    ((List)localObject).add(new AutoReplyText(HardCodeUtil.a(2131899096), 2));
    ((List)localObject).add(new AutoReplyText(HardCodeUtil.a(2131899097), 2147483647));
    ((AutoReplyText)((List)localObject).get(0)).mCheckFlag = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AutoReplyManager", 2, "getAutoReplyCache, buffList == null");
    }
    d();
    return localObject;
  }
  
  /* Error */
  public void a(List<AutoReplyText> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 38	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   14: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   17: astore 5
    //   19: aload 5
    //   21: astore 4
    //   23: aload 5
    //   25: astore_3
    //   26: aload 5
    //   28: invokevirtual 133	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   31: aload 5
    //   33: astore 4
    //   35: aload 5
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 38	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: ldc 79
    //   44: invokevirtual 137	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   47: pop
    //   48: aload 5
    //   50: astore 4
    //   52: aload 5
    //   54: astore_3
    //   55: aload_1
    //   56: invokeinterface 141 1 0
    //   61: astore 6
    //   63: aload 5
    //   65: astore 4
    //   67: aload 5
    //   69: astore_3
    //   70: aload 6
    //   72: invokeinterface 146 1 0
    //   77: ifeq +86 -> 163
    //   80: aload 5
    //   82: astore 4
    //   84: aload 5
    //   86: astore_3
    //   87: aload 6
    //   89: invokeinterface 150 1 0
    //   94: checkcast 79	com/tencent/mobileqq/data/AutoReplyText
    //   97: astore 7
    //   99: aload 5
    //   101: astore 4
    //   103: aload 5
    //   105: astore_3
    //   106: aload 7
    //   108: invokevirtual 153	com/tencent/mobileqq/data/AutoReplyText:getTextId	()I
    //   111: iload_2
    //   112: if_icmpne +19 -> 131
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: astore_3
    //   122: aload 7
    //   124: iconst_1
    //   125: putfield 104	com/tencent/mobileqq/data/AutoReplyText:mCheckFlag	I
    //   128: goto +16 -> 144
    //   131: aload 5
    //   133: astore 4
    //   135: aload 5
    //   137: astore_3
    //   138: aload 7
    //   140: iconst_0
    //   141: putfield 104	com/tencent/mobileqq/data/AutoReplyText:mCheckFlag	I
    //   144: aload 5
    //   146: astore 4
    //   148: aload 5
    //   150: astore_3
    //   151: aload_0
    //   152: getfield 38	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   155: aload 7
    //   157: invokevirtual 157	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   160: goto -97 -> 63
    //   163: aload 5
    //   165: astore 4
    //   167: aload 5
    //   169: astore_3
    //   170: aload 5
    //   172: invokevirtual 160	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   175: aload 5
    //   177: astore 4
    //   179: aload 5
    //   181: astore_3
    //   182: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +36 -> 221
    //   188: aload 5
    //   190: astore 4
    //   192: aload 5
    //   194: astore_3
    //   195: ldc 112
    //   197: iconst_2
    //   198: ldc 162
    //   200: iconst_2
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_1
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: iload_2
    //   211: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: invokestatic 174	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   218: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 5
    //   223: ifnull +44 -> 267
    //   226: aload 5
    //   228: astore_3
    //   229: goto +34 -> 263
    //   232: astore_1
    //   233: goto +90 -> 323
    //   236: astore 5
    //   238: aload_3
    //   239: astore 4
    //   241: aload 5
    //   243: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   246: aload_3
    //   247: astore 4
    //   249: ldc 112
    //   251: iconst_1
    //   252: ldc 179
    //   254: aload 5
    //   256: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_3
    //   260: ifnull +7 -> 267
    //   263: aload_3
    //   264: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   267: aload_0
    //   268: getfield 22	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:c	Ljava/lang/Object;
    //   271: astore_3
    //   272: aload_3
    //   273: monitorenter
    //   274: aload_0
    //   275: getfield 45	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:d	Ljava/util/List;
    //   278: ifnonnull +17 -> 295
    //   281: aload_0
    //   282: new 73	java/util/ArrayList
    //   285: dup
    //   286: invokespecial 77	java/util/ArrayList:<init>	()V
    //   289: putfield 45	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:d	Ljava/util/List;
    //   292: goto +12 -> 304
    //   295: aload_0
    //   296: getfield 45	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:d	Ljava/util/List;
    //   299: invokeinterface 188 1 0
    //   304: aload_0
    //   305: getfield 45	com/tencent/mobileqq/onlinestatus/AutoReplyManagerImpl:d	Ljava/util/List;
    //   308: aload_1
    //   309: invokeinterface 192 2 0
    //   314: pop
    //   315: aload_3
    //   316: monitorexit
    //   317: return
    //   318: astore_1
    //   319: aload_3
    //   320: monitorexit
    //   321: aload_1
    //   322: athrow
    //   323: aload 4
    //   325: ifnull +8 -> 333
    //   328: aload 4
    //   330: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   333: goto +5 -> 338
    //   336: aload_1
    //   337: athrow
    //   338: goto -2 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	AutoReplyManagerImpl
    //   0	341	1	paramList	List<AutoReplyText>
    //   0	341	2	paramInt	int
    //   6	314	3	localObject1	Object
    //   8	321	4	localObject2	Object
    //   17	210	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   236	19	5	localException	java.lang.Exception
    //   61	27	6	localIterator	Iterator
    //   97	59	7	localAutoReplyText	AutoReplyText
    // Exception table:
    //   from	to	target	type
    //   10	19	232	finally
    //   26	31	232	finally
    //   38	48	232	finally
    //   55	63	232	finally
    //   70	80	232	finally
    //   87	99	232	finally
    //   106	115	232	finally
    //   122	128	232	finally
    //   138	144	232	finally
    //   151	160	232	finally
    //   170	175	232	finally
    //   182	188	232	finally
    //   195	221	232	finally
    //   241	246	232	finally
    //   249	259	232	finally
    //   10	19	236	java/lang/Exception
    //   26	31	236	java/lang/Exception
    //   38	48	236	java/lang/Exception
    //   55	63	236	java/lang/Exception
    //   70	80	236	java/lang/Exception
    //   87	99	236	java/lang/Exception
    //   106	115	236	java/lang/Exception
    //   122	128	236	java/lang/Exception
    //   138	144	236	java/lang/Exception
    //   151	160	236	java/lang/Exception
    //   170	175	236	java/lang/Exception
    //   182	188	236	java/lang/Exception
    //   195	221	236	java/lang/Exception
    //   274	292	318	finally
    //   295	304	318	finally
    //   304	317	318	finally
    //   319	321	318	finally
  }
  
  public AutoReplyText b()
  {
    List localList = a();
    Iterator localIterator = localList.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      localObject2 = (AutoReplyText)localIterator.next();
      if (((AutoReplyText)localObject2).isChecked()) {
        localObject1 = localObject2;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = (AutoReplyText)localList.get(0);
      QLog.d("AutoReplyManager", 1, "getCurrentAutoReplyText is null, default check index 0");
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getCurrentAutoReplyText: ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("AutoReplyManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoReplyManager", 2, "AutoReplyManager onDestroy");
    }
    this.b.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl
 * JD-Core Version:    0.7.0.1
 */