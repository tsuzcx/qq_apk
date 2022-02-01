package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class GroupTeamWorkManager
  implements Manager
{
  AppInterface a;
  private EntityManager b;
  private ConcurrentHashMap<String, Entity> c = new ConcurrentHashMap();
  private volatile boolean d = false;
  private ConcurrentHashMap<String, Entity> e = new ConcurrentHashMap();
  
  public GroupTeamWorkManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append("_");
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    return localSharedPreferences.getString(paramContext, paramString3);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append("_");
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    localEditor.putString(paramContext, paramString3);
    localEditor.commit();
  }
  
  /* Error */
  private void c(List<GPadInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 108	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 114 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 119 1 0
    //   23: ifeq +24 -> 47
    //   26: aload_1
    //   27: invokeinterface 123 1 0
    //   32: checkcast 125	com/tencent/mobileqq/teamworkforgroup/GPadInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: aload_2
    //   41: invokevirtual 129	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   44: goto -27 -> 17
    //   47: aload_0
    //   48: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   54: invokevirtual 131	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   57: aload_0
    //   58: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   61: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   64: invokevirtual 134	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   67: return
    //   68: astore_1
    //   69: goto +41 -> 110
    //   72: astore_1
    //   73: new 62	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   80: astore_2
    //   81: aload_2
    //   82: ldc 136
    //   84: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: aload_1
    //   90: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   93: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 139
    //   99: iconst_1
    //   100: aload_2
    //   101: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: goto -50 -> 57
    //   110: aload_0
    //   111: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   114: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   117: invokevirtual 134	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   120: goto +5 -> 125
    //   123: aload_1
    //   124: athrow
    //   125: goto -2 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	GroupTeamWorkManager
    //   0	128	1	paramList	List<GPadInfo>
    //   35	66	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	68	finally
    //   17	44	68	finally
    //   47	57	68	finally
    //   73	107	68	finally
    //   0	17	72	java/lang/Exception
    //   17	44	72	java/lang/Exception
    //   47	57	72	java/lang/Exception
  }
  
  /* Error */
  private void d(List<GroupPadTemplateInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 108	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 114 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 119 1 0
    //   23: ifeq +24 -> 47
    //   26: aload_1
    //   27: invokeinterface 123 1 0
    //   32: checkcast 148	com/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: aload_2
    //   41: invokevirtual 129	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   44: goto -27 -> 17
    //   47: aload_0
    //   48: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   54: invokevirtual 131	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   57: aload_0
    //   58: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   61: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   64: invokevirtual 134	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   67: return
    //   68: astore_1
    //   69: goto +41 -> 110
    //   72: astore_1
    //   73: new 62	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   80: astore_2
    //   81: aload_2
    //   82: ldc 150
    //   84: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: aload_1
    //   90: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   93: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 139
    //   99: iconst_1
    //   100: aload_2
    //   101: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: goto -50 -> 57
    //   110: aload_0
    //   111: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   114: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   117: invokevirtual 134	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   120: goto +5 -> 125
    //   123: aload_1
    //   124: athrow
    //   125: goto -2 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	GroupTeamWorkManager
    //   0	128	1	paramList	List<GroupPadTemplateInfo>
    //   35	66	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	68	finally
    //   17	44	68	finally
    //   47	57	68	finally
    //   73	107	68	finally
    //   0	17	72	java/lang/Exception
    //   17	44	72	java/lang/Exception
    //   47	57	72	java/lang/Exception
  }
  
  public void a()
  {
    this.b.drop(GPadInfo.class);
    this.c.clear();
  }
  
  public void a(int paramInt, List<GPadInfo> paramList)
  {
    if (paramInt == 2) {
      a();
    }
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GPadInfo localGPadInfo = (GPadInfo)localIterator.next();
        this.c.put(((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(localGPadInfo.pad_url), localGPadInfo);
      }
      c(paramList);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.c.clear();
      Object localObject1 = this.b.query(GPadInfo.class, false, "groupCode=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (GPadInfo)((Iterator)localObject1).next();
          this.c.put(((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(((GPadInfo)localObject3).pad_url), localObject3);
        }
      }
      this.e.clear();
      localObject1 = this.b;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong);
      localObject1 = ((EntityManager)localObject1).query(GroupPadTemplateInfo.class, false, "groupCode=?", new String[] { ((StringBuilder)localObject3).toString() }, null, null, null, null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (GroupPadTemplateInfo)((Iterator)localObject1).next();
          this.e.put(((GroupPadTemplateInfo)localObject3).templateUrl, localObject3);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if (paramGroupPadTemplateInfo != null)
    {
      if (TextUtils.isEmpty(paramGroupPadTemplateInfo.templateUrl)) {
        return;
      }
      this.e.put(paramGroupPadTemplateInfo.templateUrl, paramGroupPadTemplateInfo);
      a(paramGroupPadTemplateInfo);
    }
  }
  
  public void a(List<GroupPadTemplateInfo> paramList)
  {
    if (this.e != null) {
      b();
    }
    if ((paramList != null) && (this.e != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)localIterator.next();
        this.e.put(localGroupPadTemplateInfo.templateUrl, localGroupPadTemplateInfo);
      }
      d(paramList);
      b(paramList);
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.b.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.b.update(paramEntity);
  }
  
  public void b()
  {
    this.b.drop(GroupPadTemplateInfo.class);
    this.e.clear();
  }
  
  /* Error */
  public void b(List<GroupPadTemplateInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +100 -> 101
    //   4: aload_0
    //   5: getfield 46	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 108	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   16: aload_1
    //   17: invokeinterface 114 1 0
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 119 1 0
    //   29: ifeq +19 -> 48
    //   32: aload_0
    //   33: aload_1
    //   34: invokeinterface 123 1 0
    //   39: checkcast 148	com/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo
    //   42: invokevirtual 232	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:a	(Lcom/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo;)V
    //   45: goto -22 -> 23
    //   48: aload_2
    //   49: invokevirtual 134	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   52: return
    //   53: astore_1
    //   54: goto +41 -> 95
    //   57: astore_1
    //   58: new 62	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: ldc 234
    //   69: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: aload_1
    //   75: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   78: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 139
    //   84: iconst_1
    //   85: aload_3
    //   86: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: goto -44 -> 48
    //   95: aload_2
    //   96: invokevirtual 134	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   99: aload_1
    //   100: athrow
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	GroupTeamWorkManager
    //   0	102	1	paramList	List<GroupPadTemplateInfo>
    //   11	85	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   65	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	23	53	finally
    //   23	45	53	finally
    //   58	92	53	finally
    //   16	23	57	java/lang/Exception
    //   23	45	57	java/lang/Exception
  }
  
  public List<GPadInfo> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((GPadInfo)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  public List<GroupPadTemplateInfo> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((GroupPadTemplateInfo)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap<String, Entity> e()
  {
    return this.c;
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.b;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.b.close();
    }
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkManager
 * JD-Core Version:    0.7.0.1
 */