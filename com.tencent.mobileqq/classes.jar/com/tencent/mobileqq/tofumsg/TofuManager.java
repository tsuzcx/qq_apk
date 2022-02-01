package com.tencent.mobileqq.tofumsg;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.util.Singleton;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public class TofuManager
  implements Handler.Callback, Manager
{
  QQAppInterface a;
  Handler b;
  EntityManager c;
  Singleton<TofuDataHandlerFactory, QQAppInterface> d;
  Set<String> e;
  QQLruCache<String, List<TofuItem>> f = new QQLruCache(2021, 8, 1);
  TofuObserver g = new TofuManager.1(this);
  
  public TofuManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.d = new TofuManager.2(this);
    this.e = Collections.synchronizedSet(new HashSet());
    this.c = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.addObserver(this.g, true);
  }
  
  private static TofuItem a(List<TofuItem> paramList, int paramInt)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TofuItem localTofuItem = (TofuItem)paramList.next();
      if (localTofuItem.busId == paramInt) {
        return localTofuItem;
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, String paramString, List<oidb_0xe61.BeancurdCubeInfoResult> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      List localList = a(paramString);
      try
      {
        BeancurdManager localBeancurdManager = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
        a(paramList, new BeancurdCubeInfoResultComparator(this.a, localBeancurdManager, this.d));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      paramBoolean = a(paramString, paramList, localList);
      if (localList.size() > 0) {
        a(paramString, localList, paramBoolean);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_TofuManager", 2, String.format("WHAT_GET_PULLED_DATA frdUin=%s", new Object[] { MobileQQ.getShortUinStr(paramString) }));
    }
    this.e.remove(paramString);
  }
  
  private boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = paramEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("updateEntity em closed e=");
      paramEntityManager.append(paramEntity.getTableName());
      QLog.d("Tofu_TofuManager", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  private void c(String paramString, int paramInt)
  {
    List localList = b(paramString, paramInt);
    boolean bool;
    if ((NetworkUtil.isNetworkAvailable()) && (a(paramString, localList))) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      this.e.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_TofuManager", 2, String.format("WHAT_PREPARE_PULL_TOFUDATA uin=%s reqSize=%d hasReq=%b", new Object[] { MobileQQ.getShortUinStr(paramString), Integer.valueOf(localList.size()), Boolean.valueOf(bool) }));
    }
  }
  
  @NotNull
  protected List<TofuItem> a(String paramString)
  {
    Object localObject2;
    synchronized (this.f)
    {
      ??? = (List)this.f.get(paramString);
      Object localObject4 = ???;
      if (??? == null)
      {
        long l = System.currentTimeMillis();
        int i = 0;
        try
        {
          ??? = this.c.query(TofuItem.class, false, "frdUin=?", new String[] { paramString }, null, null, null, null);
          ??? = ???;
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("readTofuItems exception + ");
          ((StringBuilder)localObject4).append(localException.getMessage());
          QLog.d("Tofu_TofuManager", 1, ((StringBuilder)localObject4).toString(), localException);
        }
        localObject2 = ???;
        if (??? == null) {
          localObject2 = new ArrayList(TofuConst.a.length);
        }
        synchronized (this.f)
        {
          this.f.put(paramString, localObject2);
          localObject4 = localObject2;
          if (QLog.isColorLevel())
          {
            paramString = MobileQQ.getShortUinStr(paramString);
            if (localObject2 != null) {
              i = ((List)localObject2).size();
            }
            QLog.i("Tofu_TofuManager", 2, String.format("readTofuItems %s size=%d cost=%dms", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) }));
            return localObject2;
          }
        }
      }
      return localObject4;
    }
  }
  
  /* Error */
  protected void a(String paramString, List<TofuItem> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 89	com/tencent/mobileqq/tofumsg/TofuManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 303	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: astore 6
    //   14: aload 6
    //   16: invokevirtual 308	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_2
    //   20: invokeinterface 101 1 0
    //   25: astore 7
    //   27: aload 7
    //   29: invokeinterface 107 1 0
    //   34: ifeq +29 -> 63
    //   37: aload 7
    //   39: invokeinterface 111 1 0
    //   44: checkcast 113	com/tencent/mobileqq/tofumsg/TofuItem
    //   47: astore 8
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 89	com/tencent/mobileqq/tofumsg/TofuManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: aload 8
    //   56: invokespecial 310	com/tencent/mobileqq/tofumsg/TofuManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   59: pop
    //   60: goto -33 -> 27
    //   63: aload 6
    //   65: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   68: aload 6
    //   70: invokevirtual 316	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   73: goto +54 -> 127
    //   76: astore_1
    //   77: goto +143 -> 220
    //   80: astore 7
    //   82: new 210	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   89: astore 8
    //   91: aload 8
    //   93: ldc_w 318
    //   96: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 8
    //   102: aload 7
    //   104: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 164
    //   113: iconst_1
    //   114: aload 8
    //   116: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aload 7
    //   121: invokestatic 276	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: goto -56 -> 68
    //   127: iload_3
    //   128: ifeq +34 -> 162
    //   131: aload_0
    //   132: getfield 37	com/tencent/mobileqq/tofumsg/TofuManager:f	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   135: astore 6
    //   137: aload 6
    //   139: monitorenter
    //   140: aload_0
    //   141: getfield 37	com/tencent/mobileqq/tofumsg/TofuManager:f	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   144: aload_1
    //   145: aload_2
    //   146: invokevirtual 290	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: aload 6
    //   152: monitorexit
    //   153: goto +9 -> 162
    //   156: astore_1
    //   157: aload 6
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +54 -> 219
    //   168: ldc 164
    //   170: iconst_2
    //   171: ldc_w 320
    //   174: iconst_4
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_1
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_2
    //   185: invokeinterface 126 1 0
    //   190: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: aastore
    //   194: dup
    //   195: iconst_2
    //   196: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   199: lload 4
    //   201: lsub
    //   202: invokestatic 297	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   205: aastore
    //   206: dup
    //   207: iconst_3
    //   208: iload_3
    //   209: invokestatic 251	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   212: aastore
    //   213: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: return
    //   220: aload 6
    //   222: invokevirtual 316	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   225: goto +5 -> 230
    //   228: aload_1
    //   229: athrow
    //   230: goto -2 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	TofuManager
    //   0	233	1	paramString	String
    //   0	233	2	paramList	List<TofuItem>
    //   0	233	3	paramBoolean	boolean
    //   3	197	4	l	long
    //   12	209	6	localObject1	Object
    //   25	13	7	localIterator	Iterator
    //   80	40	7	localException	Exception
    //   47	68	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	76	finally
    //   27	60	76	finally
    //   63	68	76	finally
    //   82	124	76	finally
    //   19	27	80	java/lang/Exception
    //   27	60	80	java/lang/Exception
    //   63	68	80	java/lang/Exception
    //   140	153	156	finally
    //   157	160	156	finally
  }
  
  protected void a(List<oidb_0xe61.BeancurdCubeInfoResult> paramList, Comparator paramComparator)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 1) {
        return;
      }
      Collections.sort(paramList, paramComparator);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str = MobileQQ.getShortUinStr(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase(this.a.getCurrentAccountUin())) && (!this.e.contains(paramString)))
    {
      QLog.i("Tofu_TofuManager", 1, String.format("startCheckPullTofuData [%s, %d]", new Object[] { str, Integer.valueOf(paramInt) }));
      this.e.add(paramString);
      this.b.obtainMessage(0, paramInt, 0, paramString).sendToTarget();
      return true;
    }
    QLog.i("Tofu_TofuManager", 1, String.format("startCheckPullTofuData return. [%s, %d]", new Object[] { str, Integer.valueOf(paramInt) }));
    return false;
  }
  
  protected boolean a(String paramString, List<TofuItem> paramList)
  {
    if (paramList.size() == 0) {
      return false;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (TofuItem)paramList.next();
      localObject = ((TofuDataHandlerFactory)this.d.get(this.a)).a(((TofuItem)localObject).busId).a((TofuItem)localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    ((TofuHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TOFUMSG_HANDLER)).a(paramString, localArrayList);
    return true;
  }
  
  protected boolean a(String paramString, List<oidb_0xe61.BeancurdCubeInfoResult> paramList, List<TofuItem> paramList1)
  {
    long l = System.currentTimeMillis() / 1000L;
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      oidb_0xe61.BeancurdCubeInfoResult localBeancurdCubeInfoResult = (oidb_0xe61.BeancurdCubeInfoResult)localIterator.next();
      if ((localBeancurdCubeInfoResult != null) && (localBeancurdCubeInfoResult.beancurdCubeInfo.has()) && (localBeancurdCubeInfoResult.beancurdCubeInfo.get() != null) && (localBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has()))
      {
        int i = TofuConst.c((int)((oidb_0xe61.BeancurdCubeInfo)localBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
        if (i != -1)
        {
          TofuItem localTofuItem = a(paramList1, i);
          paramList = localTofuItem;
          if (localTofuItem == null)
          {
            bool = true;
            paramList = new TofuItem(paramString, i);
            paramList1.add(paramList);
          }
          ((TofuDataHandlerFactory)this.d.get(this.a)).a(i).a(paramList, localBeancurdCubeInfoResult, l);
        }
      }
    }
    return bool;
  }
  
  @NotNull
  protected List<TofuItem> b(String paramString, int paramInt)
  {
    List localList = a(paramString);
    ArrayList localArrayList = new ArrayList(TofuConst.a.length);
    long l = System.currentTimeMillis() / 1000L;
    int i = 0;
    while (i < TofuConst.a.length)
    {
      ITofuDataHandler localITofuDataHandler = ((TofuDataHandlerFactory)this.d.get(this.a)).a(i);
      TofuItem localTofuItem2 = a(localList, i);
      TofuItem localTofuItem1 = localTofuItem2;
      if (localTofuItem2 == null) {
        localTofuItem1 = new TofuItem(paramString, i);
      }
      localTofuItem1 = localITofuDataHandler.a(localTofuItem1, l, paramInt);
      if (localTofuItem1 != null) {
        localArrayList.add(localTofuItem1);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(String paramString)
  {
    synchronized (this.f)
    {
      List localList = (List)this.f.remove(paramString);
      int j = -1;
      try
      {
        ??? = TableBuilder.getTableName(TofuItem.class);
        i = this.c.delete((String)???, "frdUin=?", new String[] { paramString });
      }
      catch (Throwable localThrowable)
      {
        QLog.d("Tofu_TofuManager", 1, localThrowable.getMessage(), localThrowable);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.d("Tofu_TofuManager", 1, localIllegalAccessException.getMessage(), localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.d("Tofu_TofuManager", 1, localInstantiationException.getMessage(), localInstantiationException);
      }
      int i = -1;
      if (QLog.isColorLevel())
      {
        if (localList != null) {
          j = localList.size();
        }
        QLog.i("Tofu_TofuManager", 2, String.format("onDelFriend frdUin=%s delCacheItems=%d delDbCnt=%d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      paramMessage = (Object[])paramMessage.obj;
      a(((Boolean)paramMessage[0]).booleanValue(), (String)paramMessage[1], (List)paramMessage[2]);
      return false;
    }
    c((String)paramMessage.obj, paramMessage.arg1);
    return false;
  }
  
  public void onDestroy()
  {
    this.c.close();
    this.a.removeObserver(this.g);
    this.b.removeCallbacksAndMessages(null);
    ((TofuDataHandlerFactory)this.d.get(this.a)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManager
 * JD-Core Version:    0.7.0.1
 */