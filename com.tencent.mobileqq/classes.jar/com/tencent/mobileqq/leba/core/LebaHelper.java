package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.leba.entity.GroupInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReqInfo;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceRespInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaHelper
{
  AppRuntime a;
  byte[] b = new byte[0];
  List<LebaPluginInfo> c;
  List<LebaPluginInfo> d;
  public List<ResourcePluginListener> e;
  boolean f = false;
  int g = 0;
  boolean h = false;
  int i = 0;
  public ILebaBasisApi j;
  public boolean k = false;
  
  public LebaHelper(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = new ArrayList();
  }
  
  public static LebaPluginInfo a(PluginConfig.GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {
      return null;
    }
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    long l;
    if (paramGetResourceRespInfo.res_id.has()) {
      l = paramGetResourceRespInfo.res_id.get();
    } else {
      l = 0L;
    }
    localLebaPluginInfo.uiResId = l;
    boolean bool = paramGetResourceRespInfo.state.has();
    int n = 0;
    if (bool) {
      m = paramGetResourceRespInfo.state.get();
    } else {
      m = 0;
    }
    localLebaPluginInfo.state = m;
    if (paramGetResourceRespInfo.res_seq.has()) {
      m = paramGetResourceRespInfo.res_seq.get();
    } else {
      m = 0;
    }
    localLebaPluginInfo.sResSeq = m;
    bool = paramGetResourceRespInfo.pkg_name.has();
    String str = "";
    if (bool) {
      localObject = paramGetResourceRespInfo.pkg_name.get();
    } else {
      localObject = "";
    }
    localLebaPluginInfo.strPkgName = ((String)localObject);
    if (paramGetResourceRespInfo.res_name.has()) {
      localObject = paramGetResourceRespInfo.res_name.get();
    } else {
      localObject = "";
    }
    localLebaPluginInfo.strResName = ((String)localObject);
    if (paramGetResourceRespInfo.icon_url.has()) {
      localObject = paramGetResourceRespInfo.icon_url.get();
    } else {
      localObject = "";
    }
    localLebaPluginInfo.strResURL = ((String)localObject);
    short s;
    if (paramGetResourceRespInfo.sub_type.has()) {
      s = (short)paramGetResourceRespInfo.sub_type.get();
    } else {
      s = -1;
    }
    localLebaPluginInfo.sResSubType = s;
    if (paramGetResourceRespInfo.jump_url.has()) {
      localObject = paramGetResourceRespInfo.jump_url.get();
    } else {
      localObject = "";
    }
    localLebaPluginInfo.strGotoUrl = ((String)localObject);
    if (paramGetResourceRespInfo.can_change_state.has()) {
      m = paramGetResourceRespInfo.can_change_state.get();
    } else {
      m = 1;
    }
    localLebaPluginInfo.cCanChangeState = m;
    if (paramGetResourceRespInfo.res_conf.has()) {
      localObject = paramGetResourceRespInfo.res_conf.get();
    } else {
      localObject = "";
    }
    localLebaPluginInfo.resConf = ((String)localObject);
    localLebaPluginInfo.cDataType = 0;
    int m = n;
    if (paramGetResourceRespInfo.simple_mode.has()) {
      m = paramGetResourceRespInfo.simple_mode.get();
    }
    localLebaPluginInfo.showInSimpleMode = m;
    Object localObject = str;
    if (paramGetResourceRespInfo.grid_icon_url.has()) {
      localObject = paramGetResourceRespInfo.grid_icon_url.get();
    }
    localLebaPluginInfo.strGridIconUrl = ((String)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("plugin config xml:");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo.res_conf.get());
      QLog.i("ConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    return localLebaPluginInfo;
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +233 -> 239
    //   9: aload_2
    //   10: invokevirtual 195	mqq/app/AppRuntime:isLogin	()Z
    //   13: ifne +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   21: invokevirtual 199	mqq/app/AppRuntime:getPreferences	()Landroid/content/SharedPreferences;
    //   24: astore_2
    //   25: new 163	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: ldc 201
    //   36: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   45: invokevirtual 204	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   48: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: iconst_1
    //   58: invokeinterface 210 3 0
    //   63: ifeq +176 -> 239
    //   66: invokestatic 213	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 215
    //   74: iconst_4
    //   75: ldc 217
    //   77: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   84: invokevirtual 223	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   87: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 233	com/tencent/mobileqq/leba/entity/LebaPluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;)Ljava/util/List;
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +59 -> 158
    //   102: iconst_0
    //   103: istore_1
    //   104: iload_1
    //   105: aload 4
    //   107: invokeinterface 238 1 0
    //   112: if_icmpge +46 -> 158
    //   115: aload 4
    //   117: iload_1
    //   118: invokeinterface 241 2 0
    //   123: checkcast 55	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: getfield 144	com/tencent/mobileqq/leba/entity/LebaPluginInfo:cDataType	B
    //   138: iconst_1
    //   139: if_icmpne +12 -> 151
    //   142: aload_3
    //   143: aload 5
    //   145: getfield 76	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   148: invokestatic 245	com/tencent/mobileqq/leba/entity/LebaPluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;J)V
    //   151: iload_1
    //   152: iconst_1
    //   153: iadd
    //   154: istore_1
    //   155: goto -51 -> 104
    //   158: aload_3
    //   159: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   162: goto +17 -> 179
    //   165: astore_2
    //   166: goto +67 -> 233
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   176: goto -18 -> 158
    //   179: aload_2
    //   180: invokeinterface 257 1 0
    //   185: astore_2
    //   186: new 163	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   193: astore_3
    //   194: aload_3
    //   195: ldc 201
    //   197: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_3
    //   202: aload_0
    //   203: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   206: invokevirtual 204	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   209: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: iconst_0
    //   219: invokeinterface 263 3 0
    //   224: pop
    //   225: aload_2
    //   226: invokeinterface 266 1 0
    //   231: pop
    //   232: return
    //   233: aload_3
    //   234: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   237: aload_2
    //   238: athrow
    //   239: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	LebaHelper
    //   103	52	1	m	int
    //   4	49	2	localObject1	Object
    //   165	15	2	localObject2	Object
    //   185	53	2	localEditor	android.content.SharedPreferences.Editor
    //   32	202	3	localObject3	Object
    //   95	21	4	localList	List
    //   169	3	4	localException	Exception
    //   126	18	5	localLebaPluginInfo	LebaPluginInfo
    // Exception table:
    //   from	to	target	type
    //   91	97	165	finally
    //   104	128	165	finally
    //   133	151	165	finally
    //   171	176	165	finally
    //   91	97	169	java/lang/Exception
    //   104	128	169	java/lang/Exception
    //   133	151	169	java/lang/Exception
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Leba.Helper", 2, "loadServerPlugins");
    }
    Map localMap = LebaUtil.a(LebaUtil.b(this.a));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Leba.Helper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    Object localObject2 = this.a.getEntityManagerFactory().createEntityManager();
    List localList1 = LebaPluginInfo.getAll((EntityManager)localObject2);
    ((EntityManager)localObject2).close();
    localObject2 = new StringBuilder();
    if ((localList1 != null) && (localList1.size() > 0)) {}
    for (;;)
    {
      int m;
      synchronized (this.d)
      {
        m = localList1.size() - 1;
        if (m >= 0)
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList1.get(m);
          GroupInfo localGroupInfo = (GroupInfo)localMap.get(Long.valueOf(localLebaPluginInfo.uiResId));
          if (localGroupInfo == null)
          {
            ((StringBuilder)localObject2).append(",remove ");
            ((StringBuilder)localObject2).append(localLebaPluginInfo);
            localList1.remove(localLebaPluginInfo);
            break label265;
          }
          ((StringBuilder)localObject2).append(",add ");
          ((StringBuilder)localObject2).append(localLebaPluginInfo);
          localLebaPluginInfo.sPriority = LebaUtil.a(localGroupInfo);
          break label265;
        }
        this.d.addAll(localList1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadServerPlugins data =  ");
      localStringBuilder.append(localObject2);
      QLog.i("Leba.Helper", 1, localStringBuilder.toString());
      return;
      label265:
      m -= 1;
    }
  }
  
  public PluginConfig.GetResourceReq a(int paramInt, List<LebaPluginInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramList.next();
        if (localLebaPluginInfo != null)
        {
          PluginConfig.GetResourceReqInfo localGetResourceReqInfo = new PluginConfig.GetResourceReqInfo();
          localGetResourceReqInfo.res_id.set((int)localLebaPluginInfo.uiResId);
          localGetResourceReqInfo.res_seq.set(localLebaPluginInfo.sResSeq);
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    int m = LebaPluginLogic.b();
    paramList = new StringBuilder();
    paramList.append("getLebaPluginListReq pluginType = ");
    paramList.append(m);
    QLog.i("Leba.Helper", 1, paramList.toString());
    paramList = new PluginConfig.GetResourceReq();
    paramList.plugin_type.set(m);
    paramList.plugin_layout_seq.set(paramInt);
    paramList.reqinfo_list.set(localArrayList);
    return paramList;
  }
  
  public void a()
  {
    this.j = ((ILebaBasisApi)QRoute.api(ILebaBasisApi.class));
  }
  
  public void a(int paramInt1, List<GroupInfo> paramList, int paramInt2, int paramInt3)
  {
    int n = LebaUtil.a(this.a);
    int m;
    if (paramList == null) {
      m = -1;
    } else {
      m = paramList.size();
    }
    QLog.i("Leba.Helper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt1), Integer.valueOf(m), Integer.valueOf(paramInt2) }));
    if ((paramInt1 > 0) && (paramInt1 != n) && (paramList != null))
    {
      LebaUtil.a(this.a, paramInt1);
      LebaUtil.a(this.a, paramList);
      LebaUtil.a(this.a, paramInt2, paramInt3);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.e)
    {
      if (!this.e.contains(paramResourcePluginListener)) {
        this.e.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h = false;
      j();
      return;
    }
    this.h = true;
  }
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt1, List<GroupInfo> paramList, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: aload 4
    //   6: iload 5
    //   8: iload 6
    //   10: invokevirtual 416	com/tencent/mobileqq/leba/core/LebaHelper:b	(ZILjava/util/List;Ljava/util/List;II)V
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore 7
    //   19: iload_1
    //   20: ifeq +624 -> 644
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 32	com/tencent/mobileqq/leba/core/LebaHelper:f	Z
    //   28: aload_0
    //   29: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   32: invokevirtual 223	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   35: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: astore 16
    //   40: aload 16
    //   42: invokevirtual 420	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   45: astore 17
    //   47: new 422	java/lang/StringBuffer
    //   50: dup
    //   51: invokespecial 423	java/lang/StringBuffer:<init>	()V
    //   54: astore 18
    //   56: aload 18
    //   58: ldc_w 425
    //   61: invokevirtual 428	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: aload 17
    //   67: invokevirtual 433	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   70: aload 4
    //   72: invokeinterface 319 1 0
    //   77: astore 4
    //   79: iconst_0
    //   80: istore_1
    //   81: iconst_0
    //   82: istore 9
    //   84: iload_1
    //   85: istore 14
    //   87: iload 9
    //   89: istore 11
    //   91: aload 4
    //   93: invokeinterface 324 1 0
    //   98: ifeq +224 -> 322
    //   101: iload_1
    //   102: istore 14
    //   104: iload 9
    //   106: istore 11
    //   108: aload 4
    //   110: invokeinterface 328 1 0
    //   115: checkcast 55	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   118: astore 19
    //   120: aload 19
    //   122: ifnonnull +6 -> 128
    //   125: goto -41 -> 84
    //   128: iload_1
    //   129: istore 14
    //   131: iload 9
    //   133: istore 11
    //   135: aload 18
    //   137: aload 19
    //   139: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: iload_1
    //   144: istore 14
    //   146: iload 9
    //   148: istore 11
    //   150: aload 19
    //   152: getfield 122	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSubType	S
    //   155: ifeq +26 -> 181
    //   158: iload_1
    //   159: istore 13
    //   161: iload 9
    //   163: istore 15
    //   165: iload_1
    //   166: istore 14
    //   168: iload 9
    //   170: istore 11
    //   172: aload 19
    //   174: getfield 122	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSubType	S
    //   177: iconst_2
    //   178: if_icmpne +93 -> 271
    //   181: iload_1
    //   182: istore 12
    //   184: iload 9
    //   186: istore 10
    //   188: iload_1
    //   189: istore 14
    //   191: iload 9
    //   193: istore 11
    //   195: aload 19
    //   197: getfield 81	com/tencent/mobileqq/leba/entity/LebaPluginInfo:state	I
    //   200: iconst_3
    //   201: if_icmpne +23 -> 224
    //   204: iload_1
    //   205: istore 14
    //   207: iload 9
    //   209: istore 11
    //   211: aload 16
    //   213: aload 19
    //   215: invokestatic 440	com/tencent/mobileqq/leba/entity/LebaPluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;)V
    //   218: iconst_1
    //   219: istore 12
    //   221: iconst_1
    //   222: istore 10
    //   224: iload 12
    //   226: istore 13
    //   228: iload 10
    //   230: istore 15
    //   232: iload 12
    //   234: istore 14
    //   236: iload 10
    //   238: istore 11
    //   240: aload 19
    //   242: getfield 81	com/tencent/mobileqq/leba/entity/LebaPluginInfo:state	I
    //   245: iconst_1
    //   246: if_icmpne +25 -> 271
    //   249: iload 12
    //   251: istore 14
    //   253: iload 10
    //   255: istore 11
    //   257: aload 16
    //   259: aload 19
    //   261: invokestatic 440	com/tencent/mobileqq/leba/entity/LebaPluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;)V
    //   264: iconst_1
    //   265: istore 13
    //   267: iload 10
    //   269: istore 15
    //   271: iload 13
    //   273: istore_1
    //   274: iload 15
    //   276: istore 9
    //   278: iload 13
    //   280: istore 14
    //   282: iload 15
    //   284: istore 11
    //   286: aload 19
    //   288: getfield 81	com/tencent/mobileqq/leba/entity/LebaPluginInfo:state	I
    //   291: iconst_2
    //   292: if_icmpne -208 -> 84
    //   295: iload 13
    //   297: istore 14
    //   299: iload 15
    //   301: istore 11
    //   303: aload 16
    //   305: aload 19
    //   307: getfield 76	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   310: invokestatic 245	com/tencent/mobileqq/leba/entity/LebaPluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;J)V
    //   313: iconst_1
    //   314: istore_1
    //   315: iload 15
    //   317: istore 9
    //   319: goto -235 -> 84
    //   322: iload_1
    //   323: istore 14
    //   325: iload 9
    //   327: istore 11
    //   329: aload 17
    //   331: invokevirtual 442	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   334: aload 17
    //   336: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   339: aload 16
    //   341: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   344: iconst_1
    //   345: istore 10
    //   347: goto +56 -> 403
    //   350: astore 4
    //   352: goto +15 -> 367
    //   355: astore_3
    //   356: goto +276 -> 632
    //   359: astore 4
    //   361: iconst_0
    //   362: istore 14
    //   364: iconst_0
    //   365: istore 11
    //   367: ldc 215
    //   369: iconst_1
    //   370: ldc_w 447
    //   373: aload 4
    //   375: invokestatic 450	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   378: aload 4
    //   380: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   383: aload 17
    //   385: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   388: aload 16
    //   390: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   393: iconst_0
    //   394: istore 10
    //   396: iload 11
    //   398: istore 9
    //   400: iload 14
    //   402: istore_1
    //   403: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +53 -> 459
    //   409: aload 18
    //   411: ldc_w 452
    //   414: iconst_3
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: iload 10
    //   422: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   425: aastore
    //   426: dup
    //   427: iconst_1
    //   428: iload 9
    //   430: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   433: aastore
    //   434: dup
    //   435: iconst_2
    //   436: iload_1
    //   437: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   440: aastore
    //   441: invokestatic 396	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   444: invokevirtual 428	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   447: pop
    //   448: ldc 215
    //   450: iconst_2
    //   451: aload 18
    //   453: invokevirtual 458	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   456: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: iload 10
    //   461: ifeq +13 -> 474
    //   464: aload_0
    //   465: iload_2
    //   466: aload_3
    //   467: iload 5
    //   469: iload 6
    //   471: invokevirtual 460	com/tencent/mobileqq/leba/core/LebaHelper:a	(ILjava/util/List;II)V
    //   474: aload_0
    //   475: invokevirtual 462	com/tencent/mobileqq/leba/core/LebaHelper:i	()V
    //   478: aload_0
    //   479: invokevirtual 413	com/tencent/mobileqq/leba/core/LebaHelper:j	()V
    //   482: iload 9
    //   484: ifeq +24 -> 508
    //   487: aload_0
    //   488: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   491: ldc_w 464
    //   494: ldc 96
    //   496: invokevirtual 468	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   499: checkcast 464	com/tencent/mobileqq/tianshu/api/IRedTouchServer
    //   502: iconst_1
    //   503: invokeinterface 471 2 0
    //   508: iload_1
    //   509: ifeq +65 -> 574
    //   512: new 44	java/util/ArrayList
    //   515: dup
    //   516: aload_0
    //   517: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   520: invokespecial 474	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   523: invokeinterface 319 1 0
    //   528: astore_3
    //   529: aload_3
    //   530: invokeinterface 324 1 0
    //   535: ifeq +178 -> 713
    //   538: aload_3
    //   539: invokeinterface 328 1 0
    //   544: checkcast 476	com/tencent/mobileqq/leba/observer/ResourcePluginListener
    //   547: astore 4
    //   549: iload 9
    //   551: ifeq +13 -> 564
    //   554: aload 4
    //   556: iconst_3
    //   557: iconst_1
    //   558: invokestatic 479	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
    //   561: goto -32 -> 529
    //   564: aload 4
    //   566: iconst_2
    //   567: iconst_1
    //   568: invokestatic 479	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
    //   571: goto -42 -> 529
    //   574: aload_0
    //   575: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   578: astore_3
    //   579: aload_3
    //   580: monitorenter
    //   581: iload 7
    //   583: istore_2
    //   584: iload_2
    //   585: aload_0
    //   586: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   589: invokeinterface 238 1 0
    //   594: if_icmpge +28 -> 622
    //   597: aload_0
    //   598: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   601: iload_2
    //   602: invokeinterface 241 2 0
    //   607: checkcast 476	com/tencent/mobileqq/leba/observer/ResourcePluginListener
    //   610: iconst_1
    //   611: iconst_1
    //   612: invokestatic 479	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
    //   615: iload_2
    //   616: iconst_1
    //   617: iadd
    //   618: istore_2
    //   619: goto -35 -> 584
    //   622: aload_3
    //   623: monitorexit
    //   624: return
    //   625: astore 4
    //   627: aload_3
    //   628: monitorexit
    //   629: aload 4
    //   631: athrow
    //   632: aload 17
    //   634: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   637: aload 16
    //   639: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   642: aload_3
    //   643: athrow
    //   644: aload_0
    //   645: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   648: astore_3
    //   649: aload_3
    //   650: monitorenter
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 32	com/tencent/mobileqq/leba/core/LebaHelper:f	Z
    //   656: iload 8
    //   658: istore_2
    //   659: iload_2
    //   660: aload_0
    //   661: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   664: invokeinterface 238 1 0
    //   669: if_icmpge +28 -> 697
    //   672: aload_0
    //   673: getfield 51	com/tencent/mobileqq/leba/core/LebaHelper:e	Ljava/util/List;
    //   676: iload_2
    //   677: invokeinterface 241 2 0
    //   682: checkcast 476	com/tencent/mobileqq/leba/observer/ResourcePluginListener
    //   685: iconst_m1
    //   686: iconst_1
    //   687: invokestatic 479	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
    //   690: iload_2
    //   691: iconst_1
    //   692: iadd
    //   693: istore_2
    //   694: goto -35 -> 659
    //   697: aload_3
    //   698: monitorexit
    //   699: return
    //   700: astore 4
    //   702: aload_3
    //   703: monitorexit
    //   704: goto +6 -> 710
    //   707: aload 4
    //   709: athrow
    //   710: goto -3 -> 707
    //   713: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	LebaHelper
    //   0	714	1	paramBoolean	boolean
    //   0	714	2	paramInt1	int
    //   0	714	3	paramList	List<GroupInfo>
    //   0	714	4	paramList1	List<LebaPluginInfo>
    //   0	714	5	paramInt2	int
    //   0	714	6	paramInt3	int
    //   17	565	7	m	int
    //   14	643	8	n	int
    //   82	468	9	bool1	boolean
    //   186	274	10	bool2	boolean
    //   89	308	11	bool3	boolean
    //   182	68	12	bool4	boolean
    //   159	137	13	bool5	boolean
    //   85	316	14	bool6	boolean
    //   163	153	15	bool7	boolean
    //   38	600	16	localEntityManager	EntityManager
    //   45	588	17	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   54	398	18	localStringBuffer	java.lang.StringBuffer
    //   118	188	19	localLebaPluginInfo	LebaPluginInfo
    // Exception table:
    //   from	to	target	type
    //   91	101	350	java/lang/Exception
    //   108	120	350	java/lang/Exception
    //   135	143	350	java/lang/Exception
    //   150	158	350	java/lang/Exception
    //   172	181	350	java/lang/Exception
    //   195	204	350	java/lang/Exception
    //   211	218	350	java/lang/Exception
    //   240	249	350	java/lang/Exception
    //   257	264	350	java/lang/Exception
    //   286	295	350	java/lang/Exception
    //   303	313	350	java/lang/Exception
    //   329	334	350	java/lang/Exception
    //   56	79	355	finally
    //   91	101	355	finally
    //   108	120	355	finally
    //   135	143	355	finally
    //   150	158	355	finally
    //   172	181	355	finally
    //   195	204	355	finally
    //   211	218	355	finally
    //   240	249	355	finally
    //   257	264	355	finally
    //   286	295	355	finally
    //   303	313	355	finally
    //   329	334	355	finally
    //   367	383	355	finally
    //   56	79	359	java/lang/Exception
    //   584	615	625	finally
    //   622	624	625	finally
    //   627	629	625	finally
    //   651	656	700	finally
    //   659	690	700	finally
    //   697	699	700	finally
    //   702	704	700	finally
  }
  
  /* Error */
  public void a(boolean paramBoolean, com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp paramGetResourceResp)
  {
    // Byte code:
    //   0: invokestatic 487	java/util/Collections:emptyList	()Ljava/util/List;
    //   3: astore 15
    //   5: invokestatic 487	java/util/Collections:emptyList	()Ljava/util/List;
    //   8: astore 14
    //   10: iconst_m1
    //   11: istore_3
    //   12: iload_1
    //   13: ifeq +606 -> 619
    //   16: aload_2
    //   17: ifnull +539 -> 556
    //   20: aload_2
    //   21: getfield 490	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:plugin_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   24: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   27: istore 5
    //   29: aload_2
    //   30: getfield 494	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:plugin_layout	Lcom/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout;
    //   33: invokevirtual 497	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:has	()Z
    //   36: istore 11
    //   38: aconst_null
    //   39: astore 17
    //   41: iload 11
    //   43: ifeq +692 -> 735
    //   46: aload_2
    //   47: getfield 494	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:plugin_layout	Lcom/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout;
    //   50: invokevirtual 500	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: checkcast 496	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout
    //   56: astore 16
    //   58: goto +3 -> 61
    //   61: aload 16
    //   63: ifnull +352 -> 415
    //   66: aload 16
    //   68: getfield 503	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:layout_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   74: ifeq +16 -> 90
    //   77: aload 16
    //   79: getfield 503	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:layout_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 6
    //   87: goto +6 -> 93
    //   90: iconst_m1
    //   91: istore 6
    //   93: iload_3
    //   94: istore 4
    //   96: iload_3
    //   97: istore 7
    //   99: aload 16
    //   101: getfield 504	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:plugin_layout_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   104: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   107: ifeq +16 -> 123
    //   110: iload_3
    //   111: istore 7
    //   113: aload 16
    //   115: getfield 504	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:plugin_layout_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: istore 4
    //   123: iload 4
    //   125: istore 7
    //   127: aload 16
    //   129: getfield 507	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:group_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   132: invokevirtual 508	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   135: ifeq +17 -> 152
    //   138: iload 4
    //   140: istore 7
    //   142: aload 16
    //   144: getfield 507	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:group_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   147: invokevirtual 510	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   150: astore 17
    //   152: aload 17
    //   154: ifnull +244 -> 398
    //   157: iload 4
    //   159: istore 7
    //   161: new 44	java/util/ArrayList
    //   164: dup
    //   165: invokespecial 45	java/util/ArrayList:<init>	()V
    //   168: astore 16
    //   170: iconst_0
    //   171: istore 9
    //   173: iconst_0
    //   174: istore 7
    //   176: iload 5
    //   178: istore_3
    //   179: iload_3
    //   180: istore 8
    //   182: iload 9
    //   184: aload 17
    //   186: invokeinterface 238 1 0
    //   191: if_icmpge +183 -> 374
    //   194: iload_3
    //   195: istore 8
    //   197: aload 17
    //   199: iload 9
    //   201: invokeinterface 241 2 0
    //   206: checkcast 512	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup
    //   209: astore 14
    //   211: iload_3
    //   212: istore 8
    //   214: aload 14
    //   216: invokevirtual 513	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup:has	()Z
    //   219: ifeq +146 -> 365
    //   222: iload_3
    //   223: istore 8
    //   225: aload 14
    //   227: getfield 516	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup:res_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   230: invokevirtual 519	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   233: ifeq +132 -> 365
    //   236: iload_3
    //   237: istore 8
    //   239: aload 14
    //   241: getfield 516	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup:res_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   244: invokevirtual 520	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   247: astore 14
    //   249: iload 7
    //   251: istore 5
    //   253: iconst_0
    //   254: istore 7
    //   256: iload_3
    //   257: istore 8
    //   259: iload 7
    //   261: aload 14
    //   263: invokeinterface 238 1 0
    //   268: if_icmpge +90 -> 358
    //   271: iload_3
    //   272: istore 8
    //   274: new 292	com/tencent/mobileqq/leba/entity/GroupInfo
    //   277: dup
    //   278: invokespecial 521	com/tencent/mobileqq/leba/entity/GroupInfo:<init>	()V
    //   281: astore 18
    //   283: iload_3
    //   284: istore 8
    //   286: aload 14
    //   288: iload 7
    //   290: invokeinterface 241 2 0
    //   295: checkcast 387	java/lang/Integer
    //   298: invokevirtual 524	java/lang/Integer:intValue	()I
    //   301: istore 10
    //   303: iload 10
    //   305: i2l
    //   306: lstore 12
    //   308: aload 18
    //   310: lload 12
    //   312: putfield 526	com/tencent/mobileqq/leba/entity/GroupInfo:a	J
    //   315: aload 18
    //   317: iload 9
    //   319: putfield 528	com/tencent/mobileqq/leba/entity/GroupInfo:b	I
    //   322: iload 5
    //   324: iconst_1
    //   325: iadd
    //   326: istore 5
    //   328: aload 18
    //   330: iload 5
    //   332: putfield 530	com/tencent/mobileqq/leba/entity/GroupInfo:c	I
    //   335: aload 16
    //   337: aload 18
    //   339: invokeinterface 340 2 0
    //   344: pop
    //   345: iload 7
    //   347: iconst_1
    //   348: iadd
    //   349: istore 7
    //   351: goto -95 -> 256
    //   354: astore_2
    //   355: goto +36 -> 391
    //   358: iload 5
    //   360: istore 7
    //   362: goto +3 -> 365
    //   365: iload 9
    //   367: iconst_1
    //   368: iadd
    //   369: istore 9
    //   371: goto -192 -> 179
    //   374: iload_3
    //   375: istore 5
    //   377: aload 16
    //   379: astore 14
    //   381: iload 4
    //   383: istore_3
    //   384: goto +34 -> 418
    //   387: astore_2
    //   388: iload 8
    //   390: istore_3
    //   391: aload 16
    //   393: astore 14
    //   395: goto +192 -> 587
    //   398: iload 4
    //   400: istore_3
    //   401: goto +17 -> 418
    //   404: astore_2
    //   405: iload 5
    //   407: istore_3
    //   408: iload 7
    //   410: istore 4
    //   412: goto +175 -> 587
    //   415: iconst_m1
    //   416: istore 6
    //   418: aload_2
    //   419: getfield 533	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:respinfo_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   422: invokevirtual 510	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   425: astore 16
    //   427: new 44	java/util/ArrayList
    //   430: dup
    //   431: invokespecial 45	java/util/ArrayList:<init>	()V
    //   434: astore_2
    //   435: aload 16
    //   437: ifnull +74 -> 511
    //   440: aload 16
    //   442: invokeinterface 319 1 0
    //   447: astore 15
    //   449: aload 15
    //   451: invokeinterface 324 1 0
    //   456: ifeq +55 -> 511
    //   459: aload 15
    //   461: invokeinterface 328 1 0
    //   466: checkcast 58	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceRespInfo
    //   469: invokestatic 535	com/tencent/mobileqq/leba/core/LebaHelper:a	(Lcom/tencent/mobileqq/leba/pb/PluginConfig$GetResourceRespInfo;)Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;
    //   472: astore 16
    //   474: aload 16
    //   476: ifnonnull +6 -> 482
    //   479: goto -30 -> 449
    //   482: aload_2
    //   483: aload 16
    //   485: invokeinterface 340 2 0
    //   490: pop
    //   491: goto -42 -> 449
    //   494: astore 16
    //   496: aload_2
    //   497: astore 15
    //   499: aload 16
    //   501: astore_2
    //   502: iload_3
    //   503: istore 4
    //   505: iload 5
    //   507: istore_3
    //   508: goto +79 -> 587
    //   511: aload_2
    //   512: astore 15
    //   514: goto +59 -> 573
    //   517: astore_2
    //   518: iload_3
    //   519: istore 4
    //   521: iload 5
    //   523: istore_3
    //   524: goto +63 -> 587
    //   527: astore_2
    //   528: iconst_m1
    //   529: istore 6
    //   531: iload_3
    //   532: istore 4
    //   534: iload 5
    //   536: istore_3
    //   537: goto +50 -> 587
    //   540: astore_2
    //   541: iconst_m1
    //   542: istore 6
    //   544: iconst_m1
    //   545: istore 5
    //   547: iload_3
    //   548: istore 4
    //   550: iload 5
    //   552: istore_3
    //   553: goto +34 -> 587
    //   556: ldc 215
    //   558: iconst_1
    //   559: ldc_w 537
    //   562: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: iconst_0
    //   566: istore_1
    //   567: iconst_m1
    //   568: istore 6
    //   570: iconst_m1
    //   571: istore 5
    //   573: aload 14
    //   575: astore_2
    //   576: iload 6
    //   578: istore 4
    //   580: aload 15
    //   582: astore 14
    //   584: goto +50 -> 634
    //   587: ldc 215
    //   589: iconst_1
    //   590: ldc_w 539
    //   593: aload_2
    //   594: invokestatic 450	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   597: aload 14
    //   599: astore_2
    //   600: iload_3
    //   601: istore 5
    //   603: iconst_0
    //   604: istore_1
    //   605: iload 4
    //   607: istore_3
    //   608: aload 15
    //   610: astore 14
    //   612: iload 6
    //   614: istore 4
    //   616: goto +18 -> 634
    //   619: aload 14
    //   621: astore_2
    //   622: iconst_m1
    //   623: istore_3
    //   624: iconst_m1
    //   625: istore 4
    //   627: iconst_m1
    //   628: istore 5
    //   630: aload 15
    //   632: astore 14
    //   634: iconst_0
    //   635: istore 7
    //   637: aload 14
    //   639: ifnull +15 -> 654
    //   642: aload 14
    //   644: invokeinterface 238 1 0
    //   649: istore 6
    //   651: goto +6 -> 657
    //   654: iconst_0
    //   655: istore 6
    //   657: aload_2
    //   658: ifnull +11 -> 669
    //   661: aload_2
    //   662: invokeinterface 238 1 0
    //   667: istore 7
    //   669: ldc 215
    //   671: iconst_1
    //   672: bipush 6
    //   674: anewarray 4	java/lang/Object
    //   677: dup
    //   678: iconst_0
    //   679: ldc_w 541
    //   682: aastore
    //   683: dup
    //   684: iconst_1
    //   685: iload_1
    //   686: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   689: aastore
    //   690: dup
    //   691: iconst_2
    //   692: ldc_w 543
    //   695: aastore
    //   696: dup
    //   697: iconst_3
    //   698: iload 6
    //   700: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: aastore
    //   704: dup
    //   705: iconst_4
    //   706: ldc_w 545
    //   709: aastore
    //   710: dup
    //   711: iconst_5
    //   712: iload 7
    //   714: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: aastore
    //   718: invokestatic 548	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   721: aload_0
    //   722: iload_1
    //   723: iload_3
    //   724: aload_2
    //   725: aload 14
    //   727: iload 4
    //   729: iload 5
    //   731: invokevirtual 550	com/tencent/mobileqq/leba/core/LebaHelper:a	(ZILjava/util/List;Ljava/util/List;II)V
    //   734: return
    //   735: aconst_null
    //   736: astore 16
    //   738: goto -677 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	741	0	this	LebaHelper
    //   0	741	1	paramBoolean	boolean
    //   0	741	2	paramGetResourceResp	com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp
    //   11	713	3	m	int
    //   94	634	4	n	int
    //   27	703	5	i1	int
    //   85	614	6	i2	int
    //   97	616	7	i3	int
    //   180	209	8	i4	int
    //   171	199	9	i5	int
    //   301	3	10	i6	int
    //   36	6	11	bool	boolean
    //   306	5	12	l	long
    //   8	718	14	localObject1	Object
    //   3	628	15	localObject2	Object
    //   56	428	16	localObject3	Object
    //   494	6	16	localException	Exception
    //   736	1	16	localObject4	Object
    //   39	159	17	localList	List
    //   281	57	18	localGroupInfo	GroupInfo
    // Exception table:
    //   from	to	target	type
    //   308	322	354	java/lang/Exception
    //   328	345	354	java/lang/Exception
    //   182	194	387	java/lang/Exception
    //   197	211	387	java/lang/Exception
    //   214	222	387	java/lang/Exception
    //   225	236	387	java/lang/Exception
    //   239	249	387	java/lang/Exception
    //   259	271	387	java/lang/Exception
    //   274	283	387	java/lang/Exception
    //   286	303	387	java/lang/Exception
    //   99	110	404	java/lang/Exception
    //   113	123	404	java/lang/Exception
    //   127	138	404	java/lang/Exception
    //   142	152	404	java/lang/Exception
    //   161	170	404	java/lang/Exception
    //   440	449	494	java/lang/Exception
    //   449	474	494	java/lang/Exception
    //   482	491	494	java/lang/Exception
    //   418	435	517	java/lang/Exception
    //   29	38	527	java/lang/Exception
    //   46	58	527	java/lang/Exception
    //   66	87	527	java/lang/Exception
    //   20	29	540	java/lang/Exception
    //   556	565	540	java/lang/Exception
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    return LebaPluginLogic.b() != LebaUtil.e(paramAppRuntime);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Leba.Helper", 2, "LebaHelper  init");
    }
    a(new LebaHelper.1(this));
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.e)
    {
      this.e.remove(paramResourcePluginListener);
      return;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt1, List<GroupInfo> paramList, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(" onGetPluginConfig, isSucc= ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",layoutSeq=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",layoutType=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",pluginType=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",groupList=");
    if (paramList != null)
    {
      localStringBuilder.append(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)paramList.next();
        if (localGroupInfo != null) {
          localStringBuilder.append(localGroupInfo.toString());
        }
      }
    }
    localStringBuilder.append(",resultInfos=");
    if (paramList1 != null)
    {
      localStringBuilder.append(paramList1.size());
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (LebaPluginInfo)paramList.next();
        if (paramList1 != null) {
          localStringBuilder.append(paramList1.toString());
        }
      }
    }
    QLog.i("Leba.Helper", 1, localStringBuilder.toString());
  }
  
  /* Error */
  public PluginConfig.GetResourceReq c()
  {
    // Byte code:
    //   0: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 215
    //   8: iconst_2
    //   9: ldc_w 586
    //   12: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   19: invokestatic 588	com/tencent/mobileqq/leba/core/LebaUtil:c	(Lmqq/app/AppRuntime;)Z
    //   22: ifeq +27 -> 49
    //   25: ldc 215
    //   27: iconst_1
    //   28: ldc_w 590
    //   31: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   38: iconst_0
    //   39: invokestatic 399	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;I)V
    //   42: aload_0
    //   43: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   46: invokestatic 592	com/tencent/mobileqq/leba/core/LebaUtil:d	(Lmqq/app/AppRuntime;)V
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   54: invokevirtual 594	com/tencent/mobileqq/leba/core/LebaHelper:a	(Lmqq/app/AppRuntime;)Z
    //   57: istore 4
    //   59: aload_0
    //   60: getfield 379	com/tencent/mobileqq/leba/core/LebaHelper:j	Lcom/tencent/mobileqq/leba/business/ILebaBasisApi;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +18 -> 85
    //   70: aload 5
    //   72: invokeinterface 597 1 0
    //   77: ifeq +8 -> 85
    //   80: iconst_1
    //   81: istore_1
    //   82: goto +5 -> 87
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: ifne +8 -> 96
    //   91: iload 4
    //   93: ifeq +79 -> 172
    //   96: ldc 215
    //   98: iconst_1
    //   99: ldc_w 599
    //   102: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_0
    //   106: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   109: iconst_0
    //   110: invokestatic 399	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;I)V
    //   113: aload_0
    //   114: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   117: invokevirtual 223	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   120: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   123: astore 5
    //   125: aload 5
    //   127: ldc 55
    //   129: invokevirtual 603	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   132: pop
    //   133: aload 5
    //   135: ifnull +37 -> 172
    //   138: aload 5
    //   140: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   143: goto +29 -> 172
    //   146: astore 6
    //   148: goto +301 -> 449
    //   151: astore 6
    //   153: ldc 215
    //   155: iconst_1
    //   156: ldc_w 605
    //   159: aload 6
    //   161: invokestatic 607	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload 5
    //   166: ifnull +6 -> 172
    //   169: goto -31 -> 138
    //   172: aload_0
    //   173: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   176: invokestatic 383	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;)I
    //   179: istore_3
    //   180: aload_0
    //   181: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:a	Lmqq/app/AppRuntime;
    //   184: invokevirtual 223	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   187: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   190: invokestatic 233	com/tencent/mobileqq/leba/entity/LebaPluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;)Ljava/util/List;
    //   193: astore 5
    //   195: new 44	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 45	java/util/ArrayList:<init>	()V
    //   202: astore 6
    //   204: aload 5
    //   206: ifnull +139 -> 345
    //   209: iconst_0
    //   210: istore_1
    //   211: iload_1
    //   212: aload 5
    //   214: invokeinterface 238 1 0
    //   219: if_icmpge +126 -> 345
    //   222: aload 5
    //   224: iload_1
    //   225: invokeinterface 241 2 0
    //   230: checkcast 55	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   233: astore 7
    //   235: aload 7
    //   237: ifnull +101 -> 338
    //   240: aload 7
    //   242: getfield 144	com/tencent/mobileqq/leba/entity/LebaPluginInfo:cDataType	B
    //   245: ifne +93 -> 338
    //   248: new 55	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   251: dup
    //   252: invokespecial 56	com/tencent/mobileqq/leba/entity/LebaPluginInfo:<init>	()V
    //   255: astore 8
    //   257: iload_3
    //   258: ifgt +8 -> 266
    //   261: iconst_0
    //   262: istore_2
    //   263: goto +9 -> 272
    //   266: aload 7
    //   268: getfield 87	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSeq	I
    //   271: istore_2
    //   272: aload 8
    //   274: iload_2
    //   275: putfield 87	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSeq	I
    //   278: aload 8
    //   280: aload 7
    //   282: getfield 76	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   285: putfield 76	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   288: aload 6
    //   290: aload 8
    //   292: invokevirtual 608	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   295: pop
    //   296: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +39 -> 338
    //   302: new 163	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   309: astore 8
    //   311: aload 8
    //   313: ldc 96
    //   315: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 8
    //   321: aload 7
    //   323: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: ldc 215
    //   329: iconst_2
    //   330: aload 8
    //   332: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: iload_1
    //   339: iconst_1
    //   340: iadd
    //   341: istore_1
    //   342: goto -131 -> 211
    //   345: iload_3
    //   346: istore_1
    //   347: aload 6
    //   349: invokevirtual 611	java/util/ArrayList:isEmpty	()Z
    //   352: ifeq +5 -> 357
    //   355: iconst_0
    //   356: istore_1
    //   357: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +81 -> 441
    //   363: new 163	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   370: astore 7
    //   372: aload 7
    //   374: ldc_w 613
    //   377: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 7
    //   383: iload_1
    //   384: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 7
    //   390: ldc_w 615
    //   393: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 7
    //   399: aload 6
    //   401: invokevirtual 616	java/util/ArrayList:size	()I
    //   404: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 7
    //   410: ldc_w 618
    //   413: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 7
    //   419: aload 5
    //   421: invokeinterface 238 1 0
    //   426: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: ldc 215
    //   432: iconst_2
    //   433: aload 7
    //   435: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload_0
    //   442: iload_1
    //   443: aload 6
    //   445: invokevirtual 620	com/tencent/mobileqq/leba/core/LebaHelper:a	(ILjava/util/List;)Lcom/tencent/mobileqq/leba/pb/PluginConfig$GetResourceReq;
    //   448: areturn
    //   449: aload 5
    //   451: ifnull +8 -> 459
    //   454: aload 5
    //   456: invokevirtual 250	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   459: goto +6 -> 465
    //   462: aload 6
    //   464: athrow
    //   465: goto -3 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	LebaHelper
    //   81	362	1	m	int
    //   262	13	2	n	int
    //   179	167	3	i1	int
    //   57	35	4	bool	boolean
    //   63	392	5	localObject1	Object
    //   146	1	6	localObject2	Object
    //   151	9	6	localThrowable	java.lang.Throwable
    //   202	261	6	localArrayList	ArrayList
    //   233	201	7	localObject3	Object
    //   255	76	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   125	133	146	finally
    //   153	164	146	finally
    //   125	133	151	java/lang/Throwable
  }
  
  public void d()
  {
    if (this.f)
    {
      m = this.g;
      if (m < 3)
      {
        this.f = false;
        this.g = (m + 1);
        m = 1;
        break label36;
      }
    }
    int m = 0;
    label36:
    int n = m;
    if (this.h)
    {
      int i1 = this.i;
      n = m;
      if (i1 < 3)
      {
        this.h = false;
        this.i = (i1 + 1);
        n = 1;
      }
    }
    if (n != 0)
    {
      QLog.i("Leba.Helper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.2(this), 160, null, true);
    }
  }
  
  public void e()
  {
    if (a(this.a))
    {
      QLog.i("Leba.Helper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.3(this), 160, null, true);
    }
  }
  
  public List<LebaPluginInfo> f()
  {
    return this.c;
  }
  
  public void g()
  {
    synchronized (this.b)
    {
      this.c.clear();
      return;
    }
  }
  
  protected void h()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = HardCodeUtil.a(2131891170);
    localLebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localLebaPluginInfo.sResSubType = 2;
    localLebaPluginInfo.cCanChangeState = 0;
    localLebaPluginInfo.cDataType = 1;
    localLebaPluginInfo.uiResId = 0L;
    localLebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.a.getAccount(), "tab_qzone" });
    localLebaPluginInfo.showInSimpleMode = 1;
    this.d.add(localLebaPluginInfo);
  }
  
  public void i()
  {
    ??? = this.a;
    if ((??? != null) && (((AppRuntime)???).isLogin()))
    {
      try
      {
        synchronized (this.d)
        {
          this.d.clear();
        }
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Leba.Helper", 2, localException2, new Object[0]);
        }
        try
        {
          h();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        l();
        synchronized (this.b)
        {
          this.c.clear();
          this.c.addAll(this.d);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("loadAllPlugins，size=");
            ((StringBuilder)???).append(this.c.size());
            QLog.d("Leba.Helper", 2, ((StringBuilder)???).toString());
          }
          this.k = true;
          return;
        }
      }
      throw localObject4;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Leba.Helper", 2, "error happens: loadAllPlugins while app is null || app is not login");
    }
  }
  
  public void j()
  {
    Iterator localIterator = new ArrayList(this.e).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaHelper
 * JD-Core Version:    0.7.0.1
 */