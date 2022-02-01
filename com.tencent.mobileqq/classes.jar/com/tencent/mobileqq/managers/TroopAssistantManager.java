package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopConfessToMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHomeworkPraiseMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopKeyWordMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.utils.TroopRemindSettingManager;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class TroopAssistantManager
{
  public static TroopAssistantManager a;
  protected Object b = new Object();
  protected boolean c = true;
  protected boolean d;
  protected boolean e;
  protected String f;
  protected long g = 0L;
  protected boolean h = false;
  protected int i = 0;
  protected Set<String> j = new HashSet();
  protected List<TroopAssistantData> k;
  protected final Map<String, TroopAssistantData> l = new HashMap();
  protected Object m = new Object();
  protected boolean n = false;
  HashSet<String> o = new HashSet();
  protected int p = -1;
  
  private TroopAssistantData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.l)
    {
      TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.l.get(paramString);
      paramEntityManager = localTroopAssistantData;
      if (localTroopAssistantData == null)
      {
        localTroopAssistantData = new TroopAssistantData();
        localTroopAssistantData.troopUin = paramString;
        paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        paramEntityManager = localTroopAssistantData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramString, 1);
          paramEntityManager = localTroopAssistantData;
          if (paramQQAppInterface != null)
          {
            localTroopAssistantData.lastdrafttime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopAssistantData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  public static TroopAssistantManager a()
  {
    try
    {
      if (a == null) {
        a = new TroopAssistantManager();
      }
      TroopAssistantManager localTroopAssistantManager = a;
      return localTroopAssistantManager;
    }
    finally {}
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.b;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.j.contains(paramString))) {
        this.j.add(paramString);
      }
      t(paramQQAppInterface);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void a(EntityManager arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 79
    //   3: iconst_0
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc 131
    //   10: aconst_null
    //   11: invokevirtual 137	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +69 -> 85
    //   19: aload_1
    //   20: invokeinterface 143 1 0
    //   25: ifle +60 -> 85
    //   28: aload_1
    //   29: new 145	com/tencent/mobileqq/managers/TroopAssistantManager$5
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 148	com/tencent/mobileqq/managers/TroopAssistantManager$5:<init>	(Lcom/tencent/mobileqq/managers/TroopAssistantManager;)V
    //   37: invokestatic 154	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   40: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +56 -> 99
    //   46: new 162	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: ldc 165
    //   57: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: aload_1
    //   63: invokeinterface 143 1 0
    //   68: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 174
    //   74: iconst_2
    //   75: aload_2
    //   76: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: goto +17 -> 99
    //   85: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +11 -> 99
    //   91: ldc 174
    //   93: iconst_2
    //   94: ldc 183
    //   96: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: getfield 55	com/tencent/mobileqq/managers/TroopAssistantManager:m	Ljava/lang/Object;
    //   103: astore_2
    //   104: aload_2
    //   105: monitorenter
    //   106: aload_0
    //   107: aload_1
    //   108: putfield 185	com/tencent/mobileqq/managers/TroopAssistantManager:k	Ljava/util/List;
    //   111: aload_0
    //   112: getfield 185	com/tencent/mobileqq/managers/TroopAssistantManager:k	Ljava/util/List;
    //   115: ifnonnull +16 -> 131
    //   118: aload_0
    //   119: new 187	java/util/ArrayList
    //   122: dup
    //   123: bipush 15
    //   125: invokespecial 190	java/util/ArrayList:<init>	(I)V
    //   128: putfield 185	com/tencent/mobileqq/managers/TroopAssistantManager:k	Ljava/util/List;
    //   131: aload_2
    //   132: monitorexit
    //   133: aload_0
    //   134: getfield 66	com/tencent/mobileqq/managers/TroopAssistantManager:l	Ljava/util/Map;
    //   137: astore_1
    //   138: aload_1
    //   139: monitorenter
    //   140: aload_0
    //   141: getfield 66	com/tencent/mobileqq/managers/TroopAssistantManager:l	Ljava/util/Map;
    //   144: invokeinterface 193 1 0
    //   149: aload_0
    //   150: getfield 185	com/tencent/mobileqq/managers/TroopAssistantManager:k	Ljava/util/List;
    //   153: invokeinterface 197 1 0
    //   158: astore_2
    //   159: aload_2
    //   160: invokeinterface 202 1 0
    //   165: ifeq +31 -> 196
    //   168: aload_2
    //   169: invokeinterface 206 1 0
    //   174: checkcast 79	com/tencent/mobileqq/data/TroopAssistantData
    //   177: astore_3
    //   178: aload_0
    //   179: getfield 66	com/tencent/mobileqq/managers/TroopAssistantManager:l	Ljava/util/Map;
    //   182: aload_3
    //   183: getfield 83	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   186: aload_3
    //   187: invokeinterface 210 3 0
    //   192: pop
    //   193: goto -34 -> 159
    //   196: aload_1
    //   197: monitorexit
    //   198: return
    //   199: astore_2
    //   200: aload_1
    //   201: monitorexit
    //   202: aload_2
    //   203: athrow
    //   204: astore_1
    //   205: aload_2
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    //   209: astore_1
    //   210: goto +45 -> 255
    //   213: astore_1
    //   214: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +37 -> 254
    //   220: new 162	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   227: astore_2
    //   228: aload_2
    //   229: ldc 212
    //   231: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload_1
    //   237: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 174
    //   246: iconst_2
    //   247: aload_2
    //   248: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: return
    //   255: goto +5 -> 260
    //   258: aload_1
    //   259: athrow
    //   260: goto -2 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	TroopAssistantManager
    //   199	7	2	localObject2	Object
    //   227	21	2	localStringBuilder	StringBuilder
    //   177	10	3	localTroopAssistantData	TroopAssistantData
    // Exception table:
    //   from	to	target	type
    //   140	159	199	finally
    //   159	193	199	finally
    //   196	198	199	finally
    //   200	202	199	finally
    //   106	131	204	finally
    //   131	133	204	finally
    //   205	207	204	finally
    //   0	15	209	finally
    //   19	82	209	finally
    //   85	99	209	finally
    //   99	106	209	finally
    //   133	140	209	finally
    //   202	204	209	finally
    //   207	209	209	finally
    //   214	254	209	finally
    //   0	15	213	java/lang/Exception
    //   19	82	213	java/lang/Exception
    //   85	99	213	java/lang/Exception
    //   99	106	213	java/lang/Exception
    //   133	140	213	java/lang/Exception
    //   202	204	213	java/lang/Exception
    //   207	209	213	java/lang/Exception
  }
  
  private void a(EntityManager paramEntityManager, TroopAssistantData paramTroopAssistantData)
  {
    if (paramTroopAssistantData != null) {
      if (TextUtils.isEmpty(paramTroopAssistantData.troopUin)) {
        return;
      }
    }
    for (;;)
    {
      synchronized (this.l)
      {
        this.l.put(paramTroopAssistantData.troopUin, paramTroopAssistantData);
        synchronized (this.m)
        {
          if (this.k != null)
          {
            this.k.remove(paramTroopAssistantData);
            int i2 = this.k.size();
            i1 = 0;
            if (i1 >= i2) {
              break label211;
            }
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.k.get(i1);
            if (Math.max(paramTroopAssistantData.lastmsgtime, paramTroopAssistantData.lastdrafttime) <= Math.max(localTroopAssistantData.lastmsgtime, localTroopAssistantData.lastdrafttime)) {
              break label204;
            }
            this.k.add(i1, paramTroopAssistantData);
            i1 = 1;
            if (i1 == 0) {
              this.k.add(this.k.size(), paramTroopAssistantData);
            }
          }
          ThreadManager.post(new TroopAssistantManager.4(this, paramTroopAssistantData, paramEntityManager), 8, null, false);
          return;
        }
      }
      return;
      label204:
      i1 += 1;
      continue;
      label211:
      int i1 = 0;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt == 2) {
        break label99;
      }
      if (paramInt != 3)
      {
        bool1 = bool2;
        if (!this.d) {
          break label99;
        }
        bool1 = bool2;
        if (this.n) {
          break label99;
        }
        bool1 = bool2;
        if (((TroopManager)localObject).c()) {
          break label99;
        }
      }
      else
      {
        bool1 = this.d;
        break label99;
      }
    }
    boolean bool1 = true;
    label99:
    if (bool1)
    {
      localObject = localRecentUserProxy.b(AppConstants.TROOP_ASSISTANT_UIN, 5000);
      ((RecentUser)localObject).uin = AppConstants.TROOP_ASSISTANT_UIN;
      ((RecentUser)localObject).setType(5000);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      if (c())
      {
        ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      }
      else
      {
        paramQQAppInterface = d(paramQQAppInterface);
        if (paramQQAppInterface != null)
        {
          ((RecentUser)localObject).lastmsgtime = paramQQAppInterface.lastmsgtime;
          ((RecentUser)localObject).lastmsgdrafttime = paramQQAppInterface.lastdrafttime;
        }
        ((RecentUser)localObject).showUpTime = 0L;
      }
      localRecentUserProxy.b((RecentUser)localObject);
      return true;
    }
    if (paramInt != 3)
    {
      paramQQAppInterface = localRecentUserProxy.c(AppConstants.TROOP_ASSISTANT_UIN, 5000);
      if (paramQQAppInterface != null) {
        localRecentUserProxy.a(paramQQAppInterface);
      }
    }
    return true;
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.l)
    {
      paramString = (TroopAssistantData)this.l.remove(paramString);
      synchronized (this.m)
      {
        if (this.k != null) {
          this.k.remove(paramString);
        }
        boolean bool = false;
        if (paramString != null)
        {
          ThreadManager.post(new TroopAssistantManager.3(this, paramEntityManager, paramString), 8, null, false);
          bool = true;
        }
        return bool;
      }
    }
  }
  
  private void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.b)
    {
      if ((paramQQAppInterface.getConversationFacade().a(paramString, 1) > 0) && (this.j.contains(paramString))) {
        this.j.remove(paramString);
      }
      t(paramQQAppInterface);
      return;
    }
  }
  
  public static void e()
  {
    a = null;
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.b)
    {
      if ((paramQQAppInterface.getConversationFacade().a(paramString, 1) > 0) && (!this.j.contains(paramString))) {
        this.j.add(paramString);
      }
      t(paramQQAppInterface);
      return;
    }
  }
  
  private TroopAssistantData h(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.l)
    {
      paramString = (TroopAssistantData)this.l.get(paramString);
      return paramString;
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface, String paramString)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    paramString = localRecentUserProxy.c(paramString, 1);
    if ((paramString != null) && (!RecentUserAppearLogic.a(paramQQAppInterface, paramString.msgType))) {
      localRecentUserProxy.a(paramString);
    }
  }
  
  private void t(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new TroopAssistantManager.1(this, paramQQAppInterface), 5, null, false);
  }
  
  private boolean u(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("should_update_troop_assistant", true);
  }
  
  private void v(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.getApp() == null) {
        return;
      }
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("should_update_troop_assistant", false).commit();
    }
  }
  
  public int a(QQMessageFacade arg1, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.b)
    {
      Object localObject = this.j;
      int i1 = 0;
      if (localObject != null)
      {
        localObject = this.j.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(str)) && (!HiddenChatHelper.a(str, 1, paramQQAppInterface))) {
            i1 += 1;
          }
        }
        this.i = i1;
        return i1;
      }
      this.i = 0;
      return 0;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public Map<String, Integer> a(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    return ((IRoamSettingService)paramQQAppInterface.getRuntimeService(IRoamSettingService.class, "")).getTroopMsgFilterList(paramList, 1);
  }
  
  public Map<String, Integer> a(QQAppInterface paramQQAppInterface, String... paramVarArgs)
  {
    return a(paramQQAppInterface, Arrays.asList(paramVarArgs));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      synchronized (this.m)
      {
        if (this.k == null)
        {
          i1 = 1;
          if (i1 != 0)
          {
            paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
            a(paramQQAppInterface);
            paramQQAppInterface.close();
          }
          return;
        }
      }
      int i1 = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.f)) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_assis_last_read_time", paramLong).commit();
    this.g = paramLong;
    synchronized (this.b)
    {
      if (this.j != null) {
        this.j.clear();
      }
      t(paramQQAppInterface);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    ThreadManager.post(new TroopAssistantManager.2(this, paramQQAppInterface, paramTroopProtocolObserver), 8, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface.setTroopMsgFilterToServer(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, localEntityManager, paramQQAppInterface);
    localEntityManager.close();
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong)) {
      localTroopAssistantData.lastmsgtime = paramMessageRecord.time;
    } else {
      localTroopAssistantData.lastmsgtime = paramLong;
    }
    Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(localTroopAssistantData.troopUin, 1);
    if (localMessage != null)
    {
      long l1 = localMessage.time;
      if (l1 > localTroopAssistantData.lastmsgtime) {
        localTroopAssistantData.lastmsgtime = l1;
      }
    }
    a(paramEntityManager, localTroopAssistantData);
    a(paramMessageRecord, paramString, paramQQAppInterface);
    if (this.n) {
      c(paramQQAppInterface, false);
    }
    i(paramQQAppInterface, paramString);
    a(paramQQAppInterface, 0, paramLong);
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
      Object localObject2 = localRecentUserProxy.a(false);
      long l1 = System.currentTimeMillis() / 1000L;
      this.c = h(paramQQAppInterface);
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if ((((RecentUser)localObject3).getType() == 1) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        long l2 = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopAssistantData)localObject3).lastdrafttime = ((RecentUser)localObject2).lastmsgdrafttime;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopAssistantData)localObject3).troopUin, 1);
            if (localMessage != null) {
              ((TroopAssistantData)localObject3).lastmsgtime = localMessage.time;
            }
          }
          else
          {
            ((TroopAssistantData)localObject3).lastmsgtime = ((RecentUser)localObject2).lastmsgtime;
          }
          a(paramEntityManager, (TroopAssistantData)localObject3);
          localRecentUserProxy.a((RecentUser)localObject2);
          e(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
        }
      }
      a(paramQQAppInterface, 0, l1);
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_assistant", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData;
    if (paramLong == 0L) {
      localTroopAssistantData = h(paramQQAppInterface, paramString);
    } else {
      localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
    }
    if (localTroopAssistantData != null)
    {
      localTroopAssistantData.lastdrafttime = paramLong;
      if ((paramLong == 0L) && (localTroopAssistantData.lastmsgtime == 0L)) {
        i(paramQQAppInterface, paramString);
      } else {
        a(paramEntityManager, localTroopAssistantData);
      }
    }
    if (this.n) {
      c(paramQQAppInterface, false);
    }
    i(paramQQAppInterface, paramString);
    a(paramQQAppInterface, 0, paramLong);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    RecentUser localRecentUser = localRecentUserProxy.c(paramString, 1);
    if (localRecentUser != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (localRecentUser.lastmsgtime == 0L)
      {
        localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramString.troopUin, 1);
        if (localObject != null) {
          paramString.lastmsgtime = ((Message)localObject).time;
        }
      }
      else
      {
        paramString.lastmsgtime = localRecentUser.lastmsgtime;
      }
      paramString.lastdrafttime = localRecentUser.lastmsgdrafttime;
      a(localEntityManager, paramString);
      e(paramString.troopUin, paramQQAppInterface);
      paramString = RecentDataListManager.a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localRecentUser.uin);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(localRecentUser.getType());
      paramString.b(((StringBuilder)localObject).toString());
      if ((!(localRecentUser.msg instanceof TroopAtMeMsg)) && (!(localRecentUser.msg instanceof TroopSpecialAttentionMsg)) && (!(localRecentUser.msg instanceof TroopConfessToMeMsg)) && (!(localRecentUser.msg instanceof TroopKeyWordMsg)) && (!(localRecentUser.msg instanceof TroopAtAllMsg)) && (!(localRecentUser.msg instanceof TroopHomeworkSpecialMsg)) && (!(localRecentUser.msg instanceof TroopReceivedFlowsersMsg)) && (!(localRecentUser.msg instanceof TroopHomeworkPraiseMsg)) && (!(localRecentUser.msg instanceof TroopNotificationMsg))) {
        localRecentUserProxy.a(localRecentUser);
      }
    }
    paramString = d(paramQQAppInterface);
    if (paramString != null) {
      a(paramQQAppInterface, 0, paramString.lastmsgtime);
    }
    localEntityManager.close();
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.getTroopMask(paramString) == 2;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.getAccount().equals(this.f)) {
      b(paramQQAppInterface);
    }
    this.d = paramBoolean;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_in_msg", paramBoolean).commit();
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    boolean bool2 = a(paramQQAppInterface, i1, 0L);
    paramBoolean = bool1;
    if (this.d)
    {
      paramBoolean = bool1;
      if (bool2) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    return this.o.contains(paramString);
  }
  
  public int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.getTroopMask(paramString);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.f = paramQQAppInterface.getAccount();
      Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.d = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_in_msg", true);
      this.e = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_on_top", false);
      this.g = ((SharedPreferences)localObject2).getLong("troop_assis_last_read_time", 0L);
      this.c = h(paramQQAppInterface);
      this.n = ((SharedPreferences)localObject2).getBoolean("troop_assistant_be_del", false);
      synchronized (this.m)
      {
        this.k = null;
        Object localObject3 = n(paramQQAppInterface);
        synchronized (this.b)
        {
          this.j = SharedPreferencesHandler.a((SharedPreferences)localObject2, "troop_assis_new_unread_list", null);
          if (this.j == null)
          {
            this.j = new HashSet();
            if (u(paramQQAppInterface))
            {
              v(paramQQAppInterface);
              localObject2 = paramQQAppInterface.getMessageFacade();
              if (localObject2 == null) {
                return;
              }
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                TroopAssistantData localTroopAssistantData = (TroopAssistantData)((Iterator)localObject3).next();
                Message localMessage = ((QQMessageFacade)localObject2).getLastMessage(localTroopAssistantData.troopUin, 1);
                if ((paramQQAppInterface.getConversationFacade().a(localTroopAssistantData.troopUin, 1) > 0) && (localMessage.time > this.g)) {
                  e(localMessage.frienduin, paramQQAppInterface);
                }
              }
            }
          }
          return;
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.getApp() == null) {
        return;
      }
      long l1 = paramLong;
      if (paramLong == 0L) {
        l1 = new Date().getTime() + 86400L;
      }
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_batch_setting_time", l1).commit();
    }
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (a(localEntityManager, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (!paramQQAppInterface.getAccount().equals(this.f)) {
      b(paramQQAppInterface);
    }
    this.e = paramBoolean;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    a(paramQQAppInterface, 3, 0L);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    return this.e;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssistantManager", 2, "app == null; what happen.");
      }
      return;
    }
    if (!paramQQAppInterface.getAccount().equals(this.f)) {
      b(paramQQAppInterface);
    }
    a(paramQQAppInterface, 0, 0L);
  }
  
  public void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assistant_be_del", paramBoolean).commit();
    this.n = paramBoolean;
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = localEntityManager;
      TroopAssistantData localTroopAssistantData = h(paramQQAppInterface, paramString);
      localObject = localEntityManager;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
      if (localTroopAssistantData != null)
      {
        localObject = localEntityManager;
        RecentUser localRecentUser = localRecentUserProxy.b(String.valueOf(localTroopAssistantData.troopUin), 1);
        localObject = localEntityManager;
        localRecentUser.uin = localTroopAssistantData.troopUin;
        localObject = localEntityManager;
        localRecentUser.setType(1);
        localObject = localEntityManager;
        localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
        localObject = localEntityManager;
        localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
        localObject = localEntityManager;
        if (a(localEntityManager, paramString))
        {
          localObject = localEntityManager;
          localRecentUserProxy.b(localRecentUser);
          localObject = localEntityManager;
          d(paramString, paramQQAppInterface);
        }
      }
      localObject = localEntityManager;
      paramString = d(paramQQAppInterface);
      if (paramString != null)
      {
        localObject = localEntityManager;
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        localObject.close();
      }
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tag_troop_ignore_tip_v2_");
          localStringBuilder.append(paramString);
          bool1 = paramQQAppInterface.getBoolean(localStringBuilder.toString(), false);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkTroopIgnoreTip ignore=");
      paramQQAppInterface.append(bool1);
      QLog.d("troopassist_guide", 2, paramQQAppInterface.toString());
    }
    return bool1;
  }
  
  public TroopAssistantData d(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    synchronized (this.m)
    {
      if ((this.k != null) && (this.k.size() > 0))
      {
        Iterator localIterator = this.k.iterator();
        TroopAssistantData localTroopAssistantData;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localTroopAssistantData = (TroopAssistantData)localIterator.next();
        } while (HiddenChatHelper.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface));
        paramQQAppInterface = localTroopAssistantData;
        return paramQQAppInterface;
      }
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tag_troop_ignore_tip_v2_");
        localStringBuilder.append(paramString);
        paramQQAppInterface.putBoolean(localStringBuilder.toString(), true).commit();
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("setTroopIgnoreTip key=tag_troop_ignore_tip_v2_");
          paramQQAppInterface.append(paramString);
          QLog.d("troopassist_guide", 2, paramQQAppInterface.toString());
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    t(paramQQAppInterface);
  }
  
  public void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (localObject != null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("tag_troop_ignore_tip_v2_");
        paramQQAppInterface.append(paramString);
        if (((SharedPreferences)localObject).getBoolean(paramQQAppInterface.toString(), false)) {
          return;
        }
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("tag_troop_aio_enter_times_");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface = ((SharedPreferences)localObject).getString(paramQQAppInterface.toString(), "");
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append(";");
          localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() / 1000L);
          paramQQAppInterface = localStringBuilder.toString();
        }
        else
        {
          paramQQAppInterface = String.valueOf(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        }
        localObject = ((SharedPreferences)localObject).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tag_troop_aio_enter_times_");
        localStringBuilder.append(paramString);
        ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramQQAppInterface);
        if (Build.VERSION.SDK_INT > 8) {
          ((SharedPreferences.Editor)localObject).apply();
        } else {
          ((SharedPreferences.Editor)localObject).commit();
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("addTroopAssistTipTime time=");
          paramString.append(paramQQAppInterface);
          QLog.d("troopassist_guide", 2, paramString.toString());
        }
      }
    }
  }
  
  /* Error */
  public void f(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mobileqq/managers/TroopAssistantManager:b	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore 5
    //   12: iconst_0
    //   13: istore 4
    //   15: iconst_0
    //   16: istore_2
    //   17: iload 5
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 53	com/tencent/mobileqq/managers/TroopAssistantManager:j	Ljava/util/Set;
    //   24: ifnull +89 -> 113
    //   27: iload 5
    //   29: istore_3
    //   30: aload_0
    //   31: getfield 53	com/tencent/mobileqq/managers/TroopAssistantManager:j	Ljava/util/Set;
    //   34: invokeinterface 394 1 0
    //   39: astore 7
    //   41: iload_2
    //   42: istore_3
    //   43: iload_2
    //   44: istore 4
    //   46: aload 7
    //   48: invokeinterface 202 1 0
    //   53: ifeq +60 -> 113
    //   56: iload_2
    //   57: istore_3
    //   58: aload 7
    //   60: invokeinterface 206 1 0
    //   65: checkcast 396	java/lang/String
    //   68: astore 8
    //   70: iload_2
    //   71: istore_3
    //   72: aload_1
    //   73: invokevirtual 334	com/tencent/mobileqq/app/QQAppInterface:getConversationFacade	()Lcom/tencent/imcore/message/ConversationFacade;
    //   76: aload 8
    //   78: iconst_1
    //   79: invokevirtual 339	com/tencent/imcore/message/ConversationFacade:a	(Ljava/lang/String;I)I
    //   82: ifgt -41 -> 41
    //   85: iload_2
    //   86: istore_3
    //   87: aload 7
    //   89: invokeinterface 668 1 0
    //   94: iconst_1
    //   95: istore_2
    //   96: goto -55 -> 41
    //   99: astore_1
    //   100: goto +27 -> 127
    //   103: astore 7
    //   105: aload 7
    //   107: invokevirtual 671	java/lang/Exception:printStackTrace	()V
    //   110: iload_3
    //   111: istore 4
    //   113: aload 6
    //   115: monitorexit
    //   116: iload 4
    //   118: ifeq +8 -> 126
    //   121: aload_0
    //   122: aload_1
    //   123: invokespecial 126	com/tencent/mobileqq/managers/TroopAssistantManager:t	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   126: return
    //   127: aload 6
    //   129: monitorexit
    //   130: goto +5 -> 135
    //   133: aload_1
    //   134: athrow
    //   135: goto -2 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	TroopAssistantManager
    //   0	138	1	paramQQAppInterface	QQAppInterface
    //   16	80	2	i1	int
    //   19	92	3	i2	int
    //   13	104	4	i3	int
    //   10	18	5	i4	int
    //   4	124	6	localObject	Object
    //   39	49	7	localIterator	Iterator
    //   103	3	7	localException	Exception
    //   68	9	8	str	String
    // Exception table:
    //   from	to	target	type
    //   20	27	99	finally
    //   30	41	99	finally
    //   46	56	99	finally
    //   58	70	99	finally
    //   72	85	99	finally
    //   87	94	99	finally
    //   105	110	99	finally
    //   113	116	99	finally
    //   127	130	99	finally
    //   20	27	103	java/lang/Exception
    //   30	41	103	java/lang/Exception
    //   46	56	103	java/lang/Exception
    //   58	70	103	java/lang/Exception
    //   72	85	103	java/lang/Exception
    //   87	94	103	java/lang/Exception
  }
  
  public void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tag_troop_aio_enter_times_");
        localStringBuilder.append(paramString);
        paramQQAppInterface.remove(localStringBuilder.toString()).commit();
      }
    }
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public boolean g(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_assistant", true);
  }
  
  public boolean g(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    if (paramQQAppInterface == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag_troop_ignore_tip_v2_");
    localStringBuilder.append(paramString);
    if (paramQQAppInterface.getBoolean(localStringBuilder.toString(), false)) {
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag_troop_aio_enter_times_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = paramQQAppInterface.getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      int i1 = paramQQAppInterface.length;
      if (i1 >= 2)
      {
        paramQQAppInterface = paramQQAppInterface[(i1 - 2)];
        try
        {
          long l1 = Long.parseLong(paramQQAppInterface);
          long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if (l2 - l1 < 7200L) {
            return true;
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAssistantManager", 2, QLog.getStackTraceString(paramQQAppInterface));
          }
        }
      }
    }
    return false;
  }
  
  public boolean h(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("show_troop_assistant_list_notity", true);
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.getApp() == null) {
        return;
      }
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("show_troop_assistant_list_notity", false).commit();
      this.c = false;
    }
  }
  
  public boolean j(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.getApp() == null) {
        return true;
      }
      long l1 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troop_batch_setting_time", 0L);
      if (new Date().getTime() / 1000L < l1) {
        return l1 == 0L;
      }
    }
    return true;
  }
  
  public List<Long> k(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).h();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    while (i1 < localArrayList1.size())
    {
      if (localArrayList1.get(i1) != null)
      {
        TroopInfo localTroopInfo = (TroopInfo)localArrayList1.get(i1);
        if (localTroopInfo == null) {
          return localArrayList2;
        }
        Map localMap = a(paramQQAppInterface, new String[] { localTroopInfo.troopuin });
        Integer localInteger = null;
        if (localMap != null) {
          localInteger = (Integer)localMap.get(localTroopInfo.troopuin);
        }
        if ((localInteger != null) && (localInteger.intValue() == 2)) {
          localArrayList2.add(Long.valueOf(localTroopInfo.troopuin));
        }
      }
      i1 += 1;
    }
    return localArrayList2;
  }
  
  public boolean l(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    if (localBaseApplication == null) {
      return true;
    }
    return localBaseApplication.getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("troop_message_setting_first", true);
  }
  
  public void m(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (paramQQAppInterface.getApp() == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_message_setting_first", false).commit();
  }
  
  public List<TroopAssistantData> n(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    int i1;
    synchronized (this.m)
    {
      if (this.k != null)
      {
        i1 = this.k.size();
        ArrayList localArrayList = new ArrayList(i1);
        if (this.k != null)
        {
          Iterator localIterator = this.k.iterator();
          while (localIterator.hasNext())
          {
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
            if ((!HiddenChatHelper.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) && (!TroopBlockUtils.b(paramQQAppInterface, localTroopAssistantData.troopUin))) {
              localArrayList.add(localTroopAssistantData);
            }
          }
        }
        return localArrayList;
      }
    }
  }
  
  public List<RecentUser> o(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.m)
    {
      ArrayList localArrayList = new ArrayList(0);
      a(paramQQAppInterface);
      if ((this.k != null) && (this.k.size() > 0))
      {
        Iterator localIterator = this.k.iterator();
        while (localIterator.hasNext())
        {
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
          if (HiddenChatHelper.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface))
          {
            RecentUser localRecentUser = new RecentUser(localTroopAssistantData.troopUin, 1);
            localRecentUser.isHiddenChat = 1;
            localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
            localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
            localArrayList.add(localRecentUser);
          }
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void p(QQAppInterface arg1)
  {
    this.o.clear();
    a(???);
    int i1;
    synchronized (this.m)
    {
      Object localObject1 = this.k;
      int i2 = 0;
      if (localObject1 != null)
      {
        i1 = this.k.size();
        localObject1 = new ArrayList(i1);
        i1 = i2;
        if (this.k != null)
        {
          ((List)localObject1).addAll(this.k);
          i1 = i2;
        }
        while (i1 < ((List)localObject1).size())
        {
          this.o.add(((TroopAssistantData)((List)localObject1).get(i1)).troopUin);
          i1 += 1;
        }
        return;
      }
    }
  }
  
  public void q(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.getProxyManager().g();
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    ??? = ((RecentUserProxy)localObject1).a(false);
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject5 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject5).getType() == 1) && (a(paramQQAppInterface, ((RecentUser)localObject5).uin)) && (!RecentUserAppearLogic.a(paramQQAppInterface, ((RecentUser)localObject5).msgType))) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
    }
    a(paramQQAppInterface);
    synchronized (this.m)
    {
      Object localObject6;
      if ((this.k != null) && (this.k.size() > 0))
      {
        localObject5 = this.k.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopAssistantData)((Iterator)localObject5).next();
          if (!a(paramQQAppInterface, ((TroopAssistantData)localObject6).troopUin)) {
            ((ArrayList)localObject2).add(localObject6);
          }
        }
      }
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ??? = (RecentUser)((Iterator)localObject3).next();
          localObject5 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
          if (((RecentUser)???).lastmsgtime == 0L)
          {
            localObject6 = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopAssistantData)localObject5).troopUin, 1);
            if (localObject6 != null) {
              ((TroopAssistantData)localObject5).lastmsgtime = ((Message)localObject6).time;
            }
          }
          else
          {
            ((TroopAssistantData)localObject5).lastmsgtime = ((RecentUser)???).lastmsgtime;
          }
          a(localEntityManager, (TroopAssistantData)localObject5);
          ((RecentUserProxy)localObject1).a((RecentUser)???);
          e(((RecentUser)???).uin, paramQQAppInterface);
        }
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TroopAssistantData)((Iterator)localObject2).next();
          ??? = ((RecentUserProxy)localObject1).b(((TroopAssistantData)localObject3).troopUin, 1);
          ((RecentUser)???).uin = ((TroopAssistantData)localObject3).troopUin;
          ((RecentUser)???).setType(1);
          ((RecentUser)???).lastmsgtime = ((TroopAssistantData)localObject3).lastmsgtime;
          ((RecentUser)???).lastmsgdrafttime = ((TroopAssistantData)localObject3).lastdrafttime;
          if (a(localEntityManager, ((TroopAssistantData)localObject3).troopUin))
          {
            ((RecentUserProxy)localObject1).b((RecentUser)???);
            d(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
          }
        }
      }
      localObject1 = d(paramQQAppInterface);
      if (localObject1 != null) {
        a(paramQQAppInterface, 0, ((TroopAssistantData)localObject1).lastmsgtime);
      }
      if (localEntityManager != null) {
        localEntityManager.close();
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void r(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    int i1;
    label108:
    synchronized (this.m)
    {
      if ((this.k != null) && (this.k.size() > 0))
      {
        i1 = this.k.size() - 1;
        if (i1 >= 0)
        {
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.k.get(i1);
          if (!HiddenChatHelper.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
            break label108;
          }
          b(localTroopAssistantData.troopUin, paramQQAppInterface);
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void s(QQAppInterface paramQQAppInterface)
  {
    try
    {
      b(paramQQAppInterface);
      if (g(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        a().a(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      c(paramQQAppInterface);
      if (TroopRemindSettingManager.a().a(paramQQAppInterface) != true) {
        break label87;
      }
      EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      TroopRemindSettingManager.a().a(localEntityManager, paramQQAppInterface);
      localEntityManager.close();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      label71:
      label87:
      break label71;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.recent", 2, "initTroopManager error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager
 * JD-Core Version:    0.7.0.1
 */