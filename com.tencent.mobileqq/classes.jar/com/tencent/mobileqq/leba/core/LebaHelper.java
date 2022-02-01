package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.leba.entity.GroupInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReqInfo;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceRespInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaHelper
{
  int jdField_a_of_type_Int = 0;
  public ILebaBasisApi a;
  public IStudyModeManager a;
  List<LebaPluginInfo> jdField_a_of_type_JavaUtilList;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  int jdField_b_of_type_Int = 0;
  List<LebaPluginInfo> jdField_b_of_type_JavaUtilList;
  public boolean b;
  public List<ResourcePluginListener> c;
  boolean c;
  
  public LebaHelper(AppRuntime paramAppRuntime)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
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
    int j = 0;
    if (bool) {
      i = paramGetResourceRespInfo.state.get();
    } else {
      i = 0;
    }
    localLebaPluginInfo.state = i;
    if (paramGetResourceRespInfo.res_seq.has()) {
      i = paramGetResourceRespInfo.res_seq.get();
    } else {
      i = 0;
    }
    localLebaPluginInfo.sResSeq = i;
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
      i = paramGetResourceRespInfo.can_change_state.get();
    } else {
      i = 1;
    }
    localLebaPluginInfo.cCanChangeState = i;
    if (paramGetResourceRespInfo.res_conf.has()) {
      localObject = paramGetResourceRespInfo.res_conf.get();
    } else {
      localObject = "";
    }
    localLebaPluginInfo.resConf = ((String)localObject);
    localLebaPluginInfo.cDataType = 0;
    int i = j;
    if (paramGetResourceRespInfo.simple_mode.has()) {
      i = paramGetResourceRespInfo.simple_mode.get();
    }
    localLebaPluginInfo.showInSimpleMode = i;
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
  
  private void b(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +233 -> 239
    //   9: aload_2
    //   10: invokevirtual 190	mqq/app/AppRuntime:isLogin	()Z
    //   13: ifne +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   21: invokevirtual 194	mqq/app/AppRuntime:getPreferences	()Landroid/content/SharedPreferences;
    //   24: astore_2
    //   25: new 156	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: ldc 196
    //   36: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   45: invokevirtual 199	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   48: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: iconst_1
    //   58: invokeinterface 205 3 0
    //   63: ifeq +176 -> 239
    //   66: invokestatic 208	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 210
    //   74: iconst_4
    //   75: ldc 212
    //   77: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   84: invokevirtual 219	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   87: invokevirtual 225	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 229	com/tencent/mobileqq/leba/entity/LebaPluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;)Ljava/util/List;
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +59 -> 158
    //   102: iconst_0
    //   103: istore_1
    //   104: iload_1
    //   105: aload 4
    //   107: invokeinterface 234 1 0
    //   112: if_icmpge +46 -> 158
    //   115: aload 4
    //   117: iload_1
    //   118: invokeinterface 237 2 0
    //   123: checkcast 48	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: getfield 137	com/tencent/mobileqq/leba/entity/LebaPluginInfo:cDataType	B
    //   138: iconst_1
    //   139: if_icmpne +12 -> 151
    //   142: aload_3
    //   143: aload 5
    //   145: getfield 69	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   148: invokestatic 241	com/tencent/mobileqq/leba/entity/LebaPluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;J)V
    //   151: iload_1
    //   152: iconst_1
    //   153: iadd
    //   154: istore_1
    //   155: goto -51 -> 104
    //   158: aload_3
    //   159: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   162: goto +17 -> 179
    //   165: astore_2
    //   166: goto +67 -> 233
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 249	java/lang/Exception:printStackTrace	()V
    //   176: goto -18 -> 158
    //   179: aload_2
    //   180: invokeinterface 253 1 0
    //   185: astore_2
    //   186: new 156	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   193: astore_3
    //   194: aload_3
    //   195: ldc 196
    //   197: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_3
    //   202: aload_0
    //   203: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   206: invokevirtual 199	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   209: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: iconst_0
    //   219: invokeinterface 259 3 0
    //   224: pop
    //   225: aload_2
    //   226: invokeinterface 262 1 0
    //   231: pop
    //   232: return
    //   233: aload_3
    //   234: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   237: aload_2
    //   238: athrow
    //   239: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	LebaHelper
    //   103	52	1	i	int
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
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Map localMap = LebaUtil.a(LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    List localList1 = LebaPluginInfo.getAll((EntityManager)localObject2);
    ((EntityManager)localObject2).close();
    localObject2 = new StringBuilder();
    if ((localList1 != null) && (localList1.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = localList1.size() - 1;
        if (i >= 0)
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList1.get(i);
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
        this.jdField_b_of_type_JavaUtilList.addAll(localList1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadServerPlugins data =  ");
      localStringBuilder.append(localObject2);
      QLog.i("LebaHelper", 1, localStringBuilder.toString());
      return;
      label265:
      i -= 1;
    }
  }
  
  /* Error */
  public PluginConfig.GetResourceReq a()
  {
    // Byte code:
    //   0: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 210
    //   8: iconst_2
    //   9: ldc_w 315
    //   12: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   19: invokestatic 318	com/tencent/mobileqq/leba/core/LebaUtil:b	(Lmqq/app/AppRuntime;)Z
    //   22: ifeq +27 -> 49
    //   25: ldc 210
    //   27: iconst_1
    //   28: ldc_w 320
    //   31: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   38: iconst_0
    //   39: invokestatic 323	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;I)V
    //   42: aload_0
    //   43: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   46: invokestatic 325	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;)V
    //   49: aload_0
    //   50: getfield 327	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi	Lcom/tencent/mobileqq/leba/business/ILebaBasisApi;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +18 -> 75
    //   60: aload 4
    //   62: invokeinterface 332 1 0
    //   67: ifeq +8 -> 75
    //   70: iconst_1
    //   71: istore_1
    //   72: goto +5 -> 77
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: ifeq +92 -> 170
    //   81: ldc 210
    //   83: iconst_1
    //   84: ldc_w 334
    //   87: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   94: iconst_0
    //   95: invokestatic 323	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;I)V
    //   98: aload_0
    //   99: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   102: invokevirtual 219	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   105: invokevirtual 225	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: astore 4
    //   110: aload 4
    //   112: ldc 48
    //   114: invokevirtual 338	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   117: pop
    //   118: aload 4
    //   120: ifnull +50 -> 170
    //   123: aload 4
    //   125: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   128: goto +42 -> 170
    //   131: astore 5
    //   133: goto +24 -> 157
    //   136: astore 5
    //   138: ldc 210
    //   140: iconst_1
    //   141: ldc_w 340
    //   144: aload 5
    //   146: invokestatic 344	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload 4
    //   151: ifnull +19 -> 170
    //   154: goto -31 -> 123
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   167: aload 5
    //   169: athrow
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   175: invokevirtual 346	com/tencent/mobileqq/leba/core/LebaHelper:a	(Lmqq/app/AppRuntime;)Z
    //   178: ifeq +20 -> 198
    //   181: ldc 210
    //   183: iconst_1
    //   184: ldc_w 348
    //   187: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_0
    //   191: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   194: iconst_0
    //   195: invokestatic 323	com/tencent/mobileqq/leba/core/LebaUtil:a	(Lmqq/app/AppRuntime;I)V
    //   198: aload_0
    //   199: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   202: invokestatic 351	com/tencent/mobileqq/leba/core/LebaUtil:b	(Lmqq/app/AppRuntime;)I
    //   205: istore_3
    //   206: aload_0
    //   207: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   210: invokevirtual 219	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   213: invokevirtual 225	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   216: invokestatic 229	com/tencent/mobileqq/leba/entity/LebaPluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;)Ljava/util/List;
    //   219: astore 4
    //   221: new 37	java/util/ArrayList
    //   224: dup
    //   225: invokespecial 38	java/util/ArrayList:<init>	()V
    //   228: astore 5
    //   230: aload 4
    //   232: ifnull +139 -> 371
    //   235: iconst_0
    //   236: istore_1
    //   237: iload_1
    //   238: aload 4
    //   240: invokeinterface 234 1 0
    //   245: if_icmpge +126 -> 371
    //   248: aload 4
    //   250: iload_1
    //   251: invokeinterface 237 2 0
    //   256: checkcast 48	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   259: astore 6
    //   261: aload 6
    //   263: ifnull +101 -> 364
    //   266: aload 6
    //   268: getfield 137	com/tencent/mobileqq/leba/entity/LebaPluginInfo:cDataType	B
    //   271: ifne +93 -> 364
    //   274: new 48	com/tencent/mobileqq/leba/entity/LebaPluginInfo
    //   277: dup
    //   278: invokespecial 49	com/tencent/mobileqq/leba/entity/LebaPluginInfo:<init>	()V
    //   281: astore 7
    //   283: iload_3
    //   284: ifgt +8 -> 292
    //   287: iconst_0
    //   288: istore_2
    //   289: goto +9 -> 298
    //   292: aload 6
    //   294: getfield 80	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSeq	I
    //   297: istore_2
    //   298: aload 7
    //   300: iload_2
    //   301: putfield 80	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSeq	I
    //   304: aload 7
    //   306: aload 6
    //   308: getfield 69	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   311: putfield 69	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   314: aload 5
    //   316: aload 7
    //   318: invokevirtual 354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   321: pop
    //   322: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +39 -> 364
    //   328: new 156	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   335: astore 7
    //   337: aload 7
    //   339: ldc 89
    //   341: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 7
    //   347: aload 6
    //   349: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc 210
    //   355: iconst_2
    //   356: aload 7
    //   358: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: iload_1
    //   365: iconst_1
    //   366: iadd
    //   367: istore_1
    //   368: goto -131 -> 237
    //   371: iload_3
    //   372: istore_1
    //   373: aload 5
    //   375: invokevirtual 357	java/util/ArrayList:isEmpty	()Z
    //   378: ifeq +5 -> 383
    //   381: iconst_0
    //   382: istore_1
    //   383: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +81 -> 467
    //   389: new 156	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   396: astore 6
    //   398: aload 6
    //   400: ldc_w 359
    //   403: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 6
    //   409: iload_1
    //   410: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 6
    //   416: ldc_w 364
    //   419: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 6
    //   425: aload 5
    //   427: invokevirtual 365	java/util/ArrayList:size	()I
    //   430: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 6
    //   436: ldc_w 367
    //   439: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 6
    //   445: aload 4
    //   447: invokeinterface 234 1 0
    //   452: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: ldc 210
    //   458: iconst_2
    //   459: aload 6
    //   461: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: aload_0
    //   468: iload_1
    //   469: aload 5
    //   471: invokevirtual 370	com/tencent/mobileqq/leba/core/LebaHelper:a	(ILjava/util/List;)Lcom/tencent/mobileqq/leba/pb/PluginConfig$GetResourceReq;
    //   474: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	LebaHelper
    //   71	398	1	i	int
    //   288	13	2	j	int
    //   205	167	3	k	int
    //   53	393	4	localObject1	Object
    //   131	1	5	localObject2	Object
    //   136	32	5	localThrowable	java.lang.Throwable
    //   228	242	5	localArrayList	ArrayList
    //   259	201	6	localObject3	Object
    //   281	76	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   110	118	131	finally
    //   138	149	131	finally
    //   110	118	136	java/lang/Throwable
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
    paramList = this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager;
    int i;
    if ((paramList != null) && (paramList.getStudyModeSwitch())) {
      i = 4026;
    } else {
      i = 4000;
    }
    paramList = new StringBuilder();
    paramList.append("getLebaPluginListReq pluginType = ");
    paramList.append(i);
    QLog.i("LebaHelper", 1, paramList.toString());
    paramList = new PluginConfig.GetResourceReq();
    paramList.plugin_type.set(i);
    paramList.plugin_layout_seq.set(paramInt);
    paramList.reqinfo_list.set(localArrayList);
    return paramList;
  }
  
  public List<LebaPluginInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi = ((ILebaBasisApi)QRoute.api(ILebaBasisApi.class));
    this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager = ((IStudyModeManager)QRoute.api(IStudyModeManager.class));
  }
  
  public void a(int paramInt1, List<GroupInfo> paramList, int paramInt2, int paramInt3)
  {
    int j = LebaUtil.b(this.jdField_a_of_type_MqqAppAppRuntime);
    int i;
    if (paramList == null) {
      i = -1;
    } else {
      i = paramList.size();
    }
    QLog.i("LebaHelper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) }));
    if ((paramInt1 > 0) && (paramInt1 != j) && (paramList != null))
    {
      LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt1);
      LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramList);
      LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt2, paramInt3);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
        this.jdField_c_of_type_JavaUtilList.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.excute(paramRunnable, 128, null, true);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    QLog.i("leba_study", 1, "tryCloseShowAllPluginAsyn");
    a(new LebaHelper.4(this, paramAppRuntime));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = false;
      i();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
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
    //   10: invokevirtual 475	com/tencent/mobileqq/leba/core/LebaHelper:b	(ZILjava/util/List;Ljava/util/List;II)V
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore 7
    //   19: iload_1
    //   20: ifeq +624 -> 644
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 25	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_Boolean	Z
    //   28: aload_0
    //   29: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   32: invokevirtual 219	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   35: invokevirtual 225	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: astore 16
    //   40: aload 16
    //   42: invokevirtual 479	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   45: astore 17
    //   47: new 481	java/lang/StringBuffer
    //   50: dup
    //   51: invokespecial 482	java/lang/StringBuffer:<init>	()V
    //   54: astore 18
    //   56: aload 18
    //   58: ldc_w 484
    //   61: invokevirtual 487	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: aload 17
    //   67: invokevirtual 492	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   70: aload 4
    //   72: invokeinterface 374 1 0
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
    //   93: invokeinterface 379 1 0
    //   98: ifeq +224 -> 322
    //   101: iload_1
    //   102: istore 14
    //   104: iload 9
    //   106: istore 11
    //   108: aload 4
    //   110: invokeinterface 383 1 0
    //   115: checkcast 48	com/tencent/mobileqq/leba/entity/LebaPluginInfo
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
    //   139: invokevirtual 495	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: iload_1
    //   144: istore 14
    //   146: iload 9
    //   148: istore 11
    //   150: aload 19
    //   152: getfield 115	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSubType	S
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
    //   174: getfield 115	com/tencent/mobileqq/leba/entity/LebaPluginInfo:sResSubType	S
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
    //   197: getfield 74	com/tencent/mobileqq/leba/entity/LebaPluginInfo:state	I
    //   200: iconst_3
    //   201: if_icmpne +23 -> 224
    //   204: iload_1
    //   205: istore 14
    //   207: iload 9
    //   209: istore 11
    //   211: aload 16
    //   213: aload 19
    //   215: invokestatic 499	com/tencent/mobileqq/leba/entity/LebaPluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;)V
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
    //   242: getfield 74	com/tencent/mobileqq/leba/entity/LebaPluginInfo:state	I
    //   245: iconst_1
    //   246: if_icmpne +25 -> 271
    //   249: iload 12
    //   251: istore 14
    //   253: iload 10
    //   255: istore 11
    //   257: aload 16
    //   259: aload 19
    //   261: invokestatic 499	com/tencent/mobileqq/leba/entity/LebaPluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;)V
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
    //   288: getfield 74	com/tencent/mobileqq/leba/entity/LebaPluginInfo:state	I
    //   291: iconst_2
    //   292: if_icmpne -208 -> 84
    //   295: iload 13
    //   297: istore 14
    //   299: iload 15
    //   301: istore 11
    //   303: aload 16
    //   305: aload 19
    //   307: getfield 69	com/tencent/mobileqq/leba/entity/LebaPluginInfo:uiResId	J
    //   310: invokestatic 241	com/tencent/mobileqq/leba/entity/LebaPluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;J)V
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
    //   331: invokevirtual 501	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   334: aload 17
    //   336: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   339: aload 16
    //   341: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
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
    //   367: ldc 210
    //   369: iconst_1
    //   370: ldc_w 506
    //   373: aload 4
    //   375: invokestatic 508	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   378: aload 4
    //   380: invokevirtual 249	java/lang/Exception:printStackTrace	()V
    //   383: aload 17
    //   385: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   388: aload 16
    //   390: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   393: iconst_0
    //   394: istore 10
    //   396: iload 11
    //   398: istore 9
    //   400: iload 14
    //   402: istore_1
    //   403: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +53 -> 459
    //   409: aload 18
    //   411: ldc_w 510
    //   414: iconst_3
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: iload 10
    //   422: invokestatic 515	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   425: aastore
    //   426: dup
    //   427: iconst_1
    //   428: iload 9
    //   430: invokestatic 515	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   433: aastore
    //   434: dup
    //   435: iconst_2
    //   436: iload_1
    //   437: invokestatic 515	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   440: aastore
    //   441: invokestatic 444	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   444: invokevirtual 487	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   447: pop
    //   448: ldc 210
    //   450: iconst_2
    //   451: aload 18
    //   453: invokevirtual 516	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   456: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: iload 10
    //   461: ifeq +13 -> 474
    //   464: aload_0
    //   465: iload_2
    //   466: aload_3
    //   467: iload 5
    //   469: iload 6
    //   471: invokevirtual 518	com/tencent/mobileqq/leba/core/LebaHelper:a	(ILjava/util/List;II)V
    //   474: aload_0
    //   475: invokevirtual 521	com/tencent/mobileqq/leba/core/LebaHelper:h	()V
    //   478: aload_0
    //   479: invokevirtual 472	com/tencent/mobileqq/leba/core/LebaHelper:i	()V
    //   482: iload 9
    //   484: ifeq +24 -> 508
    //   487: aload_0
    //   488: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   491: ldc_w 523
    //   494: ldc 89
    //   496: invokevirtual 527	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   499: checkcast 523	com/tencent/mobileqq/tianshu/api/IRedTouchServer
    //   502: iconst_1
    //   503: invokeinterface 530 2 0
    //   508: iload_1
    //   509: ifeq +65 -> 574
    //   512: new 37	java/util/ArrayList
    //   515: dup
    //   516: aload_0
    //   517: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   520: invokespecial 533	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   523: invokeinterface 374 1 0
    //   528: astore_3
    //   529: aload_3
    //   530: invokeinterface 379 1 0
    //   535: ifeq +178 -> 713
    //   538: aload_3
    //   539: invokeinterface 383 1 0
    //   544: checkcast 535	com/tencent/mobileqq/leba/observer/ResourcePluginListener
    //   547: astore 4
    //   549: iload 9
    //   551: ifeq +13 -> 564
    //   554: aload 4
    //   556: iconst_3
    //   557: iconst_1
    //   558: invokestatic 538	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
    //   561: goto -32 -> 529
    //   564: aload 4
    //   566: iconst_2
    //   567: iconst_1
    //   568: invokestatic 538	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
    //   571: goto -42 -> 529
    //   574: aload_0
    //   575: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   578: astore_3
    //   579: aload_3
    //   580: monitorenter
    //   581: iload 7
    //   583: istore_2
    //   584: iload_2
    //   585: aload_0
    //   586: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   589: invokeinterface 234 1 0
    //   594: if_icmpge +28 -> 622
    //   597: aload_0
    //   598: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   601: iload_2
    //   602: invokeinterface 237 2 0
    //   607: checkcast 535	com/tencent/mobileqq/leba/observer/ResourcePluginListener
    //   610: iconst_1
    //   611: iconst_1
    //   612: invokestatic 538	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
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
    //   634: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   637: aload 16
    //   639: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   642: aload_3
    //   643: athrow
    //   644: aload_0
    //   645: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   648: astore_3
    //   649: aload_3
    //   650: monitorenter
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 25	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_Boolean	Z
    //   656: iload 8
    //   658: istore_2
    //   659: iload_2
    //   660: aload_0
    //   661: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   664: invokeinterface 234 1 0
    //   669: if_icmpge +28 -> 697
    //   672: aload_0
    //   673: getfield 44	com/tencent/mobileqq/leba/core/LebaHelper:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   676: iload_2
    //   677: invokeinterface 237 2 0
    //   682: checkcast 535	com/tencent/mobileqq/leba/observer/ResourcePluginListener
    //   685: iconst_m1
    //   686: iconst_1
    //   687: invokestatic 538	com/tencent/mobileqq/leba/observer/ResourcePluginListener:a	(Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;BI)V
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
    //   17	565	7	i	int
    //   14	643	8	j	int
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
    //   0: invokestatic 545	java/util/Collections:emptyList	()Ljava/util/List;
    //   3: astore 13
    //   5: invokestatic 545	java/util/Collections:emptyList	()Ljava/util/List;
    //   8: astore 11
    //   10: iconst_m1
    //   11: istore 5
    //   13: iload_1
    //   14: ifeq +625 -> 639
    //   17: aload_2
    //   18: ifnull +563 -> 581
    //   21: aload_2
    //   22: getfield 548	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:plugin_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   25: invokevirtual 65	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   28: istore 8
    //   30: aload_2
    //   31: getfield 552	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:plugin_layout	Lcom/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout;
    //   34: invokevirtual 555	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:has	()Z
    //   37: istore 10
    //   39: aconst_null
    //   40: astore 15
    //   42: iload 10
    //   44: ifeq +721 -> 765
    //   47: aload_2
    //   48: getfield 552	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:plugin_layout	Lcom/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout;
    //   51: invokevirtual 558	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   54: checkcast 554	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout
    //   57: astore 12
    //   59: goto +3 -> 62
    //   62: aload 12
    //   64: ifnull +346 -> 410
    //   67: aload 12
    //   69: getfield 561	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:layout_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +15 -> 90
    //   78: aload 12
    //   80: getfield 561	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:layout_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 65	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: istore_3
    //   87: goto +5 -> 92
    //   90: iconst_m1
    //   91: istore_3
    //   92: iload 5
    //   94: istore 4
    //   96: aload 11
    //   98: astore 14
    //   100: iload 5
    //   102: istore 7
    //   104: iload_3
    //   105: istore 9
    //   107: aload 12
    //   109: getfield 562	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:plugin_layout_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   115: ifeq +24 -> 139
    //   118: aload 11
    //   120: astore 14
    //   122: iload 5
    //   124: istore 7
    //   126: iload_3
    //   127: istore 9
    //   129: aload 12
    //   131: getfield 562	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:plugin_layout_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   134: invokevirtual 65	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   137: istore 4
    //   139: aload 11
    //   141: astore 14
    //   143: iload 4
    //   145: istore 7
    //   147: iload_3
    //   148: istore 9
    //   150: aload 12
    //   152: getfield 565	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:group_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   155: invokevirtual 566	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   158: ifeq +24 -> 182
    //   161: aload 11
    //   163: astore 14
    //   165: iload 4
    //   167: istore 7
    //   169: iload_3
    //   170: istore 9
    //   172: aload 12
    //   174: getfield 565	com/tencent/mobileqq/leba/pb/PluginConfig$PluginLayout:group_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: invokevirtual 568	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   180: astore 15
    //   182: aload 11
    //   184: astore 12
    //   186: iload 4
    //   188: istore 5
    //   190: iload_3
    //   191: istore 6
    //   193: aload 15
    //   195: ifnull +222 -> 417
    //   198: aload 11
    //   200: astore 14
    //   202: iload 4
    //   204: istore 7
    //   206: iload_3
    //   207: istore 9
    //   209: new 37	java/util/ArrayList
    //   212: dup
    //   213: invokespecial 38	java/util/ArrayList:<init>	()V
    //   216: astore 11
    //   218: iconst_0
    //   219: istore 6
    //   221: iconst_0
    //   222: istore 5
    //   224: iload 6
    //   226: aload 15
    //   228: invokeinterface 234 1 0
    //   233: if_icmpge +155 -> 388
    //   236: aload 15
    //   238: iload 6
    //   240: invokeinterface 237 2 0
    //   245: checkcast 570	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup
    //   248: astore 12
    //   250: iload 5
    //   252: istore 7
    //   254: aload 12
    //   256: invokevirtual 571	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup:has	()Z
    //   259: ifeq +116 -> 375
    //   262: iload 5
    //   264: istore 7
    //   266: aload 12
    //   268: getfield 574	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup:res_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   271: invokevirtual 577	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   274: ifeq +101 -> 375
    //   277: aload 12
    //   279: getfield 574	com/tencent/mobileqq/leba/pb/PluginConfig$PluginGroup:res_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   282: invokevirtual 578	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   285: astore 12
    //   287: iconst_0
    //   288: istore 7
    //   290: iload 7
    //   292: aload 12
    //   294: invokeinterface 234 1 0
    //   299: if_icmpge +72 -> 371
    //   302: new 288	com/tencent/mobileqq/leba/entity/GroupInfo
    //   305: dup
    //   306: invokespecial 579	com/tencent/mobileqq/leba/entity/GroupInfo:<init>	()V
    //   309: astore 14
    //   311: aload 14
    //   313: aload 12
    //   315: iload 7
    //   317: invokeinterface 237 2 0
    //   322: checkcast 435	java/lang/Integer
    //   325: invokevirtual 582	java/lang/Integer:intValue	()I
    //   328: i2l
    //   329: putfield 584	com/tencent/mobileqq/leba/entity/GroupInfo:jdField_a_of_type_Long	J
    //   332: aload 14
    //   334: iload 6
    //   336: putfield 585	com/tencent/mobileqq/leba/entity/GroupInfo:jdField_a_of_type_Int	I
    //   339: iload 5
    //   341: iconst_1
    //   342: iadd
    //   343: istore 5
    //   345: aload 14
    //   347: iload 5
    //   349: putfield 586	com/tencent/mobileqq/leba/entity/GroupInfo:jdField_b_of_type_Int	I
    //   352: aload 11
    //   354: aload 14
    //   356: invokeinterface 393 2 0
    //   361: pop
    //   362: iload 7
    //   364: iconst_1
    //   365: iadd
    //   366: istore 7
    //   368: goto -78 -> 290
    //   371: iload 5
    //   373: istore 7
    //   375: iload 6
    //   377: iconst_1
    //   378: iadd
    //   379: istore 6
    //   381: iload 7
    //   383: istore 5
    //   385: goto -161 -> 224
    //   388: aload 11
    //   390: astore 12
    //   392: iload 4
    //   394: istore 5
    //   396: iload_3
    //   397: istore 6
    //   399: goto +18 -> 417
    //   402: astore_2
    //   403: aload 11
    //   405: astore 12
    //   407: goto +150 -> 557
    //   410: iconst_m1
    //   411: istore 6
    //   413: aload 11
    //   415: astore 12
    //   417: aload 12
    //   419: astore 14
    //   421: iload 5
    //   423: istore 7
    //   425: iload 6
    //   427: istore 9
    //   429: aload_2
    //   430: getfield 589	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceResp:respinfo_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   433: invokevirtual 568	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   436: astore 11
    //   438: aload 12
    //   440: astore 14
    //   442: iload 5
    //   444: istore 7
    //   446: iload 6
    //   448: istore 9
    //   450: new 37	java/util/ArrayList
    //   453: dup
    //   454: invokespecial 38	java/util/ArrayList:<init>	()V
    //   457: astore_2
    //   458: aload 11
    //   460: ifnull +75 -> 535
    //   463: aload 11
    //   465: invokeinterface 374 1 0
    //   470: astore 11
    //   472: aload 11
    //   474: invokeinterface 379 1 0
    //   479: ifeq +56 -> 535
    //   482: aload 11
    //   484: invokeinterface 383 1 0
    //   489: checkcast 51	com/tencent/mobileqq/leba/pb/PluginConfig$GetResourceRespInfo
    //   492: invokestatic 591	com/tencent/mobileqq/leba/core/LebaHelper:a	(Lcom/tencent/mobileqq/leba/pb/PluginConfig$GetResourceRespInfo;)Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;
    //   495: astore 13
    //   497: aload 13
    //   499: ifnonnull +6 -> 505
    //   502: goto -30 -> 472
    //   505: aload_2
    //   506: aload 13
    //   508: invokeinterface 393 2 0
    //   513: pop
    //   514: goto -42 -> 472
    //   517: astore 11
    //   519: aload_2
    //   520: astore 13
    //   522: aload 11
    //   524: astore_2
    //   525: iload 5
    //   527: istore 4
    //   529: iload 6
    //   531: istore_3
    //   532: goto +25 -> 557
    //   535: aload_2
    //   536: astore 13
    //   538: aload 12
    //   540: astore 11
    //   542: goto +56 -> 598
    //   545: astore_2
    //   546: iload 9
    //   548: istore_3
    //   549: iload 7
    //   551: istore 4
    //   553: aload 14
    //   555: astore 12
    //   557: aload 12
    //   559: astore 11
    //   561: goto +54 -> 615
    //   564: astore_2
    //   565: goto +7 -> 572
    //   568: astore_2
    //   569: iconst_m1
    //   570: istore 8
    //   572: iconst_m1
    //   573: istore_3
    //   574: iload 5
    //   576: istore 4
    //   578: goto +37 -> 615
    //   581: ldc 210
    //   583: iconst_1
    //   584: ldc_w 593
    //   587: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: iconst_0
    //   591: istore_1
    //   592: iconst_m1
    //   593: istore 8
    //   595: iconst_m1
    //   596: istore 6
    //   598: aload 13
    //   600: astore_2
    //   601: iload 8
    //   603: istore_3
    //   604: iload 5
    //   606: istore 4
    //   608: goto +28 -> 636
    //   611: astore_2
    //   612: goto -43 -> 569
    //   615: ldc 210
    //   617: iconst_1
    //   618: ldc_w 595
    //   621: aload_2
    //   622: invokestatic 508	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   625: aload 13
    //   627: astore_2
    //   628: iconst_0
    //   629: istore_1
    //   630: iload_3
    //   631: istore 6
    //   633: iload 8
    //   635: istore_3
    //   636: goto +14 -> 650
    //   639: iconst_m1
    //   640: istore 4
    //   642: iconst_m1
    //   643: istore_3
    //   644: iconst_m1
    //   645: istore 6
    //   647: aload 13
    //   649: astore_2
    //   650: aload_2
    //   651: ifnull +14 -> 665
    //   654: aload_2
    //   655: invokeinterface 234 1 0
    //   660: istore 5
    //   662: goto +6 -> 668
    //   665: iconst_0
    //   666: istore 5
    //   668: aload 11
    //   670: ifnull +15 -> 685
    //   673: aload 11
    //   675: invokeinterface 234 1 0
    //   680: istore 7
    //   682: goto +6 -> 688
    //   685: iconst_0
    //   686: istore 7
    //   688: ldc 210
    //   690: iconst_1
    //   691: bipush 6
    //   693: anewarray 4	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: ldc_w 597
    //   701: aastore
    //   702: dup
    //   703: iconst_1
    //   704: iload_1
    //   705: invokestatic 515	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   708: aastore
    //   709: dup
    //   710: iconst_2
    //   711: ldc_w 599
    //   714: aastore
    //   715: dup
    //   716: iconst_3
    //   717: iload 5
    //   719: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   722: aastore
    //   723: dup
    //   724: iconst_4
    //   725: ldc_w 601
    //   728: aastore
    //   729: dup
    //   730: iconst_5
    //   731: iload 7
    //   733: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   736: aastore
    //   737: invokestatic 604	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   740: aload_0
    //   741: iload_1
    //   742: iload 4
    //   744: aload 11
    //   746: aload_2
    //   747: iload 6
    //   749: iload_3
    //   750: invokevirtual 606	com/tencent/mobileqq/leba/core/LebaHelper:a	(ZILjava/util/List;Ljava/util/List;II)V
    //   753: aload_0
    //   754: aload_0
    //   755: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   758: iload_1
    //   759: iload_3
    //   760: invokevirtual 609	com/tencent/mobileqq/leba/core/LebaHelper:a	(Lmqq/app/AppRuntime;ZI)Z
    //   763: pop
    //   764: return
    //   765: aconst_null
    //   766: astore 12
    //   768: goto -706 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	771	0	this	LebaHelper
    //   0	771	1	paramBoolean	boolean
    //   0	771	2	paramGetResourceResp	com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp
    //   86	674	3	i	int
    //   94	649	4	j	int
    //   11	707	5	k	int
    //   191	557	6	m	int
    //   102	630	7	n	int
    //   28	606	8	i1	int
    //   105	442	9	i2	int
    //   37	6	10	bool	boolean
    //   8	475	11	localObject1	Object
    //   517	6	11	localException	Exception
    //   540	205	11	localObject2	Object
    //   57	710	12	localObject3	Object
    //   3	645	13	localObject4	Object
    //   98	456	14	localObject5	Object
    //   40	197	15	localList	List
    // Exception table:
    //   from	to	target	type
    //   224	250	402	java/lang/Exception
    //   254	262	402	java/lang/Exception
    //   266	287	402	java/lang/Exception
    //   290	339	402	java/lang/Exception
    //   345	362	402	java/lang/Exception
    //   463	472	517	java/lang/Exception
    //   472	497	517	java/lang/Exception
    //   505	514	517	java/lang/Exception
    //   107	118	545	java/lang/Exception
    //   129	139	545	java/lang/Exception
    //   150	161	545	java/lang/Exception
    //   172	182	545	java/lang/Exception
    //   209	218	545	java/lang/Exception
    //   429	438	545	java/lang/Exception
    //   450	458	545	java/lang/Exception
    //   30	39	564	java/lang/Exception
    //   47	59	564	java/lang/Exception
    //   67	87	564	java/lang/Exception
    //   21	30	568	java/lang/Exception
    //   581	590	611	java/lang/Exception
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    IStudyModeManager localIStudyModeManager = this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager;
    int i;
    if ((localIStudyModeManager != null) && (localIStudyModeManager.getStudyModeSwitch())) {
      i = 4026;
    } else {
      i = 4000;
    }
    return i != LebaUtil.d(paramAppRuntime);
  }
  
  public boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (LebaUtil.a(paramInt)))
    {
      if (LebaUtil.c(paramAppRuntime) == 2)
      {
        QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin failed has Close");
        return false;
      }
      QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin");
      CommPluginHandlerApi.b(paramAppRuntime);
      return true;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("tryClosePluginWhenLoadPlugin failed isSuc = ");
    paramAppRuntime.append(paramBoolean);
    paramAppRuntime.append(",pluginType=");
    paramAppRuntime.append(paramInt);
    QLog.i("leba_study", 1, paramAppRuntime.toString());
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    b(new LebaHelper.1(this));
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramResourcePluginListener);
      return;
    }
  }
  
  protected void b(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder("closeShowAllPlugin->");
    Object localObject4 = LebaShowListManager.a().b(paramAppRuntime);
    Object localObject3 = LebaShowListManager.a().a();
    long l = NetConnInfoCenter.getServerTimeMillis();
    localStringBuilder.append(l);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = "null;";
    Object localObject2 = localObject1;
    if (localObject4 != null)
    {
      localStringBuilder.append("close->");
      localObject4 = ((List)localObject4).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject4).next();
        if ((localLebaViewItem != null) && (localLebaViewItem.a != null))
        {
          localStringBuilder.append(localLebaViewItem.a.uiResId);
          localStringBuilder.append(";");
          localObject2 = localObject1;
          if (4030L == localLebaViewItem.a.uiResId) {
            break label271;
          }
          if (3504L == localLebaViewItem.a.uiResId) {
            continue;
          }
          LebaShowListManager.a().a(paramAppRuntime, localLebaViewItem.a.uiResId, false, l, -9223372036854775808L, true);
          localObject2 = new BusinessInfoCheckUpdate.AppSetting();
          ((BusinessInfoCheckUpdate.AppSetting)localObject2).appid.set((int)localLebaViewItem.a.uiResId);
          ((BusinessInfoCheckUpdate.AppSetting)localObject2).setting.set(false);
          ((BusinessInfoCheckUpdate.AppSetting)localObject2).modify_ts.set(l);
          localArrayList.add(localObject2);
        }
        else
        {
          localStringBuilder.append((String)localObject1);
        }
        localObject2 = localObject1;
        label271:
        localObject1 = localObject2;
      }
    }
    if (localObject3 != null)
    {
      localStringBuilder.append("open->");
      localObject1 = ((List)localObject3).iterator();
      label459:
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (LebaViewItem)((Iterator)localObject1).next();
        if ((localObject3 != null) && (((LebaViewItem)localObject3).a != null))
        {
          if ((4030L != ((LebaViewItem)localObject3).a.uiResId) && (3504L != ((LebaViewItem)localObject3).a.uiResId)) {
            break label459;
          }
          LebaShowListManager.a().a(paramAppRuntime, ((LebaViewItem)localObject3).a.uiResId, true, l, -9223372036854775808L, true);
          localObject4 = new BusinessInfoCheckUpdate.AppSetting();
          ((BusinessInfoCheckUpdate.AppSetting)localObject4).appid.set((int)((LebaViewItem)localObject3).a.uiResId);
          ((BusinessInfoCheckUpdate.AppSetting)localObject4).setting.set(true);
          ((BusinessInfoCheckUpdate.AppSetting)localObject4).modify_ts.set(l);
          localArrayList.add(localObject4);
        }
        else
        {
          localStringBuilder.append((String)localObject2);
        }
      }
    }
    QLog.i("leba_study", 1, localStringBuilder.toString());
    if (localArrayList.isEmpty()) {
      c(paramAppRuntime);
    } else {
      CommPluginHandlerApi.a(paramAppRuntime, localArrayList);
    }
    i();
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
    QLog.i("LebaHelper", 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      CommPluginHandlerApi.c(this.jdField_a_of_type_MqqAppAppRuntime);
      this.jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPluginConfig, mGetPluginConfigFail=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(", mPluginRetryTime=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("LebaHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void c(AppRuntime paramAppRuntime)
  {
    QLog.i("leba_study", 1, "setHasClosePluginFlagYes");
    LebaUtil.b(paramAppRuntime, 2);
    LebaUtil.a(paramAppRuntime, true);
    a(new LebaHelper.5(this, paramAppRuntime));
  }
  
  public void d()
  {
    if (a(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QLog.i("LebaHelper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.2(this), 160, null, true);
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      int i = this.jdField_b_of_type_Int;
      if (i < 3)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Int = (i + 1);
        ThreadManager.excute(new LebaHelper.3(this), 128, null, true);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkPluginSort, mGetUserSortFail=");
        localStringBuilder.append(this.jdField_c_of_type_Boolean);
        localStringBuilder.append(", mPluginRetryTime=");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        QLog.i("leba_sort", 1, localStringBuilder.toString());
      }
    }
  }
  
  protected void g()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = HardCodeUtil.a(2131693595);
    localLebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localLebaPluginInfo.sResSubType = 2;
    localLebaPluginInfo.cCanChangeState = 0;
    localLebaPluginInfo.cDataType = 1;
    localLebaPluginInfo.uiResId = 0L;
    localLebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "tab_qzone" });
    localLebaPluginInfo.showInSimpleMode = 1;
    this.jdField_b_of_type_JavaUtilList.add(localLebaPluginInfo);
  }
  
  public void h()
  {
    ??? = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((??? != null) && (((AppRuntime)???).isLogin()))
    {
      try
      {
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
        }
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LebaHelper", 2, localException2, new Object[0]);
        }
        try
        {
          g();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        k();
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("loadAllPlugins，size=");
            ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilList.size());
            QLog.d("LebaHelper", 2, ((StringBuilder)???).toString());
          }
          this.jdField_b_of_type_Boolean = true;
          return;
        }
      }
      throw localObject4;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "error happens: loadAllPlugins while app is null || app is not login");
    }
  }
  
  public void i()
  {
    Iterator localIterator = new ArrayList(this.jdField_c_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaHelper
 * JD-Core Version:    0.7.0.1
 */